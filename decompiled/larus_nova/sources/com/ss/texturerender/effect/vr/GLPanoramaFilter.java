package com.ss.texturerender.effect.vr;

import android.content.Context;
import android.opengl.GLES20;
import android.opengl.Matrix;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.Display;
import android.view.OrientationEventListener;
import android.view.WindowManager;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import com.ss.texturerender.DeviceManager;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.TextureRenderManager;
import com.ss.texturerender.VideoSurfaceTexture;
import com.ss.texturerender.effect.AbsEffect;
import com.ss.texturerender.effect.EffectTexture;
import com.ss.texturerender.effect.FrameBuffer;
import com.ss.texturerender.effect.GLDefaultFilter;
import com.ss.texturerender.effect.vr.director.IDirector;
import com.ss.texturerender.effect.vr.director.IDirectorEventListener;
import com.ss.texturerender.effect.vr.director.TouchDirector;
import com.ss.texturerender.effect.vr.director.picodirector.PicoDirector;
import com.ss.texturerender.effect.vr.director.sensordirector.SensorDirector;
import com.ss.texturerender.effect.vr.distortion.BrownDistortion;
import com.ss.texturerender.math.Quaternion;
import java.lang.reflect.Array;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;
import java.nio.ShortBuffer;
import java.util.Arrays;

/* JADX INFO: loaded from: classes40.dex */
public class GLPanoramaFilter extends GLDefaultFilter implements IDirectorEventListener {
    private static final float DEFAULT_BORDER_SIZE_METER = 0.003f;
    private static int LEFT = 0;
    private static float METERS_PER_INCH = 0.0f;
    private static int RESOLUTION = 0;
    private static int RIGHT = 0;
    private static float[] SIDE_BY_SIDE_TEXSCALE_LEFT = null;
    private static float[] SIDE_BY_SIDE_TEXSCALE_RIGHT = null;
    protected static float[] TEXSCALE_2D = null;
    private static float[] TOP_BOTTOM_TEXSCALE_LEFT = null;
    private static float[] TOP_BOTTOM_TEXSCALE_RIGHT = null;
    private static float ZFAR = 0.0f;
    private static float ZNEAR = 0.0f;
    private static final String cubemapShaderFragment = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvoid main() {\n    vec3 result = vec3((vTextureCoord - 0.5) / expandCoef + 0.5, 1.0) * texScale;\n    gl_FragColor = texture2D(sTexture, result.xy);\n}";
    private static float mRadius;
    private float DEFAULT_OUT_TEXTURE_SCALE;
    private float DEFAULT_PERSPEC_VIEW;
    private final String eac180FragShader;
    private final String eacFragShader;
    protected int mBackTextureSize;
    private float mCMPFaceInnerPadding;
    private float[] mCubeRotatesPerFace;
    private float[] mCubeTexOffsetPerFace;
    protected int mDesireViewSize;
    protected boolean mDidGetInitialModelMatrix;
    protected int mDirectMode;
    private Display mDisplay;
    private BrownDistortion mDistortion;
    private float[] mDistortionCoeffs;
    private short[][] mDistortionIndex;
    protected ShortBuffer[] mDistortionIndexBuffer;
    private float[][] mDistortionPos;
    private float[][] mDistortionTex;
    protected FloatBuffer[] mDistortionTextureBuffer;
    protected FloatBuffer[] mDistortionTriangleBuffer;
    protected int mEBO;
    private boolean mEnableTouchScaler;
    private float mExpandCoef;
    private int mExpandCoefHandle;
    private float[] mFov;
    private float[][] mFovTan;
    private int mFreezeDirector;
    protected float[] mFreezeModelMatrix;
    private float mHalfEyeDistance;
    private int mHeadposeCallbackCounter;
    private float[] mIdentityMat;
    protected float[] mInitialModelMatrixInvert;
    protected boolean mIsProcessed;
    private Quaternion mLastCallbackHeadpose;
    private float mLensToScreenDistance;
    private int mMVPMatrixHandle;
    protected float[] mModelMatrix;
    protected int mOffsetPitch;
    protected int mOffsetYaw;
    protected OrientationEventHandler mOrientationEventHandler;
    protected float mOutTextureScale;
    private int mPanoMode;
    protected float mPerspecView;
    public float mPerspecViewRatio;
    protected float[] mProjectionMatrix;
    protected float[] mRotateMatrix;
    private int mScreenH;
    private int mScreenW;
    protected IDirector mSensorDirector;
    protected boolean mSensorDirectorEnabled;
    protected int mSpaceOrientationPitch;
    protected int mTexVBO;
    private FloatBuffer mTextureVerticesRight;
    protected TouchDirector mTouchDirector;
    protected TouchScaler mTouchScaler;
    private float mTrayToLensDis;
    protected boolean mUseInitialHeadPoseAsFront;
    private int mVRModel;
    protected int mVerVBO;
    private int mVideoProjectModel;
    protected int mVideoStyle;
    protected float[] mViewMatrix;
    protected int mViewSize;
    private float mZOffset;
    private int mZOffsetHandle;
    private final String offsetCubicFragShader;
    private final String vertexDefaultShader;

    public class OrientationEventHandler extends OrientationEventListener {
        final /* synthetic */ GLPanoramaFilter this$0;

        @Override // android.view.OrientationEventListener
        public void onOrientationChanged(int r100) {
            GLPanoramaFilter r101 = this.this$0;
            TouchDirector r102 = r101.mTouchDirector;
            if (r102 != null) goto L5;
            return;
        L5:
            if (r101.mDirectMode != 2) goto L7;
        L9:
            boolean r103 = false;
        L10:
            r102.updateDeviceOrientation(r100, r103);
            return;
        L7:
            if (r101.mSensorDirectorEnabled == false) goto L9;
            r103 = true;
            goto L10
        }

        public OrientationEventHandler(GLPanoramaFilter r100, Context r101) {
            this.this$0 = r100;
            super(r101);
        }
    }

    static {
        SIDE_BY_SIDE_TEXSCALE_LEFT = new float[]{0.5f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        SIDE_BY_SIDE_TEXSCALE_RIGHT = new float[]{0.5f, 0.0f, 0.5f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        TOP_BOTTOM_TEXSCALE_LEFT = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.0f, 0.0f, 0.0f, 0.0f};
        TOP_BOTTOM_TEXSCALE_RIGHT = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 0.5f, 0.5f, 0.0f, 0.0f, 0.0f};
        TEXSCALE_2D = new float[]{1.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f};
        mRadius = 1.0f;
        METERS_PER_INCH = 0.0254f;
        LEFT = 0;
        RIGHT = 1;
        ZNEAR = 0.1f;
        ZFAR = 100.0f;
        RESOLUTION = 40;
    }

