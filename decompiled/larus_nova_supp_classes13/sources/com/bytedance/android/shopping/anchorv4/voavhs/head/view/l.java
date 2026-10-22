package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class l implements Runnable {
    public final /* synthetic */ AnchorV4SizeView a;

    public l(AnchorV4SizeView r1) {
        this.a = r1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeView r0 = this.a.a;     // Catch: Throwable -> L7
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L7
        if (r1 == null) goto L6;
        FrameLayout.LayoutParams r2 = (FrameLayout.LayoutParams) r1;     // Catch: Throwable -> L7
        r2.gravity = 16;     // Catch: Throwable -> L7
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L7
        r0.setLayoutParams(r2);     // Catch: Throwable -> L7
        return;
    L6:
        throw new NullPointerException("null cannot be cast to non-null type android.widget.FrameLayout.LayoutParams");     // Catch: Throwable -> L7
    L7:
        th = move-exception;
        if (RunnableProtector.intercept(th) == true) goto L13;
        throw th;
    }
}
