package com.bytedance.mobsec.metasec.ml;

/* JADX INFO: loaded from: classes3.dex */
public class MSC {
    public static final long AB_INIT_SWITCH_ON = 2;
    public static final long AB_MOTION_EVENT_ON = 256;
    public static final long AB_SWITCH_OFF = 0;
    public static final long DEFAULT_DELAY_TIME = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile long f265555a = 2;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static volatile long f265556b;

    public MSC() {
    }

    public static long GetABSwitch() {
        return f265555a;
    }

    public static long GetDelayTime() {
        return f265556b;
    }

    public static void SetABSwitch(long r100) {
        f265555a = r100;
    }

    public static void SetDelayTime(long r100) {
        f265556b = r100;
    }
}
