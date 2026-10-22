package io.ktor.http;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public final class m0 implements a0 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final a0 f491890a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f491891b;

    @Override // io.ktor.util.q
    public final Set<Map.Entry<String, List<String>>> entries() {
        return ((io.ktor.util.r) n0.b(this.f491890a)).entries();
    }

    @Override // io.ktor.util.q
    public final boolean isEmpty() {
        return this.f491890a.isEmpty();
    }

    @Override // io.ktor.util.q
    public final Set<String> names() {
        Set<String> r100 = this.f491890a.names();
        ArrayList r101 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r100, 10));
        Iterator<T> r102 = r100.iterator();
    L4:
        if (r102.hasNext() == false) goto L7;
        r101.add(CodecsKt.e((String) r102.next(), 0, 0, false, 15));
        goto L4
    L7:
        return CollectionsKt.toSet(r101);
    }

    @Override // io.ktor.util.q
    public final boolean c() {
        return this.f491891b;
    }

    public m0(a0 r100) {
        Intrinsics.checkNotNullParameter(r100, "encodedParametersBuilder");
        this.f491890a = r100;
        this.f491891b = r100.c();
    }

    @Override // io.ktor.util.q
    public final List<String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        List<String> r101 = this.f491890a.a(CodecsKt.f(r100, false));
        if (r101 == null) goto L8;
        List<String> r102 = r101;
        ArrayList r103 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r102, 10));
        Iterator<T> r104 = r102.iterator();
    L6:
        if (r104.hasNext() == false) goto L11;
        r103.add(CodecsKt.e((String) r104.next(), 0, 0, true, 11));
        goto L6
    L11:
        return r103;
    L8:
        return null;
    }

    @Override // io.ktor.util.q
    public final void b(String r100, String r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "value");
        this.f491890a.b(CodecsKt.f(r100, false), CodecsKt.g(r101));
    }

    @Override // io.ktor.util.q
    public final void d(String r100, Iterable<String> r101) {
        Intrinsics.checkNotNullParameter(r100, "name");
        Intrinsics.checkNotNullParameter(r101, "values");
        a0 r102 = this.f491890a;
        String r103 = CodecsKt.f(r100, false);
        ArrayList r104 = new ArrayList(CollectionsKt.collectionSizeOrDefault(r101, 10));
        Iterator<String> r105 = r101.iterator();
    L4:
        if (r105.hasNext() == false) goto L6;
        r104.add(CodecsKt.g(r105.next()));
        goto L4
    L6:
        r102.d(r103, r104);
    }
}
