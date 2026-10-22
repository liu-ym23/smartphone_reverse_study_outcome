package ku7;

import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Lazy f506221a = null;

    public static final class a implements ju7.b {
        public a() {
        }

        @Override // ju7.b
        public final void d(String r100) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
        }

        @Override // ju7.b
        public final void i(String r100) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
        }

        @Override // ju7.b
        public final void w(String r100) {
            Intrinsics.checkNotNullParameter("f_quality", "tag");
            Intrinsics.checkNotNullParameter(r100, "msg");
        }
    }

    static {
        f506221a = LazyKt.lazy(new b());
    }

    public static void a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "msg");
        ku7.a r101 = ku7.a.f506216a;
        ju7.b r102 = ku7.a.f506218c;
        if (r102 != null) goto L5;
        r102 = (ju7.b) f506221a.getValue();
    L5:
        r102.i(r100);
    }
}
