package com.ss.videoarch.liveplayer.log;

/* JADX INFO: loaded from: classes38.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static VeLivePlayerLogConfig.VeLivePlayerLogLevel f459431a;

    static {
        f459431a = VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelInfo;
    }

    private c() {
    }

    public static void setLogLevel(VeLivePlayerLogConfig.VeLivePlayerLogLevel r100) {
        f459431a = r100;
        e.setLogLevel(r100);
    }

    public static void d(String r100, String r101) {
        if (e.isVolcBaseLogExist() == false) goto L5;
        e.d(r100, r101);
        return;
    L5:
        VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelDebug.compareTo(f459431a);
    }

    public static void e(String r100, String r101) {
        if (e.isVolcBaseLogExist() == false) goto L5;
        e.e(r100, r101);
        return;
    L5:
        VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelError.compareTo(f459431a);
    }

    public static void i(String r100, String r101) {
        if (e.isVolcBaseLogExist() == false) goto L5;
        e.i(r100, r101);
        return;
    L5:
        VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelInfo.compareTo(f459431a);
    }

    public static void t(String r100, String r101) {
        if (VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelInfo.compareTo(f459431a) < 0) goto L21;
        if (r100 != null) goto L6;
        return;
    L6:
        if (r100.length() == 0) goto L26;
        if (r101 != null) goto L9;
        return;
    L9:
        if (r101.length() == 0) goto L29;
        int r102 = r101.length();
        if (r102 > 3072) goto L14;
        i(r100, r101);
        return;
    L14:
        int r103 = 0;
    L15:
        if (r103 >= r102) goto L30;
        int r104 = r103 + 3072;
        if (r104 > r102) goto L19;
        int r105 = r104;
    L20:
        i(r100, r101.substring(r103, r105));
        r103 = r104;
        goto L15
    L19:
        r105 = r102;
        goto L20
    L30:
        return;
    L29:
        return;
    L26:
        return;
    }

    public static void w(String r100, String r101) {
        if (e.isVolcBaseLogExist() == false) goto L5;
        e.w(r100, r101);
        return;
    L5:
        VeLivePlayerLogConfig.VeLivePlayerLogLevel.VeLivePlayerLogLevelWarn.compareTo(f459431a);
    }
}
