package com.bytedance.livesdk.ktvcommon.midi.view.midihitview;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.LinearInterpolator;
import com.bytedance.android.live.core.widget.HSImageView;
import com.bytedance.livesdk.ktvcommon.midi.view.LiveDegradeFpsAnimator;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Stack;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes20.dex */
public final class MidiHitAnimationController {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final AnimatorSet f256149a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final AnimatorSet f256150b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final a<ValueAnimator> f256151c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final a<ValueAnimator> f256152d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final a<ValueAnimator> f256153e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Lazy f256154f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final LinearInterpolator f256155g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<WeakReference<View>> f256156h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final com.bytedance.livesdk.ktvcommon.midi.view.midihitview.a f256157i;

    public static final class a<T extends ValueAnimator> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Stack<T> f256158a;

        public a() {
            this.f256158a = new Stack();
        }

        public final T a(Function0<? extends T> r100) {
            Intrinsics.checkNotNullParameter(r100, "create");
            if ((!this.f256158a.isEmpty()) == false) goto L6;
            return this.f256158a.pop();
        L6:
            return r100.invoke();
        }

        public final void b(T r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            if (this.f256158a.size() >= 8) goto L6;
            r100.cancel();
            r100.removeAllUpdateListeners();
            r100.removeAllListeners();
            this.f256158a.push(r100);
            return;
        }
    }

    public final void a() {
        this.f256149a.cancel();
        this.f256150b.cancel();
        Iterator<T> r100 = this.f256149a.getChildAnimations().iterator();
    L4:
        if (r100.hasNext() == false) goto L33;
        Animator r101 = (Animator) r100.next();
        if ((r101 instanceof LiveDegradeFpsAnimator) == true) goto L7;
        if ((r101 instanceof ObjectAnimator) == false) goto L4;
        String r102 = ((ObjectAnimator) r101).getPropertyName();
        if (Intrinsics.areEqual(r102, View.ALPHA.getName()) == true) goto L26;
        if (Intrinsics.areEqual(r102, View.SCALE_X.getName()) == true) goto L29;
        if (Intrinsics.areEqual(r102, View.SCALE_Y.getName()) == false) goto L4;
        this.f256153e.b((ValueAnimator) r101);
        goto L4
    L29:
        this.f256152d.b((ValueAnimator) r101);
        goto L4
    L26:
        this.f256151c.b((ValueAnimator) r101);
        goto L4
    L7:
        String r103 = ((LiveDegradeFpsAnimator) r101).f256060a;
        if (r103 == null) goto L4;
        switch(r103.hashCode()) {
            case -908189618: goto L20;
            case -908189617: goto L17;
            case 92909918: goto L14;
            default: goto L4;
        };
    L14:
        if (r103.equals("alpha") == false) goto L4;
        this.f256151c.b((ValueAnimator) r101);
        goto L4
    L17:
        if (r103.equals(com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.SCALE_Y) == false) goto L4;
        this.f256153e.b((ValueAnimator) r101);
        goto L4
    L20:
        if (r103.equals(com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator.SCALE_X) == false) goto L4;
        this.f256152d.b((ValueAnimator) r101);
        goto L4
    L33:
        Iterator<T> r104 = this.f256150b.getChildAnimations().iterator();
    L35:
        if (r104.hasNext() == false) goto L52;
        Animator r105 = (Animator) r104.next();
        if ((r105 instanceof LiveDegradeFpsAnimator) == true) goto L38;
        if ((r105 instanceof ObjectAnimator) == false) goto L35;
        if (Intrinsics.areEqual(((ObjectAnimator) r105).getPropertyName(), View.ALPHA.getName()) == false) goto L35;
        this.f256151c.b((ValueAnimator) r105);
        goto L35
    L38:
        String r106 = ((LiveDegradeFpsAnimator) r105).f256060a;
        if (r106 == null) goto L35;
        if (r106.hashCode() != 92909918) goto L35;
        if (r106.equals("alpha") == false) goto L35;
        this.f256151c.b((ValueAnimator) r105);
        goto L35
    L52:
        this.f256149a.removeAllListeners();
        this.f256150b.removeAllListeners();
        ((ArrayList) this.f256156h).clear();
    }

    public MidiHitAnimationController(com.bytedance.livesdk.ktvcommon.midi.view.midihitview.a r100) {
        Intrinsics.checkNotNullParameter(r100, "config");
        this.f256157i = r100;
        this.f256149a = new AnimatorSet();
        this.f256150b = new AnimatorSet();
        this.f256151c = new a();
        this.f256152d = new a();
        this.f256153e = new a();
        this.f256154f = LazyKt.lazy(MidiHitAnimationController$scaleInterpolator$2.INSTANCE);
        this.f256155g = new LinearInterpolator();
        this.f256156h = new ArrayList();
    }

    public final ValueAnimator b(final View r100, final float r101, final float r102, long r103) {
        if ((r100 instanceof HSImageView) == false) goto L9;
        ValueAnimator r104 = this.f256151c.a(new MidiHitAnimationController$getAlphaAnimator$anim$1(this, r100, r101, r102));
        if (r104 == null) goto L8;
        ValueAnimator r105 = (LiveDegradeFpsAnimator) r104;
    L12:
        r105.setFloatValues(new float[]{r101, r102});
        r105.setDuration(r103);
        r105.setStartDelay(0);
        r105.removeAllListeners();
        return r105;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.livesdk.ktvcommon.midi.view.LiveDegradeFpsAnimator");
    L9:
        ValueAnimator r106 = this.f256151c.a(new MidiHitAnimationController$getAlphaAnimator$anim$2(this, r100, r101, r102));
        if (r106 == null) goto L15;
        r105 = (ObjectAnimator) r106;
        goto L12
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
    }

    public final ValueAnimator c(final View r100, final float r101, final float r102, long r103) {
        if ((r100 instanceof HSImageView) == false) goto L9;
        ValueAnimator r104 = this.f256152d.a(new MidiHitAnimationController$getScaleXAnimator$anim$1(this, r100, r101, r102));
        if (r104 == null) goto L8;
        ValueAnimator r105 = (LiveDegradeFpsAnimator) r104;
    L12:
        r105.setFloatValues(new float[]{r101, r102});
        r105.setDuration(r103);
        r105.setStartDelay(0);
        r105.removeAllListeners();
        return r105;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.livesdk.ktvcommon.midi.view.LiveDegradeFpsAnimator");
    L9:
        ValueAnimator r106 = this.f256152d.a(new MidiHitAnimationController$getScaleXAnimator$anim$2(this, r100, r101, r102));
        if (r106 == null) goto L15;
        r105 = (ObjectAnimator) r106;
        goto L12
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
    }

    public final ValueAnimator d(final View r100, final float r101, final float r102, long r103) {
        if ((r100 instanceof HSImageView) == false) goto L9;
        ValueAnimator r104 = this.f256153e.a(new MidiHitAnimationController$getScaleYAnimator$anim$1(this, r100, r101, r102));
        if (r104 == null) goto L8;
        ValueAnimator r105 = (LiveDegradeFpsAnimator) r104;
    L12:
        r105.setFloatValues(new float[]{r101, r102});
        r105.setDuration(r103);
        r105.setStartDelay(0);
        r105.removeAllListeners();
        return r105;
    L8:
        throw new NullPointerException("null cannot be cast to non-null type com.bytedance.livesdk.ktvcommon.midi.view.LiveDegradeFpsAnimator");
    L9:
        ValueAnimator r106 = this.f256153e.a(new MidiHitAnimationController$getScaleYAnimator$anim$2(this, r100, r101, r102));
        if (r106 == null) goto L15;
        r105 = (ObjectAnimator) r106;
        goto L12
    L15:
        throw new NullPointerException("null cannot be cast to non-null type android.animation.ObjectAnimator");
    }
}
