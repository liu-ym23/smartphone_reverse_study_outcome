package com.bytedance.android.shopping.mall.homepage.card.headercard.channel.itemview;

import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.BtmData;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelCID;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.ChannelVO;
import com.bytedance.android.shopping.api.mall.common.homepage.card.headercard.model.Coupon4Activity;
import com.bytedance.android.shopping.mall.feed.ECMallFeed;
import com.bytedance.android.shopping.mall.homepage.card.headercard.a;
import com.bytedance.android.shopping.mall.homepage.card.headercard.util.Popup7Type;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Lambda;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000\b\n\u0000\n\u0002\u0010\u0002\n\u0000\u0010\u0000\u001a\u00020\u0001H\n¢\u0006\u0002\b\u0002"}, d2 = {"<anonymous>", "", "invoke"}, k = 3, mv = {1, 4, 3})
final class BigCardTitleView$playLottie$1 extends Lambda implements Function0<Unit> {
    final /* synthetic */ BigCardTitleView this$0;

    public BigCardTitleView$playLottie$1(BigCardTitleView r1) {
        this.this$0 = r1;
        super(0);
    }

    /* JADX INFO: renamed from: invoke, reason: collision with other method in class */
    public final void m1256invoke() {
        a r0 = this.this$0.h;
        String r1 = "";
        if (r0 == null) goto L50;
        ECMallFeed r2 = r0.h;
        if (r2 == null) goto L50;
        ECMallFeed.f r3 = r2.A1;
        if (r3 == null) goto L50;
        Map<String, Object> r4 = r3.getGlobalProps();
        if (r4 == null) goto L50;
        Object r6 = r4.get("delivery_type");
        if ((r6 instanceof String) == true) goto L13;
        r6 = null;
    L13:
        String r7 = (String) r6;
        Object r5 = r4.get("delivery_value");
        if ((r5 instanceof String) == true) goto L16;
        r5 = null;
    L16:
        String r8 = (String) r5;
        if (r8 != null) goto L19;
    L20:
        if (r8 != null) goto L22;
    L23:
        if (r8 != null) goto L25;
    L27:
        if (r8 != null) goto L29;
    L31:
        String r9 = "";
    L33:
        if (Intrinsics.areEqual(r9, Popup7Type.Seckill.getValue()) == false) goto L42;
        ChannelVO r10 = this.this$0.g;
        if (r10 == null) goto L37;
        String r11 = r10.getComponentId();
    L39:
        if (Intrinsics.areEqual(r11, ChannelCID.SECKILL.getValue()) == false) goto L42;
        this.this$0.b = true;
        goto L42
    L37:
        r11 = null;
    L42:
        if (Intrinsics.areEqual(r9, Popup7Type.Subsidy.getValue()) == false) goto L50;
        ChannelVO r12 = this.this$0.g;
        if (r12 == null) goto L46;
        String r13 = r12.getComponentId();
    L48:
        if (Intrinsics.areEqual(r13, ChannelCID.SUBSIDE.getValue()) == false) goto L50;
        this.this$0.b = true;
        goto L50
    L46:
        r13 = null;
        goto L48
    L29:
        if (StringsKt.contains$default(r8, "mall_channels_regular/seckill", false, 2, null) != true) goto L31;
        r9 = Popup7Type.Seckill.getValue();
        goto L33
    L25:
        if (StringsKt.contains$default(r8, "ecommerce_subsidy_douyin", false, 2, null) != true) goto L27;
    L26:
        r9 = Popup7Type.Subsidy.getValue();
        goto L33
    L22:
        if (StringsKt.contains$default(r8, "/mall_channels_regular/preorder/", false, 2, null) == true) goto L26;
    L19:
        if (StringsKt.contains$default(r8, "/mall_channels_group_bargain/", false, 2, null) == true) goto L26;
    L50:
        BigCardTitleView r14 = this.this$0;
        ChannelVO r15 = r14.g;
        a r16 = r14.h;
        if (r16 == null) goto L57;
        ECMallFeed r17 = r16.h;
        if (r17 == null) goto L57;
        ECMallFeed.f r18 = r17.A1;
        if (r18 == null) goto L57;
        Map<String, Object> r19 = r18.getGlobalProps();
    L58:
        if (r15 == null) goto L81;
        if (r19 == null) goto L81;
        BigCardTitleView r20 = this.this$0;
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a r21 = r20.i;
        if (r21 == null) goto L81;
        Pair[] r22 = new Pair[2];
        ChannelVO.a r23 = r20.f;
        if (r23 == null) goto L72;
        Coupon4Activity r24 = r23.c;
        if (r24 == null) goto L72;
        Long r25 = r24.getId();
        if (r25 == null) goto L72;
        String r26 = String.valueOf(r25.longValue());
        if (r26 == null) goto L72;
        r1 = r26;
    L72:
        r22[0] = TuplesKt.to("coupon_id", r1);
        if (this.this$0.b == false) goto L75;
        String r27 = "popup";
    L76:
        r22[1] = TuplesKt.to("behave_type", r27);
        Map r28 = MapsKt.mapOf(r22);
        a r29 = this.this$0.h;
        if (r29 == null) goto L79;
        BtmData r110 = r29.j;
    L80:
        com.bytedance.android.shopping.mall.homepage.card.headercard.channel.action.a.d(r21, r15, r28, false, r110, r19);
        goto L81
    L79:
        r110 = null;
        goto L80
    L75:
        r27 = "normal";
    L81:
        BigCardTitleView r30 = this.this$0;
        a r31 = r30.h;
        if (r31 == null) goto L84;
        String r32 = r31.i;
    L86:
        if (r30.j != null) goto L89;
        if (r32 == null) goto L89;
        BigCardTitleView$playLottie$1$sub$1 r33 = new BigCardTitleView$playLottie$1$sub$1(this);
        r30.j = r33;
        ECEventCenter.e("ec.mallAllowEffectShow", r33, r32);
    L89:
        a r34 = this.this$0.h;
        if (r34 == null) goto L97;
        ECMallFeed r35 = r34.h;
        if (r35 == null) goto L98;
        ECMallFeed.f r36 = r35.A1;
        if (r36 == null) goto L99;
        r36.Q30("requestChannelTitleLottieShow", null);
        return;
    L99:
        return;
    L98:
        return;
    L97:
        return;
    L84:
        r32 = null;
    L57:
        r19 = null;
        goto L58
    }

    public /* bridge */ /* synthetic */ Object invoke() {
        m1256invoke();
        return Unit.INSTANCE;
    }
}
