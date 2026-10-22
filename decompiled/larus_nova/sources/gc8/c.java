package gc8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f480881a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f480881a == ((a) r100).f480881a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f480881a;
        }

        public final String toString() {
            return "Resource(resId=" + this.f480881a + ')';
        }

        public a(int r100) {
            this.f480881a = r100;
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f480882a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f480882a, ((b) r100).f480882a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f480882a.hashCode();
        }

        public final String toString() {
            return "Url(url=" + this.f480882a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f480882a = r100;
        }
    }
}
