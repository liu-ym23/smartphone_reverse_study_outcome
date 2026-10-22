package com.bytedance.android.shopping.card_list.components;

import com.bytedance.android.shopping.card_list.utils.CardListCommonLog;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h extends b {
    public static final /* synthetic */ int d = 0;

    public static final class a {
    }

    static {
    }

    public static void g(com.bytedance.kmp.ec.yata.event.core.a r7) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Object r0 = r7.p(Reflection.getOrCreateKotlinClass(String.class), "event_name");
        if ((r0 instanceof String) == true) goto L5;
        r0 = null;
    L5:
        final String r1 = (String) r0;
        Object r2 = r7.p(Reflection.getOrCreateKotlinClass(String.class), "opportunity");
        if ((r2 instanceof String) == true) goto L8;
        r2 = null;
    L8:
        final String r3 = (String) r2;
        Object r4 = r7.p(Reflection.getOrCreateKotlinClass(Boolean.class), "need_hold");
        if ((r4 instanceof Boolean) == true) goto L11;
        r4 = null;
    L11:
        Boolean r5 = (Boolean) r4;
        boolean r6 = false;
        if (r5 == null) goto L14;
        final boolean r8 = r5.booleanValue();
    L15:
        com.bytedance.kmp.ec.yata.store.node.c r9 = r7.j();
        if (r9 == null) goto L18;
        final String r10 = r9.getKey();
    L19:
        Lazy r11 = CardListCommonLog.a;
        CardListCommonLog.a("CardListEventHandleComponent", new CardListEventHandleComponent$saveEvent$1(r1, r3, r8, r10));
        if (r1 != null) goto L22;
    L25:
        boolean r12 = true;
    L26:
        if (r12 == true) goto L42;
        if (r3 != null) goto L29;
    L32:
        boolean r13 = true;
    L33:
        if (r13 == true) goto L43;
        if (r10 != null) goto L36;
    L37:
        r6 = true;
    L38:
        if (r6 == true) goto L44;
        Intrinsics.checkNotNullParameter(r1, "eventName");
        Intrinsics.checkNotNullParameter(r3, "opportunity");
        Intrinsics.checkNotNullParameter(r10, "renderNodeKey");
        throw null;
    L44:
        throw null;
    L36:
        if (StringsKt.isBlank(r10) == false) goto L38;
    L43:
        throw null;
    L29:
        if (StringsKt.isBlank(r3) == true) goto L32;
        r13 = false;
        goto L33
    L42:
        throw null;
    L22:
        if (StringsKt.isBlank(r1) == true) goto L25;
        r12 = false;
        goto L26
    L18:
        r10 = null;
        goto L19
    L14:
        r8 = false;
        goto L15
    }
}
