package com.bytedance.android.shopping.store.home.presenter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.RelativeLayout;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class r2 implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ ECShopTopBarBackPresenterV2 b;
    public final /* synthetic */ boolean c;

    public r2(View r1, ECShopTopBarBackPresenterV2 r2, boolean r3) {
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
        View r4 = null;
        if ((r3 instanceof RelativeLayout.LayoutParams) == true) goto L5;
        r3 = null;
    L5:
        RelativeLayout.LayoutParams r5 = (RelativeLayout.LayoutParams) r3;
        if (r5 != null) goto L9;
        return;
    L9:
        if (r2 == false) goto L11;
        int r6 = 0;
    L12:
        r5.leftMargin = r6;
        r5.rightMargin = 0;
        r5.setMarginStart(r6);
        r5.setMarginEnd(0);
        r5.removeRule(0);
        r5.removeRule(1);
        r5.removeRule(16);
        r5.removeRule(17);
        if (r2 == false) goto L16;
        r5.addRule(17, 2131371036);
    L16:
        if ((r1 instanceof ViewGroup) == false) goto L19;
        r4 = r1;
    L19:
        ViewGroup r7 = (ViewGroup) r4;
        if (r7 == null) goto L22;
        r7.setClipChildren(true);
    L22:
        r1.setLayoutParams(r5);
        return;
    L11:
        r6 = com.bytedance.android.shopping.extensions.b.b(12);
        goto L12
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
