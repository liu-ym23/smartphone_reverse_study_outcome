package com.bytedance.locallife.model.poi.resp;

import com.google.gson.annotations.SerializedName;
import com.ss.android.ugc.aweme.poi.model.PoiImageUrlModel;
import java.io.Serializable;
import java.util.List;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes21.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B;\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0005HÆ\u0003J\u0011\u0010\u0016\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nHÆ\u0003J?\u0010\u0018\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\u0010\b\u0002\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00072\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nHÆ\u0001J\u0013\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u001cHÖ\u0003J\t\u0010\u001d\u001a\u00020\u001eHÖ\u0001J\t\u0010\u001f\u001a\u00020\u0005HÖ\u0001R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0018\u0010\t\u001a\u0004\u0018\u00010\n8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00058\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u001e\u0010\u0006\u001a\n\u0012\u0004\u0012\u00020\b\u0018\u00010\u00078\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013¨\u0006 "}, d2 = {"Lcom/bytedance/locallife/model/poi/resp/RateReplyUserInfo;", "Ljava/io/Serializable;", "avatar", "Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "nickName", "", "userTags", "", "Lcom/bytedance/locallife/model/poi/resp/RateTag;", "clickEvent", "Lcom/bytedance/locallife/model/poi/resp/TagClickEvent;", "(Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;Ljava/lang/String;Ljava/util/List;Lcom/bytedance/locallife/model/poi/resp/TagClickEvent;)V", "getAvatar", "()Lcom/ss/android/ugc/aweme/poi/model/PoiImageUrlModel;", "getClickEvent", "()Lcom/bytedance/locallife/model/poi/resp/TagClickEvent;", "getNickName", "()Ljava/lang/String;", "getUserTags", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "", "hashCode", "", "toString", "locallife-saas-model_release"}, k = 1, mv = {1, 4, 3}, xi = 48)
public final class RateReplyUserInfo implements Serializable {

    @SerializedName("avatar")
    private final PoiImageUrlModel avatar;

    @SerializedName("click_event")
    private final TagClickEvent clickEvent;

    @SerializedName("nick_name")
    private final String nickName;

    @SerializedName("user_tags")
    private final List<RateTag> userTags;

    public RateReplyUserInfo() {
        this(null, null, null, null, 15, null);
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static /* synthetic */ RateReplyUserInfo copy$default(RateReplyUserInfo r100, PoiImageUrlModel r101, String r102, List r103, TagClickEvent r104, int r105, Object r106) {
        if ((r105 & 1) == 0) goto L6;
        r101 = r100.avatar;
    L6:
        if ((r105 & 2) == 0) goto L9;
        r102 = r100.nickName;
    L9:
        if ((r105 & 4) == 0) goto L12;
        r103 = r100.userTags;
    L12:
        if ((r105 & 8) == 0) goto L15;
        r104 = r100.clickEvent;
    L15:
        return r100.copy(r101, r102, r103, r104);
    }

    public final PoiImageUrlModel component1() {
        return this.avatar;
    }

    public final String component2() {
        return this.nickName;
    }

    public final List<RateTag> component3() {
        return this.userTags;
    }

    public final TagClickEvent component4() {
        return this.clickEvent;
    }

    public final RateReplyUserInfo copy(PoiImageUrlModel r100, String r101, List<RateTag> r102, TagClickEvent r103) {
        return new RateReplyUserInfo(r100, r101, r102, r103);
    }

    public boolean equals(Object r100) {
        if (this != r100) goto L6;
        return true;
    L6:
        if ((r100 instanceof RateReplyUserInfo) == true) goto L8;
        return false;
    L8:
        RateReplyUserInfo r101 = (RateReplyUserInfo) r100;
        if (Intrinsics.areEqual(this.avatar, r101.avatar) == true) goto L12;
        return false;
    L12:
        if (Intrinsics.areEqual(this.nickName, r101.nickName) == true) goto L15;
        return false;
    L15:
        if (Intrinsics.areEqual(this.userTags, r101.userTags) == true) goto L18;
        return false;
    L18:
        if (Intrinsics.areEqual(this.clickEvent, r101.clickEvent) == true) goto L20;
        return false;
    L20:
        return true;
    }

    public int hashCode() {
        PoiImageUrlModel r100 = this.avatar;
        int r101 = 0;
        if (r100 != null) goto L5;
        int r102 = 0;
    L6:
        int r103 = r102 * 31;
        String r104 = this.nickName;
        if (r104 != null) goto L9;
        int r105 = 0;
    L10:
        int r106 = (r103 + r105) * 31;
        List<RateTag> r107 = this.userTags;
        if (r107 != null) goto L13;
        int r108 = 0;
    L14:
        int r109 = (r106 + r108) * 31;
        TagClickEvent r110 = this.clickEvent;
        if (r110 == null) goto L19;
        r101 = r110.hashCode();
    L19:
        return r109 + r101;
    L13:
        r108 = r107.hashCode();
        goto L14
    L9:
        r105 = r104.hashCode();
        goto L10
    L5:
        r102 = r100.hashCode();
        goto L6
    }

    public String toString() {
        return "RateReplyUserInfo(avatar=" + this.avatar + ", nickName=" + this.nickName + ", userTags=" + this.userTags + ", clickEvent=" + this.clickEvent + ')';
    }

    public final PoiImageUrlModel getAvatar() {
        return this.avatar;
    }

    public final TagClickEvent getClickEvent() {
        return this.clickEvent;
    }

    public final String getNickName() {
        return this.nickName;
    }

    public final List<RateTag> getUserTags() {
        return this.userTags;
    }

    public RateReplyUserInfo(PoiImageUrlModel r100, String r101, List<RateTag> r102, TagClickEvent r103) {
        this.avatar = r100;
        this.nickName = r101;
        this.userTags = r102;
        this.clickEvent = r103;
    }

    public /* synthetic */ RateReplyUserInfo(PoiImageUrlModel r100, String r101, List r102, TagClickEvent r103, int r104, DefaultConstructorMarker r105) {
        if ((r104 & 1) == 0) goto L6;
        r100 = null;
    L6:
        if ((r104 & 2) == 0) goto L9;
        r101 = null;
    L9:
        if ((r104 & 4) == 0) goto L12;
        r102 = null;
    L12:
        if ((r104 & 8) == 0) goto L14;
        r103 = null;
    L14:
        this(r100, r101, r102, r103);
    }
}
