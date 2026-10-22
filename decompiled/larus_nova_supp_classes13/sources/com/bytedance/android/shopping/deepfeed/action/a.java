package com.bytedance.android.shopping.deepfeed.action;

import java.util.List;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public abstract class a {

    /* JADX INFO: renamed from: com.bytedance.android.shopping.deepfeed.action.a$a, reason: collision with other inner class name */
    public static final class C0049a extends a {
        public final String a;
        public final List<String> b;
        public final boolean c;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0049a) == false) goto L12;
            C0049a r4 = (C0049a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r4.c) goto L19;
            return false;
        L19:
            return true;
        L12:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v3, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4 */
        /* JADX WARN: Type inference failed for: r1v6 */
        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            List<String> r4 = this.b;
            if (r4 == null) goto L9;
            r1 = r4.hashCode();
        L9:
            int r5 = (r3 + r1) * 31;
            boolean r6 = this.c;
            ?? r7 = r6;
            if (r6 == false) goto L13;
            r7 = 1;
        L13:
            return r5 + r7;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "AiRec(aiText=" + this.a + ", aiFeature=" + this.b + ", insertLoadingCard=" + this.c + ")";
        }

        public C0049a(String r2, List<String> r3, boolean r4) {
            Intrinsics.checkNotNullParameter(r2, "aiText");
            Intrinsics.checkNotNullParameter(r3, "aiFeature");
            this.a = r2;
            this.b = r3;
            this.c = r4;
        }
    }

    public static final class b extends a {
        public final Function1<Boolean, Unit> a;

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof b) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((b) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            Function1<Boolean, Unit> r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Collect(collectStateChange=" + this.a + ")";
        }

        /* JADX WARN: Multi-variable type inference failed */
        public b(Function1<? super Boolean, Unit> r2) {
            Intrinsics.checkNotNullParameter(r2, "collectStateChange");
            this.a = r2;
        }
    }

    public static final class c extends a {
        public final DeepFeedCommentClickArea a;

        public c() {
            this(0);
        }

        public final boolean equals(Object r2) {
            if (this != r2) goto L4;
            return true;
        L4:
            if ((r2 instanceof c) == true) goto L6;
            return false;
        L6:
            if (Intrinsics.areEqual(this.a, ((c) r2).a) == true) goto L13;
            return false;
        L13:
            return true;
        }

        public final int hashCode() {
            DeepFeedCommentClickArea r0 = this.a;
            if (r0 != null) goto L7;
            return 0;
        L7:
            return r0.hashCode();
        }

        public final String toString() {
            return "Comment(area=" + this.a + ")";
        }

        public c(int r2) {
            DeepFeedCommentClickArea r3 = DeepFeedCommentClickArea.Container;
            Intrinsics.checkNotNullParameter(r3, "area");
            this.a = r3;
        }
    }

    public static final class d extends a {
        public static final d a = null;

        static {
            a = new d();
        }

        public d() {
        }
    }

    public static final class e extends a {
        public static final e a = null;

        static {
            a = new e();
        }

        public e() {
        }
    }

    public static final class f extends a {
    }

    public static final class g extends a {
        public static final g a = null;

        static {
            a = new g();
        }

        public g() {
        }
    }

    public static final class h extends a {
        public static final h a = null;

        static {
            a = new h();
        }

        public h() {
        }
    }

    public static final class i extends a {
        public static final i a = null;

        static {
            a = new i();
        }

        public i() {
        }
    }

    public a() {
    }
}
