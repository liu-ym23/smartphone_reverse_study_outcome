package u0;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.view.Choreographer;
import com.airbnb.lottie.LottieComposition;
import com.airbnb.lottie.i;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* JADX INFO: loaded from: classes3.dex */
public final class c extends u0.a implements Choreographer.FrameCallback {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public float f548100c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public boolean f548101d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public long f548102e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public float f548103f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public int f548104g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public float f548105h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public float f548106i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public LottieComposition f548107j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public boolean f548108k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public r0.b f548109l;

    public static class a {
        public a() {
        }
    }

    public final void b() {
        g(true);
        a(f());
    }

    static {
        new a();
    }

    public final float c() {
        LottieComposition r100 = this.f548107j;
        if (r100 != null) goto L7;
        return 0.0f;
    L7:
        return (this.f548103f - r100.getStartFrame()) / (this.f548107j.getEndFrame() - this.f548107j.getStartFrame());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final void cancel() {
        Iterator r100 = ((CopyOnWriteArraySet) this.f548099b).iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((Animator.AnimatorListener) r100.next()).onAnimationCancel(this);
        goto L4
    L6:
        g(true);
    }

    public final float d() {
        LottieComposition r100 = this.f548107j;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        float r101 = this.f548106i;
        if (r101 == 2.1474836E9f) goto L9;
        return r101;
    L9:
        return r100.getEndFrame();
    }

    public final float e() {
        LottieComposition r100 = this.f548107j;
        if (r100 != null) goto L6;
        return 0.0f;
    L6:
        float r101 = this.f548105h;
        if (r101 == (-2.1474836E9f)) goto L9;
        return r101;
    L9:
        return r100.getStartFrame();
    }

    public final boolean f() {
        if (this.f548100c >= 0.0f) goto L5;
        return true;
    L5:
        return false;
    }

    @Override // android.animation.ValueAnimator
    public final float getAnimatedFraction() {
        if (this.f548107j != null) goto L7;
        return 0.0f;
    L7:
        if (f() == false) goto L11;
        float r100 = d() - this.f548103f;
        float r101 = d();
        float r102 = e();
    L10:
        return r100 / (r101 - r102);
    L11:
        r100 = this.f548103f - e();
        r101 = d();
        r102 = e();
        goto L10
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final long getDuration() {
        LottieComposition r100 = this.f548107j;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return (long) r100.getDuration();
    }

    public c() {
        this.f548100c = 1.0f;
        this.f548101d = false;
        this.f548102e = 0;
        this.f548103f = 0.0f;
        this.f548104g = 0;
        this.f548105h = -2.1474836E9f;
        this.f548106i = 2.1474836E9f;
        this.f548108k = false;
    }

    @Override // android.animation.ValueAnimator
    public final Object getAnimatedValue() {
        return Float.valueOf(c());
    }

    @Override // android.animation.ValueAnimator, android.animation.Animator
    public final boolean isRunning() {
        return this.f548108k;
    }

    @Override // android.view.Choreographer.FrameCallback
    public final void doFrame(long r110) {
        if (this.f548108k == false) goto L5;
        g(false);
        Choreographer.getInstance().postFrameCallback(this);
    L5:
        LottieComposition r100 = this.f548107j;
        if (r100 != null) goto L8;
        return;
    L8:
        if (this.f548108k == true) goto L11;
        return;
    L11:
        if (r0.c.a.f535397a == false) goto L37;
        long r101 = this.f548102e;
        if (r101 != 0) goto L15;
        long r102 = 0;
    L17:
        if (r0.c.a.f535398b == true) goto L19;
    L38:
        LottieComposition r103 = this.f548107j;
        if (r103 != null) goto L41;
        float r104 = Float.MAX_VALUE;
    L42:
        float r105 = r102 / r104;
        float r106 = this.f548103f;
        if (f() == false) goto L45;
        r105 = -r105;
    L45:
        float r107 = r106 + r105;
        this.f548103f = r107;
        float r108 = e();
        float r109 = d();
        e.a r111 = e.f548111a;
        if (r107 >= r108) goto L48;
    L50:
        boolean r112 = false;
    L51:
        boolean r113 = !r112;
        this.f548103f = e.b(this.f548103f, e(), d());
        this.f548102e = r110;
        Iterator r114 = ((CopyOnWriteArraySet) this.f548098a).iterator();
    L53:
        if (r114.hasNext() == false) goto L56;
        ((ValueAnimator.AnimatorUpdateListener) r114.next()).onAnimationUpdate(this);
        goto L53
    L56:
        if (r113 == false) goto L84;
        if (getRepeatCount() != (-1)) goto L60;
    L70:
        Iterator r115 = ((CopyOnWriteArraySet) this.f548099b).iterator();
    L72:
        if (r115.hasNext() == false) goto L74;
        ((Animator.AnimatorListener) r115.next()).onAnimationRepeat(this);
        goto L72
    L74:
        this.f548104g++;
        if (getRepeatMode() != 2) goto L78;
        this.f548101d = !this.f548101d;
        this.f548100c = -this.f548100c;
    L82:
        this.f548102e = r110;
        goto L84
    L78:
        if (f() == false) goto L80;
        float r116 = d();
    L81:
        this.f548103f = r116;
        goto L82
    L80:
        r116 = e();
        goto L81
    L60:
        if (this.f548104g < getRepeatCount()) goto L70;
        if (r0.c.a.f535397a == true) goto L64;
        this.f548103f = d();
    L69:
        g(true);
        a(f());
        goto L84
    L64:
        if (this.f548100c >= 0.0f) goto L66;
        float r117 = e();
    L67:
        this.f548103f = r117;
        goto L69
    L66:
        r117 = d();
    L84:
        if (this.f548107j == null) goto L97;
        float r118 = this.f548103f;
        if (r118 >= this.f548105h) goto L89;
    L90:
        i r119 = i.a();
        new IllegalStateException(String.format("Frame must be [%f,%f]. It is %f", new Object[]{Float.valueOf(this.f548105h), Float.valueOf(this.f548106i), Float.valueOf(this.f548103f)}));
        String r120 = this.f548107j.errorReportResId;
        r119.getClass();
        return;
    L89:
        if (r118 > this.f548106i) goto L90;
        return;
    L97:
        return;
    L48:
        if (r107 > r109) goto L50;
        r112 = true;
        goto L51
    L41:
        r104 = (1.0E9f / r103.getFrameRate()) / Math.abs(this.f548100c);
        goto L42
    L19:
        if (this.f548109l != null) goto L21;
        this.f548109l = new r0.b();
    L21:
        r0.b r121 = this.f548109l;
        if (r121 == null) goto L38;
        float r122 = r100.getFrameRate();
        if (r121.f535393a == r122) goto L29;
        r121.f535393a = r122;
        if (r122 < 24.0f) goto L28;
        r121.f535395c = 16000000;
        goto L29
    L28:
        r121.f535395c = 32000000;
    L29:
        long r123 = r121.f535394b;
        if (r123 > 0) goto L32;
    L34:
        r121.f535394b = r110;
        boolean r124 = false;
    L35:
        if (r124 == false) goto L38;
        return;
    L32:
        if ((r110 - r123) >= r121.f535395c) goto L34;
        r124 = true;
        goto L35
    L15:
        r102 = r110 - r101;
        goto L17
    L37:
        r110 = System.nanoTime();
        r102 = r110 - this.f548102e;
        goto L38
    }

    public final void g(boolean r100) {
        Choreographer.getInstance().removeFrameCallback(this);
        if (r100 == false) goto L6;
        this.f548108k = false;
        return;
    }

    public final void h(int r100) {
        float r101 = r100;
        if (this.f548103f != r101) goto L5;
        return;
    L5:
        this.f548103f = e.b(r101, e(), d());
        if (r0.c.a.f535397a == false) goto L8;
        this.f548102e = 0;
    L9:
        Iterator r102 = ((CopyOnWriteArraySet) this.f548098a).iterator();
    L11:
        if (r102.hasNext() == false) goto L13;
        ((ValueAnimator.AnimatorUpdateListener) r102.next()).onAnimationUpdate(this);
        goto L11
    L13:
        return;
    L8:
        this.f548102e = System.nanoTime();
        goto L9
    }

    @Override // android.animation.ValueAnimator
    public final void setRepeatMode(int r100) {
        super.setRepeatMode(r100);
        if (r100 != 2) goto L5;
        return;
    L5:
        if (this.f548101d == false) goto L9;
        this.f548101d = false;
        this.f548100c = -this.f548100c;
        return;
    }

    public final void i(int r100, int r101) {
        LottieComposition r102 = this.f548107j;
        if (r102 != null) goto L5;
        float r103 = -3.4028235E38f;
    L6:
        LottieComposition r104 = this.f548107j;
        if (r104 != null) goto L9;
        float r105 = Float.MAX_VALUE;
    L10:
        float r106 = r100;
        this.f548105h = e.b(r106, r103, r105);
        float r107 = r101;
        this.f548106i = e.b(r107, r103, r105);
        h((int) e.b(this.f548103f, r106, r107));
        return;
    L9:
        r105 = r104.getEndFrame();
        goto L10
    L5:
        r103 = r102.getStartFrame();
        goto L6
    }
}
