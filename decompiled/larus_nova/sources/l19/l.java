package l19;

import android.content.Context;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.graphics.RectF;
import android.view.View;
import com.larus.apm.impl.protector.RunnableProtector;
import com.larus.common_ui.photoviewer.ZoomableControllerImp;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.Iterator;
import java.util.LinkedHashSet;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public class l extends ZoomableControllerImp implements i {
    public final LinkedHashSet<f> D;
    public int E;
    public final Matrix F;
    public boolean G;
    public final Matrix H;
    public final j19.b I;

    /* JADX INFO: renamed from: J, reason: collision with root package name */
    public final k f507036J;
    public long K;
    public boolean L;
    public boolean M;
    public final Rect N;
    public boolean O;
    public j19.e P;
    public int Q;
    public int R;

    public static final class a implements Runnable {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ l f507037a;

        @Override // java.lang.Runnable
        public final void run() {
            l r100 = this.f507037a;     // Catch: Throwable -> L7
            Iterator<T> r101 = r100.D.iterator();     // Catch: Throwable -> L7
        L4:
            if (r101.hasNext() == false) goto L16;
            ((f) r101.next()).onTransitionEnd(r100.E);     // Catch: Throwable -> L7
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

        public a(l r100) {
            this.f507037a = r100;
        }
    }

    @Override // l19.i
    public final View b() {
        return null;
    }

    @Override // l19.a
    public final float getMaxDragTransitionFactor() {
        return this.I.f496872d;
    }

    public boolean A() {
        return this.O;
    }

    @Override // l19.a
    public final int getDismissAnimationType() {
        return this.R;
    }

    @Override // l19.a
    public final Rect getEnterTransitionStartRect() {
        return this.N;
    }

    @Override // l19.a
    public final int getPos() {
        return this.Q;
    }

    @Override // l19.a
    public final j19.e getRestoreTransitionProvider() {
        return this.P;
    }

    @Override // l19.a
    public final long getTransitionAnimationDuration() {
        return this.K;
    }

    @Override // l19.a
    public final boolean isDragTransitionEnabled() {
        return this.L;
    }

    public boolean isSingleTagDismissEnabled() {
        return this.M;
    }

    public void B(boolean r100) {
        this.O = r100;
    }

    @Override // l19.i
    public final void c(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.D.add(r100);
    }

    @Override // l19.i
    public final void e(f r100) {
        Intrinsics.checkNotNullParameter(r100, "listener");
        this.D.remove(r100);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp, k19.b
    public final /* bridge */ /* synthetic */ void onGestureBegin(k19.e r100) {
        q(r100);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp, k19.b
    public final /* bridge */ /* synthetic */ void onGestureEnd(k19.e r100) {
        r(r100);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp, k19.b
    public final /* bridge */ /* synthetic */ void onGestureUpdate(k19.e r100) {
        s(r100);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void q(k19.e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        super.q(r100);
        if (this.C == false) goto L5;
        return;
    L5:
        this.E = -1;
        if ((this.f327676i.top - this.f327678k.top) <= 0.001f) goto L8;
        boolean r101 = true;
    L9:
        this.G = !r101;
        return;
    L8:
        r101 = false;
        goto L9
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void r(k19.e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        if (this.C == false) goto L6;
        return;
    L6:
        if (this.E != 3) goto L28;
        Iterator<T> r101 = this.D.iterator();
    L9:
        if (r101.hasNext() == false) goto L11;
        ((f) r101.next()).onTransitionEnd(this.E);
        goto L9
    L11:
        j19.b r102 = this.I;
        if ((r102.f496870b.f501407f / r102.f496871c) <= r102.f496872d) goto L14;
        boolean r103 = true;
    L15:
        if (r103 == true) goto L17;
        this.E = 1;
        this.C = true;
        this.F.set(this.H);
        Iterator<T> r104 = this.D.iterator();
    L25:
        if (r104.hasNext() == false) goto L27;
        ((f) r104.next()).onTransitionBegin(this.E);
        goto L25
    L27:
        u(this.F, this.K, new m(this), this.f507036J);
        return;
    L17:
        if (A() == false) goto L19;
        z(false);
        return;
    L19:
        this.E = 2;
        this.C = true;
        Iterator<T> r105 = this.D.iterator();
    L21:
        if (r105.hasNext() == false) goto L35;
        ((f) r105.next()).onTransitionEnd(this.E);
        goto L21
    L35:
        return;
    L14:
        r103 = false;
        goto L15
    L28:
        super.r(r100);
    }

    @Override // com.larus.common_ui.photoviewer.ZoomableControllerImp
    public final void s(k19.e r100) {
        Intrinsics.checkNotNullParameter(r100, "detector");
        if (this.C == false) goto L5;
        return;
    L5:
        if (l() == false) goto L8;
        return;
    L8:
        if (this.L == false) goto L20;
        if (r100.f501413l != 4) goto L20;
        if (this.G == false) goto L20;
        if (this.E != (-1)) goto L20;
        this.E = 3;
        this.H.set(this.f327679l);
        Iterator<T> r101 = this.D.iterator();
    L17:
        if (r101.hasNext() == false) goto L20;
        ((f) r101.next()).onTransitionBegin(this.E);
    L20:
        if (this.E != 3) goto L29;
        Matrix r102 = this.f327679l;
        RectF r103 = this.f327677j;
        r102.set(this.H);
        float r104 = this.f327668a.f501407f;
        float r105 = this.I.a();
        r102.postScale(r105, r105, r103.centerX(), r103.centerY());
        Iterator<T> r106 = this.D.iterator();
    L23:
        if (r106.hasNext() == false) goto L26;
        f r107 = (f) r106.next();
        int r108 = this.E;
        j19.b r109 = this.I;
        r107.onTransitionChanged(r108, r109.f496870b.f501407f / r109.f496871c);
        goto L23
    L26:
        if (this.f327672e == false) goto L28;
        r102.postTranslate(this.f327668a.f501406e, r104);
    L28:
        d();
        return;
    L29:
        super.s(r100);
    }

    @Override // l19.a
    public final void setDismissAnimationType(int r100) {
        this.R = r100;
    }

    @Override // l19.a
    public final void setDragTransitionEnabled(boolean r100) {
        this.L = r100;
    }

    @Override // l19.a
    public final void setEnterTransitionStartRect(Rect r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
        this.N.set(r100);
    }

    @Override // l19.a
    public final void setMaxDragTransitionFactor(float r100) {
        this.I.f496872d = r100;
    }

    @Override // l19.a
    public final void setPos(int r100) {
        this.Q = r100;
    }

    @Override // l19.a
    public final void setRestoreTransitionProvider(j19.e r100) {
        this.P = r100;
    }

    public void setSingleTagDismissEnabled(boolean r100) {
        this.M = r100;
    }

    @Override // l19.a
    public final void setTransitionAnimationDuration(long r100) {
        this.K = r100;
    }

    public final void z(boolean r100) {
        this.E = 2;
        boolean r101 = true;
        this.C = true;
        this.F.set(this.f327679l);
        j19.e r102 = this.P;
        if (r102 == null) goto L7;
        View r103 = r102.d(this.Q);
        if (r103 == null) goto L7;
        Rect r104 = h.a(r103);
    L8:
        if (r104 != null) goto L10;
    L12:
        r101 = false;
    L13:
        if (r101 == false) goto L15;
        Intrinsics.checkNotNull(r104);
        float r105 = r104.width() / this.f327678k.width();
        this.F.postScale(r105, r105, this.f327678k.centerX(), this.f327678k.centerY());
        this.F.postTranslate(r104.centerX() - this.f327678k.centerX(), r104.centerY() - this.f327678k.centerY());
    L23:
        Iterator<T> r106 = this.D.iterator();
    L25:
        if (r106.hasNext() == false) goto L27;
        ((f) r106.next()).onTransitionBegin(this.E);
        goto L25
    L27:
        u(this.F, this.K, new a(this), this.f507036J);
        return;
    L15:
        if (r100 == false) goto L20;
        this.F.postTranslate(this.f327677j.centerX() - this.f327678k.centerX(), this.f327677j.centerY() - this.f327678k.centerY());
        if (this.R != 0) goto L23;
        this.F.postScale(0.1f, 0.1f, this.f327677j.centerX(), this.f327677j.centerY());
        goto L23
    L20:
        if (this.R != 0) goto L23;
        this.F.postScale(0.1f, 0.1f, this.f327678k.centerX(), this.f327678k.centerY());
        goto L23
    L10:
        if (r104.isEmpty() == true) goto L12;
    L7:
        r104 = null;
        goto L8
    }

    /* JADX WARN: Type inference failed for: r4v1, types: [l19.k] */
    public l(k19.e r100, Context r101) {
        Intrinsics.checkNotNullParameter(r100, "transformGestureDetector");
        Intrinsics.checkNotNullParameter(r101, PerfLog.PARAM_KEY_CONTEXT_ID);
        super(r100, r101);
        this.D = new LinkedHashSet();
        this.E = -1;
        this.F = new Matrix();
        this.G = true;
        this.H = new Matrix();
        this.I = new j19.b(r101, r100);
        this.f507036J = new k(this);
        this.K = 300;
        this.L = true;
        this.M = true;
        this.N = new Rect();
        this.O = true;
        this.Q = -1;
    }
}
