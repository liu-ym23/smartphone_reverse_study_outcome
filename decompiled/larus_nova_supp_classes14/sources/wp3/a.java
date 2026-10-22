package wp3;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class a extends c {
    public static final /* synthetic */ int b = 0;
    public final List<C0181a> a;

    /* JADX INFO: renamed from: wp3.a$a, reason: collision with other inner class name */
    public static final class C0181a {
        public final String a;
        public final String b;

        public C0181a() {
            this(null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0181a) == false) goto L10;
            C0181a r4 = (C0181a) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L16;
            return false;
        L16:
            return true;
        L10:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            String r4 = this.b;
            if (r4 == null) goto L10;
            r1 = r4.hashCode();
        L10:
            return r3 + r1;
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "CommentTagsVO(desc=" + this.a + ", count=" + this.b + ")";
        }

        public C0181a(String r1, String r2) {
            this.a = r1;
            this.b = r2;
        }
    }

    public static final class b {
        public static a a(List r7) {
            if (r7 != null) goto L5;
            return null;
        L5:
            ArrayList r1 = new ArrayList();
            ArrayList r2 = new ArrayList();
            Iterator r8 = r7.iterator();
        L7:
            if (r8.hasNext() == false) goto L16;
            Object r3 = r8.next();
            up3.b r4 = (up3.b) r3;
            if (r4.b() == null) goto L13;
            boolean r5 = true;
            if ((!StringsKt.isBlank(r4.b())) == false) goto L13;
        L14:
            if (r5 == false) goto L7;
            r2.add(r3);
        L13:
            r5 = false;
            goto L14
        L16:
            Iterator r9 = r2.iterator();
        L18:
            if (r9.hasNext() == false) goto L21;
            up3.b r6 = (up3.b) r9.next();
            r1.add(new C0181a(r6.b(), String.valueOf(r6.a())));
            goto L18
        L21:
            if (r1.isEmpty() == false) goto L24;
            return null;
        L24:
            return new a(r1);
        }
    }

    static {
    }

    public a(List<C0181a> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.a = r2;
    }
}
