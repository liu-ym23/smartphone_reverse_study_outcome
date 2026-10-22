package tv3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f547675a = null;

        static {
            f547675a = new a();
        }

        public a() {
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547676a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f547676a, ((b) r100).f547676a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f547676a.hashCode();
        }

        public final String toString() {
            return "Direct(toDetail=" + this.f547676a + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "toDetail");
            this.f547676a = r100;
        }
    }

    /* JADX INFO: renamed from: tv3.c$c, reason: collision with other inner class name */
    public static final class C7781c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f547677a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f547678b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final boolean f547679c;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C7781c) == true) goto L8;
            return false;
        L8:
            C7781c r101 = (C7781c) r100;
            if (Intrinsics.areEqual(this.f547677a, r101.f547677a) == true) goto L12;
            return false;
        L12:
            if (this.f547678b == r101.f547678b) goto L15;
            return false;
        L15:
            if (this.f547679c == r101.f547679c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r100 = ((this.f547677a.hashCode() * 31) + this.f547678b) * 31;
            if (this.f547679c == false) goto L5;
            int r101 = 1231;
        L7:
            return r100 + r101;
        L5:
            r101 = 1237;
            goto L7
        }

        public final String toString() {
            return "Pick(toDetail=" + this.f547677a + ", appRank=" + this.f547678b + ", isAppStore=" + this.f547679c + ')';
        }

        public C7781c(String r100, int r101, boolean r102) {
            Intrinsics.checkNotNullParameter(r100, "toDetail");
            this.f547677a = r100;
            this.f547678b = r101;
            this.f547679c = r102;
        }
    }

    public c() {
    }
}
