package com.bytedance.framwork.core.sdkmonitor;

import android.content.Context;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Message;
import android.text.TextUtils;
import com.bytedance.android.ec.slice.SliceInitService;
import com.bytedance.apm.constant.UploadTypeInf;
import com.bytedance.bdlocation.monitor.LBSLightLocationTraceLogger;
import com.bytedance.common.utility.NetworkUtils;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.framwork.core.sdklib.apm6.downgrade.DowngradeInfo;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastLongProtector;
import com.bytedance.news.common.service.manager.ServiceManager;
import com.bytedance.services.apm.api.EnsureManager;
import com.bytedance.services.apm.api.IHttpService;
import com.bytedance.services.slardar.config.IConfigListener;
import com.bytedance.services.slardar.config.IConfigManager;
import com.larus.apm.impl.protector.RunnableProtector;
import com.miui.easygo.constant.EasyGoConstant;
import com.optimize.statistics.FrescoMonitorConst;
import com.ss.android.downloadlib.addownload.AdQuickAppManager;
import com.ss.android.socialbase.downloader.utils.DownloadHelper;
import com.ss.ttvideoengine.net.DNSParser;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.net.URI;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicLong;
import java.util.regex.Pattern;
import java.util.zip.GZIPOutputStream;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes3.dex */
public class SDKMonitor implements gy5.b {
    private static final int BIT_API_ALL_SAMPLE = 1;
    private static final String KEY_DEBUG_UUID = "_debug_uuid";
    private static final String KEY_SELF_DEBUG_MESSAGE = "_debug_self";
    private static final int SDK_VERSION = 400;
    static AtomicLong atomicLong;
    private static volatile String hostAid;
    private static volatile IHttpService hostHttpService;
    private static long sid;
    final int SETTINGS_CODE_FAIL;
    final int SETTINGS_CODE_FULL_MODIFIED;
    final int SETTINGS_CODE_INCREMENT_MODIFIED;
    final int SETTINGS_CODE_NOT_MODIFIED;
    private volatile long lastCalculateTimestamp;
    private volatile long lastFullCalculateTimestamp;
    private String mAid;
    private volatile JSONObject mAllowLogType;
    private volatile List<String> mAllowReportList;
    private volatile List<Pattern> mAllowReportPatterns;
    private volatile JSONObject mAllowService;
    private volatile List<String> mBlockReportList;
    private volatile List<Pattern> mBlockReportPatterns;
    private com.bytedance.framwork.core.sdkmonitor.b mCacheData;
    private Map<String, String> mCommonParams;
    private volatile boolean mConfigExit;
    private List<String> mConfigUrls;
    private Context mContext;
    private volatile JSONObject mCustomAllowLogType;
    private volatile int mDisableReportApiError;
    private volatile long mFetchSettingInterval;
    private volatile boolean mHasInit;
    private JSONObject mHeaderInfo;
    private volatile IHttpService mHttpService;
    private IGetExtendParams mIGetExtendParams;
    private volatile boolean mIsEncrypt;
    private volatile long mLastFetchSettingTime;
    private boolean mOversea;
    private volatile int mReportCount;
    private volatile int mReportInterval;
    private volatile int mReportSLA;

    public interface IGetExtendParams {
        Map<String, String> getCommonParams();

        String getSessionId();
    }

