package com.larus.bmhome.chat.messagetransfer;

/* JADX INFO: loaded from: classes25.dex */
public abstract class g {

    public static final class a extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f307339a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f307339a == ((a) r100).f307339a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f307339a;
        }

        public final String toString() {
            return "SelectCountLimit(selectCount=" + this.f307339a + ')';
        }

        public a(int r100) {
            this.f307339a = r100;
        }
    }

    public static final class b extends g {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f307340a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f307340a == ((b) r100).f307340a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f307340a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "SizeLimit(selectSizeBytes=" + this.f307340a + ')';
        }

        public b(long r100) {
            this.f307340a = r100;
        }
    }

    public g() {
    }
}
