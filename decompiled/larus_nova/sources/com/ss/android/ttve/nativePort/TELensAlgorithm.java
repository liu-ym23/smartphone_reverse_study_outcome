package com.ss.android.ttve.nativePort;

import com.ss.android.ttve.lensAlgorithm.VEBaseLensAlgorithmConfig;
import com.ss.android.ttve.lensAlgorithm.videoStable.VELensVideoStabResults;
import com.ss.android.ttve.lensAlgorithm.videoStable.VEVideoStabConfig;
import com.ss.android.vesdk.VELensCallBacks;

/* JADX INFO: loaded from: classes38.dex */
public class TELensAlgorithm {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public long f449960a;

    private native long nativeCreateLensEngine();

    private native int nativeDestroyLensEngine(long r100);

    private native VELensVideoStabResults nativeGetVideoStabResult(long r100, Object r101, VEVideoStabConfig r102);

    public final synchronized int a() {
        monitor-enter(this);
        long r100 = this.f449960a;     // Catch: Throwable -> L12
        if (r100 > 0) goto L9;
        monitor-exit(this);
        return -112;
    L9:
        int r101 = nativeDestroyLensEngine(r100);     // Catch: Throwable -> L12
        this.f449960a = 0;     // Catch: Throwable -> L12
        monitor-exit(this);
        return r101;
    L12:
        th = move-exception;
        throw th;
    }

    public final synchronized int c() {
        monitor-enter(this);
    L15:
        th = move-exception;
        throw th;
    L4:
        if (this.f449960a > 0) goto L6;
    L6:
        long r100 = nativeCreateLensEngine();     // Catch: Throwable -> L15
        this.f449960a = r100;     // Catch: Throwable -> L15
        if (r100 > 0) goto L12;
        monitor-exit(this);
        return -112;
    L12:
        monitor-exit(this);
        return 0;
    }

    public TELensAlgorithm() {
        this.f449960a = 0;
    }

    static {
        TENativeLibsLoader.loadLibrary();
    }

    public final VELensVideoStabResults b(VEBaseLensAlgorithmConfig r100, VELensCallBacks r101) {
        long r102 = this.f449960a;
        if (r102 > 0) goto L6;
        return null;
    L6:
        if (r100.algorithmFlag == 16) goto L9;
        return null;
    L9:
        return nativeGetVideoStabResult(r102, r101, (VEVideoStabConfig) r100);
    }
}
