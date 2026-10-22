package fya;

import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import androidx.fragment.app.Fragment;
import kotlin.jvm.internal.Intrinsics;
import v99.x;

/* JADX INFO: loaded from: classes34.dex */
public interface a {

    /* JADX INFO: renamed from: fya.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC5966a {

        /* JADX INFO: renamed from: fya.a$a$a, reason: collision with other inner class name */
        public static final class C5967a extends AbstractC5966a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C5967a f479326a = null;

            static {
                f479326a = new C5967a();
            }

            public C5967a() {
            }
        }

        /* JADX INFO: renamed from: fya.a$a$b */
        public static final class b extends AbstractC5966a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f479327a = null;

            static {
                f479327a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: fya.a$a$c */
        public static final class c extends AbstractC5966a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final c f479328a = null;

            static {
                f479328a = new c();
            }

            public c() {
            }
        }

        /* JADX INFO: renamed from: fya.a$a$d */
        public static final class d extends AbstractC5966a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f479329a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof d) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f479329a, ((d) r100).f479329a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f479329a.hashCode();
            }

            public final String toString() {
                return "StreamResult(text=" + this.f479329a + ')';
            }

            public d(String r100) {
                Intrinsics.checkNotNullParameter(r100, "text");
                this.f479329a = r100;
            }
        }

        /* JADX INFO: renamed from: fya.a$a$e */
        public static final class e extends AbstractC5966a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f479330a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof e) == true) goto L9;
                return false;
            L9:
                if (Intrinsics.areEqual(this.f479330a, ((e) r100).f479330a) == true) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                return this.f479330a.hashCode();
            }

            public final String toString() {
                return "Success(text=" + this.f479330a + ')';
            }

            public e(String r100) {
                Intrinsics.checkNotNullParameter(r100, "text");
                this.f479330a = r100;
            }
        }

        public AbstractC5966a() {
        }
    }

    public interface b {
        String a();

        String getChatId();
    }

    public interface c {
        void a(byte[] r100, String r101);

        void b(byte[] r100);

        void c(boolean r100);

        void d(String r100, boolean r101);

        void e(AbstractC5966a r100);

        void onCancel();
    }

    public interface d {
        void a(TextView r100, boolean r101);

        void b(TextView r100);

        boolean isLoading();
    }

    void A5(ViewGroup r100, Fragment r101, ViewGroup r102, b r103, c r104);

    View.OnTouchListener D0(EditText r100);

    void v5(boolean r100);

    void w5(Fragment r100);

    x x5();

    boolean y3();

    void y5();

    boolean z5();
}
