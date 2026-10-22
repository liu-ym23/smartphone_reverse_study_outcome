package com.bytedance.ee.bear.middleground.permission.apply;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class a1<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBitableApplyPermissionFragment f232998a;

    public a1(OfficeBitableApplyPermissionFragment r100) {
        this.f232998a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("OfficeBitableApplyPermission", "apply pro failed", (Throwable) r100, false);
        OfficeBitableApplyPermissionFragment.U90(this.f232998a, -1);
        this.f232998a.setLoading(false);
    }
}
