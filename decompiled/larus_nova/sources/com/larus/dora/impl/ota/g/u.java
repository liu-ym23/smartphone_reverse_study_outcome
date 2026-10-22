package com.larus.dora.impl.ota.g;

import com.larus.dora.impl.ota.tracker.DoraOTACheckReason;

/* JADX INFO: loaded from: classes27.dex */
public interface u extends com.larus.dora.impl.ota.c {

    public static final class a implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337555a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337556b;

        public a() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.f337555a == ((a) r100).f337555a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337555a;
        }

        public final String toString() {
            return "CheckRequestFailed(retryCount=" + this.f337555a + ')';
        }

        @Override // j69.c
        public final String a() {
            return this.f337556b;
        }

        public a(int r100) {
            this.f337555a = r100;
            this.f337556b = DoraOTACheckReason.CHECK_REQUEST_FAIL;
        }
    }

    public static final class b implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337557a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337558b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f337557a == ((b) r100).f337557a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337557a;
        }

        public final String toString() {
            return "PeripheralsError(errorCode=" + this.f337557a + ')';
        }

        @Override // j69.c
        public final String a() {
            return this.f337558b;
        }

        public b(int r100) {
            this.f337557a = r100;
            this.f337558b = DoraOTACheckReason.ERROR_CODE_PREFIX + r100;
        }
    }

    public static final class c implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f337559a = null;

        static {
            f337559a = new c();
        }

        public c() {
        }

        @Override // j69.c
        public final String a() {
            return "low_battery";
        }
    }

    public static final class d implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f337560a = null;

        static {
            f337560a = new d();
        }

        public d() {
        }

        @Override // j69.c
        public final String a() {
            return "peripherals_ota_failed_require_reboot";
        }
    }

    public static final class e implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f337561a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337562b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (this.f337561a == ((e) r100).f337561a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337561a;
        }

        public final String toString() {
            return "PeripheralsPrepared(status=" + this.f337561a + ')';
        }

        @Override // j69.c
        public final String a() {
            return this.f337562b;
        }

        public e(int r100) {
            this.f337561a = r100;
            this.f337562b = "peripherals_prepared_" + r100;
        }
    }

    public static final class f implements u {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f337563a = null;

        static {
            f337563a = new f();
        }

        public f() {
        }

        @Override // j69.c
        public final String a() {
            return DoraOTACheckReason.NOT_ENOUGH_SPACE_ON_PERIPHERAL;
        }
    }
}
