package com.lynx.devtool.recorder;

/* JADX INFO: loaded from: classes32.dex */
public class LynxRecorderEnv {
    private static LynxRecorderEnv instance;
    public String lynxRecorderUrlPrefix;
    public String mUriKey;

    public static synchronized LynxRecorderEnv getInstance() {
        monitor-enter(LynxRecorderEnv.class);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (instance != null) goto L7;
        instance = new LynxRecorderEnv();     // Catch: Throwable -> L10
    L7:
        LynxRecorderEnv r100 = instance;     // Catch: Throwable -> L10
        monitor-exit(LynxRecorderEnv.class);
        return r100;
    }

    public LynxRecorderEnv() {
        this.mUriKey = "uri";
        this.lynxRecorderUrlPrefix = "file://lynxrecorder?";
    }
}
