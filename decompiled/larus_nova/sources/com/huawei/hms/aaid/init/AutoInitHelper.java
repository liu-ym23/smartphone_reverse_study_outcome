package com.huawei.hms.aaid.init;

import android.content.Context;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class AutoInitHelper {
    public AutoInitHelper() {
    }

    public static void doAutoInit(Context r100) {
    L7:
        e = move-exception;
        HMSLog.e("AutoInit", "Push init failed", e);
        return;
    L4:
        if (isAutoInitEnabled(r100) == false) goto L12;
        HMSLog.i("AutoInit", "Push init start");     // Catch: Exception -> L7
        new Thread(new a(r100)).start();     // Catch: Exception -> L7
        return;
    }

    public static boolean isAutoInitEnabled(Context r100) {
        i r101 = i.a(r100);
        if (r101.containsKey("push_kit_auto_init_enabled") == true) goto L5;
        return r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128).metaData.getBoolean("push_kit_auto_init_enabled");
    L8:
        return false;
    L5:
        return r101.getBoolean("push_kit_auto_init_enabled");
    }

    public static void setAutoInitEnabled(Context r100, boolean r101) {
        i r102 = i.a(r100);
        boolean r103 = r102.getBoolean("push_kit_auto_init_enabled");
        r102.saveBoolean("push_kit_auto_init_enabled", r101);
        if (r101 == false) goto L7;
        if (r103 == true) goto L8;
        doAutoInit(r100);
        return;
    L8:
        return;
    }
}
