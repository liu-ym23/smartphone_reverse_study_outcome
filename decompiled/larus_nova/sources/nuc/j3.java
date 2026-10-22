package nuc;

import kotlin.ULong;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.LongCompanionObject;

/* JADX INFO: loaded from: classes5.dex */
public final class j3 implements juc.d<ULong> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final j3 f520720a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r0 f520721b = null;

    public j3() {
    }

    static {
        f520720a = new j3();
        Intrinsics.checkNotNullParameter(LongCompanionObject.INSTANCE, "<this>");
        f520721b = t0.a("kotlin.ULong", g1.f520681a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520721b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return ULong.m9617boximpl(ULong.m9623constructorimpl(r100.decodeInline(f520721b).decodeLong()));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        long r102 = ((ULong) r101).m9675unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeInline(f520721b).encodeLong(r102);
    }
}
