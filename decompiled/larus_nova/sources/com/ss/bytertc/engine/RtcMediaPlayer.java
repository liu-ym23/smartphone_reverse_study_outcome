package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IMediaPlayer;
import com.ss.bytertc.engine.data.AudioMixingDualMonoMode;
import com.ss.bytertc.engine.data.AudioMixingType;
import com.ss.bytertc.engine.data.MediaPlayerConfig;
import com.ss.bytertc.engine.data.MediaPlayerCustomSource;
import com.ss.bytertc.engine.data.PlayerState;
import com.ss.bytertc.engine.data.ReturnStatus;
import com.ss.bytertc.engine.handler.RTCMediaPlayerAudioFrameObserver;
import com.ss.bytertc.engine.handler.RTCMediaPlayerCustomSourceProvider;
import com.ss.bytertc.engine.handler.RTCMediaPlayerEventHandler;
import com.ss.bytertc.engine.utils.AudioFrame;
import com.ss.bytertc.engine.utils.LogUtil;

/* JADX INFO: loaded from: classes40.dex */
public class RtcMediaPlayer extends IMediaPlayer {
    private static final String TAG = "MediaPlayer";
    private RTCMediaPlayerAudioFrameObserver mAudioFrameObserver;
    private long mLingeringNativeMediaPlayer;
    private RTCMediaPlayerCustomSourceProvider mMediaPlayerCustomSourceProvider;
    private RTCMediaPlayerEventHandler mMediaPlayerEventHandler;
    private long mNativeMediaPlayer;
    private long mNativeRTCEngine;

