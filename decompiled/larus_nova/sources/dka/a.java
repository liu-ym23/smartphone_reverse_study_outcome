package dka;

import cka.b;
import kotlin.jvm.JvmStatic;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes5.dex */
public final class a implements b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final a f469052a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static b f469053b;

    /* JADX INFO: renamed from: dka.a$a, reason: collision with other inner class name */
    public static final class C5682a implements b {
        public C5682a() {
        }

        @Override // cka.b
        public final void d(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            gka.b.a(r100, r101);
        }

        @Override // cka.b
        public final void i(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            gka.b.c(r100, r101);
        }

        @Override // cka.b
        public final void w(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            int r102 = gka.b.f481577a;
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            bka.a r103 = bka.a.f19387a;
        }

        @Override // cka.b
        public final void e(String r100, String r101, Throwable r102) {
            Intrinsics.checkNotNullParameter(r100, "tag");
            Intrinsics.checkNotNullParameter(r101, "msg");
            gka.b.b(r100, r101);
        }
    }

    public a() {
    }

    static {
        f469052a = new a();
        f469053b = new C5682a();
    }

    @JvmStatic
    public static final void a(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f469052a.d(r100, r101);
    }

    @JvmStatic
    public static final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f469052a.e(r100, r101, null);
    }

    @JvmStatic
    public static final void c(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f469052a.i(r100, r101);
    }

    @JvmStatic
    public static final void f(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f469052a.w(r100, r101);
    }

    @Override // cka.b
    public final void d(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f469053b.d(r100, r101);
    }

    @Override // cka.b
    public final void i(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f469053b.i(r100, r101);
    }

    @Override // cka.b
    public final void w(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f469053b.w(r100, r101);
    }

    @Override // cka.b
    public final void e(String r100, String r101, Throwable r102) {
        Intrinsics.checkNotNullParameter(r100, "tag");
        Intrinsics.checkNotNullParameter(r101, "msg");
        f469053b.e(r100, r101, r102);
    }
}
