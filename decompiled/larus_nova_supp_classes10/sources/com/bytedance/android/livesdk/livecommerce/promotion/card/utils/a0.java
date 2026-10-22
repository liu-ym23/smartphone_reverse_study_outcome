package com.bytedance.android.livesdk.livecommerce.promotion.card.utils;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.view.View;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
public final class a0 extends AnimatorListenerAdapter {
    public final /* synthetic */ View a;
    public final /* synthetic */ View b;
    public final /* synthetic */ Runnable c;
    public final /* synthetic */ long d;
    public final /* synthetic */ AnimatorListenerAdapter e;

    public static final class a extends AnimatorListenerAdapter {
        public final /* synthetic */ a0 a;

        public a(a0 r1) {
            this.a = r1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            AnimatorListenerAdapter r0 = this.a.e;
            if (r0 == null) goto L6;
            r0.onAnimationEnd(r2);
            return;
        }
    }

    @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
    public final void onAnimationEnd(Animator r3) {
        Intrinsics.checkNotNullParameter(r3, "animation");
        this.a.setVisibility(8);
        this.b.setVisibility(0);
        this.b.setAlpha(0.0f);
        Runnable r4 = this.c;
        if (r4 == null) goto L5;
        r4.run();
    L5:
        this.b.animate().alpha(1.0f).setDuration(this.d).setListener(new a(this)).start();
    }

    public a0(View r1, View r2, Runnable r3) {
        this.a = r1;
        this.b = r2;
        this.c = r3;
        this.d = 300;
        this.e = null;
    }
}
