package com.bytedance.bdlocation.trace;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public class StackTraceRecorder {
    private static volatile String sColdBootStackTrace = "";

    public StackTraceRecorder() {
    }

    public static String getColdBootStackTrace() {
        return sColdBootStackTrace;
    }

    public static void setColdBootStackTrace(String r0) {
        sColdBootStackTrace = r0;
    }
}
