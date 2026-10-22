package com.ss.texturerender.effect;

import android.graphics.Bitmap;
import android.opengl.GLES20;
import android.opengl.GLUtils;
import android.opengl.Matrix;
import android.os.Bundle;
import androidx.profileinstaller.ProfileVerifier;
import com.ss.texturerender.TexGLUtils;
import com.ss.texturerender.TextureRenderKeys;
import com.ss.texturerender.TextureRenderLog;
import com.ss.texturerender.VideoSurface;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.FloatBuffer;

/* JADX INFO: loaded from: classes40.dex */
public class GLAnimationFilter extends GLDefaultFilter {
    private static final int NOTIFY_OPENGL_ANIMATION_ANGLE_AND_SHOW_ORIGIN_ICON = 6;
    private static final int NOTITFY_OPENGL_ANIMATION_CURRENT_ANGLE_WHEN_USER_PAUSE = 3;
    private static final int NOTITFY_OPENGL_ANIMATION_PAUSE_WHEN_USER_SCROLL_START = 4;
    private static final int NOTITFY_OPENGL_ANIMATION_POSITION_CHANGED_OK = 2;
    private static final int NOTITFY_OPENGL_ANIMATION_RESUME_RUNNING_FROM_PAUSE = 5;
    private static final int NOTITFY_OPENGL_ANIMATION_START = 1;
    private static final int PAUSE_MODE_WHEN_LEAVE_CLEAN_WHEN_PAUSE = 5;
    private static final int PAUSE_MODE_WHEN_USER_PAUSE_PHASE1 = 1;
    private static final int PAUSE_MODE_WHEN_USER_PAUSE_PHASE2 = 3;
    private static final int PAUSE_MODE_WHEN_USER_SCROLL_PHASE1 = 2;
    private static final int PAUSE_MODE_WHEN_USER_SCROLL_PHASE2 = 4;
    private int mAlphaUniformHandle;
    private float mCurrentRotationAngle;
    private EffectTexture mEffectTexture;
    private final String mFragmentShaderSourceCode;
    private boolean mIsInitProjectViewMatrix;
    private boolean mIsPlatePositionChanged;
    private boolean mIsStopAnimation;
    private boolean mIsSwitchToRunningStatue;
    private float[] mLocalTextureVerticesData;
    private final float[] mModelMatrix;
    private int mPauseMode;
    float[] mProjectionViewMatrix;
    private float mRoatePlateBitmapScaleRatio;
    private float mRoatePlateXPosScaleRatio;
    private float mRoatePlateYPosScaleRatio;
    private Bitmap mRotateAnimationBitmap;
    private VideoSurface.NotifyUIAnimationState mRotatePlateAnimationStateCallback;
    private int mRotationSpeed;
    private final String mVertexShaderSourceCode;
    private int mvpMatrixHandle;

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameAfter() {
        GLES20.glDisable(3042);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int onDrawFrameBefore() {
        GLES20.glEnable(3042);
        GLES20.glBlendFunc(770, 771);
        Matrix.setIdentityM(this.mModelMatrix, 0);
        Matrix.translateM(this.mModelMatrix, 0, this.mRoatePlateXPosScaleRatio, -this.mRoatePlateYPosScaleRatio, 0.0f);
        float r100 = ((this.mCurrentRotationAngle - (this.mRotationSpeed * 0.75f)) + 360.0f) % 360.0f;
        this.mCurrentRotationAngle = r100;
        Matrix.rotateM(this.mModelMatrix, 0, r100, 0.0f, 0.0f, 1.0f);
        float[] r101 = this.mModelMatrix;
        float r102 = this.mRoatePlateBitmapScaleRatio;
        Matrix.scaleM(r101, 0, r102, r102, r102);
        float[] r103 = new float[16];
        Matrix.setIdentityM(r103, 0);
        Matrix.multiplyMM(r103, 0, this.mProjectionViewMatrix, 0, this.mModelMatrix, 0);
        GLES20.glUniformMatrix4fv(this.mvpMatrixHandle, 1, false, r103, 0);
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public AbsEffect release() {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "release");
        super.release();
        EffectTexture r100 = this.mEffectTexture;
        if (r100 == null) goto L5;
        TexGLUtils.deleteTexture(r100.getTexID());
        this.mEffectTexture = null;
    L5:
        this.mRotateAnimationBitmap = null;
        this.mRoatePlateBitmapScaleRatio = -1.0f;
        this.mRoatePlateXPosScaleRatio = -1.0f;
        this.mRoatePlateYPosScaleRatio = -1.0f;
        this.mRotatePlateAnimationStateCallback = null;
        this.mIsInitProjectViewMatrix = false;
        this.mIsStopAnimation = true;
        return super.release();
    }

    public GLAnimationFilter(int r100) {
        super(r100, 29);
        this.mVertexShaderSourceCode = "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
        this.mFragmentShaderSourceCode = "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    vec4 texColor = texture2D(sTexture, vTextureCoord);\n    gl_FragColor = vec4(texColor.rgb, texColor.a);\n}\n";
        this.mModelMatrix = new float[16];
        this.mProjectionViewMatrix = new float[16];
        this.mRotateAnimationBitmap = null;
        this.mRoatePlateBitmapScaleRatio = -1.0f;
        this.mRoatePlateXPosScaleRatio = -1.0f;
        this.mRoatePlateYPosScaleRatio = -1.0f;
        this.mRotationSpeed = 1;
        this.mPauseMode = 0;
        this.mRotatePlateAnimationStateCallback = null;
        this.mLocalTextureVerticesData = new float[]{0.0f, 1.0f, 1.0f, 1.0f, 0.0f, 0.0f, 1.0f, 0.0f};
        this.mIsInitProjectViewMatrix = false;
        this.mCurrentRotationAngle = 0.0f;
        this.mIsStopAnimation = true;
        this.mIsPlatePositionChanged = false;
        this.mIsSwitchToRunningStatue = false;
        this.mOrder = 9;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "new GLAnimationFilter");
    }

