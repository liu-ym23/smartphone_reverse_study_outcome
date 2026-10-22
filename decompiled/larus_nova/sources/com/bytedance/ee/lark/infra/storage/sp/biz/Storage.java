package com.bytedance.ee.lark.infra.storage.sp.biz;

import android.content.Context;
import android.content.SharedPreferences;
import com.bytedance.ee.lark.infra.foundation.log.AppBrandLogger;
import com.ss.android.lark.opmonitor.service.OPMonitor;
import hs5.a;
import hs5.b;
import ncb.d;

/* JADX INFO: loaded from: classes19.dex */
public class Storage {
    private static a mUserScopeStorage;

    public Storage() {
    }

    public static String getStorageFilePrefix(String r100) {
        int r101 = ds5.a.f469864a;
        return r100;
    }

    public static a getUserScopeStorage(Context r100) {
        if (mUserScopeStorage != null) goto L15;
        monitor-enter(b.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (mUserScopeStorage != null) goto L9;
        mUserScopeStorage = new b(r100);     // Catch: Throwable -> L11
    L9:
        monitor-exit(b.class);     // Catch: Throwable -> L11
    L15:
        return mUserScopeStorage;
    }

    public static SharedPreferences getStorageByName(Context r100, String r101) {
        if (r100 == null) goto L22;
        int r102 = 0;
        return r100.getSharedPreferences(r101, 0);
    L7:
        e = move-exception;
        AppBrandLogger.e("MMKVUtil", new Object[]{com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, "spName", r101, e});
        OPMonitor r103 = new OPMonitor(d.f518705a).addCategoryValue("spName", r101);
        StackTraceElement[] r104 = e.getStackTrace();
        StringBuilder r105 = new StringBuilder();
        if (r104 == null) goto L16;
        int r106 = r104.length;
        int r107 = 0;
    L11:
        if (r102 >= r106) goto L16;
        r105.append(r104[r102]);
        r105.append("\n");
        r107 = r107 + 1;
        if (r107 >= 10) goto L16;
        r102 = r102 + 1;
    L16:
        r103.addCategoryValue("stackTrace", r105.toString()).addCategoryValue("message", e.getMessage()).flush();
        return new gs5.a();
    L22:
        return new gs5.a();
    }
}
