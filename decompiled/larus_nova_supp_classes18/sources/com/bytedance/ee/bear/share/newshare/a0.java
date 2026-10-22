package com.bytedance.ee.bear.share.newshare;

import com.bytedance.ee.docsdk.impl.document.plugins.offline.storage.ResourceData;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public abstract class a0 {

    public static final class a extends a0 {
        public final d0 a;
        public final String b;
        public final boolean c;
        public final boolean d;
        public final boolean e;

        public final boolean equals(Object r5) {
            if (this != r5) goto L6;
            return true;
        L6:
            if ((r5 instanceof a) == true) goto L8;
            return false;
        L8:
            a r6 = (a) r5;
            if (Intrinsics.areEqual(this.a, r6.a) == true) goto L12;
            return false;
        L12:
            if (Intrinsics.areEqual(this.b, r6.b) == true) goto L15;
            return false;
        L15:
            if (this.c == r6.c) goto L18;
            return false;
        L18:
            if (this.d == r6.d) goto L21;
            return false;
        L21:
            if (this.e == r6.e) goto L23;
            return false;
        L23:
            return true;
        }

        public final int hashCode() {
            int r0 = this.a.hashCode() * 31;
            String r1 = this.b;
            if (r1 != null) goto L5;
            int r2 = 0;
        L6:
            int r3 = (r0 + r2) * 31;
            int r4 = 1231;
            if (this.c == false) goto L9;
            int r5 = 1231;
        L10:
            int r6 = (r3 + r5) * 31;
            if (this.d == false) goto L13;
            int r7 = 1231;
        L14:
            int r8 = (r6 + r7) * 31;
            if (this.e == true) goto L19;
            r4 = 1237;
        L19:
            return r8 + r4;
        L13:
            r7 = 1237;
            goto L14
        L9:
            r5 = 1237;
            goto L10
        L5:
            r2 = r1.hashCode();
            goto L6
        }

        public final String toString() {
            return "LinearGroup(listItems=" + this.a + ", title=" + this.b + ", useBackgroundColor=" + this.c + ", usePadding=" + this.d + ", useMarginTop=" + this.e + ')';
        }

        public a(d0 r2, boolean r3, boolean r4, boolean r5) {
            Intrinsics.checkNotNullParameter(r2, "listItems");
            this.a = r2;
            this.b = null;
            this.c = r3;
            this.d = r4;
            this.e = r5;
        }
    }

    public static final class b extends a0 {
        public final String a;

        public b() {
            this(0);
        }

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
            return "Normal(id=" + this.a + ')';
        }

        public b(int r2) {
            Intrinsics.checkNotNullParameter("", ResourceData.KEY_ID);
            this.a = "";
        }
    }

    public a0() {
    }
}
