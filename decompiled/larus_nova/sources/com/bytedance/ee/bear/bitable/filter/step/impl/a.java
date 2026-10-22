package com.bytedance.ee.bear.bitable.filter.step.impl;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FilterStepFragment f211906a;

    public a(FilterStepFragment r100) {
        this.f211906a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        FilterStepFragment r101 = this.f211906a;
        r101.va0((String) r100);
    }
}
