package com.larus.dora.impl.device.ailab;

/* JADX INFO: loaded from: classes27.dex */
public interface u {

    public static final class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f333573a = null;

        static {
            f333573a = new a();
        }

        public a() {
        }
    }

    public static final class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f333574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f333575b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f333576c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f333577d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final boolean f333578e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final boolean f333579f;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f333574a == r101.f333574a) goto L12;
            return false;
        L12:
            if (this.f333575b == r101.f333575b) goto L15;
            return false;
        L15:
            if (this.f333576c == r101.f333576c) goto L18;
            return false;
        L18:
            if (this.f333577d == r101.f333577d) goto L21;
            return false;
        L21:
            if (this.f333578e == r101.f333578e) goto L24;
            return false;
        L24:
            if (this.f333579f == r101.f333579f) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f333574a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = ((r101 * 31) + this.f333575b) * 31;
            if (this.f333576c == false) goto L9;
            int r103 = 1231;
        L10:
            int r104 = (r102 + r103) * 31;
            if (this.f333577d == false) goto L13;
            int r105 = 1231;
        L14:
            int r106 = (r104 + r105) * 31;
            if (this.f333578e == false) goto L17;
            int r107 = 1231;
        L18:
            int r108 = (r106 + r107) * 31;
            if (this.f333579f == true) goto L23;
            r100 = 1237;
        L23:
            return r108 + r100;
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
            return "V1(voiceWakeEnable=" + this.f333574a + ", sku=" + this.f333575b + ", isSupportDecouplingWakeup=" + this.f333576c + ", precaptureUploadEnable=" + this.f333577d + ", conversationStartEndSound=" + this.f333578e + ", conversationVisualIntentSound=" + this.f333579f + ')';
        }

        public b(boolean r100, int r101, boolean r102, boolean r103, boolean r104, boolean r105) {
            this.f333574a = r100;
            this.f333575b = r101;
            this.f333576c = r102;
            this.f333577d = r103;
            this.f333578e = r104;
            this.f333579f = r105;
        }

        public static b a(b r100, boolean r101, boolean r102, boolean r110, boolean r111, int r112) {
            if ((r112 & 1) == 0) goto L5;
            r101 = r100.f333574a;
        L5:
            boolean r103 = r101;
            if ((r112 & 2) == 0) goto L8;
            int r104 = r100.f333575b;
        L10:
            if ((r112 & 4) == 0) goto L12;
            boolean r105 = r100.f333576c;
        L14:
            if ((r112 & 8) == 0) goto L16;
            r102 = r100.f333577d;
        L16:
            boolean r106 = r102;
            if ((r112 & 16) == 0) goto L19;
            r110 = r100.f333578e;
        L19:
            boolean r107 = r110;
            if ((r112 & 32) == 0) goto L22;
            r111 = r100.f333579f;
        L22:
            r100.getClass();
            return new b(r103, r104, r105, r106, r107, r111);
        L12:
            r105 = false;
            goto L14
        L8:
            r104 = 0;
            goto L10
        }
    }

    public static final class c implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f333580a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f333580a == ((c) r100).f333580a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f333580a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "V2(voiceWakeEnable=" + this.f333580a + ')';
        }

        public c(boolean r100) {
            this.f333580a = r100;
        }
    }
}
