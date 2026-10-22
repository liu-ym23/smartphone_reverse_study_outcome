package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class u extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516796a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516797b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f516798c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f516799d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function4<Integer, Integer, Integer, Integer, Unit> f516800e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L30:
        return true;
    L5:
        if ((r100 instanceof u) == false) goto L29;
        u r101 = (u) r100;
        if (this.f516796a != r101.f516796a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L29;
        if (this.f516797b != r101.f516797b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L29;
        if (this.f516798c != r101.f516798c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L29;
        if (this.f516799d != r101.f516799d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L29;
        if (Intrinsics.areEqual(this.f516800e, r101.f516800e) == false) goto L29;
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
        int r100 = ((((((this.f516796a * 31) + this.f516797b) * 31) + this.f516798c) * 31) + this.f516799d) * 31;
        Function4<Integer, Integer, Integer, Integer, Unit> r101 = this.f516800e;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "SetPaddingParam(left=" + this.f516796a + ", top=" + this.f516797b + ", right=" + this.f516798c + ", bottom=" + this.f516799d + ", superMethod=" + this.f516800e + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516800e.invoke(Integer.valueOf(this.f516796a), Integer.valueOf(this.f516797b), Integer.valueOf(this.f516798c), Integer.valueOf(this.f516799d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public u(int r100, int r101, int r102, int r103, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r104) {
        this.f516796a = r100;
        this.f516797b = r101;
        this.f516798c = r102;
        this.f516799d = r103;
        this.f516800e = r104;
    }
}
