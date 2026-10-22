package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m extends com.bytedance.kmp.ec.yata.event.common.a {
    public final CardListObjectContainer a;

    public m(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.a = r2;
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r7, Function1 r8) {
        Intrinsics.checkNotNullParameter(r7, "input");
        Intrinsics.checkNotNullParameter(r8, "chainNextCallback");
        List r9 = ((AndroidYaTaInstance) this.a.e.c.invoke()).p("submit");
        if (r9 == null) goto L20;
        com.bytedance.kmp.ec.yata.store.node.c r10 = (com.bytedance.kmp.ec.yata.store.node.c) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L21;
        p r11 = r10.b.b;
        if (r11 == null) goto L12;
        Object r12 = q.b(r11, Reflection.getOrCreateKotlinClass(Integer.class), "select_num");
        if ((r12 instanceof Integer) == true) goto L11;
        r12 = null;
    L11:
        Integer r13 = (Integer) r12;
    L13:
        if (r13 == null) goto L22;
        int r14 = r13.intValue();
        if (r14 != 0) goto L17;
        int r15 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, true, "未选择需要删除的商品", null, null, 57));
        return;
    L17:
        if (r14 <= 0) goto L24;
        int r16 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r8.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L24:
        return;
    L22:
        return;
    L12:
        r13 = null;
        goto L13
    L21:
        return;
    }
}
