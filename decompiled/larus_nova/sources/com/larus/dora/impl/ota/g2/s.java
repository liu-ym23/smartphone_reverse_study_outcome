package com.larus.dora.impl.ota.g2;

import com.bytedance.android.ecom.arch.slice.action.SlcCommonAction;
import com.bytedance.android.livesdk.end.LiveEndPageData;
import java.util.Set;
import java.util.UUID;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes4.dex */
public interface s {

    public static final class a implements s {
        private final long generation;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final Boolean supported;

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
            if (Intrinsics.areEqual(this.supported, r101.supported) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L18;
            return false;
        L18:
            if (this.generation == r101.generation) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            Boolean r101 = this.supported;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (r100 + r102) * 31;
            long r104 = this.now;
            int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
            long r106 = this.generation;
            return r105 + ((int) (r106 ^ (r106 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "AbilityChanged(key=" + this.key + ", supported=" + this.supported + ", now=" + this.now + ", generation=" + this.generation + ')';
        }

        public final long a() {
            return this.generation;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.now;
        }

        public final Boolean d() {
            return this.supported;
        }

        public a(com.larus.dora.impl.ota.g2.e r100, Boolean r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.supported = r101;
            this.now = r102;
            this.generation = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class a0 implements s {
        private final boolean debug;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long manualRearmDelayMs;
        private final long now;
        private final String sessionId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a0) == true) goto L8;
            return false;
        L8:
            a0 r101 = (a0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.now == r101.now) goto L15;
            return false;
        L15:
            if (this.debug == r101.debug) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L21;
            return false;
        L21:
            if (this.manualRearmDelayMs == r101.manualRearmDelayMs) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.now;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            if (this.debug == false) goto L5;
            int r103 = 1231;
        L6:
            int r104 = (((r102 + r103) * 31) + this.sessionId.hashCode()) * 31;
            long r105 = this.manualRearmDelayMs;
            return r104 + ((int) (r105 ^ (r105 >>> 32)));
        L5:
            r103 = 1237;
            goto L6
        }

        public final String toString() {
            return "ManualPageEntered(key=" + this.key + ", now=" + this.now + ", debug=" + this.debug + ", sessionId=" + this.sessionId + ", manualRearmDelayMs=" + this.manualRearmDelayMs + ')';
        }

        public final boolean a() {
            return this.debug;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.manualRearmDelayMs;
        }

        public final long d() {
            return this.now;
        }

        public final String e() {
            return this.sessionId;
        }

        public a0(com.larus.dora.impl.ota.g2.e r100, long r101, boolean r102, String r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r103, "sessionId");
            this.key = r100;
            this.now = r101;
            this.debug = r102;
            this.sessionId = r103;
            this.manualRearmDelayMs = r104;
        }
    }

