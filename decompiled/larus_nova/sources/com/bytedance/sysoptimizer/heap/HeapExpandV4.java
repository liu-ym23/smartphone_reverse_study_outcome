package com.bytedance.sysoptimizer.heap;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public class HeapExpandV4 {
    private static final int SHADOWHOOK_ERRNO_OK = 0;
    private static final int SHADOWHOOK_ERRNO_UNINIT = 2;
    private static final String TAG = "HeapExpandV4";
    private static final AtomicBoolean mInitFlag = null;
    private static final AtomicBoolean mInitResult = null;

    public HeapExpandV4() {
    }

    private static native boolean applyNative(long r100);

    private static native boolean initNative();

    static {
        mInitFlag = new AtomicBoolean(false);
        mInitResult = new AtomicBoolean(false);
    }

    public static synchronized boolean apply(Context r100, long r101) {
        monitor-enter(HeapExpandV4.class);
    L45:
        th = move-exception;
        throw th;
    L6:
        if (Build.VERSION.SDK_INT >= 26) goto L10;
        monitor-exit(HeapExpandV4.class);
        return false;
    L10:
        if (Process.is64Bit() == true) goto L14;
        monitor-exit(HeapExpandV4.class);
        return false;
    L14:
        if (r101 <= 0) goto L16;
        AtomicBoolean r102 = mInitFlag;     // Catch: Throwable -> L45
        if (r102.get() == false) goto L24;
        boolean r103 = mInitResult.get();     // Catch: Throwable -> L45
        monitor-exit(HeapExpandV4.class);
        return r103;
    L24:
        r102.set(true);     // Catch: Throwable -> L45
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L41;
        ShadowHook.access$000();     // Catch: Throwable -> L43
        ShadowHook.access$100();     // Catch: Throwable -> L43
        int r104 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L43
        ShadowHook.b r105 = new ShadowHook.b();     // Catch: Throwable -> L43
        r105.f270294a = r104;     // Catch: Throwable -> L43
        r105.f270295b = true;     // Catch: Throwable -> L43
        r105.f270296c = false;     // Catch: Throwable -> L43
        r105.f270297d = false;     // Catch: Throwable -> L43
        if (ShadowHook.init(r105) != 0) goto L30;
        if (initNative() == true) goto L36;
        monitor-exit(HeapExpandV4.class);
        return false;
    L36:
        AtomicBoolean r106 = mInitResult;     // Catch: Throwable -> L39
        r106.set(applyNative(r101));     // Catch: Throwable -> L39
        boolean r107 = r106.get();     // Catch: Throwable -> L39
        monitor-exit(HeapExpandV4.class);
        return r107;
    L40:
        return false;
    L30:
        monitor-exit(HeapExpandV4.class);
        return false;
    L41:
        monitor-exit(HeapExpandV4.class);
        return false;
    L44:
        return false;
    L16:
        monitor-exit(HeapExpandV4.class);
        return false;
    }
}
