package com.bytedance.ee.bear.bitable.homepage.list;

import androidx.arch.core.util.Function;
import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes15.dex */
public final class v implements Observer<Object> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f212854a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Function f212855b;

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f212854a.setValue(this.f212855b.apply(r100));
    }

    public v(MediatorLiveData r100, m r101) {
        this.f212854a = r100;
        this.f212855b = r101;
    }
}
