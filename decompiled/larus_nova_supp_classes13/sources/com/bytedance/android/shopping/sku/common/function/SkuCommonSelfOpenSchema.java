package com.bytedance.android.shopping.sku.common.function;

import android.app.Activity;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.hybrid.utils.ECLiveHybridUtil;
import com.bytedance.android.ec.core.hybrid.utils.j;
import com.bytedance.android.ec.sdk.helper.p;
import com.bytedance.android.shopping.sku.common.monitor.error.SkuErrorMonitorType;
import com.bytedance.android.shopping.sku.common.utils.SkuBuyNowPanelHeightHelper;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonHandleSchemaUtils;
import com.bytedance.android.shopping.sku.common.utils.SkuCommonLog;
import com.bytedance.kmp.ec.yata.event.common.e;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Reflection;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class SkuCommonSelfOpenSchema {
    public final Activity a;
    public final e b;
    public final PageFinder c;
    public final mh3.a d;
    public final int e;
    public final boolean f;

    public final void a() {
        Object r1 = this.b.p(Reflection.getOrCreateKotlinClass(String.class), "open_type");
        if ((r1 instanceof String) == true) goto L5;
        r1 = null;
    L5:
        String r2 = (String) r1;
        Object r3 = this.b.p(Reflection.getOrCreateKotlinClass(String.class), "btm");
        if ((r3 instanceof String) == true) goto L8;
        r3 = null;
    L8:
        String r4 = (String) r3;
        if (r4 != null) goto L11;
    L14:
        boolean r5 = true;
    L15:
        if (r5 == true) goto L24;
        Map r6 = this.b.q();
        if (r6 == null) goto L19;
        Object r7 = r6.get("bcm");
    L21:
        if ((r7 instanceof Map) == true) goto L23;
        r7 = null;
    L23:
        Map r8 = (Map) r7;
    L25:
        Object r9 = this.b.p(Reflection.getOrCreateKotlinClass(String.class), "schema");
        if ((r9 instanceof String) == true) goto L28;
        r9 = null;
    L28:
        String r10 = (String) r9;
        if (r10 != null) goto L31;
        r10 = "";
    L31:
        String r11 = r10;
        Lazy r12 = SkuBuyNowPanelHeightHelper.a;
        int r13 = SkuCommonHandleSchemaUtils.a;
        final String r14 = SkuBuyNowPanelHeightHelper.d(SkuCommonHandleSchemaUtils.a(r11, r4, r8, this.d, "SkuCommonSelfOpenSchema", this.c), Integer.valueOf(this.e));
        Lazy r15 = SkuCommonLog.a;
        StringBuilder r16 = new StringBuilder("doAction ");
        r16.append("openType:" + r2 + ' ');
        r16.append("btm:" + r4 + ' ');
        r16.append("finalSchema:" + r14 + ' ');
        Unit r17 = Unit.INSTANCE;
        SkuCommonLog.c("SkuCommonSelfOpenSchema", r16.toString());
        if (StringsKt.isBlank(r11) == false) goto L39;
        mh3.a r18 = this.d;
        if (r18 == null) goto L39;
        com.bytedance.android.shopping.sku.common.monitor.error.a r19 = r18.c;
        if (r19 == null) goto L39;
        SkuErrorMonitorType r20 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r21 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r19.a(r20, "selfOpenSkuSchema  originSchema is null", null);
    L39:
        if (StringsKt.isBlank(r14) == false) goto L46;
        mh3.a r22 = this.d;
        if (r22 == null) goto L46;
        com.bytedance.android.shopping.sku.common.monitor.error.a r23 = r22.c;
        if (r23 == null) goto L46;
        SkuErrorMonitorType r24 = SkuErrorMonitorType.SERVER_BUSINESS_ERROR;
        Map<String, com.bytedance.android.shopping.sku.common.monitor.error.a> r25 = com.bytedance.android.shopping.sku.common.monitor.error.a.b;
        r23.a(r24, "selfOpenSkuSchema  finalSchema is null", null);
    L46:
        if (StringsKt.isBlank(r14) == false) goto L49;
        SkuCommonLog.b("SkuCommonSelfOpenSchema", "schema is null");
        return;
    L49:
        if (r2 == null) goto L67;
        int r26 = r2.hashCode();
        if (r26 == (-1346630481)) goto L65;
        if (r26 == 1134029771) goto L62;
        if (r26 != 1705749439) goto L67;
        if (r2.equals("router_service") == false) goto L67;
        p.a.d(r14, this.a);
        return;
    L62:
        if (r2.equals("router_service_with_mega") == false) goto L67;
        p.a.d(j.c(r14, false, 14), this.a);
        return;
    L65:
        if (r2.equals("live_hybrid") == false) goto L67;
        ECLiveHybridUtil.k(this.a, r14, false, false, this.f, null, 220);
        return;
    L67:
        SkuCommonHandleSchemaUtils.b(this.a, r14, this.f, new SkuCommonSelfOpenSchema$doAction$2(this, r14), 48);
        return;
    L19:
        r7 = null;
        goto L21
    L24:
        r8 = null;
        goto L25
    L11:
        if (StringsKt.isBlank(r4) == true) goto L14;
        r5 = false;
        goto L15
    }

    public SkuCommonSelfOpenSchema(Activity r2, com.bytedance.kmp.ec.yata.event.core.a r3, PageFinder r4, mh3.a r5, int r6, boolean r7) {
        Intrinsics.checkNotNullParameter(r2, "activity");
        Intrinsics.checkNotNullParameter(r3, "input");
        Intrinsics.checkNotNullParameter(r4, "btmPageFinder");
        this.a = r2;
        this.b = r3;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.f = r7;
    }
}
