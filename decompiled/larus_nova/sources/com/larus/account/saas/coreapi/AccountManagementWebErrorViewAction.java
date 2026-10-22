package com.larus.account.saas.coreapi;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/coreapi/AccountManagementWebErrorViewAction;", "", "REFRESH", "CLOSE", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public final enum AccountManagementWebErrorViewAction extends Enum<AccountManagementWebErrorViewAction> {
    public static final AccountManagementWebErrorViewAction CLOSE = null;
    public static final AccountManagementWebErrorViewAction REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccountManagementWebErrorViewAction[] f286302a = null;

    public static AccountManagementWebErrorViewAction valueOf(String r100) {
        return (AccountManagementWebErrorViewAction) a.a(AccountManagementWebErrorViewAction.class, r100);
    }

    public static AccountManagementWebErrorViewAction[] values() {
        return (AccountManagementWebErrorViewAction[]) f286302a.clone();
    }

    static {
        AccountManagementWebErrorViewAction r100 = new AccountManagementWebErrorViewAction("REFRESH", 0);
        REFRESH = r100;
        AccountManagementWebErrorViewAction r101 = new AccountManagementWebErrorViewAction("CLOSE", 1);
        CLOSE = r101;
        f286302a = new AccountManagementWebErrorViewAction[]{r100, r101};
    }

    public AccountManagementWebErrorViewAction(String r100, int r101) {
        super(r100, r101);
    }
}
