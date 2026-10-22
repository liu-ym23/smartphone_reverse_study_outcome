package com.bytedance.ee.bear.middleground.permission.apply;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class y0<T> implements Consumer {
    public final /* synthetic */ OfficeBitableApplyPermissionFragment a;

    public y0(OfficeBitableApplyPermissionFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r4) {
        tt5.a.e("OfficeBitableApplyPermission", "get permission code failed", (Throwable) r4, false);
        OfficeBitableApplyPermissionFragment.V90(this.a, true);
    }
}
