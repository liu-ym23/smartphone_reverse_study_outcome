package com.bytedance.bdnavigationsdk.network.route;

import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class f implements juc.d<e> {
    public static final f a = null;
    public static final juc.d<e> b = null;
    public static final luc.f c = null;

    public f() {
    }

    static {
        a = new f();
        juc.d<e> r0 = e.Companion.serializer();
        b = r0;
        c = r0.getDescriptor();
    }

    public final luc.f getDescriptor() {
        return c;
    }

    public final Object deserialize(muc.e r5) {
        Intrinsics.checkNotNullParameter(r5, "decoder");
        e r1 = null;
        if ((r5 instanceof ouc.h) == false) goto L5;
        ouc.h r6 = (ouc.h) r5;
    L6:
        if (r6 == null) goto L31;
        g0 r0 = r6.a();
        if ((r0 instanceof g0) == false) goto L24;
        g0 r2 = r0;
        if (r2.c() == false) goto L16;
        Float r7 = StringsKt.toFloatOrNull(r2.a());
        if (r7 == null) goto L14;
        float r8 = r7.floatValue();
    L21:
        r1 = new e(r8);
    L26:
        if (r1 != null) goto L29;
        return new e(0.0f);
    L29:
        return r1;
    L14:
        r8 = 0.0f;
        goto L21
    L16:
        if (ouc.k.i(r2) == null) goto L19;
        Double r9 = ouc.k.i(r2);
        Intrinsics.checkNotNull(r9);
        r8 = (float) r9.doubleValue();
        goto L21
    L19:
        if (ouc.k.l(r2) == null) goto L32;
        Integer r10 = ouc.k.l(r2);
        Intrinsics.checkNotNull(r10);
        r8 = r10.intValue();
        goto L21
    L32:
        return new e(0.0f);
    L24:
        if ((r0 instanceof d0) == false) goto L26;
        r1 = (e) r6.getJson().b(e.Companion.serializer(), r0);
        goto L26
    L31:
        throw new IllegalStateException("This serializer must be used with JSON format");
    L5:
        r6 = null;
        goto L6
    }

    public final void serialize(muc.f r2, Object r3) {
        e r4 = (e) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r4, "value");
        b.serialize(r2, r4);
    }
}
