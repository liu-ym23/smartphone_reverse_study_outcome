package com.ss.android.lark.widget.photo.preview.image;

import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes38.dex */
public final class k implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ LargeImageFragment f446672a;

    public k(LargeImageFragment r100) {
        this.f446672a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f446672a.f446629f;     // Catch: Throwable -> L6
        if (r100 == null) goto L9;
        r100.setVisibility(0);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
