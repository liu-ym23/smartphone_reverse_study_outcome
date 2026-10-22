package com.ss.android.lark.screenprotect.screenshot;

import android.animation.AnimatorSet;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class h implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ScreenshotPreviewActivity f439822a;

    public h(ScreenshotPreviewActivity r100) {
        this.f439822a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        AnimatorSet r100 = this.f439822a.f439800a;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.start();     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
