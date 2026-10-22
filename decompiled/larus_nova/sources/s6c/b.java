package s6c;

import android.graphics.RectF;
import android.view.View;

/* JADX INFO: loaded from: classes38.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f540895a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float f540896b;

        public a() {
            this(0.0f, 0.0f);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Float.compare(this.f540895a, r101.f540895a) == 0) goto L12;
            return false;
        L12:
            if (Float.compare(this.f540896b, r101.f540896b) == 0) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (Float.floatToIntBits(this.f540895a) * 31) + Float.floatToIntBits(this.f540896b);
        }

        public final String toString() {
            return "RectSize(width=" + this.f540895a + ", height=" + this.f540896b + ')';
        }

        public a(float r100, float r101) {
            this.f540895a = r100;
            this.f540896b = r101;
        }
    }

    View a(RectF r100);

    void b();

    a d(a r100);

    void e(View r100);

    void f();

    void g();

    void h(View r100);
}
