package w88;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public abstract class i {

    public static final class a extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f558677a = null;

        static {
            f558677a = new a();
        }

        public a() {
        }
    }

    public static final class b extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f558678a;

        public b() {
            this(null);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f558678a, ((b) r100).f558678a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f558678a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Error(message=" + this.f558678a + ')';
        }

        public b(String r100) {
            this.f558678a = r100;
        }
    }

    public static final class c extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f558679a = null;

        static {
            f558679a = new c();
        }

        public c() {
        }
    }

    public static final class d extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f558680a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f558680a == ((d) r100).f558680a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f558680a;
        }

        public final String toString() {
            return "Transferring(progress=" + this.f558680a + ')';
        }

        public d(int r100) {
            this.f558680a = r100;
        }
    }

    public static final class e extends i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f558681a = null;

        static {
            f558681a = new e();
        }

        public e() {
        }
    }

    public i() {
    }
}
