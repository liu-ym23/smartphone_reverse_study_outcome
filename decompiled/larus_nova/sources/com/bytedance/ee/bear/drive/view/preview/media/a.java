package com.bytedance.ee.bear.drive.view.preview.media;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes16.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ DriveMediaVM.b f225077a;

    public a(DriveMediaVM.b r100) {
        this.f225077a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f225077a.f225071b.a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
