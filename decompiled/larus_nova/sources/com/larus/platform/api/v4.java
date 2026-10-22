package com.larus.platform.api;

import java.util.ArrayList;
import java.util.Map;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes31.dex */
public final class v4 {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final Map<String, String> f365307a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final ArrayList<String> f365308b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final boolean f365309c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final Map<String, String> f365310d;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof v4) == true) goto L8;
        return false;
    L8:
        v4 r101 = (v4) r100;
        if (Intrinsics.areEqual(this.f365307a, r101.f365307a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f365308b, r101.f365308b) == true) goto L15;
        return false;
    L15:
        if (this.f365309c == r101.f365309c) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.f365310d, r101.f365310d) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public final int hashCode() {
        int r100 = this.f365307a.hashCode() * 31;
        ArrayList<String> r101 = this.f365308b;
        int r102 = 0;
        if (r101 != null) goto L5;
        int r103 = 0;
    L6:
        int r104 = (r100 + r103) * 31;
        if (this.f365309c == false) goto L9;
        int r105 = 1231;
    L10:
        int r106 = (r104 + r105) * 31;
        Map<String, String> r107 = this.f365310d;
        if (r107 == null) goto L15;
        r102 = r107.hashCode();
    L15:
        return r106 + r102;
    L9:
        r105 = 1237;
        goto L10
    L5:
        r103 = r101.hashCode();
        goto L6
    }

    public final String toString() {
        return "PrefetchRecommendVideoResult(itemsToRequestIdHashMap=" + this.f365307a + ", itemIdList=" + this.f365308b + ", innerLoadMoreRequestFromSecondRun=" + this.f365309c + ", itemsToChannelIdHashMap=" + this.f365310d + ')';
    }

    public v4(Map<String, String> r100, ArrayList<String> r101, boolean r102, Map<String, String> r103) {
        Intrinsics.checkNotNullParameter(r100, "itemsToRequestIdHashMap");
        this.f365307a = r100;
        this.f365308b = r101;
        this.f365309c = r102;
        this.f365310d = r103;
    }
}
