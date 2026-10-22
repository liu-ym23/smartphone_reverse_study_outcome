package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import android.view.View;
import android.widget.LinearLayout;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.CycleActivityView41;
import com.bytedance.mt.protector.impl.GsonProtectorUtils;
import com.google.gson.Gson;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends ef3.e<HeaderCardData> {
    public final LinearLayout d;
    public final List<Runnable> e;

    @Override // ef3.c
    public final String getName() {
        return "HEADER_CHANNEL_AREA";
    }

    @Override // ef3.c
    public final void onCreate() {
    }

    @Override // ef3.e
    public final void c() {
        Iterator<T> r0 = this.e.iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((Runnable) r0.next()).run();
        goto L4
    L6:
        ((ArrayList) this.e).clear();
    }

    public d(View r2, com.bytedance.android.shopping.mall.homepage.card.headercard.a r3) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        super(r2, r3);
        this.d = (LinearLayout) r2.findViewById(2131383726);
        this.e = new ArrayList();
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v9, types: [android.view.View, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.CycleActivityView41] */
    @Override // ef3.c
    public final void a(HeaderCardData r6, String r7) {
        Intrinsics.checkNotNullParameter(r7, "itemId");
        Gson r8 = new Gson();
        if (r6 == null) goto L5;
        List<ChannelVO> r1 = r6.getCycleActivityList();
    L6:
        GsonProtectorUtils.toJson(r8, r1);
        this.d.removeAllViews();
        if (r6 == null) goto L23;
        List<ChannelVO> r9 = r6.getCycleActivityList();
        if (r9 == null) goto L24;
        ChannelVO r10 = (ChannelVO) CollectionsKt.firstOrNull(r9);
        if (r10 == null) goto L25;
        ChannelVO.Data r11 = r10.getData();
        if (r11 == null) goto L26;
        List<ECCommonCard> r12 = r11.getItems();
        if (r12 != null) goto L17;
        return;
    L17:
        if (r12.size() != 4) goto L28;
        int r2 = com.bytedance.android.ec.hybrid.list.util.c.a;
        LinearLayout.LayoutParams r13 = new LinearLayout.LayoutParams(-1, com.bytedance.android.ec.hybrid.list.util.c.c(120, getContext(), true));
        r13.bottomMargin = com.bytedance.android.ec.hybrid.list.util.c.c(10, getContext(), true);
        ?? r3 = new CycleActivityView41(getContext(), null, 6, 0);
        this.d.addView(r3, r13);
        ef3.a r14 = this.c;
        if (r14 == null) goto L22;
        r3.R5(r10, (com.bytedance.android.shopping.mall.homepage.card.headercard.a) r14);
        ((ArrayList) this.e).add(new c(r3));
        return;
    L22:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.android.shopping.mall.homepage.card.headercard.HeaderCardContext");
    L28:
        return;
    L26:
        return;
    L25:
        return;
    L24:
        return;
    L23:
        return;
    L5:
        r1 = null;
        goto L6
    }
}
