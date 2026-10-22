package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class g1 implements juc.d<Long> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g1 f520681a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520682b = null;

    public g1() {
    }

    static {
        f520681a = new g1();
        f520682b = new m2("kotlin.Long", luc.e.g.f510855a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520682b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Long.valueOf(r100.decodeLong());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        long r102 = ((Number) r101).longValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeLong(r102);
    }
}
