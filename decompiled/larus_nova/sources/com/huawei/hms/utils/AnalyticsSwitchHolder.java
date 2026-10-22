package com.huawei.hms.utils;

import android.content.Context;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.AndroidException;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtils;
import com.huawei.hms.support.log.HMSLog;
import com.larus.apm.impl.protector.RunnableProtector;
import java.sql.Timestamp;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class AnalyticsSwitchHolder {
    public static final int ANALYTICS_DISABLED = 2;
    public static final int ANALYTICS_ENABLED = 1;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static volatile int f277847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private static final Object f277848b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static volatile Long f277849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static volatile boolean f277850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static volatile boolean f277851e;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277852a;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_utils_AnalyticsSwitchHolder$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_utils_AnalyticsSwitchHolder$a__run$___twin___() {
            AnalyticsSwitchHolder.a(this.f277852a);
            HMSLog.i("AnalyticsSwitchHolder", "getStateForHmsAnalyticsProvider");
        }

        public a(Context r100) {
            this.f277852a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_utils_AnalyticsSwitchHolder$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_utils_AnalyticsSwitchHolder$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277853a;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_utils_AnalyticsSwitchHolder$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_utils_AnalyticsSwitchHolder$b__run$___twin___() {
            HMSLog.i("AnalyticsSwitchHolder", "enter setAnalyticsStateAndTimestamp");
            AnalyticsSwitchHolder.a(this.f277853a);
            HMSLog.i("AnalyticsSwitchHolder", "quit setAnalyticsStateAndTimestamp");
        }

        public b(Context r100) {
            this.f277853a = r100;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_utils_AnalyticsSwitchHolder$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_huawei_hms_utils_AnalyticsSwitchHolder$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public AnalyticsSwitchHolder() {
    }

    static {
        f277848b = new Object();
        f277849c = 0L;
        f277850d = false;
        f277851e = false;
    }

    public static /* synthetic */ void a(Context r100) {
        f(r100);
    }

    private static boolean b(Context r100) {
        if (r100 != null) goto L6;
        HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, context is null.");
        return false;
    L6:
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L19;
    L17:
        HMSLog.i("AnalyticsSwitchHolder", "In getBiIsReportSetting, configuration not found for bi report setting.");
        return false;
    L19:
        ApplicationInfo r102 = r101.getPackageInfo(r100.getPackageName(), 128).applicationInfo;     // Catch: RuntimeException -> L14 AndroidException -> L16
        if (r102 == null) goto L17;
        Bundle r103 = r102.metaData;     // Catch: RuntimeException -> L14 AndroidException -> L16
        if (r103 == null) goto L17;
        return r103.getBoolean("com.huawei.hms.client.bireport.setting");
    L16:
        HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.");
    L14:
        e = move-exception;
        HMSLog.e("AnalyticsSwitchHolder", "In getBiIsReportSetting, Failed to read meta data bi report setting.", e);
        goto L17
    }

    private static void c(Context r100) {
        f277849c = Long.valueOf(new Timestamp(System.currentTimeMillis()).getTime());
        new Thread(new a(r100), "Thread-getStateForHmsAnalyticsProvider").start();
    }

    private static boolean d(Context r100) {
        return RegionUtils.isChinaROM(r100);
    }

    private static void e(Context r100) {
        Timestamp r101 = new Timestamp(System.currentTimeMillis());
        if ((r101.getTime() - f277849c.longValue()) >= 86400000) goto L5;
        return;
    L5:
        if (f277849c.longValue() <= 0) goto L9;
        f277849c = Long.valueOf(r101.getTime());
        new Thread(new b(r100), "Thread-refreshOobeAnalyticsState").start();
        return;
    }

    private static void f(Context r100) {
        if (r100 != null) goto L6;
        HMSLog.e("AnalyticsSwitchHolder", "In setAnalyticsState、, context is null.");
        return;
    L6:
        if (HiAnalyticsUtils.getInstance().getOobeAnalyticsState(r100) != 1) goto L19;
        Object r101 = f277848b;
        monitor-enter(r101);
        f277847a = 1;     // Catch: Throwable -> L16
        monitor-exit(r101);     // Catch: Throwable -> L16
        if (HiAnalyticsUtils.getInstance().getInitFlag() == false) goto L14;
        return;
    L14:
        if (f277850d == true) goto L34;
        HMSBIInitializer.getInstance(r100).initHaSDK();
        f277850d = true;
        return;
    L34:
        return;
    L16:
        th = move-exception;
        throw th;
    L19:
        Object r102 = f277848b;
        monitor-enter(r102);
        f277847a = 2;     // Catch: Throwable -> L26
        monitor-exit(r102);     // Catch: Throwable -> L26
        com.huawei.hms.stats.a.c().a();
        return;
    L26:
        th = move-exception;
        throw th;
    }

    public static int getAndRefreshAnalyticsState(Context r100) {
        Object r101 = f277848b;
        monitor-enter(r101);
        isAnalyticsDisabled(r100);     // Catch: Throwable -> L7
        int r102 = f277847a;     // Catch: Throwable -> L7
        monitor-exit(r101);     // Catch: Throwable -> L7
        return r102;
    L7:
        th = move-exception;
        throw th;
    }

    public static boolean getBiSetting(Context r100) {
        if (r100 != null) goto L6;
        HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, context is null.");
        return false;
    L6:
        PackageManager r101 = r100.getPackageManager();
        if (r101 != null) goto L19;
    L17:
        HMSLog.i("AnalyticsSwitchHolder", "In getBiSetting, configuration not found for bisetting.");
        return false;
    L19:
        ApplicationInfo r102 = r101.getPackageInfo(r100.getPackageName(), 128).applicationInfo;     // Catch: RuntimeException -> L14 AndroidException -> L16
        if (r102 == null) goto L17;
        Bundle r103 = r102.metaData;     // Catch: RuntimeException -> L14 AndroidException -> L16
        if (r103 == null) goto L17;
        return r103.getBoolean("com.huawei.hms.client.bi.setting");
    L16:
        HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.");
    L14:
        e = move-exception;
        HMSLog.e("AnalyticsSwitchHolder", "In getBiSetting, Failed to read meta data bisetting.", e);
        goto L17
    }

    public static boolean isAnalyticsDisabled(Context r100) {
        Object r101 = f277848b;
        monitor-enter(r101);
    L28:
        th = move-exception;
        throw th;
    L5:
        if (f277847a != 0) goto L20;
        if (r100 != null) goto L10;
        monitor-exit(r101);     // Catch: Throwable -> L28
        return true;
    L10:
        if (b(r100) == false) goto L13;
        HMSLog.i("AnalyticsSwitchHolder", "Builder->biReportSetting :true");     // Catch: Throwable -> L28
        f277847a = 1;     // Catch: Throwable -> L28
    L22:
        monitor-exit(r101);     // Catch: Throwable -> L28
        if (f277847a != 1) goto L32;
        return false;
    L32:
        return true;
    L13:
        if (getBiSetting(r100) == false) goto L16;
        HMSLog.i("AnalyticsSwitchHolder", "Builder->biSetting :true");     // Catch: Throwable -> L28
        f277847a = 2;     // Catch: Throwable -> L28
        goto L22
    L16:
        if (d(r100) == false) goto L18;
        f277847a = 1;     // Catch: Throwable -> L28
        goto L22
    L18:
        HMSLog.i("AnalyticsSwitchHolder", "not ChinaROM");     // Catch: Throwable -> L28
        f277847a = 3;     // Catch: Throwable -> L28
        f277851e = true;     // Catch: Throwable -> L28
        c(r100);     // Catch: Throwable -> L28
        goto L22
    L20:
        if (f277851e == false) goto L22;
        e(r100);     // Catch: Throwable -> L28
        goto L22
    }
}
