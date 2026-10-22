package com.huawei.hms.support.api.push;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.adapter.internal.CommonCode;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.d;
import com.huawei.hms.push.q;
import com.huawei.hms.push.r;
import com.huawei.hms.push.utils.JsonUtil;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.ss.texturerender.TextureRenderKeys;
import java.util.concurrent.RejectedExecutionException;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public final class PushReceiver extends BroadcastReceiver {

    public static /* synthetic */ class a {
    }

    public static class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f277744a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f277745b;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_api_push_PushReceiver$b_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_api_push_PushReceiver$b__run$___twin___() {
            Intent r100 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
            r100.setPackage(this.f277745b.getPackage());
            JSONObject r101 = PushReceiver.a(this.f277745b);     // Catch: RuntimeException -> L21
            String r102 = JsonUtil.getString(r101, TextureRenderKeys.KEY_MODULE_NAME, "");     // Catch: RuntimeException -> L21
            int r103 = JsonUtil.getInt(r101, "msgType", 0);     // Catch: RuntimeException -> L21
            int r104 = JsonUtil.getInt(r101, "status", 0);     // Catch: RuntimeException -> L21
            if (ErrorEnum.SUCCESS.getInternalCode() == r104) goto L6;
            r104 = ErrorEnum.ERROR_APP_SERVER_NOT_ONLINE.getInternalCode();     // Catch: RuntimeException -> L21
        L6:
            Bundle r105 = new Bundle();     // Catch: RuntimeException -> L21
            if ("Push".equals(r102) == false) goto L12;
            if (r103 != 1) goto L12;
            r105.putString("message_type", "delivery");     // Catch: RuntimeException -> L21
            r105.putString(MusicAppletPage.KEY_MESSAGE_ID, JsonUtil.getString(r101, RemoteMessageConst.MSGID, ""));     // Catch: RuntimeException -> L21
            r105.putInt("error", r104);     // Catch: RuntimeException -> L21
            r105.putString(CommonCode.MapKey.TRANSACTION_ID, JsonUtil.getString(r101, "transactionId", ""));     // Catch: RuntimeException -> L21
        L17:
            if (new r().a(this.f277744a, r105, r100) == false) goto L19;
            HMSLog.i("PushReceiver", "receive " + this.f277745b.getAction() + " and start service success");     // Catch: RuntimeException -> L21
            return;
        L19:
            HMSLog.e("PushReceiver", "receive " + this.f277745b.getAction() + " and start service failed");     // Catch: RuntimeException -> L21
            return;
        L12:
            if (this.f277745b.getExtras() == null) goto L14;
            r105.putAll(this.f277745b.getExtras());     // Catch: RuntimeException -> L21
        L14:
            r105.putString("message_type", "received_message");     // Catch: RuntimeException -> L21
            r105.putString(MusicAppletPage.KEY_MESSAGE_ID, this.f277745b.getStringExtra("msgIdStr"));     // Catch: RuntimeException -> L21
            r105.putByteArray(RemoteMessageConst.MSGBODY, this.f277745b.getByteArrayExtra("msg_data"));     // Catch: RuntimeException -> L21
            r105.putString(RemoteMessageConst.DEVICE_TOKEN, com.huawei.hms.push.a.a(this.f277745b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN)));     // Catch: RuntimeException -> L21
            r105.putInt(RemoteMessageConst.INPUT_TYPE, 1);     // Catch: RuntimeException -> L21
            r105.putString("message_proxy_type", this.f277745b.getStringExtra("message_proxy_type"));     // Catch: RuntimeException -> L21
        L21:
            HMSLog.e("PushReceiver", "handle push message occur exception.");
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_api_push_PushReceiver$b_com_larus_apm_impl_protector_RunnableLancet_run(b r100) {
            r100.com_huawei_hms_support_api_push_PushReceiver$b__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private b(Context r100, Intent r101) {
            this.f277744a = r100;
            this.f277745b = r101;
        }

        public /* synthetic */ b(Context r100, Intent r101, a r102) {
            this(r100, r101);
        }
    }

    public static class c implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f277746a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        private Intent f277747b;

        @Override // java.lang.Runnable
        public void run() {
            com_huawei_hms_support_api_push_PushReceiver$c_com_larus_apm_impl_protector_RunnableLancet_run(this);
        }

        public void com_huawei_hms_support_api_push_PushReceiver$c__run$___twin___() {
            byte[] r100 = this.f277747b.getByteArrayExtra(RemoteMessageConst.DEVICE_TOKEN);     // Catch: Exception -> L13 RejectedExecutionException -> L14
            if (r100 != null) goto L6;
        L11:
            HMSLog.i("PushReceiver", "get a deviceToken, but it is null or empty");     // Catch: Exception -> L13 RejectedExecutionException -> L14
            return;
        L6:
            if (r100.length == 0) goto L11;
            HMSLog.i("PushReceiver", "receive a push token: " + this.f277746a.getPackageName());     // Catch: Exception -> L13 RejectedExecutionException -> L14
            Intent r101 = new Intent("com.huawei.push.action.MESSAGING_EVENT");     // Catch: Exception -> L13 RejectedExecutionException -> L14
            r101.setPackage(this.f277747b.getPackage());     // Catch: Exception -> L13 RejectedExecutionException -> L14
            Bundle r102 = new Bundle();     // Catch: Exception -> L13 RejectedExecutionException -> L14
            r102.putString("message_type", "new_token");     // Catch: Exception -> L13 RejectedExecutionException -> L14
            r102.putString(RemoteMessageConst.DEVICE_TOKEN, com.huawei.hms.push.a.a(r100));     // Catch: Exception -> L13 RejectedExecutionException -> L14
            r102.putString(CommonCode.MapKey.TRANSACTION_ID, this.f277747b.getStringExtra(CommonCode.MapKey.TRANSACTION_ID));     // Catch: Exception -> L13 RejectedExecutionException -> L14
            r102.putString("subjectId", this.f277747b.getStringExtra("subjectId"));     // Catch: Exception -> L13 RejectedExecutionException -> L14
            r102.putInt("error", this.f277747b.getIntExtra("error", ErrorEnum.SUCCESS.getInternalCode()));     // Catch: Exception -> L13 RejectedExecutionException -> L14
            r102.putString("belongId", this.f277747b.getStringExtra("belongId"));     // Catch: Exception -> L13 RejectedExecutionException -> L14
            if (new r().a(this.f277746a, r102, r101) == true) goto L17;
            HMSLog.e("PushReceiver", "receive " + this.f277747b.getAction() + " and start service failed");     // Catch: Exception -> L13 RejectedExecutionException -> L14
            return;
        L17:
            return;
        L14:
            HMSLog.e("PushReceiver", "execute task error");
            return;
        L13:
            HMSLog.e("PushReceiver", "handle push token error");
        }

        @Skip({"com.ss.android.ugc.bytex.pthread+"})
        public static void com_huawei_hms_support_api_push_PushReceiver$c_com_larus_apm_impl_protector_RunnableLancet_run(c r100) {
            r100.com_huawei_hms_support_api_push_PushReceiver$c__run$___twin___();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        private c(Context r100, Intent r101) {
            this.f277746a = r100;
            this.f277747b = r101;
        }

        public /* synthetic */ c(Context r100, Intent r101, a r102) {
            this(r100, r101);
        }
    }

    public PushReceiver() {
    }

    private static JSONObject a(byte[] r100) {
        return new JSONObject(com.huawei.hms.push.a.a(r100));
    L4:
        HMSLog.w("PushReceiver", "JSONException:parse message body failed.");
        return null;
    }

    private static JSONObject b(Intent r100) throws RuntimeException {
        JSONObject r101 = a(r100.getByteArrayExtra("msg_data"));
        JSONObject r102 = a(r101);
        String r103 = JsonUtil.getString(r102, "data", null);
        if (d.a(r102, b(r102), r103) == false) goto L6;
        return r101;
    L6:
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return null;
    L11:
        return new JSONObject(r103);
    L10:
        return null;
    }

    private static JSONObject a(JSONObject r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.optJSONObject(RemoteMessageConst.MessageBody.MSG_CONTENT);
    }

    private static JSONObject b(JSONObject r100) {
        if (r100 != null) goto L4;
        return null;
    L4:
        return r100.optJSONObject(RemoteMessageConst.MessageBody.PS_CONTENT);
    }

    public static /* synthetic */ JSONObject a(Intent r100) throws RuntimeException {
        return b(r100);
    }

    private void a(Context r100, Intent r101) {
    L9:
        HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        return;
    L8:
        HMSLog.e("PushReceiver", "handlePushMessageEvent execute task error");
        return;
    L4:
        if (r101.hasExtra("msg_data") == false) goto L6;
        q.a().execute(new b(r100, r101, null));     // Catch: Exception -> L8 RuntimeException -> L9
    L11:
        return;
    L6:
        HMSLog.i("PushReceiver", "This push message dose not sent by hwpush.");     // Catch: Exception -> L8 RuntimeException -> L9
        goto L11
    }

    private void b(Context r100, Intent r101) {
    L9:
        HMSLog.e("PushReceiver", "handlePushMessageEvent execute task runtime exception.");
        return;
    L8:
        HMSLog.e("PushReceiver", "handlePushTokenEvent execute task error");
        return;
    L4:
        if (r101.hasExtra(RemoteMessageConst.DEVICE_TOKEN) == false) goto L6;
        q.a().execute(new c(r100, r101, null));     // Catch: Exception -> L8 RuntimeException -> L9
    L11:
        return;
    L6:
        HMSLog.i("PushReceiver", "This message dose not sent by hwpush.");     // Catch: Exception -> L8 RuntimeException -> L9
        goto L11
    }

    @Override // android.content.BroadcastReceiver
    public void onReceive(Context r100, Intent r101) {
        if (r101 == null) goto L24;
        if (r100 == null) goto L25;
        HMSLog.i("PushReceiver", "push receive broadcast message, Intent:" + r101.getAction() + " pkgName:" + r100.getPackageName());
        r101.getStringExtra("TestIntent");     // Catch: Exception -> L18
        String r102 = r101.getAction();
        if (ResourceLoaderUtil.getmContext() != null) goto L11;
        ResourceLoaderUtil.setmContext(r100.getApplicationContext());
    L11:
        if ("com.huawei.android.push.intent.REGISTRATION".equals(r102) == false) goto L14;
        b(r100, r101);
        return;
    L14:
        if ("com.huawei.android.push.intent.RECEIVE".equals(r102) == false) goto L16;
        a(r100, r101);
        return;
    L16:
        HMSLog.i("PushReceiver", "message can't be recognised.");
        return;
    L18:
        HMSLog.e("PushReceiver", "intent has some error");
        return;
    L25:
        return;
    }
}
