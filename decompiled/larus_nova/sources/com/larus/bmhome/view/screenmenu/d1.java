package com.larus.bmhome.view.screenmenu;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes26.dex */
public final class d1 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f317271a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ScreenMenuLayout f317272b;

    public d1(ScreenMenuLayout r100, ScreenMenuLayout r101) {
        this.f317271a = r100;
        this.f317272b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ScreenMenuLayout.a(this.f317272b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
