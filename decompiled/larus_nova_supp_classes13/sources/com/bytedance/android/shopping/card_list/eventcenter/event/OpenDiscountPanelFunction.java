package com.bytedance.android.shopping.card_list.eventcenter.event;

import android.widget.LinearLayout;
import com.bytedance.android.shopping.card_list.components.CardListBodyComponent;
import com.bytedance.android.shopping.card_list.components.CardListPageCallBackComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import java.util.Map;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class OpenDiscountPanelFunction extends com.bytedance.kmp.ec.yata.event.common.a {
    public final Lazy a;
    public final Lazy b;
    public final Lazy c;
    public final CardListObjectContainer d;

    public OpenDiscountPanelFunction(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.d = r2;
        this.a = LazyKt.lazy(new OpenDiscountPanelFunction$pageCallBackComponent$2(this));
        this.b = LazyKt.lazy(new OpenDiscountPanelFunction$bodyComponent$2(this));
        this.c = LazyKt.lazy(new OpenDiscountPanelFunction$headerComponent$2(this));
    }

    public final void c(com.bytedance.kmp.ec.yata.event.core.a r11, Function1 r12) {
        Intrinsics.checkNotNullParameter(r11, "input");
        Intrinsics.checkNotNullParameter(r12, "chainNextCallback");
        Map r0 = r11.q();
        if (r0 == null) goto L5;
        Object r1 = r0.get("use_new_panel");
    L7:
        if ((r1 instanceof Boolean) == true) goto L9;
        r1 = null;
    L9:
        Boolean r2 = (Boolean) r1;
        if (r2 == null) goto L12;
        boolean r3 = r2.booleanValue();
    L13:
        if (r3 == false) goto L39;
        CardListPageCallBackComponent r4 = (CardListPageCallBackComponent) this.a.getValue();
        if (r4 == null) goto L29;
        AtomicBoolean r5 = r4.d;
        if (r5 == null) goto L29;
        if (r5.get() != true) goto L29;
        CardListBodyComponent r6 = (CardListBodyComponent) this.b.getValue();
        if (r6 == null) goto L23;
        r6.g(true);
    L23:
        com.bytedance.android.shopping.card_list.components.j r7 = (com.bytedance.android.shopping.card_list.components.j) this.c.getValue();
        if (r7 == null) goto L28;
        LinearLayout r8 = r7.d;
        if (r8 == null) goto L28;
        com.bytedance.android.ec.core.utils.a.a(r8, true);
    L28:
        String r9 = "popDiscountPopup";
    L38:
        String r10 = r9;
        AndroidYaTaInstance r13 = (AndroidYaTaInstance) this.d.e.c.invoke();
        r13.k().d(com.bytedance.kmp.ec.yata.event.common.e.a.a(r13, null, r11.d.c, r10, null, "OpenDiscountPanelFunction"));
        int r14 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r12.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7));
        return;
    L29:
        CardListBodyComponent r15 = (CardListBodyComponent) this.b.getValue();
        if (r15 == null) goto L32;
        r15.g(false);
    L32:
        com.bytedance.android.shopping.card_list.components.j r16 = (com.bytedance.android.shopping.card_list.components.j) this.c.getValue();
        if (r16 == null) goto L37;
        LinearLayout r17 = r16.d;
        if (r17 == null) goto L37;
        com.bytedance.android.ec.core.utils.a.a(r17, false);
    L37:
        r9 = "pushDiscountPopup";
        goto L38
    L39:
        int r18 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        r12.invoke(com.bytedance.kmp.ec.yata.chain.event.b.a.a(false, false, "use_old_panel", null, null, 57));
        return;
    L12:
        r3 = false;
        goto L13
    L5:
        r1 = null;
        goto L7
    }
}
