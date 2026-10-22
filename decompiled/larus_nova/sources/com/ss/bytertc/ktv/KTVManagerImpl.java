package com.ss.bytertc.ktv;

import com.ss.bytertc.engine.BuildConfig;
import com.ss.bytertc.engine.NativeKTVManagerFunctions;
import com.ss.bytertc.engine.handler.KTVManagerEventHandler;
import com.ss.bytertc.engine.utils.LogUtil;
import com.ss.bytertc.ktv.data.DownloadLyricType;
import com.ss.bytertc.ktv.data.MusicFilterType;
import java.util.List;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: loaded from: classes40.dex */
public class KTVManagerImpl extends IKTVManager {
    private static final String TAG = "KTVManagerImpl";
    private final ReentrantReadWriteLock.ReadLock mJniReadLock;
    private final ReentrantReadWriteLock.WriteLock mJniWriteLock;
    private KTVManagerEventHandler mKTVManagerEventHandler;
    private KTVPlayerImpl mKTVPlayer;
    private long mNativeKTVManager;
    private long mNativeKTVManagerEventHandlerPtr;
    private final ReentrantReadWriteLock mReadWriteLock;

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void clearCache() {
        this.mJniReadLock.lock();
    L9:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeKTVManager != 0) goto L6;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, clearCache failed.");     // Catch: Throwable -> L9
    L6:
        NativeKTVManagerFunctions.nativeClearCache(this.mNativeKTVManager);     // Catch: Throwable -> L9
        this.mJniReadLock.unlock();
    }

    public void destroy() {
        KTVPlayerImpl r100 = this.mKTVPlayer;
        if (r100 == null) goto L5;
        r100.destroy();
        this.mKTVPlayer = null;
    L5:
        long r101 = this.mNativeKTVManagerEventHandlerPtr;
        if (r101 == 0) goto L8;
        NativeKTVManagerFunctions.nativeReleaseKTVManagerEventHandler(r101);
        this.mNativeKTVManagerEventHandlerPtr = 0;
    L8:
        this.mKTVManagerEventHandler = null;
        this.mJniWriteLock.lock();
        this.mNativeKTVManager = 0;     // Catch: Throwable -> L12
        this.mJniWriteLock.unlock();
        return;
    L12:
        th = move-exception;
        this.mJniWriteLock.unlock();
        throw th;
    }

    public IKTVManagerEventHandler getHandler() {
        return this.mKTVManagerEventHandler.getKTVHandler();
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public IKTVPlayer getKTVPlayer() {
        this.mJniReadLock.lock();
    L19:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L5:
        if (this.mNativeKTVManager != 0) goto L7;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, getKTVPlayer failed.");     // Catch: Throwable -> L19
    L7:
        KTVPlayerImpl r100 = this.mKTVPlayer;     // Catch: Throwable -> L19
        if (r100 == null) goto L11;
        this.mJniReadLock.unlock();
        return r100;
    L11:
        long r101 = NativeKTVManagerFunctions.nativeGetKTVPlayer(this.mNativeKTVManager);     // Catch: Throwable -> L19
        if (r101 != 0) goto L16;
        LogUtil.e(TAG, "native nativeKTVPlayer is invalid, getKTVPlayer failed.");     // Catch: Throwable -> L19
        this.mJniReadLock.unlock();
        return null;
    L16:
        KTVPlayerImpl r102 = new KTVPlayerImpl(r101);     // Catch: Throwable -> L19
        this.mKTVPlayer = r102;     // Catch: Throwable -> L19
        this.mJniReadLock.unlock();
        return r102;
    }

    public KTVManagerImpl(long r100) {
        ReentrantReadWriteLock r101 = new ReentrantReadWriteLock();
        this.mReadWriteLock = r101;
        this.mJniReadLock = r101.readLock();
        this.mJniWriteLock = r101.writeLock();
        this.mNativeKTVManager = r100;
    }

    private int calculateMusicFilterValue(MusicFilterType[] r100) {
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        if (r102 != 0) goto L9;
        return MusicFilterType.NONE.value();
    L9:
        if (r102 == 1) goto L27;
        int r103 = r100[0].value();
        int r104 = r100.length;
    L12:
        if (r101 >= r104) goto L23;
        MusicFilterType r105 = r100[r101];
        if (r103 == MusicFilterType.NONE.value()) goto L16;
        r103 = r103 | r105.value();
        r101 = r101 + 1;
        goto L12
    L16:
        if (BuildConfig.DEBUG == true) goto L20;
        LogUtil.e(TAG, "types contains 'MUSIC_FILTER_TYPE_NONE' and other");
        return -1;
    L20:
        throw new IllegalArgumentException("types contains 'MUSIC_FILTER_TYPE_NONE' and other");
    L23:
        return r103;
    L27:
        return r100[0].value();
    L5:
        r102 = r100.length;
        goto L6
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void cancelDownload(int r100) {
        this.mJniReadLock.lock();
    L9:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeKTVManager != 0) goto L6;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, downloadLyric failed.");     // Catch: Throwable -> L9
    L6:
        NativeKTVManagerFunctions.nativeCancelDownload(this.mNativeKTVManager, r100);     // Catch: Throwable -> L9
        this.mJniReadLock.unlock();
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public int downloadMidi(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeKTVManager;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, downloadMidi failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r102 = NativeKTVManagerFunctions.nativeDownloadMidi(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public int downloadMusic(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeKTVManager;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, downloadMusic failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r102 = NativeKTVManagerFunctions.nativeDownloadMusic(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r102;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void getMusicDetail(String r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeKTVManager;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, getMusicDetail failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVManagerFunctions.nativeGetMusicDetail(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void setKTVManagerEventHandler(IKTVManagerEventHandler r100) {
        this.mJniReadLock.lock();
    L13:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeKTVManager != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, setKTVManagerEventHandler failed.");     // Catch: Throwable -> L13
        this.mJniReadLock.unlock();
        return;
    L8:
        KTVManagerEventHandler r101 = new KTVManagerEventHandler(r100);     // Catch: Throwable -> L13
        this.mKTVManagerEventHandler = r101;     // Catch: Throwable -> L13
        long r102 = this.mNativeKTVManagerEventHandlerPtr;     // Catch: Throwable -> L13
        this.mNativeKTVManagerEventHandlerPtr = NativeKTVManagerFunctions.nativeSetKTVManagerEventHandler(this.mNativeKTVManager, r101);     // Catch: Throwable -> L13
        if (r102 == 0) goto L11;
        NativeKTVManagerFunctions.nativeReleaseKTVManagerEventHandler(r102);     // Catch: Throwable -> L13
    L11:
        this.mJniReadLock.unlock();
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void setMaxCacheSize(int r100) {
        this.mJniReadLock.lock();
        long r101 = this.mNativeKTVManager;     // Catch: Throwable -> L11
        if (r101 != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, setMaxCacheSize failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L8:
        NativeKTVManagerFunctions.nativeSetMaxCacheSize(r101, r100);     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public int downloadLyric(String r100, DownloadLyricType r101) {
        this.mJniReadLock.lock();
        long r102 = this.mNativeKTVManager;     // Catch: Throwable -> L11
        if (r102 != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, downloadLyric failed.");     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return -1;
    L8:
        int r103 = NativeKTVManagerFunctions.nativeDownloadLyric(r102, r100, r101.value());     // Catch: Throwable -> L11
        this.mJniReadLock.unlock();
        return r103;
    L11:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void getHotMusic(List<String> r100, MusicFilterType[] r101) {
        this.mJniReadLock.lock();
    L14:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeKTVManager != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, getHotMusic failed.");     // Catch: Throwable -> L14
    L6:
        this.mJniReadLock.unlock();
        return;
    L8:
        int r102 = calculateMusicFilterValue(r101);     // Catch: Throwable -> L14
        if (r102 == (-1)) goto L6;
        String[] r103 = new String[r100.size()];     // Catch: Throwable -> L14
        r100.toArray(r103);     // Catch: Throwable -> L14
        NativeKTVManagerFunctions.nativeGetHotMusic(this.mNativeKTVManager, r103, r102);     // Catch: Throwable -> L14
        this.mJniReadLock.unlock();
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void getMusicList(int r100, int r101, MusicFilterType[] r102) {
        this.mJniReadLock.lock();
    L14:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeKTVManager != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, getMusicList failed.");     // Catch: Throwable -> L14
    L6:
        this.mJniReadLock.unlock();
        return;
    L8:
        int r103 = calculateMusicFilterValue(r102);     // Catch: Throwable -> L14
        if (r103 == (-1)) goto L6;
        NativeKTVManagerFunctions.nativeGetMusicList(this.mNativeKTVManager, r100, r101, r103);     // Catch: Throwable -> L14
        this.mJniReadLock.unlock();
    }

    @Override // com.ss.bytertc.ktv.IKTVManager
    public void searchMusic(String r100, int r101, int r102, MusicFilterType[] r110) {
        this.mJniReadLock.lock();
    L14:
        th = move-exception;
        this.mJniReadLock.unlock();
        throw th;
    L4:
        if (this.mNativeKTVManager != 0) goto L8;
        LogUtil.e(TAG, "native KTVManagerImpl is invalid, searchMusic failed.");     // Catch: Throwable -> L14
    L6:
        this.mJniReadLock.unlock();
        return;
    L8:
        int r103 = calculateMusicFilterValue(r110);     // Catch: Throwable -> L14
        if (r103 == (-1)) goto L6;
        NativeKTVManagerFunctions.nativeSearchMusic(this.mNativeKTVManager, r100, r101, r102, r103);     // Catch: Throwable -> L14
        this.mJniReadLock.unlock();
    }
}
