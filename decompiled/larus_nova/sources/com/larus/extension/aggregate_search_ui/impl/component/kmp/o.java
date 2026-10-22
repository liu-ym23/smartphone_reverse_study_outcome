package com.larus.extension.aggregate_search_ui.impl.component.kmp;

import com.bytedance.flow.search.kmp.api.model.FilterItem;
import com.bytedance.flow.search.kmp.api.model.payload.SearchFilterPayload;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes23.dex */
public final class o {

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public static final /* synthetic */ int f342605e = 0;

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final SearchFilterPayload f342606a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final p f342607b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, FilterItem> f342608c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Boolean f342609d;

    public static final class a {
    }

    static {
    }

    public o() {
        throw null;
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof o) == true) goto L8;
        return false;
    L8:
        o r101 = (o) r100;
        if (Intrinsics.areEqual(this.f342606a, r101.f342606a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f342607b, r101.f342607b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f342608c, r101.f342608c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f342609d, r101.f342609d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        SearchFilterPayload r100 = this.f342606a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        p r104 = this.f342607b;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (((r103 + r105) * 31) + this.f342608c.hashCode()) * 31;
        Boolean r107 = this.f342609d;
        if (r107 == null) goto L15;
        r101 = r107.hashCode();
    L15:
        return r106 + r101;
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "KmpSearchFilterPanelStateDiff(payload=" + this.f342606a + ", selectedDomainFilter=" + this.f342607b + ", selectedSubFilterList=" + this.f342608c + ", isExpanded=" + this.f342609d + ')';
    }

    public o(SearchFilterPayload r100, p r101, Map r102) {
        Intrinsics.checkNotNullParameter(r102, "selectedSubFilterList");
        this.f342606a = r100;
        this.f342607b = r101;
        this.f342608c = r102;
        this.f342609d = null;
    }
}
