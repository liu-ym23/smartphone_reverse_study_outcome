package com.ss.android.ttvecamera.provider;

import android.graphics.SurfaceTexture;
import android.hardware.Camera;
import android.view.Surface;
import com.ss.android.ttvecamera.ICameraInstance;
import com.ss.android.ttvecamera.TECameraUtils;
import com.ss.android.ttvecamera.TEFrameSizei;
import com.ss.android.ttvecamera.TELogUtils;
import java.lang.reflect.Array;
import java.util.List;

/* JADX INFO: loaded from: classes38.dex */
public class TECallbackWithBufferProvider extends TECameraProvider {
    private static final int MAX_PREVIEW_DATA_CHECK_TIMES = 3;
    private static final String TAG = "TECallbackWithBufferProvider";
    private byte[][] mCallbackBytebuffer;
    private int mCallbackBytebufferSize;
    Camera.PreviewCallback mPreviewCallback;
    private int mPreviewCheckTimes;
    private SurfaceTexture mSurfaceTexture;

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public Surface getSurface() {
        return null;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int getType() {
        return 4;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void reAllocateSurfaceTexture() {
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public void setSurfaceTexture(SurfaceTexture r100, boolean r101) {
    }

    public Camera.PreviewCallback getPreviewCallback() {
        return this.mPreviewCallback;
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public SurfaceTexture getSurfaceTexture() {
        return this.mSurfaceTexture;
    }

    private boolean checkPreviewData(byte[] r110) {
        if (r110 == null) goto L5;
        int r100 = r110.length;
    L7:
        if (r100 <= 0) goto L33;
        TEFrameSizei r101 = this.mSize;
        if (r101 == null) goto L33;
        int r102 = this.mPreviewCheckTimes;
        if (r102 >= 3) goto L33;
        this.mPreviewCheckTimes = r102 + 1;
        int r103 = r101.width * r101.height;
        if (r103 <= r100) goto L16;
        TELogUtils.e(TAG, "checkPreviewData failed: mSize: " + this.mSize + ", length: " + r100);
        return false;
    L16:
        int r104 = r103 / 300;
        int r105 = r104 / 2;
        byte r106 = r110[0];
        byte r107 = r110[r103];
        int r108 = 0;
    L18:
        if (r108 >= 300) goto L30;
        int r109 = r108 * r104;
        int r111 = (r108 * r105) + r103;
        if (r109 >= r100) goto L30;
        if (r111 >= r100) goto L30;
        if (r106 != r110[r109]) goto L29;
        if (r107 != r110[r111]) goto L29;
        r108 = r108 + 1;
    L29:
        boolean r112 = true;
    L31:
        if (r112 == true) goto L33;
        return false;
    L30:
        r112 = false;
    L33:
        return true;
    L5:
        r100 = 0;
        goto L7
    }

    public byte[][] getBuffers(int r100) {
        TEFrameSizei r101 = this.mSize;
        int r102 = ((r101.width * r101.height) * 3) / 2;
        TELogUtils.d(TAG, "getBuffers current bufferSize: " + r102 + " mCallbackBytebufferSize:" + this.mCallbackBytebufferSize);
        int r103 = this.mCallbackBytebufferSize;
        if (r102 > r103) goto L5;
        if (r103 == 0) goto L5;
    L7:
        return this.mCallbackBytebuffer;
    L5:
        this.mCallbackBytebuffer = (byte[][]) Array.newInstance(Byte.TYPE, new int[]{r100, r102});
        TELogUtils.d(TAG, "new mCallbackBytebuffer size :" + r102);
        this.mCallbackBytebufferSize = r102;
        goto L7
    }

    public TECallbackWithBufferProvider(TECameraProviderManager.ProviderSettings r100, ICameraInstance r101) {
        super(r100, r101);
        this.mPreviewCheckTimes = 0;
        this.mCallbackBytebuffer = null;
        this.mCallbackBytebufferSize = 0;
        this.mSurfaceTexture = r100.mSurfaceTexture;
    }

    public static /* synthetic */ boolean access$000(TECallbackWithBufferProvider r100, byte[] r101) {
        return r100.checkPreviewData(r101);
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(List<TEFrameSizei> r100, TEFrameSizei r101) {
        if (r100 != null) goto L4;
    L8:
        TELogUtils.i(TAG, "init, setDefaultBufferSize, mSize = " + this.mSize);
        SurfaceTexture r102 = this.mSurfaceTexture;
        TEFrameSizei r103 = this.mSize;
        r102.setDefaultBufferSize(r103.width, r103.height);
        TEFrameSizei r104 = this.mSize;
        final int r105 = r104.width;
        final int r106 = r104.height;
        this.mPreviewCallback = new AnonymousClass1(this, r105, r106);
        return 0;
    L4:
        if (r100.size() <= 0) goto L8;
        if (r101 != null) goto L7;
        r101 = this.mSize;
    L7:
        this.mSize = TECameraUtils.calcPreviewSize(r100, r101, this.mCamera.getCameraSettings().mPreviewSizeStrategy);
        goto L8
    }

    @Override // com.ss.android.ttvecamera.provider.TECameraProvider
    public int init(Camera.Parameters r100, TEFrameSizei r101) {
        return init(TECameraProvider.convertSizes(r100.getSupportedPreviewSizes()), r101);
    }
}
