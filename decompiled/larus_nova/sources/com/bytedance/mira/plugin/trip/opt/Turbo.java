package com.bytedance.mira.plugin.trip.opt;

import android.util.Log;
import com.bytedance.librarian.a;
import com.bytedance.shadowhook.ShadowHook;
import com.larus.utils.logger.FLogger;
import dalvik.system.BaseDexClassLoader;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
public class Turbo {
    private static Config sConfig;
    private static volatile boolean sHasInit;
    private static volatile boolean sInitResult;

    /* JADX INFO: renamed from: com.bytedance.mira.plugin.trip.opt.Turbo$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class Config {
        private ILog log;

        private Config() {
        }

        public /* synthetic */ Config(AnonymousClass1 r100) {
            this();
        }

        public static /* synthetic */ ILog access$100(Config r100) {
            return r100.log;
        }

        public static /* synthetic */ ILog access$102(Config r100, ILog r101) {
            r100.log = r101;
            return r101;
        }
    }

    public static class ConfigBuilder {
        private ILog log;

        public ConfigBuilder() {
        }

        public Config build() {
            Config r100 = new Config(null);
            Config.access$102(r100, this.log);
            return r100;
        }

        public ConfigBuilder withLog(ILog r100) {
            this.log = r100;
            return this;
        }
    }

    public interface ILog {
        void e(String r100, String r101, Throwable r102);
    }

    public Turbo() {
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private static native boolean opt_find_type_id_native();

    private static boolean isInitReady() {
        if (sHasInit == true) goto L5;
    L7:
        return false;
    L5:
        if (sInitResult == false) goto L7;
        return true;
    }

    public static boolean optFindTypeId() {
        if (isInitReady() == true) goto L7;
        return false;
    L7:
        return opt_find_type_id_native();
    }

    public static boolean optRegisterDexFile() {
        if (isInitReady() == true) goto L7;
        return false;
    L7:
        return RegisterDexFileOpt.optRegisterDexFile();
    }

    public static boolean optZipExtraCrc32() {
        if (isInitReady() == true) goto L7;
        return false;
    L7:
        return Crc32Opt.optZipExtraCrc32();
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_mira_plugin_trip_opt_Turbo_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static boolean init(Config r100) {
        if (sHasInit == true) goto L15;
        monitor-enter(Turbo.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sHasInit == true) goto L9;
        sInitResult = safeInitWithLock(r100);     // Catch: Throwable -> L11
        sHasInit = true;     // Catch: Throwable -> L11
    L9:
        monitor-exit(Turbo.class);     // Catch: Throwable -> L11
    L15:
        return sInitResult;
    }

    private static boolean safeInitWithLock(Config r100) {
        sConfig = r100;
        ShadowHook.access$000();
        ShadowHook.access$100();
        int r101 = ShadowHook.Mode.SHARED.getValue();
        ShadowHook.b r102 = new ShadowHook.b();
        r102.f270294a = r101;
        r102.f270295b = true;
        r102.f270296c = true;
        r102.f270297d = false;
        ShadowHook.init(r102);
        INVOKESTATIC_com_bytedance_mira_plugin_trip_opt_Turbo_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("turbo");     // Catch: Throwable -> L5
        return true;
    L5:
        th = move-exception;
        Log.getStackTraceString(th);
        return false;
    }

    public static boolean optClassDef(BaseDexClassLoader r100, String r101) {
        if (isInitReady() == true) goto L7;
        return false;
    L7:
        return ClassDefOpt.optClassDef(r100, r101);
    }

    public static void reporter(String r100, String r101, Throwable r102) {
        if (isInitReady() == true) goto L5;
        return;
    L5:
        Config r103 = sConfig;
        if (r103 != null) goto L8;
        return;
    L8:
        if (Config.access$100(r103) == null) goto L13;
        Config.access$100(sConfig).e(r100, r101, r102);
        return;
    }
}
