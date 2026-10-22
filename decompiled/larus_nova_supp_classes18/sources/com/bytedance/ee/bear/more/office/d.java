package com.bytedance.ee.bear.more.office;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class d {

    public static final class a extends d {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends d {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((b) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Disabled(tips=" + this.a + ')';
        }

        public b() {
            this(com.bytedance.ee.bear.more.office.f.c());
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tips");
            this.a = r2;
        }
    }

    public static final class c extends d {
        public final String a;
        public final Throwable b;

        public c() {
            this(0);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            Throwable r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failed(tips=" + this.a + ", error=" + this.b + ')';
        }

        public /* synthetic */ c(int r2) {
            this(com.bytedance.ee.bear.more.office.f.a(), null);
        }

        public c(String r2, Throwable r3) {
            Intrinsics.checkNotNullParameter(r2, "tips");
            this.a = r2;
            this.b = r3;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.office.d$d, reason: collision with other inner class name */
    public static final class C0117d extends d {
        public static final C0117d a = null;

        static {
            a = new C0117d();
        }

        public C0117d() {
        }
    }

    public static final class e extends d {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f extends d {
        public static final f a = null;

        static {
            a = new f();
        }

        public f() {
        }
    }

    public d() {
    }
}
