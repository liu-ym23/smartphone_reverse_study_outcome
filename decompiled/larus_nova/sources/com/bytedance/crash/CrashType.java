package com.bytedance.crash;

import com.obric.miniapp.alarm.AccountType;
import com.obric.miniapp.alarm.AlarmSessionType;
import com.ss.android.common.applog.EventVerify;

/* JADX INFO: loaded from: classes.dex */
public final enum CrashType extends Enum<CrashType> {
    private static final /* synthetic */ CrashType[] $VALUES = null;
    public static final CrashType ALL = null;
    public static final CrashType ANR = null;
    public static final CrashType ASAN = null;
    public static final CrashType BLOCK = null;
    public static final CrashType CJAVA = null;
    public static final CrashType COREDUMP = null;
    public static final CrashType CUSTOM_JAVA = null;
    public static final CrashType DART = null;
    public static final CrashType ENSURE = null;
    public static final CrashType EVENT = null;
    public static final CrashType GAME = null;
    public static final CrashType JAVA = null;
    public static final CrashType LAUNCH = null;
    public static final CrashType NATIVE = null;
    public static final CrashType NATIVE_CUSTOMIZE = null;
    public static final CrashType OOM = null;
    public static final CrashType TSAN = null;
    public static final CrashType UNKNOWN = null;
    private final String mName;

    static {
        CrashType r100 = new CrashType("LAUNCH", 0, EventVerify.TYPE_LAUNCH);
        LAUNCH = r100;
        CrashType r101 = new CrashType("JAVA", 1, "java");
        JAVA = r101;
        CrashType r102 = new CrashType("NATIVE", 2, "native");
        NATIVE = r102;
        CrashType r103 = new CrashType("ASAN", 3, "asan");
        ASAN = r103;
        CrashType r104 = new CrashType("TSAN", 4, "tsan");
        TSAN = r104;
        CrashType r105 = new CrashType("ANR", 5, "anr");
        ANR = r105;
        CrashType r110 = new CrashType("NATIVE_CUSTOMIZE", 6, "ensure_zip");
        NATIVE_CUSTOMIZE = r110;
        CrashType r111 = new CrashType("BLOCK", 7, "block");
        BLOCK = r111;
        CrashType r112 = new CrashType("ENSURE", 8, "ensure");
        ENSURE = r112;
        CrashType r113 = new CrashType("DART", 9, "dart");
        DART = r113;
        CrashType r114 = new CrashType("GAME", 10, "game");
        GAME = r114;
        CrashType r106 = new CrashType("CUSTOM_JAVA", 11, "custom_java");
        CUSTOM_JAVA = r106;
        CrashType r107 = new CrashType("OOM", 12, "oom");
        OOM = r107;
        CrashType r108 = new CrashType("CJAVA", 13, "cjava");
        CJAVA = r108;
        CrashType r109 = new CrashType("COREDUMP", 14, "coredump");
        COREDUMP = r109;
        CrashType r115 = new CrashType(AlarmSessionType.EVENT, 15, "event");
        EVENT = r115;
        CrashType r116 = new CrashType(AccountType.ALL, 16, "all");
        ALL = r116;
        CrashType r117 = new CrashType("UNKNOWN", 17, "unknown");
        UNKNOWN = r117;
        $VALUES = new CrashType[]{r100, r101, r102, r103, r104, r105, r110, r111, r112, r113, r114, r106, r107, r108, r109, r115, r116, r117};
    }

    public static CrashType[] values() {
        return (CrashType[]) $VALUES.clone();
    }

    @Override // java.lang.Enum
    public String toString() {
        return getName();
    }

    public String getName() {
        return this.mName;
    }

    public static CrashType getType(String r100) {
        return valueOf(r100.toUpperCase());
    L5:
        return UNKNOWN;
    }

    public static CrashType valueOf(String r100) {
        return (CrashType) r27.a.a(CrashType.class, r100);
    }

    private CrashType(String r100, int r101, String r102) {
        super(r100, r101);
        this.mName = r102;
    }
}
