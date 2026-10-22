package com.ss.videoarch.liveplayer2;

/* JADX INFO: loaded from: classes38.dex */
public final class VeLivePlayerLogConfig {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f459686a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f459687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f459688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f459689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f459690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f459691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f459692g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f459693h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final VeLivePlayerLogLevel f459694i;

    public final String toString() {
        return "VeLivePlayerLogConfig{deviceID='null', logPath='null', maxLogSizeM=" + this.f459686a + ", singleLogSizeM=" + this.f459687b + ", logExpireTimeS=" + this.f459688c + ", enableConsole=" + this.f459689d + ", enableLogFile=" + this.f459690e + ", queryUrl='" + this.f459691f + "', enableThreadLoop=" + this.f459692g + ", intervalMS=" + this.f459693h + ", logLevel=" + this.f459694i + '}';
    }

    public VeLivePlayerLogConfig() {
        this.f459686a = 100;
        this.f459687b = 2;
        this.f459688c = 604800;
        this.f459689d = true;
        this.f459690e = true;
        this.f459691f = "";
        this.f459692g = true;
        this.f459693h = 120000;
        this.f459694i = VeLivePlayerLogLevel.VeLivePlayerLogLevelVerbose;
    }
}
