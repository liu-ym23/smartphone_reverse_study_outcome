package com.huawei.hms.support.hianalytics;

import android.content.Context;
import android.os.Bundle;
import android.provider.Settings;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hianalytics.util.HiAnalyticTools;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.HiAnalyticsOfCpUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.AnalyticsSwitchHolder;
import com.larus.apm.impl.protector.RunnableProtector;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import me.ele.lancet.base.annotations.Skip;

/* JADX INFO: loaded from: classes23.dex */
public class HiAnalyticsUtils {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Object f277754c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f277755d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HiAnalyticsUtils f277756e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private int f277757a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private final boolean f277758b;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277759a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277760b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f277761c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HiAnalyticsUtils f277762d;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_hianalytics_HiAnalyticsUtils$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$a__run$___twin___() {
            HiAnalyticsUtils.getInstance().onEvent(this.f277759a, this.f277760b, this.f277761c);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_support_hianalytics_HiAnalyticsUtils$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(HiAnalyticsUtils r100, Context r101, String r102, Map r103) {
            this.f277762d = r100;
            this.f277759a = r101;
            this.f277760b = r102;
            this.f277761c = r103;
        }
    }

    public class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277763a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277764b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ String f277765c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HiAnalyticsUtils f277766d;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_hianalytics_HiAnalyticsUtils$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$b__run$___twin___() {
            HiAnalyticsUtils.getInstance().onEvent2(this.f277763a, this.f277764b, this.f277765c);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_huawei_hms_support_hianalytics_HiAnalyticsUtils$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public b(HiAnalyticsUtils r100, Context r101, String r102, String r103) {
            this.f277766d = r100;
            this.f277763a = r101;
            this.f277764b = r102;
            this.f277765c = r103;
        }
    }

    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277767a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277768b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f277769c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HiAnalyticsUtils f277770d;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_hianalytics_HiAnalyticsUtils$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$c__run$___twin___() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f277767a, this.f277768b, this.f277769c);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_huawei_hms_support_hianalytics_HiAnalyticsUtils$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(HiAnalyticsUtils r100, Context r101, String r102, Map r103) {
            this.f277770d = r100;
            this.f277767a = r101;
            this.f277768b = r102;
            this.f277769c = r103;
        }
    }

    public class d implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277771a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277772b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f277773c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f277774d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ HiAnalyticsUtils f277775e;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_hianalytics_HiAnalyticsUtils$d_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$d__run$___twin___() {
            HiAnalyticsUtils.getInstance().onNewEvent(this.f277771a, this.f277772b, this.f277773c, this.f277774d);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$d_com_larus_apm_impl_protector_RunnableLancet_run(d r100) {
            r100.com_huawei_hms_support_hianalytics_HiAnalyticsUtils$d__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public d(HiAnalyticsUtils r100, Context r101, String r102, Map r103, int r104) {
            this.f277775e = r100;
            this.f277771a = r101;
            this.f277772b = r102;
            this.f277773c = r103;
            this.f277774d = r104;
        }
    }

    public class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277776a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277777b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f277778c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ HiAnalyticsUtils f277779d;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_hianalytics_HiAnalyticsUtils$e_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$e__run$___twin___() {
            HiAnalyticsUtils.getInstance().onReport(this.f277776a, this.f277777b, this.f277778c);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$e_com_larus_apm_impl_protector_RunnableLancet_run(e r100) {
            r100.com_huawei_hms_support_hianalytics_HiAnalyticsUtils$e__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public e(HiAnalyticsUtils r100, Context r101, String r102, Map r103) {
            this.f277779d = r100;
            this.f277776a = r101;
            this.f277777b = r102;
            this.f277778c = r103;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ Context f277780a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277781b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ Map f277782c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        final /* synthetic */ int f277783d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        final /* synthetic */ HiAnalyticsUtils f277784e;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_hianalytics_HiAnalyticsUtils$f_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$f__run$___twin___() {
            HiAnalyticsUtils.getInstance().onReport(this.f277780a, this.f277781b, this.f277782c, this.f277783d);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_hianalytics_HiAnalyticsUtils$f_com_larus_apm_impl_protector_RunnableLancet_run(f r100) {
            r100.com_huawei_hms_support_hianalytics_HiAnalyticsUtils$f__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public f(HiAnalyticsUtils r100, Context r101, String r102, Map r103, int r104) {
            this.f277784e = r100;
            this.f277780a = r101;
            this.f277781b = r102;
            this.f277782c = r103;
            this.f277783d = r104;
        }
    }

    static {
        f277754c = new Object();
        f277755d = new Object();
    }

    public static HiAnalyticsUtils getInstance() {
        Object r100 = f277754c;
        monitor-enter(r100);
    L10:
        th = move-exception;
        throw th;
    L5:
        if (f277756e != null) goto L7;
        f277756e = new HiAnalyticsUtils();     // Catch: Throwable -> L10
    L7:
        HiAnalyticsUtils r101 = f277756e;     // Catch: Throwable -> L10
        monitor-exit(r100);     // Catch: Throwable -> L10
        return r101;
    }

    public void enableLog() {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (this.f277758b == true) goto L5;
        HmsHiAnalyticsUtils.enableLog();
        return;
    L5:
        HMSLog.i("HiAnalyticsUtils", "cp needs to pass in the context, this method is not supported");
    }

    public boolean getInitFlag() {
        if (this.f277758b == true) goto L7;
        return HmsHiAnalyticsUtils.getInitFlag();
    L7:
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    private HiAnalyticsUtils() {
        this.f277757a = 0;
        this.f277758b = HianalyticsExist.isHianalyticsExist();
    }

    private int a(Context r100) {
        int r101 = 0;
        r101 = Settings.Secure.getInt(r100.getContentResolver(), "hw_app_analytics_state");     // Catch: Settings.SettingNotFoundException -> L5
        HMSLog.i("HiAnalyticsUtils", "getOobeStateForSettings value is " + r101);     // Catch: Settings.SettingNotFoundException -> L5
        return r101;
    L5:
        e = move-exception;
        HMSLog.i("HiAnalyticsUtils", "Settings.SettingNotFoundException " + e.getMessage());
        return r101;
    }

    private boolean b(Map<?, ?> r100) {
        Iterator<?> r101 = r100.values().iterator();     // Catch: Throwable -> L14
        long r102 = 0;
    L5:
        if (r101.hasNext() == false) goto L11;
        Object r103 = r101.next();     // Catch: Throwable -> L14
        if ((r103 instanceof String) == false) goto L5;
        r102 = r102 + ((long) ((String) r103).getBytes(Charset.forName("UTF-8")).length);
        goto L5
    L11:
        if (r102 > 512) goto L24;
        return true;
    L24:
        return false;
    L14:
        th = move-exception;
        HMSLog.e("HiAnalyticsUtils", "<isValidSize map> Exception: " + th.getMessage());
        return false;
    }

    public static String versionCodeToName(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L10:
        return "";
    L5:
        if (r100.length() != 8) goto L7;
    L12:
        CastIntegerProtector.parseInt(r100);     // Catch: NumberFormatException -> L11
        return CastIntegerProtector.parseInt(r100.substring(0, r100.length() - 7)) + "." + CastIntegerProtector.parseInt(r100.substring(r100.length() - 7, r100.length() - 5)) + "." + CastIntegerProtector.parseInt(r100.substring(r100.length() - 5, r100.length() - 3)) + "." + CastIntegerProtector.parseInt(r100.substring(r100.length() - 3));
    L7:
        if (r100.length() != 9) goto L10;
        goto L10
    }

    public void enableLog(Context r100) {
        HMSLog.i("HiAnalyticsUtils", "Enable Log");
        if (this.f277758b == true) goto L5;
        HmsHiAnalyticsUtils.enableLog();
        return;
    L5:
        HiAnalyticTools.enableLog(r100);
    }

    public int getOobeAnalyticsState(Context r100) {
        if (r100 != null) goto L6;
        return 0;
    L6:
        int r101 = a(r100);
        if (r101 != 1) goto L9;
        return r101;
    L9:
        Bundle r102 = new Bundle();
        r102.putString("hms_cp_bundle_key", "content://com.huawei.hms.contentprovider/com.huawei.hms.privacy.HmsAnalyticsStateProvider");
        Bundle r103 = r100.getApplicationContext().getContentResolver().call(UriProtector.parse("content://com.huawei.hms.contentprovider"), "getAnalyticsState", null, r102);     // Catch: Exception -> L14 SecurityException -> L15 IllegalArgumentException -> L16
        if (r103 == null) goto L20;
        r101 = r103.getInt("SWITCH_IS_CHECKED");     // Catch: Exception -> L14 SecurityException -> L15 IllegalArgumentException -> L16
        HMSLog.i("HiAnalyticsUtils", "get hms analyticsOobe state " + r101);     // Catch: Exception -> L14 SecurityException -> L15 IllegalArgumentException -> L16
    L23:
        return r101;
    L20:
        return r101;
    L16:
        HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState IllegalArgumentException ");
        return r101;
    L15:
        HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState SecurityException ");
        return r101;
    L14:
        HMSLog.i("HiAnalyticsUtils", "getOobeAnalyticsState Exception ");
        return r101;
    }

    public boolean hasError(Context r100) {
        return AnalyticsSwitchHolder.isAnalyticsDisabled(r100);
    }

    private static LinkedHashMap<String, String> a(Map<String, String> r100) {
        LinkedHashMap<String, String> r101 = new LinkedHashMap();
        if (r100 != null) goto L5;
    L10:
        return r101;
    L5:
        if (r100.size() <= 0) goto L10;
        Iterator<Map.Entry<String, String>> r102 = r100.entrySet().iterator();
    L8:
        if (r102.hasNext() == false) goto L10;
        Map.Entry<String, String> r103 = r102.next();
        r101.put(r103.getKey(), r103.getValue());
        goto L8
    }

    private void b(Context r100) {
        Object r101 = f277755d;
        monitor-enter(r101);
        int r102 = this.f277757a;     // Catch: Throwable -> L13
        if (r102 >= 60) goto L7;
        this.f277757a = r102 + 1;     // Catch: Throwable -> L13
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L13
        return;
    L7:
        this.f277757a = 0;     // Catch: Throwable -> L13
        if (this.f277758b == true) goto L10;
        HmsHiAnalyticsUtils.onReport();     // Catch: Throwable -> L13
        goto L11
    L10:
        HiAnalyticsOfCpUtils.onReport(r100, 0);     // Catch: Throwable -> L13
        HiAnalyticsOfCpUtils.onReport(r100, 1);     // Catch: Throwable -> L13
    L13:
        th = move-exception;
        throw th;
    }

    private boolean a(String r100) {
        if (r100 != null) goto L13;
        return false;
    L13:
        if (r100.getBytes(Charset.forName("UTF-8")).length > 512) goto L15;
        return true;
    L15:
        return false;
    L10:
        th = move-exception;
        HMSLog.e("HiAnalyticsUtils", "<isValidSize String> Exception: " + th.getMessage());
        return false;
    }

    private void a(Context r100, String r101, String r102) {
        com.huawei.hms.stats.a.c().a(new b(this, r100.getApplicationContext(), r101, r102));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        HMSLog.e("HiAnalyticsUtils", "<addOnEvent2ToCache> Failed. " + th.getMessage());
    }

    private void b(Context r100, String r101, Map r102) {
        com.huawei.hms.stats.a.c().a(new c(this, r100.getApplicationContext(), r101, r102));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache> failed. " + th.getMessage());
    }

    private void c(Context r100, String r101, Map r102) {
        com.huawei.hms.stats.a.c().a(new e(this, r100.getApplicationContext(), r101, r102));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache> failed. " + th.getMessage());
    }

    public void onBuoyEvent(Context r100, String r101, String r102) {
        onEvent2(r100, r101, r102);
    }

    public void onEvent(Context r100, String r101, Map<String, String> r102) {
        int r103 = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(r100);
        if (r102 != null) goto L5;
    L24:
        HMSLog.e("HiAnalyticsUtils", "<onEvent> map or context is null, state: " + r103);
        return;
    L5:
        if (r102.isEmpty() == true) goto L24;
        if (r100 == null) goto L24;
        boolean r104 = getInitFlag();
        if (r103 == 2) goto L11;
        boolean r105 = true;
    L13:
        if (a(r104, r105, r102) == false) goto L15;
        a(r100, r101, r102);
    L15:
        if (r103 != 1) goto L26;
        if (r104 == true) goto L19;
        return;
    L19:
        if (this.f277758b == true) goto L21;
        HmsHiAnalyticsUtils.onEvent(0, r101, a(r102));
        HmsHiAnalyticsUtils.onEvent(1, r101, a(r102));
    L22:
        b(r100);
        return;
    L21:
        HiAnalyticsOfCpUtils.onEvent(r100, 0, r101, a(r102));
        HiAnalyticsOfCpUtils.onEvent(r100, 1, r101, a(r102));
        goto L22
    L26:
        return;
    L11:
        r105 = false;
        goto L13
    }

    public void onEvent2(Context r100, String r101, String r102) {
        int r103 = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(r100);
        if (r100 != null) goto L6;
        HMSLog.e("HiAnalyticsUtils", "<onEvent2> context is null, state: " + r103);
        return;
    L6:
        boolean r104 = getInitFlag();
        if (r104 == true) goto L14;
        if (r103 == 2) goto L14;
        if (a(r102) == false) goto L14;
        a(r100, r101, r102);
    L14:
        if (r103 != 1) goto L22;
        if (r104 == true) goto L18;
        return;
    L18:
        if (this.f277758b == true) goto L20;
        HmsHiAnalyticsUtils.onEvent(r100, r101, r102);
        return;
    L20:
        HiAnalyticsOfCpUtils.onEvent(r100, r101, r102);
        return;
    }

    public void onNewEvent(Context r100, String r101, Map r102) {
        int r103 = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(r100);
        if (r102 != null) goto L5;
    L24:
        HMSLog.e("HiAnalyticsUtils", "<onNewEvent> map or context is null, state: " + r103);
        return;
    L5:
        if (r102.isEmpty() == true) goto L24;
        if (r100 == null) goto L24;
        boolean r104 = getInitFlag();
        if (r103 == 2) goto L11;
        boolean r105 = true;
    L13:
        if (a(r104, r105, r102) == false) goto L15;
        b(r100, r101, r102);
    L15:
        if (r103 != 1) goto L26;
        if (r104 == true) goto L19;
        return;
    L19:
        if (this.f277758b == true) goto L21;
        HmsHiAnalyticsUtils.onEvent(0, r101, a(r102));
        HmsHiAnalyticsUtils.onEvent(1, r101, a(r102));
    L22:
        b(r100);
        return;
    L21:
        HiAnalyticsOfCpUtils.onEvent(r100, 0, r101, a(r102));
        HiAnalyticsOfCpUtils.onEvent(r100, 1, r101, a(r102));
        goto L22
    L26:
        return;
    L11:
        r105 = false;
        goto L13
    }

    public void onReport(Context r100, String r101, Map r102) {
        int r103 = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(r100);
        if (r102 != null) goto L5;
    L23:
        HMSLog.e("HiAnalyticsUtils", "<onReport> map or context is null, state: " + r103);
        return;
    L5:
        if (r102.isEmpty() == true) goto L23;
        if (r100 == null) goto L23;
        boolean r104 = getInitFlag();
        if (r103 == 2) goto L11;
        boolean r105 = true;
    L13:
        if (a(r104, r105, r102) == false) goto L15;
        c(r100, r101, r102);
    L15:
        if (r103 != 1) goto L25;
        if (r104 == true) goto L19;
        return;
    L19:
        if (this.f277758b == true) goto L21;
        HmsHiAnalyticsUtils.onStreamEvent(0, r101, a(r102));
        HmsHiAnalyticsUtils.onStreamEvent(1, r101, a(r102));
        return;
    L21:
        HiAnalyticsOfCpUtils.onStreamEvent(r100, 0, r101, a(r102));
        HiAnalyticsOfCpUtils.onStreamEvent(r100, 1, r101, a(r102));
        return;
    L25:
        return;
    L11:
        r105 = false;
        goto L13
    }

    private void a(Context r100, String r101, Map<String, String> r102) {
        com.huawei.hms.stats.a.c().a(new a(this, r100.getApplicationContext(), r101, r102));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        HMSLog.e("HiAnalyticsUtils", "<addOnEventToCache> failed. " + th.getMessage());
    }

    private boolean a(boolean r100, boolean r101, Map<?, ?> r102) {
        if (r100 == true) goto L7;
        if (r101 == false) goto L7;
        if (b(r102) == false) goto L7;
        return true;
    L7:
        return false;
    }

    private void a(Context r100, String r101, Map r110, int r111) {
        com.huawei.hms.stats.a.c().a(new d(this, r100.getApplicationContext(), r101, r110, r111));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        HMSLog.e("HiAnalyticsUtils", "<addOnNewEventToCache with type> failed. " + th.getMessage());
    }

    private void b(Context r100, String r101, Map r110, int r111) {
        com.huawei.hms.stats.a.c().a(new f(this, r100.getApplicationContext(), r101, r110, r111));     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        HMSLog.e("HiAnalyticsUtils", "<addOnReportToCache with type> failed. " + th.getMessage());
    }

    public void onNewEvent(Context r100, String r101, Map r102, int r103) {
        if (r103 == 0) goto L7;
        if (r103 == 1) goto L7;
        HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> Data reporting type is not supported");
        return;
    L7:
        int r104 = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(r100);
        if (r102 != null) goto L10;
    L29:
        HMSLog.e("HiAnalyticsUtils", "<onNewEvent with type> map or context is null, state: " + r104);
        return;
    L10:
        if (r102.isEmpty() == true) goto L29;
        if (r100 == null) goto L29;
        boolean r105 = getInitFlag();
        if (r104 == 2) goto L16;
        boolean r106 = true;
    L18:
        if (a(r105, r106, r102) == false) goto L20;
        a(r100, r101, r102, r103);
    L20:
        if (r104 != 1) goto L31;
        if (r105 == true) goto L24;
        return;
    L24:
        if (this.f277758b == true) goto L26;
        HmsHiAnalyticsUtils.onEvent(r103, r101, a(r102));
    L27:
        b(r100);
        return;
    L26:
        HiAnalyticsOfCpUtils.onEvent(r100, r103, r101, a(r102));
        goto L27
    L31:
        return;
    L16:
        r106 = false;
        goto L18
    }

    public void onReport(Context r100, String r101, Map r102, int r103) {
        if (r103 == 0) goto L7;
        if (r103 == 1) goto L7;
        HMSLog.e("HiAnalyticsUtils", "<onReport with type> Data reporting type is not supported");
        return;
    L7:
        int r104 = AnalyticsSwitchHolder.getAndRefreshAnalyticsState(r100);
        if (r102 != null) goto L10;
    L28:
        HMSLog.e("HiAnalyticsUtils", "<onReport with type> map or context is null, state: " + r104);
        return;
    L10:
        if (r102.isEmpty() == true) goto L28;
        if (r100 == null) goto L28;
        boolean r105 = getInitFlag();
        if (r104 == 2) goto L16;
        boolean r106 = true;
    L18:
        if (a(r105, r106, r102) == false) goto L20;
        b(r100, r101, r102, r103);
    L20:
        if (r104 != 1) goto L30;
        if (r105 == true) goto L24;
        return;
    L24:
        if (this.f277758b == true) goto L26;
        HmsHiAnalyticsUtils.onStreamEvent(r103, r101, a(r102));
        return;
    L26:
        HiAnalyticsOfCpUtils.onStreamEvent(r100, r103, r101, a(r102));
        return;
    L30:
        return;
    L16:
        r106 = false;
        goto L18
    }
}
