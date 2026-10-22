package com.ss.bytertc.engine.video;

import com.ss.bytertc.engine.InternalExpressDetectConfig;
import com.ss.bytertc.engine.NativeRTCVideoFunctions;
import com.ss.bytertc.engine.data.VirtualBackgroundSource;
import com.ss.bytertc.engine.handler.RTCFaceDetectionObserver;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class RTCVideoEffect extends IVideoEffect {
    private static final String TAG = "RTCVideoEffect";
    private IFaceDetectionObserver mFaceDetectionObserver;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNativeEngine;
    private RTCFaceDetectionObserver mRTCFaceDetectionObserver;
    private final ReentrantReadWriteLock mReadWriteLock;

    private boolean engineInvalid() {
        if (this.mNativeEngine != 0) goto L5;
        return true;
    L5:
        return false;
    }

    public void destroy() {
        LogUtil.i(TAG, "dispose rtc video effect");
        this.mJniWriteLock.lock();
        this.mNativeEngine = 0;     // Catch: Throwable -> L6
        this.mJniWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableFaceDetection() {
        this.mJniReadLock.lock();
    L12:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L9;
        LogUtil.e(TAG, "invalid, registerFaceDetectionObserver failed.");     // Catch: Throwable -> L12
        this.mJniReadLock.unlock();
        return -1006;
    L9:
        this.mFaceDetectionObserver = null;     // Catch: Throwable -> L12
        int r100 = NativeRTCVideoFunctions.nativeDisableFaceDetection(this.mNativeEngine);     // Catch: Throwable -> L12
        this.mJniReadLock.unlock();
        return r100;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableVideoEffect() {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, disableVideoEffect failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r100 = NativeRTCVideoFunctions.nativeDisableVideoEffect(this.mNativeEngine);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r100;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int disableVirtualBackground() {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, disableVirtualBackground failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r100 = NativeRTCVideoFunctions.nativeDisableVirtualBackground(this.mNativeEngine);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r100;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableVideoEffect() {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, enableVideoEffect failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r100 = NativeRTCVideoFunctions.nativeEnableVideoEffect2(this.mNativeEngine);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r100;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public long getVideoEffectHandle() {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "native engine is invalid, getVideoEffectHandle failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        long r100 = NativeRTCVideoFunctions.nativeGetVideoEffectHandle(this.mNativeEngine);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r100;
    }

    public IFaceDetectionObserver getFaceDetectionObserver() {
        return this.mFaceDetectionObserver;
    }

    public RTCVideoEffect(long r100) {
        this.mNativeEngine = 0;
        this.mRTCFaceDetectionObserver = null;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r101;
        this.mJniReadLock = r101.readLock();
        this.mJniWriteLock = r101.writeLock();
        this.mNativeEngine = r100;
        this.mRTCFaceDetectionObserver = new RTCFaceDetectionObserver(this);
        LogUtil.i(TAG, "create rtc video effect");
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int appendEffectNodes(List<String> r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, appendEffectNodes failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        String[] r101 = new String[r100.size()];     // Catch: Throwable -> L11
        r100.toArray(r101);     // Catch: Throwable -> L11
        int r102 = NativeRTCVideoFunctions.nativeAppendVideoEffectNodes(this.mNativeEngine, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int applyStickerEffect(String r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "native engine is invalid, applyStickerEffect failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r101 = NativeRTCVideoFunctions.nativeApplyStickerEffect(this.mNativeEngine, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int getGestureRegistered(EffectTouchGesture r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, getGestureRegistered failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -10086;
    L8:
        int r101 = NativeRTCVideoFunctions.nativeGetGestureRegistered(this.mNativeEngine, r100.getValue());     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int removeEffectNodes(List<String> r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, removeEffectNodes failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        String[] r101 = new String[r100.size()];     // Catch: Throwable -> L11
        r100.toArray(r101);     // Catch: Throwable -> L11
        int r102 = NativeRTCVideoFunctions.nativeRemoveVideoEffectNodes(this.mNativeEngine, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setColorFilter(String r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, setColorFilter failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r101 = NativeRTCVideoFunctions.nativeSetVideoEffectColorFilter(this.mNativeEngine, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setColorFilterIntensity(float r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, setColorFilterIntensity failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r101 = NativeRTCVideoFunctions.nativeSetVideoEffectColorFilterIntensity(this.mNativeEngine, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setEffectNodes(List<String> r100) {
        this.mJniReadLock.lock();
    L14:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (engineInvalid() == false) goto L9;
        LogUtil.e(TAG, "invalid, setEffectNodes failed.");     // Catch: Throwable -> L14
        this.mJniReadLock.unlock();
        return -1006;
    L9:
        if (r100 != null) goto L11;
        LogUtil.w(TAG, "effect_nodes is null, setting empty effect nodes.");     // Catch: Throwable -> L14
        r100 = new ArrayList();     // Catch: Throwable -> L14
    L11:
        String[] r101 = new String[r100.size()];     // Catch: Throwable -> L14
        r100.toArray(r101);     // Catch: Throwable -> L14
        int r102 = NativeRTCVideoFunctions.nativeSetVideoEffectNodes(this.mNativeEngine, r101);     // Catch: Throwable -> L14
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setVideoEffectExpressionDetect(VideoEffectExpressionConfig r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, setVideoEffectExpressionDetect failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        InternalExpressDetectConfig r101 = new InternalExpressDetectConfig(r100);     // Catch: Throwable -> L11
        int r102 = NativeRTCVideoFunctions.nativeSetVideoEffectExpressionDetect(this.mNativeEngine, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableVirtualBackground(String r100, VirtualBackgroundSource r101) {
        this.mJniReadLock.lock();
    L17:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L9;
        LogUtil.e(TAG, "invalid, enableVirtualBackground failed.");     // Catch: Throwable -> L17
        this.mJniReadLock.unlock();
        return -1006;
    L9:
        if (r101 == null) goto L13;
        String r102 = r101.sourcePath;     // Catch: Throwable -> L17
        if (r102 == null) goto L13;
        String r103 = r102;
    L14:
        int r104 = NativeRTCVideoFunctions.nativeEnableVirtualBackground(this.mNativeEngine, r100, r101.sourceType.ordinal(), r101.sourceColor, r103);     // Catch: Throwable -> L17
        this.mJniReadLock.unlock();
        return r104;
    L13:
        r103 = "";
        goto L14
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int getSuspendGestureRecognizer(EffectTouchGesture r100, boolean r101) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, getSuspendGestureRecognizer failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -10086;
    L8:
        int r102 = NativeRTCVideoFunctions.nativeGetSuspendGestureRecognizer(this.mNativeEngine, r100.getValue(), r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int initCVResource(String r100, String r101) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, initCVResource failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r102 = NativeRTCVideoFunctions.nativeInitCVResource(this.mNativeEngine, r100, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setAlgoModelResourceFinder(long r100, long r101) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, setAlgoModelResourceFinder failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r102 = NativeRTCVideoFunctions.nativeSetVideoEffectAlgoModelResourceFinder(this.mNativeEngine, r100, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int enableFaceDetection(IFaceDetectionObserver r100, int r101, String r102) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, registerFaceDetectionObserver failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        this.mFaceDetectionObserver = r100;     // Catch: Throwable -> L11
        int r103 = NativeRTCVideoFunctions.nativeEnableFaceDetection(this.mNativeEngine, this.mRTCFaceDetectionObserver, r101, r102);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r103;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int updateEffectNode(String r100, String r101, float r102) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, updateEffectNode failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1006;
    L8:
        int r103 = NativeRTCVideoFunctions.nativeUpdateVideoEffectNode(this.mNativeEngine, r100, r101, r102);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r103;
    }

    @Override // com.ss.bytertc.engine.video.IVideoEffect
    public int setVideoEffectTouchEvent(int r110, float r111, float r112, float r113, float r114, EffectTouchType r115, int r116) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (engineInvalid() == false) goto L8;
        LogUtil.e(TAG, "invalid, setVideoEffectTouchEvent failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -10086;
    L8:
        int r100 = NativeRTCVideoFunctions.nativeSetVideoEffectTouchEvent(this.mNativeEngine, r110, r111, r112, r113, r114, r115.ordinal(), r116);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r100;
    }
}
