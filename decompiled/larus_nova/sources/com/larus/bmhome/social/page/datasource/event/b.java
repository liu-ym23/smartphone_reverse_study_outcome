package com.larus.bmhome.social.page.datasource.event;

/* JADX INFO: loaded from: classes26.dex */
public abstract class b {

    public static final class a extends b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            ((a) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "ItemsInserted : 0 , 0";
        }
    }

    /* JADX INFO: renamed from: com.larus.bmhome.social.page.datasource.event.b$b, reason: collision with other inner class name */
    public static final class C4102b extends b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4102b) == true) goto L9;
            return false;
        L9:
            ((C4102b) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "ItemsRemoved : 0 0";
        }
    }

    public static final class c extends b {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            ((c) r100).getClass();
            return true;
        }

        public final int hashCode() {
            return 0;
        }

        public final String toString() {
            return "ItemsUpdate : 0 , 0";
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f314032a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f314032a == ((d) r100).f314032a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.f314032a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "RefreshAll : " + this.f314032a;
        }

        public d(boolean r100) {
            this.f314032a = r100;
        }
    }

    public b() {
    }
}
