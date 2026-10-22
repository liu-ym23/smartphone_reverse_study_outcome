package com.bytedance.android.shopping.sameproduct.helper;

import android.view.View;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.ec.model.inflowfeed.Promotion;
import com.bytedance.android.ec.model.order.ECOrderTrackerData;
import com.bytedance.android.ec.model.order.ProductPurchaseInfo;
import com.bytedance.android.ec.model.response.anchorv3.PromotionProductStruct;
import com.bytedance.android.ec.model.sku.SkuRestoreState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.sameproduct.model.SameProductPageParams;
import com.bytedance.android.shopping.sameproduct.viewholder.BaseSimilarProductCardVH$buyButtonOnClickListener$1;
import com.bytedance.android.shopping.sameproduct.viewmodel.SameProductViewModel;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import p83.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(final FragmentActivity r29, final SameProductViewModel r30, View r31, rd3.a r32, BaseSimilarProductCardVH$buyButtonOnClickListener$1.a r33) {
        Intrinsics.checkNotNullParameter(r29, "activity");
        Intrinsics.checkNotNullParameter(r30, "viewModel");
        Intrinsics.checkNotNullParameter(r31, FreqActions.ACTION_VIEW);
        if (z53.b.a(r31.getId(), 800) == true) goto L45;
        if (r32 == null) goto L46;
        Promotion r3 = r32.f();
        if (r3 == null) goto L47;
        final PromotionProductStruct r6 = r3.getPromotionInfo();
        if (r6 == null) goto L50;
        int r4 = ECSdk.a;
        IEShoppingService r5 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r5 == null) goto L48;
        d r7 = r5.getAnchorV3Service();
        if (r7 == null) goto L49;
        SameProductPageParams r8 = r30.getPageParams();
        String r9 = null;
        if (r8 == null) goto L17;
        String r10 = r8.getEntranceInfo();
    L18:
        if (r8 == null) goto L21;
        String r11 = r8.getEnterFrom();
        if (r11 == null) goto L21;
    L22:
        String r12 = r11;
        if (r8 == null) goto L25;
        Integer r13 = r8.getFollowStatus();
    L26:
        if (r8 == null) goto L28;
        String r14 = r8.getAuthorId();
    L29:
        if (r8 == null) goto L31;
        String r15 = r8.getSecAuthorId();
    L32:
        if (r8 == null) goto L34;
        String r16 = r8.getVideoId();
    L35:
        if (r8 == null) goto L37;
        r9 = r8.getEcomEntranceForm();
    L37:
        String r17 = r9;
        if (r8 != null) goto L40;
    L42:
        boolean r22 = false;
    L43:
        ECOrderTrackerData r28 = new ECOrderTrackerData(r10, r12, r13, r14, r15, r16, r17, null, null, null, null, null, null, null, r22, null, null, null, 245632, null);
        Function0<Unit> r18 = new SameProductActionHelper$doBuyButtonClicked$1(r6, r29, r30);
        Function0<Unit> r19 = new SameProductActionHelper$doBuyButtonClicked$2(r6, r29, r30);
        SkuRestoreState r110 = r30.getSkuPanelState();
        Function1<SkuRestoreState, Unit> r111 = new SameProductActionHelper$doBuyButtonClicked$3(r30);
        int r20 = b.a;
        d.a.a(r7, r29, r28, new ProductPurchaseInfo(false, r6, "product_flow_page", null, r18, r19, r110, r111, b.a(r30.getPageParams(), r32, r30.getEcomSceneId()), 9, null), null, r33, 184);
        return;
    L40:
        if (r8.isFromFlowGuessULike() != true) goto L42;
        r22 = true;
        goto L43
    L34:
        r16 = null;
        goto L35
    L31:
        r15 = null;
        goto L32
    L28:
        r14 = null;
        goto L29
    L25:
        r13 = null;
    L21:
        r11 = "";
        goto L22
    L17:
        r10 = null;
        goto L18
    L49:
        return;
    L48:
        return;
    L50:
        return;
    L47:
        return;
    L46:
        return;
    }
}
