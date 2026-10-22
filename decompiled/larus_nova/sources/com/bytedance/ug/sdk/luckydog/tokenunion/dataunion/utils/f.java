package com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.utils;

import android.accounts.Account;
import android.accounts.AccountManager;
import android.content.Context;
import android.os.Build;
import android.os.Environment;
import android.text.TextUtils;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.ug.sdk.luckydog.tokenunion.dataunion.model.DataUnionStrategy;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: loaded from: classes22.dex */
public final class f {
    public static void a(Set<String> r110) {
        um7.e.b("tryCleanToken() on call;");
        HashSet r111 = (HashSet) r110;
        if (r111.size() <= 0) goto L123;
        Context r100 = pm7.b.a.f529854a.getContext();
        if (r100 == null) goto L122;
        String r101 = null;
        String r102 = e.a(r100).f272296a.getString("delete_invalid_key_list", null);
        if (r111.size() <= 0) goto L18;
        StringBuffer r103 = new StringBuffer();
        Iterator r104 = r111.iterator();
    L12:
        if (r104.hasNext() == false) goto L16;
        String r105 = (String) r104.next();
        if (TextUtils.isEmpty(r105) == true) goto L12;
        r103.append(r105);
        r103.append("/*");
        goto L12
    L16:
        r101 = r103.toString();
    L18:
        if (TextUtils.isEmpty(r102) == false) goto L20;
    L22:
        HashSet r106 = new HashSet();
        if (TextUtils.isEmpty(r102) == false) goto L99;
    L38:
        Iterator r112 = r111.iterator();
    L40:
        if (r112.hasNext() == false) goto L93;
        String r107 = (String) r112.next();
        if (TextUtils.isEmpty(r107) == true) goto L40;
        if (r106.contains(r107) == true) goto L40;
        um7.e.b("cleanValue() on call; key = " + r107);
        Context r108 = pm7.b.a.f529854a.getContext();
        if (r108 == null) goto L40;
        if (TextUtils.isEmpty(r107) == true) goto L40;
        e.a(r108).f272296a.edit().putString(r107, "").apply();
        um7.e.b("cleanValue() DataUnionSettings SP success");
        Set r109 = pm7.a.C7212a.f529851a.f529848b;
        if (r109 != null) goto L55;
        r109 = new HashSet();
    L55:
        if (r109.contains(DataUnionStrategy.UNION_ACCOUNT) == false) goto L72;
        if (TextUtils.isEmpty(r107) == false) goto L97;
    L70:
        um7.e.b("doSetUnionValue() DataUnionAccountUtils;");
        goto L72
    L97:
        String r113 = r108.getPackageName();     // Catch: Throwable -> L65
        Account[] r114 = AccountManager.get(r108).getAccountsByTypeForPackage(r113, r113);     // Catch: Throwable -> L65
        if (r114 != null) goto L63;
    L67:
        um7.e.b("cleanValue() accounts is null;  pkgName = " + r113 + "; setUserData();");     // Catch: Throwable -> L65
        goto L70
    L63:
        if (r114.length <= 0) goto L67;
        AccountManager.get(r108).setUserData(r114[0], r107, "");     // Catch: Throwable -> L65
        um7.e.b("cleanValue() success; pkgName = " + r113 + "; setUserData();");     // Catch: Throwable -> L65
    L65:
        th = move-exception;
        um7.e.a(th.getMessage());
    L72:
        if (r109.contains(DataUnionStrategy.UNION_FILE) == false) goto L40;
        if (TextUtils.isEmpty(r107) == false) goto L77;
    L92:
        um7.e.b("doSetUnionValue() DataUnionFileUtils;");
        goto L40
    L77:
        if (Build.VERSION.SDK_INT < 29) goto L95;
        um7.e.b("readFile(); sdk >= Q return");
        goto L92
    L95:
        if (c.c(r108) == true) goto L82;
    L84:
        boolean r115 = false;
    L85:
        if (r115 == false) goto L92;
        PolarisFileWrapper r116 = new PolarisFileWrapper(Environment.getExternalStorageDirectory(), c.a(r107));     // Catch: Throwable -> L90
        if (r116.exists() == false) goto L92;
        um7.e.b("cleanUnionValue(); delete success;");     // Catch: Throwable -> L90
        r116.delete();     // Catch: Throwable -> L90
        goto L92
    L82:
        if ("mounted".equals(Environment.getExternalStorageState()) == false) goto L84;
        r115 = true;
    L90:
        th = move-exception;
        um7.e.a(th.getMessage());
        goto L92
    L93:
        e.a(r100).f272296a.edit().putString("delete_invalid_key_list", r101).apply();
        return;
    L99:
        String[] r117 = r102.split("/*");     // Catch: Throwable -> L36
        if (r117 == null) goto L38;
        if (r117.length <= 0) goto L38;
        int r118 = r117.length;     // Catch: Throwable -> L36
        int r119 = 0;
    L31:
        if (r119 >= r118) goto L38;
        String r120 = r117[r119];     // Catch: Throwable -> L36
        if (TextUtils.isEmpty(r120) == true) goto L35;
        r106.add(r120);     // Catch: Throwable -> L36
    L35:
        r119 = r119 + 1;
    L36:
        th = move-exception;
        um7.e.a(th.getLocalizedMessage());
        goto L38
    L20:
        if (r102.equals(r101) == false) goto L22;
        return;
    L122:
        return;
    }
}
