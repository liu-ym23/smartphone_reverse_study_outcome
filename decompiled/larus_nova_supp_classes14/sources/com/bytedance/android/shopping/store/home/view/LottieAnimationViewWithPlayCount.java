package com.bytedance.android.shopping.store.home.view;

import android.animation.Animator;
import android.content.Context;
import android.util.AttributeSet;
import com.airbnb.lottie.LottieAnimationView;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0005\u0018\u00002\u00020\u0001B'\b\u0007\u0012\u0006\u0010\u000e\u001a\u00020\r\u0012\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\u000f\u0012\b\b\u0002\u0010\u0011\u001a\u00020\u0006¢\u0006\u0004\b\u0012\u0010\u0013J\u0012\u0010\u0005\u001a\u00020\u00042\b\u0010\u0003\u001a\u0004\u0018\u00010\u0002H\u0016R$\u0010\f\u001a\u00020\u00062\u0006\u0010\u0007\u001a\u00020\u00068\u0006@BX\u0086\u000e¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\u0014"}, d2 = {"Lcom/bytedance/android/shopping/store/home/view/LottieAnimationViewWithPlayCount;", "Lcom/airbnb/lottie/LottieAnimationView;", "", "assetName", "", "setAnimation", "", "<set-?>", "b", "I", "getPlayCount", "()I", "playCount", "Landroid/content/Context;", "context", "Landroid/util/AttributeSet;", "attrs", "defStyleAttr", "<init>", "(Landroid/content/Context;Landroid/util/AttributeSet;I)V", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LottieAnimationViewWithPlayCount extends LottieAnimationView {
    public String a;
    public int b;

    public static final class a implements Animator.AnimatorListener {
        public final /* synthetic */ LottieAnimationViewWithPlayCount a;

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationCancel(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationRepeat(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationStart(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
        }

        public a(LottieAnimationViewWithPlayCount r1) {
            this.a = r1;
        }

        @Override // android.animation.Animator.AnimatorListener
        public final void onAnimationEnd(Animator r2) {
            Intrinsics.checkNotNullParameter(r2, "animation");
            LottieAnimationViewWithPlayCount r3 = this.a;
            r3.b = r3.getPlayCount() + 1;
        }
    }

    public LottieAnimationViewWithPlayCount(Context r4) {
        AttributeSet r2 = null;
        this(r4, r2, 6, 0);
    }

    public LottieAnimationViewWithPlayCount(Context r3, AttributeSet r4) {
        this(r3, r4, 4, 0);
    }

    public final int getPlayCount() {
        return this.b;
    }

    public void setAnimation(String r2) {
        if (r2 != null) goto L4;
        return;
    L4:
        if ((!Intrinsics.areEqual(r2, this.a)) == false) goto L8;
        super.setAnimation(r2);
        this.b = 0;
        this.a = r2;
        return;
    }

    public LottieAnimationViewWithPlayCount(Context r2, AttributeSet r3, int r4) {
        Intrinsics.checkNotNullParameter(r2, "context");
        super(r2, r3, r4);
        addAnimatorListener(new a(this));
    }

    public /* synthetic */ LottieAnimationViewWithPlayCount(Context r1, AttributeSet r2, int r3, int r4) {
        if ((r3 & 2) == 0) goto L5;
        r2 = null;
    L5:
        this(r1, r2, 0);
    }
}
