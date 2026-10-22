package com.larus.dora.impl.onboarding.othersmart.streamlined;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class n0 {

    public static final class a extends n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f337289a = null;

        static {
            f337289a = new a();
        }

        public a() {
        }
    }

    public static final class b extends n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f337290a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337291b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f337292c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f337290a == r101.f337290a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337291b, r101.f337291b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f337292c, r101.f337292c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f337290a;
            return (((((int) (r100 ^ (r100 >>> 32))) * 31) + this.f337291b.hashCode()) * 31) + this.f337292c.hashCode();
        }

        public final String toString() {
            return "Listening(roundToken=" + this.f337290a + ", source=" + this.f337291b + ", text=" + this.f337292c + ')';
        }

        public b(long r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "source");
            Intrinsics.checkNotNullParameter(r102, "text");
            this.f337290a = r100;
            this.f337291b = r101;
            this.f337292c = r102;
        }
    }

    public static final class c extends n0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f337293a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337294b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f337295c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.f337293a == r101.f337293a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f337294b, r101.f337294b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f337295c, r101.f337295c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f337293a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            String r102 = this.f337294b;
            if (r102 != null) goto L5;
            int r103 = 0;
        L7:
            return ((r101 + r103) * 31) + this.f337295c.hashCode();
        L5:
            r103 = r102.hashCode();
            goto L7
        }

        public final String toString() {
            return "Submitted(roundToken=" + this.f337293a + ", text=" + this.f337294b + ", source=" + this.f337295c + ')';
        }

        public c(long r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r102, "source");
            this.f337293a = r100;
            this.f337294b = r101;
            this.f337295c = r102;
        }
    }

    public n0() {
    }
}
