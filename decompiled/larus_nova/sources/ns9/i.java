package ns9;

import com.larus.reach.api.ReachCloseReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f520381a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final ReachCloseReason f520382b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f520381a, r101.f520381a) == true) goto L12;
            return false;
        L12:
            if (this.f520382b == r101.f520382b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f520381a.hashCode() * 31) + this.f520382b.hashCode();
        }

        public final String toString() {
            return "Replace(replacedReachUniqueId=" + this.f520381a + ", reason=" + this.f520382b + ')';
        }

        public a(String r100, ReachCloseReason r101) {
            Intrinsics.checkNotNullParameter(r100, "replacedReachUniqueId");
            Intrinsics.checkNotNullParameter(r101, "reason");
            this.f520381a = r100;
            this.f520382b = r101;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f520383a = null;

        static {
            f520383a = new b();
        }

        public b() {
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f520384a;

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
            if (Intrinsics.areEqual(this.f520384a, ((c) r100).f520384a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f520384a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Wait(retryDelayMs=" + this.f520384a + ')';
        }

        public c(Long r100) {
            this.f520384a = r100;
        }
    }

    public i() {
    }
}
