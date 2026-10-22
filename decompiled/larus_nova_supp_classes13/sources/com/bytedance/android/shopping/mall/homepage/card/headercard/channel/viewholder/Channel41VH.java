package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder;

import android.text.SpannableStringBuilder;
import android.text.style.AbsoluteSizeSpan;
import android.view.View;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.event.e;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView41;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.BigCardTitleView;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/Channel41VH;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Lef3/b;", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Channel41VH extends ChannelBaseVH implements ef3.b {
    public static final /* synthetic */ int m = 0;
    public final int h;
    public final int i;
    public final BigCardTitleView j;
    public final ChannelCardView41 k;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a l;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Channel41VH b;

        public a(int r1, Channel41VH r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            long r0 = System.currentTimeMillis();
            Channel41VH r6 = this.b;
            int r2 = this.a;
            int r3 = ChannelBaseVH.g;
            r6.U3(r2, r0, null);
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // ef3.b
    public final void onRelease() {
        e r0 = this.j.j;
        if (r0 == null) goto L6;
        ECEventCenter.f("ec.mallAllowEffectShow", r0);
        return;
    }

    @Override // ef3.b
    public final void p() {
        this.j.b = false;
    }

    @Override // ef3.b
    public final void N2(View r2) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r2, "cardView");
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH
    public final void T3(ChannelVO r11) {
        super.T3(r11);
        this.k.getTitleContainer().a(r11, this.e, this.l);
        Iterator<T> r0 = this.k.getContentContainers().iterator();
        int r2 = 0;
    L4:
        if (r0.hasNext() == false) goto L34;
        Object r3 = r0.next();
        int r4 = r2 + 1;
        if (r2 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ChannelCardView41.a r5 = (ChannelCardView41.a) r3;
        String r6 = null;
        if (r11 == null) goto L11;
        String r7 = r11.getItemImageUrl(r2);
    L13:
        if (r7 != null) goto L15;
    L18:
        boolean r8 = true;
    L19:
        if (r8 == true) goto L21;
        d0.c(r5.getProductSDView(), r7, this.e.k);
    L21:
        if (r11 == null) goto L23;
        r6 = r11.getItemPrice(r2);
    L23:
        SpannableStringBuilder r9 = new SpannableStringBuilder();
        r9.append("¥");
        r9.setSpan(new AbsoluteSizeSpan(this.h), 0, r9.length(), 17);
        if (r6 != null) goto L26;
    L29:
        boolean r10 = true;
    L30:
        if (r10 == true) goto L33;
        r9.append(r6);
        r9.setSpan(new AbsoluteSizeSpan(this.i), 1, r9.length(), 17);
        r5.getPriceTextView().setText(r9);
    L33:
        r2 = r4;
        goto L4
    L26:
        if (r6.length() == 0) goto L29;
        r10 = false;
        goto L30
    L15:
        if (r7.length() == 0) goto L18;
        r8 = false;
        goto L19
    L11:
        r7 = null;
        goto L13
    }

    public Channel41VH(ChannelCardView41 r4, com.bytedance.android.shopping.mall.homepage.card.headercard.a r5, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r6) {
        Intrinsics.checkNotNullParameter(r4, "channelCardView");
        Intrinsics.checkNotNullParameter(r5, "mallContext");
        Intrinsics.checkNotNullParameter(r6, "action");
        super(r4, r5, r6);
        this.k = r4;
        this.l = r6;
        int r7 = c.a;
        this.h = c.c(10, getContext(), true);
        this.i = c.c(13, getContext(), true);
        this.j = r4.getTitleContainer();
        Iterator<T> r8 = r4.getContentContainers().iterator();
        int r9 = 0;
    L4:
        if (r8.hasNext() == false) goto L9;
        Object r0 = r8.next();
        int r1 = r9 + 1;
        if (r9 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((ChannelCardView41.a) r0).setOnClickListener(new a(r9, this));
        r9 = r1;
        goto L4
    L9:
        V3(this.k.getTitleContainer());
        r5.a(this);
    }

    @Override // ef3.b
    public final void Q0(boolean r2, Boolean r3, boolean r4) {
        this.j.d(r2, r3, r4);
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH
    public final void U3(int r1, long r2, Map<String, ? extends Object> r4) {
        super.U3(r1, r2, r4);
        this.j.c(r1);
    }
}
