package com.bytedance.android.shopping.card_list.eventcenter.event;

import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.card_list.components.CardListBodyComponent;
import com.bytedance.android.shopping.card_list.components.CardListPageCallBackComponent;
import com.bytedance.android.shopping.card_list.components.KitCartBackToTopBtnManageComponent;
import com.bytedance.android.shopping.card_list.container.init.CardListObjectContainer;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends com.bytedance.kmp.ec.yata.event.common.b {
    public final CardListObjectContainer a;

    public b(CardListObjectContainer r2) {
        Intrinsics.checkNotNullParameter(r2, "objectContainer");
        this.a = r2;
    }

    public final com.bytedance.kmp.ec.yata.chain.event.b c(com.bytedance.kmp.ec.yata.event.core.a r4) {
        Intrinsics.checkNotNullParameter(r4, "input");
        Map r5 = r4.q();
        if (r5 == null) goto L5;
        Object r6 = r5.get("popup_code");
    L7:
        if ((r6 instanceof String) == true) goto L10;
        r6 = null;
    L10:
        if (Intrinsics.areEqual((String) r6, "SEARCH_PANEL") == false) goto L17;
        CardListPageCallBackComponent r7 = (CardListPageCallBackComponent) this.a.b(Reflection.getOrCreateKotlinClass(CardListPageCallBackComponent.class));
        if (r7 == null) goto L14;
        RecyclerView r8 = r7.h;
    L15:
        if (r8 == null) goto L23;
        r8.post(new a(r8));
    L23:
        int r9 = com.bytedance.kmp.ec.yata.chain.event.b.h;
        return com.bytedance.kmp.ec.yata.chain.event.b.a.c(false, null, null, 7);
    L14:
        r8 = null;
        goto L15
    L17:
        KitCartBackToTopBtnManageComponent r10 = (KitCartBackToTopBtnManageComponent) this.a.b(Reflection.getOrCreateKotlinClass(KitCartBackToTopBtnManageComponent.class));
        if (r10 == null) goto L20;
        r10.g(false);
    L20:
        CardListBodyComponent r11 = (CardListBodyComponent) this.a.b(Reflection.getOrCreateKotlinClass(CardListBodyComponent.class));
        if (r11 == null) goto L23;
        r11.m.d.d.setValue(Unit.INSTANCE);
        goto L23
    L5:
        r6 = null;
        goto L7
    }
}
