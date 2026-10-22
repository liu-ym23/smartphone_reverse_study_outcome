package com.ss.android.lark.widget.previewanimation.animation;

import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class c implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ a f448001a;

    public c(a r100) {
        this.f448001a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a r100 = this.f448001a;     // Catch: Throwable -> L9
        if (r100.f447993a.indexOfChild(r100) == (-1)) goto L5;
        boolean r101 = true;
    L6:
        if (r101 == false) goto L12;
        a r102 = this.f448001a;     // Catch: Throwable -> L9
        r102.f447993a.removeView(r102);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L5:
        r101 = false;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
