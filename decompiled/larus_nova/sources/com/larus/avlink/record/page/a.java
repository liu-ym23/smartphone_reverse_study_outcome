package com.larus.avlink.record.page;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes25.dex */
public abstract class a<T> {

    /* JADX INFO: renamed from: com.larus.avlink.record.page.a$a, reason: collision with other inner class name */
    public static final class C4006a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f294206a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Exception f294207b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4006a) == true) goto L8;
            return false;
        L8:
            C4006a r101 = (C4006a) r100;
            if (Intrinsics.areEqual(this.f294206a, r101.f294206a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f294207b, r101.f294207b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f294206a.hashCode() * 31;
            Exception r101 = this.f294207b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Error(message=" + this.f294206a + ", error=" + this.f294207b + ')';
        }

        public C4006a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f294206a = r100;
            this.f294207b = null;
        }
    }

    public static final class b<T> extends a<T> {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final T f294208a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f294208a, ((b) r100).f294208a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            T r100 = this.f294208a;
            if (r100 != null) goto L6;
            return 0;
        L6:
            return r100.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f294208a + ')';
        }

        public b(T r100) {
            this.f294208a = r100;
        }
    }

    public a() {
    }
}
