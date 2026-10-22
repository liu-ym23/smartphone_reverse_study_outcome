package com.bytedance.ee.plugin.common.log;

/* JADX INFO: loaded from: classes19.dex */
public final class PluginLog {
    private static volatile ILog sLog;

    public PluginLog() {
    }

    static {
        sLog = new DefaultLog();
    }

    public static void d(String r100) {
        sLog.d(r100);
    }

    public static void e(String r100) {
        sLog.e(r100);
    }

    public static void i(String r100) {
        sLog.i(r100);
    }

    public static void installLog(ILog r100) {
        if (r100 == null) goto L5;
        sLog = r100;
        return;
    }

    public static void e(Throwable r100) {
        sLog.e(r100);
    }
}
