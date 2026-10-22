package com.ss.android.ugc.aweme.discover.model;

import com.bytedance.android.ec.core.event.a;
import com.google.gson.annotations.SerializedName;
import java.io.Serializable;
import kotlin.Metadata;

/* JADX INFO: loaded from: classes40.dex */
@Metadata(bv = {1, 0, 3}, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0017\u0018\u00002\u00020\u0001B\u0005¢\u0006\u0002\u0010\u0002R \u0010\u0003\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0005\u0010\u0006\"\u0004\b\u0007\u0010\bR \u0010\t\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR\"\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006@\u0006X\u0087\u000e¢\u0006\u0010\n\u0002\u0010\u0014\u001a\u0004\b\u000f\u0010\u0011\"\u0004\b\u0012\u0010\u0013R \u0010\u0015\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0016\u0010\u0006\"\u0004\b\u0017\u0010\bR \u0010\u0018\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u0019\u0010\u0006\"\u0004\b\u001a\u0010\bR \u0010\u001b\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001c\u0010\f\"\u0004\b\u001d\u0010\u000eR \u0010\u001e\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\u001f\u0010\u0006\"\u0004\b \u0010\bR \u0010!\u001a\u0004\u0018\u00010\u00048\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b\"\u0010\u0006\"\u0004\b#\u0010\bR \u0010$\u001a\u0004\u0018\u00010\n8\u0006@\u0006X\u0087\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b%\u0010\f\"\u0004\b&\u0010\u000e¨\u0006'"}, d2 = {"Lcom/ss/android/ugc/aweme/discover/model/LiveInnerShopInfo;", "Ljava/io/Serializable;", "()V", "avatarUrl", "", "getAvatarUrl", "()Ljava/lang/String;", "setAvatarUrl", "(Ljava/lang/String;)V", "flagshipTag", "Lcom/ss/android/ugc/aweme/discover/model/TagInfo;", "getFlagshipTag", "()Lcom/ss/android/ugc/aweme/discover/model/TagInfo;", "setFlagshipTag", "(Lcom/ss/android/ugc/aweme/discover/model/TagInfo;)V", "isFlagship", "", "()Ljava/lang/Boolean;", "setFlagship", "(Ljava/lang/Boolean;)V", "Ljava/lang/Boolean;", "jumpSchema", "getJumpSchema", "setJumpSchema", a.KEY_SCORE, "getScore", "setScore", "scoreTag", "getScoreTag", "setScoreTag", "shopId", "getShopId", "setShopId", "shopName", "getShopName", "setShopName", "xzgTag", "getXzgTag", "setXzgTag", "ec-search-api_saasRelease"}, k = 1, mv = {1, 4, 3})
public final class LiveInnerShopInfo implements Serializable {

    @SerializedName("avatar_url")
    private String avatarUrl;

    @SerializedName("flagship_tag")
    private TagInfo flagshipTag;

    @SerializedName("is_flagship")
    private Boolean isFlagship;

    @SerializedName("jump_schema")
    private String jumpSchema;

    @SerializedName(a.KEY_SCORE)
    private String score;

    @SerializedName("score_tag")
    private TagInfo scoreTag;

    @SerializedName(a.KEY_SHOP_ID)
    private String shopId;

    @SerializedName("shop_name")
    private String shopName;

    @SerializedName("xzg_tag")
    private TagInfo xzgTag;

    public LiveInnerShopInfo() {
    }

    public final String getAvatarUrl() {
        return this.avatarUrl;
    }

    public final TagInfo getFlagshipTag() {
        return this.flagshipTag;
    }

    public final String getJumpSchema() {
        return this.jumpSchema;
    }

    public final String getScore() {
        return this.score;
    }

    public final TagInfo getScoreTag() {
        return this.scoreTag;
    }

    public final String getShopId() {
        return this.shopId;
    }

    public final String getShopName() {
        return this.shopName;
    }

    public final TagInfo getXzgTag() {
        return this.xzgTag;
    }

    public final Boolean isFlagship() {
        return this.isFlagship;
    }

    public final void setAvatarUrl(String r100) {
        this.avatarUrl = r100;
    }

    public final void setFlagship(Boolean r100) {
        this.isFlagship = r100;
    }

    public final void setFlagshipTag(TagInfo r100) {
        this.flagshipTag = r100;
    }

    public final void setJumpSchema(String r100) {
        this.jumpSchema = r100;
    }

    public final void setScore(String r100) {
        this.score = r100;
    }

    public final void setScoreTag(TagInfo r100) {
        this.scoreTag = r100;
    }

    public final void setShopId(String r100) {
        this.shopId = r100;
    }

    public final void setShopName(String r100) {
        this.shopName = r100;
    }

    public final void setXzgTag(TagInfo r100) {
        this.xzgTag = r100;
    }
}
