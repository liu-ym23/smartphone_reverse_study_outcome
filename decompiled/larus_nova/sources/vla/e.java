package vla;

import android.util.SparseArray;
import android.view.View;
import androidx.camera.video.AudioStats;
import com.obric.oui.constraintlayout.motion.widget.MotionLayout;
import com.obric.oui.constraintlayout.widget.ConstraintAttribute;
import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.HashMap;
import tla.p;

/* JADX INFO: loaded from: classes34.dex */
public abstract class e extends p {

    public static class a extends e {
        public a() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setAlpha(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class b extends e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public final String f555718k;

        /* JADX INFO: renamed from: l, reason: collision with root package name */
        public final SparseArray<ConstraintAttribute> f555719l;

        /* JADX INFO: renamed from: m, reason: collision with root package name */
        public final SparseArray<float[]> f555720m;

        /* JADX INFO: renamed from: n, reason: collision with root package name */
        public float[] f555721n;

        @Override // tla.p
        public final void c(int r110) {
            int r100 = this.f555719l.size();
            int r101 = this.f555719l.valueAt(0).c();
            double[] r102 = new double[r100];
            int r103 = r101 + 2;
            this.f555721n = new float[r103];
            this.f546746g = new float[r101];
            double[][] r104 = (double[][]) Array.newInstance(Double.TYPE, new int[]{r100, r103});
            int r105 = 0;
        L3:
            if (r105 >= r100) goto L9;
            int r106 = this.f555719l.keyAt(r105);
            ConstraintAttribute r107 = this.f555719l.valueAt(r105);
            float[] r108 = this.f555720m.valueAt(r105);
            r102[r105] = ((double) r106) * 0.01d;
            r107.b(this.f555721n);
            int r109 = 0;
        L5:
            float[] r111 = this.f555721n;
            if (r109 >= r111.length) goto L8;
            r104[r105][r109] = r111[r109];
            r109 = r109 + 1;
            goto L5
        L8:
            double[] r112 = r104[r105];
            r112[r101] = r108[0];
            r112[r101 + 1] = r108[1];
            r105 = r105 + 1;
            goto L3
        L9:
            this.f546740a = tla.b.a(r110, r102, r104);
        }

        public b(String r100, SparseArray<ConstraintAttribute> r101) {
            this.f555720m = new SparseArray();
            this.f555718k = r100.split(",")[1];
            this.f555719l = r101;
        }

        @Override // vla.e
        public final boolean e(View r110, float r111, long r210, tla.d r211) {
            this.f546740a.d(r111, this.f555721n);
            float[] r100 = this.f555721n;
            float r101 = r100[r100.length - 2];
            float r102 = r100[r100.length - 1];
            long r103 = r210 - this.f546748i;
            if (Float.isNaN(this.f546749j) == false) goto L7;
            float r104 = r211.a(r110, this.f555718k);
            this.f546749j = r104;
            if (Float.isNaN(r104) == false) goto L7;
            this.f546749j = 0.0f;
        L7:
            float r105 = (float) ((((double) this.f546749j) + ((r103 * 1.0E-9d) * ((double) r101))) % 1.0d);
            this.f546749j = r105;
            this.f546748i = r210;
            float r106 = a(r105);
            this.f546747h = false;
            int r107 = 0;
        L8:
            float[] r108 = this.f546746g;
            if (r107 >= r108.length) goto L15;
            boolean r109 = this.f546747h;
            float r112 = this.f555721n[r107];
            if (r112 == AudioStats.AUDIO_AMPLITUDE_NONE) goto L13;
            boolean r113 = true;
        L14:
            this.f546747h = r109 | r113;
            r108[r107] = (r112 * r106) + r102;
            r107 = r107 + 1;
            goto L8
        L13:
            r113 = false;
            goto L14
        L15:
            vla.a.b(this.f555719l.valueAt(0), r110, this.f546746g);
            if (r101 == 0.0f) goto L19;
            this.f546747h = true;
        L19:
            return this.f546747h;
        }

        @Override // tla.p
        public final void b(int r100, float r101, float r102, int r103, float r104) {
            throw new RuntimeException("Wrong call for custom attribute");
        }
    }

