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
public class TEImageReaderProvider extends TECameraProvider {
    ImageReader mImageReader;

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 2;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture r100, boolean r101) {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        ImageReader r100 = this.mImageReader;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurface();
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        super.release();
        ImageReader r100 = this.mImageReader;
        if (r100 == null) goto L6;
        r100.close();
        this.mImageReader = null;
        return;
    }

    public TEImageReaderProvider(TECameraProviderManager.ProviderSettings r100, ICameraInstance r101) {
        super(r100, r101);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> r100, TEFrameSizei r101) {
        if (r100 != null) goto L4;
    L6:
        ImageReader r102 = this.mImageReader;
        if (r102 == null) goto L9;
        r102.close();
    L9:
        TEFrameSizei r103 = this.mSize;
        ImageReader r104 = ImageReader.newInstance(r103.width, r103.height, TECameraFrame.pixelFormat2ImageFormat(this.mFormat), 1);
        this.mImageReader = r104;
        r104.setOnImageAvailableListener(new AnonymousClass1(this), this.mCamera.getHandler());
        return 0;
    L4:
        if (r100.size() <= 0) goto L6;
        this.mSize = TECameraUtils.calcPreviewSize(r100, this.mSize, this.mCamera.getCameraSettings().mPreviewSizeStrategy);
        goto L6
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
