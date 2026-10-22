package com.larus.contextwindow.impl.membership;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface d {

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f330380a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f330380a, ((a) r100).f330380a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f330380a.hashCode();
        }

        public final String toString() {
            return "Eligible(accountId=" + this.f330380a + ')';
        }

        public a(String r100) {
            Intrinsics.checkNotNullParameter(r100, "accountId");
            this.f330380a = r100;
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f330381a = null;

        static {
            f330381a = new b();
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
            return 1409302406;
        }

        public final String toString() {
            return "Skipped";
        }
    }
}
