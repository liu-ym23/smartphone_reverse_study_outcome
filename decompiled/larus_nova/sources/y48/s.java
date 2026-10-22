package y48;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public abstract class s {

    public static final class a extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f566133a = null;

        static {
            f566133a = new a();
        }

        public a() {
        }
    }

    public static final class b extends s {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            ((b) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Perform(action=null)";
        }
    }

    public static final class c extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f566134a = null;

        static {
            f566134a = new c();
        }

        public c() {
        }
    }

    public static final class d extends s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f566135a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f566135a == ((d) r100).f566135a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f566135a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "UpdateCancelState(cancel=" + this.f566135a + ')';
        }

        public d(boolean r100) {
            this.f566135a = r100;
        }
    }

    public s() {
    }
}
