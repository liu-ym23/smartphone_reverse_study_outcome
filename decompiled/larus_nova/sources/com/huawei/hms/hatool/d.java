package com.huawei.hms.hatool;

import android.content.Context;
import android.content.SharedPreferences;
import android.text.TextUtils;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class d {
    public static long a(Context r100, String r101, String r102, long r103) {
        if (r100 != null) goto L4;
    L12:
        v.f("hmsSdk", "context is null or spName empty or spkey is empty");
        return r103;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (TextUtils.isEmpty(r102) == true) goto L12;
        SharedPreferences r104 = b(r100, r101);
        if (r104 != null) goto L11;
        return r103;
    L11:
        return r104.getLong(r102, r103);
    }

    public static String a(Context r100, String r101, String r102, String r103) {
        if (r100 != null) goto L4;
    L12:
        v.f("hmsSdk", "context is null or spName empty or spkey is empty");
        return r103;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (TextUtils.isEmpty(r102) == true) goto L12;
        SharedPreferences r104 = b(r100, r101);
        if (r104 != null) goto L11;
        return r103;
    L11:
        return r104.getString(r102, r103);
    }

    public static Map<String, ?> a(Context r100, String r101) {
        return b(r100, r101).getAll();
    }

    public static void a(Context r100, String r101, String... r102) {
        if (r100 != null) goto L5;
    L23:
        String r103 = "clearData(): parameter error.context,spname";
    L9:
        v.f("hmsSdk", r103);
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L23;
        if (r102 != null) goto L11;
        r103 = "clearData(): No data need to be deleted,keys is null";
        goto L9
    L11:
        SharedPreferences r104 = b(r100, r101);
        if (r104 == null) goto L22;
        SharedPreferences.Editor r105 = r104.edit();
        if (r102.length != 0) goto L16;
        r105.clear();
        r105.commit();
        return;
    L16:
        int r106 = r102.length;
        int r107 = 0;
    L17:
        if (r107 >= r106) goto L28;
        String r108 = r102[r107];
        if (r104.contains(r108) == false) goto L21;
        r105.remove(r108);
        r105.commit();
    L21:
        r107 = r107 + 1;
        goto L17
    L28:
        return;
    }

    private static SharedPreferences b(Context r100, String r101) {
        return r100.getSharedPreferences(c(r100, r101), 0);
    }

    public static void b(Context r100, String r101, String r102, long r103) {
        if (r100 != null) goto L4;
    L12:
        v.f("hmsSdk", "context is null or spName empty or spkey is empty");
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (TextUtils.isEmpty(r102) == true) goto L12;
        SharedPreferences r104 = b(r100, r101);
        if (r104 == null) goto L14;
        SharedPreferences.Editor r105 = r104.edit();
        r105.putLong(r102, r103);
        r105.commit();
        return;
    }

    public static void b(Context r100, String r101, String r102, String r103) {
        if (r100 != null) goto L4;
    L12:
        v.e("hmsSdk", "context is null or spName empty or spkey is empty");
        return;
    L4:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        if (TextUtils.isEmpty(r102) == true) goto L12;
        SharedPreferences r104 = b(r100, r101);
        if (r104 == null) goto L14;
        SharedPreferences.Editor r105 = r104.edit();
        r105.putString(r102, r103);
        r105.commit();
        return;
    }

    public static String c(Context r100, String r101) {
        String r102 = r100.getPackageName();
        String r103 = a1.n("_hms_config_tag", "oper");
        if (TextUtils.isEmpty(r103) == false) goto L7;
        return "hms_" + r101 + "_" + r102;
    L7:
        return "hms_" + r101 + "_" + r102 + "_" + r103;
    }
}
