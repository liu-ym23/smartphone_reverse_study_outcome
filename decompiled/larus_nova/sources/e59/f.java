package e59;

import c59.i;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final i f471078a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471078a, ((a) r100).f471078a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            i r100 = this.f471078a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Removed(data=" + this.f471078a + ')';
        }

        public a(i r100) {
            this.f471078a = r100;
        }
    }

    public f() {
    }
}
