package com.bytedance.ee.bear.bitable.homepage.list.newlist;

import androidx.lifecycle.Observer;
import com.bytedance.ee.bear.contract.ConnectionService;

/* JADX INFO: loaded from: classes15.dex */
public final class d<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableHomeListNewFragment f212836a;

    public d(BitableHomeListNewFragment r100) {
        this.f212836a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        tt5.a.h("BitableHomeListNewFragment", "on network changed, state = " + ((ConnectionService.NetworkState) r100));
        BitableHomeListNewFragment r101 = this.f212836a;
        int r102 = BitableHomeListNewFragment.f212814t;
        r101.getClass();
    }
}
