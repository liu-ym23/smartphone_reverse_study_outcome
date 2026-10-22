package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.popup;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/popup/PopupCandidate;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class PopupCandidate {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f450326a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f450327b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450328c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final int f450329d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final boolean f450330e;

    /* JADX INFO: renamed from: f, reason: collision with root package name */
    public final long f450331f;

    /* JADX INFO: renamed from: g, reason: collision with root package name */
    public final long f450332g;

    /* JADX INFO: renamed from: h, reason: collision with root package name */
    public final DecisionCallback f450333h;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof PopupCandidate) == false) goto L22;
        PopupCandidate r101 = (PopupCandidate) r100;
        if (Intrinsics.areEqual(this.f450326a, r101.f450326a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f450327b, r101.f450327b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f450328c, r101.f450328c) == true) goto L12;
        return false;
    L12:
        if (this.f450329d == r101.f450329d) goto L14;
        return false;
    L14:
        if (this.f450330e == r101.f450330e) goto L16;
        return false;
    L16:
        if (this.f450331f == r101.f450331f) goto L18;
        return false;
    L18:
        if (this.f450332g == r101.f450332g) goto L20;
        return false;
    L20:
        if (Intrinsics.areEqual(this.f450333h, r101.f450333h) == true) goto L34;
        return false;
    L34:
        return true;
    L22:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v10, types: [int] */
    /* JADX WARN: Type inference failed for: r2v14 */
    /* JADX WARN: Type inference failed for: r2v17 */
    /* JADX WARN: Type inference failed for: r2v8, types: [int] */
    public final int hashCode() {
        String r100 = this.f450326a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f450327b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f450328c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (((r106 + r108) * 31) + this.f450329d) * 31;
        boolean r110 = this.f450330e;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        long r113 = this.f450331f;
        int r114 = (r112 + ((int) (r113 ^ (r113 >>> 32)))) * 31;
        long r115 = this.f450332g;
        int r116 = (r114 + ((int) (r115 ^ (r115 >>> 32)))) * 31;
        DecisionCallback r117 = this.f450333h;
        if (r117 == null) goto L21;
        r101 = r117.hashCode();
    L21:
        return r116 + r101;
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
        return "PopupCandidate(searchId=" + this.f450326a + ", scene=" + this.f450327b + ", bizId=" + this.f450328c + ", priority=" + this.f450329d + ", isLastPopup=" + this.f450330e + ", submitTs=" + this.f450331f + ", receiveTs=" + this.f450332g + ", callback=" + this.f450333h + ")";
    }

    public final String a() {
        return this.f450327b + '#' + this.f450328c;
    }

    public PopupCandidate(String r100, String r101, String r102, int r103, boolean r104, long r105, long r106, DecisionCallback r110) {
        Intrinsics.checkNotNullParameter(r100, "searchId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "bizId");
        this.f450326a = r100;
        this.f450327b = r101;
        this.f450328c = r102;
        this.f450329d = r103;
        this.f450330e = r104;
        this.f450331f = r105;
        this.f450332g = r106;
        this.f450333h = r110;
    }
}
