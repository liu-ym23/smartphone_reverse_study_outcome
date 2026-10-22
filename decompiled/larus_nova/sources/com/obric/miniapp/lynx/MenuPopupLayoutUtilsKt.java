package com.obric.miniapp.lynx;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class MenuPopupLayoutUtilsKt {
    public static final int a(c6 r100) {
        return RangesKt.coerceAtLeast(r100.f398059c - r100.f398057a, 0) * RangesKt.coerceAtLeast(r100.f398060d - r100.f398058b, 0);
    }

    public static final List<l4> b(List<l4> r110) {
        Intrinsics.checkNotNullParameter(r110, "snapshots");
        List<l4> r100 = r110;
        Iterator r101 = SequencesKt.mapNotNull(SequencesKt.filter(CollectionsKt.asSequence(r100), new o4()), MenuPopupLayoutUtilsKt$normalizeMenuSnapshotsToLocal$baseBounds$2.INSTANCE).iterator();
        if (r101.hasNext() == true) goto L5;
        Object r102 = null;
    L14:
        c6 r103 = (c6) r102;
        if (r103 != null) goto L18;
        return r110;
    L18:
        if (r103.f398057a == 0) goto L20;
    L22:
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r105 = r100.iterator();
    L24:
        if (r105.hasNext() == false) goto L42;
        l4 r106 = (l4) r105.next();
        int r107 = r103.f398057a;
        int r108 = r103.f398058b;
        int r109 = r106.f398195a - r107;
        int r111 = r106.f398196b - r108;
        Integer r112 = r106.f398201g;
        if (r112 == null) goto L28;
        Integer r113 = Integer.valueOf(r112.intValue() - r107);
    L29:
        Integer r114 = r106.f398202h;
        if (r114 == null) goto L32;
        Integer r115 = Integer.valueOf(r114.intValue() - r108);
    L33:
        Integer r116 = r106.f398203i;
        if (r116 == null) goto L36;
        Integer r117 = Integer.valueOf(r116.intValue() - r107);
    L37:
        Integer r118 = r106.f398204j;
        if (r118 == null) goto L40;
        Integer r119 = Integer.valueOf(r118.intValue() - r108);
    L41:
        r104.add(new l4(r109, r111, r106.f398197c, r106.f398198d, r106.f398199e, r106.f398200f, r113, r115, r117, r119));
        goto L24
    L40:
        r119 = null;
        goto L41
    L36:
        r117 = null;
        goto L37
    L32:
        r115 = null;
        goto L33
    L28:
        r113 = null;
        goto L29
    L42:
        return r104;
    L20:
        if (r103.f398058b != 0) goto L22;
        return r110;
    L5:
        r102 = r101.next();
        if (r101.hasNext() == false) goto L14;
        int r120 = a((c6) r102);
    L9:
        Object r121 = r101.next();
        int r122 = a((c6) r121);
        if (r120 >= r122) goto L13;
        r102 = r121;
        r120 = r122;
    L13:
        if (r101.hasNext() == true) goto L9;
        goto L14
    }

    public static final c6 d(l4 r100) {
        Integer r101 = r100.f398201g;
        if (r101 == null) goto L5;
        int r102 = r101.intValue();
    L6:
        int r103 = r102;
        Integer r104 = r100.f398202h;
        if (r104 == null) goto L9;
        int r105 = r104.intValue();
    L10:
        int r106 = r105;
        Integer r107 = r100.f398203i;
        int r108 = Integer.MIN_VALUE;
        if (r107 == null) goto L13;
        int r109 = r107.intValue();
    L14:
        int r110 = Math.max(r109, r100.f398195a + r100.f398197c);
        Integer r111 = r100.f398204j;
        if (r111 == null) goto L17;
        r108 = r111.intValue();
    L17:
        int r112 = Math.max(r108, r100.f398196b + r100.f398198d);
        if (r110 <= r103) goto L23;
        if (r112 > r106) goto L22;
        return null;
    L22:
        return new c6(r103, r106, r110, r112, r100.f398199e);
    L23:
        return null;
    L13:
        r109 = Integer.MIN_VALUE;
        goto L14
    L9:
        r105 = r100.f398196b;
        goto L10
    L5:
        r102 = r100.f398195a;
        goto L6
    }

    public static final c6 e(List<c6> r100) {
        Iterator<T> r101 = r100.iterator();
        if (r101.hasNext() == false) goto L58;
        int r102 = ((c6) r101.next()).f398057a;
    L5:
        int r103 = r102;
    L7:
        if (r101.hasNext() == false) goto L11;
        r102 = ((c6) r101.next()).f398057a;
        if (r103 <= r102) goto L7;
    L11:
        Iterator<T> r104 = r100.iterator();
        if (r104.hasNext() == false) goto L56;
        int r105 = ((c6) r104.next()).f398058b;
    L14:
        int r106 = r105;
    L16:
        if (r104.hasNext() == false) goto L20;
        r105 = ((c6) r104.next()).f398058b;
        if (r106 <= r105) goto L16;
    L20:
        Iterator<T> r107 = r100.iterator();
        if (r107.hasNext() == false) goto L54;
        int r108 = ((c6) r107.next()).f398059c;
    L23:
        int r109 = r108;
    L25:
        if (r107.hasNext() == false) goto L29;
        r108 = ((c6) r107.next()).f398059c;
        if (r109 >= r108) goto L25;
    L29:
        Iterator<T> r110 = r100.iterator();
        if (r110.hasNext() == false) goto L52;
        int r111 = ((c6) r110.next()).f398060d;
    L32:
        int r112 = r111;
    L34:
        if (r110.hasNext() == false) goto L38;
        r111 = ((c6) r110.next()).f398060d;
        if (r112 >= r111) goto L34;
    L38:
        Iterator<T> r113 = r100.iterator();
        if (r113.hasNext() == false) goto L50;
        int r114 = ((c6) r113.next()).f398061e;
    L41:
        int r115 = r114;
    L43:
        if (r113.hasNext() == false) goto L48;
        r114 = ((c6) r113.next()).f398061e;
        if (r115 <= r114) goto L43;
    L48:
        return new c6(r103, r106, r109, r112, r115);
    L50:
        throw new NoSuchElementException();
    L52:
        throw new NoSuchElementException();
    L54:
        throw new NoSuchElementException();
    L56:
        throw new NoSuchElementException();
    L58:
        throw new NoSuchElementException();
    }

    public static final k4 c(List<l4> r100, int r101, int r110) {
        Intrinsics.checkNotNullParameter(r100, "snapshots");
        List<l4> r102 = r100;
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r102.iterator();
    L4:
        if (r104.hasNext() == false) goto L9;
        c6 r105 = d((l4) r104.next());
        if (r105 == null) goto L4;
        r103.add(r105);
        goto L4
    L9:
        if (r103.isEmpty() == true) goto L11;
        ArrayList r106 = new ArrayList();
        Iterator<T> r107 = r102.iterator();
    L14:
        if (r107.hasNext() == false) goto L18;
        Object r111 = r107.next();
        if (((l4) r111).f398200f == false) goto L14;
        r106.add(r111);
        goto L14
    L18:
        ArrayList r108 = new ArrayList();
        Iterator r109 = r106.iterator();
    L20:
        if (r109.hasNext() == false) goto L24;
        c6 r112 = d((l4) r109.next());
        if (r112 == null) goto L20;
        r108.add(r112);
        goto L20
    L24:
        Object r113 = null;
        if ((!r108.isEmpty()) == true) goto L28;
        r108 = null;
    L28:
        if (r108 == null) goto L30;
        c6 r114 = e(r108);
    L31:
        if (r114 != null) goto L33;
        c6 r115 = e(r103);
    L34:
        ArrayList r116 = new ArrayList();
        Iterator r117 = r103.iterator();
    L36:
        if (r117.hasNext() == false) goto L49;
        Object r118 = r117.next();
        c6 r119 = (c6) r118;
        if (r119.f398057a <= r115.f398057a) goto L40;
    L46:
        boolean r120 = false;
    L47:
        if (r120 == false) goto L36;
        r116.add(r118);
        goto L36
    L40:
        if (r119.f398058b > r115.f398058b) goto L46;
        if (r119.f398059c < r115.f398059c) goto L46;
        if (r119.f398060d < r115.f398060d) goto L46;
        r120 = true;
        goto L47
    L49:
        Iterator r121 = r116.iterator();
        if (r121.hasNext() == false) goto L61;
        r113 = r121.next();
        if (r121.hasNext() == false) goto L61;
        int r122 = a((c6) r113);
    L56:
        Object r123 = r121.next();
        int r124 = a((c6) r123);
        if (r122 <= r124) goto L60;
        r113 = r123;
        r122 = r124;
    L60:
        if (r121.hasNext() == true) goto L56;
    L61:
        c6 r125 = (c6) r113;
        if (r125 == null) goto L65;
        r115 = r125;
    L65:
        if (r114 == null) goto L67;
        int r126 = a(r114);
    L68:
        ArrayList r127 = new ArrayList();
        Iterator r128 = r116.iterator();
    L70:
        if (r128.hasNext() == false) goto L79;
        Object r129 = r128.next();
        c6 r130 = (c6) r129;
        if (r126 > 0) goto L74;
    L76:
        boolean r131 = false;
    L77:
        if (r131 == false) goto L70;
        r127.add(r129);
        goto L70
    L74:
        if (a(r130) > (r126 * 3)) goto L76;
        r131 = true;
        goto L77
    L79:
        c6 r132 = (c6) CollectionsKt.minWithOrNull(r127, ComparisonsKt.compareBy(new Function1[]{new m4(), new n4()}));
        if (r114 != null) goto L83;
    L89:
        r114 = r115;
    L91:
        int r133 = r114.f398057a;
        return new k4(r133, r114.f398058b, RangesKt.coerceAtLeast(r114.f398059c - r133, 0), RangesKt.coerceAtLeast(r114.f398060d - r114.f398058b, 0));
    L83:
        if (a(r114) == 0) goto L89;
        if (r132 == null) goto L87;
        r114 = r132;
        goto L91
    L87:
        if (a(r115) <= (a(r114) * 3)) goto L89;
    L67:
        r126 = 0;
        goto L68
    L33:
        r115 = r114;
        goto L34
    L30:
        r114 = null;
        goto L31
    L11:
        return new k4(0, 0, RangesKt.coerceAtLeast(r101, 0), RangesKt.coerceAtLeast(r110, 0));
    }
}
