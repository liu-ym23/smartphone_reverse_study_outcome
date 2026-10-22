package ti4;

import com.bytedance.creativex.mediaimport.view.internal.MaterialSelectedState;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public abstract class h0<DATA> {

    public static final class a<DATA> extends h0<DATA> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DATA f546090a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f546091b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MaterialSelectedState f546092c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f546090a, r101.f546090a) == true) goto L12;
            return false;
        L12:
            if (this.f546091b == r101.f546091b) goto L15;
            return false;
        L15:
            if (this.f546092c == r101.f546092c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            DATA r100 = this.f546090a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((r101 * 31) + this.f546091b) * 31) + this.f546092c.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "MaterialCanceled(data=" + this.f546090a + ", position=" + this.f546091b + ", state=" + this.f546092c + ')';
        }

        public a(DATA r100, int r101, MaterialSelectedState r102) {
            Intrinsics.checkNotNullParameter(r102, "state");
            this.f546090a = r100;
            this.f546091b = r101;
            this.f546092c = r102;
        }
    }

    public static final class b<DATA> extends h0<DATA> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final DATA f546093a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f546094b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final MaterialSelectedState f546095c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f546093a, r101.f546093a) == true) goto L12;
            return false;
        L12:
            if (this.f546094b == r101.f546094b) goto L15;
            return false;
        L15:
            if (this.f546095c == r101.f546095c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            DATA r100 = this.f546093a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L7:
            return (((r101 * 31) + this.f546094b) * 31) + this.f546095c.hashCode();
        L5:
            r101 = r100.hashCode();
            goto L7
        }

        public final String toString() {
            return "MaterialClick(data=" + this.f546093a + ", position=" + this.f546094b + ", state=" + this.f546095c + ')';
        }

        public b(DATA r100, int r101, MaterialSelectedState r102) {
            Intrinsics.checkNotNullParameter(r102, "state");
            this.f546093a = r100;
            this.f546094b = r101;
            this.f546095c = r102;
        }
    }

    public h0() {
    }
}
