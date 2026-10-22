package com.vivo;

import android.content.Context;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.common.utility.Logger;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.utils.f;
import com.larus.apm.impl.protector.RunnableProtector;
import com.vivo.push.model.UPSNotificationMessage;
import com.vivo.push.model.UnvarnishedMessage;
import com.vivo.push.sdk.OpenClientPushMessageReceiver;
import com.vv.VvPushAdapter;
import oqc.b;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class VivoPushMessageReceiver extends OpenClientPushMessageReceiver {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Handler f462206a;

    public class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ String f462207a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f462208b;

        @Override // java.lang.Runnable
        public final void run() {
            PushSupporter.logger().i("VivoPushMessageReceiver", "onReceiveRegId token = " + this.f462207a);     // Catch: Throwable -> L4
            VvPushAdapter.sendToken(this.f462208b, this.f462207a);     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }

        public a(String r100, Context r101) {
            this.f462207a = r100;
            this.f462208b = r101;
        }
    }

    public VivoPushMessageReceiver() {
        this.f462206a = new Handler(Looper.getMainLooper());
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onNotifyGuideDialogResult(int r100) {
        super.onNotifyGuideDialogResult(r100);
        b r101 = b.f524912b;
        oqc.a r102 = r101.f524913a;
        if (r102 == null) goto L10;
        VvPushAdapter.g.a r103 = (VvPushAdapter.g.a) r102;
        PushSupporter.logger().i("VivoPush", "onNotifyGuideDialogResult: message = " + r100);
        boolean r104 = true;
        if (r100 == 1) goto L8;
        r104 = false;
    L8:
        VvPushAdapter.g r105 = r103.f462949a;
        VvPushAdapter.access$200(r105.f462948d, r105.f462945a, r104, r105.f462947c);
        r101.f524913a = null;
        return;
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onNotificationMessageClicked(Context r100, UPSNotificationMessage r101) {
        if (r100 == null) goto L18;
        if (r101 == null) goto L20;
        Logger.i("VivoPushMessageReceiver", "onNotificationMessageClicked: message = " + r101.getSkipContent());
        String r102 = r101.getSkipContent();     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r102) == true) goto L19;
        String r103 = PushSupporter.thirdService().getMessageV2(VvPushAdapter.getVvPush(), r102.getBytes(), true);     // Catch: Throwable -> L13
        if (TextUtils.isEmpty(r103) == false) goto L11;
        return;
    L11:
        JSONObject r104 = new JSONObject(r103);     // Catch: Throwable -> L13
        r104.put("pass_through", 0);     // Catch: Throwable -> L13
        PushSupporter.thirdService().onClickNotPassThroughNotification(r100, r104.toString(), VvPushAdapter.getVvPush(), null);     // Catch: Throwable -> L13
        return;
    L19:
        return;
    L13:
        th = move-exception;
        th.printStackTrace();
        return;
    L20:
        return;
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public void onReceiveRegId(Context r100, String r101) {
        this.f462206a.post(new a(r101, r100));
    }

    @Override // com.vivo.push.sdk.OpenClientPushMessageReceiver, com.vivo.push.sdk.BasePushMessageReceiver, com.vivo.push.sdk.PushMessageCallback
    public final void onTransmissionMessage(Context r100, UnvarnishedMessage r101) {
        super.onTransmissionMessage(r100, r101);
        f.g("VivoPushMessageReceiver", "onMessageReceived is called");
        if (r101 != null) goto L6;
        f.e("VivoPushMessageReceiver", "Received message entity is null!");
        return;
    L6:
        String r102 = r101.getMessage();
        f.g("VivoPushMessageReceiver", "get message: " + r102);
        if (TextUtils.isEmpty(r102) == true) goto L15;
        JSONObject r103 = new JSONObject(r102);     // Catch: JSONException -> L10
        JSONObject r104 = new JSONObject(r103.optString("android_payload"));     // Catch: JSONException -> L10
        r104.put("voip_params", r103.optString("voip_params"));     // Catch: JSONException -> L10
        r104.put("push_show_type", r103.optInt("push_show_type"));     // Catch: JSONException -> L10
        PushSupporter.pushHandler().handlePassThroughMsg(r104, VvPushAdapter.getVvPush(), null);     // Catch: JSONException -> L10
        return;
    L10:
        e = move-exception;
        e.printStackTrace();
        return;
    }
}
