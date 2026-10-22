package com.larus.dora.impl.ota;

import com.larus.dora.impl.ota.tracker.DoraOTAPreCheckReason;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a extends com.larus.dora.impl.ota.c {

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.a$a, reason: collision with other inner class name */
    public static final class C4274a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4274a f337415a = null;

        static {
            f337415a = new C4274a();
        }

        public C4274a() {
        }

        @Override // j69.c
        public final String a() {
            return "DataTransferFailed";
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f337416a = null;

        static {
            f337416a = new b();
        }

        public b() {
        }

        @Override // j69.c
        public final String a() {
            return "DeviceDisconnected";
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f337417a = null;

        static {
            f337417a = new c();
        }

        public c() {
        }

        @Override // j69.c
        public final String a() {
            return "DownloadFailed";
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final e49.a f337418a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337419b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337418a, ((d) r100).f337418a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337418a.hashCode();
        }

        public final String toString() {
            return "DownloadFailedOnlyWifi(response=" + this.f337418a + ')';
        }

        @Override // j69.c
        public final String a() {
            return this.f337419b;
        }

        public d(e49.a r100) {
            Intrinsics.checkNotNullParameter(r100, "response");
            this.f337418a = r100;
            this.f337419b = DoraOTAPreCheckReason.NOT_ALLOWED_CELLULAR;
        }
    }

    public static final class e implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f337420a = null;

        static {
            f337420a = new e();
        }

        public e() {
        }

        @Override // j69.c
        public final String a() {
            return "OTAFailed";
        }
    }

    public static final class f implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f337421a = null;

        static {
            f337421a = new f();
        }

        public f() {
        }

        @Override // j69.c
        public final String a() {
            return DoraOTAPreCheckReason.NOT_ENOUGH_SPACE_ON_PHONE;
        }
    }

    public static final class g implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final g f337422a = null;

        static {
            f337422a = new g();
        }

        public g() {
        }

        @Override // j69.c
        public final String a() {
            return "vpn_connected";
        }
    }
}
