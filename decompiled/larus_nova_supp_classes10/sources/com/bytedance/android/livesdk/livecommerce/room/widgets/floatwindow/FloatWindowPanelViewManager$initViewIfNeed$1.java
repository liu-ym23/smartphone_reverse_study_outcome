package com.bytedance.android.livesdk.livecommerce.room.widgets.floatwindow;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.CallableReference;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class FloatWindowPanelViewManager$initViewIfNeed$1 extends MutablePropertyReference0Impl {
    public FloatWindowPanelViewManager$initViewIfNeed$1(a r7) {
        super(r7, a.class, "rootView", "getRootView()Landroid/view/View;", 0);
    }

    public Object get() {
        View r0 = ((a) ((CallableReference) this).receiver).a;
        if (r0 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r0;
    }

    public void set(Object r2) {
        View r3 = (View) r2;
        ((a) ((CallableReference) this).receiver).a = r3;
    }
}
