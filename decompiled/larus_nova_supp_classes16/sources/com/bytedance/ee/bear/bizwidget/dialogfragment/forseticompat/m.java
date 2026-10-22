package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final class m {
    public static final /* synthetic */ int a = 0;

    static {
    }

    public static Rect b(View r7) {
        Intrinsics.checkNotNullParameter(r7, "view");
        int[] r2 = new int[2];     // Catch: Exception -> L5
        r7.getLocationOnScreen(r2);     // Catch: Exception -> L5
        Rect r4 = new Rect();     // Catch: Exception -> L5
        int r5 = r2[0];     // Catch: Exception -> L5
        r4.left = r5;     // Catch: Exception -> L5
        r4.top = r2[1];     // Catch: Exception -> L5
        r4.right = r5 + r7.getWidth();     // Catch: Exception -> L5
        r4.bottom = r4.top + r7.getHeight();     // Catch: Exception -> L5
        tt5.a.b("ForsetiPopPositionCalculator", "View location: " + r4);     // Catch: Exception -> L5
        return r4;
    L5:
        e = move-exception;
        tt5.a.e("ForsetiPopPositionCalculator", "Error getting view location " + r7, e, false);
        return new Rect();
    }

    @JvmStatic
    public static final dib.a a(Activity r8, Rect r9, int r10, int r11) {
        Intrinsics.checkNotNullParameter(r8, "activity");
        Intrinsics.checkNotNullParameter(r9, "rect");
        Window r0 = r8.getWindow();
        if (r0 == null) goto L12;
        View r1 = r0.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L9:
        if (r1 == null) goto L12;
        Pair r3 = TuplesKt.to(Integer.valueOf(r1.getWidth()), Integer.valueOf(r1.getHeight()));
        if (r3 == null) goto L12;
    L13:
        int r6 = ((Number) r3.component1()).intValue();
        int r7 = ((Number) r3.component2()).intValue();
        return eib.a.a(r8, new vua.a(r9, r10, r11, true), r10, r11, r6, r7);
    L12:
        r3 = TuplesKt.to(-1, -1);
        goto L13
    }
}