    private void updateParametersFromBundle(Bundle r100) {
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "updateParametersFromBundle, bundle = " + r100);
        if (r100.containsKey(TextureRenderKeys.KEY_IS_ROTATION_PLATE_BITMAP) == false) goto L6;
        this.mRotateAnimationBitmap = (Bitmap) r100.getParcelable(TextureRenderKeys.KEY_IS_ROTATION_PLATE_BITMAP);
    L6:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_ROTATION_PLATE_BITMAP_SCALE_RATIO) == false) goto L15;
        float r101 = r100.getFloat(TextureRenderKeys.KEY_IS_ROTATION_PLATE_BITMAP_SCALE_RATIO);
        if (r101 == 0.0f) goto L17;
        if (this.mRotateAnimationBitmap == null) goto L12;
    L14:
        this.mRoatePlateBitmapScaleRatio = r101;
        goto L17
    L12:
        if (Float.compare(this.mRoatePlateBitmapScaleRatio, r101) == 0) goto L14;
        this.mIsPlatePositionChanged = true;
    L17:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_ROTATION_PLATE_XPOS_SCALE_RATIO) == false) goto L26;
        float r102 = r100.getFloat(TextureRenderKeys.KEY_IS_ROTATION_PLATE_XPOS_SCALE_RATIO);
        if (r102 == 0.0f) goto L28;
        if (this.mRotateAnimationBitmap == null) goto L23;
    L25:
        this.mRoatePlateXPosScaleRatio = r102;
        goto L28
    L23:
        if (Float.compare(this.mRoatePlateXPosScaleRatio, r102) == 0) goto L25;
        this.mIsPlatePositionChanged = true;
    L28:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_ROTATION_PLATE_YPOS_SCALE_RATIO) == false) goto L37;
        float r103 = r100.getFloat(TextureRenderKeys.KEY_IS_ROTATION_PLATE_YPOS_SCALE_RATIO);
        if (r103 == 0.0f) goto L39;
        if (this.mRotateAnimationBitmap == null) goto L34;
    L36:
        this.mRoatePlateYPosScaleRatio = r103;
        goto L39
    L34:
        if (Float.compare(this.mRoatePlateYPosScaleRatio, r103) == 0) goto L36;
        this.mIsPlatePositionChanged = true;
    L39:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_ROTATION_PLATE_ANIMATION_STATE_CALLBACK) == false) goto L42;
        this.mRotatePlateAnimationStateCallback = (VideoSurface.NotifyUIAnimationState) r100.getSerializable(TextureRenderKeys.KEY_IS_ROTATION_PLATE_ANIMATION_STATE_CALLBACK);
    L42:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_ROTATION_PLATE_ALPHA_CHANGE_TIMES) == false) goto L45;
        this.mPauseMode = ((Integer) r100.getSerializable(TextureRenderKeys.KEY_IS_ROTATION_PLATE_ALPHA_CHANGE_TIMES)).intValue();
    L45:
        if (r100.containsKey(TextureRenderKeys.KEY_IS_ROTATION_PLATE_SPEED) == false) goto L48;
        this.mRotationSpeed = ((Integer) r100.getSerializable(TextureRenderKeys.KEY_IS_ROTATION_PLATE_SPEED)).intValue();
    L48:
        if (this.mIsPlatePositionChanged == false) goto L51;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "updateParametersFromBundle, plate animation position changed, newXPosRatio = " + r102 + ", newYPosRatio = " + r103 + ", newScaleRatio = " + r101 + " mRotateAnimationBitmap = " + this.mRotateAnimationBitmap);
    L51:
        if (this.mRotateAnimationBitmap == null) goto L53;
    L83:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "updateParametersFromBundle, mIsStopAnimation = " + this.mIsStopAnimation + ", mRotateAnimationBitmap = " + this.mRotateAnimationBitmap);
        if (this.mIsStopAnimation == false) goto L98;
        this.mIsStopAnimation = false;
        if (this.mRotateAnimationBitmap != null) goto L99;
        this.mIsSwitchToRunningStatue = true;
        return;
    L99:
        return;
    L98:
        return;
    L53:
        if (r102 != 0.0f) goto L83;
        if (r103 != 0.0f) goto L83;
        if (r101 != 0.0f) goto L83;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "updateParametersFromBundle, mPauseMode = " + this.mPauseMode + ", mIsStopAnimation = " + this.mIsStopAnimation);
        int r104 = this.mPauseMode;
        if (r104 != 0) goto L62;
        this.mIsStopAnimation = true;
        this.mRoatePlateXPosScaleRatio = -1.0f;
        this.mRoatePlateYPosScaleRatio = -1.0f;
        this.mRoatePlateBitmapScaleRatio = -1.0f;
        return;
    L62:
        if (this.mIsStopAnimation == true) goto L79;
        if (r104 != 1) goto L65;
        VideoSurface.NotifyUIAnimationState r105 = this.mRotatePlateAnimationStateCallback;
        if (r105 == null) goto L93;
        r105.onAnimationState(((int) this.mCurrentRotationAngle) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_CANT_WRITE_PROFILE_VERIFICATION_RESULT_CACHE_FILE);
        return;
    L93:
        return;
    L65:
        if (r104 != 2) goto L67;
        VideoSurface.NotifyUIAnimationState r106 = this.mRotatePlateAnimationStateCallback;
        if (r106 == null) goto L91;
        r106.onAnimationState(((int) this.mCurrentRotationAngle) | 262144);
        return;
    L91:
        return;
    L67:
        if (r104 != 3) goto L69;
    L71:
        this.mIsStopAnimation = true;
        return;
    L69:
        if (r104 == 4) goto L71;
        return;
    L79:
        if (r104 != 5) goto L95;
        VideoSurface.NotifyUIAnimationState r107 = this.mRotatePlateAnimationStateCallback;
        if (r107 == null) goto L96;
        r107.onAnimationState(((int) this.mCurrentRotationAngle) | 393216);
        return;
    L96:
        return;
    L95:
        return;
    L37:
        r103 = 0.0f;
        goto L39
    L26:
        r102 = 0.0f;
        goto L28
    L15:
        r101 = 0.0f;
        goto L17
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public String getStringOption(int r100) {
        if (r100 != 11000) goto L5;
        return "attribute vec4 aPosition;\nattribute vec4 aTextureCoord;\nvarying vec2 vTextureCoord;\nuniform mat4 uMVPMatrix;\nvoid main() {\n  gl_Position = uMVPMatrix * aPosition;\n  vTextureCoord = aTextureCoord.xy;\n}\n";
    L5:
        if (r100 != 11001) goto L7;
        return "precision mediump float;\nvarying vec2 vTextureCoord;\nuniform sampler2D sTexture;\nvoid main() {\n    vec4 texColor = texture2D(sTexture, vTextureCoord);\n    gl_FragColor = vec4(texColor.rgb, texColor.a);\n}\n";
    L7:
        return super.getStringOption(r100);
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public int init(Bundle r100) {
        int r101 = super.init(r100);
        if (r101 == 0) goto L5;
        return r101;
    L5:
        FloatBuffer r102 = ByteBuffer.allocateDirect(this.mLocalTextureVerticesData.length * this.FLOAT_SIZE_BYTES).order(ByteOrder.nativeOrder()).asFloatBuffer();
        this.mTextureVertices = r102;
        r102.put(this.mLocalTextureVerticesData).position(0);
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init, bundle = " + r100);
        updateParametersFromBundle(r100);
        if (this.mvpMatrixHandle != 0) goto L8;
        this.mvpMatrixHandle = GLES20.glGetUniformLocation(this.mProgram, "uMVPMatrix");
    L8:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "init success");
        return 0;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public void setOption(Bundle r100) {
        if (r100 == null) goto L5;
        updateParametersFromBundle(r100);
        return;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter, com.ss.texturerender.effect.AbsEffect
    public EffectTexture process(EffectTexture r110, FrameBuffer r111) {
        if (r110 == null) goto L36;
        if (r111 == null) goto L36;
        if (this.mIsStopAnimation == true) goto L36;
        this.mViewPortWidth = r110.getWidth();
        this.mViewPortHeight = r110.getHeight();
        if (this.mRotateAnimationBitmap == null) goto L17;
        EffectTexture r100 = this.mEffectTexture;
        if (r100 == null) goto L12;
        TexGLUtils.deleteTexture(r100.getTexID());
        this.mEffectTexture = null;
    L12:
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process, use new bitmap, mRotatePlateAnimationBitmap = " + this.mRotateAnimationBitmap + ", viewportWidth = " + r110.getWidth() + ", viewportHeight = " + r110.getHeight() + ", bitmap width = " + this.mRotateAnimationBitmap.getWidth() + ", bitmap height = " + this.mRotateAnimationBitmap.getHeight());
        Bitmap r101 = this.mRotateAnimationBitmap;
        this.mRotateAnimationBitmap = null;
        this.mCurrentRotationAngle = 0.0f;
        if (this.mRotatePlateAnimationStateCallback == null) goto L15;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process, notify starting drawing animation");
        this.mRotatePlateAnimationStateCallback.onAnimationState(((int) this.mCurrentRotationAngle) | 65536);
    L15:
        this.mIsSwitchToRunningStatue = false;
        this.mIsPlatePositionChanged = false;
        this.mIsInitProjectViewMatrix = false;
    L30:
        if (this.mEffectTexture != null) goto L34;
        if (r101 == null) goto L34;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process, create new effect texture");
        int r102 = TexGLUtils.genTexture(3553);
        GLES20.glBindTexture(3553, r102);
        GLES20.glTexParameteri(3553, 10241, 9728);
        GLES20.glTexParameteri(3553, 10240, 9728);
        GLUtils.texImage2D(3553, 0, r101, 0);
        GLES20.glBindTexture(3553, 0);
        this.mEffectTexture = new EffectTexture(null, r102, r101.getWidth(), r101.getHeight(), 3553, null);
    L34:
        if (this.mEffectTexture == null) goto L36;
        r111.bindTexture2D(r110.getTexID());
        this.mNeedClear = false;
        super.process(this.mEffectTexture, null);
        r111.unbindTexture2D();
        goto L36
    L17:
        if (this.mIsSwitchToRunningStatue == false) goto L23;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process, switch from pause to running");
        VideoSurface.NotifyUIAnimationState r103 = this.mRotatePlateAnimationStateCallback;
        if (r103 == null) goto L21;
        r103.onAnimationState(((int) this.mCurrentRotationAngle) | ProfileVerifier.CompilationStatus.RESULT_CODE_ERROR_NO_PROFILE_EMBEDDED);
    L21:
        this.mIsSwitchToRunningStatue = false;
    L28:
        r101 = null;
        goto L30
    L23:
        if (this.mIsPlatePositionChanged == false) goto L28;
        TextureRenderLog.i(this.mTexType, this.LOG_TAG, "process, plate icon position changed");
        VideoSurface.NotifyUIAnimationState r104 = this.mRotatePlateAnimationStateCallback;
        if (r104 == null) goto L27;
        r104.onAnimationState(((int) this.mCurrentRotationAngle) | 131072);
    L27:
        this.mIsPlatePositionChanged = false;
    L36:
        return r110;
    }

    @Override // com.ss.texturerender.effect.GLDefaultFilter
    public int updateRenderParam(EffectTexture r210, FrameBuffer r211) {
        if (this.mIsInitProjectViewMatrix == true) goto L13;
        float[] r110 = new float[16];
        Matrix.setIdentityM(r110, 0);
        Matrix.setLookAtM(r110, 0, 0.0f, 0.0f, 1.0f, 0.0f, 0.0f, 0.0f, 0.0f, 1.0f, 0.0f);
        float[] r100 = new float[16];
        int r101 = this.mViewPortWidth;
        int r102 = this.mViewPortHeight;
        if (r101 <= r102) goto L7;
        float r103 = r101;
        float r104 = r102;
    L8:
        float r105 = r103 / r104;
        if (r101 <= r102) goto L11;
        Matrix.orthoM(r100, 0, -r105, r105, -1.0f, 1.0f, 0.0f, 10.0f);
    L12:
        Matrix.setIdentityM(this.mProjectionViewMatrix, 0);
        Matrix.multiplyMM(this.mProjectionViewMatrix, 0, r100, 0, r110, 0);
        this.mIsInitProjectViewMatrix = true;
        goto L13
    L11:
        Matrix.orthoM(r100, 0, -1.0f, 1.0f, -r105, r105, 0.0f, 10.0f);
        goto L12
    L7:
        r103 = r102;
        r104 = r101;
    L13:
        return 0;
    }
}
