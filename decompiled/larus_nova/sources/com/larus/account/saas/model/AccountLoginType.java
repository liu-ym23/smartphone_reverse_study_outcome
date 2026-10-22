package com.larus.account.saas.model;

import com.android.ttcjpaysdk.kmp.common.pay_ability.cancel_retain.api.CancelRetainContactInfoFunctions;
import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0005\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005¨\u0006\u0006"}, d2 = {"Lcom/larus/account/saas/model/AccountLoginType;", "", CancelRetainContactInfoFunctions.SMS, "SAFE_ONE_LOGIN", "GROUP_AUTH", "H5_JSB", "account-saas-api_release"}, k = 1, mv = {1, 7, 1})
public final enum AccountLoginType extends Enum<AccountLoginType> {
    public static final AccountLoginType GROUP_AUTH = null;
    public static final AccountLoginType H5_JSB = null;
    public static final AccountLoginType SAFE_ONE_LOGIN = null;
    public static final AccountLoginType SMS = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccountLoginType[] f286458a = null;

    public static AccountLoginType valueOf(String r100) {
        return (AccountLoginType) a.a(AccountLoginType.class, r100);
    }

    public static AccountLoginType[] values() {
        return (AccountLoginType[]) f286458a.clone();
    }

    static {
        AccountLoginType r100 = new AccountLoginType(CancelRetainContactInfoFunctions.SMS, 0);
        SMS = r100;
        AccountLoginType r101 = new AccountLoginType("SAFE_ONE_LOGIN", 1);
        SAFE_ONE_LOGIN = r101;
        AccountLoginType r102 = new AccountLoginType("GROUP_AUTH", 2);
        GROUP_AUTH = r102;
        AccountLoginType r103 = new AccountLoginType("H5_JSB", 3);
        H5_JSB = r103;
        f286458a = new AccountLoginType[]{r100, r101, r102, r103};
    }

    public AccountLoginType(String r100, int r101) {
        super(r100, r101);
    }
}
