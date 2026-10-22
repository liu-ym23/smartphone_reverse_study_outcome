package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubscribeMode extends Enum<SubscribeMode> {
    private static final /* synthetic */ SubscribeMode[] $VALUES = null;
    public static final SubscribeMode AUTO_SUBSCRIBE_MODE = null;
    public static final SubscribeMode MANUAL_SUBSCRIBE_MODE = null;
    private int value;

    static {
        SubscribeMode r100 = new SubscribeMode("AUTO_SUBSCRIBE_MODE", 0, 0);
        AUTO_SUBSCRIBE_MODE = r100;
        SubscribeMode r101 = new SubscribeMode("MANUAL_SUBSCRIBE_MODE", 1, 1);
        MANUAL_SUBSCRIBE_MODE = r101;
        $VALUES = new SubscribeMode[]{r100, r101};
    }

    public static SubscribeMode[] values() {
        return (SubscribeMode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SubscribeMode valueOf(String r100) {
        return (SubscribeMode) a.a(SubscribeMode.class, r100);
    }

    private SubscribeMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
