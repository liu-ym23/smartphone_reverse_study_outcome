package n28;

import kotlin.Unit;
import kotlin.jvm.functions.Function4;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class o extends a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f516780a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final int f516781b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f516782c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f516783d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function4<Integer, Integer, Integer, Integer, Unit> f516784e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L5;
    L30:
        return true;
    L5:
        if ((r100 instanceof o) == false) goto L29;
        o r101 = (o) r100;
        if (this.f516780a != r101.f516780a) goto L9;
        boolean r102 = true;
    L10:
        if (r102 == false) goto L29;
        if (this.f516781b != r101.f516781b) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == false) goto L29;
        if (this.f516782c != r101.f516782c) goto L19;
        boolean r104 = true;
    L20:
        if (r104 == false) goto L29;
        if (this.f516783d != r101.f516783d) goto L24;
        boolean r105 = true;
    L25:
        if (r105 == false) goto L29;
        if (Intrinsics.areEqual(this.f516784e, r101.f516784e) == false) goto L29;
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
        int r100 = ((((((this.f516780a * 31) + this.f516781b) * 31) + this.f516782c) * 31) + this.f516783d) * 31;
        Function4<Integer, Integer, Integer, Integer, Unit> r101 = this.f516784e;
        if (r101 == null) goto L5;
        int r102 = r101.hashCode();
    L7:
        return r100 + r102;
    L5:
        r102 = 0;
        goto L7
    }

    public final String toString() {
        return "OnScrollChangedParam(l=" + this.f516780a + ", t=" + this.f516781b + ", oldl=" + this.f516782c + ", oldt=" + this.f516783d + ", superMethod=" + this.f516784e + ")";
    }

    @Override // n28.a
    public final void b() {
        this.f516784e.invoke(Integer.valueOf(this.f516780a), Integer.valueOf(this.f516781b), Integer.valueOf(this.f516782c), Integer.valueOf(this.f516783d));
    }

    /* JADX WARN: Multi-variable type inference failed */
    public o(int r100, int r101, int r102, int r103, Function4<? super Integer, ? super Integer, ? super Integer, ? super Integer, Unit> r104) {
        this.f516780a = r100;
        this.f516781b = r101;
        this.f516782c = r102;
        this.f516783d = r103;
        this.f516784e = r104;
    }
}
