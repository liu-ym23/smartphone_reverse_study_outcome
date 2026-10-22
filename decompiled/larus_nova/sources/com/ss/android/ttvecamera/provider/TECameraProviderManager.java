package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.view.Surface;
import com.bytedance.android.livesdk.chatroom.event.UserProfileEvent;
import com.ss.android.ttvecamera.ICameraInstance;
import com.ss.android.ttvecamera.TECamera2;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraFrame;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.ttvecamera.TETraceUtils;
import java.util.List;
import r27.a;

/* JADX INFO: loaded from: classes38.dex */
public class TECameraProviderManager {
    public static final String TAG = "TECameraProviderManager";
    private TECameraProvider mProvider;
    private ProviderSettings mProviderSettings;

    public static class ProviderSettings {
        public TECameraFrame.ETEPixelFormat mFormat;
        public int mImageReaderCount;
        public boolean mIsPreview;
        public TECameraProvider.CaptureListener mListener;
        public Surface mPreviewSurface;
        private boolean mPrimary;
        public Surface mRecorderSurface;
        public TEFrameSizei mSize;
        public SURFACE_OPERATION mSurfaceOperation;
        public SurfaceTexture mSurfaceTexture;
        public int mTextureOES;

        public String toString() {
            return "ProviderSettings: [mIsPreview = " + this.mIsPreview + ", mSize = " + this.mSize + ", mListener = " + this.mListener + ", mSurfaceTexture = " + this.mSurfaceTexture + ", mTextureOES = " + this.mTextureOES + ", mImageReaderCount = " + this.mImageReaderCount + ", mPrimary=" + this.mPrimary + "]";
        }

        public ProviderSettings(ProviderSettings r100) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mSurfaceOperation = SURFACE_OPERATION.NONE;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Count;
            this.mPrimary = true;
            this.mIsPreview = r100.mIsPreview;
            this.mSize = r100.mSize;
            this.mListener = r100.mListener;
            this.mSurfaceTexture = r100.mSurfaceTexture;
            this.mTextureOES = r100.mTextureOES;
            this.mImageReaderCount = r100.mImageReaderCount;
        }

        public void copyFrom(ProviderSettings r100) {
            this.mIsPreview = r100.mIsPreview;
            this.mSize = r100.mSize;
            this.mListener = r100.mListener;
            this.mSurfaceTexture = r100.mSurfaceTexture;
            this.mTextureOES = r100.mTextureOES;
            this.mImageReaderCount = r100.mImageReaderCount;
            this.mPrimary = r100.mPrimary;
        }

        public boolean isSame(ProviderSettings r100) {
            if (r100 != null) goto L4;
        L20:
            return false;
        L4:
            if (this.mIsPreview != r100.mIsPreview) goto L20;
            TEFrameSizei r101 = this.mSize;
            int r102 = r101.width;
            TEFrameSizei r103 = r100.mSize;
            if (r102 != r103.width) goto L20;
            if (r101.height != r103.height) goto L20;
            if (this.mListener != r100.mListener) goto L20;
            if (this.mSurfaceTexture != r100.mSurfaceTexture) goto L20;
            if (this.mTextureOES != r100.mTextureOES) goto L20;
            if (this.mImageReaderCount != r100.mImageReaderCount) goto L20;
            if (this.mPrimary != r100.mPrimary) goto L20;
            return true;
        }

        public void setPrimary(boolean r100) {
            this.mPrimary = r100;
        }

