package com.obric.assistant.view.continuespeech;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ValueAnimator;
import android.content.Context;
import android.view.animation.PathInterpolator;
import androidx.fragment.app.CompatKt;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import com.bytedance.android.livesdk.ktvimpl.ktvroom.challenge.vm.KtvSingChallengeViewModel;
import com.larus.bmhome.chat.h4;
import com.larus.home.api.main.HomeService;
import com.larus.nova.R;
import com.larus.utils.logger.FLogger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import kotlin.Pair;
import kotlin.Result;
import kotlin.ResultKt;
import kotlin.Unit;
import kotlin.collections.ArrayDeque;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AudioGradientView f394148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AudioSpectrumView f394149b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final AudioGradientView f394150c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final long f394151d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final long f394152e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f394153f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f394154g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final long f394155h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final long f394156i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final long f394157j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final long f394158k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final PathInterpolator f394159l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final PathInterpolator f394160m;

    /* JADX INFO: renamed from: n, reason: collision with root package name */
    public final PathInterpolator f394161n;

    /* JADX INFO: renamed from: o, reason: collision with root package name */
    public boolean f394162o;

    /* JADX INFO: renamed from: p, reason: collision with root package name */
    public boolean f394163p;

    /* JADX INFO: renamed from: q, reason: collision with root package name */
    public RealtimeCallLifeState f394164q;

    /* JADX INFO: renamed from: r, reason: collision with root package name */
    public com.obric.assistant.view.continuespeech.a f394165r;

    /* JADX INFO: renamed from: s, reason: collision with root package name */
    public Animator f394166s;

    /* JADX INFO: renamed from: t, reason: collision with root package name */
    public final ArrayDeque<com.obric.assistant.view.continuespeech.a> f394167t;

    /* JADX INFO: renamed from: u, reason: collision with root package name */
    public Function0<Unit> f394168u;

    /* JADX INFO: renamed from: v, reason: collision with root package name */
    public final LinkedList<Float> f394169v;

    /* JADX INFO: renamed from: w, reason: collision with root package name */
    public long f394170w;

    public static final class a {
    }

    public static class b implements Animator.AnimatorListener {
        public b() {
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }

        @Override // android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
        }
    }

    public /* synthetic */ class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f394171a = null;

        static {
            int[] r100 = new int[RealtimeCallLifeState.values().length];
            r100[RealtimeCallLifeState.SpeechStarted.ordinal()] = 1;     // Catch: NoSuchFieldError -> L10
        L15:
            r100[RealtimeCallLifeState.Thingking.ordinal()] = 2;     // Catch: NoSuchFieldError -> L11
        L23:
            r100[RealtimeCallLifeState.QueryRejected.ordinal()] = 3;     // Catch: NoSuchFieldError -> L12
        L17:
            r100[RealtimeCallLifeState.TTSEnd.ordinal()] = 4;     // Catch: NoSuchFieldError -> L13
        L19:
            r100[RealtimeCallLifeState.FinishSession.ordinal()] = 5;     // Catch: NoSuchFieldError -> L14
        L8:
            f394171a = r100;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public boolean f394172a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ u f394173b;

        public d(u r100) {
            this.f394173b = r100;
        }

        @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f394172a = true;
        }

        @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            Intrinsics.checkNotNullParameter(r100, "p0");
            if (this.f394172a == false) goto L6;
            this.f394172a = false;
            return;
        L6:
            Function0<Unit> r101 = this.f394173b.f394168u;
            if (r101 == null) goto L10;
            r101.invoke();
            return;
        }

        @Override // com.obric.assistant.view.continuespeech.u.b, android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, "p0");
            Intrinsics.checkNotNullParameter(r100, "p0");
            this.f394173b.f394162o = false;
        }
    }

    static {
    }

    public static void b(Animator r100) {
        r100.cancel();
        if ((r100 instanceof AnimatorSet) == false) goto L9;
        Iterator<T> r101 = ((AnimatorSet) r100).getChildAnimations().iterator();
    L6:
        if (r101.hasNext() == false) goto L9;
        Animator r102 = (Animator) r101.next();
        Intrinsics.checkNotNull(r102);
        b(r102);
    L9:
        if ((r100 instanceof ValueAnimator) == false) goto L11;
        ((ValueAnimator) r100).removeAllUpdateListeners();
    L11:
        r100.removeAllListeners();
    }

    public final Pair<Animator, Boolean> d(boolean r110) {
        FLogger.f375446a.i("AudioContinueAnimDelegate", "createTimeOutAnimation timeOut:" + r110);
        ArrayList r100 = new ArrayList();
        float r101 = 0.0f;
        float r102 = 1.0f;
        if (r110 == true) goto L5;
        float r103 = RangesKt.coerceIn(this.f394150c.getGrayRatio(), 0.0f, 1.0f);
    L6:
        if (r110 == true) goto L8;
        long r104 = RangesKt.coerceAtLeast((long) (this.f394155h * r103), 0);
    L12:
        if (r110 == false) goto L14;
        float r105 = 0.0f;
    L15:
        ValueAnimator r106 = ValueAnimator.ofFloat(new float[]{this.f394149b.getPauseProgress(), r105});
        r106.setDuration(r104);
        if (r110 == false) goto L18;
        PathInterpolator r107 = this.f394160m;
    L19:
        r106.setInterpolator(r107);
        r106.addUpdateListener(new com.obric.assistant.view.continuespeech.b(this));
        Intrinsics.checkNotNull(r106);
        r100.add(r106);
        if (r110 == false) goto L22;
        float r108 = 1.0f;
    L23:
        ValueAnimator r109 = ValueAnimator.ofFloat(new float[]{this.f394150c.getGrayRatio(), r108});
        r109.setDuration(r104);
        if (r110 == false) goto L26;
        PathInterpolator r111 = this.f394160m;
    L27:
        r109.setInterpolator(r111);
        r109.addUpdateListener(new l(this));
        Intrinsics.checkNotNull(r109);
        r100.add(r109);
        int r112 = com.obric.assistant.chat.p.f386974a;
        AudioGradientView r113 = this.f394148a;
        Float r114 = null;
        if (HomeService.f344094a.o() == false) goto L39;
        if (r113 != null) goto L87;
        Fragment r115 = null;
    L51:
        if (r115 == null) goto L57;
        t1a.b r116 = s1a.a.g(r115);
        if (r116 == null) goto L57;
        laa.d r117 = (laa.d) r116.getAbility(laa.d.class);
        if (r117 == null) goto L57;
        Boolean r118 = Boolean.valueOf(r117.aF());
    L58:
        if (r118 == null) goto L72;
        boolean r119 = r118.booleanValue();
        if (r110 == false) goto L65;
        if (r119 == false) goto L63;
        r101 = 0.4f;
    L63:
        Float r120 = Float.valueOf(r101);
    L64:
        r114 = r120;
        goto L72
    L65:
        boolean r121 = v19.h.f552477a;
        boolean r122 = v19.h.b(this.f394149b.getContext());
        if (r119 == true) goto L71;
        if (r122 == false) goto L70;
        r102 = 0.6f;
        goto L71
    L70:
        r102 = 0.32f;
    L71:
        r120 = Float.valueOf(r102);
    L72:
        if (r114 == null) goto L82;
        float[] r123 = new float[2];
        AudioGradientView r124 = this.f394148a;
        if (r124 == null) goto L76;
        float r125 = r124.getAlpha();
    L77:
        r123[0] = r125;
        r123[1] = r114.floatValue();
        ValueAnimator r126 = ValueAnimator.ofFloat(r123);
        r126.setDuration(r104);
        if (r110 == false) goto L80;
        PathInterpolator r127 = this.f394160m;
    L81:
        r126.setInterpolator(r127);
        r126.addUpdateListener(new m(this));
        Intrinsics.checkNotNull(r126);
        r100.add(r126);
        goto L82
    L80:
        r127 = this.f394159l;
        goto L81
    L76:
        r125 = r114.floatValue();
    L82:
        AnimatorSet r128 = new AnimatorSet();
        r128.playTogether(r100);
        if (r110 == false) goto L86;
        r128.setStartDelay(1000);
        r128.addListener(new d(this));
    L86:
        return new Pair(r128, Boolean.valueOf(r110));
    L57:
        r118 = null;
        goto L58
    L87:
        Result.Companion r129 = Result.Companion;     // Catch: Throwable -> L32
        Object r130 = Result.m9449constructorimpl(CompatKt.findFragment(r113));     // Catch: Throwable -> L32
    L35:
        if (Result.m9455isFailureimpl(r130) == false) goto L37;
        r130 = null;
    L37:
        r115 = (Fragment) r130;
    L32:
        th = move-exception;
        Result.Companion r131 = Result.Companion;
        r130 = Result.m9449constructorimpl(ResultKt.createFailure(th));
        goto L35
    L39:
        if (r113 == null) goto L57;
        Context r132 = r113.getContext();
        if (r132 == null) goto L57;
        FragmentActivity r133 = com.larus.utils.i.a(r132);
        if (r133 == null) goto L57;
        if ((r133 instanceof h4) == true) goto L48;
        r133 = null;
    L48:
        if (r133 == null) goto L57;
        r115 = r133.getSupportFragmentManager().findFragmentById(R.id.fragment_container);
        goto L51
    L26:
        r111 = this.f394159l;
        goto L27
    L22:
        r108 = 0.0f;
        goto L23
    L18:
        r107 = this.f394159l;
        goto L19
    L14:
        r105 = 1.0f;
        goto L15
    L8:
        if (this.f394162o == false) goto L10;
        r104 = KtvSingChallengeViewModel.CHALLENGE_ON_GOING_INTERVAL;
        goto L12
    L10:
        r104 = 5000;
        goto L12
    L5:
        r103 = 1.0f;
        goto L6
    }

    public final void f(RealtimeCallLifeState r100) {
        if (this.f394167t.isEmpty() == false) goto L5;
        return;
    L5:
        ArrayDeque r101 = new ArrayDeque();
    L7:
        if ((!this.f394167t.isEmpty()) == false) goto L12;
        com.obric.assistant.view.continuespeech.a r102 = this.f394167t.removeFirst();
        if (r102.f394120c == r100) goto L7;
        r101.addLast(r102);
    L12:
        if ((!r101.isEmpty()) == false) goto L14;
        this.f394167t.addLast((com.obric.assistant.view.continuespeech.a) r101.removeFirst());
        goto L12
    }

    public u(AudioSpectrumView r100, AudioGradientView r101) {
        Intrinsics.checkNotNullParameter(r100, "audioSpectrumView");
        Intrinsics.checkNotNullParameter(r101, "voiceGradientView");
        this.f394148a = null;
        this.f394149b = r100;
        this.f394150c = r101;
        this.f394151d = 50;
        this.f394152e = 150;
        this.f394153f = 200;
        this.f394154g = 250;
        this.f394155h = 300;
        this.f394156i = 350;
        this.f394157j = 700;
        this.f394158k = 1000;
        this.f394159l = new PathInterpolator(0.34f, 0.69f, 0.1f, 1.0f);
        this.f394160m = new PathInterpolator(0.0f, 0.0f, 1.0f, 1.0f);
        this.f394161n = new PathInterpolator(0.4f, 0.8f, 0.74f, 1.0f);
        this.f394162o = true;
        this.f394167t = new ArrayDeque();
        this.f394169v = new LinkedList();
    }

    public final Pair<Animator, Boolean> c(boolean r100, float r110) {
        FLogger.f375446a.i("AudioContinueAnimDelegate", "createInputAnimation show:" + r100 + " curSpeakIntensity:" + this.f394149b.getSpeakIntensity() + " speakIntensityEndValue:" + r110);
        ArrayList r101 = new ArrayList();
        ValueAnimator r111 = ValueAnimator.ofFloat(new float[]{this.f394149b.getSpeakIntensity(), r110});
        r111.setDuration(this.f394155h);
        r111.setInterpolator(this.f394159l);
        r111.addUpdateListener(new n(this));
        Intrinsics.checkNotNull(r111);
        r101.add(r111);
        float r112 = 0.0f;
        if (r100 == false) goto L5;
        float r102 = 0.0f;
    L6:
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{this.f394149b.getPauseIntensity(), r102});
        r103.setDuration(this.f394155h);
        r103.setInterpolator(this.f394159l);
        r103.addUpdateListener(new o(this));
        Intrinsics.checkNotNull(r103);
        r101.add(r103);
        if (r100 == true) goto L10;
        r112 = 1.0f;
    L10:
        ValueAnimator r113 = ValueAnimator.ofFloat(new float[]{this.f394149b.getPauseProgress(), r112});
        r113.setDuration(this.f394155h);
        r113.setInterpolator(this.f394159l);
        r113.addUpdateListener(new p(this));
        Intrinsics.checkNotNull(r113);
        r101.add(r113);
        AnimatorSet r114 = new AnimatorSet();
        r114.playTogether(r101);
        return new Pair(r114, Boolean.valueOf(r100));
    L5:
        r102 = 1.0f;
        goto L6
    }

    public final void g(float r100, boolean r101) {
        if (this.f394164q == RealtimeCallLifeState.SpeechStarted) goto L5;
        if (r101 == true) goto L5;
        return;
    L5:
        this.f394169v.offer(Float.valueOf(r100));
        if (Math.abs(System.currentTimeMillis() - this.f394170w) < 400) goto L14;
        Float r102 = CollectionsKt.m9877maxOrNull(this.f394169v);
        if (r102 == null) goto L10;
        float r103 = r102.floatValue();
    L11:
        this.f394169v.clear();
        Pair<Animator, Boolean> r104 = c(true, r103);
        e(r104.getFirst(), r104.getSecond().booleanValue(), null, null);
        this.f394170w = System.currentTimeMillis();
        return;
    L10:
        r103 = 0.0f;
        goto L11
    }

    public static final void a(u r100, Animator r101, boolean r102) {
        if (Intrinsics.areEqual(r101, r100.f394166s) == false) goto L27;
        com.obric.assistant.view.continuespeech.a r103 = r100.f394165r;
        com.obric.assistant.view.continuespeech.a r104 = null;
        r100.f394166s = null;
        r100.f394165r = null;
        if (r102 == true) goto L12;
        if (r103 == null) goto L12;
        Function0<Unit> r105 = r103.f394121d;
        if (r105 == null) goto L12;
        r105.invoke();
    L12:
        if ((!r100.f394167t.isEmpty()) == false) goto L18;
        com.obric.assistant.view.continuespeech.a r106 = r100.f394167t.removeFirst();
        RealtimeCallLifeState r107 = r106.f394120c;
        if (r107 == null) goto L17;
        if (r107 != r100.f394164q) goto L12;
    L17:
        r104 = r106;
    L18:
        if (r104 == null) goto L26;
        r100.f394165r = r104;
        Animator r108 = r104.f394118a;
        r108.addListener(new z(r100));
        r108.start();
        r100.f394166s = r108;
        return;
    L26:
        return;
    }

    public final void e(Animator r100, boolean r101, RealtimeCallLifeState r102, Function0<Unit> r103) {
        com.obric.assistant.view.continuespeech.a r104 = new com.obric.assistant.view.continuespeech.a(r100, r101, r102, r103);
        com.obric.assistant.view.continuespeech.a r105 = this.f394165r;
        Animator r106 = this.f394166s;
        if (r105 == null) goto L10;
        if (r106 == null) goto L10;
        this.f394167t.addLast(r104);
        if (r105.f394119b == false) goto L12;
        r106.cancel();
        return;
    L12:
        return;
    L10:
        this.f394165r = r104;
        Animator r107 = r104.f394118a;
        r107.addListener(new z(this));
        r107.start();
        this.f394166s = r107;
    }
}
