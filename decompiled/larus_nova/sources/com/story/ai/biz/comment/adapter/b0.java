package com.story.ai.biz.comment.adapter;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.content.res.TypedArray;
import android.view.View;
import android.view.animation.LinearInterpolator;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;
import com.baidu.platform.comapi.map.MapController;
import com.larus.nova.R;
import com.story.ai.biz.comment.model.BaseComment;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class b0 {

    public static final class a implements Animator.AnimatorListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f459795a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final /* synthetic */ BaseComment f459796b;

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
            this.f459795a.setTag(null);
            this.f459796b.setShowBgFlashing(false);
            this.f459795a.setBackgroundColor(0);
        }

        public a(View r100, BaseComment r101) {
            this.f459795a = r100;
            this.f459796b = r101;
        }
    }

    public b0() {
    }

    public static void a(RecyclerView.ViewHolder r100, BaseComment r101) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        Intrinsics.checkNotNullParameter(r101, MapController.ITEM_LAYER_TAG);
        final View r102 = (View) dnc.b.a(r100, R.id.root);
        if (r101.getShowBgFlashing() == true) goto L13;
        Object r103 = r102.getTag();
        if ((r103 instanceof Animator) == false) goto L7;
        Animator r104 = (Animator) r103;
    L8:
        if (r104 == null) goto L10;
        r104.cancel();
    L10:
        r102.setBackgroundColor(0);
        return;
    L7:
        r104 = null;
        goto L8
    L13:
        if ((r102.getTag() instanceof Animator) == false) goto L15;
        return;
    L15:
        TypedArray r105 = r102.getContext().obtainStyledAttributes(android.R.style.Theme, new int[]{R.attr.neutral_100});
        int r106 = r105.getColor(0, 0);
        r105.recycle();
        if (r106 != ContextCompat.getColor(r102.getContext(), R.color.larus_comments_gray_bg_enhance)) goto L18;
        final int r107 = -16777216;
    L19:
        ValueAnimator r108 = ValueAnimator.ofFloat(new float[]{0.0f, 0.13f, 0.0f});
        r108.setRepeatMode(2);
        r108.setInterpolator(new LinearInterpolator());
        r108.setDuration(700);
        r102.setTag(r108);
        r108.addUpdateListener(new a0(r107, r102));
        Intrinsics.checkNotNull(r108);
        r108.addListener(new a(r102, r101));
        r108.start();
        return;
    L18:
        r107 = -1;
        goto L19
    }
}
