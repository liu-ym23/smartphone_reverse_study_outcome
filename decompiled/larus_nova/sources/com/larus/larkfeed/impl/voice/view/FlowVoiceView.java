package com.larus.larkfeed.impl.voice.view;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.fragment.app.Fragment;
import com.larus.asr.VoiceInputType;
import com.larus.asr.api.databinding.LarusWidgetSpeakerBinding;
import com.larus.asr.view.ChatSpeaker;
import com.larus.common_ui.blur.BlurCircleWithAmplitude;
import com.larus.platform.service.z2;
import com.ss.android.lark.officesdk.utils.di.j;
import com.ss.android.lark.utils.statistics.PerfLog;
import com.ss.android.lark.voiceinput.api.data.model.record.VoiceRecordState;
import kotlin.KotlinNothingValueException;
import kotlin.Metadata;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.TuplesKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.CoroutineScopeKt;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.SupervisorKt;
import kotlinx.coroutines.flow.d1;
import kotlinx.coroutines.flow.i1;

/* JADX INFO: loaded from: classes30.dex */
@Metadata(d1 = {"\u0000f\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 52\u00020\u00012\u00020\u00022\u00020\u0003:\u00015B\u000f\u0012\u0006\u0010\u0004\u001a\u00020\u0005¢\u0006\u0004\b\u0006\u0010\u0007J\b\u0010\u0010\u001a\u00020\u000bH\u0002J\b\u0010\u0011\u001a\u00020\u000bH\u0002J\u0018\u0010\u0012\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0014J\u0018\u0010\u0015\u001a\u00020\u000b2\u0006\u0010\u0013\u001a\u00020\u000f2\u0006\u0010\u0014\u001a\u00020\u000fH\u0002J\u0017\u0010\u0016\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\u0017\u001a\u00020\u000fH\u0002¢\u0006\u0002\u0010\u0018J\b\u0010\u0019\u001a\u00020\u000bH\u0002J\u0010\u0010\u001a\u001a\u00020\u000b2\u0006\u0010\u001b\u001a\u00020\u001cH\u0016J\u0018\u0010\u001d\u001a\u00020\u000b2\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020!H\u0016J\u001e\u0010\"\u001a\u00020\u000b2\u0006\u0010#\u001a\u00020\r2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010$J\u0016\u0010%\u001a\u00020\u000b2\u0006\u0010 \u001a\u00020!H\u0082@¢\u0006\u0002\u0010&J\f\u0010'\u001a\u00020(*\u00020)H\u0002J\u0018\u0010*\u001a\u00020\u000b2\u0006\u0010+\u001a\u00020,2\u0006\u0010-\u001a\u00020.H\u0016J\b\u0010/\u001a\u00020\u000bH\u0016J\u0010\u00100\u001a\u00020\u000b2\u0006\u00101\u001a\u00020\nH\u0016J\u001e\u00102\u001a\u00020\u000b2\u0014\u00103\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tH\u0016J\b\u00104\u001a\u00020\u000bH\u0016R\u001c\u0010\b\u001a\u0010\u0012\u0004\u0012\u00020\n\u0012\u0004\u0012\u00020\u000b\u0018\u00010\tX\u0082\u000e¢\u0006\u0002\n\u0000R\u0010\u0010\f\u001a\u0004\u0018\u00010\rX\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u000e¢\u0006\u0002\n\u0000¨\u00066"}, d2 = {"Lcom/larus/larkfeed/impl/voice/view/FlowVoiceView;", "Lcom/larus/asr/view/ChatSpeaker;", "Lcom/ss/android/lark/voiceinput/api/view/IVoiceView;", "Lcom/ss/android/lark/voiceinput/api/view/IVoiceViewEventChannel;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "<init>", "(Landroid/content/Context;)V", "eventListener", "Lkotlin/Function1;", "Lcom/ss/android/lark/voiceinput/api/view/IVoiceViewEvent;", "", "bindingScope", "Lkotlinx/coroutines/CoroutineScope;", "blueLayerMaxHeightPx", "", "initView", "configureFullWidthBlueLayer", "onMeasure", "widthMeasureSpec", "heightMeasureSpec", "updateBlueLayerHeight", "availableMeasureSize", "measureSpec", "(I)Ljava/lang/Integer;", "initViewHandle", "initVoiceAbility", "voiceAbilityContext", "Lcom/ss/android/lark/voiceinput/api/component/ability/IVoiceAbilityContext;", "bindVoiceState", "lifecycleOwner", "Landroidx/lifecycle/LifecycleOwner;", "state", "Lcom/ss/android/lark/voiceinput/api/service/IVoiceDataObserver;", "observeAudioFrames", "scope", "(Lkotlinx/coroutines/CoroutineScope;Lcom/ss/android/lark/voiceinput/api/service/IVoiceDataObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeRecordState", "(Lcom/ss/android/lark/voiceinput/api/service/IVoiceDataObserver;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "shouldHideVoiceView", "", "Lcom/ss/android/lark/voiceinput/api/data/model/record/VoiceRecordState;", "attachTo", "parent", "Landroid/view/ViewGroup;", "layoutParams", "Landroid/view/ViewGroup$LayoutParams;", "detach", "handleVoiceViewEvent", "event", "setEventListener", "listener", "unbindVoiceState", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class FlowVoiceView extends ChatSpeaker implements dbc.c, dbc.f {

    /* JADX INFO: renamed from: k0, reason: collision with root package name */
    public static final /* synthetic */ int f355694k0 = 0;
    public Function1<? super dbc.e, Unit> U;
    public CoroutineScope V;
    public int W;

    public static final class a {
    }

    public /* synthetic */ class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f355695a = null;

        static {
            int[] r100 = new int[VoiceRecordState.values().length];
            r100[VoiceRecordState.Idle.ordinal()] = 1;     // Catch: NoSuchFieldError -> L13
        L23:
            r100[VoiceRecordState.Stopped.ordinal()] = 2;     // Catch: NoSuchFieldError -> L14
        L35:
            r100[VoiceRecordState.Canceled.ordinal()] = 3;     // Catch: NoSuchFieldError -> L15
        L25:
            r100[VoiceRecordState.Failed.ordinal()] = 4;     // Catch: NoSuchFieldError -> L16
        L27:
            r100[VoiceRecordState.Destroy.ordinal()] = 5;     // Catch: NoSuchFieldError -> L17
        L21:
            r100[VoiceRecordState.Preparing.ordinal()] = 6;     // Catch: NoSuchFieldError -> L18
        L29:
            r100[VoiceRecordState.Prepared.ordinal()] = 7;     // Catch: NoSuchFieldError -> L19
        L31:
            r100[VoiceRecordState.Recording.ordinal()] = 8;     // Catch: NoSuchFieldError -> L20
        L11:
            f355695a = r100;
        }
    }

    static {
    }

    @Override // dbc.a
    public final void o0(hbc.b r100) {
        Intrinsics.checkNotNullParameter(r100, "voiceAbilityContext");
    }

    @Override // dbc.b
    public final void H3() {
        CoroutineScope r100 = this.V;
        if (r100 == null) goto L5;
        CoroutineScopeKt.cancel$default(r100, null, 1, null);
    L5:
        this.V = null;
        this.U = null;
    }

    @Override // dbc.d
    public final void detach() {
        Result.Companion r100 = Result.Companion;     // Catch: Throwable -> L10
        ViewParent r101 = getParent();     // Catch: Throwable -> L10
        Unit r102 = null;
        if ((r101 instanceof ViewGroup) == false) goto L5;
        ViewGroup r103 = (ViewGroup) r101;     // Catch: Throwable -> L10
    L6:
        if (r103 == null) goto L8;
        r103.removeView(this);     // Catch: Throwable -> L10
        r102 = Unit.INSTANCE;     // Catch: Throwable -> L10
    L8:
        Object r104 = Result.m9449constructorimpl(r102);     // Catch: Throwable -> L10
    L12:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L18;
        j.c("FlowVoiceView", "detach failed", r105);
        return;
    L18:
        return;
    L5:
        r103 = null;
    L10:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L12
    }

    public FlowVoiceView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100);
        c6();
        if (y48.h.a() == false) goto L5;
        int r101 = y48.f.f566092h;
        setSpec(y48.f.a.a().a());
    L7:
        if (z2.f365865a.S1().getEnableNewStyle() == false) goto L9;
        r7(false, null);
    L9:
        setForceHideShadow(true);
        N6();
        LarusWidgetSpeakerBinding r102 = getBinding();
        if (r102 == null) goto L19;
        BlurCircleWithAmplitude r103 = r102.f287184f;
        if (r103 == null) goto L19;
        ViewGroup.LayoutParams r104 = r103.getLayoutParams();
        if (r104 == null) goto L18;
        ConstraintLayout.LayoutParams r105 = (ConstraintLayout.LayoutParams) r104;
        this.W = r105.matchConstraintMaxWidth;
        r105.matchConstraintMaxWidth = 0;
        r105.dimensionRatio = null;
        r103.setLayoutParams(r105);
        goto L19
    L18:
        throw new NullPointerException("null cannot be cast to non-null type androidx.constraintlayout.widget.ConstraintLayout.LayoutParams");
    L19:
        setVisibility(8);
        Function0<Unit> r106 = new com.larus.larkfeed.impl.voice.view.a(this);
        Intrinsics.checkNotNullParameter(r106, "callback");
        this.f288115e = r106;
        Function2<? super Boolean, ? super VoiceInputType, Unit> r107 = new com.larus.larkfeed.impl.voice.view.b(this);
        Intrinsics.checkNotNullParameter(r107, "callback");
        this.f288116f = r107;
        Function0<Unit> r108 = new c(this);
        Intrinsics.checkNotNullParameter(r108, "callback");
        this.f288117g = r108;
        return;
    L5:
        setConfig(null);
        goto L7
    }

    @Override // dbc.f
    public final void j0(dbc.e r100) {
        Intrinsics.checkNotNullParameter(r100, "event");
        if ((r100 instanceof rac.b) == false) goto L6;
        this.f288136z = false;
        bringToFront();
        setVisibility(0);
        return;
    L6:
        if ((r100 instanceof rac.c) == false) goto L11;
        if (getVisibility() != 0) goto L18;
        rac.c r101 = (rac.c) r100;
        ChatSpeaker.C6(this, TuplesKt.to(Float.valueOf(r101.f536867a.getRawX()), Float.valueOf(r101.f536867a.getRawY())));
        return;
    L18:
        return;
    L11:
        if ((r100 instanceof rac.d) == false) goto L14;
        setVisibility(8);
        rac.d r102 = (rac.d) r100;
        ChatSpeaker.A8(this, r102.f536868a.getRawX(), r102.f536868a.getRawY(), 0.0f, 0.0f, false, 28);
        return;
    L14:
        if ((r100 instanceof rac.a) == false) goto L21;
        setVisibility(8);
        rac.a r103 = (rac.a) r100;
        ChatSpeaker.A8(this, r103.f536865a.getRawX(), r103.f536865a.getRawY(), 0.0f, 0.0f, false, 12);
        return;
    }

    @Override // dbc.f
    public void setEventListener(Function1<? super dbc.e, Unit> r100) {
        this.U = r100;
    }

    @Override // dbc.d
    public final void A(ViewGroup r100, ViewGroup.LayoutParams r101) {
        Intrinsics.checkNotNullParameter(r100, "parent");
        Intrinsics.checkNotNullParameter(r101, "layoutParams");
        ViewParent r102 = getParent();
        if (r102 != null) goto L13;
        Result.Companion r103 = Result.Companion;     // Catch: Throwable -> L6
        r100.addView(this, r101);     // Catch: Throwable -> L6
        Object r104 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L6
    L8:
        Throwable r105 = Result.m9452exceptionOrNullimpl(r104);
        if (r105 == null) goto L11;
        j.c("FlowVoiceView", "attachTo failed", r105);
    L11:
        Result.m9448boximpl(r104);
        return;
    L6:
        th = move-exception;
        Result.Companion r106 = Result.Companion;
        r104 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L8
    L13:
        if ((r102 instanceof ViewGroup) == true) goto L26;
        j.b("FlowVoiceView", "attachTo ignored: voice view is already attached to ".concat(r102.getClass().getSimpleName()));
        Unit r107 = Unit.INSTANCE;
        return;
    L26:
        Result.Companion r108 = Result.Companion;     // Catch: Throwable -> L16
        ((ViewGroup) r102).removeView(this);     // Catch: Throwable -> L16
        r100.addView(this, r101);     // Catch: Throwable -> L16
        Object r109 = Result.m9449constructorimpl(Unit.INSTANCE);     // Catch: Throwable -> L16
    L18:
        Throwable r110 = Result.m9452exceptionOrNullimpl(r109);
        if (r110 == null) goto L21;
        j.c("FlowVoiceView", "attachTo failed", r110);
    L21:
        Result.m9448boximpl(r109);
        return;
    L16:
        th = move-exception;
        Result.Companion r111 = Result.Companion;
        r109 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L18
    }

    @Override // dbc.b
    public final void h5(Fragment r110, cbc.c r111) {
        Intrinsics.checkNotNullParameter(r110, "lifecycleOwner");
        Intrinsics.checkNotNullParameter(r111, "state");
        CoroutineScope r112 = this.V;
        if (r112 == null) goto L5;
        CoroutineScopeKt.cancel$default(r112, null, 1, null);
    L5:
        CoroutineScope r113 = CoroutineScopeKt.CoroutineScope(SupervisorKt.SupervisorJob$default(null, 1, null).plus(Dispatchers.getMain().getImmediate()));
        this.V = r113;
        BuildersKt.launch$default(r113, null, null, new FlowVoiceView$bindVoiceState$1$1(this, r113, r111, null), 3, null);
        BuildersKt.launch$default(r113, null, null, new FlowVoiceView$bindVoiceState$1$2(this, r111, null), 3, null);
    }

    @Override // androidx.constraintlayout.widget.ConstraintLayout, android.view.View
    public final void onMeasure(int r100, int r101) {
        Integer r102 = Integer.valueOf(View.MeasureSpec.getSize(r100));
        int r103 = r102.intValue();
        boolean r104 = true;
        if (View.MeasureSpec.getMode(r100) == 0) goto L6;
        if (r103 <= 0) goto L6;
        boolean r105 = true;
    L7:
        ConstraintLayout.LayoutParams r106 = null;
        if (r105 == true) goto L11;
        r102 = null;
    L11:
        if (r102 == null) goto L40;
        int r107 = r102.intValue();
        int r108 = this.W;
        if (r108 <= 0) goto L15;
        r107 = RangesKt.coerceAtMost(r107, r108);
    L15:
        int r109 = r107 + 90;
        Integer r110 = Integer.valueOf(View.MeasureSpec.getSize(r101));
        int r111 = r110.intValue();
        if (View.MeasureSpec.getMode(r101) == 0) goto L19;
        if (r111 <= 0) goto L19;
    L20:
        if (r104 == true) goto L23;
        r110 = null;
    L23:
        if (r110 == null) goto L25;
        r109 = RangesKt.coerceAtMost(r109, r110.intValue());
    L25:
        if (r109 <= 0) goto L40;
        LarusWidgetSpeakerBinding r112 = getBinding();
        if (r112 == null) goto L40;
        BlurCircleWithAmplitude r113 = r112.f287184f;
        if (r113 == null) goto L40;
        ViewGroup.LayoutParams r114 = r113.getLayoutParams();
        if ((r114 instanceof ConstraintLayout.LayoutParams) == false) goto L35;
        r106 = (ConstraintLayout.LayoutParams) r114;
    L35:
        if (r106 == null) goto L40;
        if (((ViewGroup.MarginLayoutParams) r106).height == r109) goto L40;
        ((ViewGroup.MarginLayoutParams) r106).height = r109;
        r113.requestLayout();
    L19:
        r104 = false;
    L40:
        super.onMeasure(r100, r101);
        LarusWidgetSpeakerBinding r115 = getBinding();
        if (r115 == null) goto L49;
        BlurCircleWithAmplitude r116 = r115.f287184f;
        if (r116 != null) goto L46;
        return;
    L46:
        if (r116.getMeasuredWidth() <= 0) goto L50;
        r116.setRoundRectWidthOverride(Float.valueOf(r116.getMeasuredWidth() + 1.0f));
        return;
    L50:
        return;
    L49:
        return;
    L6:
        r105 = false;
        goto L7
    }

    public static final Object f9(FlowVoiceView r100, cbc.a r101, Continuation r102) {
        r100.getClass();
        if ((r102 instanceof FlowVoiceView$observeRecordState$1) == false) goto L7;
        FlowVoiceView$observeRecordState$1 r103 = (FlowVoiceView$observeRecordState$1) r102;
        int r104 = r103.label;
        if ((r104 & Integer.MIN_VALUE) == 0) goto L7;
        r103.label = r104 - Integer.MIN_VALUE;
    L8:
        Object r105 = r103.result;
        Object r106 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r107 = r103.label;
        if (r107 == 0) goto L14;
        if (r107 != 1) goto L12;
        ResultKt.throwOnFailure(r105);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r105);
        i1<abc.c> r108 = r101.k();
        e r109 = new e(r100);
        r103.label = 1;
        if (r108.collect(r109, r103) != r106) goto L18;
        return r106;
    L7:
        r103 = new FlowVoiceView$observeRecordState$1(r100, r102);
        goto L8
    }

    public static final Object c9(FlowVoiceView r100, CoroutineScope r101, cbc.a r102, Continuation r103) {
        r100.getClass();
        if ((r103 instanceof FlowVoiceView$observeAudioFrames$1) == false) goto L7;
        FlowVoiceView$observeAudioFrames$1 r104 = (FlowVoiceView$observeAudioFrames$1) r103;
        int r105 = r104.label;
        if ((r105 & Integer.MIN_VALUE) == 0) goto L7;
        r104.label = r105 - Integer.MIN_VALUE;
    L8:
        Object r106 = r104.result;
        Object r107 = IntrinsicsKt.getCOROUTINE_SUSPENDED();
        int r108 = r104.label;
        if (r108 == 0) goto L14;
        if (r108 != 1) goto L12;
        ResultKt.throwOnFailure(r106);
    L18:
        throw new KotlinNothingValueException();
    L12:
        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
    L14:
        ResultKt.throwOnFailure(r106);
        d1<abc.a> r109 = r102.l();
        d r110 = new d(r100, r101);
        r104.label = 1;
        if (r109.collect(r110, r104) != r107) goto L18;
        return r107;
    L7:
        r104 = new FlowVoiceView$observeAudioFrames$1(r100, r103);
        goto L8
    }
}
