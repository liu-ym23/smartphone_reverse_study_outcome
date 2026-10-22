package dw8;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<e> f470331a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f470332b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f470331a, r101.f470331a) == true) goto L12;
            return false;
        L12:
            if (this.f470332b == r101.f470332b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f470331a.hashCode() * 31) + this.f470332b;
        }

        public final String toString() {
            return "ActionGroup(items=" + this.f470331a + ", rowCount=" + this.f470332b + ')';
        }

        public a(List<e> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f470331a = r100;
            this.f470332b = r101;
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final dw8.b f470333a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f470333a, ((b) r100).f470333a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f470333a.hashCode();
        }

        public final String toString() {
            return "Execute(action=" + this.f470333a + ')';
        }

        public b(dw8.b r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f470333a = r100;
        }
    }

    public c() {
    }
}
