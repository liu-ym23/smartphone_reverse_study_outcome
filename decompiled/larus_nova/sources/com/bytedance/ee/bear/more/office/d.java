package com.bytedance.ee.bear.more.office;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f234698a = null;

        static {
            f234698a = new a();
        }

        public a() {
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f234699a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f234699a, ((b) r100).f234699a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f234699a.hashCode();
        }

        public final String toString() {
            return "Disabled(tips=" + this.f234699a + ')';
        }

        public b() {
            this(com.bytedance.ee.bear.more.office.f.c());
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f234699a = r100;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f234700a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Throwable f234701b;

        public c() {
            this(0);
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L8;
            return false;
        L8:
            c r101 = (c) r100;
            if (Intrinsics.areEqual(this.f234700a, r101.f234700a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f234701b, r101.f234701b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f234700a.hashCode() * 31;
            Throwable r101 = this.f234701b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "Failed(tips=" + this.f234700a + ", error=" + this.f234701b + ')';
        }

        public /* synthetic */ c(int r100) {
            this(com.bytedance.ee.bear.more.office.f.a(), null);
        }

        public c(String r100, Throwable r101) {
            Intrinsics.checkNotNullParameter(r100, "tips");
            this.f234700a = r100;
            this.f234701b = r101;
        }
    }

    /* JADX INFO: renamed from: com.bytedance.ee.bear.more.office.d$d, reason: collision with other inner class name */
    public static final class C3364d extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final C3364d f234702a = null;

        static {
            f234702a = new C3364d();
        }

        public C3364d() {
        }
    }

    public static final class e extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final e f234703a = null;

        static {
            f234703a = new e();
        }

        public e() {
        }
    }

    public static final class f extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final f f234704a = null;

        static {
            f234704a = new f();
        }

        public f() {
        }
    }

    public d() {
    }
}
