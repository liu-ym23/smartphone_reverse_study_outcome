package com.bytedance.ies.tools.prefetch;

import java.lang.ref.WeakReference;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.SortedMap;
import kotlin.Lazy;
import kotlin.Pair;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function0;
import kotlin.reflect.KProperty;
import kotlin.sequences.Sequence;
import kotlin.sequences.SequencesKt;

/* JADX INFO: loaded from: classes19.dex */
public final class v implements j {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final n f248834a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final f f248835b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Function0<Boolean>> f248836c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<o> f248837d;

    @Override // com.bytedance.ies.tools.prefetch.j
    public final PrefetchProcess b(PrefetchRequest r100) {
        System.currentTimeMillis();
        PrefetchProcess r101 = this.f248834a.b(r100);
        r101.getClass();
        return r101;
    }

    @Override // com.bytedance.ies.tools.prefetch.j
    public final PrefetchProcess c(PrefetchRequest r100) {
        System.currentTimeMillis();
        PrefetchProcess r101 = this.f248834a.c(r100);
        r101.getClass();
        return r101;
    }

    @Override // com.bytedance.ies.tools.prefetch.j
    public final List<PrefetchProcess> getCacheByScheme(String r100) {
        System.currentTimeMillis();
        return this.f248834a.getCacheByScheme(r100);
    }

    @Override // com.bytedance.ies.tools.prefetch.j
    public final void prefetch(final String r100) {
        k r101 = p.f248826a;
        p.b("Start prefetch, page scheme: " + r100);
        List<o> r102 = this.f248837d;
        if (r102 == null) goto L13;
        Sequence r103 = CollectionsKt.asSequence(r102);
        if (r103 == null) goto L13;
        Sequence r104 = SequencesKt.filter(r103, new PrefetchHandler$prefetchWithVariables$1(r100));
        if (r104 == null) goto L13;
        Iterator r105 = r104.iterator();
        String r106 = r100;
    L10:
        if (r105.hasNext() == false) goto L12;
        r106 = ((o) r105.next()).convert();
        k r107 = p.f248826a;
        p.a("Scheme convert to [schema:" + r106 + "], origin_scheme:" + r100);
        goto L10
    L12:
        r100 = r106;
    L13:
        UriWrapper r108 = new UriWrapper(r100);
        Pair<Collection<a0>, SortedMap<String, String>> r109 = this.f248835b.a(r108);
        if (r109 == null) goto L31;
        Collection<a0> r110 = r109.getFirst();
        SortedMap<String, String> r111 = r109.getSecond();
        Lazy r112 = r108.f248772c;
        KProperty r113 = UriWrapper.f248769f[2];
        SortedMap r114 = (SortedMap) r112.getValue();
        this.f248834a.a();
        Iterator<a0> r115 = r110.iterator();
    L17:
        if (r115.hasNext() == false) goto L44;
        a0 r116 = r115.next();
        if (this.f248836c == null) goto L30;
        List<String> r117 = r116.f248783c;
        if (r117 == null) goto L30;
        Iterator<String> r118 = r117.iterator();
    L24:
        if (r118.hasNext() == false) goto L30;
        String r119 = r118.next();
        Function0<Boolean> r120 = this.f248836c.get(r119);
        if (r120 == null) goto L29;
        if (r120.invoke().booleanValue() == true) goto L24;
    L29:
        k r121 = p.f248826a;
        p.b("Condition " + r119 + " returned false, skipping this page.");
    L30:
        this.f248834a.e(r100, r111, r114, r116);
        goto L17
    L44:
        return;
    L31:
        k r122 = p.f248826a;
        p.c("No config found for page " + r100 + ", skipping...", null);
    }

    public v(ProcessManager r100, c r101) {
        this.f248834a = r100;
        this.f248835b = r101;
        final WeakReference r102 = null;
        this.f248836c = null;
        this.f248837d = null;
        r101.b(new PrefetchHandler$1(this, r102));
    }
}
