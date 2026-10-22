package com.bytedance.sysoptimizer.javahook;

import android.hardware.display.DisplayManager;
import android.os.Handler;
import android.os.Looper;
import com.bytedance.sysoptimizer.perflock.DoubleReflectUtils;
import java.util.concurrent.Executor;

/* JADX INFO: loaded from: classes22.dex */
public class ProxyDisplayListenerDelegate {
    private static final String TAG = "ProxyDisplayListenerDelegate";

    public ProxyDisplayListenerDelegate(DisplayManager.DisplayListener r100, Looper r101) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_DISPLAYLISTENERDELEGATE_INIT_1, this, new Object[]{r100, r101});
        Throwable r102 = new Throwable();
        AHook.getCallback().e(TAG, "ProxyDisplayListenerDelegate() called with: listener = [" + r100 + "], looper = [" + r101 + "]", r102);
        if (r101 != null) goto L5;
        return;
    L5:
        if (Looper.getMainLooper() != r101) goto L8;
        return;
    L8:
        throw new IllegalStateException();
    }

    public ProxyDisplayListenerDelegate(DisplayManager.DisplayListener r100, Executor r101, long r102) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_DISPLAYLISTENERDELEGATE_INIT_2, this, new Object[]{r100, r101, Long.valueOf(r102)});
        Throwable r103 = new Throwable();
        AHook.getCallback().e(TAG, "ProxyDisplayListenerDelegate() called with: listener = [" + r100 + "], executor = [" + r101 + "], eventsMask = [" + r102 + "]", r103);
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.getClass().getName().equals("android.os.HandlerExecutor") == false) goto L14;
        Object r104 = DoubleReflectUtils.readField(r101, "mHandler");
        if (r104 != null) goto L9;
        return;
    L9:
        if (((Handler) r104).getLooper() != Looper.getMainLooper()) goto L12;
        return;
    L12:
        throw new IllegalStateException();
    }

    public ProxyDisplayListenerDelegate(DisplayManager.DisplayListener r100, Looper r101, long r102) throws Throwable {
        AHook.callOrigin(OriginMethodKey.KEY_DISPLAYLISTENERDELEGATE_INIT, this, new Object[]{r100, r101, Long.valueOf(r102)});
        Throwable r103 = new Throwable();
        AHook.getCallback().e(TAG, "ProxyDisplayListenerDelegate() called with: listener = [" + r100 + "], looper = [" + r101 + "], eventsMask = [" + r102 + "]", r103);
        if (r101 != null) goto L5;
        return;
    L5:
        if (Looper.getMainLooper() != r101) goto L8;
        return;
    L8:
        throw new IllegalStateException();
    }
}
