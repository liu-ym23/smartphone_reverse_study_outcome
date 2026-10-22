package com.ss.android.ugc.aweme.search.dynamic.core.data;

import com.ss.android.ugc.aweme.discover.commodity.holder.ECCommodityDynamicCard$bind$hostDataProvider$1;
import com.ss.android.ugc.aweme.search.dynamic.api.model.IDynamicServerData;
import com.ss.android.ugc.aweme.search.dynamic.base.model.DynamicCardData;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import ra.a;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/dynamic/core/data/DynamicData;", "", "trade-search-impl_release"}, k = 1, mv = {1, 4, 3})
public final class DynamicData {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public a f452672a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final IDynamicServerData f452673b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, ? extends Object> f452674c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, ? extends Object> f452675d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public Map<String, ? extends Object> f452676e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final Map<String, ? extends Object> f452677f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final IHostDataProvider f452678g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof DynamicData) == true) goto L8;
        return false;
    L8:
        DynamicData r101 = (DynamicData) r100;
        if (Intrinsics.areEqual(this.f452672a, r101.f452672a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f452673b, r101.f452673b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f452674c, r101.f452674c) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f452675d, r101.f452675d) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.f452676e, r101.f452676e) == true) goto L24;
        return false;
    L24:
        if (Intrinsics.areEqual(this.f452677f, r101.f452677f) == true) goto L27;
        return false;
    L27:
        if (Intrinsics.areEqual(this.f452678g, r101.f452678g) == true) goto L29;
        return false;
    L29:
        return true;
    }

    public final int hashCode() {
        a r100 = this.f452672a;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = ((r102 * 31) + this.f452673b.hashCode()) * 31;
        Map<String, ? extends Object> r104 = this.f452674c;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        Map<String, ? extends Object> r107 = this.f452675d;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        Map<String, ? extends Object> r110 = this.f452676e;
        if (r110 != null) goto L17;
        int r111 = 0;
    L18:
        int r112 = (r109 + r111) * 31;
        Map<String, ? extends Object> r113 = this.f452677f;
        if (r113 != null) goto L21;
        int r114 = 0;
    L22:
        int r115 = (r112 + r114) * 31;
        IHostDataProvider r116 = this.f452678g;
        if (r116 == null) goto L27;
        r101 = r116.hashCode();
    L27:
        return r115 + r101;
    L21:
        r114 = r113.hashCode();
        goto L22
    L17:
        r111 = r110.hashCode();
        goto L18
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "DynamicData(lynxModel=" + this.f452672a + ", serverData=" + this.f452673b + ", clientData=" + this.f452674c + ", extraFeData=" + this.f452675d + ", extraClientData=" + this.f452676e + ", globalProps=" + this.f452677f + ", hostDataProvider=" + this.f452678g + ')';
    }

    public DynamicData(DynamicCardData r100, Map r101, ECCommodityDynamicCard$bind$hostDataProvider$1 r102) {
        Intrinsics.checkNotNullParameter(r100, "serverData");
        this.f452672a = null;
        this.f452673b = r100;
        this.f452674c = null;
        this.f452675d = null;
        this.f452676e = r101;
        this.f452677f = null;
        this.f452678g = r102;
    }
}
