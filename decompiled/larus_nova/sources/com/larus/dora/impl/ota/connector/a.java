package com.larus.dora.impl.ota.connector;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public interface a extends com.larus.dora.impl.ota.c {

    /* JADX INFO: renamed from: com.larus.dora.impl.ota.connector.a$a, reason: collision with other inner class name */
    public static final class C4275a implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C4275a f337454a = null;

        static {
            f337454a = new C4275a();
        }

        public C4275a() {
        }

        @Override // j69.c
        public final String a() {
            return "ap_enabled";
        }
    }

    public static final class b implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f337455a = null;

        static {
            f337455a = new b();
        }

        public b() {
        }

        @Override // j69.c
        public final String a() {
            return "gps_disabled";
        }
    }

    public static final class c implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f337456a = null;

        static {
            f337456a = new c();
        }

        public c() {
        }

        @Override // j69.c
        public final String a() {
            return "location_permission_denied";
        }
    }

    public static final class d implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f337457a = null;

        static {
            f337457a = new d();
        }

        public d() {
        }

        @Override // j69.c
        public final String a() {
            return "nearby_permission_denied";
        }
    }

    public static final class e implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f337458a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f337459b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f337458a, ((e) r100).f337458a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f337458a.hashCode();
        }

        public final String toString() {
            return "WifiConnectFailed(reason=" + this.f337458a + ')';
        }

        public e() {
            this("");
        }

        @Override // j69.c
        public final String a() {
            return this.f337459b;
        }

        public e(String r100) {
            Intrinsics.checkNotNullParameter(r100, "reason");
            this.f337458a = r100;
            if (r100.length() <= 0) goto L5;
            boolean r101 = true;
        L6:
            if (r101 == false) goto L8;
            String r102 = "wifi_connect_failed_" + r100;
        L9:
            this.f337459b = r102;
            return;
        L8:
            r102 = "wifi_connect_failed";
            goto L9
        L5:
            r101 = false;
            goto L6
        }
    }

    public static final class f implements a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f337460a = null;

        static {
            f337460a = new f();
        }

        public f() {
        }

        @Override // j69.c
        public final String a() {
            return "wifi_disabled";
        }
    }
}
