package com.larus.share.service;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public interface j {

    public static final class a implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Long f368934a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f368935b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Throwable f368936c;

        /* JADX WARN: Multi-variable type inference failed */
        public a() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 7);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f368934a, r101.f368934a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f368935b, r101.f368935b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f368936c, r101.f368936c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Long r100 = this.f368934a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f368935b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            Throwable r107 = this.f368936c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Failed(code=" + this.f368934a + ", message=" + this.f368935b + ", cause=" + this.f368936c + ')';
        }

        public /* synthetic */ a(String r100, Throwable r101, int r102) {
            if ((r102 & 2) == 0) goto L6;
            r100 = null;
        L6:
            if ((r102 & 4) == 0) goto L8;
            r101 = null;
        L8:
            this(null, r100, r101);
        }

        public a(Long r100, String r101, Throwable r102) {
            this.f368934a = r100;
            this.f368935b = r101;
            this.f368936c = r102;
        }
    }

    public static final class b implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f368937a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f368937a, ((b) r100).f368937a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f368937a.hashCode();
        }

        public final String toString() {
            return "Success(url=" + this.f368937a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "url");
            this.f368937a = r100;
        }
    }

    public static final class c implements j {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f368938a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (this.f368938a == ((c) r100).f368938a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f368938a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "Timeout(timeoutMs=" + this.f368938a + ')';
        }

        public c(long r100) {
            this.f368938a = r100;
        }
    }
}
