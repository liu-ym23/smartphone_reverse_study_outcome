package ti4;

/* JADX INFO: loaded from: classes15.dex */
public abstract class g0 {

    public static final class a extends g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f546085a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f546085a == ((a) r100).f546085a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f546085a;
        }

        public final String toString() {
            return "ItemDrag(position=" + this.f546085a + ')';
        }

        public a(int r100) {
            this.f546085a = r100;
        }
    }

    public static final class b extends g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f546086a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f546087b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f546086a == r101.f546086a) goto L12;
            return false;
        L12:
            if (this.f546087b == r101.f546087b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f546086a * 31) + this.f546087b;
        }

        public final String toString() {
            return "ItemMoved(from=" + this.f546086a + ", to=" + this.f546087b + ')';
        }

        public b(int r100, int r101) {
            this.f546086a = r100;
            this.f546087b = r101;
        }
    }

    public static final class c extends g0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f546088a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f546089b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f546088a == r101.f546088a) goto L12;
            return false;
        L12:
            if (this.f546089b == r101.f546089b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f546088a * 31) + this.f546089b;
        }

        public final String toString() {
            return "ItemReleased(from=" + this.f546088a + ", to=" + this.f546089b + ')';
        }

        public c(int r100, int r101) {
            this.f546088a = r100;
            this.f546089b = r101;
        }
    }

    public g0() {
    }
}
