package com.bytedance.android.window.shop.repository.tab.entity;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class d0 extends f {
    public static final /* synthetic */ int k = 0;
    public final List<b> j;

    public static final class a {
        public static d0 a(List r11) {
            Intrinsics.checkNotNullParameter(r11, "sortTypeDtoList");
            d0 r0 = new d0();
            Iterator r12 = r11.iterator();
        L4:
            if (r12.hasNext() == false) goto L10;
            com.bytedance.android.ec.window.base.repository.dto.q r1 = (com.bytedance.android.ec.window.base.repository.dto.q) r12.next();
            List<b> r2 = r0.j;
            int r3 = b.f;
            Intrinsics.checkNotNullParameter(r1, "dto");
            long r5 = r1.d();
            String r7 = r1.e();
            boolean r8 = r1.b();
            boolean r9 = true;
            if (r1.c() == 1) goto L9;
            r9 = false;
        L9:
            ArrayList r4 = (ArrayList) r2;
            r4.add(new b(r5, r7, r8, r9, r1.f()));
            goto L4
        L10:
            return r0;
        }
    }

    public static final class b {
        public static final /* synthetic */ int f = 0;
        public final long a;
        public final String b;
        public final boolean c;
        public boolean d;
        public boolean e;

        public static final class a {
        }

        static {
        }

        public final boolean equals(Object r6) {
            if (this != r6) goto L4;
            return true;
        L4:
            if ((r6 instanceof b) == false) goto L16;
            b r7 = (b) r6;
            if (this.a == r7.a) goto L8;
            return false;
        L8:
            if (Intrinsics.areEqual(this.b, r7.b) == true) goto L10;
            return false;
        L10:
            if (this.c == r7.c) goto L12;
            return false;
        L12:
            if (this.d == r7.d) goto L14;
            return false;
        L14:
            if (this.e == r7.e) goto L25;
            return false;
        L25:
            return true;
        L16:
            return false;
        }

        /* JADX WARN: Multi-variable type inference failed */
        /* JADX WARN: Type inference failed for: r0v10 */
        /* JADX WARN: Type inference failed for: r0v11 */
        /* JADX WARN: Type inference failed for: r0v13 */
        /* JADX WARN: Type inference failed for: r0v14 */
        /* JADX WARN: Type inference failed for: r0v6, types: [int] */
        /* JADX WARN: Type inference failed for: r0v8, types: [int] */
        /* JADX WARN: Type inference failed for: r1v4, types: [int] */
        /* JADX WARN: Type inference failed for: r1v6, types: [int] */
        /* JADX WARN: Type inference failed for: r1v8, types: [int] */
        /* JADX WARN: Type inference failed for: r2v2 */
        /* JADX WARN: Type inference failed for: r2v3, types: [int] */
        /* JADX WARN: Type inference failed for: r2v4 */
        public final int hashCode() {
            long r0 = this.a;
            int r1 = ((int) (r0 ^ (r0 >>> 32))) * 31;
            String r2 = this.b;
            if (r2 == null) goto L5;
            int r3 = r2.hashCode();
        L6:
            int r4 = (r1 + r3) * 31;
            boolean r5 = this.c;
            ?? r6 = 1;
            ?? r7 = r5;
            if (r5 == false) goto L9;
            r7 = 1;
        L9:
            int r8 = (r4 + r7) * 31;
            boolean r9 = this.d;
            ?? r10 = r9;
            if (r9 == false) goto L12;
            r10 = 1;
        L12:
            int r11 = (r8 + r10) * 31;
            boolean r12 = this.e;
            if (r12 == true) goto L17;
            r6 = r12;
        L17:
            return r11 + r6;
        L5:
            r3 = 0;
            goto L6
        }

        public final String toString() {
            return "Sorter(id=" + this.a + ", title=" + this.b + ", canReverse=" + this.c + ", initialAscend=" + this.d + ", isCurrent=" + this.e + ")";
        }

        public b(long r2, String r4, boolean r5, boolean r6, boolean r7) {
            Intrinsics.checkNotNullParameter(r4, "title");
            this.a = r2;
            this.b = r4;
            this.c = r5;
            this.d = r6;
            this.e = r7;
        }
    }

    static {
    }

    public d0() {
        super(2509);
        this.j = new ArrayList();
    }

    public final void e(long r6, Boolean r8) {
        Iterator<T> r0 = this.j.iterator();
    L4:
        if (r0.hasNext() == false) goto L13;
        b r1 = (b) r0.next();
        long r2 = r1.a;
        if (r6 != r2) goto L8;
        boolean r4 = true;
    L9:
        r1.e = r4;
        if (r6 != r2) goto L4;
        if (r8 == null) goto L4;
        r1.d = r8.booleanValue();
        goto L4
    L8:
        r4 = false;
        goto L9
    }
}
