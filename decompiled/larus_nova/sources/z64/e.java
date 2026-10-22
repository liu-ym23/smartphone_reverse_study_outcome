package z64;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes47.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f570464a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.f570464a, ((a) r100).f570464a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f570464a;
            if (r100 != null) goto L7;
            return 0;
        L7:
            return r100.hashCode();
        }

        public final String toString() {
            return "Network(path=" + this.f570464a + ")";
        }

        public a(String r100) {
            this.f570464a = r100;
        }
    }

    public e() {
    }
}
