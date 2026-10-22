package di3;

import android.content.Context;
import com.bytedance.android.btm.api.BtmSDK;
import com.bytedance.android.btm.api.model.PageFinder;
import com.bytedance.android.ec.core.monitor.ECProcessMonitor;
import com.bytedance.android.ec.hybrid.list.util.k;
import com.bytedance.android.ecom.arch.slice.action.IAction;
import com.bytedance.android.ecom.arch.slice.action.p;
import com.bytedance.android.ecom.arch.slice.g;
import com.bytedance.android.shopping.anchorv4.vm.AnchorV4VM;
import com.bytedance.android.shopping.utils.i0;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d extends b implements p {
    public final AnchorV4VM c;

    public d(Context r2, AnchorV4VM r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "anchorV4Vm");
        super(r2, r3);
        this.c = r3;
    }

    public final void d(IAction r10, com.bytedance.android.ecom.arch.slice.action.c r11, Map<String, String> r12, int r13) {
        Intrinsics.checkNotNullParameter(r10, "action");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L22
        LinkedHashMap r1 = new LinkedHashMap();     // Catch: Throwable -> L22
        if (r12 == null) goto L7;
        r1.putAll(r12);     // Catch: Throwable -> L22
    L7:
        if (r11 == null) goto L11;
        g r14 = com.bytedance.android.ecom.arch.slice.action.b.e(r11);     // Catch: Throwable -> L22
        if (r14 == null) goto L11;
        String r15 = r14.getSliceId();     // Catch: Throwable -> L22
    L12:
        r1.put("slice_id", r15);     // Catch: Throwable -> L22
        r1.put("log_id", this.c.shareParams().b);     // Catch: Throwable -> L22
        r1.put("pdp_session_id", this.c.getSessionId());     // Catch: Throwable -> L22
        int r16 = i0.a;     // Catch: Throwable -> L22
        r1.put("product_type", i0.a(this.c));     // Catch: Throwable -> L22
        if (r13 != 0) goto L18;
        Set r17 = ECProcessMonitor.a;     // Catch: Throwable -> L22
        if (ECProcessMonitor.b(r10.getType()) == false) goto L20;
        dm.a.b r18 = dm.a.a;     // Catch: Throwable -> L22
        dm.a.a(ECProcessMonitor.r("ec_product_detail", ".Action")).i(r1.toString());     // Catch: Throwable -> L22
    L20:
        Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L22
        return;
    L18:
        if (r13 != 1) goto L20;
        LinkedHashMap r19 = new LinkedHashMap();     // Catch: Throwable -> L22
        r19.put("fields", r10.getParams());     // Catch: Throwable -> L22
        BtmSDK r110 = BtmSDK.INSTANCE;     // Catch: Throwable -> L22
        r19.put("bcm_chain", BtmSDK.getBcmChainByFinder$default(r110, PageFinder.via(this.c.getPageId()), 0, false, 6, null));     // Catch: Throwable -> L22
        r19.putAll(r110.createReportParams("a1.b8094.c0.d0", PageFinder.via(this.c.getPageId())));     // Catch: Throwable -> L22
        Set r111 = ECProcessMonitor.a;     // Catch: Throwable -> L22
        ECProcessMonitor.l("ec_product_detail", "pdp_action", null, k.b(r1), k.b(r19), ".Action", this.c.getSessionId(), 12);     // Catch: Throwable -> L22
    L11:
        r15 = null;
    L22:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
    }
}
