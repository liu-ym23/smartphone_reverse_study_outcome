package com.larus.home.impl.main.side_bar.view;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ConcurrentHashMap;
import kotlin.collections.CollectionsKt;
import kotlin.comparisons.ComparisonsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.text.StringsKt;

/* JADX INFO: loaded from: classes29.dex */
public final class d2 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public static final d2 f345076a = null;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public static final ConcurrentHashMap<String, a> f345077b = null;

    public static final class a {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final com.larus.bmhome.interactionpanel.v0 f345078a;

        /* JADX INFO: renamed from: b, reason: collision with root package name */
        public final int f345079b;

        public final boolean equals(Object r100) {
            if (this != r100) goto L6;
            return true;
        L6:
            if ((r100 instanceof a) == true) goto L8;
            return false;
        L8:
            a r101 = (a) r100;
            if (Intrinsics.areEqual(this.f345078a, r101.f345078a) == true) goto L12;
            return false;
        L12:
            if (this.f345079b == r101.f345079b) goto L14;
            return false;
        L14:
            return true;
        }

        public final int hashCode() {
            return (this.f345078a.hashCode() * 31) + this.f345079b;
        }

        public final String toString() {
            return "ConversationPendingState(primary=" + this.f345078a + ", totalPendingCount=" + this.f345079b + ')';
        }

        public a(com.larus.bmhome.interactionpanel.v0 r100, int r101) {
            Intrinsics.checkNotNullParameter(r100, "primary");
            this.f345078a = r100;
            this.f345079b = r101;
        }
    }

    public static final class b<T> implements Comparator {
        public b() {
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            return ComparisonsKt.compareValues(Long.valueOf(((com.larus.bmhome.interactionpanel.v0) r100).f312439d), Long.valueOf(((com.larus.bmhome.interactionpanel.v0) r101).f312439d));
        }
    }

    public static final class c<T> implements Comparator {

        /* JADX INFO: renamed from: a, reason: collision with root package name */
        public final /* synthetic */ Comparator f345080a;

        public c(b r100) {
            this.f345080a = r100;
        }

        /* JADX WARN: Multi-variable type inference failed */
        @Override // java.util.Comparator
        public final int compare(T r100, T r101) {
            int r102 = this.f345080a.compare(r100, r101);
            if (r102 == 0) goto L6;
            return r102;
        L6:
            return ComparisonsKt.compareValues(Integer.valueOf(((com.larus.bmhome.interactionpanel.v0) r100).f312438c), Integer.valueOf(((com.larus.bmhome.interactionpanel.v0) r101).f312438c));
        }
    }

    public d2() {
    }

    static {
        f345076a = new d2();
        f345077b = new ConcurrentHashMap();
    }

    public static a a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "conversationId");
        return f345077b.get(r100);
    }

    public final Set<String> update(List<com.larus.bmhome.interactionpanel.v0> r100) {
        Intrinsics.checkNotNullParameter(r100, "summaries");
        HashMap r101 = new HashMap(f345077b);
        HashMap r102 = new HashMap();
        ArrayList r103 = new ArrayList();
        Iterator<T> r104 = r100.iterator();
    L4:
        if (r104.hasNext() == false) goto L8;
        Object r105 = r104.next();
        if ((!StringsKt.isBlank(((com.larus.bmhome.interactionpanel.v0) r105).f312436a)) == false) goto L4;
        r103.add(r105);
        goto L4
    L8:
        LinkedHashMap r106 = new LinkedHashMap();
        Iterator r107 = r103.iterator();
    L10:
        if (r107.hasNext() == false) goto L15;
        Object r108 = r107.next();
        String r109 = ((com.larus.bmhome.interactionpanel.v0) r108).f312436a;
        Object r110 = r106.get(r109);
        if (r110 != null) goto L14;
        r110 = new ArrayList();
        r106.put(r109, r110);
    L14:
        ((List) r110).add(r108);
        goto L10
    L15:
        Iterator r111 = r106.entrySet().iterator();
    L17:
        if (r111.hasNext() == false) goto L26;
        Map.Entry r112 = (Map.Entry) r111.next();
        String r113 = (String) r112.getKey();
        List r114 = (List) r112.getValue();
        Iterator r115 = r114.iterator();
        int r116 = 0;
    L20:
        if (r115.hasNext() == false) goto L22;
        r116 = r116 + ((com.larus.bmhome.interactionpanel.v0) r115.next()).f312438c;
        goto L20
    L22:
        com.larus.bmhome.interactionpanel.v0 r117 = (com.larus.bmhome.interactionpanel.v0) CollectionsKt.maxWithOrNull(r114, new c(new b()));
        if (r117 == null) goto L17;
        r102.put(r113, new a(r117, r116));
        goto L17
    L26:
        ConcurrentHashMap<String, a> r118 = f345077b;
        r118.clear();
        r118.putAll(r102);
        HashSet r119 = new HashSet();
        HashSet r120 = new HashSet();
        r120.addAll(r101.keySet());
        r120.addAll(r102.keySet());
        Iterator r121 = r120.iterator();
    L28:
        if (r121.hasNext() == false) goto L32;
        String r122 = (String) r121.next();
        if (Intrinsics.areEqual((a) r101.get(r122), (a) r102.get(r122)) == true) goto L28;
        r119.add(r122);
        goto L28
    L32:
        return r119;
    }
}
