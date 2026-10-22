package wz6;

import android.animation.Animator;
import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.os.Build;
import java.util.Iterator;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes21.dex */
public abstract class a extends ValueAnimator {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Set<ValueAnimator.AnimatorUpdateListener> f561942a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<Animator.AnimatorListener> f561943b;

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getStartDelay() {
        throw new UnsupportedOperationException("LottieAnimator does not support getStartDelay.");
    }

    @Override // android.animation.Animator
    public final void removeAllListeners() {
        ((CopyOnWriteArraySet) this.f561943b).clear();
    }

    @Override // android.animation.ValueAnimator
    public final void removeAllUpdateListeners() {
        ((CopyOnWriteArraySet) this.f561942a).clear();
    }

    public a() {
        this.f561942a = new CopyOnWriteArraySet();
        this.f561943b = new CopyOnWriteArraySet();
    }

    final void a(boolean r100) {
        Iterator r101 = ((CopyOnWriteArraySet) this.f561943b).iterator();
    L4:
        if (r101.hasNext() == false) goto L9;
        Animator.AnimatorListener r102 = (Animator.AnimatorListener) r101.next();
        if (Build.VERSION.SDK_INT >= 26) goto L7;
        r102.onAnimationEnd(this);
        goto L4
    L7:
        r102.onAnimationEnd(this, r100);
        goto L4
    }

    @Override // android.animation.Animator
    public final void addListener(Animator.AnimatorListener r100) {
        ((CopyOnWriteArraySet) this.f561943b).add(r100);
    }

    @Override // android.animation.ValueAnimator
    public final void addUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        ((CopyOnWriteArraySet) this.f561942a).add(r100);
    }

    @Override // android.animation.Animator
    public final void removeListener(Animator.AnimatorListener r100) {
        ((CopyOnWriteArraySet) this.f561943b).remove(r100);
    }

    @Override // android.animation.ValueAnimator
    public final void removeUpdateListener(ValueAnimator.AnimatorUpdateListener r100) {
        ((CopyOnWriteArraySet) this.f561942a).remove(r100);
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final ValueAnimator setDuration(long r100) {
        throw new UnsupportedOperationException("LottieAnimator does not support setDuration.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setInterpolator(TimeInterpolator r100) {
        throw new UnsupportedOperationException("LottieAnimator does not support setInterpolator.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void setStartDelay(long r100) {
        throw new UnsupportedOperationException("LottieAnimator does not support setStartDelay.");
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final /* bridge */ /* synthetic */ Animator setDuration(long r100) {
        setDuration(r100);
        throw null;
    }
}
