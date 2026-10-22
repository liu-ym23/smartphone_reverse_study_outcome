package com.bytedance.byted_bach_sdk;

import com.bytedance.byted_bach_sdk.buffer.BachAlgorithmOutput;
import com.bytedance.byted_bach_sdk.finder.BachResourceFinder;
import com.bytedance.byted_bach_sdk.input.BachAlgorithmInput;
import com.larus.utils.logger.FLogger;
import java.util.HashMap;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: classes8.dex */
public class BachAlgorithmSystem {
    private boolean isDestroyed;
    private BachResourceFinder m_finder;
    private long m_nativePtr;

    public static final enum BachErrorCode extends Enum<BachErrorCode> {
        private static final /* synthetic */ BachErrorCode[] $VALUES = null;
        public static final BachErrorCode INTERNAL_ERROR = null;
        public static final BachErrorCode INVALID_CONFIG = null;
        public static final BachErrorCode INVALID_FORMAT = null;
        public static final BachErrorCode INVALID_GRAPH = null;
        public static final BachErrorCode INVALID_MODEL = null;
        public static final BachErrorCode INVALID_NODE = null;
        public static final BachErrorCode INVALID_RES_FINDER = null;
        public static final BachErrorCode INVALID_TYPE = null;
        public static final BachErrorCode NONE_ERROR = null;
        public static final BachErrorCode NOT_INIT = null;
        public static final BachErrorCode NO_ERROR = null;

        static {
            BachErrorCode r100 = new BachErrorCode("NO_ERROR", 0);
            NO_ERROR = r100;
            BachErrorCode r101 = new BachErrorCode("INVALID_RES_FINDER", 1);
            INVALID_RES_FINDER = r101;
            BachErrorCode r102 = new BachErrorCode("NOT_INIT", 2);
            NOT_INIT = r102;
            BachErrorCode r103 = new BachErrorCode("INVALID_CONFIG", 3);
            INVALID_CONFIG = r103;
            BachErrorCode r104 = new BachErrorCode("INVALID_GRAPH", 4);
            INVALID_GRAPH = r104;
            BachErrorCode r105 = new BachErrorCode("INVALID_MODEL", 5);
            INVALID_MODEL = r105;
            BachErrorCode r110 = new BachErrorCode("INVALID_TYPE", 6);
            INVALID_TYPE = r110;
            BachErrorCode r111 = new BachErrorCode("INVALID_NODE", 7);
            INVALID_NODE = r111;
            BachErrorCode r112 = new BachErrorCode("INVALID_FORMAT", 8);
            INVALID_FORMAT = r112;
            BachErrorCode r113 = new BachErrorCode("INTERNAL_ERROR", 9);
            INTERNAL_ERROR = r113;
            BachErrorCode r114 = new BachErrorCode("NONE_ERROR", 10);
            NONE_ERROR = r114;
            $VALUES = new BachErrorCode[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114};
        }

        public static BachErrorCode[] values() {
            return (BachErrorCode[]) $VALUES.clone();
        }

        public static BachErrorCode valueOf(String r100) {
            return (BachErrorCode) a.a(BachErrorCode.class, r100);
        }

        private BachErrorCode(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static class BachInitConfig {
        public String applicationName;
        public String cacheFolder;
        public String deviceName;
        public BachResourceFinder finder;

        public BachInitConfig() {
            this.cacheFolder = "";
        }
    }

    public static /* synthetic */ void access$000(String r100) {
        System.loadLibrary(r100);
    }

    private native long nativeCreate(BachInitConfig r100);

    private native void nativeDestroy(long r100);

    private native int nativeExec(long r100, BachAlgorithmInput r101);

    private native BachAlgorithmOutput nativeGetResult(long r100, String r101, int r102);

    private native void nativeInitGraph(long r100, String r101);

    private native void nativeSetBachCacheEnable(long r100, boolean r101);

    private native int nativeSetEnable(long r100, String r101, boolean r102);

    private native int nativeSetFloatParams(long r100, String r101, HashMap<String, Float> r102);

    private native int nativeSetIntParams(long r100, String r101, HashMap<String, Integer> r102);

    private native int nativeSetStringParams(long r100, String r101, HashMap<String, String> r102);

    private native void nativeinitGraphWithRootPath(long r100, String r101, String r102);

    public synchronized void destroy() {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L8;
        monitor-exit(this);
        return;
    L8:
        this.isDestroyed = true;     // Catch: Throwable -> L11
        nativeDestroy(this.m_nativePtr);     // Catch: Throwable -> L11
        monitor-exit(this);
    }

    static {
        INVOKESTATIC_com_bytedance_byted_bach_sdk_BachAlgorithmSystem_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary("bach-sdk-jni");
    }

    public void finalize() throws Throwable {
        super.finalize();
        destroy();
    }

    public BachAlgorithmSystem(BachInitConfig r100) {
        this.isDestroyed = false;
        this.m_nativePtr = nativeCreate(r100);
        this.m_finder = r100.finder;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_byted_bach_sdk_BachAlgorithmSystem_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public synchronized BachErrorCode execute(BachAlgorithmInput r100) {
        monitor-enter(this);
    L16:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L9;
        BachErrorCode r101 = BachErrorCode.NOT_INIT;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r101;
    L9:
        if (this.m_finder.isDestroyed == false) goto L13;
        BachErrorCode r102 = BachErrorCode.INVALID_RES_FINDER;     // Catch: Throwable -> L16
        monitor-exit(this);
        return r102;
    L13:
        int r103 = nativeExec(this.m_nativePtr, r100);     // Catch: Throwable -> L16
        BachErrorCode r104 = BachErrorCode.values()[r103];     // Catch: Throwable -> L16
        monitor-exit(this);
        return r104;
    }

    public synchronized BachAlgorithmOutput getResult(String r100) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        BachAlgorithmOutput r101 = nativeGetResult(this.m_nativePtr, r100, 0);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r101;
    }

    public synchronized void initGraph(String r100) {
        monitor-enter(this);
        nativeInitGraph(this.m_nativePtr, r100);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public void setBachCacheEnable(boolean r100) {
        nativeSetBachCacheEnable(this.m_nativePtr, r100);
    }

    public int enable(String r100, boolean r101) {
        return nativeSetEnable(this.m_nativePtr, r100, r101);
    }

    public synchronized BachAlgorithmOutput getResult(String r100, int r101) {
        monitor-enter(this);
    L11:
        th = move-exception;
        throw th;
    L4:
        if (this.isDestroyed == false) goto L8;
        monitor-exit(this);
        return null;
    L8:
        BachAlgorithmOutput r102 = nativeGetResult(this.m_nativePtr, r100, r101);     // Catch: Throwable -> L11
        monitor-exit(this);
        return r102;
    }

    public synchronized void initGraphWithRootPath(String r100, String r101) {
        monitor-enter(this);
        nativeinitGraphWithRootPath(this.m_nativePtr, r100, r101);     // Catch: Throwable -> L6
        monitor-exit(this);
        return;
    L6:
        th = move-exception;
        throw th;
    }

    public int setFloatParams(String r100, HashMap<String, Float> r101) {
        return nativeSetFloatParams(this.m_nativePtr, r100, r101);
    }

    public int setIntParams(String r100, HashMap<String, Integer> r101) {
        return nativeSetIntParams(this.m_nativePtr, r100, r101);
    }

    public int setStringParams(String r100, HashMap<String, String> r101) {
        return nativeSetStringParams(this.m_nativePtr, r100, r101);
    }
}
