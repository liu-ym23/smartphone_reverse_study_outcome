package com.xiaomi.push.service.receivers;

import android.content.Context;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.push.PushSupporter;
import com.bytedance.push.log.ILogger;
import com.bytedance.push.utils.f;
import com.xiaomi.mipush.sdk.MiPushClient;
import com.xiaomi.mipush.sdk.MiPushCommandMessage;
import com.xiaomi.mipush.sdk.MiPushMessage;
import com.xiaomi.mipush.sdk.PushMessageReceiver;
import com.xm.MiPushAdapter;
import java.util.List;
import org.json.JSONObject;
import qqc.a;

/* JADX INFO: loaded from: classes41.dex */
public class MIPushMessageHandler extends PushMessageReceiver {
    private static final String TAG = "MiPush";

    public MIPushMessageHandler() {
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onCommandResult(Context r110, MiPushCommandMessage r111) {
        if (r110 == null) goto L75;
        if (r111 == null) goto L77;
        String r100 = r111.getCommand();     // Catch: Throwable -> L70
        List<String> r112 = r111.getCommandArguments();     // Catch: Throwable -> L70
        String r113 = null;
        if (r112 != null) goto L9;
    L11:
        String r114 = null;
    L12:
        if (r112 != null) goto L14;
    L16:
        String r115 = null;
    L17:
        PushSupporter.logger().i(TAG, "command:" + r100);     // Catch: Throwable -> L70
        if (MiPushClient.COMMAND_REGISTER.equals(r100) == false) goto L27;
        if (r111.getResultCode() != 0) goto L25;
        PushSupporter.logger().d(TAG, "mRegId = " + r114);     // Catch: Throwable -> L70
        if (TextUtils.isEmpty(r114) == true) goto L24;
        PushSupporter.thirdService().registerSenderSuccessAndUploadToken(r110, MiPushAdapter.getMiPush(), r114);     // Catch: Throwable -> L70
    L52:
        if (r111.getResultCode() != 0) goto L54;
        return;
    L54:
        if (70000002 != r111.getResultCode()) goto L57;
        r113 = "push connection certification failed";
    L66:
        if (TextUtils.equals(r100, "Registration") == false) goto L68;
        PushSupporter.monitor().monitorRegisterSenderFailed(MiPushAdapter.getMiPush(), 104, String.valueOf(r111.getResultCode()), r113);     // Catch: Throwable -> L70
    L68:
        PushSupporter.logger().i(TAG, r100 + " -> " + r113);     // Catch: Throwable -> L70
        return;
    L57:
        if (70000001 != r111.getResultCode()) goto L60;
        r113 = "the push connection failed due to network failure";
        goto L66
    L60:
        if (70000004 != r111.getResultCode()) goto L63;
        r113 = "push internal status error, please contact developers if you encounter such errors";
        goto L66
    L63:
        if (70000003 != r111.getResultCode()) goto L66;
        r113 = "The message format sent by the client to the push channel is invalid";
        goto L66
    L24:
        PushSupporter.monitor().monitorRegisterSenderFailed(MiPushAdapter.getMiPush(), 102, "0", "token is empty");     // Catch: Throwable -> L70
        goto L52
    L25:
        PushSupporter.monitor().monitorRegisterSenderFailed(MiPushAdapter.getMiPush(), 104, String.valueOf(r111.getResultCode()), r111.getReason());     // Catch: Throwable -> L70
        PushSupporter.thirdService().registerSenderFailed(MiPushAdapter.getMiPush(), String.valueOf(r111.getResultCode()), r111.getReason());     // Catch: Throwable -> L70
        goto L52
    L27:
        if (MiPushClient.COMMAND_SET_ALIAS.equals(r100) == false) goto L32;
        if (r111.getResultCode() != 0) goto L52;
        PushSupporter.logger().d(TAG, "set alias success, mAlias = " + r114);     // Catch: Throwable -> L70
        goto L52
    L32:
        if (MiPushClient.COMMAND_UNSET_ALIAS.equals(r100) == false) goto L37;
        if (r111.getResultCode() != 0) goto L52;
        PushSupporter.logger().d(TAG, "unSet alias success, mAlias = " + r114);     // Catch: Throwable -> L70
        goto L52
    L37:
        if (MiPushClient.COMMAND_SUBSCRIBE_TOPIC.equals(r100) == false) goto L42;
        if (r111.getResultCode() != 0) goto L52;
        PushSupporter.logger().d(TAG, "subscribe topic success, mTopic = " + r114);     // Catch: Throwable -> L70
        goto L52
    L42:
        if (MiPushClient.COMMAND_UNSUBSCRIBE_TOPIC.equals(r100) == false) goto L47;
        if (r111.getResultCode() != 0) goto L52;
        PushSupporter.logger().d(TAG, "unSubscribe topic success, mTopic = " + r114);     // Catch: Throwable -> L70
        goto L52
    L47:
        if (MiPushClient.COMMAND_SET_ACCEPT_TIME.equals(r100) == false) goto L52;
        if (r111.getResultCode() != 0) goto L52;
        PushSupporter.logger().d(TAG, "mStartTime = " + r114 + " mEndTime = " + r115);     // Catch: Throwable -> L70
        goto L52
    L14:
        if (r112.size() <= 1) goto L16;
        r115 = (String) ListProtector.get(r112, 1);     // Catch: Throwable -> L70
        goto L17
    L9:
        if (r112.size() <= 0) goto L11;
        r114 = (String) ListProtector.get(r112, 0);     // Catch: Throwable -> L70
    L70:
        th = move-exception;
        th.printStackTrace();
        return;
    L77:
        return;
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageArrived(Context r100, MiPushMessage r101) {
        super.onNotificationMessageArrived(r100, r101);
        PushSupporter.logger().i(TAG, "onNotificationMessageArrived");
        if (a.f534511a == null) goto L5;
    L14:
        a.f534511a.getClass();
        return;
    L5:
        monitor-enter(a.class);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (a.f534511a != null) goto L9;
        a.f534511a = new a();     // Catch: Throwable -> L11
    L9:
        monitor-exit(a.class);     // Catch: Throwable -> L11
        goto L14
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onNotificationMessageClicked(Context r100, MiPushMessage r101) {
        super.onNotificationMessageClicked(r100, r101);
        ILogger r102 = PushSupporter.logger();
        StringBuilder r103 = new StringBuilder("Get MiPush Message ");
        if (r101 == null) goto L5;
        String r104 = r101.toString();
    L6:
        r103.append(r104);
        r102.d(TAG, r103.toString());
        if (r100 == null) goto L20;
        if (r101 == null) goto L22;
        String r105 = r101.getContent();     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r105) == true) goto L21;
        String r106 = PushSupporter.thirdService().getMessageV2(MiPushAdapter.getMiPush(), r105.getBytes(), true);     // Catch: Throwable -> L17
        if (TextUtils.isEmpty(r106) == false) goto L15;
        return;
    L15:
        JSONObject r107 = new JSONObject(r106);     // Catch: Throwable -> L17
        r107.put("pass_through", r101.getPassThrough());     // Catch: Throwable -> L17
        PushSupporter.thirdService().onClickNotPassThroughNotification(r100, r107.toString(), MiPushAdapter.getMiPush(), null);     // Catch: Throwable -> L17
        return;
    L21:
        return;
    L23:
        return;
    L22:
        return;
    L20:
        return;
    L5:
        r104 = String.valueOf(null);
        goto L6
    }

    @Override // com.xiaomi.mipush.sdk.PushMessageReceiver
    public void onReceivePassThroughMessage(Context r100, MiPushMessage r101) {
        super.onReceivePassThroughMessage(r100, r101);
        ILogger r102 = PushSupporter.logger();
        StringBuilder r103 = new StringBuilder("Get MiPush Message ");
        if (r101 == null) goto L5;
        String r104 = r101.toString();
    L6:
        r103.append(r104);
        r102.d(TAG, r103.toString());
        if (r100 == null) goto L19;
        if (r101 == null) goto L21;
        String r105 = r101.getContent();     // Catch: Throwable -> L14
        if (TextUtils.isEmpty(r105) == true) goto L20;
        JSONObject r106 = new JSONObject(PushSupporter.thirdService().getMessageV2(MiPushAdapter.getMiPush(), r105.getBytes(), true));     // Catch: Throwable -> L14
        r106.put("pass_through", r101.getPassThrough());     // Catch: Throwable -> L14
        PushSupporter.pushHandler().handlePassThroughMsg(r106.toString(), MiPushAdapter.getMiPush(), null);     // Catch: Throwable -> L14
        return;
    L20:
        return;
    L14:
        th = move-exception;
        f.d(Log.getStackTraceString(th));
        return;
    L21:
        return;
    L19:
        return;
    L5:
        r104 = String.valueOf(null);
        goto L6
    }
}
