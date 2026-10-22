package com.huawei.hms.activity;

import android.app.Activity;
import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.text.TextUtils;
import android.view.KeyEvent;
import com.huawei.hms.activity.internal.BusResponseCallback;
import com.huawei.hms.activity.internal.BusResponseResult;
import com.huawei.hms.activity.internal.ForegroundBusResponseMgr;
import com.huawei.hms.activity.internal.ForegroundInnerHeader;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.IntentUtil;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.UIUtil;
import com.huawei.hms.utils.Util;
import java.lang.ref.WeakReference;
import java.util.Map;

/* JADX INFO: loaded from: classes23.dex */
public class ForegroundBusDelegate implements IBridgeActivityDelegate {
    public static final String HMS_FOREGROUND_REQ_BODY = "HMS_FOREGROUND_REQ_BODY";
    public static final String HMS_FOREGROUND_REQ_HEADER = "HMS_FOREGROUND_REQ_HEADER";
    public static final String HMS_FOREGROUND_REQ_INNER = "HMS_FOREGROUND_REQ_INNER";
    public static final String HMS_FOREGROUND_RESP_HEADER = "HMS_FOREGROUND_RESP_HEADER";
    public static final String INNER_PKG_NAME = "INNER_PACKAGE_NAME";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private RequestHeader f276847a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f276848b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private ForegroundInnerHeader f276849c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private ResponseHeader f276850d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private WeakReference<Activity> f276851e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private boolean f276852f;

    public static /* synthetic */ class a {
    }

    public class b implements AvailableAdapter.AvailableCallBack {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ForegroundBusDelegate f276853a;

        private b(ForegroundBusDelegate r100) {
            this.f276853a = r100;
        }

        @Override // com.huawei.hms.adapter.AvailableAdapter.AvailableCallBack
        public void onComplete(int r100) {
            if (r100 != 0) goto L4;
            ForegroundBusDelegate.a(this.f276853a);
            return;
        L4:
            HMSLog.i("ForegroundBusDelegate", "version check failed");
            ForegroundBusDelegate.a(this.f276853a, 0, "apk version is invalid");
        }

