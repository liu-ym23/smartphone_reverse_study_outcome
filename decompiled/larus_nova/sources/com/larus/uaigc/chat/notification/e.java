package com.larus.uaigc.chat.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.vivo.push.PushClientConstants;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class e implements ServiceConnection {
    public e() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        f.f371335c = true;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "service");
        CreationService r102 = f.f371333a;
        if ((r101 instanceof CreationService.a) == false) goto L5;
        CreationService.a r103 = (CreationService.a) r101;
    L6:
        if (r103 == null) goto L8;
        CreationService r104 = r103.f371326a;
    L9:
        f.f371333a = r104;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 26) goto L14;
        NotificationChannel r105 = new NotificationChannel("ugc_creation_channel", "creation_task", 3);
        r105.setLockscreenVisibility(1);
        r105.enableVibration(false);
        r105.setSound(null, null);
        ((NotificationManager) r104.getSystemService(NotificationManager.class)).createNotificationChannel(r105);
    L14:
        d r106 = f.f371334b;
        if (r106 == null) goto L18;
        r106.invoke();
        return;
    L18:
        return;
    L8:
        r104 = null;
        goto L9
    L5:
        r103 = null;
        goto L6
    }
}
