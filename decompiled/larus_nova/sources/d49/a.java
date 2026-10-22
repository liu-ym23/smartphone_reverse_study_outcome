package d49;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final e49.a f466836a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f466837b;

    /* JADX INFO: renamed from: d49.a$a, reason: collision with other inner class name */
    public static final class C5632a extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final C5632a f466838c = null;

        static {
            f466838c = new C5632a();
        }

        public C5632a() {
            super(null, true);
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d49.b f466839c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f466839c, ((b) r100).f466839c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f466839c.hashCode();
        }

        public final String toString() {
            return "CheckUpdateSuccessAlreadyLatest(device=" + this.f466839c + ')';
        }

        public b(d49.b r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            super(null, true);
            this.f466839c = r100;
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466840c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f466840c, ((c) r100).f466840c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f466840c.hashCode();
        }

        public final String toString() {
            return "CheckUpdateSuccessWithNewVersion(responseWrapper=" + this.f466840c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466840c;
        }

        public c(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, true);
            this.f466840c = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final d f466841c = null;

        static {
            f466841c = new d();
        }

        public d() {
            super(null, true);
        }
    }

    public static final class e extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466842c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f466842c, ((e) r100).f466842c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f466842c.hashCode();
        }

        public final String toString() {
            return "CheckingBeforeDataTransfer(responseWrapper=" + this.f466842c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466842c;
        }

        public e(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, false);
            this.f466842c = r100;
        }
    }

    public static final class f extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466843c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f466843c, ((f) r100).f466843c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f466843c.hashCode();
        }

        public final String toString() {
            return "CheckingBeforeDownload(responseWrapper=" + this.f466843c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466843c;
        }

        public f(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, false);
            this.f466843c = r100;
        }
    }

    public static final class g extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466844c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f466845d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.f466844c, r101.f466844c) == true) goto L12;
            return false;
        L12:
            if (this.f466845d == r101.f466845d) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f466844c.hashCode() * 31;
            long r101 = this.f466845d;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "DataTransferSuccess(responseWrapper=" + this.f466844c + ", dataTransferId=" + this.f466845d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466844c;
        }

        public g(e49.a r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, false);
            this.f466844c = r100;
            this.f466845d = r101;
        }
    }

    public static final class h extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466846c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final long f466847d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final int f466848e;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.f466846c, r101.f466846c) == true) goto L12;
            return false;
        L12:
            if (this.f466847d == r101.f466847d) goto L15;
            return false;
        L15:
            if (this.f466848e == r101.f466848e) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f466846c.hashCode() * 31;
            long r101 = this.f466847d;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.f466848e;
        }

        public final String toString() {
            return "DataTransferring(responseWrapper=" + this.f466846c + ", dataTransferId=" + this.f466847d + ", dataTransferProgress=" + this.f466848e + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466846c;
        }

        public h(e49.a r100, long r101, int r102) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, false);
            this.f466846c = r100;
            this.f466847d = r101;
            this.f466848e = r102;
        }
    }

    public static final class i extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466849c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f466850d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.f466849c, r101.f466849c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f466850d, r101.f466850d) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f466849c.hashCode() * 31) + this.f466850d.hashCode();
        }

        public final String toString() {
            return "DownloadFailed(responseWrapper=" + this.f466849c + ", downloadFailedReason=" + this.f466850d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466849c;
        }

        public i(e49.a r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            Intrinsics.checkNotNullParameter(r101, "downloadFailedReason");
            super(r100, true);
            this.f466849c = r100;
            this.f466850d = r101;
        }
    }

    public static final class j extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466851c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f466851c, ((j) r100).f466851c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f466851c.hashCode();
        }

        public final String toString() {
            return "DownloadSuccess(responseWrapper=" + this.f466851c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466851c;
        }

        public j(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, true);
            this.f466851c = r100;
        }
    }

    public static final class k extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466852c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f466853d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.f466852c, r101.f466852c) == true) goto L12;
            return false;
        L12:
            if (this.f466853d == r101.f466853d) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f466852c.hashCode() * 31) + this.f466853d;
        }

        public final String toString() {
            return "Downloading(responseWrapper=" + this.f466852c + ", downloadProgress=" + this.f466853d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466852c;
        }

        public k(e49.a r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, false);
            this.f466852c = r100;
            this.f466853d = r101;
        }
    }

    public static final class l extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public static final l f466854c = null;

        static {
            f466854c = new l();
        }

        public l() {
            super(null, true);
        }
    }

    public static final class m extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466855c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f466856d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L8;
            return false;
        L8:
            m r101 = (m) r100;
            if (Intrinsics.areEqual(this.f466855c, r101.f466855c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f466856d, r101.f466856d) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f466855c.hashCode() * 31) + this.f466856d.hashCode();
        }

        public final String toString() {
            return "OTAFailed(responseWrapper=" + this.f466855c + ", failReason=" + this.f466856d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466855c;
        }

        public m(e49.a r100, String r101) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            Intrinsics.checkNotNullParameter(r101, "failReason");
            super(r100, true);
            this.f466855c = r100;
            this.f466856d = r101;
        }
    }

    public static final class n extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final d49.b f466857c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f466857c, ((n) r100).f466857c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f466857c.hashCode();
        }

        public final String toString() {
            return "OTASuccess(device=" + this.f466857c + ')';
        }

        public n(d49.b r100) {
            Intrinsics.checkNotNullParameter(r100, "device");
            super(null, true);
            this.f466857c = r100;
        }
    }

    public static final class o extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466858c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final int f466859d;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L8;
            return false;
        L8:
            o r101 = (o) r100;
            if (Intrinsics.areEqual(this.f466858c, r101.f466858c) == true) goto L12;
            return false;
        L12:
            if (this.f466859d == r101.f466859d) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f466858c.hashCode() * 31) + this.f466859d;
        }

        public final String toString() {
            return "PeripheralInstalling(responseWrapper=" + this.f466858c + ", peripheralInstallProgress=" + this.f466859d + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466858c;
        }

        public o(e49.a r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, false);
            this.f466858c = r100;
            this.f466859d = r101;
        }
    }

    public static final class p extends a {

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final e49.a f466860c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f466860c, ((p) r100).f466860c) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f466860c.hashCode();
        }

        public final String toString() {
            return "PeripheralRestarting(responseWrapper=" + this.f466860c + ')';
        }

        @Override // d49.a
        public final e49.a a() {
            return this.f466860c;
        }

        public p(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "responseWrapper");
            super(r100, false);
            this.f466860c = r100;
        }
    }

    public e49.a a() {
        return this.f466836a;
    }

    public a(e49.a r100, boolean r101) {
        this.f466836a = r100;
        this.f466837b = r101;
    }
}
