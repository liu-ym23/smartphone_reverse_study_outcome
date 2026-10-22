package is8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f495681a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f495681a, ((a) r100).f495681a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f495681a.hashCode();
        }

        public final String toString() {
            return "ContentUri(uri=" + this.f495681a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "uri");
            this.f495681a = r100;
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f495682a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f495682a, ((b) r100).f495682a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f495682a.hashCode();
        }

        public final String toString() {
            return "LocalPath(path=" + this.f495682a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "path");
            this.f495682a = r100;
        }
    }

    public i() {
    }
}
