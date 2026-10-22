package com.bytedance.android.shopping.anchorv4.voavhs.base.extensions;

import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import com.larus.apm.impl.protector.RunnableProtector;
import java.lang.ref.WeakReference;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ ExtensionsKt.a a;
    public final /* synthetic */ Bitmap b;

    public a(ExtensionsKt.a r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        Drawable r0 = ExtensionsKt.h(this.b, this.a.a.getContext(), this.a.b.getMaskColor());
        if (r0 == null) goto L5;
        this.a.a.setBackground(r0);
    L5:
        ExtensionsKt.a.put(this.a.c, new WeakReference(this.b));
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
