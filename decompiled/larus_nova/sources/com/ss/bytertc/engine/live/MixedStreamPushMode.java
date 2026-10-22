package com.ss.bytertc.engine.live;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum MixedStreamPushMode extends Enum<MixedStreamPushMode> {
    private static final /* synthetic */ MixedStreamPushMode[] $VALUES = null;
    public static final MixedStreamPushMode ON_START_REQUEST = null;
    public static final MixedStreamPushMode ON_STREAM = null;
    private int pushMode;

    static {
        MixedStreamPushMode r100 = new MixedStreamPushMode("ON_STREAM", 0, 0);
        ON_STREAM = r100;
        MixedStreamPushMode r101 = new MixedStreamPushMode("ON_START_REQUEST", 1, 1);
        ON_START_REQUEST = r101;
        $VALUES = new MixedStreamPushMode[]{r100, r101};
    }

    public static MixedStreamPushMode[] values() {
        return (MixedStreamPushMode[]) $VALUES.clone();
    }

    public int getValue() {
        return this.pushMode;
    }

    public static MixedStreamPushMode valueOf(String r100) {
        return (MixedStreamPushMode) a.a(MixedStreamPushMode.class, r100);
    }

    private MixedStreamPushMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.pushMode = r102;
    }
}
