package com.obric.assistant.wakeup.co_wakeup.dora.service;

import android.app.Application;
import android.content.Context;
import com.bytedance.keva.Keva;
import com.bytedance.pitaya.api.PTYSocketStateCallback;
import com.larus.common.apphost.AppHost;
import com.larus.dora.api.IDoraService;
import com.larus.dora.api.config.IDoraPageConfig;
import com.larus.dora.impl.device.settings.lab.env.EnvObserveViewModel;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.dora.impl.serviceimpl.r;
import com.larus.home.api.main.IPrivacyService;
import com.larus.platform.service.AccountService;
import com.larus.utils.j0;
import com.larus.utils.logger.FLogger;
import com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraConnectState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraSwitchState;
import com.obric.assistant.wakeup.co_wakeup.dora.model.DoraWearState;
import com.obric.memorydata.sdk.MemoryResponse;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.ttm.player.MediaPlayer;
import h49.l;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CancellationException;
import kotlin.KotlinNothingValueException;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArraysKt;
import kotlin.collections.SetsKt;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.channels.BufferOverflow;
import kotlinx.coroutines.flow.FlowCollector;
import kotlinx.coroutines.flow.MutableSharedFlow;
import kotlinx.coroutines.flow.SharedFlowKt;
import kotlinx.coroutines.flow.StateFlowImpl;
import kotlinx.coroutines.flow.j1;
import kotlinx.coroutines.sync.MutexImpl;
import kotlinx.coroutines.w1;
import org.json.JSONObject;
import t39.d;
import t39.n;
import t39.x;

