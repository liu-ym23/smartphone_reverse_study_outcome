package com.ss.android.vesdk;

import android.graphics.Bitmap;
import com.ss.android.ttve.nativePort.TEVideoUtils;

/* JADX INFO: loaded from: classes40.dex */
public class VEMediaParser {
    private volatile long mHandler;

    public synchronized void release() {
        monitor-enter(this);
        TEVideoUtils.releaseGetFrameHandler(this.mHandler);     // Catch: Throwable -> L6
        this.mHandler = 0;     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public VEMediaParser() {
        this.mHandler = 0;
    }

    public synchronized void init(String r100) {
        monitor-enter(this);
        this.mHandler = TEVideoUtils.createGetFrameHandler(r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public synchronized Bitmap getVideoFrame(int r100, int r101, int r102, boolean r110) throws VEException {
        monitor-enter(this);
    L12:
        th = move-exception;
        throw th;
    L5:
        if (this.mHandler != 0) goto L9;
        monitor-exit(this);
        return null;
    L9:
        Bitmap r103 = TEVideoUtils.getFrameWithHandler(this.mHandler, r100, r101, r102, r110);     // Catch: Throwable -> L12
        monitor-exit(this);
        return r103;
    }
}
