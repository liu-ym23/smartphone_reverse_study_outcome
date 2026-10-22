package com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.nav.legacy;

import android.content.Context;
import android.view.View;
import com.bytedance.android.bcm.api.model.BcmParams;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.BtmItemBuilder;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.common.api.IECCommonService;
import com.bytedance.android.ec.common.api.debugtool.IVisitUnit;
import com.bytedance.android.ec.common.api.debugtool.VisitActions;
import com.bytedance.android.ec.common.api.usertracker.IECUserTrackerService;
import com.bytedance.android.ec.common.api.usertracker.PostActionType;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.anchorv4.bottom.AddCartMeta;
import com.bytedance.android.shopping.anchorv4.dto.meta.CommonMeta;
import com.bytedance.common.utility.UIUtils;
import com.google.gson.internal.LinkedTreeMap;
import java.util.LinkedHashMap;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class AddCartComponent {
    public final View a;
    public final d b;
    public final AddCartMeta c;

    public AddCartComponent(View r2, d r3, AddCartMeta r4) {
        Intrinsics.checkNotNullParameter(r2, "theView");
        Intrinsics.checkNotNullParameter(r3, "anchorV4VM");
        Intrinsics.checkNotNullParameter(r4, "addCartMeta");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void a(final AddCartMeta r40, Context r41, Function1<? super Integer, Unit> r42) {
        BtmSDK r2 = BtmSDK.INSTANCE;
        final String r3 = r2.createBtmId(new BtmItemBuilder("a1.b8094.c7963.d8736", Boolean.FALSE).withView(this.a).build());
        this.b.d(new AddCartComponent$doRealActionAndLog$1(this, r3, r40));
        if (r40.getSetCartGrey() == false) goto L6;
        UIUtils.displayToast(r41, 2131895713);
        Set r1 = ECProcessMonitor.a;
        com.bytedance.android.ec.core.monitor.listener.a.k(ECProcessMonitor.d("ec_product_detail"), -4, null, null, null, 14);
        return;
    L6:
        Integer r4 = r40.getAddCartWithoutCommonskus();
        if (r4 != null) goto L10;
    L14:
        String r19 = null;
    L15:
        int r5 = ECSdk.a;
        IECCommonService r6 = (IECCommonService) ECSdk.a(IECCommonService.class);
        if (r6 == null) goto L49;
        String r9 = r40.getOriginType();
        if (r9 != null) goto L20;
        r9 = "";
    L20:
        String r11 = r40.getOriginId();
        if (r11 != null) goto L23;
        r11 = "";
    L23:
        String r12 = r40.getPromotionId();
        if (r12 != null) goto L26;
        r12 = "";
    L26:
        String r13 = r40.getProductId();
        if (r13 != null) goto L29;
        r13 = "";
    L29:
        String r14 = r40.getAuthorId();
        if (r14 != null) goto L32;
        r14 = "";
    L32:
        String r15 = r40.getSecAuthorId();
        String r16 = r40.getLiveRoomId();
        if (r16 != null) goto L35;
        r16 = "";
    L35:
        String r17 = r40.getShopId();
        if (r17 != null) goto L38;
        r17 = "";
    L38:
        String r18 = r40.getTrackExtra();
        if (r18 != null) goto L41;
        r18 = "";
    L41:
        boolean r20 = r40.isGroupingBuy();
        String r21 = r40.getReceiveAddressId();
        String r22 = r40.getMarketChannel();
        String r24 = r2.getPageId(PageFinder.via(this.a));
        String r27 = r40.getBizCampaignType();
        String r28 = r40.getChannelId();
        Integer r29 = r40.getChannelType();
        com.bytedance.android.btm.api.model.d r10 = new com.bytedance.android.btm.api.model.d();
        r10.a = "a1.b8094.c7963.d8736";
        r10.b = PageFinder.via(this.a);
        r10.c = new BcmParams();
        Unit r7 = Unit.INSTANCE;
        LinkedHashMap r8 = new LinkedHashMap();
        LinkedTreeMap r23 = r40.getTrackMeta();
        if (r23 == null) goto L44;
        r8.putAll(r23);
    L44:
        cf.a r31 = r40.getAddCartListener();
        com.bytedance.android.ec.model.e r25 = new com.bytedance.android.ec.model.e();
        CommonMeta r26 = this.b.a();
        if (r26 == null) goto L47;
        String r30 = r26.getCpsTrack();
    L48:
        r25.a = r30;
        r25.b = this.b.getSessionId();
        IECCommonService.a.a(r6, r41, 101, -1, r9, r11, r12, r13, r14, r15, r16, r17, r18, r20, r21, r22, false, r19, r24, r10, false, null, r28, r29, null, r27, r25, r31, r8, null, null, r42, -2040168448, 1);
        goto L49
    L47:
        r30 = null;
    L49:
        IVisitUnit r32 = (IVisitUnit) ECSdk.a(IVisitUnit.class);
        if (r32 == null) goto L52;
        r32.hookToDirectCall(VisitActions.PDP_OUT_ADD_CART.getKey(), new AddCartComponent$doRealActionAndLog$5(r40));
    L52:
        IECUserTrackerService r33 = (IECUserTrackerService) ECSdk.a(IECUserTrackerService.class);
        if (r33 == null) goto L58;
        of.a r34 = r33.getMarketingService();
        if (r34 == null) goto L59;
        r34.a("product_detail_add_cart", PostActionType.DO, "product_detail");
        return;
    L59:
        return;
    L58:
        return;
    L10:
        if (r4.intValue() != 1) goto L14;
        if (r40.getSkuId() == null) goto L14;
        r19 = r40.getSkuId();
        goto L15
    }
}
