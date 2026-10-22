package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import android.view.ViewGroup;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m implements Runnable {
    public final /* synthetic */ AnchorV4SizeView a;
    public final /* synthetic */ float b;

    public m(AnchorV4SizeView r1, float r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        SimpleDraweeView r0 = this.a.a;     // Catch: Throwable -> L4
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L4
        float r2 = this.b;     // Catch: Throwable -> L4
        r1.width = (int) r2;     // Catch: Throwable -> L4
        r1.height = (int) (this.a.c * r2);     // Catch: Throwable -> L4
        Unit r3 = Unit.INSTANCE;     // Catch: Throwable -> L4
        r0.setLayoutParams(r1);     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
