package com.obric.assistant.omnidetailpage.localmedia;

import android.graphics.Rect;
import android.view.View;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.Pair;
import kotlin.TuplesKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;

/* JADX INFO: loaded from: classes33.dex */
public final class w {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final LinkedHashSet<y> f390857a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<y, Object> f390858b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Set<y> f390859c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public y f390860d;

    public static final class a {
    }

    static {
    }

    public final void a() {
        LinkedHashSet<y> r100 = this.f390857a;
        Set<y> r101 = this.f390859c;
        ArrayList r102 = new ArrayList();
        Iterator<T> r103 = r100.iterator();
    L4:
        if (r103.hasNext() == false) goto L8;
        Object r104 = r103.next();
        if (r101.contains((y) r104) == true) goto L4;
        r102.add(r104);
        goto L4
    L8:
        ArrayList r105 = new ArrayList();
        Iterator r106 = r102.iterator();
    L9:
        y r107 = null;
        Pair r108 = null;
        if (r106.hasNext() == false) goto L35;
        y r109 = (y) r106.next();
        View r110 = r109.H0();
        boolean r111 = false;
        if (r110.isShown() == true) goto L14;
    L24:
        float r112 = 0.0f;
    L26:
        if (r112 < 0.5f) goto L28;
        r111 = true;
    L28:
        if (r111 == true) goto L31;
        r109 = null;
    L31:
        if (r109 == null) goto L33;
        r108 = TuplesKt.to(r109, Float.valueOf(r112));
    L33:
        if (r108 == null) goto L9;
        r105.add(r108);
        goto L9
    L14:
        if (r110.getWidth() <= 0) goto L24;
        if (r110.getHeight() <= 0) goto L24;
        Rect r113 = new Rect();
        if (r110.getGlobalVisibleRect(r113) == false) goto L24;
        int r114 = RangesKt.coerceAtLeast(r113.width(), 0) * RangesKt.coerceAtLeast(r113.height(), 0);
        int r115 = r110.getWidth() * r110.getHeight();
        if (r115 <= 0) goto L24;
        r112 = r114 / r115;
        goto L26
    L35:
        Iterator r116 = r105.iterator();
        if (r116.hasNext() == true) goto L38;
        Object r117 = null;
    L47:
        Pair r118 = (Pair) r117;
        if (r118 == null) goto L50;
        r107 = (y) r118.getFirst();
    L50:
        if (r107 != null) goto L54;
        b();
        return;
    L54:
        if (Intrinsics.areEqual(this.f390860d, r107) == false) goto L56;
        return;
    L56:
        y r119 = this.f390860d;
        if (r119 == null) goto L59;
        r119.R3();
    L59:
        this.f390860d = r107;
        r107.r0();
        return;
    L38:
        r117 = r116.next();
        if (r116.hasNext() == false) goto L47;
        float r120 = ((Number) ((Pair) r117).getSecond()).floatValue();
    L42:
        Object r121 = r116.next();
        float r122 = ((Number) ((Pair) r121).getSecond()).floatValue();
        if (Float.compare(r120, r122) >= 0) goto L46;
        r117 = r121;
        r120 = r122;
    L46:
        if (r116.hasNext() == true) goto L42;
        goto L47
    }

    public final void b() {
        y r100 = this.f390860d;
        if (r100 == null) goto L5;
        r100.R3();
    L5:
        this.f390860d = null;
    }

    public w() {
        this.f390857a = new LinkedHashSet();
        this.f390858b = new LinkedHashMap();
        this.f390859c = new LinkedHashSet();
    }

    public final void c(y r100) {
        Intrinsics.checkNotNullParameter(r100, "holder");
        boolean r101 = this.f390857a.remove(r100);
        this.f390858b.remove(r100);
        this.f390859c.remove(r100);
        if (Intrinsics.areEqual(this.f390860d, r100) == false) goto L5;
        this.f390860d = null;
    L5:
        if (r101 == false) goto L8;
        r100.i3();
        return;
    }
}
