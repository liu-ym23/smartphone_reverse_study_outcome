package com.xiaomi.push.service;

import android.app.Notification;
import android.content.Context;
import android.os.Build;
import android.os.Bundle;
import android.service.notification.StatusBarNotification;
import android.text.TextUtils;
import com.larus.bmhome.music.applet.MusicAppletPage;
import com.xiaomi.push.du;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* JADX INFO: loaded from: classes41.dex */
public class bb {
    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m9382a(Map<String, String> r100) {
        String r101 = r100.get("notification_top_repeat");
        if (TextUtils.isEmpty(r101) == true) goto L5;
        boolean r102 = Boolean.parseBoolean(r101);
        com.xiaomi.channel.commonutils.logger.b.c("top notification' repeat is " + r102);
        return r102;
    L5:
        return false;
    }

    private static int b(Map<String, String> r100) {
        return Math.max(0, com.xiaomi.push.r.a(r100.get("notification_top_frequency"), 0));
    }

    private static int a(Map<String, String> r100) {
        return Math.max(0, com.xiaomi.push.r.a(r100.get("notification_top_period"), 0));
    }

    public static /* synthetic */ String a(int r100, String r101) {
        return b(r100, r101);
    }

    private static String b(int r100, String r101) {
        return "n_top_update_" + r100 + "_" + r101;
    }

    public static void a(Context r100, Map<String, String> r101, du r102, long r103) {
        if (r101 == null) goto L18;
        if (r102 != null) goto L6;
        return;
    L6:
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L8;
        return;
    L8:
        if (m9382a(r101) == false) goto L20;
        int r104 = a(r101);
        int r105 = b(r101);
        if (r104 <= 0) goto L16;
        if (r105 > r104) goto L16;
        r102.setPriority(2);
        Bundle r106 = new Bundle();
        r106.putLong("mipush_org_when", r103);
        r106.putBoolean("mipush_n_top_flag", true);
        if (r105 <= 0) goto L15;
        r106.putInt("mipush_n_top_fre", r105);
    L15:
        r106.putInt("mipush_n_top_prd", r104);
        r102.a(r106);
        return;
    L16:
        com.xiaomi.channel.commonutils.logger.b.d("set top notification failed - period:" + r104 + " frequency:" + r105);
        return;
    L20:
        return;
    }

    private static Notification a(Notification r100, int r101, String r102, af r103) {
        if (r100 != null) goto L5;
        List<StatusBarNotification> r104 = r103.m9355b();
        if (r104 == null) goto L27;
        Iterator<StatusBarNotification> r105 = r104.iterator();
    L13:
        if (r105.hasNext() == false) goto L28;
        StatusBarNotification r106 = r105.next();
        Notification r107 = r106.getNotification();
        String r108 = r107.extras.getString(MusicAppletPage.KEY_MESSAGE_ID);
        if (r101 != r106.getId()) goto L13;
        if (r102.equals(r108) == false) goto L13;
        return r107;
    L28:
        return null;
    L27:
        return null;
    L5:
        if (r102.equals(r100.extras.getString(MusicAppletPage.KEY_MESSAGE_ID)) == true) goto L26;
        r100 = null;
    L26:
        return r100;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    public static void m9381a(Context r100, String r101, int r102, String r103, Notification r104) {
        if (com.xiaomi.push.j.m9295a(r100) == false) goto L9;
        if (r104 != null) goto L6;
        return;
    L6:
        if (r104.extras.getBoolean("mipush_n_top_flag", false) == false) goto L11;
        c(r100, r101, r102, r103, r104);
        return;
    L11:
        return;
    }

    public static /* synthetic */ void b(Context r100, String r101, int r102, String r103, Notification r104) {
        c(r100, r101, r102, r103, r104);
    }

    private static void c(Context r110, String r111, int r112, String r210, Notification r211) {
        if (r110 != null) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r111) == false) goto L7;
        return;
    L7:
        if (TextUtils.isEmpty(r210) == false) goto L9;
        return;
    L9:
        if (Build.VERSION.SDK_INT < 26) goto L48;
        af r100 = af.a(r110, r111);
        Notification r101 = a(r211, r112, r210, r100);
        if (r101 != null) goto L14;
        return;
    L14:
        if (r211 == null) goto L16;
        boolean r102 = true;
    L18:
        if (r101.getGroupAlertBehavior() == 1) goto L20;
        com.xiaomi.push.av.a(r101, "mGroupAlertBehavior", 1);
    L20:
        long r103 = System.currentTimeMillis();
        long r113 = r101.extras.getLong("mipush_org_when", 0);
        int r104 = r101.extras.getInt("mipush_n_top_fre", 0);
        int r114 = r101.extras.getInt("mipush_n_top_prd", 0);
        if (r114 <= 0) goto L45;
        if (r114 < r104) goto L46;
        long r115 = ((long) (r114 * 1000)) + r113;
        if (r113 < r103) goto L26;
    L30:
        int r116 = 0;
    L31:
        if (r102 == true) goto L38;
        if (r116 <= 0) goto L34;
        r101.when = r103;
        com.xiaomi.channel.commonutils.logger.b.m8718a("update top notification: " + r210);
        r100.a(r112, r101);
        goto L38
    L34:
        Notification.Builder r105 = Notification.Builder.recoverBuilder(r110, r101);
        r105.setPriority(0);
        r105.setWhen(r103);
        Bundle r106 = r105.getExtras();
        if (r106 == null) goto L37;
        r106.remove("mipush_n_top_flag");
        r106.remove("mipush_org_when");
        r106.remove("mipush_n_top_fre");
        r106.remove("mipush_n_top_prd");
        r105.setExtras(r106);
    L37:
        com.xiaomi.channel.commonutils.logger.b.m8718a("update top notification to common: " + r210);
        r100.a(r112, r105.build());
    L38:
        if (r116 <= 0) goto L47;
        com.xiaomi.channel.commonutils.logger.b.m8718a("schedule top notification next update delay: " + r116);
        com.xiaomi.push.ad.a(r110).m8799a(b(r112, r210));
        com.xiaomi.push.ad.a(r110).b(a(r110, r111, r112, r210, null), r116);
        return;
    L47:
        return;
    L26:
        if (r103 >= r115) goto L30;
        if (r104 <= 0) goto L29;
        r116 = (int) Math.min((r115 - r103) / 1000, r104);
        goto L31
    L29:
        r116 = r114;
        goto L31
    L46:
        return;
    L45:
        return;
    L16:
        r102 = false;
        goto L18
    }

    private static com.xiaomi.push.ad.a a(final Context r100, final String r101, final int r102, final String r110, final Notification r111) {
        return new AnonymousClass1(r102, r110, r100, r101, r111);
    }
}
