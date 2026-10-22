package luc;

import java.lang.annotation.Annotation;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Lazy;
import kotlin.LazyKt;
import kotlin.TuplesKt;
import kotlin.collections.ArraysKt;
import kotlin.collections.CollectionsKt;
import kotlin.collections.IndexedValue;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;
import kotlin.ranges.RangesKt;
import nuc.a2;

/* JADX INFO: loaded from: classes5.dex */
public final class i implements f, nuc.n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f510860a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final o f510861b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final int f510862c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final List<Annotation> f510863d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Set<String> f510864e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String[] f510865f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final f[] f510866g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final List<Annotation>[] f510867h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean[] f510868i;

    /* JADX INFO: renamed from: j, reason: collision with root package name */
    public final Map<String, Integer> f510869j;

    /* JADX INFO: renamed from: k, reason: collision with root package name */
    public final f[] f510870k;

    /* JADX INFO: renamed from: l, reason: collision with root package name */
    public final Lazy f510871l;

    @Override // luc.f
    public final boolean a() {
        return false;
    }

    @Override // luc.f
    public final boolean isInline() {
        return false;
    }

    public final int hashCode() {
        return ((Number) this.f510871l.getValue()).intValue();
    }

    public final String toString() {
        return CollectionsKt.joinToString$default(RangesKt.until(0, this.f510862c), ", ", this.f510860a + '(', ")", 0, null, new h(this), 24, null);
    }

    @Override // nuc.n
    public final Set<String> c() {
        return this.f510864e;
    }

    @Override // luc.f
    public final int d() {
        return this.f510862c;
    }

    @Override // luc.f
    public final String f() {
        return this.f510860a;
    }

    @Override // luc.f
    public final List<Annotation> getAnnotations() {
        return this.f510863d;
    }

    @Override // luc.f
    public final o getKind() {
        return this.f510861b;
    }

    @Override // luc.f
    public final String b(int r100) {
        return this.f510865f[r100];
    }

    @Override // luc.f
    public final List<Annotation> e(int r100) {
        return this.f510867h[r100];
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof i) == true) goto L8;
    L7:
        return false;
    L8:
        f r101 = (f) r100;
        if (Intrinsics.areEqual(f(), r101.f()) == false) goto L7;
        if (Arrays.equals(this.f510870k, ((i) r100).f510870k) == false) goto L7;
        if (d() != r101.d()) goto L7;
        int r102 = d();
        int r103 = 0;
    L18:
        if (r103 >= r102) goto L31;
        if (Intrinsics.areEqual(h(r103).f(), r101.h(r103).f()) == false) goto L7;
        if (Intrinsics.areEqual(h(r103).getKind(), r101.h(r103).getKind()) == false) goto L7;
        r103 = r103 + 1;
        goto L18
    L31:
        return true;
    }

    @Override // luc.f
    public final int g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Integer r101 = this.f510869j.get(r100);
        if (r101 != null) goto L7;
        return -3;
    L7:
        return r101.intValue();
    }

    @Override // luc.f
    public final f h(int r100) {
        return this.f510866g[r100];
    }

    @Override // luc.f
    public final boolean i(int r100) {
        return this.f510868i[r100];
    }

    public i(String r100, o r101, int r102, List<? extends f> r103, a r104) {
        Intrinsics.checkNotNullParameter(r100, "serialName");
        Intrinsics.checkNotNullParameter(r101, "kind");
        Intrinsics.checkNotNullParameter(r103, "typeParameters");
        Intrinsics.checkNotNullParameter(r104, "builder");
        this.f510860a = r100;
        this.f510861b = r101;
        this.f510862c = r102;
        this.f510863d = r104.f510838b;
        this.f510864e = CollectionsKt.toHashSet(r104.f510839c);
        ArrayList r105 = (ArrayList) r104.f510839c;
        String[] r106 = (String[]) r105.toArray(new String[0]);
        this.f510865f = r106;
        this.f510866g = a2.b(r104.f510841e);
        ArrayList r107 = (ArrayList) r104.f510842f;
        this.f510867h = (List[]) r107.toArray(new List[0]);
        this.f510868i = CollectionsKt.toBooleanArray(r104.f510843g);
        Iterable r108 = ArraysKt.withIndex(r106);
        ArrayList r109 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r108, 10));
        Iterator r110 = r108.iterator();
    L4:
        if (r110.hasNext() == false) goto L6;
        IndexedValue r111 = (IndexedValue) r110.next();
        r109.add(TuplesKt.to(r111.getValue(), Integer.valueOf(r111.getIndex())));
        goto L4
    L6:
        this.f510869j = MapsKt.toMap(r109);
        this.f510870k = a2.b(r103);
        this.f510871l = LazyKt.lazy(new g(this));
    }
}
