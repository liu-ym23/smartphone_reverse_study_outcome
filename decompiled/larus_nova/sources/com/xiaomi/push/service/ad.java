package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.content.res.Resources;
import android.graphics.drawable.Icon;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.ForegroundColorSpan;
import android.util.DisplayMetrics;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.obric.assistant.interaction.impl.window.WindowDisplayMetricsOverride;
import com.xiaomi.push.gj;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
class ad {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static ad f464186a;

    /* JADX INFO: renamed from: a, reason: collision with other field name */
    private SpannableString f1027a;

    /* JADX INFO: renamed from: com.xiaomi.push.service.ad$1, reason: invalid class name */
    public static /* synthetic */ class AnonymousClass1 {
    }

    public class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        final /* synthetic */ ad f464187a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        List<b> f1028a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        List<b> f464188b;

        private a(ad r100) {
            this.f464187a = r100;
            this.f1028a = new ArrayList();
            this.f464188b = new ArrayList();
        }

        public /* synthetic */ a(ad r100, AnonymousClass1 r101) {
            this(r100);
        }
    }

    public class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        int f464189a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        Notification f1029a;

        /* JADX INFO: renamed from: a, reason: collision with other field name */
        final /* synthetic */ ad f1030a;

        public String toString() {
            return "id:" + this.f464189a;
        }

        public b(ad r100, int r101, Notification r102) {
            this.f1030a = r100;
            this.f464189a = r101;
            this.f1029a = r102;
        }
    }

    static {
        f464186a = new ad();
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m9341a() {
        if (Build.VERSION.SDK_INT < 24) goto L5;
        return true;
    L5:
        return false;
    }

    private ad() {
    }

    public static ad a() {
        return f464186a;
    }

    public static DisplayMetrics INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(Resources r100) {
        return WindowDisplayMetricsOverride.apply(r100, r100.getDisplayMetrics());
    }

    private boolean a(Context r100) {
        if (b(r100) == true) goto L6;
        return false;
    L6:
        if (af.m9347a(r100) == true) goto L9;
        return false;
    L9:
        return ah.a(r100).a(gj.aX.a(), false);
    }

    /* JADX INFO: renamed from: b, reason: collision with other method in class */
    private boolean m9343b(Notification r100) {
        if (r100 != null) goto L5;
    L11:
        return false;
    L5:
        if (r100.getGroup() == null) goto L11;
        Bundle r101 = r100.extras;
        if (r101 == null) goto L11;
        long r102 = r101.getLong("push_src_group_time");
        String r103 = a(r100);
        return r100.getGroup().equals(String.format("pushmask_%s_%s", new Object[]{Long.valueOf(r102), r103}));
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private boolean m9342a(Notification r100) {
        if (r100 == null) goto L7;
        Object r101 = com.xiaomi.push.av.a(r100, "isGroupSummary", null);
        if ((r101 instanceof Boolean) == true) goto L6;
        return false;
    L6:
        return ((Boolean) r101).booleanValue();
    L7:
        return false;
    }

    private String b(Notification r100) {
        if (r100 != null) goto L5;
        return null;
    L5:
        String r101 = r100.getGroup();
        if (m9343b(r100) == true) goto L8;
        return r101;
    L8:
        return a(r100);
    }

    private List<StatusBarNotification> a(af r100) {
        if (r100 == null) goto L5;
        List<StatusBarNotification> r101 = r100.m9355b();
    L6:
        if (r101 != null) goto L8;
    L11:
        return null;
    L8:
        if (r101.size() == 0) goto L11;
        return r101;
    L5:
        r101 = null;
        goto L6
    }

    private boolean b(Context r100) {
        return ah.a(r100).a(gj.aW.a(), true);
    }

    private String a(Notification r100) {
        if (r100 == null) goto L7;
        Bundle r101 = r100.extras;
        if (r101 != null) goto L6;
        return null;
    L6:
        return r101.getString("push_src_group_name");
    L7:
        return null;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private SpannableString m9340a(Context r100, String r101) {
        if (this.f1027a != null) goto L21;
        if (r100 == null) goto L12;
        Resources r102 = r100.getResources();
        if (r102 == null) goto L12;
        DisplayMetrics r103 = INVOKEVIRTUAL_com_xiaomi_push_service_ad_com_obric_assistant_interaction_impl_window_helpers_ResourcesLancet_getDisplayMetrics(r102);
        if (r103 == null) goto L12;
        int r104 = Math.max(r103.heightPixels, r103.widthPixels);
        if (r104 <= 0) goto L12;
        int r105 = r104 / 16;
    L14:
        if (TextUtils.isEmpty(r101) == false) goto L16;
        r101 = "新消息";
    L16:
        StringBuilder r106 = new StringBuilder((r101.length() + r105) + 12);
        r106.append(r101);
        int r107 = 0;
    L17:
        if (r107 >= r105) goto L19;
        r106.append(' ');
        r107 = r107 + 1;
        goto L17
    L19:
        r106.append("GroupSummary");
        SpannableString r108 = new SpannableString(r106.toString());
        r108.setSpan(new ForegroundColorSpan(0), r101.length(), r106.length(), 33);
        this.f1027a = r108;
    L12:
        r105 = 200;
    L21:
        return this.f1027a;
    }

    private PendingIntent a(Context r100, String r101) {
        if (r100 == null) goto L5;
    L24:
        PackageManager r102 = r100.getPackageManager();     // Catch: Throwable -> L21
        if (r102 != null) goto L12;
        com.xiaomi.channel.commonutils.logger.b.m8718a("pm must not be null in getting launch intent");     // Catch: Throwable -> L21
        return null;
    L12:
        Intent r103 = r102.getLaunchIntentForPackage(r101);     // Catch: Throwable -> L21
        if (r103 != null) goto L16;
        com.xiaomi.channel.commonutils.logger.b.m8718a("targetIntent must not be null in getting launch intent");     // Catch: Throwable -> L21
        return null;
    L16:
        r103.addFlags(268435456);     // Catch: Throwable -> L21
        if (Build.VERSION.SDK_INT < 31) goto L19;
        PendingIntent r104 = PendingIntent.getActivity(r100, 0, r103, 33554432);     // Catch: Throwable -> L21
    L25:
        return r104;
    L19:
        r104 = PendingIntent.getActivity(r100, 0, r103, 0);     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        com.xiaomi.channel.commonutils.logger.b.d("error occurred during getting launch pendingIntent. exception:" + th);
        return null;
    L5:
        if (TextUtils.isEmpty(r101) == false) goto L24;
        com.xiaomi.channel.commonutils.logger.b.m8718a("ctx or pkg must not be null in getting launch intent");
        return null;
    }

    private void a(Map<String, a> r100, StatusBarNotification r101) {
        String r102 = b(r101.getNotification());
        a r103 = r100.get(r102);
        if (r103 != null) goto L5;
        r103 = new a(this, null);
        r100.put(r102, r103);
    L5:
        b r104 = new b(this, r101.getId(), r101.getNotification());
        if (m9342a(r101.getNotification()) == false) goto L8;
        r103.f464188b.add(r104);
        return;
    L8:
        r103.f1028a.add(r104);
    }

    private int a(String r100, String r101) {
        return ("GroupSummary" + r100 + r101).hashCode();
    }

    private void b(Context r100, int r101, Notification r102) {
        String r103 = ag.c(r102);
        if (TextUtils.isEmpty(r103) == false) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group restore not extract pkg from notification:" + r101);
        return;
    L6:
        af r104 = af.a(r100, r103);
        List<StatusBarNotification> r105 = a(r104);
        if (r105 != null) goto L10;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group restore not get notifications");
        return;
    L10:
        Iterator<StatusBarNotification> r106 = r105.iterator();
    L12:
        if (r106.hasNext() == false) goto L21;
        StatusBarNotification r107 = r106.next();
        Notification r108 = r107.getNotification();
        if (r108 == null) goto L12;
        if (m9343b(r108) == false) goto L12;
        if (r107.getId() == r101) goto L12;
        Notification.Builder r109 = Notification.Builder.recoverBuilder(r100, r107.getNotification());
        r109.setGroup(a(r108));
        ag.a(r109, m9342a(r108));
        r104.a(r107.getId(), r109.build());
        com.xiaomi.channel.commonutils.logger.b.b("group restore notification:" + r107.getId());
        goto L12
    }

    public void a(Context r100, int r101, Notification r102) {
        if (m9341a() == true) goto L6;
        return;
    L6:
        if (a(r100) == false) goto L12;
        b(r100, r101, r102);     // Catch: Exception -> L9
    L9:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group notify handle restore error " + e);
    L12:
        if (b(r100) == true) goto L19;
        return;
    L19:
        a(r100, r101, r102, true);     // Catch: Exception -> L16
        return;
    L16:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group notify handle auto error " + e);
    }

    public String a(Context r100, Notification.Builder r101, String r102) {
        if (m9341a() == true) goto L5;
    L8:
        return r102;
    L5:
        if (a(r100) == false) goto L8;
        long r103 = System.currentTimeMillis();
        Bundle r104 = r101.getExtras();
        r104.putString("push_src_group_name", r102);
        r104.putLong("push_src_group_time", r103);
        return String.format("pushmask_%s_%s", new Object[]{Long.valueOf(r103), r102});
    }

    private void a(Context r100, String r101, String r102) {
        com.xiaomi.channel.commonutils.logger.b.b("group cancel summary:" + r102);
        af.a(r100, r101).a(a(r101, r102));
    }

    private void a(Context r100, int r110, Notification r111, boolean r112) {
        String r101 = ag.c(r111);
        if (TextUtils.isEmpty(r101) == false) goto L6;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group auto not extract pkg from notification:" + r110);
        return;
    L6:
        List<StatusBarNotification> r102 = a(af.a(r100, r101));
        if (r102 != null) goto L10;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group auto not get notifications");
        return;
    L10:
        String r103 = b(r111);
        HashMap r104 = new HashMap();
        Iterator<StatusBarNotification> r105 = r102.iterator();
    L12:
        if (r105.hasNext() == false) goto L19;
        StatusBarNotification r106 = r105.next();
        if (r106.getNotification() == null) goto L12;
        if (r106.getId() == r110) goto L12;
        a(r104, r106);
        goto L12
    L19:
        Iterator r107 = r104.entrySet().iterator();
    L21:
        if (r107.hasNext() == false) goto L48;
        Map.Entry r108 = (Map.Entry) r107.next();
        String r109 = (String) r108.getKey();
        if (TextUtils.isEmpty(r109) == true) goto L21;
        a r113 = (a) r108.getValue();
        if (r112 == true) goto L28;
    L35:
        int r114 = r113.f1028a.size();
        if (r113.f464188b.size() <= 0) goto L37;
        if (r114 <= 0) goto L42;
        if (ah.a(r100).a(gj.f463758bt.a(), false) == false) goto L21;
        Notification r115 = ((b) ListProtector.get(r113.f464188b, 0)).f1029a;
        if (r115 == null) goto L21;
        r115.when = System.currentTimeMillis();
        a(r100, r101, r109, r115);
        goto L21
    L42:
        a(r100, r101, r109);
        goto L21
    L37:
        if (r112 == false) goto L21;
        if (r114 < 2) goto L21;
        a(r100, r101, r109, ((b) ListProtector.get(r113.f1028a, 0)).f1029a);
        goto L21
    L28:
        if (r109.equals(r103) == false) goto L35;
        if (m9343b(r111) == true) goto L35;
        b r116 = new b(this, r110, r111);
        if (m9342a(r111) == false) goto L34;
        r113.f464188b.add(r116);
        goto L35
    L34:
        r113.f1028a.add(r116);
        goto L35
    }

    private void a(Context r100, String r101, String r110, Notification r111) {
    L29:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group show summary error " + e);
        return;
    L4:
        if (TextUtils.isEmpty(r110) == false) goto L7;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group show summary group is null");     // Catch: Exception -> L29
        return;
    L7:
        int r102 = ag.a(r100, r101);     // Catch: Exception -> L29
        if (r102 != 0) goto L11;
        com.xiaomi.channel.commonutils.logger.b.m8718a("group show summary not get icon from " + r101);     // Catch: Exception -> L29
        return;
    L11:
        af r103 = af.a(r100, r101);     // Catch: Exception -> L29
        int r104 = Build.VERSION.SDK_INT;     // Catch: Exception -> L29
        if (r104 < 26) goto L18;
        String r112 = r103.c(r111.getChannelId(), "groupSummary");     // Catch: Exception -> L29
        NotificationChannel r105 = r103.m9349a(r112);     // Catch: Exception -> L29
        if ("groupSummary".equals(r112) == false) goto L17;
        if (r105 != null) goto L17;
        r103.a(new NotificationChannel(r112, "group_summary", 3));     // Catch: Exception -> L29
    L17:
        Notification.Builder r106 = new Notification.Builder(r100, r112);     // Catch: Exception -> L29
    L19:
        ag.a(r106, true);     // Catch: Exception -> L29
        Notification r113 = r106.setContentTitle(m9340a(r100, "新消息")).setContentText("你有一条新消息").setSmallIcon(Icon.createWithResource(r101, r102)).setAutoCancel(true).setGroup(r110).setGroupSummary(true).build();     // Catch: Exception -> L29
        if (r104 < 31) goto L23;
        r113.contentIntent = a(r100, r101);     // Catch: Exception -> L29
    L23:
        if (com.xiaomi.push.j.m9299c() == false) goto L25;
    L27:
        int r107 = a(r101, r110);     // Catch: Exception -> L29
        r103.a(r107, r113);     // Catch: Exception -> L29
        com.xiaomi.channel.commonutils.logger.b.b("group show summary notify:" + r107);     // Catch: Exception -> L29
        return;
    L25:
        if ("com.xiaomi.xmsf".equals(r100.getPackageName()) == false) goto L27;
        ag.m9356a(r113, r101);     // Catch: Exception -> L29
        goto L27
    L18:
        r106 = new Notification.Builder(r100).setPriority(0).setDefaults(-1);     // Catch: Exception -> L29
        goto L19
    }
}
