package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class z {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final z f397758a = null;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f397759d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f397760a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f397761b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f397762c;

        /* JADX INFO: renamed from: com.obric.miniapp.intent.z$a$a, reason: collision with other inner class name */
        public static final class C4661a {
            public static a a(String r100, String r101) {
                Intrinsics.checkNotNullParameter(r100, "errorCode");
                Intrinsics.checkNotNullParameter(r101, "errorMessage");
                return new a(false, r100, r101);
            }
        }

        static {
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (this.f397760a == r101.f397760a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397761b, r101.f397761b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f397762c, r101.f397762c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f397760a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f397761b.hashCode()) * 31) + this.f397762c.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Result(success=" + this.f397760a + ", errorCode=" + this.f397761b + ", errorMessage=" + this.f397762c + ')';
        }

        public a(boolean r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "errorCode");
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
            this.f397760a = r100;
            this.f397761b = r101;
            this.f397762c = r102;
        }
    }

    static {
        f397758a = new z();
    }

    public z() {
    }
}
