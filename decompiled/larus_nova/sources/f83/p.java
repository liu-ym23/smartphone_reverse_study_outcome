package f83;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes13.dex */
public final class p {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Integer f475864a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f475865b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Function0<com.bytedance.android.shopping.anchorv4.voavhs.head.base.e> f475866c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Function0<l> f475867d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Function0<com.bytedance.android.shopping.anchorv4.voavhs.head.base.g> f475868e;

    public p() {
        this(null, null, null, 15);
    }

    public final int d() {
        Iterator<T> r100 = this.f475865b.f475862a.iterator();
        int r101 = 0;
    L4:
        if (r100.hasNext() == false) goto L6;
        r101 = r101 + ((com.bytedance.android.shopping.anchorv4.voavhs.head.b) r100.next()).f168486c.size();
        goto L4
    L6:
        return r101;
    }

    public final void a(List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r100) {
        Intrinsics.checkNotNullParameter(r100, "incomingList");
        o r101 = this.f475865b;
        r101.getClass();
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        r101.f475862a = r100;
        Function0<l> r102 = this.f475867d;
        if (r102 == null) goto L15;
        l r103 = r102.invoke();
        if (r103 == null) goto L15;
        List<com.bytedance.android.shopping.anchorv4.voavhs.head.b> r104 = r100;
        ArrayList r105 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r106 = r104.iterator();
    L8:
        if (r106.hasNext() == false) goto L10;
        r105.add(((com.bytedance.android.shopping.anchorv4.voavhs.head.b) r106.next()).f168484a);
        goto L8
    L10:
        ArrayList r107 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r104, 10));
        Iterator<T> r108 = r104.iterator();
    L12:
        if (r108.hasNext() == false) goto L14;
        r107.add(((com.bytedance.android.shopping.anchorv4.voavhs.head.b) r108.next()).f168485b);
        goto L12
    L14:
        r103.c(r105, r100, r107);
    L15:
        b(0, true);
    }

    public final void c(int r100) {
        Function0<com.bytedance.android.shopping.anchorv4.voavhs.head.base.e> r101 = this.f475866c;
        if (r101 == null) goto L13;
        com.bytedance.android.shopping.anchorv4.voavhs.head.base.e r102 = r101.invoke();
        if (r102 == null) goto L14;
        Iterator<T> r103 = this.f475865b.f475862a.subList(0, r100).iterator();
        int r104 = 0;
    L8:
        if (r103.hasNext() == false) goto L10;
        r104 = r104 + ((com.bytedance.android.shopping.anchorv4.voavhs.head.b) r103.next()).f168486c.size();
        goto L8
    L10:
        r102.d(r104 + 0);
        return;
    L14:
        return;
    }

    public final void e(Integer r100) {
        if (r100 == null) goto L5;
        this.f475864a = Integer.valueOf(r100.intValue());
    L5:
        if (this.f475865b.f475863b == false) goto L18;
        if (r100 != null) goto L8;
        r100 = this.f475864a;
    L8:
        int r101 = d() - 1;
        if (r100 == null) goto L18;
        if (r100.intValue() != r101) goto L18;
        Function0<l> r102 = this.f475867d;
        if (r102 == null) goto L24;
        l r103 = r102.invoke();
        if (r103 == null) goto L25;
        r103.a(true);
        return;
    L25:
        return;
    L24:
        return;
    L18:
        Function0<l> r104 = this.f475867d;
        if (r104 == null) goto L27;
        l r105 = r104.invoke();
        if (r105 == null) goto L28;
        r105.a(false);
        return;
    L28:
        return;
    }

    public final void b(int r100, boolean r101) {
        Iterator<T> r102 = this.f475865b.f475862a.iterator();
        int r103 = 0;
        int r104 = r100;
    L3:
        String r105 = null;
        if (r102.hasNext() == false) goto L12;
        Object r106 = r102.next();
        int r107 = r103 + 1;
        if (r103 >= 0) goto L8;
        CollectionsKt.throwIndexOverflow();
    L8:
        com.bytedance.android.shopping.anchorv4.voavhs.head.b r108 = (com.bytedance.android.shopping.anchorv4.voavhs.head.b) r106;
        if (r104 < r108.f168486c.size()) goto L10;
        r104 = r104 - r108.f168486c.size();
        r103 = r107;
        goto L3
    L10:
        Integer r109 = Integer.valueOf(r103);
    L13:
        if (r109 == null) goto L25;
        int r110 = r109.intValue();
        Function0<l> r111 = this.f475867d;
        if (r111 == null) goto L26;
        l r112 = r111.invoke();
        if (r112 == null) goto L27;
        Integer r113 = Integer.valueOf(r110);
        com.bytedance.android.shopping.anchorv4.voavhs.head.b r114 = (com.bytedance.android.shopping.anchorv4.voavhs.head.b) CollectionsKt.getOrNull(this.f475865b.f475862a, r110);
        if (r114 == null) goto L21;
        r105 = r114.f168485b;
    L21:
        r112.b(r113, r100, r105, r101);
        return;
    L27:
        return;
    L26:
        return;
    L25:
        return;
    L12:
        r109 = null;
        goto L13
    }

    public p(Function0 r100, Function0 r101, Function0 r102, int r103) {
        if ((r103 & 1) == 0) goto L5;
        o r104 = new o(0);
    L7:
        if ((r103 & 2) == 0) goto L10;
        r100 = null;
    L10:
        if ((r103 & 4) == 0) goto L13;
        r101 = null;
    L13:
        if ((r103 & 8) == 0) goto L15;
        r102 = null;
    L15:
        Intrinsics.checkNotNullParameter(r104, "indicatorState");
        this.f475865b = r104;
        this.f475866c = r100;
        this.f475867d = r101;
        this.f475868e = r102;
        this.f475864a = -1;
        return;
    L5:
        r104 = null;
        goto L7
    }
}
