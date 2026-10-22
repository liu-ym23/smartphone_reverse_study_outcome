package com.huawei.hms.aaid;

import android.app.Activity;
import android.content.Context;
import android.os.Looper;
import android.text.TextUtils;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.entity.AAIDResult;
import com.huawei.hms.aaid.entity.DeleteTokenReq;
import com.huawei.hms.aaid.entity.TokenReq;
import com.huawei.hms.aaid.entity.TokenResult;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.opendevice.a;
import com.huawei.hms.opendevice.b;
import com.huawei.hms.opendevice.e;
import com.huawei.hms.opendevice.f;
import com.huawei.hms.opendevice.g;
import com.huawei.hms.opendevice.h;
import com.huawei.hms.opendevice.i;
import com.huawei.hms.opendevice.l;
import com.huawei.hms.support.log.HMSLog;

/* JADX INFO: loaded from: classes23.dex */
public class HmsInstanceId {
    public static final String TAG = "HmsInstanceId";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f276824a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private PushPreferences f276825b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f276826c;

    public String getToken() {
        return getToken(null, null);
    L8:
        return null;
    }

    private void a() throws ApiException {
        if (BaseUtils.getProxyInit(this.f276824a) == true) goto L5;
        return;
    L5:
        if (ProxyCenter.getProxy() == null) goto L7;
        return;
    L7:
        if (BaseUtils.isMainProc(this.f276824a) == true) goto L13;
        HMSLog.e(TAG, "Operations in child processes are not supported.");
        throw ErrorEnum.ERROR_OPER_IN_CHILD_PROCESS.toApiException();
    }

    public void deleteAAID() throws ApiException {
        b();
    L17:
        e = move-exception;
        throw e;
    L4:
        if (this.f276825b.containsKey("aaid") == true) goto L6;
        return;
    L6:
        this.f276825b.removeKey("aaid");     // Catch: Exception -> L15 ApiException -> L17
        this.f276825b.removeKey("creationTime");     // Catch: Exception -> L15 ApiException -> L17
        if (b.d(this.f276824a) == true) goto L10;
        return;
    L10:
        if (ProxyCenter.getProxy() == null) goto L13;
        HMSLog.i(TAG, "use proxy delete all token after delete AaId.");     // Catch: Exception -> L15 ApiException -> L17
        ProxyCenter.getProxy().deleteAllToken(this.f276824a);     // Catch: Exception -> L15 ApiException -> L17
        return;
    L13:
        DeleteTokenReq r100 = b.a(this.f276824a);     // Catch: Exception -> L15 ApiException -> L17
        r100.setDeleteType(1);     // Catch: Exception -> L15 ApiException -> L17
        r100.setMultiSender(false);     // Catch: Exception -> L15 ApiException -> L17
        a(r100, 1);     // Catch: Exception -> L15 ApiException -> L17
        BaseUtils.deleteAllTokenCache(this.f276824a);     // Catch: Exception -> L15 ApiException -> L17
        return;
    L16:
        throw ErrorEnum.ERROR_INTERNAL_ERROR.toApiException();
    }

    public Task<AAIDResult> getAAID() {
        return Tasks.callInBackground(new a(this.f276824a.getApplicationContext()));
    L4:
        TaskCompletionSource r100 = new TaskCompletionSource();
        r100.setException(ErrorEnum.ERROR_INTERNAL_ERROR.toApiException());
        return r100.getTask();
    }

    public long getCreationTime() {
    L8:
        return 0;
    L4:
        if (this.f276825b.containsKey("creationTime") == true) goto L6;
        getAAID();     // Catch: Exception -> L8
    L6:
        return this.f276825b.getLong("creationTime");
    }

    public String getId() {
        return b.b(this.f276824a);
    }

    private void b() throws ApiException {
        if (Looper.getMainLooper() == Looper.myLooper()) goto L6;
        return;
    L6:
        throw ErrorEnum.ERROR_MAIN_THREAD.toApiException();
    }

    private HmsInstanceId(Context r100) {
        this.f276824a = r100.getApplicationContext();
        this.f276825b = new PushPreferences(r100, "aaid");
        Api r101 = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if ((r100 instanceof Activity) == false) goto L5;
        this.f276826c = new HuaweiApi((Activity) r100, r101, null, new PushClientBuilder());
    L6:
        this.f276826c.setKitSdkVersion(61300300);
        return;
    L5:
        this.f276826c = new HuaweiApi(r100, r101, null, new PushClientBuilder());
        goto L6
    }

