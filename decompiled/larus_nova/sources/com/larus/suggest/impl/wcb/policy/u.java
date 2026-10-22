package com.larus.suggest.impl.wcb.policy;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface u {

    public static final class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f370006a = null;

        static {
            f370006a = new a();
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
            return -1509489827;
        }

        public final String toString() {
            return "Accepted";
        }
    }

    public static final class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f370007a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final boolean f370008b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.f370007a, r101.f370007a) == true) goto L12;
            return false;
        L12:
            if (this.f370008b == r101.f370008b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f370007a.hashCode() * 31;
            if (this.f370008b == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Rejected(reason=" + this.f370007a + ", monitor=" + this.f370008b + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f370007a = r100;
            this.f370008b = true;
        }
    }
}
