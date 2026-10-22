package com.obric.assistant.interaction.impl;

import android.media.AudioManager;
import com.bytedance.ai.api.AppletService;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.interaction.api.IAssistantInteractionService;
import com.obric.assistant.interaction.api.IAssistantInteractionServiceKt;
import com.obric.assistant.interaction.api.lifecycle.ILifecycleService;
import com.obric.assistant.interaction.api.service.IAuthenticationOnLockScreenService;
import com.obric.assistant.interaction.api.service.IInteractionStateApi;
import com.obric.assistant.interaction.api.service.IInteractionStateService;
import com.obric.assistant.interaction.base.feedback.VibratorSmtFeedbackEffect;
import com.obric.assistant.interaction.base.util.SoundEffectHelper;
import com.obric.assistant.interaction.base.util.SystemHiddenApiHelper;
import com.obric.assistant.interaction.impl.hook.ObricInstrumentation;
import com.obric.assistant.interaction.impl.service.AuthenticationOnLockScreenService;
import com.obric.assistant.interaction.impl.service.EventHubImpl;
import com.obric.assistant.interaction.impl.service.InteractionApiImpl;
import com.obric.assistant.interaction.impl.service.InteractionStateServiceImpl;
import com.obric.assistant.state.api.multitask.ForegroundInteractionPhase;
import com.obric.assistant.state.api.multitask.ObricInteractionProjectionDelegate;
import com.obric.assistant.state.api.multitask.state.ObricInteractionType;
import com.obric.assistant.utils.ObricShowArgServiceDelegate;
import com.obric.assistant.wakeup.bluetooth_headset.api.IBluetoothHeadSetAPI;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000j\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0010%\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010$\u001a\u00020%H\u0016J\b\u0010&\u001a\u00020%H\u0016J\u0010\u0010)\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010+\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0010\u0010,\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016H\u0002J\u0018\u0010-\u001a\u00020%2\u0006\u0010*\u001a\u00020\u00162\u0006\u0010.\u001a\u00020\u001bH\u0002J\u0010\u0010/\u001a\u00020%2\u0006\u0010*\u001a\u00020\u0016H\u0002J\b\u00100\u001a\u00020%H\u0002J\u0010\u00101\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0016H\u0002J\u0010\u00103\u001a\u00020\u001b2\u0006\u00102\u001a\u00020\u0016H\u0002R\u0014\u0010\u0004\u001a\u00020\u00058VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0006\u0010\u0007R\u0014\u0010\b\u001a\u00020\t8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\n\u0010\u000bR\u0014\u0010\f\u001a\u00020\r8VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u000e\u0010\u000fR\u001a\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00118VX\u0096\u0004¢\u0006\u0006\u001a\u0004\b\u0013\u0010\u0014R\u0010\u0010\u0015\u001a\u00020\u0016X\u0082D¢\u0006\u0004\n\u0002\b\u0017R\u000e\u0010\u0018\u001a\u00020\u0016X\u0082\u000e¢\u0006\u0002\n\u0000R\u001a\u0010\u0019\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001e0\u001dX\u0082\u0004¢\u0006\u0002\n\u0000R\u001a\u0010\u001f\u001a\u000e\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020 0\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010!\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010#\u001a\u0004\u0018\u00010\"X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010'\u001a\u00020(X\u0082\u0004¢\u0006\u0002\n\u0000¨\u00065"}, d2 = {"Lcom/obric/assistant/interaction/impl/AssistantInteractionService;", "Lcom/obric/assistant/interaction/api/IAssistantInteractionService;", "<init>", "()V", "_interactionStateService", "Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "get_interactionStateService", "()Lcom/obric/assistant/interaction/api/service/IInteractionStateService;", "_interactionStateApi", "Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "get_interactionStateApi", "()Lcom/obric/assistant/interaction/api/service/IInteractionStateApi;", "_authenOnLockScreenService", "Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "get_authenOnLockScreenService", "()Lcom/obric/assistant/interaction/api/service/IAuthenticationOnLockScreenService;", "lifecycleServices", "", "Lcom/obric/assistant/interaction/api/lifecycle/ILifecycleService;", "getLifecycleServices", "()Ljava/util/List;", "TAG", "", "TAG$1", "curBid", "isGenerateStart", "", "", "lastPhase", "Ljava/util/concurrent/ConcurrentHashMap;", "Lcom/obric/assistant/state/api/multitask/ForegroundInteractionPhase;", "curMode", "Lcom/obric/assistant/state/api/multitask/state/ObricInteractionType;", "appActionCheckJob", "Lkotlinx/coroutines/Job;", "stopVUIJob", "systemStateInit", "", "soundEffectInit", "projectionObserver", "Lcom/obric/assistant/state/api/multitask/InteractionProjectionObserver;", "onDeactivate", "botId", "onThinking", "onGenerating", "onGenerated", "failed", "onActivate", "startAppletListener", "isInterceptedByUiU", "apiName", "isInWhiteListAppAction", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AssistantInteractionService implements IAssistantInteractionService {
    public static final Companion Companion = null;
    private static final long SECOND = 1000;
    private static final String TAG = "AssistantInteractionService";
    private static final long THREE_SECONDS = 3000;
    private static final long TWO_SECONDS = 2000;
    private static final String UIU_GET_UIU_CONTEXT_TOOL = "system_get_uiu_context_tool";
    private static final String UIU_PERFORM_VIEW_OPERATIONS_TOOL = "system_do_view_operations_tool";
    private static final String UIU_PLUGIN = "system_ui_understanding_plugin";
    private static final String WHITE_LIST_AUDIO_PLAYER_ACTION = "plugin_podcast_control.plugin_tool__podcast_control";
    private final String TAG$1;
    private Job appActionCheckJob;
    private String curBid;
    private ConcurrentHashMap<String, ObricInteractionType> curMode;
    private final Map<String, Boolean> isGenerateStart;
    private final ConcurrentHashMap<String, ForegroundInteractionPhase> lastPhase;
    private final zga.c projectionObserver;
    private Job stopVUIJob;

    /* JADX INFO: loaded from: classes4.dex */
    @Metadata(d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\t\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0007X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u0005X\u0082T¢\u0006\u0002\n\u0000¨\u0006\u000e"}, d2 = {"Lcom/obric/assistant/interaction/impl/AssistantInteractionService$Companion;", "", "<init>", "()V", "TAG", "", "SECOND", "", "TWO_SECONDS", "THREE_SECONDS", "UIU_PLUGIN", "UIU_PERFORM_VIEW_OPERATIONS_TOOL", "UIU_GET_UIU_CONTEXT_TOOL", "WHITE_LIST_AUDIO_PLAYER_ACTION", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final class Companion {
        private Companion() {
        }

        public /* synthetic */ Companion(DefaultConstructorMarker r100) {
            this();
        }
    }

    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    public /* synthetic */ class WhenMappings {
        public static final /* synthetic */ int[] $EnumSwitchMapping$0 = null;
        public static final /* synthetic */ int[] $EnumSwitchMapping$1 = null;

        static {
            int[] r100 = new int[ObricInteractionType.values().length];
            r100[ObricInteractionType.TextMode.ordinal()] = 1;     // Catch: NoSuchFieldError -> L18
        L32:
            r100[ObricInteractionType.ManualHalfDuplex.ordinal()] = 2;     // Catch: NoSuchFieldError -> L19
        L42:
            r100[ObricInteractionType.AutoHalfDuplex.ordinal()] = 3;     // Catch: NoSuchFieldError -> L20
        L8:
            $EnumSwitchMapping$0 = r100;
            int[] r101 = new int[ForegroundInteractionPhase.values().length];
            r101[ForegroundInteractionPhase.Activate.ordinal()] = 1;     // Catch: NoSuchFieldError -> L21
        L34:
            r101[ForegroundInteractionPhase.Generating.ordinal()] = 2;     // Catch: NoSuchFieldError -> L22
        L44:
            r101[ForegroundInteractionPhase.Generated.ordinal()] = 3;     // Catch: NoSuchFieldError -> L23
        L28:
            r101[ForegroundInteractionPhase.Thinking.ordinal()] = 4;     // Catch: NoSuchFieldError -> L24
        L36:
            r101[ForegroundInteractionPhase.Idle.ordinal()] = 5;     // Catch: NoSuchFieldError -> L25
        L30:
            r101[ForegroundInteractionPhase.Connecting.ordinal()] = 6;     // Catch: NoSuchFieldError -> L26
        L38:
            r101[ForegroundInteractionPhase.Listen.ordinal()] = 7;     // Catch: NoSuchFieldError -> L27
        L16:
            $EnumSwitchMapping$1 = r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.interaction.impl.AssistantInteractionService$onActivate$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes33.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.interaction.impl.AssistantInteractionService$onActivate$1", f = "AssistantInteractionService.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public AnonymousClass1(Continuation<? super AnonymousClass1> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass1) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L11;
            ResultKt.throwOnFailure(r100);
            if (IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState().getValue().getFirst().booleanValue() == false) goto L9;
            IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState().setValue(TuplesKt.to(Boxing.boxBoolean(false), "clear"));
            return Unit.INSTANCE;
        L9:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
        Companion = new Companion(null);
    }

    public static /* synthetic */ void a(AssistantInteractionService r100, zga.b r101) {
        projectionObserver$lambda$0(r100, r101);
    }

    @Override // com.obric.assistant.interaction.api.IAssistantInteractionService
    public List<ILifecycleService> getLifecycleServices() {
        return CollectionsKt.listOf(new ILifecycleService[]{InteractionStateServiceImpl.INSTANCE, EventHubImpl.INSTANCE});
    }

    @Override // com.obric.assistant.interaction.api.IAssistantInteractionService
    public void soundEffectInit() {
        ObricInteractionProjectionDelegate.f392943b.b(null, this.projectionObserver);
        FLogger.f375446a.i(this.TAG$1, "soundEffectInit");
    }

    @Override // com.obric.assistant.interaction.api.IAssistantInteractionService
    public void systemStateInit() {
        SystemStateHelper r100 = SystemStateHelper.INSTANCE;
        AppHost.Companion r101 = AppHost.f326268a;
        r100.init(r101.getApplication().getApplicationContext());
        ActivityStackObserver.INSTANCE.init(r101.getApplication().getApplicationContext());
        RealtimeCallLifecycleBridge.INSTANCE.init();
        new ObricInstrumentation().installHook();
        startAppletListener();
        FLogger.f375446a.i(this.TAG$1, "systemStateInit");
    }

    public AssistantInteractionService() {
        this.TAG$1 = TAG;
        this.curBid = "";
        this.isGenerateStart = new LinkedHashMap();
        this.lastPhase = new ConcurrentHashMap();
        this.curMode = new ConcurrentHashMap();
        this.projectionObserver = new f(this);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r1v1, types: [com.obric.assistant.interaction.impl.AssistantInteractionService$startAppletListener$1] */
    private final void startAppletListener() {
        if (com.bytedance.apm.d.l() == true) goto L5;
        return;
    L5:
        AppletService r100 = (AppletService) ServiceManager.get().getService(AppletService.class);
        if (r100 == 0) goto L9;
        ?? r101 = new C116191(this);
        FLogger.f375446a.d(this.TAG$1, "addAppActionListener to AppletService");
        r100.l(r101);
        return;
    }

    @Override // com.obric.assistant.interaction.api.IAssistantInteractionService
    public IAuthenticationOnLockScreenService get_authenOnLockScreenService() {
        return AuthenticationOnLockScreenService.INSTANCE;
    }

    @Override // com.obric.assistant.interaction.api.IAssistantInteractionService
    public IInteractionStateApi get_interactionStateApi() {
        return InteractionApiImpl.INSTANCE;
    }

    @Override // com.obric.assistant.interaction.api.IAssistantInteractionService
    public IInteractionStateService get_interactionStateService() {
        return InteractionStateServiceImpl.INSTANCE;
    }

    public static final /* synthetic */ Job access$getAppActionCheckJob$p(AssistantInteractionService r100) {
        return r100.appActionCheckJob;
    }

    public static final /* synthetic */ Job access$getStopVUIJob$p(AssistantInteractionService r100) {
        return r100.stopVUIJob;
    }

    public static final /* synthetic */ String access$getTAG$p(AssistantInteractionService r100) {
        return r100.TAG$1;
    }

    private final boolean isInWhiteListAppAction(String r100) {
        return Intrinsics.areEqual(r100, WHITE_LIST_AUDIO_PLAYER_ACTION);
    }

    private final boolean isInterceptedByUiU(String r100) {
        if (Intrinsics.areEqual(r100, "system_ui_understanding_plugin.system_do_view_operations_tool") == false) goto L5;
    L8:
        return true;
    L5:
        if (Intrinsics.areEqual(r100, "system_ui_understanding_plugin.system_get_uiu_context_tool") == true) goto L8;
        return false;
    }

    private final void onActivate(String r100) {
        FLogger.f375446a.d(this.TAG$1, "onActivate botId:" + r100 + " curBotId:" + this.curBid);
        this.curBid = r100;
        if (ObricInteractionType.TextMode != this.curMode.get(r100)) goto L5;
    L9:
        this.isGenerateStart.remove(r100);
        return;
    L5:
        if (ObricInteractionType.DefaultMode == this.curMode.get(r100)) goto L9;
        if (ObricInteractionType.RealtimeCallMode == this.curMode.get(r100)) goto L9;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
        goto L9
    }

    private final void onDeactivate(String r100) {
        FLogger.f375446a.d(this.TAG$1, "onDeactivate botId:" + r100 + " curBotId:" + this.curBid);
        this.isGenerateStart.remove(r100);
        IAssistantInteractionServiceKt.getInteractionStateService().resetWakeupSource();
        ObricShowArgServiceDelegate.f393866b.a("other");
    }

    private final void onGenerating(String r100) {
        FLogger.f375446a.d(this.TAG$1, "onGenerating botId:" + r100 + " curBotId:" + this.curBid);
        if (Intrinsics.areEqual(r100, this.curBid) == false) goto L9;
        Boolean r101 = this.isGenerateStart.get(r100);
        Boolean r102 = Boolean.TRUE;
        if (Intrinsics.areEqual(r101, r102) == true) goto L9;
        if (ObricInteractionType.RealtimeCallMode == this.curMode.get(r100)) goto L9;
        this.isGenerateStart.put(r100, r102);
    L9:
        IAssistantInteractionServiceKt.getInteractionStateService().resetWakeupData();
    }

    private final void onThinking(String r100) {
        FLogger.f375446a.d(this.TAG$1, "onThinking botId:" + r100 + " curBotId:" + this.curBid + " mode:" + this.curMode);
        boolean r101 = true;
        if (this.lastPhase.get(r100) == ForegroundInteractionPhase.Thinking) goto L5;
        boolean r102 = true;
    L6:
        if (r102 == true) goto L8;
    L28:
        this.isGenerateStart.remove(r100);
        return;
    L8:
        if (Intrinsics.areEqual(r100, this.curBid) == false) goto L28;
        if (ObricInteractionType.TextMode == this.curMode.get(r100)) goto L28;
        if (ObricInteractionType.RealtimeCallMode == this.curMode.get(r100)) goto L28;
        IBluetoothHeadSetAPI r103 = tha.c.a();
        if (r103 != null) goto L16;
    L18:
        r101 = false;
    L19:
        if (r101 == false) goto L22;
        return;
    L22:
        if (IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState().getValue().getFirst().booleanValue() == false) goto L24;
        IAssistantInteractionServiceKt.getInteractionStateService().getPreSoundEffectState().setValue(TuplesKt.to(Boolean.FALSE, "clear"));
        goto L28
    L24:
        Object r104 = AppHost.f326268a.getApplication().getSystemService("audio");
        Intrinsics.checkNotNull(r104, "null cannot be cast to non-null type android.media.AudioManager");
        if (((AudioManager) r104).getRingerMode() != 2) goto L27;
        SoundEffectHelper.INSTANCE.playSendMessage();
    L27:
        SystemHiddenApiHelper.INSTANCE.performVibratorSmtFeedback(VibratorSmtFeedbackEffect.EFFECT_TICK);
        goto L28
    L16:
        if (r103.a() != true) goto L18;
    L5:
        r102 = false;
        goto L6
    }

    public static final /* synthetic */ boolean access$isInWhiteListAppAction(AssistantInteractionService r100, String r101) {
        return r100.isInWhiteListAppAction(r101);
    }

    public static final /* synthetic */ boolean access$isInterceptedByUiU(AssistantInteractionService r100, String r101) {
        return r100.isInterceptedByUiU(r101);
    }

    public static final /* synthetic */ void access$setAppActionCheckJob$p(AssistantInteractionService r100, Job r101) {
        r100.appActionCheckJob = r101;
    }

    public static final /* synthetic */ void access$setStopVUIJob$p(AssistantInteractionService r100, Job r101) {
        r100.stopVUIJob = r101;
    }

    private final void onGenerated(String r100, boolean r101) {
        FLogger.f375446a.d(this.TAG$1, "onGenerated botId:" + r100 + " curBotId:" + this.curBid + ", failed:" + r101);
        this.isGenerateStart.remove(r100);
        IAssistantInteractionServiceKt.getInteractionStateService().resetWakeupData();
    }

    private static final void projectionObserver$lambda$0(AssistantInteractionService r100, zga.b r101) {
        Intrinsics.checkNotNullParameter(r101, "projection");
        String r102 = r101.f572105a;
        if (r102 != null) goto L5;
        return;
    L5:
        ObricInteractionType r103 = r101.f572107c;
        ForegroundInteractionPhase r104 = r101.f572109e;
        FLogger r105 = FLogger.f375446a;
        r105.d(r100.TAG$1, "onProjectionChanged botId:" + r102 + " mode:" + r103 + " phase:" + r104 + " lastPhase:" + r100.lastPhase);
        ObricInteractionType r106 = r100.curMode.put(r102, r103);
        ObricInteractionType r107 = ObricInteractionType.DefaultMode;
        if (r103 != r107) goto L10;
        if (r106 == null) goto L10;
        if (r106 == r107) goto L10;
        IAssistantInteractionServiceKt.getInteractionStateService().resetWakeupSource();
        ObricShowArgServiceDelegate.f393866b.a("other");
    L10:
        int r108 = WhenMappings.$EnumSwitchMapping$0[r103.ordinal()];
        if (r108 != 1) goto L13;
    L17:
        String r109 = r102;
    L18:
        r100.curBid = r109;
        if (Intrinsics.areEqual(r102, r109) == false) goto L22;
        ForegroundInteractionPhase r110 = ForegroundInteractionPhase.Idle;
    L22:
        switch(WhenMappings.$EnumSwitchMapping$1[r104.ordinal()]) {
            case 1: goto L36;
            case 2: goto L35;
            case 3: goto L34;
            case 4: goto L33;
            case 5: goto L27;
            case 6: goto L25;
            case 7: goto L25;
            default: goto L24;
        };
    L25:
        r105.d(r100.TAG$1, "Ignore phase change, phase:" + r104);
    L37:
        r100.lastPhase.put(r102, r104);
        return;
    L33:
        r100.onThinking(r102);
        goto L37
    L34:
        r100.onGenerated(r102, false);
        goto L37
    L35:
        r100.onGenerating(r102);
        goto L37
    L36:
        r100.onActivate(r102);
        goto L37
    L24:
        throw new NoWhenBranchMatchedException();
    L27:
        if (r100.curMode.get(r102) != ObricInteractionType.AutoHalfDuplex) goto L37;
        if (r100.lastPhase.get(r102) != ForegroundInteractionPhase.Activate) goto L31;
    L32:
        r100.onDeactivate(r102);
        goto L37
    L31:
        if (r100.lastPhase.get(r102) != ForegroundInteractionPhase.Listen) goto L37;
    L13:
        if (r108 == 2) goto L17;
        if (r108 == 3) goto L17;
        r109 = "";
        goto L18
    }
}
