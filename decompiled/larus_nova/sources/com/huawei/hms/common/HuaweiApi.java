package com.huawei.hms.common;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hms.adapter.AvailableUtil;
import com.huawei.hms.adapter.BinderAdapter;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.Api.ApiOptions;
import com.huawei.hms.api.ConnectionResult;
import com.huawei.hms.common.internal.AbstractClientBuilder;
import com.huawei.hms.common.internal.AnyClient;
import com.huawei.hms.common.internal.BaseHmsClient;
import com.huawei.hms.common.internal.BindResolveClients;
import com.huawei.hms.common.internal.ClientSettings;
import com.huawei.hms.common.internal.HmsClient;
import com.huawei.hms.common.internal.RequestHeader;
import com.huawei.hms.common.internal.RequestManager;
import com.huawei.hms.common.internal.ResolveClientBean;
import com.huawei.hms.common.internal.ResponseHeader;
import com.huawei.hms.common.internal.TaskApiCall;
import com.huawei.hms.common.internal.TaskApiCallWrapper;
import com.huawei.hms.common.internal.TransactionIdCreater;
import com.huawei.hms.core.aidl.IAIDLInvoke;
import com.huawei.hms.support.api.client.Status;
import com.huawei.hms.support.api.client.SubAppInfo;
import com.huawei.hms.support.api.entity.auth.Scope;
import com.huawei.hms.support.api.entity.core.CommonCode;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsInnerClient;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.Checker;
import com.huawei.hms.utils.HMSBIInitializer;
import com.huawei.hms.utils.HMSPackageManager;
import com.huawei.hms.utils.Util;
import com.larus.apm.impl.protector.RunnableProtector;
import com.miui.easygo.constant.EasyGoConstant;
import java.lang.ref.WeakReference;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class HuaweiApi<TOption extends Api.ApiOptions> {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277019a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private TOption f277020b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private Context f277021c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    private AbstractClientBuilder<?, TOption> f277022d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    private String f277023e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    private String f277024f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    private SubAppInfo f277025g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    private WeakReference<Activity> f277026h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    private int f277027i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    private int f277028j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    private boolean f277029k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    private String f277030l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    private boolean f277031m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    private RequestManager f277032n;

    public static class RequestHandler<OptionsT extends Api.ApiOptions> implements BaseHmsClient.ConnectionCallbacks, BaseHmsClient.OnConnectionFailedListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final Queue<TaskApiCallbackWrapper> f277036a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AnyClient f277037b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        private ConnectionResult f277038c;
        public final Queue<TaskApiCallbackWrapper> callbackWaitQueue;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        private final HuaweiApi<OptionsT> f277039d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        private ResolveClientBean f277040e;

        private void b() {
            this.f277038c = null;
            this.f277036a.clear();
            Iterator<TaskApiCallbackWrapper> r100 = this.callbackWaitQueue.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            postMessage(r100.next());
            goto L4
        L6:
            this.callbackWaitQueue.clear();
        }

        private void c() {
            HMSLog.i("HuaweiApi", "wait queue size = " + this.callbackWaitQueue.size());
            HMSLog.i("HuaweiApi", "run queue size = " + this.f277036a.size());
            Iterator<TaskApiCallbackWrapper> r100 = this.callbackWaitQueue.iterator();
        L4:
            if (r100.hasNext() == false) goto L6;
            a(r100.next());
            goto L4
        L6:
            Iterator<TaskApiCallbackWrapper> r101 = this.f277036a.iterator();
        L8:
            if (r101.hasNext() == false) goto L10;
            a(r101.next());
            goto L8
        L10:
            this.callbackWaitQueue.clear();
            this.f277036a.clear();
            this.f277038c = null;
            this.f277037b.disconnect();
        }

        public void a() {
            this.f277037b.disconnect();
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnected() {
            HMSLog.i("HuaweiApi", "onConnected");
            BindResolveClients.getInstance().unRegister(this.f277040e);
            this.f277040e = null;
            RequestManager.getHandler().post(new AnonymousClass4(this));
        }

        public AnyClient getClient() {
            return this.f277037b;
        }

        public RequestHandler(HuaweiApi<OptionsT> r100) {
            this.callbackWaitQueue = new LinkedList();
            this.f277036a = new LinkedList();
            this.f277039d = r100;
            this.f277037b = r100.getClient(RequestManager.getHandler().getLooper(), this);
            this.f277038c = null;
        }

        private void b(ConnectionResult r100) {
            this.f277038c = r100;
            Iterator<TaskApiCallbackWrapper> r101 = this.callbackWaitQueue.iterator();
            boolean r102 = true;
        L4:
            if (r101.hasNext() == false) goto L20;
            TaskApiCallWrapper r103 = r101.next().a();
            ResponseHeader r104 = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Failed:" + a(r100) + "(" + r100.getErrorCode() + ")");
            r104.setTransactionId(r103.getTaskApiCall().getTransactionId());
            HiAnalyticsInnerClient.reportEntryExit(this.f277039d.getContext(), r104, String.valueOf(this.f277039d.getKitSdkVersion()));
            if (this.f277038c.getResolution() == null) goto L14;
            if (r102 == false) goto L14;
            r104.setParcelable(this.f277038c.getResolution());
            if (Util.isAvailableLibExist(this.f277039d.getContext()) == true) goto L11;
        L13:
            r102 = false;
            goto L14
        L11:
            if (this.f277038c.getErrorCode() != 26) goto L13;
            r104.setResolution(CommonCode.Resolution.HAS_RESOLUTION);
        L14:
            int r105 = this.f277038c.getErrorCode();
            if (r105 != 30) goto L17;
        L18:
            r104.setErrorCode(r105);
        L19:
            r103.getTaskApiCall().onResponse(this.f277037b, r104, null, r103.getTaskCompletionSource());
            goto L4
        L17:
            if (r105 != 31) goto L19;
        L20:
            this.callbackWaitQueue.clear();
            this.f277036a.clear();
            this.f277038c = null;
            this.f277037b.disconnect();
        }

        public static /* synthetic */ AnyClient c(RequestHandler r100) {
            return r100.f277037b;
        }

        public static /* synthetic */ Queue d(RequestHandler r100) {
            return r100.f277036a;
        }

        public static /* synthetic */ void e(RequestHandler r100) {
            r100.b();
        }

        public void a(TaskApiCallWrapper r100) {
            HMSLog.i("HuaweiApi", "sendRequest");
            TaskApiCallbackWrapper r101 = b(r100);
            if (HMSPackageManager.getInstance(this.f277039d.getContext()).isUpdateHmsForThirdPartyDevice() == false) goto L5;
            this.f277037b.disconnect();
        L5:
            int r102 = HMSPackageManager.getInstance(HuaweiApi.a(this.f277039d)).getHmsVersionCode();
            if (r102 >= 40000000) goto L9;
            if (r102 <= 0) goto L9;
            boolean r103 = true;
        L10:
            if (r103 == false) goto L24;
            if (this.f277037b.isConnected() == false) goto L24;
            if (HuaweiApi.b(this.f277039d) == true) goto L24;
            if (((BaseHmsClient) this.f277037b).getAdapter().getServiceAction().equals("com.huawei.hms.core.aidlservice") == false) goto L24;
            int r104 = this.f277037b.getRequestHmsVersionCode();
            if (r104 > r100.getTaskApiCall().getMinApkVersion()) goto L21;
            r104 = r100.getTaskApiCall().getMinApkVersion();
        L21:
            if (r104 <= r102) goto L24;
            this.f277037b.disconnect();
        L24:
            if (this.f277037b.isConnected() == false) goto L26;
            HMSLog.i("HuaweiApi", "isConnected:true.");
            BinderAdapter r105 = ((BaseHmsClient) this.f277037b).getAdapter();
            r105.updateDelayTask();
            ((HmsClient) this.f277037b).setService(IAIDLInvoke.Stub.asInterface(r105.getServiceBinder()));
            postMessage(r101);
            return;
        L26:
            HMSLog.i("HuaweiApi", "isConnected:false.");
            this.callbackWaitQueue.add(r101);
            ConnectionResult r106 = this.f277038c;
            if (r106 != null) goto L29;
        L32:
            RequestManager.addRequestToQueue(this);
            Object r107 = this.f277037b;
            if ((r107 instanceof BaseHmsClient) == false) goto L35;
            ((BaseHmsClient) r107).setInternalRequest(this);
        L35:
            a(r100.getTaskApiCall().getMinApkVersion(), r101);
            return;
        L29:
            if (r106.getErrorCode() == 0) goto L32;
            HMSLog.i("HuaweiApi", "onConnectionFailed, ErrorCode:" + this.f277038c.getErrorCode());
            onConnectionFailed(this.f277038c);
            return;
        L9:
            r103 = false;
            goto L10
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.OnConnectionFailedListener
        public void onConnectionFailed(final ConnectionResult r100) {
            HMSLog.i("HuaweiApi", "onConnectionFailed");
            BindResolveClients.getInstance().unRegister(this.f277040e);
            this.f277040e = null;
            RequestManager.getHandler().post(new AnonymousClass3(this, r100));
        }

        @Override // com.huawei.hms.common.internal.BaseHmsClient.ConnectionCallbacks
        public void onConnectionSuspended(int r100) {
            HMSLog.i("HuaweiApi", "onConnectionSuspended");
            BindResolveClients.getInstance().unRegister(this.f277040e);
            this.f277040e = null;
            RequestManager.getHandler().post(new AnonymousClass5(this));
        }

        public void postMessage(final TaskApiCallbackWrapper r100) {
            RequestManager.addToConnectedReqMap(r100.a().getTaskApiCall().getTransactionId(), this);
            this.f277036a.add(r100);
            String r101 = r100.a().getTaskApiCall().getUri();
            if (HuaweiApi.c(this.f277039d) != null) goto L5;
            Context r102 = this.f277039d.getContext();
        L6:
            String r103 = r102.getPackageName();
            if (HuaweiApi.c(this.f277039d) == null) goto L9;
            HuaweiApi<OptionsT> r104 = this.f277039d;
            HuaweiApi.a(r104, HuaweiApi.c(r104));
        L9:
            final RequestHeader r105 = new RequestHeader();
            r105.setSrvName(r101.split(EasyGoConstant.VERSION_SEPARATIVE_SIGN)[0]);
            r105.setApiName(r101);
            r105.setAppID(this.f277039d.getAppID() + HiAnalyticsConstant.REPORT_VAL_SEPARATOR + this.f277039d.getSubAppID());
            r105.setPkgName(r103);
            r105.setSessionId(this.f277037b.getSessionId());
            TaskApiCall r106 = r100.a().getTaskApiCall();
            r105.setTransactionId(a(r106.getTransactionId(), r101));
            r105.setParcelable(r106.getParcelable());
            r105.setKitSdkVersion(this.f277039d.getKitSdkVersion());
            r105.setApiLevel(Math.max(this.f277039d.getApiLevel(), r106.getApiLevel()));
            this.f277037b.post(r105, r106.getRequestJson(), new AnonymousClass2(this, r100, r105));
            return;
        L5:
            r102 = HuaweiApi.c(this.f277039d);
            goto L6
        }

        private String a(ConnectionResult r100) {
            if (Util.isAvailableLibExist(this.f277039d.getContext()) == false) goto L22;
            int r101 = r100.getErrorCode();
            if (r101 == (-1)) goto L30;
            if (r101 == 3) goto L21;
            if (r101 == 8) goto L38;
            if (r101 == 10) goto L37;
            if (r101 != 13) goto L13;
            return "update cancelled";
        L13:
            if (r101 == 21) goto L19;
            switch(r101) {
                case 25: goto L18;
                case 26: goto L17;
                case 27: goto L16;
                default: goto L39;
            };
        L16:
            return "there is already an update popup at the front desk, but it hasn't been clicked or it is not effective for a while";
        L17:
            return "update failed, because no activity incoming, can't pop update page";
        L18:
            return "failed to get update result";
        L39:
            return "unknown errorReason";
        L19:
            return "device is too old to be support";
        L37:
            return "application configuration error, please developer check configuration";
        L38:
            return "internal error";
        L21:
            return "HuaWei Mobile Service is disabled";
        L30:
            return "get update result, but has other error codes";
        L22:
            int r102 = r100.getErrorCode();
            if (r102 == (-1)) goto L30;
            if (r102 == 8) goto L38;
            if (r102 == 10) goto L37;
            return "unknown errorReason";
        }

        private TaskApiCallbackWrapper b(final TaskApiCallWrapper r100) {
            return new TaskApiCallbackWrapper(r100, new AnonymousClass1(this, r100));
        }

        private void a(TaskApiCallbackWrapper r100) {
            TaskApiCallWrapper r101 = r100.a();
            ResponseHeader r102 = new ResponseHeader(1, CommonCode.ErrorCode.CLIENT_API_INVALID, "Connection Suspended");
            r102.setTransactionId(r101.getTaskApiCall().getTransactionId());
            r101.getTaskApiCall().onResponse(this.f277037b, r102, null, r101.getTaskCompletionSource());
        }

        public static /* synthetic */ void b(RequestHandler r100) {
            r100.c();
        }

        public static /* synthetic */ HuaweiApi a(RequestHandler r100) {
            return r100.f277039d;
        }

        public synchronized void a(int r100, TaskApiCallbackWrapper r101) {
            monitor-enter(this);
        L27:
            th = move-exception;
            throw th;
        L4:
            if (this.f277037b.isConnected() == false) goto L9;
            HMSLog.d("HuaweiApi", "client is connected");     // Catch: Throwable -> L27
            monitor-exit(this);
            return;
        L9:
            if (this.f277037b.isConnecting() == false) goto L14;
            HMSLog.d("HuaweiApi", "client is isConnecting");     // Catch: Throwable -> L27
            monitor-exit(this);
            return;
        L14:
            if (this.f277039d.getActivity() != null) goto L16;
        L24:
            this.f277037b.connect(r100);     // Catch: Throwable -> L27
            monitor-exit(this);
            return;
        L16:
            if (this.f277040e != null) goto L19;
            this.f277040e = new ResolveClientBean(this.f277037b, r100);     // Catch: Throwable -> L27
        L19:
            if (BindResolveClients.getInstance().isClientRegistered(this.f277040e) == false) goto L23;
            HMSLog.i("HuaweiApi", "mResolveClientBean has already register, return!");     // Catch: Throwable -> L27
            monitor-exit(this);
            return;
        L23:
            BindResolveClients.getInstance().register(this.f277040e);     // Catch: Throwable -> L27
            goto L24
        }

        private String a(String r100, String r101) {
            if (TextUtils.isEmpty(r100) == true) goto L5;
            return r100;
        L5:
            return TransactionIdCreater.getId(this.f277039d.getAppID(), r101);
        }

        public static /* synthetic */ void a(RequestHandler r100, ConnectionResult r101) {
            r100.b(r101);
        }
    }

    public static class TaskApiCallbackWrapper {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final TaskApiCallWrapper f277052a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final AnyClient.CallBack f277053b;

        public TaskApiCallWrapper a() {
            return this.f277052a;
        }

        public AnyClient.CallBack b() {
            return this.f277053b;
        }

        public TaskApiCallbackWrapper(TaskApiCallWrapper r100, AnyClient.CallBack r101) {
            this.f277052a = r100;
            this.f277053b = r101;
        }
    }

    public static class a<OptionsT extends Api.ApiOptions> implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private final HuaweiApi<OptionsT> f277054a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private final TaskApiCallWrapper f277055b;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_common_HuaweiApi$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_common_HuaweiApi$a__run$___twin___() {
            RequestHandler r100 = new RequestHandler(this.f277054a);
            r100.a(this.f277055b);     // Catch: Throwable -> L5
            return;
        L5:
            th = move-exception;
            HMSLog.e("HuaweiApi", "sendRequest has exception", th);
            a(r100, th);
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_common_HuaweiApi$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_common_HuaweiApi$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(HuaweiApi<OptionsT> r100, TaskApiCallWrapper r101) {
            this.f277054a = r100;
            this.f277055b = r101;
        }

        private void a(RequestHandler r100, Throwable r110) {
            boolean r101 = true;
            TaskApiCall r102 = null;
            AnyClient r103 = r100.getClient();     // Catch: Throwable -> L17
            ResponseHeader r104 = new ResponseHeader(1, CommonCode.ErrorCode.INTERNAL_ERROR, r110.getMessage());     // Catch: Throwable -> L15
            String r111 = new JSONObject().toString();     // Catch: Throwable -> L13
            TaskCompletionSource r105 = this.f277055b.getTaskCompletionSource();     // Catch: Throwable -> L11
            r102 = this.f277055b.getTaskApiCall();     // Catch: Throwable -> L9
        L21:
            if (r103 == null) goto L27;
            if (r104 == null) goto L27;
            if (r111 == null) goto L27;
            if (r105 == null) goto L27;
            if (r102 == null) goto L27;
        L28:
            if (r101 == false) goto L30;
            r102.onResponse(r103, r104, r111, r105);
            return;
        L30:
            HMSLog.e("HuaweiApi", "<notifyCpException> isNotify is false, Can not notify CP.");
            return;
        L27:
            r101 = false;
        L9:
            Throwable th10 = th;
        L20:
            HMSLog.e("HuaweiApi", "<notifyCpException> " + th10.getMessage());
        L11:
            th10 = th;
            r105 = null;
        L13:
            th10 = th;
            r111 = null;
            r105 = null;
        L15:
            th = move-exception;
            th10 = th;
        L19:
            r111 = null;
            r104 = null;
            r105 = null;
        L17:
            th = move-exception;
            th10 = th;
            r103 = null;
            goto L19
        }
    }

    public Task<Boolean> disconnectService() {
        final TaskCompletionSource r100 = new TaskCompletionSource();
        RequestManager.getInstance();
        RequestManager.getHandler().post(new AnonymousClass1(this, this, r100));
        return r100.getTask();
    }

    public Activity getActivity() {
        WeakReference<Activity> r100 = this.f277026h;
        if (r100 != null) goto L5;
        return null;
    L5:
        return r100.get();
    }

    public ClientSettings getClientSetting() {
        ClientSettings r100 = new ClientSettings(this.f277019a.getPackageName(), this.f277019a.getClass().getName(), getScopes(), this.f277023e, null, this.f277025g);
        if (this.f277031m == true) goto L8;
        String r101 = HMSPackageManager.getInstance(this.f277019a).getHMSPackageNameForMultiService();
        if (TextUtils.isEmpty(r101) == false) goto L7;
        r101 = "com.huawei.hwid";
    L7:
        this.f277030l = r101;
        HMSLog.i("HuaweiApi", "No setInnerHms, hms pkg name is " + this.f277030l);
    L8:
        r100.setInnerHmsPkg(this.f277030l);
        r100.setUseInnerHms(this.f277031m);
        WeakReference<Activity> r102 = this.f277026h;
        if (r102 == null) goto L11;
        r100.setCpActivity(r102.get());
    L11:
        return r100;
    }

    public String getSubAppID() {
        return this.f277025g.getSubAppID();
    }

    public void setInnerHms() {
        this.f277030l = this.f277019a.getPackageName();
        this.f277031m = true;
        HMSLog.i("HuaweiApi", "<setInnerHms> init inner hms pkg info:" + this.f277030l);
    }

    public List<Scope> getScopes() {
        return Collections.emptyList();
    }

    public int getApiLevel() {
        return this.f277028j;
    }

    public String getAppID() {
        return this.f277024f;
    }

    public Context getContext() {
        return this.f277019a;
    }

    public int getKitSdkVersion() {
        return this.f277027i;
    }

    public TOption getOption() {
        return this.f277020b;
    }

    private <TResult, TClient extends AnyClient> Task<TResult> a(TaskApiCall<TClient, TResult> r100) {
        if (r100.getToken() != null) goto L5;
        TaskCompletionSource r101 = new TaskCompletionSource();
    L6:
        TaskApiCallWrapper r102 = new TaskApiCallWrapper(r100, r101);
        RequestManager.getHandler().post(new a(this, r102));
        return r101.getTask();
    L5:
        r101 = new TaskCompletionSource(r100.getToken());
        goto L6
    }

    private void b(Context r100) {
        String r101 = Util.getAppId(r100);
        this.f277023e = r101;
        this.f277024f = r101;
    }

    public static /* synthetic */ Context c(HuaweiApi r100) {
        return r100.f277021c;
    }

    public <TResult, TClient extends AnyClient> Task<TResult> doWrite(TaskApiCall<TClient, TResult> r100) {
        this.f277029k = true;
        if (r100 != null) goto L7;
        HMSLog.e("HuaweiApi", "in doWrite:taskApiCall is null");
        TaskCompletionSource r101 = new TaskCompletionSource();
        r101.setException(new ApiException(Status.FAILURE));
        return r101.getTask();
    L7:
        if (TextUtils.isEmpty(this.f277025g.getSubAppID()) == false) goto L9;
        String r102 = this.f277024f;
    L10:
        HiAnalyticsInnerClient.reportEntryClient(this.f277019a, r100.getUri(), r102, r100.getTransactionId(), String.valueOf(getKitSdkVersion()));
        if (this.f277032n != null) goto L14;
        this.f277032n = RequestManager.getInstance();
    L14:
        return a(r100);
    L9:
        r102 = this.f277025g.getSubAppID();
        goto L10
    }

    public void setApiLevel(int r100) {
        this.f277028j = r100;
    }

    public void setHostContext(Context r100) {
        this.f277021c = r100;
    }

    public void setKitSdkVersion(int r100) {
        this.f277027i = r100;
    }

    public void setSubAppId(String r100) throws ApiException {
        if (setSubAppInfo(new SubAppInfo(r100)) == false) goto L6;
        return;
    L6:
        throw new ApiException(Status.FAILURE);
    }

    public boolean setSubAppInfo(SubAppInfo r100) {
        HMSLog.i("HuaweiApi", "Enter setSubAppInfo");
        SubAppInfo r101 = this.f277025g;
        if (r101 != null) goto L5;
    L8:
        if (r100 != null) goto L11;
        HMSLog.e("HuaweiApi", "subAppInfo is null");
        return false;
    L11:
        String r102 = r100.getSubAppID();
        if (TextUtils.isEmpty(r102) == false) goto L16;
        HMSLog.e("HuaweiApi", "subAppId is empty");
        return false;
    L16:
        if (r102.equals(this.f277023e) == false) goto L20;
        HMSLog.e("HuaweiApi", "subAppId is host appid");
        return false;
    L20:
        if (this.f277029k == false) goto L23;
        HMSLog.e("HuaweiApi", "Client has sent request to Huawei Mobile Services, setting subAppId is not allowed");
        return false;
    L23:
        this.f277025g = new SubAppInfo(r100);
        return true;
    L5:
        if (TextUtils.isEmpty(r101.getSubAppID()) == true) goto L8;
        HMSLog.e("HuaweiApi", "subAppInfo is already set");
        return false;
    }

    private void a(Context r100) {
        HMSBIInitializer.getInstance(r100).initBI();
    }

    public static /* synthetic */ boolean b(HuaweiApi r100) {
        return r100.f277031m;
    }

    public static /* synthetic */ Context a(HuaweiApi r100) {
        return r100.f277019a;
    }

    private void a(HuaweiApi<?> r100, TaskCompletionSource<Boolean> r101) {
        HMSLog.i("HuaweiApi", "innerDisconnect.");
        r100.getClient(RequestManager.getHandler().getLooper(), null).disconnect();     // Catch: Exception -> L5
        r101.setResult(Boolean.TRUE);     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        HMSLog.w("HuaweiApi", "disconnect the binder failed for:" + e.getMessage());
    }

    public AnyClient getClient(Looper r100, RequestHandler r101) {
        return this.f277022d.buildClient(this.f277019a, getClientSetting(), r101, r101);
    }

    public static /* synthetic */ void a(HuaweiApi r100, Context r101) {
        r100.b(r101);
    }

    public static /* synthetic */ void a(HuaweiApi r100, HuaweiApi r101, TaskCompletionSource r102) {
        r100.a(r101, r102);
    }

    public HuaweiApi(Activity r100, Api<TOption> r110, TOption r111, AbstractClientBuilder r112) {
        this.f277028j = 1;
        this.f277029k = false;
        Checker.checkNonNull(r100, "Null activity is not permitted.");
        this.f277026h = new WeakReference(r100);
        a(r100, r110, r111, r112, 0, null);
    }

    public HuaweiApi(Context r100, Api<TOption> r110, TOption r111, AbstractClientBuilder r112) {
        this.f277028j = 1;
        this.f277029k = false;
        Checker.checkNonNull(r100, "Null context is not permitted.");
        a(r100, r110, r111, r112, 0, null);
    }

    public HuaweiApi(Activity r100, Api<TOption> r110, TOption r111, AbstractClientBuilder r112, int r113) {
        this.f277028j = 1;
        this.f277029k = false;
        Checker.checkNonNull(r100, "Null activity is not permitted.");
        this.f277026h = new WeakReference(r100);
        a(r100, r110, r111, r112, r113, null);
    }

    public HuaweiApi(Context r100, Api<TOption> r110, TOption r111, AbstractClientBuilder r112, int r113) {
        this.f277028j = 1;
        this.f277029k = false;
        Checker.checkNonNull(r100, "Null context is not permitted.");
        a(r100, r110, r111, r112, r113, null);
    }

    public HuaweiApi(Activity r100, Api<TOption> r101, TOption r102, AbstractClientBuilder r103, int r104, String r105) {
        this.f277028j = 1;
        this.f277029k = false;
        Checker.checkNonNull(r100, "Null activity is not permitted.");
        this.f277026h = new WeakReference(r100);
        a(r100, r101, r102, r103, r104, r105);
    }

    private void a(Context r100, Api<TOption> r101, TOption r102, AbstractClientBuilder r103, int r104, String r105) {
        this.f277019a = r100.getApplicationContext();
        this.f277020b = r102;
        this.f277022d = r103;
        b(r100);
        this.f277025g = new SubAppInfo("");
        this.f277027i = r104;
        if (TextUtils.isEmpty(r105) == false) goto L5;
    L8:
        a(r100);
        if (Util.isAvailableLibExist(r100) == false) goto L12;
        AvailableUtil.asyncCheckHmsUpdateInfo(r100);
        return;
    L12:
        return;
    L5:
        if (r105.equals(this.f277023e) == false) goto L7;
        HMSLog.e("HuaweiApi", "subAppId is host appid");
        goto L8
    L7:
        HMSLog.i("HuaweiApi", "subAppId is ".concat(r105));
        this.f277025g = new SubAppInfo(r105);
        goto L8
    }

    public HuaweiApi(Context r100, Api<TOption> r101, TOption r102, AbstractClientBuilder r103, int r104, String r105) {
        this.f277028j = 1;
        this.f277029k = false;
        Checker.checkNonNull(r100, "Null context is not permitted.");
        a(r100, r101, r102, r103, r104, r105);
    }
}
