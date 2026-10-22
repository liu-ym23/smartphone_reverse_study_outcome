package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class q2 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ ECShopTopBarBackPresenterV2 b;
    public final /* synthetic */ boolean c;

    public q2(View r1, ECShopTopBarBackPresenterV2 r2, boolean r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
    }

    public final void a() {
        ECShopTopBarBackPresenterV2 r0 = this.b;
        View r1 = this.a;
        boolean r2 = this.c;
        r0.getClass();
        ViewGroup.LayoutParams r3 = r1.getLayoutParams();
        if ((r3 instanceof RelativeLayout.LayoutParams) == true) goto L5;
        r3 = null;
    L5:
        RelativeLayout.LayoutParams r4 = (RelativeLayout.LayoutParams) r3;
        if (r4 == null) goto L17;
        if (r2 == false) goto L10;
        int r5 = 4;
    L11:
        int r6 = com.bytedance.android.shopping.extensions.b.b(Integer.valueOf(r5));
        r4.leftMargin = r6;
        r4.rightMargin = 0;
        r4.setMarginStart(r6);
        r4.setMarginEnd(0);
        r4.removeRule(20);
        r4.removeRule(0);
        r4.removeRule(1);
        r4.removeRule(16);
        r4.removeRule(17);
        if (r2 == false) goto L14;
        r4.addRule(17, 2131371036);
    L15:
        r4.addRule(16, 2131371125);
        r1.setLayoutParams(r4);
        return;
    L14:
        r4.addRule(20);
        goto L15
    L10:
        r5 = 12;
        goto L11
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
