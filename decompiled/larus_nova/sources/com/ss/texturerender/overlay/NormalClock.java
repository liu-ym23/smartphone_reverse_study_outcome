package com.ss.texturerender.overlay;

import android.os.SystemClock;
import com.ss.texturerender.TextureRenderLog;

/* JADX INFO: loaded from: classes40.dex */
public class NormalClock {
    private final String TAG;
    private boolean mIsUpdated;
    private long mPts;
    private int mStatus;
    private int mTexType;
    private long mUpdateTime;

    public synchronized long getClock() {
        monitor-enter(this);
        long r100 = this.mPts;     // Catch: Throwable -> L12
        long r101 = 0;
        if (this.mUpdateTime > 0) goto L6;
    L9:
        long r102 = r100 + r101;
        monitor-exit(this);
        return r102;
    L6:
        if (this.mStatus != 1) goto L9;
        r101 = SystemClock.elapsedRealtime() - this.mUpdateTime;
    L12:
        th = move-exception;
        throw th;
    }

    public synchronized void pause() {
        monitor-enter(this);
        this.mStatus = 2;     // Catch: Throwable -> L7
        this.mUpdateTime = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void start() {
        monitor-enter(this);
        this.mStatus = 1;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public synchronized void stop() {
        monitor-enter(this);
        this.mStatus = 3;     // Catch: Throwable -> L7
        this.mUpdateTime = 0;     // Catch: Throwable -> L7
        this.mIsUpdated = false;     // Catch: Throwable -> L7
        this.mPts = 0;     // Catch: Throwable -> L7
        monitor-exit(this);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public NormalClock(int r100) {
        this.mTexType = -1;
        this.TAG = TextureRenderLog.getLogTag(this);
        this.mPts = 0;
        this.mUpdateTime = 0;
        this.mStatus = 3;
        this.mIsUpdated = false;
        this.mTexType = r100;
    }

    public synchronized void updateClock(long r100) {
        monitor-enter(this);
        TextureRenderLog.d(this.mTexType, this.TAG, "updateClock masetr:" + r100 + " mIsUpdated:" + this.mIsUpdated + " mStatus:" + this.mStatus);     // Catch: Throwable -> L12
        if (this.mIsUpdated == true) goto L8;
        this.mIsUpdated = true;     // Catch: Throwable -> L12
        this.mStatus = 1;     // Catch: Throwable -> L12
    L8:
        if (this.mStatus != 1) goto L10;
        this.mPts = r100;     // Catch: Throwable -> L12
        this.mUpdateTime = SystemClock.elapsedRealtime();     // Catch: Throwable -> L12
    L10:
        monitor-exit(this);
        return;
    L12:
        th = move-exception;
        throw th;
    }
}
