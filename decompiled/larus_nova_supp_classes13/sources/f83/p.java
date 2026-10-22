package f83;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
public final class p {
    public Integer a;
    public final o b;
    public final Function0<com.bytedance.android.shopping.anchorv4.voavhs.head.base.e> c;
    public final Function0<l> d;
    public final Function0<com.bytedance.android.shopping.anchorv4.voavhs.head.base.g> e;

    public p() {
        this(null, null, null, 15);
    }

    public final int d() {
        Iterator<T> r0 = this.b.a.iterator();
        int r1 = 0;
    L4:
        if (r0.hasNext() == false) goto L6;
        r1 = r1 + ((com.bytedance.android.shopping.anchorv4.voavhs.head.b) r0.next()).c.size();
        goto L4
    L6:
        return r1;
    }

    public final void a(List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r7) {
        Intrinsics.checkNotNullParameter(r7, "incomingList");
        o r0 = this.b;
        r0.getClass();
        Intrinsics.checkNotNullParameter(r7, "<set-?>");
        r0.a = r7;
        Function0<l> r1 = this.d;
        if (r1 == null) goto L15;
        l r2 = (l) r1.invoke();
        if (r2 == null) goto L15;
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r3 = r7;
        ArrayList r4 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r5 = r3.iterator();
    L8:
        if (r5.hasNext() == false) goto L10;
        r4.add(((com.bytedance.android.shopping.anchorv4.voavhs.head.b) r5.next()).a);
        goto L8
    L10:
        ArrayList r6 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r3, 10));
        Iterator<T> r8 = r3.iterator();
    L12:
        if (r8.hasNext() == false) goto L14;
        r6.add(((com.bytedance.android.shopping.anchorv4.voavhs.head.b) r8.next()).b);
        goto L12
    L14:
        r2.c(r4, r7, r6);
    L15:
        b(0, true);
    }

    public final void c(int r5) {
        Function0<com.bytedance.android.shopping.anchorv4.voavhs.head.base.e> r0 = this.c;
        if (r0 == null) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.e r1 = (com.bytedance.android.shopping.anchorv4.voavhs.head.base.e) r0.invoke();
        if (r1 == null) goto L14;
        Iterator<T> r6 = this.b.a.subList(0, r5).iterator();
        int r2 = 0;
    L8:
        if (r6.hasNext() == false) goto L10;
        r2 = r2 + ((com.bytedance.android.shopping.anchorv4.voavhs.head.b) r6.next()).c.size();
        goto L8
    L10:
        r1.d(r2 + 0);
        return;
    L14:
        return;
    }

    public final void e(Integer r3) {
        if (r3 == null) goto L5;
        this.a = Integer.valueOf(r3.intValue());
    L5:
        if (this.b.b == false) goto L18;
        if (r3 != null) goto L8;
        r3 = this.a;
    L8:
        int r0 = d() - 1;
        if (r3 == null) goto L18;
        if (r3.intValue() != r0) goto L18;
        Function0<l> r4 = this.d;
        if (r4 == null) goto L24;
        l r5 = (l) r4.invoke();
        if (r5 == null) goto L25;
        r5.a(true);
        return;
    L25:
        return;
    L24:
        return;
    L18:
        Function0<l> r6 = this.d;
        if (r6 == null) goto L27;
        l r7 = (l) r6.invoke();
        if (r7 == null) goto L28;
        r7.a(false);
        return;
    L28:
        return;
    }

    public final void b(int r8, boolean r9) {
        Iterator<T> r0 = this.b.a.iterator();
        int r1 = 0;
        int r2 = r8;
    L3:
        String r4 = null;
        if (r0.hasNext() == false) goto L12;
        Object r3 = r0.next();
        int r5 = r1 + 1;
        if (r1 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.bytedance.android.shopping.anchorv4.voavhs.head.b r6 = (com.bytedance.android.shopping.anchorv4.voavhs.head.b) r3;
        if (r2 < r6.c.size()) goto L10;
        r2 = r2 - r6.c.size();
        r1 = r5;
        goto L3
    L10:
        Integer r7 = Integer.valueOf(r1);
    L13:
        if (r7 == null) goto L25;
        int r10 = r7.intValue();
        Function0<l> r11 = this.d;
        if (r11 == null) goto L26;
        l r12 = (l) r11.invoke();
        if (r12 == null) goto L27;
        Integer r13 = Integer.valueOf(r10);
        com.bytedance.android.shopping.anchorv4.voavhs.head.b r14 = (com.bytedance.android.shopping.anchorv4.voavhs.head.b) CollectionsKt.getOrNull(this.b.a, r10);
        if (r14 == null) goto L21;
        r4 = r14.b;
    L21:
        r12.b(r13, r8, r4, r9);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L12:
        r7 = null;
        goto L13
    }

    public p(Function0 r4, Function0 r5, Function0 r6, int r7) {
        if ((r7 & 1) == 0) goto L5;
        o r0 = new o(0);
    L7:
        if ((r7 & 2) == 0) goto L10;
        r4 = null;
    L10:
        if ((r7 & 4) == 0) goto L13;
        r5 = null;
    L13:
        if ((r7 & 8) == 0) goto L15;
        r6 = null;
    L15:
        Intrinsics.checkNotNullParameter(r0, "indicatorState");
        this.b = r0;
        this.c = r4;
        this.d = r5;
        this.e = r6;
        this.a = -1;
        return;
    L5:
        r0 = null;
        goto L7
    }
}
