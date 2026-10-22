package com.bytedance.sysoptimizer.tools;

import android.content.Context;
import android.os.Build;
import com.bytedance.shadowhook.ShadowHook;
import com.bytedance.sysoptimizer.SysOptimizer;

/* JADX INFO: loaded from: classes22.dex */
public class IndirectReferenceTableMonitor {
    public static final int CAP_GLOBAL = 1;
    public static final int CAP_WEAK_GLOBAL = 2;
    private static final String TAG = "IndirectRefMonitor";
    private static boolean sOptimized;

    /* JADX INFO: renamed from: com.bytedance.sysoptimizer.tools.IndirectReferenceTableMonitor$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Config {
        private int cap;
        private RefConfig globalConfig;
        private RefConfig weakGlobalConfig;

        public static final class Builder {
            private final Config config;

            public Builder() {
                this.config = new Config(null);
            }

            public Config getConfig() {
                return this.config;
            }

            public Builder setCapability(int r100) {
                Config.access$102(this.config, r100);
                return this;
            }

            public Builder setGlobalConfig(RefConfig r100) {
                Config.access$202(this.config, r100);
                return this;
            }

            public Builder setWeakGlobalConfig(RefConfig r100) {
                Config.access$302(this.config, r100);
                return this;
            }
        }

        public static class RefConfig {
            public final int crashCount;
            public final int crawlStackCount;
            public final int maxStackDump;

            public RefConfig(int r100, int r101, int r102) {
                this.crashCount = r100;
                this.crawlStackCount = r101;
                this.maxStackDump = r102;
            }
        }

        private Config() {
        }

        public boolean isValid() {
            int r100 = this.cap;
            if ((r100 & 1) == 0) goto L9;
            if (this.globalConfig == null) goto L14;
            return true;
        L14:
            return false;
        L9:
            if ((r100 & 2) != 0) goto L11;
            return false;
        L11:
            if (this.weakGlobalConfig == null) goto L16;
            return true;
        L16:
            return false;
        }

        public /* synthetic */ Config(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ int access$102(Config r100, int r101) {
            r100.cap = r101;
            return r101;
        }

        public static /* synthetic */ RefConfig access$202(Config r100, RefConfig r101) {
            r100.globalConfig = r101;
            return r101;
        }

        public static /* synthetic */ RefConfig access$302(Config r100, RefConfig r101) {
            r100.weakGlobalConfig = r101;
            return r101;
        }
    }

    public IndirectReferenceTableMonitor() {
    }

    private static native void changeConfig0(Config r100);

    public static native int dump2file(String r100);

    public static native int getReferenceCount(int r100);

    public static native void mockLeak();

    private static native void monitor(Config r100, int r101);

    public static native boolean startMonitor(int r100, int r101);

    private static void ThrowCustomException() {
        throw new RuntimeException("Leak IndirectReferenceTable");
    }

    private static String getJavaStackTrace() {
        StackTraceElement[] r100 = new Throwable().getStackTrace();
        int r101 = 1;
        if (r100.length <= 1) goto L10;
        StringBuilder r102 = new StringBuilder();
    L6:
        if (r101 >= r100.length) goto L9;
        r102.append(r100[r101].toString());
        r102.append("\n");
        r101 = r101 + 1;
        goto L6
    L9:
        return r102.toString();
    L10:
        return "";
    }

    public static void changeConfig(Config r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.isValid() == false) goto L9;
        changeConfig0(r100);
        return;
    }

    private static void e(String r100, String r101) {
        if (r101.length() > 3072) goto L6;
        return;
    L6:
        if (r101.length() <= 3072) goto L10;
        r101 = r101.replace(r101.substring(0, 3072), "");
        goto L6
    }

    public static synchronized void monitor(Context r100, Config r101) {
        monitor-enter(IndirectReferenceTableMonitor.class);
    L18:
        th = move-exception;
        throw th;
    L5:
        if (sOptimized == true) goto L16;
        if (r101 == null) goto L16;
        if (r101.isValid() == false) goto L16;
        if (SysOptimizer.loadOptimizerLibrary(r100) == false) goto L14;
        ShadowHook.access$000();     // Catch: Throwable -> L18
        ShadowHook.access$100();     // Catch: Throwable -> L18
        int r102 = ShadowHook.Mode.SHARED.getValue();     // Catch: Throwable -> L18
        ShadowHook.b r103 = new ShadowHook.b();     // Catch: Throwable -> L18
        r103.f270294a = r102;     // Catch: Throwable -> L18
        r103.f270295b = true;     // Catch: Throwable -> L18
        r103.f270296c = false;     // Catch: Throwable -> L18
        r103.f270297d = false;     // Catch: Throwable -> L18
        ShadowHook.init(r103);     // Catch: Throwable -> L18
        monitor(r101, Build.VERSION.SDK_INT);     // Catch: Throwable -> L21 Throwable -> L18
        sOptimized = true;     // Catch: Throwable -> L21 Throwable -> L18
    L14:
        monitor-exit(IndirectReferenceTableMonitor.class);
        return;
    L16:
        monitor-exit(IndirectReferenceTableMonitor.class);
    }
}
