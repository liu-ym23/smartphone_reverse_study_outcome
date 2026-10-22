package com.huawei.hms.aaid.utils;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.j;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class BaseUtils {
    private BaseUtils() {
    }

    public static void clearSubjectIds(Context r100) {
        i.a(r100).removeKey("subjectId");
    }

    public static void deleteAllTokenCache(Context r100) {
        i.a(r100).a();
    }

    public static boolean getProxyInit(Context r100) {
        return i.a(r100).getBoolean("_proxy_init");
    }

    public static String[] getSubjectIds(Context r100) {
        String r101 = i.a(r100).getString("subjectId");
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return new String[0];
    L7:
        return r101.split(",");
    }

    public static void initSecret(Context r100) {
        j.a(r100);
    }

    public static boolean isMainProc(Context r100) {
        String r101 = e.a(r100);
        String r102 = r100.getApplicationInfo().processName;
        HMSLog.i("BaseUtils", "main process name: " + r102 + ", current process name: " + r101);
        return r102.equals(r101);
    }

    public static void delLocalToken(Context r100, String r101) {
        i.a(r100).c(r101);
    }

    public static void deleteCacheData(Context r100, String r101) {
        i.a(r100).removeKey(r101);
    }

    public static String getLocalToken(Context r100, String r101) {
        return i.a(r100).b(r101);
    }

    public static void saveProxyInit(Context r100, boolean r101) {
        i.a(r100).saveBoolean("_proxy_init", r101);
    }

    public static String getCacheData(Context r100, String r101, boolean r102) {
        if (r102 == false) goto L6;
        return i.a(r100).a(r101);
    L6:
        return i.a(r100).getString(r101);
    }

    public static void saveToken(Context r100, String r101, String r102) {
        i.a(r100).b(r101, r102);
    }

    public static boolean saveCacheData(Context r100, String r101, String r102, boolean r103) {
        if (r103 == false) goto L6;
        return i.a(r100).a(r101, r102);
    L6:
        return i.a(r100).saveString(r101, r102);
    }
}
