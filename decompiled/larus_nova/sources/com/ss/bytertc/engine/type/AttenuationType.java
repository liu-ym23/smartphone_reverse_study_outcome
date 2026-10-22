package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum AttenuationType extends Enum<AttenuationType> {
    private static final /* synthetic */ AttenuationType[] $VALUES = null;
    public static final AttenuationType ATTENUATION_TYPE_EXPONENTIAL = null;
    public static final AttenuationType ATTENUATION_TYPE_LINEAR = null;
    public static final AttenuationType ATTENUATION_TYPE_NONE = null;
    private final int value;

    static {
        AttenuationType r100 = new AttenuationType("ATTENUATION_TYPE_NONE", 0, 0);
        ATTENUATION_TYPE_NONE = r100;
        AttenuationType r101 = new AttenuationType("ATTENUATION_TYPE_LINEAR", 1, 1);
        ATTENUATION_TYPE_LINEAR = r101;
        AttenuationType r102 = new AttenuationType("ATTENUATION_TYPE_EXPONENTIAL", 2, 2);
        ATTENUATION_TYPE_EXPONENTIAL = r102;
        $VALUES = new AttenuationType[]{r100, r101, r102};
    }

    public static AttenuationType[] values() {
        return (AttenuationType[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static AttenuationType valueOf(String r100) {
        return (AttenuationType) a.a(AttenuationType.class, r100);
    }

    private AttenuationType(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
