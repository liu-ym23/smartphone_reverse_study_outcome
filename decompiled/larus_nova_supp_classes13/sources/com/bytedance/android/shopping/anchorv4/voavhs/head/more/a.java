package com.bytedance.android.shopping.anchorv4.voavhs.head.more;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ b a;
    public final /* synthetic */ Bitmap b;

    public a(b r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.b.setBackground(new BitmapDrawable(this.a.a.getContext().getResources(), this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
