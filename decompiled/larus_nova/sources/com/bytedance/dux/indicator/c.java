package com.bytedance.dux.indicator;

import em4.d;
import java.util.Iterator;
import kotlin.collections.IntIterator;
import kotlin.ranges.IntRange;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes15.dex */
public abstract class c {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f205224a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public int f205225b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public int f205226c;

    public abstract void a();

    public abstract int b();

    public abstract void d(int r100, int r101, float r102);

    public abstract void e(int r100);

    public c() {
        this.f205224a = "OnPageChangeHelper";
        this.f205225b = -1;
        this.f205226c = -1;
    }

    public final void c(int r100, float r110) {
        float r101 = r100 + r110;
        float r111 = b() - 1;
        int r102 = 0;
        if (r101 != r111) goto L5;
        boolean r103 = true;
    L6:
        if (r103 == false) goto L8;
        r101 = r111 - 1.0E-4f;
    L8:
        int r104 = (int) r101;
        int r105 = r104 + 1;
        float r106 = r105;
        if (r106 <= r111) goto L11;
        a();
    L60:
        d(r104, r102, r101 % 1);     // Catch: Exception -> L18
    L23:
        int r107 = this.f205225b;
        if (r107 == (-1)) goto L54;
        if (r104 <= r107) goto L38;
        Iterator<Integer> r108 = RangesKt.until(r107, r104).iterator();
    L28:
        if (r108.hasNext() == false) goto L38;
        int r109 = ((IntIterator) r108).nextInt();
        if (r109 == r102) goto L28;
        e(r109);     // Catch: Exception -> L33
    L33:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == true) goto L36;
        int r112 = d.f473061a;
        d.b(this.f205224a, "抓住了一个Exception并ignore");
        goto L28
    L36:
        int r113 = d.f473061a;
        d.b(this.f205224a, "DuxIndicator: " + e.getMessage());
    L38:
        int r114 = this.f205226c;
        if (r102 >= r114) goto L54;
        if (r114 > r111) goto L54;
        Iterator<Integer> r115 = new IntRange(r102 + 1, this.f205226c).iterator();
    L44:
        if (r115.hasNext() == false) goto L54;
        int r116 = ((IntIterator) r115).nextInt();
        if (r116 == r104) goto L44;
        e(r116);     // Catch: Exception -> L49
    L49:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == true) goto L52;
        int r117 = d.f473061a;
        d.b(this.f205224a, "抓住了一个Exception并ignore");
        goto L44
    L52:
        int r118 = d.f473061a;
        d.b(this.f205224a, "DuxIndicator: " + e.getMessage());
    L54:
        this.f205225b = r104;
        this.f205226c = r102;
        return;
    L18:
        e = move-exception;
        if ((e instanceof IndexOutOfBoundsException) == false) goto L22;
        int r119 = d.f473061a;
        d.b(this.f205224a, "DuxIndicator: " + e.getMessage());
        goto L23
    L22:
        int r120 = d.f473061a;
        d.b(this.f205224a, "抓住了一个Exception并ignore");
        goto L23
    L11:
        if (r106 > r111) goto L78;
        if (r104 == (-1)) goto L79;
        r102 = r105;
        goto L60
    L79:
        return;
    L78:
        return;
    L5:
        r103 = false;
        goto L6
    }
}
