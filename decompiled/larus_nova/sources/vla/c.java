package vla;

import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes34.dex */
public abstract class c extends tla.f {

    public static class a extends c {
        public a() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setAlpha(a(r101));
        }
    }

    public static class b extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final float[] f555712g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public ConstraintAttribute f555713h;

        public b() {
            this.f555712g = new float[1];
        }

        @Override // tla.f
        public final void c(ConstraintAttribute r100) {
            this.f555713h = r100;
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            this.f555712g[0] = a(r101);
            vla.a.b(this.f555713h, r100, this.f555712g);
        }
    }

    /* JADX INFO: renamed from: vla.c$c, reason: collision with other inner class name */
    public static class C8018c extends c {
        public C8018c() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setElevation(a(r101));
        }
    }

    public static class d extends c {
        @Override // vla.c
        public final void e(View r100, float r101) {
        }

        public d() {
        }
    }

    public static class e extends c {

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public boolean f555714g;

        public e() {
            this.f555714g = false;
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            if ((r100 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r100).setProgress(a(r101));
            return;
        L6:
            if (this.f555714g == false) goto L16;
            return;
        L16:
            Method r102 = r100.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r102 == null) goto L21;
            r102.invoke(r100, new Object[]{Float.valueOf(a(r101))});     // Catch: Throwable -> L15
            return;
        L22:
            return;
        L21:
            return;
        L11:
            this.f555714g = true;
            r102 = null;
            goto L12
        }
    }

    public static class f extends c {
        public f() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setRotation(a(r101));
        }
    }

    public static class g extends c {
        public g() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setRotationX(a(r101));
        }
    }

    public static class h extends c {
        public h() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setRotationY(a(r101));
        }
    }

    public static class i extends c {
        public i() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setScaleX(a(r101));
        }
    }

    public static class j extends c {
        public j() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setScaleY(a(r101));
        }
    }

    public static class k extends c {
        public k() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setTranslationX(a(r101));
        }
    }

    public static class l extends c {
        public l() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setTranslationY(a(r101));
        }
    }

    public static class m extends c {
        public m() {
        }

        @Override // vla.c
        public final void e(View r100, float r101) {
            r100.setTranslationZ(a(r101));
        }
    }

    public abstract void e(View r100, float r101);

    public c() {
    }
}
