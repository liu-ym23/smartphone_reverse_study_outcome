package com.bytedance.ee.bear.more.protocol3.panel;

/* JADX INFO: loaded from: classes18.dex */
public interface i {

    public static final class a implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f234979a = null;

        static {
            f234979a = new a();
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
            return 422090586;
        }

        public final String toString() {
            return "Consumed";
        }
    }

    public static final class b implements i {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f234980a = null;

        static {
            f234980a = new b();
        }

        public b() {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return 1751104084;
        }

        public final String toString() {
            return "Fallback";
        }
    }
}
