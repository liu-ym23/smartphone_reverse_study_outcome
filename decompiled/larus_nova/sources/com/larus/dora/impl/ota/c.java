package com.larus.dora.impl.ota;

/* JADX INFO: loaded from: classes27.dex */
public interface c extends j69.c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f337426a = null;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final String f337427b = null;

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
            return 530578543;
        }

        public final String toString() {
            return "Next";
        }

        static {
            f337426a = new a();
            f337427b = "NEXT";
        }

        @Override // j69.c
        public final String a() {
            return f337427b;
        }
    }
}
