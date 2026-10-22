package com.larus.dora.obric.onboarding;

/* JADX INFO: loaded from: classes27.dex */
public interface f {

    public static final class a implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f340850a = null;

        static {
            f340850a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return -526532461;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f340851a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f340852b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f340851a == r101.f340851a) goto L12;
            return false;
        L12:
            if (this.f340852b == r101.f340852b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f340851a == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.f340852b;
            return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "State(state=" + this.f340851a + ", ts=" + this.f340852b + ')';
        }

        public b(boolean r100, long r101) {
            this.f340851a = r100;
            this.f340852b = r101;
        }
    }
}
