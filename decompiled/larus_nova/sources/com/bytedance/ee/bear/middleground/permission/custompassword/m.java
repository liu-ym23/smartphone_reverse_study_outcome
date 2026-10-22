package com.bytedance.ee.bear.middleground.permission.custompassword;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class m implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CustomPasswordSettingFragment f233821a;

    public m(CustomPasswordSettingFragment r100) {
        this.f233821a = r100;
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
        if (this.f233821a.ga0() != null) goto L5;
        tt5.a.d("CustomPasswordSettingFragment", "setInitState, edit_password is null after delay, view is already detached.");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        CustomPasswordSettingFragment.da0(this.f233821a, true);     // Catch: Throwable -> L7
        goto L12
    }
}
