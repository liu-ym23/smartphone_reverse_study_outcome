package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class o0 {

    public static final class a extends o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f337300a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337301b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f337300a == r101.f337300a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337301b, r101.f337301b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f337300a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f337301b.hashCode();
        }

        public final String toString() {
            return "Completed(roundToken=" + this.f337300a + ", text=" + this.f337301b + ')';
        }

        public a(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "text");
            this.f337300a = r100;
            this.f337301b = r101;
        }
    }

    public static final class b extends o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f337302a = null;

        static {
            f337302a = new b();
        }

        public b() {
        }
    }

    public static final class c extends o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f337303a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337304b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f337303a == r101.f337303a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337304b, r101.f337304b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f337303a;
            return (((int) (r100 ^ (r100 >>> 32))) * 31) + this.f337304b.hashCode();
        }

        public final String toString() {
            return "Loading(roundToken=" + this.f337303a + ", placeholderText=" + this.f337304b + ')';
        }

        public c(long r100, String r101) {
            Intrinsics.checkNotNullParameter(r101, "placeholderText");
            this.f337303a = r100;
            this.f337304b = r101;
        }
    }

    public static final class d extends o0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f337305a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337306b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f337307c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (this.f337305a == r101.f337305a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337306b, r101.f337306b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f337307c, r101.f337307c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f337305a;
            return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f337306b.hashCode()) * 31) + this.f337307c.hashCode();
        }

        public final String toString() {
            return "Typing(roundToken=" + this.f337305a + ", fullText=" + this.f337306b + ", displayedText=" + this.f337307c + ')';
        }

        public d(long r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "fullText");
            Intrinsics.checkNotNullParameter(r102, "displayedText");
            this.f337305a = r100;
            this.f337306b = r101;
            this.f337307c = r102;
        }
    }

    public o0() {
    }
}
