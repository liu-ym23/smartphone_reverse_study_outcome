package com.larus.connector;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface o {

    public static final class a implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final n f330218a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f330219b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f330218a, r101.f330218a) == true) goto L12;
            return false;
        L12:
            if (this.f330219b == r101.f330219b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f330218a.hashCode() * 31;
            if (this.f330219b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Connector(data=" + this.f330218a + ", isUpdating=" + this.f330219b + ')';
        }

        public a(n r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f330218a = r100;
            this.f330219b = r101;
        }
    }

    public static final class b implements o {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f330220a = null;

        static {
            f330220a = new b();
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
            return -993694389;
        }

        public final String toString() {
            return "Loading";
        }
    }
}
