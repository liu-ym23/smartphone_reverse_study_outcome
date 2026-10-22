package com.obric.update.impl.v2.handler;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Intent;
import android.content.IntentFilter;
import androidx.core.content.ContextCompat;
import com.android.ttcjpaysdk.thirdparty.voiceprint.bean.VoicePrintState;
import com.bytedance.android.livesdkapi.performance.IPerformanceStrategyManager;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.common.wschannel.WsConstants;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.common.apphost.AppHost;
import com.larus.platform.service.AccountService;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.t1;
import com.obric.update.api.v2.ObricUpdateSettingDelegate;
import com.obric.update.impl.v2.m;
import com.obric.update.impl.v2.o;
import com.ss.android.update.OnUpdateStatusChangedListener;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicLong;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import me.ele.lancet.base.annotations.Skip;
import org.json.JSONObject;

/* JADX INFO: loaded from: classes5.dex */
public final class ObricUpdateHandler {

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public static final /* synthetic */ int f404091t = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final o f404092a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final goa.a f404093b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final goa.b f404094c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final m f404095d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<Unit> f404096e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public volatile float f404097f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public volatile ObricUpdateHandler$initThermalStatus$1 f404098g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public volatile boolean f404099h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public volatile boolean f404100i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile Job f404101j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public volatile Job f404102k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public volatile Job f404103l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public volatile Job f404104m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final AtomicBoolean f404105n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final AtomicBoolean f404106o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final AtomicBoolean f404107p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final AtomicBoolean f404108q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final AtomicLong f404109r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final CoroutineScope f404110s;

    public static final class a {
    }

    static {
    }

    public final void d() {
        this.f404109r.incrementAndGet();
        Job r100 = this.f404104m;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f404104m = null;
        this.f404108q.set(false);
    }

