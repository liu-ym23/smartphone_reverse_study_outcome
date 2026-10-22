package com.larus.dora.impl.ota.g;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface x {

    public static final class a implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f337568a = null;

        static {
            f337568a = new a();
        }

        public a() {
        }
    }

    public static final class b implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d49.b f337569a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337569a, ((b) r100).f337569a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337569a.hashCode();
        }

        public final String toString() {
            return "CheckUpdateSuccessAlreadyLatest(device=" + this.f337569a + ')';
        }

        public b(d49.b r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337569a = r100;
        }
    }

    public static final class c implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337570a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337570a, ((c) r100).f337570a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337570a.hashCode();
        }

        public final String toString() {
            return "CheckUpdateSuccessWithNewVersion(responseWrapper=" + this.f337570a + ')';
        }

        public c(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            this.f337570a = r100;
        }
    }

    public static final class d implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f337571a = null;

        static {
            f337571a = new d();
        }

        public d() {
        }
    }

    public static final class e implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337572a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337572a, ((e) r100).f337572a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337572a.hashCode();
        }

        public final String toString() {
            return "CheckingEnvironment(responseWrapper=" + this.f337572a + ')';
        }

        public e(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            this.f337572a = r100;
        }
    }

    public static final class f implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337573a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337573a, ((f) r100).f337573a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337573a.hashCode();
        }

        public final String toString() {
            return "DataTransferFailed(responseWrapper=" + this.f337573a + ')';
        }

        public f(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            this.f337573a = r100;
        }
    }

    public static final class g implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337574a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f337575b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f337574a, r101.f337574a) == true) goto L12;
            return false;
        L12:
            if (this.f337575b == r101.f337575b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f337574a.hashCode() * 31) + this.f337575b;
        }

        public final String toString() {
            return "DataTransferring(responseWrapper=" + this.f337574a + ", progress=" + this.f337575b + ')';
        }

        public g(e49.a r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            this.f337574a = r100;
            this.f337575b = r101;
        }
    }

    public static final class h implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337576a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337576a, ((h) r100).f337576a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337576a.hashCode();
        }

        public final String toString() {
            return "DeviceRestarting(responseWrapper=" + this.f337576a + ')';
        }

        public h(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            this.f337576a = r100;
        }
    }

    public static final class i implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337577a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337577a, ((i) r100).f337577a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337577a.hashCode();
        }

        public final String toString() {
            return "DownloadFailed(responseWrapper=" + this.f337577a + ')';
        }

        public i(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            this.f337577a = r100;
        }
    }

    public static final class j implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337578a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337578a, ((j) r100).f337578a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337578a.hashCode();
        }

        public final String toString() {
            return "DownloadSuccess(responseWrapper=" + this.f337578a + ')';
        }

        public j(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            this.f337578a = r100;
        }
    }

    public static final class k implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f337580b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.f337579a, r101.f337579a) == true) goto L12;
            return false;
        L12:
            if (this.f337580b == r101.f337580b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f337579a.hashCode() * 31) + this.f337580b;
        }

        public final String toString() {
            return "Downloading(responseWrapper=" + this.f337579a + ", progress=" + this.f337580b + ')';
        }

        public k(e49.a r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            this.f337579a = r100;
            this.f337580b = r101;
        }
    }

    public static final class l implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final l f337581a = null;

        static {
            f337581a = new l();
        }

        public l() {
        }
    }

    public static final class m implements x {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final d49.b f337582a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337582a, ((m) r100).f337582a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337582a.hashCode();
        }

        public final String toString() {
            return "OTASuccess(device=" + this.f337582a + ')';
        }

        public m(d49.b r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            this.f337582a = r100;
        }
    }
}
