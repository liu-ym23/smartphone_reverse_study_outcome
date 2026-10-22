package com.larus.bmhome.resource.access;

import com.larus.utils.logger.FLogger;
import com.ss.android.lark.utils.statistics.PerfLog;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.coroutines.jvm.internal.ContinuationImpl;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class p0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final /* synthetic */ int f313714a = 0;

    static {
    }

    public static Object a(f r110, h0 r111, List r112, b r113, ContinuationImpl r114) {
        Intrinsics.checkNotNullParameter(r111, PerfLog.PARAM_KEY_CONTEXT_ID);
        Intrinsics.checkNotNullParameter(r112, "builtinNodes");
        HashSet r100 = new HashSet();
        ArrayList r101 = new ArrayList();
        Iterator r115 = r112.iterator();
    L4:
        if (r115.hasNext() == false) goto L8;
        Object r102 = r115.next();
        if (r100.add(((l0) r102).getKey()) == false) goto L4;
        r101.add(r102);
        goto L4
    L8:
        List r116 = CollectionsKt.sortedWith(r101, new o0(new n0()));
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r116, 10));
        Iterator r104 = r116.iterator();
    L10:
        if (r104.hasNext() == false) goto L12;
        r103.add(((l0) r104.next()).getKey());
        goto L10
    L12:
        Set r105 = CollectionsKt.toSet(r103);
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r117 = r116.iterator();
    L14:
        if (r117.hasNext() == false) goto L16;
        l0 r107 = (l0) r117.next();
        r106.put(r107.getKey(), r107);
        goto L14
    L16:
        LinkedHashSet r118 = new LinkedHashSet();
        ArrayList r108 = new ArrayList();
    L18:
        if ((!r106.isEmpty()) == false) goto L48;
        Iterator r109 = r106.values().iterator();
    L21:
        if (r109.hasNext() == false) goto L42;
        Object r119 = r109.next();
        List<String> r120 = ((l0) r119).f();
        if ((r120 instanceof Collection) == true) goto L25;
    L27:
        Iterator<T> r121 = r120.iterator();
    L29:
        if (r121.hasNext() == false) goto L39;
        String r122 = (String) r121.next();
        boolean r123 = false;
        if (r105.contains(r122) == true) goto L33;
    L36:
        boolean r124 = true;
    L37:
        if (r124 == true) goto L29;
    L40:
        if (r123 == false) goto L21;
    L43:
        l0 r125 = (l0) r119;
        if (r125 == null) goto L45;
        r106.remove(r125.getKey());
        r118.add(r125.getKey());
        r108.add(r125);
        goto L18
    L45:
        FLogger.f375446a.w("ResourceAccessPipeline", "[sortByDependency] cyclic dependency, append remaining nodes");
        r108.addAll(r106.values());
        goto L48
    L33:
        if (r118.contains(r122) == true) goto L36;
        r124 = false;
    L39:
        r123 = true;
        goto L40
    L25:
        if (r120.isEmpty() == false) goto L27;
    L42:
        r119 = null;
    L48:
        return r113.a(r110, r111, r108, r114);
    }
}
