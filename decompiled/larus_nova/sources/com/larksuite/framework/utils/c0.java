package com.larksuite.framework.utils;

import android.view.PixelCopy;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes24.dex */
public final class c0 implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ PixelCopy.OnPixelCopyFinishedListener f285949a;

    public c0(d0.a r100) {
        this.f285949a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f285949a.onPixelCopyFinished(1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
