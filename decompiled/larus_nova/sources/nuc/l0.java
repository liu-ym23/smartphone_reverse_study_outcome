package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class l0 implements juc.d<Float> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l0 f520731a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520732b = null;

    public l0() {
    }

    static {
        f520731a = new l0();
        f520732b = new m2("kotlin.Float", luc.e.C6738e.f510853a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520732b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Float.valueOf(r100.decodeFloat());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        float r102 = ((Number) r101).floatValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeFloat(r102);
    }
}
