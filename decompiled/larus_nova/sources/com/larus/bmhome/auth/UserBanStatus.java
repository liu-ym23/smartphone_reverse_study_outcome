package com.larus.bmhome.auth;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\n\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/bmhome/auth/UserBanStatus;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "Default", "Baned", "Appealing", "AppealFailed", "Mute", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserBanStatus extends Enum<UserBanStatus> {
    public static final UserBanStatus AppealFailed = null;
    public static final UserBanStatus Appealing = null;
    public static final UserBanStatus Baned = null;
    public static final UserBanStatus Default = null;
    public static final UserBanStatus Mute = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserBanStatus[] f295741a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f295742b = null;
    private final int value;

    public static EnumEntries<UserBanStatus> getEntries() {
        return f295742b;
    }

    static {
        UserBanStatus r100 = new UserBanStatus("Default", 0, 0);
        Default = r100;
        UserBanStatus r101 = new UserBanStatus("Baned", 1, 1);
        Baned = r101;
        UserBanStatus r102 = new UserBanStatus("Appealing", 2, 2);
        Appealing = r102;
        UserBanStatus r103 = new UserBanStatus("AppealFailed", 3, 3);
        AppealFailed = r103;
        UserBanStatus r104 = new UserBanStatus("Mute", 4, 4);
        Mute = r104;
        UserBanStatus[] r105 = {r100, r101, r102, r103, r104};
        f295741a = r105;
        f295742b = EnumEntriesKt.enumEntries(r105);
    }

    public static UserBanStatus[] values() {
        return (UserBanStatus[]) f295741a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserBanStatus valueOf(String r100) {
        return (UserBanStatus) r27.a.a(UserBanStatus.class, r100);
    }

    public UserBanStatus(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
