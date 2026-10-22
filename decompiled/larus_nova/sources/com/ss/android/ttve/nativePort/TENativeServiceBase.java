package com.ss.android.ttve.nativePort;

import com.ss.android.vesdk.VEEditor;

/* JADX INFO: loaded from: classes38.dex */
public class TENativeServiceBase {
    protected NativeCallbacks.a mAudioExtendToFileCallback;
    protected NativeCallbacks.c mEncoderDataCallback;
    protected NativeCallbacks.b mExtractFrameProcessCallback;
    protected NativeCallbacks.d mGetCompileFirstFrameCallback;
    protected NativeCallbacks.e mGetImageCallback;
    protected NativeCallbacks.f mKeyFrameCallback;
    protected NativeCallbacks.g mMVInitedCallback;
    protected NativeCallbacks.h mMattingCallback;
    protected com.ss.android.ttve.common.a mOnErrorListener;
    protected com.ss.android.ttve.common.a mOnInfoListener;
    protected NativeCallbacks.i mOpenGLCallback;
    protected NativeCallbacks.e mSeekFrameCallback;

    public void nativeCallback_onExtractFrameProcess(float r100) {
    }

    public void nativeCallback_onMVInited() {
    }

    public void setExtractFrameProcessCallback(NativeCallbacks.b r100) {
    }

    public void setmMVInitedCallback(NativeCallbacks.g r100) {
    }

    public void nativeCallback_onAudioExtendToFileCancel() {
        NativeCallbacks.a r100 = this.mAudioExtendToFileCallback;
        if (r100 == null) goto L6;
        r100.getClass();
        return;
    }

    public void nativeCallback_onMattingStartedCallback() {
        NativeCallbacks.h r100 = this.mMattingCallback;
        if (r100 == null) goto L6;
        VEEditor.access$3200(((VEEditor.a) r100).f455542a);
        return;
    }

    public TENativeServiceBase() {
        this.mOpenGLCallback = null;
        this.mOnErrorListener = null;
        this.mOnInfoListener = null;
        this.mEncoderDataCallback = null;
        this.mGetImageCallback = null;
        this.mGetCompileFirstFrameCallback = null;
        this.mKeyFrameCallback = null;
        this.mMattingCallback = null;
        this.mSeekFrameCallback = null;
        this.mAudioExtendToFileCallback = null;
    }

    public NativeCallbacks.c getEncoderDataListener() {
        return this.mEncoderDataCallback;
    }

    public com.ss.android.ttve.common.a getErrorListener() {
        return this.mOnErrorListener;
    }

    public com.ss.android.ttve.common.a getInfoListener() {
        return this.mOnInfoListener;
    }

    public NativeCallbacks.i getOpenGLListeners() {
        return this.mOpenGLCallback;
    }

    public void nativeCallback_onAudioExtendToFileFinish(boolean r100) {
        NativeCallbacks.a r101 = this.mAudioExtendToFileCallback;
        if (r101 == null) goto L6;
        r101.getClass();
        return;
    }

    public void nativeCallback_onAudioExtendToFileProcess(float r100) {
        NativeCallbacks.a r101 = this.mAudioExtendToFileCallback;
        if (r101 == null) goto L6;
        r101.getClass();
        return;
    }

