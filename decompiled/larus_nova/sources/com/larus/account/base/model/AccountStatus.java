package com.larus.account.base.model;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import r27.a;

/* JADX INFO: loaded from: classes3.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006¨\u0006\u0007"}, d2 = {"Lcom/larus/account/base/model/AccountStatus;", "", "<init>", "(Ljava/lang/String;I)V", "LOGGED_IN", "LOGGED_OUT", "LOGGED_FAIL", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AccountStatus extends Enum<AccountStatus> {
    public static final AccountStatus LOGGED_FAIL = null;
    public static final AccountStatus LOGGED_IN = null;
    public static final AccountStatus LOGGED_OUT = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccountStatus[] f286195a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286196b = null;

    public static EnumEntries<AccountStatus> getEntries() {
        return f286196b;
    }

    static {
        AccountStatus r100 = new AccountStatus("LOGGED_IN", 0);
        LOGGED_IN = r100;
        AccountStatus r101 = new AccountStatus("LOGGED_OUT", 1);
        LOGGED_OUT = r101;
        AccountStatus r102 = new AccountStatus("LOGGED_FAIL", 2);
        LOGGED_FAIL = r102;
        AccountStatus[] r103 = {r100, r101, r102};
        f286195a = r103;
        f286196b = EnumEntriesKt.enumEntries(r103);
    }

    public static AccountStatus[] values() {
        return (AccountStatus[]) f286195a.clone();
    }

    public static AccountStatus valueOf(String r100) {
        return (AccountStatus) a.a(AccountStatus.class, r100);
    }

    public AccountStatus(String r100, int r101) {
        super(r100, r101);
    }
}
