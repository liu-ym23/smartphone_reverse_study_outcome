package com.ss.bytertc.engine.type;

import r27.a;

/* JADX INFO: loaded from: classes40.dex */
public final enum UserVisibilityChangeError extends Enum<UserVisibilityChangeError> {
    private static final /* synthetic */ UserVisibilityChangeError[] $VALUES = null;
    public static final UserVisibilityChangeError OK = null;
    public static final UserVisibilityChangeError TOO_MANY_VISIBLE_USER = null;
    public static final UserVisibilityChangeError UNKNOWN = null;
    private int value;

    static {
        UserVisibilityChangeError r100 = new UserVisibilityChangeError("OK", 0, 0);
        OK = r100;
        UserVisibilityChangeError r101 = new UserVisibilityChangeError("UNKNOWN", 1, 1);
        UNKNOWN = r101;
        UserVisibilityChangeError r102 = new UserVisibilityChangeError("TOO_MANY_VISIBLE_USER", 2, 2);
        TOO_MANY_VISIBLE_USER = r102;
        $VALUES = new UserVisibilityChangeError[]{r100, r101, r102};
    }

    public static UserVisibilityChangeError[] values() {
        return (UserVisibilityChangeError[]) $VALUES.clone();
    }

    public int value() {
        return this.value;
    }

    public static UserVisibilityChangeError fromId(int r100) {
        UserVisibilityChangeError[] r101 = values();
        int r102 = r101.length;
        int r103 = 0;
    L3:
        if (r103 >= r102) goto L9;
        UserVisibilityChangeError r104 = r101[r103];
        if (r104.value() == r100) goto L6;
        r103 = r103 + 1;
        goto L3
    L6:
        return r104;
    L9:
        return UNKNOWN;
    }

    public static UserVisibilityChangeError valueOf(String r100) {
        return (UserVisibilityChangeError) a.a(UserVisibilityChangeError.class, r100);
    }

    private UserVisibilityChangeError(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
