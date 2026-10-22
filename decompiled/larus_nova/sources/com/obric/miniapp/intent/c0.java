package com.obric.miniapp.intent;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes33.dex */
public final class c0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final c0 f397695a = null;

    public static final class a {

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public static final /* synthetic */ int f397696d = 0;

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final boolean f397697a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final String f397698b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final String f397699c;

        /* JADX INFO: renamed from: com.obric.miniapp.intent.c0$a$a, reason: collision with other inner class name */
        public static final class C4659a {
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
            if (this.f397697a == r101.f397697a) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f397698b, r101.f397698b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.f397699c, r101.f397699c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            if (this.f397697a == false) goto L5;
            int r100 = 1231;
        L7:
            return (((r100 * 31) + this.f397698b.hashCode()) * 31) + this.f397699c.hashCode();
        L5:
            r100 = 1237;
            goto L7
        }

        public final String toString() {
            return "Result(success=" + this.f397697a + ", errorCode=" + this.f397698b + ", errorMessage=" + this.f397699c + ')';
        }

        public a(boolean r100, String r101, String r102) {
            Intrinsics.checkNotNullParameter(r101, "errorCode");
            Intrinsics.checkNotNullParameter(r102, "errorMessage");
            this.f397697a = r100;
            this.f397698b = r101;
            this.f397699c = r102;
        }
    }

    static {
        f397695a = new c0();
    }

    public c0() {
    }
}
