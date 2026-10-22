package com.bytedance.android.shopping.card_list.widgets;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.android.shopping.card_list.components.c;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b extends c {
    public final LifecycleOwner b;
    public final MutableLiveData<Unit> c;
    public final MutableLiveData<Boolean> d;
    public final MutableLiveData<Unit> e;
    public final MutableLiveData<Unit> f;

    @Override // com.bytedance.android.shopping.card_list.components.c
    public final LifecycleOwner a() {
        return this.b;
    }

    public b(LifecycleOwner r6) {
        MutableLiveData<Unit> r0 = new MutableLiveData();
        MutableLiveData<Boolean> r1 = new MutableLiveData(Boolean.TRUE);
        MutableLiveData<Unit> r2 = new MutableLiveData();
        MutableLiveData<Unit> r3 = new MutableLiveData();
        Intrinsics.checkNotNullParameter(r6, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r0, "initOrReload");
        Intrinsics.checkNotNullParameter(r1, "liveVisibility");
        Intrinsics.checkNotNullParameter(r2, "liveReleaseEvent");
        Intrinsics.checkNotNullParameter(r3, "onHasMore");
        super(r6);
        this.b = r6;
        this.c = r0;
        this.d = r1;
        this.e = r2;
        this.f = r3;
    }
}
