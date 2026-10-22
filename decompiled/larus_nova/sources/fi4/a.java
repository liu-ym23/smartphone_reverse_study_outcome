package fi4;

import android.view.View;
import com.bytedance.creativex.mediaimport.preview.internal.main.u;
import io.reactivex.Observable;

/* JADX INFO: loaded from: classes15.dex */
public interface a<DATA> {

    /* JADX INFO: renamed from: fi4.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC5910a {

        /* JADX INFO: renamed from: fi4.a$a$a, reason: collision with other inner class name */
        public static final class C5911a extends AbstractC5910a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final float f477358a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C5911a) == true) goto L9;
                return false;
            L9:
                if (Float.compare(this.f477358a, ((C5911a) r100).f477358a) == 0) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return Float.floatToIntBits(this.f477358a);
            }

            public final String toString() {
                return "AlphaChange(percent=" + this.f477358a + ')';
            }

            public C5911a(float r100) {
                this.f477358a = r100;
            }
        }

        /* JADX INFO: renamed from: fi4.a$a$b */
        public static final class b extends AbstractC5910a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f477359a = null;

            static {
                f477359a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: fi4.a$a$c */
        public static final class c extends AbstractC5910a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f477360a = null;

            static {
                f477360a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: fi4.a$a$d */
        public static final class d extends AbstractC5910a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f477361a = null;

            static {
                f477361a = new d();
            }

            public d() {
            }
        }

        /* JADX INFO: renamed from: fi4.a$a$e */
        public static final class e extends AbstractC5910a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final e f477362a = null;

            static {
                f477362a = new e();
            }

            public e() {
            }
        }

        public AbstractC5910a() {
        }
    }

    void a(u r100);

    Observable<f<DATA>> b();

    Observable<AbstractC5910a> c();

    void destroy();

    Observable<DATA> e();

    View getContentView();
}
