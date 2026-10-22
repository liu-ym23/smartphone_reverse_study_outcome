package svb;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes37.dex */
public abstract class a {

    /* JADX INFO: renamed from: svb.a$a, reason: collision with other inner class name */
    public static final class C7663a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f543682a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7663a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f543682a, ((C7663a) r100).f543682a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f543682a.hashCode();
        }

        public final String toString() {
            return "Danger(text=" + this.f543682a + ')';
        }

        public C7663a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f543682a = r100;
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f543683a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f543683a, ((b) r100).f543683a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f543683a.hashCode();
        }

        public final String toString() {
            return "Normal(text=" + this.f543683a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "text");
            this.f543683a = r100;
        }
    }

    public static final class c extends a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Warn(text=null)";
        }
    }

    public a() {
    }
}
