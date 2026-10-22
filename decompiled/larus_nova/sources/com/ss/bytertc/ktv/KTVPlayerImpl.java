package com.ss.bytertc.ktv;

import com.ss.bytertc.engine.NativeKTVPlayerFunctions;
import com.ss.bytertc.engine.handler.KTVPlayEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.ktv.data.AudioPlayType;
import com.ss.bytertc.ktv.data.AudioTrackType;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class KTVPlayerImpl extends IKTVPlayer {
    private static final String TAG = "KTVPlayerImpl";
    private KTVPlayEventHandler handler;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNativeKTVPlayer;
    private long mNativePlayerEventHandler;
    private final ReentrantReadWriteLock mReadWriteLock;

    public void destroy() {
        this.mJniWriteLock.lock();
        long r100 = this.mNativePlayerEventHandler;     // Catch: Throwable -> L9
        if (r100 == 0) goto L6;
        NativeKTVPlayerFunctions.nativeReleaseKTVPlayerEventHandler(r100);     // Catch: Throwable -> L9
        this.mNativePlayerEventHandler = 0;     // Catch: Throwable -> L9
    L6:
        this.mNativeKTVPlayer = 0;     // Catch: Throwable -> L9
        this.handler = null;     // Catch: Throwable -> L9
        this.mJniWriteLock.unlock();
        return;
    L9:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    public KTVPlayerImpl(long r100) {
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r101;
        this.mJniReadLock = r101.readLock();
        this.mJniWriteLock = r101.writeLock();
        this.mNativeKTVPlayer = r100;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void pauseMusic(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeKTVPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native mNativeKTVPlayer is invalid, pauseMusic failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVPlayerFunctions.nativePauseMusic(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void resumeMusic(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeKTVPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native mNativeKTVPlayer is invalid, resumeMusic failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVPlayerFunctions.nativeResumeMusic(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void setPlayerEventHandler(IKTVPlayerEventHandler r100) {
        KTVPlayEventHandler r101 = new KTVPlayEventHandler(r100);
        this.handler = r101;
        long r102 = this.mNativePlayerEventHandler;
        this.mNativePlayerEventHandler = NativeKTVPlayerFunctions.nativeSetPlayerEventHandler(this.mNativeKTVPlayer, r101);
        if (r102 == 0) goto L6;
        NativeKTVPlayerFunctions.nativeReleaseKTVPlayerEventHandler(r102);
        return;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void stopMusic(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeKTVPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native mNativeKTVPlayer is invalid, stopMusic failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVPlayerFunctions.nativeStopMusic(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void switchAudioTrackType(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeKTVPlayer;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native mNativeKTVPlayer is invalid, switchAudioTrackType failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVPlayerFunctions.nativeSwitchAudioTrackType(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void seekMusic(String r100, int r101) {
        this.mJniReadLock.lock();
        long r102 = this.mNativeKTVPlayer;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native mNativeKTVPlayer is invalid, seekMusic failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVPlayerFunctions.nativeSeekMusic(r102, r100, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void setMusicPitch(String r100, int r101) {
        this.mJniReadLock.lock();
        long r102 = this.mNativeKTVPlayer;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native mNativeKTVPlayer is invalid, setMusicPitch failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVPlayerFunctions.nativeSetMusicPitch(r102, r100, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void setMusicVolume(String r100, int r101) {
        this.mJniReadLock.lock();
        long r102 = this.mNativeKTVPlayer;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native mNativeKTVPlayer is invalid, setMusicVolume failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVPlayerFunctions.nativeSetMusicVolume(r102, r100, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVPlayer
    public void playMusic(String r100, AudioTrackType r101, AudioPlayType r102) {
        this.mJniReadLock.lock();
        long r103 = this.mNativeKTVPlayer;     // Catch: Throwable -> L11
        if (r103 != 0) goto L8;
        LogUtil.e(TAG, "native mNativeKTVPlayer is invalid, playMusic failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVPlayerFunctions.nativePlayMusic(r103, r100, r101.value(), r102.value());     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }
}
