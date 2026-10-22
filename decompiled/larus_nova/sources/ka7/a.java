package ka7;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import androidx.interpolator.view.animation.FastOutSlowInInterpolator;
import androidx.interpolator.view.animation.LinearOutSlowInInterpolator;
import ja7.j;
import java.util.Arrays;
import java.util.List;

/* JADX INFO: loaded from: classes19.dex */
public final class a extends j {

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final b f502193b;

    @Override // ja7.i
    public final void c() {
    }

    @Override // ja7.j
    public final void e() {
    }

    public a() {
        this.f502193b = new b();
    }

    @Override // ja7.j
    public final Animator f(ja7.a r100, ja7.a r110) {
        if (r100.f497890c == true) goto L5;
        View r111 = r110.f497888a;
        View r101 = r100.f497888a;
        ObjectAnimator r102 = ObjectAnimator.ofFloat(r101, View.ALPHA, new float[]{1.0f, 0.0f});
        r102.setInterpolator(new LinearInterpolator());
        r102.setDuration(150);
        r102.setStartDelay(50);
        ObjectAnimator r103 = ObjectAnimator.ofFloat(r101, View.TRANSLATION_Y, new float[]{0.0f, r111.getHeight() * 0.08f});
        r103.setInterpolator(new AccelerateInterpolator(2.0f));
        r103.setDuration(200);
        ObjectAnimator r112 = ObjectAnimator.ofFloat(r111, View.ALPHA, new float[]{0.7f, 1.0f});
        r112.setInterpolator(new LinearOutSlowInInterpolator());
        r112.setDuration(200);
        List r104 = Arrays.asList(new Animator[]{r102, r103, r112});
        AnimatorSet r113 = new AnimatorSet();
        r113.playTogether(r104);
        return r113;
    L5:
        return this.f502193b.f(r100, r110);
    }

    @Override // ja7.j
    public final Animator g(ja7.a r100, ja7.a r101) {
        if (r101.f497890c == true) goto L5;
        View r102 = r100.f497888a;
        View r103 = r101.f497888a;
        ObjectAnimator r104 = ObjectAnimator.ofFloat(r102, View.ALPHA, new float[]{1.0f, 1.0f});
        r104.setInterpolator(new FastOutSlowInInterpolator());
        r104.setDuration(120);
        ObjectAnimator r105 = ObjectAnimator.ofFloat(r103, View.ALPHA, new float[]{0.0f, 1.0f});
        r105.setInterpolator(new DecelerateInterpolator(2.0f));
        r105.setDuration(120);
        ObjectAnimator r106 = ObjectAnimator.ofFloat(r103, View.TRANSLATION_Y, new float[]{r103.getHeight() * 0.08f, 0.0f});
        r106.setInterpolator(new DecelerateInterpolator(2.5f));
        r106.setDuration(200);
        List r107 = Arrays.asList(new Animator[]{r104, r105, r106});
        AnimatorSet r108 = new AnimatorSet();
        r108.playTogether(r107);
        return r108;
    L5:
        return this.f502193b.g(r100, r101);
    }
}
