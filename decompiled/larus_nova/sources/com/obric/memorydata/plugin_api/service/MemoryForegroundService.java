package com.obric.memorydata.plugin_api.service;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.ss.android.agilelogger.ALog;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes6.dex */
public class MemoryForegroundService extends Service {
    private static final String CHANNEL_DESC = "Foreground service for keeping memory process alive";
    private static final String CHANNEL_ID = "memorydata_fgs";
    private static final String CHANNEL_NAME = "MemoryData Service";
    private static final int NOTIFICATION_ID = 8228;
    private static final String OBRIC_FOREGROUND_NOTIFICATION_SHOW = "obric_foreground_notification_show";
    private static final String TAG = "MemoryForegroundService";
    private static final AtomicBoolean shouldRun = null;
    private boolean startedInForeground;

    @Override // android.app.Service
    public IBinder onBind(Intent r100) {
        return null;
    }

    static {
        shouldRun = new AtomicBoolean(false);
    }

    private Notification buildNotification() {
        Notification r100 = new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.stat_notify_sync).setContentTitle(CHANNEL_NAME).setContentText("Memory service is running").setPriority(-1).setCategory("service").setOngoing(true).setOnlyAlertOnce(true).setSilent(true).build();
        r100.extras.putBoolean(OBRIC_FOREGROUND_NOTIFICATION_SHOW, false);
        return r100;
    }

    private void ensureNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        NotificationManager r100 = (NotificationManager) getSystemService("notification");
        if (r100 != null) goto L8;
        return;
    L8:
        NotificationChannel r101 = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 2);
        r101.setDescription(CHANNEL_DESC);
        r101.setSound(null, null);
        r101.enableVibration(false);
        r101.setShowBadge(false);
        r101.setLockscreenVisibility(-1);
        r100.createNotificationChannel(r101);
    }

    private void tryStartForeground() {
        if (this.startedInForeground == false) goto L13;
        return;
    L13:
        Notification r100 = buildNotification();     // Catch: Exception -> L11
        if (Build.VERSION.SDK_INT < 29) goto L8;
        startForeground(NOTIFICATION_ID, r100, 2);     // Catch: Exception -> L11
    L9:
        this.startedInForeground = true;     // Catch: Exception -> L11
        return;
    L8:
        startForeground(NOTIFICATION_ID, r100);     // Catch: Exception -> L11
    L11:
        stopSelf();
    }

    @Override // android.app.Service
    public void onDestroy() {
        if (this.startedInForeground == false) goto L5;
        stopForeground(1);
        this.startedInForeground = false;
    L5:
        super.onDestroy();
    }

    public MemoryForegroundService() {
        this.startedInForeground = false;
    }

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ensureNotificationChannel();
        tryStartForeground();
    }

    private static void dispatchForegroundServiceSync(Context r100) {
        Context r101 = r100.getApplicationContext();
        Intent r102 = new Intent(r101, MemoryForegroundService.class);
        if (Build.VERSION.SDK_INT < 26) goto L5;
        r101.startForegroundService(r102);
        return;
    L5:
        r101.startService(r102);
    }

    public static void syncShouldRun(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (shouldRun.compareAndSet(false, true) == false) goto L13;
        dispatchForegroundServiceSync(r100);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        logError("syncShouldRun failed", e);
        return;
    }

    public static void syncShouldStop(Context r100) {
        if (r100 != null) goto L5;
        return;
    L5:
        if (shouldRun.compareAndSet(true, false) == false) goto L13;
        dispatchForegroundServiceSync(r100);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        logError("syncShouldStop failed", e);
        return;
    }

    private static void logError(String r100, Throwable r101) {
        if (ALog.isInitSuccess() == false) goto L9;
        ALog.e(TAG, r100, r101);     // Catch: Throwable -> L6
        return;
    L9:
        return;
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r100, int r101, int r102) {
        if (this.startedInForeground == true) goto L6;
        tryStartForeground();
    L6:
        if (shouldRun.get() == true) goto L10;
        stopSelfResult(r102);
        return 2;
    L10:
        return 2;
    }
}
