package com.bytedance.ee.bear.middleground.permission.custompassword;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements Runnable {
    public final /* synthetic */ CustomPasswordSettingFragment a;

    public m(CustomPasswordSettingFragment r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (this.a.ga0() != null) goto L5;
        tt5.a.d("CustomPasswordSettingFragment", "setInitState, edit_password is null after delay, view is already detached.");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        CustomPasswordSettingFragment.da0(this.a, true);     // Catch: Throwable -> L7
        goto L12
    }
}
