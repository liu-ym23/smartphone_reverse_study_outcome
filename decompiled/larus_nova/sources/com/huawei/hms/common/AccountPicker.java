package com.huawei.hms.common;

import android.accounts.Account;
import android.content.Intent;
import android.os.Bundle;
import com.huawei.hms.support.log.HMSLog;
import java.util.ArrayList;

/* JADX INFO: loaded from: classes23.dex */
public final class AccountPicker {
    public static final String CHOOSE_ACCOUNT = "com.huawei.hms.common.account.CHOOSE_ACCOUNT";
    public static final int CUSTOM_THEME_ACCOUNT_CHIPS = 2;
    public static final int CUSTOM_THEME_GAMES = 1;
    public static final int CUSTOM_THEME_NONE = 0;
    public static final String EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING = "authTokenType";
    public static final String EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE = "addAccountOptions";
    public static final String EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY = "addAccountRequiredFeatures";
    public static final String EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST = "allowableAccounts";
    public static final String EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY = "allowableAccountTypes";
    public static final String EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT = "alwaysPromptForAccount";
    public static final String EXTRA_DESCRIPTION_TEXT_OVERRIDE = "descriptionTextOverride";
    public static final String EXTRA_HOSTED_DOMAIN_FILTER = "hostedDomainFilter";
    public static final String EXTRA_IS_ACCOUNT_CHIPS_ACCOUNT_PICKER = "pickedFromAccountChips";
    public static final String EXTRA_OVERRIDE_CUSTOM_THEME = "overrideCustomTheme";
    public static final String EXTRA_OVERRIDE_THEME = "overrideTheme";
    public static final String EXTRA_REAL_CLIENT_PACKAGE = "realClientPackage";
    public static final String EXTRA_SELECTED_ACCOUNT = "selectedAccount";
    public static final String EXTRA_SET_HMS_CORE_ACCOUNT = "setHmsCoreAccount";
    public static final int THEME_DEFAULT = 0;
    public static final int THEME_LIGHT = 1;

    private AccountPicker() {
    }

    public static Intent newChooseAccountIntent(Account r100, ArrayList<Account> r101, String[] r102, boolean r103, String r104, String r105, String[] r106, Bundle r110) {
        Intent r107 = new Intent();
        r107.setAction(CHOOSE_ACCOUNT);
        r107.setPackage(PackageConstants.SERVICES_PACKAGE_ALL_SCENE);     // Catch: IllegalArgumentException -> L5
    L6:
        r107.putExtra(EXTRA_ALLOWABLE_ACCOUNTS_ARRAYLIST, r101);
        r107.putExtra(EXTRA_ALLOWABLE_ACCOUNT_TYPES_STRING_ARRAY, r102);
        r107.putExtra(EXTRA_ADD_ACCOUNT_OPTIONS_BUNDLE, r110);
        r107.putExtra(EXTRA_SELECTED_ACCOUNT, r100);
        r107.putExtra(EXTRA_ALWAYS_PROMPT_FOR_ACCOUNT, r103);
        r107.putExtra(EXTRA_DESCRIPTION_TEXT_OVERRIDE, r104);
        r107.putExtra(EXTRA_ADD_ACCOUNT_AUTH_TOKEN_TYPE_STRING, r105);
        r107.putExtra(EXTRA_ADD_ACCOUNT_REQUIRED_FEATURES_STRING_ARRAY, r106);
        r107.putExtra(EXTRA_SET_HMS_CORE_ACCOUNT, false);
        r107.putExtra(EXTRA_OVERRIDE_THEME, 0);
        r107.putExtra(EXTRA_OVERRIDE_CUSTOM_THEME, 0);
        return r107;
    L5:
        HMSLog.e("AccountPicker", "IllegalArgumentException when newChooseAccountIntent intent.setPackage");
        goto L6
    }
}
