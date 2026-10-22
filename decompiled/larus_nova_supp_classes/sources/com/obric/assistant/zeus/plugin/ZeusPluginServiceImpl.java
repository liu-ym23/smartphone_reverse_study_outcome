package com.obric.assistant.zeus.plugin;

import android.app.Application;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.SystemClock;
import android.util.EventsUtils;
import android.webkit.WebView;
import androidx.core.content.ContextCompat;
import com.bytedance.crash.d;
import com.bytedance.keva.Keva;
import com.bytedance.sysoptimizer.ReceiverRegisterAnrOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterCrashOptimizer;
import com.bytedance.sysoptimizer.ReceiverRegisterLancet;
import com.larus.apm.api.IApm;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.utils.logger.FLogger;
import com.obric.activeness.IObricActivenessMonitorService;
import com.obric.activeness.ObricActiveReason;
import com.obric.aiagent.platform.depend.IRuntimeContext;
import com.obric.assistant.common.spi.ObricFeatureServiceDelegate;
import com.obric.assistant.interaction.impl.essentialtask.TaskUtils;
import com.obric.assistant.zeus.plugin.debuginfo.ZeusDebugInfoReceiver;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.volcengine.zeus.GlobalParam;
import com.volcengine.zeus.Zeus;
import com.volcengine.zeus.apm.ApmUtils;
import com.volcengine.zeus.h;
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
import org.xmlpull.v1.XmlPullParser;
import t9a.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u000b\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\f\u001a\u00020\bH\u0002J\b\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\b2\u0006\u0010\u0010\u001a\u00020\u000eH\u0016J\b\u0010\u0011\u001a\u00020\bH\u0002J\b\u0010\u0012\u001a\u00020\bH\u0002J\b\u0010\u0013\u001a\u00020\bH\u0002J\b\u0010\u0014\u001a\u00020\bH\u0003J\b\u0010\u0015\u001a\u00020\bH\u0002J\u0010\u0010\u0016\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\b\u0010\u0019\u001a\u00020\bH\u0002J\u0010\u0010\u001a\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0018\u0010\u001b\u001a\n\u0012\u0004\u0012\u00020\u001d\u0018\u00010\u001c2\u0006\u0010\t\u001a\u00020\nH\u0016J\u0010\u0010\u001e\u001a\u00020\u000e2\u0006\u0010\u001f\u001a\u00020\u001dH\u0016J\b\u0010 \u001a\u00020\bH\u0016J\u000e\u0010!\u001a\b\u0012\u0004\u0012\u00020\u001d0\u001cH\u0002J\u001e\u0010\"\u001a\u00020\b2\u0006\u0010#\u001a\u00020\u001d2\u0006\u0010$\u001a\u00020%H\u0096@¢\u0006\u0002\u0010&J\u000e\u0010'\u001a\u00020\bH\u0096@¢\u0006\u0002\u0010(J\u001a\u0010)\u001a\u000e\u0012\u0004\u0012\u00020\u000e\u0012\u0004\u0012\u00020\u001d0*H\u0096@¢\u0006\u0002\u0010(J\u0010\u0010+\u001a\u00020\u000e2\u0006\u0010,\u001a\u00020\u001dH\u0016J\b\u0010-\u001a\u00020\u001dH\u0002J\b\u0010.\u001a\u00020\u000eH\u0002R\u0016\u0010\u0004\u001a\n \u0006*\u0004\u0018\u00010\u00050\u0005X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/obric/assistant/zeus/plugin/ZeusPluginServiceImpl;", "Lcom/obric/assistant/zeus/plugin/IZeusPluginService;", "<init>", "()V", "keva", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "init", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "plantDebugUtil", "initProtocolVersionChecker", "isProtocolVersionCheckerEnabled", XmlPullParser.NO_NAMESPACE, "setProtocolVersionCheckerEnabled", "enable", "plantStartActivityFallback", "initMobReporter", "initWebview", "setWebViewDataDirectory", "initApm", "initPluginFetchManager", "Landroid/app/Application;", "initDataMigration", "initPluginInstaller", "afterPrivacy", "getUploadFilePaths", XmlPullParser.NO_NAMESPACE, XmlPullParser.NO_NAMESPACE, "isPluginInstalled", "pluginPackageName", "installFromDownloadDir", "getAllPluginPkgName", "preInstallPlugin", "hostApkPath", "timeoutMS", XmlPullParser.NO_NAMESPACE, "(Ljava/lang/String;JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "clearPreInstallData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "waitPluginInstall", "Lkotlin/Pair;", "isPluginPreInstalled", "hostPkgVersionCode", "getSimpleProcessName", "isCurrentProcessNeedZeus", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ZeusPluginServiceImpl implements IZeusPluginService {
    public static final List<String> b = null;
    public static final List<String> c = null;
    public static Boolean d;
    public final Keva a;

    public static final class a {
        public static final List a() {
            List<String> r0 = ZeusPluginServiceImpl.b;
            List r1 = CollectionsKt.createListBuilder();
            if (b.a().e() == true) goto L5;
            r1.add(TaskUtils.MEMORY_DATA_PLUGIN_PKG_NAME);
        L5:
            r1.add("com.obric.aiagent.plugin");
            return CollectionsKt.build(r1);
        }

        public a() {
        }
    }

    static {
        new a();
        b = CollectionsKt.listOf("zeus_com.obric.memorydata.plugin/star");
        c = CollectionsKt.listOf("interactor");
    }

    public static boolean h() {
        Boolean r0 = d;
        if (r0 != null) goto L5;
        List<String> r1 = c;
        String r2 = IRuntimeContext.a.b();     // Catch: Throwable -> L11
        String r3 = StringsKt.substringAfterLast$default(r2, ":", null, 2, null);
        if (Intrinsics.areEqual(r3, r2) == true) goto L13;
    L14:
        boolean r4 = !r1.contains(r3);
        d = Boolean.valueOf(r4);
        return r4;
    L13:
        r3 = "main";
    L11:
        th = move-exception;
        FLogger.a.w("ZeusPluginServiceImpl", "[process] getProcessName failed", th);
        goto L13
    L5:
        return r0.booleanValue();
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final boolean a() {
        Intrinsics.checkNotNullParameter("com.obric.aiagent.plugin", "pluginPackageName");
        if (h() == true) goto L7;
        d.b("invalid process");
        return false;
    L7:
        return Zeus.isPluginInstalled("com.obric.aiagent.plugin");
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final boolean e() {
        AppHost.Companion r0 = AppHost.a;
        if (r0.isTestChannel() == false) goto L5;
    L8:
        boolean r1 = true;
    L9:
        if (r1 == true) goto L11;
    L12:
        return true;
    L11:
        if (this.a.getBoolean("enable_protocol_checker", true) == true) goto L12;
        return false;
    L5:
        if (Intrinsics.areEqual(r0.getBuildChannel(), "auto_test") == true) goto L8;
        r1 = false;
        goto L9
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final void f() {
        if (IRuntimeContext.a.a() == true) goto L6;
        d.b("installFromDownloadDir called in non-main process");
        return;
    L6:
        Zeus.installFromDownloadDir();
    }

    public ZeusPluginServiceImpl() {
        this.a = Keva.getRepo("zeus_plugin_related", 1);
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final List<String> b(Context r5) {
        Intrinsics.checkNotNullParameter(r5, "context");
        String r6 = AppHost.a.getApplication().getFilesDir().getAbsolutePath() + '/';
        List<String> r0 = b;
        ArrayList r1 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r0, 10));
        Iterator<T> r2 = r0.iterator();
    L4:
        if (r2.hasNext() == false) goto L6;
        r1.add(r6 + ((String) r2.next()));
        goto L4
    L6:
        return r1;
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final boolean c(String r7) {
        Intrinsics.checkNotNullParameter(r7, "hostPkgVersionCode");
        if (h() == true) goto L6;
        d.b("invalid process");
        return false;
    L6:
        int r1 = h.a;
        Intrinsics.checkNotNullParameter(r7, "hostPkgVersionCode");
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: hostPkgVersionCode = " + r7);
        int r0 = ZeusPreInstallSpUtil.a().getInt("host_version", -1);
        if (r0 > 0) goto L9;
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: is not install. installHostVersion = " + r0);
        return false;
    L9:
        int r3 = ZeusPreInstallSpUtil.a().getInt("tool_version", -1);
        if (r3 == 1) goto L13;
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: toolVersion not match. toolVersion = " + r3 + ", curToolsVersion = 1");
        return false;
    L13:
        if (Intrinsics.areEqual(String.valueOf(r0), r7) == false) goto L15;
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: yes, " + r7 + " is preinstalled");
        return true;
    L15:
        ZeusLogger.i("ZeusKt", "isPluginPreInstalled: no, " + r7 + " is not preinstalled");
        return false;
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final void d(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (h() == true) goto L6;
        FLogger.a.i("ZeusPluginServiceImpl", "[privacy] do not need Zeus");
        return;
    L6:
        Zeus.onPrivacyAgreed();
        IApm r0 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r0 != null) goto L9;
    L11:
        boolean r8 = false;
    L12:
        if (r8 == true) goto L15;
        FLogger.a.i("ZeusPluginServiceImpl", "afterPrivacy，跳过插件轮询，非主进程");
        return;
    L15:
        Iterator r9 = a.a().iterator();
    L17:
        if (r9.hasNext() == false) goto L23;
        String r1 = (String) r9.next();
        c r2 = c.a;
        String[] r3 = {r1};
        Intrinsics.checkNotNullParameter(r3, "pluginPkg");
        FLogger.a.d("ZeusAutoFetchManager", "startAutoFetch: pluginPkg=" + Arrays.toString(r3) + ", startNow=true");
        c.e = CollectionsKt.distinct(CollectionsKt.plus(c.e, r3));
        int r4 = 0;
    L19:
        c r5 = c.a;
        if (r4 >= 1) goto L22;
        c.b(r3[r4]);
        r4 = r4 + 1;
        goto L19
    L22:
        c.a(r3[0], "start_auto_fetch");
        goto L17
    L23:
        h r10 = h.a;
        r10.getClass();
        ((IObricActivenessMonitorService) h.d.getValue()).b(r10, SetsKt.setOf(new ObricActiveReason[]{ObricActiveReason.DEVICE_SCREEN_ON, ObricActiveReason.PLUGIN_UPDATE}));
        return;
    L9:
        if (r0.isMainProcess(r7) != true) goto L11;
        r8 = true;
        goto L12
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final void init(Context r20) {
        Intrinsics.checkNotNullParameter(r20, "context");
        if (h() == true) goto L6;
        FLogger.a.i("ZeusPluginServiceImpl", "[init] do not need Zeus");
        return;
    L6:
        FLogger r0 = FLogger.a;
        r0.i("ZeusPluginServiceImpl", "init, 插件服务初始化");
        if ((r20 instanceof Application) == true) goto L10;
        r0.e("ZeusPluginServiceImpl", "init, 插件服务初始化失败，context 不是 Application");
        return;
    L10:
        GlobalParam.getInstance().setReporter(new q());
        IRuntimeContext.Companion r1 = IRuntimeContext.a;
        if (r1.a() == false) goto L13;
    L19:
        boolean r4 = true;
        GlobalParam.getInstance().setIgnoreWebViewRes(true);
        i r2 = new i();
        GlobalParam r5 = GlobalParam.getInstance();
        AppHost.Companion r6 = AppHost.a;
        if (r6.isTestChannel() == false) goto L22;
    L25:
        boolean r7 = true;
    L26:
        r5.setDebug(r7);
        GlobalParam.getInstance().setLogger(r2);
        ApmUtils.register(new com.obric.assistant.zeus.plugin.a());
        Iterator r3 = a.a().iterator();
    L28:
        if (r3.hasNext() == false) goto L30;
        GlobalParam.getInstance().setAutoInstallInternal((String) r3.next(), false);
        goto L28
    L30:
        FLogger r8 = FLogger.a;
        r8.i("ZeusPluginServiceImpl", "initDataMigration, 初始化数据迁移");
        GlobalParam r9 = GlobalParam.getInstance();
        IObricMigrationHandler r10 = (IObricMigrationHandler) ServiceManager.get().getService(IObricMigrationHandler.class);
        if (r10 == null) goto L33;
        n r11 = new n(r10);
    L34:
        r9.setMigrationHandlerFactory(r11);
        Application r12 = (Application) r20;
        GlobalParam.getInstance().setHostUrl("https://zeus-api.obriccloud.com/zeus/client/v2/query");
        GlobalParam.getInstance().setAutoFetch(false);
        IApm r13 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r13 != null) goto L37;
    L39:
        boolean r14 = false;
    L41:
        if (r14 == false) goto L87;
        c r15 = c.a;
        Intrinsics.checkNotNullParameter(r12, "context");
        r8.d("ZeusAutoFetchManager", "init");
        c.b = r12;
        if (r12 != null) goto L45;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        Application r16 = null;
    L46:
        Object r17 = r16.getSystemService("connectivity");
        if ((r17 instanceof ConnectivityManager) == false) goto L49;
        ConnectivityManager r18 = (ConnectivityManager) r17;
    L50:
        if (r18 == null) goto L52;
        r18.registerNetworkCallback(new NetworkRequest.Builder().addTransportType(1).build(), new b(r18));
    L52:
        IntentFilter r19 = new IntentFilter("android.intent.action.USER_PRESENT");
        Context r110 = c.b;
        if (r110 != null) goto L55;
        Intrinsics.throwUninitializedPropertyAccessException("applicationContext");
        r110 = null;
    L55:
        ZeusAutoFetchManager.init.2 r111 = new ZeusAutoFetchManager.init.2();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L118;
        ReceiverRegisterCrashOptimizer.doHWReceiverFix();
    L118:
    L81:
        e = move-exception;
        e.toString();
        e.printStackTrace();
        if (ReceiverRegisterCrashOptimizer.fixedOpen() == false) goto L86;
        ReceiverRegisterCrashOptimizer.registerReceiver(r111, r19);
    L85:
        GlobalParam.getInstance().setDownloadPolicy(c.a);
        GlobalParam.getInstance().setPluginGroundProvider(h.a);
    L91:
        GlobalParam.getInstance().setStartActivityFallback(new r());
        GlobalParam.getInstance().setCheckHostProtocolVersion(e());
        if (Intrinsics.areEqual(ObricFeatureServiceDelegate.b.f(), "LowLevel") == false) goto L94;
        GlobalParam.getInstance().setEnableSubProcessInstallStateSnapshot(true);
        GlobalParam.getInstance().setEnableHostQueryPluginProcessPid(true);
    L94:
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r21 = ISecPrivacyService.a.a();
        if (r21 == null) goto L97;
        boolean r22 = r21.h();
    L98:
        Zeus.init(r12, r22);
        IApm r23 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r23 != null) goto L101;
    L103:
        boolean r24 = false;
    L104:
        if (r24 == true) goto L106;
        FLogger.a.i("ZeusPluginServiceImpl", "afterPrivacy，跳过插件轮询，非主进程");
        return;
    L106:
        AppHost.Companion r25 = AppHost.a;
        if (r25.isTestChannel() == false) goto L109;
    L112:
        if (r4 == true) goto L115;
        return;
    L115:
        if (Build.VERSION.SDK_INT < 26) goto L123;
        int r26 = ZeusDebugInfoReceiver.a;
        Intrinsics.checkNotNullParameter(r20, "context");
        ContextCompat.registerReceiver(r20, new ZeusDebugInfoReceiver(), new IntentFilter("com.obric.ZEUS_DEBUG_INFO"), "android.permission.ACCESS_NETWORK_STATE", null, 2);
        return;
    L123:
        return;
    L109:
        if (Intrinsics.areEqual(r25.getBuildChannel(), "auto_test") == true) goto L112;
        r4 = false;
        goto L112
    L101:
        if (r23.isMainProcess(r20) != true) goto L103;
        r24 = true;
        goto L104
    L97:
        r22 = false;
        goto L98
    L86:
        throw e;
    L59:
        if (ReceiverRegisterAnrOptimizer.isEnableScreenReceiverOptimize() == false) goto L72;
        if (ReceiverRegisterAnrOptimizer.hasScreenActions(r19) == false) goto L72;
        int r28 = ReceiverRegisterAnrOptimizer.handleScreenActionRegistration(r111, r19, 0, null, null, 2, r110).result;     // Catch: Exception -> L81
        if (r28 != 1) goto L65;
        r110.registerReceiver(r111, r19);     // Catch: Exception -> L81
        goto L85
    L65:
        if (r28 != 2) goto L67;
        new Intent();     // Catch: Exception -> L81
        goto L85
    L67:
        if (r28 == 3) goto L85;
        r110.registerReceiver(r111, r19);     // Catch: Exception -> L81
    L72:
        if (ReceiverRegisterCrashOptimizer.doRegisterHandler() == false) goto L75;
        ReceiverRegisterLancet.initHandler();     // Catch: Exception -> L81
        r110.registerReceiver(r111, r19, null, ReceiverRegisterLancet.sReceiverHandler);     // Catch: Exception -> L81
        goto L85
    L75:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler() != null) goto L77;
    L79:
        r110.registerReceiver(r111, r19);     // Catch: Exception -> L81
        goto L85
    L77:
        if (ReceiverRegisterCrashOptimizer.getReceiverRegisterHandler().needHookFilter(r19) == false) goto L79;
        ReceiverRegisterLancet.initProxyHandler();     // Catch: Exception -> L81
        ContextCompat.registerReceiver(r110, r111, r19, null, ReceiverRegisterLancet.sProxyHandler, 2);     // Catch: Exception -> L81
        goto L85
    L49:
        r18 = null;
        goto L50
    L45:
        r16 = r12;
        goto L46
    L87:
        ZeusSubProcessMainProcessWakeupManager.a.getClass();
        Intrinsics.checkNotNullParameter(r12, "context");
        if (ZeusSubProcessMainProcessWakeupManager.f == true) goto L91;
        ZeusSubProcessMainProcessWakeupManager.e = r12.getApplicationContext();
        ZeusSubProcessMainProcessWakeupManager.f = true;
        r8.i("ZeusSubProcessMainProcessWakeupManager", "init");
        r8.i("ZeusSubProcessMainProcessWakeupManager", "schedule request main process fetch after 10000 ms");
        ZeusSubProcessMainProcessWakeupManager.b.postDelayed(ZeusSubProcessMainProcessWakeupManager.g, 10000);
        goto L91
    L37:
        if (r13.isMainProcess(r12) != true) goto L39;
        r14 = true;
        goto L41
    L33:
        r11 = null;
        goto L34
    L22:
        if (Intrinsics.areEqual(r6.getBuildChannel(), "auto_test") == true) goto L25;
        r7 = false;
        goto L26
    L13:
        if (Build.VERSION.SDK_INT < 28) goto L19;
        WebView.setDataDirectorySuffix(r1.b());     // Catch: Exception -> L17
    L17:
        e = move-exception;
        FLogger.a.e("ZeusPluginServiceImpl", "setWebViewDataDirectory, 初始化 WebView 数据目录失败", e);
        goto L19
    }

    @Override // com.obric.assistant.zeus.plugin.IZeusPluginService
    public final Object g(String r8, long r9, Continuation<? super Unit> r11) {
        if ((r11 instanceof preInstallPlugin.1) == false) goto L7;
        preInstallPlugin.1 r0 = (preInstallPlugin.1) r11;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r12 = r0.result;
        Object r2 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r3 = r0.label;
        if (r3 == 0) goto L14;
        if (r3 != 1) goto L13;
        long r10 = r0.J$0;
        ResultKt.throwOnFailure(r12);
    L25:
        FLogger.a.i("ZeusPluginServiceImpl", "preInstallPlugin finish. cost " + (SystemClock.elapsedRealtime() - r10) + " ms");
        return Unit.INSTANCE;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r12);
        if (h() == true) goto L18;
        d.b("invalid process");
        return Unit.INSTANCE;
    L18:
        FLogger.a.i("ZeusPluginServiceImpl", "preInstallPlugin hostApkPath " + r8 + " timeoutMS " + r9);
        long r5 = SystemClock.elapsedRealtime();
        int r13 = h.a;
        b r14 = new b();
        r0.J$0 = r5;
        r0.label = 1;
        Object r15 = new PreInstallTask(r8, r9, r14).a(r0);
        if (r15 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L22;
        r15 = Unit.INSTANCE;
    L22:
        if (r15 != r2) goto L24;
        return r2;
    L24:
        r10 = r5;
    L7:
        r0 = new preInstallPlugin.1(this, r11);
        goto L8
    }
}
