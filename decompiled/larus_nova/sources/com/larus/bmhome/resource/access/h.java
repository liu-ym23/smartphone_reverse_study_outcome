package com.larus.bmhome.resource.access;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public interface h {

    public static final class a implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f313668a = null;

        static {
            f313668a = new a();
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
            return 1539780799;
        }

        public final String toString() {
            return "Completed";
        }
    }

    public static final class b implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f313669a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313669a, ((b) r100).f313669a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313669a.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.f313669a + ')';
        }

        public b(r r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f313669a = r100;
        }
    }

    public static final class c implements h {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final r f313670a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f313670a, ((c) r100).f313670a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f313670a.hashCode();
        }

        public final String toString() {
            return "FallbackToLocal(reason=" + this.f313670a + ')';
        }

        public c(r r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f313670a = r100;
        }
    }
}
