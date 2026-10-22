package com.bytedance.android.shopping.buynow.utils;

import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    static {
    }

    @JvmStatic
    public static final com.bytedance.kmp.ec.yata.store.node.c a(AndroidYaTaInstance r4, String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "targetComponentName");
        Intrinsics.checkNotNullParameter(r6, "targetYataKey");
        Object r0 = null;
        if (r4 == null) goto L24;
        List r7 = r4.p(r5);
        if (r7 == null) goto L25;
        Iterator r8 = r7.iterator();
    L8:
        if (r8.hasNext() == false) goto L20;
        Object r9 = r8.next();
        com.bytedance.kmp.ec.yata.common.protocol.data.p r1 = ((com.bytedance.kmp.ec.yata.store.node.c) r9).b.b;
        if (r1 == null) goto L15;
        Object r2 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r1, Reflection.getOrCreateKotlinClass(String.class), "yata_key");
        if ((r2 instanceof String) == true) goto L14;
        r2 = null;
    L14:
        String r3 = (String) r2;
    L17:
        if (Intrinsics.areEqual(r3, r6) == false) goto L8;
        r0 = r9;
        goto L20
    L15:
        r3 = null;
    L20:
        return (com.bytedance.kmp.ec.yata.store.node.c) r0;
    L25:
        return null;
    L24:
        return null;
    }

    @JvmStatic
    public static final int b(AndroidYaTaInstance r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r8, "targetComponentName");
        Intrinsics.checkNotNullParameter(r9, "targetYataKey");
        if (r7 == null) goto L25;
        List r10 = r7.n("body");
        if (r10 == null) goto L28;
        Iterator r11 = r10.iterator();
        int r2 = 0;
    L8:
        if (r11.hasNext() == false) goto L30;
        com.bytedance.kmp.ec.yata.store.node.c r3 = (com.bytedance.kmp.ec.yata.store.node.c) r11.next();
        if (Intrinsics.areEqual(r3.getNodeName(), r8) == false) goto L21;
        com.bytedance.kmp.ec.yata.common.protocol.data.p r4 = r3.b.b;
        Object r5 = null;
        if (r4 == null) goto L19;
        Object r6 = com.bytedance.kmp.ec.yata.common.protocol.data.q.b(r4, Reflection.getOrCreateKotlinClass(String.class), "yata_key");
        if ((r6 instanceof String) == false) goto L17;
        r5 = r6;
    L17:
        r5 = (String) r5;
    L19:
        if (Intrinsics.areEqual(r5, r9) == false) goto L21;
        boolean r12 = true;
    L22:
        if (r12 == true) goto L29;
        r2 = r2 + 1;
        goto L8
    L29:
        return r2;
    L21:
        r12 = false;
        goto L22
    L30:
        return -1;
    L28:
        return -1;
    L25:
        return -1;
    }
}
