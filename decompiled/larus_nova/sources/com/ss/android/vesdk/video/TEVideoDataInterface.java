package com.ss.android.vesdk.video;

import android.graphics.SurfaceTexture;
import com.ss.android.ttve.nativePort.TENativeLibsLoader;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraFrameSetting;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.vesdk.TextureHolder;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.frame.TETextureCapturePipeline;
import com.ss.android.vesdk.frame.b;

/* JADX INFO: loaded from: classes40.dex */
public class TEVideoDataInterface {
    private static final String TAG = "TEVideoDataInterface";
    private TECameraFrameSetting mCameraFrameSetting;
    private b mCapturePipeline;
    private com.ss.android.vesdk.b<b> mCapturePipelines;
    private long mHandler;
    private SurfaceTexture mSurfaceTexture;
    private TextureHolder mTextureHolder;

    public class a implements b.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TEVideoDataInterface f455938a;

        @Override // com.ss.android.vesdk.frame.b.a
        public final void b(TEFrameSizei r100) {
        }

        public a(TEVideoDataInterface r100) {
            this.f455938a = r100;
        }

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        public final void onFrameCaptured(TECameraFrame r100) {
            r100.initTextureFrame(TEVideoDataInterface.access$000(this.f455938a).f455503a, 0, null, TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES, 0);
            TEVideoDataInterface.access$100(this.f455938a, r100);
            TEVideoDataInterface r101 = this.f455938a;
            TEVideoDataInterface.access$300(r101, TEVideoDataInterface.access$200(r101));
        }

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        public final void onNewSurfaceTexture(SurfaceTexture r100) {
            TEVideoDataInterface.access$402(this.f455938a, r100);
        }
    }

    private native void nativeCameraParam(long r100, TECameraFrameSetting r101);

    private native long nativeCreateVideoDataInterface();

    private native void nativeInit(long r100);

    private native void nativeNotifyFrameAvailable(long r100);

    private native void nativeReleaseVideoDataInterface(long r100);

    public void destroy() {
        this.mTextureHolder.d();     // Catch: Exception -> L4
    L6:
        this.mTextureHolder.f(true);
        long r100 = this.mHandler;
        if (r100 == 0) goto L12;
        nativeReleaseVideoDataInterface(r100);
        this.mHandler = 0;
        return;
    L12:
        return;
    L4:
        e = move-exception;
        VELogUtil.e(TAG, "detachFromGLContext error: " + e.getMessage());
        goto L6
    }

    public void onGLEnvInited() {
        TextureHolder r100 = this.mTextureHolder;
        r100.getClass();
        r100.f455503a = cfc.a.a();
        VELogUtil.i("TextureHolder", "createOESTexture mSurfaceTextureID = " + r100.f455503a);
    }

    public TEVideoDataInterface() {
        this.mHandler = 0;
        this.mTextureHolder = new TextureHolder();
        this.mCapturePipelines = new com.ss.android.vesdk.b();
        this.mHandler = nativeCreateVideoDataInterface();
    }

    public void getNextFrame() {
        SurfaceTexture r100 = this.mSurfaceTexture;
        TextureHolder r101 = this.mTextureHolder;
        SurfaceTexture r102 = r101.f455504b;
        if (r100 == r102) goto L15;
        if (r102 != null) goto L17;
    L9:
        this.mTextureHolder.f455504b = this.mSurfaceTexture;
        goto L15
    L17:
        r101.d();     // Catch: Exception -> L7
    L7:
        e = move-exception;
        VELogUtil.e(TAG, "detachFromGLContext error: " + e.getMessage());
    L15:
        TETextureCapturePipeline r103 = (TETextureCapturePipeline) this.mCapturePipeline;     // Catch: Exception -> L12
        TextureHolder r104 = this.mTextureHolder;     // Catch: Exception -> L12
        r103.f455827g = r104.f455503a;     // Catch: Exception -> L12
        r104.a();     // Catch: Exception -> L12
        this.mTextureHolder.g();     // Catch: Exception -> L12
        VELogUtil.d(TAG, "timestamp = " + this.mTextureHolder.e());     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        VELogUtil.e(TAG, "updateTexImage error: " + e.getMessage());
    }

    public long getTexImageTimeDelay() {
        return (long) (((System.nanoTime() / 1000000.0d) - this.mTextureHolder.e()) * 1000.0d);
    }

    static {
        TENativeLibsLoader.loadLibrary();
    }

    public TEVideoDataInterface(long r100) {
        this.mHandler = 0;
        this.mTextureHolder = new TextureHolder();
        this.mCapturePipelines = new com.ss.android.vesdk.b();
        this.mHandler = r100;
        nativeInit(r100);
    }

    public static /* synthetic */ TextureHolder access$000(TEVideoDataInterface r100) {
        return r100.mTextureHolder;
    }

    public static /* synthetic */ long access$200(TEVideoDataInterface r100) {
        return r100.mHandler;
    }

    private void setCameraParams(TECameraFrame r110) {
        int r100 = r110.getRotation();
        if (r110.getPixelFormat() != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES) goto L5;
        this.mCameraFrameSetting = new TECameraFrameSetting(this.mTextureHolder.f455503a, 0, r110.getSize().width, r110.getSize().height, r100, r110.getMVPMatrix(), 0, r110.getPixelFormat().ordinal(), 0);
    L5:
        long r101 = this.mHandler;
        if (r101 == 0) goto L9;
        nativeCameraParam(r101, this.mCameraFrameSetting);
        return;
    }

    public void setCapturePipeline(b r100) {
        this.mCapturePipeline = r100;
        r100.f455835c = new a(this);
    }

    public static /* synthetic */ void access$100(TEVideoDataInterface r100, TECameraFrame r101) {
        r100.setCameraParams(r101);
    }

    public static /* synthetic */ void access$300(TEVideoDataInterface r100, long r101) {
        r100.nativeNotifyFrameAvailable(r101);
    }

    public static /* synthetic */ SurfaceTexture access$402(TEVideoDataInterface r100, SurfaceTexture r101) {
        r100.mSurfaceTexture = r101;
        return r101;
    }
}
