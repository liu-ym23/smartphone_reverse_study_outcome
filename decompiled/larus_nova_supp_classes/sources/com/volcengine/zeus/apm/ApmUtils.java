package com.volcengine.zeus.apm;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public class ApmUtils {
    private static volatile AbsApm sApm;

    public ApmUtils() {
    }

    public static AbsApm getApmInstance() {
        if (sApm != null) goto L15;
        monitor-enter(AbsApm.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (sApm != null) goto L9;
        sApm = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(AbsApm.class);     // Catch: Throwable -> L11
    L15:
        return sApm;
    }

    public static synchronized void register(AbsApm r1) {
        monitor-enter(ApmUtils.class);
        sApm = r1;     // Catch: Throwable -> L7
        monitor-exit(ApmUtils.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
