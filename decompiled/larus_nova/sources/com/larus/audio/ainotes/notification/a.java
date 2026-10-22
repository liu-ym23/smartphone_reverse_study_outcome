package com.larus.audio.ainotes.notification;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.Build;
import android.os.IBinder;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.vivo.push.PushClientConstants;
import h58.b;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class a implements ServiceConnection {
    public a() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        b.f483886c = false;
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r100, IBinder r101) {
        Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
        Intrinsics.checkNotNullParameter(r101, "service");
        AiNoteService r102 = b.f483884a;
        if ((r101 instanceof AiNoteService.a) == false) goto L5;
        AiNoteService.a r103 = (AiNoteService.a) r101;
    L6:
        if (r103 == null) goto L8;
        AiNoteService r104 = r103.f288337a;
    L9:
        b.f483884a = r104;
        if (r104 == null) goto L14;
        Intrinsics.checkNotNullParameter(r104, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (Build.VERSION.SDK_INT < 26) goto L14;
        NotificationChannel r105 = new NotificationChannel("ai_note_channel", "AiNote", 3);
        r105.setLockscreenVisibility(1);
        r105.enableVibration(false);
        r105.setSound(null, null);
        ((NotificationManager) r104.getSystemService(NotificationManager.class)).createNotificationChannel(r105);
    L14:
        h58.a r106 = b.f483885b;
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
