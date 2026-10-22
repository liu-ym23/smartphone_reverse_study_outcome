package com.bytedance.ee.bear.document.render.preload;

import android.os.SystemClock;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.forecast.OperationRecord;
import com.ss.android.lark.chameleon.AbsChameleonService;
import com.ss.android.lark.utils.LarkContext;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugProbesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.i;
import kotlinx.coroutines.j;
import vv4.k;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class WebViewLoadStateWebService extends AbsChameleonService implements e {
    public String a;
    public final LarkDocsPreloadOptimize b;
    public final LinkedHashSet<String> c;
    public boolean d;
    public final Set<String> e;
    public final Map<String, List<i<Unit>>> f;
    public final long g;
    public final Lazy h;

    public WebViewLoadStateWebService() {
        this.a = "WebViewLoadStateWebService" + hashCode();
        etb.b r0 = (etb.b) LarkContext.spiByDwarf(etb.b.class);
        if (r0 == null) goto L7;
        LarkDocsPreloadOptimize r1 = (LarkDocsPreloadOptimize) r0.r("lark_docs_preload_optimize", LarkDocsPreloadOptimize.class, new LarkDocsPreloadOptimize());
        if (r1 == null) goto L7;
    L8:
        this.b = r1;
        OperationRecord r2 = com.bytedance.ee.bear.document.forecast.a.a;
        this.c = new LinkedHashSet(com.bytedance.ee.bear.document.forecast.a.b(DocOpenConfig.e()));
        this.e = new LinkedHashSet();
        this.f = new LinkedHashMap();
        this.g = SystemClock.uptimeMillis();
        this.h = LazyKt.lazy(WebViewLoadStateWebService$mDocReport$2.INSTANCE);
        return;
    L7:
        r1 = new LarkDocsPreloadOptimize();
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.render.preload.e
    public final boolean c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "type");
        return this.e.contains(r2);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void e(String[] r4) {
        JSONObject r0 = new JSONObject();
        r0.put("type", r4);
        tt5.a.h(this.a, "preloadJsModule  param: " + r0);
        k r5 = getWeb();
        if (r5 == null) goto L6;
        r5.j("javascript:preloadJsModule", r0);
        return;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void onAttachToWeb(k r3) {
        Intrinsics.checkNotNullParameter(r3, "web");
        super.onAttachToWeb(r3);
        String r4 = this.a + "#web" + r3.getWebView().hashCode();
        this.a = r4;
        tt5.a.h(r4, "==openDocs==preload== WebViewLoadStateWebService onAttachToWeb");
        tt5.a.h(this.a, "==openDocs==preload== bindBridgeHandlers");
        bindBridgeHandlerAutoUnbind("biz.notify.ready", new c(this));
        bindBridgeHandlerAutoUnbind("biz.notify.preloadReady", new d(this));
    }

    public final void onDetachFromWeb(k r3) {
        super.onDetachFromWeb(r3);
        tt5.a.h(this.a, "==openDocs==preload== WebViewLoadStateWebService onDetachFromWeb");
        Collection r4 = ((LinkedHashMap) this.f).values();
        ArrayList r0 = new ArrayList();
        Iterator r5 = r4.iterator();
    L4:
        if (r5.hasNext() == false) goto L6;
        CollectionsKt.addAll(r0, CollectionsKt.toList((List) r5.next()));
        goto L4
    L6:
        ((LinkedHashMap) this.f).clear();
        Iterator r6 = r0.iterator();
    L8:
        if (r6.hasNext() == false) goto L10;
        ((i) r6.next()).cancel(null);
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.render.preload.e
    public final Object d(String r5, Continuation<? super Unit> r6) {
        tt5.a.h(this.a, "==openDocs==render== awaitTypeReady, type = " + r5 + ", isReady = " + c(r5));
        if (c(r5) == false) goto L7;
        return Unit.INSTANCE;
    L7:
        if (this.d == true) goto L13;
        if (this.b.getOnlyPreloadCurrentType() == false) goto L11;
        tt5.a.h(this.a, "==openDocs==render== awaitTypeReady, clear typesWaitToPreload, just preload ".concat(r5));
        this.c.clear();
    L11:
        this.c.add(r5);
    L17:
        final j r0 = new j(IntrinsicsKt.intercepted(r6), 1);
        r0.C();
        tt5.a.h(this.a, "==openDocs==render== awaitTypeReady, suspendCancellableCoroutine, continuation = " + r0.hashCode());
        LinkedHashMap r1 = (LinkedHashMap) this.f;
        Object r2 = r1.get(r5);
        if (r2 != null) goto L20;
        r2 = new ArrayList();
        r1.put(r5, r2);
    L20:
        final List r3 = (List) r2;
        r3.add(r0);
        r0.i(new WebViewLoadStateWebService$awaitTypeReady$2$1(this, r0, r3));
        Object r7 = r0.B();
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r6);
    L24:
        if (r7 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r7;
    L27:
        return Unit.INSTANCE;
    L13:
        if (this.c.contains(r5) == true) goto L17;
        if (this.e.contains(r5) == true) goto L17;
        tt5.a.h(this.a, "==openDocs==render== awaitTypeReady, preload current type, type = ".concat(r5));
        e(new String[]{r5});
        goto L17
    }
}
