package com.xiaomi.push.service;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.content.SharedPreferences;
import android.provider.Settings;
import android.text.TextUtils;
import android.util.Log;
import com.bytedance.android.livesdkapi.feed.constant.OpenFeedConstantKt;
import com.bytedance.mt.protector.impl.UriProtector;
import com.xiaomi.push.gr;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* JADX INFO: loaded from: classes41.dex */
public class ac {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    private static final boolean f464185a = false;

    static {
        f464185a = Log.isLoggable("NCHelper", 3);
    }

    public static void a(gr r100) {
        if (r100 == null) goto L9;
        Map<String, String> r101 = r100.f685a;
        if (r101 != null) goto L6;
        return;
    L6:
        if (r101.containsKey("REMOVE_CHANNEL_MARK") == false) goto L11;
        r100.f681a = 0;
        r100.f685a.remove("channel_id");
        r100.f685a.remove("channel_importance");
        r100.f685a.remove(OpenFeedConstantKt.KEY_CHANNEL_NAME);
        r100.f685a.remove("channel_description");
        r100.f685a.remove("channel_perm");
        com.xiaomi.channel.commonutils.logger.b.m8718a("delete channel info by:" + r100.f685a.get("REMOVE_CHANNEL_MARK"));
        r100.f685a.remove("REMOVE_CHANNEL_MARK");
        return;
    L11:
        return;
    }

    private static int a(NotificationChannel r100) {
        int r101 = 0;
        r101 = ((Integer) com.xiaomi.push.av.b(r100, "getUserLockedFields", new Object[0])).intValue();     // Catch: Exception -> L7
        if (f464185a == false) goto L9;
        a("isUserLockedChannel:" + r101 + " " + r100);     // Catch: Exception -> L7
    L9:
        return r101;
    L7:
        e = move-exception;
        com.xiaomi.channel.commonutils.logger.b.m8719a("NCHelper", "is user locked error" + e);
        goto L9
    }

    private static SharedPreferences a(Context r100) {
        return r100.getSharedPreferences("mipush_channel_copy_sp", 0);
    }

    private static void a(String r100) {
        com.xiaomi.channel.commonutils.logger.b.m8719a("NCHelper", r100);
    }

    private static boolean a(NotificationChannel r100, NotificationChannel r101) {
        boolean r102 = false;
        if (r100 == null) goto L54;
        if (r101 == null) goto L54;
        boolean r103 = true;
        if (TextUtils.equals(r100.getName(), r101.getName()) == false) goto L9;
        boolean r104 = false;
    L14:
        if (TextUtils.equals(r100.getDescription(), r101.getDescription()) == true) goto L20;
        if (f464185a == false) goto L18;
        a("appHack channelConfigLowerCompare:getDescription");
    L18:
        r104 = true;
    L20:
        if (r100.getImportance() == r101.getImportance()) goto L26;
        r100.setImportance(Math.min(r100.getImportance(), r101.getImportance()));
        if (f464185a == false) goto L24;
        a("appHack channelConfigLowerCompare:getImportance  " + r100.getImportance() + " " + r101.getImportance());
    L24:
        r104 = true;
    L26:
        if (r100.shouldVibrate() == r101.shouldVibrate()) goto L32;
        r100.enableVibration(false);
        if (f464185a == false) goto L30;
        a("appHack channelConfigLowerCompare:enableVibration");
    L30:
        r104 = true;
    L32:
        if (r100.shouldShowLights() == r101.shouldShowLights()) goto L38;
        r100.enableLights(false);
        if (f464185a == false) goto L36;
        a("appHack channelConfigLowerCompare:enableLights");
    L36:
        r104 = true;
    L38:
        if (r100.getSound() != null) goto L40;
        boolean r105 = false;
    L42:
        if (r101.getSound() == null) goto L45;
        r102 = true;
    L45:
        if (r105 == r102) goto L49;
        r100.setSound(null, null);
        if (f464185a == false) goto L51;
        a("appHack channelConfigLowerCompare:setSound");
    L51:
        if (f464185a == false) goto L53;
        a("appHack channelConfigLowerCompare:isDifferent:" + r103);
    L53:
        return r103;
    L49:
        r103 = r104;
        goto L51
    L40:
        r105 = true;
        goto L42
    L9:
        if (f464185a == false) goto L11;
        a("appHack channelConfigLowerCompare:getName");
    L11:
        r104 = true;
    L54:
        return false;
    }

