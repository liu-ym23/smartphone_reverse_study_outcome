package com.larus.voicecall.impl.notification;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\u0018\u0000 \u00122\u00020\u00012\u00020\u0002:\u0002\u0012\u0013B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\"\u0010\u0007\u001a\u00020\b2\b\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\b2\u0006\u0010\f\u001a\u00020\bH\u0016J\u0014\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\u0010\t\u001a\u0004\u0018\u00010\nH\u0016J\b\u0010\u000f\u001a\u00020\u0010H\u0016J\b\u0010\u0011\u001a\u00020\u0001H\u0016R\u0012\u0010\u0005\u001a\u00060\u0006R\u00020\u0000X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006\u0014"}, d2 = {"Lcom/larus/voicecall/impl/notification/RealtimeCallRTCMicAndPlaybackService;", "Landroid/app/Service;", "Lcom/larus/voicecall/impl/notification/IRtcService;", "<init>", "()V", "binder", "Lcom/larus/voicecall/impl/notification/RealtimeCallRTCMicAndPlaybackService$RTCMicAndPlaybackServiceBinder;", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", LiveCommonConstants.REASON_ON_DEDTROY, "", "getService", "Companion", "RTCMicAndPlaybackServiceBinder", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallRTCMicAndPlaybackService extends Service implements com.larus.voicecall.impl.notification.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final b f378397a;

    public static final class a {
    }

    public final class b extends Binder {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ RealtimeCallRTCMicAndPlaybackService f378398a;

        public b(RealtimeCallRTCMicAndPlaybackService r100) {
            this.f378398a = r100;
        }
    }

    static {
    }

    @Override // com.larus.voicecall.impl.notification.b
    public final Service getService() {
        return this;
    }

    public RealtimeCallRTCMicAndPlaybackService() {
        this.f378397a = new b(this);
    }

    @Override // android.app.Service
    public final void onDestroy() {
        super.onDestroy();
        FLogger.f375446a.i("RTCService2", LiveCommonConstants.REASON_ON_DEDTROY);
        stopForeground(true);
    }

    @Override // android.app.Service
    public final IBinder onBind(Intent r100) {
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("onBind: ");
        if (r100 == null) goto L5;
        String r103 = r100.getAction();
    L6:
        r102.append(r103);
        r101.i("RTCService2", r102.toString());
        return this.f378397a;
    L5:
        r103 = null;
        goto L6
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("onStartCommand: ");
        String r105 = null;
        if (r100 == null) goto L5;
        String r106 = r100.getAction();
    L6:
        r104.append(r106);
        r104.append(", flags: ");
        r104.append(r101);
        r104.append(", startId: ");
        r104.append(r102);
        r103.i("RTCService2", r104.toString());
        d r107 = d.f378402a;
        if (r100 == null) goto L9;
        r105 = r100.getAction();
    L9:
        r107.getClass();
        d.e(r105);
        return super.onStartCommand(r100, r101, r102);
    L5:
        r106 = null;
        goto L6
    }
}
