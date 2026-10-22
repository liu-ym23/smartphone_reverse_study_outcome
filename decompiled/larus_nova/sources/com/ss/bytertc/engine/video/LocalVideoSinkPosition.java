package com.ss.bytertc.engine.video;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum LocalVideoSinkPosition extends Enum<LocalVideoSinkPosition> {
    private static final /* synthetic */ LocalVideoSinkPosition[] $VALUES = null;
    public static final LocalVideoSinkPosition AFTER_CAPTURE = null;
    public static final LocalVideoSinkPosition AFTER_PREPROCESS = null;
    private int value;

    static {
        LocalVideoSinkPosition r100 = new LocalVideoSinkPosition("AFTER_CAPTURE", 0, 0);
        AFTER_CAPTURE = r100;
        LocalVideoSinkPosition r101 = new LocalVideoSinkPosition("AFTER_PREPROCESS", 1, 1);
        AFTER_PREPROCESS = r101;
        $VALUES = new LocalVideoSinkPosition[]{r100, r101};
    }

    public static LocalVideoSinkPosition[] values() {
        return (LocalVideoSinkPosition[]) $VALUES.clone();
    }

    public int getValue() {
        return this.value;
    }

    public static LocalVideoSinkPosition convertFromInt(int r100) {
        return values()[r100];
    }

    public static LocalVideoSinkPosition valueOf(String r100) {
        return (LocalVideoSinkPosition) a.a(LocalVideoSinkPosition.class, r100);
    }

    private LocalVideoSinkPosition(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
