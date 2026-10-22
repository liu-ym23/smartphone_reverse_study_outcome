package com.bytedance.ee.bear.middleground.permission.apply;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class a1<T> implements Consumer {
    public final /* synthetic */ OfficeBitableApplyPermissionFragment a;

    public a1(OfficeBitableApplyPermissionFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        tt5.a.e("OfficeBitableApplyPermission", "apply pro failed", (Throwable) r4, false);
        OfficeBitableApplyPermissionFragment.U90(this.a, -1);
        this.a.setLoading(false);
    }
}
