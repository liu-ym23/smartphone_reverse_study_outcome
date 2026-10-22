package nuc;

import kotlin.UInt;
import kotlin.jvm.internal.IntCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class g3 implements juc.d<UInt> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final g3 f520695a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r0 f520696b = null;

    public g3() {
    }

    static {
        f520695a = new g3();
        kuc.a.e(IntCompanionObject.INSTANCE);
        f520696b = t0.a("kotlin.UInt", w0.f520792a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520696b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return UInt.m9538boximpl(UInt.m9544constructorimpl(r100.decodeInline(f520696b).decodeInt()));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        int r102 = ((UInt) r101).m9596unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeInline(f520696b).encodeInt(r102);
    }
}
