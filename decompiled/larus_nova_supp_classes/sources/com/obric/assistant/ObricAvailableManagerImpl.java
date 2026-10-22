package com.obric.assistant;

import android.app.Application;
import android.app.role.RoleManager;
import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.os.UserHandle;
import android.util.EventsUtils;
import com.bytedance.helios.statichook.config.ApiHookConfig;
import com.bytedance.keva.Keva;
import com.bytedance.mt.protector.impl.UriProtector;
import com.larus.bmhome.chat.model.repo.IConversationRepoService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.aiagent.assistant.utils.DefaultAssistantStatus;
import com.obric.aiagent.assistant.utils.i;
import com.obric.aiagent.plugin_api.PluginService;
import com.obric.assistant.chat.IObricChatService;
import com.obric.assistant.chat.impl.MessageApiImpl;
import com.obric.assistant.reporter.IObricReporter;
import com.obric.assistant.shortcut.IObricShortCutsService;
import com.obric.assistant.spi.window.ChatWindowServiceDelegate;
import com.obric.assistant.state.ObricSharedStateDelegate;
import com.obric.memorydata.plugin_api.MemoryPlugin;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import f06.d;
import ita.k;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.concurrent.Executor;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import org.xmlpull.v1.XmlPullParser;
import uc9.t;
import wc9.e;
import xg9.b;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
@Metadata(d1 = {"\u0000X\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u0000 ;2\u00020\u0001:\u0001;B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0010\u0010(\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u0017H\u0016J\u0010\u0010*\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u0010+\u001a\u00020,2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010-\u001a\u00020)H\u0002J\u000e\u0010.\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010/J \u00100\u001a\u00020)2\u0006\u0010\"\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00101\u001a\u00020\u001dH\u0002J\b\u00102\u001a\u00020)H\u0002J\b\u00103\u001a\u00020\u001dH\u0016J\u000e\u00104\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u0017J\u0018\u00105\u001a\u00020)2\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u00106\u001a\u00020\u0011H\u0016J\b\u00107\u001a\u00020)H\u0016J\u0010\u00108\u001a\u00020\u001d2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\u0010\u00109\u001a\u00020:2\u0006\u0010\u0016\u001a\u00020\u0017H\u0002R\u001c\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001c\u0010\n\u001a\u0004\u0018\u00010\u000bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\f\u0010\r\"\u0004\b\u000e\u0010\u000fR\u001c\u0010\u0010\u001a\u0004\u0018\u00010\u0011X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0012\u0010\u0013\"\u0004\b\u0014\u0010\u0015R\u001c\u0010\u0016\u001a\u0004\u0018\u00010\u0017X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u0019\"\u0004\b\u001a\u0010\u001bR\u001a\u0010\u001c\u001a\u00020\u001dX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001e\u0010\u001f\"\u0004\b \u0010!R\u001a\u0010\"\u001a\u00020\u001dX\u0096\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u001f\"\u0004\b#\u0010!R\u000e\u0010$\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010&\u001a\u00020'X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006<"}, d2 = {"Lcom/obric/assistant/ObricAvailableManagerImpl;", "Lcom/obric/assistant/IObricAvailableManager;", "<init>", "()V", "monitor", "Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor;", "getMonitor", "()Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor;", "setMonitor", "(Lcom/obric/aiagent/assistant/utils/ReflectHiddenRoleMonitor;)V", "innerListener", "Lcom/obric/aiagent/assistant/utils/OnAssistantSwitchListener;", "getInnerListener", "()Lcom/obric/aiagent/assistant/utils/OnAssistantSwitchListener;", "setInnerListener", "(Lcom/obric/aiagent/assistant/utils/OnAssistantSwitchListener;)V", "outerListener", "Lcom/obric/assistant/OnRoleAssistantSwitchListener;", "getOuterListener", "()Lcom/obric/assistant/OnRoleAssistantSwitchListener;", "setOuterListener", "(Lcom/obric/assistant/OnRoleAssistantSwitchListener;)V", "context", "Landroid/content/Context;", "getContext", "()Landroid/content/Context;", "setContext", "(Landroid/content/Context;)V", "inited", XmlPullParser.NO_NAMESPACE, "getInited", "()Z", "setInited", "(Z)V", "isDefaultAssistant", "setDefaultAssistant", "scope", "Lkotlinx/coroutines/CoroutineScope;", "keva", "Lcom/bytedance/keva/Keva;", "init", XmlPullParser.NO_NAMESPACE, "restartMainActivityAndKillProcess", "createMainPageIntent", "Landroid/content/Intent;", "clearContextAndRestart", "clearMainBotContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateDefaultAssistant", "isInit", "resetSetDefaultAssistantBannerSuppress", "getIsDefaultAssistant", "initDefaultAssistantStatus", "startListening", "listener", "stopListening", "isMainProcessSafe", "getProcessNameSafe", XmlPullParser.NO_NAMESPACE, "Companion", "base_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = EventsUtils.FEAT_TYPE_STORAGE_ANTIAGING_EVENT)
public final class ObricAvailableManagerImpl implements IObricAvailableManager {
    public i b;
    public a1 c;
    public l4 d;
    public Context e;
    public boolean f;
    public boolean g;
    public final CoroutineScope h;
    public final Keva i;

    public static final class a {
    }

    static {
    }

    @Override // com.obric.assistant.IObricAvailableManager
    public final boolean b() {
    L7:
        e = move-exception;
        FLogger.a.e("ObricAvailableManagerImpl", "isDefaultAssistant", e);
    L10:
        return this.g;
    L4:
        if (this.f == true) goto L10;
        FLogger.a.w("ObricAvailableManagerImpl", "getIsDefaultAssistant before init, try init", new Throwable());     // Catch: Exception -> L7
        e(AppHost.a.getApplication());     // Catch: Exception -> L7
        goto L10
    }

    public ObricAvailableManagerImpl() {
        this.g = true;
        this.h = CoroutineScopeKt.CoroutineScope(Dispatchers.getMain());
        this.i = b.a();
    }

    @Override // com.obric.assistant.IObricAvailableManager
    public final boolean a() {
        return this.g;
    }

    public final Context getContext() {
        return this.e;
    }

    public static Intent d(Context r2) {
        Context r3 = r2.getApplicationContext();
        if (r3 != null) goto L5;
        r3 = AppHost.a.getApplication();
    L5:
        Intent r0 = r3.getPackageManager().getLaunchIntentForPackage(r3.getPackageName());
        if (r0 != null) goto L8;
        r0 = new Intent("android.intent.action.VIEW").setPackage(r3.getPackageName());
    L8:
        r0.setAction("android.intent.action.VIEW");
        r0.setData(UriProtector.parse("doubao://main_page"));
        r0.addFlags(268468224);
        return r0;
    }

    public final void e(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        if (this.e != null) goto L5;
        this.e = r7;
    L5:
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L8;
        boolean r2 = Intrinsics.areEqual(r7.getPackageName(), Application.getProcessName());
    L10:
        if (r2 == true) goto L18;
        FLogger r3 = FLogger.a;
        StringBuilder r4 = new StringBuilder("initDefaultAssistantStatus, not main process, skip: ");
        if (r0 < 28) goto L14;
        String r8 = Application.getProcessName();
    L15:
        r4.append(r8);
        r3.i("ObricAvailableManagerImpl", r4.toString());
        return;
    L14:
        r8 = k.c(r7);
        goto L15
    L18:
        if (com.obric.aiagent.assistant.utils.a.a(r7) != DefaultAssistantStatus.IsDefaultAssistant) goto L20;
        boolean r1 = true;
    L21:
        this.g = r1;
        FLogger.a.i("ObricAvailableManagerImpl", "initDefaultAssistantStatus, isDefaultAssistant: " + this.g + ", " + com.obric.aiagent.assistant.utils.a.a(r7));
        this.f = true;
        return;
    L20:
        r1 = false;
        goto L21
    L8:
        r2 = k.i(r7);
        goto L10
    }

    @Override // com.obric.assistant.IObricAvailableManager
    public final void init(Context r7) {
        Intrinsics.checkNotNullParameter(r7, "context");
        this.e = r7;
        int r0 = Build.VERSION.SDK_INT;
        if (r0 < 28) goto L5;
        String r2 = Application.getProcessName();
        boolean r3 = Intrinsics.areEqual(r7.getPackageName(), r2);
    L7:
        if (r3 == true) goto L27;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("init, not main process, skip: ");
        if (r0 < 28) goto L11;
        String r8 = Application.getProcessName();
    L12:
        r5.append(r8);
        r4.i("ObricAvailableManagerImpl", r5.toString());
        return;
    L11:
        r8 = k.c(r7);
        goto L12
    L27:
        FLogger.a.i("ObricAvailableManagerImpl", "init, start initDefaultAssistantStatus");     // Catch: Exception -> L24
        e(r7);     // Catch: Exception -> L24
        g(this.g, r7, true);     // Catch: Exception -> L24
        IObricReporter.a.getClass();     // Catch: Exception -> L24
        IObricReporter r1 = IObricReporter.a.a();     // Catch: Exception -> L24
        if (r1 == null) goto L17;
        r1.k();     // Catch: Exception -> L24
    L17:
        f(r7, new b(this, r7));     // Catch: Exception -> L24
        IObricChatService r9 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);     // Catch: Exception -> L24
        if (r9 == null) goto L22;
        r9.g();     // Catch: Exception -> L24
        MessageApiImpl r10 = MessageApiImpl.a;
        r10.g(new c(this));     // Catch: Exception -> L24
    L22:
        ChatWindowServiceDelegate.b.b();     // Catch: Exception -> L24
        return;
    L24:
        e = move-exception;
        FLogger.a.e("ObricAvailableManagerImpl", "registerSendMessageExtCallback", e);
        return;
    L5:
        r3 = k.i(r7);
        goto L7
    }

    public static final Object c(ObricAvailableManagerImpl r6, Continuation r7) {
        r6.getClass();
        if ((r7 instanceof clearMainBotContext.1) == false) goto L7;
        clearMainBotContext.1 r0 = (clearMainBotContext.1) r7;
        int r1 = r0.label;
        if ((r1 & Integer.MIN_VALUE) == 0) goto L7;
        r0.label = r1 - Integer.MIN_VALUE;
    L8:
        Object r8 = r0.result;
        Object r9 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r2 = r0.label;
        boolean r3 = false;
        if (r2 == 0) goto L19;
        if (r2 == 1) goto L18;
        if (r2 != 2) goto L17;
        ResultKt.throwOnFailure(r8);     // Catch: Throwable -> L14
    L33:
        Object r10 = Result.m49constructorimpl((ub8.b) r8);     // Catch: Throwable -> L14
    L36:
        Throwable r11 = Result.m52exceptionOrNullimpl(r10);
        if (r11 == null) goto L40;
        FLogger.a.e("ObricAvailableManagerImpl", "clearContextWhenLaunchInKeyguard clear context failed", r11);
    L40:
        if (Result.m56isSuccessimpl(r10) == false) goto L47;
        ub8.b r12 = (ub8.b) r10;
        FLogger r4 = FLogger.a;
        StringBuilder r5 = new StringBuilder("clearContext: success = ");
        t r13 = r12.a;
        if (r13 == null) goto L44;
        Boolean r14 = Boxing.boxBoolean(r13.a);
    L45:
        r5.append(r14);
        r5.append(", error = ");
        r5.append(r12.c);
        r4.d("ObricAvailableManagerImpl", r5.toString());
        goto L47
    L44:
        r14 = null;
    L47:
        if (Result.m55isFailureimpl(r10) == false) goto L49;
        r10 = null;
    L49:
        ub8.b r15 = (ub8.b) r10;
        if (r15 == null) goto L60;
        t r16 = r15.a;
        if (r16 == null) goto L60;
        r3 = r16.a;
    L60:
        return Boxing.boxBoolean(r3);
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r8);
    L24:
        e r17 = (e) r8;
        if (r17 == null) goto L56;
        String r18 = r17.a;
        if (r18 == null) goto L56;
        FLogger.a.d("ObricAvailableManagerImpl", "clearContext: conversationId = ".concat(r18));
        Result.Companion r19 = Result.Companion;     // Catch: Throwable -> L14
        IConversationRepoService r20 = zh8.a.b;     // Catch: Throwable -> L14
        r0.label = 2;     // Catch: Throwable -> L14
        r8 = r20.n(r18, 3, "DefaultAssistantChange", r0);     // Catch: Throwable -> L14
        if (r8 != r9) goto L33;
        return r9;
    L56:
        return Boxing.boxBoolean(false);
    L19:
        ResultKt.throwOnFailure(r8);
        IObricChatService r21 = (IObricChatService) ServiceManager.get().getService(IObricChatService.class);
        if (r21 == null) goto L56;
        r0.label = 1;
        r8 = r21.d(r0);
        if (r8 != r9) goto L24;
        return r9;
    L14:
        th = move-exception;
        Result.Companion r22 = Result.Companion;
        r10 = Result.m49constructorimpl(ResultKt.createFailure(th));
    L7:
        r0 = new clearMainBotContext.1(r6, r7);
        goto L8
    }

    public final void f(Context r26, b r28) {
        Intrinsics.checkNotNullParameter(r26, "context");
        Intrinsics.checkNotNullParameter(r28, "listener");
        if (this.b != null) goto L17;
        i.a r3 = i.j;
        Intrinsics.checkNotNullParameter(r26, "context");
        i r4 = i.k;
        if (r4 != null) goto L15;
        monitor-enter(r3);
        r4 = i.k;     // Catch: Throwable -> L12
        if (r4 != null) goto L10;
        r4 = new i(r26.getApplicationContext());     // Catch: Throwable -> L12
        i.k = r4;     // Catch: Throwable -> L12
    L10:
        monitor-exit(r3);
    L12:
        th = move-exception;
        throw th;
    L15:
        this.b = r4;
    L17:
        if (this.c != null) goto L19;
        this.c = new a1(this);
    L19:
        this.d = r28;
        a1 r0 = this.c;
        if (r0 == null) goto L82;
        i r2 = this.b;
        if (r2 == null) goto L83;
        Intrinsics.checkNotNullParameter(r0, "listener");
        RoleManager r5 = (RoleManager) r2.b.getValue();
        if (r5 == null) goto L91;
        Class r6 = (Class) r2.c.getValue();
        if (r6 != null) goto L30;
        return;
    L30:
        if (Build.VERSION.SDK_INT < 33) goto L84;
        Context r7 = r2.a;
        ArrayList r8 = new ArrayList();
        String r13 = "android.permission.OBSERVE_ROLE_HOLDERS";
        Object[] r14 = {"android.permission.OBSERVE_ROLE_HOLDERS"};
        f06.b r11 = new f06.b("auto_cert_com_obric_aiagent_assistant_utils_ReflectHiddenRoleMonitor_android_content_Context_checkSelfPermission");
        g06.a r9 = (g06.a) ApiHookConfig.b.get(102608);
        if (r9 == null) goto L34;
        f06.a[] r10 = r9.i;
    L35:
        f06.a[] r12 = r10;
        int r15 = r12.length;
        int r16 = 0;
    L37:
        if (r16 >= r15) goto L44;
        f06.a r17 = r12[r16];
        int r20 = r16;
        int r19 = r15;
        f06.a[] r21 = r12;
        f06.b r22 = r11;
        char r18 = 0;
        String r23 = r13;
        Object[] r24 = r14;
        d r25 = r17.preInvoke(102608, "android/content/Context", "checkSelfPermission", r7, r14, "int", r22);     // Catch: Exception -> L73
        if (r25.a == true) goto L46;
        r8.add(r17);     // Catch: Exception -> L73
    L46:
        if (r25.a == false) goto L48;
        int r29 = ((Integer) r25.b).intValue();
    L49:
        if (r29 != 0) goto L51;
        boolean r110 = true;
    L52:
        if (r110 == true) goto L54;
        return;
    L54:
        if (r2.h == true) goto L86;
        r2.g = r0;
        r2.b(r6);     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        Object r1 = r2.d;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        if (r1 == null) goto L60;
        Class[] r30 = new Class[3];     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r30[r18] = Executor.class;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r30[1] = r6;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r30[2] = UserHandle.class;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        Method r31 = r5.getClass().getMethod("addOnRoleHoldersChangedListenerAsUser", (Class[]) Arrays.copyOf(r30, 3));     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r31.setAccessible(true);     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        Object[] r32 = new Object[3];     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r32[r18] = (Executor) r2.f.getValue();     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r32[1] = r1;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r32[2] = (UserHandle) r2.e.getValue();     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r31.invoke(r5, r32);     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r2.h = true;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        com.obric.aiagent.assistant.utils.b r33 = com.obric.aiagent.assistant.utils.b.a;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        Context r34 = r2.a;     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r33.getClass();     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
        r2.i = com.obric.aiagent.assistant.utils.b.d(r34);     // Catch: Exception -> L61 InvocationTargetException -> L63 IllegalAccessException -> L68 NoSuchMethodException -> L70
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
        Throwable r35 = e.getCause();
        if (r35 == null) goto L67;
        r35.getMessage();
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
        r110 = false;
        goto L52
    L48:
        r29 = r7.checkSelfPermission(r23);
    L43:
        r16 = r20 + 1;
        r15 = r19;
        r12 = r21;
        r11 = r22;
        r13 = r23;
        r14 = r24;
        goto L37
    L44:
        r23 = r13;
        r18 = 0;
        r25 = new d(false, null);
        goto L46
    L34:
        r10 = ApiHookConfig.d;
        goto L35
    L84:
        return;
    L91:
        return;
    L83:
        return;
    }

    public final void g(boolean r6, Context r7, boolean r8) {
        this.g = r6;
        if (r8 == false) goto L8;
        t1 r9 = t1.a;
        if (r6 == r9.e0()) goto L7;
        boolean r1 = ObricSharedStateDelegate.c.d("doubao_start_as_default_assistant", r6 ? 1 : 0);
        FLogger.a.i("ObricAvailableManagerImpl", "updateDefaultAssistant, putSharedStateInt, curState：" + (r6 ? 1 : 0) + ", ret: " + r1);
    L7:
        r9.m1(r6 ? 1 : 0);
    L10:
        if (r6 == false) goto L16;
        PluginService.enableComponents(r7);
        if (t9a.b.a().e() == false) goto L14;
        MemoryPlugin.disable(r7);
    L15:
        FLogger.a.i("ObricAvailableManagerImpl", "enable assistant plugin");
    L17:
        IObricShortCutsService r10 = (IObricShortCutsService) ServiceManager.get().getService(IObricShortCutsService.class);
        if (r10 == null) goto L21;
        r10.a();
        return;
    L21:
        return;
    L14:
        MemoryPlugin.enable(r7);
        goto L15
    L16:
        PluginService.disableComponents(r7);
        MemoryPlugin.disable(r7);
        FLogger.a.i("ObricAvailableManagerImpl", "disable assistant plugin");
        goto L17
    L8:
        if (r6 == true) goto L10;
        t1.a.m1(r6 ? 1 : 0);
        FLogger.a.i("ObricAvailableManagerImpl", "updateDefaultAssistant not init, setStartAsDefaultAssistant, curState：" + (r6 ? 1 : 0));
        goto L10
    }
}
