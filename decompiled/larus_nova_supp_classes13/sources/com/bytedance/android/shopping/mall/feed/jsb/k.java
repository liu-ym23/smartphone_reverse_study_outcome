package com.bytedance.android.shopping.mall.feed.jsb;

import com.bytedance.android.shopping.api.mall.IECNativeHomeService;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.ECStageTriggerSource;
import com.bytedance.sdk.xbridge.cn.registry.core.IBDXBridgeContext;
import com.bytedance.sdk.xbridge.cn.registry.core.IDLXBridgeMethod;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k extends qf3.e {
    public final String getName() {
        return "mall.deliveryRecord";
    }

    public k(qf3.d r2) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        super(r2);
    }

    public static Map h(Map r4) {
        LinkedHashMap r0 = new LinkedHashMap();
        r0.put("code", 1);
        r0.put("msg", "success");
        if (r4 != null) goto L13;
    L12:
        return r0;
    L13:
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L10
        JSONObject r2 = new JSONObject();     // Catch: Throwable -> L10
        Iterator r5 = r4.entrySet().iterator();     // Catch: Throwable -> L10
    L6:
        if (r5.hasNext() == false) goto L8;
        Map.Entry r3 = (Map.Entry) r5.next();     // Catch: Throwable -> L10
        r2.putOpt((String) r3.getKey(), r3.getValue());     // Catch: Throwable -> L10
        goto L6
    L8:
        LinkedHashMap r6 = new LinkedHashMap();     // Catch: Throwable -> L10
        r6.put("deliveryInfo", r2);     // Catch: Throwable -> L10
        Unit r7 = Unit.INSTANCE;     // Catch: Throwable -> L10
        Result.constructor-impl(r0.put("data", r6));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        Result.Companion r8 = Result.Companion;
        Result.constructor-impl(ResultKt.createFailure(th));
        goto L12
    }

    public final Map<String, Object> g(String r5) {
        return MapsKt.mapOf(new Pair[]{TuplesKt.to("code", 0), TuplesKt.to("msg", r5)});
    }

    @Override // qf3.e
    public final void realHandle(IBDXBridgeContext r11, Map<String, ? extends Object> r12, IDLXBridgeMethod.a r13) {
        Intrinsics.checkNotNullParameter(r11, "bridgeContext");
        Intrinsics.checkNotNullParameter(r12, "params");
        Intrinsics.checkNotNullParameter(r13, "callback");
        IECNativeHomeService r14 = (IECNativeHomeService) ServiceManager.get().getService(IECNativeHomeService.class);
        Map<String, Object> r0 = null;
        if (r14 == null) goto L5;
        y93.b r15 = r14.a();
    L6:
        Object r1 = r12.get("actionType");
        if ((r1 instanceof String) == true) goto L9;
        r1 = null;
    L9:
        String r2 = (String) r1;
        Object r3 = r12.get("sessionID");
        if ((r3 instanceof String) == true) goto L12;
        r3 = null;
    L12:
        String r4 = (String) r3;
        if (r2 == null) goto L91;
        if (r4 == null) goto L91;
        Object r5 = r12.get("deliveryRecord");
        if ((r5 instanceof Map) == true) goto L19;
        r5 = null;
    L19:
        Map<String, ? extends Object> r6 = (Map) r5;
        switch(r2.hashCode()) {
            case -1246914851: goto L56;
            case -235365105: goto L44;
            case 96417: goto L36;
            case 102230: goto L31;
            case 1919834714: goto L23;
            default: goto L89;
        };
    L89:
        r13.invoke(g("actionType is not support"));
        return;
    L23:
        if (r2.equals("publishTTI") == false) goto L89;
        if (r6 == null) goto L27;
        if (r15 == null) goto L27;
        r15.e(r4, r6);
    L27:
        if (r15 == null) goto L29;
        r0 = r15.h(r4);
    L29:
        r13.invoke(h(r0));
        return;
    L31:
        if (r2.equals("get") == false) goto L89;
        if (r15 == null) goto L34;
        r0 = r15.h(r4);
    L34:
        r13.invoke(h(r0));
        return;
    L36:
        if (r2.equals("add") == false) goto L89;
        if (r6 == null) goto L40;
        if (r15 == null) goto L40;
        r15.a(r4, r6);
    L40:
        if (r15 == null) goto L42;
        r0 = r15.h(r4);
    L42:
        r13.invoke(h(r0));
        return;
    L44:
        if (r2.equals("publish") == false) goto L89;
        Object r16 = r12.get("isSuccess");
        if ((r16 instanceof Boolean) == true) goto L48;
        r16 = null;
    L48:
        Boolean r17 = (Boolean) r16;
        if (r6 == null) goto L52;
        if (r15 == null) goto L52;
        r15.g(r4, Intrinsics.areEqual(r17, Boolean.TRUE), r6);
    L52:
        if (r15 == null) goto L54;
        r0 = r15.h(r4);
    L54:
        r13.invoke(h(r0));
        return;
    L56:
        if (r2.equals("addStage") == false) goto L89;
        Object r7 = r12.get("deliveryStage");
        if ((r7 instanceof String) == true) goto L60;
        r7 = null;
    L60:
        String r8 = (String) r7;
        if (r8 != null) goto L63;
        r8 = "";
    L63:
        String r9 = r8;
        if (r9.length() != 0) goto L66;
        boolean r10 = true;
    L67:
        if (r10 == false) goto L70;
        r13.invoke(g("deliveryStage is empty"));
        return;
    L70:
        Object r18 = r12.get("timestamp");
        if ((r18 instanceof Long) == true) goto L73;
        r18 = null;
    L73:
        Long r19 = (Long) r18;
        if (r19 == null) goto L76;
        long r20 = r19.longValue();
    L77:
        LinkedHashMap r21 = new LinkedHashMap();
        if (r6 == null) goto L85;
        Iterator<Map.Entry<String, ? extends Object>> r110 = r6.entrySet().iterator();
    L81:
        if (r110.hasNext() == false) goto L85;
        Map.Entry<String, ? extends Object> r22 = r110.next();
        Object r23 = r22.getValue();
        if (r23 == null) goto L81;
        r21.put(r22.getKey(), r23);
    L85:
        r21.put("delivery_session_id", r4);
        CopyOnWriteArrayList<WeakReference<com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c>> r111 = com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.a.a;
        com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.a.a(r9, "", r20, ECStageTriggerSource.MALL_DELIVERYRECORD_BRIDGE.getType(), r21);
        if (r15 == null) goto L88;
        r0 = r15.h(r4);
    L88:
        r13.invoke(h(r0));
        return;
    L76:
        r20 = System.currentTimeMillis();
        goto L77
    L66:
        r10 = false;
    L91:
        r13.invoke(g("actionType or sessionId is null"));
        return;
    L5:
        r15 = null;
        goto L6
    }

    @Override // qf3.e
    public final Pair<Boolean, String> e(qf3.d r2, IBDXBridgeContext r3, Map<String, ? extends Object> r4, Map<String, Object> r5) {
        Intrinsics.checkNotNullParameter(r2, "mallJsbContext");
        Intrinsics.checkNotNullParameter(r3, "bridgeContext");
        Intrinsics.checkNotNullParameter(r4, "params");
        Intrinsics.checkNotNullParameter(r5, "result");
        return TuplesKt.to(Boolean.TRUE, null);
    }
}
