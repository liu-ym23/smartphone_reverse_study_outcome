package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements juc.d<Boolean> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final i f520705a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520706b = null;

    public i() {
    }

    static {
        f520705a = new i();
        f520706b = new m2("kotlin.Boolean", luc.e.a.f510849a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520706b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return Boolean.valueOf(r100.decodeBoolean());
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        boolean r102 = ((Boolean) r101).booleanValue();
        Intrinsics.checkNotNullParameter(r100, "encoder");
        r100.encodeBoolean(r102);
    }
}
