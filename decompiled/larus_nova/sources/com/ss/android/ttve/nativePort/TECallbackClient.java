package com.ss.android.ttve.nativePort;

import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.ttve.model.VEFrame;
import com.ss.android.ttvecamera.TELogUtils;
import com.ss.android.vesdk.VEInfo;
import com.ss.android.vesdk.VELogUtil;
import com.ss.android.vesdk.algorithm.VEBachObjectScanDetectResult;
import com.ss.android.vesdk.algorithm.VEBachObjectScanResult;
import com.ss.android.vesdk.algorithm.VEBachQRCodeDetectResult;
import com.ss.android.vesdk.algorithm.VEBachQRCodeResult;
import com.ss.android.vesdk.l;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

/* JADX INFO: loaded from: classes38.dex */
public class TECallbackClient {
    private static final String TAG = "TECallbackClient";
    protected NativeCallbacks.IAudioCaptureCallback mAudioCaptureCallback;
    protected NativeCallbacks.AudioManagerCallback mAudioManagerCallback;
    protected NativeCallbacks.ICameraFrameCallback mBufferedFrameCallback;
    protected mgc.a mByteBufferAllocator;
    protected com.ss.android.ttve.common.a mCommonCallback;
    protected hic.b mDisplayParamsListener;
    protected NativeCallbacks.VEDistortionInfoCallback mDistortionInfoCallback;
    protected NativeCallbacks.IFrameEffectCallback mFrameEffectCallback;
    protected NativeCallbacks.IGetFrameCallback mGetFrameCallback;
    protected Map<String, NativeCallbacks.IGetFrameCallback> mGetFrameCallbacks;
    protected NativeCallbacks.ILensCallback mLensCallback;
    protected NativeCallbacks.i mOpenGLCallback;
    protected hic.c mScanListener;
    protected NativeCallbacks.ICameraFrameCallback mTextureFrameCallback;

    public void nativeCallback_onCameraFacingChangedCallback(boolean r100) {
    }

    public void nativeCallback_onDisplaySizeChangedCallback(int r100, int r101, int r102, int r103) {
    }

    public void setDisplayParamsListener(hic.b r100) {
    }

    public boolean nativeCallback_onIntercept() {
        NativeCallbacks.AudioManagerCallback r100 = this.mAudioManagerCallback;
        if (r100 != null) goto L5;
        return false;
    L5:
        return r100.onIntercept();
    }

    public TECallbackClient() {
        this.mOpenGLCallback = null;
        this.mGetFrameCallback = null;
        this.mGetFrameCallbacks = new HashMap();
        this.mBufferedFrameCallback = null;
        this.mTextureFrameCallback = null;
        this.mLensCallback = null;
        this.mAudioCaptureCallback = null;
        this.mDistortionInfoCallback = null;
        this.mAudioManagerCallback = null;
        this.mFrameEffectCallback = null;
        this.mScanListener = null;
        this.mByteBufferAllocator = null;
    }

    public NativeCallbacks.i getOpenGLListeners() {
        return this.mOpenGLCallback;
    }

    public ByteBuffer nativeCallback_allocateBuffer(int r100) {
        return nativeCallback_allocateBuffer(r100, true);
    }

    public ByteBuffer nativeCallback_allocateBufferFromAllocator(int r100) {
        mgc.a r101 = this.mByteBufferAllocator;
        if (r101 == null) goto L16;
        l r102 = (l) r101;
        monitor-enter(r102);
    L13:
        th = move-exception;
        throw th;
    L7:
        if (r102.f455869a.isEmpty() == true) goto L11;
        ByteBuffer r103 = (ByteBuffer) ((LinkedList) r102.f455869a).get(0);     // Catch: Throwable -> L13
        ((LinkedList) r102.f455869a).remove(0);     // Catch: Throwable -> L13
        monitor-exit(r102);     // Catch: Throwable -> L13
    L18:
        return r103;
    L11:
        monitor-exit(r102);     // Catch: Throwable -> L13
        r103 = VEFrame.allocateFrame(r100);
        goto L18
    L16:
        return null;
    }

    public void nativeCallback_onAudioCaptureCallback(ByteBuffer r100) {
        NativeCallbacks.IAudioCaptureCallback r101 = this.mAudioCaptureCallback;
        if (r101 == null) goto L6;
        r101.onReceive(r100);
        return;
    }

    public void nativeCallback_onFrameEffectCallback(long r100) {
        NativeCallbacks.IFrameEffectCallback r101 = this.mFrameEffectCallback;
        if (r101 == null) goto L6;
        r101.onResult(r100);
        return;
    }

    public void nativeCallback_onOpenGLCreate(int r100) {
        NativeCallbacks.i r101 = this.mOpenGLCallback;
        if (r101 == null) goto L6;
        r101.c(r100);
        return;
    }

