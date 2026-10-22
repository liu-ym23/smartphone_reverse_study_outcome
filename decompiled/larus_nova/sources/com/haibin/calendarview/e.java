package com.haibin.calendarview;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.view.ViewGroup;
import com.bytedance.android.live.core.anim.LiveDegradeFpsAnimator;
import com.larus.apm.impl.protector.RunnableProtector;

/* JADX INFO: loaded from: classes23.dex */
public final class e implements Runnable {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final /* synthetic */ CalendarLayout f276147a;

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f276148a;

        public a(e r100) {
            this.f276148a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            float r101 = ((Float) r100.getAnimatedValue()).floatValue() * 1.0f;
            CalendarLayout r102 = this.f276148a.f276147a;
            r102.f276066c.setTranslationY(r102.f276075l * (r101 / r102.f276074k));
            this.f276148a.f276147a.f276078o = true;
        }
    }

    public class b extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ e f276149a;

        public b(e r100) {
            this.f276149a = r100;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r100) {
            super.onAnimationEnd(r100);
            CalendarLayout r101 = this.f276149a.f276147a;
            r101.f276078o = false;
            CalendarLayout.a(r101);
        }
    }

    public final void a() {
        ViewGroup r100 = this.f276147a.f276070g;
        ObjectAnimator r101 = ObjectAnimator.ofFloat(r100, LiveDegradeFpsAnimator.TRANSLATION_Y, new float[]{r100.getTranslationY(), -this.f276147a.f276074k});
        r101.setDuration(0);
        r101.addUpdateListener(new a(this));
        r101.addListener(new b(this));
        r101.start();
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

    public e(CalendarLayout r100) {
        this.f276147a = r100;
    }
}
