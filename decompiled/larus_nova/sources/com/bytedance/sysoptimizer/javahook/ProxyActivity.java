package com.bytedance.sysoptimizer.javahook;

import android.app.Activity;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyActivity {
    private static final String TAG = "ProxyActivity";

    public ProxyActivity() {
    }

    public static View INVOKEVIRTUAL_com_bytedance_sysoptimizer_javahook_ProxyActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(Window r100) {
        View r101 = r100.getDecorView();
        if (com.larus.home.impl.utils.c.f346345e == false) goto L7;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");
        Thread r102 = ThreadMethodProxy.currentThread();
        if (r102 == com.larus.home.impl.utils.c.f346341a) goto L7;
        com.larus.home.impl.utils.c.a(r102, "getDecorView");
    L7:
        return r101;
    }

    private static Activity toActivity(Object r100) {
        return (Activity) r100;
    }

    public void setTheme(int r100) throws Throwable {
        AHook.getCallback().e(TAG, this + " before setTheme() called with: resid = [" + r100 + "]", new Throwable());
        AHook.callOrigin(OriginMethodKey.KEY_Activity_setTheme, this, new Object[]{Integer.valueOf(r100)});
        AHook.getCallback().e(TAG, this + " after setTheme() called with: resid = [" + r100 + "]", new Throwable());
        if (ThreadMethodProxy.getLooperThread(Looper.getMainLooper()) != ThreadMethodProxy.currentThread()) goto L6;
        INVOKEVIRTUAL_com_bytedance_sysoptimizer_javahook_ProxyActivity_com_larus_home_impl_utils_DecorViewLancet_getDecorView(toActivity(this).getWindow());
        return;
    }
}
