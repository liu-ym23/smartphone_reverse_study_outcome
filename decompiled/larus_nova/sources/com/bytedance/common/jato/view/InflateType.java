package com.bytedance.common.jato.view;

import androidx.core.app.NotificationCompat;
import r27.a;

/* JADX INFO: loaded from: classes15.dex */
public final enum InflateType extends Enum<InflateType> {
    private static final /* synthetic */ InflateType[] $VALUES = null;
    public static final InflateType create = null;
    public static final InflateType set = null;
    public static final InflateType stub = null;
    public static final InflateType sys = null;

    /* JADX INFO: renamed from: x2c, reason: collision with root package name */
    public static final InflateType f202961x2c = null;

    static {
        InflateType r100 = new InflateType("x2c", 0);
        f202961x2c = r100;
        InflateType r101 = new InflateType(NotificationCompat.CATEGORY_SYSTEM, 1);
        sys = r101;
        InflateType r102 = new InflateType("stub", 2);
        stub = r102;
        InflateType r103 = new InflateType("set", 3);
        set = r103;
        InflateType r104 = new InflateType("create", 4);
        create = r104;
        $VALUES = new InflateType[]{r100, r101, r102, r103, r104};
    }

    public static InflateType[] values() {
        return (InflateType[]) $VALUES.clone();
    }

    public static InflateType valueOf(String r100) {
        return (InflateType) a.a(InflateType.class, r100);
    }

    private InflateType(String r100, int r101) {
        super(r100, r101);
    }
}
