package com.bytedance.ee.bear.bitable.homepage.recommend;

import com.bytedance.ee.util.io.NonProguard;
import com.google.gson.annotations.SerializedName;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;

/* JADX INFO: loaded from: classes15.dex */
@Metadata(d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0005\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b(\n\u0002\u0010\u000b\n\u0002\b\u0011\u0018\u00002\u00020\u0001Bu\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\n\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u0012\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012¢\u0006\u0004\b\u0013\u0010\u0014J\u0006\u0010J\u001a\u00020;J\u0006\u0010K\u001a\u00020;R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0016R\u001a\u0010\u0005\u001a\u0004\u0018\u00010\u00068\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010\u001a\u001a\u0004\b\u0018\u0010\u0019R\u0018\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0018\u0010\b\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016R\u0018\u0010\t\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0016R\u0018\u0010\n\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0016R\u001a\u0010\u000b\u001a\u0004\u0018\u00010\f8\u0006X\u0087\u0004¢\u0006\n\n\u0002\u0010!\u001a\u0004\b\u001f\u0010 R\u0018\u0010\r\u001a\u0004\u0018\u00010\u000e8\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\"\u0010#R\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00108\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0018\u0010\u0011\u001a\u0004\u0018\u00010\u00128\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b&\u0010'R\u001a\u0010(\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b)\u0010\u0016\"\u0004\b*\u0010+R\u001a\u0010,\u001a\u00020\u0003X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b-\u0010\u0016\"\u0004\b.\u0010+R\u001a\u0010/\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b0\u00101\"\u0004\b2\u00103R\u001a\u00104\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b5\u00101\"\u0004\b6\u00103R\u001a\u00107\u001a\u00020\fX\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b8\u00101\"\u0004\b9\u00103R\u001a\u0010:\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b:\u0010<\"\u0004\b=\u0010>R\u001a\u0010?\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\b@\u0010<\"\u0004\bA\u0010>R\u001a\u0010B\u001a\u00020\u0006X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bC\u0010D\"\u0004\bE\u0010FR\u001a\u0010G\u001a\u00020;X\u0086\u000e¢\u0006\u000e\n\u0000\u001a\u0004\bH\u0010<\"\u0004\bI\u0010>¨\u0006L"}, d2 = {"Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemData;", "Lcom/bytedance/ee/util/io/NonProguard;", "title", "", "coverToken", "heat", "", "coverUrl", "contentUrl", "objToken", "contentId", "contentType", "", "owner", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemOwnerData;", "coverInfo", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemCoverInfoData;", "tagInfo", "Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendTagInfo;", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Long;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/Integer;Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemOwnerData;Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemCoverInfoData;Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendTagInfo;)V", "getTitle", "()Ljava/lang/String;", "getCoverToken", "getHeat", "()Ljava/lang/Long;", "Ljava/lang/Long;", "getCoverUrl", "getContentUrl", "getObjToken", "getContentId", "getContentType", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getOwner", "()Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemOwnerData;", "getCoverInfo", "()Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendItemCoverInfoData;", "getTagInfo", "()Lcom/bytedance/ee/bear/bitable/homepage/recommend/BitableRecommendTagInfo;", "requestId", "getRequestId", "setRequestId", "(Ljava/lang/String;)V", "coverLoadState", "getCoverLoadState", "setCoverLoadState", "requestRankFirst", "getRequestRankFirst", "()I", "setRequestRankFirst", "(I)V", "allPositionIndex", "getAllPositionIndex", "setAllPositionIndex", "positionIndex", "getPositionIndex", "setPositionIndex", "isRefresh", "", "()Z", "setRefresh", "(Z)V", "fromCache", "getFromCache", "setFromCache", "showTimestamp", "getShowTimestamp", "()J", "setShowTimestamp", "(J)V", "hasExposed", "getHasExposed", "setHasExposed", "isHot", "isNew", "docs-bitable-impl_productionChinaRelease"}, k = 1, mv = {2, 1, 0}, xi = 48)
public final class BitableRecommendItemData implements NonProguard {
    private volatile transient int allPositionIndex;

    @SerializedName(com.bytedance.android.ec.core.event.a.KEY_CONTENT_ID)
    private final String contentId;

    @SerializedName("content_type")
    private final Integer contentType;

    @SerializedName("content_url")
    private final String contentUrl;

    @SerializedName("cover_info")
    private final BitableRecommendItemCoverInfoData coverInfo;
    private volatile transient String coverLoadState;

    @SerializedName("cover_token")
    private final String coverToken;

