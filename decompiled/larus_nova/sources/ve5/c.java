package ve5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f554360a = null;

        static {
            f554360a = new a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return -164958669;
        }

        public final String toString() {
            return "Ignore";
        }

        public a() {
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f554361a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f554361a, ((b) r100).f554361a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f554361a.hashCode();
        }

        public final String toString() {
            return "Navigate(url=" + this.f554361a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f554361a = r100;
        }
    }

    public c() {
    }
}
