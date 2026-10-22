package com.ss.android.lark.passportc.entity;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes37.dex */
@Metadata(d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\b\n\u0002\b\b\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\n¨\u0006\u000b"}, d2 = {"Lcom/ss/android/lark/passportc/entity/UserState;", "", "state", "", "<init>", "(Ljava/lang/String;II)V", "getState", "()I", "ABSENT", "OFFLINE", "ONLINE", "passport-container-manager_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserState extends Enum<UserState> {
    public static final UserState ABSENT = null;
    public static final UserState OFFLINE = null;
    public static final UserState ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserState[] f438139a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f438140b = null;
    private final int state;

    public static EnumEntries<UserState> getEntries() {
        return f438140b;
    }

    static {
        UserState r100 = new UserState("ABSENT", 0, -1);
        ABSENT = r100;
        UserState r101 = new UserState("OFFLINE", 1, 0);
        OFFLINE = r101;
        UserState r102 = new UserState("ONLINE", 2, 1);
        ONLINE = r102;
        UserState[] r103 = {r100, r101, r102};
        f438139a = r103;
        f438140b = EnumEntriesKt.enumEntries(r103);
    }

    public static UserState[] values() {
        return (UserState[]) f438139a.clone();
    }

    public final int getState() {
        return this.state;
    }

    public static UserState valueOf(String r100) {
        return (UserState) a.a(UserState.class, r100);
    }

    public UserState(String r100, int r101, int r102) {
        super(r100, r101);
        this.state = r102;
    }
}
