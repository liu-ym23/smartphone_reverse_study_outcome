package com.bytedance.ee.bear.more.office;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.office.a$a, reason: collision with other inner class name */
    public static final class C3363a extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f234682a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final OfficeLongPressDisabledDispatchReason f234683b;

        /* JADX WARN: Multi-variable type inference failed */
        public C3363a() {
            Object[] r100 = 0 == true ? 1 : 0;
            this(null, r100, 3);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C3363a) == true) goto L8;
            return false;
        L8:
            C3363a r101 = (C3363a) r100;
            if (Intrinsics.areEqual(this.f234682a, r101.f234682a) == true) goto L12;
            return false;
        L12:
            if (this.f234683b == r101.f234683b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f234682a.hashCode() * 31;
            OfficeLongPressDisabledDispatchReason r101 = this.f234683b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Disabled(tips=" + this.f234682a + ", dispatchReason=" + this.f234683b + ')';
        }

        public C3363a(String r100, OfficeLongPressDisabledDispatchReason r101) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f234682a = r100;
            this.f234683b = r101;
        }

        public /* synthetic */ C3363a(String r100, OfficeLongPressDisabledDispatchReason r101, int r102) {
            if ((r102 & 1) == 0) goto L6;
            r100 = f.c();
        L6:
            if ((r102 & 2) == 0) goto L8;
            r101 = null;
        L8:
            this(r100, r101);
        }
    }

    public static final class b extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f234684a = null;

        static {
            f234684a = new b();
        }

        public b() {
        }
    }

    public static final class c extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f234685a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f234685a, ((c) r100).f234685a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f234685a.hashCode();
        }

        public final String toString() {
            return "Loading(tips=" + this.f234685a + ')';
        }

        public c() {
            this(f.b());
        }

        public c(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f234685a = r100;
        }
    }

    public static final class d extends a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final d f234686a = null;

        static {
            f234686a = new d();
        }

        public d() {
        }
    }

    public a() {
    }
}
