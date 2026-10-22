package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class k implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ String c;
    public final /* synthetic */ Exception d;

    public k(i r1, AppCompatImageView r2, String r3, Exception r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.b(this.b, this.c, this.d);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
