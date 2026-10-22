package com.larus.apm.impl;

import android.app.Application;
import android.content.Context;
import android.os.Process;
import android.util.EventsUtils;
import b27.j;
import com.bytedance.apm.ApmAgent;
import com.bytedance.apm.config.ApmStartConfig;
import com.bytedance.apm.config.b;
import com.bytedance.apm.internal.ApmDelegate;
import com.bytedance.apm.util.r;
import com.bytedance.crash.Npth;
import com.bytedance.memory.MemoryWidget;
import com.bytedance.memory.model.MemoryWidgetConfig;
import com.larus.apm.api.IApm;
import com.larus.apm.api.IApmConfigs;
import com.larus.apm.api.IExtraParams;
import com.larus.applog.api.IApplog;
import com.larus.common.apphost.AppHost;
import com.larus.settings.value.al;
import com.larus.settings.value.cm;
import com.larus.settings.value.e10;
import com.larus.settings.value.ur;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.common.spi.IObricSlardarConfigService;
import com.obric.assistant.common.spi.ObricConfigServiceDelegate;
import com.obric.assistant.common.spi.alog.ObricAlogServiceDelegate;
import com.ss.android.agilelogger.ALog;
import com.ss.android.agilelogger.ALogConfig;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import is3.d;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.collections.SetsKt;
import kotlin.jvm.internal.Intrinsics;
import ns3.c;
import org.xmlpull.v1.XmlPullParser;
import q48.h;
import q48.k;
import q48.l;
import q48.m;
import qt9.t;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\b\u0003\n\u0002\u0018\u0002\b\u0007\u0018\u0000 $2\u00020\u0001:\u0001$B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J \u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0016J\b\u0010\u0012\u001a\u00020\u000bH\u0016J\u0010\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\bH\u0016J\u0010\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010\u0019\u001a\u00020\u000b2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0012\u0010\u001a\u001a\u00020\u000b2\b\b\u0002\u0010\u001b\u001a\u00020\u001cH\u0002J\u0010\u0010\u001d\u001a\u00020\r2\u0006\u0010\u001e\u001a\u00020\u001fH\u0016J\u0010\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\rH\u0016J\u0014\u0010\"\u001a\u000e\u0012\u0004\u0012\u00020\u001c\u0012\u0004\u0012\u00020\u001c0#H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u000e\u0012\u0004\u0012\u00020\b\u0012\u0004\u0012\u00020\t0\u0007X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006%²\u0006\n\u0010&\u001a\u00020'X\u008a\u0084\u0002"}, d2 = {"Lcom/larus/apm/impl/ApmImpl;", "Lcom/larus/apm/api/IApm;", "<init>", "()V", "logObserverLock", XmlPullParser.NO_NAMESPACE, "logObserverAdapters", "Ljava/util/IdentityHashMap;", "Lcom/larus/apm/api/ApmLogObserver;", "Lcom/bytedance/apm/listener/IApmLogListener;", "initLogAndALog", XmlPullParser.NO_NAMESPACE, "debug", XmlPullParser.NO_NAMESPACE, "maxALogDirSizeMb", XmlPullParser.NO_NAMESPACE, "application", "Landroid/app/Application;", "initApm", "addLogObserver", "observer", "configApmOpt", "configBuilder", "Lcom/bytedance/apm/config/ApmInitConfig$Builder;", "configBlockDetect", "configBinderMonitor", "startApm", "did", XmlPullParser.NO_NAMESPACE, "isMainProcess", "context", "Landroid/content/Context;", "registerDolaCloudControlConsumer", "isMinorMode", "assembleApmDynamicParams", XmlPullParser.NO_NAMESPACE, "Companion", "impl_mainlandRelease", "blockConfig", "Lcom/larus/settings/provider/BlockDetectConfig;"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ApmImpl implements IApm {
    public static final Lazy<Boolean> a = null;

    public static final class a {
    }

    @Override // com.larus.apm.api.IApm
    public final void c() {
        boolean r0 = true;
        ApmAgent.FAST_MODE = true;
        jt3.a.a = true;
        ((hs3.a) is3.a.h()).d = true;
        ((hs3.a) d.a.a).d = true;
        c r1 = new c(true, true, true);
        b.a r2 = new b.a();
        r2.m = r1;
        r2.a = true;
        r2.f = true;
        Intrinsics.checkNotNull(r2);
        Lazy r3 = LazyKt.lazy(new q48.d());
        Set r4 = SetsKt.setOf(new String[]{"inhouse", "local_test", "auto_test", "beta", "release"});
        AppHost.Companion r5 = AppHost.a;
        if (r4.contains(r5.getBuildChannel()) == true) goto L5;
    L7:
        r2.b = 20000000;
        r2.g = false;
        Intrinsics.checkNotNull(r2);
        e10 r6 = e10.a;
        int r7 = l0.a;
        r2.h = ((Boolean) l0.a(Boolean.FALSE, new ur())).booleanValue();
        r2.j = r5.isDebug();
        r2.k = true;
        r2.n = false;
        Intrinsics.checkNotNull(r2);
        if (a.getValue().booleanValue() == false) goto L10;
        j.a = true;
        r2.p = true;
        r2.q = true;
    L10:
        r2.o = true;
        com.bytedance.apm.config.a.a r8 = new com.bytedance.apm.config.a.a();
        r8.a = false;
        r8.c = true;
        r8.b = 60000;
        r8.d = true;
        r8.e = new q48.c();
        r2.l = new com.bytedance.apm.config.a(r8);
        b r9 = new b(r2);
        int r10 = com.bytedance.apm.c.b.a;
        Application r11 = r5.getApplication();
        ApmDelegate.g.a.c(r11, r9);
        if (com.bytedance.apm.d.c == false) goto L13;
        bt3.c.a().b(new com.bytedance.apm.b());
    L13:
        IApplog.Companion r12 = IApplog.a;
        String r13 = r12.getDeviceId();
        if (r13.length() > 0) goto L17;
        r0 = false;
    L17:
        if (r0 == false) goto L19;
        d(r13);
        return;
    L19:
        r12.j(new b(this));
        return;
    L5:
        if (((t) r3.getValue()).b() == false) goto L7;
        r2.c = ((t) r3.getValue()).b();
        r2.d = ((t) r3.getValue()).c();
        r2.e = ((t) r3.getValue()).a();
        goto L7
    }

    static {
        a = LazyKt.lazy(new q48.b());
    }

    public ApmImpl() {
        new IdentityHashMap();
    }

    @Override // com.larus.apm.api.IApm
    public final void b(boolean r4) {
        if (AppHost.a.isOversea() == false) goto L9;
        FLogger.a.d("ApmImpl", "registerDolaCloudControlConsumer, isMinorMode: " + r4);
        y8a.b r0 = new c(r4);
        if (x8a.c.k == false) goto L7;
        x8a.c.b().c(r0);
        return;
    L7:
        x8a.c.h = r0;
        return;
    }

    public final void d(String r6) {
        IApmConfigs r0 = (IApmConfigs) ServiceManager.get().getService(IApmConfigs.class);
        if (r0 == null) goto L23;
        ApmStartConfig.Builder r1 = new ApmStartConfig.Builder();
        AppHost.Companion r2 = AppHost.a;
        ApmStartConfig.Builder r7 = r1.aid(r2.getAppId()).channel(r2.getBuildChannel()).appVersion(r2.getVersionName()).updateVersionCode(String.valueOf(r2.getUpdateVersionCode())).deviceId(r6).useDefaultTTNetImpl(true).releaseBuild(r.a()).widget(new MemoryWidget(MemoryWidgetConfig.newBuilder().build(), null)).blockDetect(true).seriousBlockDetect(true).widget(new x8a.d()).blockDetectOnlySampled(true).batteryDetect(true).requestTagHeaderProvider(new d()).dynamicParams(new e(this));
        Iterator<Map.Entry<String, String>> r3 = IExtraParams.a.c().entrySet().iterator();
    L6:
        if (r3.hasNext() == false) goto L8;
        Map.Entry<String, String> r4 = r3.next();
        r7.param(r4.getKey(), r4.getValue());
        goto L6
    L8:
        Map<String, String> r5 = ObricConfigServiceDelegate.b.getCommonParams();
        if (r5 == null) goto L15;
        Iterator<Map.Entry<String, String>> r8 = r5.entrySet().iterator();
    L12:
        if (r8.hasNext() == false) goto L15;
        Map.Entry<String, String> r9 = r8.next();
        r7.param(r9.getKey(), r9.getValue());
    L15:
        if (AppHost.a.isOversea() == false) goto L17;
        r0.g();
        ApmStartConfig.Builder r10 = r7.configFetchUrl(null);
        r0.e();
        ApmStartConfig.Builder r11 = r10.defaultReportUrls(null);
        r0.b();
        r11.exceptionLogDefaultReportUrls(null);
    L17:
        String r12 = ObricAlogServiceDelegate.b.c(com.bytedance.apm.util.a.a(Process.myPid()), null);
        if (r12 == null) goto L20;
        r7.setAlogFilesDir(r12);
    L20:
        int r13 = com.bytedance.apm.c.b.a;
        com.bytedance.apm.c.a(r7.build());
        ((IObricSlardarConfigService) nda.b.a.getValue()).a();
        return;
    L23:
        throw new IllegalStateException();
    }

    @Override // com.larus.apm.api.IApm
    public final boolean isMainProcess(Context r2) {
        Intrinsics.checkNotNullParameter(r2, "context");
        return com.bytedance.apm.util.a.b(r2);
    }

    @Override // com.larus.apm.api.IApm
    public final void a(boolean r3, int r4, Application r5) {
        Intrinsics.checkNotNullParameter(r5, "application");
        boolean r0 = k.a;
        Intrinsics.checkNotNullParameter(r5, "context");
        k.a = r3;
        e10 r1 = e10.a;
        int r2 = l0.a;
        int r6 = ((Number) l0.a(2, new cm())).intValue();
        ALogConfig.b r7 = new ALogConfig.b(r5);
        r7.b = (r4 * 1024) * 1024;
        r7.c = 2097152;
        r7.e = true;
        r7.f = true;
        r7.g = true;
        ALogConfig r8 = r7.a();
        ObricAlogServiceDelegate.b.h(r8);
        ALog.init(r8);
        ALog.setDebug(r3);
        k.b = r6;
        ALog.changeLevel(r6);
        StringBuilder r9 = new StringBuilder("BEFORE Alog Consumer, isOversea: ");
        AppHost.Companion r10 = AppHost.a;
        r9.append(r10.isOversea());
        k.b("Logger", r9.toString());
        if (r10.isOversea() == true) goto L9;
        k.b("Logger", "Setting Alog Consumer, isOversea: " + r10.isOversea());
        l r11 = new l();
        if (x8a.c.k == false) goto L7;
        x8a.c.b().c(r11);
        goto L9
    L7:
        x8a.c.h = r11;
    L9:
        if (ALog.isInitSuccess() == false) goto L11;
        ALog.i("Logger", "alog enableALogCollector");
        Npth.enableALogCollector(ALog.sConfig.getLogDirPath(), new h(), new wg4.b());
    L11:
        ALog.addLogFileDeleteListener(new m());
        q48.a.C0012a r12 = q48.a.a;
        monitor-enter(r12);
    L19:
        th = move-exception;
        throw th;
    L14:
        if (q48.a.a() != null) goto L16;
        new q48.a();     // Catch: Throwable -> L19
    L16:
        monitor-exit(r12);
        k.c = true;
        k.e();
        boolean r13 = LoggerImpl.a;
        LoggerImpl.a = ((Boolean) l0.a(Boolean.FALSE, new al())).booleanValue();
    }
}
