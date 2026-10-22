package com.bytedance.shadowhook;

import com.larus.utils.logger.FLogger;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
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

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Mode[] f270291a = null;
        private final int value;

        static {
            Mode r100 = new Mode("SHARED", 0, 0);
            SHARED = r100;
            Mode r101 = new Mode("UNIQUE", 1, 1);
            UNIQUE = r101;
            Mode r102 = new Mode("MULTI", 2, 2);
            MULTI = r102;
            f270291a = new Mode[]{r100, r101, r102};
        }

        public static Mode[] values() {
            return (Mode[]) f270291a.clone();
        }

        public int getValue() {
            return this.value;
        }

        public static Mode valueOf(String r100) {
            return (Mode) r27.a.a(Mode.class, r100);
        }

        public Mode(String r100, int r101, int r102) {
            super(r100, r101);
            this.value = r102;
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static final enum RecordItem extends Enum<RecordItem> {
        public static final RecordItem BACKUP_LEN = null;
        public static final RecordItem CALLER_LIB_NAME = null;
        public static final RecordItem ERRNO = null;
        public static final RecordItem FLAGS = null;
        public static final RecordItem LIB_NAME = null;
        public static final RecordItem NEW_ADDR = null;
        public static final RecordItem OP = null;
        public static final RecordItem STUB = null;
        public static final RecordItem SYM_ADDR = null;
        public static final RecordItem SYM_NAME = null;
        public static final RecordItem TIMESTAMP = null;
        public static final RecordItem TRACE = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ RecordItem[] f270292a = null;

        static {
            RecordItem r100 = new RecordItem("TIMESTAMP", 0);
            TIMESTAMP = r100;
            RecordItem r101 = new RecordItem("CALLER_LIB_NAME", 1);
            CALLER_LIB_NAME = r101;
            RecordItem r102 = new RecordItem("OP", 2);
            OP = r102;
            RecordItem r103 = new RecordItem("LIB_NAME", 3);
            LIB_NAME = r103;
            RecordItem r104 = new RecordItem("SYM_NAME", 4);
            SYM_NAME = r104;
            RecordItem r105 = new RecordItem("SYM_ADDR", 5);
            SYM_ADDR = r105;
            RecordItem r110 = new RecordItem("NEW_ADDR", 6);
            NEW_ADDR = r110;
            RecordItem r111 = new RecordItem("BACKUP_LEN", 7);
            BACKUP_LEN = r111;
            RecordItem r112 = new RecordItem("ERRNO", 8);
            ERRNO = r112;
            RecordItem r113 = new RecordItem("STUB", 9);
            STUB = r113;
            RecordItem r114 = new RecordItem("FLAGS", 10);
            FLAGS = r114;
            RecordItem r115 = new RecordItem("TRACE", 11);
            TRACE = r115;
            f270292a = new RecordItem[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r115};
        }

        public static RecordItem[] values() {
            return (RecordItem[]) f270292a.clone();
        }

        public static RecordItem valueOf(String r100) {
            return (RecordItem) r27.a.a(RecordItem.class, r100);
        }

        public RecordItem(String r100, int r101) {
            super(r100, r101);
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public static /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f270293a = null;

        static {
            int[] r100 = new int[RecordItem.values().length];
            f270293a = r100;
            r100[RecordItem.TIMESTAMP.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L30:
            f270293a[RecordItem.CALLER_LIB_NAME.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L36:
            f270293a[RecordItem.OP.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L50:
            f270293a[RecordItem.LIB_NAME.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L32:
            f270293a[RecordItem.SYM_NAME.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L38:
            f270293a[RecordItem.SYM_ADDR.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L42:
            f270293a[RecordItem.NEW_ADDR.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L46:
            f270293a[RecordItem.BACKUP_LEN.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L28:
            f270293a[RecordItem.ERRNO.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L34:
            f270293a[RecordItem.STUB.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L40:
            f270293a[RecordItem.FLAGS.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L44:
            f270293a[RecordItem.TRACE.ordinal()] = 12;     // Catch: NoSuchFieldError -> L27
            return;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public int f270294a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public boolean f270295b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public boolean f270296c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public boolean f270297d;

        public b() {
        }
    }

    /* JADX INFO: loaded from: classes22.dex */
    public interface c {
    }

    public ShadowHook() {
    }

    public static /* synthetic */ c access$000() {
        return null;
    }

    public static /* synthetic */ void access$001(String r100) {
        System.loadLibrary(r100);
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

    private static native String nativeGetRecords(int r100);

    private static native String nativeGetVersion();

    private static native int nativeInit(int r100, boolean r101);

    private static native void nativeSetDebuggable(boolean r100);

    private static native void nativeSetDisable(boolean r100);

    private static native void nativeSetRecordable(boolean r100);

    private static native String nativeToErrmsg(int r100);

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
        int r100 = nativeGetMode();
        Mode r101 = Mode.UNIQUE;
        if (r101.getValue() != r100) goto L7;
        return r101;
    L7:
        Mode r102 = Mode.MULTI;
        if (r102.getValue() != r100) goto L11;
        return r102;
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
    public static void INVOKESTATIC_com_bytedance_shadowhook_ShadowHook_com_larus_home_impl_utils_SystemLoadLibraryHook_loadLibrary(String r100) {
        Intrinsics.checkNotNullParameter(r100, "libName");
        FLogger r101 = FLogger.f375446a;
        r101.i("Librarian_loadLib", "loadLibrary start libName -> " + r100);
        com.bytedance.librarian.a.c(r100);
        r101.i("Librarian_loadLib", "loadLibrary success by librarian -> " + r100);
    }

    public static String getRecords(RecordItem... r100) {
        if (loadLibrary() == false) goto L26;
        int r101 = r100.length;
        int r102 = 0;
        int r103 = 0;
    L5:
        if (r102 >= r101) goto L22;
        RecordItem r104 = r100[r102];
        switch(a.f270293a[r104.ordinal()]) {
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
        r103 = r103 | 2048;
        goto L21
    L10:
        r103 = r103 | 1024;
        goto L21
    L11:
        r103 = r103 | 512;
        goto L21
    L12:
        r103 = r103 | 256;
        goto L21
    L13:
        r103 = r103 | 128;
        goto L21
    L14:
        r103 = r103 | 64;
        goto L21
    L15:
        r103 = r103 | 32;
        goto L21
    L16:
        r103 = r103 | 16;
        goto L21
    L17:
        r103 = r103 | 8;
        goto L21
    L18:
        r103 = r103 | 4;
        goto L21
    L19:
        r103 = r103 | 2;
        goto L21
    L20:
        r103 = r103 | 1;
    L21:
        r102 = r102 + 1;
        goto L5
    L22:
        if (r103 != 0) goto L25;
        r103 = -1;
    L25:
        return nativeGetRecords(r103);
    L26:
        return null;
    }

    public static synchronized int init(b r100) {
        monitor-enter(ShadowHook.class);
    L31:
        th = move-exception;
        throw th;
    L5:
        if (inited == false) goto L10;
        int r101 = initErrno;     // Catch: Throwable -> L31
        monitor-exit(ShadowHook.class);
        return r101;
    L10:
        inited = true;     // Catch: Throwable -> L31
        long r102 = System.currentTimeMillis();     // Catch: Throwable -> L31
        if (r100 != null) goto L14;
        access$000();     // Catch: Throwable -> L31
        int r103 = access$100();     // Catch: Throwable -> L31
        b r104 = new b();     // Catch: Throwable -> L31
        r104.f270294a = r103;     // Catch: Throwable -> L31
        r104.f270295b = false;     // Catch: Throwable -> L31
        r104.f270296c = false;     // Catch: Throwable -> L31
        r104.f270297d = false;     // Catch: Throwable -> L31
        r100 = r104;
    L14:
        if (loadLibrary(r100) == true) goto L35;
        initErrno = 100;     // Catch: Throwable -> L31
        initCostMs = System.currentTimeMillis() - r102;     // Catch: Throwable -> L31
        int r105 = initErrno;     // Catch: Throwable -> L31
        monitor-exit(ShadowHook.class);
        return r105;
    L35:
        if (r100.f270297d == false) goto L21;
        nativeSetDisable(true);     // Catch: Throwable -> L26
    L21:
        boolean r106 = r100.f270296c;     // Catch: Throwable -> L26
        if (r106 == false) goto L24;
        nativeSetRecordable(r106);     // Catch: Throwable -> L26
    L24:
        initErrno = nativeInit(r100.f270294a, r100.f270295b);     // Catch: Throwable -> L26
    L28:
        initCostMs = System.currentTimeMillis() - r102;     // Catch: Throwable -> L31
        int r107 = initErrno;     // Catch: Throwable -> L31
        monitor-exit(ShadowHook.class);
        return r107;
    L27:
        initErrno = 101;     // Catch: Throwable -> L31
        goto L28
    }

    private static synchronized boolean loadLibrary(b r100) {
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

    public static void setDebuggable(boolean r100) {
        if (loadLibrary() == false) goto L6;
        nativeSetDebuggable(r100);
        return;
    }

    public static void setDisable(boolean r100) {
        if (loadLibrary() == false) goto L6;
        nativeSetDisable(r100);
        return;
    }

    public static void setRecordable(boolean r100) {
        if (loadLibrary() == false) goto L6;
        nativeSetRecordable(r100);
        return;
    }

    public static String toErrmsg(int r100) {
        if (r100 != 0) goto L6;
        return "OK";
    L6:
        if (r100 != 2) goto L10;
        return "Not initialized";
    L10:
        if (r100 != 100) goto L14;
        return "Load libshadowhook.so failed";
    L14:
        if (r100 != 101) goto L18;
        return "Init exception";
    L18:
        if (loadLibrary() == true) goto L20;
        return "Unknown";
    L20:
        return nativeToErrmsg(r100);
    }
}
