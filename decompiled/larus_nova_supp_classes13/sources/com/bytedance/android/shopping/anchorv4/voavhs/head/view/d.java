package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.graphics.Bitmap;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class d implements Runnable {
    public final /* synthetic */ AnchorV4FeaturedCommentView a;

    public d(AnchorV4FeaturedCommentView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        ImageView r0 = new ImageView(this.a.getContext());     // Catch: Throwable -> L6
        this.a.addView(r0, -1, -1);     // Catch: Throwable -> L6
        this.a.buildDrawingCache();     // Catch: Throwable -> L6
        Bitmap r1 = this.a.getDrawingCache();     // Catch: Throwable -> L6
        if (r1 == null) goto L9;
        r0.setImageBitmap(Bitmap.createBitmap(r1));     // Catch: Throwable -> L6
        return;
    L9:
        return;
    L6:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