    private static void b(Context r100, String r101) {
        if (f464185a == false) goto L5;
        a("recordCopiedChannel:" + r101);
    L5:
        a(r100).edit().putBoolean(r101, true).apply();
    }

    private static void c(Context r100, String r101) {
        af r102 = af.a(r100, r101);     // Catch: Exception -> L12
        Set<String> r103 = a(r100).getAll().keySet();     // Catch: Exception -> L12
        ArrayList r104 = new ArrayList();     // Catch: Exception -> L12
        Iterator<String> r105 = r103.iterator();     // Catch: Exception -> L12
    L4:
        if (r105.hasNext() == false) goto L10;
        String r106 = r105.next();     // Catch: Exception -> L12
        if (r102.m9354a(r106) == false) goto L4;
        r104.add(r106);     // Catch: Exception -> L12
        if (f464185a == false) goto L4;
        a("delete channel copy record:" + r106);     // Catch: Exception -> L12
        goto L4
    L10:
        a(r100, r104);     // Catch: Exception -> L12
        return;
    }

    private static void a(Context r100, List<String> r101) {
        if (f464185a == false) goto L6;
        a("deleteCopiedChannelRecord:" + r101);
    L6:
        if (r101.isEmpty() == true) goto L14;
        SharedPreferences.Editor r102 = a(r100).edit();
        Iterator<String> r103 = r101.iterator();
    L9:
        if (r103.hasNext() == false) goto L11;
        r102.remove(r103.next());
        goto L9
    L11:
        r102.apply();
        return;
    }

    private static NotificationChannel a(String r100, NotificationChannel r101) {
        NotificationChannel r102 = new NotificationChannel(r100, r101.getName(), r101.getImportance());
        r102.setDescription(r101.getDescription());
        r102.enableVibration(r101.shouldVibrate());
        r102.enableLights(r101.shouldShowLights());
        r102.setSound(r101.getSound(), r101.getAudioAttributes());
        r102.setLockscreenVisibility(r101.getLockscreenVisibility());
        return r102;
    }

    /* JADX INFO: renamed from: a, reason: collision with other method in class */
    private static boolean m9339a(Context r100, String r101) {
        if (f464185a == false) goto L6;
        a("checkCopeidChannel:newFullChannelId:" + r101 + tb2.c.DEFAULT_TEXT + a(r100).getBoolean(r101, false));
    L6:
        return a(r100).getBoolean(r101, false);
    }

    public static void a(Context r100, String r101) {
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L5;
        return;
    L5:
        if (TextUtils.isEmpty(r101) == true) goto L9;
        c(r100, r101);
        f.a(r100, r101);
        return;
    }

    private static void a(af r110, NotificationChannel r111, String r112) {
        Context r100 = r110.m9350a();
        String r101 = r111.getId();
        String r102 = af.a(r101, r110.m9351a());
        boolean r103 = f464185a;
        if (r103 == false) goto L6;
        a("appChannelId:" + r101 + " oldChannelId:" + r102);
    L6:
        if (com.xiaomi.push.j.m9295a(r100) == true) goto L8;
    L41:
        NotificationChannel r104 = r110.m9349a(r101);
        if (r103 == false) goto L44;
        a("elseLogic getNotificationChannel:" + r104);
    L44:
        if (r104 != null) goto L46;
        r110.a(r111);
    L46:
        int r105 = 0;
        char r106 = 0;
    L47:
        if (r106 == 1) goto L52;
        if (r106 == 4) goto L52;
        if (r106 == 3) goto L52;
        boolean r107 = false;
    L53:
        f.a(r110.m9350a(), r110.m9351a(), r101, r111.getImportance(), r112, r107, r105);
        return;
    L52:
        r107 = true;
        goto L53
    L8:
        if (TextUtils.equals(r101, r102) == true) goto L41;
        NotificationManager r108 = (NotificationManager) r100.getSystemService("notification");
        NotificationChannel r109 = r108.getNotificationChannel(r102);
        NotificationChannel r113 = r110.m9349a(r101);
        if (r103 == false) goto L12;
        a("xmsfChannel:" + r109);
        a("appChannel:" + r113);
    L12:
        if (r109 == null) goto L24;
        NotificationChannel r114 = a(r101, r109);
        if (r103 == false) goto L16;
        a("copyXmsf copyXmsfChannel:" + r114);
    L16:
        if (r113 == null) goto L22;
        int r115 = a(r113);
        if (r115 != 0) goto L20;
        boolean r116 = true;
    L21:
        r110.a(r114, r116);
        r106 = 3;
    L23:
        b(r100, r101);
        r108.deleteNotificationChannel(r102);
    L40:
        r105 = r115;
        goto L47
    L20:
        r116 = false;
        goto L21
    L22:
        r115 = a(r109);
        a(r100, r110, r114, r115, r109.getId());
        r106 = 4;
        goto L23
    L24:
        if (r113 != null) goto L26;
        if (r103 == false) goto L39;
        a("appHack createNotificationChannel:" + r111);
    L39:
        r110.a(r111);
        r115 = 0;
        r106 = 1;
        goto L40
    L26:
        if (m9339a(r100, r101) == false) goto L28;
    L36:
        r115 = 0;
        r106 = 0;
        goto L40
    L28:
        if (a(r111, r113) == false) goto L36;
        if (r103 == false) goto L31;
        a("appHack updateNotificationChannel:" + r111);
    L31:
        r115 = a(r113);
        if (r115 != 0) goto L34;
        boolean r117 = true;
    L35:
        r110.a(r111, r117);
        r106 = 2;
        goto L40
    L34:
        r117 = false;
        goto L35
    }

