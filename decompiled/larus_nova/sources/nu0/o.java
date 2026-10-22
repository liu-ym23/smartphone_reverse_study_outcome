package nu0;

import android.animation.Animator;
import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.graphics.drawable.Drawable;
import android.widget.TextView;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public final class o {

    public static final class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ TextView f520598a;

        public a(TextView r100) {
            this.f520598a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            TextView r101 = this.f520598a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setTextColor(((Integer) r102).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final class b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Drawable f520599a;

        public b(Drawable r100) {
            this.f520599a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            Intrinsics.checkNotNullParameter(r100, "animator");
            Drawable r101 = this.f520599a;
            Object r102 = r100.getAnimatedValue();
            if (r102 == null) goto L7;
            r101.setTint(((Integer) r102).intValue());
            return;
        L7:
            throw new NullPointerException("null cannot be cast to non-null type kotlin.Int");
        }
    }

    public static final Animator a(Drawable r100, long r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$getColorAnim");
        ValueAnimator r104 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r102), Integer.valueOf(r103)});
        r104.setDuration(r101);
        r104.addUpdateListener(new b(r100));
        return r104;
    }

    public static final Animator b(TextView r100, long r101, int r102, int r103) {
        Intrinsics.checkNotNullParameter(r100, "$this$getColorAnim");
        ValueAnimator r104 = ValueAnimator.ofObject(new ArgbEvaluator(), new Object[]{Integer.valueOf(r102), Integer.valueOf(r103)});
        r104.setDuration(r101);
        r104.addUpdateListener(new a(r100));
        return r104;
    }
}
