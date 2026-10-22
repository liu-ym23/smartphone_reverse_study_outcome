package com.bytedance.ee.bear.bitable.anniex.host;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
public interface d {

    public static final class a implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f206744a = null;

        static {
            f206744a = new a();
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
            return 331159039;
        }

        public final String toString() {
            return "Supported";
        }
    }

    public static final class b implements d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f206745a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f206745a, ((b) r100).f206745a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f206745a.hashCode();
        }

        public final String toString() {
            return "Unsupported(reason=" + this.f206745a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f206745a = r100;
        }
    }
}
