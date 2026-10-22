package com.bytedance.android.shopping.skubuy.start_flow;

import android.content.Context;
import com.bytedance.android.ec.core.utils.b2;
import com.bytedance.android.ec.core.utils.l0;
import com.bytedance.android.ec.core.utils.x0;
import com.bytedance.android.ec.model.abscontainer.ISkuBuySchemaModel;
import com.bytedance.android.ec.sdk.ECSdk;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.Starter;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.c;
import com.bytedance.android.shopping.abscontainer.arch.core.starter.d;
import com.bytedance.android.shopping.model.abscontainer.PerformancePointType;
import com.bytedance.android.shopping.sku.common.controller.SkuCommonBigPicCacheController;
import com.bytedance.android.shopping.skubuy.platform.container.PlatformSkuBuyContainer;
import com.bytedance.android.shopping.skubuy.platform.container.PlatformSkuBuySplitScreenContainer;
import com.bytedance.android.shopping.skubuy.starter.SkuBuyPageInfo;
import com.bytedance.android.shopping.track.TrackCatcher;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.UUID;
import kotlin.Lazy;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends u43.a<ISkuBuySchemaModel> {
    public static final /* synthetic */ int c = 0;

    /* JADX INFO: renamed from: com.bytedance.android.shopping.skubuy.start_flow.a$a, reason: collision with other inner class name */
    public static final class C0185a {
    }

    static {
    }

    public final ISkuBuySchemaModel g() {
        return c();
    }

    public a() {
    }

    public final void a(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        u43.a.e(this, PerformancePointType.PARSE_SCHEMA_END);
        Iterator r0 = ((LinkedHashMap) ((u43.a) this).a).entrySet().iterator();
    L4:
        if (r0.hasNext() == false) goto L6;
        Map.Entry r1 = (Map.Entry) r0.next();
        c().skuBuyTimestamp().put(r1.getKey(), r1.getValue());
        goto L4
    L6:
        c r2 = f(r5);
        Lazy r3 = TrackCatcher.a;
        if (TrackCatcher.a.a() == null) goto L9;
        TrackCatcher.a("step_order");
    L9:
        Starter r4 = new Starter(r2, r5);
        d r6 = r4.b.a;
        int r7 = j43.d.a;
        r6.a = Long.valueOf(System.currentTimeMillis());
        int r8 = j43.b.a;
        Context r9 = ECAppInfoService.e.getApplicationContext();
        if (r9 == null) goto L14;
        int r10 = ECSdk.a;
        cj.b r11 = (cj.b) ECSdk.a(cj.b.class);
        if (r11 == null) goto L14;
        r11.e(r9);
    L14:
        r4.a();
        r4.b();
        final String r12 = r2.a.getSessionID();
        b2.b(new SkuBuyStartupFlowController$reportSchema$1(this, r12));
    }

    public final c f(Context r11) {
        ISkuBuySchemaModel r3 = c();
        String r2 = UUID.randomUUID().toString();
        h43.a.a(r11);
        l0.c(r11);
        nj.d r12 = h43.a.b();
        if (r12 == null) goto L5;
        r12.g();
    L5:
        gl.a r13 = c().getEntranceInfo();
        JSONObject r8 = null;
        if (r13 == null) goto L8;
        String r6 = r13.getString("recommend_info");
    L9:
        SkuBuyPageInfo r7 = new SkuBuyPageInfo("yata_skubuy", r2, r3, false, false, r6);
        ISkuBuySchemaModel r14 = c();
        int r0 = com.bytedance.android.shopping.sku.inner.ultimate.b.a;
        r14.replaceOrAppendParam("panel_width", String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.b(r7.d)));
        c().replaceOrAppendParam("panel_height", String.valueOf(com.bytedance.android.shopping.sku.inner.ultimate.b.a()));
        String r15 = c().getQueryParam("id");
        if (r15 != null) goto L12;
        r15 = "";
    L12:
        int r1 = com.bytedance.android.shopping.skubuy.platform.helper.a.a;
        Intrinsics.checkNotNullParameter(r15, "cacheKey");
        com.bytedance.android.shopping.sku.common.controller.b r4 = SkuCommonBigPicCacheController.a(r15);
        if (r4 != null) goto L15;
        String r5 = null;
    L20:
        if (r5 == null) goto L22;
        c().replaceOrAppendParam("spec_mode", r5);
    L22:
        Intrinsics.checkNotNullParameter(r15, "cacheKey");
        com.bytedance.android.shopping.sku.common.controller.b r16 = SkuCommonBigPicCacheController.a(r15);
        if (r16 == null) goto L25;
        String r17 = String.valueOf(r16.b / ((long) 1000));
    L26:
        if (r17 == null) goto L28;
        c().replaceOrAppendParam("spec_mode_time", r17);
    L28:
        gl.a r18 = c().getEntranceInfo();
        if (r18 == null) goto L33;
        JSONObject r19 = r18.e();
        if (r19 == null) goto L33;
        r8 = x0.a(r19);
    L33:
        c43.a r110 = c43.a.a;
        g().getQueryParam("source_btm_token");
        Intrinsics.checkNotNullParameter("yata_skubuy", "bizCode");
        int r9 = o43.b.a;
        Intrinsics.checkNotNullParameter("yata_skubuy", "bizCode");
        if (r8 != null) goto L36;
        r8 = new JSONObject();
    L36:
        r8.remove("recommend_info");
        c().setFixEntranceInfoStr(r8.toString());
        yh3.b r10 = new yh3.b(r7);
        if (r7.d == false) goto L39;
        Class r20 = PlatformSkuBuySplitScreenContainer.class;
    L41:
        return new c(r7, r10, r20);
    L39:
        r20 = PlatformSkuBuyContainer.class;
        goto L41
    L25:
        r17 = null;
        goto L26
    L15:
        if (r4.a == false) goto L17;
        int r21 = 1;
    L18:
        r5 = String.valueOf(r21);
        goto L20
    L17:
        r21 = 2;
        goto L18
    L8:
        r6 = null;
        goto L9
    }
}
