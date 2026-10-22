package com.bytedance.kmp.ec.yata.event.core;

import com.bytedance.kmp.ec.yata.chain.event.EventContext;
import com.bytedance.kmp.ec.yata.chain.trigger.i;
import com.bytedance.kmp.ec.yata.common.biz.YataStoreWrapper;
import com.bytedance.kmp.ec.yata.common.platform.o;
import com.bytedance.kmp.ec.yata.common.protocol.data.g;
import com.bytedance.kmp.ec.yata.event.common.e;
import com.bytedance.kmp.ec.yata.event.common.f;
import java.util.ArrayList;
import java.util.Map;
import kotlin.Deprecated;
import kotlin.Pair;
import kotlin.ReplaceWith;
import kotlin.TuplesKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends e {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final YataStoreWrapper f251687b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final EventContext f251688c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final f f251689d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final d f251690e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f251691f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f251692g;

    public final void A() {
        d r100 = this.f251690e;
        r100.getClass();
        r100.f251700h = new ArrayList();
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final Map<String, Object> c() {
        return this.f251690e.b();
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final Map<String, Object> d() {
        return this.f251690e.f251305a;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final String f() {
        return this.f251688c.f251276i;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final String i() {
        return this.f251689d.f251664d;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final String k() {
        return this.f251689d.f251663c;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final o m() {
        return this.f251689d.f251662b;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final String n() {
        return this.f251688c.f251270c.f251309a.f251326a.f251314a;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final g o() {
        com.bytedance.kmp.ec.yata.chain.event.a r100 = this.f251688c.f251269b;
        if ((r100 instanceof g) == true) goto L7;
        return null;
    L7:
        return (g) r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final Map<String, Object> q() {
        EventContext r100 = this.f251688c;
        Map<String, ? extends Object> r101 = r100.f251278k;
        if (r101 == null) goto L5;
        return r101;
    L5:
        return r100.f251269b.a();
    }

    public final aa6.b x() {
        EventContext r100 = this.f251688c;
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Object r101 = r100.d().get("__yata.sdk.passthrough.empty_adjust_rollback_protocol");
        if ((r101 instanceof aa6.b) == true) goto L7;
        return null;
    L7:
        return (aa6.b) r101;
    }

    @Deprecated(message = "废弃, 历史老逻辑，不要用，很容易出错", replaceWith = @ReplaceWith(expression = "getBizTriggerParams()", imports = {}))
    public final Object y() {
        EventContext r100 = this.f251688c;
        r100.getClass();
        int r101 = i.f251330e;
        i r102 = i.a.b(r100.f251273f);
        if (r102 != null) goto L7;
        return null;
    L7:
        return r102.f251332b;
    }

    public final long z() {
        return this.f251688c.f251270c.f251309a.f251327b;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final String e() {
        return this.f251691f;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final String g() {
        return this.f251692g;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final YataStoreWrapper l() {
        return this.f251687b;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final void s(Map<String, ? extends Object> r100) {
        Map<String, Object> r101 = this.f251690e.f251305a;
        if (r100 != null) goto L5;
        r100 = MapsKt.emptyMap();
    L5:
        r101.putAll(r100);
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final void t(Map<String, ? extends Object> r100) {
        Map<String, Object> r101 = this.f251690e.f251698f;
        if (r100 != null) goto L5;
        r100 = MapsKt.emptyMap();
    L5:
        r101.putAll(r100);
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final void u(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        d r101 = this.f251690e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "map");
        r101.f251306b = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final void v(Map<String, ? extends Object> r100) {
        Intrinsics.checkNotNullParameter(r100, "map");
        d r101 = this.f251690e;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "map");
        r101.f251699g = r100;
    }

    public a(YataStoreWrapper r100, EventContext r101) {
        Intrinsics.checkNotNullParameter(r100, "storeWrapper");
        Intrinsics.checkNotNullParameter(r101, "eventContext");
        this.f251687b = r100;
        this.f251688c = r101;
        Intrinsics.checkNotNullParameter(r101, "<this>");
        Object r102 = r101.d().get("__yata.sdk.passthrough.event_input_params");
        Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.bytedance.kmp.ec.yata.event.common.EventInputParams");
        f r103 = (f) r102;
        this.f251689d = r103;
        com.bytedance.kmp.ec.yata.chain.trigger.a r104 = r101.f251272e;
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type com.bytedance.kmp.ec.yata.event.core.YataTriggerParams");
        this.f251690e = (d) r104;
        this.f251691f = r103.f251666f;
        this.f251692g = r103.f251667g;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    public final void a(String r100, Function0<? extends Object> r101) {
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueInvoker");
        EventContext r102 = this.f251688c;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueInvoker");
        com.bytedance.kmp.ec.yata.chain.trigger.e r103 = r102.f251271d;
        if (r103 == null) goto L6;
        Intrinsics.checkNotNullParameter(r100, "key");
        Intrinsics.checkNotNullParameter(r101, "valueInvoker");
        r103.f251324a.put(r100, r101.invoke());
        return;
    }

    @Override // com.bytedance.kmp.ec.yata.event.common.e
    @Deprecated(message = "废弃, 历史老逻辑，不要用，很容易出错")
    public final void b(String r100, Object r101) {
        EventContext r102 = this.f251688c;
        r102.getClass();
        i r103 = new i(r100, r101, 8);
        i.a.a(r102.f251273f, r103);
    }

    public final void w(Boolean r100, Boolean r101, boolean r102) {
        this.f251690e.f251700h.add(MapsKt.mapOf(new Pair[]{TuplesKt.to("filter", r100), TuplesKt.to("match_node", r101), TuplesKt.to("res", Boolean.valueOf(r102))}));
    }
}
