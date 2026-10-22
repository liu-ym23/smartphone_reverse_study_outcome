package com.bytedance.android.shopping.utils.gallery;

import android.view.View;
import android.view.ViewGroup;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements Runnable {
    public final /* synthetic */ BannerAdapter a;
    public final /* synthetic */ View b;

    public a(BannerAdapter r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        View r0 = this.b;     // Catch: Throwable -> L4
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();     // Catch: Throwable -> L4
        r1.width = this.a.e;     // Catch: Throwable -> L4
        Unit r2 = Unit.INSTANCE;     // Catch: Throwable -> L4
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
