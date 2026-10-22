package zj8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f572506a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f572507b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f572508c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f572509d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f572510e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final boolean f572511f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Integer f572512g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final boolean f572513h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final int f572514i;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (Intrinsics.areEqual(this.f572506a, r101.f572506a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f572507b, r101.f572507b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f572508c, r101.f572508c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f572509d, r101.f572509d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f572510e, r101.f572510e) == true) goto L24;
        return false;
    L24:
        if (this.f572511f == r101.f572511f) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f572512g, r101.f572512g) == true) goto L30;
        return false;
    L30:
        if (this.f572513h == r101.f572513h) goto L33;
        return false;
    L33:
        if (this.f572514i == r101.f572514i) goto L35;
        return false;
    L35:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f572506a.hashCode() * 31;
        String r101 = this.f572507b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f572508c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        String r108 = this.f572509d;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        String r111 = this.f572510e;
        if (r111 != null) goto L17;
        int r112 = 0;
    L18:
        int r113 = (r110 + r112) * 31;
        int r114 = 1231;
        if (this.f572511f == false) goto L21;
        int r115 = 1231;
    L22:
        int r116 = (r113 + r115) * 31;
        Integer r117 = this.f572512g;
        if (r117 == null) goto L26;
        r102 = r117.hashCode();
    L26:
        int r118 = (r116 + r102) * 31;
        if (this.f572513h == true) goto L31;
        r114 = 1237;
    L31:
        return ((r118 + r114) * 31) + this.f572514i;
    L21:
        r115 = 1237;
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
        return "CommonButtonV2ViewInput(id=" + this.f572506a + ", title=" + this.f572507b + ", iconUrlLight=" + this.f572508c + ", iconUrlDark=" + this.f572509d + ", schemeUrl=" + this.f572510e + ", hideButton=" + this.f572511f + ", localIconRes=" + this.f572512g + ", isMultiBtn=" + this.f572513h + ", iconPos=" + this.f572514i + ')';
    }

    public e(String r100, String r101, String r102, String r103, String r104, boolean r105, Integer r106, boolean r107, int r110) {
        Intrinsics.checkNotNullParameter(r100, "id");
        this.f572506a = r100;
        this.f572507b = r101;
        this.f572508c = r102;
        this.f572509d = r103;
        this.f572510e = r104;
        this.f572511f = r105;
        this.f572512g = r106;
        this.f572513h = r107;
        this.f572514i = r110;
    }
}