    public static void a(Context r100, af r101, NotificationChannel r102, int r103, String r104) {
        if (r103 > 0) goto L4;
        r101.a(r102);
        return;
    L4:
        if (com.xiaomi.push.g.a(r100) < 2) goto L6;
        int r105 = f.a(r100.getPackageName(), r104);
    L7:
        NotificationChannel r106 = a(r102.getId(), r102);
        if ((r103 & 32) == 0) goto L14;
        if (r102.getSound() == null) goto L12;
        r106.setSound(null, null);
        goto L14
    L12:
        r106.setSound(Settings.System.DEFAULT_NOTIFICATION_URI, Notification.AUDIO_ATTRIBUTES_DEFAULT);
    L14:
        if ((r103 & 16) == 0) goto L20;
        if (r102.shouldVibrate() == false) goto L18;
        r106.enableVibration(false);
        goto L20
    L18:
        r106.enableVibration(true);
    L20:
        if ((r103 & 8) == 0) goto L26;
        if (r102.shouldShowLights() == false) goto L24;
        r106.enableLights(false);
        goto L26
    L24:
        r106.enableLights(true);
    L26:
        if ((r103 & 4) == 0) goto L32;
        int r107 = r102.getImportance() - 1;
        if (r107 > 0) goto L30;
        r107 = 2;
    L30:
        r106.setImportance(r107);
    L32:
        if ((r103 & 2) == 0) goto L34;
        r106.setLockscreenVisibility(r102.getLockscreenVisibility() - 1);
    L34:
        r101.a(r106);
        r101.a(r102, true);
        f.a(r101.m9351a(), r102.getId(), r105, 0);
        return;
    L6:
        r105 = 0;
        goto L7
    }

    public static String a(af r100, String r101, CharSequence r102, String r103, int r104, int r105, String r110, String r111) {
        String r106 = r100.m9352a(r101);
        boolean r107 = f464185a;
        if (r107 == false) goto L5;
        a("createChannel: appChannelId:" + r106 + " serverChannelId:" + r101 + " serverChannelName:" + r102 + " serverChannelDesc:" + r103 + " serverChannelNotifyType:" + r104 + " serverChannelName:" + r102 + " serverChannelImportance:" + r105 + " channelSoundStr:" + r110 + " channelPermissions:" + r111);
    L5:
        NotificationChannel r108 = new NotificationChannel(r106, r102, r105);
        r108.setDescription(r103);
        boolean r109 = false;
        if ((r104 & 2) == 0) goto L8;
        boolean r112 = true;
    L9:
        r108.enableVibration(r112);
        if ((r104 & 4) == 0) goto L12;
        r109 = true;
    L12:
        r108.enableLights(r109);
        if ((r104 & 1) != 0) goto L15;
        r108.setSound(null, null);
    L20:
        if (r107 == false) goto L22;
        a("create channel:" + r108);
    L22:
        a(r100, r108, r111);
        return r106;
    L15:
        if (TextUtils.isEmpty(r110) == true) goto L20;
        if (r110.startsWith("android.resource://" + r100.m9351a()) == false) goto L20;
        r108.setSound(UriProtector.parse(r110), Notification.AUDIO_ATTRIBUTES_DEFAULT);
        goto L20
    L8:
        r112 = false;
        goto L9
    }
}
