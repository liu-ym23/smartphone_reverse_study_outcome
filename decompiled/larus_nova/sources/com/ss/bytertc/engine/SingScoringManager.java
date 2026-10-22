package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.ISingScoringManager;
import com.ss.bytertc.engine.data.SingScoringConfig;
import com.ss.bytertc.engine.data.StandardPitchInfo;
import com.ss.bytertc.engine.handler.NativeSingScoringEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import java.lang.ref.WeakReference;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class SingScoringManager extends ISingScoringManager {
    private static final String TAG = "SingScoringManager";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    NativeSingScoringEventHandler mNativeHandler;
    private long mNativeRTCVideoEngine;
    private long mNativeSingScoringManager;
    private final ReentrantReadWriteLock mReadWriteLock;
    private WeakReference<ISingScoringEventHandler> mSingScoringEventHandler;

    public void destroy() {
        this.mJniWriteLock.lock();
        this.mNativeSingScoringManager = 0;     // Catch: Throwable -> L6
        this.mJniWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getAverageScore() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeSingScoringManager;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, getAverageScore failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = NativeSingScoringManagerFunctions.nativeGetAverageScore(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getLastSentenceScore() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeSingScoringManager;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, getLastSentenceScore failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = NativeSingScoringManagerFunctions.nativeGetLastSentenceScore(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public ISingScoringEventHandler getSingScoringEventHandler() {
        return this.mSingScoringEventHandler.get();
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int getTotalScore() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeSingScoringManager;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, getTotalScore failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = NativeSingScoringManagerFunctions.nativeGetTotalScore(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int stopSingScoring() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeSingScoringManager;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, stopSingScoring failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = NativeSingScoringManagerFunctions.nativeStopSingScoring(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public List<StandardPitchInfo> getStandardPitchInfo(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeSingScoringManager;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, getStandardPitchInfo failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return null;
    L8:
        List<StandardPitchInfo> r102 = Arrays.asList(NativeSingScoringManagerFunctions.nativeGetStandardPitchInfo(r101, r100));     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int setSingScoringConfig(SingScoringConfig r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeSingScoringManager;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, setSingScoringConfig failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r102 = NativeSingScoringManagerFunctions.nativeSetSingScoringConfig(r101, r100.sampleRate.value(), r100.mode.value(), r100.lyricsFilepath, r100.midiFilepath);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public SingScoringManager(long r100, long r101) {
        this.mNativeSingScoringManager = 0;
        this.mNativeRTCVideoEngine = 0;
        ReentrantReadWriteLock r102 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r102;
        this.mJniReadLock = r102.readLock();
        this.mJniWriteLock = r102.writeLock();
        this.mNativeRTCVideoEngine = r100;
        this.mNativeSingScoringManager = r101;
        this.mNativeHandler = new NativeSingScoringEventHandler(this);
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int startSingScoring(int r100, int r101) {
        this.mJniReadLock.lock();
        long r102 = this.mNativeSingScoringManager;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, startSingScoring failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r103 = NativeSingScoringManagerFunctions.nativeStartSingScoring(r102, r100, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r103;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISingScoringManager
    public int initSingScoring(String r100, String r110, ISingScoringEventHandler r111) {
        this.mJniReadLock.lock();
    L16:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeSingScoringManager != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, initSingScoring failed.");     // Catch: Throwable -> L16
        this.mJniReadLock.unlock();
        return -1;
    L8:
        this.mSingScoringEventHandler = new WeakReference(r111);     // Catch: Throwable -> L16
        if (r111 != null) goto L13;
        int r101 = NativeSingScoringManagerFunctions.nativeInitSingScoring(this.mNativeRTCVideoEngine, this.mNativeSingScoringManager, r100, r110, null);     // Catch: Throwable -> L16
        this.mJniReadLock.unlock();
        return r101;
    L13:
        int r102 = NativeSingScoringManagerFunctions.nativeInitSingScoring(this.mNativeRTCVideoEngine, this.mNativeSingScoringManager, r100, r110, this.mNativeHandler);     // Catch: Throwable -> L16
        this.mJniReadLock.unlock();
        return r102;
    }
}
