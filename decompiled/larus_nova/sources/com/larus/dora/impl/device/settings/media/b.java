package com.larus.dora.impl.device.settings.media;

/* JADX INFO: loaded from: classes27.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f334821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f334822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f334823c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f334824d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f334825e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f334826f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f334821a == r101.f334821a) goto L12;
            return false;
        L12:
            if (this.f334822b == r101.f334822b) goto L15;
            return false;
        L15:
            if (this.f334823c == r101.f334823c) goto L18;
            return false;
        L18:
            if (this.f334824d == r101.f334824d) goto L21;
            return false;
        L21:
            if (this.f334825e == r101.f334825e) goto L24;
            return false;
        L24:
            if (this.f334826f == r101.f334826f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f334821a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f334822b == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f334823c == false) goto L13;
            int r105 = 1231;
        L14:
            int r106 = (r104 + r105) * 31;
            if (this.f334824d == false) goto L17;
            int r107 = 1231;
        L18:
            int r108 = (r106 + r107) * 31;
            if (this.f334825e == true) goto L22;
            r100 = 1237;
        L22:
            int r109 = (r108 + r100) * 31;
            long r110 = this.f334826f;
            return r109 + ((int) (r110 ^ (r110 >>> 32)));
        L17:
            r107 = 1237;
            goto L18
        L13:
            r105 = 1237;
            goto L14
        L9:
            r103 = 1237;
            goto L10
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Config(isSupportMediaAndAlbum=" + this.f334821a + ", autoSync=" + this.f334822b + ", isSaveToGallery=" + this.f334823c + ", recordLocationEnabled=" + this.f334824d + ", locationAlwaysAllowed=" + this.f334825e + ", version=" + this.f334826f + ')';
        }

        public a(boolean r100, boolean r101, boolean r102, boolean r103, boolean r104, long r105) {
            this.f334821a = r100;
            this.f334822b = r101;
            this.f334823c = r102;
            this.f334824d = r103;
            this.f334825e = r104;
            this.f334826f = r105;
        }

        public static a a(a r100, boolean r101, boolean r102, boolean r103, boolean r110, long r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            boolean r104 = r100.f334821a;
        L7:
            if ((r112 & 2) == 0) goto L9;
            r101 = r100.f334822b;
        L9:
            boolean r105 = r101;
            if ((r112 & 4) == 0) goto L12;
            r102 = r100.f334823c;
        L12:
            boolean r106 = r102;
            if ((r112 & 8) == 0) goto L15;
            r103 = r100.f334824d;
        L15:
            boolean r107 = r103;
            if ((r112 & 16) == 0) goto L18;
            r110 = r100.f334825e;
        L18:
            boolean r108 = r110;
            if ((r112 & 32) == 0) goto L21;
            r111 = r100.f334826f;
        L21:
            r100.getClass();
            boolean r109 = r104;
            return new a(r109, r105, r106, r107, r108, r111);
        L5:
            r104 = false;
            goto L7
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.device.settings.media.b$b, reason: collision with other inner class name */
    public static final class C4236b implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4236b f334827a = null;

        static {
            f334827a = new C4236b();
        }

        public C4236b() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4236b) == true) goto L9;
            return false;
        L9:
            C4236b r101 = (C4236b) r100;
            return true;
        }

        public final int hashCode() {
            return 1342660995;
        }

        public final String toString() {
            return "Empty";
        }
    }
}
