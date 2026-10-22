package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class j implements Runnable {
    public final /* synthetic */ AnchorV4SizeView a;
    public final /* synthetic */ int b;
    public final /* synthetic */ float c;

    public j(AnchorV4SizeView r1, int r2, float r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeView r0 = this.a.a;     // Catch: Throwable -> L4
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L4
        int r2 = this.b;     // Catch: Throwable -> L4
        r1.width = r2;     // Catch: Throwable -> L4
        r1.height = (int) (r2 * this.c);     // Catch: Throwable -> L4
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r0.setLayoutParams(r1);     // Catch: Throwable -> L4
        this.a.a.setVisibility(0);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
