package e6b;

import com.ss.android.lark.blueprint.j;

/* JADX INFO: loaded from: classes35.dex */
public interface a {

    /* JADX INFO: renamed from: e6b.a$a, reason: collision with other inner class name */
    public static final class C5748a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f471155a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f471156b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5748a) == true) goto L8;
            return false;
        L8:
            C5748a r101 = (C5748a) r100;
            if (this.f471155a == r101.f471155a) goto L12;
            return false;
        L12:
            if (this.f471156b == r101.f471156b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f471155a * 31) + this.f471156b;
        }

        public final String toString() {
            return "OrderCount(subOrder=" + this.f471155a + ", count=" + this.f471156b + ')';
        }

        public C5748a(int r100, int r101) {
            this.f471155a = r100;
            this.f471156b = r101;
        }
    }

    C5748a e(j r100);
}
