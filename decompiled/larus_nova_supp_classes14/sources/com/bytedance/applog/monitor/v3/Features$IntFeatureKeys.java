package com.bytedance.applog.monitor.v3;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final enum Features$IntFeatureKeys extends Enum<Features$IntFeatureKeys> {
    public static final Features$IntFeatureKeys REPORT_INTERVAL = null;
    public static final /* synthetic */ Features$IntFeatureKeys[] a = null;
    private final int length;
    private final int position;

    static {
        Features$IntFeatureKeys r0 = new Features$IntFeatureKeys();
        REPORT_INTERVAL = r0;
        a = new Features$IntFeatureKeys[]{r0};
    }

    public Features$IntFeatureKeys() {
        super("REPORT_INTERVAL", 0);
        this.position = 19;
        this.length = 2;
    }

    public static Features$IntFeatureKeys[] values() {
        return (Features$IntFeatureKeys[]) a.clone();
    }

    public static Features$IntFeatureKeys valueOf(String r1) {
        return (Features$IntFeatureKeys) a.a(Features$IntFeatureKeys.class, r1);
    }

    public int toBits(int r5, int r6) {
        int r2 = 0;
        if (r6 < (1 << this.length)) goto L8;
        r6 = 1;
        int r0 = 0;
    L6:
        if (r0 >= this.length) goto L8;
        r6 = r6 & (1 << r0);
        r0 = r0 + 1;
    L8:
        int r1 = 1;
    L10:
        if (r2 >= this.length) goto L13;
        r1 = r1 & (1 << r2);
        r2 = r2 + 1;
        goto L10
    L13:
        return (r5 & (~r1)) | (r6 << this.position);
    }
}
