package com.bytedance.android.livesdk.ktvimpl.realtimechorus;

import com.bytedance.android.annie.api.card.HybridCard;
import com.bytedance.android.live.core.log.ALogger;
import com.bytedance.android.livesdkapi.service.MessageHub;
import com.bytedance.ies.sdk.widgets.DataCenter;
import com.bytedance.ies.sdk.widgets.Widget;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class o0 implements Runnable {
    public final /* synthetic */ RealTimeChorusMainViewWidget.e a;

    public o0(RealTimeChorusMainViewWidget.e r1) {
        this.a = r1;
    }

    public final void a() {
        RealTimeChorusMainViewWidget r0 = this.a.a;
        int r1 = RealTimeChorusMainViewWidget.Q2;
        DataCenter r2 = ((Widget) r0).dataCenter;
        if (r2 == null) goto L57;
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r3 = r0.Q;
        if (r3 == null) goto L53;
        MessageHub r4 = r0.R;
        Intrinsics.checkNotNullParameter(r2, "dataCenter");
        ALogger.i("RealTimeChorusMicHybridCardManager", "registerMethods ;; dataCenter == " + r2.hashCode() + ", " + r3.b);
        r3.e();
        if (r4 == null) goto L9;
        r3.d(r4);
    L9:
        Map<String, Map<String, List<Object>>> r5 = r3.e;
        HybridCard r6 = r3.a;
        Integer r7 = null;
        if (r6 == null) goto L12;
        Integer r8 = Integer.valueOf(r6.hashCode());
    L13:
        Map r9 = (Map) ((LinkedHashMap) r5).get(String.valueOf(r8));
        if (r9 == null) goto L18;
        Set r10 = r9.keySet();
        if (r10 == null) goto L18;
        r10.clear();
    L18:
        Map<String, Map<String, List<Object>>> r11 = r3.e;
        HybridCard r12 = r3.b;
        if (r12 == null) goto L21;
        r7 = Integer.valueOf(r12.hashCode());
    L21:
        Map r13 = (Map) ((LinkedHashMap) r11).get(String.valueOf(r7));
        if (r13 == null) goto L26;
        Set r14 = r13.keySet();
        if (r14 == null) goto L26;
        r14.clear();
    L26:
        JSONObject r15 = new JSONObject();
        r15.put("eventName", "event_party_ktv_register_wrds");
        HybridCard r16 = r3.a;
        if (r16 == null) goto L29;
        r16.sendJsEvent("event_party_ktv_register_wrds", r15);
    L29:
        HybridCard r17 = r3.b;
        if (r17 == null) goto L32;
        r17.sendJsEvent("event_party_ktv_register_wrds", r15);
    L32:
        r3.c();
        HybridCard r18 = r3.a;
        if (r18 == null) goto L35;
        r18.registerMethod("registerWrds", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.g(r2));
    L35:
        HybridCard r19 = r3.a;
        if (r19 == null) goto L38;
        r19.registerMethod("updateLinkmicStatus", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.j(r3, false));
    L38:
        HybridCard r20 = r3.a;
        if (r20 == null) goto L41;
        r20.registerMethod("reportAggregateALog", com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.i.a);
    L41:
        HybridCard r21 = r3.a;
        if (r21 == null) goto L44;
        r21.registerMethod("registerMessageLatch", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.e(r2));
    L44:
        HybridCard r22 = r3.a;
        if (r22 == null) goto L47;
        r22.registerMethod("registerMessage", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.f(r2));
    L47:
        HybridCard r23 = r3.b;
        if (r23 == null) goto L50;
        r23.registerMethod("registerWrds", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.g(r2));
    L50:
        HybridCard r24 = r3.b;
        if (r24 == null) goto L53;
        r24.registerMethod("updateLinkmicStatus", new com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.j(r3, false));
        goto L53
    L12:
        r8 = null;
    L53:
        com.bytedance.android.livesdk.ktvimpl.realtimechorus.lynx.c r25 = r0.Q;
        if (r25 == null) goto L58;
        r25.l = ((Widget) r0).dataCenter;
        return;
    L58:
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
