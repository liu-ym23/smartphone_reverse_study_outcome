package com.bytedance.push.utils;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.net.Uri;
import android.os.Environment;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import androidx.core.content.FileProvider;
import com.byted.cast.linkcommon.cybergarage.http.HTTP;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.mt.protector.impl.string2number.CastIntegerProtector;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.dtf.face.ui.toyger.FaceShowElderlyFragment;
import com.ss.android.message.util.ToolUtils;
import com.ss.ttvideoengine.TTVideoEngineInterface;
import java.io.File;

/* JADX INFO: loaded from: classes21.dex */
public final class a {
    public static Uri c(Context r100, int r101) {
        return UriProtector.parse("android.resource://" + r100.getPackageName() + HTTP.URL_DEFAULT + r101);
    }

    public static String d(Context r100, String r101) {
        File r102 = r100.getExternalFilesDir(Environment.DIRECTORY_RINGTONES);
        if (r102.exists() == true) goto L9;
        if (r102.mkdir() == true) goto L9;
        return "";
    L9:
        return r102.getAbsolutePath() + HTTP.URL_DEFAULT + r101 + FaceShowElderlyFragment.AUDIO_FORM;
    }

    public static Uri e(Context r100, String r101) {
        if (ToolUtils.isTargetBrandDevice(ToolUtils.HW) == true) goto L13;
        if (ToolUtils.isTargetBrandDevice(ToolUtils.HONOR) == true) goto L13;
        if (ToolUtils.isTargetBrandDevice(ToolUtils.OPPO) == true) goto L13;
        if (ToolUtils.isTargetBrandDevice(ToolUtils.VIVO) == true) goto L13;
        return FileProvider.getUriForFile(r100, r100.getPackageName() + ".push.file_provider", new PolarisFileWrapper(r101));
    L13:
        return Uri.fromFile(new PolarisFileWrapper(r101));
    }

    public static int b(String r100, int[] r101, String r102) {
        if (TextUtils.isEmpty(r100) == false) goto L6;
    L4:
        int r103 = -1;
    L9:
        if (r103 == (-1)) goto L11;
    L16:
        if (r103 < 0) goto L27;
        if (r101 != null) goto L19;
        return -1;
    L19:
        if (r101.length > r103) goto L21;
        return -1;
    L21:
        return r101[r103];
    L27:
        return -1;
    L11:
        if (TextUtils.isEmpty(r102) == false) goto L25;
    L12:
        r103 = -1;
        goto L16
    L25:
        r103 = CastIntegerProtector.parseInt(r102);     // Catch: Throwable -> L15
    L6:
        if (r100.startsWith("custom_sound") == false) goto L23;
        r100 = r100.substring(r100.length() - 1);
    L23:
        r103 = CastIntegerProtector.parseInt(r100);     // Catch: Throwable -> L22
        goto L9
    }

    public static boolean a(Context r100, com.bytedance.push.notification.c r101, String r102, String r103, com.bytedance.push.notification.j r104) {
        if (r101 != null) goto L5;
    L28:
        return false;
    L5:
        if (TextUtils.isEmpty(r102) == true) goto L28;
        if (r102.contains("http://") == true) goto L12;
        if (r102.contains("https://") == false) goto L28;
    L12:
        if (r102.endsWith(TTVideoEngineInterface.FORMAT_TYPE_MP3) == false) goto L28;
        String r105 = d(r100, r103);     // Catch: Throwable -> L26
        if (TextUtils.isEmpty(r105) == false) goto L17;
        return false;
    L17:
        if (new PolarisFileWrapper(r105).exists() == false) goto L22;
        r104.f266964a.setSound(e(r104.f266965b, r105), Notification.AUDIO_ATTRIBUTES_DEFAULT);     // Catch: Throwable -> L26
        com.bytedance.push.notification.i.c r106 = r104.f266967d;     // Catch: Throwable -> L26
        NotificationManager r107 = r104.f266966c;     // Catch: Throwable -> L26
        NotificationChannel r108 = r104.f266964a;     // Catch: Throwable -> L26
        r106.getClass();     // Catch: Throwable -> L26
        r107.createNotificationChannel(r108);     // Catch: Throwable -> L29
    L20:
        return true;
    L22:
        if (r101.f266948b != null) goto L24;
        r101.f266948b = new Handler(Looper.getMainLooper());     // Catch: Throwable -> L26
    L24:
        ThreadPlus.submitRunnable(new com.bytedance.push.notification.b(r101, r102, r105, r104));     // Catch: Throwable -> L26
        return true;
    L26:
        th = move-exception;
        f.g("CustomSoundUtils", "Failed to create custom sound channel, create default channel！" + th.getMessage());
        goto L28
    }
}
