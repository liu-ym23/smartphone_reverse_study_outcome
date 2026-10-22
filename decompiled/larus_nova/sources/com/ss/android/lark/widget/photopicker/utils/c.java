package com.ss.android.lark.widget.photopicker.utils;

import com.larus.apm.impl.protector.RunnableProtector;
import com.ss.android.lark.log.Log;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ Runnable f447649a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ d f447650b;

    @Override // java.lang.Runnable
    public final void run() {
        d r100 = this.f447650b;     // Catch: Throwable -> L7
        if (r100.f447652b == false) goto L5;
        Log.d("DelayShower", "not need show");     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        r100.f447651a = System.currentTimeMillis();     // Catch: Throwable -> L7
        this.f447649a.run();     // Catch: Throwable -> L7
        this.f447650b.f447652b = true;     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    }

    public c(d r100, com.ss.android.lark.widget.photo.preview.video.cover.m.a r101) {
        this.f447650b = r100;
        this.f447649a = r101;
    }
}
