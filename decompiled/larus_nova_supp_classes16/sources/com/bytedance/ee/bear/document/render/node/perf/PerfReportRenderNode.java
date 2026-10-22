package com.bytedance.ee.bear.document.render.node.perf;

import android.text.TextUtils;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.LifecycleOwnerKt;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.contract.b0;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.imageviewer.diagram.DiagramData$RESULT;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.g;
import com.bytedance.ee.bear.document.render.node.l;
import com.bytedance.ee.bear.document.render.node.o;
import com.bytedance.ee.bear.document.render.node.q;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.Map;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.Job;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class PerfReportRenderNode implements l, c {
    public Job a;
    public com.bytedance.ee.bear.document.render.node.e b;
    public g c;
    public com.bytedance.ee.bear.document.render.node.f d;
    public Map<String, String> e;

    public static final class a {
    }

    static {
    }

    public PerfReportRenderNode() {
    }

    public static Pair d(com.bytedance.ee.bear.document.render.node.e r4) {
        if (r4 == null) goto L7;
        com.bytedance.ee.bear.document.d r5 = r4.getDocumentMetadata();
        if (r5 == null) goto L7;
        String r6 = r5.getEditionId();
    L9:
        if (r6 != null) goto L11;
    L14:
        boolean r3 = true;
    L15:
        if (r3 == false) goto L18;
        return new Pair(0, null);
    L18:
        return new Pair(1, r6);
    L11:
        if (r6.length() == 0) goto L14;
        r3 = false;
    L7:
        r6 = null;
        goto L9
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final void c(DocumentLoaderV3 r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        Job r4 = this.a;
        if (r4 == null) goto L6;
        Job.DefaultImpls.cancel$default(r4, null, 1, null);
        return;
    }

    @Override // com.bytedance.ee.bear.document.render.node.perf.c
    public final void a(Integer r14, final Map<String, String> r16) {
        if (r14 != null) goto L6;
    L24:
        if (r14 != null) goto L27;
        return;
    L27:
        if (r14.intValue() != 3) goto L114;
        if (r16 == null) goto L115;
        String r17 = String.valueOf(r16.get("stage"));
        String r4 = String.valueOf(r16.get("docs_result_key"));
        String r5 = String.valueOf(r16.get("docs_result_code"));
        if (TextUtils.equals("other", r4) == true) goto L32;
    L34:
        boolean r6 = false;
    L36:
        if (TextUtils.equals(r17, "render_doc") == false) goto L85;
        if (r6 == false) goto L80;
        g r18 = this.c;
        if (r18 == null) goto L41;
        r18.h();
    L41:
        g r19 = this.c;
        if (r19 == null) goto L44;
        r19.finish(true);
    L44:
        com.bytedance.ee.bear.document.render.node.e r110 = this.b;
        if (r110 == null) goto L47;
        r110.c(new PerfReportRenderNode$onReceiveFrontEvent$1(r16));
    L47:
        com.bytedance.ee.bear.document.render.node.e r111 = this.b;
        String r0 = null;
        if (r111 == null) goto L50;
        com.bytedance.ee.bear.document.d r112 = r111.getDocumentMetadata();
    L51:
        g r1 = this.c;
        if (r1 == null) goto L54;
        DocLoadingState r2 = r1.state();
    L56:
        if (r2 != DocLoadingState.SUCCESS) goto L70;
        Pair r3 = d(this.b);
        com.bytedance.ee.bear.document.render.node.f r7 = this.d;
        if (r7 == null) goto L70;
        g r8 = this.c;
        if (r8 == null) goto L62;
        boolean r9 = r8.f();
    L63:
        int r10 = ((Number) r3.getFirst()).intValue();
        String r11 = (String) r3.getSecond();
        com.bytedance.ee.bear.document.render.node.e r12 = this.b;
        if (r12 == null) goto L68;
        ChameleonPluginHost r13 = r12.getPluginHost();
        if (r13 == null) goto L68;
        Fragment r20 = r13.getHostFragment();
    L69:
        r7.o(r16, r9, r10, r11, ForsetiHelper.s(r20));
    L68:
        r20 = null;
        goto L69
    L62:
        r9 = false;
    L70:
        if (r112 == null) goto L72;
        r0 = r112.getToken();
    L72:
        String r113 = "";
        if (r0 != null) goto L75;
        r0 = "";
    L75:
        String r114 = r16.get("total_block_count");
        if (r114 == null) goto L79;
        r113 = r114;
    L79:
        a05.d.a(r0, "block_num", r113);
        return;
    L54:
        r2 = null;
        goto L56
    L50:
        r112 = null;
        goto L51
    L80:
        int r115 = yu5.c.f(r5, -53);
        final DocException r21 = new DocException(r115, "Err in render doc");
        this.e = r16;
        com.bytedance.ee.bear.document.render.node.e r22 = this.b;
        if (r22 == null) goto L83;
        r22.c(new PerfReportRenderNode$onReceiveFrontEvent$2(r21, r16));
    L83:
        e(r115, r21, r16);
        return;
    L85:
        if (TextUtils.equals(r17, "pull_data") == false) goto L95;
        if (r6 == false) goto L90;
        g r116 = this.c;
        if (r116 == null) goto L118;
        r116.a();
        return;
    L118:
        return;
    L90:
        int r117 = yu5.c.f(r5, -54);
        final DocException r23 = new DocException(r117, "Err in pull data");
        this.e = r16;
        com.bytedance.ee.bear.document.render.node.e r24 = this.b;
        if (r24 == null) goto L93;
        r24.c(new PerfReportRenderNode$onReceiveFrontEvent$3(r23, r16));
    L93:
        e(r117, r23, r16);
        return;
    L95:
        if (TextUtils.equals(r17, "render_cache") == true) goto L97;
        j.f("PerfReportRenderNode", "onReceiveFrontEvent end stage: ".concat(r17));
        return;
    L97:
        if (idb.f.a().isEnable("ccm.bitable.docx_base.optimized.enable") == false) goto L101;
        com.bytedance.ee.bear.document.render.node.e r118 = this.b;
        if (r118 == null) goto L101;
        r118.c(PerfReportRenderNode$onReceiveFrontEvent$4.INSTANCE);
    L101:
        g r119 = this.c;
        if (r119 == null) goto L121;
        r119.e();
        return;
    L121:
        return;
    L32:
        if (TextUtils.equals(r5, DiagramData$RESULT.FAIL) == false) goto L34;
        r6 = true;
        goto L36
    L115:
        return;
    L114:
        return;
    L6:
        if (r14.intValue() != 2) goto L24;
        if (r16 == null) goto L106;
        String r120 = String.valueOf(r16.get("stage"));
        if (TextUtils.equals(r120, "render_doc") == false) goto L14;
        g r121 = this.c;
        if (r121 == null) goto L107;
        r121.d();
        return;
    L107:
        return;
    L14:
        if (TextUtils.equals(r120, "pull_data") == false) goto L19;
        g r122 = this.c;
        if (r122 == null) goto L109;
        r122.g();
        return;
    L109:
        return;
    L19:
        if (TextUtils.equals(r120, "render_cache") == false) goto L23;
        g r123 = this.c;
        if (r123 == null) goto L111;
        r123.c();
        return;
    L111:
        return;
    L23:
        j.f("PerfReportRenderNode", "onReceiveFrontEvent start stage: ".concat(r120));
        return;
    }

    @Override // com.bytedance.ee.bear.document.render.node.l
    public final Object b(DocumentLoaderV3 r10, Continuation r11) {
        this.b = r10;
        String r2 = ((com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6)).e("start_open", "click_timestamp");     // Catch: Exception -> L7
        if (r2 == null) goto L9;
        Long r3 = Long.valueOf(CastLongProtector.parseLong(r2));     // Catch: Exception -> L7
    L10:
        if (r3 == null) goto L12;
        long r4 = r3.longValue();
        o r5 = r10.h;
        JSONObject r6 = new JSONObject();
        r6.put("tap", Boxing.boxLong(r4));
        Unit r7 = Unit.INSTANCE;
        r5.a("timestamp", r6);
    L12:
        this.c = r10.j;
        this.d = r10.c;
        j.e("PerfReportRenderNode", r10.i + "addTimeoutJob");
        Job r12 = this.a;
        if (r12 == null) goto L15;
        Job.DefaultImpls.cancel$default(r12, null, 1, null);
    L15:
        Job r13 = BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r10.d.getFragment()), null, null, new PerfReportRenderNode$addTimeoutJob$1(this, null), 3, null);
        this.a = r13;
        final b r8 = new b(r10, this);
        if (r13 == null) goto L18;
        r13.invokeOnCompletion(new PerfReportRenderNode$addTimeoutJob$2(this, r8));
    L18:
        r10.S3(r8);
        k r14 = r10.d.getChameleonWeb();
        if (r14 == null) goto L21;
        r14.h("biz.statistics.sendEvent", new d(this.d, r10.j, (com.bytedance.ee.bear.contract.d) org.koin.java.a.c(com.bytedance.ee.bear.contract.d.class, null, null, 6), ((b0) org.koin.java.a.c(b0.class, null, null, 6)).e(), this));
    L21:
        r10.S3(new com.bytedance.ee.bear.document.render.node.perf.a(r10, this));
        q.a.getClass();
        return new q.c();
    L9:
        r3 = null;
    L7:
        e = move-exception;
        j.g("PerfReportRenderNode", "getTapTime error", e);
        goto L9
    }

    public final void e(int r3, DocException r4, Map<String, String> r5) {
        g r0 = this.c;
        if (r0 == null) goto L6;
        r0.finish(false);
    L6:
        if (r3 != 4) goto L8;
        return;
    L8:
        if (r3 != 1002) goto L10;
        return;
    L10:
        if (r3 == 3) goto L17;
        com.bytedance.ee.bear.document.render.node.e r1 = this.b;
        if (r1 == null) goto L18;
        r1.d(r3, r4, r5);
        return;
    L18:
        return;
    }
}
