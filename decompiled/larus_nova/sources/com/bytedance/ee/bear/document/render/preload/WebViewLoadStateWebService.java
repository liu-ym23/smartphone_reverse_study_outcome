package com.bytedance.ee.bear.document.render.preload;

import android.os.SystemClock;
import com.alibaba.fastjson.JSONObject;
import com.bytedance.ee.bear.document.DocOpenConfig;
import com.bytedance.ee.bear.document.forecast.OperationRecord;
import com.bytedance.ee.docsdk.impl.document.plugins.JsBridgeConstants;
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

/* JADX INFO: loaded from: classes16.dex */
public final class WebViewLoadStateWebService extends AbsChameleonService implements e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f221392a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final LarkDocsPreloadOptimize f221393b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final LinkedHashSet<String> f221394c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f221395d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f221396e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, List<i<Unit>>> f221397f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f221398g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final Lazy f221399h;

    public WebViewLoadStateWebService() {
        this.f221392a = "WebViewLoadStateWebService" + hashCode();
        etb.b r100 = (etb.b) LarkContext.spiByDwarf(etb.b.class);
        if (r100 == null) goto L7;
        LarkDocsPreloadOptimize r101 = (LarkDocsPreloadOptimize) r100.r("lark_docs_preload_optimize", LarkDocsPreloadOptimize.class, new LarkDocsPreloadOptimize());
        if (r101 == null) goto L7;
    L8:
        this.f221393b = r101;
        OperationRecord r102 = com.bytedance.ee.bear.document.forecast.a.f219926a;
        this.f221394c = new LinkedHashSet(com.bytedance.ee.bear.document.forecast.a.b(DocOpenConfig.e()));
        this.f221396e = new LinkedHashSet();
        this.f221397f = new LinkedHashMap();
        this.f221398g = SystemClock.uptimeMillis();
        this.f221399h = LazyKt.lazy(WebViewLoadStateWebService$mDocReport$2.INSTANCE);
        return;
    L7:
        r101 = new LarkDocsPreloadOptimize();
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.render.preload.e
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "type");
        return this.f221396e.contains(r100);
    }

    public final void e(String[] r100) {
        JSONObject r101 = new JSONObject();
        r101.put2("type", r100);
        tt5.a.h(this.f221392a, "preloadJsModule  param: " + r101);
        k r102 = getWeb();
        if (r102 == null) goto L6;
        r102.j("javascript:preloadJsModule", r101);
        return;
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a
    public final void onAttachToWeb(k r100) {
        Intrinsics.checkNotNullParameter(r100, "web");
        super.onAttachToWeb(r100);
        String r101 = this.f221392a + "#web" + r100.getWebView().hashCode();
        this.f221392a = r101;
        tt5.a.h(r101, "==openDocs==preload== WebViewLoadStateWebService onAttachToWeb");
        tt5.a.h(this.f221392a, "==openDocs==preload== bindBridgeHandlers");
        bindBridgeHandlerAutoUnbind(JsBridgeConstants.BIZ_NOTIFY_READY, new c(this));
        bindBridgeHandlerAutoUnbind(JsBridgeConstants.BIZ_NOTIFY_PRELOADREADY, new d(this));
    }

    @Override // com.ss.android.lark.chameleon.AbsChameleonService, vv4.a, vv4.m
    public final void onDetachFromWeb(k r100) {
        super.onDetachFromWeb(r100);
        tt5.a.h(this.f221392a, "==openDocs==preload== WebViewLoadStateWebService onDetachFromWeb");
        Collection r101 = ((LinkedHashMap) this.f221397f).values();
        ArrayList r102 = new ArrayList();
        Iterator r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        CollectionsKt.addAll(r102, CollectionsKt.toList((List) r103.next()));
        goto L4
    L6:
        ((LinkedHashMap) this.f221397f).clear();
        Iterator r104 = r102.iterator();
    L8:
        if (r104.hasNext() == false) goto L10;
        ((i) r104.next()).cancel(null);
        goto L8
    }

    @Override // com.bytedance.ee.bear.document.render.preload.e
    public final Object d(String r100, Continuation<? super Unit> r101) {
        tt5.a.h(this.f221392a, "==openDocs==render== awaitTypeReady, type = " + r100 + ", isReady = " + c(r100));
        if (c(r100) == false) goto L7;
        return Unit.INSTANCE;
    L7:
        if (this.f221395d == true) goto L13;
        if (this.f221393b.getOnlyPreloadCurrentType() == false) goto L11;
        tt5.a.h(this.f221392a, "==openDocs==render== awaitTypeReady, clear typesWaitToPreload, just preload ".concat(r100));
        this.f221394c.clear();
    L11:
        this.f221394c.add(r100);
    L17:
        final j r102 = new j(IntrinsicsKt.intercepted(r101), 1);
        r102.C();
        tt5.a.h(this.f221392a, "==openDocs==render== awaitTypeReady, suspendCancellableCoroutine, continuation = " + r102.hashCode());
        LinkedHashMap r103 = (LinkedHashMap) this.f221397f;
        Object r104 = r103.get(r100);
        if (r104 != null) goto L20;
        r104 = new ArrayList();
        r103.put(r100, r104);
    L20:
        final List r105 = (List) r104;
        r105.add(r102);
        r102.i(new WebViewLoadStateWebService$awaitTypeReady$2$1(this, r102, r105));
        Object r106 = r102.B();
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L24;
        DebugProbesKt.probeCoroutineSuspended(r101);
    L24:
        if (r106 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L27;
        return r106;
    L27:
        return Unit.INSTANCE;
    L13:
        if (this.f221394c.contains(r100) == true) goto L17;
        if (this.f221396e.contains(r100) == true) goto L17;
        tt5.a.h(this.f221392a, "==openDocs==render== awaitTypeReady, preload current type, type = ".concat(r100));
        e(new String[]{r100});
        goto L17
    }
}
