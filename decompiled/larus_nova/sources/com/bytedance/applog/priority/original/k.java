package com.bytedance.applog.priority.original;

import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArrayList;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes14.dex */
public final class k {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final CopyOnWriteArrayList<Group> f192749a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public boolean f192750b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public Set<String> f192751c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Set<Model$EventType> f192752d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public List<String> f192753e;

    public /* synthetic */ class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public static final /* synthetic */ int[] f192754a = null;

        static {
            int[] r100 = new int[Model$EventType.values().length];
            r100[Model$EventType.V3.ordinal()] = 1;
            f192754a = r100;
        }
    }

    public k(CopyOnWriteArrayList<Group> r110) {
        Intrinsics.checkNotNullParameter(r110, "groups");
        this.f192749a = r110;
        this.f192753e = CollectionsKt.emptyList();
        if (r110.isEmpty() == true) goto L114;
        this.f192751c = new LinkedHashSet();
        this.f192752d = new LinkedHashSet();
        LinkedHashSet r100 = new LinkedHashSet();
        Iterator<Group> r111 = r110.iterator();
    L6:
        if (r111.hasNext() == false) goto L77;
        Group r101 = r111.next();
        r r102 = r101.f192678b.f192760f;
        if (r102 == null) goto L17;
        HashMap<String, List<List<String>>> r103 = r102.f192793b;
        if (r103 == null) goto L17;
        List<List<String>> r104 = r103.get("*");
        if (r104 == null) goto L17;
        Iterator<T> r105 = r104.iterator();
    L15:
        if (r105.hasNext() == false) goto L17;
        r100.addAll((List) r105.next());
    L17:
        r r106 = r101.f192678b.f192760f;
        if (r106 == null) goto L27;
        HashMap<String, List<HashMap<String, String>>> r107 = r106.f192794c;
        if (r107 == null) goto L27;
        List<HashMap<String, String>> r108 = r107.get("*");
        if (r108 == null) goto L27;
        Iterator<T> r109 = r108.iterator();
    L25:
        if (r109.hasNext() == false) goto L27;
        r100.addAll(((HashMap) r109.next()).keySet());
    L27:
        Iterator<String> r112 = r101.f192678b.f192761g.iterator();
    L29:
        if (r112.hasNext() == false) goto L6;
        String r113 = r112.next();
        Model$EventType r114 = Model$EventType.V3;
        if (Intrinsics.areEqual(r113, r114.getAlias()) == true) goto L32;
        Set<Model$EventType> r115 = this.f192752d;
        if (r115 == null) goto L29;
        Model$EventType.Companion.getClass();
        r115.add(Model$EventType.a.b(r113));
        goto L29
    L32:
        Set<Model$EventType> r116 = this.f192752d;
        if (r116 == null) goto L36;
        r116.add(r114);
    L36:
        if (this.f192750b == true) goto L29;
        r r117 = r101.f192678b.f192760f;
        if (r117 != null) goto L40;
        this.f192750b = true;
        Unit r118 = Unit.INSTANCE;
        goto L29
    L40:
        Set<String> r119 = r117.f192792a;
        if (r119.contains("*") == false) goto L45;
        this.f192750b = true;
        Set<String> r120 = this.f192751c;
        if (r120 == null) goto L51;
        r120.clear();
    L51:
        HashMap<String, List<List<String>>> r121 = r117.f192793b;
        if (r121.containsKey("*") == false) goto L56;
        this.f192750b = true;
        Set<String> r122 = this.f192751c;
        if (r122 == null) goto L62;
        r122.clear();
    L62:
        HashMap<String, List<HashMap<String, String>>> r123 = r117.f192794c;
        if (r123.containsKey("*") == true) goto L64;
        Iterator<T> r124 = r123.keySet().iterator();
    L69:
        if (r124.hasNext() == false) goto L29;
        String r125 = (String) r124.next();
        Set<String> r126 = this.f192751c;
        if (r126 == null) goto L69;
        r126.add(r125);
        goto L69
    L64:
        this.f192750b = true;
        Set<String> r127 = this.f192751c;
        if (r127 == null) goto L29;
        r127.clear();
        goto L29
    L56:
        Iterator<T> r128 = r121.keySet().iterator();
    L58:
        if (r128.hasNext() == false) goto L62;
        String r129 = (String) r128.next();
        Set<String> r130 = this.f192751c;
        if (r130 == null) goto L58;
        r130.add(r129);
        goto L58
    L45:
        Iterator<T> r131 = r119.iterator();
    L47:
        if (r131.hasNext() == false) goto L51;
        String r132 = (String) r131.next();
        Set<String> r133 = this.f192751c;
        if (r133 == null) goto L47;
        r133.add(r132);
        goto L47
    L77:
        this.f192753e = CollectionsKt.toList(r100);
        return;
    }
}
