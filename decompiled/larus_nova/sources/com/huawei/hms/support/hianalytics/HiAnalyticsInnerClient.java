package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.text.TextUtils;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.utils.Util;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class HiAnalyticsInnerClient extends HiAnalyticsBase {
    public HiAnalyticsInnerClient() {
    }

    public static void reportEntryExit(Context r100, ResponseHeader r101, String r102) {
        HiAnalyticsUtil.getInstance();
        Map<String, String> r103 = HiAnalyticsUtil.getMapFromRequestHeader(r101);
        r103.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        if (TextUtils.isEmpty(r102) == true) goto L5;
        r103.put("version", HiAnalyticsUtil.versionCodeToName(r102));
    L5:
        r103.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(r100, HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, r103);
    }

    public static void reportEntryClient(Context r100, String r101, String r102, String r103, String r104) {
        Map<String, String> r105 = HiAnalyticsBase.getMapForBi(r100, r101);
        r105.put("appid", r102);
        if (TextUtils.isEmpty(r103) == false) goto L5;
        r103 = TransactionIdCreater.getId(r102, r101);
    L5:
        r105.put(HiAnalyticsConstant.HaKey.BI_KEY_TRANSID, r103);
        r105.put("direction", HiAnalyticsConstant.Direction.REQUEST);
        if (TextUtils.isEmpty(r104) == true) goto L8;
        r105.put("version", HiAnalyticsUtil.versionCodeToName(r104));
    L8:
        r105.put(HiAnalyticsConstant.HaKey.BI_KEY_PHONETYPE, Util.getSystemProperties("ro.logsystem.usertype", ""));
        HiAnalyticsUtil.getInstance().onNewEvent(r100, HiAnalyticsConstant.HMS_SDK_BASE_API_CALLED, r105);
    }
}
