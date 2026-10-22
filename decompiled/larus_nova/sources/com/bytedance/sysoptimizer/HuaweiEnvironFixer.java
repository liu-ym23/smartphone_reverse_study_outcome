package com.bytedance.sysoptimizer;

import android.content.Context;
import com.bytedance.shadowhook.ShadowHook;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public class HuaweiEnvironFixer {
    private static final int SHADOWHOOK_ERRNO_OK = 0;
    private static final int SHADOWHOOK_ERRNO_UNINIT = 2;
    private static final String TAG = "HuaweiEnvironFixer";
    private static final AtomicBoolean mInitFlag = null;

    public HuaweiEnvironFixer() {
    }

    public static native boolean fix();

    static {
        mInitFlag = new AtomicBoolean(false);
    }

    public static synchronized boolean apply(Context r100) {
        monitor-enter(HuaweiEnvironFixer.class);
    L24:
        th = move-exception;
        throw th;
    L6:
        if (mInitFlag.get() == false) goto L9;
        monitor-exit(HuaweiEnvironFixer.class);
        return true;
    L9:
        int r101 = 2;
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L15;
        ShadowHook.access$000();     // Catch: Throwable -> L14
        ShadowHook.access$100();     // Catch: Throwable -> L14
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L14
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L14
        r103.f270294a = r102;     // Catch: Throwable -> L14
        r103.f270295b = true;     // Catch: Throwable -> L14
        r103.f270296c = false;     // Catch: Throwable -> L14
        r103.f270297d = false;     // Catch: Throwable -> L14
        r101 = ShadowHook.init(r103);     // Catch: Throwable -> L14
    L15:
        if (r101 == 0) goto L29;
        monitor-exit(HuaweiEnvironFixer.class);
        return false;
    L29:
        boolean r104 = fix();     // Catch: Throwable -> L22
        mInitFlag.set(true);     // Catch: Throwable -> L22
        monitor-exit(HuaweiEnvironFixer.class);
        return r104;
    L23:
        return false;
    }
}
