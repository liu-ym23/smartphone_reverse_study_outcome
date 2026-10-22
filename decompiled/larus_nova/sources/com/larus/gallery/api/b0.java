package com.larus.gallery.api;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class b0<T> {

    public static final class a extends b0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f343836a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f343837b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f343836a, r101.f343836a) == true) goto L12;
            return false;
        L12:
            if (this.f343837b == r101.f343837b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f343836a.hashCode() * 31;
            if (this.f343837b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Error(error=" + this.f343836a + ", hasMore=" + this.f343837b + ')';
        }

        public a(Throwable r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f343836a = r100;
            this.f343837b = r101;
        }
    }

    public static final class b<T> extends b0<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f343838a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f343839b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f343840c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f343838a, r101.f343838a) == true) goto L12;
            return false;
        L12:
            if (this.f343839b == r101.f343839b) goto L15;
            return false;
        L15:
            if (this.f343840c == r101.f343840c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f343838a;
            if (r100 != null) goto L5;
            int r101 = 0;
        L6:
            int r102 = r101 * 31;
            int r103 = 1231;
            if (this.f343839b == false) goto L9;
            int r104 = 1231;
        L10:
            int r105 = (r102 + r104) * 31;
            if (this.f343840c == true) goto L15;
            r103 = 1237;
        L15:
            return r105 + r103;
        L9:
            r104 = 1237;
            goto L10
        L5:
            r101 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Success(data=" + this.f343838a + ", hasMore=" + this.f343839b + ", hasPrevious=" + this.f343840c + ')';
        }

        public b(T r100, boolean r101, boolean r102) {
            this.f343838a = r100;
            this.f343839b = r101;
            this.f343840c = r102;
        }

        public /* synthetic */ b(Object r100, boolean r101, boolean r102, int r103) {
            if ((r103 & 2) == 0) goto L6;
            r101 = false;
        L6:
            if ((r103 & 4) == 0) goto L8;
            r102 = false;
        L8:
            this(r100, r101, r102);
        }
    }

    public b0() {
    }
}
