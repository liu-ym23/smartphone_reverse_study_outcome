package com.bytedance.ee.bear.bitable.homepage.list;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes15.dex */
public final class a<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableHomeListFragment f212778a;

    public a(BitableHomeListFragment r100) {
        this.f212778a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        tt5.a.h("BitableHomeListFragment", "on select creation type = " + r101);
        if (r101 == null) goto L7;
        BitableHomeListFragment r102 = this.f212778a;
        int r103 = BitableHomeListFragment.f212742u;
        r102.U90();
        return;
    }
}
