package com.bytedance.sysoptimizer;

import android.app.Activity;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import me.ele.lancet.base.Origin;
import me.ele.lancet.base.This;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes22.dex */
@Skip({"-com.bytedance.pagex.dispatch.PageHostActivity", "com.bytedance.thanos+"})
public class EnterTransitionLancet {
    public EnterTransitionLancet() {
    }

    public void onStop() {
        Origin.callVoid();
        if (EnterTransitionCrashOptimizer.getContext() != null) goto L8;
        return;
    L8:
        INVOKEVIRTUAL_com_bytedance_sysoptimizer_EnterTransitionLancet_com_larus_home_impl_utils_DecorViewLancet_getDecorView(((Activity) This.get()).getWindow()).getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L7
        return;
    }

    public static View INVOKEVIRTUAL_com_bytedance_sysoptimizer_EnterTransitionLancet_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }
}
