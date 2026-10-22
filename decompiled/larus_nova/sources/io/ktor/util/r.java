package io.ktor.util;

import com.bytedance.kmp.ec.yata.view.render.controller.common.ContainerPosition;
import com.bytedance.mt.protector.impl.collections.ListProtector;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import kotlin.Unit;
import kotlin.collections.CollectionsKt;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes41.dex */
public class r implements p {

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f491987c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, List<String>> f491988d;

    @Override // io.ktor.util.p
    public final Set<Map.Entry<String, List<String>>> entries() {
        Set<Map.Entry<String, List<String>>> r100 = this.f491988d.entrySet();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Collections.unmodifiableSet(r100);
    }

    @Override // io.ktor.util.p
    public final boolean isEmpty() {
        return this.f491988d.isEmpty();
    }

    @Override // io.ktor.util.p
    public final Set<String> names() {
        Set<String> r100 = this.f491988d.keySet();
        Intrinsics.checkNotNullParameter(r100, "<this>");
        return Collections.unmodifiableSet(r100);
    }

    public final int hashCode() {
        Set<Map.Entry<String, List<String>>> r100 = entries();
        if (this.f491987c == false) goto L5;
        int r101 = 1231;
    L7:
        return ((r101 * 31) * 31) + r100.hashCode();
    L5:
        r101 = 1237;
        goto L7
    }

    @Override // io.ktor.util.p
    public final boolean c() {
        return this.f491987c;
    }

    public r(Map r100) {
        Intrinsics.checkNotNullParameter(r100, "values");
        this.f491987c = true;
        e r101 = new e();
        Iterator r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        String r104 = (String) r103.getKey();
        List r105 = (List) r103.getValue();
        int r106 = r105.size();
        ArrayList r107 = new ArrayList(r106);
        int r108 = 0;
    L6:
        if (r108 >= r106) goto L8;
        r107.add((String) ListProtector.get(r105, r108));
        r108 = r108 + 1;
        goto L6
    L8:
        r101.put(r104, r107);
        goto L4
    L9:
        this.f491988d = r101;
    }

    @Override // io.ktor.util.p
    public final List<String> a(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        return this.f491988d.get(r100);
    }

    @Override // io.ktor.util.p
    public final void d(Function2<? super String, ? super List<String>, Unit> r100) {
        Intrinsics.checkNotNullParameter(r100, ContainerPosition.BODY);
        Iterator<Map.Entry<String, List<String>>> r101 = this.f491988d.entrySet().iterator();
    L4:
        if (r101.hasNext() == false) goto L6;
        Map.Entry<String, List<String>> r102 = r101.next();
        r100.invoke(r102.getKey(), r102.getValue());
        goto L4
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof p) == true) goto L8;
        return false;
    L8:
        p r101 = (p) r100;
        if (this.f491987c == r101.c()) goto L12;
        return false;
    L12:
        return Intrinsics.areEqual(entries(), r101.entries());
    }

    @Override // io.ktor.util.p
    public final String get(String r100) {
        Intrinsics.checkNotNullParameter(r100, "name");
        List<String> r101 = this.f491988d.get(r100);
        if (r101 != null) goto L7;
        return null;
    L7:
        return (String) CollectionsKt.firstOrNull(r101);
    }
}
