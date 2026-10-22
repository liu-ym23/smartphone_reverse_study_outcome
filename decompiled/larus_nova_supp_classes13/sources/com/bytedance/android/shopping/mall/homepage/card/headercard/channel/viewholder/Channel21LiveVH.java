package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder;

import android.view.View;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView21Live;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ChannelItemLive;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/Channel21LiveVH;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Lef3/b;", "c", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Channel21LiveVH extends ChannelBaseVH implements ef3.b {
    public static final /* synthetic */ int k = 0;
    public final SimpleDraweeView h;
    public final ChannelItemLive i;
    public final ChannelItemLive j;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Channel21LiveVH a;

        public a(Channel21LiveVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            Channel21LiveVH r6 = this.a;
            long r0 = System.currentTimeMillis();
            int r2 = ChannelBaseVH.g;
            r6.U3(0, r0, null);
        }
    }

    public static final class b implements View.OnClickListener {
        public final /* synthetic */ Channel21LiveVH a;

        public b(Channel21LiveVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            Channel21LiveVH r6 = this.a;
            long r0 = System.currentTimeMillis();
            int r2 = ChannelBaseVH.g;
            r6.U3(1, r0, null);
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
    public final void T3(ChannelVO r8) {
        super.T3(r8);
        String r0 = null;
        if (r8 == null) goto L5;
        String r1 = r8.getTitleImgUrl();
    L6:
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L15;
        d0.c(this.h, r1, this.e.k);
    L15:
        if (r8 == null) goto L17;
        String r3 = r8.getItemImageUrl(0);
    L18:
        if (r3 != null) goto L20;
    L23:
        boolean r5 = true;
    L25:
        if (r5 == true) goto L37;
        d0.c(this.i.getAvatarSdView(), r3, this.e.k);
        String r6 = r8.getItemTag(0);
        if (r6 != null) goto L30;
    L33:
        boolean r7 = true;
    L34:
        if (r7 == true) goto L36;
        this.i.getTagView().setText(r6);
        this.i.getTagView().setVisibility(0);
        goto L37
    L36:
        this.i.getTagView().setVisibility(8);
        goto L37
    L30:
        if (r6.length() == 0) goto L33;
        r7 = false;
    L37:
        if (r8 == null) goto L39;
        r0 = r8.getItemImageUrl(1);
    L39:
        if (r0 != null) goto L41;
    L44:
        boolean r9 = true;
    L45:
        if (r9 == true) goto L58;
        d0.c(this.j.getAvatarSdView(), r0, this.e.k);
        String r10 = r8.getItemTag(1);
        if (r10 != null) goto L50;
    L53:
        if (r2 == true) goto L55;
        this.j.getTagView().setText(r10);
        this.j.getTagView().setVisibility(0);
        return;
    L55:
        this.j.getTagView().setVisibility(8);
        return;
    L50:
        if (r10.length() == 0) goto L53;
        r2 = false;
        goto L53
    L58:
        return;
    L41:
        if (r0.length() == 0) goto L44;
        r9 = false;
        goto L45
    L20:
        if (r3.length() == 0) goto L23;
        r5 = false;
        goto L25
    L17:
        r3 = null;
        goto L18
    L9:
        if (r1.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public Channel21LiveVH(ChannelCardView21Live r3, com.bytedance.android.shopping.mall.homepage.card.headercard.a r4, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r5) {
        Intrinsics.checkNotNullParameter(r3, "channelCardView");
        Intrinsics.checkNotNullParameter(r4, "mallContext");
        Intrinsics.checkNotNullParameter(r5, "action");
        super(r3, r4, r5);
        SimpleDraweeView r6 = r3.getTitleSdView();
        this.h = r6;
        ChannelItemLive r0 = r3.getLeftItemLiveContent();
        this.i = r0;
        ChannelItemLive r7 = r3.getRightItemLiveContent();
        this.j = r7;
        r0.setOnClickListener(new a(this));
        r7.setOnClickListener(new b(this));
        r4.a(this);
        V3(r6);
    }

    @Override // ef3.b
    public final void Q0(boolean r1, Boolean r2, boolean r3) {
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L8;
        if (r1 == false) goto L6;
        this.i.b();
        this.j.b();
        return;
    L6:
        ChannelItemLive r4 = this.i;
        ChannelItemLive.a(r4.f);
        ChannelItemLive.a(r4.e);
        ChannelItemLive.a(r4.g);
        ChannelItemLive r5 = this.j;
        ChannelItemLive.a(r5.f);
        ChannelItemLive.a(r5.e);
        ChannelItemLive.a(r5.g);
        return;
    }
}
