package com.bytedance.android.shopping.card_list.widgets.nest;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a extends com.bytedance.android.shopping.card_list.components.c {
    public final LifecycleOwner b;
    public final MutableLiveData<Boolean> c;
    public final d d;

    public a() {
        throw null;
    }

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.b;
    }

    public a(LifecycleOwner r4) {
        MutableLiveData<Boolean> r0 = new MutableLiveData(Boolean.FALSE);
        d r1 = new d(r4);
        Intrinsics.checkNotNullParameter(r4, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "cancelRefresh");
        Intrinsics.checkNotNullParameter(r1, "cardListTwoRevState");
        super(r4);
        this.b = r4;
        this.c = r0;
        this.d = r1;
    }
}
