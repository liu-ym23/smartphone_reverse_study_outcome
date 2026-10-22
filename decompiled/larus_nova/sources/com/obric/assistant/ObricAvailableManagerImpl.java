package com.obric.assistant;

import android.app.Application;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.UserHandle;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.bytedance.ug.sdk.luckyhost.api.api.ILuckyCatService;
import com.huawei.hms.support.api.entity.common.CommonConstant;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.utils.DefaultAssistantStatus;
import com.obric.aiagent.plugin_api.PluginService;
import com.obric.aiagent.sharedstate.StateKey;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.shortcut.IObricShortCutsService;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.obric.assistant.state.ObricSharedStateDelegate;
import com.obric.memorydata.plugin_api.MemoryPlugin;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020)H\u0002J\u000e\u0010.\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010/J \u00100\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020\u001dH\u0016J\u000e\u00104\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u00105\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u0011H\u0016J\b\u00107\u001a\u00020)H\u0016J\u0010\u00108\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/assistant/ObricAvailableManagerImpl;", "Lcom/obric/assistant/IObricAvailableManager;", "<init>", "()V", "monitor", "Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor;", "getMonitor", "()Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor;", "setMonitor", "(Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor;)V", "innerListener", "Lcom/obric/aiagent/assistant/utils/OnAssistantSwitchListener;", "getInnerListener", "()Lcom/obric/aiagent/assistant/utils/OnAssistantSwitchListener;", "setInnerListener", "(Lcom/obric/aiagent/assistant/utils/OnAssistantSwitchListener;)V", "outerListener", "Lcom/obric/assistant/OnRoleAssistantSwitchListener;", "getOuterListener", "()Lcom/obric/assistant/OnRoleAssistantSwitchListener;", "setOuterListener", "(Lcom/obric/assistant/OnRoleAssistantSwitchListener;)V", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "inited", "", "getInited", "()Z", "setInited", "(Z)V", "isDefaultAssistant", "setDefaultAssistant", "scope", "Lkotlinx/coroutines/CoroutineScope;", "keva", "Lcom/bytedance/keva/Keva;", "init", "", "restartMainActivityAndKillProcess", "createMainPageIntent", "Landroid/content/Intent;", "clearContextAndRestart", "clearMainBotContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDefaultAssistant", "isInit", "resetSetDefaultAssistantBannerSuppress", "getIsDefaultAssistant", "initDefaultAssistantStatus", "startListening", "listener", ILuckyCatService.ACTION_STOP_LISTENING, "isMainProcessSafe", "getProcessNameSafe", "", "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class ObricAvailableManagerImpl implements IObricAvailableManager {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public com.obric.aiagent.assistant.utils.i f385141b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public a1 f385142c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public l4 f385143d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Context f385144e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public boolean f385145f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f385146g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final CoroutineScope f385147h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Keva f385148i;

    public static final class a {
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class b implements l4 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricAvailableManagerImpl f385149a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Context f385150b;

        public b(ObricAvailableManagerImpl r100, Context r101) {
            this.f385149a = r100;
            this.f385150b = r101;
        }

        @Override // com.obric.assistant.l4
        public final void a(String r110, String r111) {
            FLogger r100 = FLogger.f375446a;
            r100.i("ObricAvailableManagerImpl", "onRoleAssistantSwitched, oldPkg: " + r110 + ", newPkg: " + r111);
            if (Intrinsics.areEqual(r111, "com.larus.nova") == true) goto L10;
            if (Intrinsics.areEqual(r110, "com.larus.nova") == false) goto L10;
            ObricAvailableManagerImpl r101 = this.f385149a;
            if (r101.f385146g == false) goto L10;
            r101.g(false, this.f385150b, false);
            ObricAvailableManagerImpl r102 = this.f385149a;
            BuildersKt.launch$default(r102.f385147h, null, null, new ObricAvailableManagerImpl$clearContextAndRestart$1(r102, null), 3, null);
        L10:
            if (Intrinsics.areEqual(r110, "com.larus.nova") == false) goto L12;
            return;
        L12:
            if (Intrinsics.areEqual(r111, "com.larus.nova") == false) goto L35;
            ObricAvailableManagerImpl r112 = this.f385149a;
            if (r112.f385146g == true) goto L36;
            r112.g(true, this.f385150b, false);
            boolean r113 = com.obric.assistant.utils.j.f393879a;
            com.obric.assistant.utils.j.f393879a = false;
            r100.i("ObricKtUtils", "consumeActiveAddRoleHolderForNova, matched=" + r113);
            com.obric.assistant.common.utils.m.f387884a.getClass();
            if (com.obric.assistant.common.utils.m.a() == false) goto L30;
            if (r113 == false) goto L30;
            Keva r114 = this.f385149a.f385148i;
            r114.erase("set_default_assistant_banner_closed");
            r114.erase("set_default_assistant_banner_suppress_until_time");
            r100.i("ObricAvailableManagerImpl", "onRoleAssistantSwitched from active addRoleHolder, restart main page");
            ObricAvailableManagerImpl r115 = this.f385149a;
            Context r116 = this.f385150b;
            r115.getClass();
            Result.Companion r117 = Result.Companion;     // Catch: Throwable -> L25
            AppHost.Companion r118 = AppHost.f326268a;     // Catch: Throwable -> L25
            Context r103 = r118.a().getCurrentActivity();     // Catch: Throwable -> L25
            if (r103 != null) goto L23;
            r103 = r116;
        L23:
            r103.startActivity(ObricAvailableManagerImpl.d(r116));     // Catch: Throwable -> L25
            r100.i("ObricAvailableManagerImpl", "restartMainActivityAndKillProcess, start main activity success, uri=doubao://main_page");     // Catch: Throwable -> L25
            int r119 = m4.f390286a;     // Catch: Throwable -> L25
            m4.a(r118.getApplication());     // Catch: Throwable -> L25
            Object r120 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L25
        L27:
            Throwable r121 = Result.m9452exceptionOrNullimpl(r120);
            if (r121 == null) goto L37;
            FLogger.f375446a.e("ObricAvailableManagerImpl", "restartMainActivityAndKillProcess failed, uri=doubao://main_page", r121);
            return;
        L37:
            return;
        L25:
            th = move-exception;
            Result.Companion r122 = Result.Companion;
            r120 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        L30:
            ObricAvailableManagerImpl r123 = this.f385149a;
            BuildersKt.launch$default(r123.f385147h, null, null, new ObricAvailableManagerImpl$clearContextAndRestart$1(r123, null), 3, null);
            return;
        L36:
            return;
        }
    }

    /* JADX INFO: loaded from: classes4.dex */
    public static final class c implements bda.b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ObricAvailableManagerImpl f385151a;

        @Override // bda.b
        public final String getScene() {
            return "ObricAvailableManagerImpl";
        }

        public c(ObricAvailableManagerImpl r100) {
            this.f385151a = r100;
        }

        @Override // bda.b
        public final Map<String, String> getExt(Map<String, String> r100, bda.b.a r101) {
            Intrinsics.checkNotNullParameter(r100, "originExt");
            LinkedHashMap r102 = new LinkedHashMap();
            if (this.f385151a.f385146g == true) goto L5;
            r102.put("o_not_default_assistant", "1");
        L5:
            FLogger.f375446a.i("ObricAvailableManagerImpl", "getExt, extras: " + r102);
            return r102;
        }
    }

    static {
    }

    @Override // com.obric.assistant.IObricAvailableManager
    public final boolean b() {
    L7:
        e = move-exception;
        FLogger.f375446a.e("ObricAvailableManagerImpl", "isDefaultAssistant", e);
    L10:
        return this.f385146g;
    L4:
        if (this.f385145f == true) goto L10;
        FLogger.f375446a.w("ObricAvailableManagerImpl", "getIsDefaultAssistant before init, try init", new Throwable());     // Catch: Exception -> L7
        e(AppHost.f326268a.getApplication());     // Catch: Exception -> L7
        goto L10
    }

    public ObricAvailableManagerImpl() {
        this.f385146g = true;
        this.f385147h = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.f385148i = xg9.b.a();
    }

    @Override // com.obric.assistant.IObricAvailableManager
    public final boolean a() {
        return this.f385146g;
    }

    public final Context getContext() {
        return this.f385144e;
    }

    public static Intent d(Context r100) {
        Context r101 = r100.getApplicationContext();
        if (r101 != null) goto L5;
        r101 = AppHost.f326268a.getApplication();
    L5:
        Intent r102 = r101.getPackageManager().getLaunchIntentForPackage(r101.getPackageName());
        if (r102 != null) goto L8;
        r102 = new Intent(CommonConstant.ACTION.HWID_SCHEME_URL).setPackage(r101.getPackageName());
    L8:
        r102.setAction(CommonConstant.ACTION.HWID_SCHEME_URL);
        r102.setData(UriProtector.parse("doubao://main_page"));
        r102.addFlags(268468224);
        return r102;
    }

    public final void e(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        if (this.f385144e != null) goto L5;
        this.f385144e = r100;
    L5:
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 28) goto L8;
        boolean r102 = Intrinsics.areEqual(r100.getPackageName(), Application.getProcessName());
    L10:
        if (r102 == true) goto L18;
        FLogger r103 = FLogger.f375446a;
        StringBuilder r104 = new StringBuilder("initDefaultAssistantStatus, not main process, skip: ");
        if (r101 < 28) goto L14;
        String r105 = Application.getProcessName();
    L15:
        r104.append(r105);
        r103.i("ObricAvailableManagerImpl", r104.toString());
        return;
    L14:
        r105 = ita.k.c(r100);
        goto L15
    L18:
        if (com.obric.aiagent.assistant.utils.a.a(r100) != DefaultAssistantStatus.IsDefaultAssistant) goto L20;
        boolean r106 = true;
    L21:
        this.f385146g = r106;
        FLogger.f375446a.i("ObricAvailableManagerImpl", "initDefaultAssistantStatus, isDefaultAssistant: " + this.f385146g + ", " + com.obric.aiagent.assistant.utils.a.a(r100));
        this.f385145f = true;
        return;
    L20:
        r106 = false;
        goto L21
    L8:
        r102 = ita.k.i(r100);
        goto L10
    }

    @Override // com.obric.assistant.IObricAvailableManager
    public final void init(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this.f385144e = r100;
        int r101 = Build.VERSION.SDK_INT;
        if (r101 < 28) goto L5;
        String r102 = Application.getProcessName();
        boolean r103 = Intrinsics.areEqual(r100.getPackageName(), r102);
    L7:
        if (r103 == true) goto L27;
        FLogger r104 = FLogger.f375446a;
        StringBuilder r105 = new StringBuilder("init, not main process, skip: ");
        if (r101 < 28) goto L11;
        String r106 = Application.getProcessName();
    L12:
        r105.append(r106);
        r104.i("ObricAvailableManagerImpl", r105.toString());
        return;
    L11:
        r106 = ita.k.c(r100);
        goto L12
    L27:
        FLogger.f375446a.i("ObricAvailableManagerImpl", "init, start initDefaultAssistantStatus");     // Catch: Exception -> L24
        e(r100);     // Catch: Exception -> L24
        g(this.f385146g, r100, true);     // Catch: Exception -> L24
        IObricReporter.f391335a.getClass();     // Catch: Exception -> L24
        IObricReporter r107 = IObricReporter.a.a();     // Catch: Exception -> L24
        if (r107 == null) goto L17;
        r107.k();     // Catch: Exception -> L24
    L17:
        f(r100, new b(this, r100));     // Catch: Exception -> L24
        IObricChatService r108 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);     // Catch: Exception -> L24
        if (r108 == null) goto L22;
        r108.g();     // Catch: Exception -> L24
        MessageApiImpl r109 = MessageApiImpl.f386895a;
        r109.g(new c(this));     // Catch: Exception -> L24
    L22:
        ChatWindowServiceDelegate.f392926b.b();     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        FLogger.f375446a.e("ObricAvailableManagerImpl", "registerSendMessageExtCallback", e);
        return;
    L5:
        r103 = ita.k.i(r100);
        goto L7
    }

    public static final Object c(ObricAvailableManagerImpl r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof ObricAvailableManagerImpl$clearMainBotContext$1) == false) goto L7;
        ObricAvailableManagerImpl$clearMainBotContext$1 r102 = (ObricAvailableManagerImpl$clearMainBotContext$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        boolean r107 = false;
        if (r106 == 0) goto L19;
        if (r106 == 1) goto L18;
        if (r106 != 2) goto L17;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L14
    L33:
        Object r108 = Result.m9449constructorimpl((ub8.b) r104);     // Catch: Throwable -> L14
    L36:
        Throwable r109 = Result.m9452exceptionOrNullimpl(r108);
        if (r109 == null) goto L40;
        FLogger.f375446a.e("ObricAvailableManagerImpl", "clearContextWhenLaunchInKeyguard clear context failed", r109);
    L40:
        if (Result.m9456isSuccessimpl(r108) == false) goto L47;
        ub8.b r110 = (ub8.b) r108;
        FLogger r111 = FLogger.f375446a;
        StringBuilder r112 = new StringBuilder("clearContext: success = ");
        uc9.t r113 = r110.f549370a;
        if (r113 == null) goto L44;
        Boolean r114 = Boxing.boxBoolean(r113.f549696a);
    L45:
        r112.append(r114);
        r112.append(", error = ");
        r112.append(r110.f549372c);
        r111.d("ObricAvailableManagerImpl", r112.toString());
        goto L47
    L44:
        r114 = null;
    L47:
        if (Result.m9455isFailureimpl(r108) == false) goto L49;
        r108 = null;
    L49:
        ub8.b r115 = (ub8.b) r108;
        if (r115 == null) goto L60;
        uc9.t r116 = r115.f549370a;
        if (r116 == null) goto L60;
        r107 = r116.f549696a;
    L60:
        return Boxing.boxBoolean(r107);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r104);
    L24:
        wc9.e r117 = (wc9.e) r104;
        if (r117 == null) goto L56;
        String r118 = r117.f559198a;
        if (r118 == null) goto L56;
        FLogger.f375446a.d("ObricAvailableManagerImpl", "clearContext: conversationId = ".concat(r118));
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L14
        IConversationRepoService r120 = zh8.a.f572197b;     // Catch: Throwable -> L14
        r102.label = 2;     // Catch: Throwable -> L14
        r104 = r120.n(r118, 3, "DefaultAssistantChange", r102);     // Catch: Throwable -> L14
        if (r104 != r105) goto L33;
        return r105;
    L56:
        return Boxing.boxBoolean(false);
    L19:
        ResultKt.throwOnFailure(r104);
        IObricChatService r121 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r121 == null) goto L56;
        r102.label = 1;
        r104 = r121.d(r102);
        if (r104 != r105) goto L24;
        return r105;
    L14:
        th = move-exception;
        Result.Companion r122 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new ObricAvailableManagerImpl$clearMainBotContext$1(r100, r101);
        goto L8
    }

    public final void f(Context r210, b r211) {
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r211, "listener");
        if (this.f385141b != null) goto L17;
        com.obric.aiagent.assistant.utils.i.a r100 = com.obric.aiagent.assistant.utils.i.f384627j;
        Intrinsics.checkNotNullParameter(r210, PerfLog.PARAM_KEY_CONTEXT_ID);
        com.obric.aiagent.assistant.utils.i r101 = com.obric.aiagent.assistant.utils.i.f384628k;
        if (r101 != null) goto L15;
        monitor-enter(r100);
        r101 = com.obric.aiagent.assistant.utils.i.f384628k;     // Catch: Throwable -> L12
        if (r101 != null) goto L10;
        r101 = new com.obric.aiagent.assistant.utils.i(r210.getApplicationContext());     // Catch: Throwable -> L12
        com.obric.aiagent.assistant.utils.i.f384628k = r101;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r100);
    L12:
        th = move-exception;
        throw th;
    L15:
        this.f385141b = r101;
    L17:
        if (this.f385142c != null) goto L19;
        this.f385142c = new a1(this);
    L19:
        this.f385143d = r211;
        a1 r102 = this.f385142c;
        if (r102 == null) goto L82;
        com.obric.aiagent.assistant.utils.i r103 = this.f385141b;
        if (r103 == null) goto L83;
        Intrinsics.checkNotNullParameter(r102, "listener");
        RoleManager r104 = (RoleManager) r103.f384630b.getValue();
        if (r104 == null) goto L91;
        Class<?> r105 = (Class) r103.f384631c.getValue();
        if (r105 != null) goto L30;
        return;
    L30:
        if (Build.VERSION.SDK_INT < 33) goto L84;
        Context r106 = r103.f384629a;
        ArrayList r107 = new ArrayList();
        String r110 = "android.permission.OBSERVE_ROLE_HOLDERS";
        Object[] r111 = {"android.permission.OBSERVE_ROLE_HOLDERS"};
        f06.b r112 = new f06.b("auto_cert_com_obric_aiagent_assistant_utils_ReflectHiddenRoleMonitor_android_content_Context_checkSelfPermission");
        g06.a r108 = ApiHookConfig.f245611b.get(102608);
        if (r108 == null) goto L34;
        f06.a[] r109 = r108.f479473i;
    L35:
        f06.a[] r113 = r109;
        int r114 = r113.length;
        int r115 = 0;
    L37:
        if (r115 >= r114) goto L44;
        f06.a r116 = r113[r115];
        int r212 = r115;
        int r117 = r114;
        f06.a[] r213 = r113;
        f06.b r214 = r112;
        char r118 = 0;
        String r215 = r110;
        Object[] r216 = r111;
        f06.d r119 = r116.preInvoke(102608, "android/content/Context", "checkSelfPermission", r106, r111, "int", r214);     // Catch: Exception -> L73
        if (r119.f474982a == true) goto L46;
        r107.add(r116);     // Catch: Exception -> L73
    L46:
        if (r119.f474982a == false) goto L48;
        int r120 = ((Integer) r119.f474983b).intValue();
    L49:
        if (r120 != 0) goto L51;
        boolean r121 = true;
    L52:
        if (r121 == true) goto L54;
        return;
    L54:
        if (r103.f384636h == true) goto L86;
        r103.f384635g = r102;
        r103.b(r105);     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        Object r122 = r103.f384632d;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        if (r122 == null) goto L60;
        Class[] r123 = new Class[3];     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r123[r118] = Executor.class;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r123[1] = r105;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r123[2] = UserHandle.class;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        Method r124 = r104.getClass().getMethod("addOnRoleHoldersChangedListenerAsUser", (Class[]) Arrays.copyOf(r123, 3));     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r124.setAccessible(true);     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        Object[] r125 = new Object[3];     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r125[r118] = (Executor) r103.f384634f.getValue();     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r125[1] = r122;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r125[2] = (UserHandle) r103.f384633e.getValue();     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r124.invoke(r104, r125);     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r103.f384636h = true;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        com.obric.aiagent.assistant.utils.b r126 = com.obric.aiagent.assistant.utils.b.f384613a;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        Context r127 = r103.f384629a;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r126.getClass();     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r103.f384637i = com.obric.aiagent.assistant.utils.b.d(r127);     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        return;
    L60:
        throw new IllegalStateException("Proxy Instance is null");     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
    L68:
        e = move-exception;
        e.printStackTrace();
        return;
    L70:
        e = move-exception;
        e.printStackTrace();
        return;
    L63:
        e = move-exception;
        Throwable r128 = e.getCause();
        if (r128 == null) goto L67;
        r128.getMessage();
    L67:
        e.printStackTrace();
        return;
    L61:
        e = move-exception;
        e.printStackTrace();
        return;
    L86:
        return;
    L51:
        r121 = false;
        goto L52
    L48:
        r120 = r106.checkSelfPermission(r215);
    L43:
        r115 = r212 + 1;
        r114 = r117;
        r113 = r213;
        r112 = r214;
        r110 = r215;
        r111 = r216;
        goto L37
    L44:
        r215 = r110;
        r118 = 0;
        r119 = new f06.d(false, null);
        goto L46
    L34:
        r109 = ApiHookConfig.f245613d;
        goto L35
    L84:
        return;
    L91:
        return;
    L83:
        return;
    }

    public final void g(boolean r100, Context r101, boolean r102) {
        this.f385146g = r100;
        if (r102 == false) goto L8;
        t1 r103 = t1.f393353a;
        if (r100 == r103.e0()) goto L7;
        boolean r104 = ObricSharedStateDelegate.f392933c.d(StateKey.KEY_DOUBAO_START_AS_DEFAULT_ASSISTANT, r100 ? 1 : 0);
        FLogger.f375446a.i("ObricAvailableManagerImpl", "updateDefaultAssistant, putSharedStateInt, curState：" + (r100 ? 1 : 0) + ", ret: " + r104);
    L7:
        r103.m1(r100 ? 1 : 0);
    L10:
        if (r100 == false) goto L16;
        PluginService.enableComponents(r101);
        if (t9a.b.a().e() == false) goto L14;
        MemoryPlugin.disable(r101);
    L15:
        FLogger.f375446a.i("ObricAvailableManagerImpl", "enable assistant plugin");
    L17:
        IObricShortCutsService r105 = (IObricShortCutsService) ServiceManager.get().getService(IObricShortCutsService.class);
        if (r105 == null) goto L21;
        r105.a();
        return;
    L21:
        return;
    L14:
        MemoryPlugin.enable(r101);
        goto L15
    L16:
        PluginService.disableComponents(r101);
        MemoryPlugin.disable(r101);
        FLogger.f375446a.i("ObricAvailableManagerImpl", "disable assistant plugin");
        goto L17
    L8:
        if (r100 == true) goto L10;
        t1.f393353a.m1(r100 ? 1 : 0);
        FLogger.f375446a.i("ObricAvailableManagerImpl", "updateDefaultAssistant not init, setStartAsDefaultAssistant, curState：" + (r100 ? 1 : 0));
        goto L10
    }
}
