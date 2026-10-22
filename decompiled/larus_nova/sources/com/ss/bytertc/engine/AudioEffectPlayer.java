package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IAudioEffectPlayer;
import com.ss.bytertc.engine.data.AudioEffectPlayerConfig;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.RTCAudioEffectPlayerEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class AudioEffectPlayer extends IAudioEffectPlayer {
    private static final String TAG = "AudioEffectPlayer";
    private RTCAudioEffectPlayerEventHandler mAudioEffectPlayerEventHandler;
    private IAudioEffectPlayerEventHandler mCachedHandler;
    private long mLingeringNativeAudioEffectPlayer;
    private long mNativeAudioEffectPlayer;
    private long mNativeRTCEngine;

    public synchronized void destroy() {
        monitor-enter(this);
        this.mLingeringNativeAudioEffectPlayer = 0;     // Catch: Throwable -> L7
        this.mNativeAudioEffectPlayer = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void destroyResourceInternal() {
        monitor-enter(this);
        this.mLingeringNativeAudioEffectPlayer = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L6
        this.mNativeAudioEffectPlayer = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int pauseAll() {
        monitor-enter(this);
        long r100 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, pauseAll failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeAudioEffectPlayerFunctions.nativePauseAll(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int resumeAll() {
        monitor-enter(this);
        long r100 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, resumeAll failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeAudioEffectPlayerFunctions.nativeResumeAll(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int stopAll() {
        monitor-enter(this);
        long r100 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, stopAll failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeAudioEffectPlayerFunctions.nativeStopAll(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int unloadAll() {
        monitor-enter(this);
        long r100 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, unloadAll failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeAudioEffectPlayerFunctions.nativeUnloadAll(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public AudioEffectPlayer(long r100) {
        this(r100, 0);
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getDuration(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, getDuration failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativeGetDuration(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getPosition(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, getPosition failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativeGetPosition(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int getVolume(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, getVolume failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativeGetVolume(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int pause(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, pause failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativePause(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int resume(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, resume failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativeResume(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setEventHandler(IAudioEffectPlayerEventHandler r100) {
        monitor-enter(this);
    L25:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativeAudioEffectPlayer != 0) goto L6;
    L22:
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid or nativeEngine is invalid, setEventHandler failed.");     // Catch: Throwable -> L25
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L25
        monitor-exit(this);
        return r101;
    L6:
        if (this.mNativeRTCEngine == 0) goto L22;
        this.mAudioEffectPlayerEventHandler.setAudioEffectPlayerEventHandler(r100);     // Catch: Throwable -> L25
        IAudioEffectPlayerEventHandler r102 = this.mCachedHandler;     // Catch: Throwable -> L25
        if (r102 == null) goto L14;
        if (r102 != r100) goto L14;
        int r103 = ReturnStatus.RETURN_STATUS_SUCCESS.value();     // Catch: Throwable -> L25
        monitor-exit(this);
        return r103;
    L14:
        this.mCachedHandler = r100;     // Catch: Throwable -> L25
        if (r100 != null) goto L19;
        int r104 = NativeAudioEffectPlayerFunctions.nativeSetEventHandler(this.mNativeAudioEffectPlayer, this.mNativeRTCEngine, null);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r104;
    L19:
        int r105 = NativeAudioEffectPlayerFunctions.nativeSetEventHandler(this.mNativeAudioEffectPlayer, this.mNativeRTCEngine, this.mAudioEffectPlayerEventHandler);     // Catch: Throwable -> L25
        monitor-exit(this);
        return r105;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setVolumeAll(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, setVolumeAll failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativeSetVolumeAll(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int stop(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, stop failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativeStop(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int unload(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, unload failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativeUnload(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    public AudioEffectPlayer(long r100, long r101) {
        this.mLingeringNativeAudioEffectPlayer = 0;
        this.mAudioEffectPlayerEventHandler = null;
        this.mCachedHandler = null;
        this.mNativeAudioEffectPlayer = r100;
        this.mNativeRTCEngine = r101;
        this.mAudioEffectPlayerEventHandler = new RTCAudioEffectPlayerEventHandler();
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int preload(int r100, String r101) {
        monitor-enter(this);
        long r102 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, preload failed.");     // Catch: Throwable -> L11
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L8:
        int r104 = NativeAudioEffectPlayerFunctions.nativePreload(r102, r100, r101);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r104;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setPosition(int r100, int r101) {
        monitor-enter(this);
        long r102 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, setPosition failed.");     // Catch: Throwable -> L11
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L8:
        int r104 = NativeAudioEffectPlayerFunctions.nativeSetPosition(r102, r100, r101);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r104;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int setVolume(int r100, int r101) {
        monitor-enter(this);
        long r102 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, setVolume failed.");     // Catch: Throwable -> L11
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L8:
        int r104 = NativeAudioEffectPlayerFunctions.nativeSetVolume(r102, r100, r101);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r104;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IAudioEffectPlayer
    public synchronized int start(int r100, String r110, AudioEffectPlayerConfig r111) {
        monitor-enter(this);
        long r101 = this.mNativeAudioEffectPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native AudioEffectPlayer is invalid, start failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeAudioEffectPlayerFunctions.nativeStart(r101, r100, r110, r111.type.value(), r111.playCount, r111.startPos, r111.pitch);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }
}