    @SerializedName("cover_url")
    private final String coverUrl;
    private volatile transient boolean fromCache;
    private volatile transient boolean hasExposed;

    @SerializedName("heat")
    private final Long heat;
    private volatile transient boolean isRefresh;

    @SerializedName("obj_token")
    private final String objToken;

    @SerializedName("owner")
    private final BitableRecommendItemOwnerData owner;
    private volatile transient int positionIndex;
    private volatile transient String requestId;
    private volatile transient int requestRankFirst;
    private volatile transient long showTimestamp;

    @SerializedName("tag_info")
    private final BitableRecommendTagInfo tagInfo;

    @SerializedName("title")
    private final String title;

    public final boolean isHot() {
        BitableRecommendTagInfo r100 = this.tagInfo;
        if (r100 == null) goto L10;
        Integer r101 = r100.getTagType();
        if (r101 == null) goto L10;
        if (r101.intValue() != 2) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
    L15:
        return false;
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.hp.feed.hottag") == false) goto L15;
        return true;
    L10:
        r102 = false;
        goto L11
    }

    public final boolean isNew() {
        BitableRecommendTagInfo r100 = this.tagInfo;
        if (r100 == null) goto L10;
        Integer r101 = r100.getTagType();
        if (r101 == null) goto L10;
        if (r101.intValue() != 1) goto L10;
        boolean r102 = true;
    L11:
        if (r102 == true) goto L13;
    L15:
        return false;
    L13:
        if (com.bytedance.ee.bear.appsetting.c.a.f206237a.h("base.hp.feed.newtag") == false) goto L15;
        return true;
    L10:
        r102 = false;
        goto L11
    }

    public final int getAllPositionIndex() {
        return this.allPositionIndex;
    }

    public final String getContentId() {
        return this.contentId;
    }

    public final Integer getContentType() {
        return this.contentType;
    }

    public final String getContentUrl() {
        return this.contentUrl;
    }

    public final BitableRecommendItemCoverInfoData getCoverInfo() {
        return this.coverInfo;
    }

    public final String getCoverLoadState() {
        return this.coverLoadState;
    }

    public final String getCoverToken() {
        return this.coverToken;
    }

    public final String getCoverUrl() {
        return this.coverUrl;
    }

    public final boolean getFromCache() {
        return this.fromCache;
    }

    public final boolean getHasExposed() {
        return this.hasExposed;
    }

    public final Long getHeat() {
        return this.heat;
    }

    public final String getObjToken() {
        return this.objToken;
    }

    public final BitableRecommendItemOwnerData getOwner() {
        return this.owner;
    }

    public final int getPositionIndex() {
        return this.positionIndex;
    }

    public final String getRequestId() {
        return this.requestId;
    }

    public final int getRequestRankFirst() {
        return this.requestRankFirst;
    }

    public final long getShowTimestamp() {
        return this.showTimestamp;
    }

    public final BitableRecommendTagInfo getTagInfo() {
        return this.tagInfo;
    }

    public final String getTitle() {
        return this.title;
    }

    public final boolean isRefresh() {
        return this.isRefresh;
    }

    public final void setAllPositionIndex(int r100) {
        this.allPositionIndex = r100;
    }

    public final void setCoverLoadState(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.coverLoadState = r100;
    }

    public final void setFromCache(boolean r100) {
        this.fromCache = r100;
    }

    public final void setHasExposed(boolean r100) {
        this.hasExposed = r100;
    }

    public final void setPositionIndex(int r100) {
        this.positionIndex = r100;
    }

    public final void setRefresh(boolean r100) {
        this.isRefresh = r100;
    }

    public final void setRequestId(String r100) {
        Intrinsics.checkNotNullParameter(r100, "<set-?>");
        this.requestId = r100;
    }

    public final void setRequestRankFirst(int r100) {
        this.requestRankFirst = r100;
    }

    public final void setShowTimestamp(long r100) {
        this.showTimestamp = r100;
    }

    public BitableRecommendItemData(String r100, String r101, Long r102, String r103, String r104, String r105, String r106, Integer r107, BitableRecommendItemOwnerData r108, BitableRecommendItemCoverInfoData r110, BitableRecommendTagInfo r111) {
        this.title = r100;
        this.coverToken = r101;
        this.heat = r102;
        this.coverUrl = r103;
        this.contentUrl = r104;
        this.objToken = r105;
        this.contentId = r106;
        this.contentType = r107;
        this.owner = r108;
        this.coverInfo = r110;
        this.tagInfo = r111;
        this.requestId = "";
        this.coverLoadState = "loading";
    }
}
