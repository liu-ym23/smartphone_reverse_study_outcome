package op8;

import android.net.Uri;
import android.view.View;
import java.util.List;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface f {

    public static abstract class a {

        /* JADX INFO: renamed from: op8.f$a$a, reason: collision with other inner class name */
        public static final class C7086a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C7086a f524757a = null;

            static {
                f524757a = new C7086a();
            }

            public C7086a() {
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f524758a = null;

            static {
                f524758a = new b();
            }

            public b() {
            }
        }

        public static final class c extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f524759a = null;

            static {
                f524759a = new c();
            }

            public c() {
            }
        }

        public static final class d extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f524760a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f524760a, ((d) r100).f524760a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f524760a.hashCode();
            }

            public final String toString() {
                return "StreamResult(text=" + this.f524760a + ')';
            }

            public d(String r100) {
                Intrinsics.checkNotNullParameter(r100, "text");
                this.f524760a = r100;
            }
        }

        public static final class e extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f524761a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f524761a, ((e) r100).f524761a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f524761a.hashCode();
            }

            public final String toString() {
                return "Succeed(text=" + this.f524761a + ')';
            }

            public e(String r100) {
                Intrinsics.checkNotNullParameter(r100, "text");
                this.f524761a = r100;
            }
        }

        public a() {
        }
    }

    public static abstract class b {

        public static final class a extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final a f524762a = null;

            static {
                f524762a = new a();
            }

            public a() {
            }
        }

        /* JADX INFO: renamed from: op8.f$b$b, reason: collision with other inner class name */
        public static final class C7087b extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C7087b f524763a = null;

            static {
                f524763a = new C7087b();
            }

            public C7087b() {
            }
        }

        public static final class c extends b {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f524764a = null;

            static {
                f524764a = new c();
            }

            public c() {
            }
        }

        public b() {
        }
    }

    void A3(List<String> r100);

    void M7(View r100, String r101);

    void a(String r100);

    void b(int r100, long r101);

    boolean c(String r100);

    void d(int r100);

    void e(a r100);

    void f(b r100);

    void f4(View r100);

    boolean g();

    Map<String, String> getEventInfo();

    void h(boolean r100);

    void h0(Uri r100);
}
