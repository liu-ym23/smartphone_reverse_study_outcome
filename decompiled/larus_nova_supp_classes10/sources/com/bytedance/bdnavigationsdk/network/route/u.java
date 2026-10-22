package com.bytedance.bdnavigationsdk.network.route;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.serialization.SerializationException;
import nuc.m2;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u implements juc.d<Integer> {
    public static final u a = null;
    public static final m2 b = null;

    public u() {
    }

    static {
        a = new u();
        b = luc.n.a("RouteVisualRemainDistance", luc.e.f.a);
    }

    public final luc.f getDescriptor() {
        return b;
    }

    public final Object deserialize(muc.e r3) {
        Intrinsics.checkNotNullParameter(r3, "decoder");
        g0 r1 = null;
        if ((r3 instanceof ouc.h) == false) goto L5;
        ouc.h r0 = (ouc.h) r3;
    L6:
        if (r0 == null) goto L24;
        ouc.i r4 = r0.a();
        if ((r4 instanceof g0) == false) goto L12;
        r1 = (g0) r4;
    L12:
        if (r1 == null) goto L23;
        if (r1.c() == false) goto L16;
        Integer r2 = StringsKt.toIntOrNull(r1.a());
    L17:
        if (r2 == null) goto L21;
        return Integer.valueOf(r2.intValue());
    L21:
        throw new SerializationException("remain_distance must be an integer");
    L16:
        r2 = ouc.k.l(r1);
        goto L17
    L23:
        throw new SerializationException("remain_distance must be an integer");
    L24:
        return Integer.valueOf(r3.decodeInt());
    L5:
        r0 = null;
        goto L6
    }

    public final void serialize(muc.f r2, Object r3) {
        int r4 = ((Number) r3).intValue();
        Intrinsics.checkNotNullParameter(r2, "encoder");
        r2.encodeInt(r4);
    }
}
