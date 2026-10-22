package com.bytedance.android.shopping.new_cart.widgets;

import android.view.View;
import com.bytedance.android.ui.ec.widget.photodraweeview.ExtensionsKt;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class h implements Runnable {
    public final /* synthetic */ ECCartLoadingView a;
    public final /* synthetic */ String b;

    public h(ECCartLoadingView r1, String r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        dm.a.a("ECCartLoadingView").i("stopLoading scene:" + this.b + ", stopped loading");
        ECCartLoadingView r0 = this.a;
        int r1 = ECCartLoadingView.l;
        r0.U5();
        ECCartLoadingView.R5(this.a).stopAnimate();
        ExtensionsKt.gone(ECCartLoadingView.R5(this.a));
        ExtensionsKt.gone(ECCartLoadingView.S5(this.a));
        ExtensionsKt.gone(ECCartLoadingView.T5(this.a));
        this.a.setVisibility(8);
        View r2 = this.a.k;
        if (r2 == null) goto L5;
        r2.setTranslationX(0.0f);
    L5:
        this.a.k = null;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
