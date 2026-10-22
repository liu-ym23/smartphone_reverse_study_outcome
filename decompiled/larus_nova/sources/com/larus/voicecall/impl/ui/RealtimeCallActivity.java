package com.larus.voicecall.impl.ui;

import android.app.Activity;
import android.content.Intent;
import android.media.AudioManager;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.KeyEvent;
import android.view.OrientationEventListener;
import android.view.View;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.Lifecycle;
import com.bytedance.android.livesdkapi.LiveCommonConstants;
import com.bytedance.ies.sdk.widgets.perf.WidgetCostModule;
import com.bytedance.sysoptimizer.EnterTransitionCrashOptimizer;
import com.larus.common.apphost.AppHost;
import com.larus.common_ui.activity.FlowCommonAppCompatActivity;
import com.larus.nova.R;
import com.larus.platform.IFlowSdkDepend;
import com.larus.platform.service.e2;
import com.larus.platform.service.z2;
import com.larus.utils.logger.FLogger;
import com.larus.voicecall.impl.util.RealtimeCallUtil;
import com.larus.voicecall.impl.util.q0;
import com.obric.assistant.interaction.impl.window.ChatWindowActivity;
import com.obric.assistant.interaction.impl.window.behaviors.ActivityStartBehavior;
import com.obric.assistant.interaction.impl.window.helpers.ActivityLancet;
import com.obric.assistant.interaction.impl.window.helpers.PopupOrDialogVisibilityTracker;
import com.obric.assistant.interaction.impl.window.helpers.WindowUtils;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionGuard;
import com.obric.assistant.interaction.impl.window.landscape.restriction.LandscapeRestrictionOperation;
import com.obric.assistant.spi.audio.IObricRealtimeCallExtService;
import com.ss.android.ugc.aweme.framework.services.ServiceManager;
import com.ss.android.ugc.bytex.pthread.base.convergence.hook.ThreadMethodProxy;
import com.ss.ttvideoengine.log.VideoEventOneOutSync;
import java.util.Map;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function2;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;

