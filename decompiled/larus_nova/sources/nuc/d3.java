package nuc;

import kotlin.UByte;
import kotlin.jvm.internal.ByteCompanionObject;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class d3 implements juc.d<UByte> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d3 f520661a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final r0 f520662b = null;

    public d3() {
    }

    static {
        f520661a = new d3();
        Intrinsics.checkNotNullParameter(ByteCompanionObject.INSTANCE, "<this>");
        f520662b = t0.a("kotlin.UByte", l.f520729a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520662b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return UByte.m9461boximpl(UByte.m9467constructorimpl(r100.decodeInline(f520662b).decodeByte()));
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        byte r102 = ((UByte) r101).m9517unboximpl();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeInline(f520662b).encodeByte(r102);
    }
}
