package com.bytedance.apm.launch;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum DefaultLaunchMode extends Enum<DefaultLaunchMode> {
    public static final DefaultLaunchMode CLOD_LAUNCH = null;
    public static final DefaultLaunchMode HOT_LAUNCH = null;
    public static final DefaultLaunchMode UNKNOWN_LAUNCH = null;
    public static final DefaultLaunchMode WARM_LAUNCH = null;
    public static final /* synthetic */ DefaultLaunchMode[] a = null;

    static {
        DefaultLaunchMode r0 = new DefaultLaunchMode("UNKNOWN_LAUNCH", 0);
        UNKNOWN_LAUNCH = r0;
        DefaultLaunchMode r1 = new DefaultLaunchMode("CLOD_LAUNCH", 1);
        CLOD_LAUNCH = r1;
        DefaultLaunchMode r3 = new DefaultLaunchMode("WARM_LAUNCH", 2);
        WARM_LAUNCH = r3;
        DefaultLaunchMode r5 = new DefaultLaunchMode("HOT_LAUNCH", 3);
        HOT_LAUNCH = r5;
        a = new DefaultLaunchMode[]{r0, r1, r3, r5};
    }

    public static DefaultLaunchMode[] values() {
        return (DefaultLaunchMode[]) a.clone();
    }

    public static DefaultLaunchMode valueOf(String r1) {
        return (DefaultLaunchMode) a.a(DefaultLaunchMode.class, r1);
    }

    public DefaultLaunchMode(String r1, int r2) {
        super(r1, r2);
    }
}
