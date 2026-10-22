package com.bytedance.locallife.groupon.guesslike.data;

import com.google.gson.annotations.SerializedName;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0010 \n\u0002\u0010\u000e\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0007\b\u0086\b\u0018\u00002\u00020\u0001R,\u0010\u0004\u001a\f\u0012\u0006\u0012\u0004\u0018\u00010\u0003\u0018\u00010\u00028\u0006@\u0006X\u0087\u000e¢\u0006\u0012\n\u0004\b\u0004\u0010\u0005\u001a\u0004\b\u0006\u0010\u0007\"\u0004\b\b\u0010\tR\u001a\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000b\u0010\f\u001a\u0004\b\r\u0010\u000eR\u001a\u0010\u000f\u001a\u00020\n8\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u000f\u0010\f\u001a\u0004\b\u0010\u0010\u000e¨\u0006\u0011"}, d2 = {"Lcom/bytedance/locallife/groupon/guesslike/data/a;", "", "", "", "preloadCovers", "Ljava/util/List;", "getPreloadCovers", "()Ljava/util/List;", "setPreloadCovers", "(Ljava/util/List;)V", "", "cacheDisable", "Z", "getCacheDisable", "()Z", "cardReuseDisable", "getCardReuseDisable", "locallife-groupon-api_release"}, k = 1, mv = {1, 4, 3})
public final class a {

    @SerializedName("cacheDisable")
    private final boolean cacheDisable;

    @SerializedName("cardReuseDisable")
    private final boolean cardReuseDisable;

    @SerializedName("preloadCovers")
    private List<String> preloadCovers;

    public final boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof a) == true) goto L8;
        return false;
    L8:
        a r101 = (a) r100;
        if (Intrinsics.areEqual(this.preloadCovers, r101.preloadCovers) == true) goto L12;
        return false;
    L12:
        if (this.cacheDisable == r101.cacheDisable) goto L15;
        return false;
    L15:
        if (this.cardReuseDisable == r101.cardReuseDisable) goto L17;
        return false;
    L17:
        return true;
    }

    public final int hashCode() {
        List<String> r100 = this.preloadCovers;
        if (r100 != null) goto L5;
        int r101 = 0;
    L6:
        int r102 = r101 * 31;
        int r103 = 1231;
        if (this.cacheDisable == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r102 + r104) * 31;
        if (this.cardReuseDisable == true) goto L15;
        r103 = 1237;
    L15:
        return r105 + r103;
    L9:
        r104 = 1237;
        goto L10
    L5:
        r101 = r100.hashCode();
        goto L6
    }

    public final String toString() {
        return "GuessLikeConfig(preloadCovers=" + this.preloadCovers + ", cacheDisable=" + this.cacheDisable + ", cardReuseDisable=" + this.cardReuseDisable + ')';
    }

    public a() {
        this.preloadCovers = null;
        this.cacheDisable = false;
        this.cardReuseDisable = false;
    }
}