    /* JADX INFO: loaded from: classes6.dex */
    public class a implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            by5.e r100 = by5.e.a.f21426a;     // Catch: Throwable -> L13
            monitor-enter(r100);     // Catch: Throwable -> L13
            r100.b();     // Catch: Throwable -> L6
        L8:
            monitor-exit(r100);     // Catch: Throwable -> L13
            return;
        L6:
            th = move-exception;
            fy5.c.c("forceReport", th);     // Catch: Throwable -> L10
        L10:
            th = move-exception;
            throw th;     // Catch: Throwable -> L13
        L13:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L23;
            throw th;
        }

        public a() {
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public class b implements Runnable {
        @Override // java.lang.Runnable
        public final void run() {
            by5.e r100 = by5.e.a.f21426a;     // Catch: Throwable -> L14
            monitor-enter(r100);     // Catch: Throwable -> L14
            r100.b();     // Catch: Throwable -> L7
        L9:
            monitor-exit(r100);     // Catch: Throwable -> L14
            throw null;     // Catch: Throwable -> L15
        L29:
            throw null;     // Catch: Throwable -> L15
        L7:
            th = move-exception;
            fy5.c.c("forceReport", th);     // Catch: Throwable -> L11
        L26:
            throw null;     // Catch: Throwable -> L15
        L11:
            th = move-exception;
            throw th;     // Catch: Throwable -> L14
        L14:
            throw null;     // Catch: Throwable -> L15
        L28:
            throw null;     // Catch: Throwable -> L15
        L27:
            throw null;     // Catch: Throwable -> L15
        L15:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L19;
            return;
        L19:
            throw th;
        }

        public b() {
        }
    }

    /* JADX INFO: loaded from: classes6.dex */
    public class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f244862a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f244863b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ long f244864c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f244865d;

        @Override // java.lang.Runnable
        public final void run() {
            this.f244865d.monitorCommonLogInternal(this.f244862a, this.f244863b, this.f244864c);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public c(SDKMonitor r100, String r101, JSONObject r102, long r103) {
            this.f244865d = r100;
            this.f244862a = r101;
            this.f244863b = r102;
            this.f244864c = r103;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public class d implements IGetExtendParams {
        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final String getSessionId() {
            return null;
        }

        public d() {
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public class e implements IGetExtendParams {
        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final Map<String, String> getCommonParams() {
            return null;
        }

        public e() {
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final String getSessionId() {
            throw null;
        }
    }

    public class f implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Context f244866a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ JSONObject f244867b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ IGetExtendParams f244868c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f244869d;

        @Override // java.lang.Runnable
        public final void run() {
            SDKMonitor.access$000(this.f244869d, this.f244866a, this.f244867b, this.f244868c);     // Catch: Throwable -> L6
            if (SDKMonitor.access$100(this.f244869d) == false) goto L9;
            SDKMonitor.access$200(this.f244869d).b(this.f244869d);     // Catch: Throwable -> L6
            return;
        L9:
            return;
        L6:
            th = move-exception;
            if (RunnableProtector.intercept(th) == true) goto L13;
            throw th;
        }

        public f(SDKMonitor r100, Context r101, JSONObject r102, IGetExtendParams r103) {
            this.f244869d = r100;
            this.f244866a = r101;
            this.f244867b = r102;
            this.f244868c = r103;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public class g implements IGetExtendParams {
        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final Map<String, String> getCommonParams() {
            return null;
        }

        @Override // com.bytedance.framwork.core.sdkmonitor.SDKMonitor.IGetExtendParams
        public final String getSessionId() {
            return null;
        }

        public g() {
        }
    }

    public class h implements IConfigListener {
        @Override // com.bytedance.services.slardar.config.IConfigListener
        public final void onReady() {
        }

        public h() {
        }

        @Override // com.bytedance.services.slardar.config.IConfigListener
        public final void onRefresh(JSONObject r100, boolean r101) {
            JSONObject r102 = null;
            if (r100 == null) goto L7;
            JSONObject r103 = r100.optJSONObject("general");
            if (r103 == null) goto L7;
            JSONObject r104 = r103.optJSONObject("slardar_api_settings");
        L9:
            if (r104 == null) goto L12;
            r102 = r104.optJSONObject("report_setting");
        L12:
            int r105 = r102.optInt("compress_type", 2);
            by5.j r106 = by5.j.a.f21454a;
            if (r105 == 2) goto L15;
        L17:
            r106.f21446b = r105;
            return;
        L15:
            if ((System.currentTimeMillis() - xu3.a.getContext().getSharedPreferences("dict_interval", 0).getLong("force_zstd_timestamp", 0)) > 3600000) goto L17;
            r106.f21446b = 1;
            return;
        L7:
            r104 = null;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public class i implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f244870a;

        public final void a() {
        L26:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th, "SDKMonitor->updateConfigFromNet tag2");
            if (SDKMonitor.access$100(this.f244870a) == true) goto L30;
            SDKMonitor.access$102(this.f244870a, true);
            SDKMonitor.access$200(this.f244870a).b(this.f244870a);
        L30:
            th.printStackTrace();
            return;
        L3:
            if (SDKMonitor.access$300(this.f244870a) == null) goto L39;
            Iterator r100 = SDKMonitor.access$400(this.f244870a).iterator();     // Catch: Throwable -> L26
        L6:
            if (r100.hasNext() == false) goto L40;
            String r101 = (String) r100.next();     // Catch: Throwable -> L26
            JSONObject r102 = this.f244870a.retrieveSettingsParams();     // Catch: Throwable -> L26
            HashMap r103 = new HashMap();     // Catch: Throwable -> L26
            r103.put("Content-Type", "application/json; charset=utf-8");     // Catch: Throwable -> L26
            JSONObject r104 = new JSONObject();     // Catch: Throwable -> L26
            r104.put(SDKMonitor.access$500(this.f244870a), r102);     // Catch: Throwable -> L26
            byte[] r105 = SDKMonitor.compress(r104.toString().getBytes(), r103);     // Catch: Throwable -> L26
            if (by5.n.f21462e == false) goto L34;
            fy5.c.a("url:" + r101);     // Catch: Throwable -> L26
        L34:
        L23:
            th = move-exception;
            EnsureManager.ensureNotReachHere(th, "SDKMonitor->updateConfigFromNet");     // Catch: Throwable -> L26
            th.printStackTrace();     // Catch: Throwable -> L26
            goto L6
        L11:
            if (SDKMonitor.access$600(this.f244870a) == null) goto L13;
            byte[] r106 = SDKMonitor.access$600(this.f244870a).doPost(r101, r105, r103).f476669c;     // Catch: Throwable -> L23
        L14:
            if (r106 == null) goto L41;
            JSONObject r107 = new JSONObject(new String(r106));     // Catch: Throwable -> L23
            if (by5.n.f21462e == false) goto L18;
            fy5.c.a("resultJSON:" + r107);     // Catch: Throwable -> L23
        L18:
            JSONObject r108 = r107.optJSONObject(SDKMonitor.access$500(this.f244870a));     // Catch: Throwable -> L23
            if (r108 == null) goto L20;
            this.f244870a.updateWithSpecificAidResult(r108);     // Catch: Throwable -> L23
        L42:
            return;
        L20:
            return;
        L41:
            return;
        L13:
            r106 = com.bytedance.framwork.core.sdkmonitor.e.c(r101, r105, SDKMonitor.access$700(this.f244870a)).f476669c;     // Catch: Throwable -> L23
            goto L14
        L40:
            return;
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public i(SDKMonitor r100) {
            this.f244870a = r100;
        }
    }

    public class j implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f244871a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f244872b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f244873c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f244874d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f244875e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f244876f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f244877g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f244878h;

        @Override // java.lang.Runnable
        public final void run() {
            this.f244878h.handleNetSLA(this.f244871a, this.f244872b, this.f244873c, this.f244874d, this.f244875e, this.f244876f, this.f244877g);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public j(SDKMonitor r100, long r101, long r102, String r103, String r104, String r105, int r106, JSONObject r110) {
            this.f244878h = r100;
            this.f244871a = r101;
            this.f244872b = r102;
            this.f244873c = r103;
            this.f244874d = r104;
            this.f244875e = r105;
            this.f244876f = r106;
            this.f244877g = r110;
        }
    }

    public class k implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ long f244879a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ long f244880b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ String f244881c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ String f244882d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ String f244883e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ int f244884f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ JSONObject f244885g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f244886h;

        @Override // java.lang.Runnable
        public final void run() {
            this.f244886h.handleApiError(this.f244879a, this.f244880b, this.f244881c, this.f244882d, this.f244883e, this.f244884f, this.f244885g);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public k(SDKMonitor r100, long r101, long r102, String r103, String r104, String r105, int r106, JSONObject r110) {
            this.f244886h = r100;
            this.f244879a = r101;
            this.f244880b = r102;
            this.f244881c = r103;
            this.f244882d = r104;
            this.f244883e = r105;
            this.f244884f = r106;
            this.f244885g = r110;
        }
    }

    public class l implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f244887a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ int f244888b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ JSONObject f244889c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ JSONObject f244890d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final /* synthetic */ JSONObject f244891e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final /* synthetic */ JSONObject f244892f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final /* synthetic */ long f244893g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final /* synthetic */ SDKMonitor f244894h;

        @Override // java.lang.Runnable
        public final void run() {
            this.f244894h.monitorService(this.f244887a, this.f244888b, this.f244889c, this.f244890d, this.f244891e, this.f244892f, this.f244893g);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public l(SDKMonitor r100, String r101, int r102, JSONObject r103, JSONObject r104, JSONObject r105, JSONObject r106, long r107) {
            this.f244894h = r100;
            this.f244887a = r101;
            this.f244888b = r102;
            this.f244889c = r103;
            this.f244890d = r104;
            this.f244891e = r105;
            this.f244892f = r106;
            this.f244893g = r107;
        }
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface m {
    }

    /* JADX INFO: loaded from: classes19.dex */
    public interface n {
    }

    public void flushBuffer() {
    }

    public void flushBuffer(m r100) {
    }

    static {
        atomicLong = new AtomicLong(0);
    }

    private IHttpService getHttpService() {
        if (this.mHttpService != null) goto L6;
        this.mHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);
    L6:
        if (this.mHttpService != null) goto L8;
        monitor-enter(this);
        IHttpService r100 = hostHttpService;     // Catch: Throwable -> L13
        monitor-exit(this);     // Catch: Throwable -> L13
        return r100;
    L13:
        th = move-exception;
        throw th;
    L8:
        return this.mHttpService;
    }

    private String getSessionId() {
        IGetExtendParams r100 = this.mIGetExtendParams;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.getSessionId();
    }

    private SharedPreferences getSp() {
        Context r100 = this.mContext;
        if (r100 == null) goto L6;
        String r101 = com.bytedance.framwork.core.sdkmonitor.d.a(r100);
        return this.mContext.getSharedPreferences("monitor_config" + this.mAid + r101, 0);
    L6:
        return null;
    }

    private void initConfig() {
        SharedPreferences r100 = getSp();
        DowngradeInfo r101 = null;
        String r102 = r100.getString("monitor_net_config", null);
        this.mLastFetchSettingTime = r100.getLong("monitor_configure_refresh_time", 0);
        this.lastCalculateTimestamp = r100.getLong("monitor_last_calculate_timestamp", 0);
        this.lastFullCalculateTimestamp = r100.getLong("monitor_last_full_calculate_timestamp", 0);
        if (r100.getInt("monitor_config_update", 0) != 1) goto L5;
        boolean r103 = true;
    L6:
        gy5.a.b.f483331a.a(this);
        if (TextUtils.isEmpty(r102) == false) goto L33;
    L17:
        IConfigManager r104 = (IConfigManager) ServiceManager.getService(IConfigManager.class);
        if (r104 == null) goto L20;
        r104.registerConfigListener(new h());
    L20:
        updateConfigFromNet(false);
        com.bytedance.framwork.core.sdklib.apm6.downgrade.a r105 = com.bytedance.framwork.core.sdklib.apm6.downgrade.a.C3505a.f244861a;
        cy5.a r106 = new cy5.a(by5.n.getContext());
        r105.f244860b = r106;
        String r107 = r106.f465788a.getString(com.heytap.mcssdk.constant.b.f276366p, null);
        if (r107 != null) goto L35;
    L31:
        r105.a(r101, false);
        return;
    L35:
    L29:
        e = move-exception;
        e.printStackTrace();
        goto L31
    L23:
        if (by5.n.f21462e == false) goto L25;
        fy5.c.d("SDK-Downgrade", "DowngradeData-load-".concat(r107));     // Catch: JSONException -> L29
    L25:
        DowngradeInfo r108 = DowngradeInfo.a(new JSONObject(r107));     // Catch: JSONException -> L29
        if (System.currentTimeMillis() >= r108.f244854a) goto L31;
        r101 = r108;
        goto L31
    L33:
        this.mConfigExit = true;     // Catch: Exception -> L16
        if (by5.n.f21462e == false) goto L11;
        fy5.c.d("APM-SDK", "local_config:" + r102);     // Catch: Exception -> L16
    L11:
        JSONObject r109 = new JSONObject(r102);     // Catch: Exception -> L16
        if (r103 == true) goto L14;
        r109.remove("report_host_new");     // Catch: Exception -> L16
    L14:
        updateConfig(r109);     // Catch: Exception -> L16
        goto L17
    L5:
        r103 = false;
        goto L6
    }

    public void flushReport() {
        gy5.a.b.f483331a.b(new a());
    }

    public int getNetWorkType() {
        return NetworkUtils.getNetworkType(this.mContext).getValue();
    }

    public JSONObject retrieveSettingsParams() {
        if (this.mCommonParams == null) goto L5;
        HashMap r100 = new HashMap(this.mCommonParams);
    L7:
        if (TextUtils.isEmpty(hostAid) == true) goto L9;
        r100.put("host_aid", hostAid);
    L9:
        r100.put("sdk_version", String.valueOf(400));
        r100.put(LBSLightLocationTraceLogger.ENCRYPT, "close");
        if ((System.currentTimeMillis() - this.lastCalculateTimestamp) < 604800000) goto L12;
        r100.put("force_refresh", String.valueOf(1));
    L12:
        r100.put("last_calculate_timestamp", String.valueOf(this.lastCalculateTimestamp / 1000));
        r100.put("last_full_calculate_timestamp", String.valueOf(this.lastFullCalculateTimestamp / 1000));
        return new JSONObject(r100);
    L5:
        r100 = new HashMap();
        goto L7
    }

    private boolean needUpdateConfigFromNet() {
        if ((System.currentTimeMillis() - this.mLastFetchSettingTime) <= (this.mFetchSettingInterval * 1000)) goto L5;
        return true;
    L5:
        return false;
    }

    public boolean isHasInit() {
        return this.mHasInit;
    }

    public JSONObject reportJsonHeaderInfo() {
        return this.mHeaderInfo;
    }

    public SDKMonitor(String r100) {
        this.SETTINGS_CODE_FULL_MODIFIED = 0;
        this.SETTINGS_CODE_FAIL = -1;
        this.SETTINGS_CODE_NOT_MODIFIED = 1;
        this.SETTINGS_CODE_INCREMENT_MODIFIED = 2;
        this.mLastFetchSettingTime = 0;
        this.mConfigUrls = new LinkedList();
        this.mIsEncrypt = true;
        this.mAid = r100;
        this.mConfigExit = false;
        this.mCacheData = new com.bytedance.framwork.core.sdkmonitor.b();
    }

    public static /* synthetic */ boolean access$100(SDKMonitor r100) {
        return r100.mConfigExit;
    }

    public static /* synthetic */ com.bytedance.framwork.core.sdkmonitor.b access$200(SDKMonitor r100) {
        return r100.mCacheData;
    }

    public static /* synthetic */ Map access$300(SDKMonitor r100) {
        return r100.mCommonParams;
    }

    public static /* synthetic */ List access$400(SDKMonitor r100) {
        return r100.mConfigUrls;
    }

    public static /* synthetic */ String access$500(SDKMonitor r100) {
        return r100.mAid;
    }

    public static /* synthetic */ IHttpService access$600(SDKMonitor r100) {
        return r100.getHttpService();
    }

    public static /* synthetic */ boolean access$700(SDKMonitor r100) {
        return r100.mIsEncrypt;
    }

    private void addDebugMessage(JSONObject r100) {
        JSONObject r101 = new JSONObject();     // Catch: Exception -> L4
        r101.put("aid", this.mAid);     // Catch: Exception -> L4
        hy5.a.a(r101);     // Catch: Exception -> L4
        r101.put("process_name", hy5.c.a());     // Catch: Exception -> L4
        r101.put(KEY_DEBUG_UUID, sid + "_" + atomicLong.getAndAdd(1));     // Catch: Exception -> L4
        r100.put(KEY_SELF_DEBUG_MESSAGE, r101);     // Catch: Exception -> L4
        return;
    }

    private boolean isMatchAllowURI(String r100) {
        return isMatch(r100, this.mAllowReportList, this.mAllowReportPatterns);
    }

    private boolean isMatchBlackURI(String r100) {
        return isMatch(r100, this.mBlockReportList, this.mBlockReportPatterns);
    }

    public static void setHostAid(String r100) {
        hostAid = r100;
    }

    public static void setHttpService(IHttpService r100) {
        monitor-enter(SDKMonitor.class);
        hostHttpService = r100;     // Catch: Throwable -> L7
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L7
        return;
    L7:
        th = move-exception;
        throw th;
    }

    public void flushReport(m r100) {
        gy5.a.b.f483331a.b(new b());
    }

    public boolean getLogTypeSwitch(String r100) {
        if (this.mAllowLogType != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        if (this.mAllowLogType.optInt(r100) != 1) goto L12;
        return true;
    L12:
        return false;
    }

    public boolean getServiceSwitch(String r100) {
        if (this.mAllowService != null) goto L5;
        return false;
    L5:
        if (TextUtils.isEmpty(r100) == false) goto L8;
        return false;
    L8:
        if (this.mAllowService.optInt(r100) != 1) goto L12;
        return true;
    L12:
        return false;
    }

    @Override // gy5.b
    public void onTimeEvent(long r100) {
        if (this.mFetchSettingInterval > 0) goto L5;
        return;
    L5:
        updateConfigFromNet(false);
    }

    public void resetConfigUrls(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (hy5.b.a(r100) == true) goto L8;
        this.mConfigUrls.clear();
        this.mConfigUrls.addAll(r100);
        return;
    }

    public void resetReportUrls(List<String> r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (hy5.b.a(r100) == true) goto L8;
        by5.d.a.f21420a.d(r100);
        return;
    }

    public synchronized void updateConfig(JSONObject r110) {
        monitor-enter(this);
        if (r110 != null) goto L140;
        monitor-exit(this);
        return;
    L140:
        JSONObject r100 = r110.optJSONObject("general");     // Catch: Throwable -> L130
        ArrayList r101 = null;
        if (r100 != null) goto L9;
        JSONObject r102 = null;
    L10:
        int r103 = 0;
        if (r102 == null) goto L68;
        JSONObject r104 = r102.optJSONObject("fetch_setting");     // Catch: Throwable -> L130
        if (r104 == null) goto L16;
        this.mFetchSettingInterval = r104.optLong("fetch_setting_interval", AdQuickAppManager.DEFAULT_QUICK_APP_CHECK_TIME);     // Catch: Throwable -> L130
    L16:
        if (this.mFetchSettingInterval >= 600) goto L18;
        this.mFetchSettingInterval = 600;     // Catch: Throwable -> L130
    L18:
        JSONObject r105 = r102.optJSONObject("report_setting");     // Catch: Throwable -> L130
        if (r105 == null) goto L59;
        ArrayList r106 = new ArrayList();     // Catch: Throwable -> L130
        JSONArray r107 = r105.optJSONArray("hosts");     // Catch: Exception -> L133 Throwable -> L130
        if (r107 == null) goto L41;
        if (r107.length() <= 0) goto L41;
        int r108 = r107.length();     // Catch: Exception -> L133 Throwable -> L130
        int r109 = 0;
    L26:
        if (r109 >= r108) goto L41;
        String r111 = JSONArrayProtectorUtils.getString(r107, r109);     // Catch: Exception -> L133 Throwable -> L130
        if (this.mOversea == false) goto L35;
        if (r111.contains(".snssdk.") == true) goto L33;
        if (r111.contains(".toutiao.") == false) goto L35;
    L33:
        r106.clear();     // Catch: Exception -> L133 Throwable -> L130
    L35:
        if (TextUtils.isEmpty(r111) == true) goto L39;
        if (r111.indexOf(46) <= 0) goto L39;
        r106.add(r111);     // Catch: Exception -> L133 Throwable -> L130
    L39:
        r109 = r109 + 1;
    L41:
        if (r106.isEmpty() == true) goto L43;
        by5.d.a.f21420a.d(r106);     // Catch: Throwable -> L130
    L43:
        int r112 = 60;
        this.mReportInterval = r105.optInt("uploading_interval", 60);     // Catch: Throwable -> L130
        if (this.mReportInterval < 0) goto L47;
        r112 = this.mReportInterval;     // Catch: Throwable -> L130
    L47:
        this.mReportInterval = r112;     // Catch: Throwable -> L130
        by5.e.a.f21426a.d(this.mReportInterval * 1000);     // Catch: Throwable -> L130
        int r113 = 100;
        this.mReportCount = r105.optInt("once_max_count", 100);     // Catch: Throwable -> L130
        if (this.mReportCount < 0) goto L51;
        r113 = this.mReportCount;     // Catch: Throwable -> L130
    L51:
        this.mReportCount = r113;     // Catch: Throwable -> L130
        this.mIsEncrypt = r105.optBoolean("enable_encrypt", true);     // Catch: Throwable -> L130
        by5.d r114 = by5.d.a.f21420a;     // Catch: Throwable -> L130
        r114.f21417j.put(this.mAid, Boolean.valueOf(this.mIsEncrypt));     // Catch: Throwable -> L130
        Iterator<Boolean> r115 = r114.f21417j.values().iterator();     // Catch: Throwable -> L130
    L53:
        if (r115.hasNext() == false) goto L57;
        if (r115.next().booleanValue() == false) goto L53;
        boolean r116 = true;
    L58:
        r114.f21418k = r116;     // Catch: Throwable -> L130
        goto L59
    L57:
        r116 = false;
    L59:
        JSONObject r117 = r110.optJSONObject("general");     // Catch: Throwable -> L130
        if (r117 != null) goto L62;
        int r118 = 0;
    L63:
        if (r118 != 1) goto L65;
        boolean r119 = true;
    L66:
        fy5.a.f479282b = r119;     // Catch: Throwable -> L130
        goto L68
    L65:
        r119 = false;
        goto L66
    L62:
        r118 = r117.optInt("enable_report_internal_exception", 0);     // Catch: Throwable -> L130
    L68:
        if (r110.length() > 0) goto L71;
        monitor-exit(this);
        return;
    L71:
        JSONObject r120 = r110.optJSONObject("custom_event_settings");     // Catch: Throwable -> L130
        if (r120 == null) goto L74;
        this.mAllowService = r120.optJSONObject("allow_service_name");     // Catch: Throwable -> L130
        this.mAllowLogType = r120.optJSONObject("allow_log_type");     // Catch: Throwable -> L130
        this.mCustomAllowLogType = r120.optJSONObject("custom_allow_log_type");     // Catch: Throwable -> L130
    L74:
        JSONObject r121 = r110.optJSONObject("network_image_modules");     // Catch: Throwable -> L130
        if (r121 != null) goto L77;
        JSONObject r122 = null;
    L78:
        if (r122 == null) goto L128;
        this.mDisableReportApiError = r122.optInt("enable_api_error_upload", 0);     // Catch: Throwable -> L130
        this.mReportSLA = r122.optInt("enable_api_all_upload", 0);     // Catch: Throwable -> L130
        JSONArray r123 = r122.optJSONArray("api_block_list");     // Catch: Exception -> L137 Throwable -> L130
        if (r123 == null) goto L90;
        if (r123.length() <= 0) goto L90;
        int r124 = r123.length();     // Catch: Exception -> L137 Throwable -> L130
        ArrayList r125 = new ArrayList(r124);     // Catch: Exception -> L137 Throwable -> L130
        int r126 = 0;
    L85:
        if (r126 >= r124) goto L91;
        String r127 = JSONArrayProtectorUtils.getString(r123, r126);     // Catch: Exception -> L137 Throwable -> L130
        if (TextUtils.isEmpty(r127) == true) goto L89;
        r125.add(r127);     // Catch: Exception -> L137 Throwable -> L130
    L89:
        r126 = r126 + 1;
    L91:
        this.mBlockReportList = r125;     // Catch: Throwable -> L130
        JSONArray r128 = r122.optJSONArray("api_block_list");     // Catch: Exception -> L136 Throwable -> L130
        if (r128 == null) goto L102;
        if (r128.length() <= 0) goto L102;
        int r129 = r128.length();     // Catch: Exception -> L136 Throwable -> L130
        ArrayList r130 = new ArrayList(r129);     // Catch: Exception -> L136 Throwable -> L130
    L97:
        if (r103 >= r129) goto L103;
        String r131 = JSONArrayProtectorUtils.getString(r128, r103);     // Catch: Exception -> L136 Throwable -> L130
        if (TextUtils.isEmpty(r131) == true) goto L101;
        r130.add(PatternProtector.compile(r131));     // Catch: Exception -> L136 Throwable -> L130
    L101:
        r103 = r103 + 1;
    L103:
        this.mBlockReportPatterns = r130;     // Catch: Throwable -> L130
        JSONObject r132 = r122.optJSONObject("api_allow_list");     // Catch: Exception -> L135 Throwable -> L130
        if (xu3.d.c(r132) == true) goto L114;
        ArrayList r133 = new ArrayList();     // Catch: Exception -> L135 Throwable -> L130
        Iterator<String> r134 = r132.keys();     // Catch: Exception -> L135 Throwable -> L130
    L109:
        if (r134.hasNext() == false) goto L115;
        String r135 = r134.next();     // Catch: Exception -> L135 Throwable -> L130
        if (r132.optInt(r135) != 1) goto L109;
        r133.add(r135);     // Catch: Exception -> L135 Throwable -> L130
    L115:
        this.mAllowReportList = r133;     // Catch: Throwable -> L130
        JSONObject r136 = r122.optJSONObject("api_allow_list");     // Catch: Exception -> L134 Throwable -> L130
        if (xu3.d.c(r136) == true) goto L127;
        ArrayList r137 = new ArrayList();     // Catch: Exception -> L134 Throwable -> L130
        Iterator<String> r138 = r136.keys();     // Catch: Exception -> L134 Throwable -> L130
    L121:
        if (r138.hasNext() == false) goto L126;
        String r139 = r138.next();     // Catch: Exception -> L134 Throwable -> L130
        if (r136.optInt(r139) != 1) goto L121;
        r137.add(PatternProtector.compile(r139));     // Catch: Exception -> L134 Throwable -> L130
    L126:
        r101 = r137;
    L127:
        this.mAllowReportPatterns = r101;     // Catch: Throwable -> L130
    L114:
        r133 = null;
    L102:
        r130 = null;
    L90:
        r125 = null;
    L128:
        monitor-exit(this);
        return;
    L77:
        r122 = r121.optJSONObject("network");     // Catch: Throwable -> L130
        goto L78
    L9:
        r102 = r100.optJSONObject("slardar_api_settings");     // Catch: Throwable -> L130
    L130:
        th = move-exception;
        throw th;
    }

    public void updateConfigFromNet(boolean r100) {
        if (this.mFetchSettingInterval >= 600) goto L6;
        this.mFetchSettingInterval = 600;
    L6:
        if (by5.n.f21462e == false) goto L16;
        StringBuilder r101 = new StringBuilder("updateConfigFromNet:");
        if (r100 == true) goto L12;
        if (needUpdateConfigFromNet() == true) goto L12;
    L14:
        boolean r102 = false;
    L15:
        r101.append(r102);
        fy5.c.a(r101.toString());
    L12:
        if (com.bytedance.framwork.core.sdkmonitor.e.d(this.mContext) == false) goto L14;
        r102 = true;
    L16:
        if (r100 == true) goto L20;
        if (needUpdateConfigFromNet() == true) goto L20;
        return;
    L20:
        if (com.bytedance.framwork.core.sdkmonitor.e.d(this.mContext) == true) goto L22;
        return;
    L22:
        monitor-enter(SDKMonitor.class);
        this.mLastFetchSettingTime = System.currentTimeMillis();     // Catch: Throwable -> L29
        monitor-exit(SDKMonitor.class);     // Catch: Throwable -> L29
        gy5.a.b.f483331a.b(new i(this));     // Catch: Throwable -> L27
        return;
    L27:
        th = move-exception;
        EnsureManager.ensureNotReachHere(th, "SDKMonitor->updateConfigFromNet tag3");
        return;
    L29:
        th = move-exception;
        throw th;
    }

    public boolean updateWithSpecificAidResult(JSONObject r110) {
        int r100 = r110.optInt("code", -1);
        if (r100 != (-1)) goto L5;
        return false;
    L5:
        SharedPreferences r101 = getSp();
        SharedPreferences.Editor r102 = r101.edit();
        if (r100 != 1) goto L9;
        r102.putLong("monitor_configure_refresh_time", System.currentTimeMillis());
        r102.putInt("monitor_config_update", 1);
        r102.apply();
        return true;
    L9:
        if (r100 != 0) goto L11;
    L12:
        JSONObject r103 = r110.optJSONObject("data");
        if (r103 != null) goto L22;
        String r104 = r101.getString("monitor_net_config", "");
        if (TextUtils.isEmpty(r104) == false) goto L45;
        r104 = SliceInitService.DEFAULT_SWITCH;
    L45:
        r103 = new JSONObject(r104);     // Catch: JSONException -> L20
    L20:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SDKMonitor->updateWithSpecificAidResult");
        r103 = null;
    L22:
        if (r103 != null) goto L49;
        return false;
    L49:
        JSONObject r105 = r110.optJSONObject("data_to_merge");     // Catch: JSONException -> L28
        if (r105 == null) goto L47;
        xu3.d.d(r103, r105);     // Catch: JSONException -> L28
    L47:
        JSONObject r106 = r110.optJSONObject("data_to_delete");     // Catch: JSONException -> L36
        if (r106 == null) goto L40;
        xu3.d.b(r103, r106);     // Catch: JSONException -> L36
    L40:
        this.lastCalculateTimestamp = ((long) r110.optInt("last_calculate_timestamp", 0)) * 1000;
        this.lastFullCalculateTimestamp = ((long) r110.optInt("last_full_calculate_timestamp", 0)) * 1000;
        updateConfig(r103);
        r102.putLong("monitor_configure_refresh_time", System.currentTimeMillis());
        r102.putString("monitor_net_config", r103.toString());
        r102.putLong("monitor_last_calculate_timestamp", this.lastCalculateTimestamp);
        r102.putLong("monitor_last_full_calculate_timestamp", this.lastFullCalculateTimestamp);
        r102.putInt("monitor_config_update", 1);
        if (this.mConfigExit == true) goto L43;
        this.mConfigExit = true;
        this.mCacheData.b(this);
    L43:
        r102.apply();
    L44:
        return true;
    L36:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SDKMonitor->updateWithSpecificAidResult 3");
        if (by5.n.f21462e == false) goto L40;
        av3.b.b("APM-SDK", "error nested data: dataToDelete");
    L28:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SDKMonitor->updateWithSpecificAidResult 2");
        if (by5.n.f21462e == false) goto L47;
        av3.b.b("APM-SDK", "error nested data: dataToMerge");
        goto L47
    L11:
        if (r100 != 2) goto L44;
        goto L12
    }

    public static /* synthetic */ boolean access$102(SDKMonitor r100, boolean r101) {
        r100.mConfigExit = r101;
        return r101;
    }

    private void combineJson(JSONObject r100, JSONObject r101) {
        if (r100 == null) goto L19;
        if (r101 != null) goto L5;
        return;
    L5:
        if (r101.length() <= 0) goto L21;
        Iterator<String> r102 = r101.keys();     // Catch: JSONException -> L12
    L9:
        if (r102.hasNext() == false) goto L22;
        String r103 = r102.next();     // Catch: JSONException -> L12
        r100.put(r103, r101.get(r103));     // Catch: JSONException -> L12
        goto L9
    L22:
        return;
    L12:
        e = move-exception;
        e.printStackTrace();
        return;
    L21:
        return;
    }

    public static byte[] compress(byte[] r100, Map<String, String> r101) throws IOException {
        if (r100.length <= 128) goto L14;
        ByteArrayOutputStream r102 = new ByteArrayOutputStream(8192);
        GZIPOutputStream r103 = new GZIPOutputStream(r102);
        r103.write(r100);     // Catch: Throwable -> L7 IOException -> L9
        r103.close();
        byte[] r104 = r102.toByteArray();
        r101.put("Content-Encoding", DownloadHelper.GZIP);
        return r104;
    L7:
        th = move-exception;
        r103.close();
        throw th;
    L9:
        e = move-exception;
        EnsureManager.ensureNotReachHere(e, "SDKMonitor->compress");     // Catch: Throwable -> L7
        throw e;     // Catch: Throwable -> L7
    L14:
        return r100;
    }

    private static String encode(String r100, String r101) {
        if (r101 != null) goto L10;
        r101 = "UTF-8";
    L10:
        return URLEncoder.encode(r100, r101);
    L7:
        e = move-exception;
        throw new IllegalArgumentException(e);
    }

    public boolean getLogTypeSwitch(String r110, JSONObject r111) {
        if (this.mAllowLogType != null) goto L5;
    L44:
        return false;
    L5:
        if (TextUtils.isEmpty(r110) == true) goto L44;
        if (this.mAllowLogType.optInt(r110) != 1) goto L10;
        boolean r100 = true;
    L11:
        if (r100 == true) goto L13;
    L43:
        return r100;
    L13:
        if (this.mCustomAllowLogType == null) goto L43;
        String r112 = this.mCustomAllowLogType.optString(r110);
        if (StringUtils.isEmpty(r112) == true) goto L43;
        JSONObject r101 = new JSONObject(r112);     // Catch: JSONException -> L45
        Iterator<String> r113 = r101.keys();     // Catch: JSONException -> L45
    L17:
        if (r113.hasNext() == false) goto L43;
        String r102 = r113.next();     // Catch: JSONException -> L45
        Object r103 = r101.get(r102);     // Catch: JSONException -> L45
        if (r102.startsWith("$.data.") == false) goto L17;
        String[] r104 = r102.replace("$.data.", "").split(EasyGoConstant.VERSION_SEPARATIVE_SIGN);     // Catch: JSONException -> L45
        Object r105 = r111;
        int r106 = 0;
        boolean r107 = false;
    L24:
        if (r106 >= r104.length) goto L32;
        if (r105 == null) goto L31;
        if ((r105 instanceof JSONObject) == false) goto L29;
        r105 = ((JSONObject) r105).opt(r104[r106]);     // Catch: JSONException -> L45
    L30:
        r106 = r106 + 1;     // Catch: JSONException -> L45
        goto L24
    L29:
        r107 = true;
        goto L30
    L31:
        r107 = true;
    L32:
        if (r107 == true) goto L17;
        if (r105 == null) goto L17;
        if ((r103 instanceof JSONObject) == false) goto L17;
        if (((JSONObject) r103).optInt(r105.toString(), 1) != 1) goto L40;
        boolean r108 = true;
    L41:
        if (r108 == true) goto L17;
        return false;
    L40:
        r108 = false;
        goto L41
    L10:
        r100 = false;
        goto L11
    }

    public void monitorCommonLog(String r100, JSONObject r101) {
        if (this.mConfigExit == true) goto L15;
        com.bytedance.framwork.core.sdkmonitor.b r102 = this.mCacheData;     // Catch: Throwable -> L17
        com.bytedance.framwork.core.sdkmonitor.c r103 = new com.bytedance.framwork.core.sdkmonitor.c(r100, r101, System.currentTimeMillis());     // Catch: Throwable -> L17
        LinkedList<com.bytedance.framwork.core.sdkmonitor.c> r104 = r102.f244904b;     // Catch: Throwable -> L17
        monitor-enter(r104);     // Catch: Throwable -> L17
    L12:
        th = move-exception;
        throw th;     // Catch: Throwable -> L17
    L7:
        if (r102.f244904b.size() <= r102.f244906d) goto L9;
        r102.f244904b.poll();     // Catch: Throwable -> L12
    L9:
        r102.f244904b.add(r103);     // Catch: Throwable -> L12
        monitor-exit(r104);     // Catch: Throwable -> L12
        goto L22
    L21:
        return;
    L15:
        monitorCommonLogAsync(r100, r101, System.currentTimeMillis());     // Catch: Throwable -> L17
        return;
    }

    private StringBuilder appendUrlParam(StringBuilder r100, String r101, String r102) {
        if (r100.charAt(r100.length() - 1) == '?') goto L5;
        r100.append("&");
    L5:
        r100.append(encode(r101, "UTF-8"));
        r100.append(com.alipay.sdk.m.n.a.f25612h);
        r100.append(encode(r102, "UTF-8"));
        return r100;
    }

    private void initMonitor(Context r100, JSONObject r101, IGetExtendParams r110) {
        if (r100 == null) goto L55;
        if (r101 == null) goto L63;
        this.mHasInit = true;
        this.mContext = r100.getApplicationContext();
        this.mHeaderInfo = r101;
        r101.put("aid", this.mAid);     // Catch: Exception -> L56
        this.mHeaderInfo.put("os", "Android");     // Catch: Exception -> L56
        this.mHeaderInfo.put("device_platform", "android");     // Catch: Exception -> L56
        this.mHeaderInfo.put("os_version", Build.VERSION.RELEASE);     // Catch: Exception -> L56
        this.mHeaderInfo.put("os_api", Build.VERSION.SDK_INT);     // Catch: Exception -> L56
        this.mHeaderInfo.put("device_model", Build.MODEL);     // Catch: Exception -> L56
        this.mHeaderInfo.put("device_brand", Build.BRAND);     // Catch: Exception -> L56
        this.mHeaderInfo.put("device_manufacturer", Build.MANUFACTURER);     // Catch: Exception -> L56
        this.mHeaderInfo.put("sdkmonitor_version", "2.0.44");     // Catch: Exception -> L56
        this.mHeaderInfo.put("monitor_from", "sdk");     // Catch: Exception -> L56
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("package_name")) == false) goto L10;
        this.mHeaderInfo.put("package_name", r100.getPackageName());     // Catch: Exception -> L56
    L10:
        JSONObject r102 = null;
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_name")) == false) goto L13;
        PackageInfo r103 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);     // Catch: Exception -> L56
        this.mHeaderInfo.put("version_name", r103.versionName);     // Catch: Exception -> L56
    L15:
        if (TextUtils.isEmpty(this.mHeaderInfo.optString("version_code")) == false) goto L19;
        if (r103 != null) goto L18;
        r103 = this.mContext.getPackageManager().getPackageInfo(this.mContext.getPackageName(), 0);     // Catch: Exception -> L56
    L18:
        this.mHeaderInfo.put("version_code", r103.versionCode);     // Catch: Exception -> L56
    L19:
        this.mIGetExtendParams = r110;     // Catch: Exception -> L56
        if (r110 != null) goto L22;
        this.mIGetExtendParams = new g();     // Catch: Exception -> L56
    L22:
        Map<String, String> r104 = this.mIGetExtendParams.getCommonParams();     // Catch: Exception -> L56
        this.mCommonParams = r104;     // Catch: Exception -> L56
        if (r104 != null) goto L25;
        this.mCommonParams = new HashMap();     // Catch: Exception -> L56
    L25:
        this.mOversea = TextUtils.equals(this.mCommonParams.get("oversea"), "1");     // Catch: Exception -> L56
        this.mCommonParams.put("aid", this.mAid);     // Catch: Exception -> L56
        this.mCommonParams.put("device_id", this.mHeaderInfo.optString("device_id"));     // Catch: Exception -> L56
        this.mCommonParams.put("device_platform", "android");     // Catch: Exception -> L56
        this.mCommonParams.put("os", "Android");     // Catch: Exception -> L56
        this.mCommonParams.put("package_name", this.mHeaderInfo.optString("package_name"));     // Catch: Exception -> L56
        this.mCommonParams.put("channel", this.mHeaderInfo.optString("channel"));     // Catch: Exception -> L56
        this.mCommonParams.put("app_version", this.mHeaderInfo.optString("app_version"));     // Catch: Exception -> L56
        this.mCommonParams.put("sdkmonitor_version", "2.0.44");     // Catch: Exception -> L56
        this.mCommonParams.put("minor_version", "1");     // Catch: Exception -> L56
        this.mCommonParams.put("host_aid", this.mHeaderInfo.optString("host_aid"));     // Catch: Exception -> L56
        if (by5.n.f21462e == false) goto L29;
        fy5.c.a("initSDK:" + this.mAid + " " + this.mCommonParams);     // Catch: Exception -> L56
        fy5.c.a("headerInfo:" + this.mAid + " " + this.mHeaderInfo);     // Catch: Exception -> L56
    L29:
        monitor-enter(by5.n.class);     // Catch: Exception -> L56
    L52:
        th = move-exception;
        throw th;     // Catch: Exception -> L56
    L31:
        if (by5.n.f21458a == null) goto L34;
        monitor-exit(by5.n.class);     // Catch: Exception -> L56
    L36:
        Map<String, String> r105 = this.mCommonParams;     // Catch: Exception -> L56
        if (r105 != null) goto L39;
    L45:
        String r106 = this.mAid;     // Catch: Exception -> L56
        JSONObject r107 = this.mHeaderInfo;     // Catch: Exception -> L56
        if (r107 != null) goto L57;
    L51:
        by5.n.e(r106, r102);     // Catch: Exception -> L56
        this.mHttpService = (IHttpService) ServiceManager.getService(IHttpService.class);     // Catch: Exception -> L56
        initConfig();     // Catch: Exception -> L56
        return;
    L57:
        r102 = new JSONObject(r107.toString());     // Catch: Exception -> L50
    L50:
        r102 = r107;
        goto L51
    L39:
        if (r105.isEmpty() == true) goto L45;
        if (by5.n.f21460c != null) goto L44;
        by5.n.f21460c = new HashMap();     // Catch: Exception -> L56
    L44:
        ((HashMap) by5.n.f21460c).putAll(r105);     // Catch: Exception -> L56
        ((HashMap) by5.n.f21460c).remove("aid");     // Catch: Exception -> L56
        goto L45
    L34:
        by5.n.f21458a = r100;     // Catch: Throwable -> L52
        monitor-exit(by5.n.class);     // Catch: Exception -> L56
        goto L36
        goto L64
    L13:
        r103 = null;
    L64:
        return;
    L63:
        return;
    }

    private boolean isMatch(String r100, List<String> r101, List<Pattern> r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return false;
    L6:
        if (hy5.b.a(r101) == true) goto L23;
        Iterator<String> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L23;
        if (r100.contains(r103.next()) == false) goto L9;
        return true;
    L23:
        String r104 = new URI(r100).getPath();     // Catch: Throwable -> L22
        if (hy5.b.a(r102) == true) goto L21;
        Iterator<Pattern> r105 = r102.iterator();     // Catch: Throwable -> L22
    L17:
        if (r105.hasNext() == false) goto L21;
        if (r105.next().matcher(r104).matches() == false) goto L17;
        return true;
    L21:
        return false;
    }

    public boolean init(Context r100, JSONObject r101, IGetExtendParams r102) {
        if (this.mHasInit == false) goto L5;
        return true;
    L5:
        this.mHasInit = true;
        sid = System.currentTimeMillis();
        fy5.c.f479288a = fy5.b.a.f479287a;
        gy5.a r103 = gy5.a.b.f483331a;
        f r104 = new f(this, r100, r101, r102);
        gy5.c r105 = r103.f483327a;
        r105.b(Message.obtain(r105.f483337d, r104), 5000);
        return true;
    }

    public void monitorCommonLogAsync(String r100, JSONObject r110, long r111) {
        gy5.a.b.f483331a.b(new c(this, r100, r110, r111));
    }

    public void monitorCommonLogInternal(String r100, JSONObject r101, long r102) {
        r101.put(FrescoMonitorConst.LOG_TYPE, r100);     // Catch: Throwable -> L16
        r101.put("network_type", getNetWorkType());     // Catch: Throwable -> L16
        if (TextUtils.isEmpty(getSessionId()) == true) goto L7;
        r101.put("session_id", getSessionId());     // Catch: Throwable -> L16
    L7:
        if (r101.isNull("timestamp") == false) goto L10;
        r101.put("timestamp", r102);     // Catch: Throwable -> L16
    L10:
        if (getLogTypeSwitch(r100, r101) == false) goto L13;
        addDebugMessage(r101);     // Catch: Throwable -> L16
        ConcurrentHashMap<Long, Long> r103 = by5.i.f21441b;     // Catch: Throwable -> L16
        by5.i.a.f21444a.b(CastLongProtector.parseLong(this.mAid), r101);     // Catch: Throwable -> L16
        return;
    L13:
        if (by5.n.f21462e == false) goto L19;
        fy5.c.d("APM-SDK", "aid:" + this.mAid + " " + r100 + " notSampled");     // Catch: Throwable -> L16
        return;
    L19:
        return;
    }

    public void monitorDuration(String r100, JSONObject r101, JSONObject r102) {
        monitorStatusAndDuration(r100, 0, r101, r102);
    }

    public void monitorStatusRate(String r100, int r101, JSONObject r102) {
        monitorStatusAndDuration(r100, r101, null, r102);
    }

    public boolean init(Context r100, JSONObject r101, n r102) {
        if (r102 != null) goto L6;
        return init(r100, r101, new d());
    L6:
        return init(r100, r101, new e());
    }

    public static /* synthetic */ void access$000(SDKMonitor r100, Context r101, JSONObject r102, IGetExtendParams r103) {
        r100.initMonitor(r101, r102, r103);
    }

    public void monitorEvent(String r210, JSONObject r211, JSONObject r212, JSONObject r213) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.d(new com.bytedance.framwork.core.sdkmonitor.f(r210, 0, null, r211, r212, r213, System.currentTimeMillis()));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        monitorServiceAsync(r210, 0, null, r211, r212, r213, System.currentTimeMillis());     // Catch: Throwable -> L8
    }

    public void monitorStatusAndDuration(String r210, int r211, JSONObject r212, JSONObject r213) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.d(new com.bytedance.framwork.core.sdkmonitor.f(r210, r211, r212, null, null, r213, System.currentTimeMillis()));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        monitorServiceAsync(r210, r211, r212, null, null, r213, System.currentTimeMillis());     // Catch: Throwable -> L8
    }

    public void monitorStatusAndEvent(String r210, int r211, JSONObject r212, JSONObject r213, JSONObject r214) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.d(new com.bytedance.framwork.core.sdkmonitor.f(r210, r211, null, r212, r213, r214, System.currentTimeMillis()));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        monitorServiceAsync(r210, r211, null, r212, r213, r214, System.currentTimeMillis());     // Catch: Throwable -> L8
    }

    private JSONObject packLog(String r100, long r101, long r102, String r103, String r110, String r111, int r112) {
        if (TextUtils.isEmpty(r100) == false) goto L22;
        return null;
    L22:
        JSONObject r104 = new JSONObject();     // Catch: Exception -> L21
        r104.put(FrescoMonitorConst.LOG_TYPE, r100);     // Catch: Exception -> L21
        r104.put("duration", r101);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r103) == true) goto L9;
        r104.put("uri", UriProtector.parse(r103));     // Catch: Exception -> L21
    L9:
        if (r102 <= 0) goto L11;
        r104.put("timestamp", r102);     // Catch: Exception -> L21
    L11:
        r104.put("status", r112);     // Catch: Exception -> L21
        if (TextUtils.isEmpty(r110) == true) goto L16;
        r104.put(DNSParser.DNS_RESULT_IP, r110);     // Catch: Exception -> L21
    L16:
        if (TextUtils.isEmpty(r111) == true) goto L18;
        r104.put("trace_code", r111);     // Catch: Exception -> L21
    L19:
        r104.put("network_type", getNetWorkType());     // Catch: Exception -> L21
        return r104;
    L18:
        r104.put("trace_code", "");     // Catch: Exception -> L21
    L21:
        return null;
    }

    public void handleApiError(long r110, long r111, String r112, String r113, String r114, int r115, JSONObject r210) {
        if (this.mDisableReportApiError == 1) goto L14;
        if (isMatchBlackURI(r112) == true) goto L14;
        JSONObject r100 = packLog(UploadTypeInf.API_ERROR, r110, r111, r112, r113, r114, r115);
        combineJson(r100, r210);
        if (r100 != null) goto L10;
        return;
    L10:
        if (r100.length() <= 0) goto L18;
        addDebugMessage(r100);
        ConcurrentHashMap<Long, Long> r101 = by5.i.f21441b;
        by5.i.a.f21444a.b(CastLongProtector.parseLong(this.mAid), r100);
        return;
    L18:
        return;
    L14:
        if (by5.n.f21462e == false) goto L19;
        fy5.c.d("APM-SDK", "isMatchBlackURI or DisableReportApiError:" + r112);
        return;
    }

    public void handleNetSLA(long r110, long r111, String r112, String r113, String r210, int r211, JSONObject r212) {
        if (isMatchBlackURI(r112) == true) goto L20;
        if (com.bytedance.framwork.core.sdkmonitor.e.d(this.mContext) == false) goto L20;
        JSONObject r100 = packLog(UploadTypeInf.API_ALL, r110, r111, r112, r113, r210, r211);
        combineJson(r100, r212);
        if (r100 == null) goto L12;
        if (isMatchAllowURI(r112) == false) goto L12;
    L24:
        r100.put("hit_rules", 1);     // Catch: JSONException -> L23
        addDebugMessage(r100);     // Catch: JSONException -> L23
        ConcurrentHashMap<Long, Long> r101 = by5.i.f21441b;     // Catch: JSONException -> L23
        by5.i.a.f21444a.b(CastLongProtector.parseLong(this.mAid), r100);     // Catch: JSONException -> L23
        return;
    L28:
        return;
    L12:
        if (this.mReportSLA != 0) goto L24;
        if (by5.n.f21462e == false) goto L26;
        fy5.c.d("APM-SDK", "not sampled:" + r112);
        return;
    L26:
        return;
    L20:
        if (by5.n.f21462e == false) goto L29;
        fy5.c.d("APM-SDK", "isMatchBlackURI or net not available:" + r112);
        return;
    }

    public void monitorApiError(long r110, long r111, String r112, String r210, String r211, int r212, JSONObject r213) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.c(new com.bytedance.framwork.core.sdkmonitor.a(r110, r111, r112, r210, r211, r212, r213));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        gy5.a.b.f483331a.b(new k(this, r110, r111, r112, r210, r211, r212, r213));     // Catch: Throwable -> L8
    }

    public void monitorSLA(long r110, long r111, String r112, String r210, String r211, int r212, JSONObject r213) {
        if (this.mConfigExit == true) goto L6;
        this.mCacheData.c(new com.bytedance.framwork.core.sdkmonitor.a(r110, r111, r112, r210, r211, r212, r213));     // Catch: Throwable -> L8
    L9:
        return;
    L6:
        gy5.a.b.f483331a.b(new j(this, r110, r111, r112, r210, r211, r212, r213));     // Catch: Throwable -> L8
    }

    public void monitorService(String r100, int r101, JSONObject r102, JSONObject r103, JSONObject r104, JSONObject r110, long r111) {
        if (r110 == null) goto L24;
    L5:
        r110.put(FrescoMonitorConst.LOG_TYPE, UploadTypeInf.SERVICE_MONITOR);     // Catch: Throwable -> L23
        r110.put("service", r100);     // Catch: Throwable -> L23
        r110.put("status", r101);     // Catch: Throwable -> L23
        r110.put("network_type", getNetWorkType());     // Catch: Throwable -> L23
        r110.put("value", r102);     // Catch: Throwable -> L23
        if (r103 == null) goto L8;
        r110.put("category", r103);     // Catch: Throwable -> L23
    L8:
        if (r104 == null) goto L11;
        r110.put("metric", r104);     // Catch: Throwable -> L23
    L11:
        if (r110.isNull("timestamp") == false) goto L14;
        r110.put("timestamp", r111);     // Catch: Throwable -> L23
    L14:
        if (TextUtils.isEmpty(getSessionId()) == true) goto L17;
        r110.put("session_id", getSessionId());     // Catch: Throwable -> L23
    L17:
        if (getServiceSwitch(r100) == false) goto L20;
        addDebugMessage(r110);     // Catch: Throwable -> L23
        ConcurrentHashMap<Long, Long> r105 = by5.i.f21441b;     // Catch: Throwable -> L23
        by5.i.a.f21444a.b(CastLongProtector.parseLong(this.mAid), r110);     // Catch: Throwable -> L23
        return;
    L20:
        if (by5.n.f21462e == false) goto L26;
        fy5.c.d("APM-SDK", "aid:" + this.mAid + " " + r100 + " notSampled");     // Catch: Throwable -> L23
        return;
    L26:
        return;
    L24:
        r110 = new JSONObject();     // Catch: Throwable -> L23
        goto L5
    }

    public void monitorServiceAsync(String r110, int r111, JSONObject r112, JSONObject r113, JSONObject r114, JSONObject r115, long r116) {
        gy5.a.b.f483331a.b(new l(this, r110, r111, r112, r113, r114, r115, r116));
    }
}
