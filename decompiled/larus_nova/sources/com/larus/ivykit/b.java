package com.larus.ivykit;

import com.bytedance.geckox.model.Resources;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.CollectionsKt;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes30.dex */
public final class b {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f351625a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f351626b;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof b) == true) goto L8;
        return false;
    L8:
        b r101 = (b) r100;
        if (Intrinsics.areEqual(this.f351625a, r101.f351625a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f351626b, r101.f351626b) == true) goto L14;
        return false;
    L14:
        return true;
    }

    public final int hashCode() {
        return (this.f351625a.hashCode() * 31) + this.f351626b.hashCode();
    }

    public final String toString() {
        return "GeckoDiskTargets(groups=" + this.f351625a + ", channels=" + this.f351626b + ')';
    }

    public final Map<String, Resources> a() {
        Map<String, String> r100 = this.f351625a;
        LinkedHashMap r101 = new LinkedHashMap(MapsKt.mapCapacity(r100.size()));
        Iterator<T> r102 = r100.entrySet().iterator();
    L4:
        if (r102.hasNext() == false) goto L9;
        Map.Entry r103 = (Map.Entry) r102.next();
        Object r104 = r103.getKey();
        String r105 = (String) r103.getKey();
        String[] r106 = {(String) r103.getValue()};
        List<String> r107 = this.f351626b.get(r105);
        if (r107 != null) goto L8;
        r107 = CollectionsKt.emptyList();
    L8:
        r101.put(r104, new Resources(r106, (String[]) r107.toArray(new String[0])));
        goto L4
    L9:
        return r101;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public b(Map<String, String> r100, Map<String, ? extends List<String>> r101) {
        Intrinsics.checkNotNullParameter(r100, "groups");
        Intrinsics.checkNotNullParameter(r101, "channels");
        this.f351625a = r100;
        this.f351626b = r101;
    }
}