    public void nativeCallback_onOpenGLDestroy(int r100) {
        NativeCallbacks.i r101 = this.mOpenGLCallback;
        if (r101 == null) goto L6;
        r101.a(r100);
        return;
    }

    public void nativeCallback_onPreviewSurface(int r100) {
        NativeCallbacks.i r101 = this.mOpenGLCallback;
        if (r101 == null) goto L6;
        r101.d(r100);
        return;
    }

    public void setAudioCaptureListener(NativeCallbacks.IAudioCaptureCallback r100) {
        this.mAudioCaptureCallback = r100;
    }

    public void setAudioManagerCallback(NativeCallbacks.AudioManagerCallback r100) {
        this.mAudioManagerCallback = r100;
    }

    public void setBufferedFrameListener(NativeCallbacks.ICameraFrameCallback r100) {
        this.mBufferedFrameCallback = r100;
    }

    public void setCommonCallback(com.ss.android.ttve.common.a r100) {
        this.mCommonCallback = r100;
    }

    public void setDistortionInfoCallback(NativeCallbacks.VEDistortionInfoCallback r100) {
        this.mDistortionInfoCallback = r100;
    }

    public void setFrameEffectCallback(NativeCallbacks.IFrameEffectCallback r100) {
        this.mFrameEffectCallback = r100;
    }

    public void setLensCallback(NativeCallbacks.ILensCallback r100) {
        this.mLensCallback = r100;
    }

    public void setOpenGLListeners(NativeCallbacks.i r100) {
        this.mOpenGLCallback = r100;
    }

    public void setTextureFrameListener(NativeCallbacks.ICameraFrameCallback r100) {
        this.mTextureFrameCallback = r100;
    }

    public ByteBuffer nativeCallback_allocateBuffer(int r100, boolean r101) {
        ByteBuffer r102 = ByteBuffer.allocateDirect(r100);
        if (r101 == false) goto L5;
        ByteOrder r103 = ByteOrder.LITTLE_ENDIAN;
    L7:
        return r102.order(r103);
    L5:
        r103 = ByteOrder.BIG_ENDIAN;
        goto L7
    }

    public void nativeCallback_onDistortionResult(String r100, String r101) {
        NativeCallbacks.VEDistortionInfoCallback r102 = this.mDistortionInfoCallback;
        if (r102 == null) goto L6;
        r102.onResult(r100, r101);
        return;
    }

    public void nativeCallback_onOpenGLDrawAfter(int r100, double r101) {
        NativeCallbacks.i r102 = this.mOpenGLCallback;
        if (r102 == null) goto L6;
        r102.b(r100, r101);
        return;
    }

    public void nativeCallback_onOpenGLDrawBefore(int r100, double r101) {
        NativeCallbacks.i r102 = this.mOpenGLCallback;
        if (r102 == null) goto L6;
        r102.e(r101);
        return;
    }

    public String nativeCallback_onStyleAudioResult(String r100, String r101) {
        NativeCallbacks.AudioManagerCallback r102 = this.mAudioManagerCallback;
        if (r102 != null) goto L5;
        return null;
    L5:
        return r102.onResult(r100, r101);
    }

    public void setGetFrameListener(NativeCallbacks.IGetFrameCallback r100, String r101) {
        this.mGetFrameCallbacks.put(r101, r100);
    }

    public void setScanListener(hic.c r100, mgc.a r101) {
        this.mScanListener = r100;
        this.mByteBufferAllocator = r101;
    }

    public void nativeCallback_onLensCallbackError(int r100, int r101, String r102) {
        NativeCallbacks.ILensCallback r103 = this.mLensCallback;
        if (r103 == null) goto L6;
        r103.onError(r100, r101, r102);
        return;
    }

    public void nativeCallback_onLensCallbackSuccess(int r100, float r101, int r102) {
        NativeCallbacks.ILensCallback r103 = this.mLensCallback;
        if (r103 == null) goto L6;
        r103.onSuccess(r100, r101, r102);
        return;
    }

