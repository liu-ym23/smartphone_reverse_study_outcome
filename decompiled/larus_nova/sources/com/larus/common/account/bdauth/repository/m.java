package com.larus.common.account.bdauth.repository;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class m {

    public static final class a extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.common.account.bdauth.repository.b f325953a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325953a, ((a) r100).f325953a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325953a.hashCode();
        }

        public final String toString() {
            return "AccountIssue(issue=" + this.f325953a + ')';
        }

        public a(com.larus.common.account.bdauth.repository.b r100) {
            Intrinsics.checkNotNullParameter(r100, "issue");
            this.f325953a = r100;
        }
    }

    public static final class b extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb7.d f325954a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325954a, ((b) r100).f325954a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325954a.hashCode();
        }

        public final String toString() {
            return "Failure(response=" + this.f325954a + ')';
        }

        public b(fb7.d r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f325954a = r100;
        }
    }

    public static final class c extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f325955a = null;

        static {
            f325955a = new c();
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
            return -1659379619;
        }

        public final String toString() {
            return "NeedLogin";
        }

        public c() {
        }
    }

    public static final class d extends m {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb7.d f325956a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325956a, ((d) r100).f325956a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325956a.hashCode();
        }

        public final String toString() {
            return "Success(response=" + this.f325956a + ')';
        }

        public d(fb7.d r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f325956a = r100;
        }
    }

    public m() {
    }
}
