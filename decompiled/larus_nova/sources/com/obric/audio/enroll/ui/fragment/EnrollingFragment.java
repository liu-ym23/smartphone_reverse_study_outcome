package com.obric.audio.enroll.ui.fragment;

import android.content.Context;
import android.net.ConnectivityManager;
import android.net.Network;
import android.net.NetworkCapabilities;
import android.net.NetworkRequest;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import androidx.appcompat.widget.AppCompatTextView;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.Guideline;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewModelProvider;
import androidx.viewbinding.ViewBindings;
import com.airbnb.lottie.LottieAnimationView;
import com.bytedance.android.live.ktv.common.util.KtvSubElement;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.larus.bmhome.view.NovaTitleBarEx;
import com.larus.dora.api.IDoraService;
import com.larus.dora.impl.serviceimpl.DeviceService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.obric.audio.enroll.base.BaseFragment;
import com.obric.audio.enroll.model.TipsCode;
import com.obric.audio.enroll.recorder.VoicePrintEnrollRecordingsMgr;
import com.obric.audio.enroll.view.EnrollStageView;
import com.obric.audio.enroll.vm.EnrollViewModel;
import com.obric.audio.impl.databinding.SvaEnrollingFragmentBinding;
import com.obric.oui.titlebar.OFloatingTitleBar;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.android.ugc.bytex.pthread.base.proxy.PthreadHandlerThreadV2;
import com.ss.android.ugc.effectmanager.common.EffectConstants;
import com.ss.ttm.player.MediaPlayer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import kotlin.Metadata;
import kotlin.NoWhenBranchMatchedException;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.enums.EnumEntries;
import kotlin.enums.EnumEntriesKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.TimeoutKt;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\b\n\u0002\b\b\u0018\u0000 02\u00020\u0001:\u00040123B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J$\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001c2\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\u001a\u0010\u001d\u001a\u00020\u00142\u0006\u0010\u001e\u001a\u00020\u00182\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u0016J\b\u0010\u001f\u001a\u00020\u0014H\u0002J\b\u0010 \u001a\u00020\fH\u0002J\u0016\u0010!\u001a\u00020\u00142\u0006\u0010\"\u001a\u00020#H\u0082@¢\u0006\u0002\u0010$J\b\u0010%\u001a\u00020\u0014H\u0002J\u0010\u0010&\u001a\u00020\u00142\u0006\u0010'\u001a\u00020#H\u0002J\b\u0010(\u001a\u00020\u0014H\u0002J\b\u0010)\u001a\u00020\u0014H\u0016J\u0010\u0010*\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0002J\u0010\u0010.\u001a\u00020\u00142\u0006\u0010+\u001a\u00020,H\u0002J\b\u0010/\u001a\u00020\u0014H\u0002R\u0010\u0010\u0004\u001a\u0004\u0018\u00010\u0005X\u0082\u000e¢\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\u00020\u00058BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\u0007\u0010\bR\u000e\u0010\t\u001a\u00020\nX\u0082.¢\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0010X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u0011\u001a\u00020\u0012X\u0082\u000e¢\u0006\u0002\n\u0000¨\u00064"}, d2 = {"Lcom/obric/audio/enroll/ui/fragment/EnrollingFragment;", "Lcom/obric/audio/enroll/base/BaseFragment;", "<init>", "()V", "_realBinding", "Lcom/obric/audio/impl/databinding/SvaEnrollingFragmentBinding;", "binding", "getBinding", "()Lcom/obric/audio/impl/databinding/SvaEnrollingFragmentBinding;", "viewModel", "Lcom/obric/audio/enroll/vm/EnrollViewModel;", "animationPlaying", "", "tipThread", "Landroid/os/HandlerThread;", "tipHandler", "Landroid/os/Handler;", "tipState", "Lcom/obric/audio/enroll/ui/fragment/EnrollingFragment$TipState;", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "onCreateView", "Landroid/view/View;", "inflater", "Landroid/view/LayoutInflater;", KtvSubElement.CONTAINER, "Landroid/view/ViewGroup;", "onViewCreated", "view", "observe", "fasterSpeedText", "handleTipsBlocking", "ev", "Lcom/obric/audio/enroll/model/TipTextEvent;", "(Lcom/obric/audio/enroll/model/TipTextEvent;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "navigateToTimeout", "showTip", "event", "navigateToResult", "onDestroyView", "showRippleOnce", "index", "", "playSuccessTone", "vibrateSuccessEffect", "requestRecordPermission", "Companion", "DoraLinkStateObserver", "NetworkStateObserver", "TipState", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class EnrollingFragment extends BaseFragment {

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public static final /* synthetic */ int f395613k = 0;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public SvaEnrollingFragmentBinding f395614e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public EnrollViewModel f395615f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public boolean f395616g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PthreadHandlerThreadV2 f395617h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Handler f395618i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public volatile TipState f395619j;

    @Metadata(d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\t\b\u0002¢\u0006\u0004\b\u0002\u0010\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007¨\u0006\b"}, d2 = {"Lcom/obric/audio/enroll/ui/fragment/EnrollingFragment$TipState;", "", "<init>", "(Ljava/lang/String;I)V", "NA", EffectConstants.NORMAL, "ERROR", "CHANGING", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
    public static final enum TipState extends Enum<TipState> {
        public static final TipState CHANGING = null;
        public static final TipState ERROR = null;
        public static final TipState NA = null;
        public static final TipState NORMAL = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ TipState[] f395620a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final /* synthetic */ EnumEntries f395621b = null;

        public static EnumEntries<TipState> getEntries() {
            return f395621b;
        }

        static {
            TipState r100 = new TipState("NA", 0);
            NA = r100;
            TipState r101 = new TipState(EffectConstants.NORMAL, 1);
            NORMAL = r101;
            TipState r102 = new TipState("ERROR", 2);
            ERROR = r102;
            TipState r103 = new TipState("CHANGING", 3);
            CHANGING = r103;
            TipState[] r104 = {r100, r101, r102, r103};
            f395620a = r104;
            f395621b = EnumEntriesKt.enumEntries(r104);
        }

        public static TipState[] values() {
            return (TipState[]) f395620a.clone();
        }

        public static TipState valueOf(String r100) {
            return (TipState) r27.a.a(TipState.class, r100);
        }

        public TipState(String r100, int r101) {
            super(r100, r101);
        }
    }

    public static final class a {
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f395622a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final CopyOnWriteArraySet<Function1<Integer, Unit>> f395623b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static volatile int f395624c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f395625d = null;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static volatile boolean f395626e;

        public static final class a implements t39.n {
            public a() {
            }

            @Override // t39.n
            public final void e(int r100, int r101, String r102, String r103) {
                Intrinsics.checkNotNullParameter(r102, "productName");
                if (r100 == b.f395624c) goto L5;
                b r104 = b.f395622a;
                b.f395624c = r100;
                FLogger.f375446a.i("EnrollingFragment", "onDoraLinkChanged state=" + r100 + " productId=" + r101);
            L5:
                Iterator<Function1<Integer, Unit>> r105 = b.f395623b.iterator();
            L7:
                if (r105.hasNext() == false) goto L9;
                r105.next().invoke(Integer.valueOf(r100));
                goto L7
            }
        }

        public b() {
        }

        static {
            f395622a = new b();
            f395623b = new CopyOnWriteArraySet();
            f395624c = Integer.MIN_VALUE;
            f395625d = new a();
        }

        public final void a(z r100) {
            Intrinsics.checkNotNullParameter(r100, "listener");
            if (f395626e == true) goto L16;
            monitor-enter(this);
        L22:
            th = move-exception;
            throw th;
        L7:
            if (f395626e == false) goto L10;
            monitor-exit(this);
            goto L16
        L10:
            IDoraService r101 = (IDoraService) ServiceManager.get().getService(IDoraService.class);     // Catch: Throwable -> L22
            if (r101 != null) goto L14;
            monitor-exit(this);
            goto L16
        L14:
            r101.G(f395625d);     // Catch: Throwable -> L22
            f395626e = true;     // Catch: Throwable -> L22
            FLogger.f375446a.i("EnrollingFragment", "registerDoraLinkCallback done");     // Catch: Throwable -> L22
            Unit r102 = Unit.INSTANCE;     // Catch: Throwable -> L22
            monitor-exit(this);
        L16:
            CopyOnWriteArraySet<Function1<Integer, Unit>> r103 = f395623b;
            r103.add(r100);
            FLogger r104 = FLogger.f375446a;
            r104.i("EnrollingFragment", "addListener size=" + r103.size());
            IDoraService r105 = (IDoraService) ServiceManager.get().getService(IDoraService.class);
            if (r105 == null) goto L27;
            DeviceService r106 = r105.device();
            if (r106 == null) goto L28;
            int r107 = r106.u();
            r104.i("EnrollingFragment", "addListener emit currentState=" + r107);
            r100.invoke(Integer.valueOf(r107));
            return;
        L28:
            return;
        }
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f395627a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final CopyOnWriteArraySet<Function1<Boolean, Unit>> f395628b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static volatile Boolean f395629c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static volatile boolean f395630d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static volatile Context f395631e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public static final a f395632f = null;

        public static final class a extends ConnectivityManager.NetworkCallback {
            public a() {
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onAvailable(Network r100) {
                Intrinsics.checkNotNullParameter(r100, "network");
                c r101 = c.f395627a;
                c.b();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onLost(Network r100) {
                Intrinsics.checkNotNullParameter(r100, "network");
                c r101 = c.f395627a;
                c.b();
            }

            @Override // android.net.ConnectivityManager.NetworkCallback
            public final void onCapabilitiesChanged(Network r100, NetworkCapabilities r101) {
                Intrinsics.checkNotNullParameter(r100, "network");
                Intrinsics.checkNotNullParameter(r101, "networkCapabilities");
                c r102 = c.f395627a;
                c.b();
            }
        }

        public c() {
        }

        static {
            f395627a = new c();
            f395628b = new CopyOnWriteArraySet();
            f395632f = new a();
        }

        public static void b() {
            Context r100 = f395631e;
            if (r100 != null) goto L5;
            return;
        L5:
            boolean r101 = sia.e.a(r100);
            if (Intrinsics.areEqual(Boolean.valueOf(r101), f395629c) == true) goto L8;
            f395629c = Boolean.valueOf(r101);
            FLogger.f375446a.i("EnrollingFragment", "networkState available=" + r101);
        L8:
            Iterator<Function1<Boolean, Unit>> r102 = f395628b.iterator();
        L10:
            if (r102.hasNext() == false) goto L12;
            r102.next().invoke(Boolean.valueOf(r101));
            goto L10
        }

        public final void a(Context r100, Function1<? super Boolean, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
            Intrinsics.checkNotNullParameter(r101, "listener");
            FLogger.f375446a.i("EnrollingFragment", "NetworkStateObserver.addListener sizeBefore=" + f395628b.size());
            Context r102 = r100.getApplicationContext();
            if (f395630d == true) goto L40;
            monitor-enter(this);
        L42:
            th = move-exception;
            throw th;
        L7:
            if (f395630d == false) goto L10;
            monitor-exit(this);
            goto L40
        L10:
            Object r103 = r102.getSystemService("connectivity");     // Catch: Throwable -> L42
            if ((r103 instanceof ConnectivityManager) == false) goto L14;
            ConnectivityManager r104 = (ConnectivityManager) r103;     // Catch: Throwable -> L42
        L15:
            if (r104 != null) goto L18;
            monitor-exit(this);
            goto L40
        L18:
            f395631e = r102;     // Catch: Throwable -> L42
            Result.Companion r105 = Result.Companion;     // Catch: Throwable -> L25
            if (Build.VERSION.SDK_INT < 24) goto L22;
            r104.registerDefaultNetworkCallback(f395632f);     // Catch: Throwable -> L25
        L23:
            Object r106 = Result.m9449constructorimpl(Boolean.TRUE);     // Catch: Throwable -> L25
        L27:
            Throwable r107 = Result.m9452exceptionOrNullimpl(r106);     // Catch: Throwable -> L42
            if (r107 == null) goto L30;
            FLogger.f375446a.e("EnrollingFragment", "NetworkStateObserver register failed: " + r107.getMessage());     // Catch: Throwable -> L42
        L30:
            Boolean r108 = Boolean.FALSE;     // Catch: Throwable -> L42
            if (Result.m9455isFailureimpl(r106) == false) goto L34;
            r106 = r108;
        L34:
            if (((Boolean) r106).booleanValue() == true) goto L38;
            monitor-exit(this);
            goto L40
        L38:
            f395630d = true;     // Catch: Throwable -> L42
            b();     // Catch: Throwable -> L42
            Unit r109 = Unit.INSTANCE;     // Catch: Throwable -> L42
            monitor-exit(this);
            goto L40
        L22:
            r104.registerNetworkCallback(new NetworkRequest.Builder().addCapability(12).build(), f395632f);     // Catch: Throwable -> L25
        L25:
            th = move-exception;
            Result.Companion r110 = Result.Companion;     // Catch: Throwable -> L42
            r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));     // Catch: Throwable -> L42
            goto L27
        L14:
            r104 = null;
        L40:
            f395628b.add(r101);
            r101.invoke(Boolean.valueOf(sia.e.a(r100.getApplicationContext())));
        }
    }

    public /* synthetic */ class d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f395633a = null;

        static {
            int[] r100 = new int[TipsCode.values().length];
            r100[TipsCode.TIPS_CODE_SAY_it.ordinal()] = 1;     // Catch: NoSuchFieldError -> L16
        L31:
            r100[TipsCode.TIPS_CODE_FASTER_SAY_it.ordinal()] = 2;     // Catch: NoSuchFieldError -> L17
        L47:
            r100[TipsCode.TIPS_CODE_CHECK_SENTENCE_ERROR.ordinal()] = 3;     // Catch: NoSuchFieldError -> L18
        L35:
            r100[TipsCode.TIPS_CODE_CHECK_SENTENCE_NETWORK.ordinal()] = 4;     // Catch: NoSuchFieldError -> L19
        L39:
            r100[TipsCode.TIPS_CODE_ERROR_TEXT_SIMILARITY.ordinal()] = 5;     // Catch: NoSuchFieldError -> L20
        L27:
            r100[TipsCode.TIPS_CODE_CHECKING_ENROLL.ordinal()] = 6;     // Catch: NoSuchFieldError -> L21
        L41:
            r100[TipsCode.TIPS_CODE_VAD_END_AND_NOT_ENOUGH_SIZE.ordinal()] = 7;     // Catch: NoSuchFieldError -> L22
        L43:
            r100[TipsCode.TIPS_CODE_ASR_TASK_START_FAILED.ordinal()] = 8;     // Catch: NoSuchFieldError -> L23
        L33:
            r100[TipsCode.TIPS_CODE_ASR_SESSION_START_FAILED.ordinal()] = 9;     // Catch: NoSuchFieldError -> L24
        L37:
            r100[TipsCode.TIPS_CODE_ASR_NETWORK_ERROR.ordinal()] = 10;     // Catch: NoSuchFieldError -> L25
        L29:
            r100[TipsCode.TIPS_CODE_ASR_TIMEOUT_RETRY.ordinal()] = 11;     // Catch: NoSuchFieldError -> L26
        L14:
            f395633a = r100;
        }
    }

    /* JADX INFO: renamed from: com.obric.audio.enroll.ui.fragment.EnrollingFragment$onDestroyView$1, reason: invalid class name and case insensitive filesystem */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.audio.enroll.ui.fragment.EnrollingFragment$onDestroyView$1", f = "EnrollingFragment.kt", i = {}, l = {MediaPlayer.MEDIA_PLAYER_OPTION_ENABLE_PRELOAD_GEAR}, m = "invokeSuspend", n = {}, s = {})
    public static final class C116521 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ EnrollingFragment this$0;

        public C116521(EnrollingFragment r100, Continuation<? super C116521> r101) {
            this.this$0 = r100;
            super(2, r101);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C116521(this.this$0, r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C116521) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            Object r101 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
            int r102 = this.label;
            if (r102 == 0) goto L8;
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L15:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            EnrollViewModel r103 = this.this$0.f395615f;
            if (r103 != null) goto L11;
            Intrinsics.throwUninitializedPropertyAccessException("viewModel");
            r103 = null;
        L11:
            VoicePrintEnrollRecordingsMgr r104 = r103.getRecordingManager();
            this.label = 1;
            if (r104.d(this) != r101) goto L15;
            return r101;
        }
    }

    static {
    }

    @Override // androidx.fragment.app.Fragment
    public final void onDestroyView() {
        FLogger.f375446a.i("EnrollingFragment", "onDestroyView ..");
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate())), null, null, new C116521(this, null), 3, null);
        super.onDestroyView();
        SvaEnrollingFragmentBinding r100 = this.f395614e;
        Intrinsics.checkNotNull(r100);
        r100.f395803j.cancelAnimation();
        this.f395614e = null;
    }

    public EnrollingFragment() {
        this.f395617h = new PthreadHandlerThreadV2("tipThread");
        this.f395619j = TipState.NA;
    }

    @Override // com.obric.audio.enroll.base.BaseFragment, androidx.fragment.app.Fragment
    public final void onCreate(Bundle r100) {
        super.onCreate(r100);
        this.f395615f = (EnrollViewModel) new ViewModelProvider(requireActivity()).get(EnrollViewModel.class);
    }

    /* JADX WARN: Type inference failed for: r11v13, types: [com.obric.audio.enroll.ui.fragment.t] */
    @Override // androidx.fragment.app.Fragment
    public final void onViewCreated(View r110, Bundle r111) {
        Intrinsics.checkNotNullParameter(r110, "view");
        super.onViewCreated(r110, r111);
        EnrollViewModel r112 = null;
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()), null, null, new EnrollingFragment$observe$1(this, null), 3, null);
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new EnrollingFragment$observe$2(this, null));
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new EnrollingFragment$observe$3(this, null));
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new EnrollingFragment$observe$4(this, null));
        LifecycleOwnerKt.getLifecycleScope(getViewLifecycleOwner()).launchWhenStarted(new EnrollingFragment$observe$5(this, null));
        SvaEnrollingFragmentBinding r113 = this.f395614e;
        Intrinsics.checkNotNull(r113);
        r113.f395798e.U5(getViewLifecycleOwner());
        if (t9a.b.a().b() == true) goto L9;
        SvaEnrollingFragmentBinding r114 = this.f395614e;
        if (r114 == null) goto L9;
        Guideline r115 = r114.f395799f;
        if (r115 == null) goto L9;
        r115.setGuidelinePercent(0.85f);
    L9:
        final ?? r116 = new t(this);
        if (t9a.b.a().b() == true) goto L18;
        EnrollViewModel r100 = this.f395615f;
        if (r100 != null) goto L15;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
        r100 = null;
    L15:
        if (Intrinsics.areEqual(r100.getStartFrom(), "DoubaoGuide") == false) goto L18;
        int r101 = rda.a.f537347a;
        SvaEnrollingFragmentBinding r102 = this.f395614e;
        Intrinsics.checkNotNull(r102);
        NovaTitleBarEx.b6(rda.a.b(r102.f395801h), R.drawable.larus_ic_left_back, false, null, null, new v(r116), 14);
    L19:
        EnrollViewModel r117 = this.f395615f;
        if (r117 != null) goto L22;
        Intrinsics.throwUninitializedPropertyAccessException("viewModel");
    L23:
        r112.setAlreadyEnroll(false);
        return;
    L22:
        r112 = r117;
    L18:
        SvaEnrollingFragmentBinding r103 = this.f395614e;
        Intrinsics.checkNotNull(r103);
        OFloatingTitleBar.i(r103.f395801h, R.drawable.o_floating_title_bar_icon_close, new u(r116));
        goto L19
    }

    public static final Object T90(EnrollingFragment r110, qia.q r111, Continuation r112) {
        r110.getClass();
        if ((r112 instanceof EnrollingFragment$handleTipsBlocking$1) == false) goto L7;
        EnrollingFragment$handleTipsBlocking$1 r100 = (EnrollingFragment$handleTipsBlocking$1) r112;
        int r101 = r100.label;
        if ((r101 & Integer.MIN_VALUE) == 0) goto L7;
        r100.label = r101 - Integer.MIN_VALUE;
    L8:
        Object r102 = r100.result;
        Object r103 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r104 = r100.label;
        if (r104 == 0) goto L18;
        if (r104 != 1) goto L17;
        qia.q r105 = (qia.q) r100.L$0;
        ResultKt.throwOnFailure(r102);     // Catch: Throwable -> L14
    L25:
        Object r106 = Result.m9449constructorimpl(Boxing.boxBoolean(((Boolean) r102).booleanValue()));     // Catch: Throwable -> L14
    L31:
        Throwable r107 = Result.m9452exceptionOrNullimpl(r106);
        if (r107 == null) goto L35;
        FLogger.f375446a.i("EnrollingFragment", "handleTipsBlocking failed : " + r107);
    L35:
        if (Result.m9456isSuccessimpl(r106) == false) goto L38;
        ((Boolean) r106).booleanValue();
        FLogger.f375446a.i("EnrollingFragment", "handleTipsBlocking success : " + r105.f533222a);
    L38:
        if (r110.isAdded() == false) goto L65;
        Ref.BooleanRef r108 = new Ref.BooleanRef();
        FLogger r109 = FLogger.f375446a;
        r109.i("EnrollingFragment", "showTip: " + r105.f533222a);
        boolean r113 = false;
        if (r105.f533222a.getV() >= 0) goto L43;
        boolean r114 = true;
    L44:
        r108.element = r114;
        switch(d.f395633a[r105.f533222a.ordinal()]) {
            case 1: goto L57;
            case 2: goto L56;
            case 3: goto L55;
            case 4: goto L54;
            case 5: goto L53;
            case 6: goto L52;
            case 7: goto L51;
            case 8: goto L50;
            case 9: goto L50;
            case 10: goto L49;
            case 11: goto L48;
            default: goto L47;
        };
    L48:
        String r115 = r110.getResources().getString(R.string.sva_enroll_asr_timeout_retry);
    L58:
        Intrinsics.checkNotNull(r115);
        if (r115.length() != 0) goto L61;
        r113 = true;
    L61:
        if (r113 == true) goto L65;
        r109.i("EnrollingFragment", "updateTip state : " + r110.f395619j + " , content " + r105.f533222a);
        CountDownLatch r116 = new CountDownLatch(1);
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(r110.getViewLifecycleOwner()), null, null, new EnrollingFragment$showTip$1(r108, r110, r115, r116, null), 3, null);
        r116.await(3, TimeUnit.SECONDS);
        goto L65
    L49:
        r115 = r110.getResources().getString(R.string.sva_enroll_asr_network_error);
        goto L58
    L50:
        r115 = r110.getResources().getString(R.string.sva_enroll_asr_start_failed);
        goto L58
    L51:
        r115 = r110.getResources().getString(R.string.sva_enroll_vad_end_and_not_enough_size);
        goto L58
    L52:
        r115 = r110.getResources().getString(R.string.sva_enroll_checking);
        goto L58
    L53:
        r115 = r110.getResources().getString(R.string.sva_enroll_error_text_similarity);
        goto L58
    L54:
        r115 = r110.getResources().getString(R.string.sva_enroll_check_sentence_network);
        goto L58
    L55:
        r115 = r110.getResources().getString(R.string.sva_enroll_check_sentence_error);
        goto L58
    L56:
        r115 = r110.getResources().getString(R.string.sva_faster_say_it);
        goto L58
    L57:
        r115 = r110.getResources().getString(R.string.sva_say_it);
        goto L58
    L47:
        throw new NoWhenBranchMatchedException();
    L43:
        r114 = false;
    L65:
        return Unit.INSTANCE;
    L14:
        th = th;
        qia.q r117 = r105;
    L30:
        Result.Companion r118 = Result.Companion;
        r106 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        r105 = r117;
        goto L31
    L17:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L18:
        ResultKt.throwOnFailure(r102);
        if (r110.isAdded() == false) goto L70;
        Result.Companion r119 = Result.Companion;     // Catch: Throwable -> L28
        EnrollingFragment$handleTipsBlocking$2$1 r120 = new EnrollingFragment$handleTipsBlocking$2$1(r110, null);     // Catch: Throwable -> L28
        r100.L$0 = r111;     // Catch: Throwable -> L28
        r100.label = 1;     // Catch: Throwable -> L28
        r102 = TimeoutKt.b(3000, r120, r100);     // Catch: Throwable -> L28
        if (r102 == r103) goto L71;
        r105 = r111;
        goto L25
    L71:
        return r103;
    L28:
        th = th;
        r117 = r111;
        goto L30
    L70:
        return Unit.INSTANCE;
    L7:
        r100 = new EnrollingFragment$handleTipsBlocking$1(r110, r112);
        goto L8
    }

    @Override // androidx.fragment.app.Fragment
    public final View onCreateView(LayoutInflater r110, ViewGroup r111, Bundle r112) {
        Intrinsics.checkNotNullParameter(r110, "inflater");
        FLogger.f375446a.i("EnrollingFragment", "onCreateView ..");
        View r113 = r110.inflate(R.layout.sva_enrolling_fragment, r111, false);
        int r114 = R.id.enrolling_guideline;
        if (((Guideline) ViewBindings.findChildViewById(r113, R.id.enrolling_guideline)) == null) goto L37;
        r114 = R.id.error_tip_view;
        AppCompatTextView r100 = (AppCompatTextView) ViewBindings.findChildViewById(r113, R.id.error_tip_view);
        if (r100 == null) goto L37;
        r114 = R.id.guide_page;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.guide_page)) == null) goto L37;
        r114 = R.id.index_indicator;
        AppCompatTextView r101 = (AppCompatTextView) ViewBindings.findChildViewById(r113, R.id.index_indicator);
        if (r101 == null) goto L37;
        r114 = R.id.ripple_area;
        View r102 = ViewBindings.findChildViewById(r113, R.id.ripple_area);
        if (r102 == null) goto L37;
        r114 = R.id.stage_area;
        EnrollStageView r103 = (EnrollStageView) ViewBindings.findChildViewById(r113, R.id.stage_area);
        if (r103 == null) goto L37;
        r114 = R.id.stage_bottom_line;
        if (((Guideline) ViewBindings.findChildViewById(r113, R.id.stage_bottom_line)) == null) goto L37;
        r114 = R.id.stage_foot_line;
        Guideline r104 = (Guideline) ViewBindings.findChildViewById(r113, R.id.stage_foot_line);
        if (r104 == null) goto L37;
        r114 = R.id.stage_left_border_line;
        if (((Guideline) ViewBindings.findChildViewById(r113, R.id.stage_left_border_line)) == null) goto L37;
        r114 = R.id.stage_neck_line;
        if (((Guideline) ViewBindings.findChildViewById(r113, R.id.stage_neck_line)) == null) goto L37;
        r114 = R.id.stage_top_line;
        if (((Guideline) ViewBindings.findChildViewById(r113, R.id.stage_top_line)) == null) goto L37;
        r114 = R.id.tip_view;
        AppCompatTextView r105 = (AppCompatTextView) ViewBindings.findChildViewById(r113, R.id.tip_view);
        if (r105 == null) goto L37;
        r114 = R.id.title_bar;
        OFloatingTitleBar r106 = (OFloatingTitleBar) ViewBindings.findChildViewById(r113, R.id.title_bar);
        if (r106 == null) goto L37;
        r114 = R.id.title_bar_group;
        FrameLayout r107 = (FrameLayout) ViewBindings.findChildViewById(r113, R.id.title_bar_group);
        if (r107 == null) goto L37;
        r114 = R.id.top_zone;
        if (((ConstraintLayout) ViewBindings.findChildViewById(r113, R.id.top_zone)) == null) goto L37;
        r114 = R.id.voice_wave_view;
        LottieAnimationView r115 = (LottieAnimationView) ViewBindings.findChildViewById(r113, R.id.voice_wave_view);
        if (r115 == null) goto L37;
        this.f395614e = new SvaEnrollingFragmentBinding((LinearLayout) r113, r100, r101, r102, r103, r104, r105, r106, r107, r115);
        getLifecycle().addObserver(new AnonymousClass1());
        ThreadMethodProxy.start(this.f395617h);
        this.f395618i = new Handler(this.f395617h.getLooper(), new y(this));
        SvaEnrollingFragmentBinding r116 = this.f395614e;
        Intrinsics.checkNotNull(r116);
        return r116.f395794a;
    L37:
        throw new NullPointerException("Missing required view with ID: ".concat(r113.getResources().getResourceName(r114)));
    }
}