    private void nativeCallback_onScanCallback(ByteBuffer r100, byte[][] r101, int r102, int r103) {
        hic.c r104 = this.mScanListener;
        if (r104 == null) goto L36;
        VEFrame r105 = null;
        if (r101 != null) goto L7;
    L30:
        r104.onResult(null);
        return;
    L7:
        if (r101.length == 0) goto L30;
        ArrayList r106 = new ArrayList(r101.length);
        int r107 = 0;
        if (r102 != 12) goto L20;
        if (r103 != 2) goto L17;
    L14:
        if (r107 >= r101.length) goto L29;
        VEBachObjectScanResult r108 = VEBachObjectScanResult.fromCameraParcel(r101[r107], r100, r105, this.mByteBufferAllocator);
        r105 = r108.getSrcImage();
        r106.add(r108);
        r107 = r107 + 1;
    L29:
        r104.onResult(r106);
        return;
    L17:
        if (r107 >= r101.length) goto L29;
        VEBachObjectScanDetectResult r109 = VEBachObjectScanDetectResult.fromCameraParcel(r101[r107], r100, r105, this.mByteBufferAllocator);
        r105 = r109.getSrcImage();
        r106.add(r109);
        r107 = r107 + 1;
        goto L17
    L20:
        if (r102 != 11) goto L25;
    L22:
        if (r107 >= r101.length) goto L29;
        r106.add(VEBachQRCodeResult.fromCameraParcel(r101[r107], r100));
        r107 = r107 + 1;
        goto L22
    L25:
        if (r102 != 13) goto L29;
    L27:
        if (r107 >= r101.length) goto L29;
        r106.add(VEBachQRCodeDetectResult.fromCameraParcel(r101[r107]));
        r107 = r107 + 1;
        goto L27
    }

    public void nativeCallback_onBufferedFrameCallback(ByteBuffer r100, int r101, int r102, long r110) {
        NativeCallbacks.ICameraFrameCallback r103 = this.mBufferedFrameCallback;
        if (r103 == null) goto L6;
        r103.onResult(r100, r101, r102, r110);
        return;
    }

    public void nativeCallback_onCommonCallback(int r100, int r101, float r102, String r110) {
        com.ss.android.ttve.common.a r103 = this.mCommonCallback;
        if (r103 != null) goto L5;
        return;
    L5:
        if (r100 != VEInfo.TE_INFO_PREVIEW_SET_SURFACE_DONE) goto L7;
    L26:
        r103.a(r100, r101, r102, CastLongProtector.parseLong(r110));     // Catch: NumberFormatException -> L22
    L24:
        this.mCommonCallback.onCallback(r100, r101, r102, r110);
        return;
    L22:
        e = move-exception;
        VELogUtil.e(TAG, "msg is not a num", e);
        goto L24
    L7:
        if (r100 == VEInfo.TE_INFO_PREVIEW_EFFECT_FRAME_RENDER_START) goto L26;
        if (r100 == VEInfo.TE_INFO_PREVIEW_EFFECT_FRAME_RENDER_END) goto L26;
        if (r100 == VEInfo.TE_INFO_PREVIEW_NO_EFFECT_FRAME_RENDER_START) goto L26;
        if (r100 == VEInfo.TE_INFO_PREVIEW_NO_EFFECT_FRAME_RENDER_END) goto L26;
        if (r100 == VEInfo.TE_INFO_PREVIEW_FIRST_FRAME_SCREEN_TRACK) goto L26;
        if (r100 == VEInfo.TE_INFO_EFFECT_INIT_START) goto L26;
        if (r100 != VEInfo.TE_INFO_EFFECT_INIT_FINISH) goto L24;
        goto L24
    }

    public void nativeCallback_onLensCallbackInfo(int r100, int r101, int r102, String r103) {
        NativeCallbacks.ILensCallback r104 = this.mLensCallback;
        if (r104 == null) goto L6;
        r104.onInfo(r100, r101, r102, r103);
        return;
    }

    public void nativeCallback_onGetFrameCallback(String r110, int r111, int r112, long r113, boolean r114, String r115) {
        TELogUtils.i(TAG, "onGetFrameCallback texDesc=" + r110 + ", isEffect=" + r114 + " ,key is " + r115);
        if (this.mGetFrameCallbacks.isEmpty() == true) goto L8;
        NativeCallbacks.IGetFrameCallback r100 = this.mGetFrameCallbacks.get(r115);
        this.mGetFrameCallbacks.remove(r115);
        if (r100 == null) goto L9;
        r100.onResult(VEFrame.createTextureFrame(r110, r111, r112, 0, r113, VEFrame.ETEPixelFormat.TEPixFmt_OpenGL_RGBA8.ordinal()), r114);
        return;
    L9:
        return;
    }

    public void nativeCallback_onTextureFrameCallback(int r100, float[] r110, int r111, int r112, int r113, long r114) {
        NativeCallbacks.ICameraFrameCallback r101 = this.mTextureFrameCallback;
        if (r101 == null) goto L6;
        r101.onResult(r100, r110, r111, r112, r113, r114);
        return;
    }

    public void nativeCallback_onGetFrameCallback(int[] r100, int r110, int r111, long r112, boolean r113, String r114) {
        TELogUtils.i(TAG, "nativeCallback_onGetFrameCallback key is " + r114);
        if (this.mGetFrameCallbacks.isEmpty() == true) goto L8;
        NativeCallbacks.IGetFrameCallback r101 = this.mGetFrameCallbacks.get(r114);
        this.mGetFrameCallbacks.remove(r114);
        if (r101 == null) goto L9;
        r101.onResult(r100, r110, r111, r112, r113);
        return;
    L9:
        return;
    }
}
