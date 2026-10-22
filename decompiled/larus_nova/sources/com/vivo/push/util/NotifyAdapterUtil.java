package com.vivo.push.util;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.AudioManager;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.text.TextUtils;
import android.widget.RemoteViews;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.ss.android.lark.picker.base.widget.utils.FakePickerAvatarCreator;
import com.vivo.push.model.InsideNotificationItem;
import com.vivo.push.model.NotifyArriveCallbackByUser;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;

/* JADX INFO: loaded from: classes41.dex */
public class NotifyAdapterUtil {
    private static final String EXTRA_VPUSH_TYPE = "extra_vpush_type";
    private static final int HIDE_TITLE = 1;
    public static final int NOTIFY_MULTITERM_STYLE = 1;
    public static final int NOTIFY_SINGLE_STYLE = 0;
    public static final String PRIMARY_CHANNEL = "vivo_push_channel";
    private static final String PUSH_EN = "PUSH";
    private static final String PUSH_ID = "pushId";
    private static final String PUSH_ZH = "推送通知";
    private static final String TAG = "NotifyManager";
    private static final String USER_ID = "sysUserId";
    private static NotificationManager sNotificationManager = null;
    private static int sNotifyId = 20000000;

    public NotifyAdapterUtil() {
    }

    private static boolean isPullService() {
        if (m.f462588a == false) goto L9;
        if (Build.VERSION.SDK_INT >= 31) goto L7;
        return true;
    L7:
        return false;
    L9:
        if (Build.VERSION.SDK_INT >= 28) goto L11;
        return true;
    L11:
        return false;
    }

    public static void cancelNotify(Context r100) {
        cancelNotify(r100, sNotifyId);
    }

    private static synchronized void initAdapter(Context r100) {
        monitor-enter(NotifyAdapterUtil.class);
    L32:
        th = move-exception;
        throw th;
    L5:
        if (sNotificationManager != null) goto L8;
        sNotificationManager = (NotificationManager) r100.getSystemService("notification");     // Catch: Throwable -> L32
    L8:
        if (Build.VERSION.SDK_INT < 26) goto L30;
        NotificationManager r101 = sNotificationManager;     // Catch: Throwable -> L32
        if (r101 == null) goto L30;
        NotificationChannel r102 = r101.getNotificationChannel("default");     // Catch: Throwable -> L32
        if (r102 == null) goto L18;
        CharSequence r103 = r102.getName();     // Catch: Throwable -> L32
        if (PUSH_ZH.equals(r103) == false) goto L16;
    L17:
        sNotificationManager.deleteNotificationChannel("default");     // Catch: Throwable -> L32
        goto L18
    L16:
        if ("PUSH".equals(r103) == true) goto L17;
    L18:
        NotificationChannel r104 = sNotificationManager.getNotificationChannel(PRIMARY_CHANNEL);     // Catch: Throwable -> L32
        StringBuilder r105 = new StringBuilder("initAdapter PRIMARY_CHANNEL yi exist ？= ");     // Catch: Throwable -> L32
        if (r104 != null) goto L21;
        boolean r106 = true;
    L22:
        r105.append(r106);     // Catch: Throwable -> L32
        r105.append(" 是否支持创建推送通知渠道= ");     // Catch: Throwable -> L32
        r105.append(com.vivo.push.restructure.a.a().g().e());     // Catch: Throwable -> L32
        t.c(TAG, r105.toString());     // Catch: Throwable -> L32
        if (com.vivo.push.restructure.a.a().g().e() == false) goto L26;
        if (r104 != null) goto L30;
    L26:
        if (isZh(r100) == false) goto L28;
        String r107 = PUSH_ZH;
    L29:
        NotificationChannel r108 = new NotificationChannel(PRIMARY_CHANNEL, r107, 4);     // Catch: Throwable -> L32
        r108.setLightColor(FakePickerAvatarCreator.GREEN);     // Catch: Throwable -> L32
        r108.enableVibration(true);     // Catch: Throwable -> L32
        r108.setLockscreenVisibility(1);     // Catch: Throwable -> L32
        sNotificationManager.createNotificationChannel(r108);     // Catch: Throwable -> L32
        goto L30
    L28:
        r107 = "PUSH";
        goto L29
    L21:
        r106 = false;
    L30:
        monitor-exit(NotifyAdapterUtil.class);
    }

