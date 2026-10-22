package com.ss.android.lark.ug.scheduler.coordinator.entity;

import com.ss.android.lark.ug.scheduler.coordinator.entity.DAGraph.b;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.jvm.functions.Function1;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes38.dex */
public final class DAGraph<N extends b> {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public static final /* synthetic */ int f444470c = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, N> f444471a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Set<String> f444472b;

    public static final class a {
    }

    public static class b {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final String f444473a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final Set<String> f444474b;

        /* JADX INFO: renamed from: c, reason: collision with root package name */
        public final Set<String> f444475c;

        /* JADX INFO: renamed from: d, reason: collision with root package name */
        public int f444476d;

        public final int hashCode() {
            return this.f444473a.hashCode();
        }

        public final String toString() {
            return "DAGNode('" + this.f444473a + "', inDegree=" + this.f444476d + ')';
        }

        public b(String r100) {
            Intrinsics.checkNotNullParameter(r100, "nodeId");
            this.f444473a = r100;
            this.f444474b = new LinkedHashSet();
            this.f444475c = new LinkedHashSet();
        }

        public final boolean equals(Object r100) {
            if (this != r100) goto L5;
            return true;
        L5:
            Class<?> r101 = getClass();
            if (r100 == null) goto L8;
            Class<?> r102 = r100.getClass();
        L10:
            if (Intrinsics.areEqual(r101, r102) == true) goto L12;
            return false;
        L12:
            Intrinsics.checkNotNull(r100, "null cannot be cast to non-null type com.ss.android.lark.ug.scheduler.coordinator.entity.DAGraph.DAGNode");
            if (Intrinsics.areEqual(this.f444473a, ((b) r100).f444473a) == true) goto L15;
            return false;
        L15:
            return true;
        L8:
            r102 = null;
            goto L10
        }
    }

    static {
    }

    public final List<N> c() {
        Set<String> r100 = this.f444472b;
        ArrayList r101 = new ArrayList();
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        String r103 = (String) r102.next();
        b r104 = (b) ((LinkedHashMap) this.f444471a).get(r103);
        if (r104 == null) goto L4;
        r101.add(r104);
        goto L4
    L9:
        return new ArrayList(r101);
    }

    public final void f() {
        Iterator r100 = ((LinkedHashMap) this.f444471a).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        b r101 = (b) r100.next();
        com.ss.android.lark.ug.scheduler.common.service.a r102 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.a r103 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        StringBuilder r104 = new StringBuilder("printGraph -> ");
        r101.getClass();
        r104.append("DAGNode('" + r101.f444473a + "', parentIds=" + r101.f444474b + ", childrenIds=" + r101.f444475c + ", inDegree=" + r101.f444476d + ')');
        r103.a("Scheduler-DAGGraph", r104.toString());
        goto L4
    }

    public final void g() {
        this.f444472b.clear();
        Iterator r100 = ((LinkedHashMap) this.f444471a).values().iterator();
    L4:
        if (r100.hasNext() == false) goto L6;
        ((b) r100.next()).f444476d = 0;
        goto L4
    L6:
        Iterator r101 = ((LinkedHashMap) this.f444471a).values().iterator();
    L8:
        if (r101.hasNext() == false) goto L13;
        b r102 = (b) r101.next();
        Function1<String, Unit> r103 = new DAGraph$refreshInDegree$2$1(this);
        Iterator<T> r104 = r102.f444475c.iterator();
    L11:
        if (r104.hasNext() == false) goto L8;
        r103.invoke((String) r104.next());
        goto L11
    L13:
        Collection r105 = ((LinkedHashMap) this.f444471a).values();
        ArrayList r106 = new ArrayList();
        Iterator r107 = r105.iterator();
    L15:
        if (r107.hasNext() == false) goto L22;
        Object r108 = r107.next();
        if (((b) r108).f444476d != 0) goto L19;
        boolean r109 = true;
    L20:
        if (r109 == false) goto L15;
        r106.add(r108);
        goto L15
    L19:
        r109 = false;
        goto L20
    L22:
        Iterator r110 = r106.iterator();
    L24:
        if (r110.hasNext() == false) goto L26;
        String r111 = ((b) r110.next()).f444473a;
        this.f444472b.add(r111);
        goto L24
    }

    public DAGraph() {
        this.f444471a = new LinkedHashMap();
        this.f444472b = new LinkedHashSet();
    }

    public final void b(List<? extends N> r100) {
        Intrinsics.checkNotNullParameter(r100, "nodes");
        com.ss.android.lark.ug.scheduler.common.service.a r101 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.a("Scheduler-DAGGraph", "addNodes.");
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        b r103 = (b) r102.next();
        String r104 = r103.f444473a;
        Intrinsics.checkNotNullParameter(r104, "nodeId");
        if (this.f444471a.containsKey(r104) == true) goto L7;
        this.f444471a.put(r103.f444473a, (N) r103);
        goto L4
    L7:
        com.ss.android.lark.ug.scheduler.common.service.a r105 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.b("Scheduler-DAGGraph", "addNodes -> node:" + r103.f444473a + " already exists.");
        goto L4
    L9:
        g();
    }

