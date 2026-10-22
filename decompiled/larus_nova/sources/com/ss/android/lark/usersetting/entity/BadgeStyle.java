package com.ss.android.lark.usersetting.entity;

/* JADX INFO: loaded from: classes38.dex */
public final enum BadgeStyle extends Enum<BadgeStyle> {
    public static final BadgeStyle STRONG_REMIND = null;
    public static final BadgeStyle WEAK_REMIND = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ BadgeStyle[] f444627a = null;
    private int value;

    static {
        BadgeStyle r100 = new BadgeStyle("WEAK_REMIND", 0, 1);
        WEAK_REMIND = r100;
        BadgeStyle r101 = new BadgeStyle("STRONG_REMIND", 1, 2);
        STRONG_REMIND = r101;
        f444627a = new BadgeStyle[]{r100, r101};
    }

    public static BadgeStyle[] values() {
        return (BadgeStyle[]) f444627a.clone();
    }

    public int getNumber() {
        return this.value;
    }

    public static BadgeStyle forNumber(int r100) {
        if (r100 == 1) goto L11;
        if (r100 == 2) goto L9;
        return STRONG_REMIND;
    L9:
        return STRONG_REMIND;
    L11:
        return WEAK_REMIND;
    }

    public static BadgeStyle valueOf(String r100) {
        return (BadgeStyle) r27.a.a(BadgeStyle.class, r100);
    }

    public static BadgeStyle valueOf(int r100) {
        return forNumber(r100);
    }

    public BadgeStyle(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
