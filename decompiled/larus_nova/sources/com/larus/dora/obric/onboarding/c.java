package com.larus.dora.obric.onboarding;

/* JADX INFO: loaded from: classes27.dex */
public interface c {

    public static final class a implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f340828a = null;

        static {
            f340828a = new a();
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
            return 1920148792;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f340829a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f340829a == ((b) r100).f340829a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f340829a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "State(state=" + this.f340829a + ')';
        }

        public b(boolean r100) {
            this.f340829a = r100;
        }
    }
}
