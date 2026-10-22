package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final class VeLivePlayerConfiguration {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f459677a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f459678b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f459679c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f459680d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final int f459681e;

    public final String toString() {
        return "VeLivePlayerConfiguration{enableSei=false, enableHardwareDecode=" + this.f459677a + ", networkTimeoutMs=" + this.f459678b + ", retryIntervalTimeMs=" + this.f459679c + ", retryMaxCount=" + this.f459680d + ", enableLiveDNS=false, enableStatisticsCallback=false, statisticsCallbackInterval=" + this.f459681e + '}';
    }

    public VeLivePlayerConfiguration() {
        this.f459677a = true;
        this.f459678b = 5000;
        this.f459679c = 5000;
        this.f459680d = 5;
        this.f459681e = 5;
    }
}
