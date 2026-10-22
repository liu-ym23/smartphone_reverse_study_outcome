package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum SubtitleMode extends Enum<SubtitleMode> {
    private static final /* synthetic */ SubtitleMode[] $VALUES = null;
    public static final SubtitleMode SUBTITLE_MODE_RECOGINTE = null;
    public static final SubtitleMode SUBTITLE_MODE_TRANSLATION = null;
    private int value;

    static {
        SubtitleMode r100 = new SubtitleMode("SUBTITLE_MODE_RECOGINTE", 0, 0);
        SUBTITLE_MODE_RECOGINTE = r100;
        SubtitleMode r101 = new SubtitleMode("SUBTITLE_MODE_TRANSLATION", 1, 1);
        SUBTITLE_MODE_TRANSLATION = r101;
        $VALUES = new SubtitleMode[]{r100, r101};
    }

    public static SubtitleMode[] values() {
        return (SubtitleMode[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static SubtitleMode fromId(int r100) {
        SubtitleMode[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        SubtitleMode r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return SUBTITLE_MODE_RECOGINTE;
    }

    public static SubtitleMode valueOf(String r100) {
        return (SubtitleMode) a.a(SubtitleMode.class, r100);
    }

    private SubtitleMode(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