    public synchronized void destroy() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L12
        if (r100 == 0) goto L6;
        NativeMediaPlayerFunctions.nativeDestory(r100);     // Catch: Throwable -> L12
        this.mNativeMediaPlayer = 0;     // Catch: Throwable -> L12
    L6:
        long r101 = this.mLingeringNativeMediaPlayer;     // Catch: Throwable -> L12
        if (r101 == 0) goto L9;
        NativeMediaPlayerFunctions.nativeDestory(r101);     // Catch: Throwable -> L12
        this.mLingeringNativeMediaPlayer = 0;     // Catch: Throwable -> L12
    L9:
        this.mNativeRTCEngine = 0;     // Catch: Throwable -> L12
        this.mAudioFrameObserver = null;     // Catch: Throwable -> L12
        this.mMediaPlayerEventHandler = null;     // Catch: Throwable -> L12
        this.mMediaPlayerCustomSourceProvider = null;     // Catch: Throwable -> L12
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void destroyResourceInternal() {
        monitor-enter(this);
        this.mLingeringNativeMediaPlayer = this.mNativeMediaPlayer;     // Catch: Throwable -> L6
        this.mNativeMediaPlayer = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getAudioTrackCount() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, getAudioTrackCount failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeMediaPlayerFunctions.nativeGetAudioTrackCount(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getPlaybackDuration() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, getPlaybackDuration failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeMediaPlayerFunctions.nativeGetPlaybackDuration(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getPosition() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, getPosition failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeMediaPlayerFunctions.nativeGetPosition(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized PlayerState getState() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, getState failed.");     // Catch: Throwable -> L11
        PlayerState r101 = PlayerState.IDLE;     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        PlayerState r102 = PlayerState.fromId(NativeMediaPlayerFunctions.nativeGetState(r100));     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getTotalDuration() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, getTotalDuration failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeMediaPlayerFunctions.nativeGetTotalDuration(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int pause() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, pause failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeMediaPlayerFunctions.nativePause(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int resume() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, resume failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeMediaPlayerFunctions.nativeResume(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int start() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, start failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeMediaPlayerFunctions.nativeStart(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int stop() {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, stop failed.");     // Catch: Throwable -> L11
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    L8:
        int r102 = NativeMediaPlayerFunctions.nativeStop(r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L11:
        th = move-exception;
        throw th;
    }

    public RtcMediaPlayer(long r100) {
        this(r100, 0);
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int getVolume(AudioMixingType r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, getVolume failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativeGetVolume(r101, r100.value());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int pushExternalAudioFrame(AudioFrame r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, pushExternalAudioFrame failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativePushExternalAudioFrame(r101, r100.buffer, r100.samples, r100.sampleRate.value(), r100.channel.value());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int registerAudioFrameObserver(IMediaPlayerAudioFrameObserver r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativeMediaPlayer != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, registerAudioFrameObserver failed.");     // Catch: Throwable -> L16
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r101;
    L8:
        this.mAudioFrameObserver.setAudioFrameObserver(r100);     // Catch: Throwable -> L16
        if (r100 != null) goto L13;
        int r102 = NativeMediaPlayerFunctions.nativeRegisterAudioFrameObserver(this.mNativeMediaPlayer, null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r102;
    L13:
        int r103 = NativeMediaPlayerFunctions.nativeRegisterAudioFrameObserver(this.mNativeMediaPlayer, this.mAudioFrameObserver);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r103;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int selectAudioTrack(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, selectAudioTrack failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativeSelectAudioTrack(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setAudioDualMonoMode(AudioMixingDualMonoMode r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, setAudioDualMonoMode failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativeSetAudioDualMonoMode(r101, r100.value());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setAudioPitch(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, setAudioPitch failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativeSetAudioPitch(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setEventHandler(IMediaPlayerEventHandler r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.mNativeMediaPlayer != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, setEventHandler failed.");     // Catch: Throwable -> L16
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L16
        monitor-exit(this);
        return r101;
    L8:
        this.mMediaPlayerEventHandler.setMediaPlayerEventHandler(r100);     // Catch: Throwable -> L16
        if (r100 != null) goto L13;
        int r102 = NativeMediaPlayerFunctions.nativeSetEventHandler(this.mNativeMediaPlayer, null);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r102;
    L13:
        int r103 = NativeMediaPlayerFunctions.nativeSetEventHandler(this.mNativeMediaPlayer, this.mMediaPlayerEventHandler);     // Catch: Throwable -> L16
        monitor-exit(this);
        return r103;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setLoudness(float r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, setLoudness failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativeSetLoudness(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setPlaybackSpeed(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, setPlaybackSpeed failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativeSetPlaybackSpeed(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setPosition(int r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, setPosition failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativeSetPosition(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setProgressInterval(long r100) {
        monitor-enter(this);
        long r101 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, setProgressInterval failed.");     // Catch: Throwable -> L11
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    L8:
        int r103 = NativeMediaPlayerFunctions.nativeSetProgressInterval(r101, r100);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L11:
        th = move-exception;
        throw th;
    }

    public RtcMediaPlayer(long r100, long r101) {
        this.mLingeringNativeMediaPlayer = 0;
        this.mAudioFrameObserver = null;
        this.mMediaPlayerEventHandler = null;
        this.mMediaPlayerCustomSourceProvider = null;
        this.mNativeMediaPlayer = r100;
        this.mNativeRTCEngine = r101;
        this.mAudioFrameObserver = new RTCMediaPlayerAudioFrameObserver();
        this.mMediaPlayerEventHandler = new RTCMediaPlayerEventHandler();
        this.mMediaPlayerCustomSourceProvider = new RTCMediaPlayerCustomSourceProvider();
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int open(String r110, MediaPlayerConfig r111) {
        monitor-enter(this);
        long r100 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, open failed.");     // Catch: Throwable -> L11
        int r112 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r112;
    L8:
        int r113 = NativeMediaPlayerFunctions.nativeOpen(r100, r110, r111.type.value(), r111.playCount, r111.startPos, r111.autoPlay, r111.callbackOnProgressInterval, r111.syncProgressToRecordFrame);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r113;
    L11:
        th = move-exception;
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int openWithCustomSource(MediaPlayerCustomSource r110, MediaPlayerConfig r111) {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mNativeMediaPlayer != 0) goto L9;
        LogUtil.e(TAG, "native MediaPlayer is invalid, openWithCustomSource failed.");     // Catch: Throwable -> L12
        int r100 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L12
        monitor-exit(this);
        return r100;
    L9:
        this.mMediaPlayerCustomSourceProvider.setCustomSourceProvider(r110.provider);     // Catch: Throwable -> L12
        int r101 = NativeMediaPlayerFunctions.nativeOpenWithCustomSource(this.mNativeMediaPlayer, r110.mode.value(), r110.type.value(), this.mMediaPlayerCustomSourceProvider, r111.type.value(), r111.playCount, r111.startPos, r111.autoPlay, r111.callbackOnProgressInterval, r111.syncProgressToRecordFrame);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    }

    @Override // com.ss.bytertc.engine.audio.IMediaPlayer
    public synchronized int setVolume(int r100, AudioMixingType r101) {
        monitor-enter(this);
        long r102 = this.mNativeMediaPlayer;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native MediaPlayer is invalid, setVolume failed.");     // Catch: Throwable -> L11
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L11
        monitor-exit(this);
        return r103;
    L8:
        int r104 = NativeMediaPlayerFunctions.nativeSetVolume(r102, r100, r101.value());     // Catch: Throwable -> L11
        monitor-exit(this);
        return r104;
    L11:
        th = move-exception;
        throw th;
    }
}
