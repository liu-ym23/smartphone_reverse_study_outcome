package rc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f537168a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f537169b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537170c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f537171d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Integer f537172e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f537173f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final pc8.a f537174g;

    public c() {
        this(null, null, null, null, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (Intrinsics.areEqual(this.f537168a, r101.f537168a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f537169b, r101.f537169b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f537170c, r101.f537170c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f537171d, r101.f537171d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f537172e, r101.f537172e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f537173f, r101.f537173f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f537174g, r101.f537174g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        String r100 = this.f537168a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.f537169b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f537170c;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f537171d;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Integer r113 = this.f537172e;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f537173f;
        if (r116 != null) goto L25;
        int r117 = 0;
    L26:
        int r118 = (r115 + r117) * 31;
        pc8.a r119 = this.f537174g;
        if (r119 == null) goto L31;
        r101 = r119.hashCode();
    L31:
        return r118 + r101;
    L25:
        r117 = r116.hashCode();
        goto L26
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "BubbleBannerNotifyInput(title=" + this.f537168a + ", icon=" + this.f537169b + ", content=" + this.f537170c + ", skipSchema=" + this.f537171d + ", layout=" + this.f537172e + ", data=" + this.f537173f + ", clickAction=" + this.f537174g + ')';
    }

    public c(String r100, String r101, String r102, String r103, Integer r104, String r105, pc8.a r106) {
        this.f537168a = r100;
        this.f537169b = r101;
        this.f537170c = r102;
        this.f537171d = r103;
        this.f537172e = r104;
        this.f537173f = r105;
        this.f537174g = r106;
    }
}
