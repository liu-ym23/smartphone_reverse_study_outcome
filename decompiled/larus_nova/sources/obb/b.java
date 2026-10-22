package obb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f522637a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f522638b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f522639c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Integer f522640d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f522641e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f522642f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public Long f522643g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public String f522644h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Long f522645i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (this.f522637a == r101.f522637a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f522638b, r101.f522638b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f522639c, r101.f522639c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f522640d, r101.f522640d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f522641e, r101.f522641e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f522642f, r101.f522642f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f522643g, r101.f522643g) == true) goto L30;
        return false;
    L30:
        if (Intrinsics.areEqual(this.f522644h, r101.f522644h) == true) goto L33;
        return false;
    L33:
        if (Intrinsics.areEqual(this.f522645i, r101.f522645i) == true) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f522637a * 31;
        String r101 = this.f522638b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f522639c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        Integer r108 = this.f522640d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f522641e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        Integer r114 = this.f522642f;
        if (r114 != null) goto L21;
        int r115 = 0;
    L22:
        int r116 = (r113 + r115) * 31;
        Long r117 = this.f522643g;
        if (r117 != null) goto L25;
        int r118 = 0;
    L26:
        int r119 = (r116 + r118) * 31;
        String r120 = this.f522644h;
        if (r120 != null) goto L29;
        int r121 = 0;
    L30:
        int r122 = (r119 + r121) * 31;
        Long r123 = this.f522645i;
        if (r123 == null) goto L35;
        r102 = r123.hashCode();
    L35:
        return r122 + r102;
    L29:
        r121 = r120.hashCode();
        goto L30
    L25:
        r118 = r117.hashCode();
        goto L26
    L21:
        r115 = r114.hashCode();
        goto L22
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
        return "DocsMetaInfo(type=" + this.f522637a + ", token=" + this.f522638b + ", fileType=" + this.f522639c + ", iconType=" + this.f522640d + ", iconKey=" + this.f522641e + ", version=" + this.f522642f + ", localWriteTime=" + this.f522643g + ", title=" + this.f522644h + ", objSubType=" + this.f522645i + ')';
    }

    public final int getType() {
        return this.f522637a;
    }

    public /* synthetic */ b(int r110, String r111, String r112, Integer r113, String r114, Integer r115, String r116, Long r117, int r118) {
        if ((r118 & 128) == 0) goto L5;
        String r100 = null;
    L7:
        if ((r118 & 256) == 0) goto L9;
        Long r101 = null;
    L10:
        this(r110, r111, r112, r113, r114, r115, null, r100, r101);
        return;
    L9:
        r101 = r117;
        goto L10
    L5:
        r100 = r116;
        goto L7
    }

    public b(int r100, String r101, String r102, Integer r103, String r104, Integer r105, Long r106, String r107, Long r108) {
        this.f522637a = r100;
        this.f522638b = r101;
        this.f522639c = r102;
        this.f522640d = r103;
        this.f522641e = r104;
        this.f522642f = r105;
        this.f522643g = r106;
        this.f522644h = r107;
        this.f522645i = r108;
    }
}
