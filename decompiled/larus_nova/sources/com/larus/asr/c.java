package com.larus.asr;

/* JADX INFO: loaded from: classes24.dex */
public final class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Object f287204a = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f287205a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f287206b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f287207c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final boolean f287208d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f287205a == r101.f287205a) goto L12;
            return false;
        L12:
            if (this.f287206b == r101.f287206b) goto L15;
            return false;
        L15:
            if (this.f287207c == r101.f287207c) goto L18;
            return false;
        L18:
            if (this.f287208d == r101.f287208d) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f287205a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            int r102 = 1231;
            if (this.f287206b == false) goto L5;
            int r103 = 1231;
        L6:
            int r104 = (r101 + r103) * 31;
            if (this.f287207c == false) goto L9;
            int r105 = 1231;
        L10:
            int r106 = (r104 + r105) * 31;
            if (this.f287208d == true) goto L15;
            r102 = 1237;
        L15:
            return r106 + r102;
        L9:
            r105 = 1237;
            goto L10
        L5:
            r103 = 1237;
            goto L6
        }

        public final String toString() {
            return "Result(sizeBytes=" + this.f287205a + ", deleted=" + this.f287206b + ", plaintextAbsent=" + this.f287207c + ", encryptedAfterDeleteFailure=" + this.f287208d + ')';
        }

        public a(long r100, boolean r101, boolean r102, boolean r103) {
            this.f287205a = r100;
            this.f287206b = r101;
            this.f287207c = r102;
            this.f287208d = r103;
        }
    }

    static {
        f287204a = new Object();
    }
}
