package com.larus.dora.impl.device.settings.lab;

import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.voice.ProtocolAbility;
import com.larus.account.base.api.ILoginService;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.DoraServiceImpl;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.settingsconfig.DoraXLinkTransportMode;
import com.larus.dora.impl.core.wifi.DoraP2pRtcSwitchSync;
import com.larus.dora.impl.core.wifi.DoraWifiLinkWrapper;
import com.larus.dora.impl.core.x0;
import com.larus.dora.impl.device.settings.lab.env.DoraEnvObserveNetwork;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.SessionService;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.util.t0;
import com.larus.nova.R;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.List;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.MainCoroutineDispatcher;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0088\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0016\u0018\u0000 Q2\u00020\u0001:\u0001QB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u0010-\u001a\u00020.H\u0002J\b\u0010/\u001a\u0004\u0018\u000100J\u0006\u00101\u001a\u00020.J\u0006\u00102\u001a\u00020.J\b\u00103\u001a\u000204H\u0002J\u000e\u00105\u001a\u00020.2\u0006\u00106\u001a\u000204J\u000e\u00107\u001a\u00020.2\u0006\u00108\u001a\u000209J \u0010:\u001a\u00020.2\u0006\u0010;\u001a\u00020<2\u0006\u0010=\u001a\u0002042\u0006\u0010>\u001a\u000204H\u0002J\u0016\u0010?\u001a\u00020\u00132\u0006\u00106\u001a\u000204H\u0082@¢\u0006\u0002\u0010@J\u0010\u0010A\u001a\u0002042\u0006\u0010B\u001a\u00020\u0013H\u0002J\u0016\u0010C\u001a\u00020\u00132\u0006\u00106\u001a\u000204H\u0082@¢\u0006\u0002\u0010@J\u000e\u0010D\u001a\u00020.2\u0006\u00106\u001a\u000204J\u000e\u0010E\u001a\u00020.2\u0006\u00106\u001a\u000204J\b\u0010F\u001a\u000204H\u0002J\u000e\u0010G\u001a\u00020.2\u0006\u00106\u001a\u000204J\u0006\u0010H\u001a\u000204J\u000e\u0010I\u001a\u00020.2\u0006\u00106\u001a\u000204J\u000e\u0010J\u001a\u00020.2\u0006\u00106\u001a\u000204J\b\u0010K\u001a\u00020.H\u0002J\b\u0010L\u001a\u000204H\u0002J\b\u0010M\u001a\u000204H\u0002J\f\u0010N\u001a\u00020\u0013*\u000204H\u0002J\b\u0010O\u001a\u00020.H\u0002J\b\u0010P\u001a\u00020.H\u0014R\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0014\u0010\u0016\u001a\u00020\u0013X\u0086D¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0015R\u0017\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00130\u0019¢\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u001d\u0010\u001c\u001a\u0004\u0018\u00010\u001d8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b \u0010!\u001a\u0004\b\u001e\u0010\u001fR\u001d\u0010\"\u001a\u0004\u0018\u00010#8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b&\u0010!\u001a\u0004\b$\u0010%R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020*X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006R"}, d2 = {"Lcom/larus/dora/impl/device/settings/lab/LabSettingsViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_envStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/settings/lab/LabEnvSettings;", "envStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getEnvStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_envActionSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/settings/lab/LabEnvAction;", "envActionSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getEnvActionSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "ENV_OB_UVI_SUCCESS", "", "getENV_OB_UVI_SUCCESS", "()I", "ENV_OB_TX_TIMEOUT", "getENV_OB_TX_TIMEOUT", "ENV_OB_UVI_FAILED_WITH_REASON", "", "getENV_OB_UVI_FAILED_WITH_REASON", "()Ljava/util/List;", "doraServiceImpl", "Lcom/larus/dora/api/IDoraService;", "getDoraServiceImpl", "()Lcom/larus/dora/api/IDoraService;", "doraServiceImpl$delegate", "Lkotlin/Lazy;", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "doraVoiceCallback", "Lcom/larus/dora/api/protocol/IFlowDoraVoiceCallBack;", "featureConfigRepository", "Lcom/larus/dora/impl/dynamic/repository/DoraFeatureConfigRepository;", "rtcTransportModeMutex", "Lkotlinx/coroutines/sync/Mutex;", "initData", "", "getFeatureConfig", "Lcom/larus/dora/impl/dynamic/entity/DoraLabFeatureConfig;", "onVoiceWakeUpState", "forceUpdateEnable", "curEnvObserveState", "", "setQuickContinuousConversationEnable", "isEnabled", "setRTCTransportMode", "mode", "Lcom/larus/dora/impl/device/settings/lab/RTCTransportMode;", "updateRTCTransportLocalState", "uid", "", "bluetoothRTCEnable", "p2pRTCEnable", "syncBluetoothRTCVideoCallSwitch", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isRTCSwitchSyncAccepted", "ret", "syncEffectiveP2PRTCVideoCallSwitch", "setBehaviorAwareEnable", "setNaturalInteractionBgmEnable", "isNaturalWakeupSettingBlocked", "setDataSavingEnable", "isDataSavingEntranceVisible", "setAllowDoubaoViewImagesEnable", "setRtosPlayerEnabled", "updateCacheAndUIState", "takeBehaviorAwareToggle", "isSupportBehaviorAware", "toToggleValue", "fetchData", "onCleared", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LabSettingsViewModel extends ViewModel {
    public static final b Companion = null;
    private static final int RET_FAILED = -1;
    private static final int SYNC_MAX_RETRIES = 3;
    private static final long SYNC_RETRY_DELAY_MS = 100;
    public static final String TAG = "LabSettingsViewModel";
    private static final int TOGGLE_OFF = 0;
    private static final int TOGGLE_ON = 1;
    private final int ENV_OB_TX_TIMEOUT;
    private final List<Integer> ENV_OB_UVI_FAILED_WITH_REASON;
    private final int ENV_OB_UVI_SUCCESS;
    private final MutableSharedFlow<com.larus.dora.impl.device.settings.lab.b> _envActionSharedFlow;
    private z0<c> _envStateFlow;
    private final Lazy doraPageConfig$delegate;
    private final Lazy doraServiceImpl$delegate;
    private f49.b doraVoiceCallback;
    private final d1<com.larus.dora.impl.device.settings.lab.b> envActionSharedFlow;
    private final i1<c> envStateFlow;
    private final g59.c featureConfigRepository;
    private final kotlinx.coroutines.sync.a rtcTransportModeMutex;

    public static final class a extends t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LabSettingsViewModel f334558a;

        public a(LabSettingsViewModel r100) {
            this.f334558a = r100;
        }

        @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            g49.d.a(LabSettingsViewModel.TAG, "onDoraLinkStateChanged: state=" + r102);
            if (r102 != 2) goto L6;
            LabSettingsViewModel.access$initData(this.f334558a);
            return;
        }
    }

    public static final class b {
        public b() {
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$fetchData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$fetchData$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            DoraEnvObserveNetwork.a();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$forceUpdateEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$forceUpdateEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111541 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111541(LabSettingsViewModel r100, Continuation<? super C111541> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111541(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111541) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L33;
            ResultKt.throwOnFailure(r110);
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L31;
            String r100 = ILoginService.f286097a.getAccountInfo().f531530c;
            if (r100 != null) goto L9;
            r100 = "";
        L9:
            DoraWifiLinkWrapper.f332292a.getClass();
            DoraWifiLinkWrapper.a r101 = DoraWifiLinkWrapper.n();
            boolean r111 = r101.a();
            boolean r112 = r101.f332302b;
            b0.f338123a.getClass();
            boolean r102 = b0.p(r100);
            boolean r103 = b0.u(r100);
            com.larus.dora.impl.core.settingsconfig.c.f332267a.getClass();
            DoraXLinkTransportMode r104 = com.larus.dora.impl.core.settingsconfig.c.d(r102, r103, r111);
            g49.d.d(LabSettingsViewModel.TAG, "forceUpdateEnable RTC transport: bluetooth=" + r102 + ", p2p=" + r103 + ", hasPermissions=" + r101.f332301a + ", hasAbility=" + r101.f332302b + ", runtimeSupported=" + r111 + ", effectiveMode=" + r104);
            if (LabSettingsViewModel.access$isSupportBehaviorAware(this.this$0) == false) goto L12;
            boolean r113 = LabSettingsViewModel.access$takeBehaviorAwareToggle(this.this$0);
        L13:
            z0 r105 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            Object r106 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r106, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            c.b r107 = (c.b) r106;
            IDoraPageConfig r108 = LabSettingsViewModel.access$getDoraPageConfig(this.this$0);
            if (r108 == null) goto L16;
            boolean r109 = r108.d("dora_g_config_key_env_observe_enable", false);
        L17:
            IDoraPageConfig r114 = LabSettingsViewModel.access$getDoraPageConfig(this.this$0);
            if (r114 == null) goto L20;
            boolean r115 = r114.d("dora_g_config_key_env_observe_auth_enable", false);
        L21:
            boolean r116 = b0.w();
            boolean r117 = b0.j().getBoolean("dora_natural_interaction_bgm_enabled", false);
            if (r104 == DoraXLinkTransportMode.OFF) goto L24;
            boolean r118 = true;
        L26:
            if (r104 != DoraXLinkTransportMode.WIFI) goto L28;
            boolean r119 = true;
        L29:
            r105.setValue(c.b.a(r107, r109, false, r115, r116, r117, false, false, r118, r119, r111, r112, r113, false, 3559221));
            goto L31
        L28:
            r119 = false;
            goto L29
        L24:
            r118 = false;
            goto L26
        L20:
            r115 = false;
            goto L21
        L16:
            r109 = false;
            goto L17
        L12:
            r113 = false;
        L31:
            return Unit.INSTANCE;
        L33:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1", f = "LabSettingsViewModel.kt", i = {0, 0, 0, 0}, l = {104, 131}, m = "invokeSuspend", n = {"isSupEnvObser", "envAuthEnable", "envEnable", "envState"}, s = {"Z$0", "I$0", "I$1", "I$2"})
    public static final class C111551 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        int I$2;
        boolean Z$0;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
        public static final class C42281 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $allowDoubaoViewImagesEnable;
            final /* synthetic */ boolean $behaviorAwareEnable;
            final /* synthetic */ boolean $envAuthEnable;
            final /* synthetic */ boolean $envEnable;
            final /* synthetic */ boolean $envState;
            final /* synthetic */ boolean $isSupEnvObser;
            final /* synthetic */ boolean $isSupportBehaviorAware;
            final /* synthetic */ boolean $isSupportBluetoothRTC;
            final /* synthetic */ boolean $isSupportHeadGestureControl;
            final /* synthetic */ boolean $isSupportQuickContinuousConversation;
            final /* synthetic */ boolean $isSupportRecordMinutes;
            final /* synthetic */ boolean $isSupportRtosPlayer;
            final /* synthetic */ boolean $isSupportSimulInterpret;
            final /* synthetic */ boolean $naturalInteractionBgmEnable;
            final /* synthetic */ boolean $quickContinuousConversationEnable;
            final /* synthetic */ boolean $rtosPlayerEnable;
            final /* synthetic */ String $uid;
            int label;
            final /* synthetic */ LabSettingsViewModel this$0;

            public C42281(String r100, LabSettingsViewModel r101, boolean r102, boolean r103, boolean r104, boolean r105, boolean r110, boolean r111, boolean r112, boolean r113, boolean r114, boolean r115, boolean r116, boolean r117, boolean r118, boolean r119, boolean r210, boolean r211, Continuation<? super C42281> r212) {
                this.$uid = r100;
                this.this$0 = r101;
                this.$isSupEnvObser = r102;
                this.$envEnable = r103;
                this.$envState = r104;
                this.$envAuthEnable = r105;
                this.$isSupportSimulInterpret = r110;
                this.$isSupportQuickContinuousConversation = r111;
                this.$quickContinuousConversationEnable = r112;
                this.$naturalInteractionBgmEnable = r113;
                this.$isSupportRecordMinutes = r114;
                this.$allowDoubaoViewImagesEnable = r115;
                this.$rtosPlayerEnable = r116;
                this.$isSupportRtosPlayer = r117;
                this.$isSupportBluetoothRTC = r118;
                this.$isSupportHeadGestureControl = r119;
                this.$isSupportBehaviorAware = r210;
                this.$behaviorAwareEnable = r211;
                super(2, r212);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r210, Continuation<?> r211) {
                return new C42281(this.$uid, this.this$0, this.$isSupEnvObser, this.$envEnable, this.$envState, this.$envAuthEnable, this.$isSupportSimulInterpret, this.$isSupportQuickContinuousConversation, this.$quickContinuousConversationEnable, this.$naturalInteractionBgmEnable, this.$isSupportRecordMinutes, this.$allowDoubaoViewImagesEnable, this.$rtosPlayerEnable, this.$isSupportRtosPlayer, this.$isSupportBluetoothRTC, this.$isSupportHeadGestureControl, this.$isSupportBehaviorAware, this.$behaviorAwareEnable, r211);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C42281) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r210) {
                IntrinsicsKt.getCOROUTINE_SUSPENDED();
                if (this.label != 0) goto L19;
                ResultKt.throwOnFailure(r210);
                b0 r100 = b0.f338123a;
                String r101 = this.$uid;
                r100.getClass();
                boolean r102 = b0.p(r101);
                DoraWifiLinkWrapper.f332292a.getClass();
                DoraWifiLinkWrapper.a r103 = DoraWifiLinkWrapper.n();
                boolean r110 = r103.a();
                boolean r111 = r103.f332302b;
                boolean r104 = b0.u(this.$uid);
                if (r110 == true) goto L8;
                if (r104 == false) goto L8;
                g49.d.e(LabSettingsViewModel.TAG, "initData: P2P RTC effective mode disabled because runtime is not supported, hasPermissions=" + r103.f332301a + ", hasAbility=" + r103.f332302b);
            L8:
                com.larus.dora.impl.core.settingsconfig.c.f332267a.getClass();
                DoraXLinkTransportMode r105 = com.larus.dora.impl.core.settingsconfig.c.d(r102, r104, r110);
                g49.d.d(LabSettingsViewModel.TAG, "initData RTC transport: bluetooth=" + r102 + ", p2p=" + r104 + ", hasPermissions=" + r103.f332301a + ", hasAbility=" + r103.f332302b + ", runtimeSupported=" + r110 + ", effectiveMode=" + r105);
                z0 r106 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
                if (r105 == DoraXLinkTransportMode.OFF) goto L11;
                boolean r112 = true;
            L13:
                if (r105 != DoraXLinkTransportMode.WIFI) goto L15;
                boolean r113 = true;
            L16:
                r106.setValue(new c.b(this.$isSupEnvObser, this.$envEnable, this.$envState, this.$envAuthEnable, this.$isSupportSimulInterpret, this.$isSupportQuickContinuousConversation, this.$quickContinuousConversationEnable, this.$naturalInteractionBgmEnable, this.$isSupportRecordMinutes, this.$allowDoubaoViewImagesEnable, this.$rtosPlayerEnable, this.$isSupportRtosPlayer, r112, r113, this.$isSupportBluetoothRTC, r110, r111, this.$isSupportHeadGestureControl, this.$isSupportBehaviorAware, this.$behaviorAwareEnable, DoraWifiLinkWrapper.i(), DoraWifiLinkWrapper.h()));
                return Unit.INSTANCE;
            L15:
                r113 = false;
                goto L16
            L11:
                r112 = false;
                goto L13
            L19:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
        }

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$initData$1$a */
        public static final class a implements f49.b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ LabSettingsViewModel f334559a;

            @Override // f49.b
            public final void b() {
            }

            @Override // f49.b
            public final void d(int r100) {
            }

            @Override // f49.b
            public final void h(int r100) {
            }

            @Override // f49.b
            public final void i() {
            }

            @Override // f49.b
            public final void j(byte[] r100, byte[] r101) {
            }

            @Override // f49.b
            public final void k() {
            }

            @Override // f49.b
            public final void m() {
            }

            @Override // f49.b
            public final void n() {
            }

            @Override // f49.b
            public final void o() {
            }

            @Override // f49.b
            public final void p() {
            }

            public a(LabSettingsViewModel r100) {
                this.f334559a = r100;
            }

            @Override // f49.b
            public final void l(int r100, int r101, int r102) {
                g49.d.d(LabSettingsViewModel.TAG, "onVoiceWakeup state = " + r100 + ", wakeMode = " + r101 + ", query = " + r102);
                if (r101 != 11) goto L6;
                this.f334559a.onVoiceWakeUpState();
                return;
            }
        }

        public C111551(LabSettingsViewModel r100, Continuation<? super C111551> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111551(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111551) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r6v10 */
        /* JADX WARN: Type inference failed for: r6v12 */
        /* JADX WARN: Type inference failed for: r6v13 */
        /* JADX WARN: Type inference failed for: r6v5 */
        /* JADX WARN: Type inference failed for: r6v6, types: [int] */
        /* JADX WARN: Type inference failed for: r6v8 */
        /* JADX WARN: Type inference failed for: r7v1 */
        /* JADX WARN: Type inference failed for: r7v2, types: [int] */
        /* JADX WARN: Type inference failed for: r7v3 */
        /* JADX WARN: Type inference failed for: r7v4 */
        /* JADX WARN: Type inference failed for: r7v6 */
        /* JADX WARN: Type inference failed for: r7v7 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r310) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L11;
            if (r101 == 1) goto L9;
            if (r101 != 2) goto L8;
            ResultKt.throwOnFailure(r310);
        L60:
            LabSettingsViewModel r102 = this.this$0;
            a r103 = new a(r102);
            IDoraService r104 = LabSettingsViewModel.access$getDoraServiceImpl(r102);
            if (r104 == null) goto L65;
            SessionService r105 = r104.d();
            if (r105 == null) goto L65;
            r105.i(r103);
        L65:
            LabSettingsViewModel.access$setDoraVoiceCallback$p(r102, r103);
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            int r106 = this.I$2;
            int r107 = this.I$1;
            int r108 = this.I$0;
            boolean r109 = this.Z$0;
            ResultKt.throwOnFailure(r310);
            Object r110 = r310;
            ?? r111 = r107;
            ?? r112 = r108;
        L10:
            boolean r113 = r109;
            boolean r114 = ((Boolean) r110).booleanValue();
            b0.f338123a.getClass();
            boolean r115 = b0.w();
            boolean r210 = b0.j().getBoolean("dora_natural_interaction_bgm_enabled", false);
            IDoraService r116 = LabSettingsViewModel.access$getDoraServiceImpl(this.this$0);
            if (r116 == null) goto L35;
            DeviceService r117 = r116.device();
            if (r117 == null) goto L35;
            if (r117.j0() != true) goto L35;
            boolean r118 = true;
        L36:
            sk4.e r119 = o0.f332223a;
            boolean r211 = o0.c(ProtocolAbility.FEATURE_RECORD_MINUTES);
            boolean r212 = o0.c(ProtocolAbility.FEATURE_HEAD_GESTURE);
            boolean r213 = o0.c("behaviorAware");
            if (b0.j().getInt("dora_g_button_mode", 1) == 1) goto L39;
            boolean r214 = true;
        L40:
            boolean r215 = kj4.a.g().getRtosPlayerSwitchState();
            boolean r216 = DoraAdapterExtKt.w(kj4.a.g());
            boolean r217 = o0.c("rtc");
            String r120 = ILoginService.f286097a.getAccountInfo().f531530c;
            if (r120 != null) goto L43;
            r120 = "";
        L43:
            String r121 = r120;
            if (r213 == false) goto L46;
            boolean r218 = LabSettingsViewModel.access$takeBehaviorAwareToggle(this.this$0);
        L47:
            MainCoroutineDispatcher r122 = Dispatchers.getMain();
            LabSettingsViewModel r123 = this.this$0;
            if (r111 == 0) goto L50;
            boolean r124 = true;
        L51:
            if (r106 == 0) goto L53;
            boolean r125 = true;
        L54:
            if (r112 == 0) goto L56;
            boolean r126 = true;
        L57:
            C42281 r127 = new C42281(r121, r123, r113, r124, r125, r126, r118, r114, r115, r210, r211, r214, r215, r216, r217, r212, r213, r218, null);
            this.label = 2;
            if (BuildersKt.withContext(r122, r127, this) != r100) goto L60;
            return r100;
        L56:
            r126 = false;
            goto L57
        L53:
            r125 = false;
            goto L54
        L50:
            r124 = false;
            goto L51
        L46:
            r218 = false;
            goto L47
        L39:
            r214 = false;
        L35:
            r118 = false;
            goto L36
        L11:
            ResultKt.throwOnFailure(r310);
            boolean r128 = Intrinsics.areEqual(AppHost.f326268a.getBuildChannel(), "dora_g_ut");
            sk4.e r129 = o0.f332223a;
            r109 = o0.c(ProtocolAbility.FEATURE_ENV_OBSERVE);
            g49.d.d(LabSettingsViewModel.TAG, "isUT: " + r128 + ", isSup: " + r109);
            IDoraPageConfig r130 = LabSettingsViewModel.access$getDoraPageConfig(this.this$0);
            if (r130 == null) goto L14;
            ?? r131 = r130.d("dora_g_config_key_env_observe_auth_enable", false);
        L15:
            IDoraPageConfig r132 = LabSettingsViewModel.access$getDoraPageConfig(this.this$0);
            if (r132 == null) goto L18;
            ?? r133 = r132.d("dora_g_config_key_env_observe_enable", false);
        L20:
            if (LabSettingsViewModel.access$curEnvObserveState(this.this$0) == true) goto L22;
        L24:
            r106 = 0;
        L25:
            this.Z$0 = r109;
            this.I$0 = r131;
            this.I$1 = r133;
            this.I$2 = r106;
            this.label = 1;
            boolean r134 = o0.c(ProtocolAbility.FEATURE_LIGHT_EFFECT_CONTROL);
            g49.d.d("DoraProtocol", "isSupportQuickContinuousConversation: " + r134);
            r110 = Boxing.boxBoolean(r134);
            r111 = r133;
            r112 = r131;
            if (r110 != r100) goto L10;
            return r100;
        L22:
            if (DoraAdapterExtKt.t(kj4.a.g()) == false) goto L24;
            r106 = 1;
            goto L25
        L18:
            r133 = 0;
            goto L20
        L14:
            r131 = 0;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$onVoiceWakeUpState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$onVoiceWakeUpState$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111561 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111561(LabSettingsViewModel r100, Continuation<? super C111561> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111561(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111561) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r210);
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L8;
            z0 r100 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            Object r101 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            r100.setValue(c.b.a((c.b) r101, false, LabSettingsViewModel.access$curEnvObserveState(this.this$0), false, false, false, false, false, false, false, false, false, false, false, 4194299));
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setAllowDoubaoViewImagesEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setAllowDoubaoViewImagesEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {651}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111571 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111571(boolean r100, LabSettingsViewModel r101, Continuation<? super C111571> r102) {
            this.$isEnabled = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111571(this.$isEnabled, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111571) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r210);
        L22:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            if (this.$isEnabled == true) goto L11;
            int r102 = 1;
        L12:
            int r103 = yj4.g.f568093a;
            final yj4.f r104 = yj4.f.a.f568092a;
            r104.getClass();
            int r105 = yj4.h.C2.j(1, 4, new byte[]{22, 1, (byte) r102}, 5000);
            pk4.m.a(new yj4.c(r104));
            g49.d.d(LabSettingsViewModel.TAG, "setAllowDoubaoViewImagesEnable: " + this.$isEnabled + ", ret = " + r105);
            if (r105 == 0) goto L15;
            MutableSharedFlow r106 = LabSettingsViewModel.access$get_envActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.lab.b.a r107 = new com.larus.dora.impl.device.settings.lab.b.a();
            this.label = 1;
            if (r106.emit(r107, this) != r100) goto L22;
            return r100;
        L15:
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L17;
            b0.f338123a.getClass();
            b0.j().storeInt("dora_g_button_mode", r102);
            z0 r108 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            Object r109 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r109, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            r108.setValue(c.b.a((c.b) r109, false, false, false, false, false, this.$isEnabled, false, false, false, false, false, false, false, 4193791));
        L17:
            DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "dora_photo_permission_settings_change", MapsKt.mapOf(TuplesKt.to("dora_g_photo_permission_switch", x0.b(this.$isEnabled))), false, 12);
            goto L22
        L11:
            r102 = 2;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setBehaviorAwareEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setBehaviorAwareEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {550}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111581 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setBehaviorAwareEnable$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setBehaviorAwareEnable$1$1", f = "LabSettingsViewModel.kt", i = {0, 0}, l = {562, 573}, m = "invokeSuspend", n = {"ret", "retryIndex"}, s = {"I$0", "I$1"})
        public static final class C42291 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isEnabled;
            int I$0;
            int I$1;
            int label;
            final /* synthetic */ LabSettingsViewModel this$0;

            public C42291(LabSettingsViewModel r100, boolean r101, Continuation<? super C42291> r102) {
                this.this$0 = r100;
                this.$isEnabled = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C42291(this.this$0, this.$isEnabled, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C42291) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:23:0x0058 -> B:27:0x0069). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:25:0x0066 -> B:27:0x0069). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r210) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L10;
                if (r101 == 1) goto L9;
                if (r101 != 2) goto L8;
                ResultKt.throwOnFailure(r210);
            L37:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                int r102 = this.I$1;
                int r103 = this.I$0;
                ResultKt.throwOnFailure(r210);
                int r104 = r103;
                C42291 r105 = this;
            L27:
                r102 = r102 + 1;
            L16:
                if (r102 >= 3) goto L28;
                zj4.a r106 = zj4.a.C8468a.f572461a;
                if (r106 == null) goto L20;
                r104 = r106.a(LabSettingsViewModel.access$toToggleValue(r105.this$0, r105.$isEnabled));
            L21:
                if (r104 == 0) goto L28;
                if (r102 >= 2) goto L27;
                r105.I$0 = r104;
                r105.I$1 = r102;
                r105.label = 1;
                if (DelayKt.delay(100, r105) != r100) goto L27;
                return r100;
            L20:
                r104 = -1;
            L28:
                g49.d.d(LabSettingsViewModel.TAG, "setBehaviorAwareEnable: isEnabled=" + r105.$isEnabled + ", ret=" + r104);
                if (r104 == 0) goto L31;
                MutableSharedFlow r107 = LabSettingsViewModel.access$get_envActionSharedFlow$p(r105.this$0);
                com.larus.dora.impl.device.settings.lab.b.C4231b r108 = new com.larus.dora.impl.device.settings.lab.b.C4231b();
                r105.label = 2;
                if (r107.emit(r108, r105) != r100) goto L37;
                return r100;
            L31:
                if ((LabSettingsViewModel.access$get_envStateFlow$p(r105.this$0).getValue() instanceof c.b) == false) goto L37;
                z0 r109 = LabSettingsViewModel.access$get_envStateFlow$p(r105.this$0);
                Object r110 = LabSettingsViewModel.access$get_envStateFlow$p(r105.this$0).getValue();
                Intrinsics.checkNotNull(r110, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
                r109.setValue(c.b.a((c.b) r110, false, false, false, false, false, false, false, false, false, false, false, r105.$isEnabled, false, 3670015));
                goto L37
            L10:
                ResultKt.throwOnFailure(r210);
                if (LabSettingsViewModel.access$isSupportBehaviorAware(this.this$0) == true) goto L14;
                g49.d.e(LabSettingsViewModel.TAG, "setBehaviorAwareEnable skipped because ability is not supported");
                return Unit.INSTANCE;
            L14:
                r102 = 0;
                r105 = this;
                r104 = -1;
                goto L16
            }
        }

        public C111581(LabSettingsViewModel r100, boolean r101, Continuation<? super C111581> r102) {
            this.this$0 = r100;
            this.$isEnabled = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111581(this.this$0, this.$isEnabled, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111581) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoroutineDispatcher r103 = Dispatchers.getIO();
            C42291 r104 = new C42291(this.this$0, this.$isEnabled, null);
            this.label = 1;
            if (BuildersKt.withContext(r103, r104, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setDataSavingEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setDataSavingEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111591 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C111591(Continuation<? super C111591> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111591(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111591) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L7;
            ResultKt.throwOnFailure(r100);
            DoraP2pRtcSwitchSync.d();
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setNaturalInteractionBgmEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setNaturalInteractionBgmEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111601 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111601(LabSettingsViewModel r100, boolean r101, Continuation<? super C111601> r102) {
            this.this$0 = r100;
            this.$isEnabled = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111601(this.this$0, this.$isEnabled, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111601) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L14;
            ResultKt.throwOnFailure(r210);
            if (LabSettingsViewModel.access$isNaturalWakeupSettingBlocked(this.this$0) == false) goto L8;
            g49.d.e(LabSettingsViewModel.TAG, "setNaturalInteractionBgmEnable: in wakeup, can not operate");
            return Unit.INSTANCE;
        L8:
            b0 r100 = b0.f338123a;
            boolean r101 = this.$isEnabled;
            r100.getClass();
            b0.j().storeBoolean("dora_natural_interaction_bgm_enabled", r101);
            boolean r102 = b0.w();
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L11;
            Object r103 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r103, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            c.b r104 = (c.b) r103;
            LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).setValue(c.b.a(r104, false, false, false, false, this.$isEnabled, false, false, false, false, false, false, false, false, 4194175));
        L11:
            DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "dora_natural_wakeup_settings_change", MapsKt.plus(x0.a(r102), MapsKt.mapOf(TuplesKt.to("dora_g_natural_setting_bgm_switch", x0.b(this.$isEnabled)))), false, 12);
            return Unit.INSTANCE;
        L14:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setQuickContinuousConversationEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setQuickContinuousConversationEnable$1", f = "LabSettingsViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_SKIP_BUFFER_LIMIT, MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_CHECK_PACKET_CORRUPT}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111611 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setQuickContinuousConversationEnable$1$1, reason: invalid class name and collision with other inner class name */
        @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
        @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setQuickContinuousConversationEnable$1$1", f = "LabSettingsViewModel.kt", i = {0}, l = {324, 342}, m = "invokeSuspend", n = {"ret"}, s = {"L$0"})
        public static final class C42301 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
            final /* synthetic */ boolean $isEnabled;
            int I$0;
            int I$1;
            Object L$0;
            boolean Z$0;
            int label;
            final /* synthetic */ LabSettingsViewModel this$0;

            public C42301(boolean r100, LabSettingsViewModel r101, Continuation<? super C42301> r102) {
                this.$isEnabled = r100;
                this.this$0 = r101;
                super(2, r102);
            }

            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
                return new C42301(this.$isEnabled, this.this$0, r101);
            }

            @Override // kotlin.jvm.functions.Function2
            public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
                return invoke2(r100, r101);
            }

            /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
            public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
                return ((C42301) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
            }

            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:13:0x0047 -> B:18:0x005d). Please report as a decompilation issue!!! */
            /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:16:0x005a -> B:18:0x005d). Please report as a decompilation issue!!! */
            @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
            public final Object invokeSuspend(Object r210) {
                Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
                int r101 = this.label;
                if (r101 == 0) goto L10;
                if (r101 == 1) goto L9;
                if (r101 != 2) goto L8;
                ResultKt.throwOnFailure(r210);
            L29:
                return Unit.INSTANCE;
            L8:
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            L9:
                int r102 = this.I$1;
                boolean r103 = this.Z$0;
                int r104 = this.I$0;
                Ref.IntRef r105 = (Ref.IntRef) this.L$0;
                ResultKt.throwOnFailure(r210);
                C42301 r106 = this;
            L18:
                r102 = r102 + 1;
            L11:
                if (r102 >= r104) goto L19;
                int r110 = kj4.a.g().v(r103);
                r105.element = r110;
                if (r110 == 0) goto L18;
                r106.L$0 = r105;
                r106.I$0 = r104;
                r106.Z$0 = r103;
                r106.I$1 = r102;
                r106.label = 1;
                if (DelayKt.delay(100, r106) != r100) goto L18;
                return r100;
            L19:
                g49.d.d(LabSettingsViewModel.TAG, "setQuickContinuousConversationEnable: " + r106.$isEnabled + ", ret = " + r105.element);
                if (r105.element != 0) goto L25;
                b0 r107 = b0.f338123a;
                boolean r108 = r106.$isEnabled;
                r107.getClass();
                b0.M(r108);
                boolean r109 = b0.j().getBoolean("dora_natural_interaction_bgm_enabled", false);
                if ((LabSettingsViewModel.access$get_envStateFlow$p(r106.this$0).getValue() instanceof c.b) == false) goto L24;
                z0 r111 = LabSettingsViewModel.access$get_envStateFlow$p(r106.this$0);
                Object r112 = LabSettingsViewModel.access$get_envStateFlow$p(r106.this$0).getValue();
                Intrinsics.checkNotNull(r112, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
                r111.setValue(c.b.a((c.b) r112, false, false, false, r106.$isEnabled, false, false, false, false, false, false, false, false, false, 4194239));
            L24:
                DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "dora_natural_wakeup_settings_change", MapsKt.plus(x0.a(r106.$isEnabled), MapsKt.mapOf(TuplesKt.to("dora_g_natural_setting_bgm_switch", x0.b(r109)))), false, 12);
                goto L29
            L25:
                MutableSharedFlow r113 = LabSettingsViewModel.access$get_envActionSharedFlow$p(r106.this$0);
                com.larus.dora.impl.device.settings.lab.b.c r114 = new com.larus.dora.impl.device.settings.lab.b.c(R.string.larus_dora_toast_update_failed_cn);
                r106.L$0 = null;
                r106.label = 2;
                if (r113.emit(r114, r106) != r100) goto L29;
                return r100;
            L10:
                ResultKt.throwOnFailure(r210);
                Ref.IntRef r115 = new Ref.IntRef();
                r103 = this.$isEnabled;
                r104 = 3;
                r106 = this;
                r105 = r115;
                r102 = 0;
                goto L11
            }
        }

        public C111611(LabSettingsViewModel r100, boolean r101, Continuation<? super C111611> r102) {
            this.this$0 = r100;
            this.$isEnabled = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111611(this.this$0, this.$isEnabled, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111611) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L21:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L16:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r100);
            if (LabSettingsViewModel.access$isNaturalWakeupSettingBlocked(this.this$0) == false) goto L17;
            g49.d.e(LabSettingsViewModel.TAG, "setQuickContinuousConversationEnable: in wakeup, can not operate");
            MutableSharedFlow r103 = LabSettingsViewModel.access$get_envActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.settings.lab.b.c r104 = new com.larus.dora.impl.device.settings.lab.b.c(R.string.larus_dora_toast_can_not_operate_in_progress_cn);
            this.label = 1;
            if (r103.emit(r104, this) != r101) goto L16;
            return r101;
        L17:
            CoroutineDispatcher r105 = Dispatchers.getIO();
            C42301 r106 = new C42301(this.$isEnabled, this.this$0, null);
            this.label = 2;
            if (BuildersKt.withContext(r105, r106, this) != r101) goto L21;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRTCTransportMode$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRTCTransportMode$1", f = "LabSettingsViewModel.kt", i = {0, 1, 2}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_LIVE_SDK_DNS_IP, 355, 356}, m = "invokeSuspend", n = {"$this$withLock_u24default$iv", "$this$withLock_u24default$iv", "$this$withLock_u24default$iv"}, s = {"L$0", "L$0", "L$0"})
    public static final class C111621 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ RTCTransportMode $mode;
        Object L$0;
        Object L$1;
        Object L$2;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111621(LabSettingsViewModel r100, RTCTransportMode r101, Continuation<? super C111621> r102) {
            this.this$0 = r100;
            this.$mode = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111621(this.this$0, this.$mode, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111621) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v3 */
        /* JADX WARN: Type inference failed for: r0v4 */
        /* JADX WARN: Type inference failed for: r0v5, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r0v9 */
        /* JADX WARN: Type inference failed for: r4v1 */
        /* JADX WARN: Type inference failed for: r4v11, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r4v2, types: [kotlinx.coroutines.sync.a] */
        /* JADX WARN: Type inference failed for: r4v6 */
        /* JADX WARN: Type inference failed for: r9v14 */
        /* JADX WARN: Type inference failed for: r9v17 */
        /* JADX WARN: Type inference failed for: r9v7, types: [java.lang.Object] */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L20;
            if (r102 == 1) goto L19;
            if (r102 == 2) goto L14;
            if (r102 != 3) goto L13;
            kotlinx.coroutines.sync.a r103 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L10
            ?? r104 = r103;
        L35:
            DoraP2pRtcSwitchSync.b();     // Catch: Throwable -> L38
            Unit r105 = Unit.INSTANCE;     // Catch: Throwable -> L38
            r104.unlock(null);
            return Unit.INSTANCE;
        L10:
            Throwable th10 = th;
        L42:
            DoraP2pRtcSwitchSync.b();     // Catch: Throwable -> L38
            throw th10;     // Catch: Throwable -> L38
        L13:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L14:
            LabSettingsViewModel r106 = (LabSettingsViewModel) this.L$2;
            RTCTransportMode r107 = (RTCTransportMode) this.L$1;
            ?? r108 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r100);     // Catch: Throwable -> L17
            ?? r109 = r108;
        L55:
            CoroutineDispatcher r110 = Dispatchers.getIO();     // Catch: Throwable -> L40
            LabSettingsViewModel$setRTCTransportMode$1$1$1 r111 = new LabSettingsViewModel$setRTCTransportMode$1$1$1(r107, r106, null);     // Catch: Throwable -> L40
            this.L$0 = r109;     // Catch: Throwable -> L40
            this.L$1 = null;     // Catch: Throwable -> L40
            this.L$2 = null;     // Catch: Throwable -> L40
            this.label = 3;     // Catch: Throwable -> L40
            if (BuildersKt.withContext(r110, r111, this) != r101) goto L34;
            return r101;
        L34:
            r104 = r109;
        L40:
            th = move-exception;
            th10 = th;
        L17:
            th = th;
        L46:
            r108.unlock(null);
            throw th;
        L19:
            r106 = (LabSettingsViewModel) this.L$2;
            RTCTransportMode r112 = (RTCTransportMode) this.L$1;
            kotlinx.coroutines.sync.a r113 = (kotlinx.coroutines.sync.a) this.L$0;
            ResultKt.throwOnFailure(r100);
            kotlinx.coroutines.sync.a r114 = r113;
        L48:
            CoroutineScope r115 = DoraP2pRtcSwitchSync.f332286a;     // Catch: Throwable -> L44
            this.L$0 = r114;     // Catch: Throwable -> L44
            this.L$1 = r112;     // Catch: Throwable -> L44
            this.L$2 = r106;     // Catch: Throwable -> L44
            this.label = 2;     // Catch: Throwable -> L44
            Object r116 = DoraP2pRtcSwitchSync.f332288c.a(null, this);     // Catch: Throwable -> L44
            if (r116 == IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L28;
            r116 = Unit.INSTANCE;     // Catch: Throwable -> L44
        L28:
            if (r116 != r101) goto L30;
            return r101;
        L30:
            r107 = r112;
            r109 = r114;
        L44:
            th = move-exception;
            r108 = r114;
            th = th;
            goto L46
        L20:
            ResultKt.throwOnFailure(r100);
            kotlinx.coroutines.sync.a r117 = LabSettingsViewModel.access$getRtcTransportModeMutex$p(this.this$0);
            RTCTransportMode r118 = this.$mode;
            LabSettingsViewModel r119 = this.this$0;
            this.L$0 = r117;
            this.L$1 = r118;
            this.L$2 = r119;
            this.label = 1;
            if (r117.a(null, this) != r101) goto L23;
            return r101;
        L23:
            r112 = r118;
            r106 = r119;
            r114 = r117;
        L38:
            th = th;
            r108 = r101;
            goto L46
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRtosPlayerEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$setRtosPlayerEnabled$1", f = "LabSettingsViewModel.kt", i = {}, l = {662}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111631 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isEnabled;
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111631(boolean r100, LabSettingsViewModel r101, Continuation<? super C111631> r102) {
            this.$isEnabled = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111631(this.$isEnabled, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111631) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r210);
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            kj4.a.g().setRtosPlayerSwitchState(this.$isEnabled);
            Object r102 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            c.b r103 = (c.b) r102;
            z0 r104 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            c.b r105 = c.b.a(r103, false, false, false, false, false, false, this.$isEnabled, false, false, false, false, false, false, 4193279);
            this.label = 1;
            if (r104.emit(r105, this) != r100) goto L12;
            return r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$syncBluetoothRTCVideoCallSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel", f = "LabSettingsViewModel.kt", i = {0, 0}, l = {521}, m = "syncBluetoothRTCVideoCallSwitch", n = {"ret", "isEnabled"}, s = {"L$0", "Z$0"})
    public static final class C111641 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111641(LabSettingsViewModel r100, Continuation<? super C111641> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return LabSettingsViewModel.access$syncBluetoothRTCVideoCallSwitch(this.this$0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$syncEffectiveP2PRTCVideoCallSwitch$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel", f = "LabSettingsViewModel.kt", i = {0, 0}, l = {538}, m = "syncEffectiveP2PRTCVideoCallSwitch", n = {"ret", "isEnabled"}, s = {"L$0", "Z$0"})
    public static final class C111651 extends ContinuationImpl {
        int I$0;
        int I$1;
        Object L$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111651(LabSettingsViewModel r100, Continuation<? super C111651> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return LabSettingsViewModel.access$syncEffectiveP2PRTCVideoCallSwitch(this.this$0, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$updateCacheAndUIState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.settings.lab.LabSettingsViewModel$updateCacheAndUIState$1", f = "LabSettingsViewModel.kt", i = {}, l = {683}, m = "invokeSuspend", n = {}, s = {})
    public static final class C111661 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ LabSettingsViewModel this$0;

        public C111661(LabSettingsViewModel r100, Continuation<? super C111661> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C111661(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C111661) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r210);
        L25:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r210);
            int r102 = yj4.g.f568093a;
            yj4.f r103 = yj4.f.a.f568092a;
            r103.a(5000);
            int r104 = r103.f568090f;
            g49.d.d(LabSettingsViewModel.TAG, "updateCacheAndUIState, buttonMode:" + r104);
            if (r104 != (-1)) goto L13;
            g49.d.d(LabSettingsViewModel.TAG, "updateCacheAndUIState, invalid buttonMode, skip update cache and ui state");
            return Unit.INSTANCE;
        L13:
            if ((LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue() instanceof c.b) == false) goto L23;
            Object r105 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r105, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
            c.b r106 = (c.b) r105;
            if (r104 == 1) goto L17;
            boolean r110 = true;
        L19:
            if (r106.f334578j == r110) goto L25;
            b0.f338123a.getClass();
            b0.j().storeInt("dora_g_button_mode", r104);
            z0 r107 = LabSettingsViewModel.access$get_envStateFlow$p(this.this$0);
            c.b r108 = c.b.a(r106, false, false, false, false, false, r110, false, false, false, false, false, false, false, 4193791);
            this.label = 1;
            if (r107.emit(r108, this) != r100) goto L25;
            return r100;
        L17:
            r110 = false;
            goto L19
        L23:
            g49.d.d(LabSettingsViewModel.TAG, "updateCacheAndUIState, _envStateFlow is not success");
            goto L25
        }
    }

    static {
        Companion = new b();
    }

    public static /* synthetic */ IDoraPageConfig Mo() {
        return doraPageConfig_delegate$lambda$1();
    }

    private final boolean isRTCSwitchSyncAccepted(int r100) {
        if (r100 != 0) goto L4;
    L7:
        return true;
    L4:
        if (r100 == (-3)) goto L7;
        return false;
    }

    private final int toToggleValue(boolean r100) {
        return r100 ? 1 : 0;
    }

    public static /* synthetic */ IDoraService yo() {
        return doraServiceImpl_delegate$lambda$0();
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$1() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private static final IDoraService doraServiceImpl_delegate$lambda$0() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    private final IDoraService getDoraServiceImpl() {
        return (IDoraService) this.doraServiceImpl$delegate.getValue();
    }

    private final boolean isNaturalWakeupSettingBlocked() {
        Object r100 = ServiceManager.get().getService(IDoraService.class);
        if ((r100 instanceof DoraServiceImpl) == false) goto L5;
        DoraServiceImpl r101 = (DoraServiceImpl) r100;
    L7:
        if (r101 != null) goto L9;
    L11:
        boolean r102 = false;
    L12:
        if (r102 == true) goto L14;
        return false;
    L14:
        SessionService r103 = r101.f331919c;
        if (r103.f337985c == 11) goto L17;
        return true;
    L17:
        if (r103.f337986d == 7) goto L22;
        return false;
    L22:
        return true;
    L9:
        if (r101.A1() != true) goto L11;
        r102 = true;
        goto L12
    L5:
        r101 = null;
        goto L7
    }

    private final boolean isSupportBehaviorAware() {
        sk4.e r100 = o0.f332223a;
        return o0.c("behaviorAware");
    }

    private final boolean takeBehaviorAwareToggle() {
        zj4.a r100 = zj4.a.C8468a.f572461a;
        if (r100 == null) goto L5;
        Integer r101 = Integer.valueOf(r100.g());
    L6:
        if (r101 == null) goto L11;
        boolean r102 = true;
        if (r101.intValue() != 1) goto L11;
    L12:
        g49.d.d(TAG, "takeBehaviorAwareToggle: toggle=" + r101 + ", isEnabled=" + r102);
        return r102;
    L11:
        r102 = false;
        goto L12
    L5:
        r101 = null;
        goto L6
    }

    public final d59.f getFeatureConfig() {
        return this.featureConfigRepository.a();
    }

    public final boolean isDataSavingEntranceVisible() {
        DoraWifiLinkWrapper.f332292a.getClass();
        return DoraWifiLinkWrapper.i();
    }

    public LabSettingsViewModel() {
        StateFlowImpl r100 = j1.a(c.a.f334568a);
        this._envStateFlow = r100;
        this.envStateFlow = r100;
        MutableSharedFlow<com.larus.dora.impl.device.settings.lab.b> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._envActionSharedFlow = r101;
        this.envActionSharedFlow = r101;
        this.ENV_OB_UVI_SUCCESS = 2;
        this.ENV_OB_TX_TIMEOUT = -1;
        this.ENV_OB_UVI_FAILED_WITH_REASON = CollectionsKt.listOf(new Integer[]{-1, 9, 10, 12, 13, 14, 15});
        this.doraServiceImpl$delegate = LazyKt.lazy(new r());
        this.doraPageConfig$delegate = LazyKt.lazy(new s());
        this.featureConfigRepository = new g59.c();
        this.rtcTransportModeMutex = kotlinx.coroutines.sync.b.a();
        initData();
        kj4.a.g().registerDoraLinkCallback(new a(this));
        fetchData();
        updateCacheAndUIState();
    }

    private final boolean curEnvObserveState() {
        IDoraService r100 = getDoraServiceImpl();
        if (r100 == null) goto L20;
        SessionService r101 = r100.d();
        if (r101 == null) goto L20;
        if (r101.f337985c == 11) goto L10;
        return false;
    L10:
        int r102 = r101.f337986d;
        if (r102 != 2) goto L13;
        return true;
    L13:
        if (r102 != 7) goto L15;
        return true;
    L15:
        if (r102 == 8) goto L22;
        return false;
    L22:
        return true;
    L20:
        return false;
    }

    private final void fetchData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(null), 2, null);
    }

    private final void initData() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C111551(this, null), 2, null);
    }

    private final void updateCacheAndUIState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C111661(this, null), 2, null);
    }

    public final void forceUpdateEnable() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C111541(this, null), 2, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        f49.b r100 = this.doraVoiceCallback;
        if (r100 == null) goto L10;
        IDoraService r101 = getDoraServiceImpl();
        if (r101 == null) goto L11;
        SessionService r102 = r101.d();
        if (r102 == null) goto L12;
        r102.x(r100);
        return;
    L12:
        return;
    L11:
        return;
    }

    public final void onVoiceWakeUpState() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C111561(this, null), 2, null);
    }

    public final int getENV_OB_TX_TIMEOUT() {
        return this.ENV_OB_TX_TIMEOUT;
    }

    public final List<Integer> getENV_OB_UVI_FAILED_WITH_REASON() {
        return this.ENV_OB_UVI_FAILED_WITH_REASON;
    }

    public final int getENV_OB_UVI_SUCCESS() {
        return this.ENV_OB_UVI_SUCCESS;
    }

    public final d1<com.larus.dora.impl.device.settings.lab.b> getEnvActionSharedFlow() {
        return this.envActionSharedFlow;
    }

    public final i1<c> getEnvStateFlow() {
        return this.envStateFlow;
    }

    public static final /* synthetic */ boolean access$curEnvObserveState(LabSettingsViewModel r100) {
        return r100.curEnvObserveState();
    }

    public static final /* synthetic */ IDoraPageConfig access$getDoraPageConfig(LabSettingsViewModel r100) {
        return r100.getDoraPageConfig();
    }

    public static final /* synthetic */ IDoraService access$getDoraServiceImpl(LabSettingsViewModel r100) {
        return r100.getDoraServiceImpl();
    }

    public static final /* synthetic */ kotlinx.coroutines.sync.a access$getRtcTransportModeMutex$p(LabSettingsViewModel r100) {
        return r100.rtcTransportModeMutex;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_envActionSharedFlow$p(LabSettingsViewModel r100) {
        return r100._envActionSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_envStateFlow$p(LabSettingsViewModel r100) {
        return r100._envStateFlow;
    }

    public static final /* synthetic */ void access$initData(LabSettingsViewModel r100) {
        r100.initData();
    }

    public static final /* synthetic */ boolean access$isNaturalWakeupSettingBlocked(LabSettingsViewModel r100) {
        return r100.isNaturalWakeupSettingBlocked();
    }

    public static final /* synthetic */ boolean access$isSupportBehaviorAware(LabSettingsViewModel r100) {
        return r100.isSupportBehaviorAware();
    }

    public static final /* synthetic */ boolean access$takeBehaviorAwareToggle(LabSettingsViewModel r100) {
        return r100.takeBehaviorAwareToggle();
    }

    public final void setAllowDoubaoViewImagesEnable(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C111571(r100, this, null), 2, null);
    }

    public final void setBehaviorAwareEnable(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C111581(this, r100, null), 3, null);
    }

    public final void setDataSavingEnable(boolean r110) {
        String r100 = ILoginService.f286097a.getAccountInfo().f531530c;
        if (r100 != null) goto L5;
        r100 = "";
    L5:
        b0.f338123a.getClass();
        Intrinsics.checkNotNullParameter(r100, "uid");
        b0.j().storeBoolean("dora_enable_data_saving_".concat(r100), r110);
        g49.d.d(TAG, "setDataSavingEnable: " + r110);
        if ((this._envStateFlow.getValue() instanceof c.b) == false) goto L8;
        c r101 = this._envStateFlow.getValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
        this._envStateFlow.setValue(c.b.a((c.b) r101, false, false, false, false, false, false, false, false, false, false, false, false, r110, 2097151));
    L8:
        DoraP2pRtcSwitchSync.e("set_data_saving");
        IDoraService.B1.getClass();
        BuildersKt.launch$default(IDoraService.b.f331727b, null, null, new C111591(null), 3, null);
    }

    public final void setNaturalInteractionBgmEnable(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C111601(this, r100, null), 2, null);
    }

    public final void setQuickContinuousConversationEnable(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C111611(this, r100, null), 3, null);
    }

    public final void setRTCTransportMode(RTCTransportMode r100) {
        Intrinsics.checkNotNullParameter(r100, "mode");
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), null, null, new C111621(this, r100, null), 3, null);
    }

    public final void setRtosPlayerEnabled(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C111631(r100, this, null), 2, null);
    }

    public static final /* synthetic */ boolean access$isRTCSwitchSyncAccepted(LabSettingsViewModel r100, int r101) {
        return r100.isRTCSwitchSyncAccepted(r101);
    }

    public static final /* synthetic */ void access$setDoraVoiceCallback$p(LabSettingsViewModel r100, f49.b r101) {
        r100.doraVoiceCallback = r101;
    }

    public static final /* synthetic */ int access$toToggleValue(LabSettingsViewModel r100, boolean r101) {
        return r100.toToggleValue(r101);
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:21:0x006c -> B:23:0x006f). Please report as a decompilation issue!!! */
    private final Object syncBluetoothRTCVideoCallSwitch(boolean r100, Continuation<? super Integer> r110) {
        if ((r110 instanceof C111641) == false) goto L7;
        C111641 r101 = (C111641) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r101.I$1;
        int r106 = r101.I$0;
        boolean r107 = r101.Z$0;
        Ref.IntRef r108 = (Ref.IntRef) r101.L$0;
        ResultKt.throwOnFailure(r111);
        boolean r112 = r107;
    L23:
        r105 = r105 + 1;
    L15:
        if (r105 >= r106) goto L25;
        int r109 = kj4.a.g().w(r112);
        r108.element = r109;
        if (r109 == 0) goto L19;
        r101.L$0 = r108;
        r101.Z$0 = r112;
        r101.I$0 = r106;
        r101.I$1 = r105;
        r101.label = 1;
        if (DelayKt.delay(100, r101) != r103) goto L23;
        return r103;
    L19:
        return Boxing.boxInt(r109);
    L25:
        return Boxing.boxInt(r108.element);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r106 = 3;
        r108 = new Ref.IntRef();
        r112 = r100;
        r105 = 0;
    L7:
        r101 = new C111641(this, r110);
        goto L8
    }

    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:22:0x0092 -> B:24:0x0095). Please report as a decompilation issue!!! */
    private final Object syncEffectiveP2PRTCVideoCallSwitch(boolean r100, Continuation<? super Integer> r110) {
        if ((r110 instanceof C111651) == false) goto L7;
        C111651 r101 = (C111651) r110;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r111 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        int r105 = r101.I$1;
        int r106 = r101.I$0;
        boolean r107 = r101.Z$0;
        Ref.IntRef r108 = (Ref.IntRef) r101.L$0;
        ResultKt.throwOnFailure(r111);
        boolean r112 = r107;
    L24:
        r105 = r105 + 1;
    L16:
        if (r105 >= r106) goto L26;
        int r109 = DoraP2pRtcSwitchSync.g(r112, null);
        r108.element = r109;
        if (r109 != 0) goto L21;
        g49.d.d(TAG, "syncEffectiveP2PRTCVideoCallSwitch success: enabled=" + r112 + ", ret=" + r108.element + ", attempt=" + (r105 + 1));
        return Boxing.boxInt(r108.element);
    L21:
        r101.L$0 = r108;
        r101.Z$0 = r112;
        r101.I$0 = r106;
        r101.I$1 = r105;
        r101.label = 1;
        if (DelayKt.delay(100, r101) != r103) goto L24;
        return r103;
    L26:
        if (r108.element != (-3)) goto L28;
        g49.d.e(TAG, "syncEffectiveP2PRTCVideoCallSwitch timeout: enabled=" + r112 + ", result unconfirmed");
    L30:
        return Boxing.boxInt(r108.element);
    L28:
        g49.d.b(TAG, "syncEffectiveP2PRTCVideoCallSwitch failed: enabled=" + r112 + ", ret=" + r108.element);
        goto L30
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        r106 = 3;
        r108 = new Ref.IntRef();
        r112 = r100;
        r105 = 0;
    L7:
        r101 = new C111651(this, r110);
        goto L8
    }

    public static final /* synthetic */ Object access$syncBluetoothRTCVideoCallSwitch(LabSettingsViewModel r100, boolean r101, Continuation r102) {
        return r100.syncBluetoothRTCVideoCallSwitch(r101, r102);
    }

    public static final /* synthetic */ Object access$syncEffectiveP2PRTCVideoCallSwitch(LabSettingsViewModel r100, boolean r101, Continuation r102) {
        return r100.syncEffectiveP2PRTCVideoCallSwitch(r101, r102);
    }

    private final void updateRTCTransportLocalState(String r210, boolean r211, boolean r212) {
        b0.f338123a.getClass();
        Intrinsics.checkNotNullParameter(r210, "uid");
        b0.j().storeBoolean("dora_enable_bluetooth_rtc_" + r210, r211);
        Intrinsics.checkNotNullParameter(r210, "uid");
        b0.j().storeBoolean("dora_enable_p2p_rtc_".concat(r210), r212);
        if ((this._envStateFlow.getValue() instanceof c.b) == false) goto L6;
        z0<c> r100 = this._envStateFlow;
        c r101 = r100.getValue();
        Intrinsics.checkNotNull(r101, "null cannot be cast to non-null type com.larus.dora.impl.device.settings.lab.LabEnvSettings.Success");
        r100.setValue(c.b.a((c.b) r101, false, false, false, false, false, false, false, r211, r212, false, false, false, false, 4182015));
        return;
    }

    public static final /* synthetic */ void access$updateRTCTransportLocalState(LabSettingsViewModel r100, String r101, boolean r102, boolean r103) {
        r100.updateRTCTransportLocalState(r101, r102, r103);
    }
}
