package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.list.util.c;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemActivity;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.MiaoShaPriceLabelView;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.BigCardTitleView;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadTimer;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\u0018\u00002\u00020\u0001:\u0001\u001dB'\b\u0007\u0012\u0006\u0010\u0017\u001a\u00020\u0016\u0012\n\b\u0002\u0010\u0019\u001a\u0004\u0018\u00010\u0018\u0012\b\b\u0002\u0010\u001a\u001a\u00020\u0003¢\u0006\u0004\b\u001b\u0010\u001cJ\u001a\u0010\u0006\u001a\u00020\u00042\u0012\u0010\u0005\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00040\u0002R\u0017\u0010\f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bR\u0017\u0010\u000f\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\r\u0010\t\u001a\u0004\b\u000e\u0010\u000bR\u0017\u0010\u0015\u001a\u00020\u00108\u0006¢\u0006\f\n\u0004\b\u0011\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014¨\u0006\u001e"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/cardview/legou/pits41/ChannelCardViewNew41;", "Landroid/widget/FrameLayout;", "Lkotlin/Function1;", "", "", "action", "setClickItem", "Lcom/facebook/drawee/view/SimpleDraweeView;", "f", "Lcom/facebook/drawee/view/SimpleDraweeView;", "getBgStyleContainer", "()Lcom/facebook/drawee/view/SimpleDraweeView;", "bgStyleContainer", "g", "getTitle", "title", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "h", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "getTitleContainer", "()Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/itemview/BigCardTitleView;", "titleContainer", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelCardViewNew41 extends FrameLayout {
    public final int a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final SimpleDraweeView f;
    public final SimpleDraweeView g;
    public final BigCardTitleView h;
    public final List<a> i;
    public final ChannelCardViewNew41$disableChannelSwiper$1 j;

    public final class a extends FrameLayout {
        public static final /* synthetic */ int i = 0;
        public final SimpleDraweeView a;
        public final MiaoShaPriceLabelView b;
        public final ChannelItemActivity c;
        public final LinearLayout d;
        public Timer e;
        public Timer f;
        public ECCommonCard g;
        public int h;

        public a() {
            throw null;
        }

        public final void a() {
            Timer r0 = this.e;
            if (r0 == null) goto L5;
            r0.cancel();
        L5:
            Timer r1 = this.f;
            if (r1 == null) goto L8;
            r1.cancel();
        L8:
            this.e = null;
            this.f = null;
            this.d.setVisibility(0);
            this.c.setVisibility(8);
            int r2 = hf3.a.a;
            LinearLayout r3 = this.d;
            Intrinsics.checkNotNullParameter(r3, FreqActions.ACTION_VIEW);
            r3.setScaleX(1.0f);
            r3.setScaleY(1.0f);
            ChannelItemActivity r4 = this.c;
            Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
            r4.setScaleX(1.0f);
            r4.setScaleY(1.0f);
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onDetachedFromWindow() {
            super.onDetachedFromWindow();
            a();
        }

        public final Timer getDelayHandle() {
            return this.e;
        }

        public final Timer getIntervalHandle() {
            return this.f;
        }

        public final ECCommonCard getItem() {
            return this.g;
        }

        public final int getItemLoopTimes() {
            return this.h;
        }

        @Override // android.view.ViewGroup, android.view.View
        public final void onAttachedToWindow() {
            super.onAttachedToWindow();
        }

        public final void setDelayHandle(Timer r1) {
            this.e = r1;
        }

        public final void setIntervalHandle(Timer r1) {
            this.f = r1;
        }

        public final void setItem(ECCommonCard r1) {
            this.g = r1;
        }

        public final void setItemLoopTimes(int r1) {
            this.h = r1;
        }

        public a(ChannelCardViewNew41 r9, Context r10) {
            Intrinsics.checkNotNullParameter(r10, "context");
            super(r10, null, 0);
            View r2 = new SimpleDraweeView(r10);
            this.a = r2;
            MiaoShaPriceLabelView r3 = new MiaoShaPriceLabelView(r10, null, 6, 0);
            this.b = r3;
            ChannelItemActivity r5 = new ChannelItemActivity(r10, null, 6, 0);
            this.c = r5;
            LinearLayout r0 = new LinearLayout(r10);
            this.d = r0;
            setLayoutParams(new FrameLayout.LayoutParams(-2, -2));
            r0.setOrientation(1);
            r0.setGravity(1);
            r0.addView(r2, new FrameLayout.LayoutParams(r9.c, r9.d));
            int r4 = c.a;
            r0.addView(r3, new FrameLayout.LayoutParams(-2, c.c(18, r10, true)));
            FrameLayout.LayoutParams r11 = new FrameLayout.LayoutParams(-2, -2);
            r11.gravity = 17;
            Unit r1 = Unit.INSTANCE;
            addView(r0, r11);
            FrameLayout.LayoutParams r12 = new FrameLayout.LayoutParams(-2, -2);
            r12.gravity = 17;
            addView(r5, r12);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Function1 b;

        public b(int r1, Function1 r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r2) {
            this.b.invoke(Integer.valueOf(this.a));
        }
    }

    public ChannelCardViewNew41(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public ChannelCardViewNew41(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final void b() {
        Iterator r0 = ((ArrayList) this.i).iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        ((a) r0.next()).a();
        goto L4
    }

    public final SimpleDraweeView getBgStyleContainer() {
        return this.f;
    }

    public final SimpleDraweeView getTitle() {
        return this.g;
    }

    public final BigCardTitleView getTitleContainer() {
        return this.h;
    }

    public final void setClickItem(Function1<? super Integer, Unit> r6) {
        Intrinsics.checkNotNullParameter(r6, "action");
        Iterator<T> r0 = this.i.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L9;
        Object r2 = r0.next();
        int r3 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        ((a) r2).setOnClickListener(new b(r1, r6));
        r1 = r3;
        goto L4
    }

    public final void a(ChannelVO r14, com.bytedance.android.shopping.mall.homepage.card.headercard.a r15) {
        Intrinsics.checkNotNullParameter(r15, "cardContext");
        Iterator r0 = ((ArrayList) this.i).iterator();
        int r3 = 0;
    L4:
        if (r0.hasNext() == false) goto L91;
        Object r4 = r0.next();
        int r5 = r3 + 1;
        if (r3 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        final a r6 = (a) r4;
        r6.getClass();
        Intrinsics.checkNotNullParameter(r15, "mallContext");
        String r7 = null;
        if (r14 == null) goto L15;
        ChannelVO.Data r8 = r14.getData();
        if (r8 == null) goto L15;
        List<ECCommonCard> r9 = r8.getItems();
        if (r9 == null) goto L15;
        ECCommonCard r10 = (ECCommonCard) ListProtector.get(r9, r3);
    L16:
        r6.g = r10;
        if (r10 == null) goto L90;
        if ((!r10.getAnimItems().isEmpty()) == false) goto L24;
        ECCommonCard.AnimItem r11 = r10.getAnimItems().get(0);
        if (r11 == null) goto L25;
        r7 = r11.getImageUrl();
    L25:
        r14.getItemImageUrl(r3);
        Map<Integer, ECCommonCard.AnimItem> r12 = r10.getAnimItems();
        if (r12 == null) goto L30;
        ECCommonCard.AnimItem r13 = r12.get(0);
        if (r13 == null) goto L30;
        r13.getImageUrl();
    L30:
        Map<Integer, ECCommonCard.AnimItem> r16 = r10.getAnimItems();
        if (r16 == null) goto L35;
        ECCommonCard.AnimItem r17 = r16.get(1);
        if (r17 == null) goto L35;
        r17.getImageUrl();
    L35:
        if (r7 != null) goto L37;
    L40:
        boolean r18 = true;
    L41:
        if (r18 == true) goto L43;
        d0.c(r6.a, r7, r15.k);
    L43:
        r6.h = 0;
        r6.b.a(r14.getItemPrice(r3));
        ECCommonCard.AnimItem r19 = r10.getAnimItems().get(1);
        if (r19 == null) goto L90;
        ChannelItemActivity r20 = r6.c;
        r20.getClass();
        Intrinsics.checkNotNullParameter(r19, "item");
        String r21 = r19.getImageUrl();
        if (r21 != null) goto L48;
    L51:
        boolean r22 = true;
    L52:
        if (r22 == false) goto L54;
        r20.a = false;
    L60:
        if (r6.c.a == false) goto L90;
        ECCommonCard r23 = r6.g;
        if (r23 == null) goto L71;
        Map<Integer, ECCommonCard.AnimItem> r24 = r23.getAnimItems();
        if (r24 == null) goto L71;
        ECCommonCard.AnimItem r25 = r24.get(0);
        if (r25 == null) goto L71;
        Long r26 = r25.getInterval();
        if (r26 == null) goto L71;
        long r27 = r26.longValue();
    L72:
        ECCommonCard r28 = r6.g;
        if (r28 == null) goto L81;
        Map<Integer, ECCommonCard.AnimItem> r29 = r28.getAnimItems();
        if (r29 == null) goto L81;
        ECCommonCard.AnimItem r30 = r29.get(0);
        if (r30 == null) goto L81;
        Long r31 = r30.getDelayTime();
        if (r31 == null) goto L81;
        long r110 = r31.longValue();
    L82:
        Function0<Unit> r32 = new ChannelCardViewNew41$ContentContainer$applyAnimateItemAnimation$1(r6);
        if (r6.g == null) goto L90;
        if (r27 <= 0) goto L90;
        if (r110 <= 0) goto L90;
        PthreadTimer r33 = new PthreadTimer("ChannelCardViewNew41$ContentContainer");
        r33.schedule(new com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.a(r6, r32, r27), r110);
        Unit r34 = Unit.INSTANCE;
        r6.e = r33;
    L81:
        r110 = 0;
    L71:
        r27 = 0;
        goto L72
    L54:
        l93.b.a(r19.getImageUrl());
        String r35 = l93.b.a(r19.getImageUrl());
        if (r35 == null) goto L57;
        r20.a = true;
        d0.c(r20.b, r35, "");
    L58:
        r20.c.a(r19.getTagContent());
        goto L60
    L57:
        r20.a = false;
        Unit r36 = Unit.INSTANCE;
        goto L58
    L48:
        if (r21.length() == 0) goto L51;
        r22 = false;
        goto L52
    L37:
        if (r7.length() == 0) goto L40;
        r18 = false;
        goto L41
    L24:
        r7 = r14.getItemImageUrl(r3);
    L90:
        r3 = r5;
    L15:
        r10 = null;
        goto L16
    L91:
        ECEventCenter.e("disable_channel_swiper", this.j, r15.i);
    }

    public ChannelCardViewNew41(Context r9, AttributeSet r10, int r11) {
        Intrinsics.checkNotNullParameter(r9, "context");
        super(r9, r10, r11);
        int r1 = c.a;
        this.a = c.c(89, getContext(), true);
        this.b = c.c(1, getContext(), true);
        int r0 = c.c(63, getContext(), true);
        this.c = r0;
        this.d = r0;
        int r2 = c.c(28, getContext(), true);
        this.e = r2;
        View r3 = new SimpleDraweeView(r9);
        this.f = r3;
        View r4 = new SimpleDraweeView(r9);
        this.g = r4;
        int r7 = 0;
        this.h = new BigCardTitleView(r9, null, 6, 0);
        this.i = new ArrayList();
        this.j = new ChannelCardViewNew41$disableChannelSwiper$1(this);
        c.c(12, r9, true);
        setLayoutParams(new FrameLayout.LayoutParams(-1, c.c(120, getContext(), true)));
        com.bytedance.android.shopping.mall.homepage.card.headercard.util.c.a(this, r9, r10);
        addView(r3, new FrameLayout.LayoutParams(-1, -1));
        addView(r4, new FrameLayout.LayoutParams(-1, r2));
        LinearLayout r5 = new LinearLayout(r9, r10, r11);
        r5.setOrientation(0);
    L4:
        if (r7 >= 4) goto L6;
        a r12 = new a(this, r9);
        r5.setGravity(16);
        ((ArrayList) this.i).add(r12);
        FrameLayout.LayoutParams r13 = new FrameLayout.LayoutParams(this.a, -1);
        r13.setMarginStart(this.b);
        Unit r6 = Unit.INSTANCE;
        r5.addView(r12, r13);
        r7 = r7 + 1;
        goto L4
    L6:
        FrameLayout.LayoutParams r14 = new FrameLayout.LayoutParams(-1, -1);
        r14.topMargin = this.e;
        Unit r15 = Unit.INSTANCE;
        addView(r5, r14);
    }

    public /* synthetic */ ChannelCardViewNew41(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
