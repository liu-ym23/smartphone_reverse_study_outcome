package com.bytedance.ee.bear.document.render.node.perf;

import android.webkit.WebView;
import androidx.fragment.app.Fragment;
import com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat.ForsetiHelper;
import com.bytedance.ee.bear.document.fail.DocException;
import com.bytedance.ee.bear.document.o;
import com.bytedance.ee.bear.document.render.loader.DocumentLoaderV3;
import com.bytedance.ee.bear.document.render.node.DocLoadingState;
import com.bytedance.ee.bear.document.render.node.g;
import com.bytedance.ee.bear.document.x2;
import com.ss.android.lark.chameleon.pluginapi.ChameleonPluginHost;
import com.ss.android.lark.officesdk.utils.di.j;
import java.util.LinkedHashMap;
import java.util.Map;
import kotlin.Pair;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a extends x2.c {
    public final /* synthetic */ com.bytedance.ee.bear.document.render.node.e a;
    public final /* synthetic */ PerfReportRenderNode b;

    @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
    public final void onLoadSuccess() {
        this.a.S(this);
    }

    public a(DocumentLoaderV3 r1, PerfReportRenderNode r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // com.bytedance.ee.bear.document.x2.c, com.bytedance.ee.bear.document.x2.b
    public final void onLoadFail(int r12, Throwable r13) {
        this.a.S(this);
        PerfReportRenderNode r14 = this.b;
        Map<String, ? extends Object> r0 = r14.e;
        if (r0 != null) goto L5;
        r0 = new LinkedHashMap();
    L5:
        Map<String, ? extends Object> r2 = r0;
        com.bytedance.ee.bear.document.render.node.e r1 = r14.b;
        if (r1 != null) goto L8;
        j.b("PerfReportRenderNode", "onRenderFail renderContext is null");
        return;
    L8:
        j.b("PerfReportRenderNode", "dealFail map:" + r2 + " err:" + r13);
        boolean r3 = false;
        if ((r13 instanceof OvertimeDocException) == false) goto L18;
        Pair r4 = PerfReportRenderNode.d(r1);
        com.bytedance.ee.bear.document.render.node.f r5 = r14.d;
        if (r5 == null) goto L49;
        int r6 = ((OvertimeDocException) r13).getCode();
        g r16 = r14.c;
        if (r16 == null) goto L15;
        boolean r7 = r16.f();
    L16:
        r5.m(r6, r7, r1.getPluginHost().getWeb().getWebView(), ((Number) r4.getFirst()).intValue(), (String) r4.getSecond(), ForsetiHelper.s(r1.getPluginHost().getHostFragment()));
        return;
    L15:
        r7 = false;
        goto L16
    L49:
        return;
    L18:
        if ((r13 instanceof DocException) == false) goto L20;
        int r17 = ((DocException) r13).getCode();
    L21:
        g r8 = r14.c;
        Fragment r9 = null;
        if (r8 == null) goto L24;
        DocLoadingState r10 = r8.state();
    L26:
        if (r10 != DocLoadingState.FAIL) goto L42;
        if (r2.size() > 0) goto L30;
        r2.put("docs_result_code", String.valueOf(r17));
        r2.put("docs_result_key", "native");
    L30:
        Pair r11 = PerfReportRenderNode.d(r1);
        com.bytedance.ee.bear.document.render.node.f r18 = r14.d;
        if (r18 == null) goto L42;
        g r19 = r14.c;
        if (r19 == null) goto L35;
        r3 = r19.f();
    L35:
        WebView r20 = r1.getPluginHost().getWeb().getWebView();
        int r21 = ((Number) r11.getFirst()).intValue();
        String r22 = (String) r11.getSecond();
        com.bytedance.ee.bear.document.render.node.e r23 = r14.b;
        if (r23 == null) goto L40;
        ChameleonPluginHost r24 = r23.getPluginHost();
        if (r24 == null) goto L40;
        r9 = r24.getHostFragment();
    L40:
        r18.g(r2, r3, r20, r21, r22, ForsetiHelper.s(r9));
    L42:
        if (r17 != 5) goto L51;
        com.bytedance.ee.bear.document.render.node.f r110 = r14.d;
        if (r110 == null) goto L46;
        r110.a(r17);
    L46:
        o.a();
        return;
    L51:
        return;
    L24:
        r10 = null;
        goto L26
    L20:
        r17 = -52;
        goto L21
    }
}
