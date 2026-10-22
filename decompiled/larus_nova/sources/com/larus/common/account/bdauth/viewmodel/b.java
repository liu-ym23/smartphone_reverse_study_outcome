package com.larus.common.account.bdauth.viewmodel;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class b {

    public static final class a extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.common.account.bdauth.repository.a f325980a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325980a, ((a) r100).f325980a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325980a.hashCode();
        }

        public final String toString() {
            return "AccountClicked(account=" + this.f325980a + ')';
        }

        public a(com.larus.common.account.bdauth.repository.a r100) {
            Intrinsics.checkNotNullParameter(r100, "account");
            this.f325980a = r100;
        }
    }

    /* JADX INFO: renamed from: com.larus.common.account.bdauth.viewmodel.b$b, reason: collision with other inner class name */
    public static final class C4178b extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4178b f325981a = null;

        static {
            f325981a = new C4178b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4178b) == true) goto L9;
            return false;
        L9:
            C4178b r101 = (C4178b) r100;
            return true;
        }

        public final int hashCode() {
            return 1917944179;
        }

        public final String toString() {
            return "NeedLogin";
        }

        public C4178b() {
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f325982a = null;

        static {
            f325982a = new c();
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
            return -917564618;
        }

        public final String toString() {
            return "OpenAddAccount";
        }

        public c() {
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb7.d f325983a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325983a, ((d) r100).f325983a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325983a.hashCode();
        }

        public final String toString() {
            return "SendCancel(response=" + this.f325983a + ')';
        }

        public d(fb7.d r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f325983a = r100;
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb7.d f325984a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325984a, ((e) r100).f325984a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325984a.hashCode();
        }

        public final String toString() {
            return "SendError(response=" + this.f325984a + ')';
        }

        public e(fb7.d r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f325984a = r100;
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final fb7.d f325985a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325985a, ((f) r100).f325985a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325985a.hashCode();
        }

        public final String toString() {
            return "SendSuccess(response=" + this.f325985a + ')';
        }

        public f(fb7.d r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f325985a = r100;
        }
    }

    public static final class g extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.common.account.bdauth.repository.b f325986a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325986a, ((g) r100).f325986a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325986a.hashCode();
        }

        public final String toString() {
            return "ShowAccountIssue(issue=" + this.f325986a + ')';
        }

        public g(com.larus.common.account.bdauth.repository.b r100) {
            Intrinsics.checkNotNullParameter(r100, "issue");
            this.f325986a = r100;
        }
    }

    public static final class h extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.common.account.bdauth.repository.a f325987a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325987a, ((h) r100).f325987a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325987a.hashCode();
        }

        public final String toString() {
            return "ShowAccountSuccess(account=" + this.f325987a + ')';
        }

        public h(com.larus.common.account.bdauth.repository.a r100) {
            Intrinsics.checkNotNullParameter(r100, "account");
            this.f325987a = r100;
        }
    }

    public static final class i extends b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.common.account.bdauth.repository.d f325988a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f325988a, ((i) r100).f325988a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f325988a.hashCode();
        }

        public final String toString() {
            return "ShowBlockingError(error=" + this.f325988a + ')';
        }

        public i(com.larus.common.account.bdauth.repository.d r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f325988a = r100;
        }
    }

    public b() {
    }
}
