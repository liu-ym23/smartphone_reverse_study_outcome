package com.larus.dora.impl.onboarding.g.v2.viewmodel;

/* JADX INFO: loaded from: classes27.dex */
public interface n {

    public static final class a implements n {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f336822a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f336823b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f336824c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f336822a == r101.f336822a) goto L12;
            return false;
        L12:
            if (this.f336823b == r101.f336823b) goto L15;
            return false;
        L15:
            if (this.f336824c == r101.f336824c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f336822a * 31) + this.f336823b) * 31;
            long r101 = this.f336824c;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "State(event=" + this.f336822a + ", pos=" + this.f336823b + ", ts=" + this.f336824c + ')';
        }

        public a(int r100, int r101, long r102) {
            this.f336822a = r100;
            this.f336823b = r101;
            this.f336824c = r102;
        }
    }
}
