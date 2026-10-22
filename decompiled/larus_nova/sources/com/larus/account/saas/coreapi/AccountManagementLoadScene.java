package com.larus.account.saas.coreapi;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0003\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003¨\u0006\u0004"}, d2 = {"Lcom/larus/account/saas/coreapi/AccountManagementLoadScene;", "", "FIRST", "REFRESH", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public final enum AccountManagementLoadScene extends Enum<AccountManagementLoadScene> {
    public static final AccountManagementLoadScene FIRST = null;
    public static final AccountManagementLoadScene REFRESH = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccountManagementLoadScene[] f286301a = null;

    public static AccountManagementLoadScene valueOf(String r100) {
        return (AccountManagementLoadScene) a.a(AccountManagementLoadScene.class, r100);
    }

    public static AccountManagementLoadScene[] values() {
        return (AccountManagementLoadScene[]) f286301a.clone();
    }

    static {
        AccountManagementLoadScene r100 = new AccountManagementLoadScene("FIRST", 0);
        FIRST = r100;
        AccountManagementLoadScene r101 = new AccountManagementLoadScene("REFRESH", 1);
        REFRESH = r101;
        f286301a = new AccountManagementLoadScene[]{r100, r101};
    }

    public AccountManagementLoadScene(String r100, int r101) {
        super(r100, r101);
    }
}
