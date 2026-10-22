package com.larus.extension.aggregate_search_ui.impl.component.kmp;

import com.bytedance.flow.search.kmp.api.model.FilterItem;
import com.bytedance.flow.search.kmp.api.model.payload.SearchFilterPayload;
import java.util.Map;
import kotlin.collections.MapsKt;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class n {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchFilterPayload f342601a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f342602b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final p f342603c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, FilterItem> f342604d;

    /* JADX WARN: Multi-variable type inference failed */
    public n() {
        Object[] r100 = 0 == true ? 1 : 0;
        Object[] r101 = 0 == true ? 1 : 0;
        this(null, r100, r101, 15);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof n) == true) goto L8;
        return false;
    L8:
        n r101 = (n) r100;
        if (Intrinsics.areEqual(this.f342601a, r101.f342601a) == true) goto L12;
        return false;
    L12:
        if (this.f342602b == r101.f342602b) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f342603c, r101.f342603c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f342604d, r101.f342604d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        SearchFilterPayload r100 = this.f342601a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.f342602b == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        p r106 = this.f342603c;
        if (r106 == null) goto L15;
        r101 = r106.hashCode();
    L15:
        return ((r105 + r101) * 31) + this.f342604d.hashCode();
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "KmpSearchFilterPanelState(payload=" + this.f342601a + ", isExpanded=" + this.f342602b + ", selectedDomainFilter=" + this.f342603c + ", selectedSubFilterList=" + this.f342604d + ')';
    }

    public /* synthetic */ n(SearchFilterPayload r100, p r101, Map r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 4) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 8) == 0) goto L11;
        r102 = MapsKt.emptyMap();
    L11:
        this(r100, false, r101, r102);
    }

    public n(SearchFilterPayload r100, boolean r101, p r102, Map<String, FilterItem> r103) {
        Intrinsics.checkNotNullParameter(r103, "selectedSubFilterList");
        this.f342601a = r100;
        this.f342602b = r101;
        this.f342603c = r102;
        this.f342604d = r103;
    }

    public static n a(n r100, boolean r101, p r102, Map r103, int r104) {
        if ((r104 & 1) == 0) goto L5;
        SearchFilterPayload r105 = r100.f342601a;
    L7:
        if ((r104 & 2) == 0) goto L10;
        r101 = r100.f342602b;
    L10:
        if ((r104 & 4) == 0) goto L13;
        r102 = r100.f342603c;
    L13:
        if ((r104 & 8) == 0) goto L15;
        r103 = r100.f342604d;
    L15:
        r100.getClass();
        Intrinsics.checkNotNullParameter(r103, "selectedSubFilterList");
        return new n(r105, r101, r102, r103);
    L5:
        r105 = null;
        goto L7
    }
}
