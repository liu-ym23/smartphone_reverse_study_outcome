package com.loc;

import android.os.Build;
import com.bytedance.bdlocation.client.LocationInfoConst;
import n4a.f5;

/* JADX INFO: loaded from: classes32.dex */
public final enum al extends Enum<al> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final al f379903a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final al f379904b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final al f379905c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final al f379906d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final al f379907e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final al f379908f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final al f379909g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final al f379910h = null;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public static final al f379911i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final al f379912j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final al f379913k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final al f379914l = null;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public static final al f379915m = null;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public static final /* synthetic */ al[] f379916s = null;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private String f379917n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    private int f379918o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    private String f379919p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    private String f379920q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    private String f379921r;

    static {
        al r100 = new al("MIUI", 0, f5.o("IeGlhb21p"));
        f379903a = r100;
        al r101 = new al("Flyme", 1, f5.o("IbWVpenU"));
        f379904b = r101;
        al r102 = new al("RH", 2, f5.o("IaHVhd2Vp"));
        f379905c = r102;
        al r103 = new al("ColorOS", 3, f5.o("Ib3Bwbw"));
        f379906d = r103;
        al r104 = new al("FuntouchOS", 4, f5.o("Idml2bw"));
        f379907e = r104;
        al r105 = new al("SmartisanOS", 5, f5.o("Mc21hcnRpc2Fu"));
        f379908f = r105;
        al r110 = new al("AmigoOS", 6, f5.o("IYW1pZ28"));
        f379909g = r110;
        al r111 = new al("EUI", 7, f5.o("IbGV0dg"));
        f379910h = r111;
        al r112 = new al("Sense", 8, f5.o("EaHRj"));
        f379911i = r112;
        al r113 = new al("LG", 9, f5.o("EbGdl"));
        f379912j = r113;
        al r114 = new al(LocationInfoConst.GOOGLE, 10, f5.o("IZ29vZ2xl"));
        f379913k = r114;
        al r106 = new al("NubiaUI", 11, f5.o("IbnViaWE"));
        f379914l = r106;
        al r107 = new al("Other", 12, "");
        f379915m = r107;
        f379916s = new al[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107};
    }

    public al(String r100, int r101, String r102) {
        super(r100, r101);
        this.f379921r = Build.MANUFACTURER;
        this.f379917n = r102;
    }

    public static al valueOf(String r100) {
        return (al) r27.a.a(al.class, r100);
    }

    public static al[] values() {
        return (al[]) f379916s.clone();
    }

    public final String a() {
        return this.f379917n;
    }

    public final void a(int r100) {
        this.f379918o = r100;
    }

    public final void a(String r100) {
        this.f379919p = r100;
    }

    public final String b() {
        return this.f379919p;
    }

    public final void b(String r100) {
        this.f379920q = r100;
    }

    @Override // java.lang.Enum
    public final String toString() {
        return "ROM{name='" + name() + "',versionCode=" + this.f379918o + ", versionName='" + this.f379920q + "',ma=" + this.f379917n + "',manufacturer=" + this.f379921r + "'}";
    }
}
