package com.ss.bytertc.engine;

import com.ss.bytertc.engine.data.ReturnStatus;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class RTCAudioDeviceManager implements IRTCAudioDeviceManager {
    private long mAudioDeviceManager;
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private final ReentrantReadWriteLock mReadWriteLock;

    public void destroy() {
        this.mJniWriteLock.lock();
        this.mAudioDeviceManager = -1;     // Catch: Throwable -> L6
        this.mJniWriteLock.unlock();
        return;
    L6:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int stopAudioDevicePlayTest() {
        this.mJniReadLock.lock();
        long r100 = this.mAudioDeviceManager;     // Catch: Throwable -> L10
        if (r100 != (-1)) goto L8;
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeAudioDeviceManagerFunctions.nativeStopAudioDevicePlayTest(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int stopAudioDeviceRecordAndPlayTest() {
        this.mJniReadLock.lock();
        long r100 = this.mAudioDeviceManager;     // Catch: Throwable -> L10
        if (r100 != (-1)) goto L8;
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeAudioDeviceManagerFunctions.nativeStopAudioDeviceRecordAndPlayTest(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int stopAudioPlaybackDeviceTest() {
        this.mJniReadLock.lock();
        long r100 = this.mAudioDeviceManager;     // Catch: Throwable -> L10
        if (r100 != (-1)) goto L8;
        int r101 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r101;
    L8:
        r101 = NativeAudioDeviceManagerFunctions.nativeStopAudioPlaybackDeviceTest(r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    public RTCAudioDeviceManager(long r100) {
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r101;
        this.mJniReadLock = r101.readLock();
        this.mJniWriteLock = r101.writeLock();
        this.mAudioDeviceManager = r100;
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int startAudioDeviceRecordTest(int r100) {
        this.mJniReadLock.lock();
        long r101 = this.mAudioDeviceManager;     // Catch: Throwable -> L10
        if (r101 != (-1)) goto L8;
        int r102 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r102;
    L8:
        r102 = NativeAudioDeviceManagerFunctions.nativeStartAudioDeviceRecordTest(r101, r100);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.engine.IRTCAudioDeviceManager
    public int startAudioPlaybackDeviceTest(String r100, int r101) {
        this.mJniReadLock.lock();
        long r102 = this.mAudioDeviceManager;     // Catch: Throwable -> L10
        if (r102 != (-1)) goto L8;
        int r103 = ReturnStatus.RETURN_STATUS_NATIVE_IN_VALID.value();     // Catch: Throwable -> L10
    L6:
        this.mJniReadLock.unlock();
        return r103;
    L8:
        r103 = NativeAudioDeviceManagerFunctions.nativeStartAudioPlaybackDeviceTest(r102, r100, r101);     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }
}
