package com.ss.android.ainote;

/* JADX INFO: loaded from: classes34.dex */
public abstract class j0 {

    public static final class a extends j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f406828a = null;

        static {
            f406828a = new a();
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
            return -5522167;
        }

        public final String toString() {
            return "ClearLocally";
        }

        public a() {
        }
    }

    public static final class b extends j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f406829a = null;

        static {
            f406829a = new b();
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
            return 433232432;
        }

        public final String toString() {
            return "Ignore";
        }

        public b() {
        }
    }

    public static final class c extends j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f406830a = null;

        static {
            f406830a = new c();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return -51758593;
        }

        public final String toString() {
            return "RefreshSilently";
        }

        public c() {
        }
    }

    public static final class d extends j0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f406831a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final AINoteUserVisibleError f406832b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f406831a == r101.f406831a) goto L12;
            return false;
        L12:
            if (this.f406832b == r101.f406832b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            if (this.f406831a == false) goto L5;
            int r100 = 1231;
        L6:
            int r101 = r100 * 31;
            AINoteUserVisibleError r102 = this.f406832b;
            if (r102 != null) goto L9;
            int r103 = 0;
        L11:
            return r101 + r103;
        L9:
            r103 = r102.hashCode();
            goto L11
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "RestoreAndRefresh(keepPendingCommit=" + this.f406831a + ", userVisibleError=" + this.f406832b + ')';
        }

        public d(boolean r100, AINoteUserVisibleError r101) {
            this.f406831a = r100;
            this.f406832b = r101;
        }
    }

    public j0() {
    }
}
