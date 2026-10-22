package com.bytedance.bdnavigationsdk.network.route;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.mt.protector.impl.string2number.CastDoubleProtector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import ouc.d0;
import ouc.g0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a implements juc.d<List<? extends com.bytedance.bdnavigationsdk.pojo.a>> {
    public static final a a = null;
    public static final nuc.f b = null;
    public static final luc.f c = null;

    public a() {
    }

    static {
        a = new a();
        nuc.f r0 = kuc.a.b(com.bytedance.bdnavigationsdk.pojo.a.Companion.serializer());
        b = r0;
        c = r0.b;
    }

    public final luc.f getDescriptor() {
        return c;
    }

    public final Object deserialize(muc.e r17) {
        Intrinsics.checkNotNullParameter(r17, "decoder");
        if ((r17 instanceof ouc.h) == false) goto L5;
        ouc.h r0 = (ouc.h) r17;
    L6:
        if (r0 == null) goto L53;
        g0 r1 = r0.a();
        if ((r1 instanceof g0) == false) goto L30;
        g0 r3 = r1;
        if (r3.c() == false) goto L30;
        String r9 = r3.a();
        if (r9.length() != 0) goto L14;
        boolean r2 = true;
    L15:
        if (r2 == true) goto L68;
        List r4 = StringsKt.split$default(r9, new String[]{";"}, false, 0, 6, null);
        ArrayList r5 = new ArrayList();
        Iterator r6 = r4.iterator();
    L19:
        if (r6.hasNext() == false) goto L69;
        List r7 = StringsKt.split$default((String) r6.next(), new String[]{","}, false, 0, 6, null);
        if (r7.size() == 2) goto L54;
    L25:
        com.bytedance.bdnavigationsdk.pojo.a r8 = null;
    L26:
        if (r8 == null) goto L19;
        r5.add(r8);
        goto L19
    L54:
        r8 = new com.bytedance.bdnavigationsdk.pojo.a(CastDoubleProtector.parseDouble((String) ListProtector.get(r7, 1)), CastDoubleProtector.parseDouble((String) ListProtector.get(r7, 0)));     // Catch: NumberFormatException -> L24
    L69:
        return r5;
    L68:
        return CollectionsKt.emptyList();
    L14:
        r2 = false;
    L30:
        if ((r1 instanceof ouc.b) == false) goto L51;
        ArrayList r10 = new ArrayList();
        Iterator r11 = ((Iterable) r1).iterator();
    L33:
        if (r11.hasNext() == false) goto L70;
        g0 r12 = (ouc.i) r11.next();
        if ((r12 instanceof d0) == false) goto L38;
        com.bytedance.bdnavigationsdk.pojo.a r13 = (com.bytedance.bdnavigationsdk.pojo.a) r0.getJson().b(com.bytedance.bdnavigationsdk.pojo.a.Companion.serializer(), r12);
    L47:
        if (r13 == null) goto L33;
        r10.add(r13);
        goto L33
    L38:
        if ((r12 instanceof g0) == false) goto L46;
        g0 r14 = r12;
        if (r14.c() == false) goto L46;
        List r15 = StringsKt.split$default(r14.a(), new String[]{","}, false, 0, 6, null);
        if (r15.size() != 2) goto L46;
        r13 = new com.bytedance.bdnavigationsdk.pojo.a(CastDoubleProtector.parseDouble((String) ListProtector.get(r15, 1)), CastDoubleProtector.parseDouble((String) ListProtector.get(r15, 0)));     // Catch: NumberFormatException -> L45
    L46:
        r13 = null;
        goto L47
    L70:
        return r10;
    L51:
        return CollectionsKt.emptyList();
    L53:
        throw new IllegalStateException("This serializer requires JSON input");
    L5:
        r0 = null;
        goto L6
    }

    public final void serialize(muc.f r2, Object r3) {
        List r4 = (List) r3;
        Intrinsics.checkNotNullParameter(r2, "encoder");
        Intrinsics.checkNotNullParameter(r4, "value");
        b.serialize(r2, r4);
    }
}
