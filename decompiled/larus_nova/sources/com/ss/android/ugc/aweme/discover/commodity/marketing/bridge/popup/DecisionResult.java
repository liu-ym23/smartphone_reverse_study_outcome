package com.ss.android.ugc.aweme.discover.commodity.marketing.bridge.popup;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/commodity/marketing/bridge/popup/DecisionResult;", "", "ec-search-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class DecisionResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final String f450313a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final String f450314b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final String f450315c;

    /* JADX INFO: renamed from: d, reason: collision with root package name */
    public final boolean f450316d;

    /* JADX INFO: renamed from: e, reason: collision with root package name */
    public final String f450317e;

    public final boolean equals(Object r100) {
        if (this != r100) goto L4;
        return true;
    L4:
        if ((r100 instanceof DecisionResult) == false) goto L16;
        DecisionResult r101 = (DecisionResult) r100;
        if (Intrinsics.areEqual(this.f450313a, r101.f450313a) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.f450314b, r101.f450314b) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.f450315c, r101.f450315c) == true) goto L12;
        return false;
    L12:
        if (this.f450316d == r101.f450316d) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.f450317e, r101.f450317e) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r0v8, types: [int] */
    /* JADX WARN: Type inference failed for: r2v12 */
    /* JADX WARN: Type inference failed for: r2v7, types: [int] */
    /* JADX WARN: Type inference failed for: r2v9 */
    public final int hashCode() {
        String r100 = this.f450313a;
        int r101 = 0;
        if (r100 == null) goto L5;
        int r102 = r100.hashCode();
    L6:
        int r103 = r102 * 31;
        String r104 = this.f450314b;
        if (r104 == null) goto L9;
        int r105 = r104.hashCode();
    L10:
        int r106 = (r103 + r105) * 31;
        String r107 = this.f450315c;
        if (r107 == null) goto L13;
        int r108 = r107.hashCode();
    L14:
        int r109 = (r106 + r108) * 31;
        boolean r110 = this.f450316d;
        ?? r111 = r110;
        if (r110 == false) goto L17;
        r111 = 1;
    L17:
        int r112 = (r109 + r111) * 31;
        String r113 = this.f450317e;
        if (r113 == null) goto L21;
        r101 = r113.hashCode();
    L21:
        return r112 + r101;
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
        return "DecisionResult(searchId=" + this.f450313a + ", scene=" + this.f450314b + ", bizId=" + this.f450315c + ", shouldShow=" + this.f450316d + ", reason=" + this.f450317e + ")";
    }

    public DecisionResult(String r100, String r101, String r102, boolean r103, String r104) {
        Intrinsics.checkNotNullParameter(r100, "searchId");
        Intrinsics.checkNotNullParameter(r101, "scene");
        Intrinsics.checkNotNullParameter(r102, "bizId");
        Intrinsics.checkNotNullParameter(r104, "reason");
        this.f450313a = r100;
        this.f450314b = r101;
        this.f450315c = r102;
        this.f450316d = r103;
        this.f450317e = r104;
    }
}
