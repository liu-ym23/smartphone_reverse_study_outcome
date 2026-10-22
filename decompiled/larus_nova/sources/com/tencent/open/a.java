package com.tencent.open;

import android.os.Build;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes29.dex */
public class a {
    public static View INVOKEVIRTUAL_com_tencent_open_a_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    public static void a(Window r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setFlags(1024, 1024);
        int r101 = Build.VERSION.SDK_INT;
        INVOKEVIRTUAL_com_tencent_open_a_com_larus_home_impl_utils_DecorViewLancet_getDecorView(r100).setSystemUiVisibility(1280);
        r100.addFlags(Integer.MIN_VALUE);
        if (r101 < 28) goto L8;
        WindowManager.LayoutParams r102 = r100.getAttributes();
        r102.layoutInDisplayCutoutMode = 1;
        r100.setAttributes(r102);
        return;
    }
}
