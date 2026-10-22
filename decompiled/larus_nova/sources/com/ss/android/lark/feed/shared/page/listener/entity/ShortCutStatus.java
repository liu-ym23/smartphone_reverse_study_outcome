package com.ss.android.lark.feed.shared.page.listener.entity;

import r27.a;

/* JADX INFO: loaded from: classes35.dex */
public final enum ShortCutStatus extends Enum<ShortCutStatus> {
    public static final ShortCutStatus CLOSE = null;
    public static final ShortCutStatus OPEN = null;
    public static final ShortCutStatus OPENDING = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ ShortCutStatus[] f421443a = null;
    private int value;

    static {
        ShortCutStatus r100 = new ShortCutStatus("OPEN", 0, 1);
        OPEN = r100;
        ShortCutStatus r101 = new ShortCutStatus("OPENDING", 1, 2);
        OPENDING = r101;
        ShortCutStatus r102 = new ShortCutStatus("CLOSE", 2, 3);
        CLOSE = r102;
        f421443a = new ShortCutStatus[]{r100, r101, r102};
    }

    public static ShortCutStatus[] values() {
        return (ShortCutStatus[]) f421443a.clone();
    }

    public static ShortCutStatus valueOf(String r100) {
        return (ShortCutStatus) a.a(ShortCutStatus.class, r100);
    }

    public ShortCutStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
