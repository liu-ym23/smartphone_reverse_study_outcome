package com.larus.community.impl.detail.bottomtools;

import com.google.gson.annotations.SerializedName;
import com.larus.platform.api.creation.UserCreation;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes27.dex */
@Metadata(d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B?\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0006\u001a\u00020\u0007\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0005HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0007HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\tHÆ\u0003J\u0010\u0010\u001c\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u0016JF\u0010\u001d\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\n\b\u0002\u0010\n\u001a\u0004\u0018\u00010\u0005HÆ\u0001¢\u0006\u0002\u0010\u001eJ\u0013\u0010\u001f\u001a\u00020\u00052\b\u0010 \u001a\u0004\u0018\u00010!HÖ\u0003J\t\u0010\"\u001a\u00020#HÖ\u0001J\t\u0010$\u001a\u00020\u0003HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0004\u001a\u00020\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0018\u0010\b\u001a\u0004\u0018\u00010\t8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u001a\u0010\n\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u0017\u001a\u0004\b\u0015\u0010\u0016¨\u0006%"}, d2 = {"Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "Lcom/larus/ui/arch/vm/external/ComponentState;", "creationId", "", "liked", "", "likeCount", "", "creation", "Lcom/larus/platform/api/creation/UserCreation;", "showAnimation", "<init>", "(Ljava/lang/String;ZJLcom/larus/platform/api/creation/UserCreation;Ljava/lang/Boolean;)V", "getCreationId", "()Ljava/lang/String;", "getLiked", "()Z", "getLikeCount", "()J", "getCreation", "()Lcom/larus/platform/api/creation/UserCreation;", "getShowAnimation", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "component1", "component2", "component3", "component4", "component5", "copy", "(Ljava/lang/String;ZJLcom/larus/platform/api/creation/UserCreation;Ljava/lang/Boolean;)Lcom/larus/community/impl/detail/bottomtools/CreationLikeState;", "equals", "other", "", "hashCode", "", "toString", "impl_mainlandRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class CreationLikeState implements w1a.b {

    @SerializedName("creation")
    private final UserCreation creation;

    @SerializedName("creation_id")
    private final String creationId;

    @SerializedName("like_count")
    private final long likeCount;

    @SerializedName("liked")
    private final boolean liked;

    @SerializedName("show_animation")
    private final Boolean showAnimation;

    public CreationLikeState() {
        this(null, false, 0, null, null, 31, null);
    }

    public static /* synthetic */ CreationLikeState copy$default(CreationLikeState r100, String r101, boolean r102, long r103, UserCreation r104, Boolean r110, int r111, Object r112) {
        if ((r111 & 1) == 0) goto L6;
        r101 = r100.creationId;
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
        r104 = r100.creation;
    L14:
        UserCreation r106 = r104;
        if ((r111 & 16) == 0) goto L17;
        r110 = r100.showAnimation;
    L17:
        String r107 = r101;
        return r100.copy(r107, r113, r105, r106, r110);
    }

    public final String component1() {
        return this.creationId;
    }

    public final boolean component2() {
        return this.liked;
    }

    public final long component3() {
        return this.likeCount;
    }

    public final UserCreation component4() {
        return this.creation;
    }

    public final Boolean component5() {
        return this.showAnimation;
    }

    public final CreationLikeState copy(String r100, boolean r110, long r111, UserCreation r112, Boolean r113) {
        return new CreationLikeState(r100, r110, r111, r112, r113);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof CreationLikeState) == true) goto L8;
        return false;
    L8:
        CreationLikeState r101 = (CreationLikeState) r100;
        if (Intrinsics.areEqual(this.creationId, r101.creationId) == true) goto L12;
        return false;
    L12:
        if (this.liked == r101.liked) goto L15;
        return false;
    L15:
        if (this.likeCount == r101.likeCount) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.creation, r101.creation) == true) goto L21;
        return false;
    L21:
        if (Intrinsics.areEqual(this.showAnimation, r101.showAnimation) == true) goto L23;
        return false;
    L23:
        return true;
    }

    public int hashCode() {
        String r100 = this.creationId;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        if (this.liked == false) goto L9;
        int r104 = 1231;
    L10:
        int r105 = (r103 + r104) * 31;
        long r106 = this.likeCount;
        int r107 = (r105 + ((int) (r106 ^ (r106 >>> 32)))) * 31;
        UserCreation r108 = this.creation;
        if (r108 != null) goto L13;
        int r109 = 0;
    L14:
        int r110 = (r107 + r109) * 31;
        Boolean r111 = this.showAnimation;
        if (r111 == null) goto L19;
        r101 = r111.hashCode();
    L19:
        return r110 + r101;
    L13:
        r109 = r108.hashCode();
        goto L14
    L9:
        r104 = 1237;
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "CreationLikeState(creationId=" + this.creationId + ", liked=" + this.liked + ", likeCount=" + this.likeCount + ", creation=" + this.creation + ", showAnimation=" + this.showAnimation + ')';
    }

    public final UserCreation getCreation() {
        return this.creation;
    }

    public final String getCreationId() {
        return this.creationId;
    }

    public final long getLikeCount() {
        return this.likeCount;
    }

    public final boolean getLiked() {
        return this.liked;
    }

    public final Boolean getShowAnimation() {
        return this.showAnimation;
    }

    public CreationLikeState(String r100, boolean r101, long r102, UserCreation r103, Boolean r104) {
        this.creationId = r100;
        this.liked = r101;
        this.likeCount = r102;
        this.creation = r103;
        this.showAnimation = r104;
    }

    public /* synthetic */ CreationLikeState(String r100, boolean r101, long r102, UserCreation r103, Boolean r110, int r111, DefaultConstructorMarker r112) {
        UserCreation r104 = null;
        if ((r111 & 1) == 0) goto L5;
        String r113 = null;
    L7:
        if ((r111 & 2) == 0) goto L9;
        boolean r105 = false;
    L11:
        if ((r111 & 4) == 0) goto L13;
        r102 = 0;
    L13:
        long r106 = r102;
        if ((r111 & 8) != 0) goto L18;
        r104 = r103;
    L18:
        if ((r111 & 16) == 0) goto L20;
        r110 = Boolean.FALSE;
    L20:
        this(r113, r105, r106, r104, r110);
        return;
    L9:
        r105 = r101;
        goto L11
    L5:
        r113 = r100;
        goto L7
    }
}
