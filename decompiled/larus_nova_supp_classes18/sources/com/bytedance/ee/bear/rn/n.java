package com.bytedance.ee.bear.rn;

import android.text.TextUtils;
import com.bytedance.ee.bear.contract.AccountService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class n implements com.bytedance.ee.bear.contract.b {
    public n() {
    }

    public final void a(AccountService.Account r3) {
        if (r3 != null) goto L4;
        return;
    L4:
        if (r3.hasLogin() == false) goto L15;
        RnSyncManager.i = r3;
        if (TextUtils.equals(RnSyncManager.s, r3.token) == false) goto L10;
        return;
    L10:
        if (RnSyncManager.j == null) goto L12;
        tt5.a.h("RnSyncManager", " account change");
        RnSyncManager r0 = RnSyncManager.a;
        RnSyncManager.m();
        RnSyncManager.o();
        RnSyncManager.j();
        RnSyncManager.p();
    L12:
        RnSyncManager.s = r3.token;
        return;
    }
}
