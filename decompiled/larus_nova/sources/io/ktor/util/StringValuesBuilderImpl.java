package io.ktor.util;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public class StringValuesBuilderImpl implements q {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final boolean f491944a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f491945b;

    public void j(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
    }

    public void k(String r100) {
        Intrinsics.checkNotNullParameter(r100, "value");
    }

    @Override // io.ktor.util.q
    public final Set<Map.Entry<String, List<String>>> entries() {
        Set<Map.Entry<String, List<String>>> r100 = this.f491945b.entrySet();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Collections.unmodifiableSet(r100);
    }

    @Override // io.ktor.util.q
    public final boolean isEmpty() {
        return this.f491945b.isEmpty();
    }

    @Override // io.ktor.util.q
    public final Set<String> names() {
        return this.f491945b.keySet();
    }

    @Override // io.ktor.util.q
    public final boolean c() {
        return this.f491944a;
    }

    public StringValuesBuilderImpl(int r100) {
        this.f491944a = true;
        this.f491945b = new e();
    }

    @Override // io.ktor.util.q
    public final List<String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f491945b.get(r100);
    }

    public final void f(p r100) {
        Intrinsics.checkNotNullParameter(r100, "stringValues");
        r100.d(new StringValuesBuilderImpl$appendAll$1(this));
    }

    public final boolean g(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f491945b.containsKey(r100);
    }

    public final List<String> h(String r100) {
        List<String> r101 = this.f491945b.get(r100);
        if (r101 != null) goto L6;
        ArrayList r102 = new ArrayList();
        j(r100);
        this.f491945b.put(r100, r102);
        return r102;
    L6:
        return r101;
    }

    public final String i(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        List<String> r101 = a(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (String) CollectionsKt.firstOrNull(r101);
    }

    @Override // io.ktor.util.q
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        k(r101);
        List<String> r102 = h(r100);
        r102.clear();
        r102.add(r101);
    }

    @Override // io.ktor.util.q
    public final void d(String r100, Iterable<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "values");
        List<String> r102 = h(r100);
        Iterator<String> r103 = r101.iterator();
    L4:
        if (r103.hasNext() == false) goto L6;
        String r104 = r103.next();
        k(r104);
        r102.add(r104);
        goto L4
    }

    public final void e(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        k(r101);
        h(r100).add(r101);
    }
}
