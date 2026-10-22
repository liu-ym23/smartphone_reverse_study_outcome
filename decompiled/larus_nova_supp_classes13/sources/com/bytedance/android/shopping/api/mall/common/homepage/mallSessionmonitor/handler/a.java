package com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler;

import cl.d;
import com.bytedance.android.ec.hybrid.monitor.HybridAppInfoService;
import com.bytedance.android.ec.local.api.ErrorType;
import com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.ECHandlerType;
import com.ss.android.common.lib.AppLogNewUtils;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Unit;
import kotlin.jvm.functions.Function6;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a implements c {
    public final Map<String, Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit>> a;
    public final Map<String, Set<String>> b;
    public final String c;
    public final String d;

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c
    public abstract String a(String r1, Map<String, ? extends Object> r2);

    public abstract Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit> c();

    public abstract ECHandlerType d();

    public abstract Map<String, Object> e();

    public a() {
        this.a = new ConcurrentHashMap();
        this.b = new ConcurrentHashMap();
        this.c = "ec_mall_session_stage_duplicate_report";
        this.d = "trigger_source";
    }

    @Override // com.bytedance.android.shopping.api.mall.common.homepage.mallSessionmonitor.handler.c
    public final void b(String r14, String r15, double r16, String r18, Map<String, ? extends Object> r19) {
        Intrinsics.checkNotNullParameter(r14, "stageName");
        Intrinsics.checkNotNullParameter(r15, "scheme");
        Intrinsics.checkNotNullParameter(r18, "triggerSource");
        boolean r8 = false;
        if (r14.length() != 0) goto L5;
        boolean r7 = true;
    L6:
        if (r7 == false) goto L8;
        return;
    L8:
        String r10 = a(r15, r19);
        if (r10 != null) goto L11;
        return;
    L11:
        if (r10.length() <= 0) goto L13;
        r8 = true;
    L13:
        Object r9 = null;
        if (r8 == true) goto L17;
        r10 = null;
    L17:
        if (r10 == null) goto L58;
        ConcurrentHashMap r11 = (ConcurrentHashMap) this.b;
        Object r12 = r11.get(r10);
        if (r12 != null) goto L22;
        r12 = new LinkedHashSet();
        r11.put(r10, r12);
    L22:
        Set r13 = (Set) r12;
        ECHandlerType r17 = d();
        if (r17 == null) goto L33;
        Intrinsics.checkNotNullParameter(r13, "stageList");
        Intrinsics.checkNotNullParameter(r15, "scheme");
        Intrinsics.checkNotNullParameter(r10, "sessionId");
        Intrinsics.checkNotNullParameter(r14, "stageName");
        Intrinsics.checkNotNullParameter(r18, "triggerSource");
        Intrinsics.checkNotNullParameter(r17, "handlerType");
        if (r13.contains(r14) == false) goto L32;
        String r2 = r17.getType();
        if (HybridAppInfoService.p.isLocalTest() == false) goto L31;
        d.a.getClass();
        d r5 = d.a.b();
        if (r5 == null) goto L31;
        r5.o("埋点重复上报", "当前" + r2 + " 链路存在埋点重复上报问题，重复上报的stageName为" + r14 + "，当前触发来源为 " + r18 + "，请检查是否存在多处重复调用逻辑，详情请联系 yangzilong.0217@bytedance.com", ErrorType.NOTIFY);
    L31:
        String r3 = r17.getType();
        String r6 = this.c;
        JSONObject r20 = new JSONObject();
        r20.putOpt("scheme", r15);
        r20.putOpt("session_id", r10);
        r20.putOpt("stage", r14);
        r20.putOpt(this.d, r18);
        r20.putOpt("handler_type", r3);
        Unit r4 = Unit.INSTANCE;
        AppLogNewUtils.onEventV3(r6, r20);
        goto L33
    L32:
        r13.add(r14);
    L33:
        Map<String, Object> r21 = e();
        if (r21 == null) goto L36;
        Object r22 = r21.get(r14);
    L38:
        if ((r22 instanceof String) == false) goto L41;
        r9 = r22;
    L41:
        String r23 = (String) r9;
        if (r23 != null) goto L44;
        String r24 = r14;
    L46:
        if (((ConcurrentHashMap) this.a).containsKey(r24) == false) goto L50;
        Function6 r1 = (Function6) ((ConcurrentHashMap) this.a).get(r24);
        if (r1 == null) goto L55;
        r1.invoke(r24, r15, r10, Double.valueOf(r16), r18, r19);
        return;
    L55:
        return;
    L50:
        Function6<String, String, String, Double, String, Map<String, ? extends Object>, Unit> r25 = c();
        if (r25 == null) goto L57;
        r25.invoke(r24, r15, r10, Double.valueOf(r16), r18, r19);
        return;
    L57:
        return;
    L44:
        r24 = r23;
        goto L46
    L36:
        r22 = null;
        goto L38
    L58:
        return;
    L5:
        r7 = false;
        goto L6
    }
}
