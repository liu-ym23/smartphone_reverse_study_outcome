package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou;

import android.animation.Animator;
import android.animation.AnimatorInflater;
import android.animation.AnimatorSet;
import android.view.View;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.ChannelItemLive;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits31.Common31ChannelCardLayout;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/legou/Channel31LiveVH;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Lef3/b;", "c", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Channel31LiveVH extends ChannelBaseVH implements ef3.b {
    public static final /* synthetic */ int k = 0;
    public final SimpleDraweeView h;
    public final Common31ChannelCardLayout i;
    public final Function0<Boolean> j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ int a;
        public final /* synthetic */ Channel31LiveVH b;

        public a(int r1, Channel31LiveVH r2) {
            this.a = r1;
            this.b = r2;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            Function0<Boolean> r6 = this.b.j;
            if (r6 != null) goto L5;
        L7:
            this.b.U3(this.a, System.currentTimeMillis(), null);
            return;
        L5:
            if (((Boolean) r6.invoke()).booleanValue() == true) goto L7;
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Channel31LiveVH a;

        public b(Channel31LiveVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            Function0<Boolean> r6 = this.a.j;
            if (r6 != null) goto L5;
        L7:
            this.a.U3(0, System.currentTimeMillis(), null);
            return;
        L5:
            if (((Boolean) r6.invoke()).booleanValue() == true) goto L7;
        }
    }

    public static final class c {
    }

    static {
    }

    @Override // ef3.b
    public final void onRelease() {
    }

    @Override // ef3.b
    public final void p() {
    }

    @Override // ef3.b
    public final void N2(View r2) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r2, "cardView");
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH
    public final void T3(ChannelVO r6) {
        super.T3(r6);
        if (r6 != null) goto L5;
        return;
    L5:
        String r0 = r6.getTagUrl();
        int r1 = 0;
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L14;
        d0.c(this.h, r0, this.e.k);
    L14:
        Iterator<T> r3 = this.i.getProductContentList().iterator();
    L16:
        if (r3.hasNext() == false) goto L21;
        Object r4 = r3.next();
        int r5 = r1 + 1;
        if (r1 >= 0) goto L20;
        CollectionsKt.throwIndexOverflow();
    L20:
        ((gf3.a) r4).a(r6, this.e, r1);
        r1 = r5;
        goto L16
    L21:
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    @Override // ef3.b
    public final void Q0(boolean r4, Boolean r5, boolean r6) {
        if (Intrinsics.areEqual(r5, Boolean.FALSE) == false) goto L40;
        Iterator<T> r7 = this.i.getProductContentList().iterator();
    L6:
        if (r7.hasNext() == false) goto L49;
        gf3.a r8 = (gf3.a) r7.next();
        Animator r1 = null;
        if ((r8 instanceof ChannelItemLive) == true) goto L10;
        r8 = null;
    L10:
        ChannelItemLive r9 = (ChannelItemLive) r8;
        if (r9 == null) goto L6;
        if (r4 == true) goto L14;
        ChannelItemLive.b(r9.h);
        ChannelItemLive.b(r9.g);
        ChannelItemLive.b(r9.i);
        goto L6
    L14:
        if (r9.g != null) goto L22;
        Animator r0 = AnimatorInflater.loadAnimator(r9.getContext(), 2130837535);
        if ((r0 instanceof AnimatorSet) == true) goto L18;
        r0 = null;
    L18:
        AnimatorSet r2 = (AnimatorSet) r0;
        r9.g = r2;
        if (r2 == null) goto L22;
        r2.setTarget(r9.c);
    L22:
        if (r9.h != null) goto L30;
        Animator r3 = AnimatorInflater.loadAnimator(r9.getContext(), 2130837536);
        if ((r3 instanceof AnimatorSet) == true) goto L26;
        r3 = null;
    L26:
        AnimatorSet r10 = (AnimatorSet) r3;
        r9.h = r10;
        if (r10 == null) goto L30;
        r10.setTarget(r9.d);
    L30:
        if (r9.i != null) goto L38;
        Animator r11 = AnimatorInflater.loadAnimator(r9.getContext(), 2130837534);
        if ((r11 instanceof AnimatorSet) == false) goto L35;
        r1 = r11;
    L35:
        AnimatorSet r12 = (AnimatorSet) r1;
        r9.i = r12;
        if (r12 == null) goto L38;
        r12.setTarget(r9.e);
    L38:
        ChannelItemLive.c(r9.h);
        ChannelItemLive.c(r9.g);
        ChannelItemLive.c(r9.i);
        goto L6
    L49:
        return;
    }

    public Channel31LiveVH(Common31ChannelCardLayout r3, com.bytedance.android.shopping.mall.homepage.card.headercard.a r4, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r5, Function0<Boolean> r6) {
        Intrinsics.checkNotNullParameter(r3, "channelCardView");
        Intrinsics.checkNotNullParameter(r4, "mallContext");
        Intrinsics.checkNotNullParameter(r5, "action");
        super(r3, r4, r5);
        this.i = r3;
        this.j = r6;
        this.h = r3.getTitleSdView();
        Iterator<T> r7 = r3.getProductContentList().iterator();
        int r8 = 0;
    L4:
        if (r7.hasNext() == false) goto L13;
        Object r9 = r7.next();
        int r0 = r8 + 1;
        if (r8 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        Object r10 = (gf3.a) r9;
        if (r10 == null) goto L12;
        ((View) r10).setOnClickListener(new a(r8, this));
        r8 = r0;
        goto L4
    L12:
        throw new NullPointerException("null cannot be cast to non-null type android.view.View");
    L13:
        this.i.setOnClickListener(new b(this));
        r4.a(this);
        V3(this.h);
    }
}
