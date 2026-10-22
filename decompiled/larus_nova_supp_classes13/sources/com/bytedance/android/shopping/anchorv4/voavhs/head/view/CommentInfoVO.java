package com.bytedance.android.shopping.anchorv4.voavhs.head.view;

import com.bytedance.android.shopping.anchorv4.dto.base.ImageModel;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextElement;
import com.bytedance.android.shopping.anchorv4.dto.elements.TextWithOneIconElement;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: /private/tmp/nixiang/classes13.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\tHÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0005HÆ\u0003JC\u0010\u001a\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001J\u0013\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u001eHÖ\u0003J\t\u0010\u001f\u001a\u00020\u0007HÖ\u0001J\t\u0010 \u001a\u00020!HÖ\u0001R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014¨\u0006\""}, d2 = {"Lcom/bytedance/android/shopping/anchorv4/voavhs/head/view/CommentInfoVO;", "Ljava/io/Serializable;", "userName", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "userAvatar", "Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "rank", "", "content", "Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "photo", "(Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;ILcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;)V", "getContent", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextElement;", "getPhoto", "()Lcom/bytedance/android/shopping/anchorv4/dto/base/ImageModel;", "getRank", "()I", "getUserAvatar", "getUserName", "()Lcom/bytedance/android/shopping/anchorv4/dto/elements/TextWithOneIconElement;", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "", "hashCode", "toString", "", "ec-shopping-impl_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class CommentInfoVO implements Serializable {

    @SerializedName("content")
    private final TextElement content;

    @SerializedName("photo")
    private final ImageModel photo;

    @SerializedName("rank")
    private final int rank;

    @SerializedName("user_avatar")
    private final ImageModel userAvatar;

    @SerializedName("user_name")
    private final TextWithOneIconElement userName;

    public CommentInfoVO() {
        this(null, null, 0, null, null, 31, null);
    }

    public static /* synthetic */ CommentInfoVO copy$default(CommentInfoVO r3, TextWithOneIconElement r4, ImageModel r5, int r6, TextElement r7, ImageModel r8, int r9, Object r10) {
        if ((r9 & 1) == 0) goto L6;
        r4 = r3.userName;
    L6:
        if ((r9 & 2) == 0) goto L8;
        r5 = r3.userAvatar;
    L8:
        ImageModel r11 = r5;
        if ((r9 & 4) == 0) goto L11;
        r6 = r3.rank;
    L11:
        int r0 = r6;
        if ((r9 & 8) == 0) goto L14;
        r7 = r3.content;
    L14:
        TextElement r1 = r7;
        if ((r9 & 16) == 0) goto L17;
        r8 = r3.photo;
    L17:
        TextWithOneIconElement r12 = r4;
        return r3.copy(r12, r11, r0, r1, r8);
    }

    public final TextWithOneIconElement component1() {
        return this.userName;
    }

    public final ImageModel component2() {
        return this.userAvatar;
    }

    public final int component3() {
        return this.rank;
    }

    public final TextElement component4() {
        return this.content;
    }

    public final ImageModel component5() {
        return this.photo;
    }

    public final CommentInfoVO copy(TextWithOneIconElement r8, ImageModel r9, int r10, TextElement r11, ImageModel r12) {
        return new CommentInfoVO(r8, r9, r10, r11, r12);
    }

    public boolean equals(Object r3) {
        if (this != r3) goto L4;
        return true;
    L4:
        if ((r3 instanceof CommentInfoVO) == false) goto L16;
        CommentInfoVO r4 = (CommentInfoVO) r3;
        if (Intrinsics.areEqual(this.userName, r4.userName) == true) goto L8;
        return false;
    L8:
        if (Intrinsics.areEqual(this.userAvatar, r4.userAvatar) == true) goto L10;
        return false;
    L10:
        if (this.rank == r4.rank) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.content, r4.content) == true) goto L14;
        return false;
    L14:
        if (Intrinsics.areEqual(this.photo, r4.photo) == true) goto L25;
        return false;
    L25:
        return true;
    L16:
        return false;
    }

    public int hashCode() {
        TextWithOneIconElement r0 = this.userName;
        int r1 = 0;
        if (r0 == null) goto L5;
        int r2 = r0.hashCode();
    L6:
        int r3 = r2 * 31;
        ImageModel r4 = this.userAvatar;
        if (r4 == null) goto L9;
        int r5 = r4.hashCode();
    L10:
        int r6 = (((r3 + r5) * 31) + this.rank) * 31;
        TextElement r7 = this.content;
        if (r7 == null) goto L13;
        int r8 = r7.hashCode();
    L14:
        int r9 = (r6 + r8) * 31;
        ImageModel r10 = this.photo;
        if (r10 == null) goto L18;
        r1 = r10.hashCode();
    L18:
        return r9 + r1;
    L13:
        r8 = 0;
        goto L14
    L9:
        r5 = 0;
        goto L10
    L5:
        r2 = 0;
        goto L6
    }

    public String toString() {
        return "CommentInfoVO(userName=" + this.userName + ", userAvatar=" + this.userAvatar + ", rank=" + this.rank + ", content=" + this.content + ", photo=" + this.photo + ")";
    }

    public final TextElement getContent() {
        return this.content;
    }

    public final ImageModel getPhoto() {
        return this.photo;
    }

    public final int getRank() {
        return this.rank;
    }

    public final ImageModel getUserAvatar() {
        return this.userAvatar;
    }

    public final TextWithOneIconElement getUserName() {
        return this.userName;
    }

    public CommentInfoVO(TextWithOneIconElement r1, ImageModel r2, int r3, TextElement r4, ImageModel r5) {
        this.userName = r1;
        this.userAvatar = r2;
        this.rank = r3;
        this.content = r4;
        this.photo = r5;
    }

    public /* synthetic */ CommentInfoVO(TextWithOneIconElement r5, ImageModel r6, int r7, TextElement r8, ImageModel r9, int r10, DefaultConstructorMarker r11) {
        if ((r10 & 1) == 0) goto L5;
        TextWithOneIconElement r12 = null;
    L7:
        if ((r10 & 2) == 0) goto L9;
        ImageModel r1 = null;
    L11:
        if ((r10 & 4) == 0) goto L13;
        int r2 = 0;
    L15:
        if ((r10 & 8) == 0) goto L17;
        TextElement r3 = null;
    L19:
        if ((r10 & 16) == 0) goto L21;
        ImageModel r13 = null;
    L22:
        this(r12, r1, r2, r3, r13);
        return;
    L21:
        r13 = r9;
        goto L22
    L17:
        r3 = r8;
        goto L19
    L13:
        r2 = r7;
        goto L15
    L9:
        r1 = r6;
        goto L11
    L5:
        r12 = r5;
        goto L7
    }
}
