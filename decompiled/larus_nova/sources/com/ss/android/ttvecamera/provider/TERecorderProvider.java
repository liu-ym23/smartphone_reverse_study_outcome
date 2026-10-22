package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.view.Surface;
import com.ss.android.ttvecamera.ICameraInstance;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TERecorderProvider extends TECameraProvider {
    private static final String TAG = "TERecorderProvider";
    private float[] mMVPMatrix;
    private Surface mPreviewSurface;
    private Surface mRecorderSurface;
    private SurfaceTexture mSurfaceTexture;
    int mTextureID;

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 16;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture r100, boolean r101) {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
        Surface r100 = this.mPreviewSurface;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        SurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L8;
        r101.release();
    L8:
        this.mSurfaceTexture = new SurfaceTexture(this.mTextureID);
        this.mPreviewSurface = new Surface(this.mSurfaceTexture);
        this.mListener.onNewSurfaceTexture(this.mSurfaceTexture);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        super.release();
        Surface r100 = this.mPreviewSurface;
        if (r100 == null) goto L5;
        r100.release();
        this.mPreviewSurface = null;
    L5:
        Surface r101 = this.mRecorderSurface;
        if (r101 == null) goto L9;
        r101.release();
        this.mRecorderSurface = null;
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getRecorderSurface() {
        return this.mRecorderSurface;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        return this.mPreviewSurface;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    public static /* synthetic */ float[] access$000(TERecorderProvider r100) {
        return r100.mMVPMatrix;
    }

    private void initOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r100) {
        this.mSurfaceTexture.setOnFrameAvailableListener(r100, this.mCamera.getHandler());
    }

    public TERecorderProvider(TECameraProviderManager.ProviderSettings r100, ICameraInstance r101) {
        super(r100, r101);
        this.mMVPMatrix = new float[16];
        this.mSurfaceTexture = r100.mSurfaceTexture;
        this.mTextureID = r100.mTextureOES;
        this.mPreviewSurface = new Surface(r100.mSurfaceTexture);
        this.mRecorderSurface = r100.mRecorderSurface;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> r100, TEFrameSizei r101) {
        if (r100 != null) goto L4;
    L6:
        SurfaceTexture r102 = this.mSurfaceTexture;
        TEFrameSizei r103 = this.mSize;
        r102.setDefaultBufferSize(r103.width, r103.height);
        initOnFrameAvailableListener(new AnonymousClass1(this));
        return 0;
    L4:
        if (r100.size() <= 0) goto L6;
        this.mSize = TECameraUtils.calcPreviewSize(r100, this.mSize, this.mCamera.getCameraSettings().mPreviewSizeStrategy);
        goto L6
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(StreamConfigurationMap r100, TEFrameSizei r101) {
        return init(TECameraProvider.convertSizes(r100.getOutputSizes(SurfaceTexture.class)), r101);
    }
}
