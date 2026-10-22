package com.bytedance.android.shopping.orderlist.common.controller;

import com.bytedance.android.ec.core.utils.a2;
import com.bytedance.kmp.ec.yata.AndroidYaTaInstance;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.event.core.YataEventCenter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class q implements ti.j {
    public final /* synthetic */ p a;
    public final /* synthetic */ String b;

    public final void a(JSONObject r33) {
        Intrinsics.checkNotNullParameter(r33, "params");
        p r1 = this.a;
        String r3 = this.b;
        Map<String, Object> r2 = com.bytedance.android.shopping.orderlist.common.utils.l.a(r33);
        Map r4 = (Map) ((LinkedHashMap) r1.a).get(r3);
        char r5 = 0;
        if (r4 != null) goto L5;
    L8:
        boolean r7 = true;
    L10:
        if (r7 == false) goto L16;
        ig3.a r6 = r1.d;
        if (r6 == null) goto L116;
        com.bytedance.android.shopping.orderlist.common.monitor.error.c r8 = r6.f;
        if (r8 == null) goto L117;
        r8.b("trigger_save_event_error", MapsKt.mapOf(new Pair[]{TuplesKt.to("error_msg", "save_event_empty"), TuplesKt.to("listener_name", r3)}));
        return;
    L117:
        return;
    L116:
        return;
    L16:
        ArrayList r9 = new ArrayList();
        if (r4 == null) goto L99;
        Iterator r10 = r4.entrySet().iterator();
    L20:
        if (r10.hasNext() == false) goto L99;
        Map.Entry r13 = (Map.Entry) r10.next();
        o r14 = (o) r13.getValue();
        if (r14.a.length() != 0) goto L24;
        boolean r15 = true;
    L26:
        if (r15 == false) goto L32;
        ig3.a r16 = r1.d;
        if (r16 == null) goto L32;
        com.bytedance.android.shopping.orderlist.common.monitor.error.c r17 = r16.f;
        if (r17 == null) goto L32;
        Pair[] r11 = new Pair[3];
        r11[r5] = TuplesKt.to("error_msg", "save_node_empty");
        r11[1] = TuplesKt.to("listener_name", r3);
        r11[2] = TuplesKt.to("trigger_event_name", r14.b);
        r17.b("trigger_save_event_error", MapsKt.mapOf(r11));
    L32:
        LinkedHashMap r12 = new LinkedHashMap();
        r12.putAll(r2);
        r12.put("trigger_params", r14.e);
        if (a2.b(r14.d) == false) goto L66;
        AndroidYaTaInstance r18 = r1.c;
        if (r18 == null) goto L45;
        String r0 = r14.d;
        Iterator r28 = r10;
        if (r0 != null) goto L39;
        r0 = "";
    L39:
        String r19 = r14.a;
        ArrayList r29 = r9;
        Intrinsics.checkNotNullParameter(r0, "expr");
        Map.Entry r30 = r13;
        Intrinsics.checkNotNullParameter("selfSaveTrigger", "monitorTag");
        YataEventCenter r110 = r18.k();
        r110.getClass();
        Intrinsics.checkNotNullParameter(r0, "expr");
        Intrinsics.checkNotNullParameter("selfSaveTrigger", "monitorTag");
        YataStoreWrapper r20 = r110.a;
        LinkedHashMap r111 = new LinkedHashMap();
        r111.putAll(r12);
        Unit r112 = Unit.INSTANCE;
        String r31 = "selfSaveTrigger";
        LinkedHashMap r21 = new LinkedHashMap();
        r21.putAll(r12);
        y96.c r22 = r110.b.e().a(r0, new com.bytedance.kmp.ec.yata.event.core.d(r20, r19, r111, r21, MapsKt.emptyMap(), MapsKt.emptyMap(), new ArrayList(), new LinkedHashMap()).b());
        if (r22.a == false) goto L46;
        YataErrorManager r23 = r110.a.f();
        com.bytedance.kmp.ec.yata.common.error.d r24 = com.bytedance.kmp.ec.yata.common.error.c.g();
        r24.c("selfSaveTrigger:calcExpr_error");
        r24.j(r22);
        if (r19 != null) goto L44;
        r19 = "";
    L44:
        r24.k(r19);
        r24.d("业务调用calcExpr执行表达式计算异常，代码位置selfSaveTrigger");
        r23.c(r24);
    L46:
        if (r22 == null) goto L48;
        Object r25 = r22.c;
    L50:
        if ((r25 instanceof String) == true) goto L52;
        r25 = null;
    L52:
        boolean r26 = Intrinsics.areEqual((String) r25, "empty");
        if (r22 == null) goto L55;
        Throwable r27 = r22.e;
    L56:
        if (r27 == null) goto L67;
        ig3.a r32 = r1.d;
        if (r32 == null) goto L67;
        com.bytedance.android.shopping.orderlist.common.monitor.error.c r34 = r32.f;
        if (r34 == null) goto L67;
        Pair[] r35 = new Pair[6];
        r35[0] = TuplesKt.to("error_msg", "trigger_control_flow_failed");
        r35[1] = TuplesKt.to("listener_name", r3);
        r35[2] = TuplesKt.to("trigger_event_name", r14.b);
        r35[3] = TuplesKt.to("render_node_key", r14.a);
        r35[4] = TuplesKt.to("trigger_control_flow", r14.d);
        if (r22 == null) goto L64;
        Integer r36 = r22.f;
    L65:
        r35[5] = TuplesKt.to("error_code", r36);
        r34.b("trigger_save_event_error", MapsKt.mapOf(r35));
        goto L67
    L64:
        r36 = null;
    L67:
        if (r26 == false) goto L97;
        LinkedHashMap r37 = new LinkedHashMap();
        r37.putAll(r14.e);
        r37.putAll(r2);
        String r38 = r14.b;
        if (r38 != null) goto L71;
    L74:
        boolean r39 = true;
    L75:
        if (r39 == false) goto L82;
        ig3.a r40 = r1.d;
        if (r40 == null) goto L82;
        com.bytedance.android.shopping.orderlist.common.monitor.error.c r41 = r40.f;
        if (r41 == null) goto L82;
        r41.b("trigger_event_chain", MapsKt.mapOf(new Pair[]{TuplesKt.to("error_msg", "empty_event_name"), TuplesKt.to("render_node_key", r14.a)}));
    L82:
        AndroidYaTaInstance r42 = r1.c;
        if (r42 == null) goto L85;
        r42.u(com.bytedance.kmp.ec.yata.event.common.e.a.a(r42, null, r14.a, r14.b, r37, "selfSaveTrigger"));
    L85:
        ig3.a r43 = r1.d;
        if (r43 == null) goto L94;
        hg3.d r44 = r43.g;
        if (r44 == null) goto L94;
        String r45 = r14.b;
        if (r45 != null) goto L92;
        r45 = "";
    L92:
        String r46 = r14.a;
        int r47 = hg3.d.c;
        r44.b(r31, r45, r46, null);
    L94:
        if (Intrinsics.areEqual(r14.c, "once") == false) goto L96;
        ArrayList r48 = r29;
        r48.add(r30.getKey());
    L98:
        r9 = r48;
        r10 = r28;
        r5 = 0;
        goto L20
    L96:
        r48 = r29;
        goto L98
    L71:
        if (r38.length() == 0) goto L74;
        r39 = false;
        goto L75
    L97:
        r48 = r29;
        goto L98
    L55:
        r27 = null;
        goto L56
    L48:
        r25 = null;
        goto L50
    L45:
        r28 = r10;
        r31 = "selfSaveTrigger";
        r29 = r9;
        r30 = r13;
        r22 = null;
        goto L46
    L66:
        r28 = r10;
        r31 = "selfSaveTrigger";
        r29 = r9;
        r30 = r13;
        r26 = true;
        goto L67
    L24:
        r15 = false;
    L99:
        Iterator r49 = r9.iterator();
    L101:
        if (r49.hasNext() == false) goto L105;
        String r50 = (String) r49.next();
        Map r51 = (Map) ((LinkedHashMap) r1.a).get(r3);
        if (r51 == null) goto L101;
        o r52 = (o) r51.remove(r50);
        goto L101
    L105:
        r1.b(r3, null);
        return;
    L5:
        if (r4.isEmpty() == true) goto L8;
        r7 = false;
        goto L10
    }

    public q(p r1, String r2) {
        this.a = r1;
        this.b = r2;
    }
}
