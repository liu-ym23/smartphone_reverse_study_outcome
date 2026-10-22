package com.huawei.hms.push.utils;

import android.app.ActivityManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.android.live.broadcastgame.api.interactgame.IInteractGameMonitorService;
import com.bytedance.bdlocation.exception.BDLocationException;
import com.huawei.hms.aaid.constant.ErrorEnum;
import com.huawei.hms.aaid.plugin.ProxyCenter;
import com.huawei.hms.aaid.utils.PushPreferences;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.push.i;
import com.huawei.hms.push.l;
import com.huawei.hms.push.m;
import com.huawei.hms.push.r;
import com.huawei.hms.push.t;
import com.huawei.hms.support.log.HMSLog;
import com.huawei.hms.utils.ResourceLoaderUtil;
import com.larus.bmhome.music.applet.MusicAppletPage;
import java.nio.charset.Charset;
import java.util.Iterator;
import java.util.List;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes23.dex */
public class PluginUtil {
    private PluginUtil() {
    }

    private static boolean a(Context r100) {
        List<ActivityManager.RunningAppProcessInfo> r101 = ((ActivityManager) r100.getSystemService("activity")).getRunningAppProcesses();
        if (r101 != null) goto L6;
        HMSLog.w("PluginUtil", "get running app processes null!");
        return false;
    L6:
        Iterator<ActivityManager.RunningAppProcessInfo> r102 = r101.iterator();
    L8:
        if (r102.hasNext() == false) goto L22;
        ActivityManager.RunningAppProcessInfo r103 = r102.next();
        if (r103.processName.equals(r100.getPackageName()) == false) goto L8;
        int r104 = r103.importance;
        if (r104 != 100) goto L14;
        return false;
    L14:
        if (r104 == 200) goto L21;
        return true;
    L21:
        return false;
    L22:
        return false;
    }

    public static boolean onDeletedMessages(Context r100) {
        HMSLog.i("PluginUtil", "onDeletedMessages");
        if (r100 != null) goto L6;
        return false;
    L6:
        Intent r101 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        r101.setPackage(r100.getPackageName());
        Bundle r102 = new Bundle();
        r102.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        r102.putString("message_type", "server_deleted_message");
        return new r().a(r100, r102, r101);
    }

    private static String a(String r100) {
        if (TextUtils.isEmpty(r100) == false) goto L9;
        return null;
    L9:
        JSONObject r101 = new JSONObject();     // Catch: JSONException -> L7
        JSONObject r102 = new JSONObject();     // Catch: JSONException -> L7
        r101.put("data", r100);     // Catch: JSONException -> L7
        r102.put(RemoteMessageConst.MessageBody.MSG_CONTENT, r101);     // Catch: JSONException -> L7
        return r102.toString();
    L7:
        HMSLog.e("PluginUtil", "rebuild message failed");
        return null;
    }

    private static boolean a(Context r100, String[] r101) {
        if (TextUtils.equals(r101[1], "0") == true) goto L5;
        return false;
    L5:
        if (a(r100) == false) goto L7;
        return true;
    L7:
        if (TextUtils.equals(r101[2], "1") == true) goto L13;
        return false;
    L13:
        return true;
    }

    public static void onMessage(Context r100, String[] r101) {
        HMSLog.i("PluginUtil", "onMessage");
        if (r100 == null) goto L16;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.length >= 5) goto L9;
        return;
    L9:
        if (ResourceLoaderUtil.getmContext() != null) goto L12;
        ResourceLoaderUtil.setmContext(r100.getApplicationContext());
    L12:
        if (a(r100, r101) == false) goto L14;
        a(r100, r101[0], r101[3], r101[4]);
        return;
    L14:
        onDataMessage(r100, r101[0], r101[4], true);
        return;
    }

    public static void saveNotifySwitch(Context r100, boolean r101) {
        new PushPreferences(r100, "push_notify_flag").saveBoolean("notify_msg_enable", r101);
    }

    private static void a(Context r100, String r101) {
        l.a(r100, r101, null, BDLocationException.ERROR_UID_IS_EMPTY);
    }

    public static void onNotificationArrived(Context r100, String r101, String r102) {
        l.a(r100, r101, r102, "100");
    }

    public static void onNotificationClicked(Context r100, String r101, String r102) {
        l.a(r100, r101, r102, "1");
        onAppOpened(r100, r101, r102, null);
    }

    public static boolean onOldDataMessage(Context r100, String r101, String r102) {
        if (ResourceLoaderUtil.getmContext() != null) goto L6;
        ResourceLoaderUtil.setmContext(r100.getApplicationContext());
    L6:
        return onDataMessage(r100, r101, a(r102), true);
    }

    private static void a(Context r100, String r101, String r102, String r103) {
        HMSLog.i("PluginUtil", "onNotification");
        if (i.a(r100) == true) goto L6;
        HMSLog.i("PluginUtil", r100.getPackageName() + " disable display notification.");
        l.a(r100, r101, null, IInteractGameMonitorService.FAILURE_CODE_LINK_MIC_MUTEX);
        return;
    L6:
        Intent r104 = new Intent();
        r104.setAction("com.huawei.push.msg.NOTIFY_MSG");
        Charset r105 = m.f277621a;
        r104.putExtra("selfshow_info", r103.getBytes(r105));
        r104.putExtra("selfshow_token", r102.getBytes(r105));
        r104.setPackage(r100.getPackageName());
        t.a(r100, r104);
        HMSLog.i("PluginUtil", "invokeSelfShow done");
    }

    public static void onAppOpened(Context r100, String r101, String r102, Bundle r103) {
        l.a(r100, r101, r102, "appHasOpenedId");
        l.a(r100, r103, "hmsStatistics");
    }

    public static boolean onDataMessage(Context r100, String r101, String r102, boolean r103) {
        HMSLog.i("PluginUtil", "onDataMessage");
        if (TextUtils.isEmpty(r102) == false) goto L6;
        HMSLog.i("PluginUtil", "Empty message received");
        return true;
    L6:
        if (r103 == false) goto L8;
        a(r100, r101);
    L8:
        Intent r104 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        r104.setPackage(r100.getPackageName());
        Bundle r105 = new Bundle();
        r105.putString(MusicAppletPage.KEY_MESSAGE_ID, r101);
        r105.putByteArray(RemoteMessageConst.MSGBODY, r102.getBytes(m.f277621a));
        r105.putString("message_type", "received_message");
        return new r().a(r100, r105, r104);
    }

    public static boolean onNewToken(Context r100, String r101, String r102, ErrorEnum r103) {
        HMSLog.i("PluginUtil", "onNewToken called.");
        Intent r104 = new Intent("com.huawei.push.action.MESSAGING_EVENT");
        r104.setPackage(r100.getPackageName());
        Bundle r105 = new Bundle();
        r105.putInt("error", r103.getInternalCode());
        r105.putString("message_type", "new_token");
        r105.putString(RemoteMessageConst.DEVICE_TOKEN, r101);
        if (TextUtils.equals(r102, r100.getPackageName()) == false) goto L5;
        r105.putString("subjectId", null);
    L6:
        r105.putString("message_proxy_type", ProxyCenter.getProxy().getProxyType());
        return new r().a(r100, r105, r104);
    L5:
        r105.putString("subjectId", r102);
        goto L6
    }
}
