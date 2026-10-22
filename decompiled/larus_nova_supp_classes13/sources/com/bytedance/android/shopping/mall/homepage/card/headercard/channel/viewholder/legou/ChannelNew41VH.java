package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.legou;

import android.view.View;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.event.e;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.AnimationType;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECCommonCard;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ECProductStruct;
import com.bytedance.android.shopping.api.mall.model.SkinConfigStyle;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.cardview.legou.pits41.ChannelCardViewNew41;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview.BigCardTitleView;
import com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH;
import com.bytedance.android.shopping.mall.homepage.tools.d0;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.facebook.drawee.view.SimpleDraweeView;
import ef3.b;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0010\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u00012\u00020\u0002:\u0001\u0003¨\u0006\u0004"}, d2 = {"Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/legou/ChannelNew41VH;", "Lcom/bytedance/android/shopping/mall/homepage/card/headercard/channel/viewholder/ChannelBaseVH;", "Lef3/b;", "a", "mall_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ChannelNew41VH extends ChannelBaseVH implements b {
    public static final /* synthetic */ int l = 0;
    public final BigCardTitleView h;
    public final ChannelCardViewNew41 i;
    public final com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a j;
    public final Function0<Boolean> k;

    public static final class a {
    }

    static {
    }

    @Override // ef3.b
    public final void onRelease() {
        e r0 = this.h.j;
        if (r0 == null) goto L5;
        ECEventCenter.f("ec.mallAllowEffectShow", r0);
    L5:
        ECEventCenter.f("disable_channel_swiper", this.i.j);
    }

    @Override // ef3.b
    public final void p() {
        this.h.b = false;
        this.i.b();
    }

    @Override // ef3.b
    public final void N2(View r2) {
        Intrinsics.checkNotNullParameter(r2, "cardView");
        Intrinsics.checkNotNullParameter(r2, "cardView");
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH
    public final void T3(ChannelVO r26) {
        super.T3(r26);
        this.i.getTitleContainer().a(r26, this.e, this.j);
        SimpleDraweeView r2 = this.i.getTitle();
        if (r26 == null) goto L6;
        String r3 = r26.getBgUrl();
        if (r3 == null) goto L6;
    L7:
        d0.c(r2, r3, this.e.k);
        com.bytedance.android.shopping.mall.homepage.card.headercard.a r4 = this.e;
        if ((r4 instanceof com.bytedance.android.shopping.mall.homepage.card.headercard.a) == true) goto L10;
        r4 = null;
    L10:
        int r5 = 1;
        int r6 = 0;
        if (r4 == null) goto L23;
        SkinConfigStyle r7 = r4.b();
        if (r7 == null) goto L23;
        SkinConfigStyle.SecKillChannelStyle r8 = r7.getSecKillChannelStyle();
        if (r8 == null) goto L23;
        String r9 = r8.getBgUrl();
        if (r9 == null) goto L23;
        if (r9.length() != 0) goto L21;
        boolean r10 = true;
    L22:
        if (r10 == true) goto L23;
    L24:
        d0.c(this.i.getBgStyleContainer(), r9, this.e.k);
        if (r26 == null) goto L123;
        Intrinsics.checkNotNullParameter(r26, "$this$generateAnimateItem");
        ChannelVO.Data r11 = r26.getData();
        if (r11 == null) goto L29;
        ChannelVO.Animation r12 = r11.getAnimation();
    L30:
        ChannelVO.Data r13 = r26.getData();
        if (r13 == null) goto L123;
        List<ECCommonCard> r14 = r13.getSubItems();
        if (r14 == null) goto L123;
        Iterator<T> r15 = r14.iterator();
    L36:
        if (r15.hasNext() == false) goto L123;
        ECCommonCard r16 = (ECCommonCard) r15.next();
        if (r16 == null) goto L122;
        Integer r17 = r16.getPosition();
        if (r17 == null) goto L43;
        int r18 = r17.intValue();
    L44:
        if (r18 < 0) goto L122;
        ChannelVO.Data r19 = r26.getData();
        if (r19 == null) goto L113;
        List<ECCommonCard> r110 = r19.getItems();
        if (r110 == null) goto L113;
        ECProductStruct r111 = r16.getProduct();
        if (r111 == null) goto L55;
        Object r112 = r111.getCoverWhiteBg();
        if (r112 == null) goto L55;
        String r113 = l93.b.a(r112);
        if (r113 == null) goto L55;
    L60:
        String r114 = r113;
    L62:
        int r115 = AnimationType.TAG_SUB_PRODUCT_CAROUSEL.getValue();
        if (r12 == null) goto L65;
        Integer r116 = r12.getAnimationType();
    L66:
        if (r116 == null) goto L93;
        if (r115 != r116.intValue()) goto L93;
        Map<Integer, ECCommonCard.AnimItem> r117 = r16.getAnimItems();
        Integer r118 = Integer.valueOf(r6);
        ChannelVO.Data.EntrancePit r119 = r16.getEntrancePit();
        if (r119 == null) goto L73;
        Integer r120 = r119.getTagType();
    L74:
        ChannelVO.Data.EntrancePit r121 = r16.getEntrancePit();
        if (r121 == null) goto L77;
        String r122 = r121.getContent();
    L78:
        Integer r123 = Integer.valueOf(r18);
        ECProductStruct r124 = r16.getProduct();
        if (r124 == null) goto L83;
        ECProductStruct.Extra r125 = r124.getExtra();
        if (r125 == null) goto L83;
        String r20 = r125.getNYuanMPiece();
    L84:
        Long r126 = r12.getCarouselPeriod();
        long r21 = 0;
        if (r126 == null) goto L87;
        long r23 = r126.longValue();
    L88:
        Long r22 = Long.valueOf(r23 * ((long) 1000));
        long r24 = 2;
        Long r127 = r12.getCarouselTimes();
        if (r127 == null) goto L91;
        r21 = r127.longValue();
    L91:
        r117.put(r118, new ECCommonCard.AnimItem(r120, r122, r114, -1, r123, r20, 1000L, r22, Long.valueOf(r24 * r21)));
        goto L93
    L87:
        r23 = 0;
    L83:
        r20 = null;
        goto L84
    L77:
        r122 = null;
        goto L78
    L73:
        r120 = null;
    L93:
        ECProductStruct r25 = r16.getProduct();
        if (r25 == null) goto L98;
        ECProductStruct.Extra r27 = r25.getExtra();
        if (r27 == null) goto L98;
        String r128 = r27.getNYuanMPiece();
    L99:
        Map<Integer, ECCommonCard.AnimItem> r28 = r16.getAnimItems();
        Integer r29 = Integer.valueOf(r5);
        ChannelVO.Data.EntrancePit r30 = r16.getEntrancePit();
        if (r30 == null) goto L102;
        Integer r129 = r30.getTagType();
    L103:
        ChannelVO.Data.EntrancePit r31 = r16.getEntrancePit();
        if (r31 == null) goto L106;
        String r130 = r31.getContent();
    L107:
        if (r12 == null) goto L111;
        Map<String, String> r32 = r12.getExtra();
        if (r32 == null) goto L111;
        String r131 = r32.get(r128);
        int r33 = -1;
    L112:
        r28.put(r29, new ECCommonCard.AnimItem(r129, r130, r131, Integer.valueOf(r33), Integer.valueOf(r18), r128, null, null, null, 448, null));
        Unit r34 = Unit.INSTANCE;
        ListProtector.add(r110, r18, r16);
    L111:
        r33 = -1;
        r131 = null;
        goto L112
    L106:
        r130 = null;
        goto L107
    L102:
        r129 = null;
    L98:
        r128 = null;
        goto L99
    L65:
        r116 = null;
    L55:
        ECProductStruct r132 = r16.getProduct();
        if (r132 == null) goto L61;
        Object r133 = r132.getCover();
        if (r133 == null) goto L61;
        r113 = l93.b.a(r133);
    L61:
        r114 = null;
    L113:
        ChannelVO.Data.EntrancePit r35 = r16.getEntrancePit();
        if (r35 == null) goto L122;
        ChannelVO.Data r36 = r26.getData();
        if (r36 == null) goto L122;
        ChannelVO.Data.Entrance r37 = r36.getEntrance();
        if (r37 == null) goto L122;
        List<ChannelVO.Data.EntrancePit> r38 = r37.getEntranceContentFormat();
        if (r38 == null) goto L122;
        ListProtector.add(r38, r18, r35);
        goto L122
    L43:
        r18 = -1;
    L122:
        r5 = 1;
        r6 = 0;
        goto L36
    L29:
        r12 = null;
    L123:
        this.i.a(r26, this.e);
        return;
    L21:
        r10 = false;
    L23:
        r9 = "https://lf3-static.bytednsdoc.com/obj/eden-cn/sshfteh7nuhpebps/20240513-114509.png";
    L6:
        r3 = "";
        goto L7
    }

    @Override // ef3.b
    public final void Q0(boolean r2, Boolean r3, boolean r4) {
        this.h.d(r2, r3, r4);
        if (r2 == true) goto L6;
        this.i.b();
        return;
    }

    @Override // com.bytedance.android.shopping.mall.homepage.card.headercard.channel.viewholder.ChannelBaseVH
    public final void U3(int r1, long r2, Map<String, ? extends Object> r4) {
        super.U3(r1, r2, r4);
        this.h.c(r1);
    }

    public ChannelNew41VH(ChannelCardViewNew41 r2, com.bytedance.android.shopping.mall.homepage.card.headercard.a r3, com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r4, Function0<Boolean> r5) {
        Intrinsics.checkNotNullParameter(r2, "channelCardView");
        Intrinsics.checkNotNullParameter(r3, "mallContext");
        Intrinsics.checkNotNullParameter(r4, "action");
        super(r2, r3, r4);
        this.i = r2;
        this.j = r4;
        this.k = r5;
        this.h = r2.getTitleContainer();
        r2.setClickItem(new AnonymousClass1(this));
        V3(r2.getTitleContainer());
        r3.a(this);
    }
}
