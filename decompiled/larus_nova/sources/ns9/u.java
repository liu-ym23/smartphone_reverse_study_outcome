package ns9;

import com.larus.reach.api.ReachRejectReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class u {

    public static final class a extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520413a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f520413a, ((a) r100).f520413a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f520413a.hashCode();
        }

        public final String toString() {
            return "Accepted(reachUniqueId=" + this.f520413a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reachUniqueId");
            this.f520413a = r100;
        }
    }

    public static final class b extends u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520414a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReachRejectReason f520415b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f520414a, r101.f520414a) == true) goto L12;
            return false;
        L12:
            if (this.f520415b == r101.f520415b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f520414a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (r101 * 31) + this.f520415b.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "Rejected(reachUniqueId=" + this.f520414a + ", reason=" + this.f520415b + ')';
        }

        public b(String r100, ReachRejectReason r101) {
            Intrinsics.checkNotNullParameter(r101, "reason");
            this.f520414a = r100;
            this.f520415b = r101;
        }
    }

    public u() {
    }
}
