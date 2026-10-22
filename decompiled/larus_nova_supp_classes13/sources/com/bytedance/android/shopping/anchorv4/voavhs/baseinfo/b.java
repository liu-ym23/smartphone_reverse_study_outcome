package com.bytedance.android.shopping.anchorv4.voavhs.baseinfo;

import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ AnchorV4ActivityLayout.a a;
    public final /* synthetic */ Bitmap b;

    public b(AnchorV4ActivityLayout.a r1, Bitmap r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.a.a.a(2131362186).setBackground(new BitmapDrawable(this.a.a.getContext().getResources(), this.b));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