/* JADX INFO: loaded from: classes4.dex */
@Metadata(d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u0000 /2\u00020\u0001:\u0001/B\u0007¢\u0006\u0004\b\u0002\u0010\u0003J\u0012\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eH\u0014J\b\u0010\u001f\u001a\u00020\u001cH\u0002J\u0012\u0010 \u001a\u00020\u001c2\b\u0010!\u001a\u0004\u0018\u00010\"H\u0014J\u001a\u0010#\u001a\u00020$2\u0006\u0010%\u001a\u00020&2\b\u0010'\u001a\u0004\u0018\u00010(H\u0016J\b\u0010)\u001a\u00020&H\u0016J\b\u0010*\u001a\u00020$H\u0016J\b\u0010+\u001a\u00020$H\u0016J\b\u0010,\u001a\u00020\u001cH\u0016J\b\u0010-\u001a\u00020\u001cH\u0014J\b\u0010.\u001a\u00020\u001cH\u0002R\u001b\u0010\u0004\u001a\u00020\u00058BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\f\u001a\u0004\u0018\u00010\u000b2\b\u0010\n\u001a\u0004\u0018\u00010\u000b@BX\u0082\u000e¢\u0006\b\n\u0000\"\u0004\b\r\u0010\u000eR\u001d\u0010\u000f\u001a\u0004\u0018\u00010\u00108BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0013\u0010\t\u001a\u0004\b\u0011\u0010\u0012R\u001d\u0010\u0014\u001a\u0004\u0018\u00010\u00158BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0018\u0010\t\u001a\u0004\b\u0016\u0010\u0017R\u000e\u0010\u0019\u001a\u00020\u001aX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00060"}, d2 = {"Lcom/larus/voicecall/impl/ui/RealtimeCallActivity;", "Lcom/larus/common_ui/activity/FlowCommonAppCompatActivity;", "<init>", "()V", "layout", "Lcom/larus/voicecall/impl/ui/calllayout/RealtimeCallSimpleLayout;", "getLayout", "()Lcom/larus/voicecall/impl/ui/calllayout/RealtimeCallSimpleLayout;", "layout$delegate", "Lkotlin/Lazy;", "value", "Landroid/view/OrientationEventListener;", "orientationEventListener", "setOrientationEventListener", "(Landroid/view/OrientationEventListener;)V", "obricRealtimeCallExtService", "Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "getObricRealtimeCallExtService", "()Lcom/obric/assistant/spi/audio/IObricRealtimeCallExtService;", "obricRealtimeCallExtService$delegate", "audioManager", "Landroid/media/AudioManager;", "getAudioManager", "()Landroid/media/AudioManager;", "audioManager$delegate", "logKeyInterval", "", WidgetCostModule.TYPE_ON_CREATE, "", "savedInstanceState", "Landroid/os/Bundle;", "setPad", "onNewIntent", "newIntent", "Landroid/content/Intent;", "onKeyDown", "", "keyCode", "", "event", "Landroid/view/KeyEvent;", "getBackgroundResource", "needAdaptStatusBarPadding", "needAdaptNavigationBarPadding", VideoEventOneOutSync.END_TYPE_FINISH, LiveCommonConstants.REASON_ON_DEDTROY, "checkAVKitInit", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class RealtimeCallActivity extends FlowCommonAppCompatActivity {

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public static final /* synthetic */ int f379260l = 0;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Lazy f379261g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public OrientationEventListener f379262h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Lazy f379263i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Lazy f379264j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public long f379265k;

    /* JADX INFO: loaded from: classes32.dex */
    public static final class a {
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.ui.RealtimeCallActivity$onCreate$1, reason: invalid class name */
    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallActivity$onCreate$1", f = "RealtimeCallActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
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
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r100);
            IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r101 == null) goto L10;
            com.larus.home.impl.sdk.s r102 = r101.s0();
            if (r102 == null) goto L10;
            r102.g();
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    /* JADX INFO: renamed from: com.larus.voicecall.impl.ui.RealtimeCallActivity$onDestroy$1, reason: invalid class name and case insensitive filesystem */
    /* JADX INFO: loaded from: classes32.dex */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.larus.voicecall.impl.ui.RealtimeCallActivity$onDestroy$1", f = "RealtimeCallActivity.kt", i = {}, l = {}, m = "invokeSuspend", n = {}, s = {})
    public static final class C115851 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        int label;

        public C115851(Continuation<? super C115851> r100) {
            super(2, r100);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new C115851(r101);
        }

        @Override // kotlin.jvm.functions.Function2
        public /* bridge */ /* synthetic */ Object invoke(CoroutineScope r100, Continuation<? super Unit> r101) {
            return invoke2(r100, r101);
        }

        /* JADX INFO: renamed from: invoke, reason: avoid collision after fix types in other method */
        public final Object invoke2(CoroutineScope r100, Continuation<? super Unit> r101) {
            return ((C115851) create(r100, r101)).invokeSuspend(Unit.INSTANCE);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Object invokeSuspend(Object r100) {
            IntrinsicsKt.getCOROUTINE_SUSPENDED();
            if (this.label != 0) goto L12;
            ResultKt.throwOnFailure(r100);
            IFlowSdkDepend r101 = (IFlowSdkDepend) ServiceManager.get().getService(IFlowSdkDepend.class);
            if (r101 == null) goto L10;
            com.larus.home.impl.sdk.s r102 = r101.s0();
            if (r102 == null) goto L10;
            r102.j();
        L10:
            return Unit.INSTANCE;
        L12:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        }
    }

    static {
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final int C1() {
        return R.color.larus_static_black;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean H1() {
        return false;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity
    public final boolean K1() {
        return false;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onDestroy() {
        if (WindowUtils.INSTANCE.isMainBotActivity(this) == false) goto L5;
        PopupOrDialogVisibilityTracker.clearTrackedOverlays(this);
        FLogger.f375446a.i("ActivityLancet", "clear tracked overlays onDestroy activity = ".concat(RealtimeCallActivity.class.getName()));
    L5:
        super.onDestroy();
        OrientationEventListener r100 = this.f379262h;
        if (r100 == null) goto L8;
        r100.disable();
    L8:
        this.f379262h = null;
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.u() == false) goto L12;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new C115851(null), 3, null);
        return;
    }

    public RealtimeCallActivity() {
        this.f379261g = LazyKt.lazy(new com.larus.voicecall.impl.ui.a(this));
        this.f379263i = LazyKt.lazy(new b());
        this.f379264j = LazyKt.lazy(new c(this));
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void finish() {
        IObricRealtimeCallExtService r100 = (IObricRealtimeCallExtService) this.f379263i.getValue();
        if (r100 == null) goto L5;
        r100.onRealtimeCallActivityFinish(this);
    L5:
        super.finish();
        overridePendingTransition(0, 0);
        if ((this instanceof ChatWindowActivity) == true) goto L59;
        FLogger r101 = FLogger.f375446a;
        r101.i("ActivityLancet", "finish ".concat(RealtimeCallActivity.class.getName()));
        long r102 = SystemClock.uptimeMillis();
        Map<Activity, Long> r103 = ActivityLancet.LAST_FINISH_HANDLED_MS;
        monitor-enter(r103);
        Long r104 = r103.get(this);     // Catch: Throwable -> L48
        if (r104 != null) goto L13;
    L16:
        r103.put(this, Long.valueOf(r102));     // Catch: Throwable -> L48
        monitor-exit(r103);     // Catch: Throwable -> L48
    L45:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "handle onBackPressed strategy failed", th);
    L56:
        return;
    L19:
        if (getLifecycle().getCurrentState().isAtLeast(Lifecycle.State.STARTED) == true) goto L22;
        r101.i("ActivityLancet", "quit !resume, current state = " + getLifecycle().getCurrentState());     // Catch: Throwable -> L45
    L51:
        goto L56
    L22:
        if (isFinishing() == true) goto L25;
        r101.i("ActivityLancet", "quit !isFinishing");     // Catch: Throwable -> L45
        goto L51
    L25:
        if (ActivityStartBehavior.isInternalActivityConsumed(this) == true) goto L28;
        r101.i("ActivityLancet", "quit !isInternalActivityConsumed");     // Catch: Throwable -> L45
        goto L51
    L28:
        if (ActivityLancet.isOnlyActivityInTask(this) == true) goto L31;
        r101.i("ActivityLancet", "quit !isOnlyActivityInTask");     // Catch: Throwable -> L45
        goto L51
    L31:
        if (ActivityLancet.isExcludedActivity(this) == false) goto L34;
        r101.i("ActivityLancet", "quit isExcludedActivity");     // Catch: Throwable -> L45
        goto L51
    L34:
        if (WindowUtils.INSTANCE.backToWindow() == false) goto L36;
        ActivityLancet.postPopWindowAfterInternalActivityFinish();     // Catch: Throwable -> L45
        goto L51
    L36:
        Intent r105 = getPackageManager().getLaunchIntentForPackage(getPackageName());     // Catch: Throwable -> L45
        if (r105 == null) goto L51;
        r105.addFlags(268435456);     // Catch: Throwable -> L45
        r105.addFlags(2097152);     // Catch: Throwable -> L45
        r101.i("ActivityLancet", "start launcher intent after backPressed, activity=" + this);     // Catch: Throwable -> L45
        startActivity(r105);     // Catch: Throwable -> L42
        overridePendingTransition(android.R.anim.fade_in, android.R.anim.slide_out_right);     // Catch: Throwable -> L42
    L42:
        th = move-exception;
        FLogger.f375446a.e("ActivityLancet", "startActivity launcher intent failed", th);     // Catch: Throwable -> L45
        goto L51
    L13:
        if ((r102 - r104.longValue()) >= 800) goto L16;
        monitor-exit(r103);     // Catch: Throwable -> L48
    L48:
        th = move-exception;
        throw th;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, androidx.fragment.app.FragmentActivity, android.app.Activity
    public final void onStop() {
        super.onStop();
        if (EnterTransitionCrashOptimizer.getContext() == null) goto L14;
        View r100 = getWindow().getDecorView();     // Catch: Throwable -> L11
        if (com.larus.home.impl.utils.c.f346345e == false) goto L9;
        FLogger.f375446a.i("DecorViewLancet", "getDecorView");     // Catch: Throwable -> L11
        Thread r101 = ThreadMethodProxy.currentThread();     // Catch: Throwable -> L11
        if (r101 == com.larus.home.impl.utils.c.f346341a) goto L9;
        com.larus.home.impl.utils.c.a(r101, "getDecorView");     // Catch: Throwable -> L11
    L9:
        r100.getViewTreeObserver().dispatchOnPreDraw();     // Catch: Throwable -> L11
        return;
    L15:
        return;
    }

    @Override // com.larus.common_ui.activity.FlowCommonAppCompatActivity, androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, androidx.core.app.ComponentActivity, android.app.Activity
    public final void onCreate(Bundle r110) {
        if (z2.f365865a.enableGlobalActivityTheme() == false) goto L6;
        v19.f.a(getTheme());     // Catch: Throwable -> L9
    L6:
        if (v19.f.f(this) == false) goto L10;
        v19.f.c(getTheme());     // Catch: Throwable -> L9
    L10:
        int r100 = getIntent().getIntExtra("force_theme", 0);
        if (r100 != 1) goto L13;
        v19.f.c(getTheme());
    L17:
        q0.a();
        if (com.larus.audio.call.f.f289123c.c() == true) goto L20;
        FLogger.f375446a.e("", "[checkAVKitInit] FlowAVKit not init, init now!");
        com.larus.audio.call.f.e(AppHost.f326268a.getApplication(), new com.larus.voicecall.impl.i());
    L21:
        super.onCreate(r110);
        if (e2.f365734a.isPad() == false) goto L34;
        d r111 = new d(this);
        OrientationEventListener r101 = this.f379262h;
        if (r101 == null) goto L26;
        r101.disable();
    L26:
        this.f379262h = r111;
        if (r111.canDetectOrientation() != true) goto L29;
        boolean r112 = true;
    L30:
        if (r112 == false) goto L34;
        OrientationEventListener r113 = this.f379262h;
        if (r113 == null) goto L34;
        r113.enable();
        goto L34
    L29:
        r112 = false;
    L34:
        setContentView((View) ((a4a.d) this.f379261g.getValue()).f1819b.getValue());
        boolean r114 = v19.h.f552477a;
        com.larus.utils.u.e(this, false, v19.h.b(this));
        a4a.d r115 = (a4a.d) this.f379261g.getValue();
        ((RealtimeCallFragment) r115.f1820c.getValue()).setArguments(r115.f1818a.getIntent().getExtras());
        FragmentTransaction r102 = r115.f1818a.getSupportFragmentManager().beginTransaction();
        RealtimeCallFragment r116 = (RealtimeCallFragment) r115.f1820c.getValue();
        if (LandscapeRestrictionGuard.shouldBlockFragmentTransaction(r102, r116, LandscapeRestrictionOperation.FRAGMENT_TRANSACTION_REPLACE, null, R.id.fragment_container) == true) goto L38;
        r102 = r102.replace(R.id.fragment_container, r116);
    L38:
        r102.commitAllowingStateLoss();
        RealtimeCallUtil.f379424a.getClass();
        if (RealtimeCallUtil.u() == false) goto L41;
        BuildersKt.launch$default(CoroutineScopeKt.CoroutineScope(Dispatchers.getIO()), null, null, new AnonymousClass1(null), 3, null);
    L41:
        getIntent().putExtra("block_ug_return_button", true);
        return;
    L20:
        com.larus.audio.call.f.g();
        goto L21
    L13:
        if (r100 != 2) goto L17;
        v19.f.b(getTheme());
        goto L17
    }

    @Override // androidx.fragment.app.FragmentActivity, androidx.activity.ComponentActivity, android.app.Activity
    public final void onNewIntent(Intent r100) {
        super.onNewIntent(r100);
        IObricRealtimeCallExtService r101 = (IObricRealtimeCallExtService) this.f379263i.getValue();
        if (r101 == null) goto L6;
        r101.onRealtimeCallActivityOnNewIntent(this, r100, (RealtimeCallFragment) ((a4a.d) this.f379261g.getValue()).f1820c.getValue());
        return;
    }

    @Override // androidx.appcompat.app.AppCompatActivity, android.app.Activity, android.view.KeyEvent.Callback
    public final boolean onKeyDown(int r110, KeyEvent r111) {
        boolean r112 = super.onKeyDown(r110, r111);
        if ((SystemClock.elapsedRealtime() - this.f379265k) <= 500) goto L28;
        m58.y r100 = m58.y.f512149a;
        String r101 = m58.y.e(AppHost.f326268a.getApplication());
        Result.Companion r102 = Result.Companion;     // Catch: Throwable -> L21
        String r103 = null;
        if (r110 != 24) goto L9;
        FLogger r113 = FLogger.f375446a;     // Catch: Throwable -> L21
        StringBuilder r104 = new StringBuilder("KEYCODE_VOLUME_UP result=");     // Catch: Throwable -> L21
        r104.append(r112);     // Catch: Throwable -> L21
        r104.append(" volumeControlStream=");     // Catch: Throwable -> L21
        r104.append(c4a.b.b(this));     // Catch: Throwable -> L21
        r104.append(" audio_mode=");     // Catch: Throwable -> L21
        AudioManager r105 = (AudioManager) this.f379264j.getValue();     // Catch: Throwable -> L21
        if (r105 == null) goto L18;
        r103 = c4a.b.a(r105);     // Catch: Throwable -> L21
    L18:
        r104.append(r103);     // Catch: Throwable -> L21
        r104.append(" volumeInfo=");     // Catch: Throwable -> L21
        r104.append(r101);     // Catch: Throwable -> L21
        r113.i("RealtimeCallActivity", r104.toString());     // Catch: Throwable -> L21
    L19:
        Object r114 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L21
    L23:
        Throwable r115 = Result.m9452exceptionOrNullimpl(r114);
        if (r115 == null) goto L27;
        FLogger.f375446a.e("RealtimeCallActivity", "onKeyDown error. msg=" + r115);
    L27:
        this.f379265k = SystemClock.elapsedRealtime();
        goto L28
    L9:
        if (r110 != 25) goto L19;
        FLogger r116 = FLogger.f375446a;     // Catch: Throwable -> L21
        StringBuilder r106 = new StringBuilder("KEYCODE_VOLUME_DOWN result=");     // Catch: Throwable -> L21
        r106.append(r112);     // Catch: Throwable -> L21
        r106.append(" volumeControlStream=");     // Catch: Throwable -> L21
        r106.append(c4a.b.b(this));     // Catch: Throwable -> L21
        r106.append(" audio_mode=");     // Catch: Throwable -> L21
        AudioManager r107 = (AudioManager) this.f379264j.getValue();     // Catch: Throwable -> L21
        if (r107 == null) goto L14;
        r103 = c4a.b.a(r107);     // Catch: Throwable -> L21
    L14:
        r106.append(r103);     // Catch: Throwable -> L21
        r106.append(" volumeInfo=");     // Catch: Throwable -> L21
        r106.append(r101);     // Catch: Throwable -> L21
        r116.i("RealtimeCallActivity", r106.toString());     // Catch: Throwable -> L21
    L21:
        th = move-exception;
        Result.Companion r108 = Result.Companion;
        r114 = Result.m9449constructorimpl(ResultKt.createFailure(th));
    L28:
        return r112;
    }
}
