package com.bytedance.ee.bear.document.sharewords.view;

import android.graphics.Bitmap;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class o implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ n f221858a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Bitmap f221859b;

    public o(n r100, Bitmap r101) {
        this.f221858a = r100;
        this.f221859b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f221858a.a(this.f221859b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
