package com.larus.dora.impl.device.settings.camera;

/* JADX INFO: loaded from: classes27.dex */
public interface f {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f334288a = null;

        static {
            f334288a = new a();
        }

        public a() {
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f334289a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f334290b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f334289a == r101.f334289a) goto L12;
            return false;
        L12:
            if (this.f334290b == r101.f334290b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = 1231;
            if (this.f334289a == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = r101 * 31;
            if (this.f334290b == true) goto L11;
            r100 = 1237;
        L11:
            return r102 + r100;
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "Success(isTakeImageEnabled=" + this.f334289a + ", isBurstTakeImageEnabled=" + this.f334290b + ')';
        }

        public b(boolean r100, boolean r101) {
            this.f334289a = r100;
            this.f334290b = r101;
        }
    }
}