    public static final class b implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;

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
            if (this.now == r101.now) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "Bound(key=" + this.key + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public b(com.larus.dora.impl.ota.g2.e r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.now = r101;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class b0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long manualRearmDelayMs;
        private final long now;
        private final String sessionId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b0) == true) goto L8;
            return false;
        L8:
            b0 r101 = (b0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.sessionId, r101.sessionId) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L18;
            return false;
        L18:
            if (this.manualRearmDelayMs == r101.manualRearmDelayMs) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.sessionId.hashCode()) * 31;
            long r101 = this.now;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.manualRearmDelayMs;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "ManualPageExited(key=" + this.key + ", sessionId=" + this.sessionId + ", now=" + this.now + ", manualRearmDelayMs=" + this.manualRearmDelayMs + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.manualRearmDelayMs;
        }

        public final long c() {
            return this.now;
        }

        public final String d() {
            return this.sessionId;
        }

        public b0(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "sessionId");
            this.key = r100;
            this.sessionId = r101;
            this.now = r102;
            this.manualRearmDelayMs = r103;
        }
    }

    public static final class c implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final String token;
        private final DeadlineType type;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (this.type == r101.type) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.token, r101.token) == true) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.type.hashCode() * 31;
            com.larus.dora.impl.ota.g2.e r101 = this.key;
            if (r101 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = (((r100 + r102) * 31) + this.token.hashCode()) * 31;
            long r104 = this.now;
            return r103 + ((int) (r104 ^ (r104 >>> 32)));
        L5:
            r102 = r101.hashCode();
            goto L6
        }

        public final String toString() {
            return "Deadline(type=" + this.type + ", key=" + this.key + ", token=" + this.token + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final String c() {
            return this.token;
        }

        public final DeadlineType getType() {
            return this.type;
        }

        public c(DeadlineType r100, com.larus.dora.impl.ota.g2.e r101, String r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "type");
            Intrinsics.checkNotNullParameter(r102, "token");
            this.type = r100;
            this.key = r101;
            this.token = r102;
            this.now = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class c0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final String ownerId;
        private final boolean success;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c0) == true) goto L8;
            return false;
        L8:
            c0 r101 = (c0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (this.success == r101.success) goto L21;
            return false;
        L21:
            if (this.now == r101.now) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            if (this.success == false) goto L5;
            int r103 = 1231;
        L6:
            int r104 = (r102 + r103) * 31;
            long r105 = this.now;
            return r104 + ((int) (r105 ^ (r105 >>> 32)));
        L5:
            r103 = 1237;
            goto L6
        }

        public final String toString() {
            return "P2pConnected(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", success=" + this.success + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public final String d() {
            return this.ownerId;
        }

        public final boolean e() {
            return this.success;
        }

        public c0(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, boolean r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.success = r103;
            this.now = r104;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class d implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final String ownerId;
        private final int progress;
        private final int stage;

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
            if (this.stage == r101.stage) goto L18;
            return false;
        L18:
            if (this.progress == r101.progress) goto L21;
            return false;
        L21:
            if (this.now == r101.now) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.stage) * 31) + this.progress) * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "DeviceStage(key=" + this.key + ", ownerId=" + this.ownerId + ", stage=" + this.stage + ", progress=" + this.progress + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final String c() {
            return this.ownerId;
        }

        public final int d() {
            return this.progress;
        }

        public final int e() {
            return this.stage;
        }

        public d(com.larus.dora.impl.ota.g2.e r100, String r101, int r102, int r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            this.key = r100;
            this.ownerId = r101;
            this.stage = r102;
            this.progress = r103;
            this.now = r104;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class d0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final String ownerId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d0) == true) goto L8;
            return false;
        L8:
            d0 r101 = (d0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "P2pDisconnected(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public final String d() {
            return this.ownerId;
        }

        public d0(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.now = r103;
        }
    }

    public static final class e implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final com.larus.dora.impl.ota.g2.g snapshot;

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
            if (Intrinsics.areEqual(this.snapshot, r101.snapshot) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.snapshot.hashCode()) * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "DeviceVersionChanged(key=" + this.key + ", snapshot=" + this.snapshot + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final com.larus.dora.impl.ota.g2.g c() {
            return this.snapshot;
        }

        public e(com.larus.dora.impl.ota.g2.e r100, com.larus.dora.impl.ota.g2.g r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "snapshot");
            this.key = r100;
            this.snapshot = r101;
            this.now = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class e0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e0) == true) goto L8;
            return false;
        L8:
            e0 r101 = (e0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.now == r101.now) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "SilentOtaCompletionAcknowledged(key=" + this.key + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public e0(com.larus.dora.impl.ota.g2.e r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.now = r101;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class f implements s {
        private final Integer downloadId;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final FailureReason reason;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L8;
            return false;
        L8:
            f r101 = (f) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (this.reason == r101.reason) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.downloadId, r101.downloadId) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.reason.hashCode()) * 31;
            long r103 = this.now;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            Integer r105 = this.downloadId;
            if (r105 != null) goto L5;
            int r106 = 0;
        L7:
            return r104 + r106;
        L5:
            r106 = r105.hashCode();
            goto L7
        }

        public final String toString() {
            return "DownloadFailed(key=" + this.key + ", operationId=" + this.operationId + ", reason=" + this.reason + ", now=" + this.now + ", downloadId=" + this.downloadId + ')';
        }

        public final Integer a() {
            return this.downloadId;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.now;
        }

        public final long d() {
            return this.operationId;
        }

        public final FailureReason e() {
            return this.reason;
        }

        public f(com.larus.dora.impl.ota.g2.e r100, long r101, FailureReason r102, long r103, Integer r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "reason");
            this.key = r100;
            this.operationId = r101;
            this.reason = r102;
            this.now = r103;
            this.downloadId = r104;
        }
    }

    public static final class f0 implements s {
        private final UserChoice choice;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f0) == true) goto L8;
            return false;
        L8:
            f0 r101 = (f0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.choice == r101.choice) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.choice.hashCode()) * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "SwitchChanged(key=" + this.key + ", choice=" + this.choice + ", now=" + this.now + ')';
        }

        public final UserChoice a() {
            return this.choice;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.now;
        }

        public f0(com.larus.dora.impl.ota.g2.e r100, UserChoice r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "choice");
            this.key = r100;
            this.choice = r101;
            this.now = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class g implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final BlockReason reason;

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
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (this.reason == r101.reason) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.reason.hashCode()) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "DownloadPaused(key=" + this.key + ", operationId=" + this.operationId + ", reason=" + this.reason + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public final BlockReason d() {
            return this.reason;
        }

        public g(com.larus.dora.impl.ota.g2.e r100, long r101, BlockReason r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "reason");
            this.key = r100;
            this.operationId = r101;
            this.reason = r102;
            this.now = r103;
        }
    }

    public static final class g0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final String localDay;
        private final long now;
        private final Trigger trigger;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g0) == true) goto L8;
            return false;
        L8:
            g0 r101 = (g0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.trigger == r101.trigger) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.localDay, r101.localDay) == true) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.key.hashCode() * 31) + this.trigger.hashCode()) * 31) + this.localDay.hashCode()) * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "SwitchExposureRequested(key=" + this.key + ", trigger=" + this.trigger + ", localDay=" + this.localDay + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final String b() {
            return this.localDay;
        }

        public final Trigger c() {
            return this.trigger;
        }

        public g0(com.larus.dora.impl.ota.g2.e r100, Trigger r101, String r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "trigger");
            Intrinsics.checkNotNullParameter(r102, "localDay");
            this.key = r100;
            this.trigger = r101;
            this.localDay = r102;
            this.now = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class h implements s {
        private final long downloadedBytes;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;

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
            if (this.now == r101.now) goto L18;
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
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.now;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.downloadedBytes;
            return r104 + ((int) (r105 ^ (r105 >>> 32)));
        }

        public final String toString() {
            return "DownloadPrepared(key=" + this.key + ", operationId=" + this.operationId + ", now=" + this.now + ", downloadedBytes=" + this.downloadedBytes + ')';
        }

        public final long a() {
            return this.downloadedBytes;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.now;
        }

        public final long d() {
            return this.operationId;
        }

        public h(com.larus.dora.impl.ota.g2.e r100, long r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.operationId = r101;
            this.now = r102;
            this.downloadedBytes = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class h0 implements s {
        private final String eventId;
        private final long now;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof h0) == true) goto L8;
            return false;
        L8:
            h0 r101 = (h0) r100;
            if (Intrinsics.areEqual(this.eventId, r101.eventId) == true) goto L12;
            return false;
        L12:
            if (this.now == r101.now) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.eventId.hashCode() * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "TerminalDispatchFailed(eventId=" + this.eventId + ", now=" + this.now + ')';
        }

        public final String a() {
            return this.eventId;
        }

        public final long b() {
            return this.now;
        }

        public h0(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276361k);
            this.eventId = r100;
            this.now = r101;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class i implements s {
        private final long bytes;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;

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
            if (this.bytes == r101.bytes) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.bytes;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            long r105 = this.now;
            return r104 + ((int) (r105 ^ (r105 >>> 32)));
        }

        public final String toString() {
            return "DownloadProgress(key=" + this.key + ", operationId=" + this.operationId + ", bytes=" + this.bytes + ", now=" + this.now + ')';
        }

        public final long a() {
            return this.bytes;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.now;
        }

        public final long d() {
            return this.operationId;
        }

        public i(com.larus.dora.impl.ota.g2.e r100, long r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.operationId = r101;
            this.bytes = r102;
            this.now = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class i0 implements s {
        private final String eventId;
        private final long now;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof i0) == true) goto L8;
            return false;
        L8:
            i0 r101 = (i0) r100;
            if (Intrinsics.areEqual(this.eventId, r101.eventId) == true) goto L12;
            return false;
        L12:
            if (this.now == r101.now) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.eventId.hashCode() * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "TerminalDispatched(eventId=" + this.eventId + ", now=" + this.now + ')';
        }

        public final String a() {
            return this.eventId;
        }

        public final long b() {
            return this.now;
        }

        public i0(String r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, com.heytap.mcssdk.constant.b.f276361k);
            this.eventId = r100;
            this.now = r101;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class j implements s {
        private final long bytes;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final boolean sufficient;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j) == true) goto L8;
            return false;
        L8:
            j r101 = (j) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (this.bytes == r101.bytes) goto L18;
            return false;
        L18:
            if (this.sufficient == r101.sufficient) goto L21;
            return false;
        L21:
            if (this.now == r101.now) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.bytes;
            int r104 = (r102 + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            if (this.sufficient == false) goto L5;
            int r105 = 1231;
        L6:
            int r106 = (r104 + r105) * 31;
            long r107 = this.now;
            return r106 + ((int) (r107 ^ (r107 >>> 32)));
        L5:
            r105 = 1237;
            goto L6
        }

        public final String toString() {
            return "DownloadSpaceChecked(key=" + this.key + ", operationId=" + this.operationId + ", bytes=" + this.bytes + ", sufficient=" + this.sufficient + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.operationId;
        }

        public final boolean c() {
            return this.sufficient;
        }

        public j(com.larus.dora.impl.ota.g2.e r100, long r101, long r102, boolean r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.operationId = r101;
            this.bytes = r102;
            this.sufficient = r103;
            this.now = r104;
        }
    }

    public static final class j0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof j0) == true) goto L8;
            return false;
        L8:
            j0 r101 = (j0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.now == r101.now) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "Unbound(key=" + this.key + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public j0(com.larus.dora.impl.ota.g2.e r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.now = r101;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class k implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k) == true) goto L8;
            return false;
        L8:
            k r101 = (k) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "DownloadSucceeded(key=" + this.key + ", operationId=" + this.operationId + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public k(com.larus.dora.impl.ota.g2.e r100, long r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.operationId = r101;
            this.now = r102;
        }
    }

    public static final class k0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final String ownerId;
        private final FailureReason reason;
        private final boolean success;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof k0) == true) goto L8;
            return false;
        L8:
            k0 r101 = (k0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (this.success == r101.success) goto L21;
            return false;
        L21:
            if (this.reason == r101.reason) goto L24;
            return false;
        L24:
            if (this.now == r101.now) goto L26;
            return false;
        L26:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            if (this.success == false) goto L5;
            int r103 = 1231;
        L6:
            int r104 = (((r102 + r103) * 31) + this.reason.hashCode()) * 31;
            long r105 = this.now;
            return r104 + ((int) (r105 ^ (r105 >>> 32)));
        L5:
            r103 = 1237;
            goto L6
        }

        public final String toString() {
            return "UploadFinished(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", success=" + this.success + ", reason=" + this.reason + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public final String d() {
            return this.ownerId;
        }

        public final FailureReason e() {
            return this.reason;
        }

        public final boolean f() {
            return this.success;
        }

        public k0(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, boolean r103, FailureReason r104, long r105) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            Intrinsics.checkNotNullParameter(r104, "reason");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.success = r103;
            this.reason = r104;
            this.now = r105;
        }
    }

    public static final class l implements s {
        private final Set<EnvironmentField> fields;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final com.larus.dora.impl.ota.g2.m snapshot;

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
            if (Intrinsics.areEqual(this.snapshot, r101.snapshot) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.fields, r101.fields) == true) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.snapshot.hashCode()) * 31;
            long r101 = this.now;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.fields.hashCode();
        }

        public final String toString() {
            return "EnvironmentChanged(key=" + this.key + ", snapshot=" + this.snapshot + ", now=" + this.now + ", fields=" + this.fields + ')';
        }

        public final Set<EnvironmentField> a() {
            return this.fields;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.now;
        }

        public final com.larus.dora.impl.ota.g2.m d() {
            return this.snapshot;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public l(com.larus.dora.impl.ota.g2.e r100, com.larus.dora.impl.ota.g2.m r101, long r102, Set<? extends EnvironmentField> r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "snapshot");
            Intrinsics.checkNotNullParameter(r103, SlcCommonAction.KEY_PARAMS);
            this.key = r100;
            this.snapshot = r101;
            this.now = r102;
            this.fields = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class l0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final String ownerId;
        private final int progress;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof l0) == true) goto L8;
            return false;
        L8:
            l0 r101 = (l0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (this.progress == r101.progress) goto L21;
            return false;
        L21:
            if (this.now == r101.now) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.progress) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "UploadProgress(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", progress=" + this.progress + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public final String d() {
            return this.ownerId;
        }

        public final int e() {
            return this.progress;
        }

        public l0(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, int r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.progress = r103;
            this.now = r104;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class m implements s {
        private final String attemptId;
        private final boolean debug;
        private final com.larus.dora.impl.ota.g2.e key;
        private final OtaMode mode;
        private final long now;

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
            if (this.mode == r101.mode) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L18;
            return false;
        L18:
            if (this.debug == r101.debug) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.attemptId, r101.attemptId) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.mode.hashCode()) * 31;
            long r101 = this.now;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            if (this.debug == false) goto L5;
            int r103 = 1231;
        L7:
            return ((r102 + r103) * 31) + this.attemptId.hashCode();
        L5:
            r103 = 1237;
            goto L7
        }

        public final String toString() {
            return "EvaluateInstall(key=" + this.key + ", mode=" + this.mode + ", now=" + this.now + ", debug=" + this.debug + ", attemptId=" + this.attemptId + ')';
        }

        public final String a() {
            return this.attemptId;
        }

        public final boolean b() {
            return this.debug;
        }

        public final com.larus.dora.impl.ota.g2.e c() {
            return this.key;
        }

        public final OtaMode d() {
            return this.mode;
        }

        public final long e() {
            return this.now;
        }

        public m(com.larus.dora.impl.ota.g2.e r100, OtaMode r101, long r102, boolean r103, int r104) {
            if ((r104 & 2) == 0) goto L6;
            r101 = OtaMode.SILENT_G2;
        L6:
            if ((r104 & 8) == 0) goto L9;
            r103 = false;
        L9:
            if ((r104 & 16) == 0) goto L11;
            String r105 = UUID.randomUUID().toString();
        L12:
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "mode");
            Intrinsics.checkNotNullParameter(r105, "attemptId");
            this.key = r100;
            this.mode = r101;
            this.now = r102;
            this.debug = r103;
            this.attemptId = r105;
            return;
        L11:
            r105 = null;
            goto L12
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class m0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final String ownerId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof m0) == true) goto L8;
            return false;
        L8:
            m0 r101 = (m0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "UploadStartRequested(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public final String d() {
            return this.ownerId;
        }

        public m0(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.now = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class n implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final OtaMode mode;
        private final long now;
        private final String traceId;
        private final Trigger trigger;

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
            if (this.trigger == r101.trigger) goto L15;
            return false;
        L15:
            if (this.mode == r101.mode) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.traceId, r101.traceId) == true) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.key.hashCode() * 31) + this.trigger.hashCode()) * 31) + this.mode.hashCode()) * 31;
            long r101 = this.now;
            return ((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.traceId.hashCode();
        }

        public final String toString() {
            return "EvaluatePredownload(key=" + this.key + ", trigger=" + this.trigger + ", mode=" + this.mode + ", now=" + this.now + ", traceId=" + this.traceId + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final OtaMode b() {
            return this.mode;
        }

        public final long c() {
            return this.now;
        }

        public final String d() {
            return this.traceId;
        }

        public final Trigger e() {
            return this.trigger;
        }

        public n(com.larus.dora.impl.ota.g2.e r100, Trigger r101, OtaMode r102, long r103, int r104) {
            if ((r104 & 4) == 0) goto L6;
            r102 = OtaMode.SILENT_G2;
        L6:
            if ((r104 & 16) == 0) goto L8;
            String r105 = UUID.randomUUID().toString();
        L9:
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "trigger");
            Intrinsics.checkNotNullParameter(r102, "mode");
            Intrinsics.checkNotNullParameter(r105, "traceId");
            this.key = r100;
            this.trigger = r101;
            this.mode = r102;
            this.now = r103;
            this.traceId = r105;
            return;
        L8:
            r105 = null;
            goto L9
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class n0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final String version;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof n0) == true) goto L8;
            return false;
        L8:
            n0 r101 = (n0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.version, r101.version) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.version.hashCode()) * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "VersionObserved(key=" + this.key + ", version=" + this.version + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final String c() {
            return this.version;
        }

        public n0(com.larus.dora.impl.ota.g2.e r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "version");
            this.key = r100;
            this.version = r101;
            this.now = r102;
        }
    }

    public static final class o implements s {
        private final boolean enabled;
        private final long installCooldownMs;
        private final long now;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o) == true) goto L8;
            return false;
        L8:
            o r101 = (o) r100;
            if (this.enabled == r101.enabled) goto L12;
            return false;
        L12:
            if (this.now == r101.now) goto L15;
            return false;
        L15:
            if (this.installCooldownMs == r101.installCooldownMs) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.enabled == false) goto L5;
            int r100 = 1231;
        L6:
            long r101 = this.now;
            int r102 = ((r100 * 31) + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            long r103 = this.installCooldownMs;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        L5:
            r100 = 1237;
            goto L6
        }

        public final String toString() {
            return "FeatureChanged(enabled=" + this.enabled + ", now=" + this.now + ", installCooldownMs=" + this.installCooldownMs + ')';
        }

        public final boolean a() {
            return this.enabled;
        }

        public final long b() {
            return this.installCooldownMs;
        }

        public final long c() {
            return this.now;
        }

        public o(boolean r100, long r101, long r102) {
            this.enabled = r100;
            this.now = r101;
            this.installCooldownMs = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class o0 implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final String ownerId;
        private final boolean success;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof o0) == true) goto L8;
            return false;
        L8:
            o0 r101 = (o0) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.operationId == r101.operationId) goto L18;
            return false;
        L18:
            if (this.success == r101.success) goto L21;
            return false;
        L21:
            if (this.now == r101.now) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.operationId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            if (this.success == false) goto L5;
            int r103 = 1231;
        L6:
            int r104 = (r102 + r103) * 31;
            long r105 = this.now;
            return r104 + ((int) (r105 ^ (r105 >>> 32)));
        L5:
            r103 = 1237;
            goto L6
        }

        public final String toString() {
            return "WifiEnableResult(key=" + this.key + ", ownerId=" + this.ownerId + ", operationId=" + this.operationId + ", success=" + this.success + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public final String d() {
            return this.ownerId;
        }

        public final boolean e() {
            return this.success;
        }

        public o0(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, boolean r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            this.key = r100;
            this.ownerId = r101;
            this.operationId = r102;
            this.success = r103;
            this.now = r104;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class p implements s {
        private final long effectId;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final boolean success;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p) == true) goto L8;
            return false;
        L8:
            p r101 = (p) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.effectId == r101.effectId) goto L15;
            return false;
        L15:
            if (this.success == r101.success) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.effectId;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            if (this.success == false) goto L5;
            int r103 = 1231;
        L6:
            int r104 = (r102 + r103) * 31;
            long r105 = this.now;
            return r104 + ((int) (r105 ^ (r105 >>> 32)));
        L5:
            r103 = 1237;
            goto L6
        }

        public final String toString() {
            return "FilesCleaned(key=" + this.key + ", effectId=" + this.effectId + ", success=" + this.success + ", now=" + this.now + ')';
        }

        public final long a() {
            return this.effectId;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.now;
        }

        public final boolean d() {
            return this.success;
        }

        public p(com.larus.dora.impl.ota.g2.e r100, long r101, boolean r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.effectId = r101;
            this.success = r102;
            this.now = r103;
        }
    }

    public static final class p0 implements s {
        private final long now;
        private final u5 window;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof p0) == true) goto L8;
            return false;
        L8:
            p0 r101 = (p0) r100;
            if (Intrinsics.areEqual(this.window, r101.window) == true) goto L12;
            return false;
        L12:
            if (this.now == r101.now) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.window.hashCode() * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "WindowChanged(window=" + this.window + ", now=" + this.now + ')';
        }

        public final u5 a() {
            return this.window;
        }

        public p0(u5 r100, long r101) {
            Intrinsics.checkNotNullParameter(r100, LiveEndPageData.TAG_WINDOW);
            this.window = r100;
            this.now = r101;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class q implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final OtaMode mode;
        private final long now;
        private final String ownerId;
        private final boolean success;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof q) == true) goto L8;
            return false;
        L8:
            q r101 = (q) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.mode == r101.mode) goto L18;
            return false;
        L18:
            if (this.success == r101.success) goto L21;
            return false;
        L21:
            if (this.now == r101.now) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r100 = ((((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31) + this.mode.hashCode()) * 31;
            if (this.success == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "InstallTypeDeclared(key=" + this.key + ", ownerId=" + this.ownerId + ", mode=" + this.mode + ", success=" + this.success + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final OtaMode b() {
            return this.mode;
        }

        public final long c() {
            return this.now;
        }

        public final String d() {
            return this.ownerId;
        }

        public final boolean e() {
            return this.success;
        }

        public q(com.larus.dora.impl.ota.g2.e r100, String r101, OtaMode r102, boolean r103, long r104) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            Intrinsics.checkNotNullParameter(r102, "mode");
            this.key = r100;
            this.ownerId = r101;
            this.mode = r102;
            this.success = r103;
            this.now = r104;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class r implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final long operationId;
        private final x4 result;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof r) == true) goto L8;
            return false;
        L8:
            r r101 = (r) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.operationId == r101.operationId) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.result, r101.result) == true) goto L18;
            return false;
        L18:
            if (this.now == r101.now) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            long r101 = this.operationId;
            int r102 = (((r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31) + this.result.hashCode()) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        }

        public final String toString() {
            return "LatestChecked(key=" + this.key + ", operationId=" + this.operationId + ", result=" + this.result + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final long c() {
            return this.operationId;
        }

        public final x4 d() {
            return this.result;
        }

        public r(com.larus.dora.impl.ota.g2.e r100, long r101, x4 r102, long r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r102, "result");
            this.key = r100;
            this.operationId = r101;
            this.result = r102;
            this.now = r103;
        }
    }

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.g2.s$s, reason: collision with other inner class name */
    /* JADX INFO: loaded from: classes27.dex */
    public static final class C4277s implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final String requestId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4277s) == true) goto L8;
            return false;
        L8:
            C4277s r101 = (C4277s) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.requestId.hashCode()) * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "LegacyDownloadReleased(key=" + this.key + ", requestId=" + this.requestId + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final String c() {
            return this.requestId;
        }

        public C4277s(com.larus.dora.impl.ota.g2.e r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "requestId");
            this.key = r100;
            this.requestId = r101;
            this.now = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class t implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final boolean queuedWake;
        private final String requestId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof t) == true) goto L8;
            return false;
        L8:
            t r101 = (t) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L18;
            return false;
        L18:
            if (this.queuedWake == r101.queuedWake) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.requestId.hashCode()) * 31;
            long r101 = this.now;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            if (this.queuedWake == false) goto L5;
            int r103 = 1231;
        L7:
            return r102 + r103;
        L5:
            r103 = 1237;
            goto L7
        }

        public final String toString() {
            return "LegacyDownloadRequested(key=" + this.key + ", requestId=" + this.requestId + ", now=" + this.now + ", queuedWake=" + this.queuedWake + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final boolean c() {
            return this.queuedWake;
        }

        public final String d() {
            return this.requestId;
        }

        public t(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "requestId");
            this.key = r100;
            this.requestId = r101;
            this.now = r102;
            this.queuedWake = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class u implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final String ownerId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof u) == true) goto L8;
            return false;
        L8:
            u r101 = (u) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "LegacyInstallCommitted(key=" + this.key + ", ownerId=" + this.ownerId + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final String c() {
            return this.ownerId;
        }

        public u(com.larus.dora.impl.ota.g2.e r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            this.key = r100;
            this.ownerId = r101;
            this.now = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class v implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final String ownerId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof v) == true) goto L8;
            return false;
        L8:
            v r101 = (v) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.ownerId, r101.ownerId) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.ownerId.hashCode()) * 31;
            long r101 = this.now;
            return r100 + ((int) (r101 ^ (r101 >>> 32)));
        }

        public final String toString() {
            return "LegacyInstallReleased(key=" + this.key + ", ownerId=" + this.ownerId + ", now=" + this.now + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final String c() {
            return this.ownerId;
        }

        public v(com.larus.dora.impl.ota.g2.e r100, String r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "ownerId");
            this.key = r100;
            this.ownerId = r101;
            this.now = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class w implements s {
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final boolean queuedWake;
        private final String requestId;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof w) == true) goto L8;
            return false;
        L8:
            w r101 = (w) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.requestId, r101.requestId) == true) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L18;
            return false;
        L18:
            if (this.queuedWake == r101.queuedWake) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.key.hashCode() * 31) + this.requestId.hashCode()) * 31;
            long r101 = this.now;
            int r102 = (r100 + ((int) (r101 ^ (r101 >>> 32)))) * 31;
            if (this.queuedWake == false) goto L5;
            int r103 = 1231;
        L7:
            return r102 + r103;
        L5:
            r103 = 1237;
            goto L7
        }

        public final String toString() {
            return "LegacyInstallRequested(key=" + this.key + ", requestId=" + this.requestId + ", now=" + this.now + ", queuedWake=" + this.queuedWake + ')';
        }

        public final com.larus.dora.impl.ota.g2.e a() {
            return this.key;
        }

        public final long b() {
            return this.now;
        }

        public final boolean c() {
            return this.queuedWake;
        }

        public final String d() {
            return this.requestId;
        }

        public w(com.larus.dora.impl.ota.g2.e r100, String r101, long r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            Intrinsics.checkNotNullParameter(r101, "requestId");
            this.key = r100;
            this.requestId = r101;
            this.now = r102;
            this.queuedWake = r103;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class x implements s {
        private final boolean active;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof x) == true) goto L8;
            return false;
        L8:
            x r101 = (x) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.active == r101.active) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            if (this.active == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "LegacySilentChanged(key=" + this.key + ", active=" + this.active + ", now=" + this.now + ')';
        }

        public final boolean a() {
            return this.active;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final long c() {
            return this.now;
        }

        public x(com.larus.dora.impl.ota.g2.e r100, boolean r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.active = r101;
            this.now = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class y implements s {
        private final boolean debug;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof y) == true) goto L8;
            return false;
        L8:
            y r101 = (y) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.debug == r101.debug) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            if (this.debug == false) goto L5;
            int r101 = 1231;
        L6:
            int r102 = (r100 + r101) * 31;
            long r103 = this.now;
            return r102 + ((int) (r103 ^ (r103 >>> 32)));
        L5:
            r101 = 1237;
            goto L6
        }

        public final String toString() {
            return "ManualCheck(key=" + this.key + ", debug=" + this.debug + ", now=" + this.now + ')';
        }

        public final boolean a() {
            return this.debug;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public y(com.larus.dora.impl.ota.g2.e r100, boolean r101, long r102) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.debug = r101;
            this.now = r102;
        }
    }

    /* JADX INFO: loaded from: classes27.dex */
    public static final class z implements s {
        private final boolean debug;
        private final com.larus.dora.impl.ota.g2.e key;
        private final long now;
        private final boolean onlyWifi;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof z) == true) goto L8;
            return false;
        L8:
            z r101 = (z) r100;
            if (Intrinsics.areEqual(this.key, r101.key) == true) goto L12;
            return false;
        L12:
            if (this.debug == r101.debug) goto L15;
            return false;
        L15:
            if (this.now == r101.now) goto L18;
            return false;
        L18:
            if (this.onlyWifi == r101.onlyWifi) goto L20;
            return false;
        L20:
            return true;
        }

        public final int hashCode() {
            int r100 = this.key.hashCode() * 31;
            int r101 = 1231;
            if (this.debug == false) goto L5;
            int r102 = 1231;
        L6:
            long r103 = this.now;
            int r104 = (((r100 + r102) * 31) + ((int) (r103 ^ (r103 >>> 32)))) * 31;
            if (this.onlyWifi == true) goto L11;
            r101 = 1237;
        L11:
            return r104 + r101;
        L5:
            r102 = 1237;
            goto L6
        }

        public final String toString() {
            return "ManualDownload(key=" + this.key + ", debug=" + this.debug + ", now=" + this.now + ", onlyWifi=" + this.onlyWifi + ')';
        }

        public final boolean a() {
            return this.debug;
        }

        public final com.larus.dora.impl.ota.g2.e b() {
            return this.key;
        }

        public final boolean c() {
            return this.onlyWifi;
        }

        public z(com.larus.dora.impl.ota.g2.e r100, boolean r101, long r102, boolean r103) {
            Intrinsics.checkNotNullParameter(r100, "key");
            this.key = r100;
            this.debug = r101;
            this.now = r102;
            this.onlyWifi = r103;
        }
    }
}
