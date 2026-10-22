package x35;

import android.text.TextUtils;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.s1;
import com.bytedance.ee.bear.document.statistics.SendEventData;
import com.bytedance.ee.bear.document.u1;
import com.bytedance.ee.bear.jsbridge.BridgeHandlerRunOnNotUIThread$CC;
import com.bytedance.ee.bear.jsbridge.auth.BridgeAuthType;
import com.bytedance.ee.util.ui.j;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.google.gson.JsonParser;
import java.lang.ref.WeakReference;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;
import tb5.m;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class f implements tb5.h<SendEventData> {
    public final u1 a;
    public final WeakReference<e> b;
    public final h c;
    public String d;

    public static final class a {
    }

    static {
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ BridgeAuthType authType() {
        return BridgeHandlerRunOnNotUIThread$CC.$default$authType(this);
    }

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
    public final void a(SendEventData r39) {
        StringBuilder r0 = new StringBuilder("send event = ");
        if (r39 == null) goto L5;
        Integer r4 = Integer.valueOf(r39.event_type);
    L6:
        r0.append(r4);
        r0.append(", data = ");
        r0.append(r39);
        tt5.a.h("SendEventHandler", r0.toString());
        if (TextUtils.isEmpty(this.d) == false) goto L12;
        if (r39 == null) goto L10;
        r39.isVersion = false;
    L10:
        if (r39 == null) goto L18;
        r39.editionId = "none";
    L18:
        if (r39 == null) goto L20;
        Integer r1 = Integer.valueOf(r39.event_type);
    L22:
        if (r1 != null) goto L25;
        String r2 = "is_version";
    L66:
        if (r1 != 0) goto L69;
    L157:
        e r3 = this.b.get();
        if (r3 == null) goto L171;
        if (r39 == null) goto L161;
        Integer r5 = Integer.valueOf(r39.event_type);
    L162:
        if (r39 == null) goto L164;
        Map<String, String> r6 = r39.data;
    L165:
        r3.a(r5, r6);
        return;
    L164:
        r6 = null;
        goto L165
    L161:
        r5 = null;
        goto L162
    L171:
        return;
    L69:
        if (r1.intValue() != 3) goto L157;
        h r7 = this.c;
        String r29 = r2;
        boolean r8 = this.a.c;
        r7.getClass();
        if (r39 == null) goto L75;
        Map<String, String> r9 = r39.data;
        if (r9 == null) goto L75;
        String r10 = r9.get("stage");
    L76:
        if (r39 == null) goto L80;
        String r31 = "stage";
        boolean r32 = r8;
        if (r39.isVersion != true) goto L81;
        int r11 = 1;
    L82:
        if (r39 == null) goto L85;
        String r12 = r39.editionId;
        if (r12 == null) goto L85;
    L86:
        if (r10 == null) goto L157;
        String r18 = r12;
        Long r13 = (Long) ((LinkedHashMap) r7.d).get(r10);
        int r33 = r11;
        if (r13 != null) goto L93;
        String r34 = "doc_has_info_cache";
        String r14 = r7.a.e("start_open", "start_time");
        if (r14 == null) goto L92;
        r13 = CastLongProtector.valueOf(r14);
    L94:
        if (r13 != null) goto L97;
        tt5.a.h(r7.c, "stage " + r10 + " hasn't started.");
        goto L157
    L97:
        if (r39.data == null) goto L99;
        Map<String, String> r16 = r39.data;
        Intrinsics.checkNotNull(r16, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        JSONObject r17 = new JSONObject(r16);
    L100:
        JSONObject r19 = r17;
        Map<String, String> r20 = r39.data;
        if (r20 == null) goto L103;
        String r21 = r20.get("timestamp");
    L104:
        if (r21 == null) goto L106;
        r19.put("cost_time", CastLongProtector.parseLong(r21) - r13.longValue());
    L107:
        r19.put("version_type", r7.b);
        r19.put("scm_version", ow4.a.a);
        r19.put("file_type", d25.d.g);
        r19.put("sub_type", d25.d.h);
        r19.put("doc_network_status", fw4.d.a().ordinal());
        r19.put("doc_has_cache", s1.r);
        r19.put("doc_from", s1.o);
        r19.put("enable_x5", r7.e);
        boolean r22 = true;
        r19.put("preload_html_enabled", 1);
        r19.put("is_first_open_docs", String.valueOf(s1.t.get()));
        r19.put(r34, s1.B);
        r19.put(r29, r33);
        r19.put("edition_id", r18);
        if (r32 == false) goto L110;
        Object r110 = "preload";
    L111:
        r19.put("docs_open_type", r110);
        r19.put("doc_sub_from", s1.p);
        if (TextUtils.isEmpty(JSONObjectProtectorUtils.getString(r19, "file_id")) == false) goto L117;
        String r23 = "";
        if (Intrinsics.areEqual(r7.g, r23) == false) goto L116;
        r7.g = du5.b.g(d25.d.d);
    L116:
        r19.put("file_id", r7.g);
    L118:
        String r24 = d25.d.d();
        if (r24 == null) goto L122;
        r23 = r24;
    L122:
        r19.put("doc_app_id", r23);
    L154:
        th = move-exception;
        tt5.a.f(r7.c, th, false);
    L156:
        com.bytedance.ee.bear.contract.d r26 = r7.a;
        int r27 = s1.c.a;
        r26.a("dev_performance_stage", r19);
        MonitorUtils.monitorEvent("docs_dev_performance_stage", r19, r19, new JSONObject());
        a05.d.b(r10);
        goto L157
    L124:
        if (Intrinsics.areEqual(r10, "render_cache") == true) goto L126;
    L152:
        tt5.a.h(r7.c, "***reportOpenDoc*** stage: " + r19.get(r31) + "  cost: " + r19.get("cost_time"));     // Catch: Throwable -> L154
        goto L156
    L126:
        if (r7.f == false) goto L128;
        j.c(new g(r7));     // Catch: Throwable -> L154
    L128:
        r7.a.j("render_cache", "start_time", r19.get("cost_time"));     // Catch: Throwable -> L154
        String r28 = r7.a.e("render_cache", "render_cache_from");     // Catch: Throwable -> L154
        if (r28 == null) goto L131;
        r19.put("doc_html_cache_from", r28);     // Catch: Throwable -> L154
    L131:
        String r30 = r7.a.e("render_cache", "render_cache_over_limit");     // Catch: Throwable -> L154
        if (r30 == null) goto L134;
        r19.put("prompt_get_html_over_limit", r30);     // Catch: Throwable -> L154
    L134:
        String r36 = r7.a.e("render_cache", "value_render_cache_ssrwebview_wait_preload_time");     // Catch: Throwable -> L154
        if (r36 != null) goto L137;
    L140:
        boolean r37 = true;
    L141:
        if (r37 == false) goto L143;
        r36 = DiagramData$RESULT.FAIL;
    L143:
        r19.put("wait_ssrwebview_preload_time", r36);     // Catch: Throwable -> L154
        String r38 = r7.a.e("render_cache", "value_render_cache_ssrwebview_is_ready");     // Catch: Throwable -> L154
        if (r38 != null) goto L146;
    L149:
        if (r22 == false) goto L151;
        r38 = "true";
    L151:
        r19.put("ssrwebview_is_ready", r38);     // Catch: Throwable -> L154
        goto L152
    L146:
        if (r38.length() == 0) goto L149;
        r22 = false;
        goto L149
    L137:
        if (r36.length() == 0) goto L140;
        r37 = false;
        goto L141
    L117:
        r23 = "";
        goto L118
    L110:
        r110 = "render";
        goto L111
    L106:
        r19.put("cost_time", System.currentTimeMillis() - r13.longValue());
        goto L107
    L103:
        r21 = null;
        goto L104
    L99:
        r17 = new JSONObject();
        goto L100
    L92:
        r13 = Long.valueOf(s1.v);
        goto L94
    L93:
        r34 = r5;
    L85:
        r12 = "none";
    L81:
        r11 = 0;
        goto L82
    L80:
        r32 = r8;
        r31 = "stage";
    L75:
        r10 = null;
        goto L76
    L25:
        if (r1.intValue() != 2) goto L65;
        h r40 = this.c;
        boolean r41 = this.a.c;
        r40.getClass();
        if (r39 == null) goto L31;
        Map<String, String> r42 = r39.data;
        if (r42 == null) goto L31;
        String r43 = r42.get("stage");
    L32:
        if (r39 == null) goto L36;
        boolean r310 = r41;
        String r311 = "doc_has_info_cache";
        if (r39.isVersion != true) goto L37;
        int r44 = 1;
    L38:
        if (r39 == null) goto L41;
        String r46 = r39.editionId;
        if (r46 == null) goto L41;
    L42:
        if (r43 == null) goto L157;
        String r111 = r46;
        if (r39 == null) goto L48;
        Map<String, String> r47 = r39.data;
        if (r47 == null) goto L48;
        String r48 = r47.get("timestamp");
    L49:
        if (r48 == null) goto L51;
        Long r49 = r40.d.put(r43, Long.valueOf(CastLongProtector.parseLong(r48)));
    L53:
        if (r39.data == null) goto L55;
        Map<String, String> r112 = r39.data;
        Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type kotlin.collections.Map<kotlin.String, kotlin.String>");
        JSONObject r50 = new JSONObject(r112);
    L56:
        r50.put("stage", r43.concat("_start"));
        r50.put("version_type", r40.b);
        r50.put("scm_version", ow4.a.a);
        r50.put("enable_x5", r40.e);
        r50.put("cost_time", System.currentTimeMillis() - s1.x);
        r50.put("preload_html_enabled", 1);
        r50.put("is_first_open_docs", String.valueOf(s1.t.get()));
        r50.put("file_type", d25.d.g);
        r50.put("sub_type", d25.d.h);
        r50.put(r311, s1.B);
        r50.put("is_version", r44);
        r50.put("edition_id", r111);
        if (r310 == false) goto L59;
        Object r113 = "preload";
    L60:
        r50.put("docs_open_type", r113);
        r50.put("doc_sub_from", s1.p);
        String r51 = d25.d.d();
        if (r51 != null) goto L63;
        String r52 = "";
    L64:
        r50.put("doc_app_id", r52);
        tt5.a.h(r40.c, "***reportOpenDoc*** stage: " + r50.get("stage") + "  cost: " + r50.get("cost_time"));
        com.bytedance.ee.bear.contract.d r53 = r40.a;
        int r54 = s1.c.a;
        r53.a("dev_performance_stage", r50);
        MonitorUtils.monitorEvent("docs_dev_performance_stage", r50, r50, new JSONObject());
        a05.d.b(r43);
        goto L157
    L63:
        r52 = r51;
        goto L64
    L59:
        r113 = "render";
        goto L60
    L55:
        r50 = new JSONObject();
        goto L56
    L51:
        Long r56 = r40.d.put(r43, Long.valueOf(System.currentTimeMillis()));
    L48:
        r48 = null;
    L41:
        r46 = "none";
    L37:
        r44 = 0;
        goto L38
    L36:
        r310 = r41;
        r311 = "doc_has_info_cache";
    L31:
        r43 = null;
        goto L32
    L65:
        r2 = "is_version";
        goto L66
    L20:
        r1 = null;
        goto L22
    L12:
        if (r39 == null) goto L14;
        r39.isVersion = true;
    L14:
        if (r39 == null) goto L18;
        r39.editionId = JsonParser.parseString(this.d).getAsJsonObject().get("version").toString();     // Catch: Exception -> L17
    L17:
        r39.editionId = "none";
        goto L18
    L5:
        r4 = null;
        goto L6
    }

    @Override // tb5.h, tb5.i, tb5.o
    public final /* bridge */ /* synthetic */ void handle(Object r1, m r2) {
        a((SendEventData) r1);
    }

    public f(u1 r2, com.bytedance.ee.bear.contract.d r3, String r4, e r5) {
        Intrinsics.checkNotNullParameter(r2, "docStateTracker");
        Intrinsics.checkNotNullParameter(r3, "analyticService");
        Intrinsics.checkNotNullParameter(r4, "versionType");
        Intrinsics.checkNotNullParameter(r5, "sendEventCallback");
        this.a = r2;
        this.b = new WeakReference(r5);
        this.c = new h(r3, r4);
    }
}
