package com.ss.android.lark.widget.select;

import android.app.Activity;
import android.view.View;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes38.dex */
public final class f {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f448424a = 0;

    static {
    }

    public static int[] a(Activity r100) {
        if (r100 == null) goto L12;
        int[] r101 = new int[2];
        View r102 = r100.getWindow().getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r103 = ThreadMethodProxy.currentThread();
        if (r103 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r103, "getDecorView");
    L9:
        r102.getLocationOnScreen(r101);
        return r101;
    L12:
        return new int[]{0, 0};
    }
}
