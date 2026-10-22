package com.larus.voicecall.impl.component.notify;

import android.app.KeyguardManager;
import android.graphics.Bitmap;
import android.view.View;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.LifecycleOwnerKt;
import com.bytedance.common.utility.NetworkUtils;
import com.larus.audio.call.mgr.MajorState;
import com.larus.av_call.component.RealtimeComponent;
import com.larus.common.apphost.AppHost;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.l;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.utils.j;
import com.obric.assistant.ability.interaction.IRealtimeCallBridgeAbility;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineDispatcher;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.DelayKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.GlobalScope;
import kotlinx.coroutines.flow.FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1;
import kotlinx.coroutines.flow.MutableSharedFlow;

/* JADX INFO: loaded from: classes32.dex */
@Metadata(d1 = {"\u0000v\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0004\u0018\u0000 @2\u00020\u00012\u00020\u0002:\u0001@B\u0007¢\u0006\u0004\b\u0003\u0010\u0004J\b\u0010*\u001a\u00020+H\u0016J\b\u0010,\u001a\u00020+H\u0016J\b\u0010-\u001a\u00020+H\u0016J\b\u0010.\u001a\u00020+H\u0016J\u0010\u0010/\u001a\u00020+2\u0006\u00100\u001a\u000201H\u0016J\b\u00102\u001a\u00020+H\u0002J\b\u00103\u001a\u00020+H\u0002J(\u00104\u001a\u00020+2\u0006\u00105\u001a\u0002062\u0006\u00107\u001a\u0002082\u0006\u00109\u001a\u0002062\u0006\u0010:\u001a\u000208H\u0016J\u0010\u0010;\u001a\u00020+2\u0006\u0010<\u001a\u00020=H\u0002J\u0010\u0010>\u001a\u0004\u0018\u00010(H\u0082@¢\u0006\u0002\u0010?R\u001b\u0010\u0005\u001a\u00020\u00068BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\t\u0010\n\u001a\u0004\b\u0007\u0010\bR\u001b\u0010\u000b\u001a\u00020\f8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u000f\u0010\n\u001a\u0004\b\r\u0010\u000eR\u001d\u0010\u0010\u001a\u0004\u0018\u00010\u00118BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0014\u0010\n\u001a\u0004\b\u0012\u0010\u0013R\u001d\u0010\u0015\u001a\u0004\u0018\u00010\u00168BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0019\u0010\n\u001a\u0004\b\u0017\u0010\u0018R\u001d\u0010\u001a\u001a\u0004\u0018\u00010\u001b8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u001e\u0010\n\u001a\u0004\b\u001c\u0010\u001dR\u001d\u0010\u001f\u001a\u0004\u0018\u00010 8BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b#\u0010\n\u001a\u0004\b!\u0010\"R\u0012\u0010$\u001a\u0004\u0018\u00010%X\u0082\u000e¢\u0006\u0004\n\u0002\u0010&R\u0010\u0010'\u001a\u0004\u0018\u00010(X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010)\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006A"}, d2 = {"Lcom/larus/voicecall/impl/component/notify/RealtimeNotifyComponent;", "Lcom/larus/av_call/component/RealtimeComponent;", "Lcom/larus/voicecall/impl/component/notify/IRealtimeNotifyAbility;", "<init>", "()V", "argumentData", "Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "getArgumentData", "()Lcom/larus/voicecall/impl/bean/RealtimeArgumentData;", "argumentData$delegate", "Lkotlin/Lazy;", "runtimeData", "Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "getRuntimeData", "()Lcom/larus/voicecall/impl/bean/RealtimeRuntimeData;", "runtimeData$delegate", "windowAbility", "Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "getWindowAbility", "()Lcom/larus/voicecall/impl/component/window/IRealtimeWindowAbility;", "windowAbility$delegate", "coreAbility", "Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "getCoreAbility", "()Lcom/larus/voicecall/impl/component/core/IRealtimeCoreAbility;", "coreAbility$delegate", "traceAbility", "Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "getTraceAbility", "()Lcom/larus/voicecall/impl/component/trace/IRealtimeTraceAbility;", "traceAbility$delegate", "realtimeCallBridgeAbility", "Lcom/obric/assistant/ability/interaction/IRealtimeCallBridgeAbility;", "getRealtimeCallBridgeAbility", "()Lcom/obric/assistant/ability/interaction/IRealtimeCallBridgeAbility;", "realtimeCallBridgeAbility$delegate", "isScreenLocked", "", "Ljava/lang/Boolean;", "avatarBitmap", "Landroid/graphics/Bitmap;", "hasLoadRoundAvatarBitmap", "onAppBackground", "", "onAppForeground", "onAttach", "onVContextReady", "onViewCreated", "view", "Landroid/view/View;", "observeNotificationAction", "observerRealtimeCallAction", "onUpdateUIState", "currentMajorState", "Lcom/larus/audio/call/mgr/MajorState;", "currentState", "", "newMajorState", "newState", "refreshCallNotification", "reason", "", "getRoundAvatarBitmap", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeNotifyComponent extends RealtimeComponent implements com.larus.voicecall.impl.component.notify.a {

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public static final /* synthetic */ int f377569w = 0;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final Lazy f377570n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public final Lazy f377571o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public final Lazy f377572p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public final Lazy f377573q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public final Lazy f377574r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public final Lazy f377575s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public Boolean f377576t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Bitmap f377577u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public boolean f377578v;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent$onAppBackground$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.component.notify.RealtimeNotifyComponent$onAppBackground$1", f = "RealtimeNotifyComponent.kt", i = {}, l = {80}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;
        final /* synthetic */ RealtimeNotifyComponent this$0;

        public AnonymousClass1(RealtimeNotifyComponent r100, Continuation<? super AnonymousClass1> r101) {
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
            if (r102 != 1) goto L7;
            ResultKt.throwOnFailure(r100);
        L11:
            RealtimeNotifyComponent r103 = this.this$0;
            FragmentActivity r104 = s1a.a.c(r103).getActivity();
            Boolean r105 = null;
            if (r104 == null) goto L14;
            Object r106 = r104.getSystemService("keyguard");
        L16:
            if ((r106 instanceof KeyguardManager) == false) goto L18;
            KeyguardManager r107 = (KeyguardManager) r106;
        L19:
            if (r107 == null) goto L21;
            r105 = Boxing.boxBoolean(r107.isKeyguardLocked());
        L21:
            r103.f377576t = r105;
            n3a.a r108 = (n3a.a) this.this$0.f377574r.getValue();
            if (r108 == null) goto L25;
            r108.zb(Intrinsics.areEqual(this.this$0.f377576t, Boxing.boxBoolean(true)));
        L25:
            return Unit.INSTANCE;
        L18:
            r107 = null;
            goto L19
        L14:
            r106 = null;
            goto L16
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            this.label = 1;
            if (DelayKt.delay(500, this) != r101) goto L11;
            return r101;
        }
    }

    static {
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void A0() {
        e3a.a r100 = (e3a.a) this.f377570n.getValue();
        p3();
        com.larus.voicecall.impl.component.window.b r101 = (com.larus.voicecall.impl.component.window.b) this.f377572p.getValue();
        m3();
        n3a.a r102 = (n3a.a) this.f377574r.getValue();
    }

    public final com.larus.voicecall.impl.component.core.a m3() {
        return (com.larus.voicecall.impl.component.core.a) this.f377573q.getValue();
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void onAppBackground() {
        BuildersKt.launch$default(GlobalScope.INSTANCE, null, null, new AnonymousClass1(this, null), 3, null);
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void onAppForeground() {
        this.f377576t = Boolean.FALSE;
    }

    public final e3a.b p3() {
        return (e3a.b) this.f377571o.getValue();
    }

    @Override // com.larus.ui.arch.component.external.delegate.BaseComponentFeatureInternal
    public final void y2() {
        Intrinsics.checkNotNullParameter(this, "<this>");
        s1a.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this), this, com.larus.voicecall.impl.component.notify.a.class);
    }

    public RealtimeNotifyComponent() {
        this.f377570n = LazyKt.lazy(new b(this));
        this.f377571o = LazyKt.lazy(new c(this));
        this.f377572p = LazyKt.lazy(new d(this));
        this.f377573q = LazyKt.lazy(new e(this));
        this.f377574r = LazyKt.lazy(new f(this));
        this.f377575s = LazyKt.lazy(new g(this));
    }

    @Override // com.larus.av_call.component.RealtimeComponent, com.larus.ui.arch.component.external.delegate.BaseComponentWidget
    public final void onViewCreated(View r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        com.larus.voicecall.impl.notification.d.f378402a.getClass();
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 r101 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(com.larus.voicecall.impl.notification.d.f378403b, new RealtimeNotifyComponent$observeNotificationAction$1(this, null));
        Intrinsics.checkNotNullParameter(this, "<this>");
        kotlinx.coroutines.flow.e.x(r101, LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)));
        IRealtimeCallBridgeAbility r102 = (IRealtimeCallBridgeAbility) this.f377575s.getValue();
        if (r102 == null) goto L8;
        MutableSharedFlow<Integer> r103 = r102.fS();
        if (r103 == null) goto L9;
        FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1 r104 = new FlowKt__TransformKt$onEach$$inlined$unsafeTransform$1(r103, new RealtimeNotifyComponent$observerRealtimeCallAction$1(this, null));
        Intrinsics.checkNotNullParameter(this, "<this>");
        kotlinx.coroutines.flow.e.x(r104, LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this)));
        return;
    L9:
        return;
    }

    public static final Object h3(RealtimeNotifyComponent r100, Continuation r101) {
        r100.getClass();
        if ((r101 instanceof RealtimeNotifyComponent$getRoundAvatarBitmap$1) == false) goto L7;
        RealtimeNotifyComponent$getRoundAvatarBitmap$1 r102 = (RealtimeNotifyComponent$getRoundAvatarBitmap$1) r101;
        int r103 = r102.label;
        if ((r103 & Integer.MIN_VALUE) == 0) goto L7;
        r102.label = r103 - Integer.MIN_VALUE;
    L8:
        Object r104 = r102.result;
        Object r105 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r106 = r102.label;
        if (r106 == 0) goto L15;
        if (r106 != 1) goto L14;
        ResultKt.throwOnFailure(r104);     // Catch: Throwable -> L41
    L33:
        Bitmap r107 = (Bitmap) r104;     // Catch: Throwable -> L41
        if (r107 != null) goto L36;
    L43:
        r107 = null;
    L44:
        Object r108 = Result.m9449constructorimpl(r107);     // Catch: Throwable -> L41
    L47:
        Object r109 = r108;
        if (Result.m9455isFailureimpl(r109) == true) goto L50;
        return r109;
    L50:
        return null;
    L36:
        if ((!r107.isRecycled()) == true) goto L39;
        r107 = null;
    L39:
        if (r107 == null) goto L43;
        int r110 = j.f379546a;     // Catch: Throwable -> L41
        j.b(r107);     // Catch: Throwable -> L41
        r100.f377577u = r107;     // Catch: Throwable -> L41
        goto L44
    L14:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L15:
        ResultKt.throwOnFailure(r104);
        Bitmap r111 = r100.f377577u;
        if (r111 == null) goto L24;
        if (r111.isRecycled() != true) goto L20;
        boolean r112 = true;
    L21:
        if (r112 == true) goto L24;
        return r100.f377577u;
    L20:
        r112 = false;
    L24:
        if (r100.f377578v == false) goto L27;
        FLogger.f375446a.e("RealtimeNotifyComponent", "getRoundAvatarBitmap failed, cause load failed before");
        goto L50
    L27:
        if (NetworkUtils.isNetworkAvailable(AppHost.f326268a.getApplication()) == true) goto L29;
        FLogger.f375446a.e("RealtimeNotifyComponent", "getRoundAvatarBitmap failed, cause network not available");
        goto L50
    L29:
        r100.f377578v = true;
        Result.Companion r113 = Result.Companion;     // Catch: Throwable -> L41
        CoroutineDispatcher r114 = Dispatchers.getIO();     // Catch: Throwable -> L41
        RealtimeNotifyComponent$getRoundAvatarBitmap$2$1 r115 = new RealtimeNotifyComponent$getRoundAvatarBitmap$2$1(r100, null);     // Catch: Throwable -> L41
        r102.label = 1;     // Catch: Throwable -> L41
        r104 = BuildersKt.withContext(r114, r115, r102);     // Catch: Throwable -> L41
        if (r104 != r105) goto L33;
        return r105;
    L41:
        th = move-exception;
        Result.Companion r116 = Result.Companion;
        r108 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L7:
        r102 = new RealtimeNotifyComponent$getRoundAvatarBitmap$1(r100, r101);
        goto L8
    }

    @Override // com.larus.av_call.component.RealtimeComponent, g88.r
    public final void o1(MajorState r100, int r101, MajorState r102, int r110) {
        Intrinsics.checkNotNullParameter(r100, "currentMajorState");
        Intrinsics.checkNotNullParameter(r102, "newMajorState");
        FLogger.f375446a.i("RealtimeNotifyComponent", "new state: " + r110 + " current:" + r101);
        if (r110 != 9) goto L5;
    L13:
        if (r110 != 9) goto L17;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.f379446l != null) goto L17;
        return;
    L17:
        String r103 = "call_state_" + r110;
        if (p3().f484270k == 6) goto L28;
        Pair<Boolean, Boolean> r104 = l.f378359i;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (l.a.a(com.larus.ui.arch.component.internal.attach.a.b(this, this).requireContext()) == false) goto L30;
        Intrinsics.checkNotNullParameter(this, "<this>");
        if (com.larus.ui.arch.component.internal.attach.a.b(this, this).getView() == null) goto L31;
        Intrinsics.checkNotNullParameter(this, "<this>");
        BuildersKt.launch$default(LifecycleOwnerKt.getLifecycleScope(com.larus.ui.arch.component.internal.attach.a.b(this, this).getViewLifecycleOwner()), null, null, new RealtimeNotifyComponent$refreshCallNotification$1(this, r103, null), 3, null);
        return;
    L31:
        return;
    L30:
        return;
    L28:
        return;
    L5:
        if (r110 == 18) goto L13;
        if (r110 == 14) goto L13;
        if (r110 == 15) goto L13;
        switch(r110) {
            case 1: goto L13;
            case 2: goto L13;
            case 3: goto L13;
            case 4: goto L13;
            case 5: goto L13;
            case 6: goto L12;
            case 7: goto L13;
            default: goto L29;
        };
    L12:
        com.larus.voicecall.impl.notification.d.f378402a.getClass();
        com.larus.voicecall.impl.notification.d.d("call_net_error");
        return;
    }
}
