package i9b;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes35.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: i9b.a$a, reason: collision with other inner class name */
    public static final class C6245a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f488827a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6245a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f488827a, ((C6245a) r100).f488827a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f488827a.hashCode();
        }

        public final String toString() {
            return "Error(message=" + this.f488827a + ')';
        }

        public C6245a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f488827a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f488828a = null;

        static {
            f488828a = new b();
        }

        public b() {
        }
    }

    public static final class c<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f488829a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f488829a, ((c) r100).f488829a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f488829a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f488829a + ')';
        }

        public c(T r100) {
            this.f488829a = r100;
        }
    }

    public a() {
    }
}
