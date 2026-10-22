package qma;

import com.obric.oui.texteffects.core.Direction;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes34.dex */
public abstract class j {

    public static final class a extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f533966a = null;

        static {
            f533966a = new a();
        }

        public a() {
        }
    }

    public static final class b extends j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Direction f533967a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Direction f533968b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final float f533969c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final float f533970d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f533967a == r101.f533967a) goto L12;
            return false;
        L12:
            if (this.f533968b == r101.f533968b) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(Float.valueOf(this.f533969c), Float.valueOf(r101.f533969c)) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(Float.valueOf(this.f533970d), Float.valueOf(r101.f533970d)) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            return (((((this.f533967a.hashCode() * 31) + this.f533968b.hashCode()) * 31) + Float.floatToIntBits(this.f533969c)) * 31) + Float.floatToIntBits(this.f533970d);
        }

        public final String toString() {
            return "ScanWindow(direction=" + this.f533967a + ", gradientAlphaDirection=" + this.f533968b + ", featherRatio=" + this.f533969c + ", minFeatherDp=" + this.f533970d + ')';
        }

        public b(Direction r100, Direction r101) {
            Intrinsics.checkNotNullParameter(r100, "direction");
            Intrinsics.checkNotNullParameter(r101, "gradientAlphaDirection");
            this.f533967a = r100;
            this.f533968b = r101;
            this.f533969c = 0.3f;
            this.f533970d = 16.0f;
        }
    }

    public j() {
    }
}
