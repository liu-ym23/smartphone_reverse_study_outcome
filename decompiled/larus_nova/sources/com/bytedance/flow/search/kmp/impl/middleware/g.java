package com.bytedance.flow.search.kmp.impl.middleware;

import com.bytedance.flow.search.kmp.api.model.FlowQuery;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes19.dex */
public final class g {

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public static final /* synthetic */ int f243597d = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f243598a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Map<String, List<String>> f243599b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, String> f243600c;

    public static final class a {
        public static g a(FlowQuery r100) {
            Intrinsics.checkNotNullParameter(r100, "query");
            String r101 = r100.f243270a;
            Map<String, List<String>> r102 = r100.f243274e;
            if (r102 != null) goto L5;
            r102 = MapsKt.emptyMap();
        L5:
            LinkedHashMap r103 = new LinkedHashMap();
            Iterator<Map.Entry<String, List<String>>> r104 = r102.entrySet().iterator();
        L7:
            if (r104.hasNext() == false) goto L11;
            Map.Entry<String, List<String>> r105 = r104.next();
            if ((!Intrinsics.areEqual(r105.getKey(), "domain")) == false) goto L7;
            r103.put(r105.getKey(), r105.getValue());
            goto L7
        L11:
            Map<String, Object> r106 = r100.f243275f;
            if (r106 != null) goto L14;
            r106 = MapsKt.emptyMap();
        L14:
            LinkedHashMap r107 = new LinkedHashMap(MapsKt.mapCapacity(r106.size()));
            Iterator<T> r108 = r106.entrySet().iterator();
        L16:
            if (r108.hasNext() == false) goto L19;
            Map.Entry r109 = (Map.Entry) r108.next();
            r107.put(r109.getKey(), r109.getValue().toString());
            goto L16
        L19:
            return new g(r101, r103, r107);
        }
    }

    static {
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof g) == true) goto L8;
        return false;
    L8:
        g r101 = (g) r100;
        if (Intrinsics.areEqual(this.f243598a, r101.f243598a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f243599b, r101.f243599b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f243600c, r101.f243600c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f243598a.hashCode() * 31) + this.f243599b.hashCode()) * 31) + this.f243600c.hashCode();
    }

    public final String toString() {
        return "MessageFirstPageCacheKey(keyword=" + this.f243598a + ", subFilters=" + this.f243599b + ", ext=" + this.f243600c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public g(String r100, Map<String, ? extends List<String>> r101, Map<String, String> r102) {
        Intrinsics.checkNotNullParameter(r100, "keyword");
        Intrinsics.checkNotNullParameter(r101, "subFilters");
        Intrinsics.checkNotNullParameter(r102, "ext");
        this.f243598a = r100;
        this.f243599b = r101;
        this.f243600c = r102;
    }
}
