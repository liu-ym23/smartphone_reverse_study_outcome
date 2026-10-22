package com.bytedance.ee.bear.office.common.screenmenu;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class r implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f235247a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenMenuLayout f235248b;

    public r(ScreenMenuLayout r100, ScreenMenuLayout r101) {
        this.f235247a = r100;
        this.f235248b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenMenuLayout.b(this.f235248b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
