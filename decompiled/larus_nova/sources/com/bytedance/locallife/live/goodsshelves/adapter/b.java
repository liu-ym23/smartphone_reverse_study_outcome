package com.bytedance.locallife.live.goodsshelves.adapter;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class b<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifePagedGoodsAdapter f259548a;

    public b(LiveLocalLifePagedGoodsAdapter r100) {
        this.f259548a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        LiveLocalLifePagedGoodsAdapter r101 = this.f259548a;
        boolean r102 = ((Boolean) r100).booleanValue();
        if (r102 == r101.f259512a) goto L6;
        r101.f259512a = r102;
        r101.D2(r102);
        return;
    }
}
