package com.bytedance.ee.bear.bitable.card.view.table;

import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class q implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ String f208896a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ ImageView f208897b;

    public q(String r100, ImageView r101) {
        this.f208896a = r100;
        this.f208897b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L15;
        throw th;
    L15:
        return;
    L3:
        if (ip4.s.d(this.f208896a) == false) goto L5;
        this.f208897b.setVisibility(0);     // Catch: Throwable -> L7
    L12:
        return;
    L5:
        this.f208897b.setVisibility(8);     // Catch: Throwable -> L7
        goto L12
    }
}
