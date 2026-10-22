package com.ss.android.ugc.aweme.poi.mob;

import java.util.List;
import java.util.Map;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(d1 = {"\u0000\n\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001¨\u0006\u0002"}, d2 = {"Lcom/ss/android/ugc/aweme/poi/mob/ConflictDetectResult;", "", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3})
public final class ConflictDetectResult {

    /* JADX INFO: renamed from: a, reason: collision with root package name */
    public final List<ConflictItemDetail> f451349a;

    /* JADX INFO: renamed from: b, reason: collision with root package name */
    public final List<ConflictItemDetail> f451350b;

    /* JADX INFO: renamed from: c, reason: collision with root package name */
    public final Map<String, Map<String, List<WriteActionRecord>>> f451351c;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof ConflictDetectResult) == true) goto L8;
        return false;
    L8:
        ConflictDetectResult r101 = (ConflictDetectResult) r100;
        if (Intrinsics.areEqual(this.f451349a, r101.f451349a) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.f451350b, r101.f451350b) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.f451351c, r101.f451351c) == true) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        return (((this.f451349a.hashCode() * 31) + this.f451350b.hashCode()) * 31) + this.f451351c.hashCode();
    }

    public final String toString() {
        return "ConflictDetectResult(itemsOfValueDiff=" + this.f451349a + ", itemsOfValueDiffInBlackList=" + this.f451350b + ", originItems=" + this.f451351c + ')';
    }

    /* JADX WARN: Multi-variable type inference failed */
    public ConflictDetectResult(List<ConflictItemDetail> r100, List<ConflictItemDetail> r101, Map<String, ? extends Map<String, ? extends List<WriteActionRecord>>> r102) {
        Intrinsics.checkNotNullParameter(r100, "itemsOfValueDiff");
        Intrinsics.checkNotNullParameter(r101, "itemsOfValueDiffInBlackList");
        Intrinsics.checkNotNullParameter(r102, "originItems");
        this.f451349a = r100;
        this.f451350b = r101;
        this.f451351c = r102;
    }
}
