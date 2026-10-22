package com.ss.android.ugc.aweme.search.filter;

import com.ss.android.ugc.aweme.discover.model.commodity.select.SelectItemStatus;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchCityInfo;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchCityInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f452792a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f452793b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f452794c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f452795d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f452796e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final SelectItemStatus f452797f;

    public ECSearchCityInfo() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchCityInfo) == false) goto L18;
        ECSearchCityInfo r101 = (ECSearchCityInfo) r100;
        if (Intrinsics.areEqual(this.f452792a, r101.f452792a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f452793b, r101.f452793b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f452794c, r101.f452794c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f452795d, r101.f452795d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f452796e, r101.f452796e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f452797f, r101.f452797f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f452792a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f452793b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f452794c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f452795d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f452796e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        SelectItemStatus r116 = this.f452797f;
        if (r116 == null) goto L26;
        r101 = r116.hashCode();
    L26:
        return r115 + r101;
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
        return "ECSearchCityInfo(selectedCityCode=" + this.f452792a + ", selectedCityName=" + this.f452793b + ", l3SelectedName=" + this.f452794c + ", l3SelectedCode=" + this.f452795d + ", l3SelectedType=" + this.f452796e + ", citySelectedStatusInfo=" + this.f452797f + ")";
    }

    public ECSearchCityInfo(int r100) {
        this.f452792a = null;
        this.f452793b = null;
        this.f452794c = null;
        this.f452795d = null;
        this.f452796e = null;
        this.f452797f = null;
    }
}
