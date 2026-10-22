package com.larus.paging;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public abstract class u {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f363919a;

    public static final class a extends u {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f363920b;

        public final int hashCode() {
            if (this.f363919a == false) goto L5;
            int r100 = 1231;
        L7:
            return r100 + this.f363920b.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Error(endOfPaginationReached=" + this.f363919a + ", error=" + this.f363920b + ')';
        }

        public a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            super(false);
            this.f363920b = r100;
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof a) == false) goto L9;
            a r101 = (a) r100;
            if (this.f363919a != r101.f363919a) goto L9;
            if (Intrinsics.areEqual(this.f363920b, r101.f363920b) == false) goto L9;
            return true;
        L9:
            return false;
        }
    }

    public static final class b extends u {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f363921b = null;

        static {
            f363921b = new b();
        }

        public b() {
            super(false);
        }

        public final int hashCode() {
            if (this.f363919a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Loading(endOfPaginationReached=" + this.f363919a + ')';
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof b) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f363919a != ((b) r100).f363919a) goto L7;
            return true;
        }
    }

    public static final class c extends u {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f363922b = null;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final c f363923c = null;

        public static final class a {
        }

        static {
            f363922b = new c(true);
            f363923c = new c(false);
        }

        public final int hashCode() {
            if (this.f363919a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "NotLoading(endOfPaginationReached=" + this.f363919a + ')';
        }

        public c(boolean r100) {
            super(r100);
        }

        public final boolean equals(Object r100) {
            if ((r100 instanceof c) == true) goto L5;
        L7:
            return false;
        L5:
            if (this.f363919a != ((c) r100).f363919a) goto L7;
            return true;
        }
    }

    public u(boolean r100) {
        this.f363919a = r100;
    }
}
