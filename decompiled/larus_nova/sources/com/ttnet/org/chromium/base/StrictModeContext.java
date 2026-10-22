package com.ttnet.org.chromium.base;

import android.os.Build;
import android.os.StrictMode;
import java.io.Closeable;

/* JADX INFO: loaded from: classes6.dex */
public final class StrictModeContext implements Closeable {
    private final StrictMode.ThreadPolicy mThreadPolicy;
    private final StrictMode.VmPolicy mVmPolicy;

    @Override // java.io.Closeable, java.lang.AutoCloseable
    public void close() {
        StrictMode.ThreadPolicy r100 = this.mThreadPolicy;
        if (r100 == null) goto L5;
        StrictMode.setThreadPolicy(r100);
    L5:
        StrictMode.VmPolicy r101 = this.mVmPolicy;
        if (r101 == null) goto L9;
        StrictMode.setVmPolicy(r101);
        return;
    }

    public static StrictModeContext allowAllThreadPolicies() {
        StrictMode.ThreadPolicy r100 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(StrictMode.ThreadPolicy.LAX);
        return new StrictModeContext(r100);
    }

    public static StrictModeContext allowAllVmPolicies() {
        StrictMode.VmPolicy r100 = StrictMode.getVmPolicy();
        StrictMode.setVmPolicy(StrictMode.VmPolicy.LAX);
        return new StrictModeContext(r100);
    }

    public static StrictModeContext allowDiskReads() {
        return new StrictModeContext(StrictMode.allowThreadDiskReads());
    }

    public static StrictModeContext allowDiskWrites() {
        return new StrictModeContext(StrictMode.allowThreadDiskWrites());
    }

    public static StrictModeContext allowSlowCalls() {
        StrictMode.ThreadPolicy r100 = StrictMode.getThreadPolicy();
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r100).permitCustomSlowCalls().build());
        return new StrictModeContext(r100);
    }

    public static StrictModeContext allowUnbufferedIo() {
        StrictMode.ThreadPolicy r100 = StrictMode.getThreadPolicy();
        if (Build.VERSION.SDK_INT < 26) goto L6;
        StrictMode.setThreadPolicy(new StrictMode.ThreadPolicy.Builder(r100).permitUnbufferedIo().build());
    L6:
        return new StrictModeContext(r100);
    }

    private StrictModeContext(StrictMode.ThreadPolicy r100) {
        this(r100, null);
    }

    private StrictModeContext(StrictMode.VmPolicy r100) {
        this(null, r100);
    }

    private StrictModeContext(StrictMode.ThreadPolicy r100, StrictMode.VmPolicy r101) {
        this.mThreadPolicy = r100;
        this.mVmPolicy = r101;
    }
}
