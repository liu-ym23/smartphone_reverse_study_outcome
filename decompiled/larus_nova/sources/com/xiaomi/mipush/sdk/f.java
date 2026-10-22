package com.xiaomi.mipush.sdk;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.content.pm.ApplicationInfo;
import android.content.pm.ResolveInfo;
import android.os.Bundle;
import android.text.TextUtils;
import com.bytedance.ee.bear.wikiv2.browser.plugin.WikiFolderPushPlugin;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.xiaomi.push.BuildConfig;
import com.xiaomi.push.ad;
import com.xiaomi.push.at;
import com.xiaomi.push.av;
import com.xiaomi.push.az;
import com.xiaomi.push.ha;
import com.xiaomi.push.service.ah;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class f {

    /* JADX INFO: renamed from: com.xiaomi.mipush.sdk.f$2, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass2 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        static final /* synthetic */ int[] f463063a = null;

        static {
            int[] r100 = new int[d.values().length];
            f463063a = r100;
            r100[d.f463055a.ordinal()] = 1;     // Catch: NoSuchFieldError -> L8
        L12:
            f463063a[d.f463056b.ordinal()] = 2;     // Catch: NoSuchFieldError -> L9
        L14:
            f463063a[d.f463057c.ordinal()] = 3;     // Catch: NoSuchFieldError -> L10
        L18:
            f463063a[d.f463058d.ordinal()] = 4;     // Catch: NoSuchFieldError -> L11
            return;
        }
    }

    public static int a() {
        Integer r100 = (Integer) av.a("com.xiaomi.assemble.control.AssembleConstants", "ASSEMBLE_VERSION_CODE");
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.intValue();
    }

    public static MiPushMessage a(String r110) {
        MiPushMessage r111 = new MiPushMessage();
        if (TextUtils.isEmpty(r110) == false) goto L57;
    L56:
        return r111;
    L57:
        JSONObject r112 = new JSONObject(r110);     // Catch: Exception -> L54
        if (r112.has("messageId") == false) goto L8;
        r111.setMessageId(JSONObjectProtectorUtils.getString(r112, "messageId"));     // Catch: Exception -> L54
    L8:
        if (r112.has("description") == false) goto L11;
        r111.setDescription(JSONObjectProtectorUtils.getString(r112, "description"));     // Catch: Exception -> L54
    L11:
        if (r112.has("title") == false) goto L14;
        r111.setTitle(JSONObjectProtectorUtils.getString(r112, "title"));     // Catch: Exception -> L54
    L14:
        if (r112.has("content") == false) goto L17;
        r111.setContent(JSONObjectProtectorUtils.getString(r112, "content"));     // Catch: Exception -> L54
    L17:
        if (r112.has("passThrough") == false) goto L20;
        r111.setPassThrough(JSONObjectProtectorUtils.getInt(r112, "passThrough"));     // Catch: Exception -> L54
    L20:
        if (r112.has("notifyType") == false) goto L23;
        r111.setNotifyType(JSONObjectProtectorUtils.getInt(r112, "notifyType"));     // Catch: Exception -> L54
    L23:
        if (r112.has("messageType") == false) goto L26;
        r111.setMessageType(JSONObjectProtectorUtils.getInt(r112, "messageType"));     // Catch: Exception -> L54
    L26:
        if (r112.has("alias") == false) goto L29;
        r111.setAlias(JSONObjectProtectorUtils.getString(r112, "alias"));     // Catch: Exception -> L54
    L29:
        if (r112.has("topic") == false) goto L32;
        r111.setTopic(JSONObjectProtectorUtils.getString(r112, "topic"));     // Catch: Exception -> L54
    L32:
        if (r112.has("user_account") == false) goto L35;
        r111.setUserAccount(JSONObjectProtectorUtils.getString(r112, "user_account"));     // Catch: Exception -> L54
    L35:
        if (r112.has(RemoteMessageConst.Notification.NOTIFY_ID) == false) goto L38;
        r111.setNotifyId(JSONObjectProtectorUtils.getInt(r112, RemoteMessageConst.Notification.NOTIFY_ID));     // Catch: Exception -> L54
    L38:
        if (r112.has("category") == false) goto L41;
        r111.setCategory(JSONObjectProtectorUtils.getString(r112, "category"));     // Catch: Exception -> L54
    L41:
        if (r112.has("isNotified") == false) goto L44;
        r111.setNotified(JSONObjectProtectorUtils.getBoolean(r112, "isNotified"));     // Catch: Exception -> L54
    L44:
        if (r112.has("extra") == false) goto L56;
        JSONObject r100 = JSONObjectProtectorUtils.getJSONObject(r112, "extra");     // Catch: Exception -> L54
        Iterator<String> r101 = r100.keys();     // Catch: Exception -> L54
        HashMap r102 = new HashMap();     // Catch: Exception -> L54
    L46:
        if (r101 == null) goto L51;
        if (r101.hasNext() == false) goto L51;
        String r103 = r101.next();     // Catch: Exception -> L54
        r102.put(r103, JSONObjectProtectorUtils.getString(r100, r103));     // Catch: Exception -> L54
    L51:
        if (r102.size() <= 0) goto L56;
        r111.setExtra(r102);     // Catch: Exception -> L54
    L54:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d(e.toString());
        goto L56
    }

    public static String b(d r100) {
        return a(r100) + "_version";
    }

    public static String c(d r100) {
        int r101 = AnonymousClass2.f463063a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "hms_push_error";
    L5:
        if (r101 != 2) goto L7;
        return "fcm_push_error";
    L7:
        if (r101 != 3) goto L9;
        return "cos_push_error";
    L9:
        if (r101 == 4) goto L11;
        return null;
    L11:
        return "ftos_push_error";
    }

    public static PushMessageReceiver a(Context r100) {
        Intent r101 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        r101.setPackage(r100.getPackageName());
        List<ResolveInfo> r102 = r100.getPackageManager().queryBroadcastReceivers(r101, 32);     // Catch: Exception -> L18
        if (r102 == null) goto L13;
        Iterator<ResolveInfo> r103 = r102.iterator();     // Catch: Exception -> L18
    L7:
        if (r103.hasNext() == false) goto L13;
        ResolveInfo r104 = r103.next();     // Catch: Exception -> L18
        ActivityInfo r105 = r104.activityInfo;     // Catch: Exception -> L18
        if (r105 == null) goto L7;
        if (r105.packageName.equals(r100.getPackageName()) == false) goto L7;
    L14:
        if (r104 == null) goto L17;
        return (PushMessageReceiver) com.xiaomi.push.q.a(r100, r104.activityInfo.name).newInstance();
    L17:
        return null;
    L13:
        r104 = null;
    L18:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d(e.toString());
        return null;
    }

    public static void b(Context r100) {
        e.a(r100).register();
    }

    public static void c(Context r100) {
        e.a(r100).unregister();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m8763a(Context r100) {
        boolean r101 = false;
        SharedPreferences r102 = r100.getSharedPreferences("mipush_extra", 0);
        String r103 = a(d.f463055a);
        String r104 = a(d.f463056b);
        if (TextUtils.isEmpty(r102.getString(r103, "")) == false) goto L5;
    L7:
        if (r101 == false) goto L10;
        u.a(r100).a(2, r103);
        return;
    L10:
        return;
    L5:
        if (TextUtils.isEmpty(r102.getString(r104, "")) == false) goto L7;
        r101 = true;
        goto L7
    }

    public static String a(d r100) {
        int r101 = AnonymousClass2.f463063a[r100.ordinal()];
        if (r101 != 1) goto L5;
        return "hms_push_token";
    L5:
        if (r101 != 2) goto L7;
        return "fcm_push_token_v2";
    L7:
        if (r101 != 3) goto L9;
        return "cos_push_token";
    L9:
        if (r101 == 4) goto L11;
        return null;
    L11:
        return "ftos_push_token";
    }

    public static void a(Intent r100) {
        if (r100 == null) goto L9;
        Bundle r101 = r100.getExtras();
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.containsKey(WikiFolderPushPlugin.PUSH_MSG) == false) goto L11;
        r100.putExtra("key_message", a(r101.getString(WikiFolderPushPlugin.PUSH_MSG)));
        return;
    L11:
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8768a(d r100) {
        if (r100 != d.f463058d) goto L5;
    L8:
        return true;
    L5:
        if (r100 == d.f463056b) goto L8;
        return false;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8766a(Context r100) {
        if (r100 != null) goto L6;
        return false;
    L6:
        return at.m8819a(r100);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static HashMap<String, String> m8762a(Context r110, d r111) {
        HashMap<String, String> r100 = new HashMap();
        int r101 = AnonymousClass2.f463063a[r111.ordinal()];
        String r102 = null;
        ApplicationInfo r103 = null;
        if (r101 != 1) goto L5;
        r103 = r110.getPackageManager().getApplicationInfo(r110.getPackageName(), 128);     // Catch: Exception -> L23
    L25:
        if (r103 == null) goto L27;
        int r104 = r103.metaData.getInt(Constants.HUAWEI_HMS_CLIENT_APPID);
    L28:
        r102 = new com.xiaomi.push.r.a(":", Constants.WAVE_SEPARATOR).a("brand", q.f463077a.name()).a("token", a(r110, r111, true)).a("package_name", r110.getPackageName()).a("app_id", Integer.valueOf(r104)).toString();
    L29:
        r100.put(Constants.ASSEMBLE_PUSH_REG_INFO, r102);
        return r100;
    L27:
        r104 = -1;
    L23:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d(e.toString());
        goto L25
    L5:
        if (r101 != 2) goto L7;
        com.xiaomi.push.r.a r112 = new com.xiaomi.push.r.a(":", Constants.WAVE_SEPARATOR).a("brand", q.f463079c.name()).a("token", a(r110, r111, false)).a("package_name", r110.getPackageName());
        int r113 = a();
        if (r113 == 0) goto L19;
        r112.a("version", Integer.valueOf(r113));
    L20:
        r102 = r112.toString();
        goto L29
    L19:
        r112.a("version", Integer.valueOf(BuildConfig.VERSION_CODE));
        goto L20
    L7:
        if (r101 != 3) goto L9;
        r102 = new com.xiaomi.push.r.a(":", Constants.WAVE_SEPARATOR).a("brand", q.f463080d.name()).a("token", a(r110, r111, true)).a("package_name", r110.getPackageName()).toString();
        goto L29
    L9:
        if (r101 != 4) goto L29;
        com.xiaomi.push.r.a r114 = new com.xiaomi.push.r.a(":", Constants.WAVE_SEPARATOR).a("brand", q.f463081e.name()).a("token", a(r110, r111, true)).a("package_name", r110.getPackageName());
        int r115 = a();
        if (r115 == 0) goto L14;
        r114.a("version", Integer.valueOf(r115));
    L14:
        r102 = r114.toString();
        goto L29
    }

    public static boolean a(ha r100, d r101) {
        if (r100 != null) goto L4;
        return false;
    L4:
        if (r100.m9197a() != null) goto L6;
        return false;
    L6:
        if (r100.m9197a().m9164a() != null) goto L8;
        return false;
    L8:
        if (r101 != d.f463056b) goto L10;
        String r102 = "FCM";
    L12:
        return r102.equalsIgnoreCase(r100.m9197a().m9164a().get("assemble_push_type"));
    L10:
        r102 = "";
        goto L12
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m8764a(Context r100, d r101) {
        String r102 = a(r101);
        if (TextUtils.isEmpty(r102) == false) goto L5;
        return;
    L5:
        com.xiaomi.push.o.a(r100.getSharedPreferences("mipush_extra", 0).edit().putString(r102, ""));
    }

    private static synchronized void a(Context r100, String r101) {
        monitor-enter(f.class);
        SharedPreferences.Editor r102 = r100.getSharedPreferences("mipush_extra", 0).edit();     // Catch: Throwable -> L7
        r102.putString("syncingToken", r101);     // Catch: Throwable -> L7
        r102.apply();     // Catch: Throwable -> L7
        monitor-exit(f.class);
        return;
    L7:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m8767a(Context r100, d r101) {
        if (g.m8770a(r101) != null) goto L5;
        return false;
    L5:
        return ah.a(r100).a(g.m8770a(r101).a(), true);
    }

    public static void a(String r100, int r101) {
        MiTinyDataClient.upload("hms_push_error", r100, 1, "error code = " + r101);
    }

    public static String a(Context r100, d r101) {
        return a(r100, r101, false);
    }

    private static int a(Context r100, d r101, String r102) {
        SharedPreferences r103 = r100.getSharedPreferences("mipush_extra", 0);
        String r104 = a(r101);
        String r105 = r103.getString(r104, "");
        String r106 = b.m8743a(r100).m8751c();
        String r107 = r103.getString("last_check_token", "");
        if (TextUtils.isEmpty(r104) == false) goto L7;
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH : can not find the key of token used in sp file");
        return 0;
    L7:
        if (TextUtils.isEmpty(r105) == false) goto L11;
        return 1;
    L11:
        if (r105.equals(r102) == true) goto L15;
        return 2;
    L15:
        if (TextUtils.equals(r106, r107) == true) goto L19;
        return 3;
    L19:
        if (m8768a(r101) == false) goto L24;
        int r108 = r103.getInt(b(r101), 0);
        if (a() == r108) goto L24;
        return 4;
    L24:
        return 0;
    }

    public static void b(final Context r100, final d r101, final String r102) {
        ad.a(r100).a(new AnonymousClass1(r102, r100, r101));
    }

    public static /* synthetic */ void c(Context r100, d r101, String r102) {
        d(r100, r101, r102);
    }

    private static synchronized void d(Context r100, d r101, String r102) {
        monitor-enter(f.class);
        String r103 = a(r101);     // Catch: Throwable -> L15
        if (TextUtils.isEmpty(r103) == false) goto L9;
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH : can not find the key of token used in sp file");     // Catch: Throwable -> L15
        monitor-exit(f.class);
        return;
    L9:
        SharedPreferences.Editor r104 = r100.getSharedPreferences("mipush_extra", 0).edit();     // Catch: Throwable -> L15
        r104.putString(r103, r102).putString("last_check_token", b.m8743a(r100).m8751c());     // Catch: Throwable -> L15
        if (m8768a(r101) == false) goto L12;
        r104.putInt(b(r101), a());     // Catch: Throwable -> L15
    L12:
        r104.putString("syncingToken", "");     // Catch: Throwable -> L15
        com.xiaomi.push.o.a(r104);     // Catch: Throwable -> L15
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH : update sp file success!  " + r102);     // Catch: Throwable -> L15
        monitor-exit(f.class);
        return;
    L15:
        th = move-exception;
        throw th;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m8765a(Context r100, d r101, String r102) {
        if (TextUtils.isEmpty(r102) == true) goto L12;
        int r103 = a(r100, r101, r102);
        if (r103 == 0) goto L10;
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH : send token upload, check:" + r103);
        a(r100, r102);
        v r104 = g.m8769a(r101);
        if (r104 != null) goto L9;
        return;
    L9:
        u.a(r100).a(null, r104, r101, "upload");
        return;
    L10:
        com.xiaomi.channel.commonutils.logger.b.m8718a("ASSEMBLE_PUSH : do not need to send token");
        return;
    }

    public static synchronized String a(Context r100, d r101, boolean r102) {
        monitor-enter(f.class);
        SharedPreferences r103 = r100.getSharedPreferences("mipush_extra", 0);     // Catch: Throwable -> L18
        if (r102 == false) goto L10;
        String r104 = r103.getString("syncingToken", "");     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r104) == true) goto L10;
        monitor-exit(f.class);
        return r104;
    L10:
        String r105 = a(r101);     // Catch: Throwable -> L18
        if (TextUtils.isEmpty(r105) == true) goto L16;
        String r106 = r103.getString(r105, "");     // Catch: Throwable -> L18
        monitor-exit(f.class);
        return r106;
    L16:
        monitor-exit(f.class);
        return "";
    L18:
        th = move-exception;
        throw th;
    }

    public static byte[] a(Context r100, ha r101, d r102) {
        if (a(r101, r102) == true) goto L5;
        return null;
    L5:
        return az.m8830a(a(r100, r102));
    }
}
