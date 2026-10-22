package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class b implements juc.d<com.bytedance.bdnavigationsdk.pojo.a> {
    public static final b a = null;
    public static final juc.d<com.bytedance.bdnavigationsdk.pojo.a> b = null;
    public static final luc.f c = null;

    public b() {
    }

    static {
        a = new b();
        juc.d<com.bytedance.bdnavigationsdk.pojo.a> r0 = com.bytedance.bdnavigationsdk.pojo.a.Companion.serializer();
        b = r0;
        c = r0.getDescriptor();
    }

    public final luc.f getDescriptor() {
        return c;
    }

    public final Object deserialize(muc.e r8) {
        Intrinsics.checkNotNullParameter(r8, "decoder");
        if ((r8 instanceof ouc.h) == false) goto L5;
        ouc.h r9 = (ouc.h) r8;
    L6:
        if (r9 == null) goto L25;
        g0 r0 = r9.a();
        if ((r0 instanceof g0) == false) goto L19;
        String r10 = r0.a();
        List r1 = StringsKt.split$default(r10, new String[]{","}, false, 0, 6, null);
        if (r1.size() != 2) goto L17;
        return new com.bytedance.bdnavigationsdk.pojo.a(CastDoubleProtector.parseDouble((String) ListProtector.get(r1, 1)), CastDoubleProtector.parseDouble((String) ListProtector.get(r1, 0)));
    L13:
        e = move-exception;
        throw new IllegalStateException("LatLng string format is invalid: " + r10, e);
    L17:
        throw new IllegalStateException("LatLng string must contain exactly two comma-separated values (lng,lat): " + r10);
    L19:
        if ((r0 instanceof d0) == false) goto L23;
        return (com.bytedance.bdnavigationsdk.pojo.a) r9.getJson().b(com.bytedance.bdnavigationsdk.pojo.a.Companion.serializer(), r0);
    L23:
        throw new IllegalStateException("Unsupported JSON token for LatLng deserialization: " + Reflection.getOrCreateKotlinClass(r0.getClass()).getSimpleName());
    L25:
        throw new IllegalStateException("This serializer must be used with JSON format");
    L5:
        r9 = null;
        goto L6
    }

    public final void serialize(muc.f r2, Object r3) {
        com.bytedance.bdnavigationsdk.pojo.a r4 = (com.bytedance.bdnavigationsdk.pojo.a) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r4, "value");
        b.serialize(r2, r4);
    }
}