    public final void d(String r100) {
        b r101 = (b) ((LinkedHashMap) this.f444471a).get(r100);
        if (r101 != null) goto L7;
        com.ss.android.lark.ug.scheduler.common.service.a r102 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.c("Scheduler-DAGGraph", "increaseNodeInDegree: node:" + r100 + " not exists.");
        return;
    L7:
        if (r101.f444476d != 0) goto L9;
        this.f444472b.remove(r101.f444473a);
    L9:
        r101.f444476d++;
    }

    public final void e(c r100) {
        Intrinsics.checkNotNullParameter(r100, "node");
        Iterator r101 = new ArrayList(r100.f444475c).iterator();
    L4:
        if (r101.hasNext() == false) goto L16;
        String r102 = (String) r101.next();
        String r103 = r100.f444473a;
        Intrinsics.checkNotNull(r102);
        Intrinsics.checkNotNullParameter(r103, "parentId");
        Intrinsics.checkNotNullParameter(r102, "childId");
        com.ss.android.lark.ug.scheduler.common.service.a r104 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.b("Scheduler-DAGGraph", "removeArc: parentId=" + r103 + ", childId=" + r102);
        b r105 = (b) ((LinkedHashMap) this.f444471a).get(r103);
        b r106 = (b) ((LinkedHashMap) this.f444471a).get(r102);
        if (r105 == null) goto L15;
        if (r106 == null) goto L15;
        if (r105.f444475c.contains(r106.f444473a) == false) goto L11;
        r106.f444474b.remove(r105.f444473a);
        r105.f444475c.remove(r106.f444473a);
        int r107 = r106.f444476d - 1;
        r106.f444476d = r107;
        if (r107 != 0) goto L4;
        this.f444472b.add(r106.f444473a);
        goto L4
    L11:
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.b("Scheduler-DAGGraph", "removeChild: " + r105.f444473a + " doesn't have child " + r106.f444473a);
    L15:
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.c("Scheduler-DAGGraph", "removeArc: failed parent=" + r105 + ", child=" + r106);
        goto L4
    }

    public final void h(String r100) {
        Intrinsics.checkNotNullParameter(r100, "nodeId");
        com.ss.android.lark.ug.scheduler.common.service.a r101 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.b("Scheduler-DAGGraph", "removeNode: nodeId=" + r100);
        N r102 = this.f444471a.remove(r100);
        if (r102 != null) goto L6;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.c("Scheduler-DAGGraph", "removeNode: node:" + r100 + " not exists.");
        return;
    L6:
        this.f444472b.remove(r100);
        Set<String> r103 = r102.f444474b;
        ArrayList r104 = new ArrayList();
        Iterator<T> r105 = r103.iterator();
    L8:
        if (r105.hasNext() == false) goto L12;
        b r106 = (b) ((LinkedHashMap) this.f444471a).get((String) r105.next());
        if (r106 == null) goto L8;
        r104.add(r106);
        goto L8
    L12:
        Iterator r107 = r104.iterator();
    L14:
        if (r107.hasNext() == false) goto L16;
        ((b) r107.next()).f444475c.remove(r100);
        goto L14
    L16:
        r102.f444474b.clear();
        Iterator<T> r108 = r102.f444475c.iterator();
    L18:
        if (r108.hasNext() == false) goto L25;
        String r109 = (String) r108.next();
        b r110 = (b) ((LinkedHashMap) this.f444471a).get(r109);
        if (r110 == null) goto L21;
        int r111 = r110.f444476d - 1;
        r110.f444476d = r111;
        if (r111 != 0) goto L18;
        this.f444472b.add(r110.f444473a);
        goto L18
    L21:
        com.ss.android.lark.ug.scheduler.common.service.a r112 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.c("Scheduler-DAGGraph", "decreaseNodeInDegree: node:" + r109 + " not exists.");
        goto L18
    }

    public static void a(DAGraph r100, c r101) {
        r100.getClass();
        Intrinsics.checkNotNullParameter(r101, "node");
        com.ss.android.lark.ug.scheduler.common.service.a r102 = com.ss.android.lark.ug.scheduler.common.service.b.f444469a;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.b("Scheduler-DAGGraph", "addNode: node=" + r101);
        String r103 = r101.f444473a;
        Intrinsics.checkNotNullParameter(r103, "nodeId");
        if (r100.f444471a.containsKey(r103) == false) goto L5;
        com.ss.android.lark.ug.scheduler.common.service.b.f444469a.b("Scheduler-DAGGraph", "addNode: node:" + r101.f444473a + " already exists.");
        return;
    L5:
        r100.f444471a.put(r101.f444473a, r101);
        r100.g();
    }
}
