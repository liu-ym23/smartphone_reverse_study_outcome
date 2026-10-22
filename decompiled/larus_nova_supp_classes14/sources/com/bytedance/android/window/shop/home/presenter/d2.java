package com.bytedance.android.window.shop.home.presenter;

import android.view.View;
import android.widget.ImageView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d2 implements Runnable {
    public final /* synthetic */ ECWindowTopInfoBarEnhancedPresenter.d a;

    public d2(ECWindowTopInfoBarEnhancedPresenter.d r1) {
        this.a = r1;
    }

    public final void a() {
        ECWindowTopInfoBarEnhancedPresenter r0 = this.a.a;
        ImageView r1 = r0.q;
        if (r1 != null) goto L5;
        Intrinsics.throwUninitializedPropertyAccessException("backBtn");
    L5:
        r0.x = ECWindowTopInfoBarEnhancedPresenter.a0(r1);
        ECWindowTopInfoBarEnhancedPresenter r2 = this.a.a;
        r2.z = ECWindowTopInfoBarEnhancedPresenter.a0(r2.b0());
        ECWindowTopInfoBarEnhancedPresenter r3 = this.a.a;
        View r4 = r3.p;
        if (r4 != null) goto L8;
        Intrinsics.throwUninitializedPropertyAccessException("windowInfoContainer");
    L8:
        r3.y = ECWindowTopInfoBarEnhancedPresenter.a0(r4);
        this.a.a.c0();
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
