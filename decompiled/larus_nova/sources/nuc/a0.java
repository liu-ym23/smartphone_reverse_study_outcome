package nuc;

import kotlin.jvm.internal.DoubleCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a0 extends l2<Double, double[], z> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a0 f520640c = null;

    static {
        f520640c = new a0();
    }

    @Override // nuc.l2
    public final double[] k() {
        return new double[0];
    }

    public a0() {
        Intrinsics.checkNotNullParameter(DoubleCompanionObject.INSTANCE, "<this>");
        super(b0.f520644a);
    }

    @Override // nuc.a
    public final int e(Object r100) {
        double[] r101 = (double[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return r101.length;
    }

    @Override // nuc.a
    public final Object i(Object r100) {
        double[] r101 = (double[]) r100;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        return new z(r101);
    }

    @Override // nuc.l2
    public final void l(muc.d r100, double[] r101, int r102) {
        double[] r103 = r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r103, "content");
        int r104 = 0;
    L3:
        if (r104 >= r102) goto L5;
        r100.encodeDoubleElement(this.f520733b, r104, r103[r104]);
        r104 = r104 + 1;
        goto L3
    }

    @Override // nuc.v, nuc.a
    public final void h(muc.c r100, int r101, Object r102, boolean r103) {
        z r104 = (z) r102;
        Intrinsics.checkNotNullParameter(r100, "decoder");
        Intrinsics.checkNotNullParameter(r104, "builder");
        double r105 = r100.decodeDoubleElement(this.f520733b, r101);
        r104.getClass();
        j2.c(r104);
        double[] r106 = r104.f520807a;
        int r107 = r104.f520808b;
        r104.f520808b = r107 + 1;
        r106[r107] = r105;
    }
}