    private void a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
        return;
    L6:
        if (e.e(this.f276824a) == false) goto L13;
        String r101 = i.a(this.f276824a).getString("subjectId");
        if (TextUtils.isEmpty(r101) == false) goto L11;
        i.a(this.f276824a).saveString("subjectId", r100);
        return;
    L11:
        if (r101.contains(r100) == true) goto L16;
        i.a(this.f276824a).saveString("subjectId", r101 + "," + r100);
        return;
    L16:
        return;
    L13:
        i.a(this.f276824a).removeKey("subjectId");
    }

    public static HmsInstanceId getInstance(Context r100) {
        Preconditions.checkNotNull(r100);
        l.c(r100);
        return new HmsInstanceId(r100);
    }

    public void deleteToken(String r100) throws ApiException {
        b();
        a();
        if (TextUtils.isEmpty(r100) == true) goto L15;
        String r101 = b.c(this.f276824a);
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (r100.equals(r101) == false) goto L10;
        deleteToken(null, null);
        return;
    L10:
        DeleteTokenReq r102 = b.a(this.f276824a, r100);
        r102.setMultiSender(true);
        a(r102, 2);
        return;
    L13:
        throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
    L15:
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    public String getToken(String r100) throws ApiException {
        b();
        a();
        if (TextUtils.isEmpty(r100) == true) goto L15;
        String r101 = b.c(this.f276824a);
        if (TextUtils.isEmpty(r101) == true) goto L13;
        if (r100.equals(r101) == true) goto L9;
        TokenReq r102 = b.b(this.f276824a, r100);
        r102.setAaid(getId());
        r102.setMultiSender(true);
        return a(r102, 2);
    L9:
        return getToken(null, null);
    L13:
        throw ErrorEnum.ERROR_MISSING_PROJECT_ID.toApiException();
    L15:
        throw ErrorEnum.ERROR_ARGUMENTS_INVALID.toApiException();
    }

    private void a(DeleteTokenReq r100, int r101) throws ApiException {
        String r102 = r100.getSubjectId();
        if (ProxyCenter.getProxy() == null) goto L6;
        HMSLog.i(TAG, "use proxy delete token");
        ProxyCenter.getProxy().deleteToken(this.f276824a, r102, null);
        return;
    L6:
        String r103 = h.a(this.f276824a, "push.deletetoken");
        String r104 = i.a(this.f276824a).b(r102);     // Catch: Exception -> L17
        if (r100.isMultiSender() == true) goto L10;
    L15:
        r100.setToken(r104);     // Catch: Exception -> L17
        f r105 = new f("push.deletetoken", r100, r103);     // Catch: Exception -> L17
        r105.setApiLevel(r101);     // Catch: Exception -> L17
        Tasks.await(this.f276826c.doWrite(r105));     // Catch: Exception -> L17
        i.a(this.f276824a).c(r102);     // Catch: Exception -> L17
        return;
    L10:
        if (TextUtils.isEmpty(r104) == false) goto L12;
    L13:
        i.a(this.f276824a).removeKey(r102);     // Catch: Exception -> L17
        HMSLog.i(TAG, "The local subject token is null");     // Catch: Exception -> L17
        return;
    L12:
        if (r104.equals(i.a(this.f276824a).b(null)) == false) goto L15;
    L17:
        e = move-exception;
        if ((e.getCause() instanceof ApiException) == false) goto L22;
        ApiException r106 = (ApiException) e.getCause();
        h.a(this.f276824a, "push.deletetoken", r103, r106.getStatusCode());
        throw r106;
    L22:
        Context r107 = this.f276824a;
        ErrorEnum r108 = ErrorEnum.ERROR_INTERNAL_ERROR;
        h.a(r107, "push.deletetoken", r103, r108);
        throw r108.toApiException();
    }

    public void deleteToken(String r100, String r101) throws ApiException {
        b();
        a();
        DeleteTokenReq r102 = b.a(this.f276824a, r100, r101);
        r102.setMultiSender(false);
        a(r102, 1);
    }

    public String getToken(String r100, String r101) throws ApiException {
        b();
        a();
        TokenReq r102 = b.b(this.f276824a, null, r101);
        r102.setAaid(getId());
        r102.setMultiSender(false);
        i.a(this.f276824a).saveString(this.f276824a.getPackageName(), "1");
        return a(r102, 1);
    }

    private String a(TokenReq r100, int r101) throws ApiException {
        if (ProxyCenter.getProxy() == null) goto L6;
        HMSLog.i(TAG, "use proxy get token, please check HmsMessageService.onNewToken receive result.");
        ProxyCenter.getProxy().getToken(this.f276824a, r100.getSubjectId(), null);
        return null;
    L6:
        a(r100.getSubjectId());
        String r102 = h.a(this.f276824a, "push.gettoken");
        HMSLog.d(TAG, "getToken req :" + r100.toString());     // Catch: Exception -> L9
        g r103 = new g("push.gettoken", r100, this.f276824a, r102);     // Catch: Exception -> L9
        r103.setApiLevel(r101);     // Catch: Exception -> L9
        return ((TokenResult) Tasks.await(this.f276826c.doWrite(r103))).getToken();
    L9:
        e = move-exception;
        if ((e.getCause() instanceof ApiException) == false) goto L14;
        ApiException r104 = (ApiException) e.getCause();
        h.a(this.f276824a, "push.gettoken", r102, r104.getStatusCode());
        throw r104;
    L14:
        Context r105 = this.f276824a;
        ErrorEnum r106 = ErrorEnum.ERROR_INTERNAL_ERROR;
        h.a(r105, "push.gettoken", r102, r106);
        throw r106.toApiException();
    }
}
