package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class m implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ AppCompatImageView b;
    public final /* synthetic */ String c;
    public final /* synthetic */ j.a d;

    public m(c r1, AppCompatImageView r2, String r3, j.a r4) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        AppCompatImageView r1 = this.b;     // Catch: Throwable -> L6
        String r2 = this.c;     // Catch: Throwable -> L6
        j.a r3 = this.d;     // Catch: Throwable -> L6
        r0.a(r1, r2, r3.a, r3.c);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
