package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.ISimilaritySingScoringManager;
import com.ss.bytertc.engine.data.RemoteStreamKey;
import com.ss.bytertc.engine.data.SimilaritySingScoringConfig;
import com.ss.bytertc.engine.data.SimilaritySingScoringMode;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class SimilaritySingScoringManager extends ISimilaritySingScoringManager {
    private static final String TAG = "SimilaritySingScoringManager";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNativeSimilaritySingScoringManager;
    private final ReentrantReadWriteLock mReadWriteLock;

    public void destroy() {
        this.mJniWriteLock.lock();
        this.mNativeSimilaritySingScoringManager = 0;     // Catch: Throwable -> L6
        this.mJniWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int getAverageScore() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeSimilaritySingScoringManager;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, getAverageScore failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = NativeSimilaritySingScoringManagerFunctions.nativeGetAverageSimilarityScore(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int getLastScore() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeSimilaritySingScoringManager;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, getLastSentenceScore failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = NativeSimilaritySingScoringManagerFunctions.nativeGetLastSimilarityScore(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int getTotalScore() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeSimilaritySingScoringManager;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, getTotalScore failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = NativeSimilaritySingScoringManagerFunctions.nativeGetTotalSimilarityScore(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int stopSingScoring() {
        this.mJniReadLock.lock();
        long r100 = this.mNativeSimilaritySingScoringManager;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SingScoringManager is invalid, stopSingScoring failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = NativeSimilaritySingScoringManagerFunctions.nativeStopSimilaritySingScoring(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public SimilaritySingScoringManager(long r100) {
        this.mNativeSimilaritySingScoringManager = 0;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r101;
        this.mJniReadLock = r101.readLock();
        this.mJniWriteLock = r101.writeLock();
        this.mNativeSimilaritySingScoringManager = r100;
    }

    @Override // com.ss.bytertc.engine.audio.ISimilaritySingScoringManager
    public int startSingScoring(SimilaritySingScoringConfig r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeSimilaritySingScoringManager;     // Catch: Throwable -> L21
        if (r101 != 0) goto L9;
        LogUtil.e(TAG, "native SingScoringManager is invalid, startSingScoring failed.");     // Catch: Throwable -> L21
        this.mJniReadLock.unlock();
        return -1;
    L9:
        if (r100 != null) goto L11;
    L18:
        LogUtil.e(TAG, "native SingScoringManager is invalid, invalid param.");     // Catch: Throwable -> L21
        this.mJniReadLock.unlock();
        return -2;
    L11:
        if (r100.refStream == null) goto L18;
        SimilaritySingScoringMode r102 = r100.mode;     // Catch: Throwable -> L21
        if (r102 == null) goto L18;
        int r103 = r100.calculateIntervalMs;     // Catch: Throwable -> L21
        int r104 = r102.value();     // Catch: Throwable -> L21
        RemoteStreamKey r105 = r100.refStream;     // Catch: Throwable -> L21
        int r106 = NativeSimilaritySingScoringManagerFunctions.nativeStartSimilaritySingScoring(r101, r103, r104, r105.roomId, r105.userId, r105.streamIndex.value());     // Catch: Throwable -> L21
        this.mJniReadLock.unlock();
        return r106;
    L21:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }
}
