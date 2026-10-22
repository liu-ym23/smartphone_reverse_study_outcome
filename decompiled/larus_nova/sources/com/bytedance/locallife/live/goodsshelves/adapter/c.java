package com.bytedance.locallife.live.goodsshelves.adapter;

import androidx.lifecycle.Observer;

/* JADX INFO: loaded from: classes21.dex */
public final class c<T> implements Observer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LiveLocalLifePagedGoodsAdapter f259549a;

    public c(LiveLocalLifePagedGoodsAdapter r100) {
        this.f259549a = r100;
    }

    @Override // androidx.lifecycle.Observer
    public final void onChanged(Object r100) {
        Integer r101 = (Integer) r100;
        this.f259549a.f259538d.invoke();
    }
}
