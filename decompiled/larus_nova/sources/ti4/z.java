package ti4;

import java.util.List;

/* JADX INFO: loaded from: classes15.dex */
public interface z<DATA> {

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final a f546105d = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f546106a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f546107b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f546108c;

        /* JADX INFO: renamed from: ti4.z$a$a, reason: collision with other inner class name */
        public static final class C7730a {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f546106a == r101.f546106a) goto L12;
            return false;
        L12:
            if (this.f546107b == r101.f546107b) goto L15;
            return false;
        L15:
            if (this.f546108c == r101.f546108c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f546106a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f546107b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f546108c == true) goto L15;
            r100 = 1237;
        L15:
            return r104 + r100;
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Result(confirmEnable=" + this.f546106a + ", videoSelectEnable=" + this.f546107b + ", imageSelectEnable=" + this.f546108c + ')';
        }

        static {
            f546105d = new a(true, true, true);
        }

        public a(boolean r100, boolean r101, boolean r102) {
            this.f546106a = r100;
            this.f546107b = r101;
            this.f546108c = r102;
        }
    }

    a a(List r100);
}
