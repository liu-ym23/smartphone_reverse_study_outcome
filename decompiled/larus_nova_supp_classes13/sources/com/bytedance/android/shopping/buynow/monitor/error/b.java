package com.bytedance.android.shopping.buynow.monitor.error;

import com.bytedance.android.ec.sdk.helper.g;
import com.bytedance.android.shopping.buynow.tracker.BuyNowLog;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Lazy;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static void a(com.bytedance.android.shopping.buynow.tracker.a r5, String r6, String r7, Map r8) {
        Intrinsics.checkNotNullParameter(r6, "errorType");
        Intrinsics.checkNotNullParameter(r8, "extraParams");
        Lazy r0 = BuyNowLog.a;
        BuyNowLog.c("BuyNowErrorUtils", "logForError errorType = " + r6 + ", errorMsg is " + r7);
        JSONObject r1 = new JSONObject();
        if (r5 == null) goto L8;
        Iterator<Map.Entry<String, Object>> r2 = r5.d().entrySet().iterator();
    L6:
        if (r2.hasNext() == false) goto L8;
        Map.Entry<String, Object> r3 = r2.next();
        r1.put(r3.getKey(), r3.getValue());
    L8:
        Iterator r9 = r8.entrySet().iterator();
    L10:
        if (r9.hasNext() == false) goto L13;
        Map.Entry r4 = (Map.Entry) r9.next();
        r1.put((String) r4.getKey(), r4.getValue());
        goto L10
    L13:
        if (r5 == null) goto L21;
        LinkedHashMap r10 = new LinkedHashMap();
        r10.put("error_type", r6);
        r10.put("error_msg", r7);
        r10.put("extra", r1);
        Unit r11 = Unit.INSTANCE;
        r5.b("buynow_error_monitor", r10);
        return;
    L21:
        Result.Companion r12 = Result.Companion;     // Catch: Throwable -> L17
        g r13 = g.a;     // Catch: Throwable -> L17
        JSONObject r14 = new JSONObject();     // Catch: Throwable -> L17
        r14.put("error_type", r6);     // Catch: Throwable -> L17
        r14.put("error_msg", r7);     // Catch: Throwable -> L17
        r14.put("extra", r1);     // Catch: Throwable -> L17
        Unit r15 = Unit.INSTANCE;     // Catch: Throwable -> L17
        r13.logV3("buynow_error_monitor", r14);     // Catch: Throwable -> L17
        Object r16 = Result.constructor-impl(Unit.INSTANCE);     // Catch: Throwable -> L17
    L19:
        Result.box-impl(r16);
        return;
    L17:
        th = move-exception;
        Result.Companion r17 = Result.Companion;
        r16 = Result.constructor-impl(ResultKt.createFailure(th));
        goto L19
    }
}
