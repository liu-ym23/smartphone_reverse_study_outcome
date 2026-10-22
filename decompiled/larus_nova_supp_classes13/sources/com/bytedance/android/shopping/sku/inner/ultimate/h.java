package com.bytedance.android.shopping.sku.inner.ultimate;

import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.j1;
import com.bytedance.android.ec.core.utils.u0;
import com.bytedance.android.ec.core.utils.z1;
import com.bytedance.android.ec.model.PromotionBenefitLabel;
import com.bytedance.android.ec.model.order.IOrderSchema;
import com.bytedance.android.ec.model.sku.SkuParams;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.mt.protector.impl.UriProtector;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h {
    public final Map<String, Object> a;
    public final SkuParams b;
    public final Uri c;
    public final IOrderSchema d;
    public final boolean e;

    public final String b(String r3) {
        IOrderSchema r0 = this.d;
        if (r0 == null) goto L6;
        return r0.getQueryParam(r3);
    L6:
        return com.bytedance.android.ecom.arch.slice.render.util.b.v(this.a, r3, null);
    }

    @Deprecated(message = "不建议使用，当uri中已有key值时会使前置加工失效")
    public final void a(Uri.Builder r5, String r6, String r7) {
        Uri r0 = this.c;
        if (r0 == null) goto L32;
        if (r7 == null) goto L33;
    L21:
        e = move-exception;
        ECExceptionMonitor.f(e, "error uri: " + this.c);
        return;
    L7:
        if (TextUtils.isEmpty(UriProtector.getQueryParameter(r0, r6)) == false) goto L9;
        r5.appendQueryParameter(r6, r7);     // Catch: Exception -> L21
        return;
    L9:
        r5.clearQuery();     // Catch: Exception -> L21
        Iterator r1 = UriProtector.getQueryParameterNames(this.c).iterator();     // Catch: Exception -> L21
    L11:
        if (r1.hasNext() == false) goto L31;
        String r2 = (String) r1.next();     // Catch: Exception -> L21
        if ((!Intrinsics.areEqual(r2, r6)) == true) goto L14;
        r5.appendQueryParameter(r2, r7);     // Catch: Exception -> L21
        goto L11
    L14:
        Iterator r3 = UriProtector.getQueryParameters(this.c, r2).iterator();     // Catch: Exception -> L21
    L16:
        if (r3.hasNext() == false) goto L11;
        r5.appendQueryParameter(r2, (String) r3.next());     // Catch: Exception -> L21
        goto L16
    L31:
        return;
    L33:
        return;
    }

    public h(Uri r115, IOrderSchema r116, boolean r117, int r118) {
        String r2 = null;
        if ((r118 & 1) == 0) goto L5;
        Uri r1 = null;
    L7:
        if ((r118 & 2) == 0) goto L9;
        IOrderSchema r3 = null;
    L11:
        if ((r118 & 4) == 0) goto L13;
        boolean r4 = false;
    L14:
        this.c = r1;
        this.d = r3;
        this.e = r4;
        if (r1 == null) goto L17;
        HashMap r5 = j1.a(r1);
    L18:
        this.a = r5;
        String r6 = b("coupon_tags");     // Catch: Exception -> L24
        if (r6 != null) goto L22;
        r6 = "";
    L22:
        List r7 = u0.e(r6, PromotionBenefitLabel[].class);     // Catch: Exception -> L24
    L25:
        List r39 = r7;
        String r21 = b("id");
        String r8 = b("sku_promotion_id");
        if (r8 != null) goto L28;
        String r22 = "";
    L29:
        int r34 = k.r(b("scene_type"), 0);
        String r52 = b("sku_session_id");
        String r38 = b("detail_url");
        String r44 = b("sku_enter_from");
        float r65 = k.p(b("mask_alpha"), 0.5f);
        Integer r62 = Integer.valueOf(k.r(b("height_percent"), 0));
        IOrderSchema r9 = this.d;
        if (r9 == null) goto L32;
        r2 = r9.H();
    L32:
        this.b = new SkuParams(null, null, null, null, null, 0, null, null, null, false, false, null, null, false, r21, r22, null, false, null, null, null, null, null, null, null, false, 1, r34, null, null, 0, r38, r39, null, null, null, null, r44, null, null, null, null, null, null, null, r52, false, null, null, null, null, this.e, false, false, null, r62, null, null, r65, null, null, null, null, null, null, null, z1.g(r2), null, null, null, null, 0, "UltimateBuySkuParamForSingle.generateSkuParams", null, null, null, null, null, false, null, null, null, null, null, null, null, 0, 0, false, null, null, null, true, null, null, null, null, null, null, null, null, 1946107903, -76029986, -268435717, 31, null);
        return;
    L28:
        r22 = r8;
    L24:
        r7 = CollectionsKt.emptyList();
        goto L25
    L17:
        r5 = null;
        goto L18
    L13:
        r4 = r117;
        goto L14
    L9:
        r3 = r116;
        goto L11
    L5:
        r1 = r115;
        goto L7
    }
}
