package com.bytedance.android.shopping.prepurchase.business.pdp.view;

import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewGroup;
import androidx.cardview.widget.CardView;
import com.bytedance.android.ec.core.widget.ECLottieAnimationView;
import com.bytedance.android.shopping.anchorv4.floatwidget.replay.PlayBackEntryVO;
import com.facebook.drawee.view.SimpleDraweeView;
import com.larus.apm.impl.protector.RunnableProtector;
import kotlin.Unit;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class f implements Runnable {
    public final /* synthetic */ AnchorV4PlaybackAreaV2 a;
    public final /* synthetic */ int b;
    public final /* synthetic */ com.bytedance.android.shopping.prepurchase.arch.container.intf.a c;
    public final /* synthetic */ int d;
    public final /* synthetic */ l e;
    public final /* synthetic */ PlayBackEntryVO f;

    public static final class a implements Runnable {
        public final /* synthetic */ f a;

        /* JADX INFO: renamed from: com.bytedance.android.shopping.prepurchase.business.pdp.view.f$a$a, reason: collision with other inner class name */
        public static final class C0174a implements ValueAnimator.AnimatorUpdateListener {
            public final /* synthetic */ a a;

            public C0174a(a r1) {
                this.a = r1;
            }

            @Override // android.animation.ValueAnimator.AnimatorUpdateListener
            public final void onAnimationUpdate(ValueAnimator r10) {
                Object r11 = r10.getAnimatedValue();
                if (r11 == null) goto L10;
                float r12 = ((Float) r11).floatValue();
                if (r12 != 1.0f) goto L7;
                this.a.a.a.h.setVisibility(8);
            L7:
                SimpleDraweeView r1 = this.a.a.a.h;
                ViewGroup.LayoutParams r2 = r1.getLayoutParams();
                int r3 = AnchorV4PlaybackAreaV2.a(this.a.a.a, com.bytedance.android.shopping.extensions.b.b(10), 0, r12);
                r2.width = r3;
                r2.height = r3;
                Unit r4 = Unit.INSTANCE;
                r1.setLayoutParams(r2);
                View r5 = this.a.a.a.l;
                ViewGroup.LayoutParams r6 = r5.getLayoutParams();
                int r7 = AnchorV4PlaybackAreaV2.a(this.a.a.a, com.bytedance.android.shopping.extensions.b.b(62), com.bytedance.android.shopping.extensions.b.b(24), r12);
                r6.width = r7;
                r6.height = r7;
                r5.setLayoutParams(r6);
                ECLottieAnimationView r8 = this.a.a.a.k;
                ViewGroup.LayoutParams r9 = r8.getLayoutParams();
                r9.width = com.bytedance.android.shopping.extensions.b.b(62);
                r9.height = com.bytedance.android.shopping.extensions.b.b(62);
                r8.setLayoutParams(r9);
                this.a.a.a.k.setAlpha(0.0f + (1.0f * r12));
                View r13 = this.a.a.a.a;
                ViewGroup.LayoutParams r14 = r13.getLayoutParams();
                r14.width = AnchorV4PlaybackAreaV2.a(this.a.a.a, com.bytedance.android.shopping.extensions.b.b(70), com.bytedance.android.shopping.extensions.b.b(32), r12);
                r14.height = AnchorV4PlaybackAreaV2.a(this.a.a.a, com.bytedance.android.shopping.extensions.b.b(66), com.bytedance.android.shopping.extensions.b.b(32), r12);
                r13.setLayoutParams(r14);
                View r15 = this.a.a.a.e;
                ViewGroup.LayoutParams r16 = r15.getLayoutParams();
                int r17 = AnchorV4PlaybackAreaV2.a(this.a.a.a, com.bytedance.android.shopping.extensions.b.b(62), 0, r12);
                r16.width = r17;
                r16.height = r17;
                r15.setLayoutParams(r16);
                this.a.a.a.e.setAlpha(1.0f + ((-1.0f) * r12));
                return;
            L10:
                throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
            }
        }

        public a(f r1) {
            this.a = r1;
        }

        public final void a() {
            this.a.a.l.setVisibility(0);
            this.a.a.k.playAnimation();
            View r0 = this.a.a.g;
            ViewGroup.LayoutParams r1 = r0.getLayoutParams();
            if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
            r1 = null;
        L5:
            ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
            if (r2 == null) goto L8;
            r2.leftMargin = com.bytedance.android.shopping.extensions.b.b(3);
            r2.rightMargin = com.bytedance.android.shopping.extensions.b.b(3);
            r2.topMargin = com.bytedance.android.shopping.extensions.b.b(5);
            r2.bottomMargin = com.bytedance.android.shopping.extensions.b.b(9);
            r0.setLayoutParams(r2);
        L8:
            ValueAnimator r3 = ValueAnimator.ofFloat(new float[]{0.0f, 1.0f}).setDuration(500);
            r3.addUpdateListener(new C0174a(this));
            r3.start();
        }

        @Override // java.lang.Runnable
        public final void run() {
            a();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public f(AnchorV4PlaybackAreaV2 r1, int r2, com.bytedance.android.shopping.prepurchase.arch.container.intf.a r3, int r4, com.bytedance.android.shopping.prepurchase.business.pdp.components.layer.pendent.d r5, PlayBackEntryVO r6) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = r4;
        this.e = r5;
        this.f = r6;
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$PrimitiveArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public final void a() {
        this.a.setVisibility(0);
        CardView r0 = this.a;
        ViewGroup.LayoutParams r1 = r0.getLayoutParams();
        if ((r1 instanceof ViewGroup.MarginLayoutParams) == true) goto L5;
        r1 = null;
    L5:
        ViewGroup.MarginLayoutParams r2 = (ViewGroup.MarginLayoutParams) r1;
        if (r2 == null) goto L12;
        r2.rightMargin = com.bytedance.android.shopping.extensions.b.b(8);
        int r3 = this.b + com.bytedance.android.shopping.extensions.b.b(48);
        com.bytedance.android.shopping.prepurchase.arch.container.intf.a r4 = this.c;
        int r5 = ((r4.b + r3) - r4.d) - this.d;
        this.a.r = Integer.valueOf(r5);
        this.a.s = Integer.valueOf(r3);
        if (this.e.isFullScreen() == true) goto L11;
        r3 = r5;
    L11:
        r2.topMargin = r3;
        r0.setLayoutParams(r2);
    L12:
        float r6 = this.a.getWidth() + com.bytedance.android.shopping.extensions.b.b(8);
        if (this.f.enableIconSlideAnimation(Boolean.valueOf(this.e.isFullScreen())) == false) goto L16;
        this.a.setTranslationX(r6);
    L16:
        if (this.f.enableIconSlideAnimation(Boolean.valueOf(this.e.isFullScreen())) == false) goto L19;
        this.a.animate().translationX(0.0f).setDuration(1000).start();
    L19:
        if (this.f.showLottie(Boolean.valueOf(this.e.isFullScreen())) == false) goto L22;
        this.a.postDelayed(new a(this), this.f.getTransformAnimStartTime());
        return;
    }

    @Override // java.lang.Runnable
    public final void run() {
        a();     // Catch: Throwable -> L4
        return;
    L4:
        th = move-exception;
        if (RunnableProtector.intercept(th) == false) goto L8;
        return;
    L8:
        throw th;
    }
}
