package com.larus.connector;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface p {

    public static final class a implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f330221a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f330221a, ((a) r100).f330221a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f330221a.hashCode();
        }

        public final String toString() {
            return "Failure(message=" + this.f330221a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "message");
            this.f330221a = r100;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f330222a = null;

        static {
            f330222a = new b();
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
            return -2114366168;
        }

        public final String toString() {
            return "Invalidated";
        }
    }

    public static final class c implements p {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final List<n> f330223a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f330223a, ((c) r100).f330223a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f330223a.hashCode();
        }

        public final String toString() {
            return "Success(items=" + this.f330223a + ')';
        }

        public c(List<n> r100) {
            Intrinsics.checkNotNullParameter(r100, "items");
            this.f330223a = r100;
        }
    }
}
