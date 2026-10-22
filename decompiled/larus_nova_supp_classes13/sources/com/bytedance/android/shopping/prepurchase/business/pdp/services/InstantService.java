package com.bytedance.android.shopping.prepurchase.business.pdp.services;

import com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent;
import com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature.slice.o;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.b0;
import fi3.c0;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.TuplesKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import vg3.d0;
import vg3.n;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class InstantService extends b0 implements n {
    public static final /* synthetic */ int r = 0;
    public Map<String, Object> i;
    public final Map<String, Object> j;
    public final Map<String, Object> k;
    public boolean l;
    public final Map<String, String> m;
    public boolean n;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<Map<String, Object>> o;
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d<List<com.bytedance.android.ecom.arch.slice.adapter.b>> p;
    public final InstantService$dependency$1 q;

    public static final class a<T> implements com.bytedance.android.shopping.prepurchase.arch.container.state.g {
        public final /* synthetic */ InstantService a;

        public a(InstantService r1) {
            this.a = r1;
        }

        @Override // com.bytedance.android.shopping.prepurchase.arch.container.state.g
        public final void onChanged(Object r5) {
            Map r6 = (Map) r5;
            Intrinsics.checkNotNullParameter(r6, "it");
            o r0 = this.a.O1().e().r();
            r0.M0(MapsKt.mapOf(TuplesKt.to("supermarket_cart_bar_data", r6)));
            if ((!r6.isEmpty()) != true) goto L6;
            int r1 = c0.e;
            r0.y0(c0.a.a("SupermarketPopSellPointHighlight", r6, null, 10), new com.bytedance.android.ecom.arch.slice.action.c(null, null), null);
            return;
        }
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final List<Class<?>> M1() {
        return CollectionsKt.listOf(d0.class);
    }

    public InstantService() {
        this.i = new LinkedHashMap();
        this.j = new LinkedHashMap();
        this.k = new LinkedHashMap();
        this.m = new LinkedHashMap();
        this.o = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.p = new com.bytedance.android.shopping.prepurchase.arch.container.state.d();
        this.q = new InstantService$dependency$1(this);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.AbsComponent
    public final void T1() {
        super.T1();
        AbsComponent.Y1(this, n.class, this, false, 12);
        com.bytedance.android.shopping.prepurchase.arch.container.state.e.a.a(this.o, this, new a(this));
        Z1(d0.class, new InstantService$onAttach$2(this, null));
    }

    @Override // vg3.n
    public final com.bytedance.android.shopping.prepurchase.arch.container.state.d F1() {
        return this.p;
    }

    @Override // vg3.n
    public final InstantService$dependency$1 b() {
        return this.q;
    }
}
