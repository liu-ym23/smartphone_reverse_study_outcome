package com.bytedance.android.shopping.prepurchase.arch.container.intf;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class k {

    public static final class a extends k {
        public final int a;
        public final String b;
        public final Throwable c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof a) == false) goto L12;
            a r4 = (a) r3;
            if (this.a == r4.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        public final int hashCode() {
            int r0 = this.a * 31;
            String r1 = this.b;
            int r2 = 0;
            if (r1 == null) goto L5;
            int r3 = r1.hashCode();
        L6:
            int r4 = (r0 + r3) * 31;
            Throwable r5 = this.c;
            if (r5 == null) goto L10;
            r2 = r5.hashCode();
        L10:
            return r4 + r2;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "FailedState(errorCode=" + this.a + ", errorMsg=" + this.b + ", cause=" + this.c + ')';
        }

        public a(int r1, String r2) {
            this.a = r1;
            this.b = r2;
            this.c = null;
        }
    }

    public static final class b extends k {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static abstract class c extends k {

        public static final class a extends c {
            public static final a a = null;

            public a() {
                super(0);
            }

            public final String toString() {
                return "Loading()";
            }

            static {
                a = new a();
            }
        }

        public static final class b extends c {
            public static final b a = null;

            public b() {
                super(0);
            }

            public final String toString() {
                return "LoadingPreview()";
            }

            static {
                a = new b();
            }
        }

        public c(int r1) {
        }
    }

    public static abstract class d extends k {

        public static final class a extends d {
            public final String a;

            public final int hashCode() {
                String r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "Cache(requestId='" + this.a + "')";
            }

            public a(String r2) {
                Intrinsics.checkNotNullParameter(r2, "requestId");
                this.a = r2;
            }

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof a) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((a) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public static final class b extends d {
            public final String a;
            public final int b;
            public final int c;

            public final int hashCode() {
                String r0 = this.a;
                if (r0 == null) goto L5;
                int r1 = r0.hashCode();
            L7:
                return (((r1 * 31) + this.b) * 31) + this.c;
            L5:
                r1 = 0;
                goto L7
            }

            public final String toString() {
                return "Chunk(requestId='" + this.a + "', index=" + this.b + ", totalChunkCount=" + this.c + ')';
            }

            public final boolean equals(Object r3) {
                if (this != r3) goto L4;
                return true;
            L4:
                if ((r3 instanceof b) == false) goto L12;
                b r4 = (b) r3;
                if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
                return false;
            L8:
                if (this.b == r4.b) goto L10;
                return false;
            L10:
                if (this.c == r4.c) goto L19;
                return false;
            L19:
                return true;
            L12:
                return false;
            }

            public b(String r2, int r3, int r4) {
                Intrinsics.checkNotNullParameter(r2, "requestId");
                this.a = r2;
                this.b = r3;
                this.c = r4;
            }
        }

        public static final class c extends d {
            public final String a;

            public final int hashCode() {
                String r0 = this.a;
                if (r0 != null) goto L7;
                return 0;
            L7:
                return r0.hashCode();
            }

            public final String toString() {
                return "Success(requestId='" + this.a + "')";
            }

            public c(String r2) {
                Intrinsics.checkNotNullParameter(r2, "requestId");
                this.a = r2;
            }

            public final boolean equals(Object r2) {
                if (this != r2) goto L4;
                return true;
            L4:
                if ((r2 instanceof c) == true) goto L6;
                return false;
            L6:
                if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
                return false;
            L13:
                return true;
            }
        }

        public d() {
        }
    }

    public k() {
    }
}
