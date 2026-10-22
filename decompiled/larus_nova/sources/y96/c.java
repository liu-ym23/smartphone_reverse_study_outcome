package y96;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f566979a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f566980b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f566981c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f566982d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Throwable f566983e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Integer f566984f;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof c) == true) goto L8;
        return false;
    L8:
        c r101 = (c) r100;
        if (this.f566979a == r101.f566979a) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f566980b, r101.f566980b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f566981c, r101.f566981c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f566982d, r101.f566982d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f566983e, r101.f566983e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f566984f, r101.f566984f) == true) goto L26;
        return false;
    L26:
        return true;
    }

    public final int hashCode() {
        if (this.f566979a == false) goto L5;
        int r100 = 1231;
    L6:
        int r101 = ((r100 * 31) + this.f566980b.hashCode()) * 31;
        Object r102 = this.f566981c;
        int r103 = 0;
        if (r102 != null) goto L9;
        int r104 = 0;
    L10:
        int r105 = (r101 + r104) * 31;
        String r106 = this.f566982d;
        if (r106 != null) goto L13;
        int r107 = 0;
    L14:
        int r108 = (r105 + r107) * 31;
        Throwable r109 = this.f566983e;
        if (r109 != null) goto L17;
        int r110 = 0;
    L18:
        int r111 = (r108 + r110) * 31;
        Integer r112 = this.f566984f;
        if (r112 == null) goto L23;
        r103 = r112.hashCode();
    L23:
        return r111 + r103;
    L17:
        r110 = r109.hashCode();
        goto L18
    L13:
        r107 = r106.hashCode();
        goto L14
    L9:
        r104 = r102.hashCode();
        goto L10
    L5:
        r100 = 1237;
        goto L6
    }

    public final String toString() {
        return "YataExprResult(isThrowable=" + this.f566979a + ", originExpr=" + this.f566980b + ", data=" + this.f566981c + ", errorExpr=" + this.f566982d + ", throwable=" + this.f566983e + ", code=" + this.f566984f + ')';
    }

    public c(boolean r100, String r101, Object r102, String r103, Throwable r104, Integer r105) {
        Intrinsics.checkNotNullParameter(r101, "originExpr");
        this.f566979a = r100;
        this.f566980b = r101;
        this.f566981c = r102;
        this.f566982d = r103;
        this.f566983e = r104;
        this.f566984f = r105;
    }
}
