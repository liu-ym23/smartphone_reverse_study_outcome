package cu5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class b<T> {

    public static final class a<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f465428a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final T f465429b;

        public /* synthetic */ a() {
            throw null;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f465428a, r101.f465428a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f465429b, r101.f465429b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f465428a.hashCode() * 31;
            T r101 = this.f465429b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Fail(err=" + this.f465428a + ", value=" + this.f465429b + ')';
        }

        public a(Throwable r100, T r101) {
            Intrinsics.checkNotNullParameter(r100, "err");
            this.f465428a = r100;
            this.f465429b = r101;
        }
    }

    /* JADX INFO: renamed from: cu5.b$b, reason: collision with other inner class name */
    public static final class C5590b<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f465430a;

        public C5590b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5590b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f465430a, ((C5590b) r100).f465430a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f465430a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Loading(value=" + this.f465430a + ')';
        }

        public C5590b(Object r100) {
            this.f465430a = null;
        }
    }

    public static final class c<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f465431a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f465431a, ((c) r100).f465431a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f465431a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(value=" + this.f465431a + ')';
        }

        public c(T r100) {
            this.f465431a = r100;
        }
    }

    public b() {
    }
}
