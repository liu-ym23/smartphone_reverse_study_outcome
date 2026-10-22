package com.bytedance.ee.bear.bitable.pro.applypro;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class a<T> implements Consumer {
    public final /* synthetic */ BitableApplyProFragment a;

    public a(BitableApplyProFragment r1) {
        this.a = r1;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final void accept(Object r2) {
        BitableApplyProFetcher.ApplyPermissionCode r3 = (BitableApplyProFetcher.ApplyPermissionCode) ((BitableApplyProFetcher.ApplyPermissionCodeResult) r2).data;
        if (r3 == null) goto L5;
        Integer r4 = Integer.valueOf(r3.getPermissionCode());
    L6:
        boolean r0 = true;
        if (r4 != null) goto L10;
    L13:
        BitableApplyProFragment.V90(this.a, r0);
        return;
    L10:
        if (r4.intValue() != 1) goto L13;
        r0 = false;
        goto L13
    L5:
        r4 = null;
        goto L6
    }
}
