package com.larus.avlink.aiproactive;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public interface i0 {

    public static final class a implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f291575a = null;

        static {
            f291575a = new a();
        }

        public a() {
        }
    }

    public static final class b implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final b f291576a = null;

        static {
            f291576a = new b();
        }

        public b() {
        }
    }

    public static final class c implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final c f291577a = null;

        static {
            f291577a = new c();
        }

        public c() {
        }
    }

    public static final class d implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f291578a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof d) == true) goto L9;
            return false;
        L9:
            if (this.f291578a == ((d) r100).f291578a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f291578a;
        }

        public final String toString() {
            return "ParseDraftFailed(resId=" + this.f291578a + ')';
        }

        public d(int r100) {
            this.f291578a = r100;
        }
    }

    public static final class e implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final t88.o f291579a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Long f291580b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof e) == true) goto L8;
            return false;
        L8:
            e r101 = (e) r100;
            if (Intrinsics.areEqual(this.f291579a, r101.f291579a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.f291580b, r101.f291580b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            int r100 = this.f291579a.hashCode() * 31;
            Long r101 = this.f291580b;
            if (r101 != null) goto L5;
            int r102 = 0;
        L7:
            return r100 + r102;
        L5:
            r102 = r101.hashCode();
            goto L7
        }

        public final String toString() {
            return "ParseDraftSuccess(draft=" + this.f291579a + ", editTaskId=" + this.f291580b + ')';
        }

        public e(t88.o r100, Long r101) {
            Intrinsics.checkNotNullParameter(r100, "draft");
            this.f291579a = r100;
            this.f291580b = r101;
        }
    }

    public static final class f implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final int f291581a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (this.f291581a == ((f) r100).f291581a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f291581a;
        }

        public final String toString() {
            return "ShowToastRes(resId=" + this.f291581a + ')';
        }

        public f(int r100) {
            this.f291581a = r100;
        }
    }

    public static final class g implements i0 {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f291582a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof g) == true) goto L9;
            return false;
        L9:
            if (this.f291582a == ((g) r100).f291582a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f291582a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "SwitchChangeFailed(taskId=" + this.f291582a + ')';
        }

        public g(long r100) {
            this.f291582a = r100;
        }
    }
}
