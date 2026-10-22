package ar5;

import com.bytedance.ee.bear.wikiv2.wikitreev2.widget.model.e3;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class b {

    public static final class a extends b {
        public final boolean a;

        public a() {
            this(false);
        }

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (this.a == ((a) r4).a) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            if (this.a == false) goto L5;
            return 1231;
        L5:
            return 1237;
        }

        public final String toString() {
            return "Fallback(legacyValid=" + this.a + ')';
        }

        public a(boolean r1) {
            this.a = r1;
        }
    }

    /* JADX INFO: renamed from: ar5.b$b, reason: collision with other inner class name */
    public static final class C0004b extends b {
        public final e3 a;
        public final d b;
        public final String c;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0004b) == true) goto L8;
            return false;
        L8:
            C0004b r6 = (C0004b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (Intrinsics.areEqual(this.c, r6.c) == true) goto L17;
            return false;
        L17:
            return true;
        }

        public final int hashCode() {
            return (((this.a.hashCode() * 31) + this.b.hashCode()) * 31) + this.c.hashCode();
        }

        public final String toString() {
            return "Success(workspace=" + this.a + ", visiblePath=" + this.b + ", targetUid=" + this.c + ')';
        }

        public C0004b(e3 r2, d r3, String r4) {
            Intrinsics.checkNotNullParameter(r2, "workspace");
            Intrinsics.checkNotNullParameter(r3, "visiblePath");
            Intrinsics.checkNotNullParameter(r4, "targetUid");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public b() {
    }
}
