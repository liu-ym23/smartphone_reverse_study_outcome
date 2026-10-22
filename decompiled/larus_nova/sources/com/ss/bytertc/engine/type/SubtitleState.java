package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubtitleState extends Enum<SubtitleState> {
    private static final /* synthetic */ SubtitleState[] $VALUES = null;
    public static final SubtitleState SUBTITLE_STATE_ERROR = null;
    public static final SubtitleState SUBTITLE_STATE_STARTED = null;
    public static final SubtitleState SUBTITLE_STATE_STOPED = null;
    private int value;

    static {
        SubtitleState r100 = new SubtitleState("SUBTITLE_STATE_STARTED", 0, 0);
        SUBTITLE_STATE_STARTED = r100;
        SubtitleState r101 = new SubtitleState("SUBTITLE_STATE_STOPED", 1, 1);
        SUBTITLE_STATE_STOPED = r101;
        SubtitleState r102 = new SubtitleState("SUBTITLE_STATE_ERROR", 2, 2);
        SUBTITLE_STATE_ERROR = r102;
        $VALUES = new SubtitleState[]{r100, r101, r102};
    }

    public static SubtitleState[] values() {
        return (SubtitleState[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SubtitleState fromId(int r100) {
        SubtitleState[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        SubtitleState r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return SUBTITLE_STATE_ERROR;
    }

    public static SubtitleState valueOf(String r100) {
        return (SubtitleState) a.a(SubtitleState.class, r100);
    }

    private SubtitleState(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