        public /* synthetic */ b(ForegroundBusDelegate r100, a r101) {
            this(r100);
        }
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public int getRequestCode() {
        return 431057;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeConfigurationChanged() {
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onKeyUp(int r100, KeyEvent r101) {
    }

    private void c() {
        if (this.f276847a == null) goto L6;
        a(HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED);
        return;
    }

    private void d() {
        a(HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY);
    }

    private Activity g() {
        WeakReference<Activity> r100 = this.f276851e;
        if (r100 != null) goto L7;
        return null;
    L7:
        return r100.get();
    }

    private void h() {
        HMSLog.i("ForegroundBusDelegate", "startApkHubActivity");
        Activity r100 = g();
        if (r100 != null) goto L7;
        HMSLog.e("ForegroundBusDelegate", "startApkHubActivity but activity is null");
        return;
    L7:
        if (this.f276852f == false) goto L9;
        String r101 = r100.getPackageName();
    L11:
        if (TextUtils.isEmpty(r101) == false) goto L14;
        HMSLog.e("ForegroundBusDelegate", "hmsPackageName is null, Service is invalid.");
        a(0, "hmsPackageName is null, Service is invalid.");
        return;
    L14:
        Intent r102 = new Intent(this.f276849c.getAction());
        r102.putExtra(HMS_FOREGROUND_REQ_BODY, this.f276848b);
        r102.setPackage(r101);     // Catch: IllegalArgumentException -> L17
    L18:
        r102.putExtra("intent.extra.isfullscreen", UIUtil.isActivityFullscreen(r100));
        r102.setClassName(r101, "com.huawei.hms.core.activity.UiJumpActivity");
        r102.putExtra(HMS_FOREGROUND_REQ_HEADER, this.f276847a.toJson());
        r102.putExtra("intent.extra.hms.core.DELEGATE_NAME", "com.huawei.hms.core.activity.ForegroundBus");
        b();     // Catch: ActivityNotFoundException -> L21
        r100.startActivityForResult(r102, 431057);     // Catch: ActivityNotFoundException -> L21
        return;
    L21:
        e = move-exception;
        HMSLog.e("ForegroundBusDelegate", "Launch sign in Intent failed. hms is probably being updated：", e);
        a(0, "launch bus intent failed");
        return;
    L17:
        HMSLog.e("ForegroundBusDelegate", "IllegalArgumentException when startApkHubActivity intent.setPackage");
        goto L18
    L9:
        r101 = HMSPackageManager.getInstance(r100.getApplicationContext()).getHMSPackageNameForMultiService();
        goto L11
    }

    public ForegroundBusDelegate() {
        this.f276849c = new ForegroundInnerHeader();
    }

    private void a() {
        Map<String, String> r100 = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f276847a);
        r100.put("direction", HiAnalyticsConstant.Direction.REQUEST);
        r100.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f276847a.getKitSdkVersion())));
        if (g() == null) goto L6;
        HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_ACTIVITY_STARTED, r100);
        return;
    }

    private void b() {
        Map<String, String> r100 = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f276847a);
        r100.put("direction", HiAnalyticsConstant.Direction.REQUEST);
        r100.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f276847a.getKitSdkVersion())));
        if (g() == null) goto L6;
        HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), HiAnalyticsConstant.HMS_SDK_BASE_START_CORE_ACTIVITY, r100);
        return;
    }

    private void e() {
        if (g() != null) goto L7;
        HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, activity must not be null.");
        a(0, "checkMinVersion failed, activity must not be null.");
        return;
    L7:
        if (this.f276852f == false) goto L11;
        h();
        return;
    L11:
        if (Util.isAvailableLibExist(g().getApplicationContext()) == false) goto L13;
        b r100 = new b(this, null);
        AvailableAdapter r101 = new AvailableAdapter(this.f276849c.getApkVersion());
        int r102 = r101.isHuaweiMobileServicesAvailable(g());
        if (r102 != 0) goto L21;
        r100.onComplete(r102);
        return;
    L21:
        if (r101.isUserResolvableError(r102) == false) goto L23;
        a(g(), r101, r100);
        return;
    L23:
        r100.onComplete(r102);
        return;
    L13:
        if (HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(g().getApplicationContext(), this.f276849c.getApkVersion()) == 0) goto L16;
        HMSLog.e("ForegroundBusDelegate", "checkMinVersion failed, and no available lib exists.");
        a(0, "apk version is invalid");
        return;
    L16:
        h();
    }

    private void f() {
        Activity r100 = g();
        if (r100 != null) goto L5;
        return;
    L5:
        if (r100.isFinishing() == true) goto L10;
        r100.finish();
        return;
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityDestroy() {
        c();
        this.f276851e = null;
    }

    private void a(String r100) {
        Map<String, String> r101 = HiAnalyticsUtil.getInstance().getMapFromForegroundRequestHeader(this.f276847a);
        r101.put("direction", HiAnalyticsConstant.Direction.RESPONSE);
        r101.put("version", HiAnalyticsUtil.versionCodeToName(String.valueOf(this.f276847a.getKitSdkVersion())));
        ResponseHeader r102 = this.f276850d;
        if (r102 == null) goto L6;
        r101.put("statusCode", String.valueOf(r102.getStatusCode()));
        r101.put("result", String.valueOf(this.f276850d.getErrorCode()));
    L6:
        if (g() == null) goto L9;
        HiAnalyticsUtil.getInstance().onNewEvent(g().getApplicationContext(), r100, r101);
        return;
    }

    private BusResponseCallback b(String r100) {
        return ForegroundBusResponseMgr.getInstance().get(r100);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public void onBridgeActivityCreate(Activity r100) {
        if (r100 != null) goto L7;
        HMSLog.e("ForegroundBusDelegate", "activity is null");
        a(0, "activity is null");
        return;
    L7:
        if (r100.isFinishing() == false) goto L10;
        HMSLog.e("ForegroundBusDelegate", "activity is finishing");
        a(0, "activity is finishing");
        return;
    L10:
        this.f276851e = new WeakReference(r100);
        Intent r101 = r100.getIntent();     // Catch: Throwable -> L32
        if (r101 != null) goto L15;
        a(0, "intent is invalid");     // Catch: Throwable -> L32
        return;
    L15:
        String r102 = r101.getStringExtra(HMS_FOREGROUND_REQ_HEADER);     // Catch: Throwable -> L32
        RequestHeader r103 = new RequestHeader();     // Catch: Throwable -> L32
        this.f276847a = r103;     // Catch: Throwable -> L32
        if (r103.fromJson(r102) == true) goto L19;
        a(0, "header is invalid");     // Catch: Throwable -> L32
        return;
    L19:
        this.f276848b = r101.getStringExtra(HMS_FOREGROUND_REQ_BODY);     // Catch: Throwable -> L32
        ForegroundInnerHeader r104 = this.f276849c;     // Catch: Throwable -> L32
        if (r104 != null) goto L23;
        a(0, "inner header is invalid");     // Catch: Throwable -> L32
        return;
    L23:
        r104.fromJson(r101.getStringExtra(HMS_FOREGROUND_REQ_INNER));     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(this.f276847a.getApiName()) == false) goto L27;
        a(0, "action is invalid");     // Catch: Throwable -> L32
        return;
    L27:
        a();     // Catch: Throwable -> L32
        if (TextUtils.isEmpty(r101.getStringExtra(INNER_PKG_NAME)) == true) goto L30;
        HMSLog.i("ForegroundBusDelegate", "isUseInnerHms: true");     // Catch: Throwable -> L32
        this.f276852f = true;     // Catch: Throwable -> L32
    L30:
        e();
        return;
    L32:
        th = move-exception;
        HMSLog.e("ForegroundBusDelegate", "ForegroundBusDelegate getStringExtra error:" + th.getMessage());
        a(0, "ForegroundBusDelegate getStringExtra error:" + th.getMessage());
    }

    public static /* synthetic */ void a(ForegroundBusDelegate r100) {
        r100.h();
    }

    private void a(int r100, String r101) {
        HMSLog.e("ForegroundBusDelegate", r101);
        Activity r102 = g();
        if (r102 != null) goto L5;
        return;
    L5:
        BusResponseCallback r103 = b(this.f276849c.getResponseCallbackKey());
        if (r103 == null) goto L11;
        BusResponseResult r104 = r103.innerError(this.f276851e.get(), r100, r101);
        if (r104 != null) goto L10;
        r102.setResult(0);
    L12:
        f();
        return;
    L10:
        r102.setResult(r104.getCode(), IntentUtil.modifyIntentBehaviorsSafe(r104.getIntent()));
        goto L12
    L11:
        r102.setResult(0);
        goto L12
    }

    private void a(int r100, Intent r101) {
        HMSLog.i("ForegroundBusDelegate", "succeedReturn");
        Activity r102 = g();
        if (r102 != null) goto L5;
        return;
    L5:
        r102.setResult(r100, IntentUtil.modifyIntentBehaviorsSafe(r101));
        f();
    }

    private static void a(Activity r100, AvailableAdapter r101, AvailableAdapter.AvailableCallBack r102) {
        if (r100 != null) goto L4;
        HMSLog.i("ForegroundBusDelegate", "null activity, could not start resolution intent");
    L4:
        r101.startResolution(r100, r102);
    }

    @Override // com.huawei.hms.activity.IBridgeActivityDelegate
    public boolean onBridgeActivityResult(int r100, int r101, Intent r102) {
        if (r100 != 431057) goto L20;
        if (r102 != null) goto L6;
    L11:
        d();
        BusResponseCallback r103 = b(this.f276849c.getResponseCallbackKey());
        if (r103 != null) goto L14;
        a(r101, r102);
        return true;
    L14:
        BusResponseResult r104 = r103.succeedReturn(this.f276851e.get(), r101, r102);
        if (r104 != null) goto L17;
        a(r101, r102);
        return true;
    L17:
        a(r104.getCode(), r104.getIntent());
        return true;
    L6:
        if (r102.hasExtra(HMS_FOREGROUND_RESP_HEADER) == false) goto L11;
        String r105 = r102.getStringExtra(HMS_FOREGROUND_RESP_HEADER);     // Catch: Throwable -> L9
    L10:
        ResponseHeader r106 = new ResponseHeader();
        this.f276850d = r106;
        JsonUtil.jsonToEntity(r105, r106);
    L9:
        HMSLog.w("ForegroundBusDelegate", "exception occur, HMS_FOREGROUND_RESP_HEADER get failed.");
        r105 = "";
        goto L10
    L20:
        return false;
    }

    public static /* synthetic */ void a(ForegroundBusDelegate r100, int r101, String r102) {
        r100.a(r101, r102);
    }
}
