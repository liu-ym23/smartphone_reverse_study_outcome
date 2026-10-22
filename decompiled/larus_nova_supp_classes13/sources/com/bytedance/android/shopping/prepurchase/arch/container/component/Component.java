package com.bytedance.android.shopping.prepurchase.arch.container.component;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import com.bytedance.android.shopping.orderlist.common.freq.FreqActions;
import com.bytedance.android.shopping.prepurchase.arch.container.state.h;
import com.bytedance.android.shopping.prepurchase.arch.utils.ViewExtensionsKt;
import com.bytedance.android.shopping.prepurchase.business.pdp.components.m;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class Component<STATE extends com.bytedance.android.shopping.prepurchase.arch.container.state.h, STORE> extends AbsComponent<STATE, STORE> {
    public View i;
    public e<STATE, STORE> j;
    public final Lazy k;
    public boolean l;

    public View c2(LayoutInflater r2, ViewGroup r3) {
        Intrinsics.checkNotNullParameter(r2, "inflater");
        Intrinsics.checkNotNullParameter(r3, "container");
        return null;
    }

    public final g<STATE, STORE> d2() {
        return (g) this.k.getValue();
    }

    public final View e2() {
        View r0 = this.i;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException(FreqActions.ACTION_VIEW);
    L5:
        return r0;
    }

    public Component() {
        this.k = LazyKt.lazy(new Component$componentLoader$2(this));
    }

    public void b2(ViewGroup r2, ViewGroup.LayoutParams r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "parentView");
        View r0 = c2(LayoutInflater.from(r2.getContext()), r2);
        if (r0 == null) goto L11;
        ViewExtensionsKt.a(r0);
        if (r3 != null) goto L7;
        r2.addView(r0, r4);
    L8:
        this.l = true;
        Intrinsics.checkNotNullParameter(r0, FreqActions.ACTION_VIEW);
        this.i = r0;
        return;
    L7:
        r2.addView(r0, r4, r3);
        goto L8
    L11:
        throw new IllegalStateException("contentView is empty");
    }

    public static void a2(Component r1, ViewGroup r2, m r3, ViewGroup.LayoutParams r4, int r5) {
        if ((r5 & 4) == 0) goto L6;
        r4 = null;
    L6:
        if ((r5 & 8) == 0) goto L8;
        int r6 = -1;
    L9:
        r1.getClass();
        Intrinsics.checkNotNullParameter(r2, "parentView");
        Intrinsics.checkNotNullParameter(r3, "component");
        r1.d2().a(r2, r3, r4, r6);
        return;
    L8:
        r6 = 0;
        goto L9
    }
}
