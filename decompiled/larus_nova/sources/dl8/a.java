package dl8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface a {

    /* JADX INFO: renamed from: dl8.a$a, reason: collision with other inner class name */
    public static final class C5685a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f469138a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f469139b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f469140c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5685a) == true) goto L8;
            return false;
        L8:
            C5685a r101 = (C5685a) r100;
            if (Intrinsics.areEqual(this.f469138a, r101.f469138a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f469139b, r101.f469139b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f469140c, r101.f469140c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f469138a.hashCode() * 31) + this.f469139b.hashCode()) * 31) + this.f469140c.hashCode();
        }

        public final String toString() {
            return "Code(code=" + this.f469138a + ", language=" + this.f469139b + ", title=" + this.f469140c + ')';
        }

        public C5685a(String r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "code");
            Intrinsics.checkNotNullParameter(r101, "language");
            Intrinsics.checkNotNullParameter(r102, "title");
            this.f469138a = r100;
            this.f469139b = r101;
            this.f469140c = r102;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f469141a = null;

        static {
            f469141a = new b();
        }

        public b() {
        }
    }
}
