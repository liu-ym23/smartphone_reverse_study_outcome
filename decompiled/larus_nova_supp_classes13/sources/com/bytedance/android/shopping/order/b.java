package com.bytedance.android.shopping.order;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import com.bytedance.common.utility.UIUtils;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b implements Runnable {
    public final /* synthetic */ Context a;
    public final /* synthetic */ View b;

    public b(Context r1, View r2) {
        this.a = r1;
        this.b = r2;
    }

    @Override // java.lang.Runnable
    public final void run() {
        float r0 = UIUtils.dip2Px(this.a, 295.0f);     // Catch: Throwable -> L10
        View r1 = this.b;     // Catch: Throwable -> L10
        ViewGroup.LayoutParams r2 = r1.getLayoutParams();     // Catch: Throwable -> L10
        FrameLayout.LayoutParams r4 = null;
        if ((r2 instanceof FrameLayout.LayoutParams) == true) goto L5;
        r2 = null;
    L5:
        FrameLayout.LayoutParams r3 = (FrameLayout.LayoutParams) r2;     // Catch: Throwable -> L10
        if (r3 == null) goto L8;
        r3.width = (int) r0;     // Catch: Throwable -> L10
        r3.height = (int) (r0 * 1.7777778f);     // Catch: Throwable -> L10
        r3.gravity = 16;     // Catch: Throwable -> L10
        Unit r5 = Unit.INSTANCE;     // Catch: Throwable -> L10
        r4 = r3;
    L8:
        r1.setLayoutParams(r4);     // Catch: Throwable -> L10
        return;
    L10:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L14;
        return;
    L14:
        throw th;
    }
}
