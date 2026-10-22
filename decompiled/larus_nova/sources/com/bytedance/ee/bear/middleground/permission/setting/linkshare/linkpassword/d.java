package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import com.bytedance.ee.permission.PermissionSdk;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: classes18.dex */
public final class d implements a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Disposable f234173a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f234174b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f234175c;

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void create() {
    }

    @Override // com.larksuite.framework.mvp.ILifecycle
    public final void destroy() {
        Disposable r100 = this.f234173a;
        if (r100 == null) goto L6;
        r100.dispose();
        return;
    }

    public d(String r100, int r101) {
        this.f234174b = r100;
        this.f234175c = r101;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.a
    public final void I4(String r100, boolean r101, f r110) {
        this.f234173a = new PermissionSdk().a().e(this.f234174b, this.f234175c, r100, r101, new c(r110));
    }
}
