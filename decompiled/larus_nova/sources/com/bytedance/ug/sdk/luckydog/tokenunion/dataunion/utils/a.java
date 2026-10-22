package com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.text.TextUtils;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import java.util.HashSet;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class a {
    public static String a(Context r100, String r101) {
        if (TextUtils.isEmpty(r101) == true) goto L12;
        Set r102 = pm7.a.C7212a.f529851a.f529847a;
        if (r102 != null) goto L10;
        r102 = new HashSet();
    L10:
        if (r102.size() > 0) goto L34;
        um7.e.b("getUnionValue() return: pkgList.size()" + r102.size());
        goto L12
    L34:
        Account[] r103 = AccountManager.get(r100).getAccounts();     // Catch: Throwable -> L31
        int r104 = 0;
        if (r103 != null) goto L16;
    L18:
        boolean r105 = false;
    L19:
        if (r105 == true) goto L22;
        um7.e.b("getUnionValue() isOk false: return");     // Catch: Throwable -> L31
        return null;
    L22:
        int r106 = r103.length;     // Catch: Throwable -> L31
    L23:
        if (r104 >= r106) goto L33;
        Account r107 = r103[r104];     // Catch: Throwable -> L31
        um7.e.b("getUnionValue（） account.type = " + r107.type);     // Catch: Throwable -> L31
        if (r102.contains(r107.type) == false) goto L30;
        String r108 = AccountManager.get(r100).getUserData(r107, r101);     // Catch: Throwable -> L31
        if (TextUtils.isEmpty(r108) == true) goto L30;
        um7.e.b("getUnionValue(); value = " + r108 + ", account.type = " + r107.type);     // Catch: Throwable -> L31
        b.a(r101, r108, r107.type, DataUnionStrategy.UNION_ACCOUNT);     // Catch: Throwable -> L31
        return r108;
    L30:
        r104 = r104 + 1;
    L33:
        return null;
    L16:
        if (r103.length <= 0) goto L18;
        r105 = true;
    L31:
        th = move-exception;
        um7.e.b(th.getMessage());
    L12:
        return null;
    }

    public static void b(Context r100, String r101, String r102) {
        if (TextUtils.isEmpty(r101) == true) goto L20;
        String r103 = r100.getPackageName();     // Catch: Throwable -> L13
        Account[] r104 = AccountManager.get(r100).getAccountsByTypeForPackage(r103, r103);     // Catch: Throwable -> L13
        if (r104 != null) goto L9;
    L11:
        um7.e.b("setUnionValue() accounts is null;  pkgName = " + r103 + "; setUserData(); value = " + r102);     // Catch: Throwable -> L13
    L16:
        return;
    L9:
        if (r104.length <= 0) goto L11;
        AccountManager.get(r100).setUserData(r104[0], r101, r102);     // Catch: Throwable -> L13
        um7.e.b("setUnionValue() success; pkgName = " + r103 + "; setUserData(); value = " + r102);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        um7.e.a(th.getMessage());
        return;
    }
}
