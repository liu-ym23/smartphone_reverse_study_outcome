package com.bytedance.ee.bear.middleground.comment.extension.addins;

import android.animation.Animator;
import android.animation.ValueAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.ee.bear.middleground.comment.export.bean.CommentBean;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class e extends CardAdapterAddin {

    public interface a {
        void R0(float r1);
    }

    public static final class b implements Animator.AnimatorListener {
        public final /* synthetic */ e a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r1) {
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r1) {
        }

        public b(e r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            com.bytedance.ee.bear.middleground.comment.card.d r3 = this.a.c();
            if (r3 == null) goto L5;
            r3.i = null;
        L5:
            com.bytedance.ee.bear.middleground.comment.card.d r4 = this.a.c();
            if (r4 == null) goto L9;
            r4.j = false;
            return;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RecyclerView.ViewHolder a;

        public c(RecyclerView.ViewHolder r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            this.a.R0(r2.getAnimatedFraction());
        }
    }

    public e() {
    }

    @Override // com.bytedance.ee.bear.middleground.comment.extension.addins.CardAdapterAddin
    public final void e(RecyclerView.ViewHolder r3, CommentBean.CommentDetail r4) {
        Intrinsics.checkNotNullParameter(r3, "holder");
        Intrinsics.checkNotNullParameter(r4, "item");
        com.bytedance.ee.bear.middleground.comment.card.d r5 = c();
        if (r5 == null) goto L6;
        r5.j = true;
    L6:
        if ((r3 instanceof a) == false) goto L9;
        ((a) r3).R0(0.0f);
        ValueAnimator r6 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r6.addUpdateListener(new c(r3));
        Intrinsics.checkNotNull(r6);
        r6.addListener(new b(this));
        r6.setDuration(500);
        r6.setStartDelay(1000);
        r6.start();
        return;
    }
}
