package com.bytedance.locallife.dito.core;

/* JADX INFO: loaded from: classes21.dex */
public final class s {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f257972a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f257973b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f257974c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final float f257975d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final float f257976e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f257977f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f257978g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f257979h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f257980i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final boolean f257981j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final boolean f257982k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final boolean f257983l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final boolean f257984m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final boolean f257985n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final boolean f257986o;

    public s(boolean r100, boolean r101, int r102, int r103, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, int r115) {
        boolean r104 = true;
        if ((r115 & 2) == 0) goto L6;
        r100 = true;
    L6:
        if ((r115 & 4) != 0) goto L10;
        r104 = false;
    L10:
        if ((r115 & 16) == 0) goto L12;
        float r105 = 0.5f;
    L14:
        if ((r115 & 64) == 0) goto L17;
        r101 = false;
    L17:
        if ((r115 & 128) == 0) goto L20;
        r102 = 0;
    L20:
        if ((r115 & 256) == 0) goto L23;
        r103 = 0;
    L23:
        if ((r115 & 1024) == 0) goto L26;
        r110 = false;
    L26:
        if ((r115 & 4096) == 0) goto L29;
        r111 = false;
    L29:
        if ((r115 & 8192) == 0) goto L32;
        r112 = false;
    L32:
        if ((r115 & 16384) == 0) goto L35;
        r113 = false;
    L35:
        if ((r115 & 32768) == 0) goto L37;
        r114 = false;
    L37:
        this.f257972a = r100;
        this.f257973b = r104;
        this.f257974c = false;
        this.f257975d = r105;
        this.f257976e = 0.0f;
        this.f257977f = r101;
        this.f257978g = r102;
        this.f257979h = r103;
        this.f257980i = 0;
        this.f257981j = r110;
        this.f257982k = false;
        this.f257983l = r111;
        this.f257984m = r112;
        this.f257985n = r113;
        this.f257986o = r114;
        return;
    L12:
        r105 = 0.0f;
        goto L14
    }
}
