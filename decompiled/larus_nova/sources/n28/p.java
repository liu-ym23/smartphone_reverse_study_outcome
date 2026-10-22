package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class p extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516785a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516786b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f516787c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f516788d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function4<Integer, Integer, Integer, Integer, Unit> f516789e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L30:
        return true;
    L5:
        if ((r100 instanceof p) == false) goto L29;
        p r101 = (p) r100;
        if (this.f516785a != r101.f516785a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L29;
        if (this.f516786b != r101.f516786b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L29;
        if (this.f516787c != r101.f516787c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L29;
        if (this.f516788d != r101.f516788d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L29;
        if (Intrinsics.areEqual(this.f516789e, r101.f516789e) == false) goto L29;
    L24:
        r105 = false;
        goto L25
    L19:
        r104 = false;
        goto L20
    L14:
        r103 = false;
        goto L15
    L9:
        r102 = false;
    L29:
        return false;
    }

    public final int hashCode() {
        int r100 = ((((((this.f516785a * 31) + this.f516786b) * 31) + this.f516787c) * 31) + this.f516788d) * 31;
        Function4<Integer, Integer, Integer, Integer, Unit> r101 = this.f516789e;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "OnSizeChangedParam(w=" + this.f516785a + ", h=" + this.f516786b + ", oldw=" + this.f516787c + ", oldh=" + this.f516788d + ", superMethod=" + this.f516789e + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516789e.invoke(Integer.valueOf(this.f516785a), Integer.valueOf(this.f516786b), Integer.valueOf(this.f516787c), Integer.valueOf(this.f516788d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public p(int r100, int r101, int r102, int r103, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r104) {
        this.f516785a = r100;
        this.f516786b = r101;
        this.f516787c = r102;
        this.f516788d = r103;
        this.f516789e = r104;
    }
}
