package rd6;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes28.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Object f537275a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f537276b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f537277c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Throwable f537278d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f537279e;

    public a() {
        this(null, 0, null, null, null);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.f537275a, r101.f537275a) == true) goto L12;
        return false;
    L12:
        if (this.f537276b == r101.f537276b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f537277c, r101.f537277c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f537278d, r101.f537278d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f537279e, r101.f537279e) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public final int hashCode() {
        Object r100 = this.f537275a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f537276b) * 31;
        String r104 = this.f537277c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Throwable r107 = this.f537278d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        d r110 = this.f537279e;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
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
        return "ExprResponse(result=" + this.f537275a + ", code=" + this.f537276b + ", msg=" + this.f537277c + ", throwable=" + this.f537278d + ", runtimeInfo=" + this.f537279e + ')';
    }

    public final void setResult(Object r100) {
        this.f537275a = r100;
    }

    public a(Object r100, int r101, String r102, Throwable r103, d r104) {
        this.f537275a = r100;
        this.f537276b = r101;
        this.f537277c = r102;
        this.f537278d = r103;
        this.f537279e = r104;
    }
}
