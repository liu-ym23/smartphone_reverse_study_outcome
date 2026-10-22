package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum PublishFallbackOption extends Enum<PublishFallbackOption> {
    private static final /* synthetic */ PublishFallbackOption[] $VALUES = null;
    public static final PublishFallbackOption DISABLE = null;
    public static final PublishFallbackOption SIMULCAST_SMALL_VIDEO_ONLY = null;
    private int value;

    static {
        PublishFallbackOption r100 = new PublishFallbackOption("DISABLE", 0, 0);
        DISABLE = r100;
        PublishFallbackOption r101 = new PublishFallbackOption("SIMULCAST_SMALL_VIDEO_ONLY", 1, 1);
        SIMULCAST_SMALL_VIDEO_ONLY = r101;
        $VALUES = new PublishFallbackOption[]{r100, r101};
    }

    public static PublishFallbackOption[] values() {
        return (PublishFallbackOption[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static PublishFallbackOption fromId(int r100) {
        PublishFallbackOption[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L8;
        PublishFallbackOption r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L8:
        return null;
    }

    public static PublishFallbackOption valueOf(String r100) {
        return (PublishFallbackOption) a.a(PublishFallbackOption.class, r100);
    }

    private PublishFallbackOption(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
