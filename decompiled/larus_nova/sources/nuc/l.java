package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class l implements juc.d<Byte> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final l f520729a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520730b = null;

    public l() {
    }

    static {
        f520729a = new l();
        f520730b = new m2("kotlin.Byte", luc.e.b.f510850a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520730b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Byte.valueOf(r100.decodeByte());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        byte r102 = ((Number) r101).byteValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeByte(r102);
    }
}
