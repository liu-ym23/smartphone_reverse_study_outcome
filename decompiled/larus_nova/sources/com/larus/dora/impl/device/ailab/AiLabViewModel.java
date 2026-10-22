package com.larus.dora.impl.device.ailab;

import android.app.Application;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelKt;
import com.bytedance.dora.annotation.ProductNameType;
import com.bytedance.dora.device.DoraDevice;
import com.bytedance.dora.voice.ProtocolAbility;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.DoraBuryPointManager;
import com.larus.dora.impl.core.DoraAdapterExtKt;
import com.larus.dora.impl.core.DoraUserManager;
import com.larus.dora.impl.core.o0;
import com.larus.dora.impl.core.x0;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeyword;
import com.larus.dora.impl.device.ailab.keywords.DoraWakeupKeywordsHandler;
import com.larus.dora.impl.network.DoraNetworkApi;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.util.b0;
import com.larus.dora.impl.util.t0;
import com.larus.nova.R;
import com.larus.utils.j0;
import com.mammon.audiosdk.SAMICore;
import com.mammon.audiosdk.enums.SAMICorePropertyId;
import com.mammon.audiosdk.structures.SAMICoreProperty;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.List;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Deferred;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.Flow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.c1;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.g1;
import kotlinx.coroutines.flow.i1;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.flow.z0;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u0000\u0087\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\t*\u0001,\u0018\u0000 R2\u00020\u0001:\u0001RB\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\b\u00102\u001a\u000203H\u0014J\u0016\u00104\u001a\u0002052\u0006\u00106\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u00107J\u0006\u00108\u001a\u000203J\u0006\u00109\u001a\u00020\u0013J\f\u0010:\u001a\b\u0012\u0004\u0012\u00020\u00130;J\u000e\u0010<\u001a\u0002032\u0006\u00106\u001a\u00020\u0013J\u0010\u0010=\u001a\u0002032\b\u0010>\u001a\u0004\u0018\u00010$J\u000e\u0010?\u001a\u0002032\u0006\u0010@\u001a\u00020\u0013J\u000e\u0010A\u001a\u0002032\u0006\u0010@\u001a\u00020\u0013J\u000e\u0010B\u001a\u0002032\u0006\u0010@\u001a\u00020\u0013J\b\u0010C\u001a\u000203H\u0002J\u001e\u0010D\u001a\u00020\u00132\u0006\u0010E\u001a\u00020$2\u0006\u0010F\u001a\u00020GH\u0082@¢\u0006\u0002\u0010HJ\f\u0010I\u001a\u000200*\u00020JH\u0002J\u0016\u0010K\u001a\u0002032\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020\u0013J\u0016\u0010N\u001a\u0002052\u0006\u0010O\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u00107J\u001e\u0010P\u001a\u00020\u00132\u0006\u0010L\u001a\u00020$2\u0006\u0010M\u001a\u00020\u0013H\u0086@¢\u0006\u0002\u0010QR\u0014\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\u00060\b¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\r0\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\fX\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0012\u0010\u0016\u001a\u0004\u0018\u00010\u0013X\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u0017R\u0016\u0010\u0018\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0019\u0010\u001a\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00190\b¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\nR\u0014\u0010\u001c\u001a\b\u0012\u0004\u0012\u00020\u00130\u0005X\u0082\u0004¢\u0006\u0002\n\u0000R\u0017\u0010\u001d\u001a\b\u0012\u0004\u0012\u00020\u00130\b¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\nR\u0011\u0010\u001f\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\u001f\u0010 R\u0011\u0010!\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b!\u0010 R\u0011\u0010\"\u001a\u00020\u00138F¢\u0006\u0006\u001a\u0004\b\"\u0010 R\u0010\u0010#\u001a\u0004\u0018\u00010$X\u0082\u000e¢\u0006\u0002\n\u0000R\u001d\u0010%\u001a\u0004\u0018\u00010&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b)\u0010*\u001a\u0004\b'\u0010(R\u0010\u0010+\u001a\u00020,X\u0082\u0004¢\u0006\u0004\n\u0002\u0010-R\u001d\u0010.\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u0002000/0\b¢\u0006\b\n\u0000\u001a\u0004\b1\u0010\n¨\u0006S"}, d2 = {"Lcom/larus/dora/impl/device/ailab/AiLabViewModel;", "Landroidx/lifecycle/ViewModel;", "<init>", "()V", "_deviceStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/larus/dora/impl/device/ailab/AiLabState;", "deviceStateFlow", "Lkotlinx/coroutines/flow/StateFlow;", "getDeviceStateFlow", "()Lkotlinx/coroutines/flow/StateFlow;", "_aiLabActionSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/larus/dora/impl/device/ailab/AiLabAction;", "aiLabActionSharedFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "getAiLabActionSharedFlow", "()Lkotlinx/coroutines/flow/SharedFlow;", "_updateMultiUserModeFlow", "", "updateMultiUserModeFlow", "getUpdateMultiUserModeFlow", "_isSupportGestureWakeupContinuousDialogue", "Ljava/lang/Boolean;", "_abilityStateFlow", "Lcom/larus/dora/impl/device/ailab/AiLabAbility;", "abilityStateFlow", "getAbilityStateFlow", "_budsQuickContinuousConversationSwitchStateFlow", "budsQuickContinuousConversationSwitchStateFlow", "getBudsQuickContinuousConversationSwitchStateFlow", "isDoreE", "()Z", "isDoraG", "isDoraLite", "mCurrentDoraDeviceMac", "", "doraPageConfig", "Lcom/larus/dora/api/config/IDoraPageConfig;", "getDoraPageConfig", "()Lcom/larus/dora/api/config/IDoraPageConfig;", "doraPageConfig$delegate", "Lkotlin/Lazy;", "doraLinkCallback", "com/larus/dora/impl/device/ailab/AiLabViewModel$doraLinkCallback$1", "Lcom/larus/dora/impl/device/ailab/AiLabViewModel$doraLinkCallback$1;", "keywordsStateFlow", "", "Lcom/larus/dora/impl/device/ailab/AiLabKeyword;", "getKeywordsStateFlow", "onCleared", "", "setVoiceWakeEnable", "", "enable", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "load", "isMultiUserModeEnabled", "getMultiUserModeStateFlow", "Lkotlinx/coroutines/flow/Flow;", "updateMultiUserModeState", "updateCurrentDoraDeviceMac", "mac", "updatePrecaptureUploadEnable", "isChecked", "updateConvVisualIntentSoundEnable", "updateConvStartEndSoundEnable", "fetchDeviceInfo", "requestDeviceSyncInfo", "key", "value", "", "(Ljava/lang/String;Ljava/lang/Object;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toAiLabKeyword", "Lcom/larus/dora/impl/device/ailab/keywords/DoraWakeupKeyword;", "updateKeyword", "keyword", "isSelected", "updateNaturalWakeupEnabled", "enabled", "selectKeywordWakeup", "(Ljava/lang/String;ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AiLabViewModel extends ViewModel {
    public static final a Companion = null;
    private static final String TAG = "AiLabViewModel";
    private z0<com.larus.dora.impl.device.ailab.a> _abilityStateFlow;
    private final MutableSharedFlow<com.larus.dora.impl.device.ailab.b> _aiLabActionSharedFlow;
    private final z0<Boolean> _budsQuickContinuousConversationSwitchStateFlow;
    private final z0<u> _deviceStateFlow;
    private Boolean _isSupportGestureWakeupContinuousDialogue;
    private final MutableSharedFlow<Boolean> _updateMultiUserModeFlow;
    private final i1<com.larus.dora.impl.device.ailab.a> abilityStateFlow;
    private final d1<com.larus.dora.impl.device.ailab.b> aiLabActionSharedFlow;
    private final i1<Boolean> budsQuickContinuousConversationSwitchStateFlow;
    private final i1<u> deviceStateFlow;
    private final b doraLinkCallback;
    private final Lazy doraPageConfig$delegate;
    private final i1<List<t>> keywordsStateFlow;
    private volatile String mCurrentDoraDeviceMac;
    private final d1<Boolean> updateMultiUserModeFlow;

    public static final class a {
        public a() {
        }
    }

    public static final class b extends t0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ AiLabViewModel f333521a;

        public b(AiLabViewModel r100) {
            this.f333521a = r100;
        }

        @Override // com.larus.dora.impl.util.t0, com.bytedance.dora.link.IDoraLinkCallback
        public final void onDoraLinkStateChanged(DoraDevice r100, int r101, int r102) {
            super.onDoraLinkStateChanged(r100, r101, r102);
            if (r100 != null) goto L6;
            return;
        L6:
            if (r102 != 2) goto L9;
            this.f333521a.load();
            return;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$fetchDeviceInfo$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$fetchDeviceInfo$1", f = "AiLabViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_BUFFER_THRESHOLD_CONTROL, 314}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        Object L$0;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public AnonymousClass1(AiLabViewModel r100, Continuation<? super AnonymousClass1> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.this$0, r101);
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
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L13;
            if (r101 == 1) goto L12;
            if (r101 != 2) goto L11;
            ResultKt.throwOnFailure(r210);     // Catch: Throwable -> L8
        L48:
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L8
        L49:
            Object r103 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L8
        L54:
            if (Result.m9452exceptionOrNullimpl(r103) == null) goto L58;
            g49.d.d(AiLabViewModel.TAG, "fetch device info failed");
            r103 = Unit.INSTANCE;
        L58:
            if (((Unit) r103) != null) goto L61;
        L59:
            g49.d.d(AiLabViewModel.TAG, "fetch device info failed, device is null");
        L61:
            return Unit.INSTANCE;
        L11:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L12:
            AiLabViewModel r104 = (AiLabViewModel) this.L$0;
            ResultKt.throwOnFailure(r210);
            Object r105 = ((Result) r210).m9458unboximpl();
        L20:
            if (Result.m9456isSuccessimpl(r105) == false) goto L52;
            com.larus.dora.impl.network.h r106 = (com.larus.dora.impl.network.h) r105;     // Catch: Throwable -> L8
            g49.d.d(AiLabViewModel.TAG, "fetch device info: " + r106);     // Catch: Throwable -> L8
            IDoraPageConfig r107 = AiLabViewModel.access$getDoraPageConfig(r104);     // Catch: Throwable -> L8
            r102 = null;
            if (r107 == null) goto L49;
            com.larus.dora.impl.network.g r108 = r106.a();     // Catch: Throwable -> L8
            if (r108 == null) goto L48;
            String r110 = r108.g();     // Catch: Throwable -> L8
            if (r110 == null) goto L36;
            Integer r111 = StringsKt.toIntOrNull(r110);     // Catch: Throwable -> L8
            if (r111 == null) goto L36;
            if (r111.intValue() != 1) goto L33;
            boolean r112 = true;
        L34:
            r107.a("dora_g_config_key_precapture_upload_enable", r112);     // Catch: Throwable -> L8
            goto L36
        L33:
            r112 = false;
        L36:
            if ((AiLabViewModel.access$get_deviceStateFlow$p(r104).getValue() instanceof u.b) == false) goto L48;
            String r109 = r108.g();     // Catch: Throwable -> L8
            if (r109 == null) goto L48;
            Integer r113 = StringsKt.toIntOrNull(r109);     // Catch: Throwable -> L8
            if (r113 == null) goto L48;
            int r114 = r113.intValue();     // Catch: Throwable -> L8
            Object r115 = AiLabViewModel.access$get_deviceStateFlow$p(r104).getValue();     // Catch: Throwable -> L8
            Intrinsics.checkNotNull(r115, "null cannot be cast to non-null type com.larus.dora.impl.device.ailab.AiLabState.V1");     // Catch: Throwable -> L8
            u.b r116 = (u.b) r115;     // Catch: Throwable -> L8
            z0 r117 = AiLabViewModel.access$get_deviceStateFlow$p(r104);     // Catch: Throwable -> L8
            if (r114 != 1) goto L44;
            boolean r118 = true;
        L45:
            u.b r119 = u.b.a(r116, false, r118, false, false, 55);     // Catch: Throwable -> L8
            this.L$0 = null;     // Catch: Throwable -> L8
            this.label = 2;     // Catch: Throwable -> L8
            if (r117.emit(r119, this) != r100) goto L48;
            return r100;
        L44:
            r118 = false;
            goto L45
        L52:
            r103 = Result.m9449constructorimpl(r105);
            goto L54
        L13:
            ResultKt.throwOnFailure(r210);
            DoraDevice r120 = kj4.a.g().c();
            if (r120 == null) goto L59;
            AiLabViewModel r121 = this.this$0;
            DoraNetworkApi r122 = DoraNetworkApi.f336157a;
            List<String> r123 = CollectionsKt.listOf("quick_chat_switch");
            this.L$0 = r121;
            this.label = 1;
            Object r124 = r122.x(r120, r123, this);
            if (r124 != r100) goto L18;
            return r100;
        L18:
            r105 = r124;
            r104 = r121;
        L8:
            th = move-exception;
            Result.Companion r125 = Result.Companion;
            r103 = Result.m9449constructorimpl(ResultKt.createFailure(th));
            goto L54
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$getMultiUserModeStateFlow$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000b\u0010\u0000\u001a\u00020\u0001*\b\u0012\u0004\u0012\u00020\u00030\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/flow/FlowCollector;", ""}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$getMultiUserModeStateFlow$1", f = "AiLabViewModel.kt", i = {0, 1}, l = {219, 220, 222}, m = "invokeSuspend", n = {"$this$flow", "$this$flow"}, s = {"L$0", "L$0"})
    public static final class C110841 extends SuspendLambda implements Function2<FlowCollector<? super Boolean>, Continuation<? super Unit>, Object> {
        private /* synthetic */ Object L$0;
        int label;

        public C110841(Continuation<? super C110841> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C110841 r102 = new C110841(r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(FlowCollector<? super Boolean> r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(FlowCollector<? super Boolean> r100, Continuation<? super Unit> r101) {
            return ((C110841) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L12;
            if (r102 == 1) goto L11;
            if (r102 == 2) goto L10;
            if (r102 != 3) goto L9;
            ResultKt.throwOnFailure(r100);
        L25:
            return Unit.INSTANCE;
        L9:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            FlowCollector r103 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r100);
        L19:
            Pair r104 = (Pair) r100;
            boolean r105 = ((Boolean) r104.component1()).booleanValue();
            boolean r106 = ((Boolean) r104.component2()).booleanValue();
            if (r105 == false) goto L25;
            Boolean r107 = Boxing.boxBoolean(r106);
            this.L$0 = null;
            this.label = 3;
            if (r103.emit(r107, this) != r101) goto L25;
            return r101;
        L11:
            r103 = (FlowCollector) this.L$0;
            ResultKt.throwOnFailure(r100);
        L16:
            DoraUserManager r108 = DoraUserManager.f332169a;
            this.L$0 = r103;
            this.label = 2;
            r100 = r108.c(this);
            if (r100 != r101) goto L19;
            return r101;
        L12:
            ResultKt.throwOnFailure(r100);
            FlowCollector r109 = (FlowCollector) this.L$0;
            DoraUserManager r110 = DoraUserManager.f332169a;
            Boolean r111 = Boxing.boxBoolean(DoraUserManager.b());
            this.L$0 = r109;
            this.label = 1;
            if (r109.emit(r111, this) != r101) goto L15;
            return r101;
        L15:
            r103 = r109;
            goto L16
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$load$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$load$1", f = "AiLabViewModel.kt", i = {0, 0, 1, 1, 1, 1, 1, 1, 1, 2, 4, 4, 4, 4, 5, 5, 5, 5, 5, 6}, l = {141, 148, 160, 172, 175, 193, MediaPlayer.MEDIA_PLAYER_OPTION_SET_ORIGINAL_RETRY, 201}, m = "invokeSuspend", n = {"$this$launch", "device", "$this$launch", "device", "isSupportWakeupGestureUnify", "isSupportWakeupAndVisualSound", "isSupportVisualIntentSound", "isSupportMultiUserModel", "isSupportNaturalWakeup", "voiceWakeEnable", "$this$launch", "device", "voiceWakeEnable", "isSupportDecouplingWakeup", "device", "precaptureUploadEnable", "startEndSoundEnable", "isSupportDecouplingWakeup", "visualIntentSoundEnable", "visualIntentSoundEnable"}, s = {"L$0", "L$1", "L$0", "L$1", "Z$0", "Z$1", "Z$2", "I$0", "I$1", "L$0", "L$0", "L$1", "L$2", "Z$0", "L$0", "L$1", "L$2", "Z$0", "I$0", "I$0"})
    public static final class C110851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int I$0;
        int I$1;
        private /* synthetic */ Object L$0;
        Object L$1;
        Object L$2;
        boolean Z$0;
        boolean Z$1;
        boolean Z$2;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C110851(AiLabViewModel r100, Continuation<? super C110851> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            C110851 r102 = new C110851(this.this$0, r101);
            r102.L$0 = r100;
            return r102;
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110851) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r21v1 */
        /* JADX WARN: Type inference failed for: r3v20 */
        /* JADX WARN: Type inference failed for: r3v21, types: [int] */
        /* JADX WARN: Type inference failed for: r3v33 */
        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r210) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            boolean r101 = true;
            switch(this.label) {
                case 0: goto L15;
                case 1: goto L13;
                case 2: goto L12;
                case 3: goto L11;
                case 4: goto L10;
                case 5: goto L9;
                case 6: goto L8;
                case 7: goto L7;
                case 8: goto L6;
                default: goto L5;
            };
        L6:
            ResultKt.throwOnFailure(r210);
        L115:
            AiLabViewModel.access$fetchDeviceInfo(this.this$0);
        L118:
            return Unit.INSTANCE;
        L7:
            boolean r102 = this.Z$2;
            boolean r103 = this.Z$1;
            int r104 = this.I$1;
            boolean r105 = this.Z$0;
            int r106 = this.I$0;
            ResultKt.throwOnFailure(r210);
            boolean r110 = r102;
            boolean r111 = r103;
            int r112 = r104;
            boolean r113 = r105;
            Object r107 = r210;
        L107:
            boolean r114 = ((Boolean) r107).booleanValue();
            if (r106 == 0) goto L110;
            boolean r115 = true;
        L111:
            Object r108 = new u.b(r113, r112, r111, r110, r114, r115);
        L112:
            z0 r109 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0);
            this.label = 8;
            if (r109.emit(r108, this) != r100) goto L115;
            return r100;
        L110:
            r115 = false;
            goto L111
        L8:
            int r116 = this.I$0;
            boolean r117 = this.Z$0;
            Deferred r118 = (Deferred) this.L$2;
            Boolean r119 = (Boolean) this.L$1;
            DoraDevice r120 = (DoraDevice) this.L$0;
            ResultKt.throwOnFailure(r210);
            Object r121 = r210;
        L103:
            boolean r122 = ((Boolean) r121).booleanValue();
            int r123 = r120.sku;
            boolean r124 = Intrinsics.areEqual(r119, Boxing.boxBoolean(true));
            this.L$0 = null;
            this.L$1 = null;
            this.L$2 = null;
            this.I$0 = r116;
            this.Z$0 = r122;
            this.I$1 = r123;
            this.Z$1 = r117;
            this.Z$2 = r124;
            this.label = 7;
            r107 = r118.await(this);
            if (r107 != r100) goto L106;
            return r100;
        L106:
            r111 = r117;
            r113 = r122;
            r112 = r123;
            r110 = r124;
            r106 = r116;
            goto L107
        L9:
            boolean r125 = this.Z$0;
            Deferred r126 = (Deferred) this.L$2;
            DoraDevice r127 = (DoraDevice) this.L$1;
            CoroutineScope r128 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r210);
            CoroutineScope r129 = r128;
            r120 = r127;
        L91:
            AiLabViewModel r130 = this.this$0;
            Intrinsics.checkNotNullParameter(r120, "<this>");
            AiLabViewModel.access$set_isSupportGestureWakeupContinuousDialogue$p(r130, Boxing.boxBoolean(o59.a.y(r120, "1.1.0.0")));
            IDoraPageConfig r131 = AiLabViewModel.access$getDoraPageConfig(this.this$0);
            if (r131 == null) goto L94;
            boolean r132 = false;
            r119 = Boxing.boxBoolean(r131.d("dora_g_config_key_precapture_upload_enable", false));
        L95:
            IDoraPageConfig r133 = AiLabViewModel.access$getDoraPageConfig(this.this$0);
            if (r133 == null) goto L98;
            ?? r134 = r133.b(r132);
        L99:
            Deferred r135 = BuildersKt.async$default(r129, null, null, new AiLabViewModel$load$1$state$startEndSoundEnable$1(null), 3, null);
            this.L$0 = r120;
            this.L$1 = r119;
            this.L$2 = r135;
            this.Z$0 = r125;
            this.I$0 = r134;
            this.label = 6;
            r121 = r126.await(this);
            if (r121 != r100) goto L102;
            return r100;
        L102:
            r118 = r135;
            ?? r211 = r134;
            r117 = r125;
            r116 = r211 == true ? 1 : 0;
            goto L103
        L98:
            r134 = 0;
            goto L99
        L94:
            r132 = false;
            r119 = null;
            goto L95
        L10:
            ResultKt.throwOnFailure(r210);
            Object r136 = r210;
        L79:
            r108 = new u.c(((Boolean) r136).booleanValue());
            goto L112
        L11:
            Deferred r137 = (Deferred) this.L$0;
            ResultKt.throwOnFailure(r210);
        L64:
            Lazy r138 = DoraWakeupKeywordsHandler.f333550a;
            SAMICoreProperty r139 = new SAMICoreProperty();
            int r140 = ((SAMICore) DoraWakeupKeywordsHandler.f333550a.getValue()).SAMICoreGetPropertyById(SAMICorePropertyId.SAMICorePropertyId_AIS_Ability, r139);
            if (r140 == 0) goto L69;
            r101 = false;
        L69:
            if (r101 == true) goto L71;
            g49.d.b("DoraWakeupKeywordsHandler", "loadKeywords: Fail to get keywords, ret=" + r140);
        L76:
            this.L$0 = null;
            this.label = 4;
            r136 = r137.await(this);
            if (r136 != r100) goto L79;
            return r100;
        L71:
            Object r141 = r139.dataObjectArray[0];
            if ((r141 instanceof String) == false) goto L74;
            String r142 = (String) r141;
        L75:
            g49.d.d("DoraWakeupKeywordsHandler", "loadKeywords: json: " + r142);
            DoraWakeupKeywordsHandler.a(r142, false);
            goto L76
        L74:
            r142 = null;
            goto L75
        L12:
            int r143 = this.I$1;
            int r144 = this.I$0;
            boolean r145 = this.Z$2;
            boolean r146 = this.Z$1;
            boolean r147 = this.Z$0;
            DoraDevice r148 = (DoraDevice) this.L$1;
            CoroutineScope r149 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r210);
            boolean r150 = r145;
            boolean r212 = r146;
        L50:
            Deferred r151 = BuildersKt.async$default(r149, null, null, new AiLabViewModel$load$1$voiceWakeEnable$1(null), 3, null);
            if (r147 == false) goto L80;
            z0 r152 = AiLabViewModel.access$get_abilityStateFlow$p(this.this$0);
            if (r144 == 0) goto L55;
            boolean r153 = true;
        L57:
            if (r143 == 0) goto L59;
            boolean r154 = true;
        L60:
            com.larus.dora.impl.device.ailab.a r155 = new com.larus.dora.impl.device.ailab.a(true, r153, true, r212, r150, r154);
            this.L$0 = r151;
            this.L$1 = null;
            this.label = 3;
            if (r152.emit(r155, this) != r100) goto L63;
            return r100;
        L63:
            r137 = r151;
            goto L64
        L59:
            r154 = false;
            goto L60
        L55:
            r153 = false;
            goto L57
        L80:
            Intrinsics.checkNotNullParameter(r148, "<this>");
            boolean r156 = o59.a.y(r148, "1.2.0.147");
            z0 r157 = AiLabViewModel.access$get_abilityStateFlow$p(this.this$0);
            if (r144 == 0) goto L83;
            boolean r158 = true;
        L84:
            if (r143 == 0) goto L86;
            boolean r159 = true;
        L87:
            boolean r160 = r158;
            DoraDevice r161 = r148;
            CoroutineScope r162 = r149;
            com.larus.dora.impl.device.ailab.a r163 = new com.larus.dora.impl.device.ailab.a(false, r160, r156, r212, r150, r159);
            this.L$0 = r162;
            this.L$1 = r161;
            this.L$2 = r151;
            this.Z$0 = r156;
            this.label = 5;
            if (r157.emit(r163, this) != r100) goto L90;
            return r100;
        L90:
            r125 = r156;
            r129 = r162;
            r120 = r161;
            r126 = r151;
            goto L91
        L86:
            r159 = false;
            goto L87
        L83:
            r158 = false;
            goto L84
        L13:
            DoraDevice r164 = (DoraDevice) this.L$1;
            CoroutineScope r165 = (CoroutineScope) this.L$0;
            ResultKt.throwOnFailure(r210);
            Object r166 = r210;
        L14:
            r148 = r164;
            r147 = ((Boolean) r166).booleanValue();
            sk4.e r167 = o0.f332223a;
            boolean r168 = o0.c(ProtocolAbility.FEATURE_WAKEUP_SOUND);
            boolean r169 = o59.a.l(r148);
            if (o59.a.q(r148) == false) goto L23;
        L26:
            int r170 = 1;
        L27:
            IDoraService r171 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r171 == null) goto L34;
            DeviceService r172 = r171.device();
            if (r172 == null) goto L34;
            if (r172.a() != true) goto L34;
            boolean r173 = true;
        L35:
            if (r173 == true) goto L37;
        L41:
            int r174 = 0;
        L42:
            z0 r175 = AiLabViewModel.access$get_budsQuickContinuousConversationSwitchStateFlow$p(this.this$0);
            if (r174 == 0) goto L45;
            b0.f338123a.getClass();
            boolean r176 = b0.w();
        L46:
            Boolean r177 = Boxing.boxBoolean(r176);
            this.L$0 = r165;
            this.L$1 = r148;
            this.Z$0 = r147;
            this.Z$1 = r168;
            this.Z$2 = r169;
            this.I$0 = r170;
            this.I$1 = r174;
            this.label = 2;
            if (r175.emit(r177, this) != r100) goto L49;
            return r100;
        L49:
            r150 = r169;
            r212 = r168;
            CoroutineScope r213 = r165;
            r144 = r170;
            r143 = r174;
            r149 = r213;
            goto L50
        L45:
            r176 = false;
            goto L46
        L37:
            if (o0.b(r148) == true) goto L41;
            if (o0.c("natural_wakup") == false) goto L41;
            r174 = 1;
        L34:
            r173 = false;
            goto L35
        L23:
            if (o59.a.l(r148) == true) goto L26;
            r170 = 0;
            goto L27
        L15:
            ResultKt.throwOnFailure(r210);
            r165 = (CoroutineScope) this.L$0;
            r164 = DoraAdapterExtKt.h(kj4.a.g());
            if (r164 == null) goto L116;
            sk4.e r178 = o0.f332223a;
            this.L$0 = r165;
            this.L$1 = r164;
            this.label = 1;
            r166 = o0.g();
            if (r166 != r100) goto L14;
            return r100;
        L116:
            g49.d.b(AiLabViewModel.TAG, "load...device is null, ensure not reach here");
            goto L118
        L5:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$requestDeviceSyncInfo$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel", f = "AiLabViewModel.kt", i = {}, l = {327}, m = "requestDeviceSyncInfo", n = {}, s = {})
    public static final class C110861 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AiLabViewModel this$0;

        public C110861(AiLabViewModel r100, Continuation<? super C110861> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return AiLabViewModel.access$requestDeviceSyncInfo(this.this$0, null, null, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$selectKeywordWakeup$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel", f = "AiLabViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND}, m = "selectKeywordWakeup", n = {}, s = {})
    public static final class C110871 extends ContinuationImpl {
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AiLabViewModel this$0;

        public C110871(AiLabViewModel r100, Continuation<? super C110871> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.selectKeywordWakeup(null, false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$setVoiceWakeEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel", f = "AiLabViewModel.kt", i = {0}, l = {132}, m = "setVoiceWakeEnable", n = {"ret"}, s = {"I$0"})
    public static final class C110881 extends ContinuationImpl {
        int I$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AiLabViewModel this$0;

        public C110881(AiLabViewModel r100, Continuation<? super C110881> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.setVoiceWakeEnable(false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateConvStartEndSoundEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updateConvStartEndSoundEnable$1", f = "AiLabViewModel.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_VSYNC_HELPER, MediaPlayer.MEDIA_PLAYER_OPTION_PREPARE_CACHE_MS}, m = "invokeSuspend", n = {}, s = {})
    public static final class C110891 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C110891(boolean r100, AiLabViewModel r101, Continuation<? super C110891> r102) {
            this.$isChecked = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C110891(this.$isChecked, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110891) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L10;
            if (r101 == 1) goto L9;
            if (r101 == 2) goto L9;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r110);
        L33:
            return Unit.INSTANCE;
        L10:
            ResultKt.throwOnFailure(r110);
            kj4.a r111 = kj4.a.g();
            if (this.$isChecked == false) goto L13;
            int r102 = 2;
        L14:
            mj4.f r112 = r111.f503708c;
            int r103 = r112.f514229d.i(1, 4, new byte[]{27, 1, (byte) r102});
            if (r103 != 0) goto L17;
            r112.f514246u = r102;
        L17:
            if (r103 != 0) goto L29;
            Object r113 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r113 instanceof u.b) == false) goto L21;
            u.b r114 = (u.b) r113;
        L22:
            u.b r104 = r114;
            if (r104 == null) goto L25;
            u.b r115 = u.b.a(r104, false, false, this.$isChecked, false, 47);
            z0 r105 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0);
            this.label = 1;
            if (r105.emit(r115, this) != r100) goto L33;
            return r100;
        L25:
            return Unit.INSTANCE;
        L21:
            r114 = null;
            goto L22
        L29:
            MutableSharedFlow r116 = AiLabViewModel.access$get_aiLabActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.ailab.b.C4215b r106 = new com.larus.dora.impl.device.ailab.b.C4215b();
            this.label = 2;
            if (r116.emit(r106, this) != r100) goto L33;
            return r100;
        L13:
            r102 = 1;
            goto L14
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateConvVisualIntentSoundEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updateConvVisualIntentSoundEnable$1", f = "AiLabViewModel.kt", i = {}, l = {274}, m = "invokeSuspend", n = {}, s = {})
    public static final class C110901 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C110901(AiLabViewModel r100, boolean r101, Continuation<? super C110901> r102) {
            this.this$0 = r100;
            this.$isChecked = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C110901(this.this$0, this.$isChecked, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110901) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L8;
            if (r101 != 1) goto L7;
            ResultKt.throwOnFailure(r110);
        L23:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r110);
            IDoraPageConfig r111 = AiLabViewModel.access$getDoraPageConfig(this.this$0);
            if (r111 == null) goto L11;
            r111.i(this.$isChecked);
        L11:
            Object r112 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            if ((r112 instanceof u.b) == false) goto L14;
            u.b r113 = (u.b) r112;
        L15:
            u.b r102 = r113;
            if (r102 == null) goto L18;
            u.b r114 = u.b.a(r102, false, false, false, this.$isChecked, 31);
            z0 r103 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0);
            this.label = 1;
            if (r103.emit(r114, this) != r100) goto L23;
            return r100;
        L18:
            return Unit.INSTANCE;
        L14:
            r113 = null;
            goto L15
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateKeyword$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updateKeyword$1", f = "AiLabViewModel.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C110911 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isSelected;
        final /* synthetic */ String $keyword;
        int label;

        public C110911(String r100, boolean r101, Continuation<? super C110911> r102) {
            this.$keyword = r100;
            this.$isSelected = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C110911(this.$keyword, this.$isSelected, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110911) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L10;
            ResultKt.throwOnFailure(r100);
            Lazy r101 = DoraWakeupKeywordsHandler.f333550a;
            if (DoraWakeupKeywordsHandler.d(this.$keyword, this.$isSelected) == true) goto L8;
            t19.s r102 = t19.s.f544207a;
            Application r103 = AppHost.f326268a.getApplication();
            r102.getClass();
            t19.s.b(r103, R.string.larus_dora_toast_update_failed_cn, false);
        L8:
            return Unit.INSTANCE;
        L10:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateMultiUserModeState$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updateMultiUserModeState$1", f = "AiLabViewModel.kt", i = {}, l = {233, 234}, m = "invokeSuspend", n = {}, s = {})
    public static final class C110921 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $enable;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C110921(boolean r100, AiLabViewModel r101, Continuation<? super C110921> r102) {
            this.$enable = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C110921(this.$enable, this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110921) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
        L17:
            boolean r103 = ((Boolean) r100).booleanValue();
            MutableSharedFlow r104 = AiLabViewModel.access$get_updateMultiUserModeFlow$p(this.this$0);
            Boolean r105 = Boxing.boxBoolean(r103);
            this.label = 2;
            if (r104.emit(r105, this) != r101) goto L21;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            DoraUserManager r106 = DoraUserManager.f332169a;
            boolean r107 = DoraUserManager.b();
            boolean r108 = this.$enable;
            if (r107 != r108) goto L14;
            g49.d.d(AiLabViewModel.TAG, "updateMultiUserModeState: enable already " + this.$enable);
            return Unit.INSTANCE;
        L14:
            this.label = 1;
            r100 = DoraUserManager.e(r108, this);
            if (r100 != r101) goto L17;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updateNaturalWakeupEnabled$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel", f = "AiLabViewModel.kt", i = {0, 0}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_PRE_STALL_500}, m = "updateNaturalWakeupEnabled", n = {"enabled", "ret"}, s = {"Z$0", "I$0"})
    public static final class C110931 extends ContinuationImpl {
        int I$0;
        boolean Z$0;
        int label;
        /* synthetic */ Object result;
        final /* synthetic */ AiLabViewModel this$0;

        public C110931(AiLabViewModel r100, Continuation<? super C110931> r101) {
            this.this$0 = r100;
            super(r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            this.result = r100;
            this.label |= Integer.MIN_VALUE;
            return this.this$0.updateNaturalWakeupEnabled(false, this);
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.ailab.AiLabViewModel$updatePrecaptureUploadEnable$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.dora.impl.device.ailab.AiLabViewModel$updatePrecaptureUploadEnable$1", f = "AiLabViewModel.kt", i = {}, l = {250, MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_RANGE_TIME, 262}, m = "invokeSuspend", n = {}, s = {})
    public static final class C110941 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $isChecked;
        int label;
        final /* synthetic */ AiLabViewModel this$0;

        public C110941(AiLabViewModel r100, boolean r101, Continuation<? super C110941> r102) {
            this.this$0 = r100;
            this.$isChecked = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C110941(this.this$0, this.$isChecked, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C110941) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r110) {
            Object r100 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r101 = this.label;
            if (r101 == 0) goto L12;
            if (r101 == 1) goto L11;
            if (r101 == 2) goto L10;
            if (r101 == 3) goto L10;
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L10:
            ResultKt.throwOnFailure(r110);
        L35:
            return Unit.INSTANCE;
        L11:
            ResultKt.throwOnFailure(r110);
        L23:
            boolean r111 = ((Boolean) r110).booleanValue();
            Object r102 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0).getValue();
            Intrinsics.checkNotNull(r102, "null cannot be cast to non-null type com.larus.dora.impl.device.ailab.AiLabState.V1");
            u.b r103 = (u.b) r102;
            if (r111 == false) goto L31;
            g49.d.d(AiLabViewModel.TAG, "updatePrecaptureUploadEnable, success");
            IDoraPageConfig r112 = AiLabViewModel.access$getDoraPageConfig(this.this$0);
            if (r112 == null) goto L28;
            r112.a("dora_g_config_key_precapture_upload_enable", this.$isChecked);
        L28:
            u.b r113 = u.b.a(r103, false, this.$isChecked, false, false, 55);
            z0 r104 = AiLabViewModel.access$get_deviceStateFlow$p(this.this$0);
            this.label = 2;
            if (r104.emit(r113, this) != r100) goto L35;
            return r100;
        L31:
            g49.d.b(AiLabViewModel.TAG, "updatePrecaptureUploadEnable failed");
            MutableSharedFlow r114 = AiLabViewModel.access$get_aiLabActionSharedFlow$p(this.this$0);
            com.larus.dora.impl.device.ailab.b.a r105 = new com.larus.dora.impl.device.ailab.b.a();
            this.label = 3;
            if (r114.emit(r105, this) != r100) goto L35;
            return r100;
        L12:
            ResultKt.throwOnFailure(r110);
            if ((AiLabViewModel.access$get_deviceStateFlow$p(this.this$0).getValue() instanceof u.b) == true) goto L16;
            g49.d.d(AiLabViewModel.TAG, "updatePrecaptureUploadEnable, not V2 state");
            return Unit.INSTANCE;
        L16:
            AiLabViewModel r115 = this.this$0;
            if (this.$isChecked == false) goto L19;
            String r106 = "1";
        L20:
            this.label = 1;
            r110 = AiLabViewModel.access$requestDeviceSyncInfo(r115, "quick_chat_switch", r106, this);
            if (r110 != r100) goto L23;
            return r100;
        L19:
            r106 = "0";
            goto L20
        }
    }

    static {
        Companion = new a();
    }

    public static /* synthetic */ IDoraPageConfig yo() {
        return doraPageConfig_delegate$lambda$0();
    }

    private static final IDoraPageConfig doraPageConfig_delegate$lambda$0() {
        return (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
    }

    private final IDoraPageConfig getDoraPageConfig() {
        return (IDoraPageConfig) this.doraPageConfig$delegate.getValue();
    }

    public final Flow<Boolean> getMultiUserModeStateFlow() {
        return kotlinx.coroutines.flow.e.w(new c1(new C110841(null)), Dispatchers.getIO());
    }

    public final boolean isMultiUserModeEnabled() {
        DoraUserManager r100 = DoraUserManager.f332169a;
        return DoraUserManager.b();
    }

    /* JADX WARN: Type inference failed for: r2v1, types: [com.larus.dora.impl.device.ailab.AiLabViewModel$special$$inlined$filter$1] */
    public AiLabViewModel() {
        StateFlowImpl r100 = j1.a(u.a.f333573a);
        this._deviceStateFlow = r100;
        this.deviceStateFlow = r100;
        MutableSharedFlow<com.larus.dora.impl.device.ailab.b> r101 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._aiLabActionSharedFlow = r101;
        this.aiLabActionSharedFlow = r101;
        MutableSharedFlow<Boolean> r102 = SharedFlowKt.MutableSharedFlow$default(0, 0, null, 7, null);
        this._updateMultiUserModeFlow = r102;
        this.updateMultiUserModeFlow = r102;
        StateFlowImpl r103 = j1.a(null);
        this._abilityStateFlow = r103;
        this.abilityStateFlow = r103;
        StateFlowImpl r104 = j1.a(Boolean.FALSE);
        this._budsQuickContinuousConversationSwitchStateFlow = r104;
        this.budsQuickContinuousConversationSwitchStateFlow = r104;
        this.doraPageConfig$delegate = LazyKt.lazy(new v());
        b r105 = new b(this);
        this.doraLinkCallback = r105;
        final StateFlowImpl r106 = DoraWakeupKeywordsHandler.f333554e;
        final ?? r107 = new AiLabViewModel$special$$inlined$filter$1(r106);
        this.keywordsStateFlow = kotlinx.coroutines.flow.e.F(new AiLabViewModel$special$$inlined$map$1(r107, this), ViewModelKt.getViewModelScope(this), g1.a.a(g1.f504854a, 0, 3), CollectionsKt.emptyList());
        g49.d.d(TAG, "AiLabViewModel init " + hashCode());
        kj4.a.g().registerDoraLinkCallback(r105);
        load();
    }

    private final void fetchDeviceInfo() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new AnonymousClass1(this, null), 2, null);
    }

    public final boolean isDoraG() {
        return o59.a.l(kj4.a.g().c());
    }

    public final boolean isDoraLite() {
        DoraDevice r100 = kj4.a.g().c();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.productId != ProductNameType.DORA_LITE.f204375id) goto L9;
        return true;
    L9:
        return false;
    }

    public final boolean isDoreE() {
        DoraDevice r100 = kj4.a.g().c();
        if (r100 != null) goto L5;
        return false;
    L5:
        if (r100.productId != ProductNameType.DORA_E.f204375id) goto L9;
        return true;
    L9:
        return false;
    }

    public final void load() {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C110851(this, null), 2, null);
    }

    @Override // androidx.lifecycle.ViewModel
    public void onCleared() {
        super.onCleared();
        g49.d.d(TAG, "AiLabViewModel onCleared " + hashCode());
        kj4.a.g().unregisterDoraLinkCallback(this.doraLinkCallback);
    }

    public final i1<com.larus.dora.impl.device.ailab.a> getAbilityStateFlow() {
        return this.abilityStateFlow;
    }

    public final d1<com.larus.dora.impl.device.ailab.b> getAiLabActionSharedFlow() {
        return this.aiLabActionSharedFlow;
    }

    public final i1<Boolean> getBudsQuickContinuousConversationSwitchStateFlow() {
        return this.budsQuickContinuousConversationSwitchStateFlow;
    }

    public final i1<u> getDeviceStateFlow() {
        return this.deviceStateFlow;
    }

    public final i1<List<t>> getKeywordsStateFlow() {
        return this.keywordsStateFlow;
    }

    public final d1<Boolean> getUpdateMultiUserModeFlow() {
        return this.updateMultiUserModeFlow;
    }

    public static final /* synthetic */ void access$fetchDeviceInfo(AiLabViewModel r100) {
        r100.fetchDeviceInfo();
    }

    public static final /* synthetic */ IDoraPageConfig access$getDoraPageConfig(AiLabViewModel r100) {
        return r100.getDoraPageConfig();
    }

    public static final /* synthetic */ z0 access$get_abilityStateFlow$p(AiLabViewModel r100) {
        return r100._abilityStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_aiLabActionSharedFlow$p(AiLabViewModel r100) {
        return r100._aiLabActionSharedFlow;
    }

    public static final /* synthetic */ z0 access$get_budsQuickContinuousConversationSwitchStateFlow$p(AiLabViewModel r100) {
        return r100._budsQuickContinuousConversationSwitchStateFlow;
    }

    public static final /* synthetic */ z0 access$get_deviceStateFlow$p(AiLabViewModel r100) {
        return r100._deviceStateFlow;
    }

    public static final /* synthetic */ MutableSharedFlow access$get_updateMultiUserModeFlow$p(AiLabViewModel r100) {
        return r100._updateMultiUserModeFlow;
    }

    private final t toAiLabKeyword(DoraWakeupKeyword r110) {
        String r100 = r110.getKeyword();
        Lazy<String> r101 = t.f333562h;
        if (Intrinsics.areEqual(r100, t.a.b()) == false) goto L12;
        int r102 = j0.f375426a;
        String r103 = j0.d(R.string.larus_dora_ailab_keyword_owen_name_cn);
        String r104 = j0.d(R.string.larus_dora_ailab_keyword_owen_desc_cn);
        String r105 = t.a.b();
        Integer r111 = r110.getStatus();
        if (r111 != null) goto L8;
    L10:
        boolean r112 = false;
    L34:
        return new t(R.drawable.larus_dora_ailab_keyword_owen, r103, r104, r105, true, r112, true);
    L8:
        if (r111.intValue() != 1) goto L10;
        r112 = true;
        goto L34
    L12:
        Lazy<String> r106 = t.f333564j;
        if (Intrinsics.areEqual(r100, r106.getValue()) == false) goto L22;
        int r107 = j0.f375426a;
        String r108 = j0.d(R.string.larus_dora_ailab_keyword_doubao_name_cn);
        String r109 = j0.d(R.string.larus_dora_ailab_keyword_doubao_desc_cn);
        String r113 = r106.getValue();
        Integer r114 = r110.getStatus();
        if (r114 != null) goto L18;
    L20:
        boolean r115 = false;
    L35:
        return new t(R.drawable.larus_dora_ailab_keyword_doubao, r108, r109, r113, false, r115, true);
    L18:
        if (r114.intValue() != 1) goto L20;
        r115 = true;
        goto L35
    L22:
        String r116 = r110.getKeyword();
        if (r116 != null) goto L25;
        r116 = "";
    L25:
        String r117 = r116;
        Integer r118 = r110.getStatus();
        if (r118 != null) goto L29;
    L31:
        boolean r119 = false;
    L33:
        return new t(0, "", "", r117, true, r119, false);
    L29:
        if (r118.intValue() != 1) goto L31;
        r119 = true;
        goto L33
    }

    public final void updateConvStartEndSoundEnable(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C110891(r100, this, null), 2, null);
    }

    public final void updateConvVisualIntentSoundEnable(boolean r100) {
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C110901(this, r100, null), 2, null);
    }

    public final void updateCurrentDoraDeviceMac(String r100) {
        this.mCurrentDoraDeviceMac = r100;
    }

    public final void updateMultiUserModeState(boolean r100) {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new C110921(r100, this, null), 3, null);
    }

    public final void updatePrecaptureUploadEnable(boolean r100) {
        g49.d.d(TAG, "updatePrecaptureUploadEnable, isChecked: " + r100);
        BuildersKt.launch$default(ViewModelKt.getViewModelScope(this), Dispatchers.getIO(), null, new C110941(this, r100, null), 2, null);
    }

    public static final /* synthetic */ void access$set_isSupportGestureWakeupContinuousDialogue$p(AiLabViewModel r100, Boolean r101) {
        r100._isSupportGestureWakeupContinuousDialogue = r101;
    }

    public static final /* synthetic */ t access$toAiLabKeyword(AiLabViewModel r100, DoraWakeupKeyword r101) {
        return r100.toAiLabKeyword(r101);
    }

    public final Object setVoiceWakeEnable(boolean r110, Continuation<? super Integer> r111) {
        if ((r111 instanceof C110881) == false) goto L7;
        C110881 r100 = (C110881) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L14;
        if (r103 != 1) goto L13;
        int r113 = r100.I$0;
        ResultKt.throwOnFailure(r112);
    L26:
        int r114 = r113;
    L28:
        return Boxing.boxInt(r114);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r114 = DoraAdapterExtKt.M(kj4.a.g(), r110);
        if (r114 != 0) goto L28;
        u r104 = this._deviceStateFlow.getValue();
        if ((r104 instanceof u.b) == false) goto L20;
        r104 = u.b.a((u.b) r104, r110, false, false, false, 62);
    L22:
        z0<u> r115 = this._deviceStateFlow;
        r100.I$0 = r114;
        r100.label = 1;
        if (r115.emit(r104, r100) != r102) goto L25;
        return r102;
    L25:
        r113 = r114;
        goto L26
    L20:
        if ((r104 instanceof u.c) == false) goto L22;
        ((u.c) r104).getClass();
        r104 = new u.c(r110);
    L7:
        r100 = new C110881(this, r111);
        goto L8
    }

    public final void updateKeyword(String r100, boolean r110) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        g49.d.d(TAG, "updateKeyword: start: keyword=" + r100 + ", isSelected=" + r110);
        BuildersKt.launch$default(GlobalScope.INSTANCE, Dispatchers.getIO(), null, new C110911(r100, r110, null), 2, null);
    }

    public final Object updateNaturalWakeupEnabled(boolean r100, Continuation<? super Integer> r101) {
        if ((r101 instanceof C110931) == false) goto L7;
        C110931 r102 = (C110931) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L14;
        if (r106 != 1) goto L13;
        int r107 = r102.I$0;
        boolean r108 = r102.Z$0;
        ResultKt.throwOnFailure(r104);
        int r109 = r107;
        r100 = r108;
    L19:
        DoraBuryPointManager.J(DoraBuryPointManager.f331862a, "dora_natural_wakeup_settings_change", x0.a(r100), false, 12);
    L21:
        return Boxing.boxInt(r109);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r104);
        r109 = kj4.a.g().v(r100);
        if (r109 != 0) goto L21;
        b0.f338123a.getClass();
        b0.M(r100);
        z0<Boolean> r110 = this._budsQuickContinuousConversationSwitchStateFlow;
        Boolean r111 = Boxing.boxBoolean(r100);
        r102.Z$0 = r100;
        r102.I$0 = r109;
        r102.label = 1;
        if (r110.emit(r111, r102) != r105) goto L19;
        return r105;
    L7:
        r102 = new C110931(this, r101);
        goto L8
    }

    private final Object requestDeviceSyncInfo(String r100, Object r101, Continuation<? super Boolean> r110) {
        if ((r110 instanceof C110861) == false) goto L7;
        C110861 r102 = (C110861) r110;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r111 = r102.result;
        Object r104 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r105 = r102.label;
        boolean r106 = true;
        if (r105 == 0) goto L14;
        if (r105 != 1) goto L13;
        ResultKt.throwOnFailure(r111);
        Object r107 = ((Result) r111).m9458unboximpl();
    L29:
        if (Result.m9456isSuccessimpl(r107) == false) goto L42;
        Long r108 = ((com.larus.dora.impl.network.i) r107).b();     // Catch: Throwable -> L39
        if (r108 != null) goto L34;
    L36:
        r106 = false;
    L37:
        return Boxing.boxBoolean(r106);
    L34:
        if (r108.longValue() != 0) goto L36;
    L39:
        th = move-exception;
        Result.Companion r109 = Result.Companion;
        r107 = ResultKt.createFailure(th);
    L42:
        if (Result.m9452exceptionOrNullimpl(Result.m9449constructorimpl(r107)) == null) goto L46;
        return Boxing.boxBoolean(false);
    L46:
        throw new KotlinNothingValueException();
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r111);
        Iterator<T> r112 = kj4.a.g().getDoraBindList().iterator();
    L16:
        if (r112.hasNext() == false) goto L20;
        Object r113 = r112.next();
        if (Intrinsics.areEqual(((DoraDevice) r113).f204389mac, this.mCurrentDoraDeviceMac) == false) goto L16;
    L21:
        DoraDevice r114 = (DoraDevice) r113;
        if (r114 == null) goto L24;
        DoraNetworkApi r115 = DoraNetworkApi.f336157a;
        List<? extends Pair<String, ? extends Object>> r116 = CollectionsKt.listOf(new Pair(r100, r101));
        r102.label = 1;
        r107 = r115.y(r114, r116, r102);
        if (r107 != r104) goto L29;
        return r104;
    L24:
        return Boxing.boxBoolean(false);
    L20:
        r113 = null;
    L7:
        r102 = new C110861(this, r110);
        goto L8
    }

    public final Object selectKeywordWakeup(String r100, boolean r101, Continuation<? super Boolean> r102) {
        if ((r102 instanceof C110871) == false) goto L7;
        C110871 r103 = (C110871) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = false;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        ResultKt.throwOnFailure(r105);
    L25:
        if (((Number) r105).intValue() != 0) goto L28;
        r108 = true;
    L28:
        return Boxing.boxBoolean(r108);
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        com.larus.dora.impl.device.ailab.a r109 = this.abilityStateFlow.getValue();
        if (r109 != null) goto L17;
    L19:
        boolean r110 = false;
    L20:
        if (r110 == false) goto L30;
        r103.label = 1;
        r105 = updateNaturalWakeupEnabled(false, r103);
        if (r105 != r106) goto L25;
        return r106;
    L30:
        return Boxing.boxBoolean(DoraWakeupKeywordsHandler.d(r100, r101));
    L17:
        if (r109.f333534f != true) goto L19;
        r110 = true;
    L7:
        r103 = new C110871(this, r102);
        goto L8
    }

    public static final /* synthetic */ Object access$requestDeviceSyncInfo(AiLabViewModel r100, String r101, Object r102, Continuation r103) {
        return r100.requestDeviceSyncInfo(r101, r102, r103);
    }
}
