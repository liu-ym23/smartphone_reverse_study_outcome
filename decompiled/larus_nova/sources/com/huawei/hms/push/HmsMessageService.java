package com.huawei.hms.push;

import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Message;
import android.os.Messenger;
import android.text.TextUtils;
import com.bytedance.mt.protector.impl.JSONArrayProtectorUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.threads.AsyncExec;
import com.huawei.hms.aaid.utils.BaseUtils;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.utils.PushBiUtil;
import com.huawei.hms.support.api.entity.push.PushNaming;
import com.huawei.hms.support.log.HMSLog;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class HmsMessageService extends Service {
    public static final String PROXY_TYPE = "proxy_type";
    public static final String SUBJECT_ID = "subject_id";

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private final Messenger f277556a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ String f277557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        final /* synthetic */ String f277558b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        final /* synthetic */ HmsMessageService f277559c;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_push_HmsMessageService$a_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_push_HmsMessageService$a__run$___twin___() {
            Context r100 = this.f277559c.getApplicationContext();
            String r101 = BaseUtils.getLocalToken(r100, this.f277557a);
            if (this.f277558b.equals(r101) == true) goto L6;
            HMSLog.i("HmsMessageService", "receive a new token, refresh the local token");
            BaseUtils.saveToken(r100, this.f277557a, this.f277558b);
            return;
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_push_HmsMessageService$a_com_larus_apm_impl_protector_RunnableLancet_run(a r100) {
            r100.com_huawei_hms_push_HmsMessageService$a__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(HmsMessageService r100, String r101, String r102) {
            this.f277559c = r100;
            this.f277557a = r101;
            this.f277558b = r102;
        }
    }

    public class b implements f.a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ HmsMessageService f277560a;

        private b(HmsMessageService r100) {
            this.f277560a = r100;
        }

        @Override // com.huawei.hms.push.f.a
        public void a(Message r100) {
            if (r100 != null) goto L6;
            HMSLog.e("HmsMessageService", "receive message is null");
            return;
        L6:
            HMSLog.i("HmsMessageService", "handle message start...");
            Bundle r101 = Message.obtain(r100).getData();
            if (r101 == null) goto L10;
            Intent r102 = new Intent();
            r102.putExtras(r101);
            r102.putExtra(RemoteMessageConst.INPUT_TYPE, r101.getInt(RemoteMessageConst.INPUT_TYPE, -1));
            this.f277560a.handleIntentMessage(r102);
            return;
        }

        public /* synthetic */ b(HmsMessageService r100, a r101) {
            this(r100);
        }
    }

    public void onDeletedMessages() {
    }

    public void onMessageDelivered(String r100, Exception r101) {
    }

    public void onMessageReceived(RemoteMessage r100) {
    }

    public void onMessageSent(String r100) {
    }

    public void onNewToken(String r100) {
    }

    public void onNewToken(String r100, Bundle r101) {
    }

    public void onSendError(String r100, Exception r101) {
    }

    public void onTokenError(Exception r100) {
    }

    public void onTokenError(Exception r100, Bundle r101) {
    }

    @Override // android.app.Service
    public void onDestroy() {
        HMSLog.i("HmsMessageService", "start to destroy");
        super.onDestroy();
    }

    public HmsMessageService() {
        this.f277556a = new Messenger(new f(new b(this, null)));
    }

    private Bundle a(Intent r100) {
        Bundle r101 = new Bundle();
        r101.putString(MusicAppletPage.KEY_MESSAGE_ID, r100.getStringExtra(MusicAppletPage.KEY_MESSAGE_ID));
        r101.putByteArray(RemoteMessageConst.MSGBODY, r100.getByteArrayExtra(RemoteMessageConst.MSGBODY));
        r101.putString(RemoteMessageConst.DEVICE_TOKEN, r100.getStringExtra(RemoteMessageConst.DEVICE_TOKEN));
        if (r100.getIntExtra(RemoteMessageConst.INPUT_TYPE, -1) != 1) goto L5;
        r101.putInt(RemoteMessageConst.INPUT_TYPE, 1);
    L5:
        return r101;
    }

    private void b(Intent r100) {
        HMSLog.i("HmsMessageService", "parse batch response.");
        String r101 = r100.getStringExtra("batchMsgbody");
        if (TextUtils.isEmpty(r101) == false) goto L15;
        return;
    L15:
        JSONArray r102 = new JSONArray(r101);     // Catch: JSONException -> L13
        int r103 = 0;
    L6:
        if (r103 >= r102.length()) goto L20;
        JSONObject r104 = JSONArrayProtectorUtils.getJSONObject(r102, r103);     // Catch: JSONException -> L13
        String r105 = r104.optString("transactionId");     // Catch: JSONException -> L13
        String r106 = r104.optString(RemoteMessageConst.MSGID);     // Catch: JSONException -> L13
        int r107 = r104.optInt("ret", ErrorEnum.ERROR_UNKNOWN.getInternalCode());     // Catch: JSONException -> L13
        if (ErrorEnum.SUCCESS.getInternalCode() != r107) goto L11;
        b(r105, r106);     // Catch: JSONException -> L13
    L12:
        r103 = r103 + 1;
        goto L6
    L11:
        b(r105, r106, r107);     // Catch: JSONException -> L13
        goto L12
    L20:
        return;
    L13:
        HMSLog.w("HmsMessageService", "parse batch response failed.");
    }

    public void doMsgReceived(Intent r100) {
        onMessageReceived(new RemoteMessage(a(r100)));
    }

    public void handleIntentMessage(Intent r110) {
        if (r110 != null) goto L36;
        HMSLog.e("HmsMessageService", "receive message is null");
        return;
    L36:
        String r100 = r110.getStringExtra(MusicAppletPage.KEY_MESSAGE_ID);     // Catch: Exception -> L30 RuntimeException -> L32
        String r101 = r110.getStringExtra("message_type");     // Catch: Exception -> L30 RuntimeException -> L32
        String r102 = r110.getStringExtra(CommonCode.MapKey.TRANSACTION_ID);     // Catch: Exception -> L30 RuntimeException -> L32
        if ("new_token".equals(r101) == false) goto L10;
        HMSLog.i("HmsMessageService", "onNewToken");     // Catch: Exception -> L30 RuntimeException -> L32
        a(r110, r102);     // Catch: Exception -> L30 RuntimeException -> L32
    L35:
        return;
    L10:
        if ("received_message".equals(r101) == false) goto L13;
        HMSLog.i("HmsMessageService", "onMessageReceived, message id:" + r100);     // Catch: Exception -> L30 RuntimeException -> L32
        a(PushNaming.RECEIVE_MSG_RSP, r100, ErrorEnum.SUCCESS.getInternalCode());     // Catch: Exception -> L30 RuntimeException -> L32
        doMsgReceived(r110);     // Catch: Exception -> L30 RuntimeException -> L32
        goto L35
    L13:
        if ("sent_message".equals(r101) == false) goto L17;
        b(r102, r100);     // Catch: Exception -> L30 RuntimeException -> L32
        goto L35
    L17:
        if ("send_error".equals(r101) == false) goto L20;
        b(r102, r100, r110.getIntExtra("error", ErrorEnum.ERROR_UNKNOWN.getInternalCode()));     // Catch: Exception -> L30 RuntimeException -> L32
        goto L35
    L20:
        if ("delivery".equals(r101) == false) goto L23;
        int r111 = r110.getIntExtra("error", ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode());     // Catch: Exception -> L30 RuntimeException -> L32
        HMSLog.i("HmsMessageService", "onMessageDelivery, message id:" + r100 + ", status:" + r111 + ", transactionId: " + r102);     // Catch: Exception -> L30 RuntimeException -> L32
        a(PushNaming.UPSEND_RECEIPT, r102, r111);     // Catch: Exception -> L30 RuntimeException -> L32
        onMessageDelivered(r100, new SendException(r111));     // Catch: Exception -> L30 RuntimeException -> L32
        goto L35
    L23:
        if ("server_deleted_message".equals(r101) == false) goto L26;
        HMSLog.i("HmsMessageService", "delete message, message id:" + r100);     // Catch: Exception -> L30 RuntimeException -> L32
        onDeletedMessages();     // Catch: Exception -> L30 RuntimeException -> L32
        goto L35
    L26:
        if ("batchSent".equals(r101) == false) goto L28;
        b(r110);     // Catch: Exception -> L30 RuntimeException -> L32
        goto L35
    L28:
        HMSLog.e("HmsMessageService", "Receive unknown message: " + r101);     // Catch: Exception -> L30 RuntimeException -> L32
    L32:
        e = move-exception;
        HMSLog.e("HmsMessageService", "handle intent RuntimeException: " + e.getMessage());
        return;
    L30:
        e = move-exception;
        HMSLog.e("HmsMessageService", "handle intent exception: " + e.getMessage());
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        HMSLog.i("HmsMessageService", "start to bind");
        return this.f277556a.getBinder();
    }

    private void a(Intent r100, String r101) {
        ErrorEnum r102 = ErrorEnum.SUCCESS;
        int r103 = r100.getIntExtra("error", r102.getInternalCode());
        a(PushNaming.GETTOKEN_ASYNC_RSP, r101, r103);
        String r104 = r100.getStringExtra("subjectId");
        String r105 = r100.getStringExtra("message_proxy_type");
        HMSLog.i("HmsMessageService", "doOnNewToken:transactionId = " + r101 + " , internalCode = " + r103 + ",subjectId:" + r104 + ",proxyType:" + r105);
        Bundle r106 = new Bundle();
        if (TextUtils.isEmpty(r104) == true) goto L6;
        r106.putString(SUBJECT_ID, r104);
    L6:
        if (TextUtils.isEmpty(r105) == true) goto L9;
        r106.putString(PROXY_TYPE, r105);
    L9:
        if (r103 != r102.getInternalCode()) goto L11;
        HMSLog.i("HmsMessageService", "Apply token OnNewToken, subId: " + r104);
        a(r100, r106, r104);
        return;
    L11:
        HMSLog.i("HmsMessageService", "Apply token failed, subId: " + r104);
        a(r100, r106, r104, r103);
    }

    private void b(String r100, String r101) {
        HMSLog.i("HmsMessageService", "onMessageSent, message id:" + r101 + ", transactionId: " + r100);
        a(PushNaming.UPSEND_MSG_ASYNC_RSP, r100, ErrorEnum.SUCCESS.getInternalCode());
        onMessageSent(r101);
    }

    private void a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
        return;
    L5:
        AsyncExec.submitSeqIO(new a(this, r101, r100));
    }

    private synchronized void a(Intent r100, Bundle r101, String r102) {
        monitor-enter(this);
        String r103 = r100.getStringExtra(RemoteMessageConst.DEVICE_TOKEN);     // Catch: Throwable -> L25
        a(r103, r102);     // Catch: Throwable -> L25
        Context r104 = getApplicationContext();     // Catch: Throwable -> L25
        int r105 = 0;
        boolean r106 = !TextUtils.isEmpty(BaseUtils.getCacheData(r104, r104.getPackageName(), false));     // Catch: Throwable -> L25
        if (r101.isEmpty() == false) goto L9;
        if (r106 == false) goto L9;
        HMSLog.i("HmsMessageService", "onNewToken to host app.");     // Catch: Throwable -> L25
        onNewToken(r103);     // Catch: Throwable -> L25
        BaseUtils.deleteCacheData(r104, r104.getPackageName());     // Catch: Throwable -> L25
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L22;
        String[] r107 = BaseUtils.getSubjectIds(r104);     // Catch: Throwable -> L25
        if (r107 != null) goto L13;
    L19:
        HMSLog.i("HmsMessageService", "onNewToken to host app with bundle.");     // Catch: Throwable -> L25
        r101.putString("belongId", r100.getStringExtra("belongId"));     // Catch: Throwable -> L25
        onNewToken(r103, r101);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L13:
        if (r107.length == 0) goto L19;
    L16:
        if (r105 >= r107.length) goto L18;
        Bundle r108 = new Bundle();     // Catch: Throwable -> L25
        r108.putString(SUBJECT_ID, r107[r105]);     // Catch: Throwable -> L25
        HMSLog.i("HmsMessageService", "onNewToken to sub app, subjectId:" + r107[r105]);     // Catch: Throwable -> L25
        onNewToken(r103, r108);     // Catch: Throwable -> L25
        a(r103, r107[r105]);     // Catch: Throwable -> L25
        r105 = r105 + 1;     // Catch: Throwable -> L25
        goto L16
    L18:
        BaseUtils.clearSubjectIds(r104);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L22:
        HMSLog.i("HmsMessageService", "onNewToken to sub app, subjectId:" + r102);     // Catch: Throwable -> L25
        onNewToken(r103, r101);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }

    private void b(String r100, String r101, int r102) {
        HMSLog.i("HmsMessageService", "onSendError, message id:" + r101 + " error:" + r102 + ", transactionId: " + r100);
        a(PushNaming.UPSEND_MSG_ASYNC_RSP, r100, r102);
        onSendError(r101, new SendException(r102));
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        HMSLog.i("HmsMessageService", "start to command , startId = " + r102);
        handleIntentMessage(r100);
        return 2;
    }

    private void a(String r100, String r101, int r102) {
        if (TextUtils.isEmpty(r101) == false) goto L5;
        r101 = "null";
    L5:
        PushBiUtil.reportExit(getApplicationContext(), r100, r101, r102);
    }

    private synchronized void a(Intent r100, Bundle r101, String r102, int r103) {
        monitor-enter(this);
        Context r104 = getApplicationContext();     // Catch: Throwable -> L25
        int r105 = 0;
        boolean r106 = !TextUtils.isEmpty(BaseUtils.getCacheData(r104, r104.getPackageName(), false));     // Catch: Throwable -> L25
        if (r101.isEmpty() == false) goto L9;
        if (r106 == false) goto L9;
        HMSLog.i("HmsMessageService", "onTokenError to host app.");     // Catch: Throwable -> L25
        onTokenError(new BaseException(r103));     // Catch: Throwable -> L25
        BaseUtils.deleteCacheData(r104, r104.getPackageName());     // Catch: Throwable -> L25
    L9:
        if (TextUtils.isEmpty(r102) == false) goto L22;
        String[] r107 = BaseUtils.getSubjectIds(r104);     // Catch: Throwable -> L25
        if (r107 != null) goto L13;
    L19:
        HMSLog.i("HmsMessageService", "onTokenError to host app with bundle.");     // Catch: Throwable -> L25
        onTokenError(new BaseException(r103), r101);     // Catch: Throwable -> L25
        monitor-exit(this);
        return;
    L13:
        if (r107.length == 0) goto L19;
    L16:
        if (r105 >= r107.length) goto L18;
        Bundle r108 = new Bundle();     // Catch: Throwable -> L25
        r108.putString(SUBJECT_ID, r107[r105]);     // Catch: Throwable -> L25
        HMSLog.i("HmsMessageService", "onTokenError to sub app, subjectId:" + r107[r105]);     // Catch: Throwable -> L25
        onTokenError(new BaseException(r103), r108);     // Catch: Throwable -> L25
        r105 = r105 + 1;     // Catch: Throwable -> L25
        goto L16
    L18:
        BaseUtils.clearSubjectIds(r104);     // Catch: Throwable -> L25
    L23:
        monitor-exit(this);
        return;
    L22:
        HMSLog.i("HmsMessageService", "onTokenError to sub app, subjectId:" + r102);     // Catch: Throwable -> L25
        onTokenError(new BaseException(r103), r101);     // Catch: Throwable -> L25
    L25:
        th = move-exception;
        throw th;
    }
}
