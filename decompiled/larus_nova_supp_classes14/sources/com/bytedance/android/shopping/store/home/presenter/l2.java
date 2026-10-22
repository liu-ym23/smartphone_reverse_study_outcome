package com.bytedance.android.shopping.store.home.presenter;

import android.app.Activity;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.store.home.entity.CouponRedPackEntryInfo;
import com.bytedance.android.shopping.store.home.entity.ECShopBlockInfoDTO;
import com.bytedance.android.shopping.store.home.entity.ECShopToolsInfo;
import com.bytedance.android.shopping.store.home.entity.ToolEntryInfo;
import com.bytedance.android.shopping.store.home.entity.ToolType;
import com.bytedance.android.shopping.store.home.view.ECShopToolDialog;
import com.bytedance.android.shopping.store.settings.ECShopABSettings;
import com.bytedance.android.shopping.store.utils.CommonUtils;
import com.google.gson.JsonElement;
import com.obric.assistant.interaction.impl.window.helpers.DialogLancet;
import io.reactivex.functions.Consumer;
import java.util.ArrayList;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class l2<T> implements Consumer {
    public final /* synthetic */ ECShopTopBarBackPresenterV2 a;

    public l2(ECShopTopBarBackPresenterV2 r1) {
        this.a = r1;
    }

    public final void accept(Object r29) {
        ECShopTopBarBackPresenterV2 r2 = this.a;
        int r3 = com.bytedance.android.shopping.store.home.entity.f.c;
        r2.J = com.bytedance.android.shopping.store.home.entity.f.a.a((ECShopBlockInfoDTO) r29);
        ECShopTopBarBackPresenterV2 r1 = this.a;
        final boolean r4 = false;
        r1.L = false;
        com.bytedance.android.shopping.store.home.entity.f r5 = r1.J;
        if (r5 == null) goto L122;
        ECShopToolsInfo r6 = r5.b;
        if (r6 == null) goto L125;
        ECShopToolDialog.b r7 = new ECShopToolDialog.b();
        r7.a = r6.getLynxUrl();
        com.bytedance.android.shopping.store.home.entity.f r8 = this.a.J;
        final ECShopToolsInfo r9 = null;
        if (r8 == null) goto L16;
        ECShopToolsInfo r10 = r8.b;
        if (r10 == null) goto L16;
        CouponRedPackEntryInfo r11 = r10.getCouponRedPackEntry();
        if (r11 == null) goto L16;
        JsonElement r12 = r11.getCouponInfoList();
        if (r12 == null) goto L16;
        String r13 = r12.toString();
    L17:
        r7.b = r13;
        Activity r14 = CommonUtils.a();
        if (r14 != null) goto L20;
        r14 = this.a.X();
    L20:
        final ECShopTopBarBackPresenterV2 r15 = this.a;
        com.bytedance.android.shopping.store.home.entity.f r16 = r15.J;
        if (r16 == null) goto L23;
        r9 = r16.b;
    L23:
        ArrayList r17 = new ArrayList();
        com.bytedance.android.shopping.store.home.entity.f r18 = r15.J;
        if (r18 == null) goto L34;
        ECShopToolsInfo r19 = r18.b;
        if (r19 == null) goto L34;
        ToolEntryInfo r20 = r19.getCustomServiceEntry();
        if (r20 == null) goto L34;
        String r21 = r20.getSchema();
        if (r21 == null) goto L34;
        if (com.bytedance.android.shopping.extensions.k.c(r21) != true) goto L34;
        r15.T().doEventAction("show_consultation", new Pair[]{TuplesKt.to("click_area", "share_panel")});
        boolean r22 = true;
    L36:
        if (r22 == false) goto L47;
        Function0<Unit> r110 = new ECShopTopBarBackPresenterV2$buildEntryList$$inlined$apply$lambda$1(r15, r9, r4);
        if (r9 == null) goto L45;
        ToolEntryInfo r111 = r9.getCustomServiceEntry();
        if (r111 == null) goto L45;
        String r112 = r111.getEntryText();
        if (r112 == null) goto L45;
        String r23 = r112;
    L46:
        r17.add(new com.bytedance.android.ec.model.h(r110, 2131237483, "shop_custom_service", r23, ToolType.CUSTOM_SERVICE.getType()));
    L45:
        r23 = "";
    L47:
        Function0<Unit> r113 = new ECShopTopBarBackPresenterV2$buildEntryList$$inlined$apply$lambda$2(r15, r9, r4);
        if (r9 == null) goto L55;
        ToolEntryInfo r114 = r9.getShareEntry();
        if (r114 == null) goto L55;
        String r115 = r114.getEntryText();
        if (r115 == null) goto L55;
        String r26 = r115;
    L56:
        r17.add(new com.bytedance.android.ec.model.h(r113, 2131234714, "shop_share", r26, ToolType.SHARE.getType()));
        int r24 = com.bytedance.android.shopping.store.home.g0.a;
        com.bytedance.android.shopping.store.home.entity.f r25 = r15.J;
        if (r25 == null) goto L69;
        ECShopToolsInfo r27 = r25.b;
        if (r27 == null) goto L69;
        CouponRedPackEntryInfo r28 = r27.getCouponRedPackEntry();
        if (r28 == null) goto L69;
        String r30 = r28.getSchema();
        if (r30 == null) goto L69;
        if (com.bytedance.android.shopping.extensions.k.c(r30) != true) goto L69;
        if (ECShopABSettings.a() <= 0) goto L69;
        boolean r116 = true;
    L70:
        Function0<Unit> r117 = new ECShopTopBarBackPresenterV2$buildEntryList$$inlined$apply$lambda$3(r15, r9, r4);
        if (r9 == null) goto L78;
        CouponRedPackEntryInfo r31 = r9.getCouponRedPackEntry();
        if (r31 == null) goto L78;
        String r32 = r31.getEntryText();
        if (r32 == null) goto L78;
        String r118 = r32;
    L79:
        Function0<Unit> r119 = new ECShopTopBarBackPresenterV2$buildEntryList$$inlined$apply$lambda$4(r15, r9, r4);
        com.bytedance.android.shopping.store.home.entity.f r33 = r15.J;
        if (r33 == null) goto L90;
        ECShopToolsInfo r34 = r33.b;
        if (r34 == null) goto L90;
        ToolEntryInfo r35 = r34.getCartEntry();
        if (r35 == null) goto L90;
        String r36 = r35.getSchema();
        if (r36 == null) goto L90;
        if (com.bytedance.android.shopping.extensions.k.c(r36) != true) goto L90;
        r15.T().doEventAction("show_cart_entrance", new Pair[]{TuplesKt.to("click_area", "share_panel")});
        boolean r120 = true;
    L91:
        if (r9 == null) goto L98;
        ToolEntryInfo r37 = r9.getCartEntry();
        if (r37 == null) goto L98;
        String r38 = r37.getEntryText();
        if (r38 == null) goto L98;
        String r121 = r38;
    L99:
        Function0<Unit> r122 = new ECShopTopBarBackPresenterV2$buildEntryList$$inlined$apply$lambda$5(r15, r9, r4);
        if (ECAppInfoService.l() == true) goto L102;
        r15.T().doEventAction("show_order_entrance", new Pair[]{TuplesKt.to("click_area", "share_panel")});
        boolean r123 = true;
    L103:
        if (r9 == null) goto L110;
        ToolEntryInfo r39 = r9.getOrderEntry();
        if (r39 == null) goto L110;
        String r40 = r39.getEntryText();
        if (r40 == null) goto L110;
        String r210 = r40;
    L111:
        com.bytedance.android.shopping.store.home.g0.a(r17, r116, r117, r118, r119, r120, r121, r122, r123, r210, new ECShopTopBarBackPresenterV2$buildEntryList$$inlined$apply$lambda$6(r15, r9, r4));
        this.a.K = new ECShopToolDialog(r14, this.a.T(), r7, r17);
        ECShopToolDialog r41 = this.a.K;
        if (r41 != null) goto L114;
        return;
    L114:
        if (DialogLancet.shouldBlockDialogShow(r41) == false) goto L120;
        DialogLancet.handleBlockedDialogShow(r41);
        return;
    L120:
        DialogLancet.sLastShowStack = new Throwable();     // Catch: Exception -> L119
    L117:
        DialogLancet.beforeDialogShow(r41);
        r41.show();
        DialogLancet.afterDialogShow(r41);
        return;
    L110:
        r210 = "";
        goto L111
    L102:
        r123 = false;
    L98:
        r121 = r10;
    L90:
        r120 = false;
    L78:
        r118 = "";
    L69:
        r116 = false;
    L55:
        r26 = "";
    L34:
        r22 = false;
    L16:
        r13 = null;
        goto L17
    L125:
        return;
    }
}
