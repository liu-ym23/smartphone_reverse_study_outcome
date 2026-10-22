package com.bytedance.sysoptimizer.javahook;

import android.content.Context;
import android.content.ContextWrapper;
import android.os.Looper;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyDecorView {
    private static final String TAG = "ProxyDecorView";

    private static ViewGroup asDecorView(Object r100) {
        return (ViewGroup) r100;
    }

    public ProxyDecorView(Context r100, int r101, Object r102, WindowManager.LayoutParams r103) throws Throwable {
        int r104 = 0;
        AHook.callOrigin(OriginMethodKey.KEY_DecorView_INIT, this, new Object[]{r100, Integer.valueOf(r101), r102, r103});
        String r105 = "ProxyDecorView() called with: context = [" + r100 + "], featureId = [" + r101 + "], window = [" + r102 + "], params = [" + r103 + "], this = [" + this + "]";
    L4:
        if ((r100 instanceof ContextWrapper) == false) goto L6;
        r105 = r105 + ", ContextWrapper" + r104 + " = " + r100;
        r100 = ((ContextWrapper) r100).getBaseContext();
        r104 = r104 + 1;
        goto L4
    L6:
        AHook.getCallback().e(TAG, (r105 + ", decorView.getContext = " + asDecorView(this).getContext()) + ", window.getContext = " + ((Window) r102).getContext(), new Throwable());
        ThreadMethodProxy.getLooperThread(Looper.getMainLooper());
        ThreadMethodProxy.currentThread();
    }
}
