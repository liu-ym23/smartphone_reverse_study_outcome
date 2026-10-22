package com.ivy.ivykit.base.provider;

import kotlin.Metadata;
import r27.a;

/* JADX INFO: loaded from: classes23.dex */
public interface AccountServiceProvider {

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001j\u0002\b\u0002¨\u0006\u0003"}, d2 = {"Lcom/ivy/ivykit/base/provider/AccountServiceProvider$AccountType;", "", "Douyin", "ivy_base_release"}, k = 1, mv = {1, 7, 1})
    public static final enum AccountType extends Enum<AccountType> {
        public static final AccountType Douyin = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ AccountType[] f278362a = null;

        public static AccountType valueOf(String r100) {
            return (AccountType) a.a(AccountType.class, r100);
        }

        public static AccountType[] values() {
            return (AccountType[]) f278362a.clone();
        }

        static {
            AccountType r100 = new AccountType();
            Douyin = r100;
            f278362a = new AccountType[]{r100};
        }

        public AccountType() {
            super("Douyin", 0);
        }
    }

    boolean a(AccountType r100);

    String e();
}
