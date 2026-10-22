package ij3;

import com.bytedance.android.ec.model.ECUrlModel;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class b {
    public static final /* synthetic */ int b = 0;
    public final List<C0136b> a;

    public static final class a {
    }

    /* JADX INFO: renamed from: ij3.b$b, reason: collision with other inner class name */
    public static final class C0136b {
        public final String a;
        public final ECUrlModel b;
        public final String c;
        public final Integer d;

        public C0136b() {
            this(null, null, null, null);
        }

        public final boolean equals(Object r3) {
            if (this != r3) goto L4;
            return true;
        L4:
            if ((r3 instanceof C0136b) == false) goto L14;
            C0136b r4 = (C0136b) r3;
            if (Intrinsics.areEqual(this.a, r4.a) == true) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r4.b) == true) goto L10;
            return false;
        L10:
            if (Intrinsics.areEqual(this.c, r4.c) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.d, r4.d) == true) goto L22;
            return false;
        L22:
            return true;
        L14:
            return false;
        }

        public final int hashCode() {
            String r0 = this.a;
            int r1 = 0;
            if (r0 == null) goto L5;
            int r2 = r0.hashCode();
        L6:
            int r3 = r2 * 31;
            ECUrlModel r4 = this.b;
            if (r4 == null) goto L9;
            int r5 = r4.hashCode();
        L10:
            int r6 = (r3 + r5) * 31;
            String r7 = this.c;
            if (r7 == null) goto L13;
            int r8 = r7.hashCode();
        L14:
            int r9 = (r6 + r8) * 31;
            Integer r10 = this.d;
            if (r10 == null) goto L18;
            r1 = r10.hashCode();
        L18:
            return r9 + r1;
        L13:
            r8 = 0;
            goto L14
        L9:
            r5 = 0;
            goto L10
        L5:
            r2 = 0;
            goto L6
        }

        public final String toString() {
            return "MarqueeBubbleItemVO(nickName=" + this.a + ", userAvatar=" + this.b + ", marqueeText=" + this.c + ", marqueeType=" + this.d + ")";
        }

        public C0136b(String r1, ECUrlModel r2, String r3, Integer r4) {
            this.a = r1;
            this.b = r2;
            this.c = r3;
            this.d = r4;
        }
    }

    static {
    }

    public b(List<C0136b> r2) {
        Intrinsics.checkNotNullParameter(r2, "list");
        this.a = r2;
    }
}
