package com.huawei.hms.push;

import android.content.Context;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.HmsInstanceId;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.plugin.PushProxy;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.ha.PushAnalyticsCenter;
import com.huawei.hms.push.utils.ha.PushBaseAnalytics;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class l {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final String f277620a = "l";

    private static Bundle a(Context r100, String r101, String r102) {
        Bundle r103 = new Bundle();
        r103.putString("sdkVer", String.valueOf(61300300));
        r103.putString("pkgName", r100.getPackageName());
        r103.putString("aaid", HmsInstanceId.getInstance(r100).getId());
        PushProxy r104 = ProxyCenter.getProxy();
        if (r104 == null) goto L5;
        r103.putString("proxyType", r104.getProxyType());
    L5:
        r103.putString(RemoteMessageConst.MSGID, r101);
        if (TextUtils.isEmpty(r102) == true) goto L8;
        r103.putString(RemoteMessageConst.ANALYTIC_INFO, r102);
    L8:
        return r103;
    }

    public static void a(Context r100, Bundle r101, String r102) {
        if (r101 != null) goto L4;
        return;
    L4:
        PushBaseAnalytics r103 = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (r103 != null) goto L7;
        return;
    L7:
        r101.putString("sdk_version", String.valueOf(61300300));
        HMSLog.i(f277620a, "eventId:" + r102);
        r103.report(r100, r102, r101);
    }

    public static void a(Context r100, String r101, String r102, String r103) {
        PushBaseAnalytics r104 = PushAnalyticsCenter.getInstance().getPushAnalytics();
        if (r104 != null) goto L5;
        return;
    L5:
        Bundle r105 = a(r100, r101, r102);
        HMSLog.i(f277620a, "eventId:" + r103);
        r104.report(r100, r103, r105);
    }
}
