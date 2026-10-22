package a78;

import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes24.dex */
public abstract class b {

    public static final class a extends b {
        public final List<String> a;

        public final boolean equals(Object r4) {
            if (this != r4) goto L6;
            return true;
        L6:
            if ((r4 instanceof a) == true) goto L9;
            return false;
        L9:
            if (Intrinsics.areEqual(this.a, ((a) r4).a) == true) goto L11;
            return false;
        L11:
            return true;
        }

        public final int hashCode() {
            return this.a.hashCode();
        }

        public final String toString() {
            return "Image(imageUris=" + this.a + ')';
        }

        public a(List<String> r2) {
            Intrinsics.checkNotNullParameter(r2, "imageUris");
            this.a = r2;
        }
    }

    /* JADX INFO: renamed from: a78.b$b, reason: collision with other inner class name */
    public static final class C0003b extends b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof C0003b) == true) goto L8;
            return false;
        L8:
            C0003b r6 = (C0003b) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Reply(questionId=" + this.a + ", withdrawContent=" + this.b + ')';
        }

        public C0003b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "questionId");
            Intrinsics.checkNotNullParameter(r3, "withdrawContent");
            this.a = r2;
            this.b = r3;
        }
    }

    public static final class c extends b {
        public final String a;
        public final String b;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof c) == true) goto L8;
            return false;
        L8:
            c r6 = (c) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.a.hashCode() * 31) + this.b.hashCode();
        }

        public final String toString() {
            return "Round(questionId=" + this.a + ", withdrawContent=" + this.b + ')';
        }

        public c(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "questionId");
            Intrinsics.checkNotNullParameter(r3, "withdrawContent");
            this.a = r2;
            this.b = r3;
        }
    }

    public b() {
    }
}
