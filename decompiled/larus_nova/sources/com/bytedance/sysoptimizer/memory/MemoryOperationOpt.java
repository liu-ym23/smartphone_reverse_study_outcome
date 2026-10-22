package com.bytedance.sysoptimizer.memory;

import android.content.Context;
import android.os.Build;
import android.os.Process;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public class MemoryOperationOpt {
    private static final String TAG = "MemoryOperationOpt";
    private static final AtomicBoolean mInitFlag = null;

    public MemoryOperationOpt() {
    }

    private static native boolean applyMemoryNative(boolean r100, long r101, long r102);

    static {
        mInitFlag = new AtomicBoolean(false);
    }

    private static synchronized boolean ensureLoaded(Context r100) {
        monitor-enter(MemoryOperationOpt.class);
        AtomicBoolean r101 = mInitFlag;     // Catch: Throwable -> L24
        if (r101.get() == false) goto L10;
        monitor-exit(MemoryOperationOpt.class);
        return true;
    L10:
        if (Build.VERSION.SDK_INT >= 23) goto L15;
        monitor-exit(MemoryOperationOpt.class);
        return false;
    L15:
        if (Process.is64Bit() == true) goto L28;
        monitor-exit(MemoryOperationOpt.class);
        return false;
    L28:
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L21;
        ShadowHook.access$000();     // Catch: Throwable -> L27
        ShadowHook.access$100();     // Catch: Throwable -> L27
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L27
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L27
        r103.f270294a = r102;     // Catch: Throwable -> L27
        r103.f270295b = true;     // Catch: Throwable -> L27
        r103.f270296c = false;     // Catch: Throwable -> L27
        r103.f270297d = false;     // Catch: Throwable -> L27
        ShadowHook.init(r103);     // Catch: Throwable -> L27
        r101.set(true);     // Catch: Throwable -> L27
    L21:
        boolean r104 = mInitFlag.get();     // Catch: Throwable -> L24
        monitor-exit(MemoryOperationOpt.class);
        return r104;
    L24:
        th = move-exception;
        throw th;
    }

    public static synchronized boolean apply(Context r100, boolean r101, long r102, long r103) {
        monitor-enter(MemoryOperationOpt.class);
        if (ensureLoaded(r100) == true) goto L17;
        monitor-exit(MemoryOperationOpt.class);
        return false;
    L17:
        boolean r104 = applyMemoryNative(r101, r102, r103);     // Catch: Throwable -> L12
        monitor-exit(MemoryOperationOpt.class);
        return r104;
    L13:
        return false;
    L14:
        th = move-exception;
        throw th;
    }
}
