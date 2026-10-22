package com.bytedance.push.event.sync;

/* JADX INFO: loaded from: classes21.dex */
public final enum UserExitsReason extends Enum<UserExitsReason> {
    public static final UserExitsReason BACK = null;
    public static final UserExitsReason HOME = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserExitsReason[] f266856a = null;
    public String exitsReasonStr;

    static {
        UserExitsReason r100 = new UserExitsReason("BACK", 0, "back");
        BACK = r100;
        UserExitsReason r101 = new UserExitsReason("HOME", 1, "home");
        HOME = r101;
        f266856a = new UserExitsReason[]{r100, r101};
    }

    public static UserExitsReason[] values() {
        return (UserExitsReason[]) f266856a.clone();
    }

    public static UserExitsReason valueOf(String r100) {
        return (UserExitsReason) r27.a.a(UserExitsReason.class, r100);
    }

    public UserExitsReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.exitsReasonStr = r102;
    }
}
