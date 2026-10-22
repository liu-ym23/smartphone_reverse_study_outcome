package q1c;

import com.larksuite.framework.callback.Entity.ErrorResult;
import kotlin.NoWhenBranchMatchedException;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class b<T> {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ErrorResult f531322a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f531322a, ((a) r100).f531322a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f531322a.hashCode();
        }

        public final String toString() {
            return "Error(error=" + this.f531322a + ')';
        }

        public a(ErrorResult r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f531322a = r100;
        }
    }

    /* JADX INFO: renamed from: q1c.b$b, reason: collision with other inner class name */
    public static final class C7270b<T> extends b<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f531323a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7270b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f531323a, ((C7270b) r100).f531323a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f531323a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f531323a + ')';
        }

        public C7270b(T r100) {
            this.f531323a = r100;
        }
    }

    public b() {
    }

    public final T a() {
        if ((this instanceof C7270b) == false) goto L6;
        return ((C7270b) this).f531323a;
    L6:
        if ((this instanceof a) == false) goto L10;
        return null;
    L10:
        throw new NoWhenBranchMatchedException();
    }
}
