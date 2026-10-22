package com.bytedance.android.bytehook;

import com.bytedance.shadowhook.ShadowHook;
import com.larus.utils.logger.FLogger;
import hd.a;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ByteHook {
    private static final int ERRNO_INIT_EXCEPTION = 101;
    private static final int ERRNO_LOAD_LIBRARY_EXCEPTION = 100;
    private static final int ERRNO_OK = 0;
    private static final int ERRNO_UNINIT = 1;
    private static final boolean defaultDebug = false;
    private static final a defaultLibLoader = null;
    private static final int defaultMode = 0;
    private static final boolean defaultRecordable = false;
    private static final boolean defaultShadowhookDebug = false;
    private static final ShadowHook.c defaultShadowhookLibLoader = null;
    private static final ShadowHook.Mode defaultShadowhookMode = null;
    private static final boolean defaultShadowhookRecordable = false;
    private static long initCostMs = -1;
    private static int initStatus = 1;
    private static boolean inited = false;
    private static final String libName = "bytehook";
    private static final int recordItemAll = 255;
    private static final int recordItemCallerLibName = 2;
    private static final int recordItemErrno = 64;
    private static final int recordItemLibName = 8;
    private static final int recordItemNewAddr = 32;
    private static final int recordItemOp = 4;
    private static final int recordItemStub = 128;
    private static final int recordItemSymName = 16;
    private static final int recordItemTimestamp = 1;

    public static final enum Mode extends Enum<Mode> {
        public static final Mode AUTOMATIC = null;
        public static final Mode MANUAL = null;
        public static final /* synthetic */ Mode[] a = null;
        private final int value;

        static {
            Mode r0 = new Mode("AUTOMATIC", 0, 0);
            AUTOMATIC = r0;
            Mode r1 = new Mode("MANUAL", 1, 1);
            MANUAL = r1;
            a = new Mode[]{r0, r1};
        }

        public static Mode[] values() {
            return (Mode[]) a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Mode valueOf(String r1) {
            return (Mode) r27.a.a(Mode.class, r1);
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
        public ShadowHook.Mode d;
        public boolean e;
        public boolean f;

        public b() {
        }
    }

    public ByteHook() {
    }

    public static /* synthetic */ a access$000() {
        return null;
    }

    public static /* synthetic */ void access$001(String r0) {
        System.loadLibrary(r0);
    }

    public static /* synthetic */ ShadowHook.c access$200() {
        return null;
    }

    public static int init() {
        return init(null);
    }

    private static native int nativeAddIgnore(String r0);

    private static native String nativeGetArch();

    private static native boolean nativeGetDebug();

    private static native int nativeGetMode();

    private static native boolean nativeGetRecordable();

    private static native String nativeGetRecords(int r0);

    private static native String nativeGetVersion();

    private static native int nativeInit(int r0, boolean r1);

    private static native void nativeSetDebug(boolean r0);

    private static native void nativeSetRecordable(boolean r0);

    static {
        defaultMode = Mode.AUTOMATIC.getValue();
        defaultShadowhookMode = ShadowHook.Mode.SHARED;
    }

    public static String getArch() {
        if (initStatus == 0) goto L5;
        return "unknown";
    L5:
        return nativeGetArch();
    }

    public static boolean getDebug() {
        if (initStatus == 0) goto L5;
        return false;
    L5:
        return nativeGetDebug();
    }

    public static Mode getMode() {
        if (initStatus != 0) goto L10;
        Mode r0 = Mode.AUTOMATIC;
        if (r0.getValue() != nativeGetMode()) goto L8;
        return r0;
    L8:
        return Mode.MANUAL;
    L10:
        return Mode.AUTOMATIC;
    }

    public static boolean getRecordable() {
        if (initStatus == 0) goto L5;
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

    public static /* synthetic */ ShadowHook.Mode access$300() {
        return defaultShadowhookMode;
    }

    public static long getInitCostMs() {
        return initCostMs;
    }

    public static int getInitErrno() {
        return initStatus;
    }

    @JvmStatic
    public static void INVOKESTATIC_com_bytedance_android_bytehook_ByteHook_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r4) {
        Intrinsics.checkNotNullParameter(r4, "libName");
        FLogger r0 = FLogger.a;
        r0.i("Librarian_loadLib", "loadLibrary start libName -> " + r4);
        com.bytedance.librarian.a.c(r4);
        r0.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r4);
    }

    public static int addIgnore(String r1) {
        int r0 = initStatus;
        if (r0 == 0) goto L5;
        return r0;
    L5:
        return nativeAddIgnore(r1);
    }

    public static String getRecords(RecordItem... r5) {
        if (initStatus != 0) goto L22;
        int r0 = r5.length;
        int r1 = 0;
        int r2 = 0;
    L5:
        if (r1 >= r0) goto L18;
        RecordItem r3 = r5[r1];
        switch(a.a[r3.ordinal()]) {
            case 1: goto L16;
            case 2: goto L15;
            case 3: goto L14;
            case 4: goto L13;
            case 5: goto L12;
            case 6: goto L11;
            case 7: goto L10;
            case 8: goto L9;
            default: goto L17;
        };
    L9:
        r2 = r2 | recordItemStub;
        goto L17
    L10:
        r2 = r2 | recordItemErrno;
        goto L17
    L11:
        r2 = r2 | 32;
        goto L17
    L12:
        r2 = r2 | 16;
        goto L17
    L13:
        r2 = r2 | 8;
        goto L17
    L14:
        r2 = r2 | 4;
        goto L17
    L15:
        r2 = r2 | 2;
        goto L17
    L16:
        r2 = r2 | 1;
    L17:
        r1 = r1 + 1;
        goto L5
    L18:
        if (r2 != 0) goto L21;
        r2 = recordItemAll;
    L21:
        return nativeGetRecords(r2);
    L22:
        return null;
    }

    public static synchronized int init(b r8) {
        monitor-enter(ByteHook.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r9 = initStatus;     // Catch: Throwable -> L31
        monitor-exit(ByteHook.class);
        return r9;
    L10:
        inited = true;     // Catch: Throwable -> L31
        long r1 = System.currentTimeMillis();     // Catch: Throwable -> L31
        if (r8 != null) goto L13;
        access$000();     // Catch: Throwable -> L31
        int r10 = access$100();     // Catch: Throwable -> L31
        access$200();     // Catch: Throwable -> L31
        ShadowHook.Mode r4 = access$300();     // Catch: Throwable -> L31
        b r5 = new b();     // Catch: Throwable -> L31
        r5.a = r10;     // Catch: Throwable -> L31
        r5.b = false;     // Catch: Throwable -> L31
        r5.c = false;     // Catch: Throwable -> L31
        r5.d = r4;     // Catch: Throwable -> L31
        r5.e = false;     // Catch: Throwable -> L31
        r5.f = false;     // Catch: Throwable -> L31
        r8 = r5;
    L13:
        ShadowHook.access$000();     // Catch: Throwable -> L31
        ShadowHook.access$100();     // Catch: Throwable -> L31
        int r6 = r8.d.getValue();     // Catch: Throwable -> L31
        boolean r7 = r8.e;     // Catch: Throwable -> L31
        boolean r11 = r8.f;     // Catch: Throwable -> L31
        ShadowHook.b r12 = new ShadowHook.b();     // Catch: Throwable -> L31
        r12.a = r6;     // Catch: Throwable -> L31
        r12.b = r7;     // Catch: Throwable -> L31
        r12.c = r11;     // Catch: Throwable -> L31
        r12.d = false;     // Catch: Throwable -> L31
        ShadowHook.init(r12);     // Catch: Throwable -> L31
        INVOKESTATIC_com_bytedance_android_bytehook_ByteHook_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(libName);     // Catch: Throwable -> L27
        goto L28
    L36:
        initStatus = nativeInit(r8.a, r8.b);     // Catch: Throwable -> L18
    L19:
        boolean r13 = r8.c;     // Catch: Throwable -> L31
        if (r13 == true) goto L34;
    L24:
        initCostMs = System.currentTimeMillis() - r1;     // Catch: Throwable -> L31
        int r14 = initStatus;     // Catch: Throwable -> L31
        monitor-exit(ByteHook.class);
        return r14;
    L34:
        nativeSetRecordable(r13);     // Catch: Throwable -> L23
    L23:
        initStatus = 101;     // Catch: Throwable -> L31
        goto L24
    L18:
        initStatus = 101;     // Catch: Throwable -> L31
    L28:
        initStatus = 100;     // Catch: Throwable -> L31
        initCostMs = System.currentTimeMillis() - r1;     // Catch: Throwable -> L31
        return initStatus;
    }

    public static void setDebug(boolean r1) {
        if (initStatus != 0) goto L6;
        nativeSetDebug(r1);
        return;
    }

    public static void setRecordable(boolean r1) {
        if (initStatus != 0) goto L6;
        nativeSetRecordable(r1);
        return;
    }
}