    public void nativeCallback_onMattingDoneCallback(float r100) {
        NativeCallbacks.h r101 = this.mMattingCallback;
        if (r101 == null) goto L6;
        VEEditor.access$3200(((VEEditor.a) r101).f455542a);
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

    public void setAudioExtendToFileCallback(NativeCallbacks.a r100) {
        this.mAudioExtendToFileCallback = r100;
    }

    public void setEncoderDataListener(NativeCallbacks.c r100) {
        this.mEncoderDataCallback = r100;
    }

    public void setErrorListener(com.ss.android.ttve.common.a r100) {
        this.mOnErrorListener = r100;
    }

    public void setGetCompileFirstFrameCallback(NativeCallbacks.d r100) {
        this.mGetCompileFirstFrameCallback = r100;
    }

    public void setGetImageCallback(NativeCallbacks.e r100) {
        this.mGetImageCallback = r100;
    }

    public void setGetSeekFrameCallback(NativeCallbacks.e r100) {
        this.mGetImageCallback = r100;
    }

    public void setInfoListener(com.ss.android.ttve.common.a r100) {
        this.mOnInfoListener = r100;
    }

    public void setKeyFrameCallback(NativeCallbacks.f r100) {
        this.mKeyFrameCallback = r100;
    }

    public void setMattingCallback(NativeCallbacks.h r100) {
        this.mMattingCallback = r100;
    }

    public void setOpenGLListeners(NativeCallbacks.i r100) {
        this.mOpenGLCallback = r100;
    }

    public void setSeekFrameCallback(NativeCallbacks.e r100) {
        this.mSeekFrameCallback = r100;
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

    public void nativeCallback_onDisplayCallback(int r100, int r101, int r102) {
        NativeCallbacks.f r103 = this.mKeyFrameCallback;
        if (r103 == null) goto L6;
        VEEditor.access$3300(((VEEditor.b) r103).f455543a);
        return;
    }

    public void nativeCallback_onInfoListener(int r100, int r101, float r102) {
        com.ss.android.ttve.common.a r103 = this.mOnInfoListener;
        if (r103 == null) goto L6;
        r103.onCallback(r100, r101, r102, null);
        return;
    }

    public void nativeCallback_onMattingErrorCallback(int r100, int r101, float r102) {
        NativeCallbacks.h r103 = this.mMattingCallback;
        if (r103 == null) goto L6;
        VEEditor.access$3200(((VEEditor.a) r103).f455542a);
        return;
    }

    public void nativeCallback_onProcessCallback(int r100, int r101, String r102) {
        NativeCallbacks.f r103 = this.mKeyFrameCallback;
        if (r103 == null) goto L6;
        VEEditor.access$3300(((VEEditor.b) r103).f455543a);
        return;
    }

    public void nativeCallback_onCompressBuffer(byte[] r100, long r101, int r110, boolean r111) {
        NativeCallbacks.c r102 = this.mEncoderDataCallback;
        if (r102 == null) goto L15;
        VEEditor.m r103 = (VEEditor.m) r102;
        r103.getClass();
        if (r100 != null) goto L7;
        return;
    L7:
        if (r101 < 0) goto L17;
        if (r110 > 0) goto L11;
        return;
    L11:
        if (VEEditor.access$2900(r103.f455568a) == null) goto L19;
        VEEditor.access$2900(r103.f455568a).onEncoderDataAvailable(r100, r101, r110, r111);
        return;
    L19:
        return;
    L17:
        return;
    }

    public void nativeCallback_onErrorListener(int r100, int r101, float r102, String r103) {
        com.ss.android.ttve.common.a r104 = this.mOnErrorListener;
        if (r104 == null) goto L6;
        r104.onCallback(r100, r101, r102, r103);
        return;
    }

    public void nativeCallback_onMattingProgressCallback(int r100, float r101, float r102, boolean r103) {
        NativeCallbacks.h r104 = this.mMattingCallback;
        if (r104 == null) goto L6;
        VEEditor.access$3200(((VEEditor.a) r104).f455542a);
        return;
    }

    public void nativeCallback_onCompileFirstFrame(int r100, byte[] r101, int r102, int r103, long r104) {
        NativeCallbacks.d r105 = this.mGetCompileFirstFrameCallback;
        if (r105 == null) goto L6;
        VEEditor.access$3100(((VEEditor.p) r105).f455571a);
        return;
    }

    public int nativeCallback_onImageData(byte[] r100, int r101, int r102, int r110, float r111) {
        NativeCallbacks.e r103 = this.mGetImageCallback;
        if (r103 != null) goto L5;
        return 0;
    L5:
        return r103.a(r100, r101, r102, r110, r111);
    }

    public int nativeCallback_onSeekFrameData(byte[] r100, int r101, int r102, int r110, float r111) {
        NativeCallbacks.e r103 = this.mSeekFrameCallback;
        if (r103 != null) goto L5;
        return 0;
    L5:
        return r103.a(r100, r101, r102, r110, r111);
    }
}
