package yt7;

import kotlin.jvm.internal.Intrinsics;
import luc.e;
import luc.f;
import luc.n;
import nuc.m2;
import ouc.g0;
import ouc.h;
import ouc.i;
import ouc.k;

/* JADX INFO: loaded from: classes3.dex */
public final class c implements juc.d<String> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final m2 f569148a;

    public c() {
        this.f569148a = n.a("NumberAsStringSerializer", e.i.f510857a);
    }

    @Override // juc.d, juc.n, juc.c
    public final f getDescriptor() {
        return this.f569148a;
    }

    @Override // juc.c
    public final Object deserialize(muc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "decoder");
        if ((r100 instanceof h) == false) goto L5;
        h r101 = (h) r100;
    L6:
        if (r101 == null) goto L26;
        i r102 = r101.a();
        if ((r102 instanceof g0) == false) goto L24;
        g0 r103 = (g0) r102;
        if (r103.c() == false) goto L13;
        return r103.a();
    L13:
        if (k.q(r103) == null) goto L16;
        return String.valueOf(k.p(r103));
    L16:
        if (k.j(r103) == null) goto L19;
        return String.valueOf(k.j(r103));
    L19:
        if (k.i(r103) == null) goto L22;
        return String.valueOf(k.h(r103));
    L22:
        return r103.a();
    L24:
        throw new IllegalStateException(("Expected primitive for IntAsString, but was: " + r102).toString());
    L26:
        throw new IllegalStateException("NumberAsStringSerializer only works with JSON".toString());
    L5:
        r101 = null;
        goto L6
    }

    @Override // juc.n
    public final void serialize(muc.f r100, Object r101) {
        String r102 = (String) r101;
        Intrinsics.checkNotNullParameter(r100, "encoder");
        Intrinsics.checkNotNullParameter(r102, "value");
        r100.encodeString(r102);
    }
}
