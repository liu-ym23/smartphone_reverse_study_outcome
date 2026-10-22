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

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
public final class k {
    public final CopyOnWriteArrayList<Group> a;
    public boolean b;
    public Set<String> c;
    public Set<Model$EventType> d;
    public List<String> e;

    public /* synthetic */ class a {
        public static final /* synthetic */ int[] a = null;

        static {
            int[] r0 = new int[Model$EventType.values().length];
            r0[Model$EventType.V3.ordinal()] = 1;
            a = r0;
        }
    }

    public k(CopyOnWriteArrayList<Group> r10) {
        Intrinsics.checkNotNullParameter(r10, "groups");
        this.a = r10;
        this.e = CollectionsKt.emptyList();
        if (r10.isEmpty() == true) goto L114;
        this.c = new LinkedHashSet();
        this.d = new LinkedHashSet();
        LinkedHashSet r0 = new LinkedHashSet();
        Iterator<Group> r11 = r10.iterator();
    L6:
        if (r11.hasNext() == false) goto L77;
        Group r1 = r11.next();
        r r2 = r1.b.f;
        if (r2 == null) goto L17;
        HashMap<String, List<List<String>>> r3 = r2.b;
        if (r3 == null) goto L17;
        List<List<String>> r4 = r3.get("*");
        if (r4 == null) goto L17;
        Iterator<T> r5 = r4.iterator();
    L15:
        if (r5.hasNext() == false) goto L17;
        r0.addAll((List) r5.next());
    L17:
        r r6 = r1.b.f;
        if (r6 == null) goto L27;
        HashMap<String, List<HashMap<String, String>>> r7 = r6.c;
        if (r7 == null) goto L27;
        List<HashMap<String, String>> r8 = r7.get("*");
        if (r8 == null) goto L27;
        Iterator<T> r9 = r8.iterator();
    L25:
        if (r9.hasNext() == false) goto L27;
        r0.addAll(((HashMap) r9.next()).keySet());
    L27:
        Iterator<String> r12 = r1.b.g.iterator();
    L29:
        if (r12.hasNext() == false) goto L6;
        String r13 = r12.next();
        Model$EventType r14 = Model$EventType.V3;
        if (Intrinsics.areEqual(r13, r14.getAlias()) == true) goto L32;
        Set<Model$EventType> r15 = this.d;
        if (r15 == null) goto L29;
        Model$EventType.Companion.getClass();
        r15.add(Model$EventType.a.b(r13));
        goto L29
    L32:
        Set<Model$EventType> r16 = this.d;
        if (r16 == null) goto L36;
        r16.add(r14);
    L36:
        if (this.b == true) goto L29;
        r r17 = r1.b.f;
        if (r17 != null) goto L40;
        this.b = true;
        Unit r18 = Unit.INSTANCE;
        goto L29
    L40:
        Set<String> r19 = r17.a;
        if (r19.contains("*") == false) goto L45;
        this.b = true;
        Set<String> r20 = this.c;
        if (r20 == null) goto L51;
        r20.clear();
    L51:
        HashMap<String, List<List<String>>> r21 = r17.b;
        if (r21.containsKey("*") == false) goto L56;
        this.b = true;
        Set<String> r22 = this.c;
        if (r22 == null) goto L62;
        r22.clear();
    L62:
        HashMap<String, List<HashMap<String, String>>> r23 = r17.c;
        if (r23.containsKey("*") == true) goto L64;
        Iterator<T> r24 = r23.keySet().iterator();
    L69:
        if (r24.hasNext() == false) goto L29;
        String r25 = (String) r24.next();
        Set<String> r26 = this.c;
        if (r26 == null) goto L69;
        r26.add(r25);
        goto L69
    L64:
        this.b = true;
        Set<String> r27 = this.c;
        if (r27 == null) goto L29;
        r27.clear();
        goto L29
    L56:
        Iterator<T> r28 = r21.keySet().iterator();
    L58:
        if (r28.hasNext() == false) goto L62;
        String r29 = (String) r28.next();
        Set<String> r30 = this.c;
        if (r30 == null) goto L58;
        r30.add(r29);
        goto L58
    L45:
        Iterator<T> r31 = r19.iterator();
    L47:
        if (r31.hasNext() == false) goto L51;
        String r32 = (String) r31.next();
        Set<String> r33 = this.c;
        if (r33 == null) goto L47;
        r33.add(r32);
        goto L47
    L77:
        this.e = CollectionsKt.toList(r0);
        return;
    }
}
