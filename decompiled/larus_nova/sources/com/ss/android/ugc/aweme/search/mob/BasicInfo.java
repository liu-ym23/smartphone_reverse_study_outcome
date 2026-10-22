package com.ss.android.ugc.aweme.search.mob;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/search/mob/BasicInfo;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class BasicInfo {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f453285a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f453286b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f453287c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final String f453288d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f453289e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof BasicInfo) == false) goto L16;
        BasicInfo r101 = (BasicInfo) r100;
        if (Intrinsics.areEqual(this.f453285a, r101.f453285a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f453286b, r101.f453286b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f453287c, r101.f453287c) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f453288d, r101.f453288d) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f453289e, r101.f453289e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public final int hashCode() {
        String r100 = this.f453285a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f453286b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f453287c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        String r110 = this.f453288d;
        if (r110 == null) goto L17;
        int r111 = r110.hashCode();
    L18:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f453289e;
        if (r113 == null) goto L22;
        r101 = r113.hashCode();
    L22:
        return r112 + r101;
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
        return "BasicInfo(searchId=" + this.f453285a + ", searchEntrance=" + this.f453286b + ", enterFrom=" + this.f453287c + ", enterMethod=" + this.f453288d + ", searchScene=" + this.f453289e + ")";
    }

    public BasicInfo(String r100, String r101, String r102, String r103) {
        Intrinsics.checkNotNullParameter("photo_search", "searchScene");
        this.f453285a = r100;
        this.f453286b = r101;
        this.f453287c = r102;
        this.f453288d = r103;
        this.f453289e = "photo_search";
    }
}
