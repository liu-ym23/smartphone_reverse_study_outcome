package com.bytedance.ee.bear.bitable.card.view.table;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes15.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableCardCoverViewPager f208861a;

    public b(BitableCardCoverViewPager r100) {
        this.f208861a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        this.f208861a.B = Boolean.valueOf(!((Boolean) r100).booleanValue());
        this.f208861a.e("orientation");
    }
}
