package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.util.Size;
import android.view.Surface;
import com.ss.android.ttvecamera.ICameraInstance;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public abstract class TECameraProvider {
    public static final int PROVIDER_TYPE_BUFFER_CALLBACK = 4;
    public static final int PROVIDER_TYPE_IMAGE_READER = 2;
    public static final int PROVIDER_TYPE_MULTI_SURFACE_TEXTURE = 32;
    public static final int PROVIDER_TYPE_RECORDER = 16;
    public static final int PROVIDER_TYPE_SURFACE_AND_IMAGE = 8;
    public static final int PROVIDER_TYPE_SURFACE_TEXTURE = 1;
    public static final int PROVIDER_TYPE_UNKNOWN = 0;
    ICameraInstance mCamera;
    protected CaptureListener mEmptyCaptureListener;
    protected CaptureListener mEmptyCaptureListenerWithAR;
    TECameraFrame.ETEPixelFormat mFormat;
    public int mImageReaderCount;
    boolean mIsPreview;
    boolean mIsPreviewStopped;
    boolean mIsPrimary;
    CaptureListener mListener;
    public TECameraFrame.Metadata mMetadata;
    final TEFrameSizei mOriginSize;
    private final Object mPicCallbackLock;
    protected TECameraBase.PictureSizeCallBack mPictureSizeCallback;
    protected TECameraBase.PreviewSizeCallBack mPreviewSizeCallback;
    TEFrameSizei mSize;
    private TECameraSettings.PictureCallback queryNextFrameCallback;
    private long queryNextFrameTimeInNS;

    public interface CaptureListener {
        void onFrameCaptured(TECameraFrame r100);

        void onNewSurfaceTexture(SurfaceTexture r100);
    }

    public interface CaptureListenerWithAR extends CaptureListener {
        void onExtFrameDataAttached(Object r100);

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        void onFrameCaptured(TECameraFrame r100);

        @Override // com.ss.android.ttvecamera.provider.TECameraProvider.CaptureListener
        void onNewSurfaceTexture(SurfaceTexture r100);

        void onNewSurfaceTexture(SurfaceTexture r100, boolean r101);
    }

    public Surface getRecorderSurface() {
        return null;
    }

    public abstract Surface getSurface();

    public Surface getSurface(int r100) {
        return null;
    }

    public Surface getSurfaceFromAdd() {
        return null;
    }

    public TECameraProviderManager.SURFACE_OPERATION getSurfaceOperation() {
        return null;
    }

    public abstract SurfaceTexture getSurfaceTexture();

    public SurfaceTexture getSurfaceTexture(int r100) {
        return null;
    }

    public SurfaceTexture getSurfaceTextureFromAdd() {
        return null;
    }

    public Surface[] getSurfaces() {
        return null;
    }

    public Surface[] getSurfaces(int r100) {
        return null;
    }

    public int getTextureID() {
        return -1;
    }

    public int getTextureID(int r100) {
        return -1;
    }

    public abstract int getType();

    public int init(StreamConfigurationMap r100, TEFrameSizei r101) {
        return -1;
    }

    public abstract int init(List<TEFrameSizei> r100, TEFrameSizei r101);

    public abstract void reAllocateSurfaceTexture();

    public void releaseSurfaceTexture() {
    }

    public void removeSurface() {
    }

    public void removeSurfaceTexture() {
    }

    public void setSurface(Surface r100, TECameraProviderManager.SURFACE_OPERATION r101) {
    }

    public void setSurfaceTexture(int r100, SurfaceTexture r101, boolean r102, int r103) {
    }

    public void setSurfaceTexture(SurfaceTexture r100, TECameraProviderManager.SURFACE_OPERATION r101) {
    }

    public abstract void setSurfaceTexture(SurfaceTexture r100, boolean r101);

    public void setTextureId(Object r100, int r101) {
    }

    public void triggerSurfaceTextureOnFrameAvailable() {
    }

    public TEFrameSizei getSize() {
        TEFrameSizei r100 = this.mSize;
        return new TEFrameSizei(r100.width, r100.height);
    }

    public void release() {
        if ((this.mListener instanceof CaptureListenerWithAR) == false) goto L5;
        this.mListener = this.mEmptyCaptureListenerWithAR;
        return;
    L5:
        this.mListener = this.mEmptyCaptureListener;
    }

    public TECameraFrame.Metadata getMetadata() {
        return this.mMetadata;
    }

    public boolean isPreview() {
        return this.mIsPreview;
    }

    public static List<TEFrameSizei> convertSizes(List<Camera.Size> r100) {
        ArrayList r101 = new ArrayList();
        Iterator<Camera.Size> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        Camera.Size r103 = r102.next();
        r101.add(new TEFrameSizei(r103.width, r103.height));
        goto L4
    L6:
        return r101;
    }

    public void onExtFrameDataAttached(Object r100) {
        CaptureListener r101 = this.mListener;
        if (r101 != null) goto L5;
        return;
    L5:
        if ((r101 instanceof CaptureListenerWithAR) == false) goto L9;
        ((CaptureListenerWithAR) r101).onExtFrameDataAttached(r100);
        return;
    }

    public void onFrameCaptured(TECameraFrame r100) {
        CaptureListener r101 = this.mListener;
        if (r101 == null) goto L5;
        r101.onFrameCaptured(r100);
    L5:
        Object r102 = this.mPicCallbackLock;
        monitor-enter(r102);
    L16:
        th = move-exception;
        throw th;
    L8:
        if (this.queryNextFrameCallback == null) goto L14;
        long r103 = r100.getTimeStampNS();     // Catch: Throwable -> L16
        long r104 = this.queryNextFrameTimeInNS;     // Catch: Throwable -> L16
        if (r103 < r104) goto L14;
        if (r104 < 0) goto L14;
        this.queryNextFrameCallback.onPictureTaken(r100, null);     // Catch: Throwable -> L16
        this.queryNextFrameCallback = null;     // Catch: Throwable -> L16
        this.queryNextFrameTimeInNS = -1;     // Catch: Throwable -> L16
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L16
    }

    public void setCaptureListener(CaptureListener r100) {
        this.mListener = r100;
    }

    public void setFormat(TECameraFrame.ETEPixelFormat r100) {
        this.mFormat = r100;
    }

    public void setMetadata(TECameraFrame.Metadata r100) {
        this.mMetadata = r100;
    }

    public void setPictureSizeCallback(TECameraBase.PictureSizeCallBack r100) {
        this.mPictureSizeCallback = r100;
    }

    public void setPreviewSizeCallback(TECameraBase.PreviewSizeCallBack r100) {
        this.mPreviewSizeCallback = r100;
    }

    public void setPreviewStoppedState(boolean r100) {
        this.mIsPreviewStopped = r100;
    }

    public static List<TEFrameSizei> convertSizes(Size[] r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        ArrayList r101 = new ArrayList();
        int r102 = r100.length;
        int r103 = 0;
    L6:
        if (r103 >= r102) goto L8;
        Size r104 = r100[r103];
        r101.add(new TEFrameSizei(r104.getWidth(), r104.getHeight()));
        r103 = r103 + 1;
        goto L6
    L8:
        return r101;
    }

    public TECameraProvider(TECameraProviderManager.ProviderSettings r100, ICameraInstance r101) {
        this.mSize = new TEFrameSizei();
        this.mIsPreview = true;
        this.mImageReaderCount = 1;
        this.mIsPrimary = true;
        this.mIsPreviewStopped = false;
        this.mPreviewSizeCallback = null;
        this.mPictureSizeCallback = null;
        this.mPicCallbackLock = new Object();
        this.queryNextFrameTimeInNS = 0;
        this.mEmptyCaptureListener = new AnonymousClass1(this);
        this.mEmptyCaptureListenerWithAR = new AnonymousClass2(this);
        this.mFormat = r100.mFormat;
        this.mListener = r100.mListener;
        if (r100.mSize == null) goto L5;
        TEFrameSizei r102 = r100.mSize;
        this.mOriginSize = new TEFrameSizei(r102.width, r102.height);
    L6:
        this.mSize = r100.mSize;
        this.mCamera = r101;
        this.mIsPreview = r100.mIsPreview;
        this.mImageReaderCount = r100.mImageReaderCount;
        return;
    L5:
        this.mOriginSize = new TEFrameSizei(TECameraUtils.CAPTURE_NORMAL, 1080);
        goto L6
    }

    public int init(Camera.Parameters r100, TEFrameSizei r101) {
        return init(convertSizes(r100.getSupportedPreviewSizes()), r101);
    }

    public void queryNextFrame(long r100, TECameraSettings.PictureCallback r101) {
        Object r102 = this.mPicCallbackLock;
        monitor-enter(r102);
        this.queryNextFrameCallback = r101;     // Catch: Throwable -> L7
        this.queryNextFrameTimeInNS = r100;     // Catch: Throwable -> L7
        monitor-exit(r102);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void setSize(int r100, int r101) {
        TEFrameSizei r102 = this.mSize;
        r102.width = r100;
        r102.height = r101;
    }
}
