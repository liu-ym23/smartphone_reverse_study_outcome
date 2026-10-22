package com.larus.dora.impl.device.settings.media;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.a$a, reason: collision with other inner class name */
    public static final class C4235a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f334815a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f334816b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f334817c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4235a) == true) goto L8;
            return false;
        L8:
            C4235a r101 = (C4235a) r100;
            if (this.f334815a == r101.f334815a) goto L12;
            return false;
        L12:
            if (this.f334816b == r101.f334816b) goto L15;
            return false;
        L15:
            if (this.f334817c == r101.f334817c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f334815a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f334816b == true) goto L10;
            r100 = 1237;
        L10:
            int r103 = (r102 + r100) * 31;
            long r104 = this.f334817c;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Action(needRequestPermission=" + this.f334815a + ", needToast=" + this.f334816b + ", version=" + this.f334817c + ')';
        }

        public C4235a() {
            long r100 = System.currentTimeMillis();
            this.f334815a = true;
            this.f334816b = false;
            this.f334817c = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f334818a;

        public b() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f334818a == ((b) r100).f334818a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f334818a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "RecordLocationRequestPermission(version=" + this.f334818a + ')';
        }

        public b(int r100) {
            this.f334818a = System.currentTimeMillis();
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f334819a;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f334819a == ((c) r100).f334819a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f334819a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "RecordLocationShowAlwaysAllowDialog(version=" + this.f334819a + ')';
        }

        public c(int r100) {
            this.f334819a = System.currentTimeMillis();
        }
    }
}
