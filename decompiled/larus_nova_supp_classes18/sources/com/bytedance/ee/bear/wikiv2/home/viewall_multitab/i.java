package com.bytedance.ee.bear.wikiv2.home.viewall_multitab;

import com.bytedance.ee.bear.contract.ConnectionService;
import io.reactivex.functions.Action;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class i implements Action {
    public final /* synthetic */ WikiSpaceListView a;
    public final /* synthetic */ ConnectionService.NetworkState b;

    public i(WikiSpaceListView r1, ConnectionService.NetworkState r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void run() {
        this.a.getRecyclerViewFromXml().setEnable(this.b.a());
        this.a.getRecyclerViewFromXml().b.notifyDataSetChanged();
    }
}
