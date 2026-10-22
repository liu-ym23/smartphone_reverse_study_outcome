package com.huawei.hms.utils;

import android.content.Context;
import android.os.AsyncTask;
import android.text.TextUtils;
import com.huawei.hianalytics.process.HiAnalyticsConfig;
import com.huawei.hianalytics.process.HiAnalyticsInstance;
import com.huawei.hianalytics.process.HiAnalyticsManager;
import com.huawei.hms.framework.network.grs.GrsApp;
import com.huawei.hms.framework.network.grs.GrsBaseInfo;
import com.huawei.hms.framework.network.grs.GrsClient;
import com.huawei.hms.framework.network.grs.IQueryUrlCallBack;
import com.huawei.hms.hatool.HmsHiAnalyticsUtils;
import com.huawei.hms.stats.HianalyticsExist;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.log.HMSLog;
import java.util.Locale;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes23.dex */
public class HMSBIInitializer {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private static final Object f277861d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private static HMSBIInitializer f277862e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private static HiAnalyticsInstance f277863f;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f277864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private AtomicBoolean f277865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private boolean f277866c;

    public class a implements IQueryUrlCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HMSBIInitializer f277867a;

        public a(HMSBIInitializer r100) {
            this.f277867a = r100;
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackFail(int r100) {
            HMSLog.e("HMSBIInitializer", "get grs failed, the errorcode is " + r100);
            HMSBIInitializer.c(this.f277867a).set(false);
            com.huawei.hms.stats.a.c().a();
        }

        @Override // com.huawei.hms.framework.network.grs.IQueryUrlCallBack
        public void onCallBackSuccess(String r100) {
            if (TextUtils.isEmpty(r100) == false) goto L14;
        L12:
            HMSBIInitializer.c(this.f277867a).set(false);
            com.huawei.hms.stats.a.c().b();
            return;
        L14:
        L10:
            th = move-exception;
            HMSLog.e("HMSBIInitializer", "HA Init error, message : " + th.getMessage());
            goto L12
        L5:
            if (HMSBIInitializer.a(this.f277867a) == true) goto L7;
            HmsHiAnalyticsUtils.init(HMSBIInitializer.b(this.f277867a), false, false, false, r100, "com.huawei.hwid");     // Catch: Throwable -> L10
        L8:
            HMSLog.i("HMSBIInitializer", "BI URL acquired successfully");     // Catch: Throwable -> L10
            goto L12
        L7:
            HMSBIInitializer.b(this.f277867a, r100);     // Catch: Throwable -> L10
            goto L8
        }
    }

    public class b extends AsyncTask<String, Integer, Void> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HMSBIInitializer f277868a;

        private b(HMSBIInitializer r100) {
            this.f277868a = r100;
        }

        public Void a(String... r100) {
            HMSBIInitializer.a(this.f277868a, r100[0]);
            return null;
        }

        @Override // android.os.AsyncTask
        public /* bridge */ /* synthetic */ Void doInBackground(String[] r100) {
            return a(r100);
        }

        public /* synthetic */ b(HMSBIInitializer r100, a r101) {
            this(r100);
        }
    }

    static {
        f277861d = new Object();
    }

    public void initBI() {
        if (this.f277866c == true) goto L5;
        boolean r100 = HmsHiAnalyticsUtils.getInitFlag();
    L6:
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag :" + r100);
        if (r100 == false) goto L10;
        return;
    L10:
        if (AnalyticsSwitchHolder.isAnalyticsDisabled(this.f277864a) == false) goto L12;
        return;
    L12:
        HMSLog.i("HMSBIInitializer", "Builder->biInitFlag : start initHaSDK");
        initHaSDK();
        return;
    L5:
        r100 = HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
        goto L6
    }

    public void initHaSDK() {
        if (this.f277865b.compareAndSet(false, true) == false) goto L15;
        String r100 = GrsApp.getInstance().getIssueCountryCode(this.f277864a);
        if (TextUtils.isEmpty(r100) == true) goto L8;
        r100 = r100.toUpperCase(Locale.ENGLISH);
    L8:
        if ("UNKNOWN".equalsIgnoreCase(r100) == false) goto L10;
    L13:
        HMSLog.e("HMSBIInitializer", "Failed to get device issue country");
        this.f277865b.set(false);
        return;
    L10:
        if (TextUtils.isEmpty(r100) == true) goto L13;
        new b(this, null).execute(new String[]{r100});
        return;
    }

    public boolean isInit() {
        if (this.f277866c == true) goto L7;
        return HmsHiAnalyticsUtils.getInitFlag();
    L7:
        return HiAnalyticsManager.getInitFlag(HiAnalyticsConstant.HA_SERVICE_TAG);
    }

    public HiAnalyticsInstance getAnalyticsInstance() {
        return f277863f;
    }

    private HMSBIInitializer(Context r100) {
        this.f277865b = new AtomicBoolean(false);
        this.f277864a = r100;
        this.f277866c = HianalyticsExist.isHianalyticsExist();
    }

    private void a(String r100) {
        HiAnalyticsInstance r101 = HiAnalyticsManager.getInstanceByTag(HiAnalyticsConstant.HA_SERVICE_TAG);
        f277863f = r101;
        if (r101 == null) goto L6;
        r101.setAppid("com.huawei.hwid");
        return;
    L6:
        HiAnalyticsConfig r102 = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(r100).build();
        HiAnalyticsConfig r103 = new HiAnalyticsConfig.Builder().setEnableImei(false).setEnableUDID(false).setEnableSN(false).setCollectURL(r100).build();
        HiAnalyticsInstance r104 = new HiAnalyticsInstance.Builder(this.f277864a).setOperConf(r102).setMaintConf(r103).create(HiAnalyticsConstant.HA_SERVICE_TAG);
        f277863f = r104;
        if (r104 == null) goto L10;
        r104.setAppid("com.huawei.hwid");
        return;
    }

    private void b(String r100) {
        HMSLog.i("HMSBIInitializer", "Start to query GRS");
        GrsBaseInfo r101 = new GrsBaseInfo();
        r101.setIssueCountry(r100);
        new GrsClient(this.f277864a, r101).ayncGetGrsUrl("com.huawei.cloud.opensdkhianalytics", "ROOTV2", new a(this));
    }

    public static /* synthetic */ AtomicBoolean c(HMSBIInitializer r100) {
        return r100.f277865b;
    }

    public static HMSBIInitializer getInstance(Context r100) {
        Object r101 = f277861d;
        monitor-enter(r101);
    L14:
        th = move-exception;
        throw th;
    L5:
        if (f277862e != null) goto L11;
        if (r100 == null) goto L11;
        Context r102 = r100.getApplicationContext();     // Catch: Throwable -> L14
        if (r102 == null) goto L10;
        f277862e = new HMSBIInitializer(r102);     // Catch: Throwable -> L14
        goto L11
    L10:
        f277862e = new HMSBIInitializer(r100);     // Catch: Throwable -> L14
    L11:
        monitor-exit(r101);     // Catch: Throwable -> L14
        return f277862e;
    }

    public static /* synthetic */ boolean a(HMSBIInitializer r100) {
        return r100.f277866c;
    }

    public static /* synthetic */ Context b(HMSBIInitializer r100) {
        return r100.f277864a;
    }

    public static /* synthetic */ void a(HMSBIInitializer r100, String r101) {
        r100.b(r101);
    }

    public static /* synthetic */ void b(HMSBIInitializer r100, String r101) {
        r100.a(r101);
    }
}
