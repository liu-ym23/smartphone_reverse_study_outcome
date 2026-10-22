package u7a;

import android.graphics.Matrix;
import android.graphics.Rect;
import com.bytedance.android.ecom.arch.slice.render.SlcScaleType;

/* JADX INFO: loaded from: classes32.dex */
public final class m {

    public static abstract class a implements b {
        public a() {
        }

        public abstract void b(Matrix r100, float r101, float r102, float r103, float r104, float r105, float r106);

        @Override // u7a.m.b
        public final Matrix a(Matrix r110, Rect r111, int r112, int r113) {
            b(r110, r111.width(), r111.height(), r112, r113, r111.left, r111.top);
            return r110;
        }
    }

    public interface b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f549123a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f549124b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f549125c = null;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final d f549126d = null;

        Matrix a(Matrix r100, Rect r101, int r102, int r103);

        static {
            f549123a = f.f549130e;
            f549124b = e.f549129e;
            f549125c = c.f549127e;
            f549126d = d.f549128e;
        }
    }

    public static class c extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final c f549127e = null;

        public final String toString() {
            return "center";
        }

        static {
            f549127e = new c();
        }

        public c() {
        }

        @Override // u7a.m.a
        public final void b(Matrix r100, float r101, float r102, float r103, float r104, float r105, float r106) {
            float r107 = com.lynx.tasm.utils.i.b(1.0f, 0.0f);
            float r108 = Math.round((r101 - (r103 * r107)) * 0.5f);
            float r109 = Math.round((r102 - (r104 * r107)) * 0.5f);
            r100.setScale(r107, r107);
            r100.postTranslate(r108, r109);
        }
    }

    public static class d extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final d f549128e = null;

        public final String toString() {
            return SlcScaleType.CENTER_CROP;
        }

        static {
            f549128e = new d();
        }

        public d() {
        }

        @Override // u7a.m.a
        public final void b(Matrix r100, float r101, float r102, float r103, float r104, float r110, float r111) {
            float r105 = r101 / r103;
            float r106 = r102 / r104;
            if (r105 <= r106) goto L5;
            r100.setScale(r105, r105);
            r100.postTranslate(r110, ((r102 - (r104 * r105)) / 2.0f) + r111);
            return;
        L5:
            r100.setScale(r106, r106);
            r100.postTranslate(((r101 - (r103 * r106)) / 2.0f) + r110, r111);
        }
    }

    public static class e extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final e f549129e = null;

        public final String toString() {
            return "fit_center";
        }

        static {
            f549129e = new e();
        }

        public e() {
        }

        @Override // u7a.m.a
        public final void b(Matrix r100, float r101, float r102, float r103, float r104, float r110, float r111) {
            float r105 = r101 / r103;
            float r106 = r102 / r104;
            if (r105 <= r106) goto L5;
            r100.setScale(r106, r106);
            r100.postTranslate(((r101 - (r103 * r106)) / 2.0f) + r110, r111);
            return;
        L5:
            r100.setScale(r105, r105);
            r100.postTranslate(r110, ((r102 - (r104 * r105)) / 2.0f) + r111);
        }
    }

    public static class f extends a {

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public static final f f549130e = null;

        public final String toString() {
            return SlcScaleType.FIT_XY;
        }

        static {
            f549130e = new f();
        }

        public f() {
        }

        @Override // u7a.m.a
        public final void b(Matrix r100, float r101, float r102, float r103, float r104, float r105, float r106) {
            r100.setScale(r101 / r103, r102 / r104);
            r100.postTranslate(r105, r106);
        }
    }

    public m() {
    }
}