/* JADX INFO: loaded from: classes5.dex */
@Metadata(d1 = {"\u0000§\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u001c\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003*\u0001/\b\u0007\u0018\u0000 c2\u00020\u00012\u00020\u00022\u00020\u00032\u00020\u0004:\u0001cB\u0007¢\u0006\u0004\b\u0005\u0010\u0006J\u0010\u00101\u001a\u0002022\u0006\u00103\u001a\u000204H\u0016J\b\u00105\u001a\u000202H\u0016J\u000e\u00109\u001a\b\u0012\u0004\u0012\u0002080:H\u0016J\u000e\u0010;\u001a\u000202H\u0082@¢\u0006\u0002\u0010<J\u001e\u0010=\u001a\u0002022\u0006\u0010>\u001a\u00020\u00112\u0006\u0010?\u001a\u00020\u0015H\u0082@¢\u0006\u0002\u0010@J\b\u0010A\u001a\u000202H\u0002J\u0018\u0010B\u001a\u0002022\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010D\u001a\u00020\u001dH\u0002J\u0018\u0010E\u001a\u0002022\u0006\u0010C\u001a\u00020\u001d2\u0006\u0010F\u001a\u00020\u001dH\u0002J\u0016\u0010G\u001a\u0002022\u0006\u0010H\u001a\u00020\u001dH\u0082@¢\u0006\u0002\u0010IJ\u0010\u0010J\u001a\u0002022\u0006\u0010H\u001a\u00020\u001dH\u0002J\u0018\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\b2\u0006\u0010D\u001a\u00020\u001dH\u0002J$\u0010K\u001a\u00020\u001d2\u0006\u0010L\u001a\u00020\b2\u0006\u0010M\u001a\u00020\b2\n\b\u0002\u0010N\u001a\u0004\u0018\u00010\bH\u0002J\b\u0010O\u001a\u000202H\u0016J\b\u0010P\u001a\u00020\u001dH\u0016J\b\u0010Q\u001a\u00020\u001dH\u0016J\b\u0010R\u001a\u00020\u001dH\u0016J\b\u0010S\u001a\u000202H\u0016J\b\u0010T\u001a\u000202H\u0016J*\u0010U\u001a\u0002022\u0006\u0010V\u001a\u00020W2\u0006\u0010X\u001a\u00020W2\u0006\u0010Y\u001a\u00020\b2\b\u0010Z\u001a\u0004\u0018\u00010\bH\u0016J\u0010\u0010[\u001a\u0002022\u0006\u0010\\\u001a\u00020\u001dH\u0016J \u0010]\u001a\u0002022\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020aH\u0016J \u0010b\u001a\u0002022\u0006\u0010^\u001a\u00020\u001d2\u0006\u0010_\u001a\u00020\u001d2\u0006\u0010`\u001a\u00020aH\u0016R\u000e\u0010\u0007\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0010\u0010\t\u001a\u0004\u0018\u00010\nX\u0082\u000e¢\u0006\u0002\n\u0000R\u0016\u0010\u000b\u001a\u0004\u0018\u00010\f8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0014\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00110\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00150\u0010X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0016\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0018\u001a\u00020\u0017X\u0082\u0004¢\u0006\u0002\n\u0000R\u0014\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001b0\u001aX\u0082\u0004¢\u0006\u0002\n\u0000R\u0012\u0010\u001c\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010\u001f\u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0012\u0010 \u001a\u0004\u0018\u00010\u001dX\u0082\u000e¢\u0006\u0004\n\u0002\u0010\u001eR\u0010\u0010!\u001a\u0004\u0018\u00010\bX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\"\u001a\u00020\u001dX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010#\u001a\u00020$X\u0082\u0004¢\u0006\u0002\n\u0000R#\u0010%\u001a\n '*\u0004\u0018\u00010&0&8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b*\u0010+\u001a\u0004\b(\u0010)R\u000e\u0010,\u001a\u00020-X\u0082\u0004¢\u0006\u0002\n\u0000R\u0010\u0010.\u001a\u00020/X\u0082\u0004¢\u0006\u0004\n\u0002\u00100R\u0014\u00106\u001a\b\u0012\u0004\u0012\u00020807X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006d"}, d2 = {"Lcom/obric/assistant/wakeup/co_wakeup/dora/service/CoWakeupService;", "Lcom/larus/dora/api/IDoraLinkCallback;", "Lcom/larus/dora/api/OnVoiceWakeupStateChangedListener;", "Lcom/larus/dora/api/wrapper/IWearStateListener;", "Lcom/obric/assistant/wakeup/co_wakeup/dora/CoWakeupApi;", "<init>", "()V", "TAG", "", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "doraApi", "Lcom/larus/dora/api/IDoraService;", "getDoraApi", "()Lcom/larus/dora/api/IDoraService;", "doraConnectStateFlow", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraConnectState;", "doraSwitchStateFlow", "Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraSwitchState;", "doraWearStateFlow", "Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraWearState;", "eventScope", "Lkotlinx/coroutines/CoroutineScope;", "collectScope", "jobs", "", "Lkotlinx/coroutines/Job;", "lastDoraGConnectionState", "", "Ljava/lang/Boolean;", "lastDoraGReadyState", "lastEnvironmentMemoryEnabled", "lastEnvironmentTimerSettings", "hasLoggedGlassesProductIdReadFailure", "memoryNotifyMutex", "Lkotlinx/coroutines/sync/Mutex;", "doraSettingsStore", "Lcom/bytedance/keva/Keva;", "kotlin.jvm.PlatformType", "getDoraSettingsStore", "()Lcom/bytedance/keva/Keva;", "doraSettingsStore$delegate", "Lkotlin/Lazy;", "timerConfigChangeListener", "Lcom/bytedance/keva/Keva$OnChangeListener;", "envObserveChangeListener", "com/obric/assistant/wakeup/co_wakeup/dora/service/CoWakeupService$envObserveChangeListener$1", "Lcom/obric/assistant/wakeup/co_wakeup/dora/service/CoWakeupService$envObserveChangeListener$1;", "init", "", "ctx", "Landroid/app/Application;", "reload", "coWakeupSharedFlow", "Lkotlinx/coroutines/flow/MutableSharedFlow;", "Lcom/obric/assistant/wakeup/co_wakeup/dora/event/CoWakeupEvent;", "sharedEventFlow", "Lkotlinx/coroutines/flow/SharedFlow;", "notifyChanged", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyDoraGStatesForMemory", "connect", "wear", "(Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraConnectState;Lcom/obric/assistant/wakeup/co_wakeup/dora/model/DoraWearState;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyGlassesProductIdForMemory", "notifyDoraGConnectionStateForMemory", "isDoraG", PTYSocketStateCallback.CONNECTED, "notifyDoraGReadyStateForMemory", "ready", "notifyEnvironmentMemoryStateForMemory", "force", "(ZLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "notifyEnvironmentTimerSettingsForMemory", "notifyMemoryDataGlassesState", "key", "value", "expectedMessage", "release", "isDoraConnected", "isDoraConnectedIgnoreSwitch", "isDoraGWearOn", "start", "stop", "onDoraLinkChanged", "state", "", "productId", "productName", "fwVersion", "onVoiceWakeupStateChanged", "enabled", "onWearStateChanged", "leftOn", "rightOn", "deviceInfo", "Lcom/larus/dora/api/DoraDeviceInfo;", "onWearStateChangedAlwaysNotify", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CoWakeupService implements n, x, l, CoWakeupApi {

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public static final Set<String> f394450r = null;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f394451a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final StateFlowImpl f394452b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final StateFlowImpl f394453c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final StateFlowImpl f394454d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final CoroutineScope f394455e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final CoroutineScope f394456f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final List<Job> f394457g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public Boolean f394458h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Boolean f394459i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Boolean f394460j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public String f394461k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public boolean f394462l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final MutexImpl f394463m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f394464n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final b f394465o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final CoWakeupService$envObserveChangeListener$1 f394466p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final MutableSharedFlow<vha.a> f394467q;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$1", f = "CoWakeupService.kt", i = {}, l = {104}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$1$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoWakeupService f394469a;

            public a(CoWakeupService r100) {
                this.f394469a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                FLogger.f375446a.i(this.f394469a.f394451a, "doraSwitchStateFlow is " + ((DoraSwitchState) r100));
                Object r102 = CoWakeupService.h(this.f394469a, r101);
                if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r102;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass1(CoWakeupService r100, Continuation<? super AnonymousClass1> r101) {
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
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoWakeupService r103 = this.this$0;
            StateFlowImpl r104 = r103.f394453c;
            a r105 = new a(r103);
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$3, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$3", f = "CoWakeupService.kt", i = {}, l = {112}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass3 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$3$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoWakeupService f394470a;

            public a(CoWakeupService r100) {
                this.f394470a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                FLogger.f375446a.i(this.f394470a.f394451a, "doraConnectState is " + ((DoraConnectState) r100));
                Object r102 = CoWakeupService.h(this.f394470a, r101);
                if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r102;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass3(CoWakeupService r100, Continuation<? super AnonymousClass3> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass3(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass3) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoWakeupService r103 = this.this$0;
            StateFlowImpl r104 = r103.f394452b;
            a r105 = new a(r103);
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$5, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$5", f = "CoWakeupService.kt", i = {}, l = {120}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass5 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$init$5$a */
        public static final class a<T> implements FlowCollector {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final /* synthetic */ CoWakeupService f394471a;

            public a(CoWakeupService r100) {
                this.f394471a = r100;
            }

            @Override // kotlinx.coroutines.flow.FlowCollector
            public final Object emit(Object r100, Continuation r101) {
                FLogger.f375446a.i(this.f394471a.f394451a, "doraWearStateFlow is " + ((DoraWearState) r100));
                Object r102 = CoWakeupService.h(this.f394471a, r101);
                if (r102 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L6;
                return r102;
            L6:
                return Unit.INSTANCE;
            }
        }

        public AnonymousClass5(CoWakeupService r100, Continuation<? super AnonymousClass5> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass5(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass5) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L6;
            ResultKt.throwOnFailure(r100);
        L12:
            throw new KotlinNothingValueException();
        L6:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            CoWakeupService r103 = this.this$0;
            StateFlowImpl r104 = r103.f394454d;
            a r105 = new a(r103);
            this.label = 1;
            if (r104.collect(r105, this) != r101) goto L12;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$reload$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$reload$1", f = "CoWakeupService.kt", i = {}, l = {131, 132}, m = "invokeSuspend", n = {}, s = {})
    public static final class C116481 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public C116481(CoWakeupService r100, Continuation<? super C116481> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C116481(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C116481) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L10;
            if (r102 == 1) goto L9;
            if (r102 != 2) goto L8;
            ResultKt.throwOnFailure(r100);
        L17:
            return Unit.INSTANCE;
        L8:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L9:
            ResultKt.throwOnFailure(r100);
        L13:
            CoWakeupService r103 = this.this$0;
            this.label = 2;
            if (CoWakeupService.i(r103, true, this) != r101) goto L17;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            CoWakeupService r104 = this.this$0;
            this.label = 1;
            if (CoWakeupService.h(r104, this) != r101) goto L13;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$1", f = "CoWakeupService.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_VIDEO_DECODER_POST_STALL_500}, m = "invokeSuspend", n = {}, s = {})
    public static final class C116491 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $connected;
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public C116491(CoWakeupService r100, boolean r101, Continuation<? super C116491> r102) {
            this.this$0 = r100;
            this.$connected = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C116491(this.this$0, this.$connected, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C116491) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            StateFlowImpl r103 = this.this$0.f394452b;
            if (this.$connected == false) goto L11;
            DoraConnectState r104 = DoraConnectState.CONNECTED;
        L12:
            this.label = 1;
            r103.setValue(r104);
            if (Unit.INSTANCE != r101) goto L16;
            return r101;
        L11:
            r104 = DoraConnectState.NOT_CONNECTED;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$2", f = "CoWakeupService.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_QUIC_MAX_RETRANSMISSION_TIME_MS}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $switchState;
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public AnonymousClass2(CoWakeupService r100, boolean r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$switchState = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$switchState, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass2) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            StateFlowImpl r103 = this.this$0.f394453c;
            if (this.$switchState == false) goto L11;
            DoraSwitchState r104 = DoraSwitchState.ON;
        L12:
            this.label = 1;
            r103.setValue(r104);
            if (Unit.INSTANCE != r101) goto L16;
            return r101;
        L11:
            r104 = DoraSwitchState.OFF;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$3, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$3", f = "CoWakeupService.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_HURRY_MILLISECOND}, m = "invokeSuspend", n = {}, s = {})
    public static final class C116503 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ boolean $wearState;
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public C116503(CoWakeupService r100, boolean r101, Continuation<? super C116503> r102) {
            this.this$0 = r100;
            this.$wearState = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C116503(this.this$0, this.$wearState, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C116503) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L16:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            StateFlowImpl r103 = this.this$0.f394454d;
            if (this.$wearState == false) goto L11;
            DoraWearState r104 = DoraWearState.ON;
        L12:
            this.label = 1;
            r103.setValue(r104);
            if (Unit.INSTANCE != r101) goto L16;
            return r101;
        L11:
            r104 = DoraWearState.OFF;
            goto L12
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$4, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$start$4", f = "CoWakeupService.kt", i = {}, l = {406}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass4 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ CoWakeupService this$0;

        public AnonymousClass4(CoWakeupService r100, Continuation<? super AnonymousClass4> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass4(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((AnonymousClass4) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
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
            CoWakeupService r103 = this.this$0;
            this.label = 1;
            if (CoWakeupService.i(r103, true, this) != r101) goto L12;
            return r101;
        }
    }

    @Override // h49.l
    public final void g(boolean r100, boolean r101, d r102) {
        Intrinsics.checkNotNullParameter(r102, "deviceInfo");
    }

    static {
        f394450r = SetsKt.setOf(new String[]{"dora_g_config_key_env_observe_timer_enable", EnvObserveViewModel.START_TIME_SET, EnvObserveViewModel.END_TIME_SET});
    }

    public static IDoraService j() {
        return (IDoraService) ServiceManager.get().getService(IDoraService.class);
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final boolean b() {
        if (((DoraConnectState) this.f394452b.getValue()) != DoraConnectState.CONNECTED) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final boolean c() {
        IDoraService r100 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
        if (r100 == null) goto L5;
        DeviceService r101 = r100.device();
    L6:
        if (r101 == null) goto L10;
        boolean r102 = true;
        if (r101.S() != true) goto L10;
    L11:
        FLogger.f375446a.i(this.f394451a, "isDoraGWearOn? " + r102 + ", doraDeviceService = " + r101);
        return r102;
    L10:
        r102 = false;
        goto L11
    L5:
        r101 = null;
        goto L6
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final boolean isDoraConnected() {
        DoraSwitchState r100 = (DoraSwitchState) this.f394453c.getValue();
        DoraConnectState r101 = (DoraConnectState) this.f394452b.getValue();
        if (r100 == DoraSwitchState.ON) goto L5;
    L7:
        return false;
    L5:
        if (r101 != DoraConnectState.CONNECTED) goto L7;
        return true;
    }

    public final void o() {
        IDoraService r100 = j();     // Catch: RuntimeException -> L29 CancellationException -> L33
        if (r100 == null) goto L6;
        DeviceService r101 = r100.device();     // Catch: RuntimeException -> L29 CancellationException -> L33
    L7:
        boolean r102 = false;
        if (r101 != null) goto L10;
    L12:
        boolean r103 = false;
    L13:
        if (r103 == false) goto L15;
        int r104 = r101.y();     // Catch: RuntimeException -> L29 CancellationException -> L33
    L16:
        this.f394462l = false;     // Catch: RuntimeException -> L29 CancellationException -> L33
        Integer r105 = Integer.valueOf(r104);     // Catch: RuntimeException -> L29 CancellationException -> L33
        if (r105.intValue() <= 0) goto L19;
        r102 = true;
    L19:
        if (r102 == true) goto L22;
        r105 = null;
    L22:
        if (r105 == null) goto L24;
        String r106 = r105.toString();     // Catch: RuntimeException -> L29 CancellationException -> L33
    L25:
        if (r106 != null) goto L27;
        r106 = "";
    L27:
        p("glasses_product_id", r106, null);     // Catch: RuntimeException -> L29 CancellationException -> L33
    L38:
        return;
    L24:
        r106 = null;
        goto L25
    L15:
        r104 = -1;
        goto L16
    L10:
        if (r101.J() != true) goto L12;
        r103 = true;
        goto L13
    L6:
        r101 = null;
    L33:
        e = move-exception;
        throw e;
    L29:
        p("glasses_product_id", "", null);
        if (this.f394462l == true) goto L37;
        this.f394462l = true;
        FLogger.f375446a.w(this.f394451a, "read glasses product id failed");
        return;
    }

    /* JADX WARN: Type inference failed for: r2v8, types: [com.obric.assistant.wakeup.co_wakeup.dora.service.b] */
    /* JADX WARN: Type inference failed for: r2v9, types: [com.obric.assistant.wakeup.co_wakeup.dora.service.CoWakeupService$envObserveChangeListener$1] */
    public CoWakeupService() {
        this.f394451a = "CoWakeupService";
        this.f394452b = j1.a(DoraConnectState.NA);
        this.f394453c = j1.a(DoraSwitchState.NA);
        this.f394454d = j1.a(DoraWearState.NA);
        this.f394455e = CoroutineScopeKt.CoroutineScope(w1.a(1, "eventScope").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f394456f = CoroutineScopeKt.CoroutineScope(w1.a(5, "collectScope").plus(SupervisorKt.SupervisorJob$default(null, 1, null)));
        this.f394457g = new ArrayList();
        this.f394463m = kotlinx.coroutines.sync.b.a();
        this.f394464n = LazyKt.lazy(new com.obric.assistant.wakeup.co_wakeup.dora.service.a());
        this.f394465o = new b(this);
        this.f394466p = new CoWakeupService$envObserveChangeListener$1(this);
        this.f394467q = SharedFlowKt.MutableSharedFlow(1, 5, BufferOverflow.SUSPEND);
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final void reload() {
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO().plus(SupervisorKt.SupervisorJob$default(null, 1, null))), null, null, new C116481(this, null), 3, null);
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final void start() {
        IDoraService r100 = j();
        boolean r101 = false;
        if (r100 == null) goto L7;
        DeviceService r102 = r100.device();
        if (r102 == null) goto L7;
        boolean r103 = r102.J();
    L8:
        FLogger r104 = FLogger.f375446a;
        r104.i(this.f394451a, "dora connect state connect?? " + r103);
        BuildersKt.launch$default(this.f394455e, null, null, new C116491(this, r103, null), 3, null);
        IDoraService r105 = j();
        if (r105 == null) goto L11;
        boolean r106 = r105.b();
    L12:
        r104.i(this.f394451a, "dora switch state is on ?? " + r106);
        BuildersKt.launch$default(this.f394455e, null, null, new AnonymousClass2(this, r106, null), 3, null);
        IDoraService r107 = j();
        if (r107 == null) goto L19;
        DeviceService r108 = r107.device();
        if (r108 == null) goto L19;
        if (r108.S() != true) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == true) goto L39;
        IDoraService r110 = j();
        if (r110 == null) goto L28;
        DeviceService r111 = r110.device();
        if (r111 == null) goto L28;
        if (r111.e(0) != true) goto L28;
        boolean r112 = true;
    L29:
        if (r112 == true) goto L39;
        IDoraService r113 = j();
        if (r113 == null) goto L37;
        DeviceService r114 = r113.device();
        if (r114 == null) goto L37;
        if (r114.e(1) != true) goto L37;
        boolean r115 = true;
    L38:
        if (r115 == true) goto L39;
    L40:
        r104.i(this.f394451a, "dora switch state is on ?? " + r106);
        BuildersKt.launch$default(this.f394455e, null, null, new C116503(this, r101, null), 3, null);
        IDoraService r116 = j();
        if (r116 == null) goto L43;
        r116.G(this);
    L43:
        IDoraService r117 = j();
        if (r117 == null) goto L46;
        r117.W(this);
    L46:
        IDoraService r118 = j();
        if (r118 == null) goto L51;
        DeviceService r119 = r118.device();
        if (r119 == null) goto L51;
        r119.v0(this);
    L51:
        IDoraService r120 = j();
        if (r120 == null) goto L56;
        r r121 = r120.g1();
        if (r121 == null) goto L56;
        r121.a(this.f394466p);
    L56:
        ((Keva) this.f394464n.getValue()).registerChangeListener(this.f394465o);
        BuildersKt.launch$default(this.f394455e, null, null, new AnonymousClass4(this, null), 3, null);
        return;
    L37:
        r115 = false;
    L28:
        r112 = false;
    L39:
        r101 = true;
    L19:
        r109 = false;
        goto L20
    L11:
        r106 = false;
    L7:
        r103 = false;
        goto L8
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final MutableSharedFlow d() {
        return this.f394467q;
    }

    @Override // t39.x
    public final void a(boolean r100) {
        BuildersKt.launch$default(this.f394455e, null, null, new CoWakeupService$onVoiceWakeupStateChanged$1(this, r100, null), 3, null);
    }

    @Override // com.obric.assistant.wakeup.co_wakeup.dora.CoWakeupApi
    public final void init(Application r100) {
        Intrinsics.checkNotNullParameter(r100, "ctx");
        FLogger.f375446a.i(this.f394451a, "init");
        Job r101 = BuildersKt.launch$default(this.f394456f, null, null, new AnonymousClass1(this, null), 3, null);
        ((ArrayList) this.f394457g).add(r101);
        Job r102 = BuildersKt.launch$default(this.f394456f, null, null, new AnonymousClass3(this, null), 3, null);
        ((ArrayList) this.f394457g).add(r102);
        Job r103 = BuildersKt.launch$default(this.f394456f, null, null, new AnonymousClass5(this, null), 3, null);
        ((ArrayList) this.f394457g).add(r103);
    }

    public final void n(boolean r110) {
        IDoraPageConfig r100 = (IDoraPageConfig) ServiceManager.get().getService(IDoraPageConfig.class);
        if (r100 != null) goto L5;
        return;
    L5:
        AccountService r101 = AccountService.f365697a;
        String r102 = r101.getUserId();
        Long r103 = StringsKt.toLongOrNull(r102);
        if (r103 == null) goto L13;
        long r104 = r103.longValue();
        boolean r105 = true;
        if (r104 <= 0) goto L10;
        boolean r106 = true;
    L11:
        if (r106 != true) goto L13;
    L14:
        if (r105 == true) goto L16;
        return;
    L16:
        boolean r107 = r100.d("dora_g_config_key_env_observe_timer_enable", false);
        int r108 = j0.f375426a;
        String r109 = r100.f(EnvObserveViewModel.START_TIME_SET, j0.e("larus_dora_environmental_observation_time_range_default_start_time_cn"));
        String r111 = r100.f(EnvObserveViewModel.END_TIME_SET, j0.e("larus_dora_environmental_observation_time_range_default_end_time_cn"));
        if (Intrinsics.areEqual(r101.getUserId(), r102) == true) goto L19;
        return;
    L19:
        JSONObject r112 = new JSONObject();
        r112.put("user_id", r102);
        r112.put("enabled", r107);
        r112.put("start", r109);
        r112.put("end", r111);
        String r113 = r112.toString();
        if (r110 == true) goto L25;
        if (Intrinsics.areEqual(this.f394461k, r113) == false) goto L25;
        return;
    L25:
        if (p("glasses_environment_timer_settings", "query_support", "glasses_environment_timer_settings") == true) goto L28;
        return;
    L28:
        if (p("glasses_environment_timer_settings", r113, null) == false) goto L31;
        this.f394461k = r113;
        return;
    L31:
        return;
    L10:
        r106 = false;
    L13:
        r105 = false;
        goto L14
    }

    public static final Object h(CoWakeupService r110, Continuation r111) {
        r110.getClass();
        if ((r111 instanceof CoWakeupService$notifyChanged$1) == false) goto L7;
        CoWakeupService$notifyChanged$1 r100 = (CoWakeupService$notifyChanged$1) r111;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r112 = r100.result;
        Object r102 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r103 = r100.label;
        if (r103 == 0) goto L16;
        if (r103 == 1) goto L15;
        if (r103 != 2) goto L14;
        ResultKt.throwOnFailure(r112);
    L24:
        return Unit.INSTANCE;
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        DoraWearState r104 = (DoraWearState) r100.L$2;
        DoraConnectState r105 = (DoraConnectState) r100.L$1;
        DoraSwitchState r106 = (DoraSwitchState) r100.L$0;
        ResultKt.throwOnFailure(r112);
    L20:
        MutableSharedFlow<vha.a> r113 = r110.f394467q;
        vha.a.C8007a r114 = new vha.a.C8007a(r106, r105, r104);
        r100.L$0 = null;
        r100.L$1 = null;
        r100.L$2 = null;
        r100.label = 2;
        if (r113.emit(r114, r100) != r102) goto L24;
        return r102;
    L16:
        ResultKt.throwOnFailure(r112);
        r106 = (DoraSwitchState) r110.f394453c.getValue();
        DoraConnectState r115 = (DoraConnectState) r110.f394452b.getValue();
        r104 = (DoraWearState) r110.f394454d.getValue();
        FLogger.f375446a.i(r110.f394451a, "notifyChanged with state switch? " + r106 + " , and connect? " + r115 + ", and wearOn? " + r104);
        r100.L$0 = r106;
        r100.L$1 = r115;
        r100.L$2 = r104;
        r100.label = 1;
        if (r110.m(r115, r104, r100) == r102) goto L25;
        r105 = r115;
        goto L20
    L25:
        return r102;
    L7:
        r100 = new CoWakeupService$notifyChanged$1(r110, r111);
        goto L8
    }

    public final void k(boolean r100, boolean r101) {
        FLogger.f375446a.i(this.f394451a, "notifyDoraGConnectionStateForMemory, isDoraG=" + r100 + ", connected=" + r101 + ", lastState=" + this.f394458h);
        if (r100 == true) goto L8;
        if (this.f394458h != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.f394458h, Boolean.valueOf(r101)) == false) goto L10;
        return;
    L10:
        if (r101 == false) goto L12;
        String r102 = PTYSocketStateCallback.CONNECTED;
    L14:
        if (p("glasses_physical_connection_state", r102, null) == false) goto L17;
        this.f394458h = Boolean.valueOf(r101);
        return;
    L17:
        return;
    L12:
        r102 = "disconnected";
        goto L14
    }

    public final void l(boolean r100, boolean r101) {
        FLogger.f375446a.i(this.f394451a, "notifyDoraGReadyStateForMemory, isDoraG=" + r100 + ", ready=" + r101 + ", lastState=" + this.f394459i);
        if (r100 == true) goto L8;
        if (this.f394459i != null) goto L8;
        return;
    L8:
        if (Intrinsics.areEqual(this.f394459i, Boolean.valueOf(r101)) == false) goto L10;
        return;
    L10:
        if (r101 == false) goto L12;
        String r102 = PTYSocketStateCallback.CONNECTED;
    L14:
        if (p("glasses_connected_state", r102, null) == false) goto L17;
        this.f394459i = Boolean.valueOf(r101);
        return;
    L17:
        return;
    L12:
        r102 = "disconnected";
        goto L14
    }

    public static final Object i(CoWakeupService r100, boolean r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof CoWakeupService$notifyEnvironmentMemoryStateForMemory$1) == false) goto L7;
        CoWakeupService$notifyEnvironmentMemoryStateForMemory$1 r103 = (CoWakeupService$notifyEnvironmentMemoryStateForMemory$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        boolean r108 = true;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L13;
        r101 = r103.Z$0;
        kotlinx.coroutines.sync.a r109 = (kotlinx.coroutines.sync.a) r103.L$0;
        ResultKt.throwOnFailure(r105);
    L66:
        IPrivacyService r110 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);     // Catch: Throwable -> L63
        if (r110 != null) goto L21;
    L23:
        boolean r111 = false;
    L24:
        if (r111 == false) goto L59;
        r100.o();     // Catch: Throwable -> L63
        r100.n(r101);     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        IDoraService r112 = j();     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        if (r112 == null) goto L59;
        r r113 = r112.g1();     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        if (r113 == null) goto L59;
        boolean r114 = r113.b();     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        if (r101 == true) goto L41;
        Boolean r115 = r100.f394460j;     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
        if (r114 == false) goto L36;
        boolean r116 = true;
    L38:
        if (Intrinsics.areEqual(r115, Boxing.boxBoolean(r116)) == false) goto L41;
    L36:
        r116 = false;
    L41:
        if (r114 == false) goto L43;
        boolean r117 = true;
    L44:
        if (r117 == false) goto L46;
        String r118 = PTYSocketStateCallback.CONNECTED;
    L48:
        if (r100.p("glasses_environment_memory_enabled", r118, null) == false) goto L59;
        if (r114 == true) goto L52;
        r108 = false;
    L52:
        r100.f394460j = Boxing.boxBoolean(r108);     // Catch: RuntimeException -> L54 CancellationException -> L56 Throwable -> L63
    L46:
        r118 = "disconnected";
        goto L48
    L43:
        r117 = false;
    L56:
        e = move-exception;
        throw e;     // Catch: Throwable -> L63
    L54:
        e = move-exception;
        FLogger.f375446a.e(r100.f394451a, "notify environment memory state failed", e);     // Catch: Throwable -> L63
    L59:
        Unit r119 = Unit.INSTANCE;     // Catch: Throwable -> L63
        r109.unlock(null);
        return Unit.INSTANCE;
    L21:
        if (r110.a() != true) goto L23;
        r111 = true;
    L63:
        th = move-exception;
        r109.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        MutexImpl r120 = r100.f394463m;
        r103.L$0 = r120;
        r103.Z$0 = r101;
        r103.label = 1;
        if (r120.a(null, r103) == r106) goto L69;
        r109 = r120;
        goto L66
    L69:
        return r106;
    L7:
        r103 = new CoWakeupService$notifyEnvironmentMemoryStateForMemory$1(r100, r102);
        goto L8
    }

    @Override // h49.l
    public final void f(boolean r100, boolean r101, d r110) {
        Intrinsics.checkNotNullParameter(r110, "deviceInfo");
        BuildersKt.launch$default(this.f394455e, null, null, new CoWakeupService$onWearStateChanged$1(this, r100, r101, null), 3, null);
    }

    public final Object m(DoraConnectState r100, DoraWearState r110, Continuation<? super Unit> r111) {
        if ((r111 instanceof CoWakeupService$notifyDoraGStatesForMemory$1) == false) goto L7;
        CoWakeupService$notifyDoraGStatesForMemory$1 r101 = (CoWakeupService$notifyDoraGStatesForMemory$1) r111;
        int r102 = r101.label;
        if ((r102 & Integer.MIN_VALUE) == 0) goto L7;
        r101.label = r102 - Integer.MIN_VALUE;
    L8:
        Object r112 = r101.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r101.label;
        boolean r105 = true;
        if (r104 == 0) goto L14;
        if (r104 != 1) goto L13;
        kotlinx.coroutines.sync.a r106 = (kotlinx.coroutines.sync.a) r101.L$2;
        r110 = (DoraWearState) r101.L$1;
        DoraConnectState r107 = (DoraConnectState) r101.L$0;
        ResultKt.throwOnFailure(r112);
        kotlinx.coroutines.sync.a r113 = r106;
        r100 = r107;
    L71:
        IPrivacyService r108 = (IPrivacyService) ServiceManager.get().getService(IPrivacyService.class);     // Catch: Throwable -> L68
        if (r108 != null) goto L20;
    L22:
        boolean r109 = false;
    L23:
        if (r109 == true) goto L25;
        FLogger.f375446a.i(this.f394451a, "skip notifying DoraG state before privacy agreed");     // Catch: Throwable -> L68
    L63:
        Unit r114 = Unit.INSTANCE;     // Catch: Throwable -> L68
        r113.unlock(null);
        return Unit.INSTANCE;
    L25:
        o();     // Catch: Throwable -> L68
        IDoraService r115 = j();     // Catch: RuntimeException -> L61 CancellationException -> L66 Throwable -> L68
        if (r115 == null) goto L29;
        DeviceService r116 = r115.device();     // Catch: RuntimeException -> L61 CancellationException -> L66 Throwable -> L68
    L30:
        if (r116 != null) goto L32;
    L34:
        boolean r117 = false;
    L35:
        if (r117 == true) goto L37;
    L45:
        boolean r118 = false;
    L46:
        if (r117 == true) goto L48;
    L50:
        boolean r119 = false;
    L51:
        if (r119 == false) goto L53;
        boolean r120 = true;
    L54:
        k(r117, r120);     // Catch: RuntimeException -> L61 CancellationException -> L66 Throwable -> L68
        if (r119 == false) goto L58;
        if (r118 == false) goto L58;
    L59:
        l(r117, r105);     // Catch: RuntimeException -> L61 CancellationException -> L66 Throwable -> L68
    L58:
        r105 = false;
        goto L59
    L53:
        r120 = false;
        goto L54
    L48:
        if (r100 != DoraConnectState.CONNECTED) goto L50;
        r119 = true;
        goto L51
    L37:
        if (r110 == DoraWearState.ON) goto L44;
        if (r116 != null) goto L40;
    L42:
        boolean r121 = false;
    L43:
        if (r121 == false) goto L45;
    L40:
        if (r116.S() != true) goto L42;
        r121 = true;
    L44:
        r118 = true;
        goto L46
    L32:
        if (r116.M() != true) goto L34;
        r117 = true;
        goto L35
    L29:
        r116 = null;
    L66:
        e = move-exception;
        throw e;     // Catch: Throwable -> L68
    L61:
        e = move-exception;
        FLogger.f375446a.e(this.f394451a, "notifyDoraGStatesForMemory failed, connect=" + r100 + ", wear=" + r110, e);     // Catch: Throwable -> L68
        goto L63
    L20:
        if (r108.a() != true) goto L22;
        r109 = true;
    L68:
        th = move-exception;
        r113.unlock(null);
        throw th;
    L13:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r112);
        r113 = this.f394463m;
        r101.L$0 = r100;
        r101.L$1 = r110;
        r101.L$2 = r113;
        r101.label = 1;
        if (r113.a(null, r101) != r103) goto L71;
        return r103;
    L7:
        r101 = new CoWakeupService$notifyDoraGStatesForMemory$1(this, r111);
        goto L8
    }

    /* JADX WARN: Multi-variable type inference failed */
    public final boolean p(String r110, String r111, String r112) {
        pka.a r100 = pka.a.f529681a;     // Catch: RuntimeException -> L10 CancellationException -> L14
        Context r101 = AppHost.f326268a.getApplication().getApplicationContext();     // Catch: RuntimeException -> L10 CancellationException -> L14
        r100.getClass();     // Catch: RuntimeException -> L10 CancellationException -> L14
        MemoryResponse r113 = pka.a.d(r101, r110, r111);     // Catch: RuntimeException -> L10 CancellationException -> L14
        if (r113.a() == true) goto L6;
        FLogger.f375446a.w(this.f394451a, "notifyMemoryDataGlassesState rejected, key=" + r110 + ", code=" + r113.f397051a);     // Catch: RuntimeException -> L10 CancellationException -> L14
        r110 = r110;
    L16:
    L12:
        return false;
    L6:
        if (r112 == null) goto L9;
        boolean r114 = Intrinsics.areEqual(r113.f397052b, r112);     // Catch: RuntimeException -> L10 CancellationException -> L14
        r110 = r114;
        if (r114 == false) goto L16;
    L9:
        return true;
    L14:
        e = move-exception;
        throw e;
    L10:
        e = move-exception;
        String r115 = ArraysKt.joinToString$default(e.getStackTrace(), "\n", null, null, 8, null, null, 54, null);
        FLogger.f375446a.e(this.f394451a, "notifyMemoryDataGlassesState failed, key=" + r110 + ", error=" + e.getClass().getSimpleName() + ", stack=" + r115);
        goto L12
    }

    @Override // t39.n
    public final void e(int r100, int r101, String r102, String r110) {
        Intrinsics.checkNotNullParameter(r102, "productName");
        BuildersKt.launch$default(this.f394455e, null, null, new CoWakeupService$onDoraLinkChanged$1(r100, this, null), 3, null);
    }
}