    private static boolean isZh(Context r100) {
        return r100.getResources().getConfiguration().locale.getLanguage().endsWith("zh");
    }

    public static void setNotifyId(int r100) {
        sNotifyId = r100;
    }

    private static boolean cancelNotify(Context r100, int r101) {
        initAdapter(r100);
        NotificationManager r102 = sNotificationManager;
        if (r102 == null) goto L6;
        r102.cancel(r101);
        return true;
    L6:
        return false;
    }

    public static boolean repealNotifyById(Context r100, long r101) {
        int r102 = com.vivo.push.m.a().j();
        if (r102 != 0) goto L11;
        long r103 = ad.c().b("com.vivo.push.notify_key", -1);
        if (r103 != r101) goto L8;
        t.d(TAG, "undo showed message ".concat(String.valueOf(r101)));
        t.a(r100, "回收已展示的通知： ".concat(String.valueOf(r101)));
        return cancelNotify(r100, sNotifyId);
    L8:
        t.d(TAG, "current showing message id " + r103 + " not match " + r101);
        t.a(r100, "与已展示的通知" + r103 + "与待回收的通知" + r101 + "不匹配");
        return false;
    L11:
        if (r102 == 1) goto L13;
        t.a(TAG, "unknow cancle notify style ".concat(String.valueOf(r102)));
        return false;
    L13:
        return cancelNotify(r100, (int) r101);
    }

