package d01;

/* JADX INFO: loaded from: classes47.dex */
public interface b {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f466180a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f466181b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L4;
            return true;
        L4:
            if ((r100 instanceof a) == false) goto L10;
            a r101 = (a) r100;
            if (this.f466180a == r101.f466180a) goto L8;
            return false;
        L8:
            if (this.f466181b == r101.f466181b) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v2, types: [int] */
        /* JADX WARN: Type inference failed for: r1v1, types: [int] */
        /* JADX WARN: Type inference failed for: r1v2 */
        /* JADX WARN: Type inference failed for: r1v3 */
        public final int hashCode() {
            int r100 = this.f466180a * 31;
            boolean r101 = this.f466181b;
            ?? r102 = r101;
            if (r101 == false) goto L6;
            r102 = 1;
        L6:
            return r100 + r102;
        }

        public final String toString() {
            return "FieldAttributes(repeatCount=" + this.f466180a + ", keyFramesOnly=" + this.f466181b + ")";
        }

        public a(int r100, boolean r101) {
            this.f466180a = r100;
            this.f466181b = r101;
        }
    }

    void a(String r100, Object r101, a r102);

    void b(String r100);
}
