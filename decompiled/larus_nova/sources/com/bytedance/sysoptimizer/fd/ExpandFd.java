package com.bytedance.sysoptimizer.fd;

import android.content.Context;
import android.os.Build;
import com.alipay.sdk.m.u.i;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes22.dex */
public class ExpandFd {
    private static final int SHADOWHOOK_ERRNO_OK = 0;
    private static final int SHADOWHOOK_ERRNO_UNINIT = 2;
    private static final String TAG = "ExpandFd";
    private static final AtomicBoolean mInitFlag = null;

    public ExpandFd() {
    }

    private static native boolean addExpandFdSetTarget(String r100, String r101);

    private static native int expandKernelFdLimitNative();

    private static native boolean expandLibcFdLimitNative(int r100);

    private static native boolean is64BitNative();

    static {
        mInitFlag = new AtomicBoolean(false);
    }

    private static synchronized boolean processTargetList(String r100) {
        monitor-enter(ExpandFd.class);
        if (r100 != null) goto L36;
    L34:
        monitor-exit(ExpandFd.class);
        return true;
    L36:
    L31:
        th = move-exception;
        throw th;
    L7:
        if (r100.trim().length() == 0) goto L34;
        if (r100.endsWith(i.f25853b) == true) goto L14;
        monitor-exit(ExpandFd.class);
        return false;
    L14:
        String[] r101 = r100.split(i.f25853b);     // Catch: Throwable -> L31
        int r102 = 0;
    L16:
        if (r102 >= r101.length) goto L29;
        String[] r103 = r101[r102].split(":");     // Catch: Throwable -> L31
        if (r103.length != 2) goto L19;
        String r104 = r103[0];     // Catch: Throwable -> L31
        String r105 = r103[1];     // Catch: Throwable -> L31
        if (r104.endsWith(".so") == false) goto L25;
        addExpandFdSetTarget(r104, r105);     // Catch: Throwable -> L31
        r102 = r102 + 1;
        goto L16
    L25:
        monitor-exit(ExpandFd.class);
        return false;
    L19:
        String r106 = r101[r102];     // Catch: Throwable -> L31
        monitor-exit(ExpandFd.class);
        return false;
    L29:
        monitor-exit(ExpandFd.class);
        return true;
    }

    public static synchronized boolean apply(Context r100, boolean r101, String r102) {
        monitor-enter(ExpandFd.class);
    L48:
        th = move-exception;
        throw th;
    L5:
        boolean r103 = true;
        if (mInitFlag.get() == false) goto L10;
        monitor-exit(ExpandFd.class);
        return true;
    L10:
        if (Build.VERSION.SDK_INT > 28) goto L12;
        int r104 = 2;
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L20;
        ShadowHook.access$000();     // Catch: Throwable -> L19
        ShadowHook.access$100();     // Catch: Throwable -> L19
        int r105 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L19
        ShadowHook.b r106 = new ShadowHook.b();     // Catch: Throwable -> L19
        r106.f270294a = r105;     // Catch: Throwable -> L19
        r106.f270295b = true;     // Catch: Throwable -> L19
        r106.f270296c = false;     // Catch: Throwable -> L19
        r106.f270297d = false;     // Catch: Throwable -> L19
        r104 = ShadowHook.init(r106);     // Catch: Throwable -> L19
    L20:
        if (r104 != 0) goto L22;
        if (is64BitNative() == true) goto L28;
        monitor-exit(ExpandFd.class);
        return false;
    L28:
        int r107 = expandKernelFdLimitNative();     // Catch: Throwable -> L46
        mInitFlag.set(true);     // Catch: Throwable -> L46
        if (r107 != 0) goto L32;
        monitor-exit(ExpandFd.class);
        return false;
    L32:
        if (r101 == false) goto L36;
        monitor-exit(ExpandFd.class);
        return true;
    L36:
        if (expandLibcFdLimitNative(r107) == true) goto L39;
        monitor-exit(ExpandFd.class);
        return false;
    L39:
        boolean r108 = DefaultFdSetExpandHelper.applyJavaCryptoExpandFdSet();     // Catch: Throwable -> L46
        boolean r109 = DefaultFdSetExpandHelper.applyLibcExpand();     // Catch: Throwable -> L46
        DefaultFdSetExpandHelper.applyQtiBoostFrameworkExpand();     // Catch: Throwable -> L46
        processTargetList(r102);     // Catch: Throwable -> L46
        if (r108 == false) goto L43;
        if (r109 == false) goto L43;
    L44:
        monitor-exit(ExpandFd.class);
        return r103;
    L43:
        r103 = false;
    L47:
        return false;
    L22:
        monitor-exit(ExpandFd.class);
        return false;
    L12:
        monitor-exit(ExpandFd.class);
        return false;
    }
}
