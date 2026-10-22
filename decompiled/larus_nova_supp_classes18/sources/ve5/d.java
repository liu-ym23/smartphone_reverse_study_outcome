package ve5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class d {

    public static final class a extends d {
        public static final a a = null;

        static {
            a = new a();
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L6;
            return true;
        L6:
            if ((r3 instanceof a) == true) goto L9;
            return false;
        L9:
            a r4 = (a) r3;
            return true;
        }

        public final int hashCode() {
            return -1205990614;
        }

        public final String toString() {
            return "Ignore";
        }

        public a() {
        }
    }

    public static final class b extends d {
        public final long a;

        public final boolean equals(Object r8) {
            if (this != r8) goto L6;
            return true;
        L6:
            if ((r8 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.a == ((b) r8).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r0 = this.a;
            return (int) (r0 ^ (r0 >>> 32));
        }

        public final String toString() {
            return "Remove(botId=" + this.a + ')';
        }

        public b(long r1) {
            this.a = r1;
        }
    }

    public static final class c extends d {
        public final com.bytedance.ee.bear.middleground.comment.widget.b a;

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
            return "Upsert(hintInfo=" + this.a + ')';
        }

        public c(com.bytedance.ee.bear.middleground.comment.widget.b r2) {
            Intrinsics.checkNotNullParameter(r2, "hintInfo");
            this.a = r2;
        }
    }

    public d() {
    }
}
