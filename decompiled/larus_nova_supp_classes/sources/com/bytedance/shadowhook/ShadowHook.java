package com.bytedance.shadowhook;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;
import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class ShadowHook {
    public static final int ERRNO_INIT_EXCEPTION = 101;
    public static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    public static final int ERRNO_OK = 0;
    public static final int ERRNO_UNINIT = 2;
    private static final boolean defaultDebuggable = false;
    private static final boolean defaultDisable = false;
    private static final c defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static final boolean defaultRecordable = false;
    private static long initCostMs = -1;
    private static int initErrno = 2;
    private static boolean inited = false;
    private static final String libName = "shadowhook";
    private static boolean loaded = false;
    private static final int recordItemAll = -1;
    private static final int recordItemBackupLen = 128;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 256;
    private static final int recordItemFlags = 1024;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 64;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 512;
    private static final int recordItemSymAddr = 32;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;
    private static final int recordItemTrace = 2048;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode MULTI = null;
        public static final Mode SHARED = null;
        public static final Mode UNIQUE = null;
        public static final /* synthetic */ Mode[] a = null;
        private final int value;

        static {
            Mode r0 = new Mode("SHARED", 0, 0);
            SHARED = r0;
            Mode r1 = new Mode("UNIQUE", 1, 1);
            UNIQUE = r1;
            Mode r3 = new Mode("MULTI", 2, 2);
            MULTI = r3;
            a = new Mode[]{r0, r1, r3};
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Mode valueOf(String r1) {
            return (Mode) a.a(Mode.class, r1);
        }

        public Mode(String r1, int r2, int r3) {
            super(r1, r2);
            this.value = r3;
        }
    }

    public static class b {
        public int a;
        public boolean b;
        public boolean c;
        public boolean d;

        public b() {
        }
    }

    public ShadowHook() {
    }

    public static /* synthetic */ c access$000() {
        return null;
    }

    public static /* synthetic */ void access$001(String r0) {
        System.loadLibrary(r0);
    }

    public static int init() {
        return init(null);
    }

    private static boolean loadLibrary() {
        return loadLibrary(null);
    }

    private static native String nativeGetArch();

    private static native boolean nativeGetDebuggable();

    private static native boolean nativeGetDisable();

    private static native int nativeGetInitErrno();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int r0);

    private static native String nativeGetVersion();

    private static native int nativeInit(int r0, boolean r1);

    private static native void nativeSetDebuggable(boolean r0);

    private static native void nativeSetDisable(boolean r0);

    private static native void nativeSetRecordable(boolean r0);

    private static native String nativeToErrmsg(int r0);

    static {
        defaultMode = Mode.SHARED.getValue();
    }

    public static String getArch() {
        if (loadLibrary() == true) goto L5;
        return "unknown";
    L5:
        return nativeGetArch();
    }

    public static boolean getDebuggable() {
        if (loadLibrary() == true) goto L5;
        return false;
    L5:
        return nativeGetDebuggable();
    }

    public static boolean getDisable() {
        if (loadLibrary() == true) goto L5;
        return false;
    L5:
        return nativeGetDisable();
    }

    public static Mode getMode() {
        if (loadLibrary() == false) goto L13;
        int r0 = nativeGetMode();
        Mode r1 = Mode.UNIQUE;
        if (r1.getValue() != r0) goto L7;
        return r1;
    L7:
        Mode r2 = Mode.MULTI;
        if (r2.getValue() != r0) goto L11;
        return r2;
    L11:
        return Mode.SHARED;
    L13:
        return Mode.SHARED;
    }

    public static boolean getRecordable() {
        if (loadLibrary() == true) goto L5;
        return false;
    L5:
        return nativeGetRecordable();
    }

    public static String getVersion() {
        return nativeGetVersion();
    }

    public static /* synthetic */ int access$100() {
        return defaultMode;
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static int getInitErrno() {
        return initErrno;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_shadowhook_ShadowHook_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static String getRecords(RecordItem... r5) {
        if (loadLibrary() == false) goto L26;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L22;
        RecordItem r3 = r5[r1];
        switch(a.a[r3.ordinal()]) {
            case 1: goto L20;
            case 2: goto L19;
            case 3: goto L18;
            case 4: goto L17;
            case 5: goto L16;
            case 6: goto L15;
            case 7: goto L14;
            case 8: goto L13;
            case 9: goto L12;
            case 10: goto L11;
            case 11: goto L10;
            case 12: goto L9;
            default: goto L21;
        };
    L9:
        r2 = r2 | recordItemTrace;
        goto L21
    L10:
        r2 = r2 | recordItemFlags;
        goto L21
    L11:
        r2 = r2 | recordItemStub;
        goto L21
    L12:
        r2 = r2 | recordItemErrno;
        goto L21
    L13:
        r2 = r2 | recordItemBackupLen;
        goto L21
    L14:
        r2 = r2 | recordItemNewAddr;
        goto L21
    L15:
        r2 = r2 | 32;
        goto L21
    L16:
        r2 = r2 | 16;
        goto L21
    L17:
        r2 = r2 | 8;
        goto L21
    L18:
        r2 = r2 | 4;
        goto L21
    L19:
        r2 = r2 | 2;
        goto L21
    L20:
        r2 = r2 | 1;
    L21:
        r1 = r1 + 1;
        goto L5
    L22:
        if (r2 != 0) goto L25;
        r2 = -1;
    L25:
        return nativeGetRecords(r2);
    L26:
        return null;
    }

    public static synchronized int init(b r6) {
        monitor-enter(ShadowHook.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r7 = initErrno;     // Catch: Throwable -> L31
        monitor-exit(ShadowHook.class);
        return r7;
    L10:
        inited = true;     // Catch: Throwable -> L31
        long r2 = System.currentTimeMillis();     // Catch: Throwable -> L31
        if (r6 != null) goto L14;
        access$000();     // Catch: Throwable -> L31
        int r8 = access$100();     // Catch: Throwable -> L31
        b r4 = new b();     // Catch: Throwable -> L31
        r4.a = r8;     // Catch: Throwable -> L31
        r4.b = false;     // Catch: Throwable -> L31
        r4.c = false;     // Catch: Throwable -> L31
        r4.d = false;     // Catch: Throwable -> L31
        r6 = r4;
    L14:
        if (loadLibrary(r6) == true) goto L35;
        initErrno = 100;     // Catch: Throwable -> L31
        initCostMs = System.currentTimeMillis() - r2;     // Catch: Throwable -> L31
        int r9 = initErrno;     // Catch: Throwable -> L31
        monitor-exit(ShadowHook.class);
        return r9;
    L35:
        if (r6.d == false) goto L21;
        nativeSetDisable(true);     // Catch: Throwable -> L26
    L21:
        boolean r1 = r6.c;     // Catch: Throwable -> L26
        if (r1 == false) goto L24;
        nativeSetRecordable(r1);     // Catch: Throwable -> L26
    L24:
        initErrno = nativeInit(r6.a, r6.b);     // Catch: Throwable -> L26
    L28:
        initCostMs = System.currentTimeMillis() - r2;     // Catch: Throwable -> L31
        int r10 = initErrno;     // Catch: Throwable -> L31
        monitor-exit(ShadowHook.class);
        return r10;
    L27:
        initErrno = ERRNO_INIT_EXCEPTION;     // Catch: Throwable -> L31
        goto L28
    }

    private static synchronized boolean loadLibrary(b r3) {
        monitor-enter(ShadowHook.class);
        if (loaded == false) goto L18;
        monitor-exit(ShadowHook.class);
        return true;
    L18:
        INVOKESTATIC_com_bytedance_shadowhook_ShadowHook_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(libName);     // Catch: Throwable -> L12
        loaded = true;     // Catch: Throwable -> L12
        monitor-exit(ShadowHook.class);
        return true;
    L13:
        return false;
    L15:
        th = move-exception;
        throw th;
    }

    public static void setDebuggable(boolean r1) {
        if (loadLibrary() == false) goto L6;
        nativeSetDebuggable(r1);
        return;
    }

    public static void setDisable(boolean r1) {
        if (loadLibrary() == false) goto L6;
        nativeSetDisable(r1);
        return;
    }

    public static void setRecordable(boolean r1) {
        if (loadLibrary() == false) goto L6;
        nativeSetRecordable(r1);
        return;
    }

    public static String toErrmsg(int r1) {
        if (r1 != 0) goto L6;
        return "OK";
    L6:
        if (r1 != 2) goto L10;
        return "Not initialized";
    L10:
        if (r1 != 100) goto L14;
        return "Load libshadowhook.so failed";
    L14:
        if (r1 != 101) goto L18;
        return "Init exception";
    L18:
        if (loadLibrary() == true) goto L20;
        return "Unknown";
    L20:
        return nativeToErrmsg(r1);
    }
}
