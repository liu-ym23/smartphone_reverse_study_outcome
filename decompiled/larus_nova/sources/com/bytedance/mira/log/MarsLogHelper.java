package com.bytedance.mira.log;

/* JADX INFO: loaded from: classes21.dex */
public class MarsLogHelper {
    static MarsLogger logger;
    static MarsReporter reporter;

    public MarsLogHelper() {
    }

    static {
        logger = new MarsLogger();
        reporter = new MarsReporter();
    }

    public static MarsLogger getLogger() {
        return logger;
    }

    public static MarsReporter getReporter() {
        return reporter;
    }

    public static void setLogger(MarsLogger r100) {
        if (r100 == null) goto L5;
        logger = r100;
        return;
    }

    public static void setReporter(MarsReporter r100) {
        if (r100 == null) goto L5;
        reporter = r100;
        return;
    }
}
