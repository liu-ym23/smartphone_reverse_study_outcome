package com.bytedance.ies.sve_core;

import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.MutableLiveData;
import com.bytedance.ies.sve_core.s;
import kotlin.jvm.functions.Function1;

/* JADX INFO: loaded from: classes19.dex */
public final class m<S extends s> implements o<S> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final MutableLiveData<S> f248697a;

    @Override // com.bytedance.ies.sve_core.o
    public final s b() {
        return this.f248697a.getValue();
    }

    public m() {
        this.f248697a = new MutableLiveData();
    }

    @Override // com.bytedance.ies.sve_core.o
    public final k a(LifecycleOwner r100, Function1 r101) {
        l r102 = new l(r101);
        this.f248697a.observe(r100, r102);
        return new k(this.f248697a, r102);
    }
}
