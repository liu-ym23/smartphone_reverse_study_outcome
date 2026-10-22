package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class x {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final x f397752a = null;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f397753d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f397754a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f397755b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f397756c;

        /* JADX INFO: renamed from: com.obric.miniapp.intent.x$a$a, reason: collision with other inner class name */
        public static final class C4660a {
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
            if (this.f397754a == r101.f397754a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397755b, r101.f397755b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f397756c, r101.f397756c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f397754a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f397755b.hashCode()) * 31) + this.f397756c.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Result(success=" + this.f397754a + ", errorCode=" + this.f397755b + ", errorMessage=" + this.f397756c + ')';
        }

        public final String a() {
            return this.f397756c;
        }

        public a(boolean r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "errorCode");
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
            this.f397754a = r100;
            this.f397755b = r101;
            this.f397756c = r102;
        }
    }

    static {
        f397752a = new x();
    }

    public x() {
    }
}
