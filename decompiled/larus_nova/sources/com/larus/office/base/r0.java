package com.larus.office.base;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes29.dex */
public final class r0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f361056a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f361057a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OfficeSdkLoginType f361058b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final int f361059c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f361060d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f361061e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f361057a, r101.f361057a) == true) goto L12;
            return false;
        L12:
            if (this.f361058b == r101.f361058b) goto L15;
            return false;
        L15:
            if (this.f361059c == r101.f361059c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f361060d, r101.f361060d) == true) goto L21;
            return false;
        L21:
            if (this.f361061e == r101.f361061e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            return (((((((this.f361057a.hashCode() * 31) + this.f361058b.hashCode()) * 31) + this.f361059c) * 31) + this.f361060d.hashCode()) * 31) + this.f361061e;
        }

        public final String toString() {
            return "CategoryData(source=" + this.f361057a + ", loginType=" + this.f361058b + ", loginRetryCount=" + this.f361059c + ", tokenSource=" + this.f361060d + ", warmupHit=" + this.f361061e + ')';
        }

        public a(String r100, OfficeSdkLoginType r101, String r102) {
            Intrinsics.checkNotNullParameter(r100, "source");
            Intrinsics.checkNotNullParameter(r101, "loginType");
            Intrinsics.checkNotNullParameter(r102, "tokenSource");
            this.f361057a = r100;
            this.f361058b = r101;
            this.f361059c = 0;
            this.f361060d = r102;
            this.f361061e = 0;
        }
    }

    public static final class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f361062a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f361063b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f361064c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f361065d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final long f361066e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final long f361067f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final long f361068g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final boolean f361069h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (this.f361062a == r101.f361062a) goto L12;
            return false;
        L12:
            if (this.f361063b == r101.f361063b) goto L15;
            return false;
        L15:
            if (this.f361064c == r101.f361064c) goto L18;
            return false;
        L18:
            if (this.f361065d == r101.f361065d) goto L21;
            return false;
        L21:
            if (this.f361066e == r101.f361066e) goto L24;
            return false;
        L24:
            if (this.f361067f == r101.f361067f) goto L27;
            return false;
        L27:
            if (this.f361068g == r101.f361068g) goto L30;
            return false;
        L30:
            if (this.f361069h == r101.f361069h) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f361062a;
            int r101 = ((int) (r100 ^ (r100 >>> 32))) * 31;
            long r102 = this.f361063b;
            int r103 = (r101 + ((int) (r102 ^ (r102 >>> 32)))) * 31;
            long r104 = this.f361064c;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.f361065d;
            int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
            long r108 = this.f361066e;
            int r109 = (r107 + ((int) (r108 ^ (r108 >>> 32)))) * 31;
            long r110 = this.f361067f;
            int r111 = (r109 + ((int) (r110 ^ (r110 >>> 32)))) * 31;
            long r112 = this.f361068g;
            int r113 = (r111 + ((int) (r112 ^ (r112 >>> 32)))) * 31;
            if (this.f361069h == false) goto L5;
            int r114 = 1231;
        L7:
            return r113 + r114;
        L5:
            r114 = 1237;
            goto L7
        }

        public final String toString() {
            return "MetricData(initDurationMs=" + this.f361062a + ", globalContainerDurationMs=" + this.f361063b + ", userContainerDurationMs=" + this.f361064c + ", tokenDurationMs=" + this.f361065d + ", loginSdkDurationMs=" + this.f361066e + ", loginLastSdkDurationMs=" + this.f361067f + ", loginDurationMs=" + this.f361068g + ", loginSuccess=" + this.f361069h + ')';
        }

        public b(long r100, long r101, long r102, long r103, long r104, long r110, long r111, boolean r112) {
            this.f361062a = r100;
            this.f361063b = r101;
            this.f361064c = r102;
            this.f361065d = r103;
            this.f361066e = r104;
            this.f361067f = r110;
            this.f361068g = r111;
            this.f361069h = r112;
        }
    }

    static {
    }
}
