package com.ss.android.ugc.aweme.search.common;

import com.ss.android.ugc.aweme.search.common.result.RefreshTrigger;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/common/ECSearchRefreshPageParam;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchRefreshPageParam {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final RefreshTrigger f451389a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final boolean f451390b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f451391c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f451392d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f451393e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f451394f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final String f451395g;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchRefreshPageParam) == false) goto L20;
        ECSearchRefreshPageParam r101 = (ECSearchRefreshPageParam) r100;
        if (Intrinsics.areEqual(this.f451389a, r101.f451389a) == true) goto L8;
        return false;
    L8:
        if (this.f451390b == r101.f451390b) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f451391c, r101.f451391c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f451392d, r101.f451392d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f451393e, r101.f451393e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f451394f, r101.f451394f) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f451395g, r101.f451395g) == true) goto L31;
        return false;
    L31:
        return true;
    L20:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v4, types: [int] */
    /* JADX WARN: Type inference failed for: r2v1, types: [int] */
    /* JADX WARN: Type inference failed for: r2v19 */
    /* JADX WARN: Type inference failed for: r2v20 */
    public final int hashCode() {
        RefreshTrigger r100 = this.f451389a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        boolean r104 = this.f451390b;
        ?? r105 = r104;
        if (r104 == false) goto L9;
        r105 = 1;
    L9:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f451391c;
        if (r107 == null) goto L12;
        int r108 = r107.hashCode();
    L13:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f451392d;
        if (r110 == null) goto L16;
        int r111 = r110.hashCode();
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f451393e;
        if (r113 == null) goto L20;
        int r114 = r113.hashCode();
    L21:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f451394f;
        if (r116 == null) goto L24;
        int r117 = r116.hashCode();
    L25:
        int r118 = (r115 + r117) * 31;
        String r119 = this.f451395g;
        if (r119 == null) goto L29;
        r101 = r119.hashCode();
    L29:
        return r118 + r101;
    L24:
        r117 = 0;
        goto L25
    L20:
        r114 = 0;
        goto L21
    L16:
        r111 = 0;
        goto L17
    L12:
        r108 = 0;
        goto L13
    L5:
        r102 = 0;
        goto L6
    }

    public final String toString() {
        return "ECSearchRefreshPageParam(triggerType=" + this.f451389a + ", isRefresh=" + this.f451390b + ", searchKeyword=" + this.f451391c + ", source=" + this.f451392d + ", page=" + this.f451393e + ", clientEngineExtra=" + this.f451394f + ", extra=" + this.f451395g + ")";
    }

    public ECSearchRefreshPageParam(RefreshTrigger r100, boolean r101, String r102, String r103, String r104, String r105, int r106) {
        if ((r106 & 4) == 0) goto L6;
        r102 = null;
    L6:
        if ((r106 & 8) == 0) goto L9;
        r103 = null;
    L9:
        if ((r106 & 16) == 0) goto L12;
        r104 = null;
    L12:
        if ((r106 & 32) == 0) goto L14;
        r105 = null;
    L14:
        Intrinsics.checkNotNullParameter(r100, "triggerType");
        this.f451389a = r100;
        this.f451390b = r101;
        this.f451391c = r102;
        this.f451392d = r103;
        this.f451393e = r104;
        this.f451394f = r105;
        this.f451395g = null;
    }
}
