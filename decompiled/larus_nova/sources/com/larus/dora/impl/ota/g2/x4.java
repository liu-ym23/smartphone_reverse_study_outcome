package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface x4 {

    public static final class a implements x4 {
        private final e5 pkg;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.pkg, ((a) r100).pkg) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.pkg.hashCode();
        }

        public final String toString() {
            return "Available(pkg=" + this.pkg + ')';
        }

        public final e5 a() {
            return this.pkg;
        }

        public a(e5 r100) {
            Intrinsics.checkNotNullParameter(r100, "pkg");
            this.pkg = r100;
        }
    }

    public static final class b implements x4 {
        private final FailureReason reason;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.reason == ((b) r100).reason) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.reason.hashCode();
        }

        public final String toString() {
            return "Failed(reason=" + this.reason + ')';
        }

        public final FailureReason a() {
            return this.reason;
        }

        public b(FailureReason r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.reason = r100;
        }
    }

    public static final class c implements x4 {
        public static final c INSTANCE = null;

        static {
            INSTANCE = new c();
        }

        public c() {
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
            return 637286237;
        }

        public final String toString() {
            return "NoUpdate";
        }
    }
}
