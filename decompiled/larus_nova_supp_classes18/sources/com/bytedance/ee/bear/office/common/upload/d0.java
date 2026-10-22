package com.bytedance.ee.bear.office.common.upload;

import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import kotlin.NoWhenBranchMatchedException;
import kotlin.collections.SetsKt;
import kotlin.jvm.functions.Function0;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes18.dex */
public final class d0 {
    public static boolean a;
    public static final Set<String> b = null;
    public static boolean c;
    public static final Set<Function0<Boolean>> d = null;
    public static final Map<String, Set<Function0<Boolean>>> e = null;
    public static final Map<String, Integer> f = null;

    static {
        b = new LinkedHashSet();
        d = new LinkedHashSet();
        e = new LinkedHashMap();
        f = new LinkedHashMap();
    }

    public static void c() {
        if (c == true) goto L5;
        return;
    L5:
        if (a == false) goto L25;
        Set<Function0<Boolean>> r0 = d;
        if ((r0 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r1 = r0.iterator();
    L13:
        if (r1.hasNext() == false) goto L17;
        if (((Boolean) ((Function0) r1.next()).invoke()).booleanValue() == false) goto L13;
        boolean r2 = true;
    L18:
        if (r2 == false) goto L26;
        a = false;
        return;
    L26:
        return;
    L17:
        r2 = false;
        goto L18
    L9:
        if (r0.isEmpty() == false) goto L11;
    }

    public static void a(g0 r2) {
        if (Intrinsics.areEqual(r2, g0.b.a) == false) goto L6;
        a = true;
        c();
        return;
    L6:
        if ((r2 instanceof g0.a) == false) goto L8;
        g0.a r3 = (g0.a) r2;
        b.add(r3.a);
        b(r3.a);
        return;
    L8:
        if (r2 != null) goto L11;
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public static void b(String r4) {
        Set r0 = (Set) ((LinkedHashMap) e).get(r4);
        if (r0 != null) goto L5;
        r0 = SetsKt.emptySet();
    L5:
        boolean r2 = false;
        if (((Number) ((LinkedHashMap) f).getOrDefault(r4, 0)).intValue() > 0) goto L8;
        return;
    L8:
        if (b.contains(r4) == false) goto L27;
        Set r1 = r0;
        if ((r1 instanceof Collection) == true) goto L12;
    L14:
        Iterator r3 = r1.iterator();
    L16:
        if (r3.hasNext() == false) goto L20;
        if (((Boolean) ((Function0) r3.next()).invoke()).booleanValue() == false) goto L16;
        r2 = true;
    L20:
        if (r2 == false) goto L28;
        b.remove(r4);
        return;
    L28:
        return;
    L12:
        if (r1.isEmpty() == false) goto L14;
    }

    public static void d(String r2, boolean r3) {
        Intrinsics.checkNotNullParameter(r2, "folderToken");
        if (StringsKt.isBlank(r2) == false) goto L6;
        return;
    L6:
        if (r3 == false) goto L8;
        Map<String, Integer> r4 = f;
        r4.put(r2, Integer.valueOf(((Number) ((LinkedHashMap) r4).getOrDefault(r2, 0)).intValue() + 1));
        b(r2);
        return;
    L8:
        Map<String, Integer> r5 = f;
        int r0 = ((Number) ((LinkedHashMap) r5).getOrDefault(r2, 0)).intValue() - 1;
        if (r0 <= 0) goto L11;
        r5.put(r2, Integer.valueOf(r0));
        return;
    L11:
        r5.remove(r2);
    }
}
