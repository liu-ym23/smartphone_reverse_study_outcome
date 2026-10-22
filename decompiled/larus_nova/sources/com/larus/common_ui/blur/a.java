package com.larus.common_ui.blur;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import com.alibaba.gaiax.template.GXTemplateKey;
import com.larus.utils.logger.FLogger;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.jvm.internal.Ref;

/* JADX INFO: loaded from: classes4.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final BlurView f326878a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f326879b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Animator f326880c;

    /* JADX INFO: renamed from: com.larus.common_ui.blur.a$a, reason: collision with other inner class name */
    public static final class C4183a {
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Ref.IntRef f326881a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ a f326882b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ Function0<Float> f326883c;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f326882b.f326880c = null;
            FLogger.f375446a.i("BlurCircleAnim", "[Round#" + this.f326881a.element + "]: " + r100.hashCode() + "#onAnimationCancel");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            a r101 = this.f326882b;
            r101.f326880c = null;
            if (r101.f326879b != 1) goto L5;
            boolean r102 = true;
        L6:
            FLogger.f375446a.i("BlurCircleAnim", "[Round#" + this.f326881a.element + "]: " + r100.hashCode() + "#onAnimationEnd[stop:" + r102 + ']');
            if (r102 == false) goto L9;
            return;
        L9:
            a r103 = this.f326882b;
            r103.b(r103.f326878a, this.f326883c.invoke().floatValue(), this);
            this.f326881a.element++;
            return;
        L5:
            r102 = false;
            goto L6
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            FLogger.f375446a.i("BlurCircleAnim", "[Round#" + this.f326881a.element + "]: " + r100.hashCode() + "#onAnimationRepeat");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            FLogger.f375446a.i("BlurCircleAnim", "[Round#" + this.f326881a.element + "]:onAnimationStart#" + r100.hashCode());
        }

        public b(Ref.IntRef r100, a r101, Function0<Float> r102) {
            this.f326881a = r100;
            this.f326882b = r101;
            this.f326883c = r102;
        }
    }

    static {
    }

    public a(BlurView r100) {
        Intrinsics.checkNotNullParameter(r100, "view");
        this.f326878a = r100;
        this.f326879b = 1;
    }

    public final void a(Function0<Float> r100) {
        Intrinsics.checkNotNullParameter(r100, "getAmplitude");
        if (this.f326879b != 0) goto L6;
        FLogger.f375446a.i("BlurCircleAnim", "startAnim, already started");
        return;
    L6:
        this.f326879b = 0;
        b r101 = new b(new Ref.IntRef(), this, r100);
        b(this.f326878a, r100.invoke().floatValue(), r101);
    }

    public final Animator b(BlurView r100, float r101, Animator.AnimatorListener r110) {
        float r102 = (float) (((double) 1.0f) + (((double) r101) * 0.1d));
        Animator r103 = this.f326880c;
        if (r103 == null) goto L5;
        r103.cancel();
    L5:
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r100, "circleScale", new float[]{r100.getCircleScale(), r102, 1.0f});
        r104.setDuration(400);
        r104.addListener(r110);
        r104.start();
        this.f326880c = r104;
        return r104;
    }
}
