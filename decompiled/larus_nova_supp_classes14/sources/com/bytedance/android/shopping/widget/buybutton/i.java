package com.bytedance.android.shopping.widget.buybutton;

import android.view.View;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.android.ec.model.ButtonType;
import com.bytedance.android.ec.model.ClickButtonParam;
import com.bytedance.android.ec.model.SingleClickParam;
import com.bytedance.android.ec.model.response.anchorv3.ButtonTipsStruct;
import com.bytedance.android.ec.model.response.anchorv3.OrderStatus;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductLink;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.anchorv3.repository.api.AnchorV3Api;
import com.bytedance.android.shopping.anchorv3.repository.dto.PromotionAutoApplyCouponRequestParam;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class i implements View.OnClickListener {
    public final /* synthetic */ g a;
    public final /* synthetic */ SingleClickParam b;
    public final /* synthetic */ ClickButtonParam c;
    public final /* synthetic */ int d;

    public i(g r1, SingleClickParam r2, ClickButtonParam r3, int r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // android.view.View.OnClickListener
    public final void onClick(View r22) {
        if (this.b.getSetGrey() == true) goto L5;
        final boolean r5 = false;
        String r8 = "";
        if (this.c.getBack2AnchorV3Page() == false) goto L23;
        c r2 = this.a.e;
        String r9 = this.c.getSchema();
        if (r9 == null) goto L17;
        String r1 = com.bytedance.android.ec.core.btm.c.c(r9, r22, "c2894.d56028", new Pair[0]);
    L18:
        Pair[] r7 = new Pair[1];
        String r10 = this.c.getEnterFrom();
        if (r10 == null) goto L22;
        r8 = r10;
    L22:
        r7[0] = TuplesKt.to("source_3d", r8);
        r2.b(r1, MapsKt.hashMapOf(r7), MapsKt.hashMapOf(new Pair[]{TuplesKt.to("entrance_info", this.c.getEntranceInfo())}));
    L131:
        if (com.bytedance.android.ec.model.b.a(this.b.getButtonType()) == false) goto L155;
        c r3 = this.a.e;
        ButtonTipsStruct r4 = this.b.getButtonTipsStruct();
        if (r4 == null) goto L135;
        String r6 = r4.getTips();
    L136:
        c.a.a(r3, r6, null, 2);
        ButtonTipsStruct r11 = this.b.getButtonTipsStruct();
        if (r11 == null) goto L139;
        String r12 = r11.getTips();
    L141:
        if (com.bytedance.android.shopping.extensions.k.c(r12) == false) goto L162;
        int r13 = o63.j.e;
        b r14 = this.a.b;
        if (r14 == null) goto L145;
        Boolean r15 = Boolean.valueOf(r14.c());
    L146:
        ButtonTipsStruct r16 = this.b.getButtonTipsStruct();
        if (r16 == null) goto L149;
        String r17 = r16.getTips();
    L151:
        if (Intrinsics.areEqual(r15, Boolean.TRUE) == false) goto L153;
        String r18 = "combination_toast_show";
    L154:
        o63.j r19 = new o63.j(r18);
        r19.d = r17;
        r19.post(null, null);
        goto L162
    L153:
        r18 = "livesdk_combination_toast_show";
        goto L154
    L149:
        r17 = null;
        goto L151
    L145:
        r15 = null;
    L162:
        b r20 = this.a.b;
        if (r20 == null) goto L167;
        r20.d(this.b.getSetGrey());
        return;
    L167:
        return;
    L139:
        r12 = null;
        goto L141
    L135:
        r6 = null;
        goto L136
    L155:
        g r21 = this.a;
        ClickButtonParam r23 = this.c;
        r21.getClass();
        yk3.a r24 = new yk3.a();
        r24.b = r23.getProductId();
        r24.a = r23.getAuthorId();
        r24.c = r23.getEnterFrom();
        r24.d = "button";
        Map r25 = r23.getLogExtra();
        if (r25 != null) goto L158;
        r25 = MapsKt.emptyMap();
    L158:
        r24.appendExtraParams(r25);
        Map r26 = r23.getTrackAdditions();
        if (r26 != null) goto L161;
        r26 = MapsKt.emptyMap();
    L161:
        r24.appendExtraParams(r26);
        r24.post(null, null);
        goto L162
    L17:
        r1 = null;
        goto L18
    L23:
        ButtonType r27 = this.b.getButtonType();
        Intrinsics.checkNotNullParameter(r27, "$this$isAppointPromotion");
        ButtonType r28 = ButtonType.TimingSale;
        if (r27 != r28) goto L26;
    L31:
        boolean r29 = true;
    L32:
        if (r29 == true) goto L34;
        ButtonType r30 = this.b.getButtonType();
        Intrinsics.checkNotNullParameter(r30, "$this$isDepositPresaleAppointPromotion");
        if (r30 != ButtonType.DepositPresaleAppointed) goto L65;
    L68:
        boolean r31 = true;
    L69:
        if (r31 == false) goto L85;
        final e r32 = this.a.a;
        String r33 = this.c.getRoomId();
        String r34 = this.c.getAuthorId();
        String r35 = this.c.getProductId();
        String r36 = this.c.getPromotionId();
        r32.getClass();
        AnchorV3Api.a r37 = AnchorV3Api.a;
        if (r33 != null) goto L73;
        String r110 = "";
    L74:
        if (r34 != null) goto L76;
        String r111 = "";
    L77:
        if (r35 != null) goto L79;
        String r112 = "";
    L81:
        if (r36 != null) goto L83;
        String r113 = "";
    L84:
        Function1<Boolean, Unit> r114 = new ShoppingPurchaseButtonModel$appointDepositPresalePromotion$1(r32);
        r37.getClass();
        AnchorV3Api.a.e(r110, r111, r112, "live", r113, r114);
        goto L131
    L83:
        r113 = r36;
        goto L84
    L79:
        r112 = r35;
        goto L81
    L76:
        r111 = r34;
        goto L77
    L73:
        r110 = r33;
        goto L74
    L85:
        ButtonType r38 = this.b.getButtonType();
        Intrinsics.checkNotNullParameter(r38, "$this$isAuctionPromotion");
        if (r38 != ButtonType.Auction) goto L88;
        boolean r39 = true;
    L89:
        if (r39 == false) goto L98;
        c r40 = this.a.e;
        PromotionProductLink r41 = this.b.getLinks();
        if (r41 == null) goto L95;
        String r42 = r41.getH5Url();
        if (r42 == null) goto L95;
        String r43 = com.bytedance.android.ec.core.btm.c.c(r42, r22, "c2894.d56028", new Pair[0]);
    L96:
        r40.g(r43);
    L95:
        r43 = null;
        goto L96
    L98:
        if (this.b.getNeedCheckSku() == false) goto L100;
        c r44 = this.a.e;
        SingleClickParam r45 = this.b;
        ClickButtonParam r46 = this.c;
        com.bytedance.android.btm.api.model.d r47 = new com.bytedance.android.btm.api.model.d();
        r47.a = "c2894.d56028";
        r47.b = PageFinder.via(this.a.e);
        Unit r48 = Unit.INSTANCE;
        r44.a(r45, r46, r47);
        goto L131
    L100:
        g r49 = this.a;
        Integer r50 = this.b.getOrderStatus();
        PromotionProductLink r51 = this.b.getLinks();
        r49.getClass();
        if (r51 == null) goto L103;
        String r115 = r51.getSmallAppUrl();
    L105:
        if (a2.b(r115) == true) goto L115;
        Lazy r116 = ECAppInfoService.a;
        if (ECAppInfoService.k() == false) goto L116;
        if (r50 == null) goto L111;
        int r52 = r50.intValue();
    L113:
        if (r52 < OrderStatus.CAN_EXPERIENCE.getSTATUS()) goto L116;
        c.a.a(r49.e, null, 2131896112, 1);
        goto L115
    L111:
        r52 = 0;
    L116:
        c r53 = r49.e;
        if (r51 == null) goto L119;
        String r54 = r51.getSmallAppUrl();
    L120:
        boolean r55 = r53.openMiniApp(r54);
    L121:
        if (r55 == true) goto L131;
        if (this.b.getApplyCoupon() == false) goto L129;
        final g r56 = this.a;
        final int r57 = this.d;
        final ClickButtonParam r58 = this.c;
        r56.getClass();
        int r59 = com.bytedance.android.shopping.anchorv3.utils.f.a;
        e r60 = r56.a;
        SingleClickParam r61 = (SingleClickParam) CollectionsKt.getOrNull(r58.getSingleClickParams(), r57);
        if (r61 == null) goto L127;
        long r62 = r61.getApplyCouponPrice();
    L128:
        r60.getClass();
        com.bytedance.android.shopping.anchorv3.utils.f.a(new PromotionAutoApplyCouponRequestParam(r60.d, r60.f, r62, r60.j, r60.g, r60.h, null, null, 192, null), new ShoppingPurchaseButtonPresenter$getApplyCouponResult$1(r56, r58, r57));
        goto L131
    L127:
        r62 = 0;
        goto L128
    L129:
        g r63 = this.a;
        c r64 = r63.e;
        e r65 = r63.a;
        int r66 = this.d;
        ClickButtonParam r67 = this.c;
        r65.getClass();
        r64.f(com.bytedance.android.ec.core.btm.c.c(e.a(r66, r67), r22, "c2894.d56028", new Pair[0]));
        goto L131
    L119:
        r54 = null;
    L115:
        r55 = false;
        goto L121
    L103:
        r115 = null;
        goto L105
    L88:
        r39 = false;
        goto L89
    L65:
        if (r30 == ButtonType.DepositPresaleNotAppointed) goto L68;
        r31 = false;
        goto L69
    L34:
        if (this.b.getButtonType() == r28) goto L131;
        final e r68 = this.a.a;
        String r69 = this.c.getPromotionId();
        if (r69 != null) goto L38;
        String r70 = "";
    L39:
        String r71 = this.c.getItemId();
        if (r71 != null) goto L42;
        String r117 = "";
    L43:
        String r72 = this.c.getSecAuthorId();
        if (r72 != null) goto L46;
        String r118 = "";
    L48:
        if (this.b.getButtonType() != ButtonType.TimingSaleAppointed) goto L50;
        r5 = true;
    L50:
        String r73 = this.c.getMetaParams();
        if (r73 != null) goto L53;
        r73 = "";
    L53:
        String r74 = this.c.getProductId();
        if (r74 != null) goto L56;
        String r119 = "";
    L57:
        r68.getClass();
        Intrinsics.checkNotNullParameter(r70, "promotionId");
        Intrinsics.checkNotNullParameter(r117, "awemeId");
        Intrinsics.checkNotNullParameter(r118, "secAuthorId");
        Intrinsics.checkNotNullParameter(r73, "metaParam");
        Intrinsics.checkNotNullParameter(r119, "productId");
        AnchorV3Api.a r75 = AnchorV3Api.a;
        if (r5 == false) goto L60;
        int r120 = 2;
    L61:
        Function2<Boolean, String, Unit> r76 = new ShoppingPurchaseButtonModel$appointPromotion$1(r68, r5);
        r75.getClass();
        AnchorV3Api.a.c(r70, r119, r117, "", r118, "", r120, r73, r76);
        goto L131
    L60:
        r120 = 1;
        goto L61
    L56:
        r119 = r74;
        goto L57
    L46:
        r118 = r72;
        goto L48
    L42:
        r117 = r71;
        goto L43
    L38:
        r70 = r69;
        goto L39
    L26:
        if (r27 == ButtonType.TimingSaleAppointed) goto L31;
        if (r27 == ButtonType.TimingSaleNotAppointed) goto L31;
        r29 = false;
        goto L32
    L5:
        if (com.bytedance.android.ec.model.b.a(this.b.getButtonType()) == false) goto L166;
        c r77 = this.a.e;
        ButtonTipsStruct r78 = this.b.getButtonTipsStruct();
        if (r78 == null) goto L9;
        String r79 = r78.getTips();
    L10:
        c.a.a(r77, r79, null, 2);
        return;
    L9:
        r79 = null;
        goto L10
    }
}
