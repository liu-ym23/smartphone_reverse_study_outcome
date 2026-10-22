package com.bytedance.push;

import android.app.Application;
import android.app.NotificationManager;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Looper;
import android.text.TextUtils;
import com.bytedance.android.service.manager.PushServiceManager;
import com.bytedance.android.service.manager.push.PushExternalService;
import com.bytedance.android.service.manager.push.trace.Constants;
import com.bytedance.android.service.manager.push.trace.PushTraceSceneType;
import com.bytedance.common.model.PushCommonConfiguration;
import com.bytedance.common.push.ThreadPlus;
import com.bytedance.common.push.interfaze.IAccountService;
import com.bytedance.common.support.PushCommonSupport;
import com.bytedance.common.utility.StringUtils;
import com.bytedance.push.settings.LocalSettings;
import com.bytedance.push.third.PushManager;
import com.bytedance.ttnet.utils.MultiProcessFileUtils;
import com.larus.push.impl.IPushServiceImpl;
import com.ss.android.common.applog.AppLog;
import com.ss.android.message.AppProvider;
import com.ss.android.message.PushThreadHandlerManager;
import com.ss.android.message.util.ToolUtils;
import com.ss.android.pushmanager.setting.PushMultiProcessSharedProvider;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicBoolean;

/* JADX INFO: loaded from: classes3.dex */
public final class a0 {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static long f266746e;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public volatile c f266747a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AtomicBoolean f266748b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AtomicBoolean f266749c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public g87.c f266750d;

    public final c a() {
        if (this.f266747a != null) goto L15;
        AtomicBoolean r100 = this.f266748b;
        monitor-enter(r100);
    L11:
        th = move-exception;
        throw th;
    L7:
        if (this.f266747a != null) goto L9;
        this.f266747a = c.O;     // Catch: Throwable -> L11
    L9:
        monitor-exit(r100);     // Catch: Throwable -> L11
    L15:
        return this.f266747a;
    }

    public a0() {
        this.f266748b = new AtomicBoolean(false);
        this.f266749c = new AtomicBoolean(false);
    }

    public final void d() {
        e77.c r100 = (e77.c) PushSupporter.get().getProcessManagerService();
        monitor-enter(r100);
    L23:
        th = move-exception;
        throw th;
    L5:
        if (r100.f471201e == false) goto L9;
        monitor-exit(r100);
        return;
    L9:
        if (ToolUtils.isMainProcess(r100.f471198b) == true) goto L13;
        monitor-exit(r100);
        return;
    L13:
        r100.f471201e = true;     // Catch: Throwable -> L23
        r100.b();     // Catch: Throwable -> L23
        if (r100.f471200d == false) goto L17;
        monitor-exit(r100);
        return;
    L17:
        r100.f471200d = true;     // Catch: Throwable -> L23
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess");     // Catch: Throwable -> L23
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess: enableMessageReceiver");     // Catch: Throwable -> L23
        l67.b r101 = l67.a.d(r100.f471198b).c();     // Catch: Throwable -> L23
        if (r101 == null) goto L20;
        r101.b();     // Catch: Throwable -> L23
    L20:
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess: start MessageLogClientManager");     // Catch: Throwable -> L23
        x67.c.a(r100.f471198b);     // Catch: Throwable -> L23
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess: start old redbadge pull strategy");     // Catch: Throwable -> L23
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess: try register mi_push and u_m if needed");     // Catch: Throwable -> L23
        v67.s r102 = PushSupporter.get().getSenderService();     // Catch: Throwable -> L23
        Context r103 = r100.f471198b;     // Catch: Throwable -> L23
        e0 r104 = (e0) r102;     // Catch: Throwable -> L23
        r104.b(r103, 6);     // Catch: Throwable -> L23
        r104.b(r103, 1);     // Catch: Throwable -> L23
        ((e0) PushSupporter.get().getSenderService()).c(r103);     // Catch: Throwable -> L23
        monitor-exit(r100);
    }