    private static void pushNotificationByCustom(Context r110, List<Bitmap> r111, InsideNotificationItem r112, long r113, NotifyArriveCallbackByUser r210, com.vivo.push.h.u.a r211) {
        Resources r100 = r110.getResources();
        String r114 = r110.getPackageName();
        String r101 = r112.getTitle();
        int r102 = NotifyUtil.getNotifyDataAdapter(r110).getDefaultNotifyIcon();
        int r103 = r110.getApplicationInfo().icon;
        Bundle r104 = new Bundle();
        r104.putLong(PUSH_ID, r113);
        if (com.vivo.push.restructure.a.a().e().m().isOpenMultiUser() == false) goto L5;
        r104.putInt(USER_ID, v.a());
    L5:
        r104.putInt(EXTRA_VPUSH_TYPE, 1);
        if (Build.VERSION.SDK_INT < 26) goto L11;
        Notification.Builder r105 = new Notification.Builder(r110, PRIMARY_CHANNEL);
        if (r102 <= 0) goto L10;
        r104.putInt("vivo.summaryIconRes", r102);
    L10:
        r105.setExtras(r104);
        Notification r106 = r105.build();
    L12:
        Notification r115 = r106;
        r115.priority = 2;
        r115.flags = 16;
        r115.tickerText = r101;
        int r107 = NotifyUtil.getNotifyDataAdapter(r110).getDefaultSmallIconId();
        if (r107 > 0) goto L15;
        r107 = r103;
    L15:
        r115.icon = r107;
        RemoteViews r108 = new RemoteViews(r114, NotifyUtil.getNotifyLayoutAdapter(r110).getNotificationLayout());
        r108.setTextViewText(r100.getIdentifier("notify_title", "id", r114), r101);
        r108.setTextColor(r100.getIdentifier("notify_title", "id", r114), NotifyUtil.getNotifyLayoutAdapter(r110).getTitleColor());
        r108.setTextViewText(r100.getIdentifier("notify_msg", "id", r114), r112.getContent());
        if (r112.isShowTime() == false) goto L18;
        r108.setTextViewText(r100.getIdentifier("notify_when", "id", r114), new SimpleDateFormat("HH:mm", Locale.CHINA).format(new Date()));
        r108.setViewVisibility(r100.getIdentifier("notify_when", "id", r114), 0);
    L19:
        int r109 = NotifyUtil.getNotifyLayoutAdapter(r110).getSuitIconId();
        r108.setViewVisibility(r109, 0);
        if (r111 != null) goto L22;
    L26:
        if (r102 > 0) goto L28;
        r102 = r103;
    L28:
        r108.setImageViewResource(r109, r102);
    L29:
        if (r111 != null) goto L31;
    L33:
        Bitmap r116 = null;
    L35:
        if (r116 != null) goto L37;
        r108.setViewVisibility(r100.getIdentifier("notify_cover", "id", r114), 8);
    L41:
        r115.contentView = r108;
        if (TextUtils.isEmpty(r112.getPurePicUrl()) == false) goto L44;
        r115.bigContentView = r108;
    L44:
        AudioManager r117 = (AudioManager) r110.getSystemService("audio");
        int r118 = r117.getRingerMode();
        int r119 = r117.getVibrateSetting(0);
        t.d(TAG, "ringMode=" + r118 + " callVibrateSetting=" + r119);
        int r120 = r112.getNotifyType();
        if (r120 == 2) goto L59;
        if (r120 == 3) goto L56;
        if (r120 == 4) goto L51;
    L61:
        i r121 = new i();
        Intent r122 = r121.a(r110, r114, r113, r112, r210);
        if (r122 != null) goto L64;
        t.a(TAG, "make notify intent error  ");
        return;
    L64:
        if (isPullService() == false) goto L66;
        r115.contentIntent = PendingIntent.getService(r110, (int) SystemClock.uptimeMillis(), b.a(r110, r114, r113, r122, r112), 201326592);
    L68:
        if (sNotificationManager == null) goto L95;
        int r123 = com.vivo.push.m.a().j();
        if (r123 != 0) goto L78;
        sNotificationManager.notify(sNotifyId, r115);     // Catch: Exception -> L75
        if (r211 == null) goto L92;
        r211.a();     // Catch: Exception -> L75
        return;
    L92:
        return;
    L78:
        if (r123 != 1) goto L83;
        sNotificationManager.notify((int) r113, r115);     // Catch: Exception -> L75
        if (r211 == null) goto L93;
        r211.a();     // Catch: Exception -> L75
        return;
    L93:
        return;
    L83:
        t.a(TAG, "unknow notify style ".concat(String.valueOf(r123)));     // Catch: Exception -> L75
        return;
    L75:
        e = move-exception;
        t.a(TAG, e);
        if (r211 == null) goto L94;
        r211.b();
        return;
    L94:
        return;
    L95:
        return;
    L66:
        new com.vivo.push.b.p(r114, r113, r112).b(r122);
        r115.contentIntent = r121.a(r110, r122);
        goto L68
    L51:
        if (r118 != 2) goto L53;
        r115.defaults = 1;
    L53:
        if (r119 != 1) goto L61;
        r115.defaults |= 2;
        r115.vibrate = new long[]{0, 100, 200, 300};
        goto L61
    L56:
        if (r119 != 1) goto L61;
        r115.defaults = 2;
        r115.vibrate = new long[]{0, 100, 200, 300};
        goto L61
    L59:
        if (r118 != 2) goto L61;
        r115.defaults = 1;
        goto L61
    L37:
        if (TextUtils.isEmpty(r112.getPurePicUrl()) == true) goto L39;
        r108.setViewVisibility(r100.getIdentifier("notify_content", "id", r114), 8);
        r108.setViewVisibility(r100.getIdentifier("notify_cover", "id", r114), 8);
        r108.setViewVisibility(r100.getIdentifier("notify_pure_cover", "id", r114), 0);
        r108.setImageViewBitmap(r100.getIdentifier("notify_pure_cover", "id", r114), r116);
        goto L41
    L39:
        r108.setViewVisibility(r100.getIdentifier("notify_cover", "id", r114), 0);
        r108.setImageViewBitmap(r100.getIdentifier("notify_cover", "id", r114), r116);
        goto L41
    L31:
        if (r111.size() <= 1) goto L33;
        r116 = (Bitmap) ListProtector.get(r111, 1);
        goto L35
    L22:
        if (r111.isEmpty() == true) goto L26;
        Bitmap r124 = (Bitmap) ListProtector.get(r111, 0);
        if (r124 == null) goto L26;
        r108.setImageViewBitmap(r109, r124);
        goto L29
    L18:
        r108.setViewVisibility(r100.getIdentifier("notify_when", "id", r114), 8);
        goto L19
    L11:
        Notification.Builder r125 = new Notification.Builder(r110);
        r125.setExtras(r104);
        r106 = r125.build();
        goto L12
    }

