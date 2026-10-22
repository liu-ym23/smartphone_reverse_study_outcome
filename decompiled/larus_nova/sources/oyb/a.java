package oyb;

import com.ss.android.lark.officesdk.api.base.IOfficeSDKProtocol;
import java.util.Map;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public interface a extends IOfficeSDKProtocol {

    /* JADX INFO: renamed from: oyb.a$a, reason: collision with other inner class name */
    public static abstract class AbstractC7129a {

        /* JADX INFO: renamed from: oyb.a$a$a, reason: collision with other inner class name */
        public static final class C7130a extends AbstractC7129a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final C7130a f527162a = null;

            static {
                f527162a = new C7130a();
            }

            public C7130a() {
            }
        }

        /* JADX INFO: renamed from: oyb.a$a$b */
        public static final class b extends AbstractC7129a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final b f527163a = null;

            static {
                f527163a = new b();
            }

            public b() {
            }
        }

        /* JADX INFO: renamed from: oyb.a$a$c */
        public static final class c extends AbstractC7129a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final String f527164a;

            /* JADX INFO: renamed from: b, reason: collision with root package name */
            public final String f527165b;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof c) == true) goto L8;
                return false;
            L8:
                c r101 = (c) r100;
                if (Intrinsics.areEqual(this.f527164a, r101.f527164a) == true) goto L12;
                return false;
            L12:
                if (Intrinsics.areEqual(this.f527165b, r101.f527165b) == true) goto L14;
                return false;
            L14:
                return true;
            }

            public final int hashCode() {
                int r100 = this.f527164a.hashCode() * 31;
                String r101 = this.f527165b;
                if (r101 != null) goto L5;
                int r102 = 0;
            L7:
                return r100 + r102;
            L5:
                r102 = r101.hashCode();
                goto L7
            }

            public final String toString() {
                return "Failure(code=" + this.f527164a + ", message=" + this.f527165b + ')';
            }

            public c(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "code");
                this.f527164a = r100;
                this.f527165b = r101;
            }
        }

        /* JADX INFO: renamed from: oyb.a$a$d */
        public static final class d extends AbstractC7129a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public static final d f527166a = null;

            static {
                f527166a = new d();
            }

            public d() {
            }
        }

        public AbstractC7129a() {
        }
    }

    void R(Function2 r100);

    void q();

    void s1(Map<String, String> r100, Function1<? super AbstractC7129a, Unit> r101);
}
