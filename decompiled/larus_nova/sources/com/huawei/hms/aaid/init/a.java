package com.huawei.hms.aaid.init;

import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.opendevice.k;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Util;
import com.larus.apm.impl.protector.RunnableProtector;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class a implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f276831a;

    @Override // java.lang.Runnable
    public void run() {
        com_huawei_hms_aaid_init_a_com_larus_apm_impl_protector_RunnableLancet_run(this);
    }

    public void com_huawei_hms_aaid_init_a__run$___twin___() {
        int r100 = ErrorEnum.SUCCESS.getInternalCode();     // Catch: Exception -> L21
        String r101 = null;
        r101 = HmsInstanceId.getInstance(this.f276831a).getToken(Util.getAppId(this.f276831a), null);     // Catch: ApiException -> L8 Exception -> L21
        HMSLog.i("AutoInit", "Push init succeed");     // Catch: ApiException -> L8 Exception -> L21
        if (TextUtils.isEmpty(r101) == false) goto L26;
        return;
    L26:
        Bundle r102 = this.f276831a.getPackageManager().getApplicationInfo(this.f276831a.getPackageName(), 128).metaData;     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
        if (r102 != null) goto L13;
    L17:
        HMSLog.i("AutoInit", "push kit sdk not exists");     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
    L25:
        return;
    L13:
        if (r102.getString("com.huawei.hms.client.service.name:push") == null) goto L17;
        Intent r103 = new Intent("com.huawei.push.action.MESSAGING_EVENT");     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
        r103.setPackage(this.f276831a.getPackageName());     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
        Bundle r104 = new Bundle();     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
        r104.putString("message_type", "new_token");     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
        r104.putString(RemoteMessageConst.DEVICE_TOKEN, r101);     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
        r104.putInt("error", r100);     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
        if (new k().a(this.f276831a, r104, r103) == true) goto L25;
        HMSLog.e("AutoInit", "start service failed");     // Catch: PackageManager.NameNotFoundException -> L19 Exception -> L21
    L19:
        HMSLog.i("AutoInit", "push kit sdk not exists");     // Catch: Exception -> L21
        return;
    L8:
        e = move-exception;
        r100 = e.getStatusCode();     // Catch: Exception -> L21
        HMSLog.e("AutoInit", "new Push init failed");     // Catch: Exception -> L21
    L21:
        e = move-exception;
        HMSLog.e("AutoInit", "Push init failed", e);
    }

    public a(Context r100) {
        this.f276831a = r100;
    }

    @Skip({"com.ss.android.ugc.bytex.pthread+"})
    public static void com_huawei_hms_aaid_init_a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
        r100.com_huawei_hms_aaid_init_a__run$___twin___();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
