package hx1;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.LinearInterpolator;
import android.view.animation.ScaleAnimation;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.bytedance.android.live.core.arch.mvvm.PropertyOwner;
import com.bytedance.ies.sdk.widgets.DataCenter;
import kotlin.Unit;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes8.dex */
public final class a implements hx1.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public AnimatorSet f487467a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public AnimatorSet f487468b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final PropertyOwner<Unit> f487469c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final PropertyOwner f487470d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final PropertyOwner<Unit> f487471e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final PropertyOwner f487472f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final PropertyOwner<Unit> f487473g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final PropertyOwner f487474h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final PropertyOwner<Unit> f487475i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final PropertyOwner f487476j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final ViewGroup f487477k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final ViewGroup f487478l;

    /* JADX INFO: renamed from: m, reason: collision with root package name */
    public final DataCenter f487479m;

    /* JADX INFO: renamed from: hx1.a$a, reason: collision with other inner class name */
    public static final class C6208a {
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f487480a;

        public b(a r100) {
            this.f487480a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == true) goto L5;
            r101 = null;
        L5:
            Float r102 = (Float) r101;
            if (r102 == null) goto L9;
            float r103 = r102.floatValue();
            int r104 = (int) r103;
            this.f487480a.f487477k.getLayoutParams().height = r104;
            this.f487480a.f487477k.requestLayout();
            return;
        }
    }

    public static final class c implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f487481a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public c(a r100) {
            this.f487481a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f487481a.f487477k.clearAnimation();
            this.f487481a.f487477k.removeAllViews();
            this.f487481a.f487477k.getLayoutParams().height = -2;
            this.f487481a.f487477k.setVisibility(8);
            this.f487481a.f487475i.a(Unit.INSTANCE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f487481a.f487477k.setAlpha(1.0f);
            this.f487481a.f487473g.a(Unit.INSTANCE);
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ a f487482a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        public d(a r100) {
            this.f487482a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f487482a.f487471e.a(Unit.INSTANCE);
            this.f487482a.f487479m.put("cmd_scroll_public_screen_msg_to_last", Boolean.TRUE);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f487482a.f487477k.setAlpha(0.0f);
            this.f487482a.f487477k.setVisibility(0);
            this.f487482a.f487469c.a(Unit.INSTANCE);
        }
    }

    static {
    }

    @Override // hx1.b
    public final void cancel() {
        AnimatorSet r100 = this.f487467a;
        AnimatorSet r101 = null;
        if (r100 != null) goto L5;
    L10:
        AnimatorSet r102 = this.f487468b;
        if (r102 != null) goto L13;
        return;
    L13:
        if (r102.isRunning() == false) goto L15;
        r101 = r102;
    L15:
        if (r101 == null) goto L19;
        r101.cancel();
        return;
    L19:
        return;
    L5:
        if (r100.isRunning() == true) goto L8;
        r100 = null;
    L8:
        if (r100 == null) goto L10;
        r100.cancel();
        goto L10
    }

    @Override // hx1.b
    public final void hide() {
        AnimatorSet r100 = this.f487468b;
        if (r100 != null) goto L5;
    L7:
        int r101 = this.f487477k.getMeasuredHeight();
        ViewGroup.LayoutParams r102 = this.f487477k.getLayoutParams();
        if (r102 == null) goto L10;
        int r103 = r102.height;
    L11:
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{Math.max(r101, r103) * 1.0f, 0.0f});
        r104.addUpdateListener(new b(this));
        ObjectAnimator r105 = ObjectAnimator.ofPropertyValuesHolder(this.f487477k, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[]{Keyframe.ofFloat(0.0f, 1.0f), Keyframe.ofFloat(0.8f, 0.75f), Keyframe.ofFloat(1.0f, 0.0f)})});
        AnimatorSet r106 = this.f487468b;
        if (r106 == null) goto L14;
        r106.end();
    L14:
        AnimatorSet r107 = this.f487468b;
        if (r107 == null) goto L17;
        r107.removeAllListeners();
    L17:
        AnimatorSet r108 = new AnimatorSet();
        r108.setDuration(400);
        r108.setInterpolator(new LinearInterpolator());
        r108.addListener(new c(this));
        r108.playTogether(new Animator[]{r104, r105});
        Unit r109 = Unit.INSTANCE;
        this.f487468b = r108;
        r108.start();
        return;
    L10:
        r103 = 0;
        goto L11
    L5:
        if (r100.isRunning() != true) goto L7;
    }

    @Override // hx1.b
    public final void show() {
        AnimatorSet r100 = this.f487467a;
        if (r100 != null) goto L5;
    L7:
        boolean r101 = false;
    L8:
        if (r101 == false) goto L10;
        return;
    L10:
        this.f487477k.setVisibility(4);
        this.f487477k.getLayoutParams().height = -2;
        this.f487477k.removeAllViews();
        this.f487477k.addView(this.f487478l);
        this.f487477k.clearAnimation();
        AnimatorSet r102 = this.f487467a;
        if (r102 == null) goto L13;
        r102.end();
    L13:
        AnimatorSet r103 = this.f487467a;
        if (r103 == null) goto L16;
        r103.removeAllListeners();
    L16:
        ObjectAnimator r104 = ObjectAnimator.ofPropertyValuesHolder(this.f487477k, new PropertyValuesHolder[]{PropertyValuesHolder.ofKeyframe(View.ALPHA, new Keyframe[]{Keyframe.ofFloat(0.0f, 0.0f), Keyframe.ofFloat(0.8f, 0.25f), Keyframe.ofFloat(1.0f, 1.0f)})});
        AnimatorSet r105 = new AnimatorSet();
        r105.setDuration(400);
        r105.setInterpolator(new LinearInterpolator());
        r105.addListener(new d(this));
        r105.playTogether(new Animator[]{r104});
        Unit r106 = Unit.INSTANCE;
        this.f487467a = r105;
        r105.start();
        ScaleAnimation r107 = new ScaleAnimation(1.0f, 1.0f, 0.0f, 1.0f, 1, 0.5f, 1, 1.0f);
        r107.setInterpolator(new LinearInterpolator());
        r107.setDuration(400);
        this.f487477k.startAnimation(r107);
        return;
    L5:
        if (r100.isRunning() != true) goto L7;
        r101 = true;
        goto L8
    }

    @Override // hx1.b
    public final PropertyOwner a() {
        return this.f487476j;
    }

    @Override // hx1.b
    public final PropertyOwner b() {
        return this.f487474h;
    }

    @Override // hx1.b
    public final PropertyOwner c() {
        return this.f487470d;
    }

    @Override // hx1.b
    public final PropertyOwner d() {
        return this.f487472f;
    }

    public a(ViewGroup r100, ViewGroup r101, DataCenter r102) {
        Intrinsics.checkNotNullParameter(r100, "widgetContainer");
        Intrinsics.checkNotNullParameter(r101, "feedbackPage");
        Intrinsics.checkNotNullParameter(r102, "dataCenter");
        this.f487477k = r100;
        this.f487478l = r101;
        this.f487479m = r102;
        Unit r103 = Unit.INSTANCE;
        PropertyOwner<Unit> r104 = new PropertyOwner(r103);
        this.f487469c = r104;
        this.f487470d = r104;
        PropertyOwner<Unit> r105 = new PropertyOwner(r103);
        this.f487471e = r105;
        this.f487472f = r105;
        PropertyOwner<Unit> r106 = new PropertyOwner(r103);
        this.f487473g = r106;
        this.f487474h = r106;
        PropertyOwner<Unit> r107 = new PropertyOwner(r103);
        this.f487475i = r107;
        this.f487476j = r107;
    }
}
