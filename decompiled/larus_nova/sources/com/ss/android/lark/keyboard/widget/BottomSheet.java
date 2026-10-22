package com.ss.android.lark.keyboard.widget;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class BottomSheet {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f430975c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f430976a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f430977b;

    public static final class a {
    }

    public interface b {
        void onDismiss();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f430978a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f430979b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f430980c;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f430978a = r100;
            this.f430979b = (LinearLayout) r100.findViewById(R.id.bottom_sheet_content_container);
            this.f430980c = r100.findViewById(R.id.bottom_sheet_mask);
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ BottomSheet f430981a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        public d(BottomSheet r100) {
            this.f430981a = r100;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f430981a.c().f430978a.setVisibility(8);
            b r101 = this.f430981a.f430977b;
            if (r101 == null) goto L6;
            r101.onDismiss();
            return;
        }
    }

    static {
    }

    public abstract View a(ViewGroup r100);

    public final void b() {
        AnimatorSet r100 = new AnimatorSet().setDuration(300);
        r100.addListener(new d(this));
        r100.playTogether(new Animator[]{ObjectAnimator.ofFloat(c().f430979b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, c().f430979b.getHeight()}).setDuration(300), ObjectAnimator.ofFloat(c().f430980c, "alpha", new float[]{1.0f, 0.0f}).setDuration(300)});
        r100.start();
    }

    public final c c() {
        return (c) this.f430976a.getValue();
    }

    public BottomSheet(final Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f430976a = LazyKt.lazy(new BottomSheet$viewHolder$2(r100, this));
    }
}
