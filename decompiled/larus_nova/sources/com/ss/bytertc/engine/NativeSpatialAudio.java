package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.ISpatialAudio;
import com.ss.bytertc.engine.data.PositionInfo;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class NativeSpatialAudio implements ISpatialAudio {
    private static final String TAG = "NativeSpatialAudio";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNaiveInstance;
    private final ReentrantReadWriteLock mReadWriteLock;

    public static native void nativeDisableRemoteOrientation(long r100);

    public static native void nativeEnableSpatialAudio(long r100, boolean r101);

    public static native int nativeRemoveAllRemotePosition(long r100);

    public static native int nativeRemoveRemotePosition(long r100, String r101);

    public static native int nativeUpdateRemotePosition(long r100, String r101, PositionInfo r102);

    public static native int nativeUpdateSelfPosition(long r100, PositionInfo r101);

    public void destroy() {
        this.mJniWriteLock.lock();
        this.mNaiveInstance = 0;     // Catch: Throwable -> L6
        this.mJniWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public void disableRemoteOrientation() {
        this.mJniReadLock.lock();
        long r100 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SpatialAudio is invalid, disableRemoteOrientation failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        nativeDisableRemoteOrientation(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int removeAllRemotePosition() {
        this.mJniReadLock.lock();
        long r100 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r100 != 0) goto L8;
        LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r101 = nativeRemoveAllRemotePosition(r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r101;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public NativeSpatialAudio(long r100) {
        this.mNaiveInstance = 0;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r101;
        this.mJniReadLock = r101.readLock();
        this.mJniWriteLock = r101.writeLock();
        this.mNaiveInstance = r100;
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public void enableSpatialAudio(boolean r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native SpatialAudio is invalid, enableSpatialAudio failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        nativeEnableSpatialAudio(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int removeRemotePosition(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r102 = nativeRemoveRemotePosition(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateSelfPosition(PositionInfo r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r102 = nativeUpdateSelfPosition(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.ISpatialAudio
    public int updateRemotePosition(String r100, PositionInfo r101) {
        this.mJniReadLock.lock();
        long r102 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native SpatialAudio is invalid, updatePosition failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r103 = nativeUpdateRemotePosition(r102, r100, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r103;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }
}
