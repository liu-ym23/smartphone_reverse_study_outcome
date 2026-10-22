package e59;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471061a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471061a, ((a) r100).f471061a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f471061a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Connected(mac=" + this.f471061a + ')';
        }

        public a(String r100) {
            this.f471061a = r100;
        }
    }

    /* JADX INFO: renamed from: e59.b$b, reason: collision with other inner class name */
    public static final class C5741b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471062a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C5741b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471062a, ((C5741b) r100).f471062a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f471062a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Connecting(mac=" + this.f471062a + ')';
        }

        public C5741b(String r100) {
            this.f471062a = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f471063a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f471063a, ((c) r100).f471063a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f471063a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Disconnected(mac=" + this.f471063a + ')';
        }

        public c(String r100) {
            this.f471063a = r100;
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f471064a = null;

        static {
            f471064a = new d();
        }

        public d() {
        }
    }

    public b() {
    }
}
