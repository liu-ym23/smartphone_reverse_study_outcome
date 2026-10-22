package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class p2 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ ECShopTopBarBackPresenterV2 b;

    public p2(View r1, ECShopTopBarBackPresenterV2 r2) {
        this.a = r1;
        this.b = r2;
    }

    public final void a() {
        ECShopTopBarBackPresenterV2 r0 = this.b;
        View r1 = this.a;
        r0.getClass();
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();
        if ((r2 instanceof RelativeLayout.LayoutParams) == true) goto L5;
        r2 = null;
    L5:
        RelativeLayout.LayoutParams r3 = (RelativeLayout.LayoutParams) r2;
        if (r3 == null) goto L10;
        r3.leftMargin = com.bytedance.android.shopping.extensions.b.b(72);
        r3.rightMargin = 0;
        r3.setMarginStart(com.bytedance.android.shopping.extensions.b.b(72));
        r3.setMarginEnd(0);
        r3.removeRule(0);
        r3.removeRule(1);
        r3.removeRule(16);
        r3.removeRule(17);
        r3.addRule(16, 2131371037);
        r1.setLayoutParams(r3);
        return;
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
