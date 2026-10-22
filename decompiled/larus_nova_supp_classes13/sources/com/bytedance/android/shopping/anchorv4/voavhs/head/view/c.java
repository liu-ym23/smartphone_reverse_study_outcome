package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c implements Runnable {
    public final /* synthetic */ AnchorV4FeaturedCommentView a;

    public c(AnchorV4FeaturedCommentView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.getRootView().findViewById(2131372198);     // Catch: Throwable -> L9
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L9
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;     // Catch: Throwable -> L9
        if (r2 == null) goto L12;
        int r3 = r2.leftMargin;     // Catch: Throwable -> L9
        r2.bottomMargin = r3;     // Catch: Throwable -> L9
        r2.topMargin = r3;     // Catch: Throwable -> L9
        r0.setLayoutParams(r2);     // Catch: Throwable -> L9
        return;
    L12:
        return;
    L9:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L16;
        throw th;
    }
}
