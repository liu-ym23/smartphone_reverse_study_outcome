package com.larus.account.saas.jsb.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class FlowAccountThirdPartyAuthCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286349a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\n\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\fj\u0002\b\rj\u0002\b\u000ej\u0002\b\u000fj\u0002\b\u0010¨\u0006\u0011"}, d2 = {"Lcom/larus/account/saas/jsb/core/FlowAccountThirdPartyAuthCore$Error;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "UNSUPPORTED_PLATFORM", "ACTIVITY_NULL", "CONFIG_MISSING", "SERVICE_UNAVAILABLE", "REQUEST_REJECTED", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error ACTIVITY_NULL = null;
        public static final Error CONFIG_MISSING = null;
        public static final Error REQUEST_REJECTED = null;
        public static final Error SERVICE_UNAVAILABLE = null;
        public static final Error UNSUPPORTED_PLATFORM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Error[] f286350a = null;
        private final int code;
        private final String message;

        public static Error valueOf(String r100) {
            return (Error) r27.a.a(Error.class, r100);
        }

        public static Error[] values() {
            return (Error[]) f286350a.clone();
        }

        static {
            Error r100 = new Error("UNSUPPORTED_PLATFORM", 0, 1, "unsupported platform");
            UNSUPPORTED_PLATFORM = r100;
            Error r101 = new Error("ACTIVITY_NULL", 1, 2, "activity is null");
            ACTIVITY_NULL = r101;
            Error r102 = new Error("CONFIG_MISSING", 2, 3, "third party auth config is missing");
            CONFIG_MISSING = r102;
            Error r103 = new Error("SERVICE_UNAVAILABLE", 3, 4, "authorize service is not initialized");
            SERVICE_UNAVAILABLE = r103;
            Error r104 = new Error("REQUEST_REJECTED", 4, 5, "authorize request rejected");
            REQUEST_REJECTED = r104;
            f286350a = new Error[]{r100, r101, r102, r103, r104};
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }

        public Error(String r100, int r101, int r102, String r103) {
            super(r100, r101);
            this.code = r102;
            this.message = r103;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f286351a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f286352b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f286353c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public final String f286354d;

        /* JADX INFO: renamed from: e, reason: collision with root package name */
        public final String f286355e;

        /* JADX INFO: renamed from: f, reason: collision with root package name */
        public final String f286356f;

        /* JADX INFO: renamed from: g, reason: collision with root package name */
        public final String f286357g;

        /* JADX INFO: renamed from: h, reason: collision with root package name */
        public final Number f286358h;

        /* JADX INFO: renamed from: i, reason: collision with root package name */
        public final String f286359i;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f286351a, r101.f286351a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286352b, r101.f286352b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f286353c, r101.f286353c) == true) goto L18;
            return false;
        L18:
            if (Intrinsics.areEqual(this.f286354d, r101.f286354d) == true) goto L21;
            return false;
        L21:
            if (Intrinsics.areEqual(this.f286355e, r101.f286355e) == true) goto L24;
            return false;
        L24:
            if (Intrinsics.areEqual(this.f286356f, r101.f286356f) == true) goto L27;
            return false;
        L27:
            if (Intrinsics.areEqual(this.f286357g, r101.f286357g) == true) goto L30;
            return false;
        L30:
            if (Intrinsics.areEqual(this.f286358h, r101.f286358h) == true) goto L33;
            return false;
        L33:
            if (Intrinsics.areEqual(this.f286359i, r101.f286359i) == true) goto L35;
            return false;
        L35:
            return true;
        }

        public final int hashCode() {
            String r100 = this.f286351a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            String r104 = this.f286352b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f286353c;
            if (r107 != null) goto L13;
            int r108 = 0;
        L14:
            int r109 = (r106 + r108) * 31;
            String r110 = this.f286354d;
            if (r110 != null) goto L17;
            int r111 = 0;
        L18:
            int r112 = (r109 + r111) * 31;
            String r113 = this.f286355e;
            if (r113 != null) goto L21;
            int r114 = 0;
        L22:
            int r115 = (r112 + r114) * 31;
            String r116 = this.f286356f;
            if (r116 != null) goto L25;
            int r117 = 0;
        L26:
            int r118 = (r115 + r117) * 31;
            String r119 = this.f286357g;
            if (r119 != null) goto L29;
            int r120 = 0;
        L30:
            int r121 = (r118 + r120) * 31;
            Number r122 = this.f286358h;
            if (r122 != null) goto L33;
            int r123 = 0;
        L34:
            int r124 = (r121 + r123) * 31;
            String r125 = this.f286359i;
            if (r125 == null) goto L39;
            r101 = r125.hashCode();
        L39:
            return r124 + r101;
        L33:
            r123 = r122.hashCode();
            goto L34
        L29:
            r120 = r119.hashCode();
            goto L30
        L25:
            r117 = r116.hashCode();
            goto L26
        L21:
            r114 = r113.hashCode();
            goto L22
        L17:
            r111 = r110.hashCode();
            goto L18
        L13:
            r108 = r107.hashCode();
            goto L14
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(platform=" + this.f286351a + ", platformAppId=" + this.f286352b + ", code=" + this.f286353c + ", openId=" + this.f286354d + ", accessToken=" + this.f286355e + ", accessTokenSecret=" + this.f286356f + ", expiresIn=" + this.f286357g + ", errorCode=" + this.f286358h + ", rawData=" + this.f286359i + ')';
        }

        public a(String r100, String r101, String r102, String r103, String r104, String r105, String r106, Number r110, int r111) {
            if ((r111 & 4) == 0) goto L6;
            r102 = null;
        L6:
            if ((r111 & 8) == 0) goto L9;
            r103 = null;
        L9:
            if ((r111 & 16) == 0) goto L12;
            r104 = null;
        L12:
            if ((r111 & 32) == 0) goto L15;
            r105 = null;
        L15:
            if ((r111 & 64) == 0) goto L18;
            r106 = null;
        L18:
            if ((r111 & 128) == 0) goto L20;
            r110 = null;
        L20:
            this.f286351a = r100;
            this.f286352b = r101;
            this.f286353c = r102;
            this.f286354d = r103;
            this.f286355e = r104;
            this.f286356f = r105;
            this.f286357g = r106;
            this.f286358h = r110;
            this.f286359i = null;
        }
    }

    static {
    }
}
