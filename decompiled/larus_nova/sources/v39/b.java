package v39;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
public abstract class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final int f552955a;

    public static final class a extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final a f552956b = null;

        static {
            f552956b = new a();
        }

        public a() {
            super(-3);
        }
    }

    /* JADX INFO: renamed from: v39.b$b, reason: collision with other inner class name */
    public static final class C7961b extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v39.a f552957b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7961b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f552957b, ((C7961b) r100).f552957b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f552957b.hashCode();
        }

        public final String toString() {
            return "FrameLoss(remoteData=" + this.f552957b + ')';
        }

        public C7961b(v39.a r100) {
            Intrinsics.checkNotNullParameter(r100, "remoteData");
            super(-8);
            this.f552957b = r100;
        }
    }

    public static final class c extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final c f552958b = null;

        static {
            f552958b = new c();
        }

        public c() {
            super(-3);
        }
    }

    public static final class d extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final d f552959b = null;

        static {
            f552959b = new d();
        }

        public d() {
            super(-8);
        }
    }

    public static final class e extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public static final e f552960b = null;

        static {
            f552960b = new e();
        }

        public e() {
            super(-3);
        }
    }

    public static final class f extends b {

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final v39.a f552961b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof f) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f552961b, ((f) r100).f552961b) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f552961b.hashCode();
        }

        public final String toString() {
            return "Success(remoteData=" + this.f552961b + ')';
        }

        public f(v39.a r100) {
            Intrinsics.checkNotNullParameter(r100, "remoteData");
            super(0);
            this.f552961b = r100;
        }
    }

    public b(int r100) {
        this.f552955a = r100;
    }
}
