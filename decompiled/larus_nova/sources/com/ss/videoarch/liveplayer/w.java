package com.ss.videoarch.liveplayer;

/* JADX INFO: loaded from: classes38.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public boolean f459658a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f459659b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f459660c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f459661d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public int f459662e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f459663f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f459664g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f459665h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public long f459666i;

    public String toString() {
        return "VeLivePlayerConfiguration{enableSei=" + this.f459658a + ", enableHardwareDecode=" + this.f459659b + ", networkTimeoutMs=" + this.f459660c + ", retryIntervalTimeMs=" + this.f459661d + ", retryMaxCount=" + this.f459662e + ", enableLiveDNS=" + this.f459663f + ", enableStatisticsCallback=false, statisticsCallbackInterval=" + this.f459664g + '}';
    }

    public w() {
        this.f459658a = false;
        this.f459659b = true;
        this.f459660c = 5000;
        this.f459661d = 5000;
        this.f459662e = 5;
        this.f459663f = false;
        this.f459664g = 5;
        this.f459665h = "";
        this.f459666i = 60000;
    }
}
