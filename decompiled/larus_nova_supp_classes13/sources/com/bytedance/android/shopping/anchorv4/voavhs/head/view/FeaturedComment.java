package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B/\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0011\u0010\u000f\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u0005HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J3\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\u0010\b\u0002\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015HÖ\u0003J\t\u0010\u0016\u001a\u00020\u0017HÖ\u0001J\t\u0010\u0018\u001a\u00020\u0019HÖ\u0001R\u001e\u0010\u0004\u001a\n\u0012\u0004\u0012\u00020\u0006\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/FeaturedComment;", "Ljava/io/Serializable;", "featuredTitle", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "featuredCommentList", "", "Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/CommentInfoVO;", "moreCommentTitle", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Ljava/util/List;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "getFeaturedCommentList", "()Ljava/util/List;", "getFeaturedTitle", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getMoreCommentTitle", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class FeaturedComment implements Serializable {

    @SerializedName("feature_comment_list")
    private final List<CommentInfoVO> featuredCommentList;

    @SerializedName("featured_title")
    private final TextWithOneIconElement featuredTitle;

    @SerializedName("more_comment_title")
    private final TextWithOneIconElement moreCommentTitle;

    public FeaturedComment() {
        this(null, null, null, 7, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ FeaturedComment copy$default(FeaturedComment r0, TextWithOneIconElement r1, List r2, TextWithOneIconElement r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.featuredTitle;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.featuredCommentList;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.moreCommentTitle;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final TextWithOneIconElement component1() {
        return this.featuredTitle;
    }

    public final List<CommentInfoVO> component2() {
        return this.featuredCommentList;
    }

    public final TextWithOneIconElement component3() {
        return this.moreCommentTitle;
    }

    public final FeaturedComment copy(TextWithOneIconElement r2, List<CommentInfoVO> r3, TextWithOneIconElement r4) {
        return new FeaturedComment(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof FeaturedComment) == false) goto L12;
        FeaturedComment r4 = (FeaturedComment) r3;
        if (Intrinsics.areEqual(this.featuredTitle, r4.featuredTitle) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.featuredCommentList, r4.featuredCommentList) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.moreCommentTitle, r4.moreCommentTitle) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r0 = this.featuredTitle;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        List<CommentInfoVO> r4 = this.featuredCommentList;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TextWithOneIconElement r7 = this.moreCommentTitle;
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
        return "FeaturedComment(featuredTitle=" + this.featuredTitle + ", featuredCommentList=" + this.featuredCommentList + ", moreCommentTitle=" + this.moreCommentTitle + ")";
    }

    public final List<CommentInfoVO> getFeaturedCommentList() {
        return this.featuredCommentList;
    }

    public final TextWithOneIconElement getFeaturedTitle() {
        return this.featuredTitle;
    }

    public final TextWithOneIconElement getMoreCommentTitle() {
        return this.moreCommentTitle;
    }

    public FeaturedComment(TextWithOneIconElement r1, List<CommentInfoVO> r2, TextWithOneIconElement r3) {
        this.featuredTitle = r1;
        this.featuredCommentList = r2;
        this.moreCommentTitle = r3;
    }

    public /* synthetic */ FeaturedComment(TextWithOneIconElement r2, List r3, TextWithOneIconElement r4, int r5, DefaultConstructorMarker r6) {
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
