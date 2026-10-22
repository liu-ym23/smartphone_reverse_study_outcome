package com.bytedance.android.shopping.deepfeed.utlis;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.ViewParent;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.RecyclerView;
import com.bytedance.android.shopping.deepfeed.ui.DeepFeedProductRecyclerview;
import com.bytedance.android.ui.ec.widget.loading.ECDuxLoadingAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/bytedance/android/shopping/deepfeed/utlis/DeepFeedFooterExitAnimator;", "Landroidx/recyclerview/widget/DefaultItemAnimator;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DeepFeedFooterExitAnimator extends DefaultItemAnimator {
    public final View a;
    public final RecyclerView b;

    public static final class a implements ValueAnimator.AnimatorUpdateListener {
        public final /* synthetic */ RecyclerView.ViewHolder a;

        public a(RecyclerView.ViewHolder r1) {
            this.a = r1;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r2) {
            Object r3 = r2.getAnimatedValue();
            if (r3 == null) goto L7;
            float r4 = ((Float) r3).floatValue();
            this.a.itemView.setAlpha(r4);
            this.a.itemView.postInvalidate();
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Float");
        }
    }

    public static final class b extends AnimatorListenerAdapter {
        public final /* synthetic */ DeepFeedFooterExitAnimator a;
        public final /* synthetic */ RecyclerView.ViewHolder b;

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.b.itemView.setLayerType(0, null);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r3) {
            Intrinsics.checkNotNullParameter(r3, "animation");
            this.b.itemView.setLayerType(0, null);
            this.a.dispatchRemoveFinished(this.b);
        }

        public b(DeepFeedFooterExitAnimator r1, RecyclerView.ViewHolder r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class c implements RecyclerView.ItemAnimator.ItemAnimatorFinishedListener {
        public final /* synthetic */ DeepFeedFooterExitAnimator a;

        public c(DeepFeedFooterExitAnimator r1) {
            this.a = r1;
        }

        public final void onAnimationsFinished() {
            RecyclerView r0 = this.a.b;
            if (r0 == null) goto L6;
            r0.setItemAnimator(new DefaultItemAnimator());
            return;
        }
    }

    public final void runPendingAnimations() {
        super.runPendingAnimations();
        isRunning(new c(this));
    }

    public final boolean animateRemove(RecyclerView.ViewHolder r6) {
        if (r6 == null) goto L5;
        View r1 = r6.itemView;
    L6:
        if (r1 == null) goto L16;
        View r2 = r6.itemView;
        View r3 = this.a;
        if (r3 == null) goto L10;
        ViewParent r4 = r3.getParent();
    L12:
        if (Intrinsics.areEqual(r2, r4) == false) goto L16;
        r6.itemView.setVisibility(0);
        r6.itemView.setAlpha(1.0f);
        r6.itemView.requestLayout();
        r6.itemView.invalidate();
        dispatchRemoveStarting(r6);
        ValueAnimator r5 = ValueAnimator.ofFloat(new float[]{1.0f, 0.0f});
        r5.setDuration(getRemoveDuration());
        r6.itemView.setLayerType(2, null);
        r5.addUpdateListener(new a(r6));
        r5.addListener(new b(this, r6));
        r5.start();
        return true;
    L10:
        r4 = null;
    L16:
        return super.animateRemove(r6);
    L5:
        r1 = null;
        goto L6
    }

    public DeepFeedFooterExitAnimator(ECDuxLoadingAnimationView r1, DeepFeedProductRecyclerview r2) {
        this.a = r1;
        this.b = r2;
    }
}
