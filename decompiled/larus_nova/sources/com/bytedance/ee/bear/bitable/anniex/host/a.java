package com.bytedance.ee.bear.bitable.anniex.host;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public interface a<T> {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.bitable.anniex.host.a$a, reason: collision with other inner class name */
    public static final class C2983a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f206738a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f206739b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C2983a) == true) goto L8;
            return false;
        L8:
            C2983a r101 = (C2983a) r100;
            if (Intrinsics.areEqual(this.f206738a, r101.f206738a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f206739b, r101.f206739b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f206738a.hashCode() * 31;
            Throwable r101 = this.f206739b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failure(message=" + this.f206738a + ", cause=" + this.f206739b + ')';
        }

        public C2983a(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f206738a = r100;
            this.f206739b = r101;
        }
    }

    public static final class b<T> implements a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f206740a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f206740a, ((b) r100).f206740a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f206740a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(value=" + this.f206740a + ')';
        }

        public b(T r100) {
            this.f206740a = r100;
        }
    }

    public static final class c implements a {
        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            ((c) r100).getClass();
            if (Intrinsics.areEqual(null, null) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            throw null;
        }

        public final String toString() {
            return "Unavailable(message=null)";
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f206741a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f206741a, ((d) r100).f206741a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f206741a.hashCode();
        }

        public final String toString() {
            return "Unsupported(message=" + this.f206741a + ')';
        }

        public d(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f206741a = r100;
        }
    }
}
