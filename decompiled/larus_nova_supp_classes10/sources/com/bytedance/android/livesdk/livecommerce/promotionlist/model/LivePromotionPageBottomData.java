package com.bytedance.android.livesdk.livecommerce.promotionlist.model;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import xi2.j;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes10.dex */
@Metadata(d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u000b\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0002\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u0019\u0010\u001aJ\u000b\u0010\u0003\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0004\u001a\u0004\u0018\u00010\u0002HÆ\u0003J\u000b\u0010\u0006\u001a\u0004\u0018\u00010\u0005HÆ\u0003J-\u0010\n\u001a\u00020\u00002\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00022\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\t\u0010\u000b\u001a\u00020\u0002HÖ\u0001J\t\u0010\r\u001a\u00020\fHÖ\u0001J\u0013\u0010\u0011\u001a\u00020\u00102\b\u0010\u000f\u001a\u0004\u0018\u00010\u000eHÖ\u0003R\u001c\u0010\u0007\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0007\u0010\u0012\u001a\u0004\b\u0013\u0010\u0014R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\u0012\u001a\u0004\b\u0015\u0010\u0014R\u001c\u0010\t\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\t\u0010\u0016\u001a\u0004\b\u0017\u0010\u0018¨\u0006\u001b"}, d2 = {"Lcom/bytedance/android/livesdk/livecommerce/promotionlist/model/LivePromotionPageBottomData;", "Ljava/io/Serializable;", "", "component1", "component2", "Lxi2/j;", "component3", "bottomTitle", "bottomRecommendTitle", "bottomInfo", "copy", "toString", "", "hashCode", "", "other", "", "equals", "Ljava/lang/String;", "getBottomTitle", "()Ljava/lang/String;", "getBottomRecommendTitle", "Lxi2/j;", "getBottomInfo", "()Lxi2/j;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Lxi2/j;)V", "livecommerce_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LivePromotionPageBottomData implements Serializable {

    @SerializedName("bottom_info")
    private final j bottomInfo;

    @SerializedName("bottom_recommend_title")
    private final String bottomRecommendTitle;

    @SerializedName("bottom_title")
    private final String bottomTitle;

    public LivePromotionPageBottomData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ LivePromotionPageBottomData copy$default(LivePromotionPageBottomData r0, String r1, String r2, j r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.bottomTitle;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.bottomRecommendTitle;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.bottomInfo;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final String component1() {
        return this.bottomTitle;
    }

    public final String component2() {
        return this.bottomRecommendTitle;
    }

    public final j component3() {
        return this.bottomInfo;
    }

    public final LivePromotionPageBottomData copy(String r2, String r3, j r4) {
        return new LivePromotionPageBottomData(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof LivePromotionPageBottomData) == false) goto L12;
        LivePromotionPageBottomData r4 = (LivePromotionPageBottomData) r3;
        if (Intrinsics.areEqual(this.bottomTitle, r4.bottomTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.bottomRecommendTitle, r4.bottomRecommendTitle) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.bottomInfo, r4.bottomInfo) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        String r0 = this.bottomTitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        String r4 = this.bottomRecommendTitle;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        j r7 = this.bottomInfo;
        if (r7 == null) goto L14;
        r1 = r7.hashCode();
    L14:
        return r6 + r1;
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "LivePromotionPageBottomData(bottomTitle=" + this.bottomTitle + ", bottomRecommendTitle=" + this.bottomRecommendTitle + ", bottomInfo=" + this.bottomInfo + ")";
    }

    public final j getBottomInfo() {
        return this.bottomInfo;
    }

    public final String getBottomRecommendTitle() {
        return this.bottomRecommendTitle;
    }

    public final String getBottomTitle() {
        return this.bottomTitle;
    }

    public LivePromotionPageBottomData(String r1, String r2, j r3) {
        this.bottomTitle = r1;
        this.bottomRecommendTitle = r2;
        this.bottomInfo = r3;
    }

    public /* synthetic */ LivePromotionPageBottomData(String r2, String r3, j r4, int r5, DefaultConstructorMarker r6) {
        if ((r5 & 1) == 0) goto L6;
        r2 = null;
    L6:
        if ((r5 & 2) == 0) goto L9;
        r3 = null;
    L9:
        if ((r5 & 4) == 0) goto L11;
        r4 = null;
    L11:
        this(r2, r3, r4);
    }
}
