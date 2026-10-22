package n38;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class a0 {

    public static final class a extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f516982a = null;

        static {
            f516982a = new a();
        }

        public a() {
        }
    }

    public static final class b extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f516983a = null;

        static {
            f516983a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f516984a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f516985b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f516984a, r101.f516984a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f516985b, r101.f516985b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f516984a.hashCode() * 31;
            String r101 = this.f516985b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failure(code=" + this.f516984a + ", message=" + this.f516985b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            this.f516984a = r100;
            this.f516985b = r101;
        }
    }

    public static final class d extends a0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f516986a = null;

        static {
            f516986a = new d();
        }

        public d() {
        }
    }

    public a0() {
    }
}
