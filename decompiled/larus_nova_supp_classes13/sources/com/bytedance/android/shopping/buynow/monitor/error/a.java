package com.bytedance.android.shopping.buynow.monitor.error;

import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.buynow.data.model.BuyNowCloseMethod;
import com.bytedance.android.shopping.extensions.k;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.bytedance.kmp.ec.yata.store.node.c;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a {
    public static /* synthetic */ void b(com.bytedance.android.shopping.buynow.tracker.a r1, String r2, String r3) {
        a(r1, r2, r3, MapsKt.emptyMap());
    }

    /* JADX WARN: Unreachable blocks removed: 3, instructions: 3 */
    public static final void d(com.bytedance.android.shopping.buynow.tracker.a r6, String r7, Throwable r8) {
        int r0 = b.a;
        Pair[] r1 = new Pair[3];
        String r2 = null;
        if (r8 == null) goto L5;
        String r3 = r8.getMessage();
    L6:
        r1[0] = TuplesKt.to("msg", r3);
        if (r8 == null) goto L11;
        Throwable r4 = r8.getCause();
        if (r4 == null) goto L11;
        r2 = r4.toString();
    L11:
        r1[1] = TuplesKt.to("name", r2);
        if (r8 != null) goto L14;
        r8 = new Throwable();
    L14:
        StringWriter r5 = new StringWriter();
        PrintWriter r9 = new PrintWriter(r5);
        com.bytedance.article.common.monitor.stack.b.b(r8, r9);     // Catch: Throwable -> L17
        String r10 = r5.toString();     // Catch: Throwable -> L17
    L18:
        r9.close();
        r1[2] = TuplesKt.to("stack", r10);
        Map r11 = MapsKt.mapOf(r1);
        if (r6 == null) goto L27;
        r6.b("buynow_error_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "runtime_error"), TuplesKt.to("desc", k.j(r7)), TuplesKt.to("detail", r11.toString())}));
        return;
    L27:
        return;
    L17:
        r10 = "";
        goto L18
    L5:
        r3 = null;
        goto L6
    }

    public static final void a(com.bytedance.android.shopping.buynow.tracker.a r1, String r2, String r3, Map r4) {
        Intrinsics.checkNotNullParameter(r2, "errorType");
        Intrinsics.checkNotNullParameter(r4, "params");
        b.a(r1, r2, r3, r4);
    }

    public static final void e(com.bytedance.android.shopping.buynow.tracker.a r6, String r7, String r8, e r9) {
        Intrinsics.checkNotNullParameter(r7, "desc");
        Intrinsics.checkNotNullParameter(r8, "msg");
        int r2 = b.a;
        Intrinsics.checkNotNullParameter(r7, "desc");
        Intrinsics.checkNotNullParameter(r8, "msg");
        Pair[] r3 = new Pair[3];
        r3[0] = TuplesKt.to("msg", r8);
        String r10 = null;
        if (r9 == null) goto L5;
        Map r4 = r9.q();
    L6:
        r3[1] = TuplesKt.to("fields", r4);
        if (r9 == null) goto L11;
        c r11 = r9.j();
        if (r11 == null) goto L11;
        r10 = r11.getKey();
    L11:
        r3[2] = TuplesKt.to("node_id", r10);
        Map r12 = MapsKt.mapOf(r3);
        if (r6 == null) goto L15;
        r6.b("buynow_error_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", "self_event_error"), TuplesKt.to("desc", r7), TuplesKt.to("detail", r12.toString())}));
        return;
    L15:
        return;
    L5:
        r4 = null;
        goto L6
    }

    public static final void f(com.bytedance.android.shopping.buynow.tracker.a r2, String r3, String r4, Function0 r5) {
        Intrinsics.checkNotNullParameter(r3, "errorType");
        Intrinsics.checkNotNullParameter(r5, "task");
        int r1 = b.a;
        BuyNowErrorMonitorKt$buyNowRunCatch$1 r6 = BuyNowErrorMonitorKt$buyNowRunCatch$1.INSTANCE;
        Intrinsics.checkNotNullParameter(r3, "errorType");
        Intrinsics.checkNotNullParameter(r5, "originTask");
        Intrinsics.checkNotNullParameter(r6, "errorCatchTask");
        r5.invoke();     // Catch: Throwable -> L5
        return;
    L5:
        th = move-exception;
        b.a(r2, r3, r4 + ": " + th.getMessage(), MapsKt.emptyMap());
        if (ECAppInfoService.e.i() == true) goto L10;
        ECExceptionMonitor.f(th, "Yata提单页组件化-".concat(r3));
        r6.invoke();
        return;
    L10:
        throw th;
    }

    public static final void c(com.bytedance.android.shopping.buynow.tracker.a r5, String r6, String r7, String r8, String r9) {
        Intrinsics.checkNotNullParameter(r6, "msg");
        int r1 = b.a;
        Intrinsics.checkNotNullParameter(r6, "msg");
        Pair[] r2 = new Pair[3];
        r2[0] = TuplesKt.to("msg", r6);
        Intrinsics.checkNotNullParameter("empty", "default");
        if (r7 != null) goto L5;
        r7 = "empty";
    L5:
        r2[1] = TuplesKt.to("status_code", r7);
        Intrinsics.checkNotNullParameter("empty", "default");
        if (r8 != null) goto L8;
        r8 = "empty";
    L8:
        r2[2] = TuplesKt.to("log_id", r8);
        Map r10 = MapsKt.mapOf(r2);
        if (r5 == null) goto L12;
        r5.b("buynow_error_monitor", MapsKt.mapOf(new Pair[]{TuplesKt.to("type", BuyNowCloseMethod.NETWORK_ERROR), TuplesKt.to("desc", k.j(r9)), TuplesKt.to("detail", r10.toString())}));
        return;
    }
}
