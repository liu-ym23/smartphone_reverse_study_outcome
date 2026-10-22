package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder;

import android.view.View;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView11Live;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ChannelItemLive;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/Channel11LiveVH;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Lef3/b;", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Channel11LiveVH extends ChannelBaseVH implements ef3.b {
    public static final /* synthetic */ int j = 0;
    public final SimpleDraweeView h;
    public final ChannelItemLive i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Channel11LiveVH a;

        public a(Channel11LiveVH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            long r0 = System.currentTimeMillis();
            Channel11LiveVH r6 = this.a;
            int r2 = ChannelBaseVH.g;
            r6.U3(0, r0, null);
        }
    }

    public static final class b {
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
    public final void T3(ChannelVO r7) {
        super.T3(r7);
        String r0 = null;
        if (r7 == null) goto L5;
        String r1 = r7.getTitleImgUrl();
    L6:
        boolean r2 = true;
        if (r1 != null) goto L9;
    L12:
        boolean r4 = true;
    L13:
        if (r4 == true) goto L16;
        d0.c(this.h, r1, this.e.k);
    L16:
        if (r7 == null) goto L18;
        r0 = r7.getItemImageUrl(0);
    L18:
        if (r0 != null) goto L20;
    L23:
        boolean r3 = true;
    L24:
        if (r3 == true) goto L37;
        d0.c(this.i.getAvatarSdView(), r0, this.e.k);
        String r8 = r7.getItemTag(0);
        if (r8 != null) goto L29;
    L32:
        if (r2 == true) goto L34;
        this.i.getTagView().setText(r8);
        this.i.getTagView().setVisibility(0);
        return;
    L34:
        this.i.getTagView().setVisibility(8);
        return;
    L29:
        if (r8.length() == 0) goto L32;
        r2 = false;
        goto L32
    L37:
        return;
    L20:
        if (r0.length() == 0) goto L23;
        r3 = false;
        goto L24
    L9:
        if (r1.length() == 0) goto L12;
        r4 = false;
        goto L13
    L5:
        r1 = null;
        goto L6
    }

    public Channel11LiveVH(ChannelCardView11Live r2, com.bytedance.android.shopping.mall.homepage.card.headercard.a r3, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r4) {
        Intrinsics.checkNotNullParameter(r2, "channelCardView");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        Intrinsics.checkNotNullParameter(r4, "action");
        super(r2, r3, r4);
        SimpleDraweeView r5 = r2.getTitleSdView();
        this.h = r5;
        this.i = r2.getContentView();
        r2.setOnClickListener(new a(this));
        r3.a(this);
        V3(r5);
    }

    @Override // ef3.b
    public final void Q0(boolean r1, Boolean r2, boolean r3) {
        if (Intrinsics.areEqual(r2, Boolean.FALSE) == false) goto L8;
        if (r1 == false) goto L6;
        this.i.b();
        return;
    L6:
        ChannelItemLive r4 = this.i;
        ChannelItemLive.a(r4.f);
        ChannelItemLive.a(r4.e);
        ChannelItemLive.a(r4.g);
        return;
    }
}
