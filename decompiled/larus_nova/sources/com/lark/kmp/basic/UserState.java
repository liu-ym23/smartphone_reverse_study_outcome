package com.lark.kmp.basic;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes43.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0087\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/lark/kmp/basic/UserState;", "", "<init>", "(Ljava/lang/String;I)V", "OFFLINE", "ONLINE", "ABSENT", "PRE_ONLINE", "user-state-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserState extends Enum<UserState> {
    public static final UserState ABSENT = null;
    public static final UserState OFFLINE = null;
    public static final UserState ONLINE = null;
    public static final UserState PRE_ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserState[] f278577a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f278578b = null;

    public static EnumEntries<UserState> getEntries() {
        return f278578b;
    }

    static {
        UserState r100 = new UserState("OFFLINE", 0);
        OFFLINE = r100;
        UserState r101 = new UserState("ONLINE", 1);
        ONLINE = r101;
        UserState r102 = new UserState("ABSENT", 2);
        ABSENT = r102;
        UserState r103 = new UserState("PRE_ONLINE", 3);
        PRE_ONLINE = r103;
        UserState[] r104 = {r100, r101, r102, r103};
        f278577a = r104;
        f278578b = EnumEntriesKt.enumEntries(r104);
    }

    public static UserState[] values() {
        return (UserState[]) f278577a.clone();
    }

    public static UserState valueOf(String r100) {
        return (UserState) a.a(UserState.class, r100);
    }

    public UserState(String r100, int r101) {
        super(r100, r101);
    }
}
