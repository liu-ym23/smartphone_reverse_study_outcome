package com.bytedance.android.shopping.mall.homepage.pagecard;

import android.content.Context;
import android.view.ViewGroup;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.ec.hybrid.card.event.ECEventCenter;
import com.bytedance.android.ec.hybrid.card.impl.ECLynxCard;
import com.bytedance.android.ec.hybrid.log.mall.ECMallLogUtil;
import com.bytedance.android.ec.hybrid.log.mall.k;
import com.bytedance.android.shopping.api.mall.common.tools.b0;
import com.bytedance.android.shopping.verse.api.IVerseService;
import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.TimeUnit;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.Unit;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements mf3.a {
    public final PageCard a;
    public boolean b;
    public final String c;

    @Override // mf3.b
    public final void onAppBackground() {
        PageCard.e(this.a, "ec.mallActionAppBackgroundForeground", MapsKt.mapOf(new Pair("isForeground", Boolean.FALSE)), 4);
    }

    @Override // mf3.b
    public final void onAppForeground() {
        PageCard.e(this.a, "ec.mallActionAppBackgroundForeground", MapsKt.mapOf(new Pair("isForeground", Boolean.TRUE)), 4);
    }

    @Override // mf3.b
    public final void onDestroy() {
        PageCard r0 = this.a;
        r0.getClass();
        Lazy r1 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.b.b, "pageCard destroy");
        r0.h = null;
        r0.g = new ConcurrentHashMap();
        r0.i.clear();
        r0.j.clear();
        com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a r2 = (com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) r0.f.getValue();
        r2.getClass();
        String r3 = r2.f;     // Catch: Exception -> L10
        if (r3 == null) goto L12;
        Iterator r4 = ((LinkedHashMap) r2.e).entrySet().iterator();     // Catch: Exception -> L10
    L7:
        if (r4.hasNext() == false) goto L12;
        Map.Entry r5 = (Map.Entry) r4.next();     // Catch: Exception -> L10
        int r6 = lk.b.a;     // Catch: Exception -> L10
        Intrinsics.checkNotNullParameter(r3, "sceneID");     // Catch: Exception -> L10
    L12:
        if (r0.a == null) goto L21;
        IVerseService r7 = ECLynxCard.f;
        if (r7 == null) goto L22;
        r7.getMallDebugService();
        return;
    L22:
        return;
    }

    @Override // mf3.b
    public final void onRefresh() {
        PageCard.e(this.a, "ec.mallActionRefresh", null, 6);
    }

    public c(String r2) {
        Intrinsics.checkNotNullParameter(r2, "cardSchema");
        this.c = r2;
        this.a = new PageCard();
    }

    @Override // mf3.b
    public final void c(String r5) {
        Intrinsics.checkNotNullParameter(r5, "sceneId");
        PageCard r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r5, "sceneId");
        if (r1.o == true) goto L10;
        r1.a = new ECLynxCard();
        r1.b = r5;
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.b.b, "pageCard init");
        if (((Number) r1.e.getValue()).intValue() != 1) goto L8;
        com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a r2 = (com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) r1.f.getValue();
        r2.getClass();
        Intrinsics.checkNotNullParameter(r5, "sceneID");
        r2.f = r5;
        int r3 = lk.b.a;
        Intrinsics.checkNotNullParameter(r5, "sceneID");
        Intrinsics.checkNotNullParameter(r5, "sceneID");
        Intrinsics.checkNotNullParameter(r5, "sceneID");
    L8:
        r1.o = true;
        return;
    }

    public final void f(String r3) {
        PageCard r0 = this.a;
        if (r3 != null) goto L5;
        r0.getClass();
        return;
    L5:
        ECLynxCard r1 = r0.a;
        if (r1 == null) goto L10;
        int r2 = com.bytedance.android.ec.hybrid.card.api.d.e;
        r1.e(com.bytedance.android.ec.hybrid.card.api.d.a.b(r3), true);
        return;
    }

    @Override // mf3.b
    public final void a(boolean r7, boolean r8) {
        Intrinsics.checkNotNullParameter("page", "source");
        PageCard r2 = this.a;
        Map r9 = MapsKt.mapOf(new Pair[]{new Pair("visible", Boolean.valueOf(r7)), new Pair("source", "page"), new Pair("isFirstShow", Boolean.valueOf(r8))});
        r2.getClass();
        Intrinsics.checkNotNullParameter("pageVisibilityChange", "eventName");
        Lazy r0 = ECMallLogUtil.a;
        ECMallLogUtil.c(k.b.b, "sendPrivateEvent, eventName = pageVisibilityChange , params =" + b0.m(r9));
        if (r2.n == true) goto L5;
        r2.j.add(new Pair("pageVisibilityChange", r9));
        return;
    L5:
        ECLynxCard r1 = r2.a;
        if (r1 == null) goto L10;
        r1.p("pageVisibilityChange", r9);
        return;
    }

    public final Map<String, Object> d(String r6, Map<String, ? extends Object> r7) {
        Intrinsics.checkNotNullParameter(r6, "apiKey");
        Intrinsics.checkNotNullParameter(r7, "paramContext");
        PageCard r1 = this.a;
        r1.getClass();
        Intrinsics.checkNotNullParameter(r6, "apiKey");
        Intrinsics.checkNotNullParameter(r7, "paramsContext");
        if (r1.a() == false) goto L12;
        Object r0 = r7.get("tab_id");
        if ((r0 instanceof String) == true) goto L7;
        r0 = null;
    L7:
        String r2 = (String) r0;
        if (r2 != null) goto L10;
        r2 = "0";
    L10:
        r1.m.b.setTPullDynamicParamsStart(Long.valueOf(System.currentTimeMillis()));
        Map<String, Object> r8 = ((com.bytedance.android.shopping.mall.homepage.pagecard.dynamicparams.a) r1.f.getValue()).a(r2, r6, r7);
        r1.m.a(true, true);
        return r8;
    L12:
        return r1.g.get(r6);
    }

    public final void e(String r5, String r6) {
        Intrinsics.checkNotNullParameter(r5, "apiKey");
        Intrinsics.checkNotNullParameter(r6, "dynamicParamsJson");
        this.a.d("ec.mallDataApiRequestSuccess", MapsKt.mapOf(new Pair[]{new Pair("apiKey", r5), new Pair("dynamicString", r6)}), true);
    }

    public final void g(List<String> r20, Map<String, ? extends Object> r21, long r22, Function0<Unit> r24) {
        Intrinsics.checkNotNullParameter(r20, "apiKeys");
        Intrinsics.checkNotNullParameter(r21, "paramContext");
        Intrinsics.checkNotNullParameter(r24, "onFinishCallBack");
        PageCard r7 = this.a;
        r7.getClass();
        Intrinsics.checkNotNullParameter(r20, "apiKeys");
        Intrinsics.checkNotNullParameter(r21, "paramContext");
        Intrinsics.checkNotNullParameter(r24, "onFinishCallBack");
        Lazy r5 = ECMallLogUtil.a;
        k.b r6 = k.b.b;
        ECMallLogUtil.c(r6, "pagecard asyncGetDynamicParams  : " + r20);
        r7.m.b.setTPullDynamicParamsStart(Long.valueOf(System.currentTimeMillis()));
        Function0<Unit> r8 = r7.h;
        if (r8 == null) goto L5;
        r8.invoke();
        r7.m.a(false, false);
        ECMallLogUtil.c(r6, "pagecard asyncGetDynamicParams 被重复触发,执行兜底保障");
    L5:
        r7.h = r24;
        long r12 = System.currentTimeMillis();
        String r9 = r7.b;
        if (r9 != null) goto L8;
        r9 = "";
    L8:
        ECEventCenter.c(new com.bytedance.android.ec.hybrid.card.event.b("ec.mallDataGetApiParams", r12, r9, false, MapsKt.mapOf(new Pair[]{new Pair("apiKeys", r20), new Pair("paramContext", b0.m(r21))}), false, 32));
        r7.k = Observable.timer(r22, TimeUnit.MILLISECONDS).observeOn(AndroidSchedulers.mainThread()).subscribe(new a(r7, r20));
    }

    @Override // mf3.b
    public final void b(Context r15, Lifecycle r16, ViewGroup r17, Map<String, ? extends Object> r18, String r19, Map<String, String> r20, Map<String, ? extends Object> r21, String r22, boolean r23) {
        Intrinsics.checkNotNullParameter(r15, "context");
        Intrinsics.checkNotNullParameter(r16, "lifecycle");
        Intrinsics.checkNotNullParameter(r17, "container");
        Intrinsics.checkNotNullParameter(r18, "globalProps");
        Intrinsics.checkNotNullParameter(r19, "bid");
        Intrinsics.checkNotNullParameter(r20, "consumerMonitor");
        Intrinsics.checkNotNullParameter(r22, "initData");
        if (this.b == true) goto L6;
        this.a.b(r15, r17, r16, this.c, false, r18, r19, r20, r21, r22, r23);
        this.b = true;
        return;
    }
}
