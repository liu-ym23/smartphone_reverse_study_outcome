package qma;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class e {

    public static final class a extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int[] f533954a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final float[] f533955b;

        public final String toString() {
            return "LinearGradient(colors=" + Arrays.toString(this.f533954a) + ", positions=" + Arrays.toString(this.f533955b) + ')';
        }

        public final int hashCode() {
            return (Arrays.hashCode(this.f533954a) * 31) + Arrays.hashCode(this.f533955b);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Arrays.equals(this.f533954a, r101.f533954a) == true) goto L11;
        L13:
            return false;
        L11:
            if (Arrays.equals(this.f533955b, r101.f533955b) == false) goto L13;
            return true;
        }

        public a(int[] r100, float[] r101) {
            Intrinsics.checkNotNullParameter(r100, "colors");
            Intrinsics.checkNotNullParameter(r101, "positions");
            this.f533954a = r100;
            this.f533955b = r101;
        }
    }

    public static final class b extends e {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f533956a = null;

        static {
            f533956a = new b();
        }

        public b() {
        }
    }

    public e() {
    }
}
