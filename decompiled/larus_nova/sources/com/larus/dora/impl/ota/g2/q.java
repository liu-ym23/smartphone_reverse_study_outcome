package com.larus.dora.impl.ota.g2;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface q {

    public static final class a implements q {
        private final long downloadedBytes;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final e5 pkg;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pkg, r101.pkg) == true) goto L18;
            return false;
        L18:
            if (this.downloadedBytes == r101.downloadedBytes) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.pkg.hashCode()) * 31;
            long r103 = this.downloadedBytes;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "CheckDownloadSpace(key=" + this.key + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ", downloadedBytes=" + this.downloadedBytes + ')';
        }

        public final long a() {
            return this.downloadedBytes;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.operationId;
        }

        public final e5 d() {
            return this.pkg;
        }

        public a(com.larus.dora.impl.ota.g2.e r100, long r101, e5 r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "pkg");
            this.key = r100;
            this.operationId = r101;
            this.pkg = r102;
            this.downloadedBytes = r103;
        }
    }

    public static final class b implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final CheckPurpose purpose;
        private final com.larus.dora.impl.ota.g2.g request;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L8;
            return false;
        L8:
            b r101 = (b) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (this.purpose == r101.purpose) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.request, r101.request) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            return ((((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.purpose.hashCode()) * 31) + this.request.hashCode();
        }

        public final String toString() {
            return "CheckLatest(key=" + this.key + ", operationId=" + this.operationId + ", purpose=" + this.purpose + ", request=" + this.request + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final com.larus.dora.impl.ota.g2.g c() {
            return this.request;
        }

        public b(com.larus.dora.impl.ota.g2.e r100, long r101, CheckPurpose r102, com.larus.dora.impl.ota.g2.g r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "purpose");
            Intrinsics.checkNotNullParameter(r103, "request");
            this.key = r100;
            this.operationId = r101;
            this.purpose = r102;
            this.request = r103;
        }
    }

    public static final class c implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final OtaMode mode;
        private final long operationId;
        private final String ownerId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (this.mode == r101.mode) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.mode.hashCode();
        }

        public final String toString() {
            return "ConnectP2p(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", mode=" + this.mode + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final OtaMode b() {
            return this.mode;
        }

        public final long c() {
            return this.operationId;
        }

        public final String d() {
            return this.ownerId;
        }

        public c(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, OtaMode r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            Intrinsics.checkNotNullParameter(r103, "mode");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.mode = r103;
        }
    }

    public static final class d implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final OtaMode mode;
        private final String ownerId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L8;
            return false;
        L8:
            d r101 = (d) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.mode == r101.mode) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.mode.hashCode();
        }

        public final String toString() {
            return "DeclareType(key=" + this.key + ", ownerId=" + this.ownerId + ", mode=" + this.mode + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final OtaMode b() {
            return this.mode;
        }

        public final String c() {
            return this.ownerId;
        }

        public d(com.larus.dora.impl.ota.g2.e r100, String r101, OtaMode r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            Intrinsics.checkNotNullParameter(r102, "mode");
            this.key = r100;
            this.ownerId = r101;
            this.mode = r102;
        }
    }

    public static final class e implements q {
        private final Integer discardDownloadId;
        private final long effectId;
        private final com.larus.dora.impl.ota.g2.e key;
        private final e5 pkg;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.effectId == r101.effectId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pkg, r101.pkg) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.discardDownloadId, r101.discardDownloadId) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.effectId;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.pkg.hashCode()) * 31;
            Integer r103 = this.discardDownloadId;
            if (r103 != null) goto L5;
            int r104 = 0;
        L7:
            return r102 + r104;
        L5:
            r104 = r103.hashCode();
            goto L7
        }

        public final String toString() {
            return "DeletePackage(key=" + this.key + ", effectId=" + this.effectId + ", pkg=" + this.pkg + ", discardDownloadId=" + this.discardDownloadId + ')';
        }

        public final Integer a() {
            return this.discardDownloadId;
        }

        public final long b() {
            return this.effectId;
        }

        public final com.larus.dora.impl.ota.g2.e c() {
            return this.key;
        }

        public final e5 d() {
            return this.pkg;
        }

        public /* synthetic */ e(com.larus.dora.impl.ota.g2.e r100, long r101, e5 r110) {
            this(r100, r101, r110, null);
        }

        public e(com.larus.dora.impl.ota.g2.e r100, long r101, e5 r102, Integer r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "pkg");
            this.key = r100;
            this.effectId = r101;
            this.pkg = r102;
            this.discardDownloadId = r103;
        }
    }

    public static final class f implements q {
        private final s event;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.event, ((f) r100).event) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.event.hashCode();
        }

        public final String toString() {
            return "Dispatch(event=" + this.event + ')';
        }

        public final s a() {
            return this.event;
        }

        public f(s r100) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.event = r100;
        }
    }

    public static final class g implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final String ownerId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L8;
            return false;
        L8:
            g r101 = (g) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "EnableWifi(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final String c() {
            return this.ownerId;
        }
    }

    public static final class h implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final BlockReason reason;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h) == true) goto L8;
            return false;
        L8:
            h r101 = (h) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (this.reason == r101.reason) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.reason.hashCode();
        }

        public final String toString() {
            return "PauseDownload(key=" + this.key + ", operationId=" + this.operationId + ", reason=" + this.reason + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final BlockReason c() {
            return this.reason;
        }

        public h(com.larus.dora.impl.ota.g2.e r100, long r101, BlockReason r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "reason");
            this.key = r100;
            this.operationId = r101;
            this.reason = r102;
        }
    }

    public static final class i implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final e5 pkg;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i) == true) goto L8;
            return false;
        L8:
            i r101 = (i) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pkg, r101.pkg) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.pkg.hashCode();
        }

        public final String toString() {
            return "PrepareDownload(key=" + this.key + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final e5 c() {
            return this.pkg;
        }

        public i(com.larus.dora.impl.ota.g2.e r100, long r101, e5 r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "pkg");
            this.key = r100;
            this.operationId = r101;
            this.pkg = r102;
        }
    }

    public static final class j implements q {
        private final String ownerId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.ownerId, ((j) r100).ownerId) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.ownerId.hashCode();
        }

        public final String toString() {
            return "ReleaseWifi(ownerId=" + this.ownerId + ')';
        }

        public final String a() {
            return this.ownerId;
        }

        public j(String r100) {
            Intrinsics.checkNotNullParameter(r100, "ownerId");
            this.ownerId = r100;
        }
    }

    public static final class k implements q {
        private final boolean awaitDispatch;
        private final p5 event;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.event, r101.event) == true) goto L12;
            return false;
        L12:
            if (this.awaitDispatch == r101.awaitDispatch) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.event.hashCode() * 31;
            if (this.awaitDispatch == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Report(event=" + this.event + ", awaitDispatch=" + this.awaitDispatch + ')';
        }

        public final boolean a() {
            return this.awaitDispatch;
        }

        public final p5 b() {
            return this.event;
        }

        public k(p5 r100, boolean r101) {
            Intrinsics.checkNotNullParameter(r100, "event");
            this.event = r100;
            this.awaitDispatch = r101;
        }
    }

    public static final class l implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final boolean onlyWifi;
        private final long operationId;
        private final e5 pkg;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l) == true) goto L8;
            return false;
        L8:
            l r101 = (l) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.pkg, r101.pkg) == true) goto L18;
            return false;
        L18:
            if (this.onlyWifi == r101.onlyWifi) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.pkg.hashCode()) * 31;
            if (this.onlyWifi == false) goto L5;
            int r103 = 1231;
        L7:
            return r102 + r103;
        L5:
            r103 = 1237;
            goto L7
        }

        public final String toString() {
            return "StartDownload(key=" + this.key + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ", onlyWifi=" + this.onlyWifi + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final boolean b() {
            return this.onlyWifi;
        }

        public final long c() {
            return this.operationId;
        }

        public final e5 d() {
            return this.pkg;
        }

        public l(com.larus.dora.impl.ota.g2.e r100, long r101, e5 r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "pkg");
            this.key = r100;
            this.operationId = r101;
            this.pkg = r102;
            this.onlyWifi = r103;
        }
    }

    public static final class m implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final String ownerId;
        private final e5 pkg;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m) == true) goto L8;
            return false;
        L8:
            m r101 = (m) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.pkg, r101.pkg) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.pkg.hashCode();
        }

        public final String toString() {
            return "StartUpload(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", pkg=" + this.pkg + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final String c() {
            return this.ownerId;
        }

        public final e5 d() {
            return this.pkg;
        }

        public m(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, e5 r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            Intrinsics.checkNotNullParameter(r103, "pkg");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.pkg = r103;
        }
    }

    public static final class n implements q {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long operationId;
        private final String ownerId;
        private final FailureReason reason;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n) == true) goto L8;
            return false;
        L8:
            n r101 = (n) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (this.reason == r101.reason) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.reason.hashCode();
        }

        public final String toString() {
            return "StopUpload(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", reason=" + this.reason + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final String c() {
            return this.ownerId;
        }

        public final FailureReason d() {
            return this.reason;
        }

        public n(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, FailureReason r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            Intrinsics.checkNotNullParameter(r103, "reason");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.reason = r103;
        }
    }
}
