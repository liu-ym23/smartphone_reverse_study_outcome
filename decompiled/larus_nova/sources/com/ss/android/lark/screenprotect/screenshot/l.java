package com.ss.android.lark.screenprotect.screenshot;

import android.view.PixelCopy;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class l implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PixelCopy.OnPixelCopyFinishedListener f439828a;

    public l(j r100) {
        this.f439828a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f439828a.onPixelCopyFinished(1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
