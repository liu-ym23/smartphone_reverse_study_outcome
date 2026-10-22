package ys8;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f568992a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f568992a == ((a) r100).f568992a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f568992a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "Apply(modelId=" + this.f568992a + ')';
        }

        public a(long r100) {
            this.f568992a = r100;
        }
    }

    /* JADX INFO: renamed from: ys8.b$b, reason: collision with other inner class name */
    public static final class C8379b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C8379b f568993a = null;

        static {
            f568993a = new C8379b();
        }

        public C8379b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f568994a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f568994a, ((c) r100).f568994a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f568994a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Reject(displayText=" + this.f568994a + ')';
        }

        public c(String r100) {
            this.f568994a = r100;
        }
    }

    public b() {
    }
}
