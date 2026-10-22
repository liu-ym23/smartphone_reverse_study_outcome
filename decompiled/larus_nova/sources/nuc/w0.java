package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class w0 implements juc.d<Integer> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final w0 f520792a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520793b = null;

    public w0() {
    }

    static {
        f520792a = new w0();
        f520793b = new m2("kotlin.Int", luc.e.f.f510854a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520793b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Integer.valueOf(r100.decodeInt());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        int r102 = ((Number) r101).intValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeInt(r102);
    }
}
