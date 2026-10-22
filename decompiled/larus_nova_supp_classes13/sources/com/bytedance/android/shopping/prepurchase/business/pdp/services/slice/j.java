package com.bytedance.android.shopping.prepurchase.business.pdp.services.slice;

import android.app.Activity;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.shopping.anchorv4.dto.meta.PageMeta;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.google.gson.internal.LinkedTreeMap;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import vg3.w;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j extends com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.h {
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> b;
    public final a c;

    public j(com.bytedance.android.shopping.prepurchase.arch.container.c r2, k.a r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "adapter");
        super(r2);
        this.b = r2;
        this.c = r3;
    }

    public final void f(Activity r2, hq.c r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "param");
        String r4 = r3.f();
        if (r4 != null) goto L5;
        return;
    L5:
        this.c.openSchema(r4);
    }

    public final void a(jq.a r5, Map<String, ? extends Object> r6, View r7) {
        Intrinsics.checkNotNullParameter(r5, "logData");
        Integer r1 = r5.d();
        if (r1 != null) goto L5;
    L7:
        boolean r2 = false;
    L8:
        LinkedTreeMap r3 = null;
        if (r2 == false) goto L11;
    L23:
        Intrinsics.checkNotNullParameter(r5, "logData");
        g(r5, r6, r7);
        Integer r0 = r5.j();
        if (r0 != null) goto L27;
    L29:
        if (r0 != null) goto L32;
    L34:
        if (r3 == null) goto L39;
        g(r3, r6, r7);
        return;
    L39:
        return;
    L32:
        if (r0.intValue() != 2) goto L34;
        r3 = com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.h.h(r5, "pdp_module_click");
        goto L34
    L27:
        if (r0.intValue() != 1) goto L29;
        r3 = com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.h.h(r5, "pdp_module_show");
        goto L34
    L11:
        if (com.bytedance.android.shopping.extensions.k.c(r5.b()) == false) goto L23;
        if (r6 != null) goto L14;
        r6 = new LinkedHashMap();
    L14:
        PageMeta r8 = (PageMeta) this.b.d().getData().b.a();
        if (r8 == null) goto L17;
        r3 = r8.getTrackMeta();
    L17:
        LinkedHashMap r9 = new LinkedHashMap();
        r9.putAll(r6);
        if (r3 == null) goto L20;
        r9.putAll(r3);
    L20:
        w r10 = this.c.a();
        if (r10 == null) goto L37;
        r10.n1(r5, r9, true);
        return;
    L37:
        return;
    L5:
        if (r1.intValue() <= 0) goto L7;
        r2 = true;
        goto L8
    }

    public final void d(IAction r10, com.bytedance.android.ecom.arch.slice.action.c r11, Map<String, String> r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "action");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L23
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L23
        if (r12 == null) goto L7;
        r1.putAll(r12);     // Catch: Throwable -> L23
    L7:
        if (r11 == null) goto L11;
        com.bytedance.android.ecom.arch.slice.g r14 = com.bytedance.android.ecom.arch.slice.action.b.e(r11);     // Catch: Throwable -> L23
        if (r14 == null) goto L11;
        String r15 = r14.getSliceId();     // Catch: Throwable -> L23
    L12:
        r1.put("slice_id", r15);     // Catch: Throwable -> L23
        r1.put("log_id", this.c.getLogId());     // Catch: Throwable -> L23
        r1.put("pdp_session_id", this.b.f().a.b);     // Catch: Throwable -> L23
        r1.put("product_type", this.c.b());     // Catch: Throwable -> L23
        if (r13 != 0) goto L16;
        Set r16 = ECProcessMonitor.a;     // Catch: Throwable -> L23
        String r17 = ECProcessMonitor.r("ec_product_detail", ".Action");     // Catch: Throwable -> L23
        this.b.w7().i(r17, r1.toString());     // Catch: Throwable -> L23
    L21:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L23
        return;
    L16:
        if (r13 != 1) goto L21;
        LinkedHashMap r18 = new LinkedHashMap();     // Catch: Throwable -> L23
        r18.put("fields", r10.getParams());     // Catch: Throwable -> L23
        PageFinder r19 = this.c.getPageFinder();     // Catch: Throwable -> L23
        if (r19 == null) goto L20;
        BtmSDK r110 = BtmSDK.INSTANCE;     // Catch: Throwable -> L23
        r18.put("bcm_chain", BtmSDK.getBcmChainByFinder$default(r110, r19, 0, false, 6, null));     // Catch: Throwable -> L23
        r18.putAll(r110.createReportParams("a1.b8094.c0.d0", r19));     // Catch: Throwable -> L23
    L20:
        Set r111 = ECProcessMonitor.a;     // Catch: Throwable -> L23
        ECProcessMonitor.l("ec_product_detail", "pdp_action", null, com.bytedance.android.ec.hybrid.list.util.k.b(r1), com.bytedance.android.ec.hybrid.list.util.k.b(r18), ".Action", this.b.f().a.b, 12);     // Catch: Throwable -> L23
    L11:
        r15 = null;
    L23:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
