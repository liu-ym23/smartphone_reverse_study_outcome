package com.bytedance.android.shopping.mall.homepage.card.headercard.components;

import android.graphics.Outline;
import android.view.View;
import android.view.ViewOutlineProvider;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.HeaderCardData;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.ChannelAdapter;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.ChannelLayoutManager;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.GridItemDecoration;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends ef3.e<HeaderCardData> {
    public final float d;
    public final RecyclerView e;
    public final View f;
    public final ChannelAdapter g;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.mall.homepage.card.headercard.components.a$a, reason: collision with other inner class name */
    public static final class C0097a extends ViewOutlineProvider {
        public final /* synthetic */ a a;

        public C0097a(a r1) {
            this.a = r1;
        }

        @Override // android.view.ViewOutlineProvider
        public final void getOutline(View r7, Outline r8) {
            if (r7 != null) goto L4;
            return;
        L4:
            if (r8 == null) goto L7;
            r8.setRoundRect(0, 0, r7.getWidth(), r7.getHeight(), this.a.d);
            return;
        }
    }

    @Override // ef3.c
    public final String getName() {
        return "CHANNEL_AREA";
    }

    @Override // ef3.c
    public final void onCreate() {
        RecyclerView r0 = this.e;
        if (r0 == null) goto L6;
        r0.setItemAnimator(null);
        r0.setLayoutManager(new ChannelLayoutManager(this.g, getContext()));
        int r2 = com.bytedance.android.ec.hybrid.list.util.c.a;
        r0.addItemDecoration(new GridItemDecoration(com.bytedance.android.ec.hybrid.list.util.c.c(Double.valueOf(0.5d), getContext(), true)));
        r0.setAdapter(this.g);
        ChannelAdapter r1 = this.g;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r0, "recyclerView");
        r1.b = r0;
        return;
    }

    public a(View r4, com.bytedance.android.shopping.mall.homepage.card.headercard.a r5) {
        Intrinsics.checkNotNullParameter(r4, "cardView");
        Intrinsics.checkNotNullParameter(r5, "mallContext");
        super(r4, r5);
        int r0 = com.bytedance.android.ec.hybrid.list.util.c.a;
        this.d = com.bytedance.android.ec.hybrid.list.util.c.c(12, getContext(), true);
        RecyclerView r1 = r4.findViewById(2131383725);
        if (r1 == null) goto L5;
        r1.setOutlineProvider(new C0097a(this));
        r1.setClipToOutline(true);
        Unit r2 = Unit.INSTANCE;
    L6:
        this.e = r1;
        this.f = r4.findViewById(2131392482);
        this.g = new ChannelAdapter(r5);
        return;
    L5:
        r1 = null;
        goto L6
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
        if (r0 == null) goto L41;
        Iterator<T> r12 = r0.iterator();
    L31:
        if (r12.hasNext() == false) goto L41;
        List r13 = (List) r12.next();
        if (r13 == null) goto L31;
        Iterator r14 = r13.iterator();
    L36:
        if (r14.hasNext() == false) goto L31;
        ChannelVO r15 = (ChannelVO) r14.next();
        if (r15 == null) goto L36;
        r6.add(r15);
    L41:
        if (r6.isEmpty() == false) goto L45;
        View r16 = this.f;
        if (r16 == null) goto L48;
        r16.setVisibility(8);
    L48:
        ChannelAdapter r17 = this.g;
        r17.a = r6;
        r17.notifyDataSetChanged();
        return;
    L45:
        View r18 = this.f;
        if (r18 == null) goto L48;
        r18.setVisibility(0);
    L24:
        if (r4 == null) goto L28;
        HeaderCardData.ChannelCards r19 = r4.getChannelCards();
        if (r19 == null) goto L28;
        r0 = r19.getData();
    L9:
        r3 = null;
        goto L10
    }
}
