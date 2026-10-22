package r2;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes43.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<d> f535693a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f535694b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f535693a, r101.f535693a) == true) goto L12;
            return false;
        L12:
            if (this.f535694b == r101.f535694b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f535693a.hashCode() * 31) + this.f535694b;
        }

        public final String toString() {
            return "ActionGroup(items=" + this.f535693a + ", rowCount=" + this.f535694b + ')';
        }

        public a(List<d> r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f535693a = r100;
            this.f535694b = r101;
        }
    }

    /* JADX INFO: renamed from: r2.b$b, reason: collision with other inner class name */
    public static final class C7425b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r2.a f535695a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7425b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f535695a, ((C7425b) r100).f535695a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f535695a.hashCode();
        }

        public final String toString() {
            return "Execute(action=" + this.f535695a + ')';
        }

        public C7425b(r2.a r100) {
            Intrinsics.checkNotNullParameter(r100, "action");
            this.f535695a = r100;
        }
    }

    public b() {
    }
}
