package com.huawei.hms.stats;

import android.content.Context;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hms.utils.HMSBIInitializer;
import java.util.LinkedHashMap;

/* JADX INFO: loaded from: classes23.dex */
public class HiAnalyticsOfCpUtils {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static HiAnalyticsInstance f277681a;

    public HiAnalyticsOfCpUtils() {
    }

    private static HiAnalyticsInstance a(Context r100) {
        HiAnalyticsInstance r101 = HMSBIInitializer.getInstance(r100).getAnalyticsInstance();
        f277681a = r101;
        return r101;
    }

    public static void onReport(Context r100, int r101) {
        if (a(r100) == null) goto L6;
        f277681a.onReport(r101);
        return;
    }

    public static void onEvent(Context r100, String r101, String r102) {
        if (a(r100) == null) goto L6;
        f277681a.onEvent(r100, r101, r102);
        return;
    }

    public static void onEvent(Context r100, int r101, String r102, LinkedHashMap<String, String> r103) {
        if (a(r100) == null) goto L6;
        f277681a.onEvent(r101, r102, r103);
        return;
    }

    public static void onStreamEvent(Context r100, int r101, String r102, LinkedHashMap<String, String> r103) {
        if (a(r100) == null) goto L6;
        f277681a.onStreamEvent(r101, r102, r103);
        return;
    }
}
