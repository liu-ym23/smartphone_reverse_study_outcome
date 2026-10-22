package com.larus.account.saas.jsb.core;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes24.dex */
public final class FlowAccountUnbindCore {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f286362a = 0;

    @Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0006\b\u0086\u0001\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001R\u0017\u0010\u0003\u001a\u00020\u00028\u0006¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u0017\u0010\b\u001a\u00020\u00078\u0006¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000bj\u0002\b\f¨\u0006\r"}, d2 = {"Lcom/larus/account/saas/jsb/core/FlowAccountUnbindCore$Error;", "", "", "code", "I", "getCode", "()I", "", "message", "Ljava/lang/String;", "getMessage", "()Ljava/lang/String;", "UNSUPPORTED_PLATFORM", "account-saas-jsb-core_release"}, k = 1, mv = {1, 7, 1})
    public static final enum Error extends Enum<Error> {
        public static final Error UNSUPPORTED_PLATFORM = null;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ Error[] f286363a = null;
        private final int code;
        private final String message;

        public static Error valueOf(String r100) {
            return (Error) r27.a.a(Error.class, r100);
        }

        public static Error[] values() {
            return (Error[]) f286363a.clone();
        }

        static {
            Error r100 = new Error();
            UNSUPPORTED_PLATFORM = r100;
            f286363a = new Error[]{r100};
        }

        public Error() {
            super("UNSUPPORTED_PLATFORM", 0);
            this.code = 1;
            this.message = "unsupported platform";
        }

        public final int getCode() {
            return this.code;
        }

        public final String getMessage() {
            return this.message;
        }
    }

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final Number f286364a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Number f286365b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f286366c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f286364a, r101.f286364a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f286365b, r101.f286365b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f286366c, r101.f286366c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            Number r100 = this.f286364a;
            int r101 = 0;
            if (r100 != null) goto L5;
            int r102 = 0;
        L6:
            int r103 = r102 * 31;
            Number r104 = this.f286365b;
            if (r104 != null) goto L9;
            int r105 = 0;
        L10:
            int r106 = (r103 + r105) * 31;
            String r107 = this.f286366c;
            if (r107 == null) goto L15;
            r101 = r107.hashCode();
        L15:
            return r106 + r101;
        L9:
            r105 = r104.hashCode();
            goto L10
        L5:
            r102 = r100.hashCode();
            goto L6
        }

        public final String toString() {
            return "Result(success=" + this.f286364a + ", errorCode=" + this.f286365b + ", errorMessage=" + this.f286366c + ')';
        }

        public a(Number r100, Number r101, String r102) {
            this.f286364a = r100;
            this.f286365b = r101;
            this.f286366c = r102;
        }
    }

    static {
    }
}
