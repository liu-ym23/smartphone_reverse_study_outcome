package com.obric.assistant;

import android.app.Application;
import android.content.Context;
import android.os.Build;
import android.util.EventsUtils;
import com.bytedance.keva.KevaBuilder;
import com.bytedance.mira.log.MiraMonitor;
import com.bytedance.security.android.aopcheck.PolarisFileWrapper;
import com.larus.apm.api.IApm;
import com.larus.apm.api.IApmTrace;
import com.larus.apm.api.IExtraParams;
import com.larus.common.apphost.AppHost;
import com.larus.common.mssdk.api.ISecPrivacyService;
import com.larus.settings.value.e10;
import com.larus.settings.value.nj;
import com.larus.utils.l0;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.platform.IAIAgentPlatform;
import com.obric.assistant.common.spi.ObricConfigServiceDelegate;
import com.obric.assistant.spi.app.IObricAppService;
import com.obric.assistant.spi.app.IObricLaunchService;
import com.obric.assistant.spi.essentialtask.IObricEssentialTaskService;
import com.obric.assistant.state.ISharedStateService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import ita.k;
import java.util.Iterator;
import java.util.Map;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.jvm.internal.Intrinsics;
import mga.b;
import org.json.JSONObject;
import org.xmlpull.v1.XmlPullParser;
import xga.c;
import xga.d;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u0000 \u001c2\u00020\u0001:\u0001\u001cB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010\u0004\u001a\u00020\u00052\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0010\u0010\b\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\u0018\u0010\n\u001a\u00020\t2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eH\u0016J\u0010\u0010\u000f\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0016J\b\u0010\u0010\u001a\u00020\tH\u0002J\b\u0010\u0011\u001a\u00020\tH\u0002J\u0010\u0010\u0012\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0015\u001a\u00020\t2\u0006\u0010\u0006\u001a\u00020\u0007H\u0002J\u0010\u0010\u0016\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0017\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u0010\u0010\u0018\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u0014H\u0016J\u001a\u0010\u0019\u001a\u00020\t2\u0006\u0010\u0013\u001a\u00020\u00142\b\u0010\u001a\u001a\u0004\u0018\u00010\u001bH\u0016¨\u0006\u001d"}, d2 = {"Lcom/obric/assistant/ObricAppServiceImpl;", "Lcom/obric/assistant/spi/app/IObricAppService;", "<init>", "()V", "shouldTakeOverEarlyStartup", XmlPullParser.NO_NAMESPACE, "context", "Landroid/content/Context;", "onEarlyStartupFailed", XmlPullParser.NO_NAMESPACE, "setAgentCommonParams", "key", XmlPullParser.NO_NAMESPACE, "obj", XmlPullParser.NO_NAMESPACE, "beforeAttachBaseContext", "registerObricPermission", "registerObricSettingConst", "afterAttachBaseContext", "application", "Landroid/app/Application;", "initFlowAppLog", "beforeOnCreate", "afterOnCreate", "syncColdBootSettings", "onColdBootSettingsUpdated", "appSettings", "Lorg/json/JSONObject;", "Companion", "app_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricAppServiceImpl implements IObricAppService {

    public static final class a {
    }

    static {
    }

    public ObricAppServiceImpl() {
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void a(Application r4) {
        Intrinsics.checkNotNullParameter(r4, "application");
        FLogger.a.i("ObricAppServiceImpl", "afterOnCreate");
        if (mda.a.b(r4) == false) goto L7;
        IObricLaunchService r0 = (IObricLaunchService) ServiceManager.get().getService(IObricLaunchService.class);
        if (r0 == null) goto L7;
        r0.init();
    L7:
        IObricAvailableManager.a.getClass();
        IObricAvailableManager r1 = IObricAvailableManager.a.a();
        if (r1 == null) goto L11;
        r1.init(r4);
        return;
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void b(Application r4) {
        Intrinsics.checkNotNullParameter(r4, "application");
        FLogger r0 = FLogger.a;
        r0.i("ObricAppServiceImpl", "beforeOnCreate");
        if (mda.a.b(r4) == false) goto L5;
    L6:
        ISharedStateService.a.getClass();
        ISharedStateService r5 = ISharedStateService.a.a();
        if (r5 == null) goto L9;
        r5.init();
        return;
    L9:
        r0.w("ISharedStateService", "init null");
        return;
    L5:
        if (mda.a.a(r4) == true) goto L6;
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void beforeAttachBaseContext(Context r8) {
        Intrinsics.checkNotNullParameter(r8, "context");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r8, "context");
        Intrinsics.checkNotNullParameter("base", "key");
        Intrinsics.checkNotNullParameter(r8, "obj");
        FLogger r4 = FLogger.a;
        r4.i("ObricAppServiceImpl", "setAgentCommonParams: base, " + r8);
        IAIAgentPlatform.a.getClass();
        Intrinsics.checkNotNullParameter("base", "key");
        Intrinsics.checkNotNullParameter(r8, "obj");
        IAIAgentPlatform.a.b.put("base", r8);
        ServiceManager r1 = ServiceManager.get();
        r4.i("ObricAppServiceImpl", "beforeAttachBaseContext");
        boolean r3 = true;
        r1.downgradeComponent("IExtraParams", true);
        r1.downgradeComponent("IHttpConst", true);
        IObricEssentialTaskService r2 = b.a();
        if (r2 == null) goto L5;
        r2.preInit(r8);
    L5:
        Intrinsics.checkNotNullParameter(r8, "context");
        if (d.b == false) goto L52;
        KevaBuilder r0 = KevaBuilder.getInstance();
        r0.setContext(r8);
        Intrinsics.checkNotNull(r0);
        com.larus.settings.coldboot.b.a.getClass();
        com.larus.settings.coldboot.a r5 = com.larus.settings.coldboot.b.a(r8);
        if (r5.a == false) goto L12;
        r0.setInitRepoOpt(1);
    L12:
        if (r5.b == false) goto L15;
        r0.setGetRepoLockOpt(true);
    L15:
        if (r5.c == false) goto L17;
        r0.setEnableExecutorOpt(true);
    L17:
        ISecPrivacyService.a.getClass();
        ISecPrivacyService r6 = ISecPrivacyService.a.a();
        if (r6 == null) goto L20;
        r6.g(r8);
    L20:
        ISecPrivacyService r9 = ISecPrivacyService.a.a();
        if (r9 == null) goto L23;
        boolean r10 = r9.h();
    L24:
        IApmTrace.Companion r7 = IApmTrace.a;
        if (r10 == false) goto L27;
        String r11 = "1";
    L28:
        r7.a("privacy_agreed", r11);
        String r12 = IExtraParams.a.b();
        if (r12.length() != 0) goto L31;
        boolean r13 = true;
    L32:
        if (r13 == false) goto L34;
        r12 = "obric";
    L34:
        r7.d("flow_app_variant", r12);
        Map<String, String> r14 = ObricConfigServiceDelegate.b.getCommonParams();
        if (r14 == null) goto L40;
        Iterator<Map.Entry<String, String>> r15 = r14.entrySet().iterator();
    L38:
        if (r15.hasNext() == false) goto L40;
        Map.Entry<String, String> r16 = r15.next();
        IApmTrace.a.d(r16.getKey(), r16.getValue());
    L40:
        IApmTrace.Companion r17 = IApmTrace.a;
        r17.a("git_branch", "obric/rls/15.2.0.1");
        r17.a("git_commit", "fc4b8ba9c915");
        Integer r18 = 887485629;
        if (r18.intValue() > 0) goto L44;
        r3 = false;
    L44:
        if (r3 == true) goto L47;
        r18 = null;
    L47:
        if (r18 == null) goto L51;
        r17.a("build_job_id", String.valueOf(r18.intValue()));
        return;
    L51:
        return;
    L31:
        r13 = false;
        goto L32
    L27:
        r11 = MiraMonitor.VALUE_DEFAULT;
        goto L28
    L23:
        r10 = false;
        goto L24
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void c(Context r3) {
        Intrinsics.checkNotNullParameter(r3, "context");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r3, "context");
        c.a.update(r3, false);
        d.b = false;
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final boolean e(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        Result.Companion r1 = Result.Companion;     // Catch: Throwable -> L9
        if (Build.VERSION.SDK_INT < 28) goto L6;
        String r2 = Application.getProcessName();     // Catch: Throwable -> L9
    L7:
        Object r3 = Result.m49constructorimpl(r2);     // Catch: Throwable -> L9
    L11:
        Result.m52exceptionOrNullimpl(r3);
        if (Result.m55isFailureimpl(r3) == false) goto L14;
        r3 = null;
    L14:
        String r4 = (String) r3;
        boolean r5 = false;
        if (Intrinsics.areEqual(r4, r7.getPackageName() + ":memorydata") == false) goto L17;
    L20:
        boolean r6 = true;
    L21:
        if (r6 == false) goto L33;
        c.a.getClass();
        Intrinsics.checkNotNullParameter(r7, "context");
        Object r8 = Result.m49constructorimpl(Boolean.valueOf(new PolarisFileWrapper(new PolarisFileWrapper(r7.getFilesDir(), "obric_early_settings"), "zeus_plugin_process_short_circuit_v1").exists()));     // Catch: Throwable -> L25
    L27:
        Result.m52exceptionOrNullimpl(r8);
        Boolean r0 = Boolean.FALSE;
        if (Result.m55isFailureimpl(r8) == false) goto L30;
        r8 = r0;
    L30:
        Boolean r9 = (Boolean) r8;
        r9.booleanValue();
        if (r9.booleanValue() == false) goto L33;
        r5 = true;
    L25:
        th = move-exception;
        Result.Companion r10 = Result.Companion;
        r8 = Result.m49constructorimpl(ResultKt.createFailure(th));
    L33:
        d.b = r5;
        return d.b;
    L17:
        if (Intrinsics.areEqual(r4, r7.getPackageName() + ":aiagent") == true) goto L20;
        r6 = false;
        goto L21
    L6:
        r2 = k.c(r7);     // Catch: Throwable -> L9
    L9:
        th = move-exception;
        Result.Companion r11 = Result.Companion;
        r3 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L11
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void f(Application r5) {
        Intrinsics.checkNotNullParameter(r5, "application");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r5, "application");
        if (d.b == false) goto L12;
        boolean r0 = AppHost.a.isTestChannel();
        if (r0 == false) goto L8;
        int r1 = 120;
    L9:
        e10 r2 = e10.a;
        int r3 = l0.a;
        int r4 = ((Number) l0.a(Integer.valueOf(r1), new nj(r1))).intValue();
        IApm r6 = (IApm) ServiceManager.get().getService(IApm.class);
        if (r6 == null) goto L12;
        r6.a(r0, r4, r5);
        goto L12
    L8:
        r1 = 40;
    L12:
        boolean r7 = mda.a.b(r5);
        FLogger.a.i("ObricAppServiceImpl", "afterAttachBaseContext: " + r7);
        IObricEssentialTaskService r8 = b.a();
        if (r8 == null) goto L15;
        r8.init(r5);
    L15:
        IObricEssentialTaskService r9 = b.a();
        if (r9 == null) goto L19;
        r9.startExecute();
        return;
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void g(Application r4) {
        Intrinsics.checkNotNullParameter(r4, "application");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        Result.Companion r0 = Result.Companion;     // Catch: Throwable -> L8
        ft9.k.a.getClass();     // Catch: Throwable -> L8
        JSONObject r1 = ft9.k.c(r4);     // Catch: Throwable -> L8
        boolean r2 = false;
        if (r1 == null) goto L6;
        r2 = r1.optBoolean("enable_zeus_plugin_process_short_circuit", false);     // Catch: Throwable -> L8
    L6:
        Object r3 = Result.m49constructorimpl(Boolean.valueOf(r2));     // Catch: Throwable -> L8
    L10:
        Result.m52exceptionOrNullimpl(r3);
        Boolean r5 = Boolean.FALSE;
        if (Result.m55isFailureimpl(r3) == false) goto L13;
        r3 = r5;
    L13:
        boolean r6 = ((Boolean) r3).booleanValue();
        c.a.update(r4, r6);
        return;
    L8:
        th = move-exception;
        Result.Companion r7 = Result.Companion;
        r3 = Result.m49constructorimpl(ResultKt.createFailure(th));
        goto L10
    }

    @Override // com.obric.assistant.spi.app.IObricAppService
    public final void d(Application r4, JSONObject r5) {
        Intrinsics.checkNotNullParameter(r4, "application");
        d.a.getClass();
        Intrinsics.checkNotNullParameter(r4, "context");
        boolean r0 = false;
        if (r5 != null) goto L5;
    L10:
        c.a.update(r4, r0);
        return;
    L5:
        if (r5.has("enable_zeus_plugin_process_short_circuit") == true) goto L8;
        r5 = null;
    L8:
        if (r5 == null) goto L10;
        r0 = r5.optBoolean("enable_zeus_plugin_process_short_circuit", false);
        goto L10
    }
}
