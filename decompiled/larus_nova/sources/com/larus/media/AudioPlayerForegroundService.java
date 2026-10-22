package com.larus.media;

import android.R;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.baidu.platform.comapi.map.NodeType;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u0000 \u00112\u00020\u0001:\u0001\u0011B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0014\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\u0006\u001a\u0004\u0018\u00010\u00072\u0006\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\tH\u0016J\b\u0010\f\u001a\u00020\rH\u0016J\b\u0010\u000e\u001a\u00020\u000fH\u0002J\b\u0010\u0010\u001a\u00020\rH\u0002¨\u0006\u0012"}, d2 = {"Lcom/larus/media/AudioPlayerForegroundService;", "Landroid/app/Service;", "<init>", "()V", "onBind", "Landroid/os/IBinder;", "intent", "Landroid/content/Intent;", "onStartCommand", "", "flags", "startId", LiveCommonConstants.REASON_ON_DEDTROY, "", "createNotification", "Landroid/app/Notification;", "ensureChannel", "Companion", "OApp.flowSDK.baseSDK.common.avsdk-media"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioPlayerForegroundService extends Service {

    public static final class a {
    }

    static {
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        return null;
    }

    @Override // android.app.Service
    public final void onDestroy() {
        stopForeground(true);
        super.onDestroy();
    }

    public AudioPlayerForegroundService() {
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        int r103 = Build.VERSION.SDK_INT;
        if (r103 < 26) goto L9;
        Object r104 = getSystemService("notification");
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.app.NotificationManager");
        NotificationManager r105 = (NotificationManager) r104;
        if (r105.getNotificationChannel("flow_media_playback") != null) goto L9;
        NotificationChannel r106 = new NotificationChannel("flow_media_playback", "音频播放", 2);
        r106.setShowBadge(false);
        r106.setLockscreenVisibility(0);
        r105.createNotificationChannel(r106);
    L9:
        Notification r107 = new NotificationCompat.Builder(this, "flow_media_playback").setContentTitle("音频播放").setContentText("正在播放音频").setSmallIcon(R.drawable.ic_media_play).setOngoing(true).setCategory("service").setPriority(-1).build();
        if (r103 < 29) goto L12;
        startForeground(NodeType.E_STREET_ARROW, r107, 2);
    L13:
        return 2;
    L12:
        startForeground(NodeType.E_STREET_ARROW, r107);
        goto L13
    }
}
