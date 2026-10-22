package com.ss.android.socialbase.downloader.cleaner;

import com.ss.android.socialbase.downloader.logger.Logger;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.Semaphore;

/* JADX INFO: loaded from: classes38.dex */
public class CleanerImpl {
    private static final String TAG = "CleanerImpl";
    private Semaphore mCleanCompletedSem;
    private List<CleanerHandler> mCleaners;
    private volatile boolean mIsStop;

    /* JADX INFO: loaded from: classes5.dex */
    public interface CleanerHandler {
        void start();
    }

    private void startClean() {
        if (this.mIsStop == false) goto L5;
        return;
    L5:
        Iterator<CleanerHandler> r100 = this.mCleaners.iterator();
    L7:
        if (r100.hasNext() == false) goto L12;
        r100.next().start();
        if (this.mIsStop == false) goto L7;
        this.mIsStop = false;
        return;
    L12:
        this.mCleanCompletedSem.release();
    }

    public void startSync() throws InterruptedException {
        if (Logger.debug() == false) goto L6;
        Logger.globalDebug(TAG, "startSync", "Run");
    L6:
        if (this.mCleaners.isEmpty() == false) goto L8;
        return;
    L8:
        long r100 = System.currentTimeMillis();
        Detecter r101 = new Detecter(new AnonymousClass1(this));
        r101.start();
        startClean();
        this.mCleanCompletedSem.acquire();
        r101.stop();
        if (Logger.debug() == false) goto L12;
        Logger.globalDebug(TAG, "startSync", "clear all cache end---cost time=" + (System.currentTimeMillis() - r100));
        return;
    }

    public boolean isStop() {
        return this.mIsStop;
    }

    public CleanerImpl(CleanerConfig r100) {
        this.mCleanCompletedSem = new Semaphore(0);
        this.mIsStop = false;
        this.mCleaners = new CopyOnWriteArrayList();
        if (CacheKeyCleaner.isEnabled(r100) == false) goto L6;
        this.mCleaners.add(new CacheKeyCleaner(this, r100));
    L6:
        if (DirectoryCleaner.isEnabled() == false) goto L9;
        this.mCleaners.add(new DirectoryCleaner(this, r100));
        return;
    }

    public static /* synthetic */ void access$100(CleanerImpl r100) {
        r100.startClean();
    }

    public static /* synthetic */ boolean access$002(CleanerImpl r100, boolean r101) {
        r100.mIsStop = r101;
        return r101;
    }
}
