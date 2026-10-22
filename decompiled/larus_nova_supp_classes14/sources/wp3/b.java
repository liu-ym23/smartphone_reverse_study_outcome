package wp3;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b extends c {
    public static final /* synthetic */ int d = 0;
    public final List<C0182b> a;
    public final String b;
    public final String c;

    public static final class a {
        public static b a(List r7, up3.c r8) {
            if (r7 != null) goto L5;
            return null;
        L5:
            if (r8 != null) goto L7;
            return null;
        L7:
            ArrayList r1 = new ArrayList();
            Iterator r9 = r7.iterator();
        L9:
            if (r9.hasNext() == false) goto L26;
            Object r2 = r9.next();
            up3.d r3 = (up3.d) r2;
            ECUrlModel r4 = r3.b();
            boolean r5 = false;
            if (r4 == null) goto L24;
            String r6 = r4.getFirstUrl();
            if (r6 == null) goto L24;
            if (r6.length() <= 0) goto L17;
            boolean r10 = true;
        L18:
            if (r10 != true) goto L24;
            String r11 = r3.a();
            if (r11 == null) goto L24;
            if ((!StringsKt.isBlank(r11)) != true) goto L24;
            r5 = true;
            goto L24
        L17:
            r10 = false;
        L24:
            if (r5 == false) goto L9;
            r1.add(r2);
            goto L9
        L26:
            ArrayList r12 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r1, 10));
            Iterator r13 = r1.iterator();
        L27:
            String r14 = "";
            if (r13.hasNext() == false) goto L42;
            up3.d r15 = (up3.d) r13.next();
            String r16 = r15.a();
            if (r16 == null) goto L39;
            ECUrlModel r17 = r15.b();
            if (r17 == null) goto L34;
            String r18 = r17.getFirstUrl();
        L35:
            if (r18 == null) goto L38;
            r14 = r18;
        L38:
            C0182b r19 = new C0182b(r14, r16);
        L40:
            r12.add(r19);
            goto L27
        L34:
            r18 = null;
            goto L35
        L39:
            r19 = null;
            goto L40
        L42:
            if (r12.isEmpty() == false) goto L44;
            return null;
        L44:
            String r20 = r8.a();
            if (r20 == null) goto L49;
            r14 = r20;
        L49:
            return new b(r12, r14, r8.b());
        }
    }

    /* JADX INFO: renamed from: wp3.b$b, reason: collision with other inner class name */
    public static final class C0182b {
        public final String a;
        public final String b;

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0182b) == false) goto L10;
            C0182b r4 = (C0182b) r3;
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
            return "ECCommentVO(authorAvatar=" + this.a + ", comment=" + this.b + ")";
        }

        public C0182b(String r2, String r3) {
            Intrinsics.checkNotNullParameter(r2, "authorAvatar");
            Intrinsics.checkNotNullParameter(r3, "comment");
            this.a = r2;
            this.b = r3;
        }
    }

    static {
    }

    public b(List<C0182b> r2, String r3, String r4) {
        Intrinsics.checkNotNullParameter(r2, "list");
        Intrinsics.checkNotNullParameter(r3, "hotCommentCountDesc");
        this.a = r2;
        this.b = r3;
        this.c = r4;
    }
}
