package com.bytedance.android.shopping.sku.inner.ultimate;

import android.app.Activity;
import android.net.Uri;
import android.text.TextUtils;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.ec.model.sku.SkuProductDetailInfo;
import com.bytedance.android.ec.model.sku.SkuShowAndDismissState;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyParams;
import com.bytedance.android.shopping.api.ultimate.UltimateBuyStyleParams;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.android.shopping.sku.common.ability.SkuAbilityType;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class e {
    public final Uri a;
    public final ea3.b b;
    public final String c;
    public final boolean d;

    public final void a(final boolean r23) {
        Lazy r2 = SkuCommonLog.a;
        SkuCommonLog.c("UltimateBuySchemaHandler", "UltimateBuyRouterHandler open uri: " + this.a);
        final String r10 = UriProtector.getQueryParameter(this.a, "source_btm_token");
        ECAppInfoService r3 = ECAppInfoService.e;
        Activity r4 = r3.getCurrentActivity();
        Uri r6 = null;
        if ((r4 instanceof FragmentActivity) == true) goto L5;
        r4 = null;
    L5:
        FragmentActivity r5 = (FragmentActivity) r4;
        if (r5 == null) goto L72;
        FragmentManager r7 = r5.getSupportFragmentManager();
        if (r7 == null) goto L72;
        Uri r8 = this.a;
        Function1<SkuProductDetailInfo, Unit> r14 = new UltimateBuySchemaRouterHandler$startFromSchema$$inlined$also$lambda$1(this, r10, r23);
        Function1<SkuShowAndDismissState, Unit> r13 = new UltimateBuySchemaRouterHandler$startFromSchema$$inlined$also$lambda$2(this, r10, r23);
        String r0 = this.c;
        boolean r9 = this.d;
        Intrinsics.checkNotNullParameter(r7, "fragmentManager");
        Intrinsics.checkNotNullParameter(r8, "uri");
        String r11 = UriProtector.getQueryParameter(r8, "ultimate_buy_ab");
        if (r11 != null) goto L12;
        r11 = "2";
    L12:
        int r18 = k.r(r11, 2);
        String r12 = UriProtector.getQueryParameter(r8, "ultimate_buy_version");
        if (r12 != null) goto L15;
        r12 = "0";
    L15:
        int r15 = k.r(r12, 0);
        String r16 = UriProtector.getQueryParameter(r8, "is_single_sku");
        if (r16 != null) goto L18;
        r16 = "-1";
    L18:
        int r17 = k.r(r16, -1);
        h r19 = new h(r8, null, false, 6);
        SkuParams r20 = r19.b;
        r20.setDiffTag(r0);
        if (r3.i() == false) goto L24;
        cl.d r1 = com.bytedance.android.ec.sdk.helper.k.a();
        if (r1 == null) goto L24;
        r1.b();
    L24:
        if (r17 != 1) goto L26;
        boolean r21 = true;
    L27:
        Map<String, mh3.a> r110 = mh3.a.m;
        SkuAbilityType r111 = SkuAbilityType.BUYNOW;
        mh3.a.C0219a.a(r111, r20, r21);
        new com.bytedance.android.shopping.sku.common.controller.d(r111, r20, true).a();
        Lazy r22 = SkuBuyNowPanelHeightHelper.a;
        int r24 = SkuBuyNowPanelHeightHelper.a(String.valueOf(r20.getSceneType()), r20.getHeightPercent());
        Uri r25 = r19.c;
        if (r25 == null) goto L41;
        Uri.Builder r112 = r25.buildUpon();
        r19.a(r112, "spec_mode", String.valueOf(r19.b.getSpecMode()));
        r19.a(r112, "spec_mode_time", String.valueOf(r19.b.getSpecModeTime()));
        r19.a(r112, "panel_width", String.valueOf(b.b(false)));
        r19.a(r112, "panel_height", String.valueOf(b.a()));
        String r26 = String.valueOf(r24);
        Uri r27 = r19.c;
        if (r27 == null) goto L40;
        if (r26 == null) goto L40;
    L38:
        e = move-exception;
        ECExceptionMonitor.f(e, "error uri: " + r19.c);
        goto L40
    L35:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r27, "height_percent")) == false) goto L40;
        r112.appendQueryParameter("height_percent", r26);     // Catch: Exception -> L38
    L40:
        r6 = r112.build();
    L41:
        UltimateBuyParams r28 = new UltimateBuyParams(null, null, r18, r17, r20, Integer.valueOf(r15));
        if (a.a(r20) == false) goto L52;
        int r29 = ECSdk.a;
        IEShoppingService r30 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r30 == null) goto L48;
        sc3.c r31 = r30.getBuyNowService();
        if (r31 == null) goto L48;
        String r32 = r31.h(r6, r28, new UltimateBuyStyleParams(r24, Float.valueOf(r20.getMaskAlpha())), r10);
    L49:
        if (r32 != null) goto L51;
        r32 = "";
    L51:
        a.b(r20, r32);
    L71:
        SkuCommonLog.c("UltimateBuySchemaHandler", "ultimate buy open success");
        return;
    L48:
        r32 = null;
        goto L49
    L52:
        if (r9 == false) goto L59;
        int r33 = ECSdk.a;
        IEShoppingService r34 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r34 == null) goto L58;
        sc3.c r35 = r34.getBuyNowService();
        if (r35 == null) goto L58;
        r35.a(r6, r28, new UltimateBuyStyleParams(r24, Float.valueOf(r20.getMaskAlpha())), r10);
    L58:
        SkuCommonLog.c("UltimateBuyPanelStarter", "isPrefetch");
        goto L71
    L59:
        int r36 = ECSdk.a;
        IEShoppingService r37 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r37 == null) goto L66;
        sc3.c r38 = r37.getBuyNowService();
        if (r38 == null) goto L66;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r39 = r38.o();
        if (r39 == null) goto L66;
        r39.c(ChainPoint.PARSE_SCHEMA_END, null);
    L66:
        IEShoppingService r40 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r40 == null) goto L71;
        sc3.c r41 = r40.getBuyNowService();
        if (r41 == null) goto L71;
        sc3.c.a.a(r41, r6, r7, r28, new UltimateBuyStyleParams(r24, Float.valueOf(r20.getMaskAlpha())), r10, null, null, r13, r14, 512);
        goto L71
    L26:
        r21 = false;
    L72:
        SkuCommonLog.c("UltimateBuySchemaHandler", "ultimate buy open fail: fragmentManager is null");
    }

    public e(Uri r2, ea3.b r3, String r4, boolean r5) {
        Intrinsics.checkNotNullParameter(r2, "uri");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
    }
}
