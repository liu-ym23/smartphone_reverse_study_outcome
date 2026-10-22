package com.larus.push.impl;

import android.app.Activity;
import android.app.Application;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.SystemClock;
import androidx.core.content.ContextCompat;
import com.bytedance.bdp.appbase.base.event.BdpAppEventConstant;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.applog.api.IApplog;
import com.larus.avlink.api.DoraAVLinkDelegate;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.utils.logger.FLogger;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.HashMap;
import java.util.TimeZone;
import java.util.UUID;
import kotlin.collections.CollectionsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;
import t39.r;

/* JADX INFO: loaded from: classes4.dex */
public final class NotificationReceiverManager {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final NotificationReceiverManager f367072a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final CoroutineScope f367073b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Object f367074c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final HashMap<String, Long> f367075d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static volatile boolean f367076e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final NotificationReceiverManager$userPresentReceiver$1 f367077f = null;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public static final a f367078g = null;

    public static final class a implements r {
        public a() {
        }

        @Override // t39.r
        public final /* synthetic */ void b(c49.a r100) {
        }

        @Override // t39.r
        public final /* synthetic */ void e(int r100) {
        }

        @Override // t39.r
        public final void a(c49.a r100) {
            FLogger r101 = FLogger.f375446a;
            r101.i("ProactiveSummaryRecords", "[NotificationTracer] PushService receive onNotifyForDouBao, title is " + r100.f22418e + ", content is " + r100.f22420g);
            StringBuilder r102 = new StringBuilder();
            String r103 = r100.f22418e;
            String r104 = "";
            if (r103 != null) goto L5;
            r103 = "";
        L5:
            r102.append(r103);
            r102.append('|');
            String r105 = r100.f22420g;
            if (r105 != null) goto L8;
            r105 = "";
        L8:
            r102.append(r105);
            String r106 = r102.toString();
            long r107 = SystemClock.elapsedRealtime();
            NotificationReceiverManager.f367072a.getClass();
            if (NotificationReceiverManager.c(r106, r107) == false) goto L12;
            r101.i("ProactiveSummaryRecords", "[NotificationTracer] PushService receive onNotifyForDouBao, dedupe skipped: " + r106);
            return;
        L12:
            DoraAVLinkDelegate r108 = DoraAVLinkDelegate.f291640b;
            String r109 = r100.f22418e;
            if (r109 != null) goto L15;
            r109 = "";
        L15:
            String r110 = r100.f22420g;
            if (r110 == null) goto L19;
            r104 = r110;
        L19:
            r108.A0(r109, r104);
        }

        @Override // t39.r
        public final void d(c49.a r110) {
            IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            boolean r101 = false;
            if (r100 != null) goto L5;
        L9:
            boolean r102 = false;
        L11:
            if (r102 == false) goto L35;
            NotificationReceiverManager.f367072a.getClass();
            long r103 = System.currentTimeMillis();
            long r104 = SystemClock.elapsedRealtime();
            AppHost.Companion r105 = AppHost.f326268a;
            if (r105.a().isAppBackground() == false) goto L15;
            boolean r106 = false;
        L20:
            if (r106 == true) goto L33;
            StringBuilder r107 = new StringBuilder();
            String r108 = r110.f22418e;
            String r111 = "";
            if (r108 != null) goto L25;
            r108 = "";
        L25:
            r107.append(r108);
            r107.append('|');
            String r109 = r110.f22419f;
            if (r109 == null) goto L29;
            r111 = r109;
        L29:
            r107.append(r111);
            String r112 = r107.toString();
            if (NotificationReceiverManager.c(r112, r104) == false) goto L32;
            FLogger.f375446a.i("ProactiveSummaryRecords", "[NotificationTracer] PushService receive onNotify, dedupe skipped: " + r112);
            goto L33
        L32:
            FLogger.f375446a.i("ProactiveSummaryRecords", "[NotificationTracer] PushService receive onNotify, clientReceiveTimeStamp " + r103 + ", msgReceiveTimeStamp : " + Long.valueOf(r110.f22415b));
            String r113 = UUID.randomUUID().toString();
            DoraAVLinkDelegate.f291640b.a1(r113, r103);
            JSONObject r114 = new JSONObject();
            IApplog.Companion r115 = IApplog.f287053a;
            r114.put("device_id", r115.getDeviceId());
            r114.put("user_id", r115.getUserID());
            r114.put("notification_id", r113);
            r114.put("title", r110.f22418e);
            r114.put(BdpAppEventConstant.PARAMS_SUB_TITLE, r110.f22419f);
            r114.put("message_detail", r110.f22420g);
            r114.put("app_name", r105.getAppName());
            r114.put("timestamp", r110.f22415b);
            r114.put("timezone", TimeZone.getDefault());
            r114.put("system_notification_id", r113);
            r114.put("pkg_name", r110.f22417d);
            r114.put("app_package", r110.f22416c);
            r114.put("channel", r110.f22421h);
            r114.put("category", r110.f22422i);
            r114.put("client_receive_timestamp", r103);
            r114.put("android_notification_flags", r110.f22423j);
            r114.put("version", "v3");
            r115.reportEvent("dora_proactive_system_notification_receive", r114);
            BuildersKt.launch$default(NotificationReceiverManager.f367073b, null, null, new NotificationReceiverManager$uploadNotification$1(r110, r114, null), 3, null);
            r101 = true;
        L33:
            if (r101 == false) goto L37;
            DoraAVLinkDelegate.f291640b.p();
            return;
        L37:
            return;
        L15:
            Activity r116 = r105.a().getCurrentActivity();
            if (r116 == null) goto L18;
            String r117 = r116.getClass().getSimpleName();
        L19:
            FLogger.f375446a.i("ProactiveSummaryRecords", "[NotificationTracer] skip notification upload because app is foreground, currentActivity=".concat(r117));
            r106 = true;
            goto L20
        L18:
            r117 = "null";
            goto L19
        L35:
            FLogger.f375446a.i("ProactiveSummaryRecords", "isNLFeatureEnabled is false, no uploadNotification");
            return;
        L5:
            if (r100.device() == null) goto L9;
            if (com.larus.dora.impl.nl.n.b() != true) goto L9;
            r102 = true;
            goto L11
        }
    }

