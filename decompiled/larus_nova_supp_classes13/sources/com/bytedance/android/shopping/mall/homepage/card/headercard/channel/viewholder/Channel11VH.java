package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder;

import android.view.View;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.ChannelCardView11;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.ChannelItemProduct;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.facebook.drawee.view.SimpleDraweeView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0002¨\u0006\u0003"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/Channel11VH;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "b", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class Channel11VH extends ChannelBaseVH {
    public static final /* synthetic */ int j = 0;
    public final SimpleDraweeView h;
    public final ChannelItemProduct i;

    public static final class a implements View.OnClickListener {
        public final /* synthetic */ Channel11VH a;

        public a(Channel11VH r1) {
            this.a = r1;
        }

        @Override // android.view.View.OnClickListener
        public final void onClick(View r5) {
            Channel11VH r6 = this.a;
            r6.U3(r6.i.getIndex(), System.currentTimeMillis(), null);
        }
    }

    public static final class b {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH
    public final void T3(ChannelVO r5) {
        super.T3(r5);
        if (r5 != null) goto L5;
        return;
    L5:
        String r0 = r5.getTitleImgUrl();
        if (r0 != null) goto L8;
    L11:
        boolean r2 = true;
    L12:
        if (r2 == true) goto L15;
        d0.c(this.h, r0, this.e.k);
    L15:
        this.i.a(r5, this.e, 0);
        return;
    L8:
        if (r0.length() == 0) goto L11;
        r2 = false;
        goto L12
    }

    public Channel11VH(ChannelCardView11 r2, com.bytedance.android.shopping.mall.homepage.card.headercard.a r3, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r4) {
        Intrinsics.checkNotNullParameter(r2, "channelCardView");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        Intrinsics.checkNotNullParameter(r4, "action");
        super(r2, r3, r4);
        SimpleDraweeView r5 = r2.getTitleSdView();
        this.h = r5;
        this.i = r2.getContentView();
        r2.setOnClickListener(new a(this));
        V3(r5);
    }
}
