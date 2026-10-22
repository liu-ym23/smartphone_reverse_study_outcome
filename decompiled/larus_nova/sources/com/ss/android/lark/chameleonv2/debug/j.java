package com.ss.android.lark.chameleonv2.debug;

import android.animation.ValueAnimator;
import android.app.Dialog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.chameleonv2.debug.ui.LoadingView;

/* JADX INFO: loaded from: classes35.dex */
public final class j implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ f f411393a;

    public j(f r100) {
        this.f411393a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        w0b.a r100 = this.f411393a.f411385a;     // Catch: Throwable -> L22
        if (r100 != null) goto L29;
    L20:
        this.f411393a.f411385a = null;     // Catch: Throwable -> L22
        return;
    L29:
    L12:
        e = move-exception;
        com.ss.android.lark.officesdk.utils.di.j.c("LoadingDialog", "Error closing dialog", e);     // Catch: Throwable -> L22
        goto L20
    L6:
        if (r100.f557831e == false) goto L20;
        LoadingView r101 = r100.f557828b;     // Catch: Exception -> L12 Throwable -> L22
        if (r101 == null) goto L14;
        ValueAnimator r102 = r101.f411421g;     // Catch: Exception -> L12 Throwable -> L22
        if (r102 == null) goto L14;
        r101.clearAnimation();     // Catch: Exception -> L12 Throwable -> L22
        r102.setRepeatCount(1);     // Catch: Exception -> L12 Throwable -> L22
        r102.cancel();     // Catch: Exception -> L12 Throwable -> L22
        r102.end();     // Catch: Exception -> L12 Throwable -> L22
    L14:
        Dialog r103 = r100.f557830d;     // Catch: Exception -> L12 Throwable -> L22
        if (r103 == null) goto L17;
        w0b.a.a(r103);     // Catch: Exception -> L12 Throwable -> L22
    L17:
        r100.f557830d = null;     // Catch: Exception -> L12 Throwable -> L22
        r100.f557831e = false;     // Catch: Exception -> L12 Throwable -> L22
    L22:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L26;
        return;
    L26:
        throw th;
    }
}
