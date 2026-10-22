package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamPushTargetType extends Enum<MixedStreamPushTargetType> {
    private static final /* synthetic */ MixedStreamPushTargetType[] $VALUES = null;
    public static final MixedStreamPushTargetType PUSH_TO_CDN = null;
    public static final MixedStreamPushTargetType PUSH_TO_WTN = null;
    private int targetType;

    static {
        MixedStreamPushTargetType r100 = new MixedStreamPushTargetType("PUSH_TO_CDN", 0, 0);
        PUSH_TO_CDN = r100;
        MixedStreamPushTargetType r101 = new MixedStreamPushTargetType("PUSH_TO_WTN", 1, 1);
        PUSH_TO_WTN = r101;
        $VALUES = new MixedStreamPushTargetType[]{r100, r101};
    }

    public static MixedStreamPushTargetType[] values() {
        return (MixedStreamPushTargetType[]) $VALUES.clone();
    }

    public int value() {
        return this.targetType;
    }

    public static MixedStreamPushTargetType valueOf(String r100) {
        return (MixedStreamPushTargetType) a.a(MixedStreamPushTargetType.class, r100);
    }

    private MixedStreamPushTargetType(String r100, int r101, int r102) {
        super(r100, r101);
        this.targetType = r102;
    }
}
