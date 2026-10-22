package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c extends com.bytedance.kmp.ec.yata.event.common.b {
    public c() {
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r6) {
        Intrinsics.checkNotNullParameter(r6, "input");
        Map r7 = r6.q();
        if (r7 == null) goto L5;
        Object r1 = r7.get("current_index");
    L7:
        if ((r1 instanceof Integer) == true) goto L9;
        r1 = null;
    L9:
        Integer r2 = (Integer) r1;
        if (r7 == null) goto L12;
        Object r3 = r7.get("current_word");
    L14:
        if ((r3 instanceof String) == true) goto L16;
        r3 = null;
    L16:
        String r4 = (String) r3;
        if (r7 == null) goto L19;
        Object r8 = r7.get("history_words");
    L21:
        if ((r8 instanceof List) == true) goto L23;
        r8 = null;
    L23:
        List r9 = (List) r8;
        if (r9 == null) goto L26;
        List r10 = CollectionsKt.toMutableList(r9);
    L27:
        if (r2 != null) goto L30;
    L31:
        if (r2 == null) goto L35;
        if (r10 == null) goto L37;
        String r5 = (String) ListProtector.remove(r10, r2.intValue());
    L37:
        if (r4 == null) goto L40;
        if (r10 == null) goto L40;
        r10.remove(r4);
    L40:
        int r11 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        if (r10 == null) goto L44;
        List r12 = CollectionsKt.toList(r10);
        if (r12 == null) goto L44;
    L46:
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, MapsKt.mapOf(TuplesKt.to("new_history_words", r12)), null, 5);
    L44:
        r12 = CollectionsKt.emptyList();
    L35:
        if (r10 == null) goto L37;
        r10.clear();
        goto L37
    L30:
        if (r2.intValue() == (-1)) goto L35;
    L26:
        r10 = null;
        goto L27
    L19:
        r8 = null;
        goto L21
    L12:
        r3 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }
}
