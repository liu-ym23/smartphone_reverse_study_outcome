package com.larus.dora.impl.core.request.v2;

import java.util.Arrays;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a {

    /* JADX INFO: renamed from: com.larus.dora.impl.core.request.v2.a$a, reason: collision with other inner class name */
    public static final class C4213a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Throwable f332255a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4213a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f332255a, ((C4213a) r100).f332255a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f332255a.hashCode();
        }

        public final String toString() {
            return "Failed(error=" + this.f332255a + ')';
        }

        public C4213a(Throwable r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f332255a = r100;
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final byte[] f332256a;

        public final String toString() {
            return "Success(data=" + Arrays.toString(this.f332256a) + ')';
        }

        public final int hashCode() {
            return Arrays.hashCode(this.f332256a);
        }

        public b(byte[] r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f332256a = r100;
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if (r100 == null) goto L8;
            Class<?> r101 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(b.class, r101) == true) goto L13;
            return false;
        L13:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.larus.dora.impl.core.request.v2.DoraRemoteResponseV2.Success");
            return Arrays.equals(this.f332256a, ((b) r100).f332256a);
        L8:
            r101 = null;
            goto L10
        }
    }
}
