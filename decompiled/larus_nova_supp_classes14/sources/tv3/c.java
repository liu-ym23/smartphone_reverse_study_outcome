package tv3;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public abstract class c {

    public static final class a extends c {
        public static final a a = null;

        static {
            a = new a();
        }

        public a() {
        }
    }

    public static final class b extends c {
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
            return "Direct(toDetail=" + this.a + ')';
        }

        public b(String r2) {
            Intrinsics.checkNotNullParameter(r2, "toDetail");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: tv3.c$c, reason: collision with other inner class name */
    public static final class C0175c extends c {
        public final String a;
        public final int b;
        public final boolean c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0175c) == true) goto L8;
            return false;
        L8:
            C0175c r6 = (C0175c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (this.b == r6.b) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            int r0 = ((this.a.hashCode() * 31) + this.b) * 31;
            if (this.c == false) goto L5;
            int r1 = 1231;
        L7:
            return r0 + r1;
        L5:
            r1 = 1237;
            goto L7
        }

        public final String toString() {
            return "Pick(toDetail=" + this.a + ", appRank=" + this.b + ", isAppStore=" + this.c + ')';
        }

        public C0175c(String r2, int r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "toDetail");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public c() {
    }
}
