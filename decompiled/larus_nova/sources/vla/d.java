package vla;

import android.util.SparseArray;
import android.view.View;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.Method;

/* JADX INFO: loaded from: classes34.dex */
public abstract class d extends tla.k {

    public static class a extends d {
        public a() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setAlpha(a(r101));
        }
    }

    public static class b extends d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final SparseArray<ConstraintAttribute> f555715f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public float[] f555716g;

        @Override // tla.k
        public final void c(int r110) {
            int r100 = this.f555715f.size();
            int r101 = this.f555715f.valueAt(0).c();
            double[] r102 = new double[r100];
            this.f555716g = new float[r101];
            double[][] r103 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r100, r101});
            int r104 = 0;
        L3:
            if (r104 >= r100) goto L9;
            int r105 = this.f555715f.keyAt(r104);
            ConstraintAttribute r106 = this.f555715f.valueAt(r104);
            r102[r104] = ((double) r105) * 0.01d;
            r106.b(this.f555716g);
            int r107 = 0;
        L5:
            float[] r108 = this.f555716g;
            if (r107 >= r108.length) goto L8;
            r103[r104][r107] = r108[r107];
            r107 = r107 + 1;
            goto L5
        L8:
            r104 = r104 + 1;
            goto L3
        L9:
            this.f546711a = tla.b.a(r110, r102, r103);
        }

        public b(String r100, SparseArray<ConstraintAttribute> r101) {
            String r102 = r100.split(",")[1];
            this.f555715f = r101;
        }

        @Override // tla.k
        public final void b(int r100, float r101) {
            throw new RuntimeException("call of custom attribute setPoint");
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            this.f546711a.d(r101, this.f555716g);
            vla.a.b(this.f555715f.valueAt(0), r100, this.f555716g);
        }
    }

    public static class c extends d {
        public c() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setElevation(a(r101));
        }
    }

    /* JADX INFO: renamed from: vla.d$d, reason: collision with other inner class name */
    public static class C8019d extends d {
        @Override // vla.d
        public final void d(View r100, float r101) {
        }

        public C8019d() {
        }
    }

    public static class e extends d {
        public e() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setPivotX(a(r101));
        }
    }

    public static class f extends d {
        public f() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setPivotY(a(r101));
        }
    }

    public static class g extends d {

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public boolean f555717f;

        public g() {
            this.f555717f = false;
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            if ((r100 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r100).setProgress(a(r101));
            return;
        L6:
            if (this.f555717f == false) goto L16;
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
            this.f555717f = true;
            r102 = null;
            goto L12
        }
    }

    public static class h extends d {
        public h() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setRotation(a(r101));
        }
    }

    public static class i extends d {
        public i() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setRotationX(a(r101));
        }
    }

    public static class j extends d {
        public j() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setRotationY(a(r101));
        }
    }

    public static class k extends d {
        public k() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setScaleX(a(r101));
        }
    }

    public static class l extends d {
        public l() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setScaleY(a(r101));
        }
    }

    public static class m extends d {
        public m() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setTranslationX(a(r101));
        }
    }

    public static class n extends d {
        public n() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setTranslationY(a(r101));
        }
    }

    public static class o extends d {
        public o() {
        }

        @Override // vla.d
        public final void d(View r100, float r101) {
            r100.setTranslationZ(a(r101));
        }
    }

    public abstract void d(View r100, float r101);

    public d() {
    }
}
