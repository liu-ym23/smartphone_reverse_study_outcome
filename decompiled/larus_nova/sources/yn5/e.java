package yn5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f568556a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f568557b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f568558c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f568559d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f568560e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof e) == true) goto L8;
        return false;
    L8:
        e r101 = (e) r100;
        if (this.f568556a == r101.f568556a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f568557b, r101.f568557b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f568558c, r101.f568558c) == true) goto L18;
        return false;
    L18:
        if (this.f568559d == r101.f568559d) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f568560e, r101.f568560e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f568556a * 31;
        String r101 = this.f568557b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        String r105 = this.f568558c;
        if (r105 != null) goto L9;
        int r106 = 0;
    L10:
        int r107 = (r104 + r106) * 31;
        if (this.f568559d == false) goto L13;
        int r108 = 1231;
    L14:
        int r109 = (r107 + r108) * 31;
        String r110 = this.f568560e;
        if (r110 == null) goto L19;
        r102 = r110.hashCode();
    L19:
        return r109 + r102;
    L13:
        r108 = 1237;
        goto L14
    L9:
        r106 = r105.hashCode();
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "TemplateTagParams(type=" + this.f568556a + ", token=" + this.f568557b + ", name=" + this.f568558c + ", openDoc=" + this.f568559d + ", newCustomFg=" + this.f568560e + ')';
    }

    public final int getType() {
        return this.f568556a;
    }

    public e(int r100, String r101, String r102, boolean r103, String r104) {
        this.f568556a = r100;
        this.f568557b = r101;
        this.f568558c = r102;
        this.f568559d = r103;
        this.f568560e = r104;
    }
}
