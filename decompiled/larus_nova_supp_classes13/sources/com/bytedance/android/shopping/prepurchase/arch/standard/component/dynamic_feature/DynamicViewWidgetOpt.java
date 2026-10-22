package com.bytedance.android.shopping.prepurchase.arch.standard.component.dynamic_feature;

import android.content.Context;
import android.view.View;
import com.bytedance.android.shopping.prepurchase.arch.container.ability.l;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;
import org.json.JSONObject;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class DynamicViewWidgetOpt implements com.bytedance.android.shopping.prepurchase.arch.container.ability.h {
    public e a;
    public final c b;
    public boolean c;
    public List<? extends com.bytedance.android.ecom.arch.slice.g> d;
    public final Lazy e;
    public final l f;

    public static final class a extends com.bytedance.android.shopping.prepurchase.arch.container.ability.b {
        public final /* synthetic */ DynamicViewWidgetOpt c;
        public final /* synthetic */ List d;
        public final /* synthetic */ Map e;
        public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.container.ability.c f;

        @Override // java.lang.Runnable
        public final void run() {
            this.c.e(this.d, this.e, this.f);
        }

        public a(DynamicViewWidgetOpt r1, List r2, Map r3, com.bytedance.android.shopping.prepurchase.arch.container.ability.c r4) {
            this.c = r1;
            this.d = r2;
            this.e = r3;
            this.f = r4;
            super("bind_lynx");
        }
    }

    public final SliceReuseHelper g() {
        return (SliceReuseHelper) this.e.getValue();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final ti.l c() {
        Intrinsics.checkNotNullParameter("std_deal_button", "sliceId");
        g r0 = g().b().get("std_deal_button");
        if (r0 != null) goto L7;
        return null;
    L7:
        return r0.d;
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final View b() {
        return g().c();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final void release() {
        g().d();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final View f(String r3) {
        Intrinsics.checkNotNullParameter(r3, "sliceKey");
        e r0 = this.a;
        if (r0 != null) goto L6;
        Intrinsics.throwUninitializedPropertyAccessException("dependency");
    L6:
        return r0.c(this.b, r3);
    }

    public DynamicViewWidgetOpt(Context r2, l r3) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "prefAbility");
        this.f = r3;
        this.b = new c(r2);
        this.e = LazyKt.lazy(new DynamicViewWidgetOpt$helper$2(this));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final Boolean a(String r2, JSONObject r3) {
        Intrinsics.checkNotNullParameter(r2, "eventName");
        return Boolean.valueOf(g().e(r2, r3));
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final void d(String r3, Map<String, ? extends Object> r4) {
        g().f(this.d, r3, r4);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.ability.h
    public final void e(List<? extends com.bytedance.android.ecom.arch.slice.g> r8, Map<String, ? extends Object> r9, com.bytedance.android.shopping.prepurchase.arch.container.ability.c r10) {
        Intrinsics.checkNotNullParameter(r8, "slices");
        Intrinsics.checkNotNullParameter(r10, "option");
        this.d = r8;
        if (r10.a == true) goto L5;
    L21:
        g().a(r8, r9);
        if (this.c == true) goto L31;
        this.c = true;
        this.f.e1(new d(this));
        return;
    L31:
        return;
    L5:
        if (this.f.e0() == true) goto L21;
        ArrayList r2 = new ArrayList();
        Iterator r0 = r8.iterator();
    L8:
        if (r0.hasNext() == false) goto L19;
        Object r3 = r0.next();
        com.bytedance.android.ecom.arch.slice.g r4 = (com.bytedance.android.ecom.arch.slice.g) r3;
        if ((!Intrinsics.areEqual(r4.getSliceType(), "Lynx")) == false) goto L12;
    L15:
        boolean r5 = true;
    L16:
        if (r5 == false) goto L8;
        r2.add(r3);
        goto L8
    L12:
        if (Intrinsics.areEqual(r4.getSliceId(), "std_deal_button") == true) goto L15;
        r5 = false;
        goto L16
    L19:
        if (r8.size() == r2.size()) goto L21;
        this.f.n0(new a(this, r8, r9, r10));
        r8 = r2;
        goto L21
    }
}
