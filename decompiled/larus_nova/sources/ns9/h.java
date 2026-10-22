package ns9;

import com.larus.reach.api.ReachRejectReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class h {

    public static final class a extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f520377a = null;

        static {
            f520377a = new a();
        }

        public a() {
        }
    }

    public static final class b extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final ReachRejectReason f520378a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f520379b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f520378a == r101.f520378a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f520379b, r101.f520379b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f520378a.hashCode() * 31;
            String r101 = this.f520379b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Reject(reason=" + this.f520378a + ", message=" + this.f520379b + ')';
        }

        public b(ReachRejectReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f520378a = r100;
            this.f520379b = null;
        }
    }

    public static final class c extends h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520380a;

        public c() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f520380a, ((c) r100).f520380a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f520380a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Wait(reason=" + this.f520380a + ')';
        }

        public c(String r100) {
            this.f520380a = r100;
        }
    }

    public h() {
    }
}
