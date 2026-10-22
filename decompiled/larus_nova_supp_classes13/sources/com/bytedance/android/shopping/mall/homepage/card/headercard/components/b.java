package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import android.view.View;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.ChannelAdapter;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.ChannelLayoutManager;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.GridItemDecoration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends ef3.e<HeaderCardData> {
    public final RecyclerView d;
    public final View e;
    public final ChannelAdapter f;

    @Override // ef3.c
    public final String getName() {
        return "CHANNEL_AREA";
    }

    @Override // ef3.c
    public final void onCreate() {
        RecyclerView r0 = this.d;
        if (r0 == null) goto L5;
        r0.setItemAnimator(null);
        r0.setLayoutManager(new ChannelLayoutManager(this.f, getContext()));
        int r2 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r0.addItemDecoration(new GridItemDecoration(com.bytedance.android.ec.hybrid.list.util.c.c(Double.valueOf(3.5d), getContext(), true)));
        r0.setAdapter(this.f);
        ChannelAdapter r1 = this.f;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "recyclerView");
        r1.b = r0;
    L5:
        View r3 = this.e;
        if (r3 == null) goto L9;
        r3.setVisibility(8);
        return;
    }

    public b(View r2, com.bytedance.android.shopping.mall.homepage.card.headercard.a r3) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        super(r2, r3);
        this.d = r2.findViewById(2131383725);
        this.e = r2.findViewById(2131392482);
        this.f = new ChannelAdapter(r3);
    }

    @Override // ef3.c
    public final void a(HeaderCardData r4, String r5) {
        Intrinsics.checkNotNullParameter(r5, "itemId");
        ArrayList r6 = new ArrayList();
        List<List<ChannelVO>> r0 = null;
        if (r4 == null) goto L9;
        HeaderCardData.MiddleArea r1 = r4.getMiddleArea();
        if (r1 == null) goto L9;
        HeaderCardData.ChannelCards r2 = r1.getActivityList();
        if (r2 == null) goto L9;
        List<List<ChannelVO>> r3 = r2.getData();
    L10:
        if (r3 == null) goto L24;
        HeaderCardData.MiddleArea r7 = r4.getMiddleArea();
        if (r7 == null) goto L24;
        HeaderCardData.ChannelCards r8 = r7.getActivityList();
        if (r8 == null) goto L24;
        List<List<ChannelVO>> r9 = r8.getData();
        if (r9 == null) goto L24;
        if ((!r9.isEmpty()) != true) goto L24;
        HeaderCardData.MiddleArea r10 = r4.getMiddleArea();
        if (r10 == null) goto L28;
        HeaderCardData.ChannelCards r11 = r10.getActivityList();
        if (r11 == null) goto L28;
        r0 = r11.getData();
    L28:
        if (r0 == null) goto L40;
        Iterator<T> r12 = r0.iterator();
    L31:
        if (r12.hasNext() == false) goto L40;
        List r13 = (List) r12.next();
        if (r13 == null) goto L31;
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L31;
        ChannelVO r15 = (ChannelVO) r14.next();
        if (r15 == null) goto L36;
        r6.add(r15);
    L40:
        ChannelAdapter r16 = this.f;
        r16.a = r6;
        r16.notifyDataSetChanged();
        return;
    L24:
        if (r4 == null) goto L28;
        HeaderCardData.ChannelCards r17 = r4.getChannelCards();
        if (r17 == null) goto L28;
        r0 = r17.getData();
    L9:
        r3 = null;
        goto L10
    }
}
