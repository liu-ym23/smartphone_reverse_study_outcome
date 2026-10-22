package com.bytedance.android.shopping.anchorv4.voavhs.head;

import com.bytedance.android.shopping.anchorv4.voavhs.head.view.FeaturedComment;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0005\b\u0086\b\u0018\u00002\u00020\u0001R\u001c\u0010\u0003\u001a\u0004\u0018\u00010\u00028\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\u0003\u0010\u0004\u001a\u0004\b\u0005\u0010\u0006R\u001c\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\f\n\u0004\b\b\u0010\t\u001a\u0004\b\n\u0010\u000b¨\u0006\f"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/i;", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/w;", "featuredShow", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/w;", "b", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/w;", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/FeaturedComment;", "featuredComment", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/FeaturedComment;", "a", "()Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/FeaturedComment;", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class i {

    @SerializedName("featured_comment")
    private final FeaturedComment featuredComment;

    @SerializedName("buy_show_comment")
    private final com.bytedance.android.shopping.anchorv4.voavhs.head.view.w featuredShow;

    public final boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof i) == false) goto L10;
        i r4 = (i) r3;
        if (Intrinsics.areEqual(this.featuredShow, r4.featuredShow) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.featuredComment, r4.featuredComment) == true) goto L16;
        return false;
    L16:
        return true;
    L10:
        return false;
    }

    public final int hashCode() {
        com.bytedance.android.shopping.anchorv4.voavhs.head.view.w r0 = this.featuredShow;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        FeaturedComment r4 = this.featuredComment;
        if (r4 == null) goto L10;
        r1 = r4.hashCode();
    L10:
        return r3 + r1;
    L5:
        r2 = 0;
        goto L6
    }

    public final String toString() {
        return "HeadCommentInfo(featuredShow=" + this.featuredShow + ", featuredComment=" + this.featuredComment + ")";
    }

    public i() {
        this.featuredShow = null;
        this.featuredComment = null;
    }

    public final FeaturedComment a() {
        return this.featuredComment;
    }

    public final com.bytedance.android.shopping.anchorv4.voavhs.head.view.w b() {
        return this.featuredShow;
    }
}
