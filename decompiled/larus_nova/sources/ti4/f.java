package ti4;

import io.reactivex.Observable;

/* JADX INFO: loaded from: classes15.dex */
public interface f {

    public static abstract class a {

        /* JADX INFO: renamed from: ti4.f$a$a, reason: collision with other inner class name */
        public static final class C7729a extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f546081a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof C7729a) == true) goto L9;
                return false;
            L9:
                if (this.f546081a == ((C7729a) r100).f546081a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                if (this.f546081a == false) goto L5;
                return 1231;
            L5:
                return 1237;
            }

            public final String toString() {
                return "ScrollEnd(isHandleDragging=" + this.f546081a + ')';
            }

            public C7729a(boolean r100) {
                this.f546081a = r100;
            }
        }

        public static final class b extends a {

            /* JADX INFO: renamed from: a, reason: collision with root package name */
            public final boolean f546082a;

            public final boolean equals(Object r100) {
                if (this != r100) goto L6;
                return true;
            L6:
                if ((r100 instanceof b) == true) goto L9;
                return false;
            L9:
                if (this.f546082a == ((b) r100).f546082a) goto L11;
                return false;
            L11:
                return true;
            }

            public final int hashCode() {
                if (this.f546082a == false) goto L5;
                return 1231;
            L5:
                return 1237;
            }

            public final String toString() {
                return "ScrollStart(isHandleDragging=" + this.f546082a + ')';
            }

            public b(boolean r100) {
                this.f546082a = r100;
            }
        }

        public a() {
        }
    }

    Observable<a> a();
}
