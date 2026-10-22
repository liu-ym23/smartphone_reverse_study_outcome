package com.larus.canvas.service.internal.sse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class d {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f323863a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f323864a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f323865b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f323866c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f323867d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f323868e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f323869f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f323870g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f323871h;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f323864a == r101.f323864a) goto L12;
            return false;
        L12:
            if (this.f323865b == r101.f323865b) goto L15;
            return false;
        L15:
            if (this.f323866c == r101.f323866c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f323867d, r101.f323867d) == true) goto L21;
            return false;
        L21:
            if (this.f323868e == r101.f323868e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f323869f, r101.f323869f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f323870g, r101.f323870g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f323871h, r101.f323871h) == true) goto L32;
            return false;
        L32:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f323864a * 31) + this.f323865b) * 31;
            long r101 = this.f323866c;
            return ((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f323867d.hashCode()) * 31) + this.f323868e) * 31) + this.f323869f.hashCode()) * 31) + this.f323870g.hashCode()) * 31) + this.f323871h.hashCode();
        }

        public final String toString() {
            return "ChunkEndInfo(status=" + this.f323864a + ", count=" + this.f323865b + ", duration=" + this.f323866c + ", errorDesc=" + this.f323867d + ", errorCode=" + this.f323868e + ", binaryType=" + this.f323869f + ", logId=" + this.f323870g + ", requestPath=" + this.f323871h + ')';
        }

        public a(int r100, int r101, long r102, String r103, int r104, String r105, String r110) {
            Intrinsics.checkNotNullParameter(r103, "errorDesc");
            Intrinsics.checkNotNullParameter("json", "binaryType");
            Intrinsics.checkNotNullParameter(r105, "logId");
            Intrinsics.checkNotNullParameter(r110, "requestPath");
            this.f323864a = r100;
            this.f323865b = r101;
            this.f323866c = r102;
            this.f323867d = r103;
            this.f323868e = r104;
            this.f323869f = "json";
            this.f323870g = r105;
            this.f323871h = r110;
        }
    }

    static {
    }
}
