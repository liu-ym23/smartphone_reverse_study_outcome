package com.ss.android.ugc.aweme.search.vision.model.decouple;

import com.ss.android.ugc.aweme.search.model.commodity.CommodityResultParam;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/vision/model/decouple/SelectEntity;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class SelectEntity {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public String f453657a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public Integer f453658b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f453659c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final CommodityResultParam f453660d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public String f453661e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public String f453662f;

    public SelectEntity() {
        this(null, null, null, 63);
    }

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof SelectEntity) == false) goto L18;
        SelectEntity r101 = (SelectEntity) r100;
        if (Intrinsics.areEqual(this.f453657a, r101.f453657a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f453658b, r101.f453658b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f453659c, r101.f453659c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f453660d, r101.f453660d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f453661e, r101.f453661e) == true) goto L16;
        return false;
    L16:
        if (Intrinsics.areEqual(this.f453662f, r101.f453662f) == true) goto L28;
        return false;
    L28:
        return true;
    L18:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f453657a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        Integer r104 = this.f453658b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f453659c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        CommodityResultParam r110 = this.f453660d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f453661e;
        if (r113 == null) goto L21;
        int r114 = r113.hashCode();
    L22:
        int r115 = (r112 + r114) * 31;
        String r116 = this.f453662f;
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
        return "SelectEntity(detection=" + this.f453657a + ", index=" + this.f453658b + ", enterMethod=" + this.f453659c + ", sortParams=" + this.f453660d + ", queryId=" + this.f453661e + ", tosId=" + this.f453662f + ")";
    }

    public SelectEntity(String r100, Integer r101, String r102, int r103) {
        if ((r103 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r103 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r103 & 4) == 0) goto L11;
        r102 = null;
    L11:
        this.f453657a = r100;
        this.f453658b = r101;
        this.f453659c = r102;
        this.f453660d = null;
        this.f453661e = null;
        this.f453662f = null;
    }
}
