package com.volcengine.zeus.apm;

import org.json.JSONObject;

/* JADX INFO: loaded from: classes.dex */
public class ApmUtils {
    private static volatile AbsApm sApm;

    /* JADX INFO: loaded from: classes41.dex */
    public static class a extends AbsApm {
        @Override // com.volcengine.zeus.apm.AbsApm
        public final String getDid() {
            return "0";
        }

        @Override // com.volcengine.zeus.apm.AbsApm
        public final void init() {
        }

        @Override // com.volcengine.zeus.apm.AbsApm
        public final void monitorEvent(String r100, JSONObject r101, JSONObject r102, JSONObject r103) {
        }

        @Override // com.volcengine.zeus.apm.AbsApm
        public final void reportError(String r100, Throwable r101) {
        }

        public a() {
        }
    }

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

    public static synchronized void register(AbsApm r100) {
        monitor-enter(ApmUtils.class);
        sApm = r100;     // Catch: Throwable -> L7
        monitor-exit(ApmUtils.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }
}
