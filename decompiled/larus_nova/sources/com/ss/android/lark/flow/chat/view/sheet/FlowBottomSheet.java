package com.ss.android.lark.flow.chat.view.sheet;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.app.Activity;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import androidx.core.view.OneShotPreDrawListener;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.nova.R;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes36.dex */
public abstract class FlowBottomSheet {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f423147c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Lazy f423148a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public b f423149b;

    public static final class a {
    }

    public interface b {
        void onDismiss();
    }

    public static final class c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final View f423150a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final LinearLayout f423151b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final View f423152c;

        public c(View r100) {
            Intrinsics.checkNotNullParameter(r100, "rootView");
            this.f423150a = r100;
            this.f423151b = (LinearLayout) r100.findViewById(R.id.bottom_sheet_content_container);
            this.f423152c = r100.findViewById(R.id.bottom_sheet_mask);
        }
    }

    public static final class d implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowBottomSheet f423153a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ boolean f423154b;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r100) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            this.f423153a.c().f423150a.setVisibility(8);
            if (this.f423154b == false) goto L8;
            b r101 = this.f423153a.f423149b;
            if (r101 == null) goto L9;
            r101.onDismiss();
            return;
        L9:
            return;
        }

        public d(FlowBottomSheet r100, boolean r101) {
            this.f423153a = r100;
            this.f423154b = r101;
        }
    }

    public static final class e implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f423155a;

        public e(View r100) {
            this.f423155a = r100;
        }

        @Override // java.lang.Runnable
        public final void run() {
            View r100 = this.f423155a;     // Catch: Throwable -> L4
            r100.setTranslationY(r100.getMeasuredHeight());     // Catch: Throwable -> L4
            r100.animate().translationY(0.0f).setDuration(300).start();     // Catch: Throwable -> L4
            return;
        L4:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L8;
            return;
        L8:
            throw th;
        }
    }

    public static final class f implements View.OnKeyListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ FlowBottomSheet f423156a;

        public f(FlowBottomSheet r100) {
            this.f423156a = r100;
        }

        @Override // android.view.View.OnKeyListener
        public final boolean onKey(View r100, int r101, KeyEvent r102) {
            if (r101 == 4) goto L5;
        L7:
            return false;
        L5:
            if (r102.getAction() != 1) goto L7;
            this.f423156a.b(true);
            return true;
        }
    }

    static {
    }

    public abstract View a(ViewGroup r100);

    public final c c() {
        return (c) this.f423148a.getValue();
    }

    public final void d() {
        c().f423150a.setVisibility(0);
        LinearLayout r100 = c().f423151b;
        OneShotPreDrawListener.add(r100, new e(r100));
        c().f423152c.setAlpha(0.0f);
        c().f423152c.animate().alpha(1.0f).setDuration(300).start();
        c().f423152c.setFocusableInTouchMode(true);
        c().f423152c.requestFocus();
        c().f423152c.setOnKeyListener(new f(this));
    }

    public FlowBottomSheet(final Activity r100) {
        Intrinsics.checkNotNullParameter(r100, "activity");
        this.f423148a = LazyKt.lazy(new FlowBottomSheet$viewHolder$2(r100, this));
    }

    public final void b(boolean r110) {
        AnimatorSet r100 = new AnimatorSet().setDuration(300);
        r100.addListener(new d(this, r110));
        r100.playTogether(new Animator[]{ObjectAnimator.ofFloat(c().f423151b, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{0.0f, c().f423151b.getHeight()}).setDuration(300), ObjectAnimator.ofFloat(c().f423152c, "alpha", new float[]{1.0f, 0.0f}).setDuration(300)});
        r100.start();
    }
}
