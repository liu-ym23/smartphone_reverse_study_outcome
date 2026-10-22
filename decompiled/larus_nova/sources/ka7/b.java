package ka7;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.View;
import android.view.animation.DecelerateInterpolator;
import ja7.j;

/* JADX INFO: loaded from: classes19.dex */
public final class b extends j {

    public class a implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ View f502194a;

        public a(View r100) {
            this.f502194a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f502194a.setAlpha(((Float) r100.getAnimatedValue()).floatValue());
        }
    }

    /* JADX INFO: renamed from: ka7.b$b, reason: collision with other inner class name */
    public class C6527b implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ ja7.a f502195a;

        public C6527b(ja7.a r100) {
            this.f502195a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            this.f502195a.f497888a.setAlpha(((Float) r100.getAnimatedValue()).floatValue());
        }
    }

    @Override // ja7.i
    public final void c() {
    }

    @Override // ja7.j
    public final void e() {
    }

    public b() {
    }

    @Override // ja7.j
    public final Animator f(ja7.a r100, ja7.a r101) {
        ValueAnimator r102 = ValueAnimator.ofFloat(new float[]{r100.f497888a.getAlpha(), 0.0f});
        r102.addUpdateListener(new C6527b(r100));
        r102.setInterpolator(new DecelerateInterpolator());
        r102.setDuration(150);
        return r102;
    }

    @Override // ja7.j
    public final Animator g(ja7.a r100, ja7.a r101) {
        View r102 = r101.f497888a;
        ValueAnimator r103 = ValueAnimator.ofFloat(new float[]{0.0f, r102.getAlpha()});
        r103.addUpdateListener(new a(r102));
        r103.setInterpolator(new DecelerateInterpolator());
        r103.setDuration(150);
        return r103;
    }
}
