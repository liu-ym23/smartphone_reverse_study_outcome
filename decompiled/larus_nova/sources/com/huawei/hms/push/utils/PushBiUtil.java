package com.huawei.hms.push.utils;

import android.content.Context;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.common.internal.ResponseErrorCode;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.hianalytics.HiAnalyticsClient;

/* JADX INFO: loaded from: classes23.dex */
public final class PushBiUtil {
    private PushBiUtil() {
    }

    public static String reportEntry(Context r100, String r101) {
        return HiAnalyticsClient.reportEntry(r100, r101, 61300300);
    }

    public static void reportExit(Context r100, String r101, ResponseErrorCode r102) {
        HiAnalyticsClient.reportExit(r100, r101, r102.getTransactionId(), r102.getStatusCode(), r102.getErrorCode(), 61300300);
    }

    public static void reportExit(Context r100, String r101, String r102, ErrorEnum r110) {
        HiAnalyticsClient.reportExit(r100, r101, r102, Status.SUCCESS.getStatusCode(), r110.getExternalCode(), 61300300);
    }

    public static void reportExit(Context r100, String r101, String r102, int r110) {
        HiAnalyticsClient.reportExit(r100, r101, r102, Status.SUCCESS.getStatusCode(), r110, 61300300);
    }
}
