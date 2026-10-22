package com.bytedance.android.shopping.prepurchase.arch.container.component;

import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.Lifecycle;
import com.bytedance.android.shopping.prepurchase.arch.container.lifecycle.LifecycleRegistry;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.bytedance.android.shopping.prepurchase.arch.utils.ViewExtensionsKt;
import java.util.ArrayList;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> implements e<STATE, STORE>, g<STATE, STORE> {
    public final List<AbsComponent<?, ?>> a;
    public final com.bytedance.android.shopping.prepurchase.arch.container.c<STATE, STORE> b;
    public final j c;
    public final Lifecycle d;

    public static final class a {
    }

    static {
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final void d(i<STATE, STORE> r4) {
        Intrinsics.checkNotNullParameter(r4, "component");
        if (((ArrayList) this.a).contains(r4) == false) goto L5;
        return;
    L5:
        r4.L1(this.b, this.c);
        this.d.a(r4);
        this.b.w7().d("ComponentLoader", "load service: ".concat(r4.getClass().getName()));
        ((ArrayList) this.a).add(r4);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final void e(Component r4) {
        Intrinsics.checkNotNullParameter(r4, "component");
        if (((ArrayList) this.a).contains(r4) == true) goto L5;
        return;
    L5:
        this.d.c(r4);
        Lifecycle.State r0 = this.d.b();
        int r1 = d.a[r0.ordinal()];
        if (r1 != 2) goto L8;
        r4.h0(r4, Lifecycle.Event.ON_DESTROY);
    L21:
        if ((r4 instanceof Component) == true) goto L23;
    L28:
        this.b.w7().d("ComponentLoader", "unload: ".concat(r4.getClass().getName()));
        ((ArrayList) this.a).remove(r4);
        return;
    L23:
        if (r4.l == false) goto L28;
        View r2 = r4.i;
        if (r2 != null) goto L27;
        Intrinsics.throwUninitializedPropertyAccessException(FreqActions.ACTION_VIEW);
    L27:
        ViewExtensionsKt.a(r2);
        goto L28
    L8:
        if (r1 != 3) goto L10;
        r4.h0(r4, Lifecycle.Event.ON_STOP);
        r4.h0(r4, Lifecycle.Event.ON_DESTROY);
        goto L21
    L10:
        if (r1 != 4) goto L12;
        r4.h0(r4, Lifecycle.Event.ON_PAUSE);
        r4.h0(r4, Lifecycle.Event.ON_STOP);
        r4.h0(r4, Lifecycle.Event.ON_DESTROY);
        goto L21
    L12:
        if (r1 != 5) goto L21;
        if (r4.c == true) goto L21;
        r4.h0(r4, Lifecycle.Event.ON_DESTROY);
        goto L21
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final boolean f(AbsComponent<?, ?> r2) {
        Intrinsics.checkNotNullParameter(r2, "component");
        return ((ArrayList) this.a).contains(r2);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.e
    public final c b(View r3, LifecycleRegistry r4) {
        Intrinsics.checkNotNullParameter(r3, "contentView");
        Intrinsics.checkNotNullParameter(r4, "lifecycle");
        return new c(this.b, this.c, r4);
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final void c(Component<STATE, STORE> r3, View r4) {
        Intrinsics.checkNotNullParameter(r3, "component");
        Intrinsics.checkNotNullParameter(r4, "contentView");
        if (((ArrayList) this.a).contains(r3) == false) goto L5;
        return;
    L5:
        r3.getClass();
        Intrinsics.checkNotNullParameter(r4, FreqActions.ACTION_VIEW);
        r3.i = r4;
        r3.L1(this.b, this.c);
        Intrinsics.checkNotNullParameter(this, "componentLoaderParent");
        r3.j = this;
        this.b.w7().d("ComponentLoader", "loadWithContent: ".concat(r3.getClass().getName()));
        ((ArrayList) this.a).add(r3);
        this.d.a(r3);
    }

    public c(com.bytedance.android.shopping.prepurchase.arch.container.c r2, j r3, LifecycleRegistry r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        Intrinsics.checkNotNullParameter(r3, "serviceRegistry");
        Intrinsics.checkNotNullParameter(r4, "lifecycleRegistry");
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.a = new ArrayList();
    }

    @Override // com.bytedance.android.shopping.prepurchase.arch.container.component.g
    public final void a(ViewGroup r3, Component<STATE, STORE> r4, ViewGroup.LayoutParams r5, int r6) {
        Intrinsics.checkNotNullParameter(r3, "parentView");
        Intrinsics.checkNotNullParameter(r4, "component");
        if (((ArrayList) this.a).contains(r4) == false) goto L5;
        return;
    L5:
        r4.L1(this.b, this.c);
        Intrinsics.checkNotNullParameter(this, "componentLoaderParent");
        r4.j = this;
        r4.b2(r3, r5, r6);
        this.b.w7().d("ComponentLoader", "load: ".concat(r4.getClass().getName()));
        ((ArrayList) this.a).add(r4);
        this.d.a(r4);
    }
}
