package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class r implements juc.d<Character> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final r f520761a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520762b = null;

    public r() {
    }

    static {
        f520761a = new r();
        f520762b = new m2("kotlin.Char", luc.e.c.f510851a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520762b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Character.valueOf(r100.decodeChar());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        char r102 = ((Character) r101).charValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeChar(r102);
    }
}
