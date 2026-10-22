package com.larus.voicecall.impl.notification;

import android.app.Activity;
import android.app.Application;
import android.app.Notification;
import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.app.Service;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.graphics.Bitmap;
import android.os.Build;
import android.os.IBinder;
import android.widget.RemoteViews;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import com.autonavi.amap.mapcore.AMapEngineUtils;
import com.bytedance.common.utility.DeviceUtils;
import com.larus.common.apphost.AppHost;
import com.larus.nova.R;
import com.larus.platform.service.g;
import com.larus.platform.service.z2;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.api.IRtcNotificationService;
import com.larus.voicecall.impl.ui.RealtimeCallActivity;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.obric.assistant.spi.audio.ObricAsrDelegate;
import com.obric.assistant.spi.chat.IObricChatUIService;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttvideoengine.ITTVideoEngineEventSource;
import com.vivo.push.PushClientConstants;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.MutableSharedFlow;
import v19.i5;

/* JADX INFO: loaded from: classes32.dex */
public final class d implements IRtcNotificationService {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d f378402a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final MutableSharedFlow<Integer> f378403b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static b f378404c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static a f378405d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static Function0<Unit> f378406e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static boolean f378407f;

    public static final class a implements ServiceConnection {
        public a() {
        }

        @Override // android.content.ServiceConnection
        public final void onServiceDisconnected(ComponentName r100) {
            Intrinsics.checkNotNullParameter(r100, "name");
            d.f378407f = false;
            FLogger.f375446a.i("RTCServiceManager", "bindForegroundService onServiceDisconnected");
        }

        @Override // android.content.ServiceConnection
        public final void onServiceConnected(ComponentName r100, IBinder r101) {
            Intrinsics.checkNotNullParameter(r100, PushClientConstants.TAG_CLASS_NAME);
            Intrinsics.checkNotNullParameter(r101, "service");
            FLogger.f375446a.i("RTCServiceManager", "bindForegroundService onServiceConnected");
            d r102 = d.f378402a;
            r102.getClass();
            if (z2.f365865a.Z2() == false) goto L11;
            if ((r101 instanceof RealtimeCallRTCMicAndPlaybackService.b) == false) goto L7;
            RealtimeCallRTCMicAndPlaybackService.b r103 = (RealtimeCallRTCMicAndPlaybackService.b) r101;
        L8:
            if (r103 == null) goto L16;
            b r104 = r103.f378398a;
        L17:
            d.f378404c = r104;
            if (r104 == null) goto L25;
            Service r105 = r104.getService();
            r102.getClass();
            int r106 = Build.VERSION.SDK_INT;
            if (r106 < 26) goto L25;
            NotificationChannel r107 = new NotificationChannel("call_channel", "realtimeCall", 4);
            r107.setLockscreenVisibility(1);
            if (r106 < 34) goto L24;
            r107.setBypassDnd(true);
            r107.setShowBadge(true);
        L24:
            r107.enableVibration(false);
            r107.setSound(null, null);
            ((NotificationManager) r105.getSystemService(NotificationManager.class)).createNotificationChannel(r107);
        L25:
            Function0<Unit> r108 = d.f378406e;
            if (r108 == null) goto L28;
            r108.invoke();
        L28:
            d.f378406e = null;
            return;
        L16:
            r104 = null;
            goto L17
        L7:
            r103 = null;
            goto L8
        L11:
            if ((r101 instanceof RTCService.b) == false) goto L13;
            RTCService.b r109 = (RTCService.b) r101;
        L14:
            if (r109 == null) goto L16;
            r104 = r109.f378396a;
            goto L17
        L13:
            r109 = null;
            goto L14
        }
    }

    public d() {
    }

    static {
        f378402a = new d();
        MutableSharedFlow<Integer> r100 = e.f378408a;
        f378403b = e.f378408a;
    }

    @Override // com.larus.voicecall.api.IRtcNotificationService
    public final MutableSharedFlow a() {
        return f378403b;
    }

