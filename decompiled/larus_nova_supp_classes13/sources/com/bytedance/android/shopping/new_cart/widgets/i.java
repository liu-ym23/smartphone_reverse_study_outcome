package com.bytedance.android.shopping.new_cart.widgets;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class i extends com.bytedance.android.shopping.card_list.components.c {
    public final LifecycleOwner b;
    public final MutableLiveData<Boolean> c;
    public final MutableLiveData<Integer> d;
    public final com.bytedance.android.shopping.card_list.widgets.nest.d e;

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.b;
    }

    public i(LifecycleOwner r5) {
        MutableLiveData<Boolean> r0 = new MutableLiveData();
        MutableLiveData<Integer> r1 = new MutableLiveData();
        com.bytedance.android.shopping.card_list.widgets.nest.d r2 = new com.bytedance.android.shopping.card_list.widgets.nest.d(r5);
        Intrinsics.checkNotNullParameter(r5, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "show");
        Intrinsics.checkNotNullParameter(r1, "bodyLinkedScrollHeight");
        Intrinsics.checkNotNullParameter(r2, "cardListTwoRevState");
        super(r5);
        this.b = r5;
        this.c = r0;
        this.d = r1;
        this.e = r2;
    }
}
