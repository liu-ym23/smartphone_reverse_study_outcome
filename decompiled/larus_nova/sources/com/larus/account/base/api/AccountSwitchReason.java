package com.larus.account.base.api;

import kotlin.Metadata;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0086\u0081\u0002\u0018\u0000 \u00142\b\u0012\u0004\u0012\u00020\u00000\u0001:\u0001\u0014B\u0011\b\u0002\u0012\u0006\u0010\u0002\u001a\u00020\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0006\u0010\u0012\u001a\u00020\u0013R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010j\u0002\b\u0011¨\u0006\u0015"}, d2 = {"Lcom/larus/account/base/api/AccountSwitchReason;", "", "enterMethod", "", "<init>", "(Ljava/lang/String;ILjava/lang/String;)V", "getEnterMethod", "()Ljava/lang/String;", "SETTING", "SETTING_ACCOUNT_NAME", "SETTING_TOP", "DOUBAO_ACCOUNT_SETTING_PAGE", "ACCOUNT_NAME", "PROFILE_ACCOUNT_NAME", "LOGOUT", "AUTO_LOGOUT", "OS_CLOUD_ALIGN_POPUP", "UNKNOWN", "isLogout", "", "Companion", "api_release"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final enum AccountSwitchReason extends Enum<AccountSwitchReason> {
    public static final AccountSwitchReason ACCOUNT_NAME = null;
    public static final AccountSwitchReason AUTO_LOGOUT = null;
    public static final a Companion = null;
    public static final AccountSwitchReason DOUBAO_ACCOUNT_SETTING_PAGE = null;
    public static final AccountSwitchReason LOGOUT = null;
    public static final AccountSwitchReason OS_CLOUD_ALIGN_POPUP = null;
    public static final AccountSwitchReason PROFILE_ACCOUNT_NAME = null;
    public static final AccountSwitchReason SETTING = null;
    public static final AccountSwitchReason SETTING_ACCOUNT_NAME = null;
    public static final AccountSwitchReason SETTING_TOP = null;
    public static final AccountSwitchReason UNKNOWN = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ AccountSwitchReason[] f286090a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ EnumEntries f286091b = null;
    private final String enterMethod;

    public static final class a {
        public a() {
        }

        public static AccountSwitchReason a(String r100) {
            AccountSwitchReason[] r101 = AccountSwitchReason.values();
            int r102 = r101.length;
            int r103 = 0;
        L3:
            if (r103 >= r102) goto L13;
            AccountSwitchReason r104 = r101[r103];
            if (r104.isLogout() == false) goto L7;
        L9:
            boolean r105 = false;
        L10:
            if (r105 == true) goto L14;
            r103 = r103 + 1;
        L14:
            if (r104 == null) goto L16;
            return r104;
        L16:
            return AccountSwitchReason.UNKNOWN;
        L7:
            if (Intrinsics.areEqual(r104.getEnterMethod(), r100) == false) goto L9;
            r105 = true;
            goto L10
        L13:
            r104 = null;
            goto L14
        }
    }

    public static EnumEntries<AccountSwitchReason> getEntries() {
        return f286091b;
    }

    static {
        AccountSwitchReason r100 = new AccountSwitchReason("SETTING", 0, "setting");
        SETTING = r100;
        AccountSwitchReason r101 = new AccountSwitchReason("SETTING_ACCOUNT_NAME", 1, "setting_account_name");
        SETTING_ACCOUNT_NAME = r101;
        AccountSwitchReason r102 = new AccountSwitchReason("SETTING_TOP", 2, "setting_top");
        SETTING_TOP = r102;
        AccountSwitchReason r103 = new AccountSwitchReason("DOUBAO_ACCOUNT_SETTING_PAGE", 3, "doubao_account_setting_page");
        DOUBAO_ACCOUNT_SETTING_PAGE = r103;
        AccountSwitchReason r104 = new AccountSwitchReason("ACCOUNT_NAME", 4, "account_name");
        ACCOUNT_NAME = r104;
        AccountSwitchReason r105 = new AccountSwitchReason("PROFILE_ACCOUNT_NAME", 5, "profile_account_name");
        PROFILE_ACCOUNT_NAME = r105;
        AccountSwitchReason r110 = new AccountSwitchReason("LOGOUT", 6, "logout");
        LOGOUT = r110;
        AccountSwitchReason r111 = new AccountSwitchReason("AUTO_LOGOUT", 7, "auto_logout");
        AUTO_LOGOUT = r111;
        AccountSwitchReason r112 = new AccountSwitchReason("OS_CLOUD_ALIGN_POPUP", 8, "os_cloud_align_popup");
        OS_CLOUD_ALIGN_POPUP = r112;
        AccountSwitchReason r113 = new AccountSwitchReason("UNKNOWN", 9, "unknown");
        UNKNOWN = r113;
        AccountSwitchReason[] r106 = {r100, r101, r102, r103, r104, r105, r110, r111, r112, r113};
        f286090a = r106;
        f286091b = EnumEntriesKt.enumEntries(r106);
        Companion = new a();
    }

    public static AccountSwitchReason[] values() {
        return (AccountSwitchReason[]) f286090a.clone();
    }

    public final boolean isLogout() {
        if (this != LOGOUT) goto L5;
    L8:
        return true;
    L5:
        if (this == AUTO_LOGOUT) goto L8;
        return false;
    }

    public final String getEnterMethod() {
        return this.enterMethod;
    }

    public static AccountSwitchReason valueOf(String r100) {
        return (AccountSwitchReason) r27.a.a(AccountSwitchReason.class, r100);
    }

    public AccountSwitchReason(String r100, int r101, String r102) {
        super(r100, r101);
        this.enterMethod = r102;
    }
}
