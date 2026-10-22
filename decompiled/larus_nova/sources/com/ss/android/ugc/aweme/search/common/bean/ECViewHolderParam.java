package com.ss.android.ugc.aweme.search.common.bean;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;
import com.ss.android.ugc.aweme.discover.commodity.ISearchCommodityAdapter;
import com.ss.android.ugc.aweme.discover.model.SearchAggregateCommodity;
import kotlin.Metadata;
import kotlin.Unit;
import kotlin.jvm.functions.Function2;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/bean/ECViewHolderParam;", "", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECViewHolderParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public Fragment f451576a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final Function2<SearchAggregateCommodity, RecyclerView.ViewHolder, Unit> f451577b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Object f451578c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public Object f451579d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final Object f451580e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f451581f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final Object f451582g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public ISearchCommodityAdapter f451583h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final Object f451584i;

    public ECViewHolderParam() {
        this(null, null, 511);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECViewHolderParam) == false) goto L24;
        ECViewHolderParam r101 = (ECViewHolderParam) r100;
        if (Intrinsics.areEqual(this.f451576a, r101.f451576a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f451577b, r101.f451577b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f451578c, r101.f451578c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f451579d, r101.f451579d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f451580e, r101.f451580e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f451581f, r101.f451581f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f451582g, r101.f451582g) == true) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f451583h, r101.f451583h) == true) goto L22;
        return false;
    L22:
        if (Intrinsics.areEqual(this.f451584i, r101.f451584i) == true) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    public final int hashCode() {
        Fragment r100 = this.f451576a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Function2<SearchAggregateCommodity, RecyclerView.ViewHolder, Unit> r104 = this.f451577b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        Object r107 = this.f451578c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        Object r110 = this.f451579d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        Object r113 = this.f451580e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f451581f;
        if (r116 == null) goto L25;
        int r117 = r116.hashCode();
    L26:
        int r118 = (r115 + r117) * 31;
        Object r119 = this.f451582g;
        if (r119 == null) goto L29;
        int r120 = r119.hashCode();
    L30:
        int r121 = (r118 + r120) * 31;
        ISearchCommodityAdapter r122 = this.f451583h;
        if (r122 == null) goto L33;
        int r123 = r122.hashCode();
    L34:
        int r124 = (r121 + r123) * 31;
        Object r125 = this.f451584i;
        if (r125 == null) goto L38;
        r101 = r125.hashCode();
    L38:
        return r124 + r101;
    L33:
        r123 = 0;
        goto L34
    L29:
        r120 = 0;
        goto L30
    L25:
        r117 = 0;
        goto L26
    L21:
        r114 = 0;
        goto L22
    L17:
        r111 = 0;
        goto L18
    L13:
        r108 = 0;
        goto L14
    L9:
        r105 = 0;
        goto L10
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECViewHolderParam(fragment=" + this.f451576a + ", cb=" + this.f451577b + ", containerStatusProvider=" + this.f451578c + ", scrollManager=" + this.f451579d + ", playVideoObserver=" + this.f451580e + ", enterFrom=" + this.f451581f + ", model=" + this.f451582g + ", iSearchCommodityAdapter=" + this.f451583h + ", dynamicDocument=" + this.f451584i + ")";
    }

    public ECViewHolderParam(Fragment r100, Function2 r101, int r102) {
        if ((r102 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r102 & 2) == 0) goto L8;
        r101 = null;
    L8:
        this.f451576a = r100;
        this.f451577b = r101;
        this.f451578c = null;
        this.f451579d = null;
        this.f451580e = null;
        this.f451581f = null;
        this.f451582g = null;
        this.f451583h = null;
        this.f451584i = null;
    }
}
