package com.ss.android.bytedcert.face.ui;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes34.dex */
public final class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ FaceDetectFullActivity.f f407507a;

    @Override // java.lang.Runnable
    public final void run() {
        this.f407507a.f407501a.f407466d.requestLayout();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }

    public a(FaceDetectFullActivity.f r100) {
        this.f407507a = r100;
    }
}
