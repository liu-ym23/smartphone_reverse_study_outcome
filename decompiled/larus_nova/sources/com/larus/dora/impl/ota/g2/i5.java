package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface i5 {

    public static final class a implements i5 {
        public static final a INSTANCE = null;

        static {
            INSTANCE = new a();
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
            return -428676707;
        }

        public final String toString() {
            return "Buffer";
        }
    }

    public static final class b implements i5 {
        public static final b INSTANCE = null;

        static {
            INSTANCE = new b();
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
            return -362399860;
        }

        public final String toString() {
            return "Drop";
        }
    }

    public static final class c implements i5 {
        private final t4 owner;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.owner, ((c) r100).owner) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.owner.hashCode();
        }

        public final String toString() {
            return "Route(owner=" + this.owner + ')';
        }

        public final t4 a() {
            return this.owner;
        }

        public c(t4 r100) {
            Intrinsics.checkNotNullParameter(r100, "owner");
            this.owner = r100;
        }
    }
}
