package com.huawei.hms.opendevice;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.agconnect.config.AGConnectServicesConfig;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.HmsMessaging;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import java.util.UUID;

/* JADX INFO: loaded from: classes23.dex */
public class b {
    public static DeleteTokenReq a(Context r100) {
        return a(r100, null, null, null, null);
    }

    public static synchronized String b(Context r100) {
        monitor-enter(b.class);
        PushPreferences r101 = new PushPreferences(r100, "aaid");     // Catch: Throwable -> L10
        if (r101.containsKey("aaid") == false) goto L7;
        String r102 = r101.getString("aaid");     // Catch: Throwable -> L10
    L8:
        monitor-exit(b.class);
        return r102;
    L7:
        r102 = UUID.randomUUID().toString();     // Catch: Throwable -> L10
        r101.saveString("aaid", r102);     // Catch: Throwable -> L10
        r101.saveLong("creationTime", Long.valueOf(System.currentTimeMillis()));     // Catch: Throwable -> L10
    L10:
        th = move-exception;
        throw th;
    }

    public static String c(Context r100) {
        return AGConnectServicesConfig.fromContext(r100).getString("client/project_id");
    }

    public static boolean d(Context r100) {
        ApplicationInfo r101 = r100.getPackageManager().getApplicationInfo(r100.getPackageName(), 128);     // Catch: Throwable -> L10
        if (r101 == null) goto L9;
        Bundle r102 = r101.metaData;     // Catch: Throwable -> L10
        if (r102 == null) goto L9;
        if (TextUtils.isEmpty(r102.getString("com.huawei.hms.client.service.name:base")) == true) goto L9;
        return true;
    L9:
        return false;
    L10:
        HMSLog.e(HmsInstanceId.TAG, "isIntegratedBaseSdk failed.");
        return true;
    }

    public static DeleteTokenReq a(Context r100, String r101) {
        return a(r100, null, null, r101, null);
    }

    public static TokenReq b(Context r100, String r101) {
        return b(r100, null, null, r101, null);
    }

    public static DeleteTokenReq a(Context r100, String r101, String r102) {
        return a(r100, r101, null, null, r102);
    }

    public static TokenReq b(Context r100, String r101, String r102) {
        return b(r100, r101, null, null, r102);
    }

    public static DeleteTokenReq a(Context r100, String r101, String r102, String r103, String r104) {
        DeleteTokenReq r105 = new DeleteTokenReq();
        r105.setAppId(r101);
        r105.setScope(r104);
        r105.setProjectId(r102);
        r105.setPkgName(r100.getPackageName());
        r105.setSubjectId(r103);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r105.setAppId(Util.getAppId(r100));
    L6:
        if (TextUtils.isEmpty(r104) == false) goto L9;
        r105.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r105.setProjectId(c(r100));
    L11:
        return r105;
    }

    public static TokenReq b(Context r100, String r101, String r102, String r103, String r104) {
        TokenReq r105 = new TokenReq();
        r105.setPackageName(r100.getPackageName());
        r105.setAppId(r101);
        r105.setScope(r104);
        r105.setProjectId(r102);
        r105.setSubjectId(r103);
        r105.setMultiSender(false);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        r105.setAppId(Util.getAppId(r100));
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L9;
        r105.setProjectId(c(r100));
    L9:
        if (TextUtils.isEmpty(r104) == false) goto L11;
        r105.setScope(HmsMessaging.DEFAULT_TOKEN_SCOPE);
    L11:
        i r106 = i.a(r100);
        if (r106.getBoolean("hasRequestAgreement") == true) goto L14;
        r105.setFirstTime(true);
        r106.saveBoolean("hasRequestAgreement", true);
    L15:
        return r105;
    L14:
        r105.setFirstTime(false);
        goto L15
    }
}
