package com.bytedance.android.livesdk.livecommerce.utils;

import android.graphics.Rect;
import android.view.TouchDelegate;
import android.view.View;
import com.bytedance.android.livesdk.livecommerce.iron.widgets.IronPromotionListTopCategoryWidget$createExpandView$view$1;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class j implements Runnable {
    public final /* synthetic */ View a;
    public final /* synthetic */ int b;
    public final /* synthetic */ int c;
    public final /* synthetic */ int d;
    public final /* synthetic */ int e;

    public final void a() {
        Rect r0 = new Rect();
        this.a.getHitRect(r0);
        r0.top += this.b;
        r0.bottom += this.c;
        r0.left += this.d;
        r0.right += this.e;
        TouchDelegate r1 = new TouchDelegate(r0, this.a);
        if ((this.a.getParent() instanceof View) == false) goto L6;
        ((View) this.a.getParent()).setTouchDelegate(r1);
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

    public j(IronPromotionListTopCategoryWidget$createExpandView$view$1 r1, int r2, int r3) {
        this.a = r1;
        this.b = 0;
        this.c = 0;
        this.d = r2;
        this.e = r3;
    }
}
