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

/* JADX INFO: loaded from: classes18.dex */
public final class d0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static boolean f235354a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Set<String> f235355b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static boolean f235356c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final Set<Function0<Boolean>> f235357d = null;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final Map<String, Set<Function0<Boolean>>> f235358e = null;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public static final Map<String, Integer> f235359f = null;

    static {
        f235355b = new LinkedHashSet();
        f235357d = new LinkedHashSet();
        f235358e = new LinkedHashMap();
        f235359f = new LinkedHashMap();
    }

    public static void c() {
        if (f235356c == true) goto L5;
        return;
    L5:
        if (f235354a == false) goto L25;
        Set<Function0<Boolean>> r100 = f235357d;
        if ((r100 instanceof Collection) == true) goto L9;
    L11:
        Iterator<T> r101 = r100.iterator();
    L13:
        if (r101.hasNext() == false) goto L17;
        if (((Boolean) ((Function0) r101.next()).invoke()).booleanValue() == false) goto L13;
        boolean r102 = true;
    L18:
        if (r102 == false) goto L26;
        f235354a = false;
        return;
    L26:
        return;
    L17:
        r102 = false;
        goto L18
    L9:
        if (r100.isEmpty() == false) goto L11;
    }

    public static void a(g0 r100) {
        if (Intrinsics.areEqual(r100, g0.b.f235371a) == false) goto L6;
        f235354a = true;
        c();
        return;
    L6:
        if ((r100 instanceof g0.a) == false) goto L8;
        g0.a r101 = (g0.a) r100;
        f235355b.add(r101.f235370a);
        b(r101.f235370a);
        return;
    L8:
        if (r100 != null) goto L11;
        return;
    L11:
        throw new NoWhenBranchMatchedException();
    }

    public static void b(String r100) {
        Set r101 = (Set) ((LinkedHashMap) f235358e).get(r100);
        if (r101 != null) goto L5;
        r101 = SetsKt.emptySet();
    L5:
        boolean r102 = false;
        if (((Number) ((LinkedHashMap) f235359f).getOrDefault(r100, 0)).intValue() > 0) goto L8;
        return;
    L8:
        if (f235355b.contains(r100) == false) goto L27;
        Set r103 = r101;
        if ((r103 instanceof Collection) == true) goto L12;
    L14:
        Iterator r104 = r103.iterator();
    L16:
        if (r104.hasNext() == false) goto L20;
        if (((Boolean) ((Function0) r104.next()).invoke()).booleanValue() == false) goto L16;
        r102 = true;
    L20:
        if (r102 == false) goto L28;
        f235355b.remove(r100);
        return;
    L28:
        return;
    L12:
        if (r103.isEmpty() == false) goto L14;
    }

    public static void d(String r100, boolean r101) {
        Intrinsics.checkNotNullParameter(r100, "folderToken");
        if (StringsKt.isBlank(r100) == false) goto L6;
        return;
    L6:
        if (r101 == false) goto L8;
        Map<String, Integer> r102 = f235359f;
        r102.put(r100, Integer.valueOf(((Number) ((LinkedHashMap) r102).getOrDefault(r100, 0)).intValue() + 1));
        b(r100);
        return;
    L8:
        Map<String, Integer> r103 = f235359f;
        int r104 = ((Number) ((LinkedHashMap) r103).getOrDefault(r100, 0)).intValue() - 1;
        if (r104 <= 0) goto L11;
        r103.put(r100, Integer.valueOf(r104));
        return;
    L11:
        r103.remove(r100);
    }
}
