package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.camera2.params.StreamConfigurationMap;
import android.media.MediaRecorder;
import android.os.Build;
import android.util.Size;
import android.view.Surface;
import com.ss.android.ttvecamera.ICameraInstance;
import com.ss.android.ttvecamera.TECameraBase;
import com.ss.android.ttvecamera.TECameraSettings;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TESurfaceTextureProvider extends TECameraProvider {
    private static final String TAG = "TESurfaceTextureProvider";
    private boolean mIsFirstCameraFrame;
    float[] mMVPMatrix;
    SurfaceTexture.OnFrameAvailableListener mOnFrameAvailableListener;
    private final HashMap<Integer, SurfaceTextureDesc> mOtherSurfaceTextureMap;
    Surface mSurface;
    Surface mSurfaceAdd;
    TECameraProviderManager.SURFACE_OPERATION mSurfaceOperation;
    SurfaceTexture mSurfaceTexture;
    SurfaceTexture mSurfaceTextureAdd;
    int mTextureID;

    public static class SurfaceTextureDesc {
        float[] mMVPMatrix;
        SurfaceTexture mSurfaceTexture;
        int mTextureID;

        private SurfaceTextureDesc() {
            this.mMVPMatrix = new float[16];
        }

        public /* synthetic */ SurfaceTextureDesc(AnonymousClass1 r100) {
            this();
        }
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 1;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        TELogUtils.i(TAG, "get surface = " + this.mSurface);
        return this.mSurface;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurfaceFromAdd() {
        TELogUtils.i(TAG, "getSurfaceFromAdd surface is " + this.mSurfaceAdd);
        return this.mSurfaceAdd;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public TECameraProviderManager.SURFACE_OPERATION getSurfaceOperation() {
        TELogUtils.i(TAG, "get operation is " + this.mSurfaceOperation + " ,this is" + this);
        return this.mSurfaceOperation;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTextureFromAdd() {
        TELogUtils.i(TAG, "get surface texture is " + this.mSurfaceTextureAdd + " ,ooperation is " + this.mSurfaceOperation + " ,this is" + this);
        return this.mSurfaceTextureAdd;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
        Surface r100 = this.mSurface;
        if (r100 == null) goto L5;
        r100.release();
    L5:
        SurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L9;
        r101.release();
    L9:
        if (this.mTextureID != 0) goto L11;
        boolean r102 = true;
    L12:
        if (r102 == true) goto L14;
    L16:
        SurfaceTexture r103 = new SurfaceTexture(this.mTextureID);
        this.mSurfaceTexture = r103;
        if (r102 == false) goto L19;
        r103.detachFromGLContext();
    L19:
        this.mSurface = new Surface(this.mSurfaceTexture);
        TECameraProvider.CaptureListener r104 = this.mListener;
        if ((r104 instanceof TECameraProvider.CaptureListenerWithAR) == false) goto L23;
        ((TECameraProvider.CaptureListenerWithAR) r104).onNewSurfaceTexture(this.mSurfaceTexture, r102);
        return;
    L23:
        return;
    L14:
        if (Build.VERSION.SDK_INT < 26) goto L16;
        this.mSurfaceTexture = new SurfaceTexture(false);
        goto L19
    L11:
        r102 = false;
        goto L12
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void releaseSurfaceTexture() {
        SurfaceTexture r100 = this.mSurfaceTexture;
        if (r100 != null) goto L5;
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        return;
    L7:
        if (r100.isReleased() == true) goto L12;
        TELogUtils.i(TAG, "releaseSurfaceTexture, mSurfaceTexture = " + this.mSurfaceTexture);
        this.mSurfaceTexture.release();
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void removeSurface() {
        TELogUtils.i(TAG, "removeSurface surface is " + this.mSurfaceAdd);
        this.mSurfaceAdd = null;
        this.mSurfaceOperation = TECameraProviderManager.SURFACE_OPERATION.NONE;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void removeSurfaceTexture() {
        TELogUtils.i(TAG, "remove surface texture");
        this.mSurfaceTextureAdd = null;
        this.mSurfaceOperation = TECameraProviderManager.SURFACE_OPERATION.NONE;
    }

    public String toString() {
        return getClass().getName() + "@" + Integer.toHexString(hashCode()) + "&listener=" + this.mListener;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void release() {
        super.release();
        Surface r100 = this.mSurface;
        if (r100 == null) goto L6;
        r100.release();
        this.mSurface = null;
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void triggerSurfaceTextureOnFrameAvailable() {
        super.triggerSurfaceTextureOnFrameAvailable();
        this.mOnFrameAvailableListener.onFrameAvailable(this.mSurfaceTexture);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getTextureID() {
        return this.mTextureID;
    }

    public static /* synthetic */ boolean access$000(TESurfaceTextureProvider r100) {
        return r100.mIsFirstCameraFrame;
    }

    private void initOnFrameAvailableListener(SurfaceTexture.OnFrameAvailableListener r100) {
        SurfaceTexture r101 = this.mSurfaceTexture;
        if (r101 == null) goto L6;
        r101.setOnFrameAvailableListener(r100, this.mCamera.getHandler());
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture(int r100) {
        if (this.mOtherSurfaceTextureMap.containsKey(Integer.valueOf(r100)) == true) goto L5;
        return null;
    L5:
        return this.mOtherSurfaceTextureMap.get(Integer.valueOf(r100)).mSurfaceTexture;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getTextureID(int r100) {
        if (this.mOtherSurfaceTextureMap.containsKey(Integer.valueOf(r100)) == true) goto L5;
        return -1;
    L5:
        return this.mOtherSurfaceTextureMap.get(Integer.valueOf(r100)).mTextureID;
    }

    public TESurfaceTextureProvider(TECameraProviderManager.ProviderSettings r100, ICameraInstance r101) {
        super(r100, r101);
        this.mSurfaceOperation = TECameraProviderManager.SURFACE_OPERATION.NONE;
        this.mMVPMatrix = new float[16];
        this.mIsFirstCameraFrame = true;
        this.mOtherSurfaceTextureMap = new HashMap();
        this.mOnFrameAvailableListener = new AnonymousClass1(this);
        SurfaceTexture r102 = r100.mSurfaceTexture;
        this.mSurfaceTexture = r102;
        if (r102 != null) goto L5;
        TELogUtils.i(TAG, "only surface = " + r100.mRecorderSurface);
        this.mSurface = r100.mRecorderSurface;
        return;
    L5:
        this.mTextureID = r100.mTextureOES;
        this.mSurface = new Surface(this.mSurfaceTexture);
        TELogUtils.i(TAG, "new surface = " + this.mSurface);
    }

    public static /* synthetic */ boolean access$002(TESurfaceTextureProvider r100, boolean r101) {
        r100.mIsFirstCameraFrame = r101;
        return r101;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> r100, TEFrameSizei r101) {
        if (this.mSurfaceTexture != null) goto L5;
    L48:
        return 0;
    L5:
        if (r100 != null) goto L7;
    L47:
        TELogUtils.i(TAG, "previewSize = " + r101 + " mSize = " + this.mSize + "mPreviewSizeCallback = " + this.mPreviewSizeCallback + " deviceSupportedSizes = " + r100);
        SurfaceTexture r102 = this.mSurfaceTexture;
        TEFrameSizei r103 = this.mSize;
        r102.setDefaultBufferSize(r103.width, r103.height);
        initOnFrameAvailableListener(this.mOnFrameAvailableListener);
        goto L48
    L7:
        if (r100.size() <= 0) goto L47;
        TECameraSettings r104 = this.mCamera.getCameraSettings();
        if (r104 != null) goto L11;
    L13:
        boolean r105 = false;
    L14:
        if (r105 == true) goto L23;
        TECameraBase.PreviewSizeCallBack r106 = this.mPreviewSizeCallback;
        if (r106 == null) goto L23;
        TEFrameSizei r107 = r106.getPreviewSize(r100);
        if (r107 == null) goto L20;
        this.mSize = r107;
        goto L47
    L20:
        if (r101 != null) goto L22;
        r101 = this.mSize;
    L22:
        this.mSize = TECameraUtils.calcPreviewSize(r100, r101, this.mCamera.getCameraSettings().mPreviewSizeStrategy);
    L23:
        if (r105 == false) goto L37;
        TECameraBase.PictureSizeCallBack r108 = this.mPictureSizeCallback;
        if (r108 == null) goto L37;
        TEFrameSizei r109 = r108.getPictureSize(r100, r100);
        if (r109 == null) goto L33;
        this.mSize = r109;
        TEFrameSizei r110 = TECameraUtils.makeSizeSupported(r100, r109);
        if (r110 == null) goto L47;
        if (r109.equals(r110) == true) goto L47;
        TELogUtils.i(TAG, "mSize = " + r109 + " not found, change to " + r110);
        this.mSize = r109;
        goto L47
    L33:
        if (r101 != null) goto L35;
        r101 = this.mSize;
    L35:
        this.mSize = TECameraUtils.calcPreviewSize(r100, r101, this.mCamera.getCameraSettings().mPreviewSizeStrategy);
    L37:
        if (this.mCamera.getCameraSettings().mPreviewSizeStrategy != TECameraSettings.TEPreviewSizeStrategy.MATCH_BY_PIXELS) goto L41;
        if (r101 != null) goto L41;
        r101 = this.mCamera.getCameraSettings().mPreviewSize;
    L41:
        if (r104.mbEnableDynamicSwitch == false) goto L44;
        if (r101 != null) goto L46;
        r101 = this.mOriginSize;
    L46:
        this.mSize = TECameraUtils.calcPreviewSize(r100, r101, this.mCamera.getCameraSettings().mPreviewSizeStrategy);
        goto L47
    L44:
        if (r101 != null) goto L46;
        r101 = this.mSize;
        goto L46
    L11:
        if (this.mCamera.getCameraSettings().mCameraZslStrategy != 8) goto L13;
        r105 = true;
        goto L14
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurface(Surface r100, TECameraProviderManager.SURFACE_OPERATION r101) {
        TELogUtils.i(TAG, "setSurface surface is " + this.mSurfaceAdd);
        this.mSurfaceAdd = r100;
        this.mSurfaceOperation = r101;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture r100, boolean r101) {
        Surface r102 = this.mSurface;
        if (r102 == null) goto L5;
        r102.release();
    L5:
        SurfaceTexture r103 = this.mSurfaceTexture;
        if (r103 == null) goto L8;
        r103.release();
    L8:
        this.mSurfaceTexture = r100;
        this.mSurface = new Surface(this.mSurfaceTexture);
        initOnFrameAvailableListener(this.mOnFrameAvailableListener);
        TECameraProvider.CaptureListener r104 = this.mListener;
        if (r104 != null) goto L11;
        return;
    L11:
        if ((r104 instanceof TECameraProvider.CaptureListenerWithAR) == false) goto L15;
        ((TECameraProvider.CaptureListenerWithAR) r104).onNewSurfaceTexture(this.mSurfaceTexture, r101);
        return;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setTextureId(Object r100, int r101) {
        if (r100 != null) goto L4;
    L19:
        this.mTextureID = r101;
        return;
    L4:
        if (r100 == this.mSurfaceTexture) goto L19;
        HashMap<Integer, SurfaceTextureDesc> r102 = this.mOtherSurfaceTextureMap;
        monitor-enter(r102);
        Iterator<SurfaceTextureDesc> r103 = this.mOtherSurfaceTextureMap.values().iterator();     // Catch: Throwable -> L16
    L10:
        if (r103.hasNext() == false) goto L14;
        SurfaceTextureDesc r104 = r103.next();     // Catch: Throwable -> L16
        if (r104.mSurfaceTexture != r100) goto L10;
        r104.mTextureID = r101;     // Catch: Throwable -> L16
        goto L10
    L14:
        monitor-exit(r102);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(StreamConfigurationMap r100, TEFrameSizei r101) {
        Size[] r102 = r100.getOutputSizes(SurfaceTexture.class);
        if (this.mCamera.getCameraSettings().mEnableRecordStream == false) goto L7;
        List<TEFrameSizei> r103 = TECameraProvider.convertSizes(r100.getOutputSizes(MediaRecorder.class));
        return init(TECameraUtils.getSameFrameSize(TECameraProvider.convertSizes(r102), r103), r101);
    L7:
        return init(TECameraProvider.convertSizes(r102), r101);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture r100, TECameraProviderManager.SURFACE_OPERATION r101) {
        this.mSurfaceOperation = r101;
        this.mSurfaceTextureAdd = r100;
        TELogUtils.i(TAG, "set surface texture is " + this.mSurfaceTextureAdd + " ,ooperation is " + this.mSurfaceOperation + " ,this is" + this);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(int r100, SurfaceTexture r101, boolean r102, int r103) {
        StringBuilder r104 = new StringBuilder("setSurfaceTexture surfaceTexture=");
        if (r101 == null) goto L5;
        int r105 = r101.hashCode();
    L6:
        r104.append(r105);
        r104.append(", map size=");
        r104.append(this.mOtherSurfaceTextureMap.size());
        TELogUtils.i(TAG, r104.toString());
        SurfaceTextureDesc r106 = new SurfaceTextureDesc(null);
        r106.mSurfaceTexture = r101;
        r106.mTextureID = r103;
        this.mOtherSurfaceTextureMap.put(Integer.valueOf(r100), r106);
        return;
    L5:
        r105 = 0;
        goto L6
    }
}
