package com.larus.bmhome.chat.setting.bean;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes25.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/larus/bmhome/chat/setting/bean/UserConfigPullReason;", "", "value", "", "<init>", "(Ljava/lang/String;II)V", "getValue", "()I", "STARTUP", "POLLING", "NOTIFIED", "api_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserConfigPullReason extends Enum<UserConfigPullReason> {
    public static final UserConfigPullReason NOTIFIED = null;
    public static final UserConfigPullReason POLLING = null;
    public static final UserConfigPullReason STARTUP = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserConfigPullReason[] f308905a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f308906b = null;
    private final int value;

    public static EnumEntries<UserConfigPullReason> getEntries() {
        return f308906b;
    }

    static {
        UserConfigPullReason r100 = new UserConfigPullReason("STARTUP", 0, 1);
        STARTUP = r100;
        UserConfigPullReason r101 = new UserConfigPullReason("POLLING", 1, 2);
        POLLING = r101;
        UserConfigPullReason r102 = new UserConfigPullReason("NOTIFIED", 2, 3);
        NOTIFIED = r102;
        UserConfigPullReason[] r103 = {r100, r101, r102};
        f308905a = r103;
        f308906b = EnumEntriesKt.enumEntries(r103);
    }

    public static UserConfigPullReason[] values() {
        return (UserConfigPullReason[]) f308905a.clone();
    }

    public final int getValue() {
        return this.value;
    }

    public static UserConfigPullReason valueOf(String r100) {
        return (UserConfigPullReason) a.a(UserConfigPullReason.class, r100);
    }

    public UserConfigPullReason(String r100, int r101, int r102) {
        super(r100, r101);
        this.value = r102;
    }
}
