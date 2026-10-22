package com.huawei.hms.common.internal;

import android.app.Activity;
import android.content.Context;
import android.os.Handler;
import android.os.IBinder;
import android.os.Message;
import com.huawei.hms.adapter.AvailableAdapter;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.adapter.InnerBinderAdapter;
import com.huawei.hms.adapter.OuterBinderAdapter;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.api.IPCTransport;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.AidlApiClient;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.PackageManagerHelper;
import com.huawei.hms.utils.Util;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: loaded from: classes23.dex */
public abstract class BaseHmsClient implements AidlApiClient {
    protected static final int TIMEOUT_DISCONNECTED = 6;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private static final Object f277066i = null;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private static final AtomicInteger f277067j = null;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private static final AtomicInteger f277068k = null;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private static BinderAdapter f277069l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private static BinderAdapter f277070m;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Context f277071a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private String f277072b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private final ClientSettings f277073c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private volatile IAIDLInvoke f277074d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private final ConnectionCallbacks f277075e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private final OnConnectionFailedListener f277076f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private Handler f277077g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private HuaweiApi.RequestHandler f277078h;
    protected String sessionId;

    public interface ConnectionCallbacks {
        public static final int CAUSE_API_CLIENT_EXPIRED = 3;
        public static final int CAUSE_NETWORK_LOST = 2;
        public static final int CAUSE_SERVICE_DISCONNECTED = 1;

        void onConnected();

        void onConnectionSuspended(int r100);
    }

    public static final class ConnectionResultWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private HuaweiApi.RequestHandler f277083a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private ConnectionResult f277084b;

        public ConnectionResult getConnectionResult() {
            return this.f277084b;
        }

        public HuaweiApi.RequestHandler getRequest() {
            return this.f277083a;
        }

