package com.bytedance.ee.bear.more.protocol3.panel;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public interface i {

    public static final class a implements i {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
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
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof b) == true) goto L9;
            return false;
        L9:
            b r4 = (b) r3;
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
