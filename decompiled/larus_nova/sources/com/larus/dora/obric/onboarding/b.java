package com.larus.dora.obric.onboarding;

/* JADX INFO: loaded from: classes27.dex */
public interface b {

    public static final class a implements b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f340821a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f340822b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f340823c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f340821a == r101.f340821a) goto L12;
            return false;
        L12:
            if (this.f340822b == r101.f340822b) goto L15;
            return false;
        L15:
            if (this.f340823c == r101.f340823c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f340821a * 31) + this.f340822b) * 31;
            long r101 = this.f340823c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "State(event=" + this.f340821a + ", pos=" + this.f340822b + ", ts=" + this.f340823c + ')';
        }

        public a(int r100, int r101, long r102) {
            this.f340821a = r100;
            this.f340822b = r101;
            this.f340823c = r102;
        }
    }
}
