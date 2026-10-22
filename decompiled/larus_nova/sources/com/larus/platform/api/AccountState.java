package com.larus.platform.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;

/* JADX INFO: loaded from: classes31.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/platform/api/AccountState;", "", "<init>", "(Ljava/lang/String;I)V", "ONLINE", "OFFLINE", "platform_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AccountState extends Enum<AccountState> {
    public static final AccountState OFFLINE = null;
    public static final AccountState ONLINE = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccountState[] f364744a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f364745b = null;

    public static EnumEntries<AccountState> getEntries() {
        return f364745b;
    }

    static {
        AccountState r100 = new AccountState("ONLINE", 0);
        ONLINE = r100;
        AccountState r101 = new AccountState("OFFLINE", 1);
        OFFLINE = r101;
        AccountState[] r102 = {r100, r101};
        f364744a = r102;
        f364745b = EnumEntriesKt.enumEntries(r102);
    }

    public static AccountState[] values() {
        return (AccountState[]) f364744a.clone();
    }

    public static AccountState valueOf(String r100) {
        return (AccountState) r27.a.a(AccountState.class, r100);
    }

    public AccountState(String r100, int r101) {
        super(r100, r101);
    }
}
