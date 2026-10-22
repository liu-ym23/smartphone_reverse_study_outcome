package com.bytedance.android.shopping.extensions;

import android.os.Build;
import android.view.View;
import android.view.Window;
import com.bytedance.android.shopping.anchorv3.utils.b0;
import com.bytedance.common.utility.DeviceUtils;
import com.gyf.barlibrary.FlymeOSStatusBarFontUtils;
import com.gyf.barlibrary.OSUtils;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class m {
    public static final void a(Window r4, boolean r5) {
        int r0 = b0.a;
        Intrinsics.checkNotNullParameter(r4, "window");
        if (Build.VERSION.SDK_INT < 23) goto L15;
        View r1 = r4.getDecorView();
        if (com.larus.home.impl.utils.c.e == false) goto L9;
        FLogger.a.i("DecorViewLancet", "getDecorView");
        Thread r2 = ThreadMethodProxy.currentThread();
        if (r2 == com.larus.home.impl.utils.c.a) goto L9;
        com.larus.home.impl.utils.c.a(r2, "getDecorView");
    L9:
        int r3 = r1.getSystemUiVisibility();
        if (r5 == false) goto L12;
        int r6 = r3 | 8192;
    L13:
        r1.setSystemUiVisibility(r6);
        goto L15
    L12:
        r6 = r3 & (-8193);
    L15:
        if (OSUtils.isMIUI6Later() == false) goto L18;
        DeviceUtils.setMiuiStatusBarDarkMode(r5, r4);
    L18:
        if (OSUtils.isFlymeOS4Later() == false) goto L21;
        FlymeOSStatusBarFontUtils.setStatusBarDarkIcon(r4, r5);
        return;
    }
}
