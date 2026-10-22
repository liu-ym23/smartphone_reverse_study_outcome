package com.bytedance.ee.bear.document.plugin.selection;

/* JADX INFO: loaded from: classes16.dex */
public final class j {

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f220936a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f220937b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f220938c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f220936a == r101.f220936a) goto L12;
            return false;
        L12:
            if (this.f220937b == r101.f220937b) goto L15;
            return false;
        L15:
            if (this.f220938c == r101.f220938c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f220936a * 31) + this.f220937b) * 31;
            if (this.f220938c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "AnimatorParams(speed=" + this.f220936a + ", scrollDirection=" + this.f220937b + ", isHandle=" + this.f220938c + ')';
        }

        public a(int r100, int r101) {
            this.f220936a = r100;
            this.f220937b = r101;
            this.f220938c = false;
        }
    }

    public j() {
    }
}
