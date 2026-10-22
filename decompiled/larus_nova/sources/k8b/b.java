package k8b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f502131a = null;

        static {
            f502131a = new a();
        }

        public a() {
        }
    }

    /* JADX INFO: renamed from: k8b.b$b, reason: collision with other inner class name */
    public static final class C6522b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C6522b f502132a = null;

        static {
            f502132a = new C6522b();
        }

        public C6522b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f502133a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f502134b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f502133a, r101.f502133a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f502134b, r101.f502134b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f502133a.hashCode() * 31;
            String r101 = this.f502134b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failure(code=" + this.f502133a + ", message=" + this.f502134b + ')';
        }

        public c(String r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "code");
            this.f502133a = r100;
            this.f502134b = r101;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f502135a = null;

        static {
            f502135a = new d();
        }

        public d() {
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f502136a = null;

        static {
            f502136a = new e();
        }

        public e() {
        }
    }

    public b() {
    }
}