    private void initGLData() {
        if (this.mEBO > 0) goto L10;
        int[] r100 = new int[1];
        GLES20.glGenBuffers(1, r100, 0);
        int r101 = r100[0];
        if (r101 != 0) goto L8;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "glGenBuffers bufferID: 0");
        return;
    L8:
        this.mEBO = r101;
    L10:
        if (this.mIndexBuffers != null) goto L13;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "mIndexBuffers is null");
        return;
    L13:
        GLES20.glBindBuffer(34963, this.mEBO);
        this.mIndexBuffers.position(0);
        GLES20.glBufferData(34963, this.mIndexBuffers.capacity() * 2, this.mIndexBuffers, 35044);
        GLES20.glBindBuffer(34963, 0);
        if (this.mVerVBO > 0) goto L21;
        int[] r102 = new int[1];
        GLES20.glGenBuffers(1, r102, 0);
        int r103 = r102[0];
        if (r103 != 0) goto L19;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "glGenBuffers bufferID: 0");
        return;
    L19:
        this.mVerVBO = r103;
    L21:
        if (this.mTriangleVertices != null) goto L24;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "mTriangleVertices is null");
        return;
    L24:
        GLES20.glBindBuffer(34962, this.mVerVBO);
        this.mTriangleVertices.position(0);
        GLES20.glBufferData(34962, this.mTriangleVertices.capacity() * 4, this.mTriangleVertices, 35044);
        GLES20.glBindBuffer(34962, 0);
        if (this.mTexVBO > 0) goto L32;
        int[] r104 = new int[1];
        GLES20.glGenBuffers(1, r104, 0);
        int r105 = r104[0];
        if (r105 != 0) goto L30;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "glGenBuffers bufferID: 0");
        return;
    L30:
        this.mTexVBO = r105;
    L32:
        if (this.mTextureVertices != null) goto L35;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "mTextureVertices is null");
        return;
    L35:
        GLES20.glBindBuffer(34962, this.mTexVBO);
        this.mTextureVertices.position(0);
        GLES20.glBufferData(34962, this.mTextureVertices.capacity() * 4, this.mTextureVertices, 35044);
        GLES20.glBindBuffer(34962, 0);
    }

    public void construct() {
        this.mOrder = 90;
        this.mEnableTouchScaler = true;
        this.mTouchScaler = new TouchScaler(this.mTexType);
        this.mDistortion = new BrownDistortion(this.mDistortionCoeffs, this.mTexType);
        int r100 = RESOLUTION;
        Class r101 = Float.TYPE;
        this.mDistortionTex = (float[][]) Array.newInstance(r101, new int[]{2, (r100 * r100) * 2});
        int r102 = RESOLUTION;
        this.mDistortionPos = (float[][]) Array.newInstance(r101, new int[]{2, (r102 * r102) * 2});
        int r103 = RESOLUTION;
        this.mDistortionIndex = (short[][]) Array.newInstance(Short.TYPE, new int[]{2, (((r103 - 1) * 2) * r103) + (r103 - 2)});
        this.mDistortionTriangleBuffer = new FloatBuffer[2];
        this.mDistortionTextureBuffer = new FloatBuffer[2];
        this.mDistortionIndexBuffer = new ShortBuffer[2];
        this.mFovTan = (float[][]) Array.newInstance(r101, new int[]{2, 4});
        float[] r104 = new float[16];
        this.mIdentityMat = r104;
        Matrix.setIdentityM(r104, 0);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLPanoramaFilter");
    }

    public int getShaderType() {
        int r100 = this.mViewSize;
        int r101 = 1;
        if (r100 != 90) goto L6;
    L13:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "pano_eac:" + r101);
        return r101;
    L6:
        if (r100 == 180) goto L8;
    L12:
        r101 = 0;
        goto L13
    L8:
        if (this.mVRModel != 1) goto L12;
        r101 = 2;
        if (this.mVideoProjectModel != 2) goto L12;
        goto L12
    }

    public void handleDirectModeChange() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "handleDirectModeChange mDirectMode:" + this.mDirectMode);
        int r100 = this.mDirectMode;
        if (r100 != 1) goto L8;
        startSensorDirector();
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L15;
        r101.unRegisterTouchListener(this.mTouchDirector);
        return;
    L15:
        return;
    L8:
        if (r100 != 2) goto L13;
        IDirector r102 = this.mSensorDirector;
        if (r102 == null) goto L12;
        r102.stop();
    L12:
        registTouchDirector();
        return;
    L13:
        startSensorDirector();
        registTouchDirector();
    }

    public void handleTouchScalerChange() {
        if (this.mSurfaceTexture != null) goto L6;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "Error: handleTouchScalerChange mSurfaceTexture is null");
        return;
    L6:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "handleTouchScalerChange mEnableTouchScaler:" + this.mEnableTouchScaler);
        if (this.mEnableTouchScaler == false) goto L9;
        this.mTouchScaler.start();
        this.mSurfaceTexture.registerTouchListener(this.mTouchScaler);
        return;
    L9:
        this.mSurfaceTexture.unRegisterTouchListener(this.mTouchScaler);
        this.mTouchScaler.stop();
    }

    public void registTouchDirector() {
        VideoSurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 == null) goto L11;
        TouchDirector r101 = this.mTouchDirector;
        if (r101 != null) goto L7;
        return;
    L7:
        if (this.mFreezeDirector != 2) goto L9;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "freezing touch,don't regist");
        return;
    L9:
        r100.registerTouchListener(r101);
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        IDirector r100 = this.mSensorDirector;
        if (r100 == null) goto L5;
        r100.stop();
        this.mSensorDirector = null;
    L5:
        OrientationEventHandler r101 = this.mOrientationEventHandler;
        if (r101 == null) goto L8;
        r101.disable();
        this.mOrientationEventHandler = null;
    L8:
        this.mIsProcessed = false;
        return super.release();
    }

    public void startSensorDirector() {
        IDirector r100 = this.mSensorDirector;
        if (r100 != null) goto L5;
        return;
    L5:
        if (this.mFreezeDirector != 0) goto L7;
        r100.start();
        return;
    L7:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "freezing,don't start");
    }

    public float getExpandCoef() {
        return this.mExpandCoef;
    }

    public GLPanoramaFilter(int r100) {
        super(r100, 8);
        this.vertexDefaultShader = "attribute vec4 aPosition;\nuniform mat4 u_MVPMatrix;\nuniform mat4 rotateMatrix;attribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;void main() {\n  gl_Position =  u_MVPMatrix * rotateMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n  verPosition = aPosition.xyz;}\n";
        this.eacFragShader = "#define PI 3.14159265359\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = 1.0 / 3.0 * clamp(floor(oriCoord.x * 3.0), 0.0, 2.0);\n    float yStep = 0.5 * step(0.5, oriCoord.y);\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 4.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 4.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = texture2D(sTexture,  eacResult.xy);\n}";
        this.eac180FragShader = "#define PI 3.14159265359\nprecision highp float;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = -1.0 / 6.0 + step(1.0 / 6.0, oriCoord.x) / 3.0 + step(3.0 / 6.0, oriCoord.x) / 3.0 + step(2.0 / 3.0, oriCoord.x) / 6.0;\n    float yStep = 0.0;\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 2.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 2.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = step(0.0, -verPosition.z) * texture2D(sTexture, eacResult.xy);\n}";
        this.offsetCubicFragShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nvarying vec3 verPosition;\nuniform vec3 zOffset;\nuniform int cubemapMode;\nuniform vec2 texOffset[6];\nuniform mat2 rotates[6];\nuniform mat3 texScale;//one eye and two eye scale\nvec2 cubeToTexture(vec3 cubeCoord, float expand) {\n    vec2 result;\n    float absX = abs(cubeCoord.x);\n    float absY = abs(cubeCoord.y);\n    float absZ = abs(cubeCoord.z);\n    int index;//0:left 1:front 2:right 3:top 4:back 5:bottom\n    if (-cubeCoord.z >= absX && -cubeCoord.z >= absY) {\n        result = vec2(cubeCoord.x, cubeCoord.y);\n        index = 1;\n    } else if (cubeCoord.z >= absX && cubeCoord.z >= absY) {\n        result = vec2(-cubeCoord.x, cubeCoord.y);\n        index = 4;\n    } else if (cubeCoord.y >= absX && cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, cubeCoord.z);\n        index = 3;\n    } else if (-cubeCoord.y >= absX && -cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, -cubeCoord.z);\n        index = 5;\n    } else if (cubeCoord.x >= absY && cubeCoord.x >= absZ) {\n        result = vec2(cubeCoord.z, cubeCoord.y);\n        index = 2;\n    } else {\n        result = vec2(-cubeCoord.z, cubeCoord.y);\n        index = 0;\n    }\n    result = result * rotates[index] / expand;\n    result = vec2((result.x + 1.0) / 6.0, (result.y + 1.0) / 4.0) + texOffset[index];\n    return result;\n}\nvec2 offsetCubicTransFunc(vec3 inCubePosition) {\n    inCubePosition = inCubePosition - zOffset;\n    inCubePosition = inCubePosition / max(max(abs(inCubePosition.x),abs(inCubePosition.y)),abs(inCubePosition.z));\n    return cubeToTexture(inCubePosition, expandCoef);\n}\nvoid main() {\n    vec3 result = vec3(offsetCubicTransFunc(verPosition),1.0) * texScale;\n    gl_FragColor = texture2D(sTexture, result.xy);\n}";
        this.mExpandCoef = 1.0f;
        this.mOffsetYaw = 0;
        this.mOffsetPitch = 0;
        this.mSpaceOrientationPitch = 0;
        this.mProjectionMatrix = new float[16];
        this.mModelMatrix = new float[16];
        this.mFreezeModelMatrix = new float[16];
        this.mInitialModelMatrixInvert = new float[16];
        this.mDidGetInitialModelMatrix = false;
        this.mUseInitialHeadPoseAsFront = false;
        this.mViewMatrix = new float[16];
        this.mRotateMatrix = new float[16];
        this.mSensorDirectorEnabled = true;
        this.mPanoMode = 2;
        this.mVideoStyle = 1;
        this.mVRModel = 1;
        this.mVideoProjectModel = 1;
        this.mViewSize = 360;
        this.mDesireViewSize = 360;
        this.mBackTextureSize = 180;
        this.mDirectMode = 1;
        this.DEFAULT_PERSPEC_VIEW = 100.0f;
        this.mPerspecView = 100.0f;
        this.mPerspecViewRatio = 1.0f;
        this.mFov = new float[]{100.0f / 2.0f, 100.0f / 2.0f, 100.0f / 2.0f, 100.0f / 2.0f};
        this.mHalfEyeDistance = 0.03f;
        this.mIsProcessed = false;
        this.mLensToScreenDistance = 0.042f;
        this.mDistortionCoeffs = new float[]{0.441f, 0.156f};
        this.mTrayToLensDis = 0.035f;
        this.mScreenW = -1;
        this.mScreenH = -1;
        this.DEFAULT_OUT_TEXTURE_SCALE = 1.1f;
        this.mOutTextureScale = 1.1f;
        this.mTextureVerticesRight = null;
        this.mEBO = -1;
        this.mTexVBO = -1;
        this.mVerVBO = -1;
        this.mCMPFaceInnerPadding = 0.0f;
        this.mHeadposeCallbackCounter = 0;
        this.mLastCallbackHeadpose = null;
        this.mFreezeDirector = 0;
        this.mOrientationEventHandler = null;
        construct();
    }

    private void renderDistortion(int r100) {
        this.mDistortionTriangleBuffer[r100].position(0);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 2, 5126, false, 8, this.mDistortionTriangleBuffer[r100]);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        this.mDistortionTextureBuffer[r100].position(0);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, 8, this.mDistortionTextureBuffer[r100]);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        this.mDistortionIndexBuffer[r100].position(0);
        GLES20.glDrawElements(5, this.mDistortionIndexBuffer[r100].remaining(), 5123, this.mDistortionIndexBuffer[r100]);
    }

    private void updateDistortionParam(boolean r210) {
        if (this.mPanoMode == 2) goto L5;
        return;
    L5:
        if (DeviceManager.isVRDevice() == true) goto L19;
        DisplayMetrics r100 = new DisplayMetrics();
        Context r101 = TextureRenderManager.getManager().getContext();
        if (r101 == null) goto L10;
        ((WindowManager) r101.getSystemService(LiveEndPageData.TAG_WINDOW)).getDefaultDisplay().getMetrics(r100);
    L10:
        int r102 = r100.widthPixels;
        if (r102 == this.mScreenW) goto L13;
    L16:
        this.mScreenW = r102;
        int r103 = r100.heightPixels;
        this.mScreenH = r103;
        float r104 = r102 / r100.xdpi;
        float r105 = METERS_PER_INCH;
        float r106 = r104 * r105;
        float r107 = (r103 / r100.ydpi) * r105;
        float[] r108 = calculateFov(r106, r107);
        this.mFovTan[LEFT][0] = (float) Math.tan(r108[0]);
        this.mFovTan[LEFT][1] = (float) Math.tan(r108[1]);
        this.mFovTan[LEFT][2] = (float) Math.tan(r108[2]);
        this.mFovTan[LEFT][3] = (float) Math.tan(r108[3]);
        this.mFovTan[RIGHT][0] = (float) Math.tan(r108[1]);
        this.mFovTan[RIGHT][1] = (float) Math.tan(r108[0]);
        this.mFovTan[RIGHT][2] = (float) Math.tan(r108[2]);
        this.mFovTan[RIGHT][3] = (float) Math.tan(r108[3]);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "realFov:" + Arrays.toString(r108) + "screenWInMeter:" + r106 + " screenHInMeter:" + r107);
        float r109 = this.mLensToScreenDistance;
        float r110 = r106 / r109;
        float r111 = r107 / r109;
        float r112 = r106 / 2.0f;
        float r113 = this.mHalfEyeDistance;
        float r114 = (this.mTrayToLensDis - DEFAULT_BORDER_SIZE_METER) / r109;
        float r115 = (float) (Math.tan(r108[0]) + Math.tan(r108[1]));
        float r116 = (float) (Math.tan(r108[2]) + Math.tan(r108[3]));
        float r117 = (float) Math.tan(r108[0]);
        float r118 = (float) Math.tan(r108[1]);
        float r119 = (float) Math.tan(r108[2]);
        updateMesh(LEFT, r110, r111, (r112 - r113) / r109, r114, r115, r116, r117, r119);
        updateMesh(RIGHT, r110, r111, (r112 + r113) / r109, r114, r115, r116, r118, r119);
        return;
    L13:
        if (r100.heightPixels != this.mScreenH) goto L16;
        if (r210 == true) goto L16;
        return;
    }

    public void draw(ShortBuffer r100) {
        float[] r101 = new float[16];
        Matrix.multiplyMM(r101, 0, this.mViewMatrix, 0, this.mModelMatrix, 0);
        Matrix.multiplyMM(r101, 0, this.mProjectionMatrix, 0, r101, 0);
        GLES20.glUniformMatrix4fv(this.mMVPMatrixHandle, 1, false, r101, 0);
        r100.position(0);
        GLES20.glBindBuffer(34963, this.mEBO);
        GLES20.glDrawElements(4, r100.remaining(), 5123, 0);
        GLES20.glBindBuffer(34963, 0);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int getIntOption(int r100) {
        if (r100 != 10004) goto L9;
        if (DeviceManager.isVRDevice() == false) goto L9;
        return 36197;
    L9:
        if (r100 != 10012) goto L13;
        return this.mPanoMode;
    L13:
        return super.getIntOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "attribute vec4 aPosition;\nuniform mat4 u_MVPMatrix;\nuniform mat4 rotateMatrix;attribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;void main() {\n  gl_Position =  u_MVPMatrix * rotateMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n  verPosition = aPosition.xyz;}\n";
    L5:
        if (r100 != 11001) goto L7;
        int r101 = this.mVRModel;
        if (r101 != 2) goto L17;
        if (this.mViewSize != 180) goto L14;
        return "#define PI 3.14159265359\nprecision highp float;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = -1.0 / 6.0 + step(1.0 / 6.0, oriCoord.x) / 3.0 + step(3.0 / 6.0, oriCoord.x) / 3.0 + step(2.0 / 3.0, oriCoord.x) / 6.0;\n    float yStep = 0.0;\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 2.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 2.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = step(0.0, -verPosition.z) * texture2D(sTexture, eacResult.xy);\n}";
    L14:
        return "#define PI 3.14159265359\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = 1.0 / 3.0 * clamp(floor(oriCoord.x * 3.0), 0.0, 2.0);\n    float yStep = 0.5 * step(0.5, oriCoord.y);\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 4.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 4.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = texture2D(sTexture,  eacResult.xy);\n}";
    L17:
        if (r101 != 3) goto L21;
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nvarying vec3 verPosition;\nuniform vec3 zOffset;\nuniform int cubemapMode;\nuniform vec2 texOffset[6];\nuniform mat2 rotates[6];\nuniform mat3 texScale;//one eye and two eye scale\nvec2 cubeToTexture(vec3 cubeCoord, float expand) {\n    vec2 result;\n    float absX = abs(cubeCoord.x);\n    float absY = abs(cubeCoord.y);\n    float absZ = abs(cubeCoord.z);\n    int index;//0:left 1:front 2:right 3:top 4:back 5:bottom\n    if (-cubeCoord.z >= absX && -cubeCoord.z >= absY) {\n        result = vec2(cubeCoord.x, cubeCoord.y);\n        index = 1;\n    } else if (cubeCoord.z >= absX && cubeCoord.z >= absY) {\n        result = vec2(-cubeCoord.x, cubeCoord.y);\n        index = 4;\n    } else if (cubeCoord.y >= absX && cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, cubeCoord.z);\n        index = 3;\n    } else if (-cubeCoord.y >= absX && -cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, -cubeCoord.z);\n        index = 5;\n    } else if (cubeCoord.x >= absY && cubeCoord.x >= absZ) {\n        result = vec2(cubeCoord.z, cubeCoord.y);\n        index = 2;\n    } else {\n        result = vec2(-cubeCoord.z, cubeCoord.y);\n        index = 0;\n    }\n    result = result * rotates[index] / expand;\n    result = vec2((result.x + 1.0) / 6.0, (result.y + 1.0) / 4.0) + texOffset[index];\n    return result;\n}\nvec2 offsetCubicTransFunc(vec3 inCubePosition) {\n    inCubePosition = inCubePosition - zOffset;\n    inCubePosition = inCubePosition / max(max(abs(inCubePosition.x),abs(inCubePosition.y)),abs(inCubePosition.z));\n    return cubeToTexture(inCubePosition, expandCoef);\n}\nvoid main() {\n    vec3 result = vec3(offsetCubicTransFunc(verPosition),1.0) * texScale;\n    gl_FragColor = texture2D(sTexture, result.xy);\n}";
    L21:
        if (r101 != 4) goto L23;
        return cubemapShaderFragment;
    L23:
        if (r101 != 5) goto L26;
        return cubemapShaderFragment;
    L26:
        return super.getStringOption(r100);
    L7:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r110) {
        if (r110.containsKey(TextureRenderKeys.KEY_IS_VR_MODEL) == false) goto L6;
        int r100 = r110.getInt(TextureRenderKeys.KEY_IS_VR_MODEL);
        this.mVRModel = r100;
        this.mVideoProjectModel = r100;
    L6:
        if (r110.containsKey(TextureRenderKeys.KEY_IS_VIDEO_PROJECTION_MODEL) == false) goto L8;
        this.mVideoProjectModel = r110.getInt(TextureRenderKeys.KEY_IS_VIDEO_PROJECTION_MODEL);
    L8:
        this.mViewSize = r110.getInt("view_size", 360);
        if (super.init(r110) == 0) goto L14;
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L13;
        r101.notifyInitError(10, this.mEffectType, "super.init(bundle) != TR_OK");
    L13:
        return -1;
    L14:
        this.mMVPMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "u_MVPMatrix");
        this.mExpandCoefHandle = GLES20.glGetUniformLocation(this.mProgram, "expandCoef");
        this.mZOffsetHandle = GLES20.glGetUniformLocation(this.mProgram, "zOffset");
        Matrix.setIdentityM(this.mModelMatrix, 0);
        Matrix.setIdentityM(this.mViewMatrix, 0);
        Matrix.setIdentityM(this.mProjectionMatrix, 0);
        this.mIsProcessed = false;
        this.mFreezeDirector = 0;
        this.mPanoMode = r110.getInt(TextureRenderKeys.KEY_IS_PANORAMA_MODE, 2);
        boolean r111 = true;
        this.mVideoStyle = r110.getInt(TextureRenderKeys.KEY_IS_VIDEO_STYLE, 1);
        this.mDirectMode = r110.getInt(TextureRenderKeys.KEY_IS_DIRECT_MODE, 1);
        if (r110.getInt(TextureRenderKeys.KEY_IS_USE_INITIAL_HEAD_POSE_AS_FRONT, 0) != 0) goto L17;
        boolean r102 = false;
    L18:
        this.mUseInitialHeadPoseAsFront = r102;
        this.mPerspecView = r110.getFloat(TextureRenderKeys.KEY_IS_PERSPECTIVE_VIEW, this.DEFAULT_PERSPEC_VIEW);
        this.mDesireViewSize = r110.getInt(TextureRenderKeys.KEY_IS_DESIRE_VIEW_SIZE, this.mViewSize);
        this.mOutTextureScale = r110.getFloat(TextureRenderKeys.KEY_IS_VR_OUT_TEXTURE_SCALE, this.DEFAULT_OUT_TEXTURE_SCALE);
        if (r110.containsKey(TextureRenderKeys.KEY_IS_BACKGROUND_TEXTURE_SIZE) == false) goto L22;
        this.mBackTextureSize = r110.getInt(TextureRenderKeys.KEY_IS_BACKGROUND_TEXTURE_SIZE);
    L22:
        if (r110.containsKey(TextureRenderKeys.KEY_IS_EXPAND_COEF) == false) goto L24;
        this.mExpandCoef = r110.getFloat(TextureRenderKeys.KEY_IS_EXPAND_COEF);
    L24:
        this.mZOffset = r110.getFloat(TextureRenderKeys.KEY_IS_Z_OFFSET, 0.0f);
        this.mOffsetYaw = r110.getInt(TextureRenderKeys.KEY_IS_YAW);
        this.mOffsetPitch = r110.getInt(TextureRenderKeys.KEY_IS_PITCH);
        if (r110.containsKey(TextureRenderKeys.KEY_IS_SPACE_ORIENTATION_PITCH) == false) goto L27;
        this.mSpaceOrientationPitch = r110.getInt(TextureRenderKeys.KEY_IS_SPACE_ORIENTATION_PITCH);
    L27:
        this.mCMPFaceInnerPadding = r110.getFloat(TextureRenderKeys.KEY_IS_CMP_FACE_INNER_PADDING, 0.0f);
        if (this.mDisplay != null) goto L36;
        Context r103 = TextureRenderManager.getManager().getContext();
        if (r103 != null) goto L32;
        return -1;
    L32:
        WindowManager r104 = (WindowManager) r103.getSystemService(LiveEndPageData.TAG_WINDOW);
        if (r104 != null) goto L35;
        return -1;
    L35:
        this.mDisplay = r104.getDefaultDisplay();
    L36:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "display rotation:" + this.mDisplay.getRotation() + ",perspec:" + this.mPerspecView);
        updateRenderParam(null, null);
        initGLData();
        TouchDirector r105 = new TouchDirector(this.mDisplay);
        this.mTouchDirector = r105;
        r105.start();
        this.mTouchDirector.setRadius(800.0f);
        if (this.mSensorDirector == null) goto L39;
    L44:
        IDirector r106 = this.mSensorDirector;
        if (r106 == null) goto L48;
        r106.setParam(r110);
    L48:
        if (this.mOrientationEventHandler != null) goto L57;
        if (r110.getInt(TextureRenderKeys.KEY_IS_HANDLE_DEVICE_ORIENTATION_ENABLED, 0) == 0) goto L57;
        if (DeviceManager.isVRDevice() == true) goto L57;
        Context r107 = TextureRenderManager.getManager().getContext();
        if (r107 == null) goto L57;
        this.mOrientationEventHandler = new OrientationEventHandler(this, r107);
    L57:
        if (r110.containsKey(TextureRenderKeys.KEY_IS_FOV) == false) goto L59;
        this.mFov = r110.getFloatArray(TextureRenderKeys.KEY_IS_FOV);
        boolean r108 = true;
    L61:
        if (r110.containsKey(TextureRenderKeys.KEY_IS_DISTORTION_COEFFS) == false) goto L64;
        this.mDistortionCoeffs = r110.getFloatArray(TextureRenderKeys.KEY_IS_DISTORTION_COEFFS);
        r108 = true;
    L64:
        if (r110.containsKey(TextureRenderKeys.KEY_IS_LENS_TO_SCREEN_DISTANCE) == false) goto L66;
        this.mLensToScreenDistance = r110.getFloat(TextureRenderKeys.KEY_IS_LENS_TO_SCREEN_DISTANCE);
    L67:
        updateDistortionParam(r111);
        if (this.mEnableTouchScaler == false) goto L72;
        TouchScaler r109 = this.mTouchScaler;
        if (r109 == null) goto L72;
        r109.setMaxScale(r110.getFloat(TextureRenderKeys.KEY_IS_VR_MAX_SCALE, 4.0f));
        this.mTouchScaler.setMinScale(r110.getFloat(TextureRenderKeys.KEY_IS_VR_MIN_SCALE, 0.2f));
    L72:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init, manu:" + Build.MANUFACTURER);
        return 0;
    L66:
        r111 = r108;
        goto L67
    L59:
        r108 = false;
        goto L61
    L39:
        if (DeviceManager.isVRDevice() == false) goto L41;
        this.mSensorDirector = new PicoDirector(this.mDisplay);
        goto L44
    L41:
        Context r112 = TextureRenderManager.getManager().getContext();
        if (r112 == null) goto L44;
        this.mSensorDirector = new SensorDirector(r112, this.mDisplay, r110.getInt(TextureRenderKeys.KEY_IS_SENSOR_START_POS, 1), r110.getInt(TextureRenderKeys.KEY_IS_SENSOR_RESET_POS, 2), this.mTexType, r110.getInt(TextureRenderKeys.KEY_IS_SENSOR_SMOOTHER_ENABLED, 0), r110.getFloat(TextureRenderKeys.KEY_IS_SENSOR_SMOOTH_FACTOR, 1.0f), this);
        goto L44
    L17:
        r102 = true;
        goto L18
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        if (r100 != null) goto L4;
    L19:
        super.setOption(r100);
        return;
    L4:
        if (this.mEffectType != r100.getInt("effect_type")) goto L19;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "setOption:" + r100.toString());
        if (r100.getInt("action") != 134) goto L24;
        IDirector r101 = this.mSensorDirector;
        if (r101 == null) goto L11;
        r101.stop();
        this.mSensorDirector.reset();
        startSensorDirector();
    L11:
        TouchDirector r102 = this.mTouchDirector;
        if (r102 == null) goto L14;
        r102.stop();
        this.mTouchDirector.reset();
        this.mTouchDirector.start();
    L14:
        TouchScaler r103 = this.mTouchScaler;
        if (r103 != null) goto L17;
        return;
    L17:
        if (this.mEnableTouchScaler == false) goto L22;
        r103.stop();
        this.mTouchScaler.start();
        return;
    L22:
        return;
    }

    public void updateOutTexSize(float r100) {
        if (this.mVideoProjectModel == 2) goto L5;
    L7:
        this.mOutTexHeight = (int) Math.ceil((((this.mPerspecView / this.mPerspecViewRatio) / 180.0f) * this.mSurfaceTexture.getTexHeight()) * this.mOutTextureScale);
    L8:
        int r101 = this.mOutTexHeight;
        int r102 = ((4 - (r101 % 4)) % 4) + r101;
        this.mOutTexHeight = r102;
        this.mOutTexWidth = (int) Math.ceil((r102 * 1.0f) * r100);
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "pano OutTex h:" + this.mOutTexHeight + " w:" + this.mOutTexWidth + ",viewPortRatio:" + r100);
        return;
    L5:
        if (this.mViewSize != 180) goto L7;
        this.mOutTexHeight = (int) Math.ceil((((this.mPerspecView / this.mPerspecViewRatio) / 90.0f) * this.mSurfaceTexture.getTexHeight()) * this.mOutTextureScale);
        goto L8
    }

    public GLPanoramaFilter(int r100, int r101) {
        super(r100, r101);
        this.vertexDefaultShader = "attribute vec4 aPosition;\nuniform mat4 u_MVPMatrix;\nuniform mat4 rotateMatrix;attribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;void main() {\n  gl_Position =  u_MVPMatrix * rotateMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n  verPosition = aPosition.xyz;}\n";
        this.eacFragShader = "#define PI 3.14159265359\nprecision highp float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = 1.0 / 3.0 * clamp(floor(oriCoord.x * 3.0), 0.0, 2.0);\n    float yStep = 0.5 * step(0.5, oriCoord.y);\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 4.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 4.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = texture2D(sTexture,  eacResult.xy);\n}";
        this.eac180FragShader = "#define PI 3.14159265359\nprecision highp float;\nvarying vec2 vTextureCoord;\nvarying vec3 verPosition;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nuniform vec3 zOffset;\nuniform mat3 texScale;//one eye and two eye scale\nvec2 EACTransFunc(vec2 oriCoord, float expand) {\n    vec2 resultCoord;\n    float xStep = -1.0 / 6.0 + step(1.0 / 6.0, oriCoord.x) / 3.0 + step(3.0 / 6.0, oriCoord.x) / 3.0 + step(2.0 / 3.0, oriCoord.x) / 6.0;\n    float yStep = 0.0;\n    resultCoord.x = (atan(((oriCoord.x - xStep) * 6.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 6.0 + xStep;\n    resultCoord.y = (atan(((oriCoord.y - yStep) * 2.0 - 1.0) / expand) / PI * 4.0 + 1.0) / 2.0 + yStep;\n    return resultCoord;\n}\nvoid main() {\n    vec3 eacResult = vec3(EACTransFunc(vTextureCoord, expandCoef), 1.0) * texScale;\n    gl_FragColor = step(0.0, -verPosition.z) * texture2D(sTexture, eacResult.xy);\n}";
        this.offsetCubicFragShader = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nuniform float expandCoef;\nvarying vec3 verPosition;\nuniform vec3 zOffset;\nuniform int cubemapMode;\nuniform vec2 texOffset[6];\nuniform mat2 rotates[6];\nuniform mat3 texScale;//one eye and two eye scale\nvec2 cubeToTexture(vec3 cubeCoord, float expand) {\n    vec2 result;\n    float absX = abs(cubeCoord.x);\n    float absY = abs(cubeCoord.y);\n    float absZ = abs(cubeCoord.z);\n    int index;//0:left 1:front 2:right 3:top 4:back 5:bottom\n    if (-cubeCoord.z >= absX && -cubeCoord.z >= absY) {\n        result = vec2(cubeCoord.x, cubeCoord.y);\n        index = 1;\n    } else if (cubeCoord.z >= absX && cubeCoord.z >= absY) {\n        result = vec2(-cubeCoord.x, cubeCoord.y);\n        index = 4;\n    } else if (cubeCoord.y >= absX && cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, cubeCoord.z);\n        index = 3;\n    } else if (-cubeCoord.y >= absX && -cubeCoord.y >= absZ) {\n        result = vec2(cubeCoord.x, -cubeCoord.z);\n        index = 5;\n    } else if (cubeCoord.x >= absY && cubeCoord.x >= absZ) {\n        result = vec2(cubeCoord.z, cubeCoord.y);\n        index = 2;\n    } else {\n        result = vec2(-cubeCoord.z, cubeCoord.y);\n        index = 0;\n    }\n    result = result * rotates[index] / expand;\n    result = vec2((result.x + 1.0) / 6.0, (result.y + 1.0) / 4.0) + texOffset[index];\n    return result;\n}\nvec2 offsetCubicTransFunc(vec3 inCubePosition) {\n    inCubePosition = inCubePosition - zOffset;\n    inCubePosition = inCubePosition / max(max(abs(inCubePosition.x),abs(inCubePosition.y)),abs(inCubePosition.z));\n    return cubeToTexture(inCubePosition, expandCoef);\n}\nvoid main() {\n    vec3 result = vec3(offsetCubicTransFunc(verPosition),1.0) * texScale;\n    gl_FragColor = texture2D(sTexture, result.xy);\n}";
        this.mExpandCoef = 1.0f;
        this.mOffsetYaw = 0;
        this.mOffsetPitch = 0;
        this.mSpaceOrientationPitch = 0;
        this.mProjectionMatrix = new float[16];
        this.mModelMatrix = new float[16];
        this.mFreezeModelMatrix = new float[16];
        this.mInitialModelMatrixInvert = new float[16];
        this.mDidGetInitialModelMatrix = false;
        this.mUseInitialHeadPoseAsFront = false;
        this.mViewMatrix = new float[16];
        this.mRotateMatrix = new float[16];
        this.mSensorDirectorEnabled = true;
        this.mPanoMode = 2;
        this.mVideoStyle = 1;
        this.mVRModel = 1;
        this.mVideoProjectModel = 1;
        this.mViewSize = 360;
        this.mDesireViewSize = 360;
        this.mBackTextureSize = 180;
        this.mDirectMode = 1;
        this.DEFAULT_PERSPEC_VIEW = 100.0f;
        this.mPerspecView = 100.0f;
        this.mPerspecViewRatio = 1.0f;
        this.mFov = new float[]{100.0f / 2.0f, 100.0f / 2.0f, 100.0f / 2.0f, 100.0f / 2.0f};
        this.mHalfEyeDistance = 0.03f;
        this.mIsProcessed = false;
        this.mLensToScreenDistance = 0.042f;
        this.mDistortionCoeffs = new float[]{0.441f, 0.156f};
        this.mTrayToLensDis = 0.035f;
        this.mScreenW = -1;
        this.mScreenH = -1;
        this.DEFAULT_OUT_TEXTURE_SCALE = 1.1f;
        this.mOutTextureScale = 1.1f;
        this.mTextureVerticesRight = null;
        this.mEBO = -1;
        this.mTexVBO = -1;
        this.mVerVBO = -1;
        this.mCMPFaceInnerPadding = 0.0f;
        this.mHeadposeCallbackCounter = 0;
        this.mLastCallbackHeadpose = null;
        this.mFreezeDirector = 0;
        this.mOrientationEventHandler = null;
        construct();
    }

    private float[] calculateFov(float r100, float r101) {
        float r102 = this.mHalfEyeDistance;
        float r103 = this.mTrayToLensDis - DEFAULT_BORDER_SIZE_METER;
        return new float[]{Math.min((float) Math.atan(this.mDistortion.distort(((r100 / 2.0f) - r102) / this.mLensToScreenDistance, 0.0f)[0]), (float) Math.toRadians(this.mFov[0])), Math.min((float) Math.atan(this.mDistortion.distort(r102 / this.mLensToScreenDistance, 0.0f)[0]), (float) Math.toRadians(this.mFov[1])), Math.min((float) Math.atan(this.mDistortion.distort(0.0f, r103 / this.mLensToScreenDistance)[1]), (float) Math.toRadians(this.mFov[2])), Math.min((float) Math.atan(this.mDistortion.distort(0.0f, (r101 - r103) / this.mLensToScreenDistance)[1]), (float) Math.toRadians(this.mFov[3]))};
    }

    @Override // com.ss.texturerender.effect.vr.director.IDirectorEventListener
    public void onDisplayRotationChanged(int r100, boolean r101) {
        if (r101 == false) goto L5;
        this.mSurfaceTexture.setOption(128, 1);
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r310, FrameBuffer r311) {
        if (this.mIsProcessed == true) goto L9;
        this.mIsProcessed = true;
        OrientationEventHandler r100 = this.mOrientationEventHandler;
        if (r100 == null) goto L7;
        r100.enable();
    L7:
        handleDirectModeChange();
        handleTouchScalerChange();
    L9:
        if (r310.getTexTarget() == this.mInTextureTarget) goto L15;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r310.getTexTarget());
        VideoSurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L13;
        r101.notifyError(12, this.mEffectType, "error, texture miss match, accept:" + this.mInTextureTarget + ",in:" + r310.getTexTarget());
    L13:
        return r310;
    L15:
        if (this.mProgram != 0) goto L20;
        TextureRenderLog.e(this.mTexType, this.LOG_TAG, "program error,don't process,filter:" + this.mEffectType);
        VideoSurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L19;
        r102.notifyError(13, this.mEffectType, "program error,don't process,filter:" + this.mEffectType);
    L19:
        return r310;
    L20:
        VideoSurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L23;
        r103.currentEffectProcessBegin(this.mEffectType);
    L23:
        GLES20.glUseProgram(this.mProgram);
        this.mViewPortWidth = this.mSurfaceTexture.getViewportWidth();
        this.mViewPortHeight = this.mSurfaceTexture.getViewportHeight();
        if (this.mVideoStyle != 1) goto L26;
        updateRenderParam(r310, r311);
    L26:
        GLES20.glBindBuffer(34962, this.mVerVBO);
        GLES20.glVertexAttribPointer(this.maPositionHandle, 3, 5126, false, this.TRIANGLE_VERTICES_DATA_STRIDE_BYTES, 0);
        GLES20.glEnableVertexAttribArray(this.maPositionHandle);
        GLES20.glBindBuffer(34962, 0);
        GLES20.glBindBuffer(34962, this.mTexVBO);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, 0);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
        GLES20.glBindBuffer(34962, 0);
        if (this.mSensorDirectorEnabled == true) goto L38;
        float[] r104 = this.mFreezeModelMatrix;
        if (r104 == null) goto L38;
        this.mModelMatrix = r104;
        if (this.mDidGetInitialModelMatrix == true) goto L51;
        IDirector r105 = this.mSensorDirector;
        if (r105 != null) goto L35;
    L37:
        Matrix.invertM(this.mInitialModelMatrixInvert, 0, this.mModelMatrix, 0);
        float[] r106 = this.mModelMatrix;
        Matrix.multiplyMM(r106, 0, r106, 0, this.mInitialModelMatrixInvert, 0);
        this.mFreezeModelMatrix = this.mModelMatrix;
        this.mDidGetInitialModelMatrix = true;
        goto L51
    L35:
        if (this.mDirectMode == 2) goto L37;
        r105.getView(r104, 0);
    L51:
        Matrix.setIdentityM(this.mRotateMatrix, 0);
        if (DeviceManager.isVRDevice() == true) goto L54;
    L57:
        Matrix.rotateM(this.mRotateMatrix, 0, this.mOffsetPitch + this.mTouchDirector.getDiffX(), 1.0f, 0.0f, 0.0f);
        Matrix.rotateM(this.mRotateMatrix, 0, this.mTouchDirector.getDiffY() - this.mOffsetYaw, 0.0f, 1.0f, 0.0f);
    L58:
        Matrix.rotateM(this.mRotateMatrix, 0, this.mSpaceOrientationPitch, 1.0f, 0.0f, 0.0f);
        float[] r107 = new float[16];
        Matrix.multiplyMM(r107, 0, this.mModelMatrix, 0, this.mRotateMatrix, 0);
        Matrix.invertM(r107, 0, r107, 0);
        Quaternion r108 = new Quaternion(r107);
        this.mSurfaceTexture.setHeadPose(r108);
        this.mHeadposeCallbackCounter++;
        VideoSurfaceTexture r109 = this.mSurfaceTexture;
        if (r109 == null) goto L61;
        int r110 = r109.getIntOption(135);
    L62:
        int r111 = this.mHeadposeCallbackCounter % r110;
        this.mHeadposeCallbackCounter = r111;
        if (r111 != 0) goto L72;
        Quaternion r112 = this.mLastCallbackHeadpose;
        if (r112 != null) goto L67;
    L68:
        VideoSurfaceTexture r113 = this.mSurfaceTexture;
        if (r113 == null) goto L71;
        r113.onHeadposeChanged(r108);
    L71:
        this.mLastCallbackHeadpose = r108;
        goto L72
    L67:
        if ((((Math.abs(r112.getX0() - r108.getX0()) + Math.abs(this.mLastCallbackHeadpose.getX1() - r108.getX1())) + Math.abs(this.mLastCallbackHeadpose.getX2() - r108.getX2())) + Math.abs(this.mLastCallbackHeadpose.getX3() - r108.getX3())) > 0.001d) goto L68;
    L72:
        float r114 = this.mTouchScaler.getScale();
        GLES20.glUniformMatrix4fv(GLES20.glGetUniformLocation(this.mProgram, "rotateMatrix"), 1, false, this.mRotateMatrix, 0);
        if (this.mVRModel != 3) goto L75;
        GLES20.glUniform2fv(GLES20.glGetUniformLocation(this.mProgram, "texOffset"), 6, this.mCubeTexOffsetPerFace, 0);
        GLES20.glUniformMatrix2fv(GLES20.glGetUniformLocation(this.mProgram, "rotates"), 6, false, this.mCubeRotatesPerFace, 0);
        GLES20.glUniform3f(this.mZOffsetHandle, 0.0f, 0.0f, this.mZOffset);
    L75:
        GLES20.glUniform1f(this.mExpandCoefHandle, this.mExpandCoef);
        float r115 = (this.mSurfaceTexture.getViewportWidth() * 1.0f) / this.mSurfaceTexture.getViewportHeight();
        if (r115 <= 1.0f) goto L78;
        float r116 = r115;
    L79:
        this.mPerspecViewRatio = r116;
        if (r311 == null) goto L85;
        updateOutTexSize(r115);
        EffectTexture r117 = genTexture();
        if (r117 != null) goto L84;
        return r310;
    L84:
        r311.bindTexture2D(r117.getTexID());
        this.mViewPortWidth = this.mOutTexWidth;
        this.mViewPortHeight = this.mOutTexHeight;
    L87:
        if (this.mNeedClear == false) goto L89;
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
    L89:
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, r310.getTexID());
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        if (this.mPanoMode != 1) goto L93;
        GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, TEXSCALE_2D, 0);
        Matrix.perspectiveM(this.mProjectionMatrix, 0, this.mPerspecView / this.mPerspecViewRatio, r115, 0.1f, 100.0f);
        Matrix.scaleM(this.mProjectionMatrix, 0, r114, r114, 1.0f);
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        Matrix.setLookAtM(this.mViewMatrix, 0, 0.0f, 0.0f, 0.0f, 0.0f, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
        draw(this.mIndexBuffers);
        r310.giveBack();
    L134:
        GLES20.glBindTexture(this.mInTextureTarget, 0);
        GLES20.glDisableVertexAttribArray(this.maPositionHandle);
        GLES20.glDisableVertexAttribArray(this.maTextureHandle);
        this.mSurfaceTexture.setOption(19, this.mEffectType, 1);
        GLES20.glFinish();
        VideoSurfaceTexture r118 = this.mSurfaceTexture;
        if (r118 == null) goto L137;
        r118.currentEffectProcessEnd(this.mEffectType);
    L137:
        int r119 = TexGLUtils.checkGLError(this.mTexType, "error pano draw");
        if (r119 == 0) goto L142;
        VideoSurfaceTexture r120 = this.mSurfaceTexture;
        if (r120 == null) goto L142;
        r120.notifyError(r119, this.mEffectType, "error pano draw");
    L142:
        if (r311 == null) goto L145;
        r311.unbindTexture2D();
        return r117;
    L145:
        return null;
    L93:
        if (DeviceManager.isVRDevice() == true) goto L95;
        updateDistortionParam(false);
        float[] r121 = this.mProjectionMatrix;
        float[] r122 = this.mFovTan[LEFT];
        float r123 = -r122[0];
        float r210 = ZNEAR;
        Matrix.frustumM(r121, 0, r123 * r210, r122[1] * r210, (-r122[2]) * r210, r122[3] * r210, r210, ZFAR);
    L97:
        if (this.mVideoStyle != 4) goto L99;
        GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, SIDE_BY_SIDE_TEXSCALE_LEFT, 0);
    L100:
        GLES20.glViewport(0, 0, this.mViewPortWidth / 2, this.mViewPortHeight);
        float[] r124 = this.mViewMatrix;
        if (DeviceManager.isVRDevice() == false) goto L103;
        float r125 = 0.0f;
    L105:
        if (DeviceManager.isVRDevice() == false) goto L107;
        float r211 = 0.0f;
    L108:
        Matrix.setLookAtM(r124, 0, r125, 0.0f, 0.0f, r211, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
        draw(this.mIndexBuffers);
        FloatBuffer r126 = this.mTextureVerticesRight;
        if (r126 == null) goto L112;
        r126.position(0);
        GLES20.glVertexAttribPointer(this.maTextureHandle, 2, 5126, false, this.TEXTURE_VERTICES_DATA_STRIDE_BYTES, this.mTextureVerticesRight);
        GLES20.glEnableVertexAttribArray(this.maTextureHandle);
    L112:
        if (DeviceManager.isVRDevice() == true) goto L115;
        float[] r127 = this.mProjectionMatrix;
        float[] r128 = this.mFovTan[RIGHT];
        float r129 = -r128[0];
        float r212 = ZNEAR;
        Matrix.frustumM(r127, 0, r129 * r212, r128[1] * r212, (-r128[2]) * r212, r128[3] * r212, r212, ZFAR);
    L115:
        if (this.mVideoStyle != 4) goto L117;
        GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, SIDE_BY_SIDE_TEXSCALE_RIGHT, 0);
    L118:
        int r130 = this.mViewPortWidth;
        GLES20.glViewport(r130 / 2, 0, r130 / 2, this.mViewPortHeight);
        float[] r131 = this.mViewMatrix;
        if (DeviceManager.isVRDevice() == false) goto L121;
        float r132 = 0.0f;
    L123:
        if (DeviceManager.isVRDevice() == false) goto L125;
        float r133 = 0.0f;
    L126:
        Matrix.setLookAtM(r131, 0, r132, 0.0f, 0.0f, r133, 0.0f, -1.0f, 0.0f, 1.0f, 0.0f);
        draw(this.mIndexBuffers);
        r310.giveBack();
        if (DeviceManager.isVRDevice() == true) goto L134;
        if (r311 == null) goto L132;
        EffectTexture r134 = genTexture();
        if (r134 == null) goto L133;
        r311.bindTexture2D(r134.getTexID());
    L133:
        GLES20.glUseProgram(this.mProgram);
        GLES20.glClearColor(0.0f, 0.0f, 0.0f, 0.0f);
        GLES20.glClear(16384);
        GLES20.glViewport(this.mViewPortX, this.mViewPortY, this.mViewPortWidth, this.mViewPortHeight);
        GLES20.glActiveTexture(33984);
        GLES20.glBindTexture(this.mInTextureTarget, r117.getTexID());
        GLES20.glUniform1i(this.mInputTextureHandle, 0);
        GLES20.glUniformMatrix4fv(this.mMVPMatrixHandle, 1, false, this.mIdentityMat, 0);
        GLES20.glEnable(3089);
        GLES20.glScissor(this.mViewPortX, this.mViewPortY, this.mViewPortWidth / 2, this.mViewPortHeight);
        renderDistortion(LEFT);
        int r135 = this.mViewPortWidth;
        GLES20.glScissor((r135 / 2) + this.mViewPortX, this.mViewPortY, r135 / 2, this.mViewPortHeight);
        renderDistortion(RIGHT);
        GLES20.glDisable(3089);
        r117.giveBack();
        r117 = r134;
        goto L134
    L132:
        r134 = null;
        goto L133
    L125:
        r133 = this.mHalfEyeDistance;
        goto L126
    L121:
        r132 = this.mHalfEyeDistance;
        goto L123
    L117:
        GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, TOP_BOTTOM_TEXSCALE_RIGHT, 0);
        goto L118
    L107:
        r211 = -this.mHalfEyeDistance;
        goto L108
    L103:
        r125 = -this.mHalfEyeDistance;
        goto L105
    L99:
        GLES20.glUniformMatrix3fv(GLES20.glGetUniformLocation(this.mProgram, "texScale"), 1, false, TOP_BOTTOM_TEXSCALE_LEFT, 0);
        goto L100
    L95:
        Matrix.perspectiveM(this.mProjectionMatrix, 0, this.mPerspecView, r115 / 2.0f, 0.1f, 100.0f);
        goto L97
    L85:
        r117 = null;
        goto L87
    L78:
        r116 = 1.0f;
        goto L79
    L61:
        r110 = 1;
        goto L62
    L54:
        if (this.mOffsetYaw != 0) goto L57;
        if (this.mOffsetPitch == 0) goto L58;
    L38:
        IDirector r136 = this.mSensorDirector;
        if (r136 == null) goto L44;
        if (this.mDirectMode == 2) goto L44;
        r136.getView(this.mModelMatrix, 0);
    L44:
        if (this.mDidGetInitialModelMatrix == true) goto L47;
        Matrix.invertM(this.mInitialModelMatrixInvert, 0, this.mModelMatrix, 0);
        this.mDidGetInitialModelMatrix = true;
    L47:
        if (this.mDirectMode == 2) goto L51;
        if (this.mUseInitialHeadPoseAsFront == false) goto L51;
        float[] r137 = this.mModelMatrix;
        Matrix.multiplyMM(r137, 0, r137, 0, this.mInitialModelMatrixInvert, 0);
        goto L51
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, int r101) {
        boolean r102 = false;
        if (r100 == 1) goto L76;
        if (r100 != 101) goto L7;
        this.mPanoMode = r101;
        return;
    L7:
        if (r100 != 102) goto L9;
        this.mVideoStyle = r101;
        updateRenderParam(null, null);
        return;
    L9:
        if (r100 != 105) goto L11;
        this.mDirectMode = r101;
        handleDirectModeChange();
        return;
    L11:
        if (r100 == 106) goto L59;
        if (r100 != 108) goto L15;
        this.mOffsetYaw = r101;
    L88:
        TextureRenderLog.d(this.mTexType, this.LOG_TAG, "setOption key:" + r100 + " value:" + r101);
        super.setOption(r100, r101);
        return;
    L15:
        if (r100 != 109) goto L17;
        this.mOffsetPitch = r101;
        goto L88
    L17:
        if (r100 != 128) goto L19;
        this.mDidGetInitialModelMatrix = false;
        if (r101 == 0) goto L97;
        TouchDirector r103 = this.mTouchDirector;
        if (r103 == null) goto L98;
        r103.reset();
        return;
    L98:
        return;
    L97:
        return;
    L19:
        if (r100 == 129) goto L43;
        switch(r100) {
            case 137: goto L29;
            case 138: goto L28;
            case 139: goto L22;
            default: goto L88;
        };
    L22:
        TouchScaler r104 = this.mTouchScaler;
        if (r104 != null) goto L25;
        return;
    L25:
        if (this.mEnableTouchScaler == false) goto L91;
        r104.stop();
        this.mTouchScaler.start();
        return;
    L91:
        return;
    L28:
        this.mSpaceOrientationPitch = r101;
        goto L88
    L29:
        this.mFreezeDirector = r101;
        if (r101 != 0) goto L33;
        handleDirectModeChange();
        return;
    L33:
        if (r101 == 1) goto L35;
        if (r101 == 2) goto L35;
        return;
    L35:
        IDirector r105 = this.mSensorDirector;
        if (r105 == null) goto L38;
        r105.stop();
    L38:
        if (r101 != 2) goto L94;
        VideoSurfaceTexture r106 = this.mSurfaceTexture;
        if (r106 == null) goto L95;
        r106.unRegisterTouchListener(this.mTouchDirector);
        return;
    L95:
        return;
    L94:
        return;
    L43:
        if (r101 == 0) goto L46;
        r102 = true;
    L46:
        this.mSensorDirectorEnabled = r102;
        if (r102 == true) goto L96;
        this.mFreezeModelMatrix = this.mModelMatrix;
        return;
    L96:
        return;
    L59:
        if (this.mSensorDirector == null) goto L88;
        if (r101 != 1) goto L65;
        OrientationEventHandler r107 = this.mOrientationEventHandler;
        if (r107 == null) goto L64;
        r107.disable();
    L64:
        this.mSensorDirector.stop();
        goto L88
    L65:
        OrientationEventHandler r108 = this.mOrientationEventHandler;
        if (r108 == null) goto L68;
        r108.enable();
    L68:
        startSensorDirector();
        goto L88
    L76:
        if (this.mSensorDirector == null) goto L88;
        if (r101 != 3) goto L83;
        OrientationEventHandler r109 = this.mOrientationEventHandler;
        if (r109 == null) goto L82;
        r109.disable();
    L82:
        this.mSensorDirector.stop();
        this.mSensorDirector.reset();
        this.mTouchDirector.stop();
        this.mTouchDirector.reset();
        this.mTouchScaler.stop();
        this.mFreezeDirector = 0;
        goto L88
    L83:
        if (r101 != 1) goto L88;
        OrientationEventHandler r110 = this.mOrientationEventHandler;
        if (r110 == null) goto L87;
        r110.enable();
    L87:
        startSensorDirector();
        this.mTouchDirector.start();
        this.mTouchScaler.start();
        goto L88
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture r210, FrameBuffer r211) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "handleModlelChange mVideoStyle:" + this.mVideoStyle);
        float r100 = 2.0f;
        int r101 = 6;
        if (this.mVideoStyle == 1) goto L83;
        int r102 = this.mVRModel;
        if (r102 == 1) goto L27;
        if (r102 == 3) goto L27;
        if (r102 == 6) goto L27;
        if (r102 == 2) goto L14;
        if (r102 == 4) goto L14;
        if (r102 == 5) goto L14;
        int r103 = 0;
        short[] r104 = null;
        float[][] r105 = null;
        float[] r110 = null;
    L87:
        if (r105 == null) goto L97;
        FloatBuffer r106 = ByteBuffer.allocateDirect(r105[r103].length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVertices = r106;
        if (r106 == null) goto L91;
        r106.put(r105[r103]).position(r103);
    L91:
        float[] r107 = r105[1];
        if (r107 == null) goto L96;
        FloatBuffer r108 = ByteBuffer.allocateDirect(r107.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVerticesRight = r108;
        if (r108 == null) goto L97;
        r108.put(r105[1]).position(0);
        goto L97
    L96:
        this.mTextureVerticesRight = null;
    L97:
        if (r110 == null) goto L101;
        FloatBuffer r109 = ByteBuffer.allocateDirect(r110.length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTriangleVertices = r109;
        if (r109 == null) goto L101;
        r109.put(r110).position(0);
    L101:
        if (r104 == null) goto L103;
        ShortBuffer r111 = ByteBuffer.allocateDirect(r104.length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.mIndexBuffers = r111;
        r111.put(r104).position(0);
        return 0;
    L103:
        return 0;
    L14:
        float[] r112 = {-1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, 1.0f, 1.0f, -1.0f, 1.0f, 1.0f, -1.0f, -1.0f, 1.0f, 1.0f, -1.0f, 1.0f, -1.0f, -1.0f, -1.0f, 1.0f, -1.0f, -1.0f};
        r104 = new short[]{0, 1, 2, 1, 2, 3, 4, 5, 6, 5, 6, 7, 8, 9, 10, 9, 10, 11, 12, 13, 14, 13, 14, 15, 16, 17, 18, 17, 18, 19, 20, 21, 22, 21, 22, 23};
        r105 = new float[2][];
        if (r102 != 5) goto L19;
        float r113 = this.mCMPFaceInnerPadding;
        float r114 = 0.16666667f;
        float r115 = 0.16666667f - (0.33333334f * r113);
        float r116 = 0.25f - (r113 * 0.5f);
        r105[0] = new float[48];
        int r117 = 0;
    L17:
        if (r117 >= r101) goto L25;
        int r118 = r117 * 8;
        float r119 = (((r117 % 3) * 2) + 1) * r114;
        float r120 = (((r117 / 3) * 2) + 1) * 0.25f;
        float[] r121 = r105[0];
        float r122 = r119 - r115;
        r121[r118 + 0] = r122;
        float r212 = r120 - r116;
        r121[r118 + 1] = r212;
        float r123 = r119 + r115;
        r121[r118 + 2] = r123;
        r121[r118 + 3] = r212;
        r121[r118 + 4] = r122;
        float r124 = r120 + r116;
        r121[r118 + 5] = r124;
        r121[r118 + 6] = r123;
        r121[r118 + 7] = r124;
        r117 = r117 + 1;
        r101 = 6;
        r114 = 0.16666667f;
    L25:
        r110 = r112;
    L26:
        r103 = 0;
        goto L87
    L19:
        if (r102 != 4) goto L22;
        r105[0] = new float[]{0.0f, 0.0f, 0.33333334f, 0.0f, 0.0f, 0.5f, 0.33333334f, 0.5f, 0.33333334f, 0.0f, 0.6666667f, 0.0f, 0.33333334f, 0.5f, 0.6666667f, 0.5f, 0.6666667f, 0.0f, 1.0f, 0.0f, 0.6666667f, 0.5f, 1.0f, 0.5f, 0.0f, 1.0f, 0.0f, 0.5f, 0.33333334f, 1.0f, 0.33333334f, 0.5f, 0.6666667f, 0.5f, 0.6666667f, 1.0f, 0.33333334f, 0.5f, 0.33333334f, 1.0f, 0.6666667f, 1.0f, 0.6666667f, 0.5f, 1.0f, 1.0f, 1.0f, 0.5f};
        goto L25
    L22:
        if (this.mViewSize != 360) goto L24;
        r105[0] = new float[]{0.0f, 0.5f, 0.33333334f, 0.5f, 0.0f, 1.0f, 0.33333334f, 1.0f, 0.33333334f, 0.5f, 0.6666667f, 0.5f, 0.33333334f, 1.0f, 0.6666667f, 1.0f, 0.6666667f, 0.5f, 1.0f, 0.5f, 0.6666667f, 1.0f, 1.0f, 1.0f, 1.0f, 0.0f, 1.0f, 0.5f, 0.6666667f, 0.0f, 0.6666667f, 0.5f, 0.33333334f, 0.5f, 0.33333334f, 0.0f, 0.6666667f, 0.5f, 0.6666667f, 0.0f, 0.33333334f, 0.0f, 0.33333334f, 0.5f, 0.0f, 0.0f, 0.0f, 0.5f};
        goto L25
    L24:
        r105[0] = new float[]{-0.16666667f, 0.0f, 0.16666667f, 0.0f, -0.16666667f, 1.0f, 0.16666667f, 1.0f, 0.16666667f, 0.0f, 0.5f, 0.0f, 0.16666667f, 1.0f, 0.5f, 1.0f, 0.5f, 0.0f, 0.8333333f, 0.0f, 0.5f, 1.0f, 0.8333333f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.6666667f, 0.0f, 0.6666667f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.6666667f, 0.0f, 0.6666667f, 1.0f, 1.0f, 0.0f, 1.0f, 1.0f, 0.6666667f, 0.0f, 0.6666667f, 1.0f};
    L27:
        int r125 = this.mDesireViewSize;
        int r126 = (int) ((((double) r125) * 150.0d) / 360.0d);
        float r127 = (float) (((double) (r125 / 180)) * 3.141592653589793d);
        float r128 = 1.0f / 75;
        float r129 = 1.0f / r126;
        int r130 = r126 + 1;
        short r131 = 76;
        int r132 = 76 * r130;
        float[] r133 = new float[r132 * 3];
        short[] r134 = new short[r132 * 6];
        short r135 = 0;
        int r213 = 0;
    L28:
        if (r135 >= r131) goto L33;
        float r214 = r128;
        double r136 = (r135 * 3.1415927f) * r128;
        float r137 = (float) Math.cos(r136);
        float r138 = (float) Math.sin(r136);
        short r139 = 0;
    L30:
        if (r139 >= r130) goto L32;
        double r140 = (3.1415927f - (r127 / r100)) + ((r139 * r127) * r129);
        float[] r215 = r133;
        double r141 = r138;
        float r142 = -((float) (Math.sin(r140) * r141));
        float r143 = (float) (Math.cos(r140) * r141);
        int r144 = r213 + 1;
        float r145 = mRadius;
        r215[r213] = r142 * r145;
        int r146 = r144 + 1;
        r215[r144] = r137 * r145;
        r213 = r146 + 1;
        r215[r146] = r143 * r145;
        r139 = (short) (r139 + 1);
        r133 = r215;
        r134 = r134;
        r100 = 2.0f;
        goto L30
    L32:
        r135 = (short) (r135 + 1);
        r128 = r214;
        r131 = 76;
        r100 = 2.0f;
        goto L28
    L33:
        float r216 = r128;
        float[] r217 = r133;
        short[] r218 = r134;
        int r147 = 2;
        int r148 = r132 * 2;
        r105 = new float[][]{new float[r148], null};
        short r149 = 0;
        int r150 = 0;
        int r151 = 0;
    L34:
        if (r149 >= 76) goto L73;
        short r152 = 0;
    L36:
        if (r152 >= r130) goto L72;
        int r153 = this.mVideoStyle;
        if (r153 != r147) goto L40;
        int r154 = r150 + 1;
        r105[0][r150] = r152 * r129;
        if (DeviceManager.isVRDevice() == false) goto L70;
        r105[0][r154] = r149 * r216;
        r150 = r154 + 1;
    L71:
        r152 = (short) (r152 + 1);
        r147 = 2;
        goto L36
    L70:
        r105[0][r154] = 1.0f - (r149 * r216);
        r150 = r154 + 1;
        goto L71
    L40:
        if (r153 != 3) goto L42;
        int r155 = r150 + 1;
        float r156 = r152 * r129;
        r105[0][r150] = r156;
        if (DeviceManager.isVRDevice() == false) goto L59;
        int r157 = r155 + 1;
        r105[0][r155] = r149 * r216;
    L61:
        if (r105[1] != null) goto L63;
        r105[1] = new float[r148];
    L63:
        int r158 = r151 + 1;
        r105[1][r151] = r156;
        if (DeviceManager.isVRDevice() == false) goto L66;
        r151 = r158 + 1;
        r105[1][r158] = r149 * r216;
        r150 = r157;
        goto L71
    L66:
        r105[1][r158] = 0.5f - ((r149 * r216) * 0.5f);
        r151 = r158 + 1;
        r150 = r157;
        goto L71
    L59:
        r157 = r155 + 1;
        r105[0][r155] = 1.0f - ((r149 * r216) * 0.5f);
        goto L61
    L42:
        if (r153 != 4) goto L71;
        if (DeviceManager.isVRDevice() == false) goto L48;
        float[] r159 = r105[0];
        int r160 = r150 + 1;
        r159[r150] = r152 * r129;
        r150 = r160 + 1;
        r159[r160] = r149 * r216;
    L50:
        if (r105[1] != null) goto L53;
        r105[1] = new float[r148];
    L53:
        if (DeviceManager.isVRDevice() == false) goto L55;
        float[] r161 = r105[1];
        int r162 = r151 + 1;
        r161[r151] = r152 * r129;
        r151 = r162 + 1;
        r161[r162] = r149 * r216;
        goto L71
    L55:
        float[] r163 = r105[1];
        int r164 = r151 + 1;
        r163[r151] = ((r152 * r129) * 0.5f) + 0.5f;
        r151 = r164 + 1;
        r163[r164] = 1.0f - (r149 * r216);
        goto L71
    L48:
        float[] r165 = r105[0];
        int r166 = r150 + 1;
        r165[r150] = (r152 * r129) * 0.5f;
        r150 = r166 + 1;
        r165[r166] = 1.0f - (r149 * r216);
        goto L50
    L72:
        r149 = (short) (r149 + 1);
        r147 = 2;
        goto L34
    L73:
        short r167 = 0;
        int r168 = 0;
    L74:
        if (r167 >= 75) goto L80;
        short r169 = 0;
    L76:
        if (r169 >= r126) goto L78;
        int r170 = r168 + 1;
        int r171 = r167 * r130;
        r218[r168] = (short) (r171 + r169);
        int r172 = r170 + 1;
        int r173 = (r167 + 1) * r130;
        short r174 = (short) (r173 + r169);
        r218[r170] = r174;
        int r175 = r172 + 1;
        int r176 = r169 + 1;
        short r177 = (short) (r171 + r176);
        r218[r172] = r177;
        int r178 = r175 + 1;
        r218[r175] = r177;
        int r179 = r178 + 1;
        r218[r178] = r174;
        r168 = r179 + 1;
        r218[r179] = (short) (r173 + r176);
        r169 = (short) r176;
        goto L76
    L78:
        r167 = (short) (r167 + 1);
        goto L74
    L80:
        if (this.mVRModel != 3) goto L82;
        this.mCubeTexOffsetPerFace = new float[]{0.0f, 0.0f, 0.33333334f, 0.0f, 0.6666667f, 0.0f, 0.0f, 0.5f, 0.33333334f, 0.5f, 0.6666667f, 0.5f};
        this.mCubeRotatesPerFace = new float[]{1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f, 1.0f, -1.0f, 0.0f, 0.0f, -1.0f, 1.0f, 0.0f, 0.0f, 1.0f, -1.0f, 0.0f};
    L82:
        r110 = r217;
        r104 = r218;
        goto L26
    L83:
        if (r210 != null) goto L86;
        return -1;
    L86:
        float r180 = (float) (((double) mRadius) * Math.tan(((double) (((this.mPerspecView - 15.0f) / 2.0f) / 180.0f)) * 3.141592653589793d));
        float r181 = (r210.getWidth() * r180) / r210.getHeight();
        float r182 = -r181;
        float r183 = -r180;
        float r184 = mRadius;
        float[] r185 = {r182, r183, -r184, r181, r183, -r184, r182, r180, -r184, r181, r180, -r184};
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "triangle ver:" + Arrays.toString(GLDefaultFilter.mTriangleVerticesData));
        float[][] r186 = new float[2][];
        r103 = 0;
        r186[0] = new float[]{0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 1.0f, 1.0f, 1.0f};
        r105 = r186;
        r110 = r185;
        r104 = new short[]{0, 1, 2, 1, 2, 3};
        goto L87
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(int r100, float r101) {
        if (r100 != 103) goto L5;
        this.mPerspecView = r101;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "perspective view:" + r101);
        return;
    L5:
        if (r100 != 104) goto L7;
        this.mHalfEyeDistance = r101 / 2.0f;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "eye disfance:" + r101);
        return;
    L7:
        if (r100 != 111) goto L9;
        this.mZOffset = r101;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set zoffset:" + r101);
        return;
    L9:
        if (r100 == 164) goto L11;
        super.setOption(r100, r101);
        return;
    L11:
        this.mOutTextureScale = r101;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "set textureScale:" + r101);
    }

    private void updateMesh(int r110, float r111, float r112, float r113, float r210, float r211, float r212, float r213, float r214) {
        if (r110 != LEFT) goto L5;
        float r100 = 0.0f;
    L6:
        int r101 = 0;
    L7:
        int r102 = RESOLUTION;
        if (r101 >= r102) goto L14;
        float r103 = (r101 * 1.0f) / (r102 - 1);
        int r104 = 0;
    L10:
        int r105 = RESOLUTION;
        if (r104 >= r105) goto L13;
        float r114 = (r104 * 1.0f) / (r105 - 1);
        float[] r106 = this.mDistortion.distortInverse((r114 * r211) - r213, (r103 * r212) - r214);
        float r115 = (r106[0] + r113) / r111;
        float r107 = (r106[1] + r210) / r112;
        int r116 = ((RESOLUTION * r101) + r104) * 2;
        float[] r117 = this.mDistortionPos[r110];
        r117[r116] = (r115 * 2.0f) - 1.0f;
        int r118 = r116 + 1;
        r117[r118] = (r107 * 2.0f) - 1.0f;
        float[] r108 = this.mDistortionTex[r110];
        r108[r116] = (r114 / 2.0f) + r100;
        r108[r118] = r103;
        r104 = r104 + 1;
        goto L10
    L13:
        r101 = r101 + 1;
        goto L7
    L14:
        int r109 = 0;
        int r119 = 0;
        int r120 = 0;
    L16:
        if (r109 >= (RESOLUTION - 1)) goto L29;
        if (r109 <= 0) goto L19;
        short[] r121 = this.mDistortionIndex[r110];
        r121[r119] = r121[r119 - 1];
        r119 = r119 + 1;
    L19:
        int r122 = 0;
    L20:
        int r123 = RESOLUTION;
        if (r122 >= r123) goto L28;
        if (r122 <= 0) goto L27;
        if ((r109 % 2) != 0) goto L26;
        r120 = r120 + 1;
        goto L27
    L26:
        r120 = r120 - 1;
    L27:
        short[] r124 = this.mDistortionIndex[r110];
        int r125 = r119 + 1;
        r124[r119] = (short) r120;
        r119 = r125 + 1;
        r124[r125] = (short) (r123 + r120);
        r122 = r122 + 1;
        goto L20
    L28:
        r120 = r120 + r123;
        r109 = r109 + 1;
        goto L16
    L29:
        this.mDistortionTriangleBuffer[r110] = ByteBuffer.allocateDirect(this.mDistortionPos[r110].length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mDistortionTriangleBuffer[r110].put(this.mDistortionPos[r110]).position(0);
        this.mDistortionTextureBuffer[r110] = ByteBuffer.allocateDirect(this.mDistortionTex[r110].length * 4).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mDistortionTextureBuffer[r110].put(this.mDistortionTex[r110]).position(0);
        this.mDistortionIndexBuffer[r110] = ByteBuffer.allocateDirect(this.mDistortionIndex[r110].length * 2).order(ByteOrder.nativeOrder()).asShortBuffer();
        this.mDistortionIndexBuffer[r110].put(this.mDistortionIndex[r110]).position(0);
        return;
    L5:
        r100 = 0.5f;
        goto L6
    }
}
