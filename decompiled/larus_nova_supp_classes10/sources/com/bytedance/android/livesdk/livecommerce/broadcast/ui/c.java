package com.bytedance.android.livesdk.livecommerce.broadcast.ui;

import vi2.v0;
import xi2.p;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class c implements v0<p> {
    public final /* synthetic */ LiveRoomCouponListViewModel.b a;

    public c(LiveRoomCouponListViewModel.b r1) {
        this.a = r1;
    }

    @Override // vi2.v0
    public final void onError(Throwable r2) {
        this.a.a.getFullLoadingFinishData().postValue(null);
        LiveRoomCouponListViewModel.access$1200(this.a.a);
        LiveRoomCouponListViewModel.access$1002(this.a.a, null);
    }

    @Override // vi2.v0
    public final void onSuccess(p r2) {
        this.a.a.getFullLoadingFinishData().postValue(null);
        LiveRoomCouponListViewModel.access$1100(this.a.a);
        LiveRoomCouponListViewModel.access$1002(this.a.a, null);
    }
}
