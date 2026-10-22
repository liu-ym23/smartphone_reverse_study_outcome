package nuc;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class f0 extends g2 {

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final luc.o.b f520672m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f520673n;

    @Override // nuc.g2
    public final int hashCode() {
        int r100 = this.f520683a.hashCode();
        Intrinsics.checkNotNullParameter(this, "<this>");
        luc.j r101 = new luc.j(this);
        int r102 = 1;
    L4:
        if (r101.hasNext() == false) goto L11;
        int r103 = r102 * 31;
        String r104 = (String) r101.next();
        if (r104 == null) goto L8;
        int r105 = r104.hashCode();
    L9:
        r102 = r103 + r105;
        goto L4
    L8:
        r105 = 0;
        goto L9
    L11:
        return (r100 * 31) + r102;
    }

    @Override // nuc.g2
    public final String toString() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        return CollectionsKt.joinToString$default(new luc.k(this), ", ", this.f520683a + '(', ")", 0, null, null, 56, null);
    }

    @Override // nuc.g2, luc.f
    public final luc.o getKind() {
        return this.f520672m;
    }

    @Override // nuc.g2
    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if (r100 != null) goto L9;
        return false;
    L9:
        if ((r100 instanceof luc.f) == true) goto L11;
        return false;
    L11:
        luc.f r101 = (luc.f) r100;
        if (r101.getKind() == luc.o.b.f510876a) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f520683a, r101.f()) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(a2.a(this), a2.a(r101)) == true) goto L20;
        return false;
    L20:
        return true;
    }

    @Override // nuc.g2, luc.f
    public final luc.f h(int r100) {
        return ((luc.f[]) this.f520673n.getValue())[r100];
    }

    public f0(final String r100, final int r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        super(r100, null, r101);
        this.f520672m = luc.o.b.f510876a;
        this.f520673n = LazyKt.lazy(new e0(r101, r100, this));
    }
}
