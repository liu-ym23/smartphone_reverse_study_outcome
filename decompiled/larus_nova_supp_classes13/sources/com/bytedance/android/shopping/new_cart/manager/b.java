package com.bytedance.android.shopping.new_cart.manager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class b {
    public final View a;
    public int b;
    public int c;
    public final int d;
    public final a e;
    public final com.bytedance.android.shopping.new_cart.manager.a f;
    public final int g;
    public final View h;
    public final View i;

    public interface a {
        void a();

        void z();
    }

    public final void a(Boolean r6) {
        Rect r0 = new Rect();
        this.a.getWindowVisibleDisplayFrame(r0);
        int r1 = r0.bottom - r0.top;
        if (r1 == this.b) goto L18;
        int r2 = this.a.getRootView().getHeight();
        int r3 = r2 - r1;
        if (r3 > (r2 / 4)) goto L7;
        this.a.setPadding(0, 0, 0, 0);
        a r7 = this.e;
        if (r7 == null) goto L16;
        r7.a();
    L16:
        this.a.requestLayout();
        this.b = r1;
        return;
    L7:
        if (r6.booleanValue() == false) goto L9;
        this.a.setPadding(0, 0, 0, Math.max(0, (this.c - ((r2 - r3) + this.d)) - this.g));
    L10:
        a r8 = this.e;
        if (r8 == null) goto L16;
        r8.z();
        goto L16
    L9:
        this.a.setPadding(0, 0, 0, 0);
        goto L10
    }

    /* JADX WARN: Type inference failed for: r4v2, types: [com.bytedance.android.shopping.new_cart.manager.a] */
    public b(View r4, c r5, final Boolean r6, int r7) {
        this.e = null;
        this.g = 0;
        this.g = r7;     // Catch: Throwable -> L18
        this.e = r5;     // Catch: Throwable -> L18
        this.d = k1.p();     // Catch: Throwable -> L18
        if ((r4 instanceof ViewGroup) == false) goto L14;
        this.a = ((ViewGroup) r4).getChildAt(0);     // Catch: Throwable -> L18
        View r8 = r4.findViewById(2131372736);     // Catch: Throwable -> L18
        this.h = r8;     // Catch: Throwable -> L18
        View r1 = r4.findViewById(2131372735);     // Catch: Throwable -> L18
        this.i = r1;     // Catch: Throwable -> L18
        ViewParent r2 = r4.getParent();     // Catch: Throwable -> L18
        if (r8 == null) goto L8;
    L10:
        if (r1 != null) goto L14;
        if ((r2 instanceof ViewGroup) == false) goto L14;
        this.i = ((ViewGroup) r2).findViewById(2131372735);     // Catch: Throwable -> L18
        goto L14
    L8:
        if ((r2 instanceof ViewGroup) == false) goto L10;
        this.h = ((ViewGroup) r2).findViewById(2131372736);     // Catch: Throwable -> L18
    L14:
        if (r4 != null) goto L16;
        return;
    L16:
        this.f = new com.bytedance.android.shopping.new_cart.manager.a(this, r6);     // Catch: Throwable -> L18
        return;
    L18:
        th = move-exception;
        if (ECAppInfoService.e.i() == true) goto L23;
        ECExceptionMonitor.e(th);
        return;
    L23:
        throw th;
    }
}
