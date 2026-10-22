package com.xiaomi.push.service;

import android.app.Notification;
import android.app.PendingIntent;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import android.util.DisplayMetrics;
import android.util.Pair;
import android.widget.RemoteViews;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.bytedance.mt.protector.impl.JSONObjectProtectorUtils;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.huawei.hms.push.constant.RemoteMessageConst;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.huawei.hms.support.hianalytics.HiAnalyticsConstant;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.ss.android.ugc.bytex.pthread.base.PThreadExecutorsUtils;
import com.ss.android.ugc.bytex.thread_rename.base.DefaultThreadFactory;
import com.xiaomi.push.ds;
import com.xiaomi.push.dt;
import com.xiaomi.push.du;
import com.xiaomi.push.dv;
import com.xiaomi.push.ge;
import com.xiaomi.push.gr;
import com.xiaomi.push.ha;
import java.net.MalformedURLException;
import java.net.URISyntaxException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;
import org.json.JSONException;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes41.dex */
public class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static long f464358a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static volatile ab f1143a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static final LinkedList<Pair<Integer, ha>> f1144a = null;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private static ExecutorService f1145a;

    public static class a implements Callable<Bitmap> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        private Context f464360a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private String f1148a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        private boolean f1149a;

        public Bitmap a() {
            if (TextUtils.isEmpty(this.f1148a) == false) goto L5;
            com.xiaomi.channel.commonutils.logger.b.m8718a("Failed get online picture/icon resource cause picUrl is empty");
            return null;
        L5:
            if (this.f1148a.startsWith("http") == false) goto L10;
            ae.b r100 = ae.a(this.f464360a, this.f1148a, this.f1149a);
            if (r100 != null) goto L15;
            com.xiaomi.channel.commonutils.logger.b.m8718a("Failed get online picture/icon resource");
            return null;
        L15:
            return r100.f1033a;
        L10:
            Bitmap r101 = ae.a(this.f464360a, this.f1148a);
            if (r101 != null) goto L17;
            com.xiaomi.channel.commonutils.logger.b.m8718a("Failed get online picture/icon resource");
            return r101;
        L17:
            return r101;
        }

        @Override // java.util.concurrent.Callable
        public /* synthetic */ Bitmap call() {
            return a();
        }

        public a(String r100, Context r101, boolean r102) {
            this.f464360a = r101;
            this.f1148a = r100;
            this.f1149a = r102;
        }
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        long f464361a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Notification f1150a;

        public b() {
            this.f464361a = 0;
        }
    }

    public static class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public long f464362a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public String f1151a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        public boolean f1152a;

        public c() {
            this.f464362a = 0;
            this.f1152a = false;
        }
    }

    static {
        f1144a = new LinkedList();
        f1145a = PThreadExecutorsUtils.newCachedThreadPool(new DefaultThreadFactory("ush/service/x"));
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_xiaomi_push_service_x_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    public static Bitmap a(Drawable r100) {
        if ((r100 instanceof BitmapDrawable) == true) goto L5;
        int r101 = r100.getIntrinsicWidth();
        int r102 = 1;
        if (r101 > 0) goto L10;
        r101 = 1;
    L10:
        int r103 = r100.getIntrinsicHeight();
        if (r103 <= 0) goto L13;
        r102 = r103;
    L13:
        Bitmap r104 = Bitmap.createBitmap(r101, r102, Bitmap.Config.ARGB_8888);
        Canvas r105 = new Canvas(r104);
        r100.setBounds(0, 0, r105.getWidth(), r105.getHeight());
        r100.draw(r105);
        return r104;
    L5:
        return ((BitmapDrawable) r100).getBitmap();
    }

    private static int b(Map<String, String> r100) {
        if (r100 == null) goto L13;
        String r101 = r100.get("channel_importance");
        if (TextUtils.isEmpty(r101) == true) goto L14;
        com.xiaomi.channel.commonutils.logger.b.c("importance=" + r101);     // Catch: Exception -> L8
        return CastIntegerProtector.parseInt(r101);
    L8:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("parsing channel importance error: " + e);
        return 3;
    L14:
        return 3;
    L13:
        return 3;
    }

    private static int c(Map<String, String> r100) {
        if (r100 == null) goto L13;
        String r101 = r100.get("notification_priority");
        if (TextUtils.isEmpty(r101) == true) goto L14;
        com.xiaomi.channel.commonutils.logger.b.c("priority=" + r101);     // Catch: Exception -> L8
        return CastIntegerProtector.parseInt(r101);
    L8:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("parsing notification priority error: " + e);
        return 0;
    L14:
        return 0;
    L13:
        return 0;
    }

    public static boolean d(ha r100) {
        if (r100.a() != ge.f463646a) goto L5;
        return true;
    L5:
        return false;
    }

    public static boolean e(ha r100) {
        if (m9425a(r100) == false) goto L5;
    L10:
        return true;
    L5:
        if (c(r100) == true) goto L10;
        if (m9429b(r100) == true) goto L10;
        return false;
    }

    public static String a(ha r100) {
        if ("com.xiaomi.xmsf".equals(r100.f777b) == false) goto L12;
        gr r101 = r100.m9197a();
        if (r101 == null) goto L12;
        if (r101.m9164a() == null) goto L12;
        String r102 = r101.m9164a().get("miui_package_name");
        if (TextUtils.isEmpty(r102) == true) goto L12;
        return r102;
    L12:
        return r100.f777b;
    }

    public static String b(ha r100) {
        if (m9425a(r100) == false) goto L7;
        return "E100002";
    L7:
        if (c(r100) == false) goto L11;
        return "E100000";
    L11:
        if (m9429b(r100) == false) goto L15;
        return "E100001";
    L15:
        if (d(r100) == false) goto L18;
        return "E100003";
    L18:
        return "";
    }

    public static boolean c(ha r100) {
        gr r101 = r100.m9197a();
        if (a(r101) == true) goto L5;
    L9:
        return false;
    L5:
        if (r101.f687b != 0) goto L9;
        if (m9425a(r100) == true) goto L9;
        return true;
    }

    private static boolean a(gr r100) {
        if (r100 == null) goto L12;
        String r101 = r100.m9163a();
        if (TextUtils.isEmpty(r101) == false) goto L7;
        return false;
    L7:
        if (r101.length() == 22) goto L9;
        return false;
    L9:
        if ("satuigmo".indexOf(r101.charAt(0)) < 0) goto L15;
        return true;
    L15:
        return false;
    L12:
        return false;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m9429b(ha r100) {
        gr r101 = r100.m9197a();
        if (a(r101) == true) goto L5;
    L9:
        return false;
    L5:
        if (r101.f687b != 1) goto L9;
        if (m9425a(r100) == true) goto L9;
        return true;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9426a(Map<String, String> r100) {
        if (r100 != null) goto L4;
        return true;
    L4:
        if (r100.containsKey("notify_foreground") == true) goto L7;
        return true;
    L7:
        return "1".equals(r100.get("notify_foreground"));
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private static boolean m9430b(Map<String, String> r100) {
        if (r100 != null) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("meta extra is null");
        return false;
    L6:
        return "6".equals(r100.get("notification_style_type"));
    }

    private static int a(Map<String, String> r100) {
        if (r100 != null) goto L4;
        String r101 = null;
    L6:
        if (TextUtils.isEmpty(r101) == true) goto L12;
        return CastIntegerProtector.parseInt(r101);
    L13:
        return 0;
    L12:
        return 0;
    L4:
        r101 = r100.get("timeout");
        goto L6
    }

    private static Notification a(Notification r100) {
        Object r101 = com.xiaomi.push.av.a(r100, "extraNotification");
        if (r101 == null) goto L5;
        com.xiaomi.push.av.a(r101, "setCustomizedIcon", new Object[]{Boolean.TRUE});
    L5:
        return r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9425a(ha r100) {
        gr r101 = r100.m9197a();
        if (a(r101) == true) goto L5;
    L7:
        return false;
    L5:
        if (r101.l() == false) goto L7;
        return true;
    }

    private static void a(Intent r100) {
        if (r100 != null) goto L4;
        return;
    L4:
        r100.setFlags((((r100.getFlags() & (-2)) & (-3)) & (-65)) & (-129));
    }

    public static ComponentName a(String r100) {
        return new ComponentName(r100, "com.xiaomi.mipush.sdk.NotificationClickedActivity");
    }

    private static String[] a(Context r100, gr r101) {
        String r102 = r101.m9171c();
        String r103 = r101.d();
        Map<String, String> r104 = r101.m9164a();
        if (r104 == null) goto L21;
        int r105 = Float.valueOf((INVOKEVIRTUAL_com_xiaomi_push_service_x_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).widthPixels / INVOKEVIRTUAL_com_xiaomi_push_service_x_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r100.getResources()).density) + 0.5f).intValue();
        if (r105 > 320) goto L13;
        String r106 = r104.get("title_short");
        if (TextUtils.isEmpty(r106) == true) goto L9;
        r102 = r106;
    L9:
        String r107 = r104.get("description_short");
        if (TextUtils.isEmpty(r107) == true) goto L21;
    L19:
        r103 = r107;
        goto L21
    L13:
        if (r105 <= 360) goto L21;
        String r108 = r104.get("title_long");
        if (TextUtils.isEmpty(r108) == true) goto L17;
        r102 = r108;
    L17:
        r107 = r104.get("description_long");
        if (TextUtils.isEmpty(r107) == false) goto L19;
    L21:
        return new String[]{r102, r103};
    }

    private static int b(Context r100, String r101) {
        int r102 = a(r100, r101, "mipush_notification");
        int r103 = a(r100, r101, "mipush_small_notification");
        if (r102 > 0) goto L8;
        if (r103 <= 0) goto L7;
        r102 = r103;
        goto L8
    L7:
        r102 = r100.getApplicationInfo().icon;
    L8:
        if (r102 == 0) goto L10;
        return r102;
    L10:
        return r100.getApplicationInfo().logo;
    }

    public static void c(Context r100, String r101) {
        r100.getSharedPreferences("pref_notify_type", 0).edit().remove(r101).commit();
    }

    public static String a(Map<String, String> r100, int r101) {
        if (r101 != 0) goto L6;
        String r102 = "notify_effect";
    L20:
        if (r100 == null) goto L24;
        if (r102 != null) goto L23;
        return null;
    L23:
        return r100.get(r102);
    L24:
        return null;
    L6:
        if (m9430b(r100) == false) goto L8;
        r102 = String.format("cust_btn_%s_ne", new Object[]{Integer.valueOf(r101)});
        goto L20
    L8:
        if (r101 != 1) goto L11;
        r102 = "notification_style_button_left_notify_effect";
        goto L20
    L11:
        if (r101 != 2) goto L14;
        r102 = "notification_style_button_mid_notify_effect";
        goto L20
    L14:
        if (r101 != 3) goto L17;
        r102 = "notification_style_button_right_notify_effect";
        goto L20
    L17:
        if (r101 != 4) goto L19;
        r102 = "notification_colorful_button_notify_effect";
        goto L20
    L19:
        r102 = null;
        goto L20
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static void m9427b(Context r100, String r101) {
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L5;
        return;
    L5:
        if (f1143a != null) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r101) == true) goto L13;
        f1143a.a(r101);
        return;
    }

    public static void a(Context r100, LinkedList<? extends Object> r101) {
        if (r101 != null) goto L4;
        return;
    L4:
        if (r101.size() <= 0) goto L8;
        az.a(r100, "category_clear_notification", "clear_notification", r101.size(), "");
        return;
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    public static boolean m9428b(Context r100, String r101) {
        return r100.getSharedPreferences("pref_notify_type", 0).contains(r101);
    }

    private static boolean a(String r100, String r101) {
        if (TextUtils.isEmpty(r100) == false) goto L5;
    L8:
        return true;
    L5:
        if (r101.contains(r100) == true) goto L8;
        return false;
    }

    public static int a(Context r100, String r101) {
        return r100.getSharedPreferences("pref_notify_type", 0).getInt(r101, Integer.MAX_VALUE);
    }

    private static Bitmap a(Context r100, int r101) {
        return a(r100.getResources().getDrawable(r101));
    }

    private static String a(Map<String, String> r100, String r101) {
        if (r100 != null) goto L6;
        return null;
    L6:
        return r100.get(r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9422a(Context r100, String r101) {
        a(r100, r101, -1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9423a(Context r100, String r101) {
        return com.xiaomi.push.g.m9125b(r100, r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static c m9421a(Context r210, ha r211, byte[] r212) {
        c r100 = new c();
        com.xiaomi.push.g.b r101 = com.xiaomi.push.g.a(r210, a(r211), true);
        gr r110 = r211.m9197a();
        String r111 = null;
        if (r110 == null) goto L5;
        int r102 = r110.c();
        Map<String, String> r112 = r110.m9164a();
    L6:
        final int r113 = com.xiaomi.push.r.b(a(r211), r102);
        if (com.xiaomi.push.j.m9295a(r210) == false) goto L15;
        if (r101 != com.xiaomi.push.g.b.f463641c) goto L15;
        if (r110 == null) goto L12;
        ds.a(r210.getApplicationContext()).a(r211.b(), b(r211), r110.m9163a(), "10:" + a(r211));
    L12:
        com.xiaomi.channel.commonutils.logger.b.m8718a("Do not notify because user block " + a(r211) + "‘s notification");
        return r100;
    L15:
        if (com.xiaomi.push.j.m9295a(r210) == true) goto L17;
    L24:
        RemoteViews r103 = a(r210, r211, r212);
        PendingIntent r104 = a(r210, r211, r211.b(), r212, r113);
        if (r104 != null) goto L30;
        if (r110 == null) goto L28;
        ds.a(r210.getApplicationContext()).a(r211.b(), b(r211), r110.m9163a(), "11");
    L28:
        com.xiaomi.channel.commonutils.logger.b.m8718a("The click PendingIntent is null. ");
        return r100;
    L30:
        b r105 = a(r210, r211, r212, r103, r104, r113);
        r100.f464362a = r105.f464361a;
        r100.f1151a = a(r211);
        Notification r106 = r105.f1150a;
        if (com.xiaomi.push.j.m9294a() == false) goto L51;
        if (TextUtils.isEmpty(r110.m9163a()) == true) goto L35;
        r106.extras.putString(MusicAppletPage.KEY_MESSAGE_ID, r110.m9163a());
    L35:
        r106.extras.putString("local_paid", r211.m9198a());
        ag.a(r112, r106.extras, "msg_busi_type");
        ag.a(r112, r106.extras, "disable_notification_flags");
        if (r110.m9169b() != null) goto L38;
        String r107 = null;
    L40:
        if (TextUtils.isEmpty(r107) == true) goto L42;
        r106.extras.putString("score_info", r107);
    L42:
        r106.extras.putString("pushUid", a(r110.f685a, "n_stats_expose"));
        if (c(r211) == false) goto L46;
        int r108 = 1000;
    L49:
        r106.extras.putString("eventMessageType", String.valueOf(r108));
        r106.extras.putString(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, a(r211));
        goto L51
    L46:
        if (m9425a(r211) == false) goto L48;
        r108 = 3000;
        goto L49
    L48:
        r108 = -1;
        goto L49
    L38:
        r107 = r110.m9169b().get("score_info");
    L51:
        if (r110.m9164a() == null) goto L55;
        r111 = r110.m9164a().get("message_count");
    L55:
        if (com.xiaomi.push.j.m9294a() == false) goto L61;
        if (r111 == null) goto L61;
        ag.a(r106, CastIntegerProtector.parseInt(r111));     // Catch: NumberFormatException -> L59
    L59:
        e = move-exception;
        ds.a(r210.getApplicationContext()).b(r211.b(), b(r211), r110.m9163a(), "8");
        com.xiaomi.channel.commonutils.logger.b.d("fail to set message count. " + e);
    L61:
        String r109 = a(r211);
        ag.m9356a(r106, r109);
        final af r114 = af.a(r210, r109);
        if (com.xiaomi.push.j.m9295a(r210) == false) goto L67;
        if (f1143a == null) goto L67;
        f1143a.a(r211, r110.m9164a(), r113, r106);
    L67:
        if (com.xiaomi.push.j.m9295a(r210) == true) goto L69;
    L73:
        r114.a(r113, r106);
        r100.f1152a = true;
        com.xiaomi.channel.commonutils.logger.b.m8718a("notification: " + r110.m9163a() + " is notifyied");
    L75:
        if (com.xiaomi.push.j.m9294a() == false) goto L80;
        if (com.xiaomi.push.j.m9295a(r210) == false) goto L80;
        ad.a().a(r210, r113, r106);
        bb.m9381a(r210, r109, r113, r110.m9163a(), r106);
    L80:
        if (m9425a(r211) == false) goto L83;
        ds.a(r210.getApplicationContext()).a(r211.b(), b(r211), r110.m9163a(), 3002, null);
    L83:
        if (c(r211) == false) goto L86;
        ds.a(r210.getApplicationContext()).a(r211.b(), b(r211), r110.m9163a(), 1002, null);
    L86:
        if (Build.VERSION.SDK_INT >= 26) goto L92;
        String r115 = r110.m9163a();
        com.xiaomi.push.ad r116 = com.xiaomi.push.ad.a(r210);
        int r117 = a(r110.m9164a());
        if (r117 <= 0) goto L92;
        if (TextUtils.isEmpty(r115) == true) goto L92;
        final String r118 = "n_timeout_" + r115;
        r116.m8799a(r118);
        r116.b(new AnonymousClass1(r118, r114, r113), r117);
    L92:
        Pair<Integer, ha> r119 = new Pair(Integer.valueOf(r113), r211);
        LinkedList<Pair<Integer, ha>> r120 = f1144a;
        monitor-enter(r120);
        r120.add(r119);     // Catch: Throwable -> L99
        if (r120.size() <= 100) goto L97;
        r120.remove();     // Catch: Throwable -> L99
    L97:
        monitor-exit(r120);     // Catch: Throwable -> L99
        return r100;
    L99:
        th = move-exception;
        throw th;
    L69:
        if (f1143a == null) goto L73;
        if (f1143a.a(r110.m9164a(), r113, r106) == false) goto L73;
        com.xiaomi.channel.commonutils.logger.b.b("consume this notificaiton by agent");
        goto L75
    L17:
        if (f1143a == null) goto L24;
        if (f1143a.m9338a(r210, r113, a(r211), r112) == false) goto L24;
        if (r110 == null) goto L22;
        ds.a(r210.getApplicationContext()).a(r211.b(), b(r211), r110.m9163a(), "14:" + a(r211));
    L22:
        com.xiaomi.channel.commonutils.logger.b.m8718a("Do not notify because card notification is canceled or sequence incorrect");
        return r100;
    L5:
        r102 = 0;
        r112 = null;
        goto L6
    }

    public static void b(Context r100, String r101, int r102) {
        r100.getSharedPreferences("pref_notify_type", 0).edit().putInt(r101, r102).commit();
    }

    private static RemoteViews a(Context r100, ha r110, byte[] r111) {
        gr r101 = r110.m9197a();
        String r112 = a(r110);
        if (r101 != null) goto L5;
    L53:
        return null;
    L5:
        if (r101.m9164a() == null) goto L53;
        Map<String, String> r102 = r101.m9164a();
        String r103 = r102.get("layout_name");
        String r104 = r102.get("layout_value");
        if (TextUtils.isEmpty(r103) == true) goto L53;
        if (TextUtils.isEmpty(r104) == true) goto L53;
        Resources r105 = r100.getPackageManager().getResourcesForApplication(r112);     // Catch: PackageManager.NameNotFoundException -> L51
        int r106 = r105.getIdentifier(r103, "layout", r112);
        if (r106 != 0) goto L17;
        return null;
    L17:
        RemoteViews r107 = new RemoteViews(r112, r106);
        JSONObject r108 = new JSONObject(r104);     // Catch: JSONException -> L48
        if (r108.has("text") == false) goto L28;
        JSONObject r109 = JSONObjectProtectorUtils.getJSONObject(r108, "text");     // Catch: JSONException -> L48
        Iterator<String> r113 = r109.keys();     // Catch: JSONException -> L48
    L23:
        if (r113.hasNext() == false) goto L28;
        String r114 = r113.next();     // Catch: JSONException -> L48
        String r115 = JSONObjectProtectorUtils.getString(r109, r114);     // Catch: JSONException -> L48
        int r116 = r105.getIdentifier(r114, "id", r112);     // Catch: JSONException -> L48
        if (r116 <= 0) goto L23;
        r107.setTextViewText(r116, r115);     // Catch: JSONException -> L48
    L28:
        if (r108.has("image") == false) goto L36;
        JSONObject r117 = JSONObjectProtectorUtils.getJSONObject(r108, "image");     // Catch: JSONException -> L48
        Iterator<String> r118 = r117.keys();     // Catch: JSONException -> L48
    L31:
        if (r118.hasNext() == false) goto L36;
        String r119 = r118.next();     // Catch: JSONException -> L48
        String r120 = JSONObjectProtectorUtils.getString(r117, r119);     // Catch: JSONException -> L48
        int r121 = r105.getIdentifier(r119, "id", r112);     // Catch: JSONException -> L48
        int r122 = r105.getIdentifier(r120, "drawable", r112);     // Catch: JSONException -> L48
        if (r121 <= 0) goto L31;
        r107.setImageViewResource(r121, r122);     // Catch: JSONException -> L48
    L36:
        if (r108.has("time") == false) goto L47;
        JSONObject r123 = JSONObjectProtectorUtils.getJSONObject(r108, "time");     // Catch: JSONException -> L48
        Iterator<String> r124 = r123.keys();     // Catch: JSONException -> L48
    L38:
        if (r124.hasNext() == false) goto L47;
        String r125 = r124.next();     // Catch: JSONException -> L48
        String r126 = JSONObjectProtectorUtils.getString(r123, r125);     // Catch: JSONException -> L48
        if (r126.length() != 0) goto L43;
        r126 = "yy-MM-dd hh:mm";
    L43:
        int r127 = r105.getIdentifier(r125, "id", r112);     // Catch: JSONException -> L48
        if (r127 <= 0) goto L38;
        long r128 = System.currentTimeMillis();     // Catch: JSONException -> L48
        r107.setTextViewText(r127, new SimpleDateFormat(r126).format(new Date(r128)));     // Catch: JSONException -> L48
    L47:
        return r107;
    L48:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        return null;
    L51:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L53
    }

    private static boolean a(Context r100, ha r101, String r102) {
        if (r101 != null) goto L5;
    L17:
        com.xiaomi.channel.commonutils.logger.b.m8718a("should clicked activity params are null.");
        return false;
    L5:
        if (r101.m9197a() == null) goto L17;
        if (r101.m9197a().m9164a() == null) goto L17;
        if (TextUtils.isEmpty(r102) == true) goto L17;
        if (Boolean.parseBoolean(r101.m9197a().m9164a().get("use_clicked_activity")) == true) goto L14;
        return false;
    L14:
        if (j.a(r100, a(r102)) == false) goto L20;
        return true;
    L20:
        return false;
    }

    private static Bitmap a(Context r100, String r101, boolean r102) {
        Future r103 = f1145a.submit(new a(r101, r100, r102));
        Bitmap r104 = (Bitmap) r103.get(180, TimeUnit.SECONDS);     // Catch: Throwable -> L6 TimeoutException -> L8 ExecutionException -> L10 InterruptedException -> L12
        if (r104 != null) goto L20;
        r103.cancel(true);
        return r104;
    L20:
        return r104;
    L6:
        th = move-exception;
        r103.cancel(true);
        throw th;
    L10:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L6
    L14:
        r103.cancel(true);
        return null;
    L12:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L6
    L8:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);     // Catch: Throwable -> L6
        goto L14
    }

    private static String a(Context r100, String r101, Map<String, String> r102) {
        if (r102 == null) goto L8;
        if (TextUtils.isEmpty(r102.get(OpenFeedConstantKt.KEY_CHANNEL_NAME)) == true) goto L8;
        return r102.get(OpenFeedConstantKt.KEY_CHANNEL_NAME);
    L8:
        return com.xiaomi.push.g.m9124b(r100, r101);
    }

    private static int a(Context r100, String r101, String r102) {
        if (r101.equals(r100.getPackageName()) == true) goto L5;
        return 0;
    L5:
        return r100.getResources().getIdentifier(r102, "drawable", r101);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static boolean m9424a(Context r100, String r101, boolean r102) {
        if (com.xiaomi.push.j.m9294a() == true) goto L5;
        return false;
    L5:
        if (r102 == false) goto L7;
        return false;
    L7:
        if (m9423a(r100, r101) == false) goto L11;
        return true;
    L11:
        return false;
    }

    public static void a(Context r100, String r101, int r102) {
        a(r100, r101, r102, -1);
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static Intent m9420a(Context r110, String r111, Map<String, String> r112, int r113) {
        if (m9430b(r112) == true) goto L5;
        if (r113 == 1) goto L22;
        if (r113 == 2) goto L20;
        if (r113 == 3) goto L18;
        if (r113 == 4) goto L16;
        return null;
    L16:
        return a(r110, r111, r112, "notification_colorful_button_notify_effect", "notification_colorful_button_intent_uri", "notification_colorful_button_intent_class", "notification_colorful_button_web_uri");
    L18:
        return a(r110, r111, r112, "notification_style_button_right_notify_effect", "notification_style_button_right_intent_uri", "notification_style_button_right_intent_class", "notification_style_button_right_web_uri");
    L20:
        return a(r110, r111, r112, "notification_style_button_mid_notify_effect", "notification_style_button_mid_intent_uri", "notification_style_button_mid_intent_class", "notification_style_button_mid_web_uri");
    L22:
        return a(r110, r111, r112, "notification_style_button_left_notify_effect", "notification_style_button_left_intent_uri", "notification_style_button_left_intent_class", "notification_style_button_left_web_uri");
    L5:
        return a(r110, r111, r112, String.format("cust_btn_%s_ne", new Object[]{Integer.valueOf(r113)}), String.format("cust_btn_%s_iu", new Object[]{Integer.valueOf(r113)}), String.format("cust_btn_%s_ic", new Object[]{Integer.valueOf(r113)}), String.format("cust_btn_%s_wu", new Object[]{Integer.valueOf(r113)}));
    }

    public static Intent b(Context r100, String r101, Map<String, String> r102, int r103) {
        if (r102 != null) goto L5;
        return null;
    L5:
        if (r103 == 0) goto L9;
        return m9420a(r100, r101, r102, r103);
    L9:
        if (r102.containsKey("notify_effect") == true) goto L11;
        return null;
    L11:
        String r104 = r102.get("notify_effect");
        String r105 = r102.get("intent_flag");
        int r106 = -1;
    L16:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Cause by intent_flag: " + e.getMessage());
    L19:
        if (an.f464236a.equals(r104) == false) goto L25;
        Intent r107 = r100.getPackageManager().getLaunchIntentForPackage(r101);     // Catch: Exception -> L22
    L66:
        if (r107 == null) goto L84;
        if (r106 < 0) goto L69;
        r107.setFlags(r106);
    L69:
        a(r107);
        r107.addFlags(268435456);
    L82:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
        goto L84
    L71:
        if (r100.getPackageManager().resolveActivity(r107, 65536) == null) goto L74;
        return r107;
    L74:
        if (Build.VERSION.SDK_INT >= 30) goto L76;
    L80:
        com.xiaomi.channel.commonutils.logger.b.m8718a("not resolve activity:" + r107);     // Catch: Exception -> L82
        goto L84
    L76:
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L80;
        if (an.f464238c.equals(r104) == false) goto L80;
        return r107;
    L84:
        return null;
    L22:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
    L65:
        r107 = null;
        goto L66
    L25:
        if (an.f464237b.equals(r104) == false) goto L45;
        if (r102.containsKey("intent_uri") == false) goto L41;
        String r108 = r102.get("intent_uri");
        if (r108 == null) goto L65;
        Intent r109 = Intent.parseUri(r108, 1);     // Catch: URISyntaxException -> L36
        r109.setPackage(r101);     // Catch: URISyntaxException -> L34
    L39:
        r107 = r109;
    L34:
        e = e;
    L38:
        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
    L36:
        e = e;
        r109 = null;
        goto L38
    L41:
        if (r102.containsKey("class_name") == false) goto L65;
        String r110 = r102.get("class_name");
        Intent r111 = new Intent();
        r111.setComponent(new ComponentName(r101, r110));
    L43:
        r107 = r111;
        goto L66
    L45:
        if (an.f464238c.equals(r104) == false) goto L65;
        String r112 = r102.get("web_uri");
        if (r112 == null) goto L65;
        String r113 = r112.trim();
        if (r113.startsWith("http://") == false) goto L51;
    L93:
        String r114 = new URL(r113).getProtocol();     // Catch: MalformedURLException -> L62
        if ("http".equals(r114) == false) goto L56;
    L57:
        r111 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: MalformedURLException -> L62
        r111.setData(UriProtector.parse(r113));     // Catch: MalformedURLException -> L60
        ag.a(r100, r101, r111);     // Catch: MalformedURLException -> L60
    L60:
        e = e;
    L64:
        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
        goto L43
    L56:
        if ("https".equals(r114) == false) goto L65;
    L62:
        e = e;
        r111 = null;
        goto L64
    L51:
        if (r113.startsWith("https://") == true) goto L93;
        r113 = "http://".concat(r113);
        goto L93
    L13:
        if (TextUtils.isEmpty(r105) == true) goto L19;
        r106 = CastIntegerProtector.parseInt(r105);     // Catch: NumberFormatException -> L16
        goto L19
    }

    public static void a(Context r100, String r101, String r102, String r110) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (TextUtils.isEmpty(r102) == false) goto L8;
        return;
    L8:
        if (TextUtils.isEmpty(r110) == true) goto L50;
        af r103 = af.a(r100, r101);
        List<StatusBarNotification> r104 = r103.m9355b();
        if (com.xiaomi.push.r.a(r104) == false) goto L13;
        return;
    L13:
        LinkedList r105 = new LinkedList();
        Iterator<StatusBarNotification> r106 = r104.iterator();
    L15:
        if (r106.hasNext() == false) goto L30;
        StatusBarNotification r107 = r106.next();
        Notification r108 = r107.getNotification();
        if (r108 == null) goto L15;
        if (TextUtils.isEmpty(String.valueOf(r107.getId())) == true) goto L15;
        int r109 = r107.getId();
        String r111 = ag.a(r108);
        String r112 = ag.b(r108);
        if (TextUtils.isEmpty(r111) == true) goto L15;
        if (TextUtils.isEmpty(r112) == true) goto L15;
        if (a(r111, r102) == false) goto L15;
        if (a(r112, r110) == false) goto L15;
        r105.add(r107);
        r103.a(r109);
        goto L15
    L30:
        a(r100, r105);
        return;
    }

    private static void b(Context r100, String r101, du r102, Map<String, String> r103) {
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L11;
        String r104 = a(r103, "fcm_icon_uri");
        String r105 = a(r103, "fcm_icon_color");
        if (TextUtils.isEmpty(r104) == true) goto L11;
        if (TextUtils.isEmpty(r105) == true) goto L11;
        int r106 = a(r100, r101, r104);
        if (r106 <= 0) goto L11;
        r102.setSmallIcon(r106);
        r102.mo9030a(r105);
        boolean r107 = true;
    L12:
        if (r107 == false) goto L14;
        return;
    L14:
        if (Build.VERSION.SDK_INT < 23) goto L16;
        r102.setSmallIcon(Icon.createWithResource(r101, ag.a(r100, r101)));
        return;
    L16:
        r102.setSmallIcon(b(r100, r101));
        return;
    L11:
        r107 = false;
        goto L12
    }

    public static void a(Context r100, String r101, int r102, int r103) {
        if (r100 != null) goto L4;
        return;
    L4:
        if (TextUtils.isEmpty(r101) == false) goto L6;
        return;
    L6:
        if (r102 < (-1)) goto L38;
        af r104 = af.a(r100, r101);
        List<StatusBarNotification> r105 = r104.m9355b();
        if (com.xiaomi.push.r.a(r105) == false) goto L11;
        return;
    L11:
        LinkedList r106 = new LinkedList();
        boolean r107 = false;
        if (r102 != (-1)) goto L14;
        int r108 = 0;
        r107 = true;
    L15:
        Iterator<StatusBarNotification> r109 = r105.iterator();
    L17:
        if (r109.hasNext() == false) goto L25;
        StatusBarNotification r110 = r109.next();
        if (TextUtils.isEmpty(String.valueOf(r110.getId())) == true) goto L17;
        int r111 = r110.getId();
        if (r107 == true) goto L22;
        if (r108 != r111) goto L17;
        d.a(r100, r110, r103);
        r106.add(r110);
        r104.a(r111);
        goto L25
    L22:
        r106.add(r110);
        r104.a(r111);
    L25:
        a(r100, r106);
        return;
    L14:
        r108 = ((r101.hashCode() / 10) * 10) + r102;
        goto L15
    }

    private static void a(Context r100, String r101, du r102, Map<String, String> r103) {
        int r104 = a(r100, r101, "mipush_small_notification");
        int r105 = a(r100, r101, "mipush_notification");
        if (com.xiaomi.push.j.m9295a(r100) == false) goto L8;
        if (r104 <= 0) goto L7;
        if (r105 <= 0) goto L7;
        r102.setSmallIcon(r104);
        r102.setLargeIcon(a(r100, r105));
        return;
    L7:
        b(r100, r101, r102, r103);
        return;
    L8:
        if (r104 <= 0) goto L10;
        r102.setSmallIcon(r104);
    L11:
        if (r105 <= 0) goto L16;
        r102.setLargeIcon(a(r100, r105));
        return;
    L16:
        return;
    L10:
        b(r100, r101, r102, r103);
        goto L11
    }

    private static int a(Context r100, String r101, Map<String, String> r102, int r103) {
        Intent r104 = b(r100, r101, r102, r103);
        if (r104 == null) goto L8;
        ComponentName r105 = j.a(r100, r104);
        if (r105 != null) goto L7;
        return 0;
    L7:
        return r105.hashCode();
    L8:
        return 0;
    }

    private static du a(Context r100, ha r110, byte[] r111, String r112, int r113) {
        String r101 = a(r110);
        Map<String, String> r102 = r110.m9197a().m9164a();
        String r103 = r102.get("notification_style_type");
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L5;
    L7:
        du r104 = null;
    L8:
        if (r104 == null) goto L11;
        r104.a(r102);
        return r104;
    L11:
        if ("2".equals(r103) == false) goto L21;
        du r105 = new du(r100);
        if (TextUtils.isEmpty(r102.get("notification_bigPic_uri")) == false) goto L15;
        Bitmap r106 = null;
    L16:
        if (r106 != null) goto L19;
        com.xiaomi.channel.commonutils.logger.b.m8718a("can not get big picture.");
        return r105;
    L19:
        Notification.BigPictureStyle r114 = new Notification.BigPictureStyle(r105);
        r114.bigPicture(r106);
        r114.setSummaryText(r112);
        r114.bigLargeIcon(null);
        r105.setStyle(r114);
        return r105;
    L15:
        r106 = a(r100, r102.get("notification_bigPic_uri"), false);
        goto L16
    L21:
        if ("1".equals(r103) == false) goto L24;
        du r107 = new du(r100);
        r107.setStyle(new Notification.BigTextStyle().bigText(r112));
        return r107;
    L24:
        if ("4".equals(r103) == false) goto L35;
        if (com.xiaomi.push.j.m9294a() == false) goto L35;
        dt r108 = new dt(r100, r101);
        if (TextUtils.isEmpty(r102.get("notification_banner_image_uri")) == true) goto L31;
        r108.a(a(r100, r102.get("notification_banner_image_uri"), false));
    L31:
        if (TextUtils.isEmpty(r102.get("notification_banner_icon_uri")) == true) goto L33;
        r108.b(a(r100, r102.get("notification_banner_icon_uri"), false));
    L33:
        r108.a(r102);
        return r108;
    L35:
        if ("3".equals(r103) == false) goto L51;
        if (com.xiaomi.push.j.m9294a() == false) goto L51;
        dv r115 = new dv(r100, r113, r101);
        if (TextUtils.isEmpty(r102.get("notification_colorful_button_text")) == true) goto L44;
        PendingIntent r116 = a(r100, r101, r110, r111, r113, 4);
        if (r116 == null) goto L44;
        r115.a(r102.get("notification_colorful_button_text"), r116).mo9030a(r102.get("notification_colorful_button_bg_color"));
    L44:
        if (TextUtils.isEmpty(r102.get("notification_colorful_bg_color")) == true) goto L47;
        r115.b(r102.get("notification_colorful_bg_color"));
    L49:
        r115.a(r102);
        return r115;
    L47:
        if (TextUtils.isEmpty(r102.get("notification_colorful_bg_image_uri")) == true) goto L49;
        r115.a(a(r100, r102.get("notification_colorful_bg_image_uri"), false));
    L51:
        return new du(r100);
    L5:
        if (f1143a == null) goto L7;
        r104 = f1143a.a(r100, r113, r101, r102);
        goto L8
    }

    private static PendingIntent a(Context r100, ha r101, String r102, byte[] r110, int r111) {
        return a(r100, r101, r102, r110, r111, 0, a(r100, r101, r102));
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r5v25 */
    /* JADX WARN: Type inference failed for: r5v29 */
    private static b a(Context r210, ha r211, byte[] r212, RemoteViews r213, PendingIntent r310, int r311) {
        b r100 = new b();
        gr r101 = r211.m9197a();
        String r110 = a(r211);
        Map<String, String> r111 = r101.m9164a();
        String[] r112 = a(r210, r101);
        if (r213 == null) goto L6;
        du r102 = new du(r210);
        r102.a(r213);
    L5:
        du r103 = r102;
        a(r103, r210, r211.b(), r211, r212, r311);
        r103.setContentTitle(r112[0]);
        r103.setContentText(r112[1]);
        long r104 = System.currentTimeMillis();
        r103.setWhen(r104);
        String r105 = a(r111, "notification_show_when");
        if (TextUtils.isEmpty(r105) == true) goto L14;
        r103.setShowWhen(Boolean.parseBoolean(r105));
    L17:
        r103.setContentIntent(r310);
        a(r210, r110, r103, r111);
        int r106 = Build.VERSION.SDK_INT;
        if (r106 >= 23) goto L20;
    L30:
        String r107 = a(r111, "__dynamic_icon_uri");
        if (Boolean.parseBoolean(a(r111, "__adiom")) == false) goto L33;
    L36:
        boolean r108 = true;
    L38:
        if (TextUtils.isEmpty(r107) == true) goto L49;
        if (r108 == false) goto L49;
        if (r107.startsWith("http") == false) goto L46;
        ae.b r109 = ae.a(r210, r107, true);
        if (r109 == null) goto L45;
        Bitmap r113 = r109.f1033a;
        r100.f464361a = r109.f464193a;
    L47:
        if (r113 == null) goto L49;
        r103.setLargeIcon(r113);
        boolean r114 = true;
    L50:
        if (r111 != null) goto L52;
        Bitmap r115 = null;
    L53:
        if (r115 == null) goto L56;
        r103.setLargeIcon(r115);
    L56:
        if (r111 != null) goto L58;
    L73:
        String r116 = null;
        boolean r117 = false;
    L74:
        boolean r118 = false;
    L75:
        r103.setAutoCancel(true);
        long r119 = System.currentTimeMillis();
        if (r111 == null) goto L81;
        if (r111.containsKey(RemoteMessageConst.Notification.TICKER) == false) goto L81;
        r103.setTicker(r111.get(RemoteMessageConst.Notification.TICKER));
    L81:
        if ((r119 - f464358a) <= 10000) goto L96;
        f464358a = r119;
        int r120 = r101.f681a;
        if (m9428b(r210, r110) == false) goto L85;
        r120 = a(r210, r110);
    L85:
        r103.setDefaults(r120);
        if (r111 != null) goto L88;
    L95:
        String r312 = "com.xiaomi.xmsf";
        boolean r214 = r114;
        b r121 = r100;
    L97:
        String r122 = "0";
        if (r111 == null) goto L131;
        if (r106 < 26) goto L131;
        af r123 = af.a(r210, r110);
        int r124 = a(r111);
        if (r124 <= 0) goto L104;
        com.xiaomi.push.av.a(r103, "setTimeoutAfter", new Object[]{Long.valueOf(r124 * 1000)});
    L104:
        ac.a(r101);
        String r125 = r111.get("channel_id");
        if (TextUtils.isEmpty(r125) == true) goto L107;
    L108:
        String r215 = a(r210, r110, r111);
        int r216 = b(r111);
        int r126 = r101.f681a;
        String r217 = r111.get("channel_description");
        String r218 = r111.get("sound_uri");
        String r219 = r111.get("channel_perm");
        bb.a(r210, r111, r103, r104);
        com.xiaomi.push.av.a(r103, "setChannelId", new Object[]{ac.a(r123, r125, r215, r217, r126, r216, r218, r219)});
        if (r120 != (-100)) goto L114;
        if (ag.a(r111) == false) goto L114;
        ag.a(r103, r117);
    L114:
        if ("pulldown".equals(ag.a(r111)) == false) goto L121;
        if (ag.a(r111) == false) goto L121;
        if (Objects.equals(r111.get("pull_down_pop_type"), r122) == false) goto L121;
        ag.a(r103, r117);
    L121:
        if ("tts".equals(ag.a(r111)) == true) goto L123;
    L125:
        String r127 = r111.get("background_color");
        if (TextUtils.isEmpty(r127) == false) goto L173;
    L136:
        if (r116 == null) goto L141;
        if (r118 == true) goto L139;
        r116 = ad.a().a(r210, r103, r116);
    L139:
        com.xiaomi.push.av.a(r103, "setGroup", new Object[]{r116});
    L141:
        if (com.xiaomi.push.j.m9299c() == true) goto L143;
    L145:
        Notification r128 = r103.getNotification();
        if (r214 == true) goto L148;
    L150:
        if (r111 != null) goto L152;
    L171:
        b r129 = r121;
        r129.f1150a = r128;
        return r129;
    L152:
        if (r128.extras != null) goto L155;
        r128.extras = new Bundle();
    L155:
        if (TextUtils.isEmpty(r111.get("enable_keyguard")) == true) goto L158;
        ag.b(r128, Boolean.parseBoolean(r111.get("enable_keyguard")));
    L158:
        if (TextUtils.isEmpty(r111.get("enable_float")) == true) goto L161;
        ag.a(r128, Boolean.parseBoolean(r111.get("enable_float")));
    L161:
        if (TextUtils.isEmpty(r111.get("float_small_win")) == false) goto L163;
    L167:
        int r130 = com.xiaomi.push.r.a(r111.get("section_is_prr"), -1);
        int r131 = com.xiaomi.push.r.a(r111.get("section_prr_cl"), -1);
        if (r130 < 0) goto L171;
        if (r131 < 0) goto L171;
        ag.a(r128, r130, r131);
        goto L171
    L163:
        if (r122.equals(r111.get("float_small_win")) == false) goto L167;
        if (com.xiaomi.push.g.d(r210, r110) == false) goto L167;
        ag.a(r128, false);
        goto L167
    L148:
        if (com.xiaomi.push.j.m9294a() == false) goto L150;
        a(r128);
        goto L150
    L143:
        if (r312.equals(r210.getPackageName()) == false) goto L145;
        com.xiaomi.push.av.a("miui.util.NotificationHelper", "setTargetPkg", new Object[]{r210, r103, a(r211)});
        goto L145
    L173:
        int r132 = CastIntegerProtector.parseInt(r127);     // Catch: Exception -> L129
        r103.setOngoing(true);     // Catch: Exception -> L129
        r103.setColor(r132);     // Catch: Exception -> L129
        com.xiaomi.push.av.a(r103, "setColorized", new Object[]{Boolean.TRUE});     // Catch: Exception -> L129
    L129:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.a(e);
        goto L136
    L123:
        if (ag.a(r111) == false) goto L125;
        ag.a(r103, r117);
        goto L125
    L107:
        if (r210.getApplicationInfo().targetSdkVersion < 26) goto L125;
    L131:
        r122 = "0";
        if (r111 == null) goto L136;
        if (r106 >= 26) goto L136;
        com.xiaomi.push.av.a(r103, "setPriority", new Object[]{Integer.valueOf(c(r111))});
        goto L136
    L88:
        if ((r120 & 1) == 0) goto L95;
        r121 = r100;
        String r133 = r111.get("sound_uri");
        if (TextUtils.isEmpty(r133) == true) goto L94;
        r214 = r114;
        r312 = "com.xiaomi.xmsf";
        if (r133.startsWith("android.resource://" + r110) == false) goto L97;
        r103.setDefaults(r120 ^ 1);
        r103.setSound(UriProtector.parse(r133));
        goto L97
    L94:
        r312 = "com.xiaomi.xmsf";
        r214 = r114;
        goto L97
    L96:
        r312 = "com.xiaomi.xmsf";
        r214 = r114;
        r121 = r100;
        r120 = -100;
        goto L97
    L58:
        if (r106 < 24) goto L73;
        String r134 = r111.get("notification_group");
        r117 = Boolean.parseBoolean(r111.get("notification_is_summary"));
        boolean r135 = Boolean.parseBoolean(r111.get("notification_group_disable_default"));
        if (TextUtils.isEmpty(r134) == true) goto L62;
    L65:
        String r220 = r134;
        com.xiaomi.push.av.a(r103, "setGroupSummary", new Object[]{Boolean.valueOf(r117)});
        String r136 = r111.get("notification_style_type");
        if ("com.xiaomi.xmsf".equals(r210.getPackageName()) == true) goto L68;
    L72:
        r116 = r220;
        goto L74
    L68:
        if ("4".equals(r136) == false) goto L70;
    L71:
        r116 = a(r211) + "_custom_" + r104;
        r118 = true;
        goto L75
    L70:
        if ("3".equals(r136) == false) goto L72;
    L62:
        if (com.xiaomi.push.j.m9294a() == true) goto L64;
        if (r135 == true) goto L65;
    L64:
        r134 = a(r211);
        goto L65
    L52:
        r115 = a(r210, r111.get("notification_large_icon_uri"), true);
        goto L53
    L45:
        r113 = null;
        goto L47
    L46:
        r113 = ae.a(r210, r107);
    L49:
        r114 = false;
        goto L50
    L33:
        if (com.xiaomi.push.j.m9294a() == false) goto L36;
        r108 = false;
        goto L38
    L20:
        if (r111 != null) goto L22;
        int r137 = 1;
        Bitmap r138 = null;
    L23:
        if (r138 == null) goto L28;
        Object[] r139 = new Object[r137];
        r139[0] = r138;
        Object r140 = com.xiaomi.push.av.a("android.graphics.drawable.Icon", "createWithBitmap", r139);
        if (r140 == null) goto L27;
        Object[] r141 = new Object[r137];
        r141[0] = r140;
        com.xiaomi.push.av.a(r103, "setSmallIcon", r141);
        Bundle r142 = new Bundle();
        r142.putBoolean("miui.isGrayscaleIcon", r137);
        r103.a(r142);
    L29:
        r103.mo9030a(a(r111, "notification_small_icon_color"));
        goto L30
    L27:
        com.xiaomi.channel.commonutils.logger.b.m8718a("failed te get small icon with url:" + r111.get("notification_small_icon_uri"));
        goto L29
    L28:
        com.xiaomi.channel.commonutils.logger.b.m8718a("failed to get small icon url:" + a(r111, "notification_small_icon_uri"));
        goto L29
    L22:
        r137 = 1;
        r138 = a(r210, r111.get("notification_small_icon_uri"), true);
        goto L23
    L14:
        if (Build.VERSION.SDK_INT < 24) goto L17;
        r103.setShowWhen(true);
        goto L17
    L6:
        if (r111 != null) goto L8;
    L10:
        r102 = new du(r210);
        goto L5
    L8:
        if (r111.containsKey("notification_style_type") == false) goto L10;
        r102 = a(r210, r211, r212, r112[1], r311);
        goto L5
    }

    private static void a(du r110, Context r111, String r112, ha r113, byte[] r114, int r115) {
        Map<String, String> r100 = r113.m9197a().m9164a();
        if (TextUtils.equals("3", r100.get("notification_style_type")) == false) goto L5;
        return;
    L5:
        if (TextUtils.equals("4", r100.get("notification_style_type")) == false) goto L8;
        return;
    L8:
        if (m9430b(r100) == false) goto L20;
        int r116 = 1;
    L11:
        if (r116 > 3) goto L18;
        String r117 = r100.get(String.format("cust_btn_%s_n", new Object[]{Integer.valueOf(r116)}));
        if (TextUtils.isEmpty(r117) == true) goto L17;
        PendingIntent r101 = a(r111, r112, r113, r114, r115, r116);
        if (r101 == null) goto L17;
        r110.addAction(0, r117, r101);
    L17:
        r116 = r116 + 1;
        goto L11
    L18:
        return;
    L20:
        if (TextUtils.isEmpty(r100.get("notification_style_button_left_name")) == true) goto L25;
        PendingIntent r102 = a(r111, r112, r113, r114, r115, 1);
        if (r102 == null) goto L25;
        r110.addAction(0, r100.get("notification_style_button_left_name"), r102);
    L25:
        if (TextUtils.isEmpty(r100.get("notification_style_button_mid_name")) == true) goto L30;
        PendingIntent r103 = a(r111, r112, r113, r114, r115, 2);
        if (r103 == null) goto L30;
        r110.addAction(0, r100.get("notification_style_button_mid_name"), r103);
    L30:
        if (TextUtils.isEmpty(r100.get("notification_style_button_right_name")) == true) goto L40;
        PendingIntent r104 = a(r111, r112, r113, r114, r115, 3);
        if (r104 == null) goto L41;
        r110.addAction(0, r100.get("notification_style_button_right_name"), r104);
        return;
    L41:
        return;
    }

    private static void a(Context r100, Intent r101, ha r102, gr r103, String r104, int r105) {
        if (r102 == null) goto L20;
        if (r103 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r104) == true) goto L24;
        String r106 = a(r103.m9164a(), r105);
        if (TextUtils.isEmpty(r106) == false) goto L10;
        return;
    L10:
        if (an.f464236a.equals(r106) == false) goto L12;
    L15:
        r101.putExtra("messageId", r104);
        r101.putExtra("local_paid", r102.f773a);
        if (TextUtils.isEmpty(r102.f777b) == true) goto L18;
        r101.putExtra(HiAnalyticsConstant.BI_KEY_TARGET_PACKAGE, r102.f777b);
    L18:
        r101.putExtra("job_key", a(r103.m9164a(), "jobkey"));
        r101.putExtra(r105 + "_target_component", a(r100, r102.f777b, r103.m9164a(), r105));
        return;
    L12:
        if (an.f464237b.equals(r106) == true) goto L15;
        if (an.f464238c.equals(r106) == true) goto L15;
        return;
    L24:
        return;
    }

    private static PendingIntent a(Context r100, String r110, ha r111, byte[] r112, int r113, int r114) {
        Map<String, String> r101 = r111.m9197a().m9164a();
        if (r101 != null) goto L5;
        return null;
    L5:
        boolean r102 = a(r100, r111, r110);
        if (r102 == true) goto L15;
        Intent r115 = m9420a(r100, r110, r101, r114);
        if (r115 != null) goto L11;
        return null;
    L11:
        if (Build.VERSION.SDK_INT < 31) goto L14;
        return PendingIntent.getActivity(r100, 0, r115, 167772160);
    L14:
        return PendingIntent.getActivity(r100, 0, r115, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L15:
        return a(r100, r111, r110, r112, r113, r114, r102);
    }

    private static PendingIntent a(Context r110, ha r111, String r112, byte[] r113, int r210, int r211, boolean r212) {
        if (c(r111) == false) goto L6;
        int r100 = 1000;
    L9:
        gr r101 = r111.m9197a();
        if (r101 == null) goto L12;
        String r102 = r101.m9163a();
    L13:
        boolean r103 = m9425a(r111);
        if (r101 == null) goto L34;
        if (TextUtils.isEmpty(r101.f694e) == true) goto L34;
        Intent r104 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);
        r104.setData(UriProtector.parse(r101.f694e));
        String r105 = new URL(r101.f694e).getProtocol();     // Catch: MalformedURLException -> L26
        if ("http".equals(r105) == false) goto L21;
    L24:
        ag.a(r110, r112, r104);     // Catch: MalformedURLException -> L26
    L52:
    L27:
        r104.addFlags(268435456);
        r104.putExtra("messageId", r102);
        r104.putExtra("eventMessageType", r100);
        if (Build.VERSION.SDK_INT < 31) goto L32;
        return PendingIntent.getActivity(r110, 0, r104, 167772160);
    L32:
        return PendingIntent.getActivity(r110, 0, r104, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L21:
        if ("https".equals(r105) == true) goto L24;
        r104.setPackage(r112);     // Catch: MalformedURLException -> L26
    L26:
        com.xiaomi.channel.commonutils.logger.b.m8718a("meet URL exception : " + r101.f694e);
        r104.setPackage(r112);
    L34:
        if (r103 == false) goto L36;
        Intent r106 = new Intent();
        r106.setComponent(new ComponentName("com.xiaomi.xmsf", "com.xiaomi.mipush.sdk.PushMessageHandler"));
        r106.putExtra("mipush_payload", r113);
        r106.putExtra("mipush_notified", true);
        r106.addCategory(String.valueOf(r210));
        r106.addCategory(String.valueOf(r102));
    L37:
        r106.putExtra("notification_click_button", r211);
        r106.putExtra("messageId", r102);
        r106.putExtra("eventMessageType", r100);
        if (r103 == true) goto L46;
        if (r212 == false) goto L46;
        Intent r107 = new Intent();
        r107.setComponent(a(r112));
        r107.addFlags(276824064);
        r107.putExtra("mipush_serviceIntent", r106);
        r107.addCategory(String.valueOf(r210));
        r107.addCategory(String.valueOf(r102));
        r107.addCategory(String.valueOf(r211));
        a(r110, r107, r111, r101, r102, r211);
        if (Build.VERSION.SDK_INT < 31) goto L45;
        return PendingIntent.getActivity(r110, 0, r107, 167772160);
    L45:
        return PendingIntent.getActivity(r110, 0, r107, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L46:
        a(r110, r106, r111, r101, r102, r211);
        if (Build.VERSION.SDK_INT < 31) goto L51;
        return PendingIntent.getService(r110, 0, r106, 167772160);
    L51:
        return PendingIntent.getService(r110, 0, r106, AMapEngineUtils.HALF_MAX_P20_WIDTH);
    L36:
        r106 = new Intent("com.xiaomi.mipush.RECEIVE_MESSAGE");
        r106.setComponent(new ComponentName(r112, "com.xiaomi.mipush.sdk.PushMessageHandler"));
        r106.putExtra("mipush_payload", r113);
        r106.putExtra("mipush_notified", true);
        r106.addCategory(String.valueOf(r210));
        r106.addCategory(String.valueOf(r102));
        goto L37
    L12:
        r102 = "";
        goto L13
    L6:
        if (m9425a(r111) == false) goto L8;
        r100 = 3000;
        goto L9
    L8:
        r100 = -1;
        goto L9
    }

    private static Intent a(Context r100, String r101, Map<String, String> r102, String r103, String r104, String r105, String r110) {
        String r106 = r102.get(r103);
        if (TextUtils.isEmpty(r106) == false) goto L6;
        return null;
    L6:
        if (an.f464236a.equals(r106) == false) goto L12;
        Intent r107 = r100.getPackageManager().getLaunchIntentForPackage(r101);     // Catch: Exception -> L9
    L53:
        if (r107 == null) goto L69;
        r107.addFlags(268435456);
    L67:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
        goto L69
    L56:
        if (r100.getPackageManager().resolveActivity(r107, 65536) == null) goto L59;
        return r107;
    L59:
        if (Build.VERSION.SDK_INT >= 30) goto L61;
    L65:
        com.xiaomi.channel.commonutils.logger.b.m8718a("not resolve activity:" + r107 + "for buttons");     // Catch: Exception -> L67
        goto L69
    L61:
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L65;
        if (an.f464238c.equals(r106) == false) goto L65;
        return r107;
    L69:
        return null;
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
    L52:
        r107 = null;
        goto L53
    L12:
        if (an.f464237b.equals(r106) == false) goto L32;
        if (r102.containsKey(r104) == false) goto L28;
        String r108 = r102.get(r104);
        if (r108 == null) goto L52;
        Intent r109 = Intent.parseUri(r108, 1);     // Catch: URISyntaxException -> L23
        r109.setPackage(r101);     // Catch: URISyntaxException -> L21
    L26:
        r107 = r109;
    L21:
        e = e;
    L25:
        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
    L23:
        e = e;
        r109 = null;
        goto L25
    L28:
        if (r102.containsKey(r105) == false) goto L52;
        String r111 = r102.get(r105);
        Intent r112 = new Intent();
        r112.setComponent(new ComponentName(r101, r111));
    L30:
        r107 = r112;
        goto L53
    L32:
        if (an.f464238c.equals(r106) == false) goto L52;
        String r113 = r102.get(r110);
        if (TextUtils.isEmpty(r113) == true) goto L52;
        String r114 = r113.trim();
        if (r114.startsWith("http://") == false) goto L38;
    L74:
        String r115 = new URL(r114).getProtocol();     // Catch: MalformedURLException -> L49
        if ("http".equals(r115) == false) goto L43;
    L44:
        r112 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL);     // Catch: MalformedURLException -> L49
        r112.setData(UriProtector.parse(r114));     // Catch: MalformedURLException -> L47
        ag.a(r100, r101, r112);     // Catch: MalformedURLException -> L47
    L47:
        e = e;
    L51:
        com.xiaomi.channel.commonutils.logger.b.d("Cause: " + e.getMessage());
        goto L30
    L43:
        if ("https".equals(r115) == false) goto L52;
    L49:
        e = e;
        r112 = null;
        goto L51
    L38:
        if (r114.startsWith("https://") == true) goto L74;
        r114 = "http://".concat(r114);
        goto L74
    }
}
