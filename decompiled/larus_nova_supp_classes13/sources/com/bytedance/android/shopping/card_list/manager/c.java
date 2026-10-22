package com.bytedance.android.shopping.card_list.manager;

import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import android.view.ViewTreeObserver;
import com.bytedance.android.ec.core.monitor.ECExceptionMonitor;
import com.bytedance.android.ec.core.utils.k1;
import com.bytedance.android.ec.sdk.helper.ECAppInfoService;
import com.bytedance.android.shopping.card_list.widgets.CardListRootFrameLayoutContainer;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class c {
    public static final /* synthetic */ int k = 0;
    public final View a;
    public int b;
    public int c;
    public final int d;
    public final b e;
    public final View f;
    public final View g;
    public ViewTreeObserver h;
    public final com.bytedance.android.shopping.card_list.manager.a i;
    public final int j;

    public static final class a {
    }

    static {
    }

    public static final void a(c r5, Boolean r6) {
        r5.getClass();
        Rect r0 = new Rect();
        View r1 = r5.a;
        if (r1 == null) goto L5;
        r1.getWindowVisibleDisplayFrame(r0);
    L5:
        int r2 = r0.bottom - r0.top;
        if (r2 == r5.b) goto L37;
        View r3 = r5.a;
        if (r3 == null) goto L12;
        View r4 = r3.getRootView();
        if (r4 == null) goto L12;
        int r7 = r4.getHeight();
    L13:
        int r8 = r7 - r2;
        if (r8 > (r7 / 4)) goto L16;
        View r9 = r5.a;
        if (r9 == null) goto L29;
        r9.setPadding(0, 0, 0, 0);
    L29:
        com.bytedance.android.shopping.card_list.manager.a r10 = r5.i;
        if (r10 == null) goto L32;
        r10.a();
    L32:
        View r11 = r5.a;
        if (r11 == null) goto L35;
        r11.requestLayout();
    L35:
        r5.b = r2;
        return;
    L16:
        if (Intrinsics.areEqual(r6, Boolean.TRUE) == false) goto L20;
        View r12 = r5.a;
        if (r12 == null) goto L23;
        r12.setPadding(0, 0, 0, RangesKt.coerceAtLeast(0, (r5.c - ((r7 - r8) + r5.d)) - r5.j));
    L23:
        com.bytedance.android.shopping.card_list.manager.a r13 = r5.i;
        if (r13 == null) goto L32;
        r13.z();
        goto L32
    L20:
        View r14 = r5.a;
        if (r14 == null) goto L23;
        r14.setPadding(0, 0, 0, 0);
    L12:
        r7 = 0;
        goto L13
    }

    /* JADX WARN: Multi-variable type inference failed */
    public c(CardListRootFrameLayoutContainer r3, KeyboardManager r4, Boolean r5, int r6) {
        this.i = r4;
        this.j = r6;
        this.d = k1.p();
    L16:
        th = move-exception;
        if (ECAppInfoService.e.i() == true) goto L21;
        ECExceptionMonitor.e(th);
        return;
    L21:
        throw th;
    L4:
        if ((r3 instanceof ViewGroup) == false) goto L14;
        this.a = r3.getChildAt(0);     // Catch: Throwable -> L16
        View r7 = r3.findViewById(2131372736);     // Catch: Throwable -> L16
        this.f = r7;     // Catch: Throwable -> L16
        View r1 = r3.findViewById(2131372735);     // Catch: Throwable -> L16
        this.g = r1;     // Catch: Throwable -> L16
        ViewParent r8 = r3.getParent();     // Catch: Throwable -> L16
        if (r7 == null) goto L8;
    L10:
        if (r1 != null) goto L14;
        if ((r8 instanceof ViewGroup) == false) goto L14;
        this.g = ((ViewGroup) r8).findViewById(2131372735);     // Catch: Throwable -> L16
        goto L14
    L8:
        if ((r8 instanceof ViewGroup) == false) goto L10;
        this.f = ((ViewGroup) r8).findViewById(2131372736);     // Catch: Throwable -> L16
    L14:
        this.e = new b(this, r5);     // Catch: Throwable -> L16
    }
}
