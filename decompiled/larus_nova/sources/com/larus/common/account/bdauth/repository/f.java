package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class f {

    public static final class a extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.common.account.bdauth.repository.d f325946a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325946a, ((a) r100).f325946a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325946a.hashCode();
        }

        public final String toString() {
            return "BlockingError(error=" + this.f325946a + ')';
        }

        public a(com.larus.common.account.bdauth.repository.d r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f325946a = r100;
        }
    }

    public static final class b extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb7.d f325947a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325947a, ((b) r100).f325947a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325947a.hashCode();
        }

        public final String toString() {
            return "Failure(response=" + this.f325947a + ')';
        }

        public b(fb7.d r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f325947a = r100;
        }
    }

    public static final class c extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f325948a = null;

        static {
            f325948a = new c();
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
            return 1731732198;
        }

        public final String toString() {
            return "NeedLogin";
        }

        public c() {
        }
    }

    public static final class d extends f {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e f325949a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325949a, ((d) r100).f325949a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325949a.hashCode();
        }

        public final String toString() {
            return "Success(data=" + this.f325949a + ')';
        }

        public d(e r100) {
            Intrinsics.checkNotNullParameter(r100, "data");
            this.f325949a = r100;
        }
    }

    public f() {
    }
}
