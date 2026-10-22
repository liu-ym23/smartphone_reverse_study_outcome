package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.util.AttributeSet;
import android.view.View;
import android.widget.FrameLayout;
import androidx.camera.video.AudioStats;
import androidx.lifecycle.LifecycleOwner;
import androidx.lifecycle.LifecycleOwnerKt;
import androidx.lifecycle.ViewTreeLifecycleOwner;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Iterator;
import kotlin.Metadata;
import kotlin.Pair;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.coroutines.Continuation;
import kotlin.coroutines.intrinsics.IntrinsicsKt;
import kotlin.coroutines.jvm.internal.Boxing;
import kotlin.coroutines.jvm.internal.DebugMetadata;
import kotlin.coroutines.jvm.internal.SuspendLambda;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlinx.coroutines.BuildersKt;
import kotlinx.coroutines.CoroutineScope;
import kotlinx.coroutines.Dispatchers;
import kotlinx.coroutines.Job;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000\u0092\u0001\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\f\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0007\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0012\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\u0015\n\u0000\n\u0002\u0010\u0014\n\u0002\b\u0006\u0018\u0000 O2\u00020\u00012\u00020\u0002:\u0001OB'\b\u0007\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b¢\u0006\u0004\b\t\u0010\nJ\b\u0010,\u001a\u00020\u000fH\u0002J\u0010\u0010-\u001a\u00020\u00142\u0006\u0010.\u001a\u00020/H\u0016J \u0010-\u001a\u00020\u00142\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`3H\u0016J&\u00104\u001a\u00020\u00142\u0016\u00100\u001a\u0012\u0012\u0004\u0012\u00020201j\b\u0012\u0004\u0012\u000202`3H\u0082@¢\u0006\u0002\u00105J\b\u00106\u001a\u00020\u0014H\u0014J\u000e\u00107\u001a\u00020\u00142\u0006\u00108\u001a\u00020%J\u0010\u00109\u001a\u00020\u00142\b\b\u0002\u0010:\u001a\u00020%J\"\u0010;\u001a\u00020%2\b\u0010<\u001a\u0004\u0018\u00010=2\u0010\b\u0002\u0010>\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013J\u0010\u0010?\u001a\u00020\u00142\b\u0010@\u001a\u0004\u0018\u00010AJ\u000e\u0010B\u001a\u00020\u00142\u0006\u0010C\u001a\u00020%J\u0006\u0010D\u001a\u00020\u0014J\u0006\u0010E\u001a\u00020\u0014J\u0016\u0010F\u001a\u00020\u00142\u0006\u0010G\u001a\u00020H2\u0006\u0010I\u001a\u00020JJ\f\u0010K\u001a\u00020H*\u00020HH\u0002J\b\u0010L\u001a\u00020\u0014H\u0016J\u0010\u0010M\u001a\u00020'2\u0006\u0010N\u001a\u000202H\u0002R\u000e\u0010\u000b\u001a\u00020\u0001X\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u000e\u001a\u00020\u000fX\u0082\u0004¢\u0006\u0002\n\u0000R\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u0004¢\u0006\u0002\n\u0000R4\u0010\u0015\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u00132\u000e\u0010\u0012\u001a\n\u0012\u0004\u0012\u00020\u0014\u0018\u00010\u0013@FX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0017\"\u0004\b\u0018\u0010\u0019R\u001a\u0010\u001a\u001a\u00020\bX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001b\u0010\u001c\"\u0004\b\u001d\u0010\u001eR\u000e\u0010\u001f\u001a\u00020\bX\u0082D¢\u0006\u0002\n\u0000R\u0016\u0010 \u001a\u0004\u0018\u00010!8BX\u0082\u0004¢\u0006\u0006\u001a\u0004\b\"\u0010#R\u000e\u0010$\u001a\u00020%X\u0082\u000e¢\u0006\u0002\n\u0000R\u0012\u0010&\u001a\u0004\u0018\u00010'X\u0082\u000e¢\u0006\u0004\n\u0002\u0010(R\u0010\u0010)\u001a\u0004\u0018\u00010*X\u0082\u000e¢\u0006\u0002\n\u0000R\u000e\u0010+\u001a\u00020%X\u0082\u0004¢\u0006\u0002\n\u0000¨\u0006P"}, d2 = {"Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "Landroid/widget/FrameLayout;", "Lcom/obric/assistant/spi/chat/IObricAudioVisualizer;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "voiceBarFrame", "audioSpectrumView", "Lcom/obric/assistant/view/continuespeech/AudioSpectrumView;", "voiceGradientView", "Lcom/obric/assistant/view/continuespeech/AudioGradientView;", "animDelegate", "Lcom/obric/assistant/view/continuespeech/AudioContinueAnimDelegate;", "value", "Lkotlin/Function0;", "", "timeOutCallback", "getTimeOutCallback", "()Lkotlin/jvm/functions/Function0;", "setTimeOutCallback", "(Lkotlin/jvm/functions/Function0;)V", "mode", "getMode", "()I", "setMode", "(I)V", "density", "lifecycleScope", "Lkotlinx/coroutines/CoroutineScope;", "getLifecycleScope", "()Lkotlinx/coroutines/CoroutineScope;", "isRecognizing", "", "lastAmplitude", "", "Ljava/lang/Float;", "audioUpdateJob", "Lkotlinx/coroutines/Job;", "isWindowMode", "createVoiceGradientView", "setAudioData", "data", "", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "setAudioDataInner", "(Ljava/util/ArrayList;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "onDetachedFromWindow", "setRecognizing", "recognizing", "showVoiceView", "forceWelcome", "onRealtimeCallLifeStateUpdate", "state", "Lcom/obric/assistant/view/continuespeech/RealtimeCallLifeState;", "onAnimationEnd", "addInputGradientView", "inputGradientView", "Landroid/view/View;", "setUseShimmerThinkingAnimation", "useShimmer", "onChatWindowShow", "adaptWindowStyle", "setVoiceGradientPureColor", "colors", "", "positions", "", "toOpaqueColors", "resetUi", "optAmplitude", "before", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class AudioContinueGradientView extends FrameLayout implements iga.a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final FrameLayout f394052a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioSpectrumView f394053b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudioGradientView f394054c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final u f394055d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Function0<Unit> f394056e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public int f394057f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final int f394058g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public boolean f394059h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public Float f394060i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public Job f394061j;

    public static final class a {
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioData$1, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioData$1", f = "AudioContinueGradientView.kt", i = {}, l = {108, 109}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass1 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ byte[] $data;
        int label;
        final /* synthetic */ AudioContinueGradientView this$0;

        public AnonymousClass1(byte[] r100, AudioContinueGradientView r101, Continuation<? super AnonymousClass1> r102) {
            this.$data = r100;
            this.this$0 = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass1(this.$data, this.this$0, r101);
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
            AudioContinueGradientView r103 = this.this$0;
            this.label = 2;
            if (AudioContinueGradientView.b(r103, (ArrayList) r100, this) != r101) goto L17;
            return r101;
        L10:
            ResultKt.throwOnFailure(r100);
            int r104 = com.larus.common_ui.widget.input.a.f328681a;
            byte[] r105 = this.$data;
            int r106 = this.this$0.f394058g;
            this.label = 1;
            r100 = com.larus.common_ui.widget.input.a.a(r105, r106, this);
            if (r100 != r101) goto L13;
            return r101;
        }
    }

    /* JADX INFO: renamed from: com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioData$2, reason: invalid class name */
    @Metadata(d1 = {"\u0000\n\n\u0000\n\u0002\u0010\u0002\n\u0002\u0018\u0002\u0010\u0000\u001a\u00020\u0001*\u00020\u0002H\n"}, d2 = {"<anonymous>", "", "Lkotlinx/coroutines/CoroutineScope;"}, k = 3, mv = {2, 1, 0}, xi = 48)
    @DebugMetadata(c = "com.obric.assistant.view.continuespeech.AudioContinueGradientView$setAudioData$2", f = "AudioContinueGradientView.kt", i = {}, l = {117}, m = "invokeSuspend", n = {}, s = {})
    public static final class AnonymousClass2 extends SuspendLambda implements Function2<CoroutineScope, Continuation<? super Unit>, Object> {
        final /* synthetic */ ArrayList<Double> $sampleData;
        int label;
        final /* synthetic */ AudioContinueGradientView this$0;

        public AnonymousClass2(AudioContinueGradientView r100, ArrayList<Double> r101, Continuation<? super AnonymousClass2> r102) {
            this.this$0 = r100;
            this.$sampleData = r101;
            super(2, r102);
        }

        @Override // kotlin.coroutines.jvm.internal.BaseContinuationImpl
        public final Continuation<Unit> create(Object r100, Continuation<?> r101) {
            return new AnonymousClass2(this.this$0, this.$sampleData, r101);
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
        L12:
            return Unit.INSTANCE;
        L7:
            throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
        L8:
            ResultKt.throwOnFailure(r100);
            AudioContinueGradientView r103 = this.this$0;
            ArrayList<Double> r104 = this.$sampleData;
            this.label = 1;
            if (AudioContinueGradientView.b(r103, r104, this) != r101) goto L12;
            return r101;
        }
    }

    static {
    }

    public AudioContinueGradientView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public AudioContinueGradientView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    @Override // iga.a
    public final void a() {
        this.f394059h = false;
        AudioShimmerGradientView r100 = null;
        this.f394060i = null;
        u r101 = this.f394055d;
        r101.f394150c.setAlpha(1.0f);
        AudioSpectrumView r102 = r101.f394149b;
        r102.setSpeakIntensity(0.0f);
        r102.setPauseIntensity(0.0f);
        r102.setPauseProgress(0.0f);
        r102.setPauseSlope(0.15f);
        r102.setWaveIntensity(0.0f);
        r102.setWavePlayProgress(0.0f);
        r101.f394164q = null;
        r101.f394162o = true;
        r101.f394167t.clear();
        Animator r103 = r101.f394166s;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        AudioGradientView r104 = r101.f394150c;
        if ((r104 instanceof AudioShimmerGradientView) == false) goto L8;
        r100 = (AudioShimmerGradientView) r104;
    L8:
        if (r100 == null) goto L10;
        r100.d();
    L10:
        r101.f394150c.setAnimating(false);
        r101.f394150c.setAlpha(1.0f);
        r101.f394150c.setGrayRatio(0.0f);
        r101.f394150c.setVisibility(0);
    }

    public final void setUseShimmerThinkingAnimation(boolean r100) {
    }

    private final CoroutineScope getLifecycleScope() {
        LifecycleOwner r100 = ViewTreeLifecycleOwner.get(this);
        if (r100 != null) goto L7;
        return null;
    L7:
        return LifecycleOwnerKt.getLifecycleScope(r100);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        Job r100 = this.f394061j;
        AudioShimmerGradientView r101 = null;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        this.f394061j = null;
        this.f394059h = false;
        this.f394060i = null;
        u r102 = this.f394055d;
        Iterator<com.obric.assistant.view.continuespeech.a> r103 = r102.f394167t.iterator();
    L7:
        if (r103.hasNext() == false) goto L9;
        u.b(r103.next().f394118a);
        goto L7
    L9:
        r102.f394167t.clear();
        Animator r104 = r102.f394166s;
        if (r104 == null) goto L12;
        r102.f394166s = null;
        r102.f394165r = null;
        u.b(r104);
    L12:
        r102.f394169v.clear();
        r102.f394170w = 0;
        r102.f394164q = null;
        r102.f394162o = true;
        AudioGradientView r105 = r102.f394148a;
        if (r105 == null) goto L15;
        r105.setAnimating(false);
    L15:
        AudioGradientView r106 = r102.f394150c;
        if ((r106 instanceof AudioShimmerGradientView) == false) goto L18;
        r101 = (AudioShimmerGradientView) r106;
    L18:
        if (r101 == null) goto L20;
        r101.d();
    L20:
        r102.f394150c.setAnimating(false);
    }

    public final int getMode() {
        return this.f394057f;
    }

    public final Function0<Unit> getTimeOutCallback() {
        return this.f394056e;
    }

    public final void d(boolean r110) {
        final u r100 = this.f394055d;
        r100.f394167t.clear();
        Animator r101 = r100.f394166s;
        if (r101 == null) goto L5;
        r101.cancel();
    L5:
        AudioGradientView r102 = r100.f394150c;
        if ((r102 instanceof AudioShimmerGradientView) == false) goto L8;
        AudioShimmerGradientView r103 = (AudioShimmerGradientView) r102;
    L9:
        if (r103 == null) goto L11;
        r103.d();
    L11:
        r100.f394150c.setAnimating(false);
        r100.f394150c.setAlpha(1.0f);
        r100.f394150c.setGrayRatio(0.0f);
        r100.f394150c.setVisibility(0);
        AudioSpectrumView r104 = r100.f394149b;
        r104.setSpeakIntensity(0.0f);
        r104.setPauseIntensity(0.0f);
        r104.setPauseProgress(0.0f);
        r104.setPauseSlope(0.15f);
        r104.setWaveIntensity(0.0f);
        r104.setWavePlayProgress(0.0f);
        if (r110 == false) goto L14;
    L17:
        boolean r111 = true;
    L18:
        FLogger.f375446a.i("AudioContinueAnimDelegate", "createWelcomeAnimation first:" + r111);
        ArrayList r105 = new ArrayList();
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r100.f394150c, View.ALPHA, new float[]{1.0f});
        r106.setDuration(r100.f394155h);
        r106.addListener(new y(r100));
        Intrinsics.checkNotNull(r106);
        r105.add(r106);
        ObjectAnimator r107 = ObjectAnimator.ofFloat(r100.f394149b, View.ALPHA, new float[]{1.0f});
        r107.setDuration(r100.f394155h);
        r107.addListener(new x(r100));
        Intrinsics.checkNotNull(r107);
        r105.add(r107);
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r108.setDuration(r100.f394157j);
        r108.setInterpolator(r100.f394161n);
        r108.addUpdateListener(new h(r100));
        Intrinsics.checkNotNull(r108);
        r105.add(r108);
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r109.setDuration(r100.f394157j);
        r109.setInterpolator(r100.f394161n);
        r109.addUpdateListener(new i(r100));
        Intrinsics.checkNotNull(r109);
        r105.add(r109);
        if (r111 == true) goto L21;
        AnimatorSet r112 = new AnimatorSet();
        r112.playTogether(r105);
        Pair r113 = new Pair(r112, Boolean.FALSE);
    L22:
        r100.e((Animator) r113.getFirst(), ((Boolean) r113.getSecond()).booleanValue(), null, null);
        if (r100.f394163p == false) goto L26;
        r100.f394163p = false;
        return;
    L26:
        return;
    L21:
        ValueAnimator r114 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r114.setDuration(r100.f394156i);
        r114.setInterpolator(r100.f394159l);
        r114.addUpdateListener(new j(r100));
        Intrinsics.checkNotNull(r114);
        r105.add(r114);
        ValueAnimator r115 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f});
        r115.setDuration(r100.f394158k);
        r115.setInterpolator(r100.f394161n);
        r115.addUpdateListener(new k(r100));
        Intrinsics.checkNotNull(r115);
        r105.add(r115);
        AnimatorSet r116 = new AnimatorSet();
        r116.playTogether(r105);
        r113 = new Pair(r116, Boolean.FALSE);
        goto L22
    L14:
        if (r100.f394163p == true) goto L17;
        r111 = false;
        goto L18
    L8:
        r103 = null;
        goto L9
    }

    public void setAudioData(ArrayList<Double> r110) {
        Intrinsics.checkNotNullParameter(r110, "sampleData");
        Job r100 = this.f394061j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        CoroutineScope r101 = getLifecycleScope();
        if (r101 != null) goto L8;
        return;
    L8:
        this.f394061j = BuildersKt.launch$default(r101, Dispatchers.getDefault(), null, new AnonymousClass2(this, r110, null), 2, null);
    }

    public final void setMode(int r100) {
        this.f394057f = r100;
    }

    public final void setRecognizing(boolean r100) {
        boolean r101 = this.f394059h;
        this.f394059h = r100;
        if (r101 == true) goto L13;
        if (r100 == false) goto L14;
        Float r102 = this.f394060i;
        if (r102 == null) goto L15;
        float r103 = r102.floatValue();
        u r104 = this.f394055d;
        if (this.f394057f != 0) goto L10;
        boolean r105 = true;
    L11:
        r104.g(r103, r105);
        return;
    L10:
        r105 = false;
        goto L11
    L15:
        return;
    L14:
        return;
    }

    public final void setTimeOutCallback(Function0<Unit> r100) {
        this.f394056e = r100;
        this.f394055d.f394168u = r100;
    }

    @Override // iga.a
    public void setAudioData(byte[] r110) {
        Intrinsics.checkNotNullParameter(r110, "data");
        Job r100 = this.f394061j;
        if (r100 == null) goto L5;
        Job.DefaultImpls.cancel$default(r100, null, 1, null);
    L5:
        CoroutineScope r101 = getLifecycleScope();
        if (r101 != null) goto L8;
        return;
    L8:
        this.f394061j = BuildersKt.launch$default(r101, Dispatchers.getDefault(), null, new AnonymousClass1(r110, this, null), 2, null);
    }

    public final void c(int[] r110, float[] r111) {
        Intrinsics.checkNotNullParameter(r110, "colors");
        Intrinsics.checkNotNullParameter(r111, "positions");
        AudioGradientView r100 = this.f394054c;
        int r101 = r110.length;
        int[] r102 = new int[r101];
        int r103 = 0;
        int r104 = 0;
    L3:
        if (r104 >= r101) goto L5;
        int r105 = r110[r104];
        r102[r104] = Color.argb(255, Color.red(r105), Color.green(r105), Color.blue(r105));
        r104 = r104 + 1;
        goto L3
    L5:
        r100.getClass();
        if (r101 != 0) goto L8;
        boolean r106 = true;
    L9:
        if (r106 == false) goto L11;
        r100.f394072j = false;
        r100.f394073k = 0;
        r100.invalidate();
        return;
    L11:
        int r107 = Math.min(r101, 8);
        if (r111.length >= r107) goto L14;
        r100.f394072j = false;
        r100.f394073k = 0;
        r100.invalidate();
        return;
    L14:
        float r108 = 0.0f;
    L16:
        if (r103 >= r107) goto L18;
        int r112 = r102[r103];
        int r113 = r103 * 4;
        r100.f394074l[r113] = Color.red(r112) / 255.0f;
        r100.f394074l[r113 + 1] = Color.green(r112) / 255.0f;
        r100.f394074l[r113 + 2] = Color.blue(r112) / 255.0f;
        r100.f394074l[r113 + 3] = Color.alpha(r112) / 255.0f;
        r108 = RangesKt.coerceAtLeast(RangesKt.coerceIn(r111[r103], 0.0f, 1.0f), r108);
        r100.f394075m[r103] = r108;
        r103 = r103 + 1;
        goto L16
    L18:
        int r109 = r107;
    L19:
        if (r109 >= 8) goto L21;
        int r114 = r109 * 4;
        float[] r115 = r100.f394074l;
        r115[r114] = 0.0f;
        r115[r114 + 1] = 0.0f;
        r115[r114 + 2] = 0.0f;
        r115[r114 + 3] = 0.0f;
        r100.f394075m[r109] = 1.0f;
        r109 = r109 + 1;
        goto L19
    L21:
        r100.f394072j = true;
        r100.f394073k = r107;
        r100.invalidate();
        return;
    L8:
        r106 = false;
        goto L9
    }

    public AudioContinueGradientView(Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f394058g = 45;
        TypedArray r103 = r100.obtainStyledAttributes(r101, new int[]{R.attr.audioWindowMode}, r102, 0);
        boolean r104 = r103.getBoolean(0, false);     // Catch: Throwable -> L10
        r103.recycle();
        FrameLayout.inflate(r100, R.layout.obric_audio_continue_gradient_view, this);
        AudioSpectrumView r105 = (AudioSpectrumView) findViewById(R.id.voice_bars);
        this.f394053b = r105;
        FrameLayout r106 = (FrameLayout) findViewById(R.id.voice_bar_frame);
        this.f394052a = r106;
        if (r104 == false) goto L7;
        AudioGradientView r107 = new AudioShimmerGradientView(getContext(), null, 6, 0);
    L8:
        r107.setAutoExpand(false);
        r107.setBlurRadius(0.0f);
        r107.setCornerRadius(0.0f);
        r107.setLayoutParams(new FrameLayout.LayoutParams(-1, -1));
        r107.setVisibility(0);
        r106.addView(r107, 0);
        this.f394054c = r107;
        this.f394055d = new u(r105, r107);
        return;
    L7:
        r107 = new AudioGradientView(getContext(), null, 6, 0);
    L10:
        th = move-exception;
        r103.recycle();
        throw th;
    }

    public static final Object b(AudioContinueGradientView r100, ArrayList r101, Continuation r102) {
        r100.getClass();
        Iterator r103 = r101.iterator();
        if (r103.hasNext() == true) goto L5;
        Double r104 = null;
    L10:
        if (r104 == null) goto L12;
        double r105 = r104.doubleValue();
    L14:
        if (r105 <= 0.5d) goto L16;
        double r106 = 1.0d;
    L17:
        Object r107 = BuildersKt.withContext(Dispatchers.getMain(), new AudioContinueGradientView$setAudioDataInner$2(r100, RangesKt.coerceAtMost(((float) r106) * 2.5f, 1.0f), null), r102);
        if (r107 != IntrinsicsKt.getCOROUTINE_SUSPENDED()) goto L21;
        return r107;
    L21:
        return Unit.INSTANCE;
    L16:
        r106 = Math.sin(r105 * 3.141592653589793d);
        goto L17
    L12:
        r105 = AudioStats.AUDIO_AMPLITUDE_NONE;
        goto L14
    L5:
        double r108 = Math.abs(((Number) r103.next()).doubleValue());
    L7:
        if (r103.hasNext() == false) goto L9;
        r108 = Math.max(r108, Math.abs(((Number) r103.next()).doubleValue()));
        goto L7
    L9:
        r104 = Boxing.boxDouble(r108);
        goto L10
    }

    public /* synthetic */ AudioContinueGradientView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