        public ConnectionResultWrapper(HuaweiApi.RequestHandler r100, ConnectionResult r101) {
            this.f277083a = r100;
            this.f277084b = r101;
        }
    }

    public interface OnConnectionFailedListener {
        void onConnectionFailed(ConnectionResult r100);
    }

    public final void connectionConnected() {
        b(3);
        RequestManager.getHandler().sendEmptyMessage(10011);
        ConnectionCallbacks r100 = this.f277075e;
        if (r100 != null) goto L5;
        return;
    L5:
        if ((r100 instanceof HuaweiApi.RequestHandler) == true) goto L9;
        r100.onConnected();
        return;
    }

    public int getMinApkVersion() {
        return 30000000;
    }

    static {
        f277066i = new Object();
        f277067j = new AtomicInteger(1);
        f277068k = new AtomicInteger(1);
    }

    private void b() {
        Object r100 = f277066i;
        monitor-enter(r100);
        Handler r101 = this.f277077g;     // Catch: Throwable -> L9
        if (r101 == null) goto L7;
        r101.removeMessages(2);     // Catch: Throwable -> L9
        this.f277077g = null;     // Catch: Throwable -> L9
    L7:
        monitor-exit(r100);     // Catch: Throwable -> L9
        return;
    L9:
        th = move-exception;
        throw th;
    }

    private boolean c() {
        if (HMSPackageManager.getInstance(this.f277071a).getHMSPackageStatesForMultiService() != PackageManagerHelper.PackageStates.ENABLED) goto L5;
        return true;
    L5:
        return false;
    }

    private BinderAdapter.BinderCallBack d() {
        return new AnonymousClass1(this);
    }

    private void e() {
        HMSLog.w("BaseHmsClient", "Failed to get service as interface, trying to unbind.");
        if (this.f277073c.isUseInnerHms() == false) goto L9;
        BinderAdapter r100 = f277070m;
        if (r100 != null) goto L8;
        HMSLog.w("BaseHmsClient", "mInnerBinderAdapter is null.");
        return;
    L8:
        r100.unBind();
    L14:
        b(1);
        a(10);
        return;
    L9:
        BinderAdapter r101 = f277069l;
        if (r101 != null) goto L13;
        HMSLog.w("BaseHmsClient", "mOuterBinderAdapter is null.");
        return;
    L13:
        r101.unBind();
        goto L14
    }

    private void f() {
        if (this.f277073c.isUseInnerHms() == false) goto L8;
        BinderAdapter r100 = f277070m;
        if (r100 == null) goto L12;
        r100.unBind();
        return;
    L12:
        return;
    L8:
        BinderAdapter r101 = f277069l;
        if (r101 == null) goto L13;
        r101.unBind();
        return;
    }

    public void a() {
        String r100 = this.f277073c.getInnerHmsPkg();
        String r101 = getServiceAction();
        HMSLog.i("BaseHmsClient", "enter bindCoreService, packageName is " + r100 + ", serviceAction is " + r101);
        a(r100, r101);
    }

    public void disconnect() {
        if (this.f277073c.isUseInnerHms() == false) goto L5;
        AtomicInteger r100 = f277068k;
    L6:
        int r101 = r100.get();
        HMSLog.i("BaseHmsClient", "Enter disconnect, Connection Status: " + r101);
        if (r101 != 3) goto L9;
        f();
        b(1);
        return;
    L9:
        if (r101 != 5) goto L15;
        b();
        b(1);
        return;
    L15:
        return;
    L5:
        r100 = f277067j;
        goto L6
    }

    public BinderAdapter getAdapter() {
        HMSLog.i("BaseHmsClient", "getAdapter:isInner:" + this.f277073c.isUseInnerHms() + ", mInnerBinderAdapter:" + f277070m + ", mOuterBinderAdapter:" + f277069l);
        if (this.f277073c.isUseInnerHms() == false) goto L6;
        return f277070m;
    L6:
        return f277069l;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public List<String> getApiNameList() {
        return this.f277073c.getApiName();
    }

    public int getConnectionStatus() {
        if (this.f277073c.isUseInnerHms() == false) goto L5;
        AtomicInteger r100 = f277068k;
    L7:
        return r100.get();
    L5:
        r100 = f277067j;
        goto L7
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getCpID() {
        return this.f277073c.getCpID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getPackageName() {
        return this.f277073c.getClientPackageName();
    }

    public String getServiceAction() {
        HMSPackageManager r100 = HMSPackageManager.getInstance(this.f277071a);
        if (this.f277073c.isUseInnerHms() == false) goto L6;
        return r100.getInnerServiceAction();
    L6:
        return r100.getServiceAction();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public SubAppInfo getSubAppInfo() {
        return this.f277073c.getSubAppID();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getTransportName() {
        return IPCTransport.class.getName();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public boolean isConnected() {
        if (this.f277073c.isUseInnerHms() == false) goto L8;
        if (f277068k.get() == 3) goto L9;
    L10:
        return false;
    L9:
        return true;
    L8:
        if (f277067j.get() != 3) goto L10;
        goto L9
    }

    public boolean isConnecting() {
        if (this.f277073c.isUseInnerHms() == false) goto L5;
        AtomicInteger r100 = f277068k;
    L7:
        if (r100.get() != 5) goto L9;
        return true;
    L9:
        return false;
    L5:
        r100 = f277067j;
        goto L7
    }

    public final void checkConnected() {
        if (isConnected() == false) goto L6;
        return;
    L6:
        throw new IllegalStateException("Not connected. Call connect() and wait for onConnected() to be called.");
    }

    public int getRequestHmsVersionCode() {
        return getMinApkVersion();
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getAppID() {
        return this.f277072b;
    }

    public ClientSettings getClientSettings() {
        return this.f277073c;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public Context getContext() {
        return this.f277071a;
    }

    @Override // com.huawei.hms.support.api.client.AidlApiClient
    public IAIDLInvoke getService() {
        return this.f277074d;
    }

    @Override // com.huawei.hms.support.api.client.ApiClient
    public String getSessionId() {
        return this.sessionId;
    }

    public void onConnecting() {
        connectionConnected();
    }

    private void a(int r100) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + r100);
        Message r101 = new Message();
        r101.what = 10012;
        r101.obj = new ConnectionResultWrapper(this.f277078h, new ConnectionResult(r100));
        RequestManager.getHandler().sendMessage(r101);
        OnConnectionFailedListener r102 = this.f277076f;
        if (r102 != null) goto L5;
        return;
    L5:
        if ((r102 instanceof HuaweiApi.RequestHandler) == true) goto L9;
        r102.onConnectionFailed(new ConnectionResult(r100));
        return;
    }

    public static /* synthetic */ boolean c(BaseHmsClient r100) {
        return r100.c();
    }

    public void b(int r100) {
        if (this.f277073c.isUseInnerHms() == false) goto L5;
        f277068k.set(r100);
        return;
    L5:
        f277067j.set(r100);
    }

    public void connect(int r100) {
        a(r100, false);
    }

    public void connectedInternal(IBinder r100) {
        this.f277074d = IAIDLInvoke.Stub.asInterface(r100);
        if (this.f277074d != null) goto L6;
        HMSLog.e("BaseHmsClient", "mService is null, try to unBind.");
        e();
        return;
    L6:
        onConnecting();
    }

    public final void setInternalRequest(HuaweiApi.RequestHandler r100) {
        this.f277078h = r100;
    }

    public void setService(IAIDLInvoke r100) {
        this.f277074d = r100;
    }

    private void a(ConnectionResult r100) {
        HMSLog.i("BaseHmsClient", "notifyFailed result: " + r100.getErrorCode());
        Message r101 = new Message();
        r101.what = 10012;
        HuaweiApi.RequestHandler r102 = this.f277078h;
        this.f277078h = null;
        r101.obj = new ConnectionResultWrapper(r102, r100);
        RequestManager.getHandler().sendMessage(r101);
        OnConnectionFailedListener r103 = this.f277076f;
        if (r103 != null) goto L5;
        return;
    L5:
        if ((r103 instanceof HuaweiApi.RequestHandler) == true) goto L9;
        r103.onConnectionFailed(r100);
        return;
    }

    public static /* synthetic */ ConnectionCallbacks b(BaseHmsClient r100) {
        return r100.f277075e;
    }

    public static /* synthetic */ Context a(BaseHmsClient r100) {
        return r100.f277071a;
    }

    private void a(int r100, boolean r101) {
        HMSLog.i("BaseHmsClient", "====== HMSSDK version: 61300301 ======");
        if (this.f277073c.isUseInnerHms() == false) goto L5;
        AtomicInteger r102 = f277068k;
    L6:
        int r103 = r102.get();
        HMSLog.i("BaseHmsClient", "Enter connect, Connection Status: " + r103);
        if (r101 == true) goto L14;
        if (r103 != 3) goto L11;
        return;
    L11:
        if (r103 != 5) goto L14;
        return;
    L14:
        if (getMinApkVersion() <= r100) goto L16;
        r100 = getMinApkVersion();
    L16:
        HMSLog.i("BaseHmsClient", "connect minVersion:" + r100 + " packageName:" + this.f277073c.getInnerHmsPkg());
        if (this.f277071a.getPackageName().equals(this.f277073c.getInnerHmsPkg()) == false) goto L21;
        HMSLog.i("BaseHmsClient", "service packageName is same, bind core service return");
        a();
        return;
    L21:
        if (Util.isAvailableLibExist(this.f277071a) == false) goto L32;
        AvailableAdapter r104 = new AvailableAdapter(r100);
        int r105 = r104.isHuaweiMobileServicesAvailable(this.f277071a);
        HMSLog.i("BaseHmsClient", "check available result: " + r105);
        if (r105 != 0) goto L26;
        a();
        return;
    L26:
        if (r104.isUserResolvableError(r105) == false) goto L29;
        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start resolution now.");
        b(r104, r105);
        return;
    L29:
        if (r104.isUserNoticeError(r105) == false) goto L31;
        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail, start notice now.");
        a(r104, r105);
        return;
    L31:
        HMSLog.i("BaseHmsClient", "bindCoreService3.0 fail: " + r105 + " is not resolvable.");
        a(r105);
        return;
    L32:
        int r106 = HuaweiApiAvailability.getInstance().isHuaweiMobileServicesAvailable(this.f277071a, r100);
        HMSLog.i("BaseHmsClient", "HuaweiApiAvailability check available result: " + r106);
        if (r106 != 0) goto L35;
        a();
        return;
    L35:
        a(r106);
        return;
    L5:
        r102 = f277067j;
        goto L6
    }

    private void b(AvailableAdapter r100, int r101) {
        HMSLog.i("BaseHmsClient", "enter HmsCore resolution");
        if (getClientSettings().isHasActivity() == true) goto L6;
        a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f277071a, r101, 0)));
        return;
    L6:
        Activity r102 = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (r102 == null) goto L9;
        r100.startResolution(r102, new AnonymousClass3(this));
        return;
    L9:
        a(26);
    }

    public void connect(int r100, boolean r101) {
        a(r100, r101);
    }

    private void a(String r100, String r101) {
        if (this.f277073c.isUseInnerHms() == false) goto L10;
        f277070m = InnerBinderAdapter.getInstance(this.f277071a, r101, r100);
        if (isConnected() == false) goto L8;
        HMSLog.i("BaseHmsClient", "The binder is already connected.");
        getAdapter().updateDelayTask();
        connectedInternal(getAdapter().getServiceBinder());
        return;
    L8:
        b(5);
        f277070m.binder(d());
        return;
    L10:
        f277069l = OuterBinderAdapter.getInstance(this.f277071a, r101, r100);
        if (isConnected() == false) goto L14;
        HMSLog.i("BaseHmsClient", "The binder is already connected.");
        getAdapter().updateDelayTask();
        connectedInternal(getAdapter().getServiceBinder());
        return;
    L14:
        b(5);
        f277069l.binder(d());
    }

    private void a(AvailableAdapter r100, int r101) {
        HMSLog.i("BaseHmsClient", "enter notice");
        if (getClientSettings().isHasActivity() == false) goto L5;
        Activity r102 = Util.getActiveActivity(getClientSettings().getCpActivity(), getContext());
        if (r102 == null) goto L12;
        r100.startNotice(r102, new AnonymousClass2(this));
        return;
    L12:
        a(26);
        return;
    L5:
        if (r101 != 29) goto L7;
        r101 = 9;
    L7:
        a(new ConnectionResult(26, HuaweiApiAvailability.getInstance().getErrPendingIntent(this.f277071a, r101, 0)));
    }

    public static /* synthetic */ void a(BaseHmsClient r100, int r101) {
        r100.a(r101);
    }

    public static /* synthetic */ void a(BaseHmsClient r100, ConnectionResult r101) {
        r100.a(r101);
    }

    public static /* synthetic */ IAIDLInvoke a(BaseHmsClient r100, IAIDLInvoke r101) {
        r100.f277074d = r101;
        return r101;
    }

    public BaseHmsClient(Context r100, ClientSettings r101, OnConnectionFailedListener r102, ConnectionCallbacks r103) {
        this.f277077g = null;
        this.f277071a = r100;
        this.f277073c = r101;
        if (r101 == null) goto L5;
        this.f277072b = r101.getAppID();
    L5:
        this.f277076f = r102;
        this.f277075e = r103;
    }
}
