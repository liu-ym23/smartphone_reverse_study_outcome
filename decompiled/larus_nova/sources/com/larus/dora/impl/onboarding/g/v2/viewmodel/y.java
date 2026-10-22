package com.larus.dora.impl.onboarding.g.v2.viewmodel;

/* JADX INFO: loaded from: classes27.dex */
public interface y {

    public static final class a implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f336832a = null;

        static {
            f336832a = new a();
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
            return 281866213;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements y {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f336833a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f336834b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f336833a == r101.f336833a) goto L12;
            return false;
        L12:
            if (this.f336834b == r101.f336834b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f336833a == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.f336834b;
            return (r100 * 31) + ((int) (r101 ^ (r101 >>> 32)));
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "State(state=" + this.f336833a + ", ts=" + this.f336834b + ')';
        }

        public b(boolean r100, long r101) {
            this.f336833a = r100;
            this.f336834b = r101;
        }
    }
}
