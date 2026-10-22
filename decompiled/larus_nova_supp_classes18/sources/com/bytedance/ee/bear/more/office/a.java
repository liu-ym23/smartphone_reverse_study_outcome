package com.bytedance.ee.bear.more.office;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.office.a$a, reason: collision with other inner class name */
    public static final class C0116a extends a {
        public final String a;
        public final OfficeLongPressDisabledDispatchReason b;

        /* JADX WARN: Multi-variable type inference failed */
        public C0116a() {
            Object[] r0 = 0 == true ? 1 : 0;
            this(null, r0, 3);
        }

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0116a) == true) goto L8;
            return false;
        L8:
            C0116a r6 = (C0116a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            OfficeLongPressDisabledDispatchReason r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L7:
            return r0 + r2;
        L5:
            r2 = r1.hashCode();
            goto L7
        }

        public final String toString() {
            return "Disabled(tips=" + this.a + ", dispatchReason=" + this.b + ')';
        }

        public C0116a(String r2, OfficeLongPressDisabledDispatchReason r3) {
            Intrinsics.checkNotNullParameter(r2, "tips");
            this.a = r2;
            this.b = r3;
        }

        public /* synthetic */ C0116a(String r2, OfficeLongPressDisabledDispatchReason r3, int r4) {
            if ((r4 & 1) == 0) goto L6;
            r2 = f.c();
        L6:
            if ((r4 & 2) == 0) goto L8;
            r3 = null;
        L8:
            this(r2, r3);
        }
    }

    public static final class b extends a {
        public static final b a = null;

        static {
            a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {
        public final String a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((c) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Loading(tips=" + this.a + ')';
        }

        public c() {
            this(f.b());
        }

        public c(String r2) {
            Intrinsics.checkNotNullParameter(r2, "tips");
            this.a = r2;
        }
    }

    public static final class d extends a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public a() {
    }
}
