package com.bytedance.android.shopping.anchorv4.voavhs.headbottom;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class a implements Runnable {
    public final /* synthetic */ Bitmap a;
    public final /* synthetic */ HeadBottomAdapter.HeadBottomHolder b;

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r0 = this.b.a;     // Catch: Throwable -> L6
        if (r0 == null) goto L9;
        r0.setImageBitmap(this.a);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }

    public a(Bitmap r1, HeadBottomAdapter.HeadBottomHolder r2) {
        this.a = r1;
        this.b = r2;
    }
}
