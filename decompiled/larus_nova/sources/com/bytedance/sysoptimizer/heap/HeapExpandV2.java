package com.bytedance.sysoptimizer.heap;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizerEarly;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public class HeapExpandV2 {
    private static final int SHADOWHOOK_ERRNO_OK = 0;
    private static final int SHADOWHOOK_ERRNO_UNINIT = 2;
    private static final String TAG = "HeapExpandV2";
    private static final AtomicBoolean mInitFlag = null;

    public HeapExpandV2() {
    }

    private static native boolean applyNative(long r100);

    private static native boolean initNative();

    private static native boolean is64BitNative();

    private static native boolean triggerCopyGcNative();

    static {
        mInitFlag = new AtomicBoolean(false);
    }

    public static boolean triggerCopyGc() {
        return triggerCopyGcNative();
    }

    public static synchronized boolean apply(Context r100, long r101) {
        monitor-enter(HeapExpandV2.class);
        if (r101 <= 0) goto L7;
        AtomicBoolean r102 = mInitFlag;     // Catch: Throwable -> L45
        if (r102.get() == false) goto L50;
        monitor-exit(HeapExpandV2.class);
        return true;
    L50:
        if (SysOptimizerEarly.loadOptimizerLibrary(r100) == false) goto L41;
        ShadowHook.access$000();     // Catch: Throwable -> L43
        ShadowHook.access$100();     // Catch: Throwable -> L43
        int r103 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L43
        ShadowHook.b r104 = new ShadowHook.b();     // Catch: Throwable -> L43
        r104.f270294a = r103;     // Catch: Throwable -> L43
        r104.f270295b = true;     // Catch: Throwable -> L43
        r104.f270296c = false;     // Catch: Throwable -> L43
        r104.f270297d = false;     // Catch: Throwable -> L43
        if (ShadowHook.init(r104) != 0) goto L19;
        if (is64BitNative() == true) goto L25;
        monitor-exit(HeapExpandV2.class);
        return false;
    L25:
        int r105 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L39
        if (r105 >= 23) goto L28;
    L37:
        monitor-exit(HeapExpandV2.class);
        return false;
    L28:
        if (r105 > 25) goto L37;
        if (initNative() == true) goto L34;
        monitor-exit(HeapExpandV2.class);
        return false;
    L34:
        r102.set(true);     // Catch: Throwable -> L39
        boolean r106 = applyNative(r101);     // Catch: Throwable -> L39
        monitor-exit(HeapExpandV2.class);
        return r106;
    L40:
        return false;
    L19:
        monitor-exit(HeapExpandV2.class);
        return false;
    L41:
        monitor-exit(HeapExpandV2.class);
        return false;
    L44:
        return false;
    L7:
        monitor-exit(HeapExpandV2.class);
        return false;
    L45:
        th = move-exception;
        throw th;
    }
}
