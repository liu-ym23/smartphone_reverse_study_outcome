package com.bytedance.ee.bear.bitable.chameleon.render.cache;

import com.bytedance.ee.bear.bitable.chameleon.BitableSubType;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public final class g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BitableSubType f209712a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f209713b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final c f209714c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f209715d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f209716e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f209717f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f209718g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f209719h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public boolean f209720i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (this.f209712a == r101.f209712a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f209713b, r101.f209713b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f209714c, r101.f209714c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f209715d, r101.f209715d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f209716e, r101.f209716e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f209717f, r101.f209717f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f209718g, r101.f209718g) == true) goto L30;
        return false;
    L30:
        if (this.f209719h == r101.f209719h) goto L33;
        return false;
    L33:
        if (this.f209720i == r101.f209720i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = ((this.f209712a.hashCode() * 31) + this.f209713b.hashCode()) * 31;
        c r101 = this.f209714c;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f209715d;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f209716e;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f209717f;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        String r114 = this.f209718g;
        if (r114 == null) goto L22;
        r102 = r114.hashCode();
    L22:
        int r115 = (r113 + r102) * 31;
        int r116 = 1231;
        if (this.f209719h == false) goto L25;
        int r117 = 1231;
    L26:
        int r118 = (r115 + r117) * 31;
        if (this.f209720i == true) goto L31;
        r116 = 1237;
    L31:
        return r118 + r116;
    L25:
        r117 = 1237;
        goto L26
    L17:
        r112 = r111.hashCode();
        goto L18
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "BitableCacheSnapshot(scene=" + this.f209712a + ", token=" + this.f209713b + ", firstBlock=" + this.f209714c + ", cacheClientVars=" + this.f209715d + ", mainPage=" + this.f209716e + ", recordData=" + this.f209717f + ", addRecordPage=" + this.f209718g + ", nativeLocalCSReady=" + this.f209719h + ", nativeMainPageReady=" + this.f209720i + ')';
    }

    public g(BitableSubType r100, String r101, c r102, String r103, String r104, String r105, String r106, boolean r107) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "token");
        this.f209712a = r100;
        this.f209713b = r101;
        this.f209714c = r102;
        this.f209715d = r103;
        this.f209716e = r104;
        this.f209717f = r105;
        this.f209718g = r106;
        this.f209719h = r107;
        this.f209720i = false;
    }
}
