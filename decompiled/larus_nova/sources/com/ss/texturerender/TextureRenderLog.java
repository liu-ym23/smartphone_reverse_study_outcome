package com.ss.texturerender;

import java.util.Iterator;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes40.dex */
public class TextureRenderLog {
    public static final int LOG_DEBUG = 1;
    public static final int LOG_ERROR = 6;
    public static final int LOG_INFO = 2;
    public static final int LOG_KILL = 4;
    public static final int LOG_TRACK = 3;
    public static final int LOG_VERBOSE = 0;
    public static final int LOG_WARN = 5;
    private static OnLogListener mLogListener;
    private static ConcurrentHashMap<Integer, OnLogListenerExt> mLogListenerExts;

    public interface OnLogListener {
        int log(String r100, String r101);
    }

    public interface OnLogListenerExt {
        void d(String r100, String r101);

        void e(String r100, String r101);

        void i(String r100, String r101);

        void k(String r100, String r101);

        void t(String r100, String r101);

        void w(String r100, String r101);
    }

    public TextureRenderLog() {
    }

    static {
        mLogListenerExts = new ConcurrentHashMap();
    }

    public static String getLogTag(Object r100) {
        return "TR_" + r100.getClass().getSimpleName() + "@" + Integer.toHexString(r100.hashCode());
    }

    public static synchronized void setOnLogListener(OnLogListener r100) {
        monitor-enter(TextureRenderLog.class);
        mLogListener = r100;     // Catch: Throwable -> L7
        monitor-exit(TextureRenderLog.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public static synchronized void setOnLogListenerExt(int r100, OnLogListenerExt r101) {
        monitor-enter(TextureRenderLog.class);
        ConcurrentHashMap<Integer, OnLogListenerExt> r102 = mLogListenerExts;     // Catch: Throwable -> L9
        if (r102 == null) goto L7;
        r102.put(Integer.valueOf(r100), r101);     // Catch: Throwable -> L9
    L7:
        monitor-exit(TextureRenderLog.class);
        return;
    L9:
        th = move-exception;
        throw th;
    }

    public static void d(int r100, String r101, String r102) {
        log(1, r100, r101, r102);
    }

    public static void e(int r100, String r101, String r102) {
        log(6, r100, r101, r102);
    }

    public static void i(int r100, String r101, String r102) {
        log(2, r100, r101, r102);
    }

    public static void k(int r100, String r101, String r102) {
        log(4, r100, r101, r102);
    }

    public static void t(int r100, String r101, String r102) {
        log(3, r100, r101, r102);
    }

    public static void w(int r100, String r101, String r102) {
        log(5, r100, r101, r102);
    }

    private static synchronized void log(int r100, int r101, String r102, String r103) {
        monitor-enter(TextureRenderLog.class);
        ConcurrentHashMap<Integer, OnLogListenerExt> r104 = mLogListenerExts;     // Catch: Throwable -> L23
        if (r104 != null) goto L7;
    L18:
        OnLogListener r105 = mLogListener;     // Catch: Throwable -> L23
        if (r105 == null) goto L21;
        r105.log(r102, r103);     // Catch: Throwable -> L23
    L21:
        monitor-exit(TextureRenderLog.class);
        return;
    L7:
        if (r101 != (-1)) goto L12;
        Iterator<OnLogListenerExt> r106 = r104.values().iterator();     // Catch: Throwable -> L23
    L10:
        if (r106.hasNext() == false) goto L18;
        notifyListener(r100, r106.next(), r102, r103);     // Catch: Throwable -> L23
        goto L10
    L12:
        OnLogListenerExt r107 = r104.get(Integer.valueOf(r101));     // Catch: Throwable -> L23
        if (r107 == null) goto L15;
        notifyListener(r100, r107, r102, r103);     // Catch: Throwable -> L23
    L15:
        OnLogListenerExt r108 = mLogListenerExts.get(-1);     // Catch: Throwable -> L23
        if (r108 == null) goto L18;
        notifyListener(r100, r108, r102, r103);     // Catch: Throwable -> L23
    L23:
        th = move-exception;
        throw th;
    }

    private static void notifyListener(int r100, OnLogListenerExt r101, String r102, String r103) {
        switch(r100) {
            case 1: goto L9;
            case 2: goto L8;
            case 3: goto L7;
            case 4: goto L6;
            case 5: goto L5;
            case 6: goto L4;
            default: goto L16;
        };
    L4:
        r101.e(r102, r103);
        return;
    L5:
        r101.w(r102, r103);
        return;
    L6:
        r101.k(r102, r103);
        return;
    L7:
        r101.t(r102, r103);
        return;
    L8:
        r101.i(r102, r103);
        return;
    L9:
        r101.d(r102, r103);
        return;
    }
}
