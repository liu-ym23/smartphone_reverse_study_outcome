package nuc;

import kotlin.UShort;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.ShortCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class m3 implements juc.d<UShort> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final m3 f520738a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r0 f520739b = null;

    public m3() {
    }

    static {
        f520738a = new m3();
        Intrinsics.checkNotNullParameter(ShortCompanionObject.INSTANCE, "<this>");
        f520739b = t0.a("kotlin.UShort", u2.f520784a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520739b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return UShort.m9724boximpl(UShort.m9730constructorimpl(r100.decodeInline(f520739b).decodeShort()));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        short r102 = ((UShort) r101).m9780unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeInline(f520739b).encodeShort(r102);
    }
}
