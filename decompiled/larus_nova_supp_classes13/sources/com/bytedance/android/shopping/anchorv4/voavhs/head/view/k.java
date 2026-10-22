package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class k implements Runnable {
    public final /* synthetic */ AnchorV4SizeView a;
    public final /* synthetic */ int b;

    public k(AnchorV4SizeView r1, int r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.a.b;     // Catch: Throwable -> L4
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L4
        r1.height = (int) (((double) this.b) * 0.2d);     // Catch: Throwable -> L4
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r0.setLayoutParams(r1);     // Catch: Throwable -> L4
        this.a.b.setVisibility(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
