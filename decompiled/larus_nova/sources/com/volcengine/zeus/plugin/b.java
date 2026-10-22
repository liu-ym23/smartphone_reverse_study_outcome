package com.volcengine.zeus.plugin;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Context;
import android.os.Build;
import android.os.VibrationEffect;
import android.os.Vibrator;
import com.volcengine.zeus.log.ZeusLogger;
import java.util.concurrent.ConcurrentHashMap;

/* JADX INFO: loaded from: classes41.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final ConcurrentHashMap<String, Long> f462773a = null;

    static {
        f462773a = new ConcurrentHashMap();
    }

    public static void a(Context r100) {
        if (Build.VERSION.SDK_INT >= 26) goto L16;
        return;
    L16:
        NotificationManager r101 = (NotificationManager) r100.getSystemService(NotificationManager.class);     // Catch: Throwable -> L13
        if (r101 != null) goto L10;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier ensureNotificationChannel failed because notificationManager is null");     // Catch: Throwable -> L13
        return;
    L10:
        if (r101.getNotificationChannel("zeus_internal_plugin_protocol_mismatch") != null) goto L17;
        NotificationChannel r102 = new NotificationChannel("zeus_internal_plugin_protocol_mismatch", "Zeus Internal Plugin Alerts", 4);     // Catch: Throwable -> L13
        r102.setDescription("Alerts for internal plugin protocol mismatch");     // Catch: Throwable -> L13
        r101.createNotificationChannel(r102);     // Catch: Throwable -> L13
        return;
    L17:
        return;
    L13:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier create notification channel failed", th);
    }

    public static Vibrator b(Context r100) {
        Object r101 = null;
        if (Build.VERSION.SDK_INT >= 31) goto L20;
    L14:
        Object r102 = r100.getSystemService("vibrator");
        if ((r102 instanceof Vibrator) == false) goto L19;
        r101 = r102;
    L19:
        return (Vibrator) r101;
    L20:
        Object r103 = r100.getSystemService("vibrator_manager");     // Catch: Throwable -> L12
        if (r103 == null) goto L11;
        Object r104 = r103.getClass().getMethod("getDefaultVibrator", new Class[0]).invoke(r103, new Object[0]);     // Catch: Throwable -> L12
        if ((r104 instanceof Vibrator) == true) goto L9;
        r104 = null;
    L9:
        return (Vibrator) r104;
    L11:
        return null;
    L12:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier get vibrator manager failed, fallback to legacy vibrator", th);
        goto L14
    }

    public static void c(Context r100, String r101) {
        Vibrator r102 = b(r100);     // Catch: Throwable -> L16
        if (r102 != null) goto L8;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier vibrate skipped because vibrator is null. pluginPkgName=".concat(r101));     // Catch: Throwable -> L16
        return;
    L8:
        if (r102.hasVibrator() == true) goto L12;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier vibrate skipped because device has no vibrator. pluginPkgName=".concat(r101));     // Catch: Throwable -> L16
        return;
    L12:
        if (Build.VERSION.SDK_INT < 26) goto L14;
        r102.vibrate(VibrationEffect.createOneShot(10000, -1));     // Catch: Throwable -> L16
        return;
    L14:
        r102.vibrate(10000);     // Catch: Throwable -> L16
        return;
    L16:
        th = move-exception;
        ZeusLogger.w(ZeusLogger.TAG_INSTALL, "InternalPluginProtocolMismatchNotifier vibrate failed. pluginPkgName=".concat(r101), th);
    }
}
