package com.huawei.hms.framework.network.grs;

import android.content.Context;
import com.huawei.hms.framework.common.Logger;
import com.huawei.hms.framework.network.grs.local.model.CountryCodeBean;
import java.util.HashMap;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class GrsApi {
    private static final String TAG = "GrsApi";
    private static GrsClient grsClient;

    public GrsApi() {
    }

    public static void ayncGetGrsUrl(String r100, String r101, IQueryUrlCallBack r102) {
        if (r102 != null) goto L5;
        Logger.w(TAG, "IQueryUrlCallBack is must not null for process continue.");
        return;
    L5:
        GrsClient r103 = grsClient;
        if (r103 == null) goto L12;
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        r103.ayncGetGrsUrl(r100, r101, r102);
        return;
    L12:
        r102.onCallBackFail(-6);
    }

    public static void ayncGetGrsUrls(String r100, IQueryUrlsCallBack r101) {
        if (r101 != null) goto L5;
        Logger.w(TAG, "IQueryUrlsCallBack is must not null for process continue.");
        return;
    L5:
        GrsClient r102 = grsClient;
        if (r102 == null) goto L11;
        if (r100 == null) goto L11;
        r102.ayncGetGrsUrls(r100, r101);
        return;
    L11:
        r101.onCallBackFail(-6);
    }

    public static void clearSp() {
        if (grsClient != null) goto L6;
        Logger.w(TAG, "GrsApi.clearSp return because grsClient is null.");
        return;
    }

    public static boolean forceExpire() {
        GrsClient r100 = grsClient;
        if (r100 != null) goto L7;
        Logger.w(TAG, "GrsApi.forceExpire return false because grsClient is null.");
        return false;
    L7:
        return r100.forceExpire();
    }

    public static CountryCodeBean getCountryCode(Context r100, boolean r101) {
        return a.a(r100, r101);
    }

    public static int grsSdkInit(Context r100, GrsBaseInfo r101) {
        Logger.w(TAG, "GrsApi.grsSdkInit is @Deprecated,  And Only Application Can Call Once");
        grsClient = new GrsClient(r100, r101);
        return 0;
    }

    public static String synGetGrsUrl(String r100, String r101) {
        GrsClient r102 = grsClient;
        if (r102 == null) goto L9;
        if (r100 == null) goto L9;
        if (r101 == null) goto L9;
        return r102.synGetGrsUrl(r100, r101);
    L9:
        Logger.w(TAG, "GrsApi.synGetGrsUrl method maybe grsSdkInit has not completed and grsClient is null.");
        return null;
    }

    public static Map<String, String> synGetGrsUrls(String r100) {
        GrsClient r101 = grsClient;
        if (r101 == null) goto L8;
        if (r100 == null) goto L8;
        return r101.synGetGrsUrls(r100);
    L8:
        Logger.w(TAG, "GrsApi.synGetGrsUrls method maybe grsSdkInit has not completed and grsClient is null.");
        return new HashMap();
    }
}
