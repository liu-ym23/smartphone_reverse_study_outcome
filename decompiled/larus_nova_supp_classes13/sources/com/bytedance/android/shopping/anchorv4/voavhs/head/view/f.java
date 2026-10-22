package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.graphics.Bitmap;
import android.view.View;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Runnable {
    public final /* synthetic */ AnchorV4FeaturedShowView a;

    public f(AnchorV4FeaturedShowView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = new SimpleDraweeView(this.a.getContext());     // Catch: Throwable -> L4
        this.a.addView(r0, -1, -1);     // Catch: Throwable -> L4
        this.a.buildDrawingCache();     // Catch: Throwable -> L4
        r0.setImageBitmap(Bitmap.createBitmap(this.a.getDrawingCache()));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
