package com.ss.texturerender.effect;

import android.opengl.GLES20;
import android.os.Bundle;
import androidx.camera.core.processing.util.GLUtils;
import com.ss.texturerender.ShaderHelper;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderer;
import com.ss.texturerender.VideoSurfaceTexture;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class GLDefaultFilter extends AbsEffect {
    public static final int OPTION_FILTER_CALL_GLFINISH = 20006;
    public static final int OPTION_FILTER_INT_GL_ERROR = 20005;
    public static final int OPTION_FILTER_INT_PORT_HEIGHT = 20002;
    public static final int OPTION_FILTER_INT_PORT_WIDTH = 20001;
    public static final int OPTION_FILTER_INT_PORT_X = 20003;
    public static final int OPTION_FILTER_INT_PORT_Y = 20004;
    public static float[] mPostionTextureVerticesData;
    public static float[] mTextureVerticesData;
    public static float[] mTriangleVerticesData;
    int FLOAT_SIZE_BYTES;
    protected int TEXTURE_VERTICES_DATA_STRIDE_BYTES;
    protected int TRIANGLE_VERTICES_DATA_POS_OFFSET;
    protected int TRIANGLE_VERTICES_DATA_STRIDE_BYTES;
    protected int TRIANGLE_VERTICES_DATA_UV_OFFSET;
    private final String fragmentDefaultShader;
    protected boolean isMirrorHorizontal;
    protected boolean isMirrorVertical;
    protected float mCropHeightNormalize;
    protected float[] mCropTextureCoord;
    protected float mCropWidthNormalize;
    protected float mCropXNormalize;
    protected float mCropYNormalize;
    protected int mGLError;
    protected ShortBuffer mIndexBuffers;
    protected int mInputTextureHandle;
    protected int mIsCallGLfinish;
    protected float[] mLastCropParamNormalize;
    protected float mLayoutAspectRatio;
    protected int mLayoutMode;
    protected boolean mNeedClear;
    protected int mOutTexHeight;
    protected Bundle mOutTexRect;
    protected int mOutTexWidth;
    protected int mProgram;
    protected int mRotation;
    protected int mTextureMagFilter;
    protected int mTextureMinFilter;
    protected FloatBuffer mTextureVertices;
    protected FloatBuffer mTriangleVertices;
    protected boolean mUseVBO;
    protected int mViewPortHeight;
    protected int mViewPortWidth;
    protected int mViewPortX;
    protected int mViewPortY;
    protected int maPositionHandle;
    protected int maTextureHandle;
    protected int positionTextureVbo;
    private final String vertexDefaultShader;

    public int onDrawFrameAfter() {
        return 0;
    }

    public int onDrawFrameBefore() {
        return 0;
    }

    public int onPrepareDrawFrame(EffectTexture r100) {
        return 0;
    }

    public int updateRenderParam(EffectTexture r100, FrameBuffer r101) {
        return -1;
    }

    static {
        mTriangleVerticesData = new float[]{-1.0f, -1.0f, 0.0f, 1.0f, -1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.0f};
        mTextureVerticesData = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        mPostionTextureVerticesData = new float[]{-1.0f, -1.0f, 0.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f, 1.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f};
    }

    private void reTransformIfNeeded() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L10;
        if (r100.getIntOption(146) != 0) goto L10;
        int r101 = this.mRotation;
        if (r101 == 0) goto L10;
        rotate(this.mTextureVertices, r101);
    L10:
        if (this.isMirrorHorizontal == false) goto L13;
        mirror(30, this.mTextureVertices);
    L13:
        if (this.isMirrorVertical == false) goto L15;
        mirror(31, this.mTextureVertices);
    L15:
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 != null) goto L18;
        return;
    L18:
        if (r102.getIntOption(146) != 1) goto L24;
        int r103 = this.mRotation;
        if (r103 == 0) goto L25;
        rotate(this.mTextureVertices, r103);
        return;
    L25:
        return;
    }

    public EffectTexture genTexture() {
        TextureRenderer r100 = this.mParentRender;
        if (r100 != null) goto L5;
        return null;
    L5:
        if (r100.getEffectTextureManager() != null) goto L8;
        return null;
    L8:
        if (this.mSurfaceTexture == null) goto L12;
        return this.mParentRender.getEffectTextureManager().genTexture(this.mOutTexWidth, this.mOutTexHeight, this.mSurfaceTexture.getIntOption(130), this.mOutTexRect);
    L12:
        return this.mParentRender.getEffectTextureManager().genTexture(this.mOutTexWidth, this.mOutTexHeight, this.mOutTexRect);
    }

    public void initParam() {
        if (this.mUseVBO == false) goto L5;
        int[] r100 = new int[1];
        GLES20.glGenBuffers(1, r100, 0);
        this.positionTextureVbo = r100[0];
        FloatBuffer r101 = ByteBuffer.allocateDirect(mPostionTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        r101.put(mPostionTextureVerticesData).position(0);
        GLES20.glBindBuffer(34962, this.positionTextureVbo);
        GLES20.glBufferData(34962, r101.capacity() * 4, r101, 35044);
        GLES20.glBindBuffer(34962, 0);
        return;
    L5:
        FloatBuffer r102 = ByteBuffer.allocateDirect(mTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVertices = r102;
        r102.put(mTextureVerticesData).position(0);
        FloatBuffer r103 = ByteBuffer.allocateDirect(mTriangleVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = r103;
        r103.put(mTriangleVerticesData).position(0);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        int r100 = this.mProgram;
        if (r100 <= 0) goto L6;
        GLES20.glDeleteProgram(r100);
    L6:
        return super.release();
    }

    public void resetClipParams() {
        float r100 = this.mCropXNormalize;
        float[] r101 = this.mLastCropParamNormalize;
        float r102 = r101[0];
        if (r100 == r102) goto L5;
    L10:
        this.mCropXNormalize = r102;
        float r103 = r101[1];
        this.mCropYNormalize = r103;
        float r104 = r101[2];
        this.mCropWidthNormalize = r104;
        float r105 = r101[3];
        this.mCropHeightNormalize = r105;
        if (this.mCropTextureCoord != null) goto L13;
        this.mCropTextureCoord = new float[8];
    L13:
        float[] r106 = this.mCropTextureCoord;
        r106[4] = r102;
        r106[0] = r102;
        r106[3] = r103;
        r106[1] = r103;
        float r107 = r102 + r104;
        r106[6] = r107;
        r106[2] = r107;
        float r108 = r103 + r105;
        r106[7] = r108;
        r106[5] = r108;
        return;
    L5:
        if (this.mCropYNormalize != r101[1]) goto L10;
        if (this.mCropWidthNormalize != r101[2]) goto L10;
        if (this.mCropHeightNormalize != r101[3]) goto L10;
    }

    public void resetCropParams() {
        Bundle r100 = new Bundle();
        r100.putInt("action", 21);
        r100.putInt("effect_type", 11);
        r100.putFloat("width", 1.0f);
        r100.putFloat("height", 1.0f);
        r100.putFloat("x", 0.0f);
        r100.putFloat("y", 0.0f);
        setOption(r100);
    }

    public void resetRotationMirrorParams() {
        FloatBuffer r100 = this.mTextureVertices;
        if (r100 == null) goto L6;
        r100.position(0);
        this.mTextureVertices.put(mTextureVerticesData).position(0);
        return;
    }

    public GLDefaultFilter(int r100) {
        this(r100, 7);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int getIntOption(int r100) {
        switch(r100) {
            case 20001: goto L14;
            case 20002: goto L12;
            case 20003: goto L10;
            case 20004: goto L8;
            case 20005: goto L6;
            default: goto L4;
        };
    L4:
        return super.getIntOption(r100);
    L6:
        return this.mGLError;
    L8:
        return this.mViewPortY;
    L10:
        return this.mViewPortX;
    L12:
        return this.mViewPortHeight;
    L14:
        return this.mViewPortWidth;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position =  aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
    L5:
        if (r100 != 11001) goto L7;
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
    L7:
        if (r100 != 11003) goto L9;
        float[] r101 = this.mCropTextureCoord;
        if (r101 != null) goto L14;
        return "";
    L14:
        return Arrays.toString(r101);
    L9:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        if (r100 != null) goto L5;
        boolean r101 = false;
    L7:
        if (EffectConfig.sTRUseVBO == true) goto L11;
        if (r101 == true) goto L11;
        boolean r102 = false;
    L12:
        this.mUseVBO = r102;
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 != null) goto L15;
    L17:
        int r104 = ShaderHelper.compileShader(35633, getStringOption(11000));
        int r105 = ShaderHelper.compileShader(35632, getStringOption(11001));
        if (r104 == 0) goto L29;
        if (r105 == 0) goto L29;
        int r106 = ShaderHelper.createAndLinkProgram(r104, r105, null);
        this.mProgram = r106;
        if (r106 != 0) goto L27;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "create program error,filter:" + this.mEffectType);
        this.mGLError = -1;
        VideoSurfaceTexture r107 = this.mSurfaceTexture;
        if (r107 == null) goto L26;
        r107.notifyInitError(9, this.mEffectType, "create program error");
    L26:
        return -1;
    L27:
        this.mInputTextureHandle = GLES20.glGetUniformLocation(r106, GLUtils.VAR_TEXTURE);
        this.maPositionHandle = GLES20.glGetAttribLocation(this.mProgram, "aPosition");
        this.maTextureHandle = GLES20.glGetAttribLocation(this.mProgram, "aTextureCoord");
        initParam();
        this.mGLError = 0;
        return 0;
    L29:
        this.mGLError = -1;
        VideoSurfaceTexture r108 = this.mSurfaceTexture;
        if (r108 == null) goto L32;
        r108.notifyInitError(8, this.mEffectType, "compile shader error");
    L32:
        return -1;
    L15:
        if (r103.getIntOption(126, this.mEffectType) != (-1)) goto L17;
        this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
    L11:
        r102 = true;
        goto L12
    L5:
        r101 = r100.getBoolean(TextureRenderKeys.KEY_IS_EFFECT_USE_VBO, false);
        goto L7
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        int r101 = r100.getInt("action", -1);
        if (r100.getInt("effect_type", -1) == 11) goto L7;
        return;
    L7:
        if (r101 != 21) goto L9;
    L12:
        float r102 = r100.getFloat("width", 1.0f);
        float r103 = r100.getFloat("height", 1.0f);
        float r104 = 0.0f;
        float r105 = r100.getFloat("x", 0.0f);
        float r106 = r100.getFloat("y", 0.0f);
        if (r105 <= 1.0f) goto L15;
        return;
    L15:
        if (r105 >= 0.0f) goto L17;
        return;
    L17:
        if (r106 <= 1.0f) goto L19;
        return;
    L19:
        if (r106 >= 0.0f) goto L21;
        return;
    L21:
        if (r102 > 0.0f) goto L23;
        return;
    L23:
        if (r103 > 0.0f) goto L25;
        return;
    L25:
        if (r106 == this.mCropYNormalize) goto L27;
    L33:
        this.mCropWidthNormalize = r102;
        this.mCropHeightNormalize = r103;
        this.mCropXNormalize = r105;
        this.mCropYNormalize = r106;
        if (r105 >= 0.0f) goto L36;
        r105 = 0.0f;
    L36:
        this.mCropXNormalize = r105;
        if (r106 < 0.0f) goto L40;
        r104 = r106;
    L40:
        this.mCropYNormalize = r104;
        if ((r105 + r102) <= 1.0f) goto L43;
        r102 = 1.0f - r105;
    L43:
        this.mCropWidthNormalize = r102;
        if ((r104 + r103) <= 1.0f) goto L46;
        r103 = 1.0f - r104;
    L46:
        this.mCropHeightNormalize = r103;
        this.mCropTextureCoord = new float[]{r105, r104, r105 + r102, r104, r105, r104 + r103, r105 + r102, r104 + r103};
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "param set success, bundle:" + r100);
        return;
    L27:
        if (r105 != this.mCropXNormalize) goto L33;
        if (r102 != this.mCropWidthNormalize) goto L33;
        if (r103 != this.mCropHeightNormalize) goto L33;
        return;
    L9:
        if (r101 == 28) goto L12;
        if (r101 == 35) goto L12;
    }

    public GLDefaultFilter(int r100, int r101) {
        super(r100, r101);
        this.vertexDefaultShader = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvoid main() {\n  gl_Position =  aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
        this.fragmentDefaultShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n  gl_FragColor = texture2D(sTexture, vTextureCoord);\n}\n";
        this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES = 12;
        this.TEXTURE_VERTICES_DATA_STRIDE_BYTES = 8;
        this.TRIANGLE_VERTICES_DATA_POS_OFFSET = 0;
        this.TRIANGLE_VERTICES_DATA_UV_OFFSET = 0;
        this.FLOAT_SIZE_BYTES = 4;
        this.mViewPortWidth = -1;
        this.mViewPortHeight = -1;
        this.mViewPortX = 0;
        this.mViewPortY = 0;
        this.mNeedClear = true;
        this.mOutTexRect = null;
        this.mLayoutMode = 1;
        this.mLayoutAspectRatio = 0.5f;
        this.mCropXNormalize = 0.0f;
        this.mCropYNormalize = 0.0f;
        this.mCropWidthNormalize = 1.0f;
        this.mCropHeightNormalize = 1.0f;
        this.mLastCropParamNormalize = new float[]{0.0f, 0.0f, 1.0f, 1.0f};
        this.mCropTextureCoord = null;
        this.mTextureMinFilter = 9729;
        this.mTextureMagFilter = 9729;
        this.mRotation = 0;
        this.isMirrorHorizontal = false;
        this.isMirrorVertical = false;
        this.mGLError = 0;
        this.mIsCallGLfinish = 1;
        this.positionTextureVbo = -1;
        this.mUseVBO = false;
        this.mInTextureTarget = 3553;
        this.mOrder = 0;
    }

    private void clip(Bundle r110, FrameBuffer r111) {
        float[] r100 = this.mLastCropParamNormalize;
        r100[0] = this.mCropXNormalize;
        r100[1] = this.mCropYNormalize;
        r100[2] = this.mCropWidthNormalize;
        r100[3] = this.mCropHeightNormalize;
        if (r110 == null) goto L21;
        float r101 = r110.getFloat("x", 0.0f);
        float r102 = r110.getFloat("y", 0.0f);
        float r103 = r110.getFloat("width", 1.0f);
        float r112 = r110.getFloat("height", 1.0f);
        if (r111 != null) goto L15;
        float r113 = this.mCropXNormalize;
        if (r113 == 0.0f) goto L9;
    L14:
        this.mCropXNormalize = r101 + (r113 * r103);
        this.mCropYNormalize = r102 + (this.mCropYNormalize * r112);
        this.mCropWidthNormalize *= r103;
        this.mCropHeightNormalize *= r112;
    L17:
        if (this.mCropTextureCoord != null) goto L19;
        this.mCropTextureCoord = new float[8];
    L19:
        float[] r114 = this.mCropTextureCoord;
        float r115 = this.mCropXNormalize;
        r114[4] = r115;
        r114[0] = r115;
        float r104 = this.mCropYNormalize;
        r114[3] = r104;
        r114[1] = r104;
        float r116 = r115 + this.mCropWidthNormalize;
        r114[6] = r116;
        r114[2] = r116;
        float r105 = r104 + this.mCropHeightNormalize;
        r114[7] = r105;
        r114[5] = r105;
        return;
    L9:
        if (this.mCropYNormalize != 0.0f) goto L14;
        if (this.mCropWidthNormalize != 1.0f) goto L14;
        if (this.mCropHeightNormalize != 1.0f) goto L14;
    L15:
        this.mCropXNormalize = r101;
        this.mCropYNormalize = r102;
        this.mCropWidthNormalize = r103;
        this.mCropHeightNormalize = r112;
        goto L17
    }

    private void mirror(int r110, FloatBuffer r111) {
        if (this.mTextureVertices != null) goto L5;
        return;
    L5:
        FloatBuffer r100 = ByteBuffer.allocateDirect(mTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        if (r111 == null) goto L8;
        r111.rewind();
        r100.put(r111);
        r111.rewind();
        r100.flip();
    L10:
        if (r110 != 30) goto L13;
        this.mTextureVertices.put(0, r100.get(2));
        this.mTextureVertices.put(1, r100.get(3));
        this.mTextureVertices.put(2, r100.get(0));
        this.mTextureVertices.put(3, r100.get(1));
        this.mTextureVertices.put(4, r100.get(6));
        this.mTextureVertices.put(5, r100.get(7));
        this.mTextureVertices.put(6, r100.get(4));
        this.mTextureVertices.put(7, r100.get(5));
    L16:
        r100.clear();
        return;
    L13:
        if (r110 != 31) goto L15;
        this.mTextureVertices.put(0, r100.get(4));
        this.mTextureVertices.put(1, r100.get(5));
        this.mTextureVertices.put(2, r100.get(6));
        this.mTextureVertices.put(3, r100.get(7));
        this.mTextureVertices.put(4, r100.get(0));
        this.mTextureVertices.put(5, r100.get(1));
        this.mTextureVertices.put(6, r100.get(2));
        this.mTextureVertices.put(7, r100.get(3));
        goto L16
    L15:
        this.mTextureVertices.put(r100).position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        goto L16
    L8:
        r100.put(mTextureVerticesData);
        goto L10
    }

    private void rotate(FloatBuffer r110, int r111) {
        FloatBuffer r100 = ByteBuffer.allocateDirect(mTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        if (r110 == null) goto L5;
        r110.rewind();
        r100.put(r110);
        r110.rewind();
        r100.flip();
    L6:
        if (r111 >= 0) goto L9;
        r111 = r111 + 360;
    L9:
        if (r111 != 90) goto L12;
        this.mTextureVertices.put(0, r100.get(2));
        this.mTextureVertices.put(1, r100.get(3));
        this.mTextureVertices.put(2, r100.get(6));
        this.mTextureVertices.put(3, r100.get(7));
        this.mTextureVertices.put(4, r100.get(0));
        this.mTextureVertices.put(5, r100.get(1));
        this.mTextureVertices.put(6, r100.get(4));
        this.mTextureVertices.put(7, r100.get(5));
    L18:
        r100.clear();
        return;
    L12:
        if (r111 != 180) goto L15;
        this.mTextureVertices.put(0, r100.get(6));
        this.mTextureVertices.put(1, r100.get(7));
        this.mTextureVertices.put(2, r100.get(4));
        this.mTextureVertices.put(3, r100.get(5));
        this.mTextureVertices.put(4, r100.get(2));
        this.mTextureVertices.put(5, r100.get(3));
        this.mTextureVertices.put(6, r100.get(0));
        this.mTextureVertices.put(7, r100.get(1));
        goto L18
    L15:
        if (r111 != 270) goto L17;
        this.mTextureVertices.put(0, r100.get(4));
        this.mTextureVertices.put(1, r100.get(5));
        this.mTextureVertices.put(2, r100.get(0));
        this.mTextureVertices.put(3, r100.get(1));
        this.mTextureVertices.put(4, r100.get(6));
        this.mTextureVertices.put(5, r100.get(7));
        this.mTextureVertices.put(6, r100.get(2));
        this.mTextureVertices.put(7, r100.get(3));
        goto L18
    L17:
        this.mTextureVertices.put(r100).position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        goto L18
    L5:
        r100.put(mTextureVerticesData);
        goto L6
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r100, FrameBuffer r101) {
        return process(r100, r101, Boolean.TRUE);
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, int r101) {
        boolean r102 = false;
        if (r100 == 26) goto L93;
        if (r100 != 20006) goto L7;
        this.mIsCallGLfinish = r101;
        return;
    L7:
        if (r100 != 158) goto L9;
        this.mTextureMinFilter = r101;
        return;
    L9:
        if (r100 != 159) goto L11;
        this.mTextureMagFilter = r101;
        return;
    L11:
        switch(r100) {
            case 29: goto L69;
            case 30: goto L45;
            case 31: goto L21;
            default: goto L12;
        };
    L12:
        switch(r100) {
            case 10006: goto L20;
            case 10007: goto L19;
            case 10008: goto L18;
            case 10009: goto L17;
            case 10010: goto L14;
            default: goto L13;
        };
    L13:
        super.setOption(r100, r101);
        return;
    L14:
        if (r101 != 1) goto L16;
        r102 = true;
    L16:
        this.mNeedClear = r102;
        return;
    L17:
        this.mViewPortY = r101;
        return;
    L18:
        this.mViewPortX = r101;
        return;
    L19:
        this.mViewPortHeight = r101;
        return;
    L20:
        this.mViewPortWidth = r101;
        return;
    L21:
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 != null) goto L24;
    L37:
        boolean r104 = this.isMirrorVertical;
        if (r101 <= 0) goto L40;
        boolean r105 = true;
    L41:
        if (r104 == r105) goto L108;
        if (r101 <= 0) goto L44;
        r102 = true;
    L44:
        this.isMirrorVertical = r102;
        mirror(31, this.mTextureVertices);
        return;
    L108:
        return;
    L40:
        r105 = false;
        goto L41
    L24:
        if (r103.getIntOption(144) != 1) goto L37;
        boolean r106 = this.isMirrorVertical;
        if (r101 <= 0) goto L28;
        boolean r107 = true;
    L29:
        if (r106 != r107) goto L31;
        if (r106 == true) goto L31;
        return;
    L31:
        if (r101 <= 0) goto L33;
        r102 = true;
    L33:
        this.isMirrorVertical = r102;
        if (r102 == false) goto L36;
        mirror(31, null);
        return;
    L36:
        resetRotationMirrorParams();
        return;
    L28:
        r107 = false;
        goto L29
    L45:
        VideoSurfaceTexture r108 = this.mSurfaceTexture;
        if (r108 != null) goto L48;
    L61:
        boolean r109 = this.isMirrorHorizontal;
        if (r101 <= 0) goto L64;
        boolean r110 = true;
    L65:
        if (r109 == r110) goto L113;
        if (r101 <= 0) goto L68;
        r102 = true;
    L68:
        this.isMirrorHorizontal = r102;
        mirror(30, this.mTextureVertices);
        return;
    L113:
        return;
    L64:
        r110 = false;
        goto L65
    L48:
        if (r108.getIntOption(144) != 1) goto L61;
        boolean r111 = this.isMirrorHorizontal;
        if (r101 <= 0) goto L52;
        boolean r112 = true;
    L53:
        if (r111 != r112) goto L55;
        if (r111 == true) goto L55;
        return;
    L55:
        if (r101 <= 0) goto L57;
        r102 = true;
    L57:
        this.isMirrorHorizontal = r102;
        if (r102 == false) goto L60;
        mirror(30, null);
        return;
    L60:
        resetRotationMirrorParams();
        return;
    L52:
        r112 = false;
        goto L53
    L69:
        VideoSurfaceTexture r113 = this.mSurfaceTexture;
        if (r113 != null) goto L72;
    L86:
        int r114 = this.mRotation;
        if (r114 == r101) goto L119;
        rotate(this.mTextureVertices, r101 - r114);
        this.mRotation = r101;
        return;
    L119:
        return;
    L72:
        if (r113.getIntOption(144) != 1) goto L86;
        if (this.mRotation != r101) goto L76;
        if (r101 != 0) goto L76;
        return;
    L76:
        this.mRotation = r101;
        if (r101 != 0) goto L79;
        resetRotationMirrorParams();
        return;
    L79:
        if (this.isMirrorVertical == false) goto L81;
    L84:
        rotate(this.mTextureVertices, r101);
        return;
    L81:
        if (this.isMirrorHorizontal == true) goto L84;
        rotate(null, r101);
        return;
    L93:
        if (this.mLayoutMode == r101) goto L124;
        FloatBuffer r115 = ByteBuffer.allocateDirect(mTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVertices = r115;
        if (r115 == null) goto L97;
        r115.put(mTextureVerticesData).position(0);
    L97:
        this.mLayoutMode = r101;
        reTransformIfNeeded();
        return;
    }

    public int updateDefaultRenderParam(EffectTexture r110, FrameBuffer r111) {
        int r100 = Math.round(r110.getWidth() * this.mCropWidthNormalize);
        int r112 = Math.round(r110.getHeight() * this.mCropHeightNormalize);
        if (r111 == null) goto L5;
        this.mOutTexWidth = r100;
        this.mOutTexHeight = r112;
        this.mViewPortWidth = r100;
        this.mViewPortHeight = r112;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        setOption(13000, this.mCropTextureCoord);
    L45:
        return 0;
    L5:
        int r113 = this.mViewPortWidth;
        int r101 = this.mViewPortHeight;
        float r114 = r112;
        float r102 = r100;
        float r103 = (r114 * 1.0f) / r102;
        float r104 = r101 * 1.0f;
        float r105 = r113;
        float r106 = r104 / r105;
        if (1 != this.mSurfaceTexture.getIntOption(41)) goto L8;
        r106 = (this.mSurfaceTexture.getSurfaceRealHeight() * 1.0f) / this.mSurfaceTexture.getSurfaceRealWidth();
    L8:
        int r107 = this.mLayoutMode;
        if (r107 != 0) goto L28;
        if (r106 <= r103) goto L18;
        int r115 = this.mRotation;
        if (r115 == 90) goto L17;
        if (r115 == 270) goto L17;
        this.mViewPortWidth = r113;
        int r116 = (int) ((r105 * 1.0f) * r103);
        this.mViewPortHeight = r116;
        this.mViewPortX = 0;
        this.mViewPortY = (int) ((r101 - r116) * this.mLayoutAspectRatio);
    L24:
        setOption(13000, this.mCropTextureCoord);
        if (this.mCropTextureCoord == null) goto L45;
        reTransformIfNeeded();
    L17:
        int r117 = Math.min((int) (r104 * r103), r113);
        this.mViewPortWidth = r117;
        int r108 = (int) ((r117 * 1.0f) / r103);
        this.mViewPortHeight = r108;
        float r118 = r113 - r117;
        float r119 = this.mLayoutAspectRatio;
        this.mViewPortX = (int) (r118 * r119);
        this.mViewPortY = (int) ((r101 - r108) * r119);
        goto L24
    L18:
        int r120 = this.mRotation;
        if (r120 == 90) goto L23;
        if (r120 == 270) goto L23;
        int r121 = (int) (r104 / r103);
        this.mViewPortWidth = r121;
        this.mViewPortHeight = r101;
        this.mViewPortX = (int) ((r113 - r121) * this.mLayoutAspectRatio);
        this.mViewPortY = 0;
    L23:
        int r122 = Math.min((int) ((r105 * 1.0f) / r103), r101);
        this.mViewPortHeight = r122;
        int r109 = (int) ((r122 * 1.0f) * r103);
        this.mViewPortWidth = r109;
        float r123 = r113 - r109;
        float r124 = this.mLayoutAspectRatio;
        this.mViewPortX = (int) (r123 * r124);
        this.mViewPortY = (int) ((r101 - r122) * r124);
        goto L24
    L28:
        if (r107 != 2) goto L42;
        this.mViewPortWidth = r113;
        this.mViewPortHeight = r101;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        int r125 = this.mRotation;
        if (r125 == 90) goto L37;
        if (r125 == 270) goto L37;
        if (r106 <= r103) goto L36;
        float r126 = 1.0f - (r103 / r106);
        this.mTextureVertices.put(0, this.mCropXNormalize + ((this.mCropWidthNormalize * r126) * this.mLayoutAspectRatio));
        this.mTextureVertices.put(1, this.mCropYNormalize);
        this.mTextureVertices.put(2, this.mCropXNormalize + (this.mCropWidthNormalize * (1.0f - (r126 * (1.0f - this.mLayoutAspectRatio)))));
        this.mTextureVertices.put(5, this.mCropYNormalize + this.mCropHeightNormalize);
    L41:
        FloatBuffer r127 = this.mTextureVertices;
        r127.put(3, r127.get(1));
        FloatBuffer r128 = this.mTextureVertices;
        r128.put(4, r128.get(0));
        FloatBuffer r129 = this.mTextureVertices;
        r129.put(6, r129.get(2));
        FloatBuffer r130 = this.mTextureVertices;
        r130.put(7, r130.get(5));
        reTransformIfNeeded();
        goto L45
    L36:
        float r131 = 1.0f - (r106 / r103);
        this.mTextureVertices.put(0, this.mCropXNormalize);
        this.mTextureVertices.put(1, this.mCropYNormalize + ((this.mCropHeightNormalize * r131) * this.mLayoutAspectRatio));
        this.mTextureVertices.put(2, this.mCropXNormalize + this.mCropWidthNormalize);
        this.mTextureVertices.put(5, this.mCropYNormalize + (this.mCropHeightNormalize * (1.0f - (r131 * (1.0f - this.mLayoutAspectRatio)))));
    L37:
        float r132 = (r102 * 1.0f) / r114;
        if (r106 <= r132) goto L40;
        float r133 = 1.0f - (r132 / r106);
        this.mTextureVertices.put(0, this.mCropXNormalize);
        this.mTextureVertices.put(1, this.mCropYNormalize + ((this.mCropHeightNormalize * r133) * this.mLayoutAspectRatio));
        this.mTextureVertices.put(2, this.mCropXNormalize + this.mCropWidthNormalize);
        this.mTextureVertices.put(5, this.mCropYNormalize + (this.mCropHeightNormalize * (1.0f - (r133 * (1.0f - this.mLayoutAspectRatio)))));
        goto L41
    L40:
        float r134 = 1.0f - (r106 / r132);
        this.mTextureVertices.put(0, this.mCropXNormalize + ((this.mCropWidthNormalize * r134) * this.mLayoutAspectRatio));
        this.mTextureVertices.put(1, this.mCropYNormalize);
        this.mTextureVertices.put(2, this.mCropXNormalize + (this.mCropWidthNormalize * (1.0f - (r134 * this.mLayoutAspectRatio))));
        this.mTextureVertices.put(5, this.mCropYNormalize + this.mCropHeightNormalize);
        goto L41
    L42:
        this.mViewPortWidth = r113;
        this.mViewPortHeight = r101;
        this.mViewPortY = 0;
        this.mViewPortX = 0;
        setOption(13000, this.mCropTextureCoord);
        if (this.mCropTextureCoord == null) goto L45;
        reTransformIfNeeded();
        goto L45
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, float[] r101) {
        if (r100 == 13000) goto L5;
        super.setOption(r100, r101);
        return;
    L5:
        if (r101 == null) goto L9;
        this.mTextureVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        this.mTextureVertices.put(r101);
        return;
    }

    @Override // com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, float r101) {
        if (r100 != 27) goto L7;
        this.mLayoutAspectRatio = r101;
        return;
    }

    public EffectTexture process(EffectTexture r210, FrameBuffer r211, Boolean r212) {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L8;
        if (r100.getIntOption(126, this.mEffectType) != (-1)) goto L8;
        this.mSurfaceTexture.setOption(126, this.mEffectType, 0);
    L8:
        if (r210.getTexTarget() == this.mInTextureTarget) goto L14;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r210.getTexTarget());
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L12;
        r101.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r210.getTexTarget());
    L12:
        return r210;
    L14:
        if (onPrepareDrawFrame(r210) == 0) goto L17;
        return r210;
    L17:
        if (this.mProgram != 0) goto L22;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "program error,don't process,filter:" + this.mEffectType);
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L21;
        r102.notifyError(13, this.mEffectType, "program error,don't process,filter:" + this.mEffectType);
    L21:
        return r210;
    L22:
        int r103 = TexGLUtils.checkGLError(this.mTexType, "filter process start,type:" + this.mEffectType);
        if (r103 == 0) goto L28;
        this.mGLError = -1;
        VideoSurfaceTexture r104 = this.mSurfaceTexture;
        if (r104 == null) goto L27;
        r104.notifyError(r103, this.mEffectType, "");
    L27:
        return r210;
    L28:
        VideoSurfaceTexture r105 = this.mSurfaceTexture;
        if (r105 == null) goto L32;
        r105.currentEffectProcessBegin(this.mEffectType);
    L32:
        if (this.mDoClip == false) goto L35;
        clip(r210.getRect(), r211);
    L35:
        if (updateRenderParam(r210, r211) != (-1)) goto L37;
        updateDefaultRenderParam(r210, r211);
    L37:
        if (r211 != null) goto L39;
        EffectTexture r106 = null;
    L56:
        GLES20.glUseProgram(this.mProgram);
        Boolean r107 = Boolean.valueOf(this.mNeedClear);
        VideoSurfaceTexture r108 = this.mSurfaceTexture;
        if (r108 == null) goto L62;
        if (r108.getIntOption(179) == 0) goto L62;
        r107 = Boolean.FALSE;
    L62:
        if (this.mNeedClear == true) goto L64;
    L66:
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        if (this.mUseVBO == false) goto L69;
        GLES20.glBindBuffer(34962, this.positionTextureVbo);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, 20, 0);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 20, 12);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        GLES20.glBindBuffer(34962, 0);
    L70:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, r210.getTexID());
        GLES20.glTexParameteri(this.mInTextureTarget, 10241, this.mTextureMinFilter);
        GLES20.glTexParameteri(this.mInTextureTarget, 10240, this.mTextureMagFilter);
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        onDrawFrameBefore();
        int r109 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays before,type:" + this.mEffectType);
        if (r109 != 0) goto L73;
        GLES20.glDrawArrays(5, 0, 4);
        this.mGLError = 0;
    L76:
        onDrawFrameAfter();
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        int r110 = this.mIsCallGLfinish;
        VideoSurfaceTexture r111 = this.mSurfaceTexture;
        if (r111 != null) goto L79;
    L81:
        VideoSurfaceTexture r112 = this.mSurfaceTexture;
        if (r112 == null) goto L87;
        if (r112.getLastComeFrameType() != 3) goto L87;
        r110 = 1;
    L87:
        if (this.mIsCallGLfinish != 1) goto L90;
        if (r110 != 1) goto L90;
        GLES20.glFinish();
    L90:
        if (r211 == null) goto L93;
        r211.unbindTexture2D();
    L93:
        if (this.mDoClip == false) goto L95;
        resetClipParams();
    L95:
        VideoSurfaceTexture r113 = this.mSurfaceTexture;
        if (r113 == null) goto L98;
        r113.currentEffectProcessEnd(this.mEffectType);
    L98:
        int r114 = TexGLUtils.checkGLError(this.mTexType, "filter glDrawArrays after,type:" + this.mEffectType);
        if (this.mGLError != 0) goto L116;
        if (r114 != 0) goto L116;
        VideoSurfaceTexture r115 = this.mSurfaceTexture;
        if (r115 == null) goto L113;
        r115.setOption(19, this.mEffectType, 1);
        if (this.mTrackEvent == false) goto L113;
        this.mSurfaceTexture.getEventLogger().setViewPort(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        this.mSurfaceTexture.getEventLogger().setTexCoords(this.mTextureVertices);
        this.mSurfaceTexture.getEventLogger().setTexSize(r210.getWidth(), r210.getHeight());
        this.mSurfaceTexture.getEventLogger().setLayoutMode(this.mLayoutMode);
        this.mSurfaceTexture.getEventLogger().setRotation(this.mRotation);
        boolean r116 = this.isMirrorVertical;
        if (r116 == false) goto L108;
        this.mSurfaceTexture.getEventLogger().setMirror(1);
    L111:
        this.mSurfaceTexture.getEventLogger().setCropParams(this.mCropXNormalize, this.mCropYNormalize, this.mCropWidthNormalize, this.mCropHeightNormalize);
        goto L113
    L108:
        if (r116 == false) goto L110;
        this.mSurfaceTexture.getEventLogger().setMirror(2);
        goto L111
    L110:
        this.mSurfaceTexture.getEventLogger().setMirror(0);
    L113:
        if (r212.booleanValue() == false) goto L115;
        r210.giveBack();
    L115:
        return r106;
    L116:
        VideoSurfaceTexture r117 = this.mSurfaceTexture;
        if (r117 == null) goto L119;
        r117.notifyError(r114, this.mEffectType, "filter glDrawArrays after,type:" + this.mEffectType);
    L119:
        if (r106 == null) goto L121;
        r106.giveBack();
    L121:
        this.mGLError = -1;
        return r210;
    L79:
        if (r111.getIntOption(178) == 0) goto L81;
        r110 = 0;
        goto L81
    L73:
        this.mGLError = -1;
        VideoSurfaceTexture r118 = this.mSurfaceTexture;
        if (r118 == null) goto L76;
        r118.notifyError(r109, this.mEffectType, "filter glDrawArrays before,type:" + this.mEffectType);
        goto L76
    L69:
        this.mTriangleVertices.position(this.TRIANGLE_VERTICES_DATA_POS_OFFSET);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, this.mTriangleVertices);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mTextureVertices.position(this.TRIANGLE_VERTICES_DATA_UV_OFFSET);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, this.mTextureVertices);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        goto L70
    L64:
        if (r107.booleanValue() == false) goto L66;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        goto L66
    L39:
        if (this.mOutTexWidth != 0) goto L41;
    L42:
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
        VideoSurfaceTexture r119 = this.mSurfaceTexture;
        if (r119 == null) goto L46;
        r119.notifyError(14, this.mEffectType, "error width or height, w:" + this.mOutTexWidth + " h:" + this.mOutTexHeight);
    L46:
        if (this.mDoClip == true) goto L48;
        this.mOutTexRect = r210.getRect();
    L48:
        r106 = genTexture();
        if (r106 == null) goto L51;
        r211.bindTexture2D(r106.getTexID());
        goto L56
    L51:
        if (this.mDoClip == false) goto L53;
        resetClipParams();
    L53:
        return r210;
    L41:
        if (this.mOutTexHeight != 0) goto L46;
        goto L42
    }
}
