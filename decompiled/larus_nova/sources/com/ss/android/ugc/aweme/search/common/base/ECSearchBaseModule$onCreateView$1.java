package com.ss.android.ugc.aweme.search.common.base;

import android.view.View;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.MutablePropertyReference0Impl;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, k = 3, mv = {1, 4, 3})
final /* synthetic */ class ECSearchBaseModule$onCreateView$1 extends MutablePropertyReference0Impl {
    public ECSearchBaseModule$onCreateView$1(ECSearchBaseModule r100) {
        super(r100, ECSearchBaseModule.class, "rootView", "getRootView()Landroid/view/View;", 0);
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KProperty0
    public Object get() {
        View r100 = ((ECSearchBaseModule) this.receiver).f451482l;
        if (r100 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("rootView");
    L5:
        return r100;
    }

    @Override // kotlin.jvm.internal.MutablePropertyReference0Impl, kotlin.reflect.KMutableProperty0
    public void set(Object r100) {
        ECSearchBaseModule r101 = (ECSearchBaseModule) this.receiver;
        View r102 = (View) r100;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r102, "<set-?>");
        r101.f451482l = r102;
    }
}
