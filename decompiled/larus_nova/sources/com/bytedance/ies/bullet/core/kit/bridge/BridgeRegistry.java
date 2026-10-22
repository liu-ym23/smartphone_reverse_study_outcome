package com.bytedance.ies.bullet.core.kit.bridge;

import com.bytedance.ies.bullet.core.BulletContext;
import com.bytedance.ies.bullet.service.monitor.AbsBulletMonitorCallback;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class BridgeRegistry implements f {

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public static final Function1<String, List<String>> f246527j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final Function1<List<String>, String> f246528k = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BulletContext f246529a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function1<m16.b, List<com.bytedance.ies.bullet.service.base.bridge.a>> f246530b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final m16.b f246531c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, IBridgeScope> f246532d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Map<String, com.bytedance.ies.bullet.service.base.bridge.a> f246533e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f246534f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f246535g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f246536h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Function1<? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> f246537i;

    public static final class a {
    }

    static {
        f246527j = BridgeRegistry$Companion$SCOPE_SPLITER$1.INSTANCE;
        f246528k = BridgeRegistry$Companion$SCOPE_JOINER$1.INSTANCE;
    }

    @Override // com.bytedance.ies.bullet.service.base.i0
    public final void release() {
        Iterator r100 = ((LinkedHashMap) this.f246532d).entrySet().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((IBridgeScope) ((Map.Entry) r100.next()).getValue()).release();
        goto L4
    L6:
        Iterator r101 = ((LinkedHashMap) this.f246533e).entrySet().iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((com.bytedance.ies.bullet.service.base.bridge.a) ((Map.Entry) r101.next()).getValue()).release();
        goto L8
    L10:
        ((LinkedHashMap) this.f246532d).clear();
        ((LinkedHashMap) this.f246533e).clear();
        this.f246535g = true;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final Map<String, com.bytedance.ies.bullet.service.base.bridge.a> xu() {
        Map<String, com.bytedance.ies.bullet.service.base.bridge.a> r100 = this.f246533e;
        if (this.f246536h == true) goto L38;
        BulletContext r101 = this.f246529a;
        if (r101 == null) goto L9;
        AbsBulletMonitorCallback r102 = r101.f246435c;
        if (r102 == null) goto L9;
        r102.p();
    L9:
        List<com.bytedance.ies.bullet.service.base.bridge.a> r103 = this.f246530b.invoke(this.f246531c);
        StringBuilder r104 = new StringBuilder();
        StringBuilder r105 = new StringBuilder();
        Iterator<T> r106 = r103.iterator();
    L11:
        if (r106.hasNext() == false) goto L16;
        com.bytedance.ies.bullet.service.base.bridge.a r107 = (com.bytedance.ies.bullet.service.base.bridge.a) r106.next();
        r104.append(r107.getName());
        StringsKt.appendln(r104);
        com.bytedance.ies.bullet.service.base.bridge.a r108 = (com.bytedance.ies.bullet.service.base.bridge.a) ((LinkedHashMap) this.f246533e).get(r107.getName());
        if (r108 == null) goto L15;
        r105.append(r108.getName());
        StringsKt.appendln(r105);
        r108.release();
    L15:
        this.f246533e.put(r107.getName(), r107);
        goto L11
    L16:
        Iterator r109 = ((List) this.f246534f.getValue()).iterator();
    L18:
        if (r109.hasNext() == false) goto L32;
        b r110 = (b) r109.next();
        f r111 = r110.f246543a;
        boolean r112 = r110.f246544b;
        LinkedHashMap r113 = new LinkedHashMap();
        Iterator<Map.Entry<String, com.bytedance.ies.bullet.service.base.bridge.a>> r114 = r111.xu().entrySet().iterator();
    L21:
        if (r114.hasNext() == false) goto L18;
        Map.Entry<String, com.bytedance.ies.bullet.service.base.bridge.a> r115 = r114.next();
        if (this.f246533e.containsKey(r115.getKey()) == true) goto L24;
        r113.put(r115.getKey(), MapsKt.mapOf(TuplesKt.to("has_been_registered", Boolean.FALSE)));
        this.f246533e.put(r115.getKey(), r115.getValue());
        goto L21
    L24:
        r113.put(r115.getKey(), MapsKt.mapOf(new Pair[]{TuplesKt.to("has_been_registered", Boolean.TRUE), TuplesKt.to("useOthersOnConflict", Boolean.valueOf(r112))}));
        if (r112 == true) goto L26;
        r115.getValue().release();
        goto L21
    L26:
        com.bytedance.ies.bullet.service.base.bridge.a r116 = (com.bytedance.ies.bullet.service.base.bridge.a) ((LinkedHashMap) this.f246533e).get(r115.getKey());
        if (r116 == null) goto L29;
        r116.release();
    L29:
        this.f246533e.put(r115.getKey(), r115.getValue());
        goto L21
    L32:
        BulletContext r117 = this.f246529a;
        if (r117 == null) goto L37;
        AbsBulletMonitorCallback r118 = r117.f246435c;
        if (r118 == null) goto L37;
        r118.q();
    L37:
        this.f246536h = true;
    L38:
        return r100;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final boolean lp() {
        return this.f246535g;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final com.bytedance.ies.bullet.service.base.bridge.a B40(String r100) {
        Intrinsics.checkNotNullParameter(r100, "func");
        return (com.bytedance.ies.bullet.service.base.bridge.a) ((LinkedHashMap) xu()).get(r100);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final void Jt(Function1<? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "bridgePreInvokeHandler");
        this.f246537i = r100;
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final void LV(com.bytedance.ies.bullet.service.base.bridge.a r100) {
        Intrinsics.checkNotNullParameter(r100, "bridge");
        if (this.f246533e.containsKey(r100.getName()) == false) goto L7;
        Map<String, com.bytedance.ies.bullet.service.base.bridge.a> r101 = this.f246533e;
        LinkedHashMap r102 = (LinkedHashMap) r101;
        com.bytedance.ies.bullet.service.base.bridge.a r103 = (com.bytedance.ies.bullet.service.base.bridge.a) r102.get(r100.getName());
        if (r103 == null) goto L7;
        r103.release();
    L7:
        this.f246533e.put(r100.getName(), r100);
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final void hS(final Function2<? super String, ? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, "handler");
        Function2<? super List<? extends IBridgeScope>, ? super com.bytedance.ies.bullet.service.base.bridge.a, Unit> r101 = new BridgeRegistry$iterateWithFuncName$1(r100);
        Intrinsics.checkNotNullParameter(r101, "handler");
        Iterator r102 = ((LinkedHashMap) this.f246532d).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        ((IBridgeScope) ((Map.Entry) r102.next()).getValue()).e80(r101);
        goto L4
    L6:
        Iterator r103 = ((LinkedHashMap) xu()).entrySet().iterator();
    L8:
        if (r103.hasNext() == false) goto L10;
        Map.Entry r104 = (Map.Entry) r103.next();
        r101.invoke(CollectionsKt.emptyList(), r104.getValue());
        goto L8
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final void AL(BridgeRegistry r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "otherRegistry");
        Iterator r102 = ((LinkedHashMap) r100.f246532d).entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L11;
        Map.Entry r103 = (Map.Entry) r102.next();
        if (this.f246532d.containsKey(r103.getKey()) == true) goto L7;
        Map<String, IBridgeScope> r104 = this.f246532d;
        Object r105 = r103.getKey();
        r104.put((String) r105, (IBridgeScope) r103.getValue());
        goto L4
    L7:
        Map<String, IBridgeScope> r106 = this.f246532d;
        LinkedHashMap r107 = (LinkedHashMap) r106;
        IBridgeScope r108 = (IBridgeScope) r107.get(r103.getKey());
        if (r108 == null) goto L4;
        r108.RA((IBridgeScope) r103.getValue(), r101);
        goto L4
    L11:
        ((List) this.f246534f.getValue()).add(new b(r100, r101));
    }

    public BridgeRegistry(BulletContext r100, List r101, Function1 r102, m16.b r103) {
        Intrinsics.checkNotNullParameter(r101, "scopeProviderFactories");
        Intrinsics.checkNotNullParameter(r102, "bridgeProvider");
        Intrinsics.checkNotNullParameter(r103, "contextProviderFactory");
        this.f246529a = r100;
        this.f246530b = r102;
        this.f246531c = r103;
        this.f246532d = new LinkedHashMap();
        this.f246533e = new LinkedHashMap();
        this.f246534f = LazyKt.lazy(BridgeRegistry$bridgeMergeOps$2.INSTANCE);
        Iterator r104 = r101.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        g r105 = (g) r104.next();
        int r106 = BridgeScope.f246538e;
        BridgeScope r107 = BridgeScope.a.a(r105, this.f246531c);
        this.f246532d.put(r105.getName(), r107);
        goto L4
    }

    @Override // com.bytedance.ies.bullet.core.kit.bridge.f
    public final void UE(String r100, Object r101, com.bytedance.ies.bullet.service.base.bridge.a.InterfaceC3543a r102, Function1<? super Throwable, Unit> r103) {
        Intrinsics.checkNotNullParameter(r100, "funcName");
        Intrinsics.checkNotNullParameter(r101, "params");
        Intrinsics.checkNotNullParameter(r102, "callback");
        Intrinsics.checkNotNullParameter(r103, "reject");
        if (this.f246535g == false) goto L5;
        return;
    L5:
        new BridgeRegistry$handle$impl$1(this).invoke(r100, r101, r102, r103);
    }
}
