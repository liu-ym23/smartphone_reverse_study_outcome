package com.bytedance.android.shopping.card_list.eventcenter.event;

import com.bytedance.android.shopping.card_list.components.CardListBodyComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.android.shopping.card_list.utils.CardListCommonLog;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SelfAnchorScroll extends com.bytedance.kmp.ec.yata.event.common.b {
    public final Lazy a;
    public final CardListObjectContainer b;

    public SelfAnchorScroll(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.b = r2;
        this.a = LazyKt.lazy(new SelfAnchorScroll$bodyComponent$2(this));
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r12) {
        Intrinsics.checkNotNullParameter(r12, "input");
        Map r13 = r12.q();
        if (r13 == null) goto L5;
        Object r1 = r13.get("node_name");
    L7:
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        final String r2 = (String) r1;
        if (r13 == null) goto L12;
        Object r3 = r13.get("yata_key");
    L14:
        if ((r3 instanceof String) == true) goto L16;
        r3 = null;
    L16:
        final String r4 = (String) r3;
        if (r13 == null) goto L19;
        Object r14 = r13.get("position");
    L21:
        if ((r14 instanceof String) == true) goto L23;
        r14 = null;
    L23:
        String r15 = (String) r14;
        Lazy r5 = CardListCommonLog.a;
        CardListCommonLog.a("SelfAnchorScroll", new SelfAnchorScroll$onExecuteSync$1(r2, r4));
        if (r2 != null) goto L26;
    L29:
        boolean r7 = true;
    L30:
        if (r7 == true) goto L86;
        if (r4 != null) goto L33;
    L36:
        boolean r8 = true;
    L37:
        if (r8 == true) goto L86;
        List r9 = ((AndroidYaTaInstance) this.b.e.c.invoke()).n("body");
        if (r9 == null) goto L84;
        Iterator r10 = r9.iterator();
        int r11 = 0;
    L43:
        if (r10.hasNext() == false) goto L57;
        final com.bytedance.kmp.ec.yata.store.node.c r16 = (com.bytedance.kmp.ec.yata.store.node.c) r10.next();
        Lazy r17 = CardListCommonLog.a;
        CardListCommonLog.a("SelfAnchorScroll", new SelfAnchorScroll$onExecuteSync$2$1(r16));
        if (Intrinsics.areEqual(r16.getNodeName(), r2) == false) goto L53;
        Map r18 = r16.s();
        if (r18 == null) goto L49;
        Object r19 = r18.get("yata_key");
    L51:
        if (Intrinsics.areEqual(String.valueOf(r19), r4) == false) goto L53;
        boolean r20 = true;
    L54:
        if (r20 == true) goto L58;
        r11 = r11 + 1;
    L58:
        if (r15 == null) goto L82;
        int r6 = r15.hashCode();
        if (r6 == (-1383228885)) goto L78;
        if (r6 == (-1364013995)) goto L73;
        if (r6 != 115029) goto L82;
        if (r15.equals("top") == false) goto L82;
        CardListBodyComponent r110 = (CardListBodyComponent) this.a.getValue();
        if (r110 == null) goto L82;
        r110.h(r11, ScrollMode.TOP);
        goto L82
    L73:
        if (r15.equals("center") == false) goto L82;
        CardListBodyComponent r111 = (CardListBodyComponent) this.a.getValue();
        if (r111 == null) goto L82;
        r111.h(r11, ScrollMode.CENTER);
        goto L82
    L78:
        if (r15.equals("bottom") == false) goto L82;
        CardListBodyComponent r112 = (CardListBodyComponent) this.a.getValue();
        if (r112 == null) goto L82;
        r112.h(r11, ScrollMode.BOTTOM);
    L82:
        int r113 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L49:
        r19 = null;
    L53:
        r20 = false;
        goto L54
    L57:
        r11 = -1;
        goto L58
    L84:
        int r114 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "anchor scroll error, no target node", null, null, 57);
    L33:
        if (r4.length() == 0) goto L36;
        r8 = false;
    L86:
        int r115 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "anchor scroll error, no node name or yata key", null, null, 57);
    L26:
        if (r2.length() == 0) goto L29;
        r7 = false;
        goto L30
    L19:
        r14 = null;
        goto L21
    L12:
        r3 = null;
        goto L14
    L5:
        r1 = null;
        goto L7
    }
}
