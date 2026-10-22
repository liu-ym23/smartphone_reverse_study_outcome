package n99;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import q99.c;
import q99.j;
import q99.k;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: n99.a$a, reason: collision with other inner class name */
    public static final class C6908a implements a {
        public C6908a() {
        }

        @Override // n99.a
        public final void a(c r100, p99.a r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
            Intrinsics.checkNotNullParameter(r101, "callback");
        }

        @Override // n99.a
        public final void b(k r100, Function1<? super dm9.a<Unit>, Unit> r101) {
            Intrinsics.checkNotNullParameter(r100, "request");
        }

        @Override // n99.a
        public final void c(j r100) {
            Intrinsics.checkNotNullParameter(r100, "request");
        }
    }

    void a(c r100, p99.a r101);

    void b(k r100, Function1<? super dm9.a<Unit>, Unit> r101);

    void c(j r100);
}
