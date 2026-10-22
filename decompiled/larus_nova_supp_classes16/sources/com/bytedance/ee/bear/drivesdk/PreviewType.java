package com.bytedance.ee.bear.drivesdk;

import r27.a;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes16.dex */
public final enum PreviewType extends Enum<PreviewType> {
    public static final PreviewType NATIVE = null;
    public static final PreviewType TRANFORM = null;
    public static final PreviewType UNSUPPORT = null;
    public static final /* synthetic */ PreviewType[] a = null;

    static {
        PreviewType r0 = new PreviewType("NATIVE", 0);
        NATIVE = r0;
        PreviewType r1 = new PreviewType("TRANFORM", 1);
        TRANFORM = r1;
        PreviewType r3 = new PreviewType("UNSUPPORT", 2);
        UNSUPPORT = r3;
        a = new PreviewType[]{r0, r1, r3};
    }

    public static PreviewType[] values() {
        return (PreviewType[]) a.clone();
    }

    public static PreviewType valueOf(String r1) {
        return (PreviewType) a.a(PreviewType.class, r1);
    }

    public PreviewType(String r1, int r2) {
        super(r1, r2);
    }
}
