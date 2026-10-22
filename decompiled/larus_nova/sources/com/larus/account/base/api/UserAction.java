package com.larus.account.base.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/account/base/api/UserAction;", "", "<init>", "(Ljava/lang/String;I)V", "USER_LOGIN", "USER_LOGOUT", "ACCOUNT_SWITCH", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum UserAction extends Enum<UserAction> {
    public static final UserAction ACCOUNT_SWITCH = null;
    public static final UserAction USER_LOGIN = null;
    public static final UserAction USER_LOGOUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ UserAction[] f286103a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286104b = null;

    public static EnumEntries<UserAction> getEntries() {
        return f286104b;
    }

    static {
        UserAction r100 = new UserAction("USER_LOGIN", 0);
        USER_LOGIN = r100;
        UserAction r101 = new UserAction("USER_LOGOUT", 1);
        USER_LOGOUT = r101;
        UserAction r102 = new UserAction("ACCOUNT_SWITCH", 2);
        ACCOUNT_SWITCH = r102;
        UserAction[] r103 = {r100, r101, r102};
        f286103a = r103;
        f286104b = EnumEntriesKt.enumEntries(r103);
    }

    public static UserAction[] values() {
        return (UserAction[]) f286103a.clone();
    }

    public static UserAction valueOf(String r100) {
        return (UserAction) a.a(UserAction.class, r100);
    }

    public UserAction(String r100, int r101) {
        super(r100, r101);
    }
}
