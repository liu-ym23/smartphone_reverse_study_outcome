package ue9;

/* JADX INFO: loaded from: classes30.dex */
public interface g {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final b f549873a = null;

    public static final class a implements g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f549874b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f549875c;

        /* JADX INFO: renamed from: ue9.g$a$a, reason: collision with other inner class name */
        public static final class C7873a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f549874b == r101.f549874b) goto L12;
            return false;
        L12:
            if (this.f549875c == r101.f549875c) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f549874b * 31) + this.f549875c;
        }

        public final String toString() {
            return "Audio(sampleRate=" + this.f549874b + ", channel=" + this.f549875c + ')';
        }

        public a(int r100, int r101) {
            this.f549874b = r100;
            this.f549875c = r101;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ b f549876a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f549877b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f549878c = null;

        public b() {
        }

        static {
            f549876a = new b();
            f549877b = new a(16000, 1);
            f549878c = new c();
        }
    }

    public static final class c implements g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f549879b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f549880c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f549881d;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f549879b == r101.f549879b) goto L12;
            return false;
        L12:
            if (this.f549880c == r101.f549880c) goto L15;
            return false;
        L15:
            if (this.f549881d == r101.f549881d) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.f549879b * 31) + this.f549880c) * 31) + this.f549881d;
        }

        public final String toString() {
            return "Opus(sampleRate=" + this.f549879b + ", channel=" + this.f549880c + ", frameSizeMs=" + this.f549881d + ')';
        }

        public c() {
            this.f549879b = 48000;
            this.f549880c = 1;
            this.f549881d = 20;
        }
    }

    public static final class d implements g {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f549882b = null;

        static {
            f549882b = new d();
        }

        public d() {
        }
    }

    static {
        f549873a = b.f549876a;
    }
}
