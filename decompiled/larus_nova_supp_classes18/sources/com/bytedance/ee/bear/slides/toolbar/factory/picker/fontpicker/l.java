package com.bytedance.ee.bear.slides.toolbar.factory.picker.fontpicker;

import android.graphics.drawable.PictureDrawable;
import android.widget.ImageView;
import androidx.appcompat.widget.AppCompatImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class l implements Runnable {
    public final /* synthetic */ i a;
    public final /* synthetic */ ImageView b;
    public final /* synthetic */ String c;
    public final /* synthetic */ PictureDrawable d;
    public final /* synthetic */ h e;

    public l(i r1, AppCompatImageView r2, String r3, PictureDrawable r4, h r5) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
    }

    @Override // java.lang.Runnable
    public final void run() {
        i r0 = this.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        ImageView r1 = this.b;     // Catch: Throwable -> L6
        String r2 = this.c;     // Catch: Throwable -> L6
        PictureDrawable r3 = this.d;     // Catch: Throwable -> L6
        h r4 = this.e;     // Catch: Throwable -> L6
        float r5 = r4.a;     // Catch: Throwable -> L6
        r0.a(r1, r2, r3, r4.b);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
