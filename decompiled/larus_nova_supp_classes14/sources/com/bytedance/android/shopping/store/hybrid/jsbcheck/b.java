package com.bytedance.android.shopping.store.hybrid.jsbcheck;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes14.dex */
@Metadata(d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R\"\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007R\"\u0010\b\u001a\n\u0012\u0004\u0012\u00020\u0003\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0005\u001a\u0004\b\t\u0010\u0007¨\u0006\n"}, d2 = {"Lcom/bytedance/android/shopping/store/hybrid/jsbcheck/b;", "", "", "", "matchRegex", "Ljava/util/List;", "getMatchRegex", "()Ljava/util/List;", "blockRegex", "getBlockRegex", "ec-biz-store-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class b {

    @SerializedName("block_regex")
    private final List<String> blockRegex;

    @SerializedName("match_regex")
    private final List<String> matchRegex;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof b) == false) goto L10;
        b r4 = (b) r3;
        if (Intrinsics.areEqual(this.matchRegex, r4.matchRegex) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.blockRegex, r4.blockRegex) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        List<String> r0 = this.matchRegex;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<String> r4 = this.blockRegex;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "ECStoreJsbPolicyRule(matchRegex=" + this.matchRegex + ", blockRegex=" + this.blockRegex + ")";
    }

    public b() {
        this.matchRegex = null;
        this.blockRegex = null;
    }
}
