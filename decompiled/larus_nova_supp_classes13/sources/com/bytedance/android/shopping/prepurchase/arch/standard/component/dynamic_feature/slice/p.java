package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice;

import android.app.Activity;
import android.content.Context;
import android.view.View;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ecom.arch.slice.action.t;
import com.bytedance.android.ecom.arch.slice.action.v;
import com.bytedance.android.shopping.prepurchase.business.pdp.repository.PdpDataStore;
import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p implements v, t {
    public final com.bytedance.android.ecom.arch.slice.action.p a;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<com.bytedance.android.shopping.prepurchase.business.pdp.e, PdpDataStore> b;
    public final com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.k.a c;

    public final void a(jq.a r2, Map<String, ? extends Object> r3, View r4) {
        Intrinsics.checkNotNullParameter(r2, "logData");
        this.a.a(r2, r3, r4);
    }

    public final void e(Context r2, iq.b r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "toastParam");
        this.a.e(r2, r3);
    }

    public final void f(Activity r2, hq.c r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "param");
        this.a.f(r2, r3);
    }

    public p(com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.j r2, com.bytedance.android.shopping.prepurchase.arch.container.c r3, com.bytedance.android.shopping.prepurchase.business.pdp.services.slice.k.a r4) {
        Intrinsics.checkNotNullParameter(r2, "commonActionProvider");
        Intrinsics.checkNotNullParameter(r3, "context");
        Intrinsics.checkNotNullParameter(r4, "pdpAdapter");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }

    public final void c(EventContext r10, Map<String, String> r11, int r12) {
        Intrinsics.checkNotNullParameter(r10, "eventContext");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L28
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L28
        r1.putAll(r11);     // Catch: Throwable -> L28
        r10.d();     // Catch: Throwable -> L28
        com.bytedance.android.ecom.arch.slice.g r13 = yp.a.a(r10);     // Catch: Throwable -> L28
        if (r13 == null) goto L6;
        String r14 = r13.getSliceId();     // Catch: Throwable -> L28
    L8:
        String r2 = "";
        if (r14 != null) goto L11;
        r14 = "";
    L11:
        r1.put("slice_id", r14);     // Catch: Throwable -> L28
        r1.put("log_id", this.c.getLogId());     // Catch: Throwable -> L28
        r1.put("pdp_session_id", this.b.f().a.b);     // Catch: Throwable -> L28
        r1.put("product_type", this.c.b());     // Catch: Throwable -> L28
        if (r12 != 0) goto L21;
        String r15 = r10.h;     // Catch: Throwable -> L28
        if (r15 == null) goto L17;
        r2 = r15;
    L17:
        Set r16 = ECProcessMonitor.a;     // Catch: Throwable -> L28
        if (ECProcessMonitor.b(r2) == false) goto L26;
        dm.a.b r17 = dm.a.a;     // Catch: Throwable -> L28
        dm.a.a(ECProcessMonitor.r("ec_product_detail", ".Action")).i(r1.toString());     // Catch: Throwable -> L28
    L26:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L28
        return;
    L21:
        if (r12 != 1) goto L26;
        LinkedHashMap r18 = new LinkedHashMap();     // Catch: Throwable -> L28
        r18.put("fields", r10.k);     // Catch: Throwable -> L28
        PageFinder r19 = this.c.getPageFinder();     // Catch: Throwable -> L28
        if (r19 == null) goto L25;
        BtmSDK r7 = BtmSDK.INSTANCE;     // Catch: Throwable -> L28
        r18.put("bcm_chain", BtmSDK.getBcmChainByFinder$default(r7, r19, 0, false, 6, null));     // Catch: Throwable -> L28
        r18.putAll(r7.createReportParams("a1.b8094.c0.d0", r19));     // Catch: Throwable -> L28
    L25:
        Set r110 = ECProcessMonitor.a;     // Catch: Throwable -> L28
        ECProcessMonitor.l("ec_product_detail", "pdp_action", null, com.bytedance.android.ec.hybrid.list.util.k.b(r1), com.bytedance.android.ec.hybrid.list.util.k.b(r18), ".Action", this.b.f().a.b, 12);     // Catch: Throwable -> L28
        goto L26
    L6:
        r14 = null;
    L28:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