    public static class c extends e {
        public c() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setElevation(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class d extends e {
        public d() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r103) {
            return this.f546747h;
        }
    }

    /* JADX INFO: renamed from: vla.e$e, reason: collision with other inner class name */
    public static class C8020e extends e {

        /* JADX INFO: renamed from: k, reason: collision with root package name */
        public boolean f555722k;

        public C8020e() {
            this.f555722k = false;
        }

        @Override // vla.e
        public final boolean e(View r110, float r111, long r112, tla.d r113) {
            if ((r110 instanceof MotionLayout) == false) goto L6;
            ((MotionLayout) r110).setProgress(d(r111, r112, r110, r113));
        L15:
            return this.f546747h;
        L6:
            if (this.f555722k == false) goto L19;
            return false;
        L19:
            Method r100 = r110.getClass().getMethod("setProgress", new Class[]{Float.TYPE});     // Catch: NoSuchMethodException -> L11
        L12:
            if (r100 == null) goto L15;
            r100.invoke(r110, new Object[]{Float.valueOf(d(r111, r112, r110, r113))});     // Catch: Throwable -> L16
        L11:
            this.f555722k = true;
            r100 = null;
            goto L12
        }
    }

    public static class f extends e {
        public f() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setRotation(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class g extends e {
        public g() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setRotationX(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class h extends e {
        public h() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setRotationY(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class i extends e {
        public i() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setScaleX(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class j extends e {
        public j() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setScaleY(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class k extends e {
        public k() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setTranslationX(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class l extends e {
        public l() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setTranslationY(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public static class m extends e {
        public m() {
        }

        @Override // vla.e
        public final boolean e(View r100, float r101, long r102, tla.d r110) {
            r100.setTranslationZ(d(r101, r102, r100, r110));
            return this.f546747h;
        }
    }

    public abstract boolean e(View r100, float r101, long r102, tla.d r103);

    public e() {
    }

    public final float d(float r110, long r210, View r211, tla.d r212) {
        this.f546740a.d(r110, this.f546746g);
        float[] r100 = this.f546746g;
        boolean r101 = true;
        float r102 = r100[1];
        if (r102 != 0.0f) goto L7;
        this.f546747h = false;
        return r100[2];
    L7:
        if (Float.isNaN(this.f546749j) == false) goto L11;
        float r103 = r212.a(r211, this.f546745f);
        this.f546749j = r103;
        if (Float.isNaN(r103) == false) goto L11;
        this.f546749j = 0.0f;
    L11:
        float r104 = (float) ((((double) this.f546749j) + (((r210 - this.f546748i) * 1.0E-9d) * ((double) r102))) % 1.0d);
        this.f546749j = r104;
        String r111 = this.f546745f;
        if (r212.f546676a.containsKey(r211) == true) goto L14;
        HashMap<String, float[]> r112 = new HashMap();
        r112.put(r111, new float[]{r104});
        r212.f546676a.put(r211, r112);
    L27:
        this.f546748i = r210;
        float r105 = this.f546746g[0];
        float r106 = (a(this.f546749j) * r105) + this.f546746g[2];
        if (r105 != 0.0f) goto L32;
        if (r102 != 0.0f) goto L32;
        r101 = false;
    L32:
        this.f546747h = r101;
        return r106;
    L14:
        HashMap<String, float[]> r113 = r212.f546676a.get(r211);
        if (r113 != null) goto L18;
        r113 = new HashMap();
    L18:
        if (r113.containsKey(r111) == true) goto L20;
        r113.put(r111, new float[]{r104});
        r212.f546676a.put(r211, r113);
        goto L27
    L20:
        float[] r107 = r113.get(r111);
        if (r107 != null) goto L24;
        r107 = new float[0];
    L24:
        if (r107.length > 0) goto L26;
        r107 = Arrays.copyOf(r107, 1);
    L26:
        r107[0] = r104;
        r113.put(r111, r107);
        goto L27
    }
}
