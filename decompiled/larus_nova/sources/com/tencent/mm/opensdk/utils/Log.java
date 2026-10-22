package com.tencent.mm.opensdk.utils;

/* JADX INFO: loaded from: classes40.dex */
public class Log {
    private static ILog logImpl;

    public Log() {
    }

    public static void d(String r100, String r101) {
        ILog r102 = logImpl;
        if (r102 == null) goto L7;
        r102.d(r100, r101);
        return;
    }

    public static void e(String r100, String r101) {
        ILog r102 = logImpl;
        if (r102 == null) goto L7;
        r102.e(r100, r101);
        return;
    }

    public static void i(String r100, String r101) {
        ILog r102 = logImpl;
        if (r102 == null) goto L7;
        r102.i(r100, r101);
        return;
    }

    public static void setLogImpl(ILog r100) {
        logImpl = r100;
    }

    public static void v(String r100, String r101) {
        ILog r102 = logImpl;
        if (r102 == null) goto L7;
        r102.v(r100, r101);
        return;
    }

    public static void w(String r100, String r101) {
        ILog r102 = logImpl;
        if (r102 == null) goto L7;
        r102.w(r100, r101);
        return;
    }
}
