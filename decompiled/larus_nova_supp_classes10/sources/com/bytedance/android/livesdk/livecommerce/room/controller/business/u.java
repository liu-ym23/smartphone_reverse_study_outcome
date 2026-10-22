package com.bytedance.android.livesdk.livecommerce.room.controller.business;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.model.promotion.ECUIPromotion;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.livesdk.livecommerce.room.LiveRoomProvider;
import com.bytedance.android.livesdk.livecommerce.room.controller.RealRoomController$roomResources$1;
import com.bytedance.android.livesdk.livecommerce.room.controller.c0;
import com.bytedance.android.livesdk.livecommerce.room.widgets.promotion_card.refactor.ExplainCardViewModel;
import com.bytedance.android.livesdk.livecommerce.utils.UtilityKotlinExtentionsKt;
import java.util.LinkedHashMap;
import java.util.List;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class u extends c0 {
    public boolean c;
    public boolean d;
    public boolean e;
    public ExplainCardViewModel f;
    public final List<String> g;
    public final t h;
    public final PreviewClickEntryController$fragmentLifeCallBack$1 i;
    public final Function0<Unit> j;
    public final s k;

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onPause() {
        this.d = false;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onResume() {
        this.d = true;
        if (this.c == false) goto L9;
        int r0 = ECSdk.a;
        cf.l r1 = (cf.l) ECSdk.a(cf.l.class);
        if (r1 == null) goto L7;
        r1.Qa(B());
    L7:
        this.c = false;
        return;
    }

    @Override // com.bytedance.android.livesdk.livecommerce.room.controller.c0, com.bytedance.android.livesdk.livecommerce.room.api.b
    public final void onExitRoom() {
        super.onExitRoom();
        this.f = null;
    }

    /* JADX WARN: Type inference failed for: r11v4, types: [com.bytedance.android.livesdk.livecommerce.room.controller.business.PreviewClickEntryController$fragmentLifeCallBack$1] */
    public u(RealRoomController$roomResources$1 r11) {
        Intrinsics.checkNotNullParameter(r11, "roomResources");
        super(r11);
        this.g = CollectionsKt.listOf(new String[]{"AnchorV4Fragment", "LivePromotionListFragment", "SkuFragment", "SkuPanelOptimizeFragment", "SkuYataFragment", "BuyNowFragment", "BuyNowHalfScreenDialogFragment", "LiveAnnieFragment", "MatchPurchaseFragment"});
        this.h = new t(this);
        this.i = new PreviewClickEntryController$fragmentLifeCallBack$1(this);
        this.j = new PreviewClickEntryController$cancelInteractionMask$1(this);
        this.k = new s(this);
    }

    public final void H(String r26, final View r27) {
        Intrinsics.checkNotNullParameter(r26, "clickFrom");
        Intrinsics.checkNotNullParameter(r27, "view");
        com.bytedance.android.livesdk.livecommerce.room.g r4 = LiveRoomProvider.g;
        if (Intrinsics.areEqual(r4.a, r26) == false) goto L44;
        int r5 = r26.hashCode();
        jf.d r8 = null;
        if (r5 == (-1648893033)) goto L28;
        if (r5 == 287895896) goto L10;
    L42:
        Intrinsics.checkNotNullParameter("UNKNOW", "<set-?>");
        r4.a = "UNKNOW";
        r4.b.clear();
        return;
    L10:
        if (r26.equals("explain_card") == false) goto L42;
        final s r1 = this.k;
        Bundle r6 = r4.b;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "businessArg");
        Intrinsics.checkNotNullParameter(r27, "view");
        int r3 = ECSdk.a;
        cf.l r7 = (cf.l) ECSdk.a(cf.l.class);
        if (r7 == null) goto L14;
        r7.showInteractionMask(r1.a.B());
    L14:
        Context r9 = r1.a.m();
        if ((r9 instanceof FragmentActivity) == true) goto L17;
        r9 = null;
    L17:
        FragmentActivity r10 = (FragmentActivity) r9;
        if (r10 == null) goto L22;
        FragmentManager r11 = r10.getSupportFragmentManager();
        if (r11 == null) goto L22;
        r11.registerFragmentLifecycleCallbacks(r1.a.i, true);
    L22:
        String r12 = r6.getString("bundle_key_click_area");
        final ECUIPromotion r13 = e.a.remove(Integer.valueOf(r6.getInt("bundle_key_explain_card_preview_ui_promotion")));
        u r14 = r1.a;
        ExplainCardViewModel r15 = r14.f;
        if (r13 == null) goto L42;
        if (r15 == null) goto L26;
        r8 = r15.getNewJumpDispatcher(r14.m(), null, true);
    L26:
        UtilityKotlinExtentionsKt.g(r15, r8, r12, new PreviewClickEntryController$previewClickJumpDispatcher$1$clickFromExplainCard$1(r1, r27, r13));
        xh.a r2 = xh.c.a("Live");
        String r16 = "explain_card_" + r12;
        LinkedHashMap r17 = new LinkedHashMap();
        r17.put("promotion_id", r13.getPromotionId());
        Unit r18 = Unit.INSTANCE;
        r2.d("explain_card", r16, r17);
        goto L42
    L28:
        if (r26.equals("shopping_cart") == false) goto L42;
        final s r19 = this.k;
        Bundle r20 = r4.b;
        r19.getClass();
        Intrinsics.checkNotNullParameter(r20, "businessArg");
        Intrinsics.checkNotNullParameter(r27, "view");
        int r21 = ECSdk.a;
        cf.l r22 = (cf.l) ECSdk.a(cf.l.class);
        if (r22 == null) goto L32;
        r22.showInteractionMask(r19.a.B());
    L32:
        String r23 = BtmSDK.createJumpSourceBtmToken$default(BtmSDK.INSTANCE, "c366460.d75972", PageFinder.via(r27), null, 4, null);
        jf.d r24 = r19.a.m();
        if ((r24 instanceof FragmentActivity) == false) goto L36;
        r8 = r24;
    L36:
        FragmentActivity r25 = (FragmentActivity) r8;
        if (r25 == null) goto L41;
        FragmentManager r28 = r25.getSupportFragmentManager();
        if (r28 == null) goto L41;
        r28.registerFragmentLifecycleCallbacks(r19.a.i, true);
    L41:
        PromotionListController.N(r19.a.A().r, r19.a.m(), "live_preview_shopping_cart", new si2.b("live_preview_shopping_cart", false, false), new PromotionListController.c(null, false, null, null, r23, null, null, null, 239), true, null, null, new PreviewClickEntryController$previewClickJumpDispatcher$1$clickFromShoppingCart$1(r19), 32);
        goto L42
    }
}
