package com.huawei.hms.push;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.PatternProtector;
import com.bytedance.mt.protector.impl.UriProtector;
import com.huawei.hmf.tasks.Task;
import com.huawei.hmf.tasks.TaskCompletionSource;
import com.huawei.hmf.tasks.Tasks;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.encrypt.PushEncrypter;
import com.huawei.hms.aaid.init.AutoInitHelper;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.task.PushClientBuilder;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.android.HwBuildEx;
import com.huawei.hms.api.Api;
import com.huawei.hms.api.HuaweiApiAvailability;
import com.huawei.hms.common.ApiException;
import com.huawei.hms.common.HuaweiApi;
import com.huawei.hms.common.internal.Preconditions;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.task.BaseVoidTask;
import com.huawei.hms.push.task.IntentCallable;
import com.huawei.hms.push.task.SendUpStreamTask;
import com.huawei.hms.push.task.SubscribeTask;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.EnableNotifyReq;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.api.entity.push.SubscribeReq;
import com.huawei.hms.support.api.entity.push.UpSendMsgReq;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.JsonUtil;
import com.huawei.hms.utils.NetWorkUtil;
import java.util.regex.Pattern;

/* JADX INFO: loaded from: classes23.dex */
public class HmsMessaging {
    public static final String DEFAULT_TOKEN_SCOPE = "HCM";

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    private static final Pattern f277561c = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private Context f277562a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    private HuaweiApi<Api.ApiOptions.NoOptions> f277563b;

