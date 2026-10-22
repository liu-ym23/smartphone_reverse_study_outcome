package com.larus.disk.impl;

import androidx.camera.video.AudioStats;

/* JADX INFO: loaded from: classes27.dex */
public final class m0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f330756a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f330757b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public String f330758c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public String f330759d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f330760e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f330761f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f330762g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final double f330763h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f330764i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public long f330765j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f330766k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final long f330767l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final long f330768m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final long f330769n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final String f330770o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final int f330771p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final long f330772q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final int f330773r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final long f330774s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final long f330775t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public final int f330776u;

    public m0() {
        this(null, null, null, null, false, false, 0, AudioStats.AUDIO_AMPLITUDE_NONE, 0, 0, false, 2097151);
    }

    public final String toString() {
        return "FileScanInfo(path=" + this.f330756a + ", originPath=" + this.f330757b + ", biz=" + this.f330758c + ", business=" + this.f330759d + ", isInternal=" + this.f330760e + ", isDirectory=" + this.f330761f + ", fileSize=" + this.f330762g + ", reportFileSize=" + this.f330763h + ", childFileCount=" + this.f330764i + ", bizFileThreshold=" + this.f330765j + ", isOverThreshold=" + this.f330766k + ", accessKnownBytes=" + this.f330767l + ", accessed7dBytes=" + this.f330768m + ", accessed30dBytes=" + this.f330769n + ", accessSource=" + this.f330770o + ", accessTrackedFileCount=" + this.f330771p + ", accessUpdateFailureCount=" + this.f330772q + ", accessObservationDays=" + this.f330773r + ", accessHookSuccessCount=" + this.f330774s + ", accessHookFailureCount=" + this.f330775t + ", accessHookLastErrorCode=" + this.f330776u + ')';
    }

    public /* synthetic */ m0(String r310, String r311, String r312, String r410, boolean r411, boolean r412, long r413, double r414, int r415, long r416, boolean r510, int r511) {
        if ((r511 & 1) == 0) goto L5;
        String r100 = "";
    L7:
        if ((r511 & 2) == 0) goto L9;
        String r101 = "";
    L11:
        if ((r511 & 4) == 0) goto L13;
        String r102 = "unknown";
    L15:
        if ((r511 & 8) == 0) goto L17;
        String r103 = "unknown";
    L18:
        boolean r104 = false;
        if ((r511 & 16) == 0) goto L21;
        boolean r105 = false;
    L23:
        if ((r511 & 32) == 0) goto L25;
        boolean r106 = false;
    L27:
        if ((r511 & 64) == 0) goto L29;
        long r110 = 0;
    L31:
        if ((r511 & 128) == 0) goto L33;
        double r111 = AudioStats.AUDIO_AMPLITUDE_NONE;
    L35:
        if ((r511 & 256) == 0) goto L37;
        int r107 = 0;
    L39:
        if ((r511 & 512) == 0) goto L41;
        long r112 = -1;
    L43:
        if ((r511 & 1024) != 0) goto L47;
        r104 = r510;
    L47:
        if ((r511 & 2048) == 0) goto L49;
        long r210 = -1;
    L51:
        if ((r511 & 4096) == 0) goto L53;
        long r211 = -1;
    L55:
        if ((r511 & 8192) == 0) goto L57;
        long r212 = -1;
    L58:
        this(r100, r101, r102, r103, r105, r106, r110, r111, r107, r112, r104, r210, r211, r212, null, 0, 0, 0, 0, 0, 0);
        return;
    L57:
        r212 = 0;
        goto L58
    L53:
        r211 = 0;
        goto L55
    L49:
        r210 = 0;
        goto L51
    L41:
        r112 = r416;
        goto L43
    L37:
        r107 = r415;
        goto L39
    L33:
        r111 = r414;
        goto L35
    L29:
        r110 = r413;
        goto L31
    L25:
        r106 = r412;
        goto L27
    L21:
        r105 = r411;
        goto L23
    L17:
        r103 = r410;
        goto L18
    L13:
        r102 = r312;
        goto L15
    L9:
        r101 = r311;
        goto L11
    L5:
        r100 = r310;
        goto L7
    }

    public m0(String r100, String r101, String r102, String r103, boolean r104, boolean r105, long r110, double r111, int r112, long r113, boolean r114, long r115, long r210, long r211, String r212, int r213, long r214, int r215, long r216, long r310, int r311) {
        this.f330756a = r100;
        this.f330757b = r101;
        this.f330758c = r102;
        this.f330759d = r103;
        this.f330760e = r104;
        this.f330761f = r105;
        this.f330762g = r110;
        this.f330763h = r111;
        this.f330764i = r112;
        this.f330765j = r113;
        this.f330766k = r114;
        this.f330767l = r115;
        this.f330768m = r210;
        this.f330769n = r211;
        this.f330770o = r212;
        this.f330771p = r213;
        this.f330772q = r214;
        this.f330773r = r215;
        this.f330774s = r216;
        this.f330775t = r310;
        this.f330776u = r311;
    }
}
