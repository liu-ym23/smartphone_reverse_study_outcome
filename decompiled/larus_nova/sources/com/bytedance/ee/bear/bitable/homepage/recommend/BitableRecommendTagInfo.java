package com.bytedance.ee.bear.bitable.homepage.recommend;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B\u0011\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0004\u0010\u0005J\u0010\u0010\t\u001a\u0004\u0018\u00010\u0003HÆ\u0003¢\u0006\u0002\u0010\u0007J\u001a\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u000bJ\u0013\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fHÖ\u0003J\t\u0010\u0010\u001a\u00020\u0003HÖ\u0001J\t\u0010\u0011\u001a\u00020\u0012HÖ\u0001R\u001a\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\b\u001a\u0004\b\u0006\u0010\u0007¨\u0006\u0013"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendTagInfo;", "Lcom/bytedance/ee/util/io/NonProguard;", "tagType", "", "<init>", "(Ljava/lang/Integer;)V", "getTagType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "component1", "copy", "(Ljava/lang/Integer;)Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendTagInfo;", "equals", "", "other", "", "hashCode", "toString", "", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecommendTagInfo implements NonProguard {

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_TAG_TYPE)
    private final Integer tagType;

    public static /* synthetic */ BitableRecommendTagInfo copy$default(BitableRecommendTagInfo r100, Integer r101, int r102, Object r103) {
        if ((r102 & 1) == 0) goto L6;
        r101 = r100.tagType;
    L6:
        return r100.copy(r101);
    }

    public final Integer component1() {
        return this.tagType;
    }

    public final BitableRecommendTagInfo copy(Integer r100) {
        return new BitableRecommendTagInfo(r100);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof BitableRecommendTagInfo) == true) goto L9;
        return false;
    L9:
        if (Intrinsics.areEqual(this.tagType, ((BitableRecommendTagInfo) r100).tagType) == true) goto L11;
        return false;
    L11:
        return true;
    }

    public int hashCode() {
        Integer r100 = this.tagType;
        if (r100 != null) goto L6;
        return 0;
    L6:
        return r100.hashCode();
    }

    public String toString() {
        return "BitableRecommendTagInfo(tagType=" + this.tagType + ')';
    }

    public final Integer getTagType() {
        return this.tagType;
    }

    public BitableRecommendTagInfo(Integer r100) {
        this.tagType = r100;
    }
}