    public NotificationReceiverManager() {
    }

    /* JADX WARN: Type inference failed for: r0v7, types: [com.larus.push.impl.NotificationReceiverManager$userPresentReceiver$1] */
    static {
        f367072a = new NotificationReceiverManager();
        f367073b = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getIO()));
        f367074c = new Object();
        f367075d = new HashMap();
        f367077f = new NotificationReceiverManager$userPresentReceiver$1();
        f367078g = new a();
    }

    public static boolean c(String r100, final long r101) {
        Object r102 = f367074c;
        monitor-enter(r102);
        HashMap<String, Long> r103 = f367075d;     // Catch: Throwable -> L16
        Long r104 = r103.get(r100);     // Catch: Throwable -> L16
        if (r104 != null) goto L8;
    L12:
        CollectionsKt.removeAll(r103.entrySet(), new j(r101));     // Catch: Throwable -> L16
        r103.put(r100, Long.valueOf(r101));     // Catch: Throwable -> L16
        monitor-exit(r102);
        return false;
    L8:
        if ((r101 - r104.longValue()) >= 100) goto L12;
        monitor-exit(r102);
        return true;
    L16:
        th = move-exception;
        throw th;
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void a(Application r100, NotificationReceiverManager$userPresentReceiver$1 r110, IntentFilter r111) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L40;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L40:
    L34:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.registerReceiver(r110, r111, 4);
        return;
    L39:
        throw e;
    L7:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L23;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r111) == false) goto L23;
        int r101 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r110, r111, 4, null, null, 3, r100).result;     // Catch: Exception -> L34
        if (r101 != 1) goto L13;
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L13:
        if (r101 != 2) goto L15;
        new Intent();     // Catch: Exception -> L34
        return;
    L15:
        if (r101 == 3) goto L41;
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L41:
        return;
    L23:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L27;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L34
        r100.registerReceiver(r110, r111, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L34
        return;
    L27:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L29;
    L32:
        r100.registerReceiver(r110, r111, 4);     // Catch: Exception -> L34
        return;
    L29:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r111) == false) goto L32;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L34
        ContextCompat.registerReceiver(r100, r110, r111, null, ReceiverRegisterLancet.sProxyHandler, 4);     // Catch: Exception -> L34
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static void b(Application r100, NotificationReceiverManager$userPresentReceiver$1 r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L39;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L39:
    L33:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L38;
        ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
        return;
    L38:
        throw e;
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L22;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L22;
        int r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100).result;     // Catch: Exception -> L33
        if (r102 != 1) goto L12;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L12:
        if (r102 != 2) goto L14;
        new Intent();     // Catch: Exception -> L33
        return;
    L14:
        if (r102 == 3) goto L40;
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L40:
        return;
    L22:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L26;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L33
        r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L33
        return;
    L26:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L28;
    L31:
        r100.registerReceiver(r101, r110);     // Catch: Exception -> L33
        return;
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L31;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L33
        ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L33
    }
}
