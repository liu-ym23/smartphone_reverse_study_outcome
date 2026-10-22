package com.obric.assistant.zeus.plugin;

import android.app.Application;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import com.bytedance.android.service.manager.pull.PullConfiguration;
import com.bytedance.keva.Keva;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.api.IApm;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.activeness.ObricActiveReason;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.zeus.plugin.debuginfo.ZeusDebugInfoReceiver;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.apm.ApmUtils;
import com.volcengine.zeus.log.ZeusLogger;
import com.volcengine.zeus.plugin.preinstall.PreInstallTask;
import com.volcengine.zeus.plugin.preinstall.ZeusPreInstallSpUtil;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0003J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u001e\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001d0*H\u0096@¢\u0006\u0002\u0010(J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u000eH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/zeus/plugin/ZeusPluginServiceImpl;", "Lcom/obric/assistant/zeus/plugin/IZeusPluginService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "init", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "plantDebugUtil", "initProtocolVersionChecker", "isProtocolVersionCheckerEnabled", "", "setProtocolVersionCheckerEnabled", "enable", "plantStartActivityFallback", "initMobReporter", "initWebview", "setWebViewDataDirectory", "initApm", "initPluginFetchManager", "Landroid/app/Application;", "initDataMigration", "initPluginInstaller", "afterPrivacy", "getUploadFilePaths", "", "", "isPluginInstalled", "pluginPackageName", "installFromDownloadDir", "getAllPluginPkgName", "preInstallPlugin", "hostApkPath", "timeoutMS", "", "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearPreInstallData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitPluginInstall", "Lkotlin/Pair;", "isPluginPreInstalled", "hostPkgVersionCode", "getSimpleProcessName", "isCurrentProcessNeedZeus", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ZeusPluginServiceImpl implements IZeusPluginService {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final List<String> f395017b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final List<String> f395018c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static Boolean f395019d;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Keva f395020a;

    public static final class a {
        public static final List a() {
            List<String> r100 = ZeusPluginServiceImpl.f395017b;
            List r101 = CollectionsKt.createListBuilder();
            if (t9a.b.a().e() == true) goto L5;
            r101.add("com.obric.memorydata.plugin");
        L5:
            r101.add("com.obric.aiagent.plugin");
            return CollectionsKt.build(r101);
        }

        public a() {
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    public static final class b implements com.volcengine.zeus.plugin.preinstall.a {
        public b() {
        }

        @Override // com.volcengine.zeus.plugin.preinstall.a
        public final void a() {
            FLogger.f375446a.i("ZeusPluginServiceImpl", "preInstallPlugin onPreInstallFinish");
        }
    }

    static {
        new a();
        f395017b = CollectionsKt.listOf("zeus_com.obric.memorydata.plugin/star");
        f395018c = CollectionsKt.listOf("interactor");
    }

    public static boolean h() {
        Boolean r100 = f395019d;
        if (r100 != null) goto L5;
        List<String> r101 = f395018c;
        String r102 = IRuntimeContext.f384990a.b();     // Catch: Throwable -> L11
        String r103 = StringsKt.substringAfterLast$default(r102, ":", null, 2, null);
        if (Intrinsics.areEqual(r103, r102) == true) goto L13;
    L14:
        boolean r104 = !r101.contains(r103);
        f395019d = Boolean.valueOf(r104);
        return r104;
    L13:
        r103 = PullConfiguration.PROCESS_NAME_MAIN;
    L11:
        th = move-exception;
        FLogger.f375446a.w("ZeusPluginServiceImpl", "[process] getProcessName failed", th);
        goto L13
    L5:
        return r100.booleanValue();
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final boolean a() {
        Intrinsics.checkNotNullParameter("com.obric.aiagent.plugin", "pluginPackageName");
        if (h() == true) goto L7;
        com.bytedance.crash.d.b("invalid process");
        return false;
    L7:
        return Zeus.isPluginInstalled("com.obric.aiagent.plugin");
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final boolean e() {
        AppHost.Companion r100 = AppHost.f326268a;
        if (r100.isTestChannel() == false) goto L5;
    L8:
        boolean r101 = true;
    L9:
        if (r101 == true) goto L11;
    L12:
        return true;
    L11:
        if (this.f395020a.getBoolean("enable_protocol_checker", true) == true) goto L12;
        return false;
    L5:
        if (Intrinsics.areEqual(r100.getBuildChannel(), "auto_test") == true) goto L8;
        r101 = false;
        goto L9
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final void f() {
        if (IRuntimeContext.f384990a.a() == true) goto L6;
        com.bytedance.crash.d.b("installFromDownloadDir called in non-main process");
        return;
    L6:
        Zeus.installFromDownloadDir();
    }

    public ZeusPluginServiceImpl() {
        this.f395020a = Keva.getRepo("zeus_plugin_related", 1);
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final List<String> b(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        String r101 = AppHost.f326268a.getApplication().getFilesDir().getAbsolutePath() + '/';
        List<String> r102 = f395017b;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L6;
        r103.add(r101 + ((String) r104.next()));
        goto L4
    L6:
        return r103;
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final boolean c(String r100) {
        Intrinsics.checkNotNullParameter(r100, "hostPkgVersionCode");
        if (h() == true) goto L6;
        com.bytedance.crash.d.b("invalid process");
        return false;
    L6:
        int r101 = com.volcengine.zeus.h.f462707a;
        Intrinsics.checkNotNullParameter(r100, "hostPkgVersionCode");
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: hostPkgVersionCode = " + r100);
        int r102 = ZeusPreInstallSpUtil.a().getInt("host_version", -1);
        if (r102 > 0) goto L9;
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: is not install. installHostVersion = " + r102);
        return false;
    L9:
        int r103 = ZeusPreInstallSpUtil.a().getInt("tool_version", -1);
        if (r103 == 1) goto L13;
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: toolVersion not match. toolVersion = " + r103 + ", curToolsVersion = 1");
        return false;
    L13:
        if (Intrinsics.areEqual(String.valueOf(r102), r100) == false) goto L15;
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: yes, " + r100 + " is preinstalled");
        return true;
    L15:
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: no, " + r100 + " is not preinstalled");
        return false;
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final void d(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (h() == true) goto L6;
        FLogger.f375446a.i("ZeusPluginServiceImpl", "[privacy] do not need Zeus");
        return;
    L6:
        Zeus.onPrivacyAgreed();
        IApm r101 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L15;
        FLogger.f375446a.i("ZeusPluginServiceImpl", "afterPrivacy，跳过插件轮询，非主进程");
        return;
    L15:
        Iterator r103 = a.a().iterator();
    L17:
        if (r103.hasNext() == false) goto L23;
        String r104 = (String) r103.next();
        c r105 = c.f395036a;
        String[] r106 = {r104};
        Intrinsics.checkNotNullParameter(r106, "pluginPkg");
        FLogger.f375446a.d("ZeusAutoFetchManager", "startAutoFetch: pluginPkg=" + Arrays.toString(r106) + ", startNow=true");
        c.f395040e = CollectionsKt.distinct(CollectionsKt.plus(c.f395040e, r106));
        int r107 = 0;
    L19:
        c r108 = c.f395036a;
        if (r107 >= 1) goto L22;
        c.b(r106[r107]);
        r107 = r107 + 1;
        goto L19
    L22:
        c.a(r106[0], "start_auto_fetch");
        goto L17
    L23:
        h r109 = h.f395045a;
        r109.getClass();
        h.f395048d.getValue().b(r109, SetsKt.setOf(new ObricActiveReason[]{ObricActiveReason.DEVICE_SCREEN_ON, ObricActiveReason.PLUGIN_UPDATE}));
        return;
    L9:
        if (r101.isMainProcess(r100) != true) goto L11;
        r102 = true;
        goto L12
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final void init(Context r210) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (h() == true) goto L6;
        FLogger.f375446a.i("ZeusPluginServiceImpl", "[init] do not need Zeus");
        return;
    L6:
        FLogger r100 = FLogger.f375446a;
        r100.i("ZeusPluginServiceImpl", "init, 插件服务初始化");
        if ((r210 instanceof Application) == true) goto L10;
        r100.e("ZeusPluginServiceImpl", "init, 插件服务初始化失败，context 不是 Application");
        return;
    L10:
        GlobalParam.getInstance().setReporter(new q());
        IRuntimeContext.Companion r101 = IRuntimeContext.f384990a;
        if (r101.a() == false) goto L13;
    L19:
        boolean r102 = true;
        GlobalParam.getInstance().setIgnoreWebViewRes(true);
        i r103 = new i();
        GlobalParam r104 = GlobalParam.getInstance();
        AppHost.Companion r105 = AppHost.f326268a;
        if (r105.isTestChannel() == false) goto L22;
    L25:
        boolean r106 = true;
    L26:
        r104.setDebug(r106);
        GlobalParam.getInstance().setLogger(r103);
        ApmUtils.register(new com.obric.assistant.zeus.plugin.a());
        Iterator r107 = a.a().iterator();
    L28:
        if (r107.hasNext() == false) goto L30;
        GlobalParam.getInstance().setAutoInstallInternal((String) r107.next(), false);
        goto L28
    L30:
        FLogger r108 = FLogger.f375446a;
        r108.i("ZeusPluginServiceImpl", "initDataMigration, 初始化数据迁移");
        GlobalParam r109 = GlobalParam.getInstance();
        IObricMigrationHandler r110 = (IObricMigrationHandler) ServiceManager.get().getService(IObricMigrationHandler.class);
        if (r110 == null) goto L33;
        n r111 = new n(r110);
    L34:
        r109.setMigrationHandlerFactory(r111);
        Application r112 = (Application) r210;
        GlobalParam.getInstance().setHostUrl("https://zeus-api.obriccloud.com/zeus/client/v2/query");
        GlobalParam.getInstance().setAutoFetch(false);
        IApm r113 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r113 != null) goto L37;
    L39:
        boolean r114 = false;
    L41:
        if (r114 == false) goto L87;
        c r115 = c.f395036a;
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        r108.d("ZeusAutoFetchManager", "init");
        c.f395037b = r112;
        if (r112 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        Application r116 = null;
    L46:
        Object r117 = r116.getSystemService("connectivity");
        if ((r117 instanceof ConnectivityManager) == false) goto L49;
        ConnectivityManager r118 = (ConnectivityManager) r117;
    L50:
        if (r118 == null) goto L52;
        r118.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), new com.obric.assistant.zeus.plugin.b(r118));
    L52:
        IntentFilter r119 = new IntentFilter("android.intent.action.USER_PRESENT");
        Context r120 = c.f395037b;
        if (r120 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        r120 = null;
    L55:
        BroadcastReceiver r121 = new ZeusAutoFetchManager$init$2();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L118;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L118:
    L81:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L86;
        ReceiverRegisterCrashOptimizer.registerReceiver(r121, r119);
    L85:
        GlobalParam.getInstance().setDownloadPolicy(c.f395036a);
        GlobalParam.getInstance().setPluginGroundProvider(h.f395045a);
    L91:
        GlobalParam.getInstance().setStartActivityFallback(new r());
        GlobalParam.getInstance().setCheckHostProtocolVersion(e());
        if (Intrinsics.areEqual(ObricFeatureServiceDelegate.f387839b.f(), "LowLevel") == false) goto L94;
        GlobalParam.getInstance().setEnableSubProcessInstallStateSnapshot(true);
        GlobalParam.getInstance().setEnableHostQueryPluginProcessPid(true);
    L94:
        ISecPrivacyService.f326368a.getClass();
        ISecPrivacyService r122 = ISecPrivacyService.a.a();
        if (r122 == null) goto L97;
        boolean r123 = r122.h();
    L98:
        Zeus.init(r112, r123);
        IApm r124 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r124 != null) goto L101;
    L103:
        boolean r125 = false;
    L104:
        if (r125 == true) goto L106;
        FLogger.f375446a.i("ZeusPluginServiceImpl", "afterPrivacy，跳过插件轮询，非主进程");
        return;
    L106:
        AppHost.Companion r126 = AppHost.f326268a;
        if (r126.isTestChannel() == false) goto L109;
    L112:
        if (r102 == true) goto L115;
        return;
    L115:
        if (Build.VERSION.SDK_INT < 26) goto L123;
        int r127 = ZeusDebugInfoReceiver.f395043a;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        ContextCompat.registerReceiver(r210, new ZeusDebugInfoReceiver(), new IntentFilter("com.obric.ZEUS_DEBUG_INFO"), "android.permission.ACCESS_NETWORK_STATE", null, 2);
        return;
    L123:
        return;
    L109:
        if (Intrinsics.areEqual(r126.getBuildChannel(), "auto_test") == true) goto L112;
        r102 = false;
        goto L112
    L101:
        if (r124.isMainProcess(r210) != true) goto L103;
        r125 = true;
        goto L104
    L97:
        r123 = false;
        goto L98
    L86:
        throw e;
    L59:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L72;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r119) == false) goto L72;
        int r128 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r121, r119, 0, null, null, 2, r120).result;     // Catch: Exception -> L81
        if (r128 != 1) goto L65;
        r120.registerReceiver(r121, r119);     // Catch: Exception -> L81
        goto L85
    L65:
        if (r128 != 2) goto L67;
        new Intent();     // Catch: Exception -> L81
        goto L85
    L67:
        if (r128 == 3) goto L85;
        r120.registerReceiver(r121, r119);     // Catch: Exception -> L81
    L72:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L75;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L81
        r120.registerReceiver(r121, r119, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L81
        goto L85
    L75:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L77;
    L79:
        r120.registerReceiver(r121, r119);     // Catch: Exception -> L81
        goto L85
    L77:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r119) == false) goto L79;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L81
        ContextCompat.registerReceiver(r120, r121, r119, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L81
        goto L85
    L49:
        r118 = null;
        goto L50
    L45:
        r116 = r112;
        goto L46
    L87:
        ZeusSubProcessMainProcessWakeupManager.f395021a.getClass();
        Intrinsics.checkNotNullParameter(r112, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (ZeusSubProcessMainProcessWakeupManager.f395026f == true) goto L91;
        ZeusSubProcessMainProcessWakeupManager.f395025e = r112.getApplicationContext();
        ZeusSubProcessMainProcessWakeupManager.f395026f = true;
        r108.i("ZeusSubProcessMainProcessWakeupManager", "init");
        r108.i("ZeusSubProcessMainProcessWakeupManager", "schedule request main process fetch after 10000 ms");
        ZeusSubProcessMainProcessWakeupManager.f395022b.postDelayed(ZeusSubProcessMainProcessWakeupManager.f395027g, 10000);
        goto L91
    L37:
        if (r113.isMainProcess(r112) != true) goto L39;
        r114 = true;
        goto L41
    L33:
        r111 = null;
        goto L34
    L22:
        if (Intrinsics.areEqual(r105.getBuildChannel(), "auto_test") == true) goto L25;
        r106 = false;
        goto L26
    L13:
        if (Build.VERSION.SDK_INT < 28) goto L19;
        WebView.setDataDirectorySuffix(r101.b());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        FLogger.f375446a.e("ZeusPluginServiceImpl", "setWebViewDataDirectory, 初始化 WebView 数据目录失败", e);
        goto L19
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final Object g(String r100, long r101, Continuation<? super Unit> r110) {
        if ((r110 instanceof ZeusPluginServiceImpl$preInstallPlugin$1) == false) goto L7;
        ZeusPluginServiceImpl$preInstallPlugin$1 r102 = (ZeusPluginServiceImpl$preInstallPlugin$1) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        long r106 = r102.J$0;
        ResultKt.throwOnFailure(r111);
    L25:
        FLogger.f375446a.i("ZeusPluginServiceImpl", "preInstallPlugin finish. cost " + (SystemClock.elapsedRealtime() - r106) + " ms");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        if (h() == true) goto L18;
        com.bytedance.crash.d.b("invalid process");
        return Unit.INSTANCE;
    L18:
        FLogger.f375446a.i("ZeusPluginServiceImpl", "preInstallPlugin hostApkPath " + r100 + " timeoutMS " + r101);
        long r107 = SystemClock.elapsedRealtime();
        int r112 = com.volcengine.zeus.h.f462707a;
        b r113 = new b();
        r102.J$0 = r107;
        r102.label = 1;
        Object r108 = new PreInstallTask(r100, r101, r113).a(r102);
        if (r108 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        r108 = Unit.INSTANCE;
    L22:
        if (r108 != r104) goto L24;
        return r104;
    L24:
        r106 = r107;
    L7:
        r102 = new ZeusPluginServiceImpl$preInstallPlugin$1(this, r110);
        goto L8
    }
}
