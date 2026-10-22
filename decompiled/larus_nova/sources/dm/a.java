package dm;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes44.dex */
public final class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f469202a = null;

    /* JADX INFO: renamed from: dm.a$a, reason: collision with other inner class name */
    public interface InterfaceC5687a extends dm.b {
    }

    public static final class b implements InterfaceC5687a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d f469203a;

        public b() {
            this.f469203a = new d();
        }

        public final void a(String r100) {
            d r101 = this.f469203a;     // Catch: Exception -> L4
            r101.g(3, r101.d(), r101.e(), r101.c(), r100, null);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            c.b(e);
        }

        @Override // dm.b
        public final void i(String r100) {
            this.f469203a.i(r100);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            c.b(e);
        }

        public final void b(String r100, Throwable r101) {
            this.f469203a.b(r100, r101);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            c.b(e);
        }

        @Override // dm.b
        public final void w(String r100, Throwable r101) {
            this.f469203a.w(r100, r101);     // Catch: Exception -> L4
            return;
        L4:
            e = move-exception;
            c.b(e);
        }
    }

    static {
        f469202a = new b();
    }

    public static b a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        b r101 = f469202a;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "tag");
        d r102 = r101.f469203a;
        r102.getClass();
        Intrinsics.checkNotNullParameter(r100, "tag");
        r102.f469206b.set(r100);
        return r101;
    }
}
