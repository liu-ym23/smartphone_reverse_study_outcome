package com.bytedance.ee.bear.middleground.permission.apply;

import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes18.dex */
public final class y0<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ OfficeBitableApplyPermissionFragment f233091a;

    public y0(OfficeBitableApplyPermissionFragment r100) {
        this.f233091a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        tt5.a.e("OfficeBitableApplyPermission", "get permission code failed", (Throwable) r100, false);
        OfficeBitableApplyPermissionFragment.V90(this.f233091a, true);
    }
}