    public final boolean b(IPushServiceImpl.b r100) {
        com.bytedance.push.notification.q r101 = (com.bytedance.push.notification.q) PushSupporter.get().getPushNotificationManagerService();
        if (r101.f266990c == true) goto L6;
        com.bytedance.push.utils.f.i("PushNotificationManager", "cur is not android13，needn't invoke requestNotificationPermission");
    L41:
        return false;
    L6:
        if (PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration().mIPushCommonConfiguration.autoRequestNotificationPermission() == false) goto L8;
        com.bytedance.push.utils.f.i("PushNotificationManager", "autoRequestNotificationPermission is true, request permission automatically，needn't invoke requestNotificationPermission");
        goto L41
    L8:
        r101.getClass();
        if (r101.f266989b == false) goto L12;
        return r101.b();
    L12:
        if (r101.f266993f == false) goto L14;
        com.bytedance.push.utils.f.b("PushNotificationManager", "has popped notification permission popup,do nothing");
        goto L41
    L14:
        r101.f266993f = true;
        Object r102 = r101.f266992e;
        monitor-enter(r102);
    L43:
        th = move-exception;
        throw th;
    L17:
        if (r101.f266991d != null) goto L19;
        r101.f266991d = r101.c().e();     // Catch: Throwable -> L43
    L19:
        int r103 = Build.VERSION.SDK_INT;     // Catch: Throwable -> L43
        if (r103 < 26) goto L40;
        NotificationManager r104 = (NotificationManager) r101.f266988a.getSystemService("notification");     // Catch: Throwable -> L43
        if (r101.f266991d.size() <= 0) goto L27;
        com.bytedance.push.utils.f.b("PushNotificationManager", "create channel of mNotificationChannelSerializableMap for popup");     // Catch: Throwable -> L43
        Iterator<Map.Entry<String, u77.e>> r105 = r101.f266991d.entrySet().iterator();     // Catch: Throwable -> L43
    L25:
        if (r105.hasNext() == false) goto L37;
        r104.createNotificationChannel(r105.next().getValue().f549043a);     // Catch: Throwable -> L43
    L37:
        r101.c().G();     // Catch: Throwable -> L43
        monitor-exit(r102);     // Catch: Throwable -> L43
        return true;
    L27:
        com.bytedance.push.utils.f.b("PushNotificationManager", "create default channel for popup");     // Catch: Throwable -> L43
        v67.h r106 = PushSupporter.get().getNotificationService();     // Catch: Throwable -> L43
        Context r107 = r101.f266988a;     // Catch: Throwable -> L43
        ((com.bytedance.push.notification.n) r106).getClass();     // Catch: Throwable -> L43
        if (r107 == null) goto L37;
        if (r103 < 26) goto L37;
        if (com.bytedance.push.notification.n.a(r107, "push") == true) goto L37;
        if (r103 < 26) goto L37;
        ThreadPlus.submitRunnable(new com.bytedance.push.notification.m(null, r107));     // Catch: Throwable -> L43
        goto L37
    L40:
        monitor-exit(r102);     // Catch: Throwable -> L43
        goto L41
    }

