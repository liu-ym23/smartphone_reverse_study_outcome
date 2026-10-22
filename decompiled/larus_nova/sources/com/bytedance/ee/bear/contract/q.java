package com.bytedance.ee.bear.contract;

import androidx.lifecycle.MediatorLiveData;
import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes16.dex */
public final /* synthetic */ class q implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ MediatorLiveData f217130a;

    public /* synthetic */ q(MediatorLiveData r100) {
        this.f217130a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f217130a.postValue((Boolean) r100);
    }
}
