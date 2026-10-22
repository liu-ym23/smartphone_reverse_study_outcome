package com.larus.bmhome.view.actionbar.segment.vm;

import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes26.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0016\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u00012\u00020\u0002B=\u0012\b\b\u0002\u0010\u0003\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0004\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0004HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001b\u001a\u0004\u0018\u00010\u0004HÆ\u0003¢\u0006\u0002\u0010\u0015JD\u0010\u001c\u001a\u00020\u00002\b\b\u0002\u0010\u0003\u001a\u00020\u00042\b\b\u0002\u0010\u0005\u001a\u00020\u00042\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0004HÆ\u0001¢\u0006\u0002\u0010\u001dJ\u0013\u0010\u001e\u001a\u00020\u00042\b\u0010\u001f\u001a\u0004\u0018\u00010 HÖ\u0003J\t\u0010!\u001a\u00020\"HÖ\u0001J\t\u0010#\u001a\u00020\tHÖ\u0001R\u0016\u0010\u0003\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0005\u001a\u00020\u00048\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00048\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0016\u001a\u0004\b\u0014\u0010\u0015¨\u0006$"}, d2 = {"Lcom/larus/bmhome/view/actionbar/segment/vm/LikeBotState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "Ljava/io/Serializable;", "showLikeButton", "", "liked", "likeCount", "", "botId", "", "knowLike", "<init>", "(ZZJLjava/lang/String;Ljava/lang/Boolean;)V", "getShowLikeButton", "()Z", "getLiked", "getLikeCount", "()J", "getBotId", "()Ljava/lang/String;", "getKnowLike", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(ZZJLjava/lang/String;Ljava/lang/Boolean;)Lcom/larus/bmhome/view/actionbar/segment/vm/LikeBotState;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class LikeBotState implements w1a.b, Serializable {

    @SerializedName("bot_id")
    private final String botId;

    @SerializedName("know_like")
    private final Boolean knowLike;

    @SerializedName("like_count")
    private final long likeCount;

    @SerializedName("liked")
    private final boolean liked;

    @SerializedName("show_like_button")
    private final boolean showLikeButton;

    public LikeBotState() {
        this(false, false, 0, null, null, 31, null);
    }

    public static /* synthetic */ LikeBotState copy$default(LikeBotState r100, boolean r101, boolean r102, long r103, String r104, Boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.showLikeButton;
    L6:
        if ((r111 & 2) == 0) goto L8;
        r102 = r100.liked;
    L8:
        boolean r113 = r102;
        if ((r111 & 4) == 0) goto L11;
        r103 = r100.likeCount;
    L11:
        long r105 = r103;
        if ((r111 & 8) == 0) goto L14;
        r104 = r100.botId;
    L14:
        String r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.knowLike;
    L17:
        boolean r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final boolean component1() {
        return this.showLikeButton;
    }

    public final boolean component2() {
        return this.liked;
    }

    public final long component3() {
        return this.likeCount;
    }

    public final String component4() {
        return this.botId;
    }

    public final Boolean component5() {
        return this.knowLike;
    }

    public final LikeBotState copy(boolean r100, boolean r110, long r111, String r112, Boolean r113) {
        return new LikeBotState(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof LikeBotState) == true) goto L8;
        return false;
    L8:
        LikeBotState r101 = (LikeBotState) r100;
        if (this.showLikeButton == r101.showLikeButton) goto L12;
        return false;
    L12:
        if (this.liked == r101.liked) goto L15;
        return false;
    L15:
        if (this.likeCount == r101.likeCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.botId, r101.botId) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.knowLike, r101.knowLike) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        int r100 = 1231;
        if (this.showLikeButton == false) goto L5;
        int r101 = 1231;
    L6:
        int r102 = r101 * 31;
        if (this.liked == true) goto L10;
        r100 = 1237;
    L10:
        int r103 = (r102 + r100) * 31;
        long r104 = this.likeCount;
        int r105 = (r103 + ((int) (r104 ^ (r104 >>> 32)))) * 31;
        String r106 = this.botId;
        int r107 = 0;
        if (r106 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r105 + r108) * 31;
        Boolean r110 = this.knowLike;
        if (r110 == null) goto L19;
        r107 = r110.hashCode();
    L19:
        return r109 + r107;
    L13:
        r108 = r106.hashCode();
        goto L14
    L5:
        r101 = 1237;
        goto L6
    }

    public String toString() {
        return "LikeBotState(showLikeButton=" + this.showLikeButton + ", liked=" + this.liked + ", likeCount=" + this.likeCount + ", botId=" + this.botId + ", knowLike=" + this.knowLike + ')';
    }

    public final String getBotId() {
        return this.botId;
    }

    public final Boolean getKnowLike() {
        return this.knowLike;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final boolean getShowLikeButton() {
        return this.showLikeButton;
    }

    public LikeBotState(boolean r100, boolean r101, long r102, String r103, Boolean r104) {
        this.showLikeButton = r100;
        this.liked = r101;
        this.likeCount = r102;
        this.botId = r103;
        this.knowLike = r104;
    }

    public /* synthetic */ LikeBotState(boolean r100, boolean r101, long r102, String r103, Boolean r110, int r111, DefaultConstructorMarker r112) {
        boolean r104 = false;
        if ((r111 & 1) == 0) goto L5;
        boolean r113 = false;
    L7:
        if ((r111 & 2) != 0) goto L11;
        r104 = r101;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r105 = r102;
        if ((r111 & 8) == 0) goto L16;
        r103 = null;
    L16:
        String r106 = r103;
        if ((r111 & 16) == 0) goto L19;
        r110 = Boolean.FALSE;
    L19:
        boolean r107 = r113;
        boolean r108 = r104;
        this(r107, r108, r105, r106, r110);
        return;
    L5:
        r113 = r100;
        goto L7
    }
}