    public final boolean l() {
        this.f404092a.f404131a.getClass();
        String r100 = com.ss.android.update.d.x().Z;
        FLogger.f375446a.i("ObricUpdateHandler", "isObricChannel: channel=" + r100);
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.length() <= 0) goto L7;
        boolean r101 = true;
    L9:
        if (r101 == true) goto L12;
        r100 = null;
    L12:
        if (r100 != null) goto L14;
        return false;
    L14:
        if (StringsKt.startsWith$default(r100, "obric_", false, 2, null) != true) goto L19;
        return true;
    L19:
        return false;
    L7:
        r101 = false;
        goto L9
    }

    public final boolean p() {
        if (this.f404093b.f481952c == true) goto L5;
        return false;
    L5:
        if (this.f404093b.f481953d == false) goto L7;
        return false;
    L7:
        if (this.f404093b.f481956g == true) goto L16;
        this.f404092a.f404134d.getClass();
        if (com.obric.update.impl.v2.gateway.c.b() == true) goto L17;
        FLogger.f375446a.i("ObricUpdateHandler", "pauseWifiAutoDownloadOnMobileNetwork: trigger=sdk_progress");
        m.e(this.f404095d, WsConstants.KEY_NETWORK_STATE, "auto pause download:sdk_progress", 4);
        o(true);
        return true;
    L17:
        return false;
    L16:
        return false;
    }

    public final void t() {
        FLogger r100 = FLogger.f375446a;
        StringBuilder r101 = new StringBuilder("updateCacheRecord: updating cache record with versionCode=");
        this.f404092a.f404131a.getClass();
        com.ss.android.update.d r102 = com.ss.android.update.d.x();
        monitor-enter(r102);
    L11:
        th = move-exception;
        throw th;
    L5:
        if (r102.f455272k == true) goto L7;
        r102.U();     // Catch: Throwable -> L11
        r102.f455272k = true;     // Catch: Throwable -> L11
    L7:
        int r103 = r102.f455278n;     // Catch: Throwable -> L11
        monitor-exit(r102);
        r101.append(r103);
        r100.i("ObricUpdateHandler", r101.toString());
        long r104 = t1.f393353a.L0().getObricUpdateCheckResultCacheTime() * 1000;
        goa.b r105 = this.f404094c;
        this.f404092a.f404131a.getClass();
        r105.f481962d = new goa.b.C6045b(com.obric.update.impl.v2.gateway.f.c(), System.currentTimeMillis() + r104);
    }

    public final void r() {
        d();
        this.f404093b.f481953d = false;
        this.f404093b.f481951b = false;
        this.f404093b.f481952c = false;
        this.f404093b.f481955f = false;
        this.f404107p.set(false);
    }

    public static final void b(ObricUpdateHandler r100) {
        r100.getClass();
        FLogger r101 = FLogger.f375446a;
        r101.i("ObricUpdateHandler", "onPluginInstalled: plugin pre-installed successfully");
        r100.f404094c.a(100);
        r100.f404094c.b(4);
        r100.f404093b.f481956g = false;
        r100.f404093b.f481953d = false;
        r100.f404093b.f481955f = false;
        r100.f404107p.set(false);
        if (r100.f404093b.f481957h == false) goto L6;
        r101.i("ObricUpdateHandler", "onPluginInstalled: triggering onInstallReady");
        r100.f404093b.f481957h = false;
        r100.f404096e.invoke();
        return;
    }

    public final void c(String r100) {
        FLogger.f375446a.i("ObricUpdateHandler", "cancelDownload: cancelling current download");     // Catch: Exception -> L8
        d();     // Catch: Exception -> L8
        Job r101 = this.f404101j;     // Catch: Exception -> L8
        if (r101 == null) goto L6;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);     // Catch: Exception -> L8
    L6:
        this.f404107p.set(true);     // Catch: Exception -> L8
        this.f404106o.set(false);     // Catch: Exception -> L8
        this.f404094c.b(1);     // Catch: Exception -> L8
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L8
        com.ss.android.update.d.x().h();     // Catch: Exception -> L8
        this.f404093b.f481954e = false;     // Catch: Exception -> L8
        this.f404093b.f481952c = false;     // Catch: Exception -> L8
        this.f404093b.f481951b = false;     // Catch: Exception -> L8
        this.f404093b.f481953d = false;     // Catch: Exception -> L8
        this.f404093b.f481955f = false;     // Catch: Exception -> L8
        this.f404105n.set(true);     // Catch: Exception -> L8
        m r102 = this.f404095d;     // Catch: Exception -> L8
        JSONObject r103 = new JSONObject();     // Catch: Exception -> L8
        r103.put(VoicePrintState.EXT_KEY_CANCEL_REASON, r100);     // Catch: Exception -> L8
        Unit r104 = Unit.INSTANCE;     // Catch: Exception -> L8
        r102.c("download", "cancel_download", r103);     // Catch: Exception -> L8
        return;
    L8:
        e = move-exception;
        FLogger.f375446a.e("ObricUpdateHandler", "cancelDownload error: " + e);
    }

    public final void f(String r110) {
        if (this.f404094c.f481960b != 4) goto L12;
        this.f404092a.f404131a.getClass();
        PolarisFileWrapper r100 = com.obric.update.impl.v2.gateway.f.b();
        if (r100 != null) goto L7;
    L9:
        boolean r101 = false;
    L10:
        if (r101 == true) goto L12;
        FLogger.f375446a.i("ObricUpdateHandler", "checkAutoDownload: downloaded state but apk missing, fallback to STATE_AVAILABLE");
        this.f404094c.b(1);
        goto L12
    L7:
        if (r100.exists() != true) goto L9;
        r101 = true;
    L12:
        int r102 = this.f404094c.f481960b;
        if (r102 == 1) goto L21;
        if (r102 == 6) goto L21;
        if (r102 == 3) goto L21;
        FLogger.f375446a.i("ObricUpdateHandler", "checkAutoDownload return, current state = " + r102);
        m r103 = this.f404095d;
        JSONObject r104 = new JSONObject();
        r104.put("trigger_from", r110);
        Unit r105 = Unit.INSTANCE;
        r103.c("trigger_download", "state_not_match", r104);
        return;
    L21:
        if (this.f404093b.f481952c == true) goto L23;
    L26:
        this.f404092a.f404134d.getClass();
        boolean r106 = com.obric.update.impl.v2.gateway.c.b();
        this.f404092a.f404136f.getClass();
        boolean r107 = ObricUpdateSettingDelegate.f404037a.a();
        this.f404092a.f404131a.getClass();
        boolean r108 = com.ss.android.update.d.x().T();
        this.f404092a.f404131a.getClass();
        PolarisFileWrapper r111 = com.obric.update.impl.v2.gateway.f.b();
        if (r111 != null) goto L29;
    L31:
        boolean r112 = false;
    L32:
        boolean r113 = this.f404093b.f481954e;
        boolean r114 = this.f404093b.f481956g;
        this.f404092a.f404136f.getClass();
        float r115 = t1.f393353a.L0().getObricUpdateTemperatureBlockThreshold();
        if (this.f404097f <= r115) goto L35;
        boolean r116 = true;
    L36:
        FLogger r117 = FLogger.f375446a;
        r117.i("ObricUpdateHandler", "checkAutoDownload isWifi:" + r106 + ",wifiAutoDownloadEnable=" + r107 + ",isUpdating=" + r108 + ",isApkReady=" + r112 + ",isDownloading=" + r113 + ",isZeusPluginPreInstalling=" + r114 + ",currentTemperature=" + this.f404097f + ",temperatureBlockThreshold=" + r115 + ",isThermalBlocked=" + r116);
        if (r106 == false) goto L49;
        if (r107 == false) goto L49;
        if (r108 == true) goto L49;
        if (r112 == true) goto L49;
        if (r113 == true) goto L49;
        if (r114 == true) goto L49;
        if (r116 == true) goto L49;
        r117.i("ObricUpdateHandler", "checkAutoDownload: all conditions met, triggering startDownload");
        this.f404093b.f481951b = false;     // Catch: Exception -> L47
        this.f404093b.f481952c = true;     // Catch: Exception -> L47
        JSONObject r109 = new JSONObject();     // Catch: Exception -> L47
        r109.put("trigger_from", r110);     // Catch: Exception -> L47
        Unit r118 = Unit.INSTANCE;     // Catch: Exception -> L47
        s(this, "wifi_auto_download", false, r109, 0, 8);     // Catch: Exception -> L47
        return;
    L47:
        e = move-exception;
        q(r110, e);
        return;
    L49:
        if (r116 == false) goto L51;
        String r119 = "thermal_too_high";
    L52:
        m r120 = this.f404095d;
        JSONObject r121 = new JSONObject();
        r121.put("trigger_from", r110);
        r121.put("current_temperature", Float.valueOf(this.f404097f));
        Unit r122 = Unit.INSTANCE;
        r120.c("trigger_download", r119, r121);
        return;
    L51:
        r119 = "auto_download_check_fail";
        goto L52
    L35:
        r116 = false;
        goto L36
    L29:
        if (r111.exists() != true) goto L31;
        r112 = true;
        goto L32
    L23:
        if (this.f404093b.f481953d == false) goto L26;
        FLogger.f375446a.i("ObricUpdateHandler", "checkAutoDownload return, wifi-auto path is frozen by user interference");
        m r123 = this.f404095d;
        JSONObject r124 = new JSONObject();
        r124.put("trigger_from", r110);
        Unit r125 = Unit.INSTANCE;
        r123.c("trigger_download", "wifi_auto_interfered", r124);
    }

    public final Object g(Continuation<? super Boolean> r110) {
        if ((r110 instanceof ObricUpdateHandler$checkForceUpdateForRomUnmatched$1) == false) goto L7;
        ObricUpdateHandler$checkForceUpdateForRomUnmatched$1 r100 = (ObricUpdateHandler$checkForceUpdateForRomUnmatched$1) r110;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r111 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        boolean r104 = true;
        if (r103 == 0) goto L15;
        if (r103 != 1) goto L14;
        ResultKt.throwOnFailure(r111);     // Catch: Exception -> L29
    L19:
        boolean r112 = ((Boolean) r111).booleanValue();     // Catch: Exception -> L29
        FLogger r105 = FLogger.f375446a;     // Catch: Exception -> L29
        StringBuilder r106 = new StringBuilder("checkForceUpdateForRomUnmatched: isRomCompatible=");     // Catch: Exception -> L29
        if (r112 == false) goto L22;
        boolean r107 = true;
    L23:
        r106.append(r107);     // Catch: Exception -> L29
        r105.i("ObricUpdateHandler", r106.toString());     // Catch: Exception -> L29
        if (r112 == false) goto L27;
        r104 = false;
    L27:
        return Boxing.boxBoolean(r104);
    L22:
        r107 = false;
        goto L23
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r111);
        FLogger.f375446a.i("ObricUpdateHandler", "checkForceUpdateForRomUnmatched: start");     // Catch: Exception -> L29
        String r113 = t9a.b.b().b().b();     // Catch: Exception -> L29
        CoroutineDispatcher r108 = Dispatchers.getIO();     // Catch: Exception -> L29
        ObricUpdateHandler$checkForceUpdateForRomUnmatched$isRomCompatible$1 r109 = new ObricUpdateHandler$checkForceUpdateForRomUnmatched$isRomCompatible$1(r113, null);     // Catch: Exception -> L29
        r100.label = 1;     // Catch: Exception -> L29
        r111 = BuildersKt.withContext(r108, r109, r100);     // Catch: Exception -> L29
        if (r111 != r102) goto L19;
        return r102;
    L29:
        e = move-exception;
        FLogger.f375446a.i("ObricUpdateHandler", "checkForceUpdateForRomUnmatched: fail:" + e);
        return Boxing.boxBoolean(false);
    L7:
        r100 = new ObricUpdateHandler$checkForceUpdateForRomUnmatched$1(this, r110);
        goto L8
    }

    public final void h(h r110) {
        Intrinsics.checkNotNullParameter(r110, "listener");
        Job r100 = this.f404103l;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f404103l = BuildersKt.launch$default(this.f404110s, null, null, new ObricUpdateHandler$checkNetworkState$1(this, r110, null), 3, null);
    }

    public final Object j(Continuation<? super String> r100) {
        if ((r100 instanceof ObricUpdateHandler$fetchLatestApkUrl$1) == false) goto L7;
        ObricUpdateHandler$fetchLatestApkUrl$1 r101 = (ObricUpdateHandler$fetchLatestApkUrl$1) r100;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r103 = r101.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r101.label;
        if (r105 == 0) goto L15;
        if (r105 != 1) goto L14;
        ResultKt.throwOnFailure(r103);     // Catch: Exception -> L38
    L19:
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L38
        com.ss.android.update.d r106 = com.ss.android.update.d.x();     // Catch: Exception -> L38
        monitor-enter(r106);     // Catch: Exception -> L38
    L40:
        th = move-exception;
        throw th;     // Catch: Exception -> L38
    L22:
        if (r106.f455272k == true) goto L24;
        r106.U();     // Catch: Throwable -> L40
        r106.f455272k = true;     // Catch: Throwable -> L40
    L24:
        String r107 = r106.f455274l;     // Catch: Throwable -> L40
        monitor-exit(r106);     // Catch: Exception -> L38
        FLogger r108 = FLogger.f375446a;     // Catch: Exception -> L38
        StringBuilder r109 = new StringBuilder("fetchLatestApkUrl: hasUrl=");     // Catch: Exception -> L38
        if (r107 != null) goto L29;
    L32:
        boolean r110 = true;
    L33:
        r109.append(!r110);     // Catch: Exception -> L38
        r108.i("ObricUpdateHandler", r109.toString());     // Catch: Exception -> L38
        if (r107 != null) goto L36;
        return null;
    L36:
        if ((!StringsKt.isBlank(r107)) == true) goto L50;
        return null;
    L50:
        return r107;
    L29:
        if (StringsKt.isBlank(r107) == true) goto L32;
        r110 = false;
        goto L33
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r103);
        FLogger.f375446a.i("ObricUpdateHandler", "fetchLatestApkUrl: start");     // Catch: Exception -> L38
        CoroutineDispatcher r111 = Dispatchers.getIO();     // Catch: Exception -> L38
        ObricUpdateHandler$fetchLatestApkUrl$2 r112 = new ObricUpdateHandler$fetchLatestApkUrl$2(this, null);     // Catch: Exception -> L38
        r101.label = 1;     // Catch: Exception -> L38
        if (BuildersKt.withContext(r111, r112, r101) != r104) goto L19;
        return r104;
    L38:
        e = move-exception;
        FLogger.f375446a.i("ObricUpdateHandler", "fetchLatestApkUrl: fail:" + e);
        return null;
    L7:
        r101 = new ObricUpdateHandler$fetchLatestApkUrl$1(this, r100);
        goto L8
    }

    public final void n(boolean r110) {
        FLogger r100 = FLogger.f375446a;
        r100.i("ObricUpdateHandler", "onDownloadCompleted start: fromDownloadResult=" + r110 + ", autoInstall=false");
        Job r101 = this.f404102k;
        if (r101 == null) goto L7;
        boolean r102 = true;
        if (r101.isActive() != true) goto L7;
    L8:
        boolean r103 = this.f404093b.f481956g;
        m.d(this.f404095d, "plugin_install", null, 6);
        if (r102 == true) goto L14;
        if (r103 == true) goto L14;
        this.f404102k = BuildersKt.launch$default(this.f404110s, null, null, new ObricUpdateHandler$onDownloadCompleted$1(this, r110, null), 3, null);
        return;
    L14:
        r100.i("ObricUpdateHandler", "onDownloadCompleted ignored, plugin install already running (isActive=" + r102 + ", isPreInstalling=" + r103 + ')');
        this.f404095d.c("plugin_install", "already_running", null);
        return;
    L7:
        r102 = false;
        goto L8
    }

    public final void o(boolean r100) {
        FLogger.f375446a.i("ObricUpdateHandler", "pauseDownload: pausing current download");     // Catch: Exception -> L12
        d();     // Catch: Exception -> L12
        Job r101 = this.f404101j;     // Catch: Exception -> L12
        if (r101 == null) goto L7;
        Job.DefaultImpls.cancel$default(r101, null, 1, null);     // Catch: Exception -> L12
    L7:
        if (this.f404093b.f481952c == false) goto L10;
        if (r100 == true) goto L10;
        this.f404093b.f481953d = true;     // Catch: Exception -> L12
    L10:
        this.f404107p.set(true);     // Catch: Exception -> L12
        this.f404106o.set(false);     // Catch: Exception -> L12
        this.f404094c.b(3);     // Catch: Exception -> L12
        this.f404093b.f481954e = false;     // Catch: Exception -> L12
        this.f404105n.set(true);     // Catch: Exception -> L12
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L12
        com.ss.android.update.d.x().h();     // Catch: Exception -> L12
        m r102 = this.f404095d;     // Catch: Exception -> L12
        int r103 = m.f404127d;     // Catch: Exception -> L12
        r102.c("download", "pause_download", null);     // Catch: Exception -> L12
        return;
    L12:
        e = move-exception;
        FLogger.f375446a.e("ObricUpdateHandler", "pauseDownload error: " + e);
    }

    public final void e(String r110, boolean r111) {
        Job r100 = this.f404104m;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f404108q.set(false);
        long r101 = this.f404109r.incrementAndGet();
        this.f404092a.f404131a.getClass();
        com.ss.android.update.d r102 = com.ss.android.update.d.x();
        monitor-enter(r102);
    L14:
        th = move-exception;
        throw th;
    L8:
        if (r102.f455272k == true) goto L10;
        r102.U();     // Catch: Throwable -> L14
        r102.f455272k = true;     // Catch: Throwable -> L14
    L10:
        int r103 = r102.f455278n;     // Catch: Throwable -> L14
        monitor-exit(r102);
        this.f404104m = BuildersKt.launch$default(this.f404110s, null, null, new ObricUpdateHandler$checkAndRestartSdkRestoredDownload$1(r101, this, r103, r110, r111, null), 3, null);
    }

    public final void k(boolean r110, boolean r111) {
        Job r100 = this.f404101j;     // Catch: Exception -> L37
        if (r100 == null) goto L6;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);     // Catch: Exception -> L37
    L6:
        boolean r101 = this.f404108q.getAndSet(false);     // Catch: Exception -> L37
        int r102 = this.f404094c.f481960b;     // Catch: Exception -> L37
        if (this.f404107p.get() == false) goto L10;
        if (r101 == true) goto L10;
    L35:
        FLogger.f375446a.i("ObricUpdateHandler", "handleDownloadResult ignored after termination: success=" + r110 + ",state=" + r102);     // Catch: Exception -> L37
        return;
    L10:
        if (r102 == 4) goto L35;
        if (r102 == 5) goto L35;
        if (r102 == (-1)) goto L35;
        if (r110 == false) goto L21;
        if (this.f404106o.compareAndSet(false, true) == false) goto L21;
        this.f404101j = null;     // Catch: Exception -> L37
        this.f404105n.set(false);     // Catch: Exception -> L37
    L21:
        if (this.f404105n.get() == false) goto L24;
        FLogger.f375446a.i("ObricUpdateHandler", "handleDownloadResult ignored, result already consumed: success=" + r110);     // Catch: Exception -> L37
        return;
    L24:
        if (r110 == true) goto L26;
        this.f404106o.set(false);     // Catch: Exception -> L37
    L26:
        boolean r103 = this.f404093b.f481951b;     // Catch: Exception -> L37
        FLogger r104 = FLogger.f375446a;     // Catch: Exception -> L37
        r104.i("ObricUpdateHandler", "handleDownloadResult: success=" + r110 + ", isManual=" + r103);     // Catch: Exception -> L37
        if (r110 == true) goto L29;
        this.f404101j = BuildersKt.launch$default(this.f404110s, null, null, new ObricUpdateHandler$handleDownloadResult$1(this, null), 3, null);     // Catch: Exception -> L37
    L34:
        this.f404093b.f481954e = false;     // Catch: Exception -> L37
        return;
    L29:
        if (this.f404105n.compareAndSet(false, true) == true) goto L32;
        r104.i("ObricUpdateHandler", "download success ignored, result already consumed");     // Catch: Exception -> L37
        return;
    L32:
        m.e(this.f404095d, "download", null, 6);     // Catch: Exception -> L37
        n(r111);     // Catch: Exception -> L37
    L37:
        e = move-exception;
        FLogger.f375446a.e("ObricUpdateHandler", "handleDownloadResult error: " + e);
    }

    public final Object m(String r210, Continuation<? super Boolean> r211) {
        String r100 = r210;
        if ((r211 instanceof ObricUpdateHandler$isUpdateAvailable$1) == false) goto L7;
        ObricUpdateHandler$isUpdateAvailable$1 r110 = (ObricUpdateHandler$isUpdateAvailable$1) r211;
        int r111 = r110.label;
        if ((r111 & Integer.MIN_VALUE) == 0) goto L7;
        r110.label = r111 - Integer.MIN_VALUE;
    L8:
        Object r101 = r110.result;
        Object r112 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r102 = r110.label;
        boolean r103 = true;
        if (r102 == 0) goto L16;
        if (r102 != 1) goto L15;
        r100 = (String) r110.L$0;
        ResultKt.throwOnFailure(r101);     // Catch: Exception -> L72
    L49:
        boolean r104 = ((Boolean) r101).booleanValue();     // Catch: Exception -> L72
        FLogger r105 = FLogger.f375446a;     // Catch: Exception -> L72
        StringBuilder r106 = new StringBuilder("isUpdateAvailable: hasNewVersion=");     // Catch: Exception -> L72
        if (r104 == false) goto L52;
        boolean r107 = true;
    L53:
        r106.append(r107);     // Catch: Exception -> L72
        r106.append(" scene=");     // Catch: Exception -> L72
        r106.append(r100);     // Catch: Exception -> L72
        r105.i("ObricUpdateHandler", r106.toString());     // Catch: Exception -> L72
        if (r104 == true) goto L56;
    L59:
        if (r104 == false) goto L61;
        r105.i("ObricUpdateHandler", "isUpdateAvailable: hasNewVersion checkAutoDownload. scene=" + r100);     // Catch: Exception -> L72
        t();     // Catch: Exception -> L72
        m.d(this.f404095d, "trigger_download", "is_update_available", 4);     // Catch: Exception -> L72
        f("is_update_available");     // Catch: Exception -> L72
    L62:
        StringBuilder r108 = new StringBuilder("isUpdateAvailable: end. hasNewVersion=");     // Catch: Exception -> L72
        if (r104 == false) goto L65;
        boolean r109 = true;
    L66:
        r108.append(r109);     // Catch: Exception -> L72
        r108.append(". ");     // Catch: Exception -> L72
        r108.append(r100);     // Catch: Exception -> L72
        r105.i("ObricUpdateHandler", r108.toString());     // Catch: Exception -> L72
        if (r104 == true) goto L71;
        r103 = false;
    L71:
        return Boxing.boxBoolean(r103);
    L65:
        r109 = false;
        goto L66
    L61:
        this.f404094c.b(-1);     // Catch: Exception -> L72
        r();     // Catch: Exception -> L72
        r105.i("ObricUpdateHandler", "isUpdateAvailable: no new version available. scene=" + r100);     // Catch: Exception -> L72
        goto L62
    L56:
        if (l() == true) goto L59;
        r105.i("ObricUpdateHandler", "isUpdateAvailable: return false, not obric channel. " + r100);     // Catch: Exception -> L72
        this.f404094c.b(-1);     // Catch: Exception -> L72
        r();     // Catch: Exception -> L72
        return Boxing.boxBoolean(false);
    L52:
        r107 = false;
        goto L53
    L15:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L16:
        ResultKt.throwOnFailure(r101);
        FLogger r113 = FLogger.f375446a;     // Catch: Exception -> L72
        r113.i("ObricUpdateHandler", "isUpdateAvailable: start scene=" + r100);     // Catch: Exception -> L72
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L72
        if (com.ss.android.update.d.x().T() == false) goto L21;
        r113.i("ObricUpdateHandler", "isUpdateAvailable: return true, sdk updating. " + r100);     // Catch: Exception -> L72
        return Boxing.boxBoolean(true);
    L21:
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L72
        PolarisFileWrapper r114 = com.obric.update.impl.v2.gateway.f.b();     // Catch: Exception -> L72
        if (r114 != null) goto L24;
    L26:
        boolean r115 = false;
    L27:
        if (r115 == false) goto L30;
        r113.i("ObricUpdateHandler", "isUpdateAvailable: return true, apk exists and exc onDownloadCompleted. " + r100);     // Catch: Exception -> L72
        n(false);     // Catch: Exception -> L72
        return Boxing.boxBoolean(true);
    L30:
        goa.b.C6045b r116 = this.f404094c.f481962d;     // Catch: Exception -> L72
        if (r116 != null) goto L33;
    L38:
        this.f404092a.f404133c.getClass();     // Catch: Exception -> L72
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L42;
        r113.i("ObricUpdateHandler", "isUpdateAvailable: return false, not Login. " + r100);     // Catch: Exception -> L72
        return Boxing.boxBoolean(false);
    L42:
        this.f404092a.f404134d.getClass();     // Catch: Exception -> L72
        if (com.obric.update.impl.v2.gateway.c.a() == true) goto L46;
        r113.i("ObricUpdateHandler", "isUpdateAvailable: return false, net not available. " + r100);     // Catch: Exception -> L72
        return Boxing.boxBoolean(false);
    L46:
        CoroutineDispatcher r117 = Dispatchers.getIO();     // Catch: Exception -> L72
        ObricUpdateHandler$isUpdateAvailable$hasNewVersion$1 r118 = new ObricUpdateHandler$isUpdateAvailable$hasNewVersion$1(this, null);     // Catch: Exception -> L72
        r110.L$0 = r100;     // Catch: Exception -> L72
        r110.label = 1;     // Catch: Exception -> L72
        r101 = BuildersKt.withContext(r117, r118, r110);     // Catch: Exception -> L72
        if (r101 != r112) goto L49;
        return r112;
    L33:
        if (r116.f481965b <= System.currentTimeMillis()) goto L38;
        if (this.f404094c.f481960b == (-1)) goto L38;
        r113.i("ObricUpdateHandler", "isUpdateAvailable: return true, cache hit=" + r116.f481964a + ",checkAutoDownload. scene=" + r100);     // Catch: Exception -> L72
        m.d(this.f404095d, "trigger_download", "is_update_available", 4);     // Catch: Exception -> L72
        f("is_update_available");     // Catch: Exception -> L72
        return Boxing.boxBoolean(true);
    L24:
        if (r114.exists() != true) goto L26;
        r115 = true;
    L72:
        e = move-exception;
        FLogger.f375446a.i("ObricUpdateHandler", "isUpdateAvailable: fail: " + e);
        return Boxing.boxBoolean(false);
    L7:
        r110 = new ObricUpdateHandler$isUpdateAvailable$1(this, r211);
        goto L8
    }

    public final void q(String r100, Throwable r101) {
        m r102 = this.f404095d;
        JSONObject r103 = new JSONObject();
        r103.put("trigger_from", r100);
        String r104 = r101.getMessage();
        if (r104 != null) goto L5;
        r104 = r101.toString();
    L5:
        r103.put("error", r104);
        Unit r105 = Unit.INSTANCE;
        r102.c("trigger_download", com.bytedance.android.ec.core.event.a.KEY_EXCEPTION, r103);
    }

    @Skip({"com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer", "com.tencent.tinker.loader.app.TinkerApplication", "com.bytedance.tools.wrangler.Wrangler", "com.iab.omid.library.bytedance.b.b", "com.bytedance.tools.codelocator.CodeLocator", "com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer"})
    public static Intent a(Application r100, BroadcastReceiver r101, IntentFilter r110) {
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L41;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L41:
    L35:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == true) goto L39;
        throw e;
    L39:
        return ReceiverRegisterCrashOptimizer.registerReceiver(r101, r110);
    L6:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L24;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r110) == false) goto L24;
        ReceiverRegisterAnrOptimizer.ResultWrapper r102 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r101, r110, 0, null, null, 2, r100);     // Catch: Exception -> L35
        int r103 = r102.result;     // Catch: Exception -> L35
        if (r103 == 1) goto L22;
        if (r103 == 2) goto L20;
        if (r103 == 3) goto L18;
        return r100.registerReceiver(r101, r110);
    L18:
        return r102.intent;
    L20:
        return new Intent();
    L22:
        return r100.registerReceiver(r101, r110);
    L24:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L28;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L35
        return r100.registerReceiver(r101, r110, null, ReceiverRegisterLancet.sReceiverHandler);
    L28:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() == null) goto L34;
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r110) == false) goto L34;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L35
        return ContextCompat.registerReceiver(r100, r101, r110, null, ReceiverRegisterLancet.sProxyHandler, 2);
    L34:
        return r100.registerReceiver(r101, r110);
    }

    public final void i(boolean r110, String r210, OnUpdateStatusChangedListener r211) {
        Intrinsics.checkNotNullParameter(r211, "listener");
        FLogger r100 = FLogger.f375446a;     // Catch: Exception -> L43
        r100.i("ObricUpdateHandler", "checkUpdate isAutoCheck=" + r110 + ", scene=" + r210);     // Catch: Exception -> L43
        m.d(this.f404095d, "check_update", r210, 4);     // Catch: Exception -> L43
        this.f404092a.f404133c.getClass();     // Catch: Exception -> L43
        if (AccountService.f365697a.isLogin().booleanValue() == true) goto L8;
        r100.i("ObricUpdateHandler", "checkUpdate ignored, not login");     // Catch: Exception -> L43
        this.f404095d.c("check_update", "not_login", null);     // Catch: Exception -> L43
        return;
    L8:
        this.f404092a.f404134d.getClass();     // Catch: Exception -> L43
        if (com.obric.update.impl.v2.gateway.c.a() == true) goto L12;
        r100.i("ObricUpdateHandler", "checkUpdate ignored, network unavailable");     // Catch: Exception -> L43
        this.f404095d.c("check_update", "no_network", null);     // Catch: Exception -> L43
        return;
    L12:
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L43
        if (com.ss.android.update.d.x().T() == false) goto L15;
    L41:
        StringBuilder r101 = new StringBuilder("checkUpdate ignored, sdk updating=");     // Catch: Exception -> L43
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L43
        r101.append(com.ss.android.update.d.x().T());     // Catch: Exception -> L43
        r101.append(",state = ");     // Catch: Exception -> L43
        r101.append(this.f404094c.f481960b);     // Catch: Exception -> L43
        r101.append(",isDownloading=");     // Catch: Exception -> L43
        r101.append(this.f404093b.f481954e);     // Catch: Exception -> L43
        r100.i("ObricUpdateHandler", r101.toString());     // Catch: Exception -> L43
        this.f404095d.c("check_update", "is_updating", null);     // Catch: Exception -> L43
        return;
    L15:
        if (this.f404093b.f481954e == true) goto L41;
        goa.b.C6045b r102 = this.f404094c.f481962d;     // Catch: Exception -> L43
        int r103 = 1;
        if (r102 != null) goto L20;
    L30:
        if (r110 == false) goto L32;
        r103 = 2;
    L32:
        com.obric.update.impl.v2.gateway.f r104 = this.f404092a.f404131a;     // Catch: Exception -> L43
        hoa.h r105 = hoa.h.f486293a;     // Catch: Exception -> L43
        hoa.a r106 = hoa.a.f486277a;     // Catch: Exception -> L43
        r104.getClass();     // Catch: Exception -> L43
        Intrinsics.checkNotNullParameter(r105, PullConfiguration.PROCESS_NAME_MAIN);     // Catch: Exception -> L43
        Intrinsics.checkNotNullParameter(r106, "check");     // Catch: Exception -> L43
        com.ss.android.update.d r107 = com.ss.android.update.d.x();     // Catch: Exception -> L43
        monitor-enter(r107);     // Catch: Exception -> L43
        r107.f455267h0 = r105;     // Catch: Throwable -> L38
        r107.f455269i0 = r106;     // Catch: Throwable -> L38
        monitor-exit(r107);     // Catch: Throwable -> L38
        r100.i("ObricUpdateHandler", "checkUpdate: starting sdk checkUpdate");     // Catch: Exception -> L43
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L43
        Intrinsics.checkNotNullParameter(r211, "listener");     // Catch: Exception -> L43
        com.ss.android.update.d r108 = com.ss.android.update.d.x();     // Catch: Exception -> L43
        r108.Y(r211);     // Catch: Exception -> L43
        r108.g0(r103, 3, r211, false);     // Catch: Exception -> L43
        return;
    L38:
        th = move-exception;
        throw th;     // Catch: Exception -> L43
    L20:
        if (r102.f481965b <= System.currentTimeMillis()) goto L30;
        int r111 = this.f404094c.f481960b;     // Catch: Exception -> L43
        r100.i("ObricUpdateHandler", "checkUpdate cache hit=" + r102.f481964a + " scene=" + r210 + ",current_state=" + r111);     // Catch: Exception -> L43
        if (r111 == (-1)) goto L30;
        this.f404095d.c("check_update", "cache_hit", null);     // Catch: Exception -> L43
        m.d(this.f404095d, "trigger_download", "check_update", 4);     // Catch: Exception -> L43
        f("check_update");     // Catch: Exception -> L43
        this.f404092a.f404131a.getClass();     // Catch: Exception -> L43
        if (com.ss.android.update.d.x().P() == false) goto L27;
        hoa.h.f486293a.a(true);     // Catch: Exception -> L43
        r100.i("ObricUpdateHandler", "checkUpdate cache hit，forceUpdate showMainDialog");     // Catch: Exception -> L43
        return;
    L27:
        if (r110 == true) goto L49;
        hoa.a.f486277a.a(1);     // Catch: Exception -> L43
        r100.i("ObricUpdateHandler", "checkUpdate cache hit，not isAutoCheck showMainDialog");     // Catch: Exception -> L43
        return;
    L49:
        return;
    L43:
        e = move-exception;
        FLogger.f375446a.i("ObricUpdateHandler", "checkUpdate fail: " + e);
    }

    /* JADX WARN: Type inference failed for: r0v8, types: [com.obric.update.impl.v2.handler.ObricUpdateHandler$initThermalStatus$1] */
    public ObricUpdateHandler(o r100, goa.a r101, goa.b r102, m r103, com.obric.update.impl.v2.g r104) {
        Intrinsics.checkNotNullParameter(r100, "gateways");
        Intrinsics.checkNotNullParameter(r101, "flowContext");
        Intrinsics.checkNotNullParameter(r102, "stateHolder");
        Intrinsics.checkNotNullParameter(r103, "pipelineReporter");
        Intrinsics.checkNotNullParameter(r104, "onInstallReady");
        this.f404092a = r100;
        this.f404093b = r101;
        this.f404094c = r102;
        this.f404095d = r103;
        this.f404096e = r104;
        this.f404097f = -1.0f;
        r100.f404134d.getClass();
        this.f404099h = com.obric.update.impl.v2.gateway.c.b();
        r100.f404134d.getClass();
        this.f404100i = com.obric.update.impl.v2.gateway.c.a();
        IntentFilter r105 = new IntentFilter("android.intent.action.BATTERY_CHANGED");     // Catch: Exception -> L10
        AppHost.Companion r106 = AppHost.f326268a;     // Catch: Exception -> L10
        Intent r107 = a(r106.getApplication(), null, r105);     // Catch: Exception -> L10
        if (r107 == null) goto L8;
        int r108 = r107.getIntExtra(IPerformanceStrategyManager.KEY_FLOAT_TEMPERATURE, -1);     // Catch: Exception -> L10
        if (r108 == (-1)) goto L8;
        this.f404097f = r108 / 10.0f;     // Catch: Exception -> L10
    L8:
        this.f404098g = new ObricUpdateHandler$initThermalStatus$1(this);     // Catch: Exception -> L10
        a(r106.getApplication(), this.f404098g, r105);     // Catch: Exception -> L10
        FLogger.f375446a.i("ObricUpdateHandler", "initThermalStatus: registered battery receiver for temperature tracking, initial temp=" + this.f404097f);     // Catch: Exception -> L10
    L12:
        this.f404105n = new AtomicBoolean(false);
        this.f404106o = new AtomicBoolean(false);
        this.f404107p = new AtomicBoolean(false);
        this.f404108q = new AtomicBoolean(false);
        this.f404109r = new AtomicLong(0);
        this.f404110s = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain()));
        return;
    L10:
        e = move-exception;
        FLogger.f375446a.e("ObricUpdateHandler", "initThermalStatus failed: " + e);
        goto L12
    }

    public static void s(ObricUpdateHandler r100, String r101, boolean r102, JSONObject r103, long r104, int r105) {
        if ((r105 & 4) == 0) goto L6;
        r103 = null;
    L6:
        if ((r105 & 8) == 0) goto L11;
        Job r106 = r100.f404104m;
        if (r106 == null) goto L10;
        Job.DefaultImpls.cancel$default(r106, null, 1, null);
    L10:
        r100.f404108q.set(false);
        r104 = r100.f404109r.incrementAndGet();
    L11:
        if (r102 == false) goto L13;
        r100.f404094c.b(2);
    L13:
        r100.f404107p.set(false);
        r100.f404108q.set(true);
        r100.f404105n.set(false);
        r100.f404106o.set(false);
        r100.f404092a.f404131a.getClass();     // Catch: Exception -> L17
        com.ss.android.update.d.x().h0(false);     // Catch: Exception -> L17
        m r107 = r100.f404095d;
        r107.getClass();
        Intrinsics.checkNotNullParameter("trigger_download", "stage");
        r107.b("trigger_download", "success", r101, r103);
        return;
    L17:
        e = move-exception;
        if (r104 != r100.f404109r.get()) goto L21;
        r100.f404108q.set(false);
    L21:
        throw e;
    }
}
