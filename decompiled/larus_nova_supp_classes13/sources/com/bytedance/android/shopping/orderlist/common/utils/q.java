package com.bytedance.android.shopping.orderlist.common.utils;

import android.view.View;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q {
    public static final Long a(com.bytedance.kmp.ec.yata.common.protocol.data.c r2) {
        Map r3 = r2.g();
        if (r3 == null) goto L5;
        Object r4 = r3.get("current_time");
    L7:
        if ((r4 instanceof Number) == true) goto L9;
        r4 = null;
    L9:
        Number r5 = (Number) r4;
        if (r5 != null) goto L12;
        return null;
    L12:
        return Long.valueOf(r5.longValue());
    L5:
        r4 = null;
        goto L7
    }

    public static final void b(AndroidYaTaInstance r8, f r9, View r10, String r11) {
        Intrinsics.checkNotNullParameter(r9, "eventChain");
        Intrinsics.checkNotNullParameter(r11, "bizMonitorTag");
        String r0 = r9.a;
        boolean r1 = true;
        if (r0 != null) goto L5;
    L8:
        boolean r2 = true;
    L9:
        if (r2 == true) goto L25;
        String r3 = r9.b;
        if (r3 != null) goto L13;
    L16:
        if (r1 == true) goto L26;
        if (r8 == null) goto L20;
        com.bytedance.kmp.ec.yata.store.node.c r4 = r8.o(r9.b);
    L21:
        if (r4 != null) goto L23;
        return;
    L23:
        r8.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r8, new com.bytedance.kmp.ec.yata.common.platform.o(r10), r9.b, r9.a, r9.c, r11));
        return;
    L20:
        r4 = null;
        goto L21
    L26:
        return;
    L13:
        if (r3.length() == 0) goto L16;
        r1 = false;
        goto L16
    L25:
        return;
    L5:
        if (r0.length() == 0) goto L8;
        r2 = false;
        goto L9
    }
}
