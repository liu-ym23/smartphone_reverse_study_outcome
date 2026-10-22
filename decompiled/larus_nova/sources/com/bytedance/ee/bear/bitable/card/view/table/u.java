package com.bytedance.ee.bear.bitable.card.view.table;

import android.graphics.drawable.Drawable;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes15.dex */
public final class u implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ ImageView f208915a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ Drawable f208916b;

    public u(ImageView r100, Drawable r101) {
        this.f208915a = r100;
        this.f208916b = r101;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.f208915a.setBackground(this.f208916b);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
