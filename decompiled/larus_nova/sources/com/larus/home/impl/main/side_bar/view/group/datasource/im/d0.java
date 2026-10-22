package com.larus.home.impl.main.side_bar.view.group.datasource.im;

import com.bytedance.mt.protector.impl.collections.ListProtector;
import com.larus.im.internal.jni.bean.OmniConversationSortType;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import kotlin.collections.SetsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Set<Integer> f345337a = null;

    static {
        f345337a = SetsKt.setOf(new Integer[]{20, 24, 22});
    }

    public static final int b(int r100, int r101) {
        if (r100 < (Integer.MAX_VALUE - r101)) goto L6;
        return Integer.MAX_VALUE;
    L6:
        return r100 + r101;
    }

    public static final zb9.i c(u0 r110) {
        Iterator<T> r100 = r110.f345395b.iterator();
        long r101 = 0;
        if (r100.hasNext() == true) goto L5;
        Long r102 = null;
    L28:
        if (r102 == null) goto L31;
        r101 = r102.longValue();
    L31:
        return new zb9.i(r110, r101, 0, 0, false, 24);
    L5:
        wh8.a r103 = ((com.larus.home.impl.main.side_bar.data.j0) r100.next()).f344507b;
        if (r103 == null) goto L12;
        wc9.e r104 = r103.f559708a;
        if (r104 == null) goto L12;
        Long r105 = r104.f559201d;
        if (r105 == null) goto L12;
        long r106 = r105.longValue();
    L13:
        Long r107 = Long.valueOf(r106);
    L15:
        if (r100.hasNext() == false) goto L27;
        wh8.a r108 = ((com.larus.home.impl.main.side_bar.data.j0) r100.next()).f344507b;
        if (r108 == null) goto L23;
        wc9.e r109 = r108.f559708a;
        if (r109 == null) goto L23;
        Long r111 = r109.f559201d;
        if (r111 == null) goto L23;
        long r112 = r111.longValue();
    L24:
        Long r113 = Long.valueOf(r112);
        if (r107.compareTo(r113) >= 0) goto L15;
        r107 = r113;
    L23:
        r112 = 0;
        goto L24
    L27:
        r102 = r107;
    L12:
        r106 = 0;
        goto L13
    }

    public static final void a(List r100, wc9.e r101, OmniConversationSortType r110) {
        long r102 = p.b(r101, r110);
        int r103 = r100.size();
        int r104 = r100.size();
        int r105 = 0;
    L3:
        if (r105 >= r104) goto L8;
        if (p.b((wc9.e) ListProtector.get(r100, r105), r110) < r102) goto L6;
        r105 = r105 + 1;
        goto L3
    L6:
        r103 = r105;
    L8:
        ListProtector.add(r100, r103, r101);
    }
}
