package com.bytedance.ee.bear.bizwidget.dialogfragment.forseticompat;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.lynx.serval.svg.SVGRenderEngine;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes16.dex */
public final class m {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f216475a = 0;

    static {
    }

    public static Rect b(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        int[] r101 = new int[2];     // Catch: Exception -> L5
        r100.getLocationOnScreen(r101);     // Catch: Exception -> L5
        Rect r102 = new Rect();     // Catch: Exception -> L5
        int r103 = r101[0];     // Catch: Exception -> L5
        r102.left = r103;     // Catch: Exception -> L5
        r102.top = r101[1];     // Catch: Exception -> L5
        r102.right = r103 + r100.getWidth();     // Catch: Exception -> L5
        r102.bottom = r102.top + r100.getHeight();     // Catch: Exception -> L5
        tt5.a.b("ForsetiPopPositionCalculator", "View location: " + r102);     // Catch: Exception -> L5
        return r102;
    L5:
        e = move-exception;
        tt5.a.e("ForsetiPopPositionCalculator", "Error getting view location " + r100, e, false);
        return new Rect();
    }

    @JvmStatic
    public static final dib.a a(Activity r100, Rect r101, int r110, int r111) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        Intrinsics.checkNotNullParameter(r101, SVGRenderEngine.RECT);
        Window r102 = r100.getWindow();
        if (r102 == null) goto L12;
        View r103 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r104 = ThreadMethodProxy.currentThread();
        if (r104 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r104, "getDecorView");
    L9:
        if (r103 == null) goto L12;
        Pair r105 = TuplesKt.to(Integer.valueOf(r103.getWidth()), Integer.valueOf(r103.getHeight()));
        if (r105 == null) goto L12;
    L13:
        int r106 = ((Number) r105.component1()).intValue();
        int r107 = ((Number) r105.component2()).intValue();
        return eib.a.a(r100, new vua.a(r101, r110, r111, true), r110, r111, r106, r107);
    L12:
        r105 = TuplesKt.to(-1, -1);
        goto L13
    }
}
