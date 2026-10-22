package com.ss.bytertc.engine;

import com.ss.bytertc.engine.audio.IRangeAudio;
import com.ss.bytertc.engine.data.Position;
import com.ss.bytertc.engine.data.ReceiveRange;
import com.ss.bytertc.engine.type.AttenuationType;
import com.ss.bytertc.engine.utils.LogUtil;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class NativeRangeAudio implements IRangeAudio {
    private static final String TAG = "NativeRangeAudio";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private long mNaiveInstance;
    private final ReentrantReadWriteLock mReadWriteLock;

    public static native void nativeEnableRangeAudio(long r100, boolean r101);

    public static native int nativeSetAttenuationType(long r100, int r101, float r102);

    public static native void nativeSetNoAttenuationFlags(long r100, String[] r101);

    public static native int nativeUpdatePosition(long r100, float r101, float r102, float r103);

    public static native int nativeUpdateReceiveRange(long r100, int r101, int r102);

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

    public NativeRangeAudio(long r100) {
        this.mNaiveInstance = 0;
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r101;
        this.mJniReadLock = r101.readLock();
        this.mJniWriteLock = r101.writeLock();
        this.mNaiveInstance = r100;
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public void enableRangeAudio(boolean r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native RangeAudio is invalid, enableRangeAudio failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        nativeEnableRangeAudio(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public void setNoAttenuationFlags(List<String> r100) {
        this.mJniReadLock.lock();
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNaiveInstance != 0) goto L8;
        LogUtil.e(TAG, "native range audio is invalid, setNoAttenuationFlags failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        String[] r101 = new String[r100.size()];     // Catch: Throwable -> L11
        r100.toArray(r101);     // Catch: Throwable -> L11
        nativeSetNoAttenuationFlags(this.mNaiveInstance, r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public int updatePosition(Position r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native RangeAudio is invalid, updatePosition failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r102 = nativeUpdatePosition(r101, r100.f456202x, r100.f456203y, r100.f456204z);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public int updateReceiveRange(ReceiveRange r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native RangeAudio is invalid, updateReceiveRange failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r102 = nativeUpdateReceiveRange(r101, r100.min, r100.max);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.audio.IRangeAudio
    public int setAttenuationModel(AttenuationType r100, float r101) {
        this.mJniReadLock.lock();
        long r102 = this.mNaiveInstance;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native range audio is invalid, setAttenuationModel failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r103 = nativeSetAttenuationType(r102, r100.value(), r101);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r103;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }
}
