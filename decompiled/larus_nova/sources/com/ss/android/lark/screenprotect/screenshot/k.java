package com.ss.android.lark.screenprotect.screenshot;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.view.View;
import com.larksuite.framework.callback.IGetDataCallback;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ View f439826a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ IGetDataCallback<Bitmap> f439827b;

    public k(View r100, ShareScreenshotPlugin$shareScreenshot$1$1 r101) {
        this.f439826a = r100;
        this.f439827b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        Bitmap r100 = Bitmap.createBitmap(this.f439826a.getWidth(), this.f439826a.getHeight(), Bitmap.Config.ARGB_8888);     // Catch: Throwable -> L4
        Canvas r101 = new Canvas(r100);     // Catch: Throwable -> L4
        this.f439826a.draw(r101);     // Catch: Throwable -> L4
        r101.setBitmap(null);     // Catch: Throwable -> L4
        this.f439827b.onSuccess(r100);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
