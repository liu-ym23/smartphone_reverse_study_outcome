package com.bytedance.notification.helper;

import android.app.Application;
import android.app.Notification;
import android.graphics.Bitmap;
import android.media.MediaMetadataRetriever;
import android.os.Looper;
import android.widget.RemoteViews;
import com.bytedance.android.service.manager.push.notification.NotificationBody;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.bytedance.notification.extra.PushNotificationExtra;
import com.bytedance.push.utils.f;
import com.larus.nova.R;
import com.ss.android.message.AppProvider;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import org.json.JSONObject;
import u77.i;

/* JADX INFO: loaded from: classes21.dex */
public final class b {
    public static void a(Notification.Builder r210, NotificationBody r211) {
        if (Looper.getMainLooper() != Looper.myLooper()) goto L6;
        f.e("GifNotificationHelper", "Don't call time-consuming methods on the main thread.");
        return;
    L6:
        Application r100 = AppProvider.getApp();
        RemoteViews r101 = new RemoteViews(r100.getPackageName(), R.layout.gif_notification_content_layout);
        String r102 = r100.getPackageName();
        com.ss.android.pushmanager.setting.b.b().getClass();
        i r103 = com.ss.android.pushmanager.setting.b.d().B();
        if (r103 != null) goto L9;
    L11:
        int r104 = R.layout.gif_notification_big_content_right_layout;
    L12:
        RemoteViews r105 = new RemoteViews(r102, r104);
        PushNotificationExtra r106 = new PushNotificationExtra(r211.bdPushStr);
        if (r106.A == false) goto L15;
    L17:
        String r107 = "";
    L18:
        r101.setTextViewText(R.id.notification_title, r211.title);
        r101.setTextViewText(R.id.notification_content, r211.content);
        r105.setTextViewText(R.id.notification_title, r211.title);
        r105.setTextViewText(R.id.notification_content, r211.content);
        f.b("GifNotificationHelper", "getAllFramesForGif: " + r107);
        com.ss.android.pushmanager.setting.b.b().getClass();
        i r108 = com.ss.android.pushmanager.setting.b.d().B();
        if (r108 == null) goto L23;
        int r109 = r108.notificationGifFrameInterval;
        if (r109 <= 0) goto L23;
    L24:
        com.ss.android.pushmanager.setting.b.b().getClass();
        i r110 = com.ss.android.pushmanager.setting.b.d().B();
        if (r110 == null) goto L29;
        int r111 = r110.notificationGifMaxPixelSize;
        if (r111 <= 0) goto L29;
    L30:
        ArrayList r112 = new ArrayList();
        MediaMetadataRetriever r113 = new MediaMetadataRetriever();
        f.b("GifUtils", "videoPath: " + r107);
        r113.setDataSource(r107);     // Catch: Throwable -> L44 Exception -> L62
        long r114 = Long.parseLong(x37.a.a(r113)) * 1000;
        int r115 = r111;
        long r116 = ((long) r109) * 1000;
        long r117 = 0;
    L34:
        if (r117 >= r114) goto L66;
        Bitmap r118 = r113.getFrameAtTime(r117, 3);     // Catch: Throwable -> L44 Exception -> L62
        if (r118 == null) goto L64;
        Iterator r212 = r112.iterator();     // Catch: Throwable -> L44 Exception -> L62
        long r213 = r114;
        int r119 = 0;
    L40:
        if (r212.hasNext() == false) goto L48;
        Bitmap r120 = (Bitmap) r212.next();     // Catch: Throwable -> L44 Exception -> L62
        if (r120 == null) goto L40;
        r119 = r119 + r120.getByteCount();     // Catch: Throwable -> L44 Exception -> L62
        goto L40
    L48:
        RemoteViews r121 = r105;
        int r122 = (r119 / Math.max(r112.size(), 1)) * (r112.size() + 1);     // Catch: Throwable -> L44 Exception -> L60
        com.ss.android.pushmanager.setting.b.b().getClass();     // Catch: Throwable -> L44 Exception -> L60
        i r123 = com.ss.android.pushmanager.setting.b.d().B();     // Catch: Throwable -> L44 Exception -> L60
        if (r123 == null) goto L54;
        int r124 = r123.notificationGifMaxBytes;     // Catch: Throwable -> L44 Exception -> L60
        if (r124 <= 0) goto L54;
    L55:
        if (r122 < r124) goto L59;
        f.b("GifUtils", "Bitmap: " + r112.size());     // Catch: Throwable -> L44 Exception -> L60
        f.b("GifUtils", "Size: " + r119);     // Catch: Throwable -> L44 Exception -> L60
        if (r112.isEmpty() == true) goto L59;
    L78:
        r113.release();
    L79:
        f.b("GifNotificationHelper", "frames: " + r112.size());
        if (r112.size() <= 0) goto L104;
        int r125 = r112.size();
        final int r126 = R.layout.gif_notification_big_image_1_1_layout;
        if (r125 == 0) goto L93;
        HashMap r127 = new HashMap();
        r127.put(Float.valueOf(1.0f), Integer.valueOf(R.layout.gif_notification_big_image_1_1_layout));
        r127.put(Float.valueOf(0.5625f), Integer.valueOf(R.layout.gif_notification_big_image_9_16_layout));
        r127.put(Float.valueOf(1.7777778f), Integer.valueOf(R.layout.gif_notification_big_image_16_9_layout));
        r127.put(Float.valueOf(1.3333334f), Integer.valueOf(R.layout.gif_notification_big_image_4_3_layout));
        Bitmap r128 = (Bitmap) ListProtector.get(r112, 0);
        int r129 = r128.getWidth();
        int r130 = r128.getHeight();
        if (r130 == 0) goto L93;
        float r131 = r129 / r130;
        Iterator r132 = r127.entrySet().iterator();
        float r133 = Float.MAX_VALUE;
    L89:
        if (r132.hasNext() == false) goto L93;
        Map.Entry r134 = (Map.Entry) r132.next();
        float r135 = ((Float) r134.getKey()).floatValue();
        int r136 = ((Integer) r134.getValue()).intValue();
        float r137 = Math.abs(r131 - r135);
        if (r137 >= r133) goto L89;
        r126 = r136;
        r133 = r137;
    L93:
        Iterator r138 = r112.iterator();
    L95:
        if (r138.hasNext() == false) goto L97;
        final Bitmap r139 = (Bitmap) r138.next();
        final String r140 = r100.getPackageName();
        r101.addView(R.id.notification_image, new GifNotificationHelper$1(r140, r139));
        final String r141 = r100.getPackageName();
        r121.addView(R.id.notification_image, new GifNotificationHelper$2(r141, r126, r139));
        goto L95
    L97:
        RemoteViews r142 = r121;
        r210.setStyle(new Notification.DecoratedCustomViewStyle());
        r210.setContentTitle(r211.title);
        r210.setContentText(r211.content);
        r210.setCustomContentView(r101);
        com.ss.android.pushmanager.setting.b.b().getClass();
        i r143 = com.ss.android.pushmanager.setting.b.d().B();
        if (r143 == null) goto L100;
        boolean r144 = r143.notificationGifEnableExpansion;
    L101:
        if (r144 == false) goto L103;
        r210.setCustomBigContentView(r142);
        return;
    L103:
        r210.setCustomBigContentView(r101);
        return;
    L100:
        r144 = true;
        goto L101
    L104:
        r210.setContentTitle(r211.title).setContentText(r211.content).setLargeIcon(r211.imageBitmap);
        return;
    L59:
        int r145 = r115;
        r112.add(ifc.a.c(r118, r145, r145 / 15.0f));     // Catch: Throwable -> L44 Exception -> L60
        r117 = r117 + r116;     // Catch: Throwable -> L44 Exception -> L60
        r115 = r145;
        r105 = r121;
        r114 = r213;
    L54:
        r124 = 200;
    L60:
        e = e;
    L73:
        f.e("GifUtils", e.getMessage());     // Catch: Throwable -> L44
        f.e("GifUtils", Arrays.toString(e.getStackTrace()));     // Catch: Throwable -> L44
        JSONObject r146 = new JSONObject();     // Catch: Throwable -> L44 Exception -> L76
        r146.put("GifUtils", e.getStackTrace());     // Catch: Throwable -> L44 Exception -> L76
        z67.i.a("push_monitor_gif_notification", r146, null, null);     // Catch: Throwable -> L44 Exception -> L76
    L76:
        e = move-exception;
        f.e("GifUtils", e.getMessage());     // Catch: Throwable -> L44
        goto L78
    L64:
        r121 = r105;
        f.e("GifUtils", "Time Error:" + r117);     // Catch: Throwable -> L44 Exception -> L60
        goto L78
    L66:
        r121 = r105;
        r113.release();
        f.b("GifUtils", "Bitmap: " + r112.size());
        StringBuilder r147 = new StringBuilder("Size: ");
        Iterator r148 = r112.iterator();
        int r149 = 0;
    L68:
        if (r148.hasNext() == false) goto L72;
        Bitmap r150 = (Bitmap) r148.next();
        if (r150 == null) goto L68;
        r149 = r149 + r150.getByteCount();
        goto L68
    L72:
        r147.append(r149);
        f.b("GifUtils", r147.toString());
    L44:
        th = move-exception;
        r113.release();
        throw th;
    L62:
        e = e;
        r121 = r105;
    L29:
        r111 = 5000000;
    L23:
        r109 = 200;
        goto L24
    L15:
        if (r106.H.isEmpty() == true) goto L17;
        r107 = r106.H;
        goto L18
    L9:
        if (r103.notificationGifPosition.equals("bottom") == false) goto L11;
        r104 = R.layout.gif_notification_big_content_bottom_layout;
        goto L12
    }
}
