package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.pm.ResolveInfo;
import android.text.TextUtils;
import com.xiaomi.push.gr;
import com.xiaomi.push.hh;
import java.util.List;

/* JADX INFO: loaded from: classes41.dex */
public class PushMessageHelper {
    public static final String ERROR_MESSAGE = "error_message";
    public static final String ERROR_TYPE = "error_type";
    public static final String ERROR_TYPE_NEED_PERMISSION = "error_lack_of_permission";
    public static final String KEY_COMMAND = "key_command";
    public static final String KEY_MESSAGE = "key_message";
    public static final int MESSAGE_COMMAND = 3;
    public static final int MESSAGE_ERROR = 5;
    public static final int MESSAGE_QUIT = 4;
    public static final int MESSAGE_RAW = 1;
    public static final int MESSAGE_SENDMESSAGE = 2;
    public static final String MESSAGE_TYPE = "message_type";
    public static final int PUSH_MODE_BROADCAST = 2;
    public static final int PUSH_MODE_CALLBACK = 1;
    private static int pushMode;

    public PushMessageHelper() {
    }

    public static gr generateMessage(MiPushMessage r100) {
        gr r101 = new gr();
        r101.a(r100.getMessageId());
        r101.b(r100.getTopic());
        r101.d(r100.getDescription());
        r101.c(r100.getTitle());
        r101.c(r100.getNotifyId());
        r101.a(r100.getNotifyType());
        r101.b(r100.getPassThrough());
        r101.a(r100.getExtra());
        return r101;
    }

    public static int getPushMode(Context r100) {
        if (pushMode != 0) goto L9;
        if (isUseCallbackPushMode(r100) == false) goto L7;
        setPushMode(1);
        goto L9
    L7:
        setPushMode(2);
    L9:
        return pushMode;
    }

    public static boolean isUseCallbackPushMode(Context r100) {
        Intent r101 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        r101.setClassName(r100.getPackageName(), "com.xiaomi.mipush.sdk.PushServiceReceiver");
        return isIntentAvailable(r100, r101);
    }

    public static void sendQuitMessageBroadcast(Context r100) {
        Intent r101 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        r101.setPackage(r100.getPackageName());
        r101.putExtra("message_type", 4);
        new PushServiceReceiver().onReceive(r100, r101);
    }

    private static void setPushMode(int r100) {
        pushMode = r100;
    }

    private static boolean isIntentAvailable(Context r100, Intent r101) {
        List<ResolveInfo> r102 = r100.getPackageManager().queryBroadcastReceivers(r101, 32);     // Catch: Exception -> L10
        if (r102 == null) goto L8;
        if (r102.isEmpty() == true) goto L8;
        return true;
    L8:
        return false;
    L14:
        return true;
    }

    public static void sendCommandMessageBroadcast(Context r100, MiPushCommandMessage r101) {
        Intent r102 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        r102.setPackage(r100.getPackageName());
        r102.putExtra("message_type", 3);
        r102.putExtra(KEY_COMMAND, r101);
        new PushServiceReceiver().onReceive(r100, r102);
    }

    public static MiPushMessage generateMessage(hh r100, gr r101, boolean r102) {
        MiPushMessage r103 = new MiPushMessage();
        r103.setMessageId(r100.m9236a());
        if (TextUtils.isEmpty(r100.d()) == true) goto L6;
        r103.setMessageType(1);
        r103.setAlias(r100.d());
    L12:
        r103.setCategory(r100.e());
        if (r100.a() == null) goto L15;
        r103.setContent(r100.a().c());
    L15:
        if (r101 != null) goto L17;
    L23:
        r103.setNotified(r102);
        return r103;
    L17:
        if (TextUtils.isEmpty(r103.getMessageId()) == false) goto L20;
        r103.setMessageId(r101.m9163a());
    L20:
        if (TextUtils.isEmpty(r103.getTopic()) == false) goto L22;
        r103.setTopic(r101.m9168b());
    L22:
        r103.setDescription(r101.d());
        r103.setTitle(r101.m9171c());
        r103.setNotifyType(r101.a());
        r103.setNotifyId(r101.c());
        r103.setPassThrough(r101.b());
        r103.setExtra(r101.m9164a());
        goto L23
    L6:
        if (TextUtils.isEmpty(r100.c()) == true) goto L9;
        r103.setMessageType(2);
        r103.setTopic(r100.c());
        goto L12
    L9:
        if (TextUtils.isEmpty(r100.f()) == true) goto L11;
        r103.setMessageType(3);
        r103.setUserAccount(r100.f());
        goto L12
    L11:
        r103.setMessageType(0);
        goto L12
    }

    public static MiPushCommandMessage generateCommandMessage(String r100, List<String> r101, long r102, String r103, String r104, List<String> r105) {
        MiPushCommandMessage r106 = new MiPushCommandMessage();
        r106.setCommand(r100);
        r106.setCommandArguments(r101);
        r106.setResultCode(r102);
        r106.setReason(r103);
        r106.setCategory(r104);
        r106.setAutoMarkPkgs(r105);
        return r106;
    }
}
