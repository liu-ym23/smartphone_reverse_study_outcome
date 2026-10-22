package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFetcher;
import com.bytedance.ee.bear.contract.Result;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class x0<T> implements Consumer {
    public final /* synthetic */ OfficeBitableApplyPermissionFragment a;

    public x0(OfficeBitableApplyPermissionFragment r1) {
        this.a = r1;
    }

    public final void accept(Object r3) {
        OfficeBitableApplyPermissionFragment r0 = this.a;
        BitableApplyProFetcher.ApplyPermissionCode r4 = ((Result) ((BitableApplyProFetcher.ApplyPermissionCodeResult) r3)).data;
        if (r4 != null) goto L5;
    L7:
        boolean r5 = false;
    L8:
        OfficeBitableApplyPermissionFragment.V90(r0, !r5);
        return;
    L5:
        if (r4.getPermissionCode() != 1) goto L7;
        r5 = true;
        goto L8
    }
}
