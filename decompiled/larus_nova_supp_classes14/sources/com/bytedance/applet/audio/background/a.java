package com.bytedance.applet.audio.background;

import android.content.ComponentName;
import android.content.ServiceConnection;
import android.os.IBinder;
import aw3.g0;
import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a implements ServiceConnection {
    public a() {
    }

    @Override // android.content.ServiceConnection
    public final void onServiceDisconnected(ComponentName r3) {
        Intrinsics.checkNotNullParameter(r3, "name");
        g0.c = null;
        g0.e = false;
        FLogger.a.i("AppletBackgroundAudioMediaSessionController", "media session service disconnected");
    }

    @Override // android.content.ServiceConnection
    public final void onServiceConnected(ComponentName r3, IBinder r4) {
        Intrinsics.checkNotNullParameter(r3, "className");
        Intrinsics.checkNotNullParameter(r4, "service");
        AppletBackgroundAudioMediaSessionService r0 = null;
        if ((r4 instanceof AppletBackgroundAudioMediaSessionService.b) == false) goto L5;
        AppletBackgroundAudioMediaSessionService.b r5 = (AppletBackgroundAudioMediaSessionService.b) r4;
    L6:
        if (r5 == null) goto L8;
        r0 = r5.a;
    L8:
        g0.c = r0;
        g0.e = false;
        if (r0 != null) goto L12;
        g0.a.clear();
        FLogger.a.e("AppletBackgroundAudioMediaSessionController", "media session service bind failed. reason: binder type mismatch");
        return;
    L12:
        CopyOnWriteArrayList<Function1<AppletBackgroundAudioMediaSessionService, Unit>> r6 = g0.a;
        if (r6.isEmpty() == false) goto L16;
        g0.d();
        FLogger.a.i("AppletBackgroundAudioMediaSessionController", "media session service released. reason: no pending action");
        return;
    L16:
        Iterator r7 = new CopyOnWriteArrayList(r6).iterator();
    L18:
        if (r7.hasNext() == false) goto L20;
        ((Function1) r7.next()).invoke(r0);
        goto L18
    L20:
        g0.a.clear();
        FLogger.a.i("AppletBackgroundAudioMediaSessionController", "media session service connected");
        return;
    L5:
        r5 = null;
        goto L6
    }
}
