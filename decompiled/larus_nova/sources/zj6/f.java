package zj6;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Matrix;
import android.graphics.RectF;
import com.bytedance.live.photoviewer.ZoomableControllerImp;
import com.larus.apm.impl.protector.RunnableProtector;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class f extends ZoomableControllerImp implements e {
    public final LinkedHashSet<zj6.c> B;
    public boolean C;
    public int D;
    public final Matrix E;
    public boolean F;
    public final Matrix G;
    public final c H;

    public static final class a {
    }

    public static final class b implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f572493a;

        @Override // java.lang.Runnable
        public final void run() {
            Iterator<T> r100 = this.f572493a.B.iterator();     // Catch: Throwable -> L7
        L4:
            if (r100.hasNext() == false) goto L16;
            ((zj6.c) r100.next()).onTransitionEnd(this.f572493a.D);     // Catch: Throwable -> L7
            goto L4
        L16:
            return;
        L7:
            th = move-exception;
            if (RunnableProtector.intercept(th) == false) goto L11;
            return;
        L11:
            throw th;
        }

        public b(f r100) {
            this.f572493a = r100;
        }
    }

    public static final class c implements ValueAnimator.AnimatorUpdateListener {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ f f572494a;

        public c(f r100) {
            this.f572494a = r100;
        }

        @Override // android.animation.ValueAnimator.AnimatorUpdateListener
        public final void onAnimationUpdate(ValueAnimator r100) {
            f r101 = this.f572494a;
            float r102 = r101.b(r101.G);
            f r103 = this.f572494a;
            float r104 = r103.b(r103.f255625r) / r102;
            Iterator<T> r105 = this.f572494a.B.iterator();
        L4:
            if (r105.hasNext() == false) goto L6;
            ((zj6.c) r105.next()).onTransitionChanged(this.f572494a.D, r104);
            goto L4
        }
    }

    static {
    }

    @Override // com.bytedance.live.photoviewer.ZoomableControllerImp
    public final void m() {
        if (this.A == false) goto L6;
        return;
    L6:
        if (this.D != 3) goto L22;
        float r100 = s();
        Iterator<T> r101 = this.B.iterator();
    L9:
        if (r101.hasNext() == false) goto L12;
        ((zj6.c) r101.next()).onTransitionEnd(this.D);
        goto L9
    L12:
        if (r100 >= 0.8f) goto L14;
        r(false);
        return;
    L14:
        this.D = 1;
        this.A = true;
        this.E.set(this.G);
        Iterator<T> r102 = this.B.iterator();
    L16:
        if (r102.hasNext() == false) goto L18;
        ((zj6.c) r102.next()).onTransitionBegin(this.D);
        goto L16
    L18:
        p(this.E, this.f255630w, new g(this), this.H);
        return;
    }

    public final float s() {
        if (this.C == false) goto L8;
        float r100 = this.f550394a.f560036f;
        if (r100 > 0) goto L7;
        return 1.0f;
    L7:
        return 1 - RangesKt.coerceAtMost(r100 / this.f550401h.height(), 0.95f);
    L8:
        return 1.0f;
    }

    @Override // zj6.e
    public final void a(zj6.c r100) {
        this.B.remove(r100);
    }

    @Override // zj6.e
    public final void d(zj6.c r100) {
        this.B.add(r100);
    }

    @Override // com.bytedance.live.photoviewer.ZoomableControllerImp
    public final void l(wj6.e r100) {
        super.l(r100);
        if (this.A == false) goto L5;
        return;
    L5:
        this.D = -1;
        if ((this.f550401h.top - this.f550403j.top) <= 0.001f) goto L8;
        boolean r101 = true;
    L9:
        this.F = !r101;
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.bytedance.live.photoviewer.ZoomableControllerImp
    public final void n(wj6.e r100) {
        if (this.A == false) goto L6;
        return;
    L6:
        if (h() == false) goto L9;
        return;
    L9:
        if (this.C == false) goto L21;
        if (r100.f560042l != 4) goto L21;
        if (this.F == false) goto L21;
        if (this.D != (-1)) goto L21;
        this.D = 3;
        this.G.set(this.f550404k);
        Iterator<T> r101 = this.B.iterator();
    L18:
        if (r101.hasNext() == false) goto L21;
        ((zj6.c) r101.next()).onTransitionBegin(this.D);
    L21:
        if (this.D != 3) goto L30;
        Matrix r102 = this.f550404k;
        wj6.e r103 = this.f550394a;
        RectF r104 = this.f550402i;
        r102.set(this.G);
        float r105 = r103.f560036f;
        float r106 = s();
        r102.postScale(r106, r106, r104.centerX(), r104.centerY());
        Iterator<T> r107 = this.B.iterator();
    L24:
        if (r107.hasNext() == false) goto L27;
        ((zj6.c) r107.next()).onTransitionChanged(this.D, r106);
        goto L24
    L27:
        if (this.f550398e == false) goto L29;
        r102.postTranslate(r103.f560035e, r105);
    L29:
        c();
        return;
    L30:
        super.n(r100);
    }

    @Override // com.bytedance.live.photoviewer.ZoomableControllerImp, wj6.b
    public final /* bridge */ /* synthetic */ void onGestureBegin(wj6.e r100) {
        l(r100);
    }

    @Override // com.bytedance.live.photoviewer.ZoomableControllerImp, wj6.b
    public final /* bridge */ /* synthetic */ void onGestureEnd(wj6.e r100) {
        m();
    }

    @Override // com.bytedance.live.photoviewer.ZoomableControllerImp, wj6.b
    public final /* bridge */ /* synthetic */ void onGestureUpdate(wj6.e r100) {
        n(r100);
    }

    public final void r(boolean r100) {
        this.D = 2;
        this.A = true;
        this.E.set(this.f550404k);
        if (r100 == false) goto L5;
        this.E.postTranslate(this.f550402i.centerX() - this.f550403j.centerX(), this.f550402i.centerY() - this.f550403j.centerY());
        this.E.postScale(0.1f, 0.1f, this.f550402i.centerX(), this.f550402i.centerY());
    L6:
        Iterator<T> r101 = this.B.iterator();
    L8:
        if (r101.hasNext() == false) goto L10;
        ((zj6.c) r101.next()).onTransitionBegin(this.D);
        goto L8
    L10:
        p(this.E, this.f255630w, new b(this), this.H);
        return;
    L5:
        this.E.postScale(0.1f, 0.1f, this.f550403j.centerX(), this.f550403j.centerY());
        goto L6
    }

    public f(wj6.e r100, Context r101) {
        super(r100, r101);
        this.B = new LinkedHashSet();
        this.C = true;
        this.D = -1;
        this.E = new Matrix();
        this.G = new Matrix();
        this.H = new c(this);
    }
}
