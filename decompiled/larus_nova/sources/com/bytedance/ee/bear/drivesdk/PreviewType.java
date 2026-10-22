package com.bytedance.ee.bear.drivesdk;

import r27.a;

/* JADX INFO: loaded from: classes16.dex */
public final enum PreviewType extends Enum<PreviewType> {
    public static final PreviewType NATIVE = null;
    public static final PreviewType TRANFORM = null;
    public static final PreviewType UNSUPPORT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ PreviewType[] f225984a = null;

    static {
        PreviewType r100 = new PreviewType("NATIVE", 0);
        NATIVE = r100;
        PreviewType r101 = new PreviewType("TRANFORM", 1);
        TRANFORM = r101;
        PreviewType r102 = new PreviewType("UNSUPPORT", 2);
        UNSUPPORT = r102;
        f225984a = new PreviewType[]{r100, r101, r102};
    }

    public static PreviewType[] values() {
        return (PreviewType[]) f225984a.clone();
    }

    public static PreviewType valueOf(String r100) {
        return (PreviewType) a.a(PreviewType.class, r100);
    }

    public PreviewType(String r100, int r101) {
        super(r100, r101);
    }
}
