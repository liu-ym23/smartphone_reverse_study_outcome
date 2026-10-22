package com.larus.suggest.impl.wcb.policy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface s {

    public static final class a implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f370004a = null;

        static {
            f370004a = new a();
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
            return 1478277549;
        }

        public final String toString() {
            return "Accepted";
        }
    }

    public static final class b implements s {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370005a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f370005a, ((b) r100).f370005a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f370005a.hashCode();
        }

        public final String toString() {
            return "Rejected(reason=" + this.f370005a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f370005a = r100;
        }
    }
}
