package com.larus.dora.impl.onboarding;

/* JADX INFO: loaded from: classes27.dex */
public abstract class a {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f336604a;

    /* JADX INFO: renamed from: com.larus.dora.impl.onboarding.a$a, reason: collision with other inner class name */
    public static final class C4271a extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final C4271a f336605b = null;

        static {
            f336605b = new C4271a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C4271a) == true) goto L9;
            return false;
        L9:
            C4271a r101 = (C4271a) r100;
            return true;
        }

        public final int hashCode() {
            return 365625524;
        }

        public final String toString() {
            return "DeviceAuthGetSignTokenFailed";
        }

        public C4271a() {
            super("deviceAuthGetSignTokenFailed");
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final b f336606b = null;

        static {
            f336606b = new b();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            b r101 = (b) r100;
            return true;
        }

        public final int hashCode() {
            return -276508804;
        }

        public final String toString() {
            return "DeviceAuthProtocolInfoGetFailed";
        }

        public b() {
            super("deviceAuthProtocolInfoGetFailed");
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f336607b = null;

        static {
            f336607b = new c();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            c r101 = (c) r100;
            return true;
        }

        public final int hashCode() {
            return -10250414;
        }

        public final String toString() {
            return "DeviceAuthSuccess";
        }

        public c() {
            super("success");
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final long f336608b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f336608b == ((d) r100).f336608b) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f336608b;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "DeviceSignTokenAuthFailed(code=" + this.f336608b + ')';
        }

        public d(long r100) {
            super("deviceSignTokenAuthFailed(" + r100 + ')');
            this.f336608b = r100;
        }
    }

    public a(String r100) {
        this.f336604a = r100;
    }
}
