package com.larus.voicecall.impl.util;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowInsetsController;
import androidx.fragment.app.FragmentActivity;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes32.dex */
public final class y0 {
    public static final void a(FragmentActivity r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "<this>");
        Window r102 = r100.getWindow();
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 33) goto L11;
        WindowInsetsController r104 = r102.getInsetsController();
        if (r104 != null) goto L7;
        return;
    L7:
        if (r101 == false) goto L9;
        r104.setSystemBarsAppearance(8, 8);
        return;
    L9:
        r104.setSystemBarsAppearance(0, 8);
        return;
    L11:
        if (r103 < 23) goto L26;
        View r105 = r102.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L17;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r106 = ThreadMethodProxy.currentThread();
        if (r106 == com.larus.home.impl.utils.c.f346341a) goto L17;
        com.larus.home.impl.utils.c.a(r106, "getDecorView");
    L17:
        int r107 = r105.getSystemUiVisibility();
        if (r101 == false) goto L20;
        int r108 = r107 | 8192;
    L21:
        r105.setSystemUiVisibility(r108);
        return;
    L20:
        r108 = r107 & (-8193);
        goto L21
    }
}
