package com.bytedance.android.shopping.buynow.starter;

import android.app.Activity;
import android.content.Context;
import android.net.Uri;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.api.IEShoppingService;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import com.bytedance.android.shopping.data.api.ChainPoint;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowRouter implements bf.c {
    public static final /* synthetic */ int a = 0;

    public static final class a {
    }

    static {
    }

    public BuyNowRouter() {
    }

    public final void a() {
    }

    public final String b() {
        return "buy_now";
    }

    public final boolean c(Context r14, final Uri r15, boolean r16) {
        Intrinsics.checkNotNullParameter(r14, "context");
        Intrinsics.checkNotNullParameter(r15, "uri");
        String r2 = UriProtector.getQueryParameter(r15, "ultimate_buy_ab");
        String r3 = "0";
        if (r2 != null) goto L5;
        r2 = "0";
    L5:
        int r5 = com.bytedance.android.shopping.extensions.k.r(r2, 0);
        String r4 = UriProtector.getQueryParameter(r15, "ultimate_buy_version");
        if (r4 == null) goto L9;
        r3 = r4;
    L9:
        int r6 = com.bytedance.android.shopping.extensions.k.r(r3, 0);
        ConcurrentHashMap r7 = a43.a.a;
        if (Intrinsics.areEqual(l43.a.a("ec_sku_buy_arch_opt_host"), 1) == false) goto L15;
        if (r5 <= 0) goto L15;
        if (r6 <= 0) goto L15;
        com.bytedance.android.ec.core.utils.n.b(r14, r16, null, new BuyNowRouter$open$1(this, r15), BuyNowRouter$open$2.INSTANCE);
        return true;
    L15:
        Lazy r8 = BuyNowLog.a;
        BuyNowLog.d("BuyNowRouter", "BuyNowRouter open uri: " + r15);
        int r9 = ECSdk.a;
        IEShoppingService r10 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r10 == null) goto L20;
        sc3.c r11 = r10.getBuyNowService();
        if (r11 == null) goto L20;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r12 = r11.o();
    L21:
        if (r12 == null) goto L23;
        r12.c(ChainPoint.PARSE_SCHEMA_START, null);
    L23:
        String r13 = UriProtector.getQueryParameter(r15, "source_btm_token");
        if (r12 == null) goto L26;
        r12.c(ChainPoint.PARSE_SCHEMA_END, null);
    L26:
        Boolean r17 = Boolean.FALSE;
        if (r5 <= 0) goto L31;
        if (r6 <= 0) goto L31;
        new com.bytedance.android.shopping.sku.inner.ultimate.e(r15, null, null, false).a(r16);
        return true;
    L31:
        if (r5 <= 0) goto L54;
        String r1 = UriProtector.getQueryParameter(r15, "is_single_sku");
        if (r1 != null) goto L35;
        r1 = "-1";
    L35:
        int r18 = com.bytedance.android.shopping.extensions.k.r(r1, -1);
        if (r18 <= 0) goto L52;
        BuyNowLog.d("BuyNowRouter", "try ultimate buy");
        Activity r19 = ECAppInfoService.e.getCurrentActivity();
        if ((r19 instanceof FragmentActivity) == true) goto L40;
        r19 = null;
    L40:
        FragmentActivity r20 = (FragmentActivity) r19;
        if (r20 == null) goto L54;
        FragmentManager r21 = r20.getSupportFragmentManager();
        if (r21 == null) goto L54;
        IEShoppingService r22 = (IEShoppingService) ECSdk.a(IEShoppingService.class);
        if (r22 == null) goto L47;
        sc3.i r23 = r22.getSkuYataService();
    L48:
        if (r23 == null) goto L50;
        r17 = Boolean.valueOf(r23.j(r21, r15, r5, r18, r13));
    L51:
        BuyNowLog.d("BuyNowRouter", "ultimate buy isUltimateBuyConsumed:" + r17);
        goto L54
    L50:
        r17 = null;
        goto L51
    L47:
        r23 = null;
        goto L48
    L52:
        BuyNowLog.d("BuyNowRouter", "isSingleSku is not Valid " + r18);
    L54:
        if ((!Intrinsics.areEqual(r17, Boolean.TRUE)) == false) goto L68;
        BuyNowLog.d("BuyNowRouter", "BuyNowStarter create open buy now " + r15);
        int r24 = BuyNowStarter.w;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a.e.getClass();
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r25 = com.bytedance.android.shopping.buynow.monitor.firstscreen.a.d;
        if (r25 == null) goto L62;
        com.bytedance.android.ec.model.d r26 = r25.c;
        if (r26 == null) goto L62;
        Long r27 = r26.b;
        if (r27 == null) goto L62;
        long r28 = r27.longValue();
    L64:
        if ((System.currentTimeMillis() - r28) < 100000) goto L66;
        com.bytedance.android.shopping.buynow.monitor.firstscreen.a r29 = null;
    L67:
        BuyNowStarter.a.b(r15, r29, null, null, null, null, r13, 188).t(r14);
        goto L68
    L66:
        r29 = r25;
    L62:
        r28 = 0;
    L68:
        return true;
    L20:
        r12 = null;
        goto L21
    }
}