        public ProviderSettings(TEFrameSizei r100, TECameraProvider.CaptureListener r101, boolean r102, TECameraFrame.ETEPixelFormat r103) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mSurfaceOperation = SURFACE_OPERATION.NONE;
            TECameraFrame.ETEPixelFormat r104 = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420;
            this.mPrimary = true;
            this.mSize = r100;
            this.mListener = r101;
            this.mFormat = r103;
            this.mIsPreview = r102;
        }

        public ProviderSettings(TEFrameSizei r100, TECameraProvider.CaptureListener r101, boolean r102, SurfaceTexture r103, int r104) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mSurfaceOperation = SURFACE_OPERATION.NONE;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Count;
            this.mPrimary = true;
            this.mSize = r100;
            this.mListener = r101;
            this.mSurfaceTexture = r103;
            this.mTextureOES = r104;
            this.mIsPreview = r102;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES;
        }

        public ProviderSettings(TECameraProvider.CaptureListener r100, SurfaceTexture r101, int r102, Surface r103, SURFACE_OPERATION r104) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mSurfaceOperation = SURFACE_OPERATION.NONE;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Count;
            this.mPrimary = true;
            this.mListener = r100;
            this.mSurfaceTexture = r101;
            this.mSurfaceOperation = r104;
            this.mPreviewSurface = r103;
            this.mTextureOES = r102;
        }

        public ProviderSettings(TEFrameSizei r100, TECameraProvider.CaptureListener r101, boolean r102, SurfaceTexture r103, TECameraFrame.ETEPixelFormat r104) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mSurfaceOperation = SURFACE_OPERATION.NONE;
            TECameraFrame.ETEPixelFormat r105 = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420;
            this.mPrimary = true;
            this.mSize = r100;
            this.mListener = r101;
            this.mSurfaceTexture = r103;
            this.mIsPreview = r102;
            this.mFormat = r104;
        }

        public ProviderSettings(TEFrameSizei r100, TECameraProvider.CaptureListener r101, boolean r102, SurfaceTexture r103, int r104, Surface r105) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mSurfaceOperation = SURFACE_OPERATION.NONE;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Count;
            this.mPrimary = true;
            this.mSize = r100;
            this.mListener = r101;
            this.mSurfaceTexture = r103;
            this.mTextureOES = r104;
            this.mIsPreview = r102;
            this.mFormat = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES;
            this.mRecorderSurface = r105;
        }

        public ProviderSettings(TEFrameSizei r100, TECameraProvider.CaptureListener r101, boolean r102, SurfaceTexture r103, TECameraFrame.ETEPixelFormat r104, int r105) {
            this.mIsPreview = true;
            this.mImageReaderCount = 0;
            this.mSurfaceOperation = SURFACE_OPERATION.NONE;
            TECameraFrame.ETEPixelFormat r106 = TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_YUV420;
            this.mPrimary = true;
            this.mSize = r100;
            this.mListener = r101;
            this.mSurfaceTexture = r103;
            this.mIsPreview = r102;
            this.mFormat = r104;
            this.mImageReaderCount = r105;
        }
    }

    public static final enum SURFACE_OPERATION extends Enum<SURFACE_OPERATION> {
        private static final /* synthetic */ SURFACE_OPERATION[] $VALUES = null;
        public static final SURFACE_OPERATION ADD_SURFACE = null;
        public static final SURFACE_OPERATION ADD_SURFACE_TEXTURE = null;
        public static final SURFACE_OPERATION CHANGE_SURFACE = null;
        public static final SURFACE_OPERATION NONE = null;
        public static final SURFACE_OPERATION REMOVE_SURFACE = null;
        public static final SURFACE_OPERATION REMOVE_SURFACE_TEXTURE = null;
        public static final SURFACE_OPERATION SURFACETEXTUREID = null;

        private static /* synthetic */ SURFACE_OPERATION[] $values() {
            return new SURFACE_OPERATION[]{NONE, ADD_SURFACE, CHANGE_SURFACE, REMOVE_SURFACE, ADD_SURFACE_TEXTURE, REMOVE_SURFACE_TEXTURE, SURFACETEXTUREID};
        }

        static {
            NONE = new SURFACE_OPERATION(UserProfileEvent.POSITION_NONE, 0);
            ADD_SURFACE = new SURFACE_OPERATION("ADD_SURFACE", 1);
            CHANGE_SURFACE = new SURFACE_OPERATION("CHANGE_SURFACE", 2);
            REMOVE_SURFACE = new SURFACE_OPERATION("REMOVE_SURFACE", 3);
            ADD_SURFACE_TEXTURE = new SURFACE_OPERATION("ADD_SURFACE_TEXTURE", 4);
            REMOVE_SURFACE_TEXTURE = new SURFACE_OPERATION("REMOVE_SURFACE_TEXTURE", 5);
            SURFACETEXTUREID = new SURFACE_OPERATION("SURFACETEXTUREID", 6);
            $VALUES = $values();
        }

        public static SURFACE_OPERATION[] values() {
            return (SURFACE_OPERATION[]) $VALUES.clone();
        }

        public static SURFACE_OPERATION valueOf(String r100) {
            return (SURFACE_OPERATION) a.a(SURFACE_OPERATION.class, r100);
        }

        private SURFACE_OPERATION(String r100, int r101) {
            super(r100, r101);
        }
    }

    public TECameraProviderManager() {
    }

    public synchronized TECameraProvider getProvider() {
        monitor-enter(this);
        TECameraProvider r100 = this.mProvider;     // Catch: Throwable -> L6
        monitor-exit(this);
        return r100;
    L6:
        th = move-exception;
        throw th;
    }

    public TEFrameSizei getPictureSize() {
        if (this.mProvider.isPreview() == true) goto L7;
        return this.mProvider.mSize;
    L7:
        return new TEFrameSizei(1080, TECameraUtils.CAPTURE_NORMAL);
    }

    public TEFrameSizei getPreviewSize() {
        if (this.mProvider.isPreview() == true) goto L5;
        return null;
    L5:
        return this.mProvider.getSize();
    }

    public Surface getPreviewSurface() {
        TECameraProvider r100 = this.mProvider;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurface();
    }

    public Surface[] getPreviewSurfaces() {
        TECameraProvider r100 = this.mProvider;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurfaces();
    }

    public int getProviderType() {
        TECameraProvider r100 = this.mProvider;
        if (r100 != null) goto L7;
        return 0;
    L7:
        return r100.getType();
    }

    public SurfaceTexture getSurfaceTexture() {
        TECameraProvider r100 = this.mProvider;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getSurfaceTexture();
    }

    public Surface getVideoSurface() {
        TECameraProvider r100 = this.mProvider;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.getRecorderSurface();
    }

    public void releaseSurfaceTexture() {
        TECameraProvider r100 = this.mProvider;
        if (r100 == null) goto L6;
        r100.releaseSurfaceTexture();
        return;
    }

    public void removeProvider() {
        TECameraProvider r100 = this.mProvider;
        if (r100 == null) goto L13;
        r100.release();
        monitor-enter(this);
        this.mProvider = null;     // Catch: Throwable -> L10
        monitor-exit(this);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        throw th;
    }

    public ProviderSettings getProviderSettings() {
        return this.mProviderSettings;
    }

    public Surface getPreviewSurface(int r100) {
        TECameraProvider r101 = this.mProvider;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSurface(r100);
    }

    public Surface[] getPreviewSurfaces(int r100) {
        TECameraProvider r101 = this.mProvider;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSurfaces(r100);
    }

    public SurfaceTexture getSurfaceTexture(int r100) {
        TECameraProvider r101 = this.mProvider;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSurfaceTexture(r100);
    }

    public Surface[] getSurfaces(int r100) {
        TECameraProvider r101 = this.mProvider;
        if (r101 != null) goto L7;
        return null;
    L7:
        return r101.getSurfaces(r100);
    }

    public int getTextureID(int r100) {
        TECameraProvider r101 = this.mProvider;
        if (r101 != null) goto L7;
        return -1;
    L7:
        return r101.getTextureID(r100);
    }

    public void setPictureSizeCallback(TECameraBase.PictureSizeCallBack r100) {
        TECameraProvider r101 = this.mProvider;
        if (r101 != null) goto L6;
        TELogUtils.e(TAG, "setPictureSizeCallback provider is null!");
        return;
    L6:
        r101.setPictureSizeCallback(r100);
    }

    public void setPreviewSizeCallback(TECameraBase.PreviewSizeCallBack r100) {
        TECameraProvider r101 = this.mProvider;
        if (r101 != null) goto L6;
        TELogUtils.e(TAG, "provider is null!");
        return;
    L6:
        r101.setPreviewSizeCallback(r100);
    }

    public void setPreviewStoppedState(boolean r100) {
        if (this.mProvider != null) goto L6;
        TELogUtils.e(TAG, "setPreviewStoppedState: prodiver is null!");
        return;
    L6:
        TETraceUtils.beginSection("setPreviewStoppedState " + r100);
        this.mProvider.setPreviewStoppedState(r100);
        TETraceUtils.endSection();
    }

    public void setProviderSettings(ProviderSettings r100) {
        this.mProviderSettings = r100;
    }

    public void createProvider(ProviderSettings r100, ICameraInstance r101) {
        TELogUtils.i(TAG, "createProvider facing = " + r101.getFacing());
        if (r101.getFacing() != 7) goto L5;
        TECameraProvider r102 = this.mProvider;
        if (r102 != null) goto L56;
    L58:
        TECameraProvider r103 = this.mProvider;
        if (r103 != null) goto L61;
    L62:
        monitor-enter(this);
        this.mProvider = new TEMultiSurfaceTextureProvider(r100, r101);     // Catch: Throwable -> L68
        monitor-exit(this);     // Catch: Throwable -> L68
    L65:
        this.mProvider.setSurfaceTexture(-1, r100.mSurfaceTexture, false, r100.mTextureOES);
        this.mProvider.setCaptureListener(r100.mListener);
    L66:
        r101.setProviderManager(this);
        return;
    L68:
        th = move-exception;
        throw th;
    L61:
        if (((TEMultiSurfaceTextureProvider) r103).isFull() == false) goto L65;
    L56:
        if ((r102 instanceof TEMultiSurfaceTextureProvider) == true) goto L58;
        removeProvider();
        goto L58
    L5:
        if (r101.getCameraSettings().mCameraZslStrategy == 4) goto L7;
        removeProvider();
    L7:
        TECameraFrame.ETEPixelFormat r104 = r100.mFormat;
        if (r104 != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_Recorder) goto L17;
        monitor-enter(this);
        this.mProvider = new TERecorderProvider(r100, r101);     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
    L49:
        r101.setProviderManager(this);
    L13:
        th = move-exception;
        throw th;
    L17:
        if (r104 != TECameraFrame.ETEPixelFormat.PIXEL_FORMAT_OpenGL_OES) goto L35;
        TELogUtils.i(TAG, "createProvider mProvider = " + this.mProvider + ", providerSettings = " + r100 + "，this = " + this);
        monitor-enter(this);
    L31:
        th = move-exception;
        throw th;
    L21:
        if (r101.getCameraSettings().mCameraZslStrategy == 4) goto L24;
        this.mProvider = new TESurfaceTextureProvider(r100, r101);     // Catch: Throwable -> L31
    L29:
        monitor-exit(this);     // Catch: Throwable -> L31
        goto L49
    L24:
        if (r100.mIsPreview == false) goto L26;
        removeProvider();     // Catch: Throwable -> L31
        this.mProvider = new TESurfaceTextureProvider(r100, r101);     // Catch: Throwable -> L31
        goto L29
    L26:
        TECameraProvider r105 = this.mProvider;     // Catch: Throwable -> L31
        if (r105 == null) goto L29;
        r105.setSurfaceTexture(9, r100.mSurfaceTexture, false, r100.mTextureOES);     // Catch: Throwable -> L31
        goto L29
    L35:
        if ((r101 instanceof TECamera2) == false) goto L46;
        monitor-enter(this);
    L43:
        th = move-exception;
        throw th;
    L38:
        if (r100.mImageReaderCount <= 0) goto L40;
        this.mProvider = new TEMultiCamera2Provider(r100, r101);     // Catch: Throwable -> L43
    L41:
        monitor-exit(this);     // Catch: Throwable -> L43
        goto L49
    L40:
        this.mProvider = new TEImageReaderProvider(r100, r101);     // Catch: Throwable -> L43
        goto L41
    L46:
        monitor-enter(this);
        this.mProvider = new TECallbackWithBufferProvider(r100, r101);     // Catch: Throwable -> L50
        monitor-exit(this);     // Catch: Throwable -> L50
    L50:
        th = move-exception;
        throw th;
    }

    public int initProvider(Camera.Parameters r100, TEFrameSizei r101) {
        TECameraProvider r102 = this.mProvider;
        if (r102 != null) goto L5;
        return -112;
    L5:
        if (r102 != null) goto L7;
        return -112;
    L7:
        return r102.init(r100, r101);
    }

    public int initProvider(StreamConfigurationMap r100, TEFrameSizei r101) {
        TECameraProvider r102 = this.mProvider;
        if (r102 != null) goto L5;
        return -112;
    L5:
        if (r102 != null) goto L7;
        return -112;
    L7:
        return r102.init(r100, r101);
    }

    public int initProvider(List<TEFrameSizei> r100, TEFrameSizei r101) {
        TECameraProvider r102 = this.mProvider;
        if (r102 != null) goto L7;
        return -112;
    L7:
        return r102.init(r100, r101);
    }
}