    public final void c(String r110, String r111, String r112) {
        HashMap r100 = new HashMap();
        r100.put("clientudid", r112);
        r100.put("device_id", r110);
        r100.put("install_id", r111);
        String r113 = null;
        if (TextUtils.isEmpty(null) == true) goto L5;
        r100.put("alias", null);
    L5:
        a87.i r114 = j77.i.f497636a;
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode(Constants.NODE_PUSH_START, "Push logic is started");
        Application r115 = a().f266761a;
        if (r100.isEmpty() == true) goto L8;
        r113 = (String) r100.get("clientudid");
        String r101 = (String) r100.get("device_id");
        String r102 = (String) r100.get("install_id");
    L10:
        if (TextUtils.isEmpty(r113) == false) goto L12;
    L154:
        HashMap r103 = new HashMap();     // Catch: Throwable -> L32
        AppLog.f408004g0.g(r103);     // Catch: Throwable -> L30
        String r104 = (String) r103.get("clientudid");     // Catch: Throwable -> L30
        String r116 = (String) r103.get("device_id");     // Catch: Throwable -> L28
        String r105 = (String) r103.get("install_id");     // Catch: Throwable -> L25
        com.bytedance.push.utils.f.b("BDPush", "getSSIDs from applog again ");     // Catch: Throwable -> L23
        r101 = r116;
        r102 = r105;
    L37:
        r113 = r104;
    L39:
        if (TextUtils.isEmpty(r113) == false) goto L41;
    L51:
        boolean r117 = false;
    L52:
        com.bytedance.push.utils.f.b("Start", "BDPush start ,isDidValid = " + r117 + " forceUpdate = false cur process is " + a().f266769i);
        if (r117 == true) goto L56;
        return;
    L56:
        if (ToolUtils.isMainProcess(r115) == false) goto L169;
        v67.u r118 = PushSupporter.get();
        if (this.f266749c.compareAndSet(false, true) == false) goto L140;
        b77.a r106 = (b77.a) rgc.b.a(b77.a.class);
        if (r106 == null) goto L63;
        r106.start();
    L63:
        ((e77.c) PushSupporter.get().getProcessManagerService()).b();
        l67.b r107 = l67.a.d(a().f266761a).c();
        if (r107 == null) goto L66;
        r107.b();
    L66:
        PushServiceManager.get().getPushTraceExternalService().getTraceScene(PushTraceSceneType.ALLIANCE_WAKEUP).enterNode(Constants.NODE_PUSH_START_ONCE, "startOnce logic is triggered");
        PushCommonConfiguration r108 = PushCommonSupport.getInstance().getPushConfigurationService().getPushCommonConfiguration();
        if (r108.mIsDebugMode == false) goto L78;
        boolean r109 = PushManager.inst().checkThirdPushConfig("BDPush", a().f266761a);
        if (r109 == false) goto L71;
        com.bytedance.push.utils.f.g("BDPush", "configuration correct");
    L72:
        if (r109 == true) goto L78;
        if (r108.mIPushCommonConfiguration.enableExceptionInDebugModeWhenFatalError() == true) goto L77;
        com.bytedance.push.utils.f.e("BDPush", "configuration error，please filter \"BDPush\" in logcat to correct the error");
        goto L78
    L77:
        throw new IllegalArgumentException("configuration error，please filter \"BDPush\" in logcat to correct the error");
    L71:
        com.bytedance.push.utils.f.e("BDPush", "configuration error!!!");
    L78:
        String r119 = ((LocalSettings) j77.i.a(AppProvider.getApp(), LocalSettings.class)).g0();
        a().E = TextUtils.isEmpty(r119);
        com.bytedance.push.utils.f.b("BDPush", "mIsNewUser：" + a().E + " pushChannelsJsonArray：" + r119);
        v67.h r120 = r118.getNotificationService();
        c.b r121 = a().f266771k;
        ((com.bytedance.push.notification.n) r120).getClass();
        if (r115 != null) goto L82;
    L85:
        com.bytedance.push.utils.f.b("BDPush", "start once,delay 15s to sync notice state");
        PushThreadHandlerManager.inst().postRunnable(new x(this, r118, r115), TimeUnit.SECONDS.toMillis(15));
        com.bytedance.push.utils.f.b("Polling", "ready to register foreground listener");
        k r122 = (k) r118.getNotificationSwitchReport();
        r122.getClass();
        PushThreadHandlerManager.inst().postRunnable(new f(r122, r115, r118));
        ((v67.r) rgc.b.a(v67.r.class)).onUserActive();
        PushServiceManager.get().getIPushStatisticsExternalService().onPushStart();
        s67.c r123 = s67.c.d(r115);
        com.ss.android.pushmanager.setting.b.b().getClass();
        long r124 = com.ss.android.pushmanager.setting.b.d().K().f536467c;
        monitor-enter(r123);
    L137:
        th = move-exception;
        throw th;
    L88:
        if (com.ss.android.pushmanager.setting.b.b().a() == true) goto L92;
        com.bytedance.push.utils.f.b("MultiProcessPushMessageDatabaseHelper", "[deleteExpiredMsg] do nothing because allowCacheMessageToDb is false");     // Catch: Throwable -> L137
        monitor-exit(r123);
    L109:
        ((f87.a) PushSupporter.get().getMessageSpreadOutService()).c();
        e77.c r125 = (e77.c) PushSupporter.get().getProcessManagerService();
        r125.getClass();
        if (ToolUtils.isMainProcess(r115) == true) goto L113;
    L121:
        PushServiceManager.get().getAliveMonitorService().onUserActive();
        t.b().d(r115);
        e77.c r126 = (e77.c) PushSupporter.get().getProcessManagerService();
        r126.b();
        if (r126.f471200d == false) goto L124;
        PushThreadHandlerManager.inst().postRunnable(new y(r115), 1000);
    L124:
        PushServiceManager.get().getIClientAiExternalService().init();
        a77.d r127 = a77.d.a();
        r127.getClass();
        com.bytedance.push.utils.f.b("PushMultiProcessMonitor", "startReport");
        PushThreadHandlerManager.inst().addHandlerCallback(r127);
        PushThreadHandlerManager.inst().getHandler().sendEmptyMessage(4171758);
        PushServiceManager.get().getPushExternalService().triggerSignalReport(PushExternalService.SIGNAL_SCENE_APP_LAUNCH);
        PushServiceManager.get().getIAllianceService().onMainProcessStart();
        PushServiceManager.get().getIDepthsI18nExternalService().start();
        PushServiceManager.get().getIPushNotificationService().tryClearSomeNotification();
        com.bytedance.push.utils.f.b("BDPush", "[startOnce]mIsNewUser:" + a().E);
        if (a().E == false) goto L130;
        s67.d.a().getClass();
        if (s67.d.f540836f == false) goto L129;
        com.bytedance.push.utils.f.b("BDPush", "[startOnce]cur has foreground");
        PushServiceManager.get().getIPermissionBootExternalService().reportDefaultNotificationStatus();
        goto L130
    L129:
        com.bytedance.push.utils.f.b("BDPush", "[startOnce]cur not has background,listen app status change");
        s67.d.a().addObserver(new z());
    L130:
        l87.a.a().b(r118, a().f266783w);
        g87.c r128 = this.f266750d;
        if (r128 == null) goto L133;
        r128.f480420a.sendEmptyMessageDelayed(10089, new Random().nextInt(60000));
    L133:
        r118.requestSettings(a().I);
    L144:
        r118.getMonitor().monitorStart();
        e0 r129 = (e0) r118.getSenderService();
        r129.getClass();
        if (Looper.getMainLooper() != Looper.myLooper()) goto L147;
        ThreadPlus.submitRunnable(new c0(r129));
    L148:
        com.bytedance.push.third.g.g().a(r115, r100);
        return;
    L147:
        r129.f266851b.c(false);
        goto L148
    L113:
        if (r125.f471204h.compareAndSet(false, true) == false) goto L121;
        r125.b();
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService onMainProcessStart, mDelayStartChildProcessMode is " + r125.f471202f + " cur is isInBackGround:" + m67.a.d());
        int r130 = r125.f471202f;
        if (r130 == 2) goto L118;
        if (r130 != 1) goto L121;
    L118:
        if (r130 != 2) goto L120;
        com.bytedance.push.utils.f.b("NON_MAIN_PROCESS_START_CONTROL", "ProcessManagerService-->startNonMainProcess after background with timeout: " + r125.f471197a);
        PushThreadHandlerManager.inst().postRunnable(new e77.a(), r125.f471197a);
    L120:
        m67.a.a().addObserver(new e77.b(r125));
        goto L121
    L92:
        long r131 = System.currentTimeMillis() - (3600000 * r124);     // Catch: Throwable -> L137
        com.bytedance.push.utils.f.b("MultiProcessPushMessageDatabaseHelper", "[deleteExpiredMsg] lastTimeStamp is " + r131 + " maxCacheTimeInHour is " + r124);     // Catch: Throwable -> L137
        SQLiteDatabase r132 = r123.f();     // Catch: Throwable -> L137
        com.bytedance.push.utils.f.b("MultiProcessPushMessageDatabaseHelper", "[deleteExpiredMsg] success open db");     // Catch: Throwable -> L137
        if (r132 != null) goto L157;
    L101:
        com.bytedance.push.utils.f.i("MultiProcessPushMessageDatabaseHelper", "db not establish and open");     // Catch: Throwable -> L105
        com.bytedance.push.utils.f.b("MultiProcessPushMessageDatabaseHelper", "[deleteExpiredMsg] finish message delete, close db");     // Catch: Throwable -> L137
        r123.a();     // Catch: Throwable -> L137
        monitor-exit(r123);
    L156:
    L105:
        th = move-exception;
        com.bytedance.push.utils.f.f("MultiProcessPushMessageDatabaseHelper", "[deleteExpiredMsg] error ", th);     // Catch: Throwable -> L134
        com.bytedance.push.utils.f.b("MultiProcessPushMessageDatabaseHelper", "[deleteExpiredMsg] finish message delete, close db");     // Catch: Throwable -> L137
        r123.a();     // Catch: Throwable -> L137
        goto L109
    L134:
        th = move-exception;
        com.bytedance.push.utils.f.b("MultiProcessPushMessageDatabaseHelper", "[deleteExpiredMsg] finish message delete, close db");     // Catch: Throwable -> L137
        r123.a();     // Catch: Throwable -> L137
        throw th;     // Catch: Throwable -> L137
    L157:
        if (r132.isOpen() == false) goto L101;
        r132.delete("message", "arrive_time <= ? and has_been_shown=1", new String[]{String.valueOf(r131)});     // Catch: Throwable -> L105
        com.bytedance.push.utils.f.b("MultiProcessPushMessageDatabaseHelper", "[deleteExpiredMsg] finish message delete, close db");     // Catch: Throwable -> L137
        r123.a();     // Catch: Throwable -> L137
        monitor-exit(r123);
        goto L156
    L82:
        if (Build.VERSION.SDK_INT < 26) goto L85;
        ThreadPlus.submitRunnable(new com.bytedance.push.notification.m(r121, r115));
        goto L85
    L140:
        l87.a r133 = l87.a.a();
        IAccountService r134 = a().f266783w;
        r133.getClass();
        com.ss.android.pushmanager.setting.b.b().getClass();
        boolean r135 = com.ss.android.pushmanager.setting.b.d().L();
        com.bytedance.push.utils.f.g("UidSync", "[checkUidUpdate]enableBackUpTokenRefresh:" + r135);
        if (r135 == false) goto L143;
        com.bytedance.push.utils.f.g("UidSync", "[checkUidUpdate]check uid change after 3000ms");
        PushThreadHandlerManager.inst().postRunnable(new l87.c(r133, r134, r118), 3000);
        goto L144
    L143:
        com.bytedance.push.utils.f.g("UidSync", "[checkUidUpdate]do nothing because enableBackUpTokenRefresh is false");
        goto L144
    L169:
        return;
    L41:
        if (TextUtils.isEmpty(r101) == true) goto L51;
        if (TextUtils.isEmpty(r102) == true) goto L51;
        com.ss.android.pushmanager.setting.b.b().getClass();
        com.ss.android.pushmanager.setting.a r136 = com.ss.android.pushmanager.setting.a.b();
        r136.getClass();
        if (com.bytedance.push.utils.f.f267065a == false) goto L162;
        com.bytedance.push.utils.f.b("PushService", "saveSSIDs start");
    L162:
        String r137 = StringUtils.mapToString(r103);     // Catch: Exception -> L49
        PushMultiProcessSharedProvider.a r138 = r136.f449564a.b();     // Catch: Exception -> L49
        r138.f449558b.put(MultiProcessFileUtils.KEY_SSIDS, r137);     // Catch: Exception -> L49
        r138.a();     // Catch: Exception -> L49
    L50:
        r117 = true;
    L23:
        Throwable th10 = th;
        r102 = r105;
    L27:
        r101 = r116;
    L36:
        com.bytedance.push.utils.f.f("BDPush", "error when getSSIDs", th10);
    L25:
        th = move-exception;
        th10 = th;
    L28:
        th = move-exception;
        th10 = th;
        r113 = r104;
    L35:
        r104 = r113;
    L30:
        th = th;
    L34:
        th10 = th;
    L32:
        th = th;
        r103 = r100;
        goto L34
    L12:
        if (TextUtils.isEmpty(r101) == true) goto L154;
        if (TextUtils.isEmpty(r102) == true) goto L154;
        r103 = r100;
        goto L39
    L8:
        r101 = null;
        r102 = null;
        goto L10
    }
}
