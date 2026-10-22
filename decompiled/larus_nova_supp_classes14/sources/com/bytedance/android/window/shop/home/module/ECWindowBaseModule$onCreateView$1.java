package com.bytedance.android.window.shop.home.module;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECWindowBaseModule$onCreateView$1 extends MutablePropertyReference0Impl {
    public ECWindowBaseModule$onCreateView$1(a r7) {
        super(r7, a.class, "rootView", "getRootView()Landroid/view/View;", 0);
    }

    public Object get() {
        return ((a) ((CallableReference) this).receiver).l();
    }

    public void set(Object r3) {
        a r0 = (a) ((CallableReference) this).receiver;
        View r4 = (View) r3;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r4, "<set-?>");
        r0.l = r4;
    }
}
