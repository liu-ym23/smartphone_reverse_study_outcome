package com.bytedance.ee.bear.facade.common.empty;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes16.dex */
public final class b implements Observer<EmptyStateSource.b> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f226421a;

    public b(c r100) {
        this.f226421a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(EmptyStateSource.b r100) {
        c r101 = this.f226421a;
        r101.a(r100);
    }
}
