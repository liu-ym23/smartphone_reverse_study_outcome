package com.bytedance.android.shopping.anchorv4.voavhs.head.vo;

import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B)\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\u0002\u0010\u0006J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\r\u001a\u0004\u0018\u00010\u0003HÆ\u0003J-\u0010\u000e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0013\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012HÖ\u0003J\t\u0010\u0013\u001a\u00020\u0014HÖ\u0001J\t\u0010\u0015\u001a\u00020\u0016HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\bR\u0018\u0010\u0005\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b¨\u0006\u0017"}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/vo/CommentVideoInfo;", "Ljava/io/Serializable;", "authorHead", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "authorName", "moreText", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;)V", "getAuthorHead", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "getAuthorName", "getMoreText", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentVideoInfo implements Serializable {

    @SerializedName("author_head")
    private final TextWithOneIconElement authorHead;

    @SerializedName("author_name")
    private final TextWithOneIconElement authorName;

    @SerializedName("more_text")
    private final TextWithOneIconElement moreText;

    public CommentVideoInfo() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ CommentVideoInfo copy$default(CommentVideoInfo r0, TextWithOneIconElement r1, TextWithOneIconElement r2, TextWithOneIconElement r3, int r4, Object r5) {
        if ((r4 & 1) == 0) goto L6;
        r1 = r0.authorHead;
    L6:
        if ((r4 & 2) == 0) goto L9;
        r2 = r0.authorName;
    L9:
        if ((r4 & 4) == 0) goto L12;
        r3 = r0.moreText;
    L12:
        return r0.copy(r1, r2, r3);
    }

    public final TextWithOneIconElement component1() {
        return this.authorHead;
    }

    public final TextWithOneIconElement component2() {
        return this.authorName;
    }

    public final TextWithOneIconElement component3() {
        return this.moreText;
    }

    public final CommentVideoInfo copy(TextWithOneIconElement r2, TextWithOneIconElement r3, TextWithOneIconElement r4) {
        return new CommentVideoInfo(r2, r3, r4);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommentVideoInfo) == false) goto L12;
        CommentVideoInfo r4 = (CommentVideoInfo) r3;
        if (Intrinsics.areEqual(this.authorHead, r4.authorHead) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.authorName, r4.authorName) == true) goto L10;
        return false;
    L10:
        if (Intrinsics.areEqual(this.moreText, r4.moreText) == true) goto L19;
        return false;
    L19:
        return true;
    L12:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r0 = this.authorHead;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        TextWithOneIconElement r4 = this.authorName;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (r3 + r5) * 31;
        TextWithOneIconElement r7 = this.moreText;
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
        return "CommentVideoInfo(authorHead=" + this.authorHead + ", authorName=" + this.authorName + ", moreText=" + this.moreText + ")";
    }

    public final TextWithOneIconElement getAuthorHead() {
        return this.authorHead;
    }

    public final TextWithOneIconElement getAuthorName() {
        return this.authorName;
    }

    public final TextWithOneIconElement getMoreText() {
        return this.moreText;
    }

    public CommentVideoInfo(TextWithOneIconElement r1, TextWithOneIconElement r2, TextWithOneIconElement r3) {
        this.authorHead = r1;
        this.authorName = r2;
        this.moreText = r3;
    }

    public /* synthetic */ CommentVideoInfo(TextWithOneIconElement r2, TextWithOneIconElement r3, TextWithOneIconElement r4, int r5, DefaultConstructorMarker r6) {
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
