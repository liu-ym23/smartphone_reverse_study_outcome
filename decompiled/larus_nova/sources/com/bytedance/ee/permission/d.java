package com.bytedance.ee.permission;

import com.larus.office.base.permission.r;
import io.reactivex.functions.Consumer;

/* JADX INFO: loaded from: classes19.dex */
public final class d<T> implements Consumer {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ut5.a<Boolean> f243025a;

    public d(r r100) {
        this.f243025a = r100;
    }

    @Override // io.reactivex.functions.Consumer
    public final void accept(Object r100) {
        Throwable r101 = (Throwable) r100;
        tt5.a.e("PermissionAllApis", "applyPermission failed", r101, false);
        ut5.a<Boolean> r102 = this.f243025a;
        if (r102 == null) goto L6;
        r102.onError(-1, r101);
        return;
    }
}
