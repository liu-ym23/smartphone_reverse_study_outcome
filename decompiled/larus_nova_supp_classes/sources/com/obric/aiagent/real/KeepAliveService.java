package com.obric.aiagent.real;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.util.EventsUtils;
import androidx.core.app.NotificationCompat;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.xmlpull.v1.XmlPullParser;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00152\u00020\u0001:\u0001\u0015B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\b\u0010\u000e\u001a\u00020\u0007H\u0016J\u0014\u0010\u000f\u001a\u0004\u0018\u00010\u00102\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0011\u001a\u00020\u0007H\u0002J\b\u0010\u0012\u001a\u00020\u0007H\u0002J\b\u0010\u0013\u001a\u00020\u0014H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0016"}, d2 = {"Lcom/obric/aiagent/real/KeepAliveService;", "Landroid/app/Service;", "<init>", "()V", "startedInForeground", XmlPullParser.NO_NAMESPACE, "onCreate", XmlPullParser.NO_NAMESPACE, "onStartCommand", XmlPullParser.NO_NAMESPACE, "intent", "Landroid/content/Intent;", "flags", "startId", "onDestroy", "onBind", "Landroid/os/IBinder;", "tryStartForeground", "ensureNotificationChannel", "buildNotification", "Landroid/app/Notification;", "Companion", "zeus_api_release"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class KeepAliveService extends Service {
    private static final String CHANNEL_DESC = "Foreground service for AIAgent keep alive";
    private static final String CHANNEL_ID = "aiagent_keep_alive_fgs";
    private static final String CHANNEL_NAME = "AIAgent Keep Alive";
    public static final a Companion = null;
    private static final int NOTIFICATION_ID = 2579;
    private static final String TAG = "AiagentKeepAliveService";
    private boolean startedInForeground;

    static {
        Companion = new a();
    }

    @Override // android.app.Service
    public IBinder onBind(Intent r1) {
        return null;
    }

    private final Notification buildNotification() {
        return new NotificationCompat.Builder(this, CHANNEL_ID).setSmallIcon(R.drawable.stat_sys_download).setContentTitle("AiAgent").setContentText("AiAgent is running").setPriority(-1).setCategory("service").setOngoing(true).setOnlyAlertOnce(true).setSilent(true).build();
    }

    private final void ensureNotificationChannel() {
        if (Build.VERSION.SDK_INT >= 26) goto L5;
        return;
    L5:
        Object r0 = getSystemService("notification");
        Intrinsics.checkNotNull(r0, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationChannel r1 = new NotificationChannel(CHANNEL_ID, CHANNEL_NAME, 1);
        r1.setDescription(CHANNEL_DESC);
        r1.setSound(null, null);
        r1.enableVibration(false);
        r1.setShowBadge(false);
        r1.setLockscreenVisibility(-1);
        ((NotificationManager) r0).createNotificationChannel(r1);
    }

    private final void tryStartForeground() {
        if (this.startedInForeground == false) goto L10;
        return;
    L10:
        startForeground(NOTIFICATION_ID, buildNotification());     // Catch: Exception -> L7
        this.startedInForeground = true;     // Catch: Exception -> L7
        return;
    L7:
        e = move-exception;
        e.toString();
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

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
        ensureNotificationChannel();
        tryStartForeground();
    }

    public KeepAliveService() {
    }

    @Override // android.app.Service
    public int onStartCommand(Intent r1, int r2, int r3) {
        if (this.startedInForeground == true) goto L7;
        tryStartForeground();
        return 2;
    L7:
        return 2;
    }
}
