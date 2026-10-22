package com.larus.asr.handsfree;

import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import androidx.core.app.NotificationCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes24.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010\u0006\u001a\u00020\u0007H\u0016J\"\u0010\b\u001a\u00020\t2\b\u0010\n\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0016J\u0014\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\b\u0010\n\u001a\u0004\u0018\u00010\u000bH\u0016J\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0010\u0010\u0011\u001a\u00020\u00072\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\b\u0010\u0014\u001a\u00020\u0007H\u0002J\b\u0010\u0015\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006\u0018"}, d2 = {"Lcom/larus/asr/handsfree/HandsfreeForegroundService;", "Landroid/app/Service;", "<init>", "()V", "foregroundStarted", "", WidgetCostModule.TYPE_ON_CREATE, "", "onStartCommand", "", "intent", "Landroid/content/Intent;", "flags", "startId", "onBind", "Landroid/os/IBinder;", LiveCommonConstants.REASON_ON_DEDTROY, "startForegroundSafely", "from", "", "createNotificationChannel", "buildNotification", "Landroid/app/Notification;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class HandsfreeForegroundService extends Service {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final /* synthetic */ int f287295b = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile boolean f287296a;

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
        if (this.f287296a == true) goto L5;
    L8:
        FLogger.f375446a.i("HandsfreeForegroundService", "[HF] foreground service destroyed");
        com.larus.asr.handsfree.a.f287297a.getClass();
        com.larus.asr.handsfree.a.f287298b = false;
        super.onDestroy();
        return;
    L5:
        if (Build.VERSION.SDK_INT < 24) goto L7;
        stopForeground(1);
        goto L8
    L7:
        stopForeground(true);
        goto L8
    }

    public final Notification a() {
        Intent r100 = getPackageManager().getLaunchIntentForPackage(getPackageName());
        if (r100 == null) goto L5;
        r100.setFlags(335544320);
    L6:
        if (r100 != null) goto L9;
        r100 = new Intent();
    L9:
        if (Build.VERSION.SDK_INT < 23) goto L11;
        int r101 = 201326592;
    L12:
        PendingIntent r102 = PendingIntent.getActivity(this, 0, r100, r101);
        NotificationCompat.Builder r103 = new NotificationCompat.Builder(this, "handsfree_voice_input_channel").setSmallIcon(R.drawable.larus_ic_notification_small);
        AppHost.Companion r104 = AppHost.f326268a;
        String r105 = r104.getAppStringName();
        if (StringsKt.isBlank(r105) == false) goto L16;
        r105 = r104.getAppName();
    L16:
        return r103.setContentTitle(r105).setContentText("正在使用语音输入").setContentIntent(r102).setShowWhen(false).setSound(null).setVibrate(null).setOngoing(true).setAutoCancel(false).setPriority(-1).setVisibility(1).build();
    L11:
        r101 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
        goto L12
    L5:
        r100 = null;
        goto L6
    }

    @Override // android.app.Service
    public final void onCreate() {
        super.onCreate();
        b(WidgetCostModule.TYPE_ON_CREATE);
    }

    public HandsfreeForegroundService() {
    }

    public final void b(String r110) {
        if (this.f287296a == false) goto L21;
        return;
    L21:
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L15
        int r101 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L15
        if (r101 < 26) goto L9;
        NotificationManager r102 = (NotificationManager) getSystemService(NotificationManager.class);     // Catch: Throwable -> L15
        NotificationChannel r103 = new NotificationChannel("handsfree_voice_input_channel", "HandsFree", 2);     // Catch: Throwable -> L15
        r103.setLockscreenVisibility(1);     // Catch: Throwable -> L15
        r103.enableVibration(false);     // Catch: Throwable -> L15
        r103.setSound(null, null);     // Catch: Throwable -> L15
        r102.createNotificationChannel(r103);     // Catch: Throwable -> L15
    L9:
        Notification r104 = a();     // Catch: Throwable -> L15
        if (r101 < 34) goto L12;
        startForeground(110, r104, 128);     // Catch: Throwable -> L15
    L13:
        this.f287296a = true;     // Catch: Throwable -> L15
        FLogger.f375446a.i("HandsfreeForegroundService", "[HF] foreground service started from=".concat(r110));     // Catch: Throwable -> L15
        Object r105 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L15
    L17:
        Throwable r106 = Result.m9452exceptionOrNullimpl(r105);
        if (r106 == null) goto L23;
        FLogger.f375446a.e("HandsfreeForegroundService", "[HF] foreground service startForeground failed from=" + r110 + ", " + r106.getMessage());
        stopSelf();
        return;
    L23:
        return;
    L12:
        startForeground(110, r104);     // Catch: Throwable -> L15
    L15:
        th = move-exception;
        Result.Companion r107 = Result.Companion;
        r105 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L17
    }

    @Override // android.app.Service
    public final int onStartCommand(Intent r100, int r101, int r102) {
        b("onStartCommand");
        return 2;
    }
}
