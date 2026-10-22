package com.bytedance.android.shopping.buynow.controller;

import android.content.Context;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.shopping.yata.business.function.common.TTPay;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class BuyNowOrderLoadingController {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(Boolean r5, boolean r6, Map r7, ia3.b r8, Context r9) {
        Intrinsics.checkNotNullParameter(r9, "context");
        if ((!Intrinsics.areEqual(r5, Boolean.TRUE)) == false) goto L11;
        if (r6 == false) goto L7;
        if (r8 == null) goto L32;
        r8.b(new ia3.c(false, false));
        return;
    L32:
        return;
    L7:
        if (r8 == null) goto L34;
        r8.c();
        return;
    L34:
        return;
    L11:
        if (r6 == false) goto L30;
        int r10 = TTPay.a;     // Catch: Exception -> L18
        JSONObject r11 = new JSONObject();     // Catch: Exception -> L18
        r11.put("service", 61);     // Catch: Exception -> L18
        r11.put("sdk_info", new JSONObject().put("loading_status", 1));     // Catch: Exception -> L18
        JSONObject r12 = new JSONObject();     // Catch: Exception -> L18
        if (r7 == null) goto L15;
        JSONObject r13 = com.bytedance.android.ec.hybrid.list.util.k.b(r7);     // Catch: Exception -> L18
    L16:
        r11.put("ext", r12.put("sdk_show_info", r13).toString());     // Catch: Exception -> L18
        Unit r14 = Unit.INSTANCE;     // Catch: Exception -> L18
        TTPay.a(r9, r11, BuyNowOrderLoadingController$toggleLoading$2.INSTANCE);     // Catch: Exception -> L18
        return;
    L15:
        r13 = new JSONObject();     // Catch: Exception -> L18
    L18:
        e = move-exception;
        ECExceptionMonitor.e(e);
        return;
    L30:
        int r15 = TTPay.a;     // Catch: Exception -> L25
        JSONObject r16 = new JSONObject();     // Catch: Exception -> L25
        r16.put("service", 61);     // Catch: Exception -> L25
        r16.put("sdk_info", new JSONObject().put("loading_status", 0));     // Catch: Exception -> L25
        Unit r17 = Unit.INSTANCE;     // Catch: Exception -> L25
        TTPay.a(r9, r16, BuyNowOrderLoadingController$toggleLoading$4.INSTANCE);     // Catch: Exception -> L25
        if (r8 == null) goto L36;
        r8.c();     // Catch: Exception -> L25
        return;
    L36:
        return;
    L25:
        e = move-exception;
        ECExceptionMonitor.e(e);
    }
}
