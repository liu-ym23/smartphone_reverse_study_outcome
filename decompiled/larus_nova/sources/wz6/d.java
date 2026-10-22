package wz6;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.Choreographer;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes21.dex */
public final class d extends a implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f561944c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f561945d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f561946e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f561947f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f561948g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f561949h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f561950i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public com.bytedance.lottie.d f561951j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f561952k;

    public final void b() {
        f(true);
        a(e());
    }

    public final float c() {
        com.bytedance.lottie.d r100 = this.f561951j;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        float r101 = this.f561950i;
        if (r101 == 2.1474836E9f) goto L9;
        return r101;
    L9:
        return r100.f264434k;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator r100 = ((CopyOnWriteArraySet) this.f561943b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Animator.AnimatorListener) r100.next()).onAnimationCancel(this);
        goto L4
    L6:
        f(true);
    }

    public final float d() {
        com.bytedance.lottie.d r100 = this.f561951j;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        float r101 = this.f561949h;
        if (r101 == (-2.1474836E9f)) goto L9;
        return r101;
    L9:
        return r100.f264433j;
    }

    public final boolean e() {
        if (this.f561944c >= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        if (this.f561951j != null) goto L7;
        return 0.0f;
    L7:
        if (e() == false) goto L11;
        float r100 = c() - this.f561947f;
        float r101 = c();
        float r102 = d();
    L10:
        return r100 / (r101 - r102);
    L11:
        r100 = this.f561947f - d();
        r101 = c();
        r102 = d();
        goto L10
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        com.bytedance.lottie.d r100 = this.f561951j;
        if (r100 != null) goto L5;
        float r101 = 0.0f;
    L7:
        return Float.valueOf(r101);
    L5:
        float r102 = this.f561947f;
        float r103 = r100.f264433j;
        r101 = (r102 - r103) / (r100.f264434k - r103);
        goto L7
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        com.bytedance.lottie.d r100 = this.f561951j;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return (long) r100.b();
    }

    public d() {
        this.f561944c = 1.0f;
        this.f561945d = false;
        this.f561946e = 0;
        this.f561947f = 0.0f;
        this.f561948g = 0;
        this.f561949h = -2.1474836E9f;
        this.f561950i = 2.1474836E9f;
        this.f561952k = false;
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.f561952k;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r100) {
        if (this.f561952k == false) goto L6;
        f(false);
        Choreographer.getInstance().postFrameCallback(this);
    L6:
        if (this.f561951j != null) goto L8;
        return;
    L8:
        if (this.f561952k == false) goto L60;
        long r101 = System.nanoTime();
        long r102 = r101 - this.f561946e;
        com.bytedance.lottie.d r103 = this.f561951j;
        if (r103 != null) goto L13;
        float r104 = Float.MAX_VALUE;
    L14:
        float r105 = r102 / r104;
        float r106 = this.f561947f;
        if (e() == false) goto L17;
        r105 = -r105;
    L17:
        float r107 = r106 + r105;
        this.f561947f = r107;
        float r108 = d();
        float r109 = c();
        if (r107 >= r108) goto L20;
    L22:
        boolean r110 = false;
    L23:
        boolean r111 = !r110;
        this.f561947f = f.b(this.f561947f, d(), c());
        this.f561946e = r101;
        Iterator r112 = ((CopyOnWriteArraySet) this.f561942a).iterator();
    L25:
        if (r112.hasNext() == false) goto L28;
        ((ValueAnimator.AnimatorUpdateListener) r112.next()).onAnimationUpdate(this);
        goto L25
    L28:
        if (r111 == false) goto L48;
        if (getRepeatCount() != (-1)) goto L32;
    L34:
        Iterator r113 = ((CopyOnWriteArraySet) this.f561943b).iterator();
    L36:
        if (r113.hasNext() == false) goto L38;
        ((Animator.AnimatorListener) r113.next()).onAnimationRepeat(this);
        goto L36
    L38:
        this.f561948g++;
        if (getRepeatMode() != 2) goto L42;
        this.f561945d = !this.f561945d;
        this.f561944c = -this.f561944c;
    L46:
        this.f561946e = r101;
        goto L48
    L42:
        if (e() == false) goto L44;
        float r114 = c();
    L45:
        this.f561947f = r114;
        goto L46
    L44:
        r114 = d();
        goto L45
    L32:
        if (this.f561948g < getRepeatCount()) goto L34;
        this.f561947f = c();
        f(true);
        a(e());
    L48:
        if (this.f561951j == null) goto L61;
        float r115 = this.f561947f;
        float r116 = this.f561949h;
        if (r115 >= r116) goto L53;
    L54:
        String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(r116), Float.valueOf(this.f561950i), Float.valueOf(this.f561947f)});
        return;
    L53:
        if (r115 > this.f561950i) goto L54;
        return;
    L61:
        return;
    L20:
        if (r107 > r109) goto L22;
        r110 = true;
        goto L23
    L13:
        r104 = (1.0E9f / r103.f264435l) / Math.abs(this.f561944c);
        goto L14
    }

    public final void f(boolean r100) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (r100 == false) goto L6;
        this.f561952k = false;
        return;
    }

    public final void g(int r100) {
        float r101 = r100;
        if (this.f561947f != r101) goto L5;
        return;
    L5:
        this.f561947f = f.b(r101, d(), c());
        this.f561946e = System.nanoTime();
        Iterator r102 = ((CopyOnWriteArraySet) this.f561942a).iterator();
    L7:
        if (r102.hasNext() == false) goto L9;
        ((ValueAnimator.AnimatorUpdateListener) r102.next()).onAnimationUpdate(this);
        goto L7
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int r100) {
        super.setRepeatMode(r100);
        if (r100 != 2) goto L5;
        return;
    L5:
        if (this.f561945d == false) goto L9;
        this.f561945d = false;
        this.f561944c = -this.f561944c;
        return;
    }

    public final void h(int r100, int r101) {
        com.bytedance.lottie.d r102 = this.f561951j;
        if (r102 != null) goto L5;
        float r103 = -3.4028235E38f;
    L6:
        if (r102 != null) goto L8;
        float r104 = Float.MAX_VALUE;
    L9:
        float r105 = r100;
        this.f561949h = f.b(r105, r103, r104);
        float r106 = r101;
        this.f561950i = f.b(r106, r103, r104);
        g((int) f.b(this.f561947f, r105, r106));
        return;
    L8:
        r104 = r102.f264434k;
        goto L9
    L5:
        r103 = r102.f264433j;
        goto L6
    }
}
