package com.larus.im.internal.network.sse;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f349520a = 0;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f349521a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f349522b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final long f349523c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f349524d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f349525e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f349526f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f349527g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final String f349528h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final int f349529i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f349521a == r101.f349521a) goto L12;
            return false;
        L12:
            if (this.f349522b == r101.f349522b) goto L15;
            return false;
        L15:
            if (this.f349523c == r101.f349523c) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f349524d, r101.f349524d) == true) goto L21;
            return false;
        L21:
            if (this.f349525e == r101.f349525e) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f349526f, r101.f349526f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f349527g, r101.f349527g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f349528h, r101.f349528h) == true) goto L33;
            return false;
        L33:
            if (this.f349529i == r101.f349529i) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f349521a * 31) + this.f349522b) * 31;
            long r101 = this.f349523c;
            return ((((((((((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f349524d.hashCode()) * 31) + this.f349525e) * 31) + this.f349526f.hashCode()) * 31) + this.f349527g.hashCode()) * 31) + this.f349528h.hashCode()) * 31) + this.f349529i;
        }

        public final String toString() {
            return "ChunkEndInfo(status=" + this.f349521a + ", count=" + this.f349522b + ", duration=" + this.f349523c + ", errorDesc=" + this.f349524d + ", errorCode=" + this.f349525e + ", binaryType=" + this.f349526f + ", logId=" + this.f349527g + ", requestPath=" + this.f349528h + ", statusCode=" + this.f349529i + ')';
        }

        public a(int r100, int r101, long r102, String r103, int r104, String r105, String r110, int r111) {
            Intrinsics.checkNotNullParameter(r103, "errorDesc");
            Intrinsics.checkNotNullParameter("json", "binaryType");
            Intrinsics.checkNotNullParameter(r105, "logId");
            Intrinsics.checkNotNullParameter(r110, "requestPath");
            this.f349521a = r100;
            this.f349522b = r101;
            this.f349523c = r102;
            this.f349524d = r103;
            this.f349525e = r104;
            this.f349526f = "json";
            this.f349527g = r105;
            this.f349528h = r110;
            this.f349529i = r111;
        }
    }

    static {
    }
}
