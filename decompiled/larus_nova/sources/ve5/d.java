package ve5;

import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes18.dex */
public abstract class d {

    public static final class a extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final a f554362a = null;

        static {
            f554362a = new a();
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
            return -1205990614;
        }

        public final String toString() {
            return "Ignore";
        }

        public a() {
        }
    }

    public static final class b extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final long f554363a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof b) == true) goto L9;
            return false;
        L9:
            if (this.f554363a == ((b) r100).f554363a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            long r100 = this.f554363a;
            return (int) (r100 ^ (r100 >>> 32));
        }

        public final String toString() {
            return "Remove(botId=" + this.f554363a + ')';
        }

        public b(long r100) {
            this.f554363a = r100;
        }
    }

    public static final class c extends d {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.bytedance.ee.bear.middleground.comment.widget.b f554364a;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof c) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.f554364a, ((c) r100).f554364a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.f554364a.hashCode();
        }

        public final String toString() {
            return "Upsert(hintInfo=" + this.f554364a + ')';
        }

        public c(com.bytedance.ee.bear.middleground.comment.widget.b r100) {
            Intrinsics.checkNotNullParameter(r100, "hintInfo");
            this.f554364a = r100;
        }
    }

    public d() {
    }
}
