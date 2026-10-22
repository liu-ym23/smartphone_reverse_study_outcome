package com.xiaomi.push.service;

import android.app.Notification;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.os.Parcelable;
import android.provider.Settings;
import android.text.TextUtils;
import androidx.core.app.NotificationCompat;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.ss.android.download.api.constant.BaseConstants;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class ag {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a<String, String, String> f464196a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    static Boolean f1038a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static String f1039a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final String[] f1040a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final a<String, String, String> f464197b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final a<String, String, String> f464198c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final a<String, String, String> f464199d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final a<String, String, String> f464200e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final a<String, String, String> f464201f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a<String, String, String> f464202g = null;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public static final a<String, String, String> f464203h = null;

    /* JADX INFO: renamed from: com.xiaomi.push.service.ag$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public static class a<F, S, T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        F f464204a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        S f464205b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        T f464206c;

        private a(F r100, S r101, T r102) {
            this.f464204a = r100;
            this.f464205b = r101;
            this.f464206c = r102;
        }

        public /* synthetic */ a(Object r100, Object r101, Object r102, AnonymousClass1 r103) {
            this(r100, r101, r102);
        }
    }

    static {
        f1040a = new String[]{"com.mi.globalbrowser", BaseConstants.KLLK_PROMOTION_NORMAL_PKG_INFO};
        AnonymousClass1 r100 = null;
        f1039a = null;
        String r101 = "getNotificationSettings";
        f464196a = new a(r101, r101, r101, r100);
        String r102 = "canSound";
        f464197b = new a("setSound", r102, r102, r100);
        String r103 = "canVibrate";
        f464198c = new a("setVibrate", r103, r103, r100);
        String r104 = "canLights";
        f464199d = new a("setLights", r104, r104, r100);
        String r105 = "canShowOnKeyguard";
        f464200e = new a("setShowOnKeyguard", r105, r105, r100);
        String r106 = "setFloat";
        f464201f = new a(r106, "canFloat", "canShowFloat", r100);
        String r107 = "canShowBadge";
        f464202g = new a("setShowBadge", r107, r107, r100);
        String r108 = "canShowOngoing";
        f464203h = new a("setShowOngoing", r108, r108, r100);
    }

    public static boolean a() {
        if (f1038a != null) goto L15;
        if (Build.VERSION.SDK_INT < 30) goto L13;
        Bundle r100 = f.m9383a("com.xiaomi.xmsf", null);
        if (r100 != null) goto L9;
    L12:
        f1038a = Boolean.FALSE;
        goto L15
    L9:
        if (r100.isEmpty() == true) goto L12;
        f1038a = Boolean.TRUE;
        goto L15
    L13:
        f1038a = Boolean.FALSE;
    L15:
        return f1038a.booleanValue();
    }

    public static String a(Notification r100) {
        Bundle r101 = r100.extras;
        if (r101 == null) goto L10;
        CharSequence r102 = r101.getCharSequence(NotificationCompat.EXTRA_TITLE);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = r100.extras.getCharSequence(NotificationCompat.EXTRA_TITLE_BIG);
    L8:
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r102 = r100.extras.getCharSequence("mipush.customTitle");
    L11:
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102.toString();
    L10:
        r102 = null;
        goto L11
    }

    public static String b(Notification r100) {
        Bundle r101 = r100.extras;
        if (r101 == null) goto L10;
        CharSequence r102 = r101.getCharSequence(NotificationCompat.EXTRA_TEXT);
        if (TextUtils.isEmpty(r102) == false) goto L8;
        r102 = r100.extras.getCharSequence(NotificationCompat.EXTRA_BIG_TEXT);
    L8:
        if (TextUtils.isEmpty(r102) == false) goto L11;
        r102 = r100.extras.getCharSequence("mipush.customContent");
    L11:
        if (r102 != null) goto L15;
        return "";
    L15:
        return r102.toString();
    L10:
        r102 = null;
        goto L11
    }

    public static String c(Notification r100) {
        String r101 = null;
        Bundle r102 = r100.extras;     // Catch: Exception -> L13
        if (r102 == null) goto L7;
        r101 = r102.getString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE);     // Catch: Exception -> L13
    L7:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        Object r103 = com.xiaomi.push.av.a(r100, "extraNotification");     // Catch: Exception -> L13
        if (r103 == null) goto L17;
        return (String) com.xiaomi.push.av.a(r103, "getTargetPkg", new Object[0]);
    L17:
        return r101;
    L16:
        return r101;
    L18:
        return r101;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Notification.Action[] m9358a(Notification r100) {
        Notification.Action[] r101 = r100.actions;
        if (r101 == null) goto L5;
        return r101;
    L5:
        Bundle r102 = r100.extras;
        if (r102 == null) goto L11;
        Parcelable[] r103 = r102.getParcelableArray("mipush.customActions");
        if (r103 != null) goto L10;
        return null;
    L10:
        return (Notification.Action[]) Arrays.copyOf(r103, r103.length, Notification.Action[].class);
    L11:
        return null;
    }

    public static int a(ContentResolver r100) {
        return Settings.Global.getInt(r100, "user_aggregate", 0);
    L5:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("get user aggregate failed, " + e);
        return 0;
    }

    public static boolean a(Map<String, String> r100) {
        return Boolean.parseBoolean((String) a(r100, "not_suppress", "true"));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9357a(ContentResolver r100) {
        int r101 = a(r100);
        if (r101 != 1) goto L5;
        return true;
    L5:
        if (r101 == 2) goto L10;
        return false;
    L10:
        return true;
    }

    public static String a(Object r100) {
        return (String) a(r100, "msg_busi_type", "");
    }

    public static void a(Notification r100, int r101) {
        Bundle r102 = r100.extras;     // Catch: Exception -> L9
        if (r102 == null) goto L5;
        r102.putInt("miui.messageCount", r101);     // Catch: Exception -> L9
    L5:
        Object r103 = com.xiaomi.push.av.a(r100, "extraNotification");     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        com.xiaomi.push.av.a(r103, "setMessageCount", new Object[]{Integer.valueOf(r101)});     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    public static void b(Notification r100, boolean r101) {
        Bundle r102 = r100.extras;     // Catch: Exception -> L9
        if (r102 == null) goto L5;
        r102.putBoolean("miui.enableKeyguard", r101);     // Catch: Exception -> L9
    L5:
        Object r103 = com.xiaomi.push.av.a(r100, "extraNotification");     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        com.xiaomi.push.av.a(r103, "setEnableKeyguard", new Object[]{Boolean.valueOf(r101)});     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    public static void a(Notification r100, boolean r101) {
        Bundle r102 = r100.extras;     // Catch: Exception -> L9
        if (r102 == null) goto L5;
        r102.putBoolean("miui.enableFloat", r101);     // Catch: Exception -> L9
    L5:
        Object r103 = com.xiaomi.push.av.a(r100, "extraNotification");     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        com.xiaomi.push.av.a(r103, "setEnableFloat", new Object[]{Boolean.valueOf(r101)});     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9356a(Notification r100, String r101) {
        Bundle r102 = r100.extras;     // Catch: Exception -> L9
        if (r102 == null) goto L5;
        r102.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, r101);     // Catch: Exception -> L9
    L5:
        Object r103 = com.xiaomi.push.av.a(r100, "extraNotification");     // Catch: Exception -> L9
        if (r103 == null) goto L12;
        com.xiaomi.push.av.a(r103, "setTargetPkg", new Object[]{r101});     // Catch: Exception -> L9
        return;
    L12:
        return;
    }

    public static boolean a(Notification.Builder r100, boolean r101) {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        com.xiaomi.channel.commonutils.logger.b.b("not support setGroupAlertBehavior");
        return false;
    L5:
        if (r101 == false) goto L7;
        int r102 = 2;
    L8:
        r100.setGroupAlertBehavior(r102);
        return true;
    L7:
        r102 = 1;
        goto L8
    }

    public static <T> T a(Notification r100, String r101) {
        Bundle r102 = r100.extras;
        if (r102 != null) goto L9;
        return null;
    L9:
        return (T) r102.get(r101);
    L11:
        return null;
    }

    public static int a(Context r100, String r101) {
        return com.xiaomi.push.g.b(r100, r101);
    }

    public static void a(Context r100, String r101, Intent r102) {
        if (r102 != null) goto L4;
        return;
    L4:
        ArrayList r103 = new ArrayList();
        if (TextUtils.isEmpty(r101) == true) goto L7;
        r103.add(r101);
    L7:
        r103.addAll(Arrays.asList(f1040a));
        int r104 = r103.size();
        int r105 = 0;
    L8:
        if (r105 >= r104) goto L19;
        String r106 = (String) ListProtector.get(r103, r105);
        if (TextUtils.isEmpty(r106) == true) goto L18;
        Intent r107 = new Intent(r102);
        r107.setPackage(r106);
    L16:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("can't match url intent. " + e);
        goto L18
    L13:
        if (r100.getPackageManager().resolveActivity(r107, 65536) == null) goto L18;
        r102.setPackage(r106);     // Catch: Exception -> L16
    L18:
        r105 = r105 + 1;
    L19:
        r102.setPackage(r102.getPackage());
    }

    public static <T> T a(Object r100, String r101, T r102) {
        Object r103 = null;
    L15:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("get value error " + e);
    L17:
        if (r103 != null) goto L20;
        return r102;
    L20:
        return (T) r103;
    L4:
        if ((r100 instanceof Notification) == false) goto L8;
        Object r104 = a((Notification) r100, r101);     // Catch: Exception -> L15
    L6:
        r103 = r104;
        goto L17
    L8:
        if ((r100 instanceof Map) == false) goto L11;
        r104 = ((Map) r100).get(r101);     // Catch: Exception -> L15
        goto L6
    L11:
        if ((r100 instanceof Bundle) == false) goto L13;
        r104 = ((Bundle) r100).get(r101);     // Catch: Exception -> L15
        goto L6
    L13:
        com.xiaomi.channel.commonutils.logger.b.m8718a("not support get value from classType:" + r100);     // Catch: Exception -> L15
        goto L17
    }

    public static void a(Map<String, String> r100, Bundle r101, String r102) {
        if (r100 == null) goto L12;
        if (r101 == null) goto L12;
        if (TextUtils.isEmpty(r102) == true) goto L12;
        if (TextUtils.isEmpty(r100.get(r102)) == false) goto L10;
        r101.remove(r102);
        return;
    L10:
        r101.putString(r102, r100.get(r102));
        return;
    L12:
        com.xiaomi.channel.commonutils.logger.b.m8718a("cp map to b fail:" + r102);
    }

    public static void a(Notification r100, int r101, int r102) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (r100.extras != null) goto L6;
        r100.extras = new Bundle();
    L6:
        r100.extras.putInt("is_priority", r101);
        r100.extras.putInt("mipush_class", r102);
    }

    public static Bundle a(Context r100, String r101, String r102) {
        return a(r100, f464196a.f464205b, r101, r102, null);
    L5:
        return null;
    }

    public static int a(Context r100, String r101, String r102, a<String, String, String> r103) {
        if (r103 != null) goto L12;
        return -1;
    L12:
        Bundle r104 = a(r100, r103.f464205b, r101, r102, null);     // Catch: Exception -> L11
        if (r104 != null) goto L6;
        return -1;
    L6:
        if (r104.containsKey(r103.f464206c) == false) goto L15;
        return r104.getBoolean(r103.f464206c) ? 1 : 0;
    L15:
        return -1;
    L16:
        return -1;
    }

    private static Bundle a(Context r100, String r101, String r102, String r103, Bundle r104) {
        if (r100 == null) goto L15;
        if (TextUtils.isEmpty(r101) == true) goto L15;
        if (TextUtils.isEmpty(r102) == true) goto L15;
        Bundle r105 = new Bundle();
        r105.putString("package", r102);
        if (TextUtils.isEmpty(r103) == true) goto L10;
        r105.putString("channel_id", r103);
    L10:
        if (r104 == null) goto L13;
        r105.putAll(r104);
    L13:
        return r100.getContentResolver().call(UriProtector.parse("content://statusbar.notification"), r101, null, r105);
    L15:
        throw new IllegalArgumentException("call notification provider failed!");
    }

    public static boolean a(Context r100, String r101, String r102, a<String, String, String> r103, boolean r104) {
        if (r103 != null) goto L8;
    L5:
        return false;
    L8:
        Bundle r105 = new Bundle();     // Catch: Exception -> L7
        r105.putBoolean(r103.f464206c, r104);     // Catch: Exception -> L7
        a(r100, r103.f464204a, r101, r102, r105);     // Catch: Exception -> L7
        return true;
    }
}
