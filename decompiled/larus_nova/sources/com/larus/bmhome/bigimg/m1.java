package com.larus.bmhome.bigimg;

/* JADX INFO: loaded from: classes25.dex */
public final class m1 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f296022a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f296023b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f296024c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f296025d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f296026e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f296027f;

    public m1(String r100, String r101, String r102, Integer r103, Integer r104, String r105) {
        this.f296022a = r100;
        this.f296023b = r101;
        this.f296024c = r102;
        this.f296025d = r103;
        this.f296026e = r104;
        this.f296027f = r105;
    }

    public /* synthetic */ m1(String r100, String r101, String r102, Integer r110, Integer r111, String r112, int r113) {
        if ((r113 & 1) == 0) goto L5;
        String r103 = null;
    L7:
        if ((r113 & 2) == 0) goto L9;
        String r104 = null;
    L11:
        if ((r113 & 4) == 0) goto L13;
        String r105 = null;
    L15:
        if ((r113 & 8) == 0) goto L17;
        Integer r106 = null;
    L19:
        if ((r113 & 16) == 0) goto L21;
        Integer r107 = null;
    L23:
        if ((r113 & 32) == 0) goto L25;
        String r114 = null;
    L26:
        this(r103, r104, r105, r106, r107, r114);
        return;
    L25:
        r114 = r112;
        goto L26
    L21:
        r107 = r111;
        goto L23
    L17:
        r106 = r110;
        goto L19
    L13:
        r105 = r102;
        goto L15
    L9:
        r104 = r101;
        goto L11
    L5:
        r103 = r100;
        goto L7
    }
}
