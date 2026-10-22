package com.ss.android.lark.biz.im.extension.panel.drag;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import android.view.animation.AccelerateInterpolator;
import com.alibaba.gaiax.template.GXTemplateKey;
import java.util.Iterator;
import kotlin.Unit;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public final class DragPanel$createDragLayoutChangeListener$1 implements com.ss.android.lark.biz.im.extension.panel.drag.view.b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public float f410523a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final /* synthetic */ DragPanel f410524b;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DragPanel f410525a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ float f410526b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final /* synthetic */ float f410527c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final /* synthetic */ Function1<Float, Unit> f410528d;

        /* JADX WARN: Multi-variable type inference failed */
        public a(DragPanel r100, float r101, float r102, Function1<? super Float, Unit> r103) {
            this.f410525a = r100;
            this.f410526b = r101;
            this.f410527c = r102;
            this.f410528d = r103;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "it");
            Object r101 = r100.getAnimatedValue();
            if ((r101 instanceof Float) == false) goto L5;
            Float r102 = (Float) r101;
        L6:
            if (r102 == null) goto L8;
            float r103 = r102.floatValue();
        L9:
            float r104 = r103 / 1000.0f;
            this.f410525a.f410512j.setTranslationY(this.f410526b + (this.f410527c * r104));
            this.f410528d.invoke(Float.valueOf(r104));
            return;
        L8:
            r103 = 0.0f;
            goto L9
        L5:
            r102 = null;
            goto L6
        }
    }

    public static final class b implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ DragPanel f410529a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ Function0<Unit> f410530b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            DragPanel r101 = this.f410529a;
            r101.f410513k = false;
            r101.f410514l.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f410530b.invoke();
            DragPanel r101 = this.f410529a;
            r101.f410513k = false;
            r101.f410514l.invoke();
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
            Intrinsics.checkNotNullParameter(r100, GXTemplateKey.GAIAX_ANIMATION);
            this.f410529a.f410513k = true;
        }

        public b(DragPanel r100, Function0<Unit> r101) {
            this.f410529a = r100;
            this.f410530b = r101;
        }
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.view.b
    public final void b() {
        DragPanel r100 = this.f410524b;
        if ((r100.f410504b.f410542a instanceof o) == true) goto L6;
        return;
    L6:
        if (r100.f410508f != r100.f410507e) goto L8;
        return;
    L8:
        float r101 = r100.f410512j.getTranslationY();
        final DragPanel r102 = this.f410524b;
        Function0<Unit> r103 = new DragPanel$createDragLayoutChangeListener$1$onFullExpand$1(r102, this);
        final DragPanel r104 = this.f410524b;
        g(r101, 0.0f, r103, new DragPanel$createDragLayoutChangeListener$1$onFullExpand$2(r104, this));
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.view.b
    public final void c() {
        float r100 = this.f410524b.f410512j.getTranslationY();
        float r101 = this.f410523a;
        Function1<Float, Unit> r102 = new DragPanel$createDragLayoutChangeListener$1$onRestoreTouchDownState$1(this);
        g(r100, r101, DragPanel$createDragLayoutChangeListener$1$startRestoreAnimator$1.INSTANCE, r102);
        this.f410523a = 0.0f;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.view.b
    public final void d() {
        this.f410523a = this.f410524b.f410512j.getTranslationY();
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.view.b
    public final void e() {
        DragPanel.f(this.f410524b);
    }

    public DragPanel$createDragLayoutChangeListener$1(DragPanel r100) {
        this.f410524b = r100;
    }

    @Override // com.ss.android.lark.biz.im.extension.panel.drag.view.b
    public final void a(float r100) {
        boolean r101 = true;
        if (r100 >= 0.0f) goto L14;
        ViewGroup r102 = this.f410524b.f410512j;
        float r103 = r102.getTranslationY() + r100;
        if ((r102.getHeight() - r103) >= 0.0f) goto L7;
    L10:
        boolean r104 = true;
    L11:
        if (r104 == false) goto L14;
        r100 = 0.0f;
        goto L14
    L7:
        if (r103 < 0.0f) goto L10;
        r104 = false;
    L14:
        if (r100 == 0.0f) goto L17;
        r101 = false;
    L17:
        if (r101 == false) goto L19;
        return;
    L19:
        ViewGroup r105 = this.f410524b.f410512j;
        r105.setTranslationY(r105.getTranslationY() + r100);
        f(false);
    }

    public final void f(boolean r100) {
        DragPanel r101 = this.f410524b;
        Math.max(r101.f410507e - r101.f410512j.getTranslationY(), 0.0f);
        Iterator<j> r102 = this.f410524b.f410517o.iterator();
    L4:
        if (r102.hasNext() == false) goto L6;
        r102.next().a();
        goto L4
    }

    public final void g(float r100, float r101, Function0<Unit> r102, Function1<? super Float, Unit> r103) {
        ValueAnimator r104 = ValueAnimator.ofFloat(new float[]{1000.0f});
        r104.setDuration(50);
        r104.setInterpolator(new AccelerateInterpolator());
        r104.addUpdateListener(new a(this.f410524b, r100, r101 - r100, r103));
        r104.addListener(new b(this.f410524b, r102));
        r104.start();
    }
}
