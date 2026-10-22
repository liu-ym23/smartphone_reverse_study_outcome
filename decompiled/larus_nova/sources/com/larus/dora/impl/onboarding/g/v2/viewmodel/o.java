package com.larus.dora.impl.onboarding.g.v2.viewmodel;

/* JADX INFO: loaded from: classes27.dex */
public interface o {

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f336825a = null;

        static {
            f336825a = new a();
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
            return -1566419830;
        }

        public final String toString() {
            return "Empty";
        }
    }

    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f336826a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f336826a == ((b) r100).f336826a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f336826a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "State(state=" + this.f336826a + ')';
        }

        public b(boolean r100) {
            this.f336826a = r100;
        }
    }
}
