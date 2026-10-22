package com.ss.android.ugc.aweme.search.filter;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/filter/ECSearchCalenderInfo;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class ECSearchCalenderInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f452783a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f452784b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f452785c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f452786d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f452787e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final String f452788f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final boolean f452789g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final int f452790h;

    /* JADX INFO: renamed from: i, reason: collision with root package name */
    public final boolean f452791i;

    public ECSearchCalenderInfo() {
        this(0);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof ECSearchCalenderInfo) == false) goto L24;
        ECSearchCalenderInfo r101 = (ECSearchCalenderInfo) r100;
        if (Intrinsics.areEqual(this.f452783a, r101.f452783a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f452784b, r101.f452784b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f452785c, r101.f452785c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f452786d, r101.f452786d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f452787e, r101.f452787e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f452788f, r101.f452788f) == true) goto L18;
        return false;
    L18:
        if (this.f452789g == r101.f452789g) goto L20;
        return false;
    L20:
        if (this.f452790h == r101.f452790h) goto L22;
        return false;
    L22:
        if (this.f452791i == r101.f452791i) goto L37;
        return false;
    L37:
        return true;
    L24:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v14, types: [int] */
    /* JADX WARN: Type inference failed for: r0v18, types: [int] */
    /* JADX WARN: Type inference failed for: r1v3, types: [int] */
    /* JADX WARN: Type inference failed for: r1v6 */
    /* JADX WARN: Type inference failed for: r1v8 */
    /* JADX WARN: Type inference failed for: r2v13 */
    /* JADX WARN: Type inference failed for: r2v14, types: [int] */
    /* JADX WARN: Type inference failed for: r2v15 */
    public final int hashCode() {
        String r100 = this.f452783a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f452784b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f452785c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f452786d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f452787e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f452788f;
        if (r116 == null) goto L25;
        r101 = r116.hashCode();
    L25:
        int r117 = (r115 + r101) * 31;
        boolean r118 = this.f452789g;
        ?? r119 = 1;
        ?? r120 = r118;
        if (r118 == false) goto L28;
        r120 = 1;
    L28:
        int r121 = (((r117 + r120) * 31) + this.f452790h) * 31;
        boolean r122 = this.f452791i;
        if (r122 == true) goto L33;
        r119 = r122;
    L33:
        return r121 + r119;
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
        return "ECSearchCalenderInfo(startDateHint=" + this.f452783a + ", endDateHint=" + this.f452784b + ", startDateText=" + this.f452785c + ", endDateText=" + this.f452786d + ", startDate=" + this.f452787e + ", endDate=" + this.f452788f + ", hasDateSelected=" + this.f452789g + ", isMorning=" + this.f452790h + ", hasManualSelected=" + this.f452791i + ")";
    }

    public ECSearchCalenderInfo(int r100) {
        this.f452783a = null;
        this.f452784b = null;
        this.f452785c = null;
        this.f452786d = null;
        this.f452787e = null;
        this.f452788f = null;
        this.f452789g = false;
        this.f452790h = 0;
        this.f452791i = false;
    }
}
