package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.ImageReader;
import android.view.Surface;
import com.ss.android.ttvecamera.ICameraInstance;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TEMultiCamera2Provider extends TECameraProvider {
    ImageReader[] mImageReaders;
    float[] mMVPMatrix;
    Surface[] mSurface;
    SurfaceTexture mSurfaceTexture;
    int mTextureID;

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 8;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        Surface[] r100 = this.mSurface;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100[0];
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getTextureID() {
        if (this.mSurfaceTexture == null) goto L6;
        return this.mTextureID;
    L6:
        return super.getTextureID();
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        super.release();
        ImageReader[] r100 = this.mImageReaders;
        if (r100 == null) goto L12;
        int r101 = r100.length;
        int r102 = 0;
    L5:
        if (r102 >= r101) goto L10;
        ImageReader r103 = r100[r102];
        if (r103 == null) goto L9;
        r103.close();
    L9:
        r102 = r102 + 1;
        goto L5
    L10:
        this.mImageReaders = null;
    L12:
        if (this.mSurfaceTexture == null) goto L22;
        Surface[] r104 = this.mSurface;
        if (r104 == null) goto L23;
        Surface r105 = r104[0];
        if (r105 == null) goto L24;
        r105.release();
        return;
    L24:
        return;
    L23:
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface[] getSurfaces() {
        return this.mSurface;
    }

    public TEMultiCamera2Provider(TECameraProviderManager.ProviderSettings r100, ICameraInstance r101) {
        super(r100, r101);
        this.mMVPMatrix = new float[16];
        SurfaceTexture r102 = r100.mSurfaceTexture;
        this.mSurfaceTexture = r102;
        this.mTextureID = r100.mTextureOES;
        int r103 = this.mImageReaderCount;
        this.mImageReaders = new ImageReader[r103];
        if (r102 == null) goto L5;
        r103 = r103 + 1;
    L5:
        Surface[] r104 = new Surface[r103];
        this.mSurface = r104;
        if (r102 == null) goto L9;
        r104[0] = new Surface(this.mSurfaceTexture);
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> r100, TEFrameSizei r101) {
        if (r100 != null) goto L4;
    L6:
        SurfaceTexture r102 = this.mSurfaceTexture;
        if (r102 == null) goto L9;
        TEFrameSizei r103 = this.mSize;
        r102.setDefaultBufferSize(r103.width, r103.height);
    L9:
        int r104 = 0;
    L11:
        if (r104 >= this.mImageReaderCount) goto L17;
        ImageReader[] r105 = this.mImageReaders;
        TEFrameSizei r106 = this.mSize;
        r105[r104] = ImageReader.newInstance(r106.width, r106.height, TECameraFrame.pixelFormat2ImageFormat(this.mFormat), 1);
        this.mImageReaders[r104].setOnImageAvailableListener(new AnonymousClass1(this), this.mCamera.getHandler());
        if (this.mSurfaceTexture == null) goto L15;
        this.mSurface[r104 + 1] = this.mImageReaders[r104].getSurface();
    L16:
        r104 = r104 + 1;
        goto L11
    L15:
        this.mSurface[r104] = this.mImageReaders[r104].getSurface();
        goto L16
    L17:
        return 0;
    L4:
        if (r100.size() <= 0) goto L6;
        this.mSize = TECameraUtils.calcPreviewSize(r100, this.mSize, this.mCamera.getCameraSettings().mPreviewSizeStrategy);
        goto L6
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture r100, boolean r101) {
        if (this.mSurfaceTexture != null) goto L5;
        return;
    L5:
        Surface[] r102 = this.mSurface;
        if (r102 == null) goto L10;
        Surface r103 = r102[0];
        if (r103 == null) goto L10;
        r103.release();
    L10:
        SurfaceTexture r104 = this.mSurfaceTexture;
        if (r104 == null) goto L13;
        r104.release();
    L13:
        this.mSurfaceTexture = r100;
        this.mSurface[0] = new Surface(this.mSurfaceTexture);
        TECameraProvider.CaptureListener r105 = this.mListener;
        if (r105 != null) goto L16;
        return;
    L16:
        if ((r105 instanceof TECameraProvider.CaptureListenerWithAR) == false) goto L20;
        ((TECameraProvider.CaptureListenerWithAR) r105).onNewSurfaceTexture(this.mSurfaceTexture, r101);
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(StreamConfigurationMap r100, TEFrameSizei r101) {
        int[] r102 = r100.getOutputFormats();
        int r103 = TECameraFrame.pixelFormat2ImageFormat(this.mFormat);
        int r104 = r102.length;
        int r105 = 0;
        int r106 = 0;
    L3:
        if (r106 >= r104) goto L8;
        int r107 = r102[r106];
        if (r107 == r103) goto L6;
        r106 = r106 + 1;
        goto L3
    L6:
        r105 = r107;
    L8:
        if (r105 != 0) goto L11;
        this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420;
        r105 = 35;
    L11:
        return init(TECameraProvider.convertSizes(r100.getOutputSizes(r105)), r101);
    }
}
