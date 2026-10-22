package com.bytedance.ee.bear.bitable.pro.applypro;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes16.dex */
public final class a<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ BitableApplyProFragment f215157a;

    public a(BitableApplyProFragment r100) {
        this.f215157a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        BitableApplyProFetcher.ApplyPermissionCode r101 = (BitableApplyProFetcher.ApplyPermissionCode) ((BitableApplyProFetcher.ApplyPermissionCodeResult) r100).data;
        if (r101 == null) goto L5;
        Integer r102 = Integer.valueOf(r101.getPermissionCode());
    L6:
        boolean r103 = true;
        if (r102 != null) goto L10;
    L13:
        BitableApplyProFragment.V90(this.f215157a, r103);
        return;
    L10:
        if (r102.intValue() != 1) goto L13;
        r103 = false;
        goto L13
    L5:
        r102 = null;
        goto L6
    }
}
