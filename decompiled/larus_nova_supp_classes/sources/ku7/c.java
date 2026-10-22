package ku7;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes.dex */
public final class c {
    public static final Lazy a = null;

    public static final class a implements ju7.b {
        public a() {
        }

        @Override // ju7.b
        public final void d(String r3) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        @Override // ju7.b
        public final void i(String r3) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }

        @Override // ju7.b
        public final void w(String r3) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r3, "msg");
        }
    }

    static {
        a = LazyKt.lazy(new b());
    }

    public static void a(String r1) {
        Intrinsics.checkNotNullParameter(r1, "msg");
        ku7.a r0 = ku7.a.a;
        ju7.b r2 = ku7.a.c;
        if (r2 != null) goto L5;
        r2 = (ju7.b) a.getValue();
    L5:
        r2.i(r1);
    }
}
