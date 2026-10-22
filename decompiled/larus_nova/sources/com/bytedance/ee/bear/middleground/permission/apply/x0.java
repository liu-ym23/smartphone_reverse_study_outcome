package com.bytedance.ee.bear.middleground.permission.apply;

import com.bytedance.ee.bear.bitable.pro.applypro.BitableApplyProFetcher;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class x0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBitableApplyPermissionFragment f233089a;

    public x0(OfficeBitableApplyPermissionFragment r100) {
        this.f233089a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        OfficeBitableApplyPermissionFragment r101 = this.f233089a;
        BitableApplyProFetcher.ApplyPermissionCode r102 = (BitableApplyProFetcher.ApplyPermissionCode) ((BitableApplyProFetcher.ApplyPermissionCodeResult) r100).data;
        if (r102 != null) goto L5;
    L7:
        boolean r103 = false;
    L8:
        OfficeBitableApplyPermissionFragment.V90(r101, !r103);
        return;
    L5:
        if (r102.getPermissionCode() != 1) goto L7;
        r103 = true;
        goto L8
    }
}
