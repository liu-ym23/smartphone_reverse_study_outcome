package lk9;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f509630a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f509630a, ((a) r100).f509630a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f509630a.hashCode();
        }

        public final String toString() {
            return "Failure(reason=" + this.f509630a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f509630a = r100;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final float f509631a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Float.compare(this.f509631a, ((b) r100).f509631a) == 0) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return Float.floatToIntBits(this.f509631a);
        }

        public final String toString() {
            return "Success(volume=" + this.f509631a + ')';
        }

        public b(float r100) {
            this.f509631a = r100;
        }
    }

    public i() {
    }
}