    public static void b(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("bindForegroundService, reason: ");
        r102.append(r100);
        r102.append(", rtcService is null: ");
        boolean r103 = false;
        if (f378404c != null) goto L5;
        boolean r104 = true;
    L6:
        r102.append(r104);
        r101.i("RTCServiceManager", r102.toString());
        IObricChatUIService r105 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r105 != null) goto L9;
    L11:
        if (r103 == false) goto L16;
        if (ObricAsrDelegate.f392831b.a() == false) goto L16;
        return;
    L16:
        if (f378404c != null) goto L32;
        Result.Companion r106 = Result.Companion;     // Catch: Throwable -> L23
        a r107 = new a();     // Catch: Throwable -> L23
        AppHost.Companion r108 = AppHost.f326268a;     // Catch: Throwable -> L23
        Application r109 = r108.getApplication();     // Catch: Throwable -> L23
        Application r110 = r108.getApplication();     // Catch: Throwable -> L23
        f378402a.getClass();     // Catch: Throwable -> L23
        if (z2.f365865a.Z2() == false) goto L20;
        Class r111 = RealtimeCallRTCMicAndPlaybackService.class;
    L21:
        r109.bindService(new Intent(r110, r111), r107, 1);     // Catch: Throwable -> L23
        r101.i("RTCServiceManager", "bindForegroundService start bind service");     // Catch: Throwable -> L23
        f378405d = r107;     // Catch: Throwable -> L23
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L23
    L26:
        if (Result.m9452exceptionOrNullimpl(r112) == null) goto L28;
        FLogger.f375446a.e("RTCServiceManager", "bindForegroundService failed");
    L28:
        Result.m9448boximpl(r112);
        return;
    L20:
        r111 = RTCService.class;
    L23:
        th = move-exception;
        Result.Companion r113 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L26
    L32:
        return;
    L9:
        if (r105.n() == true) goto L11;
        r103 = true;
        goto L11
    L5:
        r104 = false;
        goto L6
    }

    public static void d(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("dismissForegroundNotification, ");
        r102.append(r100);
        r102.append(", rtcService null: ");
        if (f378404c != null) goto L5;
        boolean r103 = true;
    L6:
        r102.append(r103);
        r102.append(", connection null: ");
        if (f378405d != null) goto L9;
        boolean r104 = true;
    L10:
        r102.append(r104);
        r102.append(", notification show: ");
        r102.append(f378407f);
        r101.i("RTCServiceManager", r102.toString());
        if (Build.VERSION.SDK_INT < 24) goto L17;
        b r105 = f378404c;
        if (r105 == null) goto L22;
        Service r106 = r105.getService();
        if (r106 == null) goto L22;
        r106.stopForeground(1);
    L22:
        f378407f = false;
        return;
    L17:
        b r107 = f378404c;
        if (r107 == null) goto L22;
        Service r108 = r107.getService();
        if (r108 == null) goto L22;
        r108.stopForeground(true);
        goto L22
    L9:
        r104 = false;
        goto L10
    L5:
        r103 = false;
        goto L6
    }

    public static void e(String r100) {
        FLogger.f375446a.i("RTCServiceManager", "handleAction: " + r100);
        if (r100 == null) goto L23;
        int r101 = r100.hashCode();
        if (r101 == (-295947265)) goto L19;
        if (r101 == 3363353) goto L16;
        if (r101 == 692880776) goto L12;
        return;
    L12:
        if (r100.equals("hang_up") == false) goto L28;
        MutableSharedFlow<Integer> r102 = e.f378408a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RtcNotificationActionManager$handleHangupAction$1(null), 3, null);
        return;
    L28:
        return;
    L16:
        if (r100.equals(ITTVideoEngineEventSource.KEY_MUTE) == false) goto L25;
        MutableSharedFlow<Integer> r103 = e.f378408a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RtcNotificationActionManager$handleMuteAction$1(null), 3, null);
        return;
    L25:
        return;
    L19:
        if (r100.equals("un_mute") == false) goto L29;
        MutableSharedFlow<Integer> r104 = e.f378408a;
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new RtcNotificationActionManager$handleUnMuteAction$1(null), 3, null);
        return;
    L29:
        return;
    }

    public static void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        FLogger r101 = FLogger.f375446a;
        StringBuilder r102 = new StringBuilder("unbindForegroundService, ");
        r102.append(r100);
        r102.append(", rtcService null: ");
        boolean r103 = false;
        if (f378404c != null) goto L5;
        boolean r104 = true;
    L6:
        r102.append(r104);
        r102.append(", connection null: ");
        if (f378405d != null) goto L9;
        r103 = true;
    L9:
        r102.append(r103);
        r102.append(", notification show: ");
        r102.append(f378407f);
        r101.i("RTCServiceManager", r102.toString());
        d(r100);
        Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L19
        a r106 = f378405d;     // Catch: Throwable -> L19
        if (r106 == null) goto L13;
        AppHost.f326268a.getApplication().unbindService(r106);     // Catch: Throwable -> L19
        f378405d = null;     // Catch: Throwable -> L19
    L13:
        AppHost.Companion r107 = AppHost.f326268a;     // Catch: Throwable -> L19
        Application r108 = r107.getApplication();     // Catch: Throwable -> L19
        f378402a.getClass();     // Catch: Throwable -> L19
        if (z2.f365865a.Z2() == false) goto L16;
        Class r109 = RealtimeCallRTCMicAndPlaybackService.class;
    L17:
        Intent r110 = new Intent(r108, r109);     // Catch: Throwable -> L19
        r107.getApplication().stopService(r110);     // Catch: Throwable -> L19
        f378404c = null;     // Catch: Throwable -> L19
        r101.i("RTCServiceManager", "unbindForegroundService");     // Catch: Throwable -> L19
        Object r111 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L19
    L22:
        if (Result.m9452exceptionOrNullimpl(r111) == null) goto L27;
        FLogger.f375446a.e("RTCServiceManager", "unbindForegroundService failed");
        return;
    L27:
        return;
    L16:
        r109 = RTCService.class;
    L19:
        th = move-exception;
        Result.Companion r112 = Result.Companion;
        r111 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L22
    L5:
        r104 = false;
        goto L6
    }

    public static void f(final String r100, final IRtcNotificationService.a r101) {
        Intrinsics.checkNotNullParameter(r100, "reason");
        Intrinsics.checkNotNullParameter(r101, "data");
        FLogger r102 = FLogger.f375446a;
        StringBuilder r103 = new StringBuilder("showForegroundNotification, rtcService null: ");
        boolean r104 = false;
        if (f378404c != null) goto L5;
        boolean r105 = true;
    L6:
        r103.append(r105);
        r103.append(", connection null: ");
        if (f378405d != null) goto L9;
        boolean r106 = true;
    L10:
        r103.append(r106);
        r103.append(", notification show: ");
        r103.append(f378407f);
        r102.i("RTCServiceManager", r103.toString());
        IObricChatUIService r107 = (IObricChatUIService) ServiceManager.get().getService(IObricChatUIService.class);
        if (r107 != null) goto L13;
    L15:
        if (r104 == false) goto L20;
        if (ObricAsrDelegate.f392831b.a() == false) goto L20;
        return;
    L20:
        if (f378404c != null) goto L23;
        f378406e = new c(r100, r101);
        return;
    L23:
        if (f378407f == false) goto L44;
        AppHost.Companion r108 = AppHost.f326268a;
        NotificationManagerCompat r109 = NotificationManagerCompat.from(r108.getApplication());
        Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L27
        d r111 = f378402a;     // Catch: Throwable -> L27
        r111.getClass();     // Catch: Throwable -> L27
        r109.notify(101, c(r108.getApplication(), r101, true, r100 + "_update"));     // Catch: Throwable -> L27
        Object r112 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L27
    L29:
        Throwable r113 = Result.m9452exceptionOrNullimpl(r112);
        if (r113 == null) goto L49;
        g.f365738a.ensureNotReachHere(r113, "notificationManager notify failed");
        return;
    L49:
        return;
    L27:
        th = move-exception;
        Result.Companion r114 = Result.Companion;
        r112 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L29
    L44:
        Result.Companion r115 = Result.Companion;     // Catch: Throwable -> L34
        f378402a.getClass();     // Catch: Throwable -> L34
        g(r100, r101);     // Catch: Throwable -> L34
        Object r116 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L34
    L36:
        Throwable r117 = Result.m9452exceptionOrNullimpl(r116);
        if (r117 == null) goto L40;
        FLogger.f375446a.e("RTCServiceManager", "showForegroundNotification failed, " + r117.getMessage());
    L40:
        if (Result.m9456isSuccessimpl(r116) == false) goto L42;
        Unit r118 = (Unit) r116;
        f378407f = true;
    L42:
        Result.m9448boximpl(r116);
        return;
    L34:
        th = move-exception;
        Result.Companion r119 = Result.Companion;
        r116 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L36
    L13:
        if (r107.n() == true) goto L15;
        r104 = true;
        goto L15
    L9:
        r106 = false;
        goto L10
    L5:
        r105 = false;
        goto L6
    }

    public static void g(String r100, IRtcNotificationService.a r101) {
        z2 r102 = z2.f365865a;
        boolean r103 = r102.x0();
        if (r103 == false) goto L5;
    L6:
        if (r103 == true) goto L8;
    L18:
        b r104 = f378404c;
        if (r104 == null) goto L27;
        Service r105 = r104.getService();
        if (r105 == null) goto L28;
        r105.startForeground(101, c(AppHost.f326268a.getApplication(), r101, true, r100));
        return;
    L28:
        return;
    L27:
        return;
    L8:
        if (Build.VERSION.SDK_INT < 30) goto L18;
    L9:
        b r106 = f378404c;
        if (r106 == null) goto L24;
        Service r107 = r106.getService();
        if (r107 == null) goto L25;
        Notification r108 = c(AppHost.f326268a.getApplication(), r101, true, r100);
        if (r102.Z2() == false) goto L16;
        int r109 = 130;
    L17:
        r107.startForeground(101, r108, r109);
        return;
    L16:
        r109 = 128;
        goto L17
    L25:
        return;
    L24:
        return;
    L5:
        if (Build.VERSION.SDK_INT >= 34) goto L9;
        goto L6
    }

    public static Notification c(Context r310, IRtcNotificationService.a r311, boolean r312, String r313) {
        Intrinsics.checkNotNullParameter(r310, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r311, "rtcData");
        Intrinsics.checkNotNullParameter(r313, "reason");
        FLogger.f375446a.i("RTCServiceManager", "buildNotification, " + r313 + ", enableRoute: " + r312);
        boolean r100 = com.larus.voicecall.impl.notification.a.c(r310);
        String r101 = r310.getPackageName();
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L5;
    L14:
        boolean r102 = true;
    L16:
        if (r102 == false) goto L20;
        if (r100 == false) goto L19;
        int r103 = R.layout.larus_layout_call_notification_dark_with_margin;
    L23:
        RemoteViews r110 = new RemoteViews(r101, r103);
        int r104 = Build.VERSION.SDK_INT;
        if (r104 < 31) goto L32;
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L32;
        if (com.larus.voicecall.impl.notification.a.b() < 8) goto L30;
        r110.setViewVisibility(R.id.photo, 8);
        goto L32
    L30:
        r110.setViewLayoutMargin(R.id.photo, 4, 0.0f, 1);
    L32:
        if (r104 >= 31) goto L34;
    L36:
        r110.setTextViewText(R.id.name, r311.f377076a);
        r110.setTextViewText(R.id.title, r311.f377077b);
        Bitmap r105 = r311.f377078c;
        if (r105 == null) goto L39;
        r110.setImageViewBitmap(R.id.photo, r105);
    L40:
        Integer r106 = r311.f377079d;
        if (r106 == null) goto L43;
        r110.setImageViewResource(R.id.large_icon, r106.intValue());
        r110.setViewVisibility(R.id.large_icon, 0);
    L45:
        if (r311.f377081f == false) goto L55;
        int r107 = j0.f375426a;
        if (r311.f377080e == false) goto L49;
        int r108 = R.string.larus_unmute_button;
    L50:
        r110.setTextViewText(R.id.mute_btn, j0.d(r108));
        if (r311.f377080e == false) goto L53;
        PendingIntent r109 = e.a("un_mute");
    L54:
        r110.setOnClickPendingIntent(R.id.mute_btn, r109);
        int r111 = R.id.name;
        int r112 = 8;
        int r113 = R.id.photo;
    L56:
        r110.setOnClickPendingIntent(R.id.hangup_btn, e.a("hang_up"));
        String r114 = r310.getPackageName();
        if (com.larus.voicecall.impl.notification.a.e() == false) goto L59;
    L62:
        if (r104 >= 31) goto L64;
        boolean r115 = true;
    L65:
        if (r115 == false) goto L69;
        if (r100 == false) goto L68;
        int r116 = R.layout.larus_layout_call_notification_dark_with_margin;
    L72:
        RemoteViews r117 = new RemoteViews(r114, r116);
        if (r104 >= 31) goto L75;
    L79:
        r117.setTextViewText(r111, r311.f377076a);
        r117.setTextViewText(R.id.title, r311.f377077b);
        Bitmap r118 = r311.f377078c;
        if (r118 == null) goto L82;
        r117.setImageViewBitmap(r113, r118);
    L83:
        Integer r119 = r311.f377079d;
        if (r119 == null) goto L86;
        r117.setImageViewResource(R.id.large_icon, r119.intValue());
        r117.setViewVisibility(R.id.large_icon, 0);
    L88:
        if (r311.f377081f == false) goto L98;
        int r120 = j0.f375426a;
        if (r311.f377080e == false) goto L92;
        int r121 = R.string.larus_unmute_button;
    L93:
        r117.setTextViewText(R.id.mute_btn, j0.d(r121));
        if (r311.f377080e == false) goto L96;
        PendingIntent r122 = e.a("un_mute");
    L97:
        r117.setOnClickPendingIntent(R.id.mute_btn, r122);
    L99:
        r117.setOnClickPendingIntent(R.id.hangup_btn, e.a("hang_up"));
        IObricRealtimeCallExtService r123 = (IObricRealtimeCallExtService) ServiceManager.get().getService(IObricRealtimeCallExtService.class);
        if (r123 == null) goto L105;
        PendingIntent r124 = r123.getNotificationPendingIntent(r310, r311.f377082g, r311.f377083h);
        if (r124 == null) goto L105;
        boolean r125 = false;
    L120:
        NotificationCompat.Builder r126 = new NotificationCompat.Builder(r310, "call_channel");
        if (r100 == false) goto L123;
        int r127 = R.drawable.larus_ic_rtc_phone_fill_dark;
    L124:
        NotificationCompat.Builder r128 = r126.setSmallIcon(r127).setShowWhen(r125).setSound(null).setVibrate(null).setContentTitle(r311.f377076a).setContentText(r311.f377077b).setAutoCancel(r125).setOngoing(r125).setPriority(1).setVisibility(1);
        if (z2.f365865a.enableRealtimeCallGroup() == false) goto L127;
        r128.setGroup("realtime_call_group");
        r128.setGroupAlertBehavior(1);
    L127:
        NotificationCompat.Builder r129 = r128.setAutoCancel(true);
        if (r312 == false) goto L130;
        r129.setContentIntent(r124);
    L130:
        f378402a.getClass();
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L133;
    L144:
        boolean r130 = true;
    L145:
        if (r130 == false) goto L153;
        r129.setCustomContentView(r110);
        r129.setCustomBigContentView(r117);
        int r131 = j0.f375426a;
        if (r100 == false) goto L149;
        int r132 = R.color.larus_rtc_notification_bg_dark;
    L150:
        r129.setColor(j0.a(r132));
        if (r104 < 26) goto L164;
        r129.setColorized(true);
    L164:
        return r129.build();
    L149:
        r132 = R.color.larus_rtc_notification_bg_light;
        goto L150
    L153:
        Bitmap r133 = r311.f377078c;
        if (r133 == null) goto L157;
        r129.setLargeIcon(r133);
    L157:
        if (r311.f377081f == true) goto L159;
    L162:
        Intrinsics.checkNotNull(r129);
        Intrinsics.checkNotNullParameter(r129, "<this>");
        int r134 = j0.f375426a;
        r129.addAction(0, j0.d(R.string.larus_end_btn), e.a("hang_up"));
        goto L164
    L159:
        if (r311.f377080e == false) goto L161;
        Intrinsics.checkNotNull(r129);
        Intrinsics.checkNotNullParameter(r129, "<this>");
        int r135 = j0.f375426a;
        r129.addAction(0, j0.d(R.string.larus_unmute_button), e.a("un_mute"));
        goto L162
    L161:
        Intrinsics.checkNotNull(r129);
        Intrinsics.checkNotNullParameter(r129, "<this>");
        int r136 = j0.f375426a;
        r129.addAction(0, j0.d(R.string.larus_mute_btn), e.a(ITTVideoEngineEventSource.KEY_MUTE));
        goto L162
    L133:
        if (com.larus.voicecall.impl.notification.a.e() == true) goto L144;
        if (DeviceUtils.isHuawei() == true) goto L144;
        if (DeviceUtils.isOppo() == true) goto L144;
        if (DeviceUtils.isVivo() == true) goto L144;
        if (DeviceUtils.isFlyme() == true) goto L144;
        r130 = false;
        goto L145
    L123:
        r127 = R.drawable.larus_ic_rtc_phone_fill_light;
    L105:
        boolean r137 = r311.f377082g;
        Context r138 = r311.f377083h;
        if ((r138 instanceof Activity) == false) goto L108;
        Activity r139 = (Activity) r138;
    L109:
        if (r139 != null) goto L111;
        r139 = AppHost.f326268a.a().getCurrentActivity();
    L111:
        if (r137 == false) goto L114;
        if (r139 == null) goto L114;
        Class<?> r140 = r139.getClass();
    L115:
        Intent r141 = new Intent(r310, r140);
        r141.setFlags(603979776);
        if (r104 < 23) goto L118;
        int r142 = 201326592;
    L119:
        r125 = false;
        r124 = PendingIntent.getActivity(r310, 0, r141, r142);
        goto L120
    L118:
        r142 = AMapEngineUtils.HALF_MAX_P20_WIDTH;
    L114:
        r140 = RealtimeCallActivity.class;
        goto L115
    L108:
        r139 = null;
        goto L109
    L96:
        r122 = e.a(ITTVideoEngineEventSource.KEY_MUTE);
        goto L97
    L92:
        r121 = R.string.larus_mute_btn;
        goto L93
    L98:
        r117.setViewVisibility(R.id.mute_btn, r112);
        r117.setViewPadding(R.id.hangup_btn, 0, i5.Y(), i5.r0(), i5.h());
        goto L99
    L86:
        r117.setViewVisibility(R.id.large_icon, r112);
        goto L88
    L82:
        r117.setImageViewResource(r113, R.drawable.larus_common_ui_avatar_placeholder);
        goto L83
    L75:
        if (com.larus.voicecall.impl.notification.a.d() == false) goto L79;
        if (com.larus.voicecall.impl.notification.a.b() < r112) goto L79;
        r117.setViewVisibility(r113, r112);
        goto L79
    L68:
        r116 = R.layout.larus_layout_call_notification_with_margin;
        goto L72
    L69:
        if (r100 == false) goto L71;
        r116 = R.layout.larus_layout_call_notification_dark;
        goto L72
    L71:
        r116 = R.layout.larus_layout_call_notification;
    L64:
        r115 = false;
        goto L65
    L59:
        if (DeviceUtils.isOppo() == true) goto L62;
        if (DeviceUtils.isVivo() == false) goto L64;
    L53:
        r109 = e.a(ITTVideoEngineEventSource.KEY_MUTE);
        goto L54
    L49:
        r108 = R.string.larus_mute_btn;
        goto L50
    L55:
        r110.setViewVisibility(R.id.mute_btn, 8);
        int r210 = i5.Y();
        int r211 = i5.r0();
        int r212 = i5.h();
        r111 = R.id.name;
        r112 = 8;
        r113 = R.id.photo;
        r110.setViewPadding(R.id.hangup_btn, 0, r210, r211, r212);
        goto L56
    L43:
        r110.setViewVisibility(R.id.large_icon, 8);
        goto L45
    L39:
        r110.setImageViewResource(R.id.photo, R.drawable.larus_common_ui_avatar_placeholder);
        goto L40
    L34:
        if (DeviceUtils.isVivo() == false) goto L36;
        r110.setViewVisibility(R.id.buttons, 8);
        r110.setViewVisibility(R.id.large_icon, 8);
        goto L36
    L19:
        r103 = R.layout.larus_layout_call_notification_with_margin;
        goto L23
    L20:
        if (r100 == false) goto L22;
        r103 = R.layout.larus_layout_call_notification_dark;
        goto L23
    L22:
        r103 = R.layout.larus_layout_call_notification;
        goto L23
    L5:
        if (com.larus.voicecall.impl.notification.a.e() == true) goto L11;
        if (DeviceUtils.isVivo() == true) goto L11;
        if (DeviceUtils.isOppo() == true) goto L11;
    L13:
        r102 = false;
    L11:
        if (Build.VERSION.SDK_INT >= 31) goto L13;
        goto L13
    }
}
