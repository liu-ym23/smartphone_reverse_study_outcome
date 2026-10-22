package com.bytedance.lark.sdk.log;

import com.larus.utils.logger.FLogger;
import com.ss.android.rust.molten.ffi.MoltenLogger;
import kotlin.Deprecated;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
@Deprecated(message = "Due to the removal of `molten_android`, Global of `molten-log` initialization moves here, but it will be replaced by `molten-log` in future soon.")
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\b\u0007\u0018\u0000 \u00052\u00020\u0001:\u0002\u0004\u0005B\u0007¢\u0006\u0004\b\u0002\u0010\u0003¨\u0006\u0006"}, d2 = {"Lcom/bytedance/lark/sdk/log/MoltenLog;", "", "<init>", "()V", "Level", "Global", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class MoltenLog {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f254200a = 0;

    @Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003J\r\u0010\t\u001a\u00020\nH\u0000¢\u0006\u0002\b\u000bj\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007j\u0002\b\b¨\u0006\f"}, d2 = {"Lcom/bytedance/lark/sdk/log/MoltenLog$Level;", "", "<init>", "(Ljava/lang/String;I)V", "TRACE", "DEBUG", "INFO", "WARN", "ERROR", "value", "", "value$molten_log_release", "molten-log_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum Level extends Enum<Level> {
        public static final Level DEBUG = null;
        public static final Level ERROR = null;
        public static final Level INFO = null;
        public static final Level TRACE = null;
        public static final Level WARN = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Level[] f254201a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f254202b = null;

        public /* synthetic */ class a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final /* synthetic */ int[] f254203a = null;

            static {
                int[] r100 = new int[Level.values().length];
                r100[Level.TRACE.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
            L15:
                r100[Level.DEBUG.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
            L23:
                r100[Level.INFO.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
            L17:
                r100[Level.WARN.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
            L19:
                r100[Level.ERROR.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
            L8:
                f254203a = r100;
            }
        }

        public static EnumEntries<Level> getEntries() {
            return f254202b;
        }

        static {
            Level r100 = new Level("TRACE", 0);
            TRACE = r100;
            Level r101 = new Level("DEBUG", 1);
            DEBUG = r101;
            Level r102 = new Level("INFO", 2);
            INFO = r102;
            Level r103 = new Level("WARN", 3);
            WARN = r103;
            Level r104 = new Level("ERROR", 4);
            ERROR = r104;
            Level[] r105 = {r100, r101, r102, r103, r104};
            f254201a = r105;
            f254202b = EnumEntriesKt.enumEntries(r105);
        }

        public static Level[] values() {
            return (Level[]) f254201a.clone();
        }

        public final int value$molten_log_release() {
            int r100 = a.f254203a[ordinal()];
            int r101 = 1;
            if (r100 == 1) goto L15;
            r101 = 2;
            if (r100 == 2) goto L15;
            r101 = 3;
            if (r100 == 3) goto L15;
            r101 = 4;
            if (r100 == 4) goto L15;
            r101 = 5;
            if (r100 == 5) goto L15;
            throw new NoWhenBranchMatchedException();
        L15:
            return r101;
        }

        public static Level valueOf(String r100) {
            return (Level) r27.a.a(Level.class, r100);
        }

        public Level(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
        public a() {
        }

        @JvmStatic
        public static void a(Level r100) {
            Intrinsics.checkNotNullParameter(r100, "level");
            MoltenLog.a(r100.value$molten_log_release());     // Catch: UnsatisfiedLinkError -> L5
            return;
        L5:
            e = move-exception;
            String r101 = e.getMessage();
            System.out.println(r101);
            System.out.println("`setMaxLevel` not support.");
        }
    }

    public MoltenLog() {
    }

    @JvmStatic
    private static final native void _clientEnableConsole();

    @JvmStatic
    private static final native void _clientLogClose();

    @JvmStatic
    private static final native void _clientLogFlush();

    @JvmStatic
    private static final native void _clientLogV2(String r100, String r101, String r102, String r103, int r104, long r105, String r106, String r107, int r108, String r110, String r111, int r112);

    @JvmStatic
    private static final native void _clientSetMaxLevel(int r100);

    @JvmStatic
    private static final native int _initClientLog(String r100, String r101, int r102, String r103, String r104);

    static {
        a r100 = new a();
        monitor-enter(r100);
        String r101 = System.getProperty(MoltenLogger.LIB_NAME_PROPERTY);     // Catch: Throwable -> L12
        if (r101 == null) goto L8;
        monitor-exit(r100);
    L10:
        Intrinsics.checkNotNullParameter(r101, "libName");
        FLogger r102 = FLogger.f375446a;
        r102.i("Librarian_loadLib", "loadLibrary start libName -> ".concat(r101));
        com.bytedance.librarian.a.c(r101);
        r102.i("Librarian_loadLib", "loadLibrary success by librarian -> ".concat(r101));
        return;
    L8:
        r101 = "molten_log";
        monitor-exit(r100);
    L12:
        th = move-exception;
        throw th;
    }

    public static final /* synthetic */ void a(int r100) {
        _clientSetMaxLevel(r100);
    }

    public static final /* synthetic */ int b(String r100, String r101) {
        return _initClientLog(r100, r101, 0, null, null);
    }
}