    static {
        f277561c = PatternProtector.compile("[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    }

    public boolean isAutoInitEnabled() {
        return AutoInitHelper.isAutoInitEnabled(this.f277562a);
    }

    public Task<Void> turnOffPush() {
        if (ProxyCenter.getProxy() == null) goto L6;
        HMSLog.i("HmsMessaging", "turn off for proxy");
        return ProxyCenter.getProxy().turnOff(this.f277562a, null);
    L6:
        HMSLog.i("HmsMessaging", "invoke turnOffPush");
        return a(false);
    }

    public Task<Void> turnOnPush() {
        if (ProxyCenter.getProxy() == null) goto L6;
        HMSLog.i("HmsMessaging", "turn on for proxy");
        return ProxyCenter.getProxy().turnOn(this.f277562a, null);
    L6:
        HMSLog.i("HmsMessaging", "invoke turnOnPush");
        return a(true);
    }

    private HmsMessaging(Context r100) {
        Preconditions.checkNotNull(r100);
        this.f277562a = r100;
        Api r101 = new Api(HuaweiApiAvailability.HMS_API_NAME_PUSH);
        if ((r100 instanceof Activity) == false) goto L5;
        this.f277563b = new HuaweiApi((Activity) r100, r101, null, new PushClientBuilder());
    L6:
        this.f277563b.setKitSdkVersion(61300300);
        return;
    L5:
        this.f277563b = new HuaweiApi(r100, r101, null, new PushClientBuilder());
        goto L6
    }

    private Task<Void> a(boolean r110) {
        String r100 = PushBiUtil.reportEntry(this.f277562a, PushNaming.SET_NOTIFY_FLAG);
        if (d.d(this.f277562a) == true) goto L5;
    L25:
        HMSLog.i("HmsMessaging", "turn on/off with AIDL");
        EnableNotifyReq r101 = new EnableNotifyReq();
        r101.setPackageName(this.f277562a.getPackageName());
        r101.setEnable(r110);
        return this.f277563b.doWrite(new BaseVoidTask(PushNaming.SET_NOTIFY_FLAG, JsonUtil.createJsonString(r101), r100));
    L5:
        if (d.b() == true) goto L25;
        if (HwBuildEx.VERSION.EMUI_SDK_INT >= 12) goto L12;
        HMSLog.e("HmsMessaging", "operation not available on Huawei device with EMUI lower than 5.1");
        TaskCompletionSource r111 = new TaskCompletionSource();
        ErrorEnum r102 = ErrorEnum.ERROR_OPERATION_NOT_SUPPORTED;
        r111.setException(r102.toApiException());
        PushBiUtil.reportExit(this.f277562a, PushNaming.SET_NOTIFY_FLAG, r100, r102);
        return r111.getTask();
    L12:
        if (d.b(this.f277562a) >= 90101310) goto L16;
        HMSLog.i("HmsMessaging", "turn on/off with broadcast v1");
        Intent r112 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG").putExtra("enalbeFlag", PushEncrypter.encrypterOld(this.f277562a, this.f277562a.getPackageName() + "#" + r110));
        r112.setPackage("android");
        return Tasks.callInBackground(new IntentCallable(this.f277562a, r112, r100));
    L16:
        if (d.b(this.f277562a) >= 110118300) goto L19;
        HMSLog.i("HmsMessaging", "turn on/off with broadcast v2");
        new PushPreferences(this.f277562a, "push_notify_flag").saveBoolean("notify_msg_enable", !r110);
        Uri r113 = UriProtector.parse("content://" + this.f277562a.getPackageName() + ".huawei.push.provider/push_notify_flag.xml");
        Intent r103 = new Intent("com.huawei.android.push.intent.SDK_COMMAND");
        r103.putExtra("type", "enalbeFlag");
        r103.putExtra("pkgName", this.f277562a.getPackageName());
        r103.putExtra("url", r113);
        r103.setPackage("android");
        return Tasks.callInBackground(new IntentCallable(this.f277562a, r103, r100));
    L19:
        HMSLog.i("HmsMessaging", "turn on/off with broadcast v3");
        if (TextUtils.isEmpty(BaseUtils.getLocalToken(this.f277562a, null)) == false) goto L23;
        TaskCompletionSource r114 = new TaskCompletionSource();
        r114.setException(ErrorEnum.ERROR_NO_TOKEN.toApiException());
        return r114.getTask();
    L23:
        new PushPreferences(this.f277562a, "push_notify_flag").saveBoolean("notify_msg_enable", !r110);
        Intent r104 = new Intent("com.huawei.intent.action.SELF_SHOW_FLAG");
        r104.putExtra("enalbeFlag", r110);
        r104.putExtra(RemoteMessageConst.DEVICE_TOKEN, BaseUtils.getLocalToken(this.f277562a, null));
        r104.putExtra("pkgName", this.f277562a.getPackageName());
        r104.putExtra("uid", this.f277562a.getApplicationInfo().uid);
        r104.setPackage("android");
        return Tasks.callInBackground(new IntentCallable(this.f277562a, r104, r100));
    }

    public static synchronized HmsMessaging getInstance(Context r100) {
        monitor-enter(HmsMessaging.class);
        HmsMessaging r101 = new HmsMessaging(r100);     // Catch: Throwable -> L7
        monitor-exit(HmsMessaging.class);
        return r101;
    L7:
        th = move-exception;
        throw th;
    }

    public void send(RemoteMessage r100) {
        if (ProxyCenter.getProxy() != null) goto L6;
        HMSLog.i("HmsMessaging", "send upstream message");
        a(r100);
        return;
    L6:
        HMSLog.e("HmsMessaging", "Operation(send) unsupported");
        throw new UnsupportedOperationException("Operation(send) unsupported");
    }

    public void setAutoInitEnabled(boolean r100) {
        AutoInitHelper.setAutoInitEnabled(this.f277562a, r100);
    }

    public Task<Void> subscribe(String r100) {
        HMSLog.i("HmsMessaging", "invoke subscribe");
        return a(r100, "Sub");
    }

    public Task<Void> unsubscribe(String r100) {
        HMSLog.i("HmsMessaging", "invoke unsubscribe");
        return a(r100, "UnSub");
    }

    private void a(RemoteMessage r100) {
        String r101 = PushBiUtil.reportEntry(this.f277562a, PushNaming.UPSEND_MSG);
        ErrorEnum r102 = v.a(this.f277562a);
        if (r102 == ErrorEnum.SUCCESS) goto L5;
        HMSLog.e("HmsMessaging", "Message sent failed:" + r102.getExternalCode() + ':' + r102.getMessage());
        PushBiUtil.reportExit(this.f277562a, PushNaming.UPSEND_MSG, r101, r102);
        throw new UnsupportedOperationException(r102.getMessage());
    L5:
        if (TextUtils.isEmpty(r100.getTo()) == false) goto L7;
        HMSLog.e("HmsMessaging", "Mandatory parameter 'to' missing");
        PushBiUtil.reportExit(this.f277562a, PushNaming.UPSEND_MSG, r101, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        throw new IllegalArgumentException("Mandatory parameter 'to' missing");
    L7:
        if (TextUtils.isEmpty(r100.getMessageId()) == false) goto L9;
        HMSLog.e("HmsMessaging", "Mandatory parameter 'message_id' missing");
        PushBiUtil.reportExit(this.f277562a, PushNaming.UPSEND_MSG, r101, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        throw new IllegalArgumentException("Mandatory parameter 'message_id' missing");
    L9:
        if (TextUtils.isEmpty(r100.getData()) == true) goto L15;
        UpSendMsgReq r103 = new UpSendMsgReq();
        r103.setPackageName(this.f277562a.getPackageName());
        r103.setMessageId(r100.getMessageId());
        r103.setTo(r100.getTo());
        r103.setData(r100.getData());
        r103.setMessageType(r100.getMessageType());
        r103.setTtl(r100.getTtl());
        r103.setCollapseKey(r100.getCollapseKey());
        r103.setSendMode(r100.getSendMode());
        r103.setReceiptMode(r100.getReceiptMode());
        if (d.b() == false) goto L13;
        this.f277563b.doWrite(new BaseVoidTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(r103), r101));
        return;
    L13:
        a(r103, r101);
        return;
    L15:
        HMSLog.e("HmsMessaging", "Mandatory parameter 'data' missing");
        PushBiUtil.reportExit(this.f277562a, PushNaming.UPSEND_MSG, r101, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        throw new IllegalArgumentException("Mandatory parameter 'data' missing");
    }

    private Task<Void> a(String r100, String r101) {
        String r102 = PushBiUtil.reportEntry(this.f277562a, PushNaming.SUBSCRIBE);
        if (r100 != null) goto L5;
    L32:
        PushBiUtil.reportExit(this.f277562a, PushNaming.SUBSCRIBE, r102, ErrorEnum.ERROR_ARGUMENTS_INVALID);
        HMSLog.e("HmsMessaging", "Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
        throw new IllegalArgumentException("Invalid topic: topic should match the format:[\\u4e00-\\u9fa5\\w-_.~%]{1,900}");
    L5:
        if (f277561c.matcher(r100).matches() == false) goto L32;
        if (ProxyCenter.getProxy() == null) goto L34;
        HMSLog.i("HmsMessaging", "use proxy subscribe.");
        if (TextUtils.equals(r101, "Sub") == false) goto L12;
        return ProxyCenter.getProxy().subscribe(this.f277562a, r100, r102);
    L12:
        return ProxyCenter.getProxy().unsubscribe(this.f277562a, r100, r102);
    L34:
        ErrorEnum r103 = v.a(this.f277562a);     // Catch: Exception -> L27 ApiException -> L29
        if (r103 != ErrorEnum.SUCCESS) goto L26;
        if (NetWorkUtil.getNetworkType(this.f277562a) == 0) goto L23;
        SubscribeReq r104 = new SubscribeReq(this.f277562a, r101, r100);     // Catch: Exception -> L27 ApiException -> L29
        r104.setToken(BaseUtils.getLocalToken(this.f277562a, null));     // Catch: Exception -> L27 ApiException -> L29
        if (d.b() == false) goto L22;
        return this.f277563b.doWrite(new BaseVoidTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(r104), r102));
    L22:
        return this.f277563b.doWrite(new SubscribeTask(PushNaming.SUBSCRIBE, JsonUtil.createJsonString(r104), r102));
    L23:
        HMSLog.e("HmsMessaging", "no network");     // Catch: Exception -> L27 ApiException -> L29
        throw ErrorEnum.ERROR_NO_NETWORK.toApiException();     // Catch: Exception -> L27 ApiException -> L29
    L26:
        throw r103.toApiException();     // Catch: Exception -> L27 ApiException -> L29
    L29:
        e = move-exception;
        TaskCompletionSource r105 = new TaskCompletionSource();
        r105.setException(e);
        PushBiUtil.reportExit(this.f277562a, PushNaming.SUBSCRIBE, r102, e.getStatusCode());
        return r105.getTask();
    L27:
        TaskCompletionSource r106 = new TaskCompletionSource();
        ErrorEnum r107 = ErrorEnum.ERROR_INTERNAL_ERROR;
        r106.setException(r107.toApiException());
        PushBiUtil.reportExit(this.f277562a, PushNaming.SUBSCRIBE, r102, r107);
        return r106.getTask();
    }

    private void a(UpSendMsgReq r100, String r110) {
        r100.setToken(BaseUtils.getLocalToken(this.f277562a, null));
        this.f277563b.doWrite(new SendUpStreamTask(PushNaming.UPSEND_MSG, JsonUtil.createJsonString(r100), r110, r100.getPackageName(), r100.getMessageId()));     // Catch: Exception -> L5
        return;
    L5:
        e = move-exception;
        if ((e.getCause() instanceof ApiException) == false) goto L9;
        ApiException r101 = (ApiException) e.getCause();
        PushBiUtil.reportExit(this.f277562a, PushNaming.UPSEND_MSG, r110, r101.getStatusCode());
        return;
    L9:
        PushBiUtil.reportExit(this.f277562a, PushNaming.UPSEND_MSG, r110, ErrorEnum.ERROR_INTERNAL_ERROR);
    }
}
