package com.bytedance.ee.bear.middleground.comment.detail;

import android.view.View;
import com.bytedance.ee.util.ui.k;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes18.dex */
public final class b implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ c f231261a;

    public b(c r100) {
        this.f231261a = r100;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r100 = this.f231261a.f231271i;     // Catch: Throwable -> L10
        if (r100 == null) goto L13;
        int[] r101 = new int[2];     // Catch: Throwable -> L10
        r100.getLocationOnScreen(r101);     // Catch: Throwable -> L10
        if (r101[1] != 0) goto L7;
        int r102 = k.e(r100.getContext());     // Catch: Throwable -> L10
    L8:
        r100.setPadding(0, r102, 0, this.f231261a.f231278p);     // Catch: Throwable -> L10
        return;
    L7:
        r102 = 0;
        goto L8
    L13:
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L17;
        throw th;
    }
}
