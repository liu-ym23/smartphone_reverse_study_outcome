package com.bytedance.ee.bear.document;

import android.text.TextUtils;
import com.bytedance.framwork.core.monitor.MonitorUtils;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.concurrent.atomic.AtomicBoolean;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class t1 implements Runnable {
    public final /* synthetic */ s1 a;
    public final /* synthetic */ long b;
    public final /* synthetic */ long c;

    public t1(s1 r1, long r2, long r4) {
        this.a = r1;
        this.b = r2;
        this.c = r4;
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
    public final void a() {
        String r14 = "open_doc_desc";
        String r16 = "doc_sub_from";
        String r17 = "docs_dev_performance_stage";
        String r18 = "dev_performance_stage";
        String r8 = "scm_version";
        String r19 = "start_open";
        String r20 = "doc_app_id";
        String r21 = "edition_id";
        String r22 = "is_version";
        String r23 = "doc_has_info_cache";
        String r24 = "is_first_open_docs";
        String r26 = "isCoverEnabled";
        String r27 = "file_id";
        String r28 = "";
        String r10 = "cost_time";
        s1 r0 = this.a;
        r0.getClass();
        String r32 = d25.d.j;     // Catch: Throwable -> L83
        if (TextUtils.isEmpty(r32) == true) goto L6;
        String r34 = r32;
        int r36 = 1;
    L7:
        JSONObject r1 = new JSONObject();     // Catch: Throwable -> L83
        r1.put("stage", "load_url_start");     // Catch: Throwable -> L80
        r1.put("docs_result_key", "other");     // Catch: Throwable -> L80
        r1.put("docs_result_code", 0);     // Catch: Throwable -> L80
        r1.put("version_type", r0.e);     // Catch: Throwable -> L80
        r1.put("file_type", d25.d.g);     // Catch: Throwable -> L80
        r1.put("sub_type", d25.d.h);     // Catch: Throwable -> L80
        r1.put("enable_x5", r0.f);     // Catch: Throwable -> L80
        r1.put("scm_version", ow4.a.a);     // Catch: Throwable -> L80
        r1.put("doc_has_cache", s1.r);     // Catch: Throwable -> L80
        r1.put("doc_from", s1.o);     // Catch: Throwable -> L80
        r1.put("doc_sub_from", s1.p);     // Catch: Throwable -> L80
        r1.put("open_doc_desc", s1.q);     // Catch: Throwable -> L80
        r14 = "open_doc_desc";
        r28 = r28;
    L78:
        th = th;
        r8 = "scm_version";
        r17 = r17;
        r10 = "cost_time";
    L15:
        String r29 = "doc_from";
    L16:
        String r110 = "enable_x5";
        String r9 = "DocReport";
        String r111 = "doc_has_cache";
        String r3 = "start_time";
    L85:
        tt5.a.f(r9, th, false);
    L86:
        String r2 = this.a.b.e(r19, r3);
        long r37 = 0;
        if (TextUtils.isEmpty(r2) == true) goto L106;
        long r4 = this.b;
        Intrinsics.checkNotNull(r2);
        long r5 = r4 - CastLongProtector.parseLong(r2);
        long r39 = vv4.g.a - CastLongProtector.parseLong(r2);
        if (r39 > 0) goto L91;
        r39 = 0;
    L91:
        long r41 = vv4.g.c;
        if (r41 > 0) goto L94;
        long r42 = 0;
        long r43 = 0;
        long r46 = 0;
    L95:
        vv4.g.c = 0;
        long r6 = this.c;
        long r49 = r6 - s1.w;
        long r11 = this.b - r6;
        if (Intrinsics.areEqual(d25.d.g, sbb.e.n.getType()) == false) goto L104;
        long r7 = s1.z - CastLongProtector.parseLong(r2);
        if (r7 > 0) goto L100;
        r7 = 0;
    L100:
        long r51 = s1.A - s1.z;
        long r53 = vv4.g.a - s1.A;
        if (r53 <= 0) goto L104;
        r37 = r7;
    L105:
        long r57 = r37;
        long r12 = r42;
        long r112 = r46;
        long r13 = r5;
        long r59 = r51;
        long r61 = r53;
        long r30 = r43;
        long r31 = r49;
        long r113 = r11;
        long r33 = r39;
    L107:
        String r44 = d25.d.j;
        boolean r47 = TextUtils.isEmpty(r44);
        if (r47 == true) goto L110;
        String r63 = r44;
    L111:
        int r114 = !r47 ? 1 : 0;
        JSONObject r115 = new JSONObject();
        r115.put(r10, r13);
        r115.put("cost_time_webfragmentoncreate", r33);
        r115.put("cost_time_newpluginlist", r112);
        r115.put("cost_time_attchpluginlist", r12);
        r115.put("cost_time_onviewcreated", r30);
        r115.put("cost_time_loadurlstart", r31);
        r115.put("cost_time_create_ui", r113);
        long r48 = r113;
        long r116 = r57;
        r115.put("cost_time_containerfragmentoncreate", r116);
        long r117 = r59;
        r115.put("cost_time_loadcontentinfo", r117);
        long r118 = r61;
        r115.put("cost_time_loadcontentfragment", r118);
        r115.put("stage", "create_ui");
        r115.put("docs_result_key", "other");
        r115.put("docs_result_code", 0);
        r115.put("file_type", d25.d.g);
        r115.put("sub_type", d25.d.h);
        s1 r38 = this.a;
        String r119 = r28;
        if (Intrinsics.areEqual(r38.g, r119) == false) goto L114;
        r38.g = du5.b.g(d25.d.d);
    L114:
        r115.put(r27, r38.g);
        r115.put("version_type", this.a.e);
        r115.put(r110, this.a.f);
        r115.put(r8, ow4.a.a);
        r115.put(r111, s1.r);
        r115.put(r29, s1.o);
        r115.put(r16, s1.p);
        r115.put(r14, s1.q);
        this.a.getClass();
        r115.put(r26, DocOpenConfig.i ? 1 : 0);
        AtomicBoolean r40 = s1.t;
        r115.put(r24, String.valueOf(r40.get()));
        r115.put(r23, s1.B);
        r115.put(r22, r114);
        r115.put(r21, r63);
        String r120 = d25.d.d();
        String r121 = r20;
        if (r120 != null) goto L117;
        r120 = r119;
    L117:
        r115.put(r121, r120);
        tt5.a.h(r9, "***reportOpenDoc*** CreateUI create_ui: " + r115.get(r10) + "    cost_time_webfragmentoncreate: " + r33 + "    cost_time_newpluginlist: " + r112 + "    cost_time_attchpluginlist: " + r12 + "    cost_time_onviewcreated: " + r30 + "    cost_time_loadurlstart: " + r31 + "    cost_time_create_ui: " + r48 + "    cost_time_cotainerfragmentoncreate: " + r116 + "    cost_time_loadcontentinfo: " + r117 + "    cost_time_loadcontentfragment: " + r118 + "    isFirstOpenDocs: " + r40.get());
        com.bytedance.ee.bear.contract.d r50 = this.a.b;
        int r52 = s1.c.a;
        r50.a(r18, r115);
        MonitorUtils.monitorEvent(r17, r115, r115, new JSONObject());
        return;
    L110:
        r63 = "none";
    L104:
        r51 = 0;
        r53 = 0;
        goto L105
    L94:
        long r410 = vv4.g.b;
        r46 = r410 - vv4.g.a;
        r42 = r41 - r410;
        r43 = s1.w - vv4.g.c;
        goto L95
    L106:
        r12 = 0;
        r13 = 0;
        r33 = 0;
        r113 = 0;
        r112 = 0;
        r57 = 0;
        r59 = 0;
        r61 = 0;
        r30 = 0;
        r31 = 0;
        goto L107
    L12:
        if (Intrinsics.areEqual(r0.g, r28) == false) goto L17;
        r0.g = du5.b.g(d25.d.d);     // Catch: Throwable -> L78
    L17:
        r16 = "doc_sub_from";
        r27 = r27;
        r1.put(r27, r0.g);     // Catch: Throwable -> L76
        r29 = "doc_from";
        r1.put(r26, DocOpenConfig.i ? 1 : 0);     // Catch: Throwable -> L74
        r26 = r26;
        r1.put(r24, String.valueOf(s1.t.get()));     // Catch: Throwable -> L71
        r24 = r24;
        r1.put(r23, s1.B);     // Catch: Throwable -> L69
        r23 = r23;
        r1.put(r22, r36);     // Catch: Throwable -> L67
        r22 = r22;
        r1.put(r21, r34);     // Catch: Throwable -> L65
        String r122 = d25.d.d();     // Catch: Throwable -> L65
        r21 = r21;
        if (r122 != null) goto L125;
        r122 = r28;
    L125:
        r1.put(r20, r122);     // Catch: Throwable -> L63
        r20 = r20;
        r19 = r19;
        r111 = "doc_has_cache";
        r3 = "start_time";
        String r123 = r0.b.e(r19, r3);     // Catch: Throwable -> L61
        if (r123 != null) goto L129;
        r8 = "scm_version";
        r110 = "enable_x5";
        r10 = "cost_time";
    L45:
        r9 = "DocReport";
        tt5.a.h(r9, "***reportOpenDoc*** LoadUrlStart: " + r1.get(r10));     // Catch: Throwable -> L57
        com.bytedance.ee.bear.contract.d r54 = r0.b;     // Catch: Throwable -> L57
        int r56 = s1.c.a;     // Catch: Throwable -> L57
        r54.a(r18, r1);     // Catch: Throwable -> L55
        r18 = r18;
        r17 = r17;
        MonitorUtils.monitorEvent(r17, r1, r1, new JSONObject());     // Catch: Throwable -> L53
    L53:
        th = th;
    L55:
        th = th;
        r18 = r18;
    L58:
        r17 = r17;
    L57:
        th = th;
    L59:
        th = th;
    L43:
        r17 = r17;
        r9 = "DocReport";
        goto L85
    L129:
        r110 = "enable_x5";
        long r58 = s1.x - CastLongProtector.parseLong(r123);
        r8 = "scm_version";
        r10 = "cost_time";
        r1.put(r10, r58);     // Catch: Throwable -> L59
    L41:
        th = th;
        r8 = "scm_version";
        r110 = "enable_x5";
        r10 = "cost_time";
    L61:
        th = th;
        r8 = "scm_version";
        r110 = "enable_x5";
        r17 = r17;
        r9 = "DocReport";
        r10 = "cost_time";
    L63:
        th = th;
        r20 = r20;
    L73:
        r8 = "scm_version";
        r17 = r17;
        r10 = "cost_time";
    L65:
        th = th;
        r21 = r21;
    L67:
        th = th;
        r22 = r22;
    L69:
        th = th;
        r23 = r23;
    L71:
        th = th;
        r24 = r24;
    L74:
        th = th;
        r26 = r26;
    L76:
        th = th;
        r29 = "doc_from";
    L80:
        th = th;
        r10 = "cost_time";
        goto L15
    L6:
        r34 = "none";
        r36 = 0;
    L83:
        th = th;
        goto L15
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
