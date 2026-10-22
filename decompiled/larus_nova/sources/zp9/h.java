package zp9;

import kotlin.jvm.internal.Intrinsics;
import nuc.m2;
import ouc.g0;

/* JADX INFO: loaded from: classes31.dex */
public final class h implements juc.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final h f573269a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final m2 f573270b = null;

    public h() {
    }

    static {
        f573269a = new h();
        f573270b = luc.n.a("FlexibleStringSerializer", luc.e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final luc.f getDescriptor() {
        return f573270b;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        String r101 = null;
        if ((r100 instanceof ouc.h) == false) goto L5;
        ouc.h r102 = (ouc.h) r100;
    L6:
        if (r102 == null) goto L19;
        ouc.i r103 = r102.a();
        if (Intrinsics.areEqual(r103, ouc.a0.INSTANCE) == true) goto L18;
        if ((r103 instanceof g0) == false) goto L16;
        g0 r104 = (g0) r103;
        r101 = ouc.k.g(r104);
        if (r101 != null) goto L18;
        r101 = r104.toString();
        goto L18
    L16:
        r101 = r103.toString();
    L18:
        return r101;
    L19:
        return r100.decodeString();
    L5:
        r102 = null;
        goto L6
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        String r102 = (String) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        if (r102 != null) goto L5;
        r100.encodeNull();
        return;
    L5:
        r100.encodeString(r102);
    }
}
