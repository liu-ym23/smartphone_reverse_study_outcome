package com.facebook.common.references;

import android.graphics.Bitmap;
import android.os.Build;
import com.facebook.common.logging.FLog;
import javax.annotation.Nullable;

/* JADX INFO: loaded from: classes22.dex */
public class HWClosableReleaser implements ResourceReleaser<Bitmap> {
    private static long DEFAULT_MAX_SIZE = 67108864;
    private static HWClosableReleaser sInstance;
    private long mFreeValues;
    private long mInUseValues;
    private long mMaxSize;

    public static HWClosableReleaser getInstance() {
        if (sInstance != null) goto L15;
        monitor-enter(HWClosableReleaser.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sInstance != null) goto L9;
        sInstance = new HWClosableReleaser();     // Catch: Throwable -> L11
    L9:
        monitor-exit(HWClosableReleaser.class);     // Catch: Throwable -> L11
    L15:
        return sInstance;
    }

    public long getFreeValues() {
        return this.mMaxSize - this.mInUseValues;
    }

    public HWClosableReleaser() {
        this.mMaxSize = DEFAULT_MAX_SIZE;
    }

    public synchronized void addBitmap(Bitmap r100) {
        monitor-enter(this);
        this.mInUseValues += (long) getSizeInBytes(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized boolean canAddBitmap(Bitmap r100) {
        monitor-enter(this);
        if (getSizeInBytes(r100) >= (this.mMaxSize - this.mInUseValues)) goto L7;
        boolean r101 = true;
    L8:
        monitor-exit(this);
        return r101;
    L7:
        r101 = false;
    L10:
        th = move-exception;
        throw th;
    }

    public synchronized void decreaseBitmap(Bitmap r100) {
        monitor-enter(this);
        this.mInUseValues -= (long) getSizeInBytes(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public int getSizeInBytes(@Nullable Bitmap r100) {
        if (r100 != null) goto L9;
        return 0;
    L9:
        return r100.getAllocationByteCount();
    L8:
        return r100.getByteCount();
    }

    /* JADX INFO: renamed from: release, reason: avoid collision after fix types in other method */
    public void release2(Bitmap r100) {
    L10:
        th = move-exception;
        FLog.d("debug_hw", "HWClosableReleaser, release: t = " + th);
        return;
    L3:
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        if (r100.getConfig() != Bitmap.Config.HARDWARE) goto L16;
        decreaseBitmap(r100);     // Catch: Throwable -> L10
        if (r100.isRecycled() == true) goto L17;
        r100.recycle();     // Catch: Throwable -> L10
        return;
    L17:
        return;
    }

    public void setMaxSize(long r100) {
        this.mMaxSize = r100;
    }

    @Override // com.facebook.common.references.ResourceReleaser
    public /* bridge */ /* synthetic */ void release(Bitmap r100) {
        release2(r100);
    }
}
