package com.bytedance.ee.bear.document.render.node.perf;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.render.node.g;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonParser;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.h;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class d implements h<SendEventData> {
    public final com.bytedance.ee.bear.document.render.node.f a;
    public final g b;
    public final c c;
    public final e d;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    @Override // tb5.h, tb5.i, tb5.o
    public final void handle(Object r40, m r41) {
        SendEventData r2 = (SendEventData) r40;
        StringBuilder r0 = new StringBuilder("send event = ");
        if (r2 == null) goto L5;
        Integer r4 = Integer.valueOf(r2.event_type);
    L6:
        r0.append(r4);
        r0.append(", data = ");
        r0.append(r2);
        tt5.a.h("SendEventHandler", r0.toString());
        if (TextUtils.isEmpty(null) == false) goto L12;
        if (r2 == null) goto L10;
        r2.isVersion = false;
    L10:
        if (r2 == null) goto L18;
        r2.editionId = "none";
    L18:
        if (r2 == null) goto L20;
        Integer r1 = Integer.valueOf(r2.event_type);
    L22:
        if (r1 != null) goto L25;
        String r3 = "doc_from";
    L74:
        if (r1 != 0) goto L77;
    L75:
        Map<String, String> r5 = null;
    L181:
        c r6 = this.c;
        if (r2 == null) goto L184;
        Integer r7 = Integer.valueOf(r2.event_type);
    L185:
        if (r2 == null) goto L187;
        r5 = r2.data;
    L187:
        r6.a(r7, r5);
        return;
    L184:
        r7 = r5;
        goto L185
    L77:
        if (r1.intValue() != 3) goto L179;
        e r8 = this.d;
        boolean r13 = this.b.f();
        r8.getClass();
        if (r2 == null) goto L83;
        Map<String, String> r9 = r2.data;
        if (r9 == null) goto L83;
        String r10 = r9.get("stage");
    L84:
        if (r2 == null) goto L88;
        String r31 = "stage";
        boolean r32 = r13;
        if (r2.isVersion != true) goto L89;
        int r11 = 1;
    L90:
        if (r2 == null) goto L93;
        String r14 = r2.editionId;
        if (r14 == null) goto L93;
    L94:
        if (r10 == null) goto L179;
        String r17 = r14;
        Long r16 = (Long) ((LinkedHashMap) r8.d).get(r10);
        int r33 = r11;
        if (r16 != null) goto L101;
        String r34 = "enable_x5";
        String r12 = r8.b.e("start_open", "start_time");
        if (r12 == null) goto L100;
        r16 = CastLongProtector.valueOf(r12);
    L102:
        if (r16 != null) goto L105;
        tt5.a.h(r21, "stage " + r10 + " hasn't started.");
        goto L179
    L105:
        if (r2.data == null) goto L107;
        Map<String, String> r18 = r2.data;
        Intrinsics.checkNotNull(r18, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        JSONObject r19 = new JSONObject(r18);
    L108:
        Map<String, String> r20 = r2.data;
        if (r20 == null) goto L111;
        String r21 = r20.get("timestamp");
    L112:
        if (r21 == null) goto L114;
        r19.put("cost_time", CastLongProtector.parseLong(r21) - r16.longValue());
    L115:
        r19.put("cost_time_start_click", r8.a(System.currentTimeMillis()));
        r19.put("version_type", r8.c);
        r19.put("scm_version", ow4.a.a);
        r19.put("file_type", d25.d.g);
        r19.put("sub_type", d25.d.h);
        r19.put("doc_network_status", fw4.d.a().ordinal());
        com.bytedance.ee.bear.document.render.node.f r22 = r8.a;
        if (r22 == null) goto L118;
        Integer r23 = Integer.valueOf(r22.h());
    L119:
        r19.put("doc_has_cache", r23);
        com.bytedance.ee.bear.document.render.node.f r24 = r8.a;
        if (r24 == null) goto L122;
        String r26 = r24.getFrom();
    L123:
        r19.put(r3, r26);
        r19.put(r34, r8.e);
        r19.put("preload_html_enabled", 1);
        r19.put("is_first_open_docs", String.valueOf(a05.c.r.get()));
        r19.put("doc_has_info_cache", a05.c.x);
        r19.put("is_version", r33);
        r19.put("edition_id", r17);
        if (r32 == false) goto L126;
        Object r27 = "preload";
    L127:
        r19.put("docs_open_type", r27);
        r5 = null;
        r19.put("doc_sub_from", null);
        if (TextUtils.isEmpty(JSONObjectProtectorUtils.getString(r19, "file_id")) == false) goto L133;
        String r28 = "";
        if (Intrinsics.areEqual(r8.g, r28) == false) goto L132;
        r8.g = du5.b.g(d25.d.d);
    L132:
        r19.put("file_id", r8.g);
    L134:
        String r29 = d25.d.d();
        if (r29 != null) goto L137;
        String r30 = r28;
    L138:
        r19.put("doc_app_id", r30);
    L175:
        th = th;
        String r36 = r21;
    L177:
        tt5.a.f(r36, th, false);
    L178:
        com.bytedance.ee.bear.contract.d r37 = r8.b;
        int r38 = a05.c.C0000c.a;
        r37.a("dev_performance_stage", r19);
        a05.d.b(r10);
        goto L181
    L140:
        if (Intrinsics.areEqual(r10, "render_cache") == true) goto L142;
    L169:
        r36 = "StageReport";
        tt5.a.h(r36, "***reportOpenDoc*** stage: " + r19.get(r31) + "  cost: " + r19.get("cost_time"));     // Catch: Throwable -> L173
    L173:
        th = th;
        goto L177
    L142:
        if (r8.f == false) goto L144;
        j.c(new f(r8));     // Catch: Throwable -> L175
    L144:
        r8.b.j("render_cache", "start_time", r19.get("cost_time"));     // Catch: Throwable -> L175
        r8.b.j("render_cache", "value_render_cache_cost_time_click", r19.get("cost_time_start_click"));     // Catch: Throwable -> L175
        String r39 = r8.b.e("render_cache", "render_cache_from");     // Catch: Throwable -> L175
        if (r39 == null) goto L147;
        r19.put("doc_html_cache_from", r39);     // Catch: Throwable -> L175
    L147:
        String r42 = r8.b.e("render_cache", "render_cache_over_limit");     // Catch: Throwable -> L175
        if (r42 == null) goto L150;
        r19.put("prompt_get_html_over_limit", r42);     // Catch: Throwable -> L175
    L150:
        String r43 = r8.b.e("render_cache", "value_render_cache_ssrwebview_wait_preload_time");     // Catch: Throwable -> L175
        if (r43 != null) goto L153;
    L156:
        boolean r44 = true;
    L157:
        if (r44 == false) goto L159;
        r43 = DiagramData$RESULT.FAIL;
    L159:
        r19.put("wait_ssrwebview_preload_time", r43);     // Catch: Throwable -> L175
        String r46 = r8.b.e("render_cache", "value_render_cache_ssrwebview_is_ready");     // Catch: Throwable -> L175
        if (r46 != null) goto L162;
    L165:
        boolean r47 = true;
    L166:
        if (r47 == false) goto L168;
        r46 = "true";
    L168:
        r19.put("ssrwebview_is_ready", r46);     // Catch: Throwable -> L175
        goto L169
    L162:
        if (r46.length() == 0) goto L165;
        r47 = false;
        goto L166
    L153:
        if (r43.length() == 0) goto L156;
        r44 = false;
        goto L157
    L137:
        r30 = r29;
        goto L138
    L133:
        r28 = "";
        goto L134
    L126:
        r27 = "render";
        goto L127
    L122:
        r26 = null;
        goto L123
    L118:
        r23 = null;
        goto L119
    L114:
        r19.put("cost_time", System.currentTimeMillis() - r16.longValue());
        goto L115
    L111:
        r21 = null;
        goto L112
    L107:
        r19 = new JSONObject();
        goto L108
    L100:
        r16 = Long.valueOf(a05.c.t);
        goto L102
    L101:
        r34 = "enable_x5";
    L93:
        r14 = "none";
    L89:
        r11 = 0;
        goto L90
    L88:
        r31 = "stage";
        r32 = r13;
    L83:
        r10 = null;
    L179:
        r5 = null;
        goto L181
    L25:
        if (r1.intValue() != 2) goto L73;
        e r48 = this.d;
        boolean r49 = this.b.f();
        r48.getClass();
        if (r2 == null) goto L31;
        Map<String, String> r50 = r2.data;
        if (r50 == null) goto L31;
        String r51 = r50.get("stage");
    L32:
        if (r2 == null) goto L36;
        boolean r310 = r49;
        String r311 = "sub_type";
        if (r2.isVersion != true) goto L37;
        int r52 = 1;
    L38:
        if (r2 == null) goto L41;
        String r110 = r2.editionId;
        if (r110 == null) goto L41;
    L42:
        if (r51 == null) goto L75;
        String r111 = r110;
        if (r2 == null) goto L48;
        Map<String, String> r112 = r2.data;
        if (r112 == null) goto L48;
        String r53 = r112.get("timestamp");
    L49:
        if (r53 == null) goto L51;
        Long r54 = r48.d.put(r51, Long.valueOf(CastLongProtector.parseLong(r53)));
    L53:
        if (r2.data == null) goto L55;
        Map<String, String> r113 = r2.data;
        Intrinsics.checkNotNull(r113, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        JSONObject r56 = new JSONObject(r113);
    L56:
        r56.put("stage", r51.concat("_start"));
        r56.put("version_type", r48.c);
        r56.put("scm_version", ow4.a.a);
        r56.put("enable_x5", r48.e);
        long r114 = System.currentTimeMillis();
        com.bytedance.ee.bear.document.render.node.f r57 = r48.a;
        if (r57 == null) goto L59;
        long r312 = r57.b();
    L60:
        r56.put("cost_time", r114 - r312);
        r56.put("cost_time_start_click", r48.a(System.currentTimeMillis()));
        r56.put("preload_html_enabled", 1);
        r56.put("is_first_open_docs", String.valueOf(a05.c.r.get()));
        r56.put("file_type", d25.d.g);
        r56.put(r311, d25.d.h);
        com.bytedance.ee.bear.document.render.node.f r58 = r48.a;
        if (r58 == null) goto L63;
        String r59 = r58.getFrom();
    L64:
        r56.put("doc_from", r59);
        r56.put("doc_has_info_cache", a05.c.x);
        r56.put("is_version", r52);
        r56.put("edition_id", r111);
        if (r310 == false) goto L67;
        Object r115 = "preload";
    L68:
        r56.put("docs_open_type", r115);
        r56.put("doc_sub_from", null);
        String r60 = d25.d.d();
        if (r60 != null) goto L71;
        String r61 = "";
    L72:
        r56.put("doc_app_id", r61);
        tt5.a.h("StageReport", "***reportOpenDoc*** stage: " + r56.get("stage") + "  cost: " + r56.get("cost_time"));
        com.bytedance.ee.bear.contract.d r62 = r48.b;
        int r63 = a05.c.C0000c.a;
        r62.a("dev_performance_stage", r56);
        a05.d.b(r51);
        goto L75
    L71:
        r61 = r60;
        goto L72
    L67:
        r115 = "render";
        goto L68
    L63:
        r59 = null;
        goto L64
    L59:
        r312 = 0;
        goto L60
    L55:
        r56 = new JSONObject();
        goto L56
    L51:
        Long r64 = r48.d.put(r51, Long.valueOf(System.currentTimeMillis()));
    L48:
        r53 = null;
    L41:
        r110 = "none";
    L37:
        r52 = 0;
        goto L38
    L36:
        r310 = r49;
        r311 = "sub_type";
    L31:
        r51 = null;
        goto L32
    L73:
        r3 = "doc_from";
        goto L74
    L20:
        r1 = null;
        goto L22
    L12:
        if (r2 == null) goto L14;
        r2.isVersion = true;
    L14:
        if (r2 == null) goto L18;
        r2.editionId = JsonParser.parseString(null).getAsJsonObject().get("version").toString();     // Catch: Exception -> L17
    L17:
        r2.editionId = "none";
        goto L18
    L5:
        r4 = null;
        goto L6
    }

    public d(com.bytedance.ee.bear.document.render.node.f r2, g r3, com.bytedance.ee.bear.contract.d r4, String r5, c r6) {
        Intrinsics.checkNotNullParameter(r3, "docStateTracker");
        Intrinsics.checkNotNullParameter(r4, "analyticService");
        Intrinsics.checkNotNullParameter(r5, "versionType");
        Intrinsics.checkNotNullParameter(r6, "sendEventCallback");
        this.a = r2;
        this.b = r3;
        this.c = r6;
        this.d = new e(r2, r4, r5);
    }
}
