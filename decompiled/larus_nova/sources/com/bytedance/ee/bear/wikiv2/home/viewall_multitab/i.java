package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import com.bytedance.ee.bear.contract.ConnectionService;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: classes18.dex */
public final class i implements Action {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ WikiSpaceListView f240786a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ConnectionService.NetworkState f240787b;

    public i(WikiSpaceListView r100, ConnectionService.NetworkState r101) {
        this.f240786a = r100;
        this.f240787b = r101;
    }

    @Override // io.reactivex.functions.Action
    public final void run() {
        this.f240786a.getRecyclerViewFromXml().setEnable(this.f240787b.a());
        this.f240786a.getRecyclerViewFromXml().f240732b.notifyDataSetChanged();
    }
}
