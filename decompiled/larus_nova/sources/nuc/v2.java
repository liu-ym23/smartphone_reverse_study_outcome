package nuc;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class v2 implements juc.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final v2 f520790a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f520791b = null;

    public v2() {
    }

    static {
        f520790a = new v2();
        f520791b = new m2("kotlin.String", luc.e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f520791b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        return r100.decodeString();
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        String r102 = (String) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeString(r102);
    }
}
