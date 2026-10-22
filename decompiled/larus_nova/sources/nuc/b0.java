package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class b0 implements juc.d<Double> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b0 f520644a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520645b = null;

    public b0() {
    }

    static {
        f520644a = new b0();
        f520645b = new m2("kotlin.Double", luc.e.d.f510852a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520645b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Double.valueOf(r100.decodeDouble());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        double r102 = ((Number) r101).doubleValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeDouble(r102);
    }
}
