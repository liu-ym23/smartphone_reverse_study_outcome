package com.ss.android.lark.widget.photopicker.utils;

import android.app.Activity;
import android.graphics.Rect;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class f {
    static {
    }

    @JvmStatic
    public static final boolean a(Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        View r101 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        Rect r103 = new Rect();
        r101.getWindowVisibleDisplayFrame(r103);
        int r104 = r101.getRootView().getHeight();
        if ((r104 - r103.bottom) <= (((double) r104) * 0.15d)) goto L10;
        return true;
    L10:
        return false;
    }
}
