package com.obric.assistant.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import android.view.ViewPropertyAnimator;
import android.widget.FrameLayout;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.nova.R;
import com.larus.utils.e1;
import com.obric.assistant.view.continuespeech.AudioContinueGradientView;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
@Metadata(d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u000b\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\u0010\u0006\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u0000 &2\u00020\u0001:\u0001&B'\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007¢\u0006\u0004\b\b\u0010\tJ\u0006\u0010\u0017\u001a\u00020\u0018J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\u001bJ\u0006\u0010\u001e\u001a\u00020\u0018J\u0006\u0010\u001f\u001a\u00020\u0018J\b\u0010 \u001a\u00020\u0018H\u0014J\u001e\u0010!\u001a\u00020\u00182\u0016\u0010\"\u001a\u0012\u0012\u0004\u0012\u00020$0#j\b\u0012\u0004\u0012\u00020$`%R\u001b\u0010\n\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\r\u0010\u000e\u001a\u0004\b\u000b\u0010\fR\u001b\u0010\u000f\u001a\u00020\u00018BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0011\u0010\u000e\u001a\u0004\b\u0010\u0010\fR\u001b\u0010\u0012\u001a\u00020\u00138BX\u0082\u0084\u0002¢\u0006\f\n\u0004\b\u0016\u0010\u000e\u001a\u0004\b\u0014\u0010\u0015R\u000e\u0010\u001d\u001a\u00020\u001bX\u0082\u000e¢\u0006\u0002\n\u0000¨\u0006'"}, d2 = {"Lcom/obric/assistant/view/LongPressMockView;", "Landroid/widget/FrameLayout;", PerfLog.PARAM_KEY_CONTEXT_ID, "Landroid/content/Context;", "attrs", "Landroid/util/AttributeSet;", "defStyleAttr", "", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "mockView", "getMockView", "()Landroid/widget/FrameLayout;", "mockView$delegate", "Lkotlin/Lazy;", "loadingView", "getLoadingView", "loadingView$delegate", "voiceView", "Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "getVoiceView", "()Lcom/obric/assistant/view/continuespeech/AudioContinueGradientView;", "voiceView$delegate", "startShortPress", "", "updateBg", "isChatWindow", "", "panelShown", "onLongPress", "startLongPress", "stopLongPress", "onDetachedFromWindow", "setAudioData", "sampleData", "Ljava/util/ArrayList;", "", "Lkotlin/collections/ArrayList;", "Companion", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LongPressMockView extends FrameLayout {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f393925d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f393926a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Lazy f393927b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Lazy f393928c;

    public static final class a {
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ LongPressMockView f393929a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public b(LongPressMockView r100) {
            this.f393929a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            LongPressMockView r101 = this.f393929a;
            int r102 = LongPressMockView.f393925d;
            r101.getClass();
        }
    }

    static {
    }

    public LongPressMockView(Context r100) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        AttributeSet r101 = null;
        this(r100, r101, 6, 0);
    }

    public LongPressMockView(Context r100, AttributeSet r101) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        this(r100, r101, 4, 0);
    }

    private final FrameLayout getLoadingView() {
        return (FrameLayout) this.f393927b.getValue();
    }

    private final FrameLayout getMockView() {
        return (FrameLayout) this.f393926a.getValue();
    }

    private final AudioContinueGradientView getVoiceView() {
        return (AudioContinueGradientView) this.f393928c.getValue();
    }

    public final void a() {
        ViewPropertyAnimator r100 = getLoadingView().animate();
        r100.setDuration(300);
        r100.alpha(0.0f);
        r100.setListener(new b(this));
        r100.start();
    }

    public final void b() {
        getVoiceView().a();
        e1.x(getMockView());
        e1.x(getLoadingView());
        e1.x(getVoiceView());
        getLoadingView().setAlpha(1.0f);
    }

    @Override // android.view.ViewGroup, android.view.View
    public final void onDetachedFromWindow() {
        super.onDetachedFromWindow();
        getMockView().animate().cancel();
        getVoiceView().animate().cancel();
        getLoadingView().animate().cancel();
    }

    public final void setAudioData(ArrayList<Double> r100) {
        Intrinsics.checkNotNullParameter(r100, "sampleData");
        getVoiceView().setAudioData(r100);
    }

    public final void c(boolean r100, boolean r101) {
        FrameLayout r102 = getLoadingView();
        int r103 = R.drawable.bg_obric_audio_visualizer1;
        if (r100 == false) goto L7;
        if (r101 == false) goto L6;
        int r104 = R.drawable.bg_obric_audio_visualizer1;
    L10:
        r102.setBackgroundResource(r104);
        FrameLayout r105 = getMockView();
        if (r100 == false) goto L15;
        if (r101 == true) goto L18;
        r103 = R.drawable.bg_obric_audio_visualizer;
    L18:
        r105.setBackgroundResource(r103);
        return;
    L15:
        if (r101 == false) goto L17;
        r103 = R.drawable.bg_obric_audio_visualizer_half_window1;
        goto L18
    L17:
        r103 = R.drawable.bg_obric_audio_visualizer_half_window;
        goto L18
    L6:
        r104 = R.drawable.bg_obric_audio_visualizer;
        goto L10
    L7:
        if (r101 == false) goto L9;
        r104 = R.drawable.bg_obric_audio_visualizer_half_window1;
        goto L10
    L9:
        r104 = R.drawable.bg_obric_audio_visualizer_half_window;
        goto L10
    }

    public LongPressMockView(final Context r100, AttributeSet r101, int r102) {
        Intrinsics.checkNotNullParameter(r100, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101, r102);
        this.f393926a = LazyKt.lazy(new com.obric.assistant.view.b(r100));
        this.f393927b = LazyKt.lazy(new c(r100));
        this.f393928c = LazyKt.lazy(new d(r100));
        addView(getMockView(), new FrameLayout.LayoutParams(-1, -1));
        addView(getLoadingView(), new FrameLayout.LayoutParams(-1, -1));
        AudioContinueGradientView r103 = getVoiceView();
        FrameLayout.LayoutParams r104 = new FrameLayout.LayoutParams(-1, -1);
        r104.gravity = 17;
        Unit r105 = Unit.INSTANCE;
        addView(r103, r104);
    }

    public /* synthetic */ LongPressMockView(Context r100, AttributeSet r101, int r102, int r103) {
        if ((r102 & 2) == 0) goto L5;
        r101 = null;
    L5:
        this(r100, r101, 0);
    }
}
