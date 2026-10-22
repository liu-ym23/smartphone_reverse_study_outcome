package com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword;

import com.bytedance.ee.permission.PermissionSdk;
import io.reactivex.disposables.Disposable;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d implements a {
    public Disposable a;
    public final String b;
    public final int c;

    public final void create() {
    }

    public final void destroy() {
        Disposable r0 = this.a;
        if (r0 == null) goto L6;
        r0.dispose();
        return;
    }

    public d(String r1, int r2) {
        this.b = r1;
        this.c = r2;
    }

    @Override // com.bytedance.ee.bear.middleground.permission.setting.linkshare.linkpassword.a
    public final void I4(String r8, boolean r9, f r10) {
        this.a = new PermissionSdk().a().e(this.b, this.c, r8, r9, new c(r10));
    }
}