    public static void pushNotification(Context r100, List<Bitmap> r101, InsideNotificationItem r102, long r110, int r111, NotifyArriveCallbackByUser r112, com.vivo.push.h.u.a r113) {
        t.d(TAG, "pushNotification");
        initAdapter(r100);
        int r103 = NotifyUtil.getNotifyDataAdapter(r100).getNotifyMode(r102);
        if (TextUtils.isEmpty(r102.getPurePicUrl()) == true) goto L11;
        if (r101 == null) goto L11;
        if (r101.size() <= 1) goto L11;
        if (ListProtector.get(r101, 1) == null) goto L11;
        r103 = 1;
    L11:
        if (r103 != 2) goto L14;
        pushNotificationBySystem(r100, r101, r102, r110, r111, r112, r113);
        return;
    L14:
        if (r103 != 1) goto L17;
        pushNotificationByCustom(r100, r101, r102, r110, r112, r113);
        return;
    }

    private static void pushNotificationBySystem(Context r110, List<Bitmap> r111, InsideNotificationItem r112, long r210, int r211, NotifyArriveCallbackByUser r212, com.vivo.push.h.u.a r213) {
        String r113 = r110.getPackageName();
        String r100 = r112.getTitle();
        String r101 = r112.getContent();
        int r102 = r110.getApplicationInfo().icon;
        boolean r103 = r112.isShowTime();
        AudioManager r104 = (AudioManager) r110.getSystemService("audio");
        int r105 = NotifyUtil.getNotifyDataAdapter(r110).getDefaultNotifyIcon();
        if (r111 != null) goto L5;
    L12:
        Bitmap r114 = null;
    L13:
        Bundle r115 = new Bundle();
        int r116 = Build.VERSION.SDK_INT;
        if (r116 < 26) goto L20;
        Notification.Builder r117 = new Notification.Builder(r110, PRIMARY_CHANNEL);
        if (r105 <= 0) goto L18;
        r115.putInt("vivo.summaryIconRes", r105);
    L18:
        if (r114 == null) goto L28;
        r117.setLargeIcon(r114);
    L28:
        if (com.vivo.push.restructure.a.a().e().m().isOpenMultiUser() == false) goto L30;
        r115.putInt(USER_ID, v.a());
    L30:
        r115.putInt(EXTRA_VPUSH_TYPE, 1);
        r115.putLong(PUSH_ID, r210);
        r117.setExtras(r115);
        int r106 = NotifyUtil.getNotifyDataAdapter(r110).getDefaultSmallIconId();
        if (r106 <= 0) goto L34;
        r102 = r106;
    L34:
        r117.setSmallIcon(r102);
        if (r112.getCompatibleType() == 1) goto L37;
        r117.setContentTitle(r100);
    L37:
        r117.setPriority(2);
        r117.setContentText(r101);
        if (r103 == false) goto L40;
        long r118 = System.currentTimeMillis();
    L41:
        r117.setWhen(r118);
        r117.setShowWhen(r103);
        r117.setTicker(r100);
        int r107 = r104.getRingerMode();
        int r108 = r112.getNotifyType();
        if (r108 != 2) goto L44;
        if (r107 == 2) goto L55;
    L46:
        int r109 = 1;
    L56:
        if (r111 != null) goto L58;
    L60:
        Bitmap r119 = null;
    L61:
        if (r211 == r109) goto L63;
        Notification.BigTextStyle r120 = new Notification.BigTextStyle();
        r120.setBigContentTitle(r100);
        r120.bigText(r101);
        r117.setStyle(r120);
    L63:
        if (r119 == null) goto L65;
        Notification.BigPictureStyle r121 = new Notification.BigPictureStyle();
        r121.setBigContentTitle(r100);
        r121.setSummaryText(r101);
        r121.bigPicture(r119);
        r117.setStyle(r121);
    L65:
        r117.setAutoCancel(true);
        i r122 = new i();
        Intent r123 = r122.a(r110, r113, r210, r112, r212);
        if (r123 != null) goto L68;
        t.a(TAG, "make notify intent error  ");
        return;
    L68:
        if (isPullService() == false) goto L70;
        Intent r124 = b.a(r110, r113, r210, r123, r112);
        r117.setContentIntent(PendingIntent.getService(r110, (int) SystemClock.uptimeMillis(), r124, 201326592));
    L71:
        Notification r125 = r117.build();
        int r126 = com.vivo.push.m.a().j();
        NotificationManager r127 = sNotificationManager;
        if (r127 == null) goto L97;
        if (r126 != 0) goto L81;
        r127.notify(sNotifyId, r125);     // Catch: Exception -> L78
        if (r213 == null) goto L95;
        r213.a();     // Catch: Exception -> L78
        return;
    L95:
        return;
    L81:
        if (r126 != 1) goto L86;
        r127.notify((int) r210, r125);     // Catch: Exception -> L78
        if (r213 == null) goto L96;
        r213.a();     // Catch: Exception -> L78
        return;
    L96:
        return;
    L86:
        t.a(TAG, "unknow notify style ".concat(String.valueOf(r126)));     // Catch: Exception -> L78
        return;
    L78:
        e = move-exception;
        t.a(TAG, e);
        if (r213 == null) goto L98;
        r213.b();
        return;
    L98:
        return;
    L97:
        return;
    L70:
        new com.vivo.push.b.p(r113, r210, r112).b(r123);
        r117.setContentIntent(r122.a(r110, r123));
        goto L71
    L58:
        if (r111.size() <= r109) goto L60;
        r119 = (Bitmap) ListProtector.get(r111, r109);
        goto L61
    L55:
        r109 = 1;
        r117.setDefaults(1);
        goto L56
    L44:
        if (r108 == 3) goto L52;
        if (r108 != 4) goto L46;
        if (r107 != 2) goto L50;
        r117.setDefaults(3);
        r117.setVibrate(new long[]{0, 100, 200, 300});
        goto L46
    L50:
        if (r107 != 1) goto L46;
        r117.setDefaults(2);
        r117.setVibrate(new long[]{0, 100, 200, 300});
        goto L46
    L52:
        if (r107 != 2) goto L46;
        r117.setDefaults(2);
        r117.setVibrate(new long[]{0, 100, 200, 300});
        goto L46
    L40:
        r118 = 0;
        goto L41
    L20:
        Notification.Builder r128 = new Notification.Builder(r110);
        if (r114 == null) goto L24;
        r128.setLargeIcon(r114);
    L26:
        r117 = r128;
        goto L28
    L24:
        if (r116 > 22) goto L26;
        r128.setLargeIcon(BitmapFactory.decodeResource(r110.getResources(), r102));
        goto L26
    L5:
        if (r111.isEmpty() == true) goto L12;
        r114 = (Bitmap) ListProtector.get(r111, 0);
        if (r114 == null) goto L13;
        if (r105 <= 0) goto L13;
        Bitmap r129 = BitmapFactory.decodeResource(r110.getResources(), r105);
        if (r129 == null) goto L13;
        int r130 = r129.getWidth();
        int r131 = r129.getHeight();
        r129.recycle();
        r114 = d.a(r114, r130, r131);
        goto L13
    }
}
