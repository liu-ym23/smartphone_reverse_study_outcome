package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class u2 implements juc.d<Short> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final u2 f520784a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520785b = null;

    public u2() {
    }

    static {
        f520784a = new u2();
        f520785b = new m2("kotlin.Short", luc.e.h.f510856a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520785b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Short.valueOf(r100.decodeShort());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        short r102 = ((Number) r101).shortValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeShort(r102);
    }
}
