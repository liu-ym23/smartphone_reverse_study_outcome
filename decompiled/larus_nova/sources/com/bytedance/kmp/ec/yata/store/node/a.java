package com.bytedance.kmp.ec.yata.store.node;

import com.bytedance.kmp.ec.yata.common.error.YataErrorManager;
import com.bytedance.kmp.ec.yata.common.protocol.data.i;
import com.bytedance.kmp.ec.yata.common.protocol.data.p;
import com.bytedance.kmp.ec.yata.common.protocol.data.q;
import com.bytedance.kmp.ec.yata.common.render.LayoutType;
import com.bytedance.kmp.ec.yata.store.core.RenderTreeStruct;
import com.bytedance.kmp.ec.yata.store.core.k;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes19.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f251774a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final k f251775b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final d<a> f251776c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public b f251777d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final List<b> f251778e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final e f251779f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final c f251780g;

    public final com.bytedance.kmp.ec.yata.store.core.f a() {
        c r100 = this.f251780g;
        r100.getClass();
        final LinkedHashMap r101 = new LinkedHashMap();
        b.a.d(r100, new IRenderObject$findAllRenderObjectsByDfsV2$1(r101));
        c r102 = this.f251780g;
        r102.getClass();
        final LinkedHashMap r103 = new LinkedHashMap();
        b.a.b(r102, new IRenderObject$findRenderObjectByNodeNameV2$1(r103));
        c r104 = this.f251780g;
        r104.getClass();
        LinkedHashMap r105 = new LinkedHashMap();
        b.a.c(r104, new IRenderObject$findUpScreenNodesByPositionV2$1(r105));
        c r106 = this.f251780g;
        r106.getClass();
        final LinkedHashMap r107 = new LinkedHashMap();
        b.a.d(r106, new IRenderObject$findAutoExposureGroupNodesV2$1(r107));
        Iterator r108 = r101.entrySet().iterator();
    L4:
        if (r108.hasNext() == false) goto L7;
        c r109 = (c) ((Map.Entry) r108.next()).getValue();
        String r110 = this.f251774a;
        r109.getClass();
        Intrinsics.checkNotNullParameter(r110, "rootKey");
        r109.f251784d = r110;
        goto L4
    L7:
        return new com.bytedance.kmp.ec.yata.store.core.f(r101, r103, r105, r107);
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final List<b> getChildren() {
        return this.f251778e;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final String getKey() {
        return this.f251774a;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final b getParent() {
        return this.f251777d;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void g(b r100) {
        this.f251777d = r100;
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void h(Function1<? super b, Unit> r100) {
        b.a.d(this, r100);
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void n(Function1<? super b, Unit> r100) {
        b.a.c(this, r100);
    }

    @Override // com.bytedance.kmp.ec.yata.store.node.b
    public final void q(Function1<? super b, Unit> r100) {
        b.a.b(this, r100);
    }

    public a(String r110, k r111, d<a> r112) {
        Intrinsics.checkNotNullParameter(r110, "key");
        Intrinsics.checkNotNullParameter(r111, "protocolContext");
        this.f251774a = r110;
        this.f251775b = r111;
        this.f251776c = r112;
        this.f251778e = new ArrayList();
        Map<String, p> r113 = r111.f251746b.getData();
        if (r113 == null) goto L5;
        p r100 = r113.get(r110);
    L6:
        aa6.b r114 = r111.f251746b;
        Intrinsics.checkNotNullParameter(r114, "<this>");
        Intrinsics.checkNotNullParameter(r110, "renderKey");
        Map<String, p> r115 = r114.getData();
        int r101 = 0;
        if (r115 == null) goto L30;
        p r116 = r115.get(r110);
        if (r116 == null) goto L30;
        com.bytedance.kmp.ec.yata.common.protocol.data.k r117 = r116.g();
        if (r117 == null) goto L30;
        String r118 = r117.getType();
        if (r118 == null) goto L30;
        List<com.bytedance.kmp.ec.yata.common.protocol.data.b> r119 = r114.c();
        if (r119 == null) goto L30;
        Iterator<T> r120 = r119.iterator();
    L19:
        if (r120.hasNext() == false) goto L28;
        Object r102 = r120.next();
        List<String> r103 = ((com.bytedance.kmp.ec.yata.common.protocol.data.b) r102).getType();
        if (r103 != null) goto L23;
    L25:
        boolean r104 = false;
    L26:
        if (r104 == false) goto L19;
    L29:
        com.bytedance.kmp.ec.yata.common.protocol.data.b r105 = (com.bytedance.kmp.ec.yata.common.protocol.data.b) r102;
    L31:
        Map<String, Object> r106 = this.f251775b.f251746b.h();
        i r121 = this.f251775b.f251746b.g();
        if (r121 == null) goto L39;
        Map<String, List<String>> r122 = r121.h();
        if (r122 == null) goto L39;
        List<String> r123 = r122.get(this.f251774a);
        if (r123 == null) goto L39;
        List r124 = CollectionsKt.toMutableList(r123);
        if (r124 == null) goto L39;
    L40:
        e r125 = new e(r110, r100, r105, r124, r106);
        this.f251779f = r125;
        if (this.f251776c != null) goto L44;
        c r126 = new h(this.f251774a, r125, this.f251775b.f251745a);
    L91:
        this.f251780g = r126;
        Iterator<T> r127 = r125.f251790d.iterator();
        a r128 = null;
    L93:
        if (r127.hasNext() == false) goto L104;
        Object r129 = r127.next();
        int r107 = r101 + 1;
        if (r101 >= 0) goto L97;
        CollectionsKt.throwIndexOverflow();
    L97:
        r128 = new a((String) r129, this.f251775b, new d(r101, r128));
        b.a.a(this, r128, r101);
        b r130 = r128.f251777d;
        if ((r130 instanceof a) == false) goto L100;
        a r131 = (a) r130;
    L101:
        if (r131 == null) goto L103;
        c r108 = r128.f251780g;
        c r132 = r131.f251780g;
        r132.getClass();
        b.a.a(r132, r108, r101);
    L103:
        r101 = r107;
        goto L93
    L100:
        r131 = null;
        goto L101
    L104:
        return;
    L44:
        if (r125.f251790d.isEmpty() == true) goto L46;
    L48:
        boolean r133 = false;
    L49:
        if (r133 == false) goto L51;
        r126 = new f(this.f251774a, r125, this.f251775b.f251745a);
        goto L91
    L51:
        p r134 = r125.f251788b;
        if (r134 == null) goto L56;
        com.bytedance.kmp.ec.yata.common.protocol.data.k r135 = r134.g();
        if (r135 == null) goto L56;
        String r136 = r135.g();
    L57:
        LayoutType r137 = LayoutType.Banner;
        if (Intrinsics.areEqual(r136, r137.getValue()) == false) goto L60;
        r126 = new g(this.f251774a, r125, this.f251775b, new RenderTreeStruct(new a(this.f251774a, this.f251775b, null)));
        goto L91
    L60:
        p r138 = r125.f251788b;
        if (r138 == null) goto L65;
        com.bytedance.kmp.ec.yata.common.protocol.data.k r139 = r138.g();
        if (r139 == null) goto L65;
        String r140 = r139.g();
    L66:
        if (r140 != null) goto L68;
    L71:
        boolean r109 = true;
    L72:
        if (r109 == false) goto L75;
    L76:
        boolean r141 = true;
    L78:
        if (r141 == true) goto L90;
        YataErrorManager r142 = this.f251775b.f251745a.f251752a.f();
        int r143 = com.bytedance.kmp.ec.yata.common.error.c.f251397a;
        com.bytedance.kmp.ec.yata.common.error.d r144 = new com.bytedance.kmp.ec.yata.common.error.d(1401, "PROTOCOL_CONTAINER_ERROR");
        r144.c("layout_type_invalid");
        StringBuilder r145 = new StringBuilder("layout_type配置不符合预期 ");
        p r146 = r125.f251788b;
        if (r146 == null) goto L84;
        com.bytedance.kmp.ec.yata.common.protocol.data.k r147 = r146.g();
        if (r147 == null) goto L84;
        String r148 = r147.g();
    L85:
        r145.append(r148);
        r144.d(r145.toString());
        p r149 = r125.f251788b;
        if (r149 == null) goto L88;
        String r150 = q.c(r149);
    L89:
        r144.l(r150);
        r144.k(this.f251774a);
        r144.f251414q = true;
        r144.f251415r = ((long) 1000) * 60;
        r144.e();
        r142.c(r144);
        goto L90
    L88:
        r150 = null;
    L84:
        r148 = null;
    L90:
        r126 = new h(this.f251774a, r125, this.f251775b.f251745a);
        goto L91
    L75:
        if (Intrinsics.areEqual(r140, r137.getValue()) == true) goto L76;
        r141 = false;
        goto L78
    L68:
        if (StringsKt.isBlank(r140) == true) goto L71;
        r109 = false;
    L65:
        r140 = null;
    L56:
        r136 = null;
        goto L57
    L46:
        if (r125.f251789c == null) goto L48;
        r133 = true;
    L39:
        r124 = new ArrayList();
        goto L40
    L23:
        if (r103.contains(r118) != true) goto L25;
        r104 = true;
        goto L26
    L28:
        r102 = null;
    L30:
        r105 = null;
        goto L31
    L5:
        r100 = null;
        goto L6
    }
}
