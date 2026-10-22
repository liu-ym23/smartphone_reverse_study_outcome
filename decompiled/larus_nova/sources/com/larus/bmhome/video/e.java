package com.larus.bmhome.video;

import com.larus.utils.logger.FLogger;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.CopyOnWriteArraySet;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
public final class e {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final Map<String, CopyOnWriteArrayList<g>> f315241a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final Map<String, CopyOnWriteArrayList<String>> f315242b = null;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final Map<String, CopyOnWriteArraySet<String>> f315243c = null;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final CopyOnWriteArraySet<String> f315244d = null;

    static {
        f315241a = new LinkedHashMap();
        f315242b = new LinkedHashMap();
        f315243c = new LinkedHashMap();
        f315244d = new CopyOnWriteArraySet();
    }

    public static void d(String r110) {
        Intrinsics.checkNotNullParameter(r110, "scene");
        Map<String, CopyOnWriteArrayList<g>> r100 = f315241a;
        CopyOnWriteArrayList r101 = (CopyOnWriteArrayList) ((LinkedHashMap) r100).get(r110);
        if (r101 == null) goto L5;
        r101.clear();
    L5:
        r100.remove(r110);
        Map<String, CopyOnWriteArrayList<String>> r102 = f315242b;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) ((LinkedHashMap) r102).get(r110);
        if (r103 == null) goto L8;
        r103.clear();
    L8:
        r102.remove(r110);
        f315244d.clear();
        CopyOnWriteArraySet r104 = (CopyOnWriteArraySet) ((LinkedHashMap) f315243c).get(r110);
        if (r104 == null) goto L11;
        r104.clear();
    L11:
        FLogger r105 = FLogger.f375446a;
        StringBuilder r106 = new StringBuilder("clear cache of ");
        r106.append(r110);
        r106.append(", ");
        StringBuilder r107 = new StringBuilder("mobParamsCache: [");
        Iterator r108 = ((LinkedHashMap) r100).keySet().iterator();
        int r109 = 0;
        int r111 = 0;
    L12:
        Integer r112 = null;
        if (r108.hasNext() == false) goto L24;
        Object r113 = r108.next();
        int r114 = r111 + 1;
        if (r111 >= 0) goto L17;
        CollectionsKt.throwIndexOverflow();
    L17:
        String r115 = (String) r113;
        if (r111 == 0) goto L20;
        r107.append(", ");
    L20:
        r107.append(r115);
        r107.append(": size-");
        CopyOnWriteArrayList r116 = (CopyOnWriteArrayList) ((LinkedHashMap) f315241a).get(r115);
        if (r116 == null) goto L23;
        r112 = Integer.valueOf(r116.size());
    L23:
        r107.append(r112);
        r111 = r114;
        goto L12
    L24:
        r107.append("], innerStreamPlayList: [");
        Iterator r117 = ((LinkedHashMap) f315242b).keySet().iterator();
    L26:
        if (r117.hasNext() == false) goto L38;
        Object r118 = r117.next();
        int r119 = r109 + 1;
        if (r109 >= 0) goto L30;
        CollectionsKt.throwIndexOverflow();
    L30:
        String r120 = (String) r118;
        if (r109 == 0) goto L33;
        r107.append(", ");
    L33:
        r107.append(r120);
        r107.append(": size-");
        CopyOnWriteArrayList r121 = (CopyOnWriteArrayList) ((LinkedHashMap) f315242b).get(r120);
        if (r121 == null) goto L36;
        Integer r122 = Integer.valueOf(r121.size());
    L37:
        r107.append(r122);
        r109 = r119;
        goto L26
    L36:
        r122 = null;
        goto L37
    L38:
        r107.append("]");
        r106.append(r107.toString());
        r105.i("InnerStreamCache", r106.toString());
    }

    public static void a(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "itemIdList");
        Map<String, CopyOnWriteArraySet<String>> r102 = f315243c;
        if (r102.containsKey(r100) == false) goto L7;
        CopyOnWriteArraySet r103 = (CopyOnWriteArraySet) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L9;
        r103.addAll(r101);
        return;
    L9:
        return;
    L7:
        CopyOnWriteArraySet<String> r104 = new CopyOnWriteArraySet();
        r104.addAll(r101);
        r102.put(r100, r104);
    }

    public static void b(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "mobParamsList");
        Map<String, CopyOnWriteArrayList<g>> r102 = f315241a;
        if (r102.containsKey(r100) == false) goto L7;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L9;
        r103.addAll(r101);
        return;
    L9:
        return;
    L7:
        CopyOnWriteArrayList<g> r104 = new CopyOnWriteArrayList();
        r104.addAll(r101);
        r102.put(r100, r104);
    }

    public static void c(String r100, List r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "itemIdList");
        Map<String, CopyOnWriteArrayList<String>> r102 = f315242b;
        if (r102.containsKey(r100) == false) goto L7;
        CopyOnWriteArrayList r103 = (CopyOnWriteArrayList) ((LinkedHashMap) r102).get(r100);
        if (r103 == null) goto L9;
        r103.addAll(r101);
        return;
    L9:
        return;
    L7:
        CopyOnWriteArrayList<String> r104 = new CopyOnWriteArrayList();
        r104.addAll(r101);
        r102.put(r100, r104);
    }

    public static g e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "scene");
        Intrinsics.checkNotNullParameter(r101, "itemId");
        CopyOnWriteArrayList r102 = (CopyOnWriteArrayList) ((LinkedHashMap) f315241a).get(r100);
        Object r103 = null;
        if (r102 == null) goto L15;
        Iterator r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        Object r105 = r104.next();
        if (Intrinsics.areEqual(((g) r105).f315322a, r101) == false) goto L6;
        r103 = r105;
    L11:
        return (g) r103;
    L15:
        return null;
    }
}
