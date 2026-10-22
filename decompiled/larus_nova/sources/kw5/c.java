package kw5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public abstract class c {

    public static final class a extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f506397a = null;

        static {
            f506397a = new a();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L9;
            return false;
        L9:
            a r101 = (a) r100;
            return true;
        }

        public final int hashCode() {
            return 1191594355;
        }

        public final String toString() {
            return "EndOfFile";
        }

        public a() {
        }
    }

    public static final class b extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final hw5.a f506398a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f506398a, ((b) r100).f506398a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f506398a.hashCode();
        }

        public final String toString() {
            return "Failure(error=" + this.f506398a + ')';
        }

        public b(hw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "error");
            this.f506398a = r100;
        }
    }

    /* JADX INFO: renamed from: kw5.c$c, reason: collision with other inner class name */
    public static final class C6620c extends c {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final kw5.a f506399a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof C6620c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f506399a, ((C6620c) r100).f506399a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f506399a.hashCode();
        }

        public final String toString() {
            return "Success(audioData=" + this.f506399a + ')';
        }

        public C6620c(kw5.a r100) {
            Intrinsics.checkNotNullParameter(r100, "audioData");
            this.f506399a = r100;
        }
    }

    public c() {
    }
}
